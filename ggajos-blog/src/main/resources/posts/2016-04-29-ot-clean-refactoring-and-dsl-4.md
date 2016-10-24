---
layout: otclean
title: ot-clean, Refactoring and cleaning DSL (4/4)
date: 2016-04-29
categories: ot-clean refactoring DSL
keywords:
  - ot-clean domain specific language
  - ot-clean DSL
  - ot-clean refactoring
  - ot-clean fluent
  - ot-clean cleanup
---

We haven't changed the logic and still have the same code to use. This way
we've separated behaviour and definition of cleaning from the logic of cleaning itself. It's very
clear and easy to add new definitions.

### Summary

#### Maven definition before refactoring.

{% highlight java %}
final class Maven implements Cleanable {
    private final Delete delete;

    public Maven(final Delete cdelete) {
        this.delete = cdelete;
    }

    @Override
    public void clean(final Path path) {
        if (this.match(path)) {
            this.delete.file(path.resolve("target"));
        }
    }

    @Override
    public boolean match(final Path path) {
        return path.resolve("pom.xml").toFile().exists();
    }

    @Override
    public void display(final Path path, final Console console) {
        console.print(
            String.format(
                "[Maven]: %s", path
            )
        );
    }
}
{% endhighlight %}

#### Maven definition after refactoring.

{% highlight java %}
new Definition(
    Type.MAVEN,
    If.fileExists("pom.xml"),
    Then.delete("target")
),
{% endhighlight %}

#### List of all definitions.

{% highlight java %}
List<Definition> DEFAULT = Lists.newArrayList(
    new Definition(
        Type.MAVEN,
        If.fileExists("pom.xml"),
        Then.delete("target")
    ),
    new Definition(
        Type.GRAILS_2,
        If.fileExistsWithRegExp(
            "application.properties",
            "app.grails.version"
        ),
        Then.delete("target", "**/*.log")
    ),
    new Definition(
        Type.GRAILS_3,
        If.fileExistsWithRegExp(
            "build.gradle",
            "apply plugin:.*org.grails"
        ),
        Then.delete("build", "**/*.log")
    ),
    new Definition(
        Type.OT_CLEAN,
        If.fileExists(".clean.yml"),
        Then.useYmlConfig()
    ),
    new Definition(
        Type.PLAYFRAMEWORK_2,
        If.fileExistsWithRegExp(
            "build.sbt",
            "enablePlugins\\(PlayJava\\)"
        ),
        Then.delete(
            "logs",
            "target",
            "project/target",
            "project/project/target",
            ".sbtserver",
            "**/*.log"
        )
    )
);
{% endhighlight %}

Is it better that way? :)