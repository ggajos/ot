package com.ggajos.include;

import com.opentangerine.genotype.html.Renderable;
import com.opentangerine.genotype.Template;

import static com.opentangerine.genotype.html.Wizard.nil;

/**
 * @author Grzegorz Gajos
 */
public class Share implements Template {
    @Override
    public Renderable html() {
        // FIXME GG: in progress, access site url and page url
        return nil;
    }
}
//<a href="https://twitter.com/share?url={{ site.url }}{{ page.url }}&amp;text={{ page.title }} by @ggajos"
//        title="Share on Twitter" class="share" rel="nofollow">Twitter</a>,
//<a href="http://www.facebook.com/sharer/sharer.php?u={{ site.url }}{{ page.url }}"
//        title="Share on Facebook" class="share" rel="nofollow">Facebook</a>,
//<a href="https://plus.google.com/share?url={{ site.url }}{{ page.url }}"
//        title="Share on Google+" class="share" rel="nofollow">Google+</a>,
//<a href="https://www.linkedin.com/cws/share?url={{ site.url }}{{ page.url }}"
//        title="Share on LinkedIn" class="share" rel="nofollow">LinkedIn</a>
//        or
//<a href="{{ '/about' | prepend: site.baseurl | prepend: site.url }}">subscribe</a>
