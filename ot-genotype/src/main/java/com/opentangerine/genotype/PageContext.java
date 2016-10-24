package com.opentangerine.genotype;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This class has to be immutable.
 *
 * @author Grzegorz Gajos
 */
public class PageContext {
    private Map<String, String> page = new HashMap<>();
    private String baseUrl;
    private String pageUrl;
    private boolean compressed = false;

    public boolean isCompressed() {
        return compressed;
    }

    //FIXME GG: group url to some kind of object?
    public PageContext(String baseUrl, String pageUrl) {
        this.baseUrl = baseUrl;
        this.pageUrl = pageUrl;
    }

    public String url() {
        return baseUrl + pageUrl + "/";
    }

    public String absoluteUrl(String relative) {
        return baseUrl + relative;
    }

    public String relativeUrl(String relative) {
        return "/" + relative;
    }

    public String baseUrl() {
        return baseUrl;
    }

    public String pageUrl() {
        return pageUrl;
    }

    public PageContext with(Map<String, String> args) {
        PageContext context = copy();
        context.page.putAll(args);
        return context;
    }

    public PageContext with(String key, String value) {
        PageContext context = copy();
        context.page.put(key, value);
        return context;
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(page.get(key));
    }

    private PageContext copy() {
        PageContext context = new PageContext(baseUrl, pageUrl);
        context.page = new HashMap<>(this.page);
        return context;
    }
}
