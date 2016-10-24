---
layout: otclean
title: ot-clean, Handle any project using YAML format
date: 2016-03-11
categories: ot-clean yaml
keywords:
  - ot-clean java
  - ot-clean yaml
  - ot-clean project
  - ot-clean custom
  - ot-clean config
---

**ot-clean** is able to find and clean up maven project by default (more project
structures might be supported in the future). However, you can clean any project
or directory you want. The process is very simple. Create `.clean.yml` file with
the list of files or directories you want to remove and that’s all.

### Example configuration

See example `.clean.yml` file below which I’m using to clean up `playframework` project.

{% highlight yaml %}
deletes:
 - project-web/target
 - project-web/project/target
 - project-web/project/project/target
 - project-web/logs
 - project-web/.sbtserver
{% endhighlight %}

Note that `yml` file is located above playframework working directory. It’s really up to you if you want to commit that file to the repository or not.