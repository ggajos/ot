---
layout: otclean
title: ot-clean, Single clean to clean them all!
description: Single clean to clean them all!
date: 2016-03-01
categories: ot-clean clean-all clean
keywords:
  - ot-clean clean clean-all
  - ot-clean development
  - ot-clean projects
  - ot-clean maven
  - ot-clean java
---

Projects are generating lots of garbage. Compiler output, temporary files, directories. In many cases
`maven clean`, `grails clean` or any other clean task of your build tool is not enough to remove all that stuff which
is bouncing around. In many cases, you don't want to remove that along with clean step but rather occasionally, for example
before making a backup of your data. If those issues sound familiar to you [ot-clean](https://github.com/ggajos/ot-clean)
may help you solve those problems once for all. Read more on the [project page](https://github.com/ggajos/ot-clean).