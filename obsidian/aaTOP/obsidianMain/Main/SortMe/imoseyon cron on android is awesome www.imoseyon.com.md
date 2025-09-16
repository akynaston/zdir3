# imoseyon: cron on android is awesome [www.imoseyon.com]

# [imoseyon](http://www.imoseyon.com/)

## Tuesday, February 8, 2011

### cron on android is awesome

[Cron](http://en.wikipedia.org/wiki/Cron) is a popular time based job scheduler on Unix/Linux, and is super useful as you can virtually run any command or script periodically at certain times or dates.
Even though Android is based on linux, it does not run crond (cron daemon) by default, well at least not on my Droid X.  Fortunately, you can run crond with busybox with a few hacks.  It's not the prettiest hack but it works.  Here's how you do it:

1. Make sure that your busybox supports crond.  Try typing "crond" in Terminal and see what it says.  I run busybox v1.17.1.

* Run your favorite command line tool telnet, Terminal, adb, etc. to run the commands below.
* Remount / and /system rw.
* Create a /etc/passwd. (crond calls getpwnam to search user db)
	**echo "root:x:0:0::/data/cron:/system/bin/bash" > /etc/passwd**
* Create a symlink for /system/bin in /bin.
	**ln -s /system/bin/ /bin**
* Create your crontab file, and call it "root" (I created _/data/cron/root_).  Check the example section in this article to see what a crontab file should look like: <http://en.wikipedia.org/wiki/Cron>
* Set your timezone<http://en.wikipedia.org/wiki/Tz_database>.  I live in California so mine looks like this (apparently the new Olson style timezones do not work):
	**TZ=PST8PDT
	export TZ**
* Run crond:
	**crond -c /data/cron**
* To verify that crond is running succesfully run "_pgrep crond_".  If you get a number (PID) then you know it's running.
Obviously you don't want to do the above steps every time your phone boots, so you want to create an init.d script with the above commands to run at boot, or add the commands to the end of an existing init.d script.  I've added them at the end of my init.d script called /etc/init.d/99imoseyon:

> **\# enable crond
> \# crond calls getpwnam (user database search)
> mount -o remount,rw -t yaffs2 \`grep /system /proc/mounts | cut -d' ' -f1\` /system
> echo "root:x:0:0::/data/cron:/system/bin/bash" > /etc/passwd
> mount -o remount,ro -t yaffs2 \`grep /system /proc/mounts | cut -d' ' -f1\` /system
> \# crond has "/bin/sh" hardcoded
> mount -o remount,rw rootfs /
> ln -s /system/bin/ /bin
> mount -o remount,ro rootfs /****
> \# set timezone
> TZ=PST8PDT
> export TZ
> \# use /data/cron, call the crontab file "root"
> crond -c /data/cron**

So what can we use it for?  Lots of things.  I'm going to start using it to periodically drop page/filesystem caches, back up SMS database nightly, kill memory resident apps hourly, etc.  There are literally hundreds of use cases for android phones. Here's a sample crontab file (backups my init.d script at 8pm every night) at _/data/cron/root_:

> **0 20 \* \* \* cp /system/etc/init.d/99imoseyon /sdcard/data/init.d**

**UPDATE: Added timezone step to the instructions.  Also added a command to verify that crond is running.**

Posted by imoseyon at [3:42 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html)
[Email This](http://www.blogger.com/share-post.g?blogID=3279866164130564941&postID=3295984958544571668&target=email)[BlogThis!](http://www.blogger.com/share-post.g?blogID=3279866164130564941&postID=3295984958544571668&target=blog)[Share to Twitter](http://www.blogger.com/share-post.g?blogID=3279866164130564941&postID=3295984958544571668&target=twitter)[Share to Facebook](http://www.blogger.com/share-post.g?blogID=3279866164130564941&postID=3295984958544571668&target=facebook)

#### 16 comments:

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.2.gif]]](http://www.blogger.com/profile/13170915026327552993)

[Jregruit](http://www.blogger.com/profile/13170915026327552993) said...

For dropping page/filesystem caches I have in my /data/cron/root file
"0 8 \* \* \* su -c 'echo 3 > /proc/sys/vm/drop\_caches;\\"
Do I need to include the:
"bash-3.2# cat /data/cron/root" before it as well?
Thank you for all of these blogs by the way, my droid 2 thanks you too.

[February 9, 2011 3:16 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297293369325#c7935697895039316319)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.jpeg]]](http://www.blogger.com/profile/01455585149930192996)

[imoseyon](http://www.blogger.com/profile/01455585149930192996) said...

Actually, cron already runs as root so you don't need the "su -c" stuff. Try:
0 8 \* \* \* echo 3 > /proc/sys/vm/drop\_caches
Oh, don't include the bash line. In fact let me remove that line to avoid confusion. :)

[February 9, 2011 4:47 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297298870444#c3974838780628253220)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.2.gif]]](http://www.blogger.com/profile/13170915026327552993)

[Jregruit](http://www.blogger.com/profile/13170915026327552993) said...

Sweet :). No more daily reboots. Also just so you know i've credited you for all of your sysctl knowledge on droidforums in the droid 2 and droid X liberty section.

[February 9, 2011 5:11 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297300299650#c5727247556007556256)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.jpeg]]](http://www.blogger.com/profile/01455585149930192996)

[imoseyon](http://www.blogger.com/profile/01455585149930192996) said...

oh awesome. I'm gonna check out your thread. :)

[February 9, 2011 5:42 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297302177676#c5651040088036279435)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.jpeg]]](http://www.blogger.com/profile/01455585149930192996)

[imoseyon](http://www.blogger.com/profile/01455585149930192996) said...

oh also i'd change your cron job to:
sync; echo 3 > /proc/sys/vm/drop\_caches
sync before dropping caches will be more effective.

[February 9, 2011 5:43 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297302221024#c2075038790153161985)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.2.gif]]](http://www.blogger.com/profile/13170915026327552993)

[Jregruit](http://www.blogger.com/profile/13170915026327552993) said...

I'll add this cron schedualer to the thread soon. Its right on top in the D2 liberty section.

[February 9, 2011 5:53 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297302837633#c1780132168691494947)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.2.gif]]](http://www.blogger.com/profile/04336020446179664504)

[Janna](http://www.blogger.com/profile/04336020446179664504) said...

Would there be a command to reboot my phone every night. My phone never gets shut off, except for a reboot every morning to keep things fresh. It would be great if it would do this each night while i was asleep.

[February 11, 2011 10:21 AM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297448508587#c2968781851932447398)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.jpeg]]](http://www.blogger.com/profile/01455585149930192996)

[imoseyon](http://www.blogger.com/profile/01455585149930192996) said...

Yup this should do it (reboots 2am every morning):
0 2 \* \* \* reboot

[February 11, 2011 12:52 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297457540318#c1338872500659998919)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.2.gif]]](http://www.blogger.com/profile/04336020446179664504)

[Janna](http://www.blogger.com/profile/04336020446179664504) said...

Thanks for the fast response, also I was wondering i see (TZ=PST8PDT) up there, should i just use the PST difference from my EST or can i just change it to EST? seams like TZ=EST5EDT but just wanted to check first.

[February 11, 2011 1:56 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297461394115#c6883001989374140013)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.jpeg]]](http://www.blogger.com/profile/01455585149930192996)

[imoseyon](http://www.blogger.com/profile/01455585149930192996) said...

Janna, I only tested pst8pdt but either should work.

[February 11, 2011 3:38 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297467492452#c7813260374284382608)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.2.gif]]](http://www.blogger.com/profile/04987610300480112521)

[Matt Mihalik](http://www.blogger.com/profile/04987610300480112521) said...

I've been experimenting with using cron to perform a nightly reboot, but i'm finding that it doesn't execute while the screen is locked/sleeping. Anyone happen to know if there is a way around this or is it simply a limitation?

[February 17, 2011 10:50 AM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297968630851#c1649653306578040905)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.1.gif]]](http://www.blogger.com/profile/01455585149930192996)

[imoseyon](http://www.blogger.com/profile/01455585149930192996) said...

that's odd matt. All my cron jobs execute while the screen is locked. What does your crontab file look like and what version of busybox?

[February 17, 2011 11:11 AM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297969882384#c7305601664600003166)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.2.gif]]](http://www.blogger.com/profile/04987610300480112521)

[Matt Mihalik](http://www.blogger.com/profile/04987610300480112521) said...

After some more testing I seem to have it working now. I added "-f" to the last line of the 99imoseyon file for the following:
busybox1180 crond -f -c /data/cron
I may have something else installed that was keeping crond from running in the background. I'll have to look into that further. Thanks for the prompt reply.

[February 17, 2011 11:58 AM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297972727744#c4393518230268390107)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.1.gif]]](http://www.blogger.com/profile/01455585149930192996)

[imoseyon](http://www.blogger.com/profile/01455585149930192996) said...

Yeah I suspect there's something else going on. You shouldn't have to run it in the foreground but it won't hurt either. :)

[February 17, 2011 12:20 PM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1297974055705#c5943715751065570980)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.2.gif]]](http://www.blogger.com/profile/11151873328403803786)

[WILDRAT](http://www.blogger.com/profile/11151873328403803786) said...

Imoseyon,
Is there archive someplace with other sample scripts to use with Cron?
Patrick

[April 6, 2011 6:39 AM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1302097156511#c4258008548259100067)

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.1.gif]]](http://www.blogger.com/profile/12948333227905437870)

[Håkan Wiklund](http://www.blogger.com/profile/12948333227905437870) said...

Hmm, can not get this to work on my android. If I start crond with the most verbose loglevel it logs the following:
crond: crond (busybox 1.15.2) started, log level 0
crond: ignoring root
Why is it ignoring my root file?
Here is the file:
\# ls -la /data/cron/root
\-rw------- 1 0 0 31 Sep 7 18:30 /data/cron/root
And here is the content:
\# more /data/cron/root
\* \* \* \* \* /data/local/rsync.sh

[September 7, 2011 11:59 AM](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html?showComment=1315421964794#c6644065255968219086)

#### Post a Comment

<http://www.blogger.com/comment-iframe.g?blogID=3279866164130564941&postID=3295984958544571668&blogspotRpcToken=1389691>

[Newer Post](http://www.imoseyon.com/2011/02/sysctl-and-minfree-tweaks-revisited.html) [Older Post](http://www.imoseyon.com/2011/02/differences-between-rubix-and-liberty.html) [Home](http://www.imoseyon.com/)

Subscribe to: [Post Comments (Atom)](http://www.imoseyon.com/feeds/3295984958544571668/comments/default)

## Followers

## Blog Archive

*   [October](http://www.imoseyon.com/2011_10_01_archive.html) (1)

*   [September](http://www.imoseyon.com/2011_09_01_archive.html) (1)

*   [May](http://www.imoseyon.com/2011_05_01_archive.html) (1)

*   [April](http://www.imoseyon.com/2011_04_01_archive.html) (3)

*   [March](http://www.imoseyon.com/2011_03_01_archive.html) (2)

* [Experimental Mods](http://www.imoseyon.com/2011/02/experimental-mods.html)

* [Soft Reboot (quick reboot)](http://www.imoseyon.com/2011/02/soft-reboot-quick-reboot.html)
* [I Got a ZIP (imoseyon mods)](http://www.imoseyon.com/2011/02/i-got-zip.html)
* [sysctl (and minfree) tweaks revisited](http://www.imoseyon.com/2011/02/sysctl-and-minfree-tweaks-revisited.html)
* [cron on android is awesome](http://www.imoseyon.com/2011/02/cron-on-android-is-awesome.html)
* [Differences between rubix and liberty](http://www.imoseyon.com/2011/02/differences-between-rubix-and-liberty.html)
	*   [January](http://www.imoseyon.com/2011_01_01_archive.html) (12)

## About Me

[![[./_resources/imoseyon_cron_on_android_is_awesome_www.imoseyon.com.resources/unknown_filename.3.jpeg]]](http://www.blogger.com/profile/01455585149930192996)

[imoseyon](http://www.blogger.com/profile/01455585149930192996)
twitter: @imoseyon

[View my complete profile](http://www.blogger.com/profile/01455585149930192996)

|     |     |
| --- | --- |
|     |     |

Simple template. Powered by [Blogger](http://www.blogger.com).
