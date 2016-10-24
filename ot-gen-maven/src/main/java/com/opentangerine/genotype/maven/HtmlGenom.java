package com.opentangerine.genotype.maven;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Grzegorz Gajos
 */
public class HtmlGenom {
    private Path base;

    public HtmlGenom(Path base) {
        this.base = base;
    }

    public void main() throws IOException {
        String[] tags = IOUtils.toString(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("config/tags.txt"),
                StandardCharsets.UTF_8
        ).split(" ");
        Map<String, Object> map = new HashMap<>();
        map.put("tags", tags);


        List<String> lines = IOUtils.readLines(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("config/attrs.txt"),
                StandardCharsets.UTF_8
        );
        List<Pair> attrs = lines.stream()
                .map(it -> it.split("\t")[0])
                .filter(it -> !it.contains("*"))
                .map(it -> new Pair(it))
                .collect(Collectors.toList());
        map.put("attrs", attrs);
        gen("Wizard", map);
        gen("Start", map);
        gen("Gen", map);
        gen("Element", map);
    }

    private void gen(final String className, Map<String, Object> map) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("templates/" + className + ".java.mustache");
        StringWriter w = new StringWriter();
        mustache.execute(w, map);
        String result = w.toString().trim();
        File file = base.resolve("src/main/java/com/opentangerine/genotype/html/" + className + ".java").toFile();
        FileUtils.writeStringToFile(file, result, StandardCharsets.UTF_8);
        System.out.println(file.getAbsolutePath());
    }

    static class Pair {
        public String name;
        public String html;

        public Pair(String name) {
            this.html = name;
            this.name = name.replace("-", "_");
            if("class".equals(name)) {
                this.name = "classAttr";
            }
            if("for".equals(name)) {
                this.name = "forAttr";
            }
            if("default".equals(name)) {
                this.name = "defaultAttr";
            }
        }
    }

}

