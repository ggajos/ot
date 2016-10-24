---
layout: otclean
title: ot-clean, How to access maven artifact version at runtime?
date: 2016-03-29
categories: ot-clean versioning
keywords:
  - ot-clean maven
  - ot-clean java
  - ot-clean versioning
  - ot-clean runtime
  - ot-clean artifact
---

I wanted to display the version number in help section during application runtime.
It turns out that Maven has very interesting feature called [resource filtering](http://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html){:rel="nofollow"}.

You can add `<resources/>` fragment into the `pom.xml`.

{% highlight text %}
<resources>
   <resource>
       <directory>src/main/resources</directory>
       <filtering>true</filtering>
       <includes>
           <include>**/help.txt</include>
       </includes>
   </resource>
</resources>
{% endhighlight %}

It says that maven should look into `help.txt` file and try to perform replacements
(same as in `pom.xml`). Now we can put `${project.version}` directly inside `help.txt`.

{% highlight text %}
Version - ${project.version}
{% endhighlight %}

Below you can see full `help.txt` file file.

{% highlight text %}
________________________________________________________________________________
   ___ _____     ___ _    ___   _   _  _
  / _ \_   _|__ / __| |  | __| /_\ | \| |
 | (_) || ||___| (__| |__| _| / _ \| .` |
  \___/ |_|     \___|____|___/_/ \_\_|\_|

          Supported arguments

-d      - By default no directories are going to be deleted. You have to provide
          this argument if you really want to delete them.

          About

Version - ${project.version}
Source  - github.com/ggajos/ot-clean
Author  - Grzegorz Gajos / ggajos.com
Sponsor - Open Tangerine / opentangerine.com
________________________________________________________________________________
{% endhighlight %}

By the way, all other maven variables are accessible also.
