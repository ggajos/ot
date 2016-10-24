---
layout: otclean
title: ot-clean, Complete use case
date: 2016-04-08
categories: ot-clean use case
keywords:
  - ot-clean use case
  - ot-clean example
  - ot-clean guide
  - ot-clean help
  - ot-clean info
---

I would like to describe a very simple yet complete cleaning use case. The only prerequisite here is JDK or JRE 1.8+. Imagine that you have your working directory in `/mnt/work`. Applications are producing logs or compilation files that you would like to remove executing a single command.

### Step by step guide

* [Download the latest ot-clean release](https://github.com/ggajos/ot-clean/releases/){:rel="nofollow"}.
* Unpack it to `/mnt/work/clean` directory (for example).
* Go to `/mnt/work/clean`.
* Create `.clean.yml` with the following content:

{% highlight yml %}
deletes:
 - **/*.log
dirs:
 - /mnt/work
 - /home/yourusername
{% endhighlight %}

* Execute `java -jar clean.jar`.
* Check list of files that are going to be removed.
* Execute `java -jar clean.jar -d` in order to remove them.

Now every time you want to perform cleanup. Just go to `/mnt/work/clean` and type:

{% highlight bash %}
java -jar clean.jar -d
{% endhighlight %}

Feel free to put it in some more convenient place if you like.

### What actually happen here?

The ot-clean is scanning your directories and is looking for certain project patterns. If application recognizes that it is maven project for example, then it tries to remove “target” directory. If the application finds `.clean.yml` then is trying to remove all files listed in `deletes` section. If there is `dirs` section then is scanning also specified directories.

### Example ot-clean output

#### Finds maven project automatically

{% highlight yml %}
[Maven]: D:\work\playground
 - Found directory: D:\work\playground\target [2 KB]
{% endhighlight %}

#### Finds directories specified in .clean.yml file

{% highlight yml %}
[.clean.yml]: D:\work\ot-miho\m
 - Found directory: D:\work\ot-miho\m\m-app\target [221 KB]
 - Found directory: D:\work\ot-miho\m\m-web\logs [131 bytes]
 - Found directory: D:\work\ot-miho\m\m-web\project\project\target [12 KB]
 - Found directory: D:\work\ot-miho\m\m-web\project\target [15 MB]
 - Found directory: D:\work\ot-miho\m\m-web\target [7 MB]
{% endhighlight %}

#### Example summary

{% highlight yml %}
Summary: Found 72 element(s) [293 MB]
{% endhighlight %}

### Why bother?

The idea is similar to `.gitignore`. Therefore, if application finds `.clean.yml` file somewhere during scanning it tries to parse it. You can keep custom cleaning files inside your projects. This way you can even share it via code repository if you like.
