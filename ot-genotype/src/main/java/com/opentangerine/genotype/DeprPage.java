package com.opentangerine.genotype;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author Grzegorz Gajos
 */
@Deprecated
public class DeprPage {
    DeprView view;
    File target;

    public DeprPage(DeprView view, File target) {
        this.view = view;
        this.target = target;
    }

    void render(Engine engine, Map<String, Object> args) {
        try {
            System.out.println("WRITING: " + target);
            FileUtils.writeStringToFile(
                    target,
                    engine.render(view, args),
                    Charset.forName("UTF-8"),
                    false
            );
        } catch (IOException e) {
            throw new IllegalStateException("Unable to render file", e);
        }
    }
}
