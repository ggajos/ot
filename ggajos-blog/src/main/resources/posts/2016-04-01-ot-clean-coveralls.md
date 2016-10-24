---
layout: otclean
title: ot-clean, Coveralls integration and code cleanup
date: 2016-04-01
categories: ot-clean coveralls
keywords:
  - ot-clean coverage
  - ot-clean java
  - ot-clean coveralls
  - ot-clean cleanup
  - ot-clean artifact
---

I had hard time integrating Cobertura and coveralls. In the end it turns out
it’s just not working and I’m continuously fighting with errors. Moreover,
Cobertura is really crashing a lot in JDK 8. I found however very interesting and
active test coverage project called Jacoco. Below you can find coverage profile
I am using in order to produce coverage report and send it to [coveralls.io](https://coveralls.io/){:rel="nofollow"}.

{% highlight xml %}
<profile>
   <id>coverage</id>
   <build>
       <plugins>
           <plugin>
               <groupId>org.jacoco</groupId>
               <artifactId>jacoco-maven-plugin</artifactId>
               <version>0.7.6.201602180812</version>
               <executions>
                   <execution>
                       <id>default-prepare-agent</id>
                       <goals>
                           <goal>prepare-agent</goal>
                       </goals>
                   </execution>
                   <execution>
                       <id>default-report</id>
                       <phase>prepare-package</phase>
                       <goals>
                           <goal>report</goal>
                       </goals>
                   </execution>
               </executions>
           </plugin>
           <plugin>
               <groupId>org.eluder.coveralls</groupId>
               <artifactId>coveralls-maven-plugin</artifactId>
               <version>4.1.0</version>
               <configuration>
                   <timestampFormat>yyyy-MM-dd'T'HH:mm:ss</timestampFormat>
               </configuration>
           </plugin>
       </plugins>
   </build>
</profile>
{% endhighlight %}

I am using Travis for building purposes. Below you can find configuration file:

{% highlight yaml %}
language: java
jdk:
 - oraclejdk8
cache:
 directories:
   - $HOME/.m2
script:
 - mvn clean install -Pqulice,coverage coveralls:report --batch-mode --errors
{% endhighlight %}

### Recurrence `-r` parameter is gone
One small update regarding version 0.8. It turns out that I’ve never wanted to use
cleanup only on the current directory. Therefore `-r` parameter has been removed in
`0.8` and now by default application is looking for all nested directories.