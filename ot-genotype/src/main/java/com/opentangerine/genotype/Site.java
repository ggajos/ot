package com.opentangerine.genotype;

import com.cathive.sass.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Grzegorz Gajos
 */
public class Site {
    private String baseUrl;
    private Path target;
    private Collection<Page> views = new ArrayList<>();

    public Site(String baseUrl, Path target) {
        this.baseUrl = baseUrl;
        this.target = target;
    }

    public Site addPage(String relative, Block block) {
        if(relative.startsWith("/")) {
            throw new IllegalArgumentException("Cannot start with '/'");
        }
        views.add(new Page(new PageContext(baseUrl, relative), block));
        return this;
    }

    public Site generate() {
        views.forEach(it -> it.render(target));
        // FIXME GG: in progress, compile SCSS
        // FIXME GG: in progress,
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        SimpleSassExample.main();
        try {
            System.out.println("HERE");
            System.out.println(Paths.get("src/main/webapp").toFile().getAbsolutePath());
            FileUtils.copyDirectory(
                    Paths.get("src/main/webapp").toFile(),
                    target.toFile()
            );
            FileUtils.writeStringToFile(
                target.resolve("meta.json").toFile(),
                "{\"version\": " + System.currentTimeMillis() + "}",
                StandardCharsets.UTF_8
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}

class SimpleSassExample {

    public static void main() {
        // Our root directory that contains the
        Path srcRoot = Paths.get("src/main/webapp/css");

        // Creates a new sass file context.
        SassContext ctx = SassFileContext.create(srcRoot.resolve("main.scss"));

        SassOptions options = ctx.getOptions();
        options.setIncludePath(
                srcRoot
//                Paths.get("/another/include/directory"),
//                Paths.get("/and/yet/another/include/directory")
                //[...] varargs can be passed to add even more include directories.
        );
        options.setOutputStyle(SassOutputStyle.NESTED);
        // any other options supported by libsass including source map stuff can be configured
        // as well here.

        // Will print the compiled CSS contents to the console. Use a FileOutputStream
        // or some other fancy mechanism to redirect the output to wherever you want.
        try {
            System.err.println("COMPILE");
            System.err.println(srcRoot.resolve("main.css").toFile().getAbsolutePath());
            FileUtils.writeStringToFile(srcRoot.resolve("main.css").toFile(), ctx.compile(), StandardCharsets.UTF_8);
        } catch (SassCompilationException e) {
            // Will print the error code, filename, line, column and the message provided
            // by libsass to the standard error output.
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(String.format("Compilation failed: %s", e.getMessage()));
        }
    }

}
