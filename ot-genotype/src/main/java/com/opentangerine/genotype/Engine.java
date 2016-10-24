package com.opentangerine.genotype;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Grzegorz Gajos
 */
// FIXME GG: in progress, add all pages first (page can have category etc.)
// FIXME GG: in progress, try to render completely file:///D:/work/ot-static/repo/target/index.html
public class Engine {
    private final DefaultMustacheFactory mf;

    public Engine() {
        this.mf = new DefaultMustacheFactory(new RelativeResolver());
    }

    public String render(DeprView layout, Map<String, Object> args) {
        // FIXME GG: in progress, use immutable maps!
        if(args.get("page") == null) {
            args.put("page", new HashMap<String, Object>());
        }
        ((Map)args.get("page")).putAll(layout.header());
        System.out.println(((Map)args.get("page")).get("title"));
        String content = layout.content();
        if(layout.getName().endsWith(".md")) {
            content = new PegDownProcessor(Extensions.NONE).markdownToHtml(layout.content(), new LinkRenderer());
        }
        Mustache mustache = mf.compile(new StringReader(content), layout.getName());
        StringWriter w = new StringWriter();
        mustache.execute(w, args);
        String result = w.toString().trim();
        final String lay = layout.header().get("layout");
        if(lay != null) {
            args.put("content", result);

            return render(new DeprView(lay), args);
        } else {
            return result;
        }
    }

}
