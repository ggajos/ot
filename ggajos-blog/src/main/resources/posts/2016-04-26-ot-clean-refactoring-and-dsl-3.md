---
layout: otclean
title: ot-clean, Refactoring and cleaning DSL (3/4)
date: 2016-04-26
categories: ot-clean refactoring DSL
keywords:
  - ot-clean domain specific language
  - ot-clean DSL
  - ot-clean refactoring
  - ot-clean fluent
  - ot-clean cleanup
---

In previous post we've significantly reduced amount of code. Now let's try to push it further.

### Step 5: Combined definitions

Below you can see definitions of different cleaners. The problem is that in one place in the app we
need to have access to all cleaners. It's easy to miss adding them to the `ALL` variable.

{% highlight java %}
    Cleanable MAVEN = new Definition(
        "Maven",
        If.fileExists("pom.xml"),
        Then.delete("target")
    );
    Cleanable GRAILS_2 = new Definition(
        "Grails 2",
        If.fileExistsWithRegExp("application.properties", "app.grails.version"),
        Then.delete("target", "**/*.log")
    );
    Cleanable YCLEAN = new Definition(
        ".clean.yml",
        If.fileExists(".clean.yml"),
        Then.useYmlConfig()
    );
    List<Cleanable> ALL = Lists.newArrayList(
        MAVEN,
        GRAILS_2,
        YCLEAN
    );
{% endhighlight %}

Let's try to use single field instead and introduce enums as keys.

{% highlight java %}
enum Type {
    MAVEN,
    GRAILS_2,
    GRAILS_3,
    YCLEAN
}

Map<Type, Definition> DEFAULT = new ImmutableMap.Builder<Type, Definition>()
    .put(
        Type.MAVEN,
        new Definition(
            "Maven",
            If.fileExists("pom.xml"),
            Then.delete("target")
        )
    )
    .put(
        Type.GRAILS_2,
        new Definition(
            "Grails 2.x",
            If.fileExistsWithRegExp(
                "application.properties",
                "app.grails.version"
            ),
            Then.delete("target", "**/*.log")
        )
    )
    .put(
        Type.GRAILS_3,
        new Definition(
            "Grails 3.x",
            If.fileExistsWithRegExp(
                "build.gradle",
                "apply plugin:.*org.grails"
            ),
            Then.delete("build", "**/*.log")
        )
    )
    .put(
        Type.YCLEAN,
        new Definition(
            ".clean.yml",
            If.fileExists(".clean.yml"),
            Then.useYmlConfig()
        )
    )
    .build();
{% endhighlight %}

### Step 6: Enum can encapsulate the name

We have redundancy in definitions. We defined type enums and still we have to provide user friendly name.
This is something that can be moved now to the enum. So instead of this.

{% highlight java %}
.put(
    Type.YCLEAN,
    new Definition(
        ".clean.yml",
        If.fileExists(".clean.yml"),
        Then.useYmlConfig()
    )
)
{% endhighlight %}

We can do this.

{% highlight java %}
.put(
    Type.YCLEAN,
    new Definition(
        Type.YCLEAN,
        If.fileExists(".clean.yml"),
        Then.useYmlConfig()
    )
)
{% endhighlight %}

We have to extend enum a little bit.

{% highlight java %}
enum Type {
    MAVEN,
    GRAILS_2,
    GRAILS_3,
    PLAYFRAMEWORK_2,
    YCLEAN;

    /**
     * Generates user friendly name of this enumeration.
     * @return Name.
     */
    public String display() {
        return StringUtils.replace(
            WordUtils.capitalize(
                name().toLowerCase(Locale.ENGLISH)
            ),
            "_",
            " "
        );
    }
}
{% endhighlight %}

### Step 7: Convert map into the list

Again we have name redundancy. We have to type enum twice. First is the map key and the second is the name
of the definition.

{% highlight java %}
.put(
    Type.MAVEN,
    new Definition(
        Type.MAVEN,
        If.fileExists(".clean.yml"),
        Then.useYmlConfig()
    )
)
{% endhighlight %}

Let's convert our map to the list. This way it would be enough to just put definition there. This way we
can access all items as list and find elements by searching for definition with specific type.

{% highlight java %}
new Definition(
    Type.MAVEN,
    If.fileExists("pom.xml"),
    Then.delete("target")
),
{% endhighlight %}

[Ok, so far so good. Now let's have a look at big picture]({% post_url 2016-04-29-ot-clean-refactoring-and-dsl-4 %})