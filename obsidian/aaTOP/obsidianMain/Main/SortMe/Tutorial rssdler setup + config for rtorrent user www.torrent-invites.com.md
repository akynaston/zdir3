# [Tutorial] rssdler setup + config for rtorrent user [www.torrent-invites.com]

* ![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.5.png]]
* ![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.6.png]]
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.13.png]]
	

	Remember Me?
	

.

[![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.10.png]]](http://www.torrent-invites.com/forum.php?s=cb64a6b81788ed2501f7da69b3beaba4)

[![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/seedad.jpg]]](http://www.seedboxes.cc/)
To remove ads [Register](http://www.torrent-invites.com/register.php). Inquire about [advertising here](http://www.torrent-invites.com/misc.php?do=form&fid=29).

.

[![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.1.png]]](http://www.torrent-invites.com/register.php)

We are the best invite forum on the internet! Here you will find free invites, free seedboxes, free bonuses, and much more. Our members know the true meaning of sharing and have created a truly global bittorent community! Our site has the most up to date information on all private trackers and our members will guide you and introduce you to this truly secretive and enlightened club. Ready to get started? Register now!

.

* [Forum](http://www.torrent-invites.com/forum.php?s=cb64a6b81788ed2501f7da69b3beaba4)

* [What's New?](http://www.torrent-invites.com/activity.php?s=cb64a6b81788ed2501f7da69b3beaba4)
* [Articles](http://www.torrent-invites.com/content.php?s=cb64a6b81788ed2501f7da69b3beaba4)
* [Blogs](http://www.torrent-invites.com/blog.php?s=cb64a6b81788ed2501f7da69b3beaba4)
* [Support Us](http://www.torrent-invites.com/payments.php)
* [IRC](http://www.torrent-invites.com/chat_irc.php?s=cb64a6b81788ed2501f7da69b3beaba4)
.

* [Forum](http://www.torrent-invites.com/forum.php?s=cb64a6b81788ed2501f7da69b3beaba4)

* ![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.12.png]]
* [Seedboxes](http://www.torrent-invites.com/forumdisplay.php?f=146&s=cb64a6b81788ed2501f7da69b3beaba4)
* ![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.12.png]]
* [Seedbox Tutorials](http://www.torrent-invites.com/forumdisplay.php?f=104&s=cb64a6b81788ed2501f7da69b3beaba4)
* ![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.12.png]]
* \[Tutorial\] rssdler setup + config for rtorrent user
.

## [User Tag List](http://www.torrent-invites.com/usertag.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=list&action=tags&t=25858)

Results 1 to 2 of 2

# Thread: [Tutorial rssdler setup + config for rtorrent user](http://www.torrent-invites.com/showthread.php?t=25858&s=cb64a6b81788ed2501f7da69b3beaba4)

		###### [[#|Thread Tools]]
	

		###### [[#|Display]]
	

1. May 31st, 2009, 06:18 PM [#1](http://www.torrent-invites.com/showthread.php?t=25858&s=cb64a6b81788ed2501f7da69b3beaba4&p=247999&viewfull=1#post247999)
	
	[**Scorpion**](http://www.torrent-invites.com/member.php?u=1009&s=cb64a6b81788ed2501f7da69b3beaba4)
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.11.png]]
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.8.png]]
	
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.4.png]]
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.4.png]]
	
	Join Date:
	Jul 2008
	Location:
	Portugal
	Posts:
	169
	
	## 
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/icon1.png]]
	\[Tutorial\] rssdler setup + config for rtorrent user
	
	> This lil guide is made to help users install rssdler on their rtorrent seedbox running on debian.
	> Official install instructions
	> [http://code.google.com/p/rssdler/wiki/InstallInstructions](https://scenelife.net/redir.php?url=http://code.google.com/p/rssdler/wiki/InstallInstructions)
	> short version:
	> **apt-get install python
	> apt-get install python-feedparser
	> apt-get install python-mechanize**
	> Install RSSDler:
	> make a directory in your home folder to keep all your rssdler related files (not necessarily your downloads) in, preferably .rssdler (the defaults assume that is what it will be).
	> Download the rssdler.tar.gz and unpack it:
	> **wget [http://rssdler.googlecode.com/files/rssdler-0.4.0a.tar.gz](https://scenelife.net/redir.php?url=http://rssdler.googlecode.com/files/rssdler-0.4.0a.tar.gz)
	> tar xvzf rssdler-X.Y.Z.tar.gz
	> cd rssdlerXYZ
	> sudo python setup.py install**
	> You have now installed all the requirements for RSSDler as well as RSSDler itself
	> You can run it with just "rssdler -r" anywhere, and it will find your config file at ~/.rssdler/config.txt, IF you installed it there. Otherwise, specify the configuration file with -c.
	> Take a look at the HelpMessage and CommentedConfig to help in the creation of a suitable configuration file
	> [http://code.google.com/p/rssdler/wiki/HelpMessage](https://scenelife.net/redir.php?url=http://code.google.com/p/rssdler/wiki/HelpMessage)
	> Follow the link above and read it all if you encounter problems. I'm only adding the command line options.
	> Command Line Options:
	> \--config/-c can be used with all the options except --comment-config, --help
	> \--comment-config: Prints a commented config file to stdout
	> \--help/-h: print the short help message (command line options)
	> \--full-help/-f: print the complete help message (quite long)
	> \--run/-r: run according to the configuration file
	> \--runonce/-o: run only once then exit
	> \--daemon/-d: run in the background (Unix-like only)
	> \--kill/-k: kill the currently running instance (may not work on Windows)
	> \--config/-c: specify a config file (default /home/james/.rssdler/config.txt).
	> \--list-failed: Will list the urls of all the failed downloads
	> \--purge-failed: Use to clear the failed download queue.
	> Use when you have a download stuck (perhaps removed from the site or
	> wrong url in RSS feed) and you no longer care about RSSDler attempting
	> to grab it. Will be appended to the saved download list to prevent
	> readdition to the failed queue.
	> Should be used alone or with -c/--config. Exits after completion.
	> \--list-saved: Will list everything that has been registered as downloaded.
	> \--purge-saved: Clear the list of saved downloads, not stored anywhere.
	> \--state/-s: Will return the process ID if another instance is running with.
	> Otherwise exits with return code 1
	> Note for Windows: will return the pid found in daemonInfo,
	> regardless of whether it is currently running.
	> \--set-default-config: \[No longer available. Deprecated\]
	> [http://code.google.com/p/rssdler/wiki/CommentedConfig](https://scenelife.net/redir.php?url=http://code.google.com/p/rssdler/wiki/CommentedConfig)
	> Since the commented config is rather long, and boring (if you're looking for a more specific config, then by all means read/edit it), and we want to get rssdler to work asap, then have a look at an example config i'm using for a couple of sites. Copy & paste this in notepad (no Wordpad or Word, as they add characters that fuck up the config).
	> 
	> \[global\]
	> downloadDir = /home/userdir/watch/
	> workingDir = /home/userdir/.rssdler/
	> minSize = 0
	> log = 1
	> logFile = /home/userdir/rssdlerlog.txt
	> scanMins = 5
	> sleepTime = 5
	> runOnce = false
	> urllib = True
	> ###################
	> \[site1\]
	> link =http://site1.com/rss.php?feed=dl&cat=7,55,4&passkey="yourpasskey"
	> maxSize = 0
	> minSize = 120
	> nosave = False
	> regextrue = (prison.break|heroes|gossip.girl|greek|south.park| stargate.atlantis|the.shield|my.name.is.earl|small ville|fringe|house|dexter|californication|family.g uy|entourage|chuck|the.simpsons|lost|one.tree.hill |without.a.trace|max.payne|the.dark.knight|saw|qua ntum.of.solace|transporter|eagle.eye|crank|x-men|vicky.christina.barcelona|night.at.the.museum)
	> regexfalse = (HEBSUB|D0|720p|x264|STV|R5|CAM|TS|hospital|specia l.forces)
	> \[site2\]
	> link =http://site2.com/rss.php?feed=dl&cat=7,11&passkey="yourpasskey"
	> maxSize = 0
	> minSize = 10
	> nosave = False
	> regextrue = (prison.break|heroes|gossip.girl|greek|south.park| stargate.atlantis|the.shield|my.name.is.earl|small ville|fringe|house|dexter|californication|family.g uy|entourage|chuck|the.simpsons|lost|one.tree.hill |without.a.trace|max.payne|the.dark.knight|saw|qua ntum.of.solace|transporter|eagle.eye|crank|x-men|vicky.christina.barcelona|night.at.the.museum)
	> regexfalse = (HEBSUB|D0|720p|x264|STV|R5|CAM|TS|hospital|specia l.forces)
	> \[site3\]
	> link =http://site3.com/rss.php?feed=dl&cat=13&passkey="yourpasskey"
	> maxSize = 0
	> minSize = 10
	> nosave = False
	> regextrue = (-BF|-EUPHORiC|-WiTF|-kW|-QB|-LOYALTY|-ATRium|-RACEME|-320|-iDC|-MK2|-WEM|-HQEM|-CBR|-Scratch|-DGN|-SDS|-dh|-MPX|-BSiDE|-tronik|-1KING|-IMT|-SOULFUL|-MTC|-WRE|-MTD|-TCLUB|-eMF|-OBC|-DFM|-WAV|-kiNky|-XTC|-USF|-KTMP3|-XXL|-MNS|-G4iN|-TGX|-wAx|-TSP|-WHOA|digweed|transitions|global.underground|sasha)
	> regexfalse = (RADIO|FM|SAT|LINE|LIVE|DVD|DAB|MP3-01|MP3-02|MP3-03|MP3-04|MP3-05|MP3-06|MP3-07|MP3-08|MP3-09|MP3-10|MP3-11|MP3-12|-SCC|READDESCRIPTION|PACK)
	> 
	> **You need to edit a few lines:**
	> downloadDir = /home/userdir/watch/ <-- change path so it points to your rtorrent watch folder
	> workingDir = /home/userdir/.rssdler/ <-- change path to where you installed rssdler
	> logFile = /home/userdir/rssdlerlog.txt <-- create the file, and change the path to the exact location
	> \[site1\]
	> link =http://site1.com/rss.php?feed=dl&cat=7,55,4&passkey="yourpasskey" <-- generate your RSS feed on the torrent site with the categories you want, and add your passkey if it isn't generated with the feed
	> \[site2\]
	> link =http://site2.com/rss.php?feed=dl&cat=7,11&passkey="yourpasskey" <-- generate your RSS feed on the torrent site with the categories you want, and add your passkey if it isn't generated with the feed
	> \[site3\]
	> link =http://site3.com/rss.php?feed=dl&cat=13&passkey="yourpasskey" <-- generate your RSS feed on the torrent site with the categories you want, and add your passkey if it isn't generated with the feed
	> change regextrue (the things you want to download/allow) and regexfalse (the things you don't want/skip)
	> IF you editted everything mentionned above, save the file, go back to the command line and type
	> **rssdler -d** (daemon stile, runs continuesly at the interval stated in config.txt)
	> Hope this helps getting your rssdler up and running in a minimum amount of time.
	> **Note: Those tutorial, was been taked from ScL forums.**
	
	[![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.png]]
	Reply With Quote](http://www.torrent-invites.com/newreply.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=newreply&p=247999) **.**
	

To remove ads become [VIP](http://www.torrent-invites.com/content/become-v-i-p-member-today-354/). Inquire about [advertising here](http://www.torrent-invites.com/misc.php?do=form&fid=29).
3. August 4th, 2011, 11:40 PM [#2](http://www.torrent-invites.com/showthread.php?t=25858&s=cb64a6b81788ed2501f7da69b3beaba4&p=1040205&viewfull=1#post1040205)
	
	[**jsaffar**](http://www.torrent-invites.com/member.php?u=88025&s=cb64a6b81788ed2501f7da69b3beaba4)
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.11.png]]
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.7.png]]
	
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.4.png]]
	
	Join Date:
	Oct 2010
	Posts:
	23
	
	## 
	![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/icon1.png]]
	Re: \[Tutorial\] rssdler setup + config for rtorrent user
	
	> nice tutorial , this tool is very helpful especially when autodl-irssi is not available, i followed the tutorial, worked like charm thanx
	> but is there any way to make separate filters instead of match or doesn't match?
	> thank you
	
	[![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.png]]
	Reply With Quote](http://www.torrent-invites.com/newreply.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=newreply&p=1040205) **.**
	

**«** [Previous Thread](http://www.torrent-invites.com/showthread.php?t=25858&s=cb64a6b81788ed2501f7da69b3beaba4&goto=nextoldest) | [Next Thread](http://www.torrent-invites.com/showthread.php?t=25858&s=cb64a6b81788ed2501f7da69b3beaba4&goto=nextnewest) **»**

#### Similar Threads

1. ###### [Advice for rtorrent.rc config](http://www.torrent-invites.com/showthread.php?t=172374&s=cb64a6b81788ed2501f7da69b3beaba4)
	
	By Sefex in forum Help
	Replies: 7
	Last Post: October 21st, 2011, 04:46 PM
	
	.

		###### [How to Setup & Config vnc4server for Linux Debian or Ubuntu](http://www.torrent-invites.com/showthread.php?t=49945&s=cb64a6b81788ed2501f7da69b3beaba4)
	
	By Issa in forum Operating Systems
	Replies: 11
	Last Post: January 27th, 2010, 04:43 AM
	
	.
		###### [Linux-Block Internet access for specific users...](http://www.torrent-invites.com/showthread.php?t=18719&s=cb64a6b81788ed2501f7da69b3beaba4)
	
	By rahman in forum Operating Systems
	Replies: 0
	Last Post: April 4th, 2009, 01:35 AM
	
	.
		###### [Italy announces "3-strike" program for P2P users](http://www.torrent-invites.com/showthread.php?t=11509&s=cb64a6b81788ed2501f7da69b3beaba4)
	
	By Ikyn in forum BitTorrent News
	Replies: 10
	Last Post: April 1st, 2009, 06:25 AM
	
	.

#### Tags for this Thread

[config](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=config), [doesn](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=doesn), [helpful](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=helpful), [ice](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=ice), [ins](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=ins), [irssi](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=irssi), [make](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=make), [match](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=match), [nice](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=nice), [ot](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=ot), [rssdler](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=rssdler), [rtorrent](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=rtorrent), [se](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=se), [separate](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=separate), [setup](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=setup), [show](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=show), [tha](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=tha), [tool](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=tool), [tu](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=tu), [Tutorial](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=Tutorial), [ubuntu](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=ubuntu), [user](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=user), [yo](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4&tag=yo)

[View Tag Cloud](http://www.torrent-invites.com/tags.php?s=cb64a6b81788ed2501f7da69b3beaba4)

#### [![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.3.png]]](http://www.torrent-invites.com/showthread.php?t=25858#top)Posting Permissions

* You **may not** post new threads

* You **may not** post replies
* You **may not** post attachments
* You **may not** edit your posts

* [BB code](http://www.torrent-invites.com/misc.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=bbcode) is **On**

* [Smilies](http://www.torrent-invites.com/misc.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=showsmilies) are **On**
* [IMG](http://www.torrent-invites.com/misc.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=bbcode#imgcode) code is **On**
* [VIDEO](http://www.torrent-invites.com/misc.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=bbcode#videocode) code is **On**
* HTML code is **Off**

[Forum Rules](http://www.torrent-invites.com/misc.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=showrules)

.

![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.2.png]]

Copyright © 2012 Torrent-Invites.com
All rights reserved.
All times are GMT -4. The time now is 12:50 PM.
Powered by vBulletin®
Copyright © 2012 vBulletin Solutions, Inc. All rights reserved.

![[./_resources/Tutorial_rssdler_setup_+_config_for_rtorrent_user_www.torrent-invites.com.resources/resource.9.gif]]

* Affiliates

* [Torrent Forums](http://torrentforums.com/)
* [Tracker Invites](http://trackerinvites.org/)
* [Sceper](http://sceper.eu/)
* [Seedbox](http://www.torrent-invites.com/seedbox-discussions/)
* [Torrent Invites](http://www.torrent-invites.com/)
* [P2PNews](http://www.p2pnews.net/)
	
	* Sponsors
	* [Xirvik](http://www.xirvik.com/)
	* [PulsedMedia](http://www.pulsedmedia.com/)
	* [SeedStuff](http://www.seedstuff.ca/)
	* [Seed.ST](http://www.seed.st/)
	* [Seednet](http://www.seednet.eu/)
	* [Seedhost.eu](http://www.seedhost.eu/)
	
	* We are Social
	* [Connect with us](http://www.facebook.com/)
	* [Follow Us](https://www.twitter.com/)
	* [Watch Videos](http://www.youtube.com/)

* [Contact Us](http://www.torrent-invites.com/misc.php?s=cb64a6b81788ed2501f7da69b3beaba4&do=form&fid=15)

* [Torrent-Invites](http://www.torrent-invites.com/)
* [Archive](http://www.torrent-invites.com/archive/index.php?s=cb64a6b81788ed2501f7da69b3beaba4)
