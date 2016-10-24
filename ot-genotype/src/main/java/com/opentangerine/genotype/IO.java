package com.opentangerine.genotype;

import com.opentangerine.genotype.html.Renderable;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.Reader;

/**
 * @author Grzegorz Gajos
 */
public interface IO {

    static String pretty(Renderable renderable) {
        return Jsoup.parseBodyFragment(renderable.render()).body().html();
    }

    static String pretty(Template template) {
        return IO.pretty(template.html());
    }

    static String read(Reader reader) {
        try {
            return IOUtils.toString(reader);
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to read file from the reader", ex);
        }
    }

    static Reader resource(String name) {
        return new RelativeResolver().getReader(name);
    }

}
