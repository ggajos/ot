package com.opentangerine.genotype;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Grzegorz Gajos
 */
public class LayoutTest {
    @Test
    public void content() throws Exception {
        DeprView layout = new DeprView("view/static.mustache");
        Assert.assertThat(layout.content(), Matchers.is("Static content {{custom}}"));
        Assert.assertThat(layout.header().get("custom"), Matchers.is("works"));
    }

    @Test
    public void contentWithoutHeader() throws Exception {
        DeprView layout = new DeprView("view/static-only.mustache");
        Assert.assertThat(layout.content(), Matchers.is("Static content"));
        Assert.assertThat(layout.header().size(), Matchers.is(0));
    }

    @Test
    public void emptyFile() throws Exception {
        DeprView layout = new DeprView("view/empty.mustache");
        Assert.assertThat(layout.header().size(), Matchers.is(0));
        Assert.assertThat(layout.content(), Matchers.is(""));
    }

}