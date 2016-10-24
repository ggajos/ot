---
layout: otclean
title: ot-clean, Refactoring and cleaning DSL (1/4)
date: 2016-04-19
categories: ot-clean refactoring DSL
keywords:
  - ot-clean domain specific language
  - ot-clean DSL
  - ot-clean refactoring
  - ot-clean fluent
  - ot-clean cleanup
---

I was planning to [implement support for few new frameworks out of the box]({% post_url 2016-04-12-ot-clean-grails-playframework-support %}).
This way some projects will be discovered by default. No need for custom configuration. That is the main purpose
of the tool. I've implemented *Grails 2.x* support but it turns out that I have to write down lots of code in order
to implement another cleaning definition. That was the perfect moment to small refactor as I knew what kind
of usage would be most suitable for me.

### Initial version

This how the code looks like before refactor. In order to implement definition, you had to override cleanable interface
and provide an implementation for three methods: 

* display - how prefix of cleaner will look like in the user console
* match - check if cleaner should act in the specific directory
* clean - perform cleanup

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

That was the first *dirty* version of *Grails 2.x* support.

{% highlight java %}
final class Grails2 implements Cleanable {

    private final Delete delete;

    public Grails2(final Delete cdelete) {
        this.delete = cdelete;
    }

    @Override
    public void clean(final Path path) {
        if (this.match(path)) {
            Yconfig yconf = new Yconfig();
            yconf.setDeletes(Lists.newArrayList("target", "**/*.log"));
            yconf
                .filesToDelete(path)
                .forEach(this.delete::file);
        }
    }

    @Override
    public boolean match(final Path path) {
        boolean success;
        final File file = path
            .resolve("application.properties")
            .toFile();
        try {
            success = file.exists() && FileUtils
                .readFileToString(file)
                .contains("app.grails.version");
        } catch (IOException ioe) {
            Logger.debug(this, "Unable to read %s %[exception]s", file, ioe);
            success = false;
        }
        return success;
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

Ok, let's start refactoring.

### Step 1: Narrow down the scope

First issue that is visible here is that scope is not correct. You can see that `Delete` object is passed
to the `Ctor` only because it is used in `clean` method. This is bad. Why? Because it creates artificial
binding between dependency and the cleaning behaviour. In other words we can move this dependency into
the method definition.

#### Before

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

#### After

{% highlight java %}
final class Maven implements Cleanable {

    @Override
    public void clean(final Delete delete, final Path path) {
        if (this.match(path)) {
            delete.file(path.resolve("target"));
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

As you can see we have no constructor at all now. Is it better? It means that each method within this
class is pure behaviour which is not dependent to anything else than the arguments. This gives us needed
flexibility very soon.

### Step 2: Create once and reuse

We don't have any dependencies so we can create this object once and reuse in other part of application.

{% highlight java %}
Cleanable MAVEN = new Cleanable() {

    @Override
    public void clean(final Delete delete, final Path path) {
        if (this.match(path)) {
            delete.file(path.resolve("target"));
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

};
{% endhighlight %}

This object is created inside `Cleanable` interface so in other parts of application we can access it
via `Cleanable.MAVEN`. So far so good.
[Let's try to do this in more functional way]({% post_url 2016-04-22-ot-clean-refactoring-and-dsl-2 %})