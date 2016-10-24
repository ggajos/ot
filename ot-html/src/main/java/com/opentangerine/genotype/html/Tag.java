package com.opentangerine.genotype.html;

import java.util.stream.Stream;

/**
 * @author Grzegorz Gajos
 */
interface Tag extends Renderable {
    Tag body(Stream<Tag> tags);

    Tag body(Tag... tags);

    Tag body(String tags);

    Tag attrs(Tag... tags);

    Tag aClass(String arg);

    Tag id(Tag... tags);

    Tag id(String s);

    Tag href(String s);

    Tag src(String s);

    Tag href(Tag... tags);

    Tag src(Tag... tags);

    String render();
}
