package com.ggajos;

import com.ggajos.view.AboutPage;
import com.opentangerine.genotype.Site;
import com.opentangerine.genotype.Page;

import java.awt.*;
import java.net.URI;
import java.nio.file.Paths;

/**
 * @author Grzegorz Gajos
 */
public class Blog {
    // FIXME GG: in progress, generate about page
    public static void main(String[] args) {
        new Site("http://localhost:4000/", Paths.get(".").resolve("target/static-site"))
                .addPage("about", new AboutPage())
                .generate();
    }
}
