---
layout: post
title: Windows backup solution that you already have
description: There are three kinds of people. Ones that backup their data before first data crash, after or never.
date: 2015-12-18
categories: windows backup robocopy
keywords:
  - windows backup approach
  - portable backup setup
  - reliable photo storage
  - robocopy simple usage
  - valuable data backup
  - developer system maintenance
---

There are three kinds of people. Ones that backup their data before first data crash, after or never. In which group you are?

## Why you need to backup?

If your hard drive is corrupted then you need to pick another one and set up the entire environment from scratch. When you delete something permanently, it would be good to get it back easily. Heavy virus infection is also a good reason cleanup system, move few days back in time but have all elements operational without the risk of losing more.

## What you need to backup?

Entire *program files* or system directory is something that do not need the backup for sure. Most applications need full installation procedure anyway. When we narrow down what kind of data we want to secure it is easier to pick right back up option. What I backup:

- documents - self-explanatory,
- photos - yes, if you want to keep your photos for longer than few years you *have to* backup,
- google drive - it is a bit paranoid,
- lib - this is my m solution, you can [read more here]({% post_url 2015-11-01-environment-variables-management %}),
- utils - portable programs or utilities,
- work - all work related.

## How you are going to backup your files?

Full disk image clone is problematic and you will not be able to easily look for something in that backup. I remember my friend did a full disk image and burn it on 12 DVDs. Recovering procedure was so time-consuming that he decided is not worth recovering. Some backups are not recoverable at all because software expired or image has been corrupted during creation. I thought I need very specialized software or RAID 0 to have reliable and easy to use backup solution. Thankfully, I was wrong :).

## Do the robot

Ok, so where is the silver bullet? Since Windows 7 there is built-in command line tool called [*robocopy*](https://technet.microsoft.com/en-us/library/cc733145.aspx){:rel="nofollow"}. It is doing what needs to be done. It is part of the a system so there is no UI overhead (which I found problematic in some solutions). I created simple *bat* file to do all the work for me. Once a week I’m plug in HDD drive and execute the backup operation. Simple.

{% highlight batch %}
rem Robocopy parameters
rem /MIR - Mirror mode; copies subdirectories; deletes destination files and directories that no longer exist in the source.
rem /R:1 - Fail after one retry.
rem /V - Verbose mode.
set args=/MIR /R:1 /V

rem Target backup drive
set backup=O:\backup

rem Mirrors configuration
rem Here you can configure a list of directories
robocopy D:\arch %backup%\ssd %args%
robocopy E:\arch %backup%\hdd %args%
robocopy W:\work %backup%\work %args%
{% endhighlight %}

Be aware that robocopy might require admin privileges on your computer. To ensure and fail fast when executed without privileges. I am using guard at the beginning of file:

{% highlight batch %}
rem DETECT ADMIN PRIVILEGES, IF NOT QUIT
rem source: http://stackoverflow.com/questions/4051883/batch-script-how-to-check-for-admin-rights
NET SESSION >nul 2>&1
IF %ERRORLEVEL% EQU 0 (
    echo Administrator privileges Detected! 
) ELSE (
    echo ######## ########  ########   #######  ########  
    echo ##       ##     ## ##     ## ##     ## ##     ## 
    echo ##       ##     ## ##     ## ##     ## ##     ## 
    echo ######   ########  ########  ##     ## ########  
    echo ##       ##   ##   ##   ##   ##     ## ##   ##   
    echo ##       ##    ##  ##    ##  ##     ## ##    ##  
    echo ######## ##     ## ##     ##  #######  ##     ## 
    echo.
    echo.
    echo ####### ERROR: ADMINISTRATOR PRIVILEGES REQUIRED #########
    echo This script must be run as administrator to work properly!  
    echo ##########################################################
    echo.
    PAUSE
    EXIT /B 1
)
{% endhighlight %}

Enjoy. Have better alternative? Feel free to comment!