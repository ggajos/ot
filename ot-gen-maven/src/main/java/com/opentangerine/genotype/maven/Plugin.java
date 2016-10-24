package com.opentangerine.genotype.maven;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.apache.maven.plugins.annotations.LifecyclePhase.GENERATE_SOURCES;
import static org.apache.maven.plugins.annotations.ResolutionScope.TEST;

@Mojo(
        name = "generate",
        defaultPhase = GENERATE_SOURCES,
        requiresDependencyResolution = TEST
)
public class Plugin extends AbstractMojo {

    /**
     * The Maven project.
     */
    @Parameter(
            property = "project",
            required = true,
            readonly = true
    )
    private MavenProject project;

    @Parameter
    private boolean genom;

    public void execute() throws MojoExecutionException {
        getLog().error("HERE!");
        getLog().error(project.getBasedir().getAbsolutePath());
        getLog().error(project.getBasedir().toString());
        Path base = Paths.get(project.getBasedir().getPath(), "src/main/resources");
        if(base.toFile().exists()) {
            try {
                Files.walk(base, FileVisitOption.FOLLOW_LINKS).forEach(it -> {
                    if (FilenameUtils.isExtension(it.toFile().getName(), "yml")) {
                        getLog().info("Found new file! " + it);

                        YmlGenom.gen(
                                it,
                                Paths.get(project.getBasedir().getPath(), "src/main/java/com/opentangerine/genotype/yml")
                        );
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //
        if(genom) {
            try {
                new HtmlGenom(project.getBasedir().toPath()).main();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
