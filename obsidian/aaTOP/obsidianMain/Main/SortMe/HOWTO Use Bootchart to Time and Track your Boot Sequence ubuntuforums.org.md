# HOWTO: Use Bootchart to Time and Track your Boot Sequence [ubuntuforums.org]

[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.23.png]]](http://ubuntuforums.org/index.php)

* [Help](http://ubuntuforums.org/faq.php)

	
.

* [Forum](http://ubuntuforums.org/forum.php)

* [[#|Quick Links]]

* [[#|Forum Community]]
* [[#|Ubuntu Community]]
* [[#|Other Support]]
* [[#|Social Media]]
.* [Register](http://ubuntuforums.org/showthread.php?t=2164051&p=12738892&viewfull=1#post12738892)
* [Activity Page](http://ubuntuforums.org/activity.php)
.

![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/search.png]]

* [Advanced Search](http://ubuntuforums.org/search.php?search_type=1)

* [![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.1.png]]](http://ubuntuforums.org/index.php)

* [Forum](http://ubuntuforums.org/index.php)
* [The Ubuntu Forum Community](http://ubuntuforums.org/forumdisplay.php?f=130)
* [Ubuntu Specialised Discussions](http://ubuntuforums.org/forumdisplay.php?f=423)
* [Tutorials](http://ubuntuforums.org/forumdisplay.php?f=100)
* [Outdated Tutorials & Tips](http://ubuntuforums.org/forumdisplay.php?f=255)
* HOWTO: Use Bootchart to Time and Track your Boot Sequence
.

[[#|Page 1 of 3]] [[#|1]][2](http://ubuntuforums.org/showthread.php?t=868189&page=2)[3](http://ubuntuforums.org/showthread.php?t=868189&page=3)[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.19.png]]](http://ubuntuforums.org/showthread.php?t=868189&page=2)[Last
![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.18.png]]](http://ubuntuforums.org/showthread.php?t=868189&page=3)
Results 1 to 10 of 22

# Thread: [HOWTO: Use Bootchart to Time and Track your Boot Sequence](http://ubuntuforums.org/showthread.php?t=868189)

		###### [[#|Thread Tools]]
	

		###### [[#|Display]]
	

1. July 23rd, 2008 [#1](http://ubuntuforums.org/showthread.php?t=868189&p=5444476#post5444476)
	
	[**mbsullivan**](http://ubuntuforums.org/member.php?u=336475)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**Ubuntu Extra Shot****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.5.png]]
	**
	
	Join Date**:**
	Jul 2007
	Location**:**
	Austin, TX (formerly D.C)
	Beans**:**
	359
	Distro**:**
	Ubuntu 10.04 Lucid Lynx
	
	## HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> **HOWTO: Use Bootchart to Time and Track your Boot Sequence**
	> This simple tutorial will describe how to use bootchart in order to get a graphical representation of the processes which run during your boot process. You will also be able to view the CPU and disk usage during your boot sequence, and will get an exact time (in seconds) of how long it takes for you to boot up.
	> Using bootchart is in no way difficult (and I present no new knowledge here), but it is my hope that this will introduce some in the Ubuntu community to bootcharting and give them an easy introduction to the topic.
	> **Motivation:**
	> There are various reasons that you may want to see what processes start along with your computer. Apart from satisfying your curiosity, getting a visual representation of your boot sequence may help you to fine tune your computer startup, or to diagnose why your computer may not be starting as quickly as you may like. Furthermore, getting a quantitative value for the time it takes to boot your computer will allow you to analyze how much of an improvement you make in the future
	> ![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.20.png]]
	> **Installing Bootchart**
	> In order to track the boot sequence, we will use a program called bootchart. Installing it from the repositories is dead simple:
	> 
	> Code:
	> sudo aptitude install bootchart
	> 
	> ... And it's installed! No further configuration is necessary.
	> **Using Bootchart**
	> Using bootchart may be even easier than installing it... Just reboot! After your machine starts up next time, bootchart will create a graphical representation of the boot sequence (as a .png file), and place it in **/var/log/bootchart**.
	> An example bootchart is attached. It was taken from an unoptimized boot sequence on my Thinkpad x61 running Hardy. You can see at the top that it took 30 seconds to boot completely, and there seem to be some places where optimizing the boot sequence (through parallelism) could possibly lead to a speedier bootup. But, such a thing is best left for another tutorial...
	> **Disable Bootchart**
	> Bootchart will, unless disabled, chart every boot process after you've installed it. This may be overkill for most users, who only want to track their boot sequence occasionally. In order to stop bootchart from charting your boot sequence, simply remove its SysV script from executing after startup:
	> 
	> Code:
	> cd /etc/init.d
	> sudo update-rc.d -f stop-bootchart remove
	>  Removing any system startup links for /etc/init.d/stop-bootchart ...
	>    /etc/rc2.d/S99stop-bootchart
	>    /etc/rc3.d/S99stop-bootchart
	>    /etc/rc4.d/S99stop-bootchart
	>    /etc/rc5.d/S99stop-bootchart
	> 
	> **Enable Bootchart**
	> Re-enabling bootchart is as simple as disabling it. You may either reinstall it (through the repositories), or add it back to runlevels 2345:
	> 
	> Code:
	> cd /etc/init.d
	> sudo update-rc.d stop-bootchart start 99 2 3 4 5 .
	>  Adding system startup for /etc/init.d/stop-bootchart ...
	>    /etc/rc2.d/S99stop-bootchart -> ../init.d/stop-bootchart
	>    /etc/rc3.d/S99stop-bootchart -> ../init.d/stop-bootchart
	>    /etc/rc4.d/S99stop-bootchart -> ../init.d/stop-bootchart
	>    /etc/rc5.d/S99stop-bootchart -> ../init.d/stop-bootchart
	> 
	> That's it! It's so easy! I hope that this tutorial helps some of you to chart your boot process. Let me know if anybody runs into any issues.
	> Mike
	
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.14.png]]
	Attached Thumbnails[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.21.png]]](http://ubuntuforums.org/attachment.php?attachmentid=78716&d=1216846561) 
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=5444476&noquote=1)   **.**
	
2. July 28th, 2008 [#2](http://ubuntuforums.org/showthread.php?t=868189&p=5477236#post5477236)
	
	[**erwall**](http://ubuntuforums.org/member.php?u=210051)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**A Carafe of Ubuntu****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.11.png]]
	**
	
	Join Date**:**
	Dec 2006
	Location**:**
	Maryland
	Beans**:**
	95
	Distro**:**
	Ubuntu 9.10 Karmic Koala
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> Didn't work for me, installed, rebooted, and nothing in /var/log/bootchart
	> Then tried this:
	> 
	> Code:
	> sudo update-rc.d stop-bootchart start 99 2 3 4 5 .
	> 
	> And got this:
	> 
	> Code:
	> System startup links for /etc/init.d/stop-bootchart already exist.
	
	> Last edited by erwall; July 28th, 2008 at 10:48 PM.
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=5477236&noquote=1)   **.**
	
3. July 29th, 2008 [#3](http://ubuntuforums.org/showthread.php?t=868189&p=5477933#post5477933)
	
	[**mbsullivan**](http://ubuntuforums.org/member.php?u=336475)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**Ubuntu Extra Shot****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.5.png]]
	**
	
	Join Date**:**
	Jul 2007
	Location**:**
	Austin, TX (formerly D.C)
	Beans**:**
	359
	Distro**:**
	Ubuntu 10.04 Lucid Lynx
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> Didn't work for me, installed, rebooted, and nothing in /var/log/bootchart
	> 
	> For most people, bootchart should work "out of the box". Otherwise, troubleshooting seems a bit ambiguous.
	> What distro are you running? Also, did you do something non-standard to your java installation? Bootchart depends on java, so if you have weirdness going on with your JRE then it might make something break. What's the output of 'which java' and 'which rsvg'?
	> A quick look around and I came up with [this thread](http://ubuntuforums.org/showthread.php?t=319962). Turns out that bootchart doesn't run when FSCK checks the disc, and certain boot options can stop it from working, too.
	> Perhaps one of these things applies to you? You could also try a good old reinstall:
	> 
	> Code:
	> sudo aptitude reinstall bootchart
	> 
	> Let me know if the problem resolves itself.
	> Mike
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=5477933&noquote=1)   **.**
	
4. July 29th, 2008 [#4](http://ubuntuforums.org/showthread.php?t=868189&p=5478273#post5478273)
	
	[**erwall**](http://ubuntuforums.org/member.php?u=210051)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**A Carafe of Ubuntu****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.11.png]]
	**
	
	Join Date**:**
	Dec 2006
	Location**:**
	Maryland
	Beans**:**
	95
	Distro**:**
	Ubuntu 9.10 Karmic Koala
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> I have what I consider a pretty vanilla install of Hardy. The output of which java and which rsvg show them both in /usr/bin
	> After reading the other post you provided I'm wondering if my having 'startup-manager' installed has anything to do w/it...
	> Thanks for the help so far!
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=5478273&noquote=1)   **.**
	
5. July 29th, 2008 [#5](http://ubuntuforums.org/showthread.php?t=868189&p=5484676#post5484676)
	
	[**mbsullivan**](http://ubuntuforums.org/member.php?u=336475)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**Ubuntu Extra Shot****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.5.png]]
	**
	
	Join Date**:**
	Jul 2007
	Location**:**
	Austin, TX (formerly D.C)
	Beans**:**
	359
	Distro**:**
	Ubuntu 10.04 Lucid Lynx
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> Code:
	> After reading the other post you provided I'm wondering if my having 'startup-manager' installed has anything to do w/it...
	> 
	> You mean [this one](http://packages.ubuntu.com/hardy/startupmanager)? It doesn't sound far-fetched to me that it might interfere with bootchart. I know that it has issues out-of-the-box dealing with display managers other than XDM/KDM/GDM, and there are probably other programs that might interfere with its performance, as well.
	> Let me know if you figure anything out!
	> Mike
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=5484676&noquote=1)   **.**
	
6. July 30th, 2008 [#6](http://ubuntuforums.org/showthread.php?t=868189&p=5485049#post5485049)
	
	[**erwall**](http://ubuntuforums.org/member.php?u=210051)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**A Carafe of Ubuntu****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.11.png]]
	**
	
	Join Date**:**
	Dec 2006
	Location**:**
	Maryland
	Beans**:**
	95
	Distro**:**
	Ubuntu 9.10 Karmic Koala
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> ![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.7.png]]
	> Originally Posted by **mbsullivan**[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.8.png]]](http://ubuntuforums.org/showthread.php?p=5484676#post5484676)
	> 
	> Code:
	> After reading the other post you provided I'm wondering if my having 'startup-manager' installed has anything to do w/it...
	> 
	> You mean [this one](http://packages.ubuntu.com/hardy/startupmanager)? It doesn't sound far-fetched to me that it might interfere with bootchart. I know that it has issues out-of-the-box dealing with display managers other than XDM/KDM/GDM, and there are probably other programs that might interfere with its performance, as well.
	> Let me know if you figure anything out!
	> Mike
	> 
	> Yep, that's it. I'll report back if I figure anything out.
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=5485049&noquote=1)   **.**
	
7. August 1st, 2008 [#7](http://ubuntuforums.org/showthread.php?t=868189&p=5503181#post5503181)
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.13.png]]](http://ubuntuforums.org/member.php?u=204351)
	
	[**run1206**](http://ubuntuforums.org/member.php?u=204351)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**A Carafe of Ubuntu****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.2.png]]
	**
	[[#|![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.9.png]]]][[#|![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.4.png]]]]
	
	Join Date**:**
	Dec 2006
	Location**:**
	Perth Amboy, NJ
	Beans**:**
	141
	Distro**:**
	Ubuntu 9.04 Jaunty Jackalope
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> sorry to ask but does anyone know where the config files are for bootchart
	> i'm trying to put the patch in that does bootchart after the GNOME startup
	> <http://www.gnome.org/~lcolitti/gnome-startup/analysis/>
	> (i've checked /etc and i don't have bootchartd.conf like the patch says)
	> any help is appreciated, thanks a bunch.
	
	> Welcome to the world of Open Source!!!
	> ![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.17.png]]
	> [Linux User #471120](http://counter.li.org/) [Ubuntu User #21997](http://ubuntucounter.geekosophical.net/index.php)
	> Jaunty Jackalope 9.04
	> ![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.17.png]]
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=5503181&noquote=1)   **.**
	
8. November 13th, 2008 [#8](http://ubuntuforums.org/showthread.php?t=868189&p=6170262#post6170262)
	
	[**mbsullivan**](http://ubuntuforums.org/member.php?u=336475)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**Ubuntu Extra Shot****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.5.png]]
	**
	
	Join Date**:**
	Jul 2007
	Location**:**
	Austin, TX (formerly D.C)
	Beans**:**
	359
	Distro**:**
	Ubuntu 10.04 Lucid Lynx
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> (i've checked /etc and i don't have bootchartd.conf like the patch says)
	> 
	> You're right, the Ubuntu packages do not install a configuration file for bootchart. I'm not sure of any fix (there may be one) other than going and installing it some other way.
	> The Debian packages are more updated, and might (note: I don't know) work out for you. I've attached the current version from Debian to this post. You can try it out by downloading it and installing it:
	> 
	> Code:
	> sudo dpkg -i \[name\].deb
	> 
	> Uninstall the Ubuntu package first, if you want to try it.
	> Mike
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=6170262&noquote=1)   **.**
	
9. January 31st, 2009 [#9](http://ubuntuforums.org/showthread.php?t=868189&p=6651302#post6651302)
	
	[**jmckean**](http://ubuntuforums.org/member.php?u=445613)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**Spilled the Beans****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.6.png]]
	**
	
	Join Date**:**
	Dec 2007
	Beans**:**
	16
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> OK, I have bootchart running under eeeUbuntu (8.04 with netremix and a few hardware tweaks). But it reports much faster boot than I actually experience. It says 22 seconds, I say 45 seconds to login prompt (gdm).
	> I thought is was measuring to login prompt. Am I wrong?
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=6651302&noquote=1)   **.**
	
10. January 31st, 2009 [#10](http://ubuntuforums.org/showthread.php?t=868189&p=6652182#post6652182)
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.13.png]]](http://ubuntuforums.org/member.php?u=204351)
	
	[**run1206**](http://ubuntuforums.org/member.php?u=204351)
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.22.png]]
	**A Carafe of Ubuntu****
	![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.2.png]]
	**
	[[#|![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.9.png]]]][[#|![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.4.png]]]]
	
	Join Date**:**
	Dec 2006
	Location**:**
	Perth Amboy, NJ
	Beans**:**
	141
	Distro**:**
	Ubuntu 9.04 Jaunty Jackalope
	
	## Re: HOWTO: Use Bootchart to Time and Track your Boot Sequence
	
	> nope, bootchart only checks up to where you finish with the startup processes. There is a patch where you can have bootchart check up to the login promapt and including the gdm login process up to where your main screen comes up. Look up boootchart patch either here or in Google
	
	> Welcome to the world of Open Source!!!
	> ![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.17.png]]
	> [Linux User #471120](http://counter.li.org/) [Ubuntu User #21997](http://ubuntucounter.geekosophical.net/index.php)
	> Jaunty Jackalope 9.04
	> ![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.17.png]]
	
	[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.png]]
	Adv Reply](http://ubuntuforums.org/newreply.php?p=6652182&noquote=1)   **.**
	

[[#|Page 1 of 3]] [[#|1]][2](http://ubuntuforums.org/showthread.php?t=868189&page=2)[3](http://ubuntuforums.org/showthread.php?t=868189&page=3)[![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.19.png]]](http://ubuntuforums.org/showthread.php?t=868189&page=2)[Last
![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.18.png]]](http://ubuntuforums.org/showthread.php?t=868189&page=3)

Quick Navigation [Outdated Tutorials & Tips](http://ubuntuforums.org/showthread.php?t=868189) [Top](http://ubuntuforums.org/showthread.php?t=868189#top)

**«** [Previous Thread](http://ubuntuforums.org/showthread.php?t=868189&goto=nextoldest) | [Next Thread](http://ubuntuforums.org/showthread.php?t=868189&goto=nextnewest) **»**

#### Bookmarks

* [![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.16.png]]](http://digg.com/submit?phrase=2&url=http%3A%2F%2Fubuntuforums.org%2Fshowthread.php%3Ft%3D868189&title=HOWTO%3A+Use+Bootchart+to+Time+and+Track+your+Boot+Sequence)[Digg](http://digg.com/submit?phrase=2&url=http%3A%2F%2Fubuntuforums.org%2Fshowthread.php%3Ft%3D868189&title=HOWTO%3A+Use+Bootchart+to+Time+and+Track+your+Boot+Sequence)

* [![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.12.png]]](http://del.icio.us/post?url=http%3A%2F%2Fubuntuforums.org%2Fshowthread.php%3Ft%3D868189&title=HOWTO%3A+Use+Bootchart+to+Time+and+Track+your+Boot+Sequence)[del.icio.us](http://del.icio.us/post?url=http%3A%2F%2Fubuntuforums.org%2Fshowthread.php%3Ft%3D868189&title=HOWTO%3A+Use+Bootchart+to+Time+and+Track+your+Boot+Sequence)
* [![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.10.png]]](http://www.stumbleupon.com/submit?url=http%3A%2F%2Fubuntuforums.org%2Fshowthread.php%3Ft%3D868189&title=HOWTO%3A+Use+Bootchart+to+Time+and+Track+your+Boot+Sequence)[StumbleUpon](http://www.stumbleupon.com/submit?url=http%3A%2F%2Fubuntuforums.org%2Fshowthread.php%3Ft%3D868189&title=HOWTO%3A+Use+Bootchart+to+Time+and+Track+your+Boot+Sequence)
* [![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.3.png]]](http://www.google.com/bookmarks/mark?op=edit&output=popup&bkmk=http%3A%2F%2Fubuntuforums.org%2Fshowthread.php%3Ft%3D868189&title=HOWTO%3A+Use+Bootchart+to+Time+and+Track+your+Boot+Sequence)[Google](http://www.google.com/bookmarks/mark?op=edit&output=popup&bkmk=http%3A%2F%2Fubuntuforums.org%2Fshowthread.php%3Ft%3D868189&title=HOWTO%3A+Use+Bootchart+to+Time+and+Track+your+Boot+Sequence)
.

#### [![[./_resources/HOWTO_Use_Bootchart_to_Time_and_Track_your_Boot_Sequence_ubuntuforums.org.resources/resource.15.png]]](http://ubuntuforums.org/showthread.php?t=868189#top)Posting Permissions

* You **may not** post new threads

* You **may not** post replies
* You **may not** post attachments
* You **may not** edit your posts

* [BB code](http://ubuntuforums.org/misc.php?do=bbcode) is **On**

* [Smilies](http://ubuntuforums.org/misc.php?do=showsmilies) are **On**
* [IMG](http://ubuntuforums.org/misc.php?do=bbcode#imgcode) code is **On**
* [VIDEO](http://ubuntuforums.org/misc.php?do=bbcode#videocode) code is **Off**
* HTML code is **Off**

[Ubuntu Forums Code of Conduct](http://ubuntuforums.org/misc.php?do=showrules)

.

* [Ubuntu Forums](http://ubuntuforums.org/)

* [Archive](http://ubuntuforums.org/archive/index.php)
* [Top](http://ubuntuforums.org/showthread.php?t=868189#top)
.

All times are GMT +1. The time now is 01:13 AM.
vBulletin ©2000 - 2014, Jelsoft Enterprises Ltd. Ubuntu Logo, Ubuntu and Canonical © Canonical Ltd. Tango Icons © Tango Desktop Project.
