---
layout: post
title: Windows environment variables management.
description: M solution. Managing library installations without relying on installers. Easy switching from one version of library to another.
date: 2015-11-01
categories: windows path management
keywords:
  - windows environment management
  - variables management
  - java libraries versioning
  - java strict control
  - global windows path setup
  - switching between versions
---

A couple of projects at work, few programming languages, and your environment is polluted by different libraries or dependencies. Managing installed ones is always a hassle. It starts simple. Download, unzip, add the `bin` directory to the `PATH`. Everybody knows how the `PATH` configuration dialog looks in Windows (is it Microsoft easter egg?). I believe that installing the external tool in order to manage single variable is madness.

## Why adding binaries directory to the PATH is so awkward?

The problem is very old and yet I couldn't find any practical solution for it. When library becomes popular, developers invest some time to develop the VM (version management) application. For grails, we have `gvm` or `rvm` for Ruby. Why is the additional tool needed when in many cases the only thing that has to be done is adding the bin directory to `PATH` or define some other environment variable like `JAVA_HOME`? Well, for many it is easier to install new version management tool than just put `; C:/a/simple/path` at the end of the line.

## What is the *M* solution?

The name came from `m.bat` file which is actually doing all the magic. For a few years, I was using this as workaround but it appears to be a long-term solution that resolve:

- Managing a library installations without relying on installers.
- Easy switching from one version of the library to another.
- Absolutely no `PATH` variable pollution by default.
- Easy disabling and enabling libraries.
- Portability! Clone environment in no time.

## How to implement your own *M* solution?

First, decide where you would like to hold all your libraries. In the following example, I'm going to use `C:\lib`. Therefore, create `C:\lib\m.bat` file with following content:

{% highlight batch %}
set path_lib=C:\lib
set path_build=
rem <placeholder>
if defined original_path (goto skip) else (goto save)
:save
set original_path=%path%
:skip
set path=%path_build%;%original_path%
{% endhighlight %}

Add `C:\lib` directory to your `PATH` so you can reach it by typing just *M* in the command line. This is the last time you are using windows environment dialog ever. Now let's try to check how it looks like in day to day work. 

## How to setup and manage two versions of grails?

Let’s download two versions of grails library and put them into separate directories.

{% highlight batch %}
C:\lib\grails-2.2.4
C:\lib\grails-2.3.0
{% endhighlight %}

Let’s replace `rem <placeholder>` with following lines

{% highlight batch %}
rem set grails_home=%path_lib%\grails-2.2.4
set grails_home=%path_lib%\grails-2.3.0
set path_build=%path_build%;%path_lib%\%grails_home%\bin
{% endhighlight %}

In order to execute grails-2.3.0 we can open `cmd` and type

{% highlight sh %}
C:\>m
C:\>grails run-app
{% endhighlight %}

In order to switch versions, we just need to switch `rem` prefix.

{% highlight sh %}
set grails_home=%path_lib%\grails-2.2.4
rem set grails_home=%path_lib%\grails-2.3.0
{% endhighlight %}

Batch *M* is going to initialize `PATH` and the different version is going to be loaded. You might notice guard block at the end of the file which is allowing to execute *M* command multiple times and reinitialize all variables. For a very long time, it was looking like an ugly workaround for me. However, it appears to be a very handy way to manage and access all types of binaries. This approach is working quite well even with some database servers or other shell applications.