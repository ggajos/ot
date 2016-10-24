package com.ggajos.include;

import com.opentangerine.genotype.Geno;
import com.opentangerine.genotype.PageContext;
import com.opentangerine.genotype.Block;
import com.opentangerine.genotype.html.Renderable;
import com.opentangerine.genotype.yml.Config;

import static com.opentangerine.genotype.html.Wizard.*;

/**
 * @author Grzegorz Gajos
 */
public class Default implements Block {
    @Override
    public Renderable html(PageContext context) {
        // FIXME GG: in progress, create element which is not going to render anything!
        // FIXME GG: in progress, add `<!DOCTYPE html>`
        // FIXME GG: in progress, head template
        System.out.println(new Head().html(context).render());
        return nil.in(
            nil.in("<!DOCTYPE html>"),
            html.lang("en-US").in(
                new Head().html(context),
                body.classAttr(Config.basetheme).in(
                    header.classAttr("main-header").in(
                        div.classAttr("wc-container").in(
                            h2.in(
                                // FIXME GG: in progress, access site variables
                                a.href(context.relativeUrl("")).in("Java Developer")
                            ),
                            headerLinks(context)
                        )
                    ),
                    () -> context.get("content").orElse(""),
                    footer.in(" "),
                    script.src("//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"),
                    script.src(context.relativeUrl("assets/js/all.js")),
                    googleAnalytics()
                )
            ));
    }

    private Renderable googleAnalytics() {
        return Geno.include("include/google-analytics.html");
    }

    private Renderable headerLinks(PageContext context) {
        return nil.in(
            ul.in(
                li.in(() -> " by ", a.href(context.absoluteUrl("about")).in("Grzegorz Gajos"), () -> " &middot; "),
                li.in(() -> " check ", a.href(context.absoluteUrl("rss.xml")).in("rss feed"), () -> " &middot; "),
                li.in(() -> " see ", a.href(context.absoluteUrl("blog")).in("all posts"), () -> " &middot; "),
                li.in(() -> " or ", a.href(context.absoluteUrl("")).in("home page"))
            ),
            ul.in(
                li.in(
                    nil("I won't tell you that"),
                    a.href("http://opentangerine.com").rel("nofollow").in("Open Tangerine"),
                    nil("team is among the most ingenious and professional engineers.")
                )
            )
        );
    }

}