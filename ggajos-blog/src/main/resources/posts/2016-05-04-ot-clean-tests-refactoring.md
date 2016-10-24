---
layout: otclean
title: ot-clean, Tests refactoring
date: 2016-05-04
categories: ot-clean tests refactoring
keywords:
  - ot-clean tests
  - ot-clean DSL
  - ot-clean refactoring
  - ot-clean fluent
  - ot-clean cleanup
---

The final step before the release is to cleanup the test code. Some test cases are really too complex
and I want to make them more clear and straightforward. Simpler tests are making adding new features
less error prone and more straightforward.

### Helper object to encapsulate case structure

There are multiple tests that are checking if the directory is cleaned up and files are removed properly.
In every case project structure has to be created and checked again after cleaning process. It turns
out that logic can be fairly easy encapsulated.

#### Before refactoring

{% highlight java %}
@Test
public void deleteGrails2ProjectWithoutAnyConfiguration() {
    final Path root = this.createGrails2();
    MatcherAssert.assertThat(
        root.resolve("target").toFile().isDirectory(),
        Matchers.is(true)
    );
    MatcherAssert.assertThat(
        root.resolve("subdir.log").toFile().exists(),
        Matchers.is(true)
    );
    MatcherAssert.assertThat(
        root.resolve("subdir/target/some.log").toFile().exists(),
        Matchers.is(true)
    );
    final Mode mode = new Mode(Mode.Arg.D.getLabel());
    this.get(Wipe.Type.GRAILS_2).clean(new Delete(mode, new Summary(mode)), root);
    MatcherAssert.assertThat(
        root.resolve("target").toFile().isDirectory(),
        Matchers.is(false)
    );
    MatcherAssert.assertThat(
        root.resolve("subdir.log").toFile().exists(),
        Matchers.is(false)
    );
    MatcherAssert.assertThat(
        root.resolve("subdir/target/some.log").toFile().exists(),
        Matchers.is(false)
    );
}
{% endhighlight %}

#### After refactoring

{% highlight java %}
@Test
public void defaultGrailsVersionTwo() {
    new Check("target", "subdir.log", "subdir/target/some.log")
        .file("application.properties", "app.grails.version")
        .run(Wipe.Type.GRAILS_2);
}
{% endhighlight %}

### Java 8 utility class

I wanted to increase test coverage for the project. It turns out that it is not possible to reach
100% due to the fact that private constructor of utility class is not testable. Java 8 default interface
methods are able to do the trick which makes the code looking even better.

#### Before refactoring

{% highlight java %}
public final class Res {

    private Res() {
        // Private
    }

    public static String resource(final String path) {
        try {
            final InputStream stream = Res.class.getResourceAsStream(path);
            Validate.isTrue(stream != null, "File not found");
            return IOUtils.toString(stream);
        } catch (final IllegalArgumentException | IOException exc) {
            Logger.error(Res.class, "Unable to read '%s'", path);
            throw new IllegalArgumentException(
                String.format("Unable to read resource: %s", path), exc
            );
        }
    }

}
{% endhighlight %}

#### After refactoring

{% highlight java %}
interface Res {

    static String resource(final String path) {
        try {
            final InputStream stream = Res.class.getResourceAsStream(path);
            Validate.isTrue(stream != null, "File not found");
            return IOUtils.toString(stream);
        } catch (final IllegalArgumentException | IOException exc) {
            Logger.error(Res.class, "Unable to read '%s'", path);
            throw new IllegalArgumentException(
                String.format("Unable to read resource: %s", path), exc
            );
        }
    }

}
{% endhighlight %}

Feels better.