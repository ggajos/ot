package com.opentangerine.maven.server;

import com.opentangerine.maven.Run;
import lombok.val;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.maven.project.MavenProject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * @author Grzegorz Gajos
 */
public class BackendTest {
    @Test
    public void start() throws Exception {
        FileUtils.writeStringToFile(
                Paths.get("target/web/page/index.html").toFile(),
                "test",
                StandardCharsets.UTF_8
        );
        Backend.Jetty.WEB.start();
        val a = IOUtils.toString(new URL("http://localhost:4000/page"), StandardCharsets.UTF_8);
        MatcherAssert.assertThat(a, Matchers.equalTo("test"));
        Backend.Jetty.WEB.stop();
    }

}