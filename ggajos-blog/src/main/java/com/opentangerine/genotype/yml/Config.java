package com.opentangerine.genotype.yml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Grzegorz Gajos
 */
public final class Config {
    public static final String url = "http://ggajos.com";
    public static final String name = "Blog about programming";
    public static final String meta_keywords = "blog, java, software development, software house";
    public static final String meta_title = "Java Developer - Blog - Grzegorz Gajos";
    public static final String meta_description = "If you are looking for interesting articles from IT space, a fresh perspective on IT business, software quality or interesting tips in a day to day work, this blog might be interesting to you. Today, ...";
    public static final String basetheme = "theme-base-01";
    public static final ConfigAuthor author = new ConfigAuthor();
    public static final String highlighter = "rouge";
    public static final String permalink = ":title";
    public static final String exclude = "[Gemfile, Rakefile, README.md, .gitignore, .sass-cache, Gemfile.lock, dev.bat, dev-draft.bat, blog.iml, blog.ipr, blog.iws]";
    public static final ConfigSass sass = new ConfigSass();
    public static final String gems = "[jekyll-sitemap]";
}