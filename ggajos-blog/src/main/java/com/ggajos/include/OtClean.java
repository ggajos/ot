package com.ggajos.include;

import com.opentangerine.genotype.html.Renderable;
import com.opentangerine.genotype.Template;

import static com.opentangerine.genotype.html.Wizard.head;

/**
 * @author Grzegorz Gajos
 */
public class OtClean implements Template {
    @Override
    public Renderable html() {
        return head.in(
        );
    }
}