package com.opentangerine.genotype;

import com.github.mustachejava.MustacheResolver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @author Grzegorz Gajos
 */
class RelativeResolver implements MustacheResolver {
    @Override
    public Reader getReader(String resourceName) {
        try {
            final ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = null;
            final File file = Paths.get("src/main/resources").resolve(resourceName).toFile();
            if (file.exists()) {
                System.out.println("GERE");
                stream = new FileInputStream(file);
            }
            if (new File(resourceName).isFile()) {
                stream = new FileInputStream(new File(resourceName));
            }
            if (stream == null) {
                stream = loader.getResourceAsStream(resourceName);
            }
            if (stream == null) {
                stream = loader.getResourceAsStream(resourceName + ".mustache");
            }
            if (stream == null) {
                stream = loader.getResourceAsStream("view/" + resourceName);
            }
            if (stream == null) {
                stream = loader.getResourceAsStream("view/" + resourceName + ".mustache");
            }
            return new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        } catch (Exception ex) {
            throw new IllegalArgumentException("Unable to resolve " + resourceName + " view.", ex);
        }
    }
}
