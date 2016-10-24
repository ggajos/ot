---
layout: post
title: Configuration files stored in revision control system over external ones.
description: How to handle configuration files. How to make it scale when the team is growing.
date: 2015-11-15
categories: java cloud configuration
keywords:
  - config files backup
  - configuration files sync
  - java properties location
  - java app environment
  - cloud app execution
  - app config maintenance
---

Almost every application depends on the environment where is executed. Database URLs, storage paths, external services or some credentials and codes have to be somehow provided, depending on execution place. I would like to show you two approaches here and explain why the second one is better. 

## Configuration files stored in home directory

It is a tempting vision. You are creating a single configuration file in each server box. Each developer can create this file also on local box in order to override some configuration. Your application during runtime will look inside the config file located in the home directory and you can manage different variables for each machine. It should work, right? Yes, but you have to remember about:

- `backup` - Configuration is very important part of the application. In some cases, it is extremely hard to get config from the sky.
- `sync` - In the case of config error you can quickly fix it on the remote machine and forget about it. If you are doing some kind of backup, you would need to execute it after that change. You might also want to propagate this change to other boxes.
- `sharing` - When amount machines (developer and server ones) are growing, it can be difficult to have easy control over them,
- `permissions` - The only person with server credentials will be able to update some configuration. This means that configuration needs to be maintained by the server administrator. Even if could be easily applied by the developer.
- `history` - Every change will be lost. It might be really helpful to narrow down what changed in the history of the specific file. Especially during some bug research.
- `cloud` - Some cloud providers are not giving you the option to store files in different directories. You would need to figure out something else or stick to the ones that give you this feature.

## Configuration files stored as part of revision control system

There is, however different way of doing this. You can store configuration file along with your source code:

{% highlight batch %}
/src/config/config.properties
/src/config/dev/config.properties
/src/config/dev-john/config.properties
/src/config/dev-peter/config.properties
/src/config/prod/config.properties
{% endhighlight %}

Then you can load your files using specific app environment variable:

{% highlight batch %}
/src/config/config.properties
/src/config/{APP_ENV}/config.properties
{% endhighlight %}

On target machine you would need to setup single environment variable only:

{% highlight batch %}
set APP_ENV=dev
{% endhighlight %}

## Why revision control system is the much better approach?

Let's try to compare points from above. How it is going to change when the configuration is stored in version control.

- `backup` - Source code repository does this for you.
- `sync` - You can pull most up to date config from the repository or commit fix back.
- `sharing` - Everybody who have access to the repository.
- `permissions` - Every developer can edit this, it means that the person responsible for developing feature can prepare also proper configuration.
- `history` - Thanks to source code repository you can track who added what and in what purpose.
- `cloud` - Usually it's easy to setup environment variable even if it is the very restricted environment.