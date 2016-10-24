---
layout: otclean
title: ot-clean, Zero maintenance overhead
date: 2016-03-21
categories: ot-clean maintenance
keywords:
  - ot-clean devops
  - ot-clean plugins
  - ot-clean maven
  - ot-clean maintenance
  - ot-clean java
---

The amount of time I can spend on open source project is limited. That is why maintainability is priority number one for me. If I want to add a new feature I want to focus on new feature only, no distractions. That is why one of the first things I have done was automation of entire project lifecycle. This includes building, high-coverage testing and single command release.

### Jcabi-parent

`jcabi-parent` is a parent pom from [jcabi](http://www.jcabi.com/){:rel="nofollow"} components which simplify getting up to date
versions of popular dependencies. By updating version of parent pom, we can automatically update most of the libraries
used in the project.

### Qulice

[Qulice](http://www.qulice.com/) is Quality control instrument for Java projects. Very restrictive tool that
preconfigures many code quality libraries like:

* Maven dependency analysis
* Maven-enforcer-plugin
* Jslint-maven-plugin
* Maven-duplicate-finder-plugin
* Checkstyle
* PMD
* FindBugs
* Cobertura
* CodeNarc

### Maven-assembly-plugin + jar-with-dependencies

**ot-clean** is a command line tool. In order to prepare release I need to pack everything as a standalone jar file,
add some execution scripts and pack everything together. I was looking for some easy way to do this and it turns out that
those two plugins are handling this quite nicely.

### Github-release-plugin

Finally, when the project is ready I wanted to distribute it easily. This plugin is handling few steps:

* creates new GitHub release using project version,
* creates git tag (using current branch),
* attaches zipped distribution
* attaches project jar file
* attaches source code (zip and tar.gz version)

### Build & Release

In order to build and release my project I just need to execute two lines:

{% highlight batch %}
mvn clean install -Pqulice,cobertura
mvn github-release:release
{% endhighlight %}