package com.opentangerine.genotype;

import com.opentangerine.genotype.html.Renderable;
import java.util.Map;

/**
 * @author Grzegorz Gajos
 */
public interface Block {
    Renderable html(PageContext context);
}
