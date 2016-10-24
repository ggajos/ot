package com.opentangerine.maven.server;

import lombok.val;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

import java.io.File;

/**
 * @author Grzegorz Gajos
 */
public interface Backend {

    Backend WEB = new Jetty();

    void start();
    void stop();

    class Jetty implements Backend {
        private Server server;

        @Override
        public void start() {
            this.server = new Server();
            val connector = new SelectChannelConnector();
            connector.setPort(4000);
            server.addConnector(connector);
            val res = new ResourceHandler();
            res.setDirectoriesListed(true);
            res.setWelcomeFiles(new String[]{ "index.html" });
            res.setResourceBase("target/web");
            final File file = new File("target/web");
            if(!file.exists()) {
                throw new IllegalStateException("Unable to find " + file.getAbsolutePath());
            }
            val handlers = new HandlerList();
            handlers.setHandlers(new Handler[] { res, new DefaultHandler() });
            server.setHandler(handlers);
            try {
                server.start();
            } catch (Exception e) {
                throw new IllegalStateException("Unable to start Jetty server", e);
            }
        }

        @Override
        public void stop() {
            try {
                server.stop();
            } catch (Exception e) {
                throw new IllegalStateException("Unable to stop Jetty server", e);
            }
        }

    }



}
