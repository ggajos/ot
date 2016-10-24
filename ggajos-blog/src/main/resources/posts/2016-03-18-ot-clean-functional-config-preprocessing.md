---
layout: otclean
title: ot-clean, Functional config file preprocessing
date: 2016-03-18
categories: ot-clean functional
keywords:
  - ot-clean config
  - ot-clean preprocess
  - ot-clean functional
  - ot-clean replace
  - ot-clean java
---

YAML support alias nodes which were
[causing some unnecessary double quotes](http://ggajos.com/ot-clean-yaml-alias-nodes/).
It is not a very big deal but I it is forcing you to type `“**/*.log”` instead of just `**/*.log`.
I implemented simple file preprocessing which handles this case.

### Functional style replace

I had to find specific lines in the input file and produce preprocessed one with replaced values.
That sounds trivial but I wanted to abstract matching and replacing process.
I decided to create new `Replace` class with functional style `replace` method.

{% highlight java %}
/**
* Apply replace transformation on selected line only if matching
* function returned true.
*
* @param matching Closure that returns true if line has been matched.
* @param transformation Closure with line transformation.
* @return Replace object.
*/
public Replace replace(
   final Function<String, Boolean> matching,
   final Function<String, String> transformation
)
{% endhighlight %}

As you can see it is returning Replace object so replacing can be chained.

{% highlight java %}
new Replace(text).replace(...).replace(...).replace(...).output();
{% endhighlight %}

The problem with proper new line character was resolved by `Scanner`. `StrBuilder` from apache commons in case of writing. Plus automatic resource release:

{% highlight java %}
public Replace replace(
   final Function<String, Boolean> matching,
   final Function<String, String> transformation
) {
   final StrBuilder out = new StrBuilder();
   try (Scanner scanner = new Scanner(this.text)) {
       while (scanner.hasNextLine()) {
           final String line = scanner.nextLine();
           if (matching.apply(line)) {
               out.append(transformation.apply(line));
           } else {
               out.append(line);
           }
           out.appendNewLine();
       }
   }
   return new Replace(out.build());
}
{% endhighlight %}

Final preprocessing method:

{% highlight java %}
/**
* Preprocess input file and append double quotes for all paths in the file.
*
* @param file Input file.
* @return Preprocessed file.
* @throws IOException On file error.
*/
private static String preprocess(final File file) throws IOException {
   final String pattern = "- *";
   return new Replace(
       FileUtils.readFileToString(file)
   ).replace(
       line -> line.contains(pattern),
       line -> StringUtils.join(
           StringUtils.replace(line, pattern, "- \"*"),
           "\""
       )
   ).output();
}
{% endhighlight %}