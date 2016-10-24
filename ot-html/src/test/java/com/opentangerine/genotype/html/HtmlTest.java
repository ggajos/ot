package com.opentangerine.genotype.html;

import com.sun.media.sound.FFT;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.util.stream.Stream;

import static com.opentangerine.genotype.html.Wizard.*;
import static com.opentangerine.genotype.html.Wizard.strong;

/**
 * @author Grzegorz Gajos
 */
public class HtmlTest {

    @Test
    public void example() {
        Stream<String> arrays = Stream.of("1", "2");

        String html = div.classAttr("large-12 columns").in(
                div.id("333"),
                div.classAttr("logo-img"),
                h1.in("Heading"),
                a.href("http://google.com/"),
                h2.id("4asd").src("asokdvamsoka").in("Heading"),
                div.classAttr("inline-list sub-header-info").in(
                        ul.classAttr("inline-list sub-header-info").in(
                                li.in(
                                        strong.in("JAVA"),
                                        strong.in("AI"),
                                        strong.in("NLP"),
                                        strong.in("BIG DATA")
                                )
                        )
                ),
                ul.classAttr("x-inline-list").in(
                        li.in(
                                arrays.map(strong::in)
                        )
                )
        ).render();
        html = Jsoup.parseBodyFragment(html).body().html();
        MatcherAssert.assertThat(
                html,
                Matchers.equalToIgnoringWhiteSpace(StringUtils.join(
                        " <div class=\"large-12 columns\">",
                        "  <div id=\"333\"></div>",
                        "  <div class=\"logo-img\"></div>",
                        "  <h1>Heading</h1>",
                        "  <a href=\"http://google.com/\"></a>",
                        "  <h2 id=\"4asd\" src=\"asokdvamsoka\">Heading</h2>",
                        "  <div class=\"inline-list sub-header-info\">",
                        "   <ul class=\"inline-list sub-header-info\">",
                        "    <li><strong>JAVA</strong><strong>AI</strong><strong>NLP</strong><strong>BIG DATA</strong></li>",
                        "   </ul>",
                        "  </div>",
                        "  <ul class=\"x-inline-list\">",
                        "   <li><strong>1</strong><strong>2</strong></li>",
                        "  </ul>",
                        " </div>"
                ))
        );
    }

    @Test
    public void strong() {
        MatcherAssert.assertThat(
                strong.in("123").render(),
                Matchers.equalToIgnoringWhiteSpace("<strong>123</strong>")
        );
    }

    @Test
    public void div() {
        MatcherAssert.assertThat(
                div.id("333").render(),
                Matchers.equalToIgnoringWhiteSpace("<div id=\"333\"></div>")
        );
    }

    @Test
    public void divWithContent() {
        MatcherAssert.assertThat(
                div.id("333").in("content").render(),
                Matchers.equalToIgnoringWhiteSpace("<div id=\"333\">content</div>")
        );
    }

    @Test
    public void divWithNestedDiv() {
        MatcherAssert.assertThat(
                div.id("333").in(
                        div.id("nest1").in("n1"),
                        div.id("nest2").in("n2")
                ).render(),
                Matchers.equalToIgnoringWhiteSpace("<div id=\"333\">" +
                        "<div id=\"nest1\">n1</div>" +
                        "<div id=\"nest2\">n2</div>" +
                        "</div>"
                )
        );
    }

    @Test
    public void emptyDiv() {
        MatcherAssert.assertThat(
                div.render(),
                // FIXME GG: in progress, div should have content (check all tags)
                Matchers.equalToIgnoringWhiteSpace("<div></div>")
        );
    }

    @Test
    public void emptyOptgroup() {
        MatcherAssert.assertThat(
                optgroup.render(),
                Matchers.equalToIgnoringWhiteSpace("<optgroup></optgroup>")
        );
    }

    @Test
    public void customAttrWithoutValue() {
        MatcherAssert.assertThat(
                optgroup.attr("itemscope").render(),
                Matchers.equalToIgnoringWhiteSpace("<optgroup itemscope></optgroup>")
        );
    }

    @Test
    // FIXME GG: in progress,
    public void checkThatCustomElementWithoutParentCanBeRendered() {
        MatcherAssert.assertThat(
                nil.in("content").render(),
                Matchers.equalToIgnoringWhiteSpace("content")
        );
    }

    @Test
    // FIXME GG: in progress,
    public void checkThatCustomElementHeaderWithoutParentCanBeRendered() {
        MatcherAssert.assertThat(
                nil.in(
                        nil.in("<DOCTYPE!>"),
                        html.in("anything")
                ).render(),
                Matchers.equalToIgnoringWhiteSpace("<DOCTYPE!><html>anything</html>")
        );
    }

    @Test
    public void autocloseTagIfNoContent() {
        MatcherAssert.assertThat(
            ul.href("//ggajos.com").render(),
            Matchers.equalTo("<ul href=\"//ggajos.com\"></ul>")
        );
    }

    @Test
    public void doNotAutocloseTagIfForSpecialTags() {
        MatcherAssert.assertThat(
            base.href("//ggajos.com").render(),
            Matchers.equalTo("<base href=\"//ggajos.com\">")
        );
    }

    @Test
    public void exampleMeta() {
        MatcherAssert.assertThat(
            meta.name("viewport").content("width=device-width, initial-scale=1.0").render(),
            Matchers.equalTo("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
        );
    }
}