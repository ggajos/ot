package com.opentangerine.genotype;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import org.jsoup.Jsoup;

/**
 * @author Grzegorz Gajos
 */
public class Page {
    private final PageContext context;
    private final Block block;

    public Page(PageContext context, Block block) {
        this.context = context;
        this.block = block;
    }

    void render(Path target) {
        try {
            final File file = target.resolve(context.pageUrl()).resolve("./index.html").normalize().toFile();
            System.out.println(file.getAbsolutePath());
            String html = block.html(context).render();
            if (!context.isCompressed()) {
                html = Jsoup.parse(html).html();
            } else {
                //FIXME GG: add html compression
            }
            FileUtils.writeStringToFile(
                file,
                html,
                StandardCharsets.UTF_8
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
