package com.opentangerine.genotype;

import com.opentangerine.genotype.html.Renderable;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Grzegorz Gajos
 */
@Deprecated
public interface Geno {
    @Deprecated
    static String link(String relative) {
        return "/" + relative;
    }
    @Deprecated
    static Renderable include(String path) {
        return () -> IO.read(IO.resource(path));
    }
}
