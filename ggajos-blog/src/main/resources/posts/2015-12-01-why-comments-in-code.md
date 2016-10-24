---
layout: post
title: Code comments are priceless when placed on the precious ground.
description: What is the right approach for code comments. Does it make sense to put them everywhere?
date: 2015-12-01
categories: source comments value
keywords:
  - java code comments
  - source value agile
  - agile manifesto comments
  - code comments value
  - comments best practices
  - quality of comments
---

Shall we write code comments at all? Should we force ourselves to write comments to every method/class/variable? How important comments are for the project? What is the value of comments for the project stakeholder?

## How to find what is the right approach?

Let's say that we are creating commons library where the code will be reused in multiple projects. This is the place where many eyes will be looking at and many access variation will happen. This is a place where comments are priceless. Now let's look at service class which is responsible for calculating 20% sales discount of Nike shoes for one specific retailer. We can implement this as self-explanatory code and there is no need for excessive comments. It's actually better to document that using some automated tests. There is no silver bullet for commenting. It's better to have them *more* than less.

## Are there comments with no value?

#### Thank you, Mr. Obvious.

{% highlight java %}
/* A width. */
int width;
{% endhighlight %}

If you think that this comment has no value in the project, you are wrong! This type of comment might be copied over into a different place or become outdated.

{% highlight java %}
/* A width. */
int index;
{% endhighlight %}

Therefore, it might lower quality, produce additional confusion and consume some time. By typing just a few more letters we can get it right: 

{% highlight java %}
/* Width of screen (in pixels). */
int width;
{% endhighlight %}

#### Outdated comments.

{% highlight java %}
// Here we are calculating final price, you better be sure that this is going
// to work without exception, otherwise we're going to fail badly and loose
// our customer!
double finalPrice = 0.0
{% endhighlight %}

Somebody mess up with price calculation formula and didn't remove a comment because it might be valuable. If you need to remove something, remove it. Plus, there is revision control system to track history. Code review is the right moment to get rid of it early.

#### Disabled lines of code.

{% highlight java %}
// Here we are calculating final price, you better be sure that this is going
// to work without exception, otherwise we're going to fail badly and loose
// our customer!
double finalPrice = sumup() + discounts(); // + promotions() + shipping()
{% endhighlight %}

Somebody commented some of the calculations. If we have a luck you might find reason in revision history but this is the worst type of comments. The source code is not a place for leaving the history of requirements.

## What comment is exceptional and precious?

#### Expected results or assertions.

{% highlight java %}
/**
 * <pre>
 * empty(null)      = false
 * empty("")        = false
 * empty(" ")       = true
 * empty("bob")     = true
 * empty("  bob  ") = true
 * </pre>
 */
{% endhighlight %}

This approach is widely used by [Apache libraries](http://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html#splitByCharacterTypeCamelCase(java.lang.String)){:rel="nofollow"}. It is amazingly simple to understand methods behavior and corner cases become obvious.

#### Doomed areas.

{% highlight java %}
// Here we are calculating final price, you better be sure that this is going
// to work without exception, otherwise we're going to fail badly and loose
// our customer!
double finalPrice = sumup() + discounts() + promotions() + shipping();
{% endhighlight %}

This comment acts as a warning for the developer. Better be sure what you are doing and carefully test it out before submitting a mess here. This comment indicates major design flaw in the code, but it makes it visible. It means that somebody spent some time to figure this out. Maybe he is an author of this mess. No matter how ugly described code is, that kind of comments might save others time. 

## Value produced by the comment.

There are good or bad comments but most important is the benefit or value for the project that they are producing. The right approach is going to save your and others time. [What is the best comment in source code you have ever encountered?](http://stackoverflow.com/questions/184618/what-is-the-best-comment-in-source-code-you-have-ever-encountered particularly){:rel="nofollow"} :).