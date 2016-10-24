package com.opentangerine.genotype;

import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Grzegorz Gajos
 */
@Deprecated
public class DeprView {
    private final String text;
    private final String name;

    public DeprView(String resource) {
        this.name = resource;
        this.text = IO.read(IO.resource(resource));
    }

    public DeprView(File file) {
        this.name = file.getName();
        this.text = IO.read(IO.resource(file.getAbsolutePath()));
    }

    public String getName() {
        return name;
    }

    public Map<String, String> header() {
        final String header = StringUtils.substringBetween(this.text, "---");
        if(header == null) {
            return new HashMap<>();
        } else {
            return (Map<String, String>) new Yaml().load(header);
        }
    }

    public String content() {
        if(this.text.startsWith("---")) {
            return StringUtils.substringAfter(
                    StringUtils.replaceOnce(this.text, "---", ""),
                    "---"
            ).trim();
        } else {
            return this.text;
        }
    }
}
