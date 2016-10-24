package com.ggajos.include;

import com.opentangerine.genotype.Geno;
import com.opentangerine.genotype.html.Renderable;
import com.opentangerine.genotype.Template;

import static com.opentangerine.genotype.html.Wizard.*;

/**
 * @author Grzegorz Gajos
 */
public class Author implements Template {
    @Override
    public Renderable html() {
        return nil.in(
                h4.in("About the author"),
                p.in(
                        a.href(Geno.link("/about")).in("Grzegorz Gajos").in(
                                "Software Architect" +
                                "with international consulting and programming background. Co-founder of Open Tangerine" +
                                "Software House. Quality evangelist. An experienced entrepreneur, out of the box thinker and problem solver."
                        )
                )
        );
    }
}
