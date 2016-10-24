---
layout: post
title: Laptop vs desktop, intel i7 4 vs 6 cores.
description: Does it make sense to put more cores or switch back to desktop machine in order to increase productivity and make things faster?
date: 2015-10-15
categories: performance benchmark workstation
keywords:
 - developer workstation benchmark
 - maven compilation time
 - grails compilation time
 - 4 cores vs 6 cores
 - java code compilation
---

You can find many benchmarks online regarding game performance or 3D rendering speed. However, there is very little information about true impact on software developer work and compilation times. Does it make sense to put more cores or switch back to desktop machine? Will it increase productivity and make things faster?

## Testing environment

For testing purposes I used two machines. Benchmark differences are quite big but does it really matter in day to day work?

#### Desktop
 * CPU: Intel Core i7 5820K (6 cores), [12,993 points](http://www.cpubenchmark.net/cpu_lookup.php?cpu=Intel+Core+i7-5820K+%40+3.30GHz&id=2340){:rel="nofollow"} benchmark points
 * MEM: 16GB DDR4 2400Mhz
 * SSD: Samsung 850 Evo 250 GB

#### Laptop
 * CPU: Intel Core i7 2630QM (4 cores), [5,568 points](http://www.cpubenchmark.net/cpu_lookup.php?cpu=Intel+Core+i7-2630QM+%40+2.00GHz&id=873){:rel="nofollow"} benchmark points
 * MEM: 8GB DDR3 1333Mhz
 * SSD: Samsung 840 Pro 256 GB

## Let's build maven project

I picked one of the biggest maven projects on which I'm working on. All artifacts have been cached in `.m2` local repository so there is no internet connection impact on building process. Project contain 36 modules, no tests executed.

*Test device* | *Build time*
Laptop | 76 seconds
Desktop | 30 seconds

I used also *-T=8* parameter in order to compare parallel build performance.

*Test device* | *Build time (8 threads)*
Laptop | 38 seconds
Desktop | 10 seconds

## How fast we can go with Grails?

Grails project I'm working on contain multiple inline modules. I used simple `grails compile` command to execute tests.

*Test device* | *Build time*
Laptop | 367 seconds
Desktop | 192 seconds

## How it feels to work on 6 cores?

Apart from compilation time I must admit that working when something is compiling is huge difference. On laptop machine is hard to make anything else during compilation of big project. Moreover, i7 with full turbo boost is really hot (good for winter only). On desktop on the other hand there is no problem to even run another compilation or work on different killer project. This is probably main benefit of 6 cores in this comparison and benefit for my daily work. I noticed that hardware is actually getting more expensive lately [source](https://pcpartpicker.com/trends/price/cpu/#cpu.intel.lga1155.core-i7.ivy_bridge){:rel="nofollow"} so it might be good moment to setup solid workstation.