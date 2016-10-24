package com.opentangerine.maven;

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

import static org.apache.maven.plugins.annotations.ResolutionScope.COMPILE_PLUS_RUNTIME;

@Mojo(
        name = "g-run",
        requiresDependencyResolution = COMPILE_PLUS_RUNTIME
)
public class Run extends AbstractMojo {
    @Parameter( defaultValue = "${session}", readonly = true )
    private MavenSession session;
    @Parameter( defaultValue = "${project}", readonly = true )
    protected MavenProject project;

    @Component
    private Maven maven;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            new ProcessBuilder("mvn.bat", "compile").inheritIO().directory(project.getBasedir()).start().waitFor();
            getLog().info("COMPILED");
            new ProcessBuilder("mvn.bat", "org.codehaus.mojo:exec-maven-plugin:1.5.0:java", "-Dexec.mainClass=\"com.ggajos.Blog\"").inheritIO().directory(project.getBasedir()).start();
            getLog().info("REBUILD");
            Jetty.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

interface Jetty {
    static Server run() {
        Server server = new Server();
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(4000);
        server.addConnector(connector);
        ResourceHandler res = new ResourceHandler();
        res.setDirectoriesListed(true);
        res.setWelcomeFiles(new String[]{ "index.html" });
        res.setResourceBase("target/web");
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { res, new DefaultHandler() });
        server.setHandler(handlers);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return server;
    }
}
