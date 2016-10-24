---
layout: otclean
title: ot-clean, Grails 2.x/3.x, PlayFramework 2.x support
date: 2016-04-12
categories: ot-clean cleaners
keywords:
  - ot-clean cleaners
  - ot-clean grails
  - ot-clean playframework
  - ot-clean support
  - ot-clean auto
---

For version 0.11 I am planning to add Grails and PlayFramework project cleanup support out of the box.

#### Grails 2.x support

In order to recognize Grails 2.x structure I am planning to perform simple checks:

 * check if directory contains `application.properties` file
 * check if `application.properties` contains `app.grails.version` string
 * if yes delete: `target/`, `*.log`

#### Grails 3.x support

In order to recognize Grails 3.x:

 * check if directory contains `build.gradle` file
 * check if `build.grade` contains `apply plugin:.*org.grails` (ignore whitespace)
 * if yes delete: `build/`, `*.log`

#### PlayFramework 2.x support

In order to recognize PlayFramework:

 * check if directory contains `build.sbt` file
 * check if `build.sbt` file contains `enablePlugins(PlayJava)`
 * if yes: delete `logs/`, `target/`, `project/target`, `project/project/target`, `.sbtserver`, `*.log`
