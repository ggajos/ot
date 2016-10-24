package com.ggajos.include;

import com.opentangerine.genotype.Geno;
import com.opentangerine.genotype.PageContext;
import com.opentangerine.genotype.Block;
import com.opentangerine.genotype.html.Renderable;

import static com.opentangerine.genotype.html.Wizard.*;

/**
 * @author Grzegorz Gajos
 */
public class About implements Block {

    @Override
    public Renderable html(PageContext context) {
        // FIXME GG: in progress, cleanup
        context = context.with("content", content(context, context.get("content").orElse("")).render());
        return new Default().html(context);
    }

    private Renderable content(PageContext context, final String old) {
        return div.classAttr("page-content wc-container").in(
            div.classAttr("post").attr("itemscope").attr("itemtype", "http://schema.org/Article").in(
                a.href(context.absoluteUrl("about")).classAttr("avatar").in("&nbsp;"),
                h1.classAttr("about-me").attr("itemprop", "author").in("Grzegorz Gajos"),
                div.classAttr("post").attr("itemprop", "articleBody").in(old)
            )
        );
    }
}