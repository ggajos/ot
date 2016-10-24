---
layout: otclean
title: ot-clean, Scan multiple unrelated directories
date: 2016-04-05
categories: ot-clean directories
keywords:
  - ot-clean dirs
  - ot-clean directories
  - ot-clean yml
  - ot-clean cleanup
  - ot-clean tests
---

Since version **0.9** ot-clean is supporting multiple starting directories. It means that you can execute cleaning in single place and clean unrelated directories. For example `.clean.yml` configuration might look like this:

{% highlight yml %}
dirs:
 - c:/Users/ggajos/
 - ../above/parent
{% endhighlight %}

More detailed information will appear in the readme with version 0.10.

### Taking care of exceptional cases

This tool is removing files from the hard drive. That is why test coverage is very important. Coverage for version **0.9** is **95%**. I don’t think that it is necessary to have *100%* but before the final release, it might reach that point. Below you can see also one of the test cases that is checking multiple dirs feature.

{% highlight java %}
@Test
public void cleanupProjectStartingFromDifferentDirectory() {
    final String one = "one";
    final String two = "two";
    final Path root = this.folder.getRoot().toPath();
    this.tempFile(root.resolve("one/todelete/file1.txt"));
    this.tempFile(root.resolve("two/file2.txt"));
    this.writeYml(root.resolve(one), "deletes:\n - todelete");
    this.writeYml(
        root.resolve(two),
        StringUtils.join(
            "dirs:\n - '",
            root.resolve(one).toFile().getAbsolutePath(),
            "'"
        )
    );
    final Mode mode = new Mode(Mode.Arg.D.getLabel());
    MatcherAssert.assertThat(
        root.resolve("one/todelete").toFile().isDirectory(),
        Matchers.is(true)
    );
    new Clean(mode).clean(root.resolve(two));
    MatcherAssert.assertThat(
        root.resolve("one/target").toFile().isDirectory(),
        Matchers.is(false)
    );
}
{% endhighlight %}