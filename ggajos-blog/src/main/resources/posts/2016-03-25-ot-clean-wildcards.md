---
layout: otclean
title: ot-clean, Wildcards
date: 2016-03-25
categories: ot-clean wildcards
keywords:
  - ot-clean wildcards
  - ot-clean java
  - ot-clean search
  - ot-clean cleanup
  - ot-clean log
---

Since version 0.4 **ot-clean** is able to search for and remove specific files using wildcards. Thanks to
[DirectoryScanner](https://maven.apache.org/shared/maven-shared-utils/apidocs/org/apache/maven/shared/utils/io/DirectoryScanner.html){:rel="nofollow"}
I was able to implement wildcard support. I am using this feature to unclutter directories from log files. When I execute `ot-clean` with following YAML:

{% highlight yaml %}
deletes:
 - "**/*.log"
{% endhighlight %}

It is looking for all log files

{% highlight batch %}
[INFO] 19:23:48 clean.Delete: Directory 'D:\work\.postgres\pg_log\postgresql-2016-02-24_104409.log' can be deleted.
[INFO] 19:23:48 clean.Delete: Directory 'D:\work\.postgres\pg_log\postgresql-2016-02-25_000000.log' can be deleted.
[INFO] 19:23:48 clean.Delete: Directory 'D:\work\.postgres\pg_log\postgresql-2016-02-26_000000.log' can be deleted.
[INFO] 19:23:48 clean.Delete: Directory 'D:\work\contend\test.log' can be deleted.
{% endhighlight %}

#### Usage of directory scanner

Thanks to [DirectoryScanner](https://maven.apache.org/shared/maven-shared-utils/apidocs/org/apache/maven/shared/utils/io/DirectoryScanner.html){:rel="nofollow"}
I was able to convert list of input wildcard paths into the stream of files or
directories that should have been deleted.
 
{% highlight java %}
public Stream<Path> filesToDelete(final Path path) {
    final DirectoryScanner scanner = new DirectoryScanner();
    scanner.setIncludes(this.deletes.toArray(new String[this.deletes.size()]));
    scanner.setBasedir(path.toFile());
    scanner.setCaseSensitive(false);
    scanner.scan();
    return Stream.concat(
        Arrays.stream(scanner.getIncludedDirectories()),
        Arrays.stream(scanner.getIncludedFiles())
    ).map(path::resolve);
}
{% endhighlight %}