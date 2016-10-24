package com.opentangerine.genotype.maven;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Grzegorz Gajos
 */
public class YmlGenom {
    public static long uniq = 0;
    public static void main(String[] args) throws IOException {
        Map<String, Object> map = (Map<String, Object>) new Yaml().load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/config.yml"));
//        generateClass("ymlConfig", map);
    }

    public static void gen(Path file, Path target) {
        try {
            Map<String, Object> map = (Map<String, Object>) new Yaml().load(FileUtils.readFileToString(file.toFile(), StandardCharsets.UTF_8));
            generateClass(StringUtils.capitalize(FilenameUtils.getBaseName(file.toFile().getName())), target, map);
        } catch (IOException e) {

        }
    }

    private static String generateClass(String name, Path target, Map<String, Object> map) {
        Map<String, Object> params = new HashMap<>();
        params.put("class", name);
        params.put("fields",
                map.entrySet().stream().map(it ->
                        new HashMap<String, String>() {{
                            put("name", it.getKey());
                            if(it.getValue() instanceof Map) {

                                String newType = generateClass(name + StringUtils.capitalize(it.getKey().toLowerCase()), target, (Map<String, Object>) it.getValue());
                                put("type", newType);
                                put("value", "new " + newType + "()");
                            } else {
                                put("type", "String");
                                put("value", "\"" + it.getValue().toString().replace("\"", "\\\"") + "\"");
                            }
                        }}).collect(Collectors.toList())
        );

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("templates/ConfigYml.java.mustache");
        StringWriter w = new StringWriter();
        mustache.execute(w, params);
        String result = w.toString().trim();
        File file = target.resolve(name + ".java").toFile();
        try {
            FileUtils.writeStringToFile(file, result, StandardCharsets.UTF_8);
            System.out.println("GENERATING" + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}

