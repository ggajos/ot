package com.opentangerine.genotype.html;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Grzegorz Gajos
 */
public class El {
    private String name;
    private List<Renderable> in = new ArrayList<>();
    private Map<String, String> attrs = new LinkedHashMap<>(); // we want to keep inserts!

    public El(String name) {
        this.name = name;
    }

    public void in(Renderable... tags) {
        for (Renderable tag : tags) {
            in.add(tag);
        }
    }

    public void in(String tags) {
        in.add(() -> tags);
    }

    public void in(Stream<Renderable> stream) {
        stream.forEach(it -> in.add(it));
    }

    public void attr(String key) {
        this.attrs.put(key, null);
    }

    public void attr(String key, Optional<String> value) {
        if(value.isPresent()) {
            if(this.attrs.containsKey(key)) {
                throw new IllegalArgumentException("You cannot set same key multiple times");
            }
            this.attrs.put(key, value.get());
        }
    }

    public String render() {
        StringBuilder builder = new StringBuilder();
        if(name != null) {
            builder.append("<").append(name);
            for (Map.Entry<String, String> it : attrs.entrySet()) {
                builder.append(" ");
                if(it.getKey() != null) {
                    builder.append(it.getKey());
                }
                if(it.getValue() != null) {
                    builder.append("=\"").append(it.getValue()).append("\"");
                }
            }
            builder.append(">");
        }
        if(!in.isEmpty()) {
            in.forEach((renderable) -> builder.append(renderable.render()));
        }
        if (name != null && !isVoidTag(name)) {
            builder.append("</").append(name).append(">");
        }
        return builder.toString();
    }

    private static boolean isVoidTag(String name) {
        //FIXME GG: in progress
        Set<String> set = new HashSet<>();
        final String[] list = {
                "area",
                "base",
                "br",
                "col",
                "embed",
                "hr",
                "img",
                "input",
                "keygen",
                "link",
                "meta",
                "param",
                "source",
                "track",
                "wbr"
        };
        Collections.addAll(set, list);
        return set.contains(name);
    }

}
