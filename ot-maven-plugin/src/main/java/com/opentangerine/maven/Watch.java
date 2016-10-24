package com.opentangerine.maven;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.apache.maven.Maven;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.apache.maven.plugins.annotations.ResolutionScope.COMPILE_PLUS_RUNTIME;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

@Mojo(
        name = "g-watch",
        requiresDependencyResolution = COMPILE_PLUS_RUNTIME
)
public class Watch extends AbstractMojo {
    @Parameter( defaultValue = "${session}", readonly = true )
    private MavenSession session;
    @Parameter( defaultValue = "${project}", readonly = true )
    protected MavenProject project;

    @Component
    private Maven maven;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Jetty.run();
        new Thread(() -> {
            try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
                compile(true);
                final Path src = project.getBasedir().toPath().resolve("src");
                registerAll(src, watchService);
                System.out.println("WATCHING: " + src.toFile().getAbsolutePath());
                while (true) {
                    final WatchKey wk = watchService.take();
                    System.out.println("WAIT");
                    boolean recompile = false;
                    final List<WatchEvent<?>> events = wk.pollEvents();
                    for(WatchEvent<?> it : events) {
                        recompile = recompile || StringUtils.endsWith(it.context().toString(), "java");
                    }
                    if(events.size() > 0) {
                        compile(recompile);
                    }
                    // reset the key
                    boolean valid = wk.reset();
                    if (!valid) {
                        System.out.println("Key has been unregisterede");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Register the given directory, and all its sub-directories, with the WatchService.
     */
    private void registerAll(final Path start, final WatchService watcher) throws IOException {
        // register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException {
                dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private void compile(boolean recompile) throws Exception {
        final File dir = project.getBasedir();
        run(dir, recompile);
    }

    private void run(final File dir, boolean recompile) throws Exception {
        Invoker invoker = new DefaultInvoker();
        if(recompile) {
            compile(dir, invoker);
        }
        build(dir, invoker);
    }

    private void build(File dir, Invoker invoker) throws MavenInvocationException {
        InvocationRequest request;
        request = new DefaultInvocationRequest();
        request.setBaseDirectory(dir);
        System.setProperty("exec.mainClass", "com.ggajos.Blog");
        request.setGoals(Arrays.asList("--quiet", "org.codehaus.mojo:exec-maven-plugin:1.5.0:java", "-Dexec.mainClass=\"com.ggajos.Blog\""));
        invoker.execute(request);
        getLog().info("REBUILD");
    }

    private void compile(File dir, Invoker invoker) throws MavenInvocationException {
        InvocationRequest request;
        request = new DefaultInvocationRequest();
        request.setBaseDirectory(dir);
        request.setGoals(Arrays.asList("--quiet", "compile"));
        invoker.execute(request);
        getLog().info("COMPILED");
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("maven.home", "d:\\arch\\lib\\apache-maven-3.2.1");
        new Watch().run(Paths.get("D:\\work\\ot-static\\ggajos-blog").toFile(), true);
    }

}
