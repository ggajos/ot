---
layout: otclean
title: ot-clean, Cascade and arguments
date: 2016-03-15
categories: ot-clean cascade
keywords:
  - ot-clean cascade
  - ot-clean arguments
  - ot-clean recurrence
  - ot-clean config
  - ot-clean java
---

The **ot-clean** is not deleting any files by default. It means, when you run **ot-clean**, it is going to list files that eventually might go away. If you’re happy with the list of directories to remove, you can use `-d` switch to actually remove those files:

{% highlight batch %}
ot-clean -d
{% endhighlight %}

By default **ot-clean** command is trying to clean only a project in the current directory.
You can traverse all nested directories (look for all nested `.clean.yml`) files by simply providing `-r` switch.
This behaves similarly to the `.gitignore`. It is especially helpful when you have
multiple projects and want to clean up all of them at once.

In other words to make your work directory clean again, you can run:
{% highlight batch %}
ot-clean -r -d
{% endhighlight %}
… and let the magic happen for you.