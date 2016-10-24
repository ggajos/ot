---
layout: otclean
title: ot-clean, YAML node alias surprise 
date: 2016-03-04
categories: ot-clean yaml
keywords:
  - ot-clean yaml
  - ot-clean alias nodes
  - ot-clean config
  - ot-clean escape
  - ot-clean java
---

I’m working on version 0.4 now where I want to add support for wildcard matching. In other words, I would like to remove all log files from the project by simply adding `*.log` pattern. For test purposes I created simple `clean.yml` file:

{% highlight batch %}
deletes:
 - *.log
{% endhighlight %}

and got the nasty exception:
{% highlight batch %}
while scanning an alias
 in 'string', line 2, column 4:
     - *.log
       ^
expected alphabetic or numeric character, but found /
 in 'string', line 2, column 5:
     - *.log
        ^
{% endhighlight %}

Star at the beginning of the line is illegal in YAML. Why? It looks like it supports feature called [Alias Nodes](http://yaml.org/spec/current.html). In order to avoid that you have to use double quotes like this:

{% highlight yaml %}
deletes:
 - “*.log”
{% endhighlight %}

I really don’t like a need of adding double quotes into deletes section. The idea for now is to preprocess YAML a bit and add double quotes before parsing by YAML library. I’ll put this into backlog but I’m really disappointed by the complexity of current YAML format. Functionality like this is making space for new file formats. I would not be surprised when seeing some YAML-Lite version specs in the near future.