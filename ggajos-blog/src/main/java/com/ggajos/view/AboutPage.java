package com.ggajos.view;

import com.ggajos.include.About;
import com.ggajos.include.Default;
import com.opentangerine.genotype.*;
import com.opentangerine.genotype.html.Renderable;

import java.util.Map;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;

/**
 * @author Grzegorz Gajos
 */
public class AboutPage implements Block {
    @Override
    public Renderable html(PageContext context) {
        final DeprView v = new DeprView("view/about.md");
        context = context
                .with(v.header())
                .with("content", new PegDownProcessor(Extensions.NONE).markdownToHtml(v.content(), new LinkRenderer()));
        return new About().html(context);
    }

}