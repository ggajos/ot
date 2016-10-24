package com.ggajos.include;

import com.opentangerine.genotype.PageContext;
import com.opentangerine.genotype.Block;
import com.opentangerine.genotype.html.Renderable;
import com.opentangerine.genotype.html.Wizard;
import com.opentangerine.genotype.yml.Config;

import static com.opentangerine.genotype.html.Wizard.*;

/**
 * @author Grzegorz Gajos
 */
public class Head implements Block {

    @Override
    public Renderable html(PageContext context) {
        final String pageTitle = context.get("title").orElse(Config.meta_title);
        final String pageDescription = context.get("description").orElse(Config.meta_description);
        final String pageKeywords = context.get("keywords").orElse(Config.meta_keywords);
        return head.attr("itemscope").attr("itemtype", "http://schema.org/WebPage").in(
            base.href(context.url()),
            meta.charset("UTF-8"),
            meta.http_equiv("X-UA-Compatible").content("IE=edge,chrome=1"),
            meta.name("viewport").content("width=device-width, initial-scale=1.0"),
            meta.name("description").content(pageDescription),
            meta.name("keywords").content(pageKeywords),
            link.rel("canonical").href(context.url()),
            // FIXME GG: in progress, well there is no RSS available yet
            link.rel("alternate").type("application/rss+xml").title("RSS for ggajos.com").href(context.absoluteUrl("rss.xml")),
            title.in(pageTitle),
            // <!--twitter -->
            meta.name("twitter:site").content("@ggajos"),
            meta.name("twitter:creator").content("@ggajos"),
            meta.name("twitter:url").content(context.url()),
            // <!-- facebook -->
            meta.attr("property", "article:author").content("https://www.facebook.com/grzegorz.gajos"),
            meta.attr("property", "og:url").content(context.url()),
            meta.attr("property", "og:site_name").content("ggajos"),
            meta.attr("property", "og:title").content(pageTitle),
            meta.attr("property", "og:description").content(pageDescription),
            meta.attr("property", "og:type").content("article"),
            meta.attr("property", "og:locale").content("en_US"),
            // <!-- itemprop -->
            meta.attr("itemprop", "name").content(pageTitle),
            meta.attr("itemprop", "author").content(Config.author.name),
            meta.attr("itemprop", "breadcrumb").content(context.baseUrl()),
            meta.attr("itemprop", "keywords").content(pageKeywords),
            meta.attr("itemprop", "description").content(pageDescription),
            // <!-- google -->
            meta.name("google-site-verification").content("Ls52KLW0k11NkXeBx89rhcLnXOfGbaDlNSCkGawXcM4"),
            // <!-- script/css -->
            // FIXME GG: in progress, add CSS asset management
            link.rel("stylesheet").type("text/css").href(context.relativeUrl("css/main.css")),
            script.attr("async").src(context.relativeUrl("js/modernizr.js")),
            script.in("setInterval(function() { jQuery.getJSON('/meta.json', function(data) { if(!window.version) { window.version = data.version } else if(window.version !== data.version) { window.location.reload() } }) }, 500);"),
            nil.in(
                () -> "<!--[if lt IE 9]>",
                script.src("https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"),
                script.src("https://oss.maxcdn.com/respond/1.4.2/respond.min.js"),
                () -> "<![endif]-->"
            )
        );
    }
}