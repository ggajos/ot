package com.opentangerine.genotype;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author Grzegorz Gajos
 */
public class Genotype {
    private Engine engine = new Engine();
    private Stream<DeprPage> pages;

    Genotype mount(String dir) throws Exception {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        pages = Arrays.stream(new File(loader.getResource(dir).toURI()).listFiles())
                .map(it -> new DeprPage(
                        new DeprView(it),
                        new File("target/posts/" + it.getName() + ".html")
                ));
        return this;
    }

    Genotype render(Map<String, Object> args) {
        // FIXME GG: in progress, we are constructinge pages first and then rendering
        pages.forEach(it -> {
            it.render(engine, args);
        });
        return this;
    }
}
