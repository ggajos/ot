---
layout: otclean
title: ot-clean, Refactoring and cleaning DSL (2/4)
date: 2016-04-22
categories: ot-clean refactoring DSL
keywords:
  - ot-clean domain specific language
  - ot-clean DSL
  - ot-clean refactoring
  - ot-clean fluent
  - ot-clean cleanup
---

In previous post we've removed dependency. Now let's try to use some Java 8 sugar.

### Step 3: Functional approach

We can significantly reduce the amount of code that is needed to define cleanable.

#### Before

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

#### After

{% highlight java %}
Cleanable MAVEN = new Definition(
    "Maven",
    path -> path.resolve("pom.xml").toFile().exists(),
    (delete, path) -> delete.file(path.resolve("target"))
);
{% endhighlight %}

This is still the same code as before but we implemented small sugar object that is able to take care of
all stuff for us. Let's call it `Definition`.

{% highlight java %}
final class Definition implements Cleanable {
    /**
     * Name of the cleaning definition.
     */
    private String name;

    /**
     * Matching behaviour.
     */
    private Function<Path, Boolean> matcher;

    /**
     * Cleaning behaviour.
     */
    private BiConsumer<Delete, Path> cleaner;

    /**
     * Ctor.
     *
     * @param cname Name of the cleaner.
     * @param cmatcher Matching behaviour.
     * @param ccleaner Cleaning behaviour.
     */
    public Definition(
        final String cname,
        final Function<Path, Boolean> cmatcher,
        final BiConsumer<Delete, Path> ccleaner
    ) {
        this.name = cname;
        this.matcher = cmatcher;
        this.cleaner = ccleaner;
    }

    @Override
    public void clean(final Delete delete, final Path path) {
        if(this.match(path)) {
            this.cleaner.accept(delete, path);
        }
    }

    @Override
    public boolean match(final Path path) {
        return this.matcher.apply(path);
    }

    @Override
    public void display(final Path path, final Console console) {
        console.print(
            String.format(
                "[%s]: %s", this.name, path
            )
        );
    }
}
{% endhighlight %}

It looks bit overcomplicated but the best part will start soon.

### Step 4: Functional expressions

Let's extract some functions into the named helpers
 
{% highlight java %}
Cleanable MAVEN = new Definition(
    "Maven",
    If.fileExists("pom.xml"),
    Then.delete("target")
); 
{% endhighlight %}

Below you can find source code of the helpers.

{% highlight java %}
/**
 * Collection of behaviours for matching purposes.
 */
final class If {

    /**
     * Returns true if file exists.
     *
     * @param name Name of the file.
     * @return Matching behaviour.
     */
    static Function<Path, Boolean> fileExists(String name) {
        return path -> path.resolve(name).toFile().exists();
    }

}

/**
 * Collection of behaviours for cleaning purposes.
 */
final class Then {

    /**
     * Executes cleanup using list of paths. RegExps are allowed.
     *
     * @param deletes List of paths.
     * @return Deleting behaviour.
     */
    static BiConsumer<Delete, Path> delete(String... deletes) {
        return (delete, path) -> {
            Yconfig yconf = new Yconfig();
            yconf.setDeletes(Lists.newArrayList(deletes));
            yconf.filesToDelete(path).forEach(delete::file);
        };
    }

}
{% endhighlight %}

[Now let's try to do reduce some code and make it less error prone]({% post_url 2016-04-26-ot-clean-refactoring-and-dsl-3 %})