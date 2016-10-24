package com.opentangerine.maven;

import com.opentangerine.maven.server.Backend;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.maven.Maven;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

import java.util.concurrent.TimeUnit;

import static org.apache.maven.plugins.annotations.ResolutionScope.COMPILE_PLUS_RUNTIME;

@Mojo(
        name = "run",
        requiresDependencyResolution = COMPILE_PLUS_RUNTIME
)
@NoArgsConstructor
@AllArgsConstructor
public class Run extends AbstractMojo {
    @Parameter( defaultValue = "${project}", readonly = true )
    private MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            new ProcessBuilder("mvn.bat", "compile").inheritIO().directory(project.getBasedir()).start().waitFor();
            getLog().info("COMPILED");
            new ProcessBuilder("mvn.bat", "org.codehaus.mojo:exec-maven-plugin:1.5.0:java", "-Dexec.mainClass=\"com.ggajos.Blog\"").inheritIO().directory(project.getBasedir()).start();
            getLog().info("REBUILD");
            Backend.WEB.start();
            TimeUnit.HOURS.sleep(24);
        } catch (Exception e) {
            throw new IllegalStateException("Unable to execute `run`", e);
        }
    }

}