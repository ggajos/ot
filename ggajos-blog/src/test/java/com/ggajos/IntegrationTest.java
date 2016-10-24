package com.ggajos;

import com.ggajos.view.AboutPage;
import com.opentangerine.genotype.IO;
import com.opentangerine.genotype.Site;
import com.opentangerine.genotype.Page;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.diff.EditList;
import org.eclipse.jgit.diff.HistogramDiff;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.diff.RawTextComparator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.jsoup.Jsoup;
import org.junit.Test;

/**
 * Created by gagre on 09.10.2016.
 */
public class IntegrationTest {

    @Test
    public void aboutPage() throws IOException {
        new Site("http://ggajos.com/", Paths.get(".").resolve("target/site"))
            .addPage("about", new AboutPage())
            .generate();
        String result = FileUtils.readFileToString(Paths.get("target/site/about/index.html").toFile(), StandardCharsets.UTF_8);
        result = Jsoup.parse(result).html();
        final String expected = Jsoup.parse(IO.read(IO.resource("pages/about.html"))).html();

        EditList diffList = new EditList();
        diffList.addAll(new HistogramDiff().diff(RawTextComparator.WS_IGNORE_ALL, new RawText(expected.getBytes()), new RawText(result.getBytes())));
        new DiffFormatter(System.out).format(diffList, new RawText(expected.getBytes()), new RawText(result.getBytes()));

        MatcherAssert.assertThat(
            StringUtils.deleteWhitespace(result),
            Matchers.equalTo(StringUtils.deleteWhitespace(expected))
        );
    }

    @Test
    public void copyResources() {
        FileUtils.deleteQuietly(Paths.get("target/site/test.txt").toFile());
        new Site("http://ggajos.com/", Paths.get(".").resolve("target/site")).generate();
        MatcherAssert.assertThat(
                Paths.get("target/site/test.txt").toFile().exists(),
                Matchers.is(true)
        );
    }
}
