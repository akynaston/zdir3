# The number of active connections to your server `netstat -anp` | Linux.org [www.linux.org]

### [Log in or Sign up](http://www.linux.org/login/)

<http://www.linux.org/misc/quick-navigation-menu?selected=node-10>[Home](http://www.linux.org/) [Forums](http://www.linux.org/forums/) \> [General](http://www.linux.org/forums/#general.7) \> [Command Line](http://www.linux.org/forums/command-line.10/) \>

# The number of active connections to your server \`netstat -anp\`

Discussion in '[Command Line](http://www.linux.org/forums/command-line.10/)' started by [gcawood](http://www.linux.org/members/gcawood.3/), [Oct 29, 2011](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/).

,

. .

1. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.1.png]]](http://www.linux.org/members/gcawood.3/)
	
	### [gcawood](http://www.linux.org/members/gcawood.3/) _Administrator_ _**Staff Member**_
	
	Messages:
	[49](http://www.linux.org/search/member?user_id=3)
	
	Likes Received:
	14
	
	Trophy Points:
	[0](http://www.linux.org/members/gcawood.3/trophies)
	
	> To View the number of active tcp connections to a server based on IP address, sorted from lowest to highest
	> 
	> Code:
	> netstat -anp | grep tcp | awk '{print $5}' | cut -f 1 -d : | sort | uniq -c | sort -n 
	> 
	> Depending on your linux distro, you may have to modify the awk'{print $N}' statement to line up with the IP field.
	
	[gcawood](http://www.linux.org/members/gcawood.3/), [Oct 29, 2011](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/)
	[#1](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/)
	
	.

		[![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.7.png]]](http://www.linux.org/members/tomfmason.87/)
	
	### [tomfmason](http://www.linux.org/members/tomfmason.87/) _New Member_ _**Staff Writer**_
	
	Messages:
	[22](http://www.linux.org/search/member?user_id=87)
	
	Likes Received:
	5
	
	Trophy Points:
	[0](http://www.linux.org/members/tomfmason.87/trophies)
	
	> nice thanks!
	
	[tomfmason](http://www.linux.org/members/tomfmason.87/), [Nov 3, 2011](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-191)
	[#2](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-191)
	
	.
		[![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.8.png]]](http://www.linux.org/members/mustangv10.157/)
	
	### [MustangV10](http://www.linux.org/members/mustangv10.157/) _New Member_
	
	Messages:
	[87](http://www.linux.org/search/member?user_id=157)
	
	Likes Received:
	2
	
	Trophy Points:
	[0](http://www.linux.org/members/mustangv10.157/trophies)
	
	> I believe this was the command I was told to use a while ago when I asked about looking to see if I was under a DDoS attack. Not sure though. Would something like this be ideal for searching out a DoS attack?
	
	[MustangV10](http://www.linux.org/members/mustangv10.157/), [Nov 11, 2011](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-539)
	[#3](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-539)
	
	.
		[![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.8.png]]](http://www.linux.org/members/ryran.297/)
	
	### [ryran](http://www.linux.org/members/ryran.297/) _New Member_
	
	Messages:
	[10](http://www.linux.org/search/member?user_id=297)
	
	Likes Received:
	4
	
	Trophy Points:
	[0](http://www.linux.org/members/ryran.297/trophies)
	
	> gcawood said: [↑](http://www.linux.org/goto/post?id=15#post-15)
	> 
	> > To View the number of active tcp connections to a server based on IP address, sorted from lowest to highest
	> > netstat -anp | grep tcp | awk '{print $5}' | cut -f 1 -d : | sort | uniq -c | sort -n
	> 
	> Comparing that to the following might be instructive for some folks. Check out the differences.
	> 
	> Code:
	> netstat -tn | tail -n+3 |  awk {print\\$5} |cut -d: -f1|sort|uniq -c|sort -nr
	> 
	> We didn't need to use grep tcp, because netstat has a -t option; we also didn't need to use -p since we weren't selecting for programs; and since we don't want to see listening things, we don't need -a. Then all the rest is the same except that I reversed the sort order at the end.
	> Personally, I'm partial to lsof. It's much more powerful than netstat, IMO. I also would want to see ports as well. I'm no expert, but here's what I came up with:
	> 
	> Code:
	> lsof -nPi tcp -F n | awk -F\\> '/>/{print$2}'| sort | uniq -c | sort -nr
	> 
	> which gives some output like:
	> 
	> Code:
	>       3 74.125.39.104:443
	>       2 209.85.229.125:5222
	>       1 92.123.159.139:443
	>       1 74.125.236.147:443
	>       1 74.125.230.142:443
	>       1 74.125.230.137:80
	>       1 74.125.230.128:80
	>       1 69.171.229.11:443
	>       1 209.85.147.83:443
	> 
	> Breaking down **lsof -nPi tcp -F n**:
	> **\-n** & **\-P** stop host & port lookups
	> **\-i** selects for internet "files" and the optional arg of **tcp**, well.. that's obvious
	> **\-F** makes lsof run in a special mode designed for passing to other programs; in this case we tell it with **n** that we only want to see the name/netaddress field (but it shows us the pid anyway)
	> Breaking down **awk -F\\> '/>/{print$2}'**
	> Awk is amazing. I'm a novice with it, but I still find it quite useful. Case in point, almost everyone has to use awk for column selection at some point, but I think a lot basic cmdline users don't realize that it can do searching & column selection in one fell-swoop (instead of chaining it with grep). The syntax is super simple: awk '/regex searchstring/{print $FIELD#}'
	> So in our case, we're simply search for **\>** and printing the second column. BUT WAIT--we also ran with an arg of **\-F\\>**, which tells awk to use a field-separator of **\>** (had to escape for the shell of course).
	> Here's a small taste of what awk can do. Run it as root to check it out. I put this together a little while back, as part of a script that reports hardware info.
	> 
	> Code:
	> dmidecode -t memory|awk '/^\[\[:space:\]\]Size: \[\[:digit:\]\]/{numdims+=1;ram=$2;sumram+=ram}END{print numdims" DIMMs, "sumram" MB actual"}'
	> 
	> which prints out something like this if you have dmidecode (program for querying info from the bios) installed:
	> 
	> Code:
	> 2 DIMMs, 4096 MB actual
	> 
	> Hope someone finds all this instructive!
	> ![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.5.png]]
	> Oh, PS: For more on lsof, I just posted about it a little while ago [here](http://www.linuxforum.com/showthread.php/365-Monitoring-commands?p=1159#post1159).
	
	[ryran](http://www.linux.org/members/ryran.297/), [Nov 28, 2011](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-1163)
	[#4](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-1163)
	
	[grim76](http://www.linux.org/members/grim76.253/), [Rob](http://www.linux.org/members/rob.1/) and [tomfmason](http://www.linux.org/members/tomfmason.87/) like this.
	
	.
		[![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.8.png]]](http://www.linux.org/members/ryran.297/)
	
	### [ryran](http://www.linux.org/members/ryran.297/) _New Member_
	
	Messages:
	[10](http://www.linux.org/search/member?user_id=297)
	
	Likes Received:
	4
	
	Trophy Points:
	[0](http://www.linux.org/members/ryran.297/trophies)
	
	> Just found a [cool little blog post](http://blog.urfix.com/25-awk-commands-tricks/). Modified one of the things there a tiny bit to come up with the following, which graphs the number of connections to remote hosts:
	> 
	> Code:
	> ss -n | awk '!/^State/{print $5}' | awk -F: '{print $1}' | sort -n | uniq -c | awk '{ printf("%s\\t%s\\t",$2,$1) ; for (i = 0; i < $1; i++) {printf("\*")}; print "" }'
	> 
	> (Just noticed ss tonight for the first time, so I had to use it.)
	> In my case, it prints out something like this:
	> 
	> Code:
	> 66.220.158.25	1	\*
	> 74.125.230.155	2	\*\*
	> 74.125.236.148	1	\*
	> 88.221.217.17	4	\*\*\*\*
	> 92.122.2.110	4	\*\*\*\*
	> 92.123.157.177	2	\*\*
	> 209.85.229.125	1	\*
	> 209.92.144.49	6	\*\*\*\*\*\*
	
	[ryran](http://www.linux.org/members/ryran.297/), [Dec 3, 2011](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-1334)
	[#5](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-1334)
	
	.
		[![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.8.png]]](http://www.linux.org/members/carbon333.782/)
	
	### [carbon333](http://www.linux.org/members/carbon333.782/) _New Member_
	
	Messages:
	[87](http://www.linux.org/search/member?user_id=782)
	
	Likes Received:
	4
	
	Trophy Points:
	[0](http://www.linux.org/members/carbon333.782/trophies)
	
	> Very useful topic, thank you very much!
	
	[carbon333](http://www.linux.org/members/carbon333.782/), [Feb 16, 2012](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-3093)
	[#6](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#post-3093)
	
	.

[(You must log in or sign up to reply here.)](http://www.linux.org/login/)
. .

### Share This Page

.

[Sign Up Now!](http://www.linux.org/login/)

[![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.3.png]]](https://www.linuxpowerhosting.com/cart.php)
<https://www.linuxpowerhosting.com/cart.php>
<https://www.linuxpowerhosting.com/cart.php>
<https://www.linuxpowerhosting.com/cart.php>
<https://www.linuxpowerhosting.com/cart.php>
<https://www.linuxpowerhosting.com/cart.php>

### <https://www.linuxpowerhosting.com/cart.php>[Members Online Now](http://www.linux.org/online/)

1. [ZZs](http://www.linux.org/members/zzs.13843/),

* [DevynCJohnson](http://www.linux.org/members/devyncjohnson.4843/),
* [MikeyD](http://www.linux.org/members/mikeyd.5935/)
Total: 718 (members: 6, guests: 686, robots: 26)

### Facebook Group

### Recent Threads

1. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.2.png]]](http://www.linux.org/members/wii1990.15433/)
	[Looking for a low power distro.](http://www.linux.org/threads/looking-for-a-low-power-distro.5573/)
	[Yesyesloud](http://www.linux.org/members/yesyesloud.12932/) @ 
	
2. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.9.png]]](http://www.linux.org/members/marthamydear.14936/)
	[Low disk space on HDD...here I go again.](http://www.linux.org/threads/low-disk-space-on-hdd-here-i-go-again.5586/)
	[arochester](http://www.linux.org/members/arochester.3112/) @ 
	
3. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.10.png]]](http://www.linux.org/members/alejo.15522/)
	[Gothan WiFi N USB not working](http://www.linux.org/threads/gothan-wifi-n-usb-not-working.5585/)
	[arochester](http://www.linux.org/members/arochester.3112/) @ 
	
4. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.11.png]]](http://www.linux.org/members/urdrwho.15148/)
	[Fun with XP - Lilnux continues -- if it is at all...](http://www.linux.org/threads/fun-with-xp-lilnux-continues-if-it-is-at-all-fun.5587/)
	[ainteinstein](http://www.linux.org/members/ainteinstein.13615/) @ 
	
5. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/22de19fb2ba1d23d444bde66ec518bc0-s=48&d=http---www.png]]](http://www.linux.org/members/miguel-araujo.15520/)
	[hello](http://www.linux.org/threads/hello.5584/)
	[Miguel Araujo](http://www.linux.org/members/miguel-araujo.15520/) @ 
	
6. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.2.png]]](http://www.linux.org/members/pete-cotting.15514/)
	[What should I use?](http://www.linux.org/threads/what-should-i-use.5583/)
	[ainteinstein](http://www.linux.org/members/ainteinstein.13615/) @ 
	
7. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/d82c9e9aa0e1616e6bcf3d6457208dd9-s=48&d=http---www.png]]](http://www.linux.org/members/ryanvade.2159/)
	[Basic forum courtesy: Rules to follow for all...](http://www.linux.org/threads/basic-forum-courtesy-rules-to-follow-for-all-forum-users.4688/)
	[ryanvade](http://www.linux.org/members/ryanvade.2159/) @ 
	
8. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.6.png]]](http://www.linux.org/members/devyncjohnson.4843/)
	[Converting Between the Ubuntus](http://www.linux.org/threads/converting-between-the-ubuntus.5079/)
	[Richard Rodriguez](http://www.linux.org/members/richard-rodriguez.4905/) @ 
	
9. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.4.png]]](http://www.linux.org/members/gautam.15508/)
	[Hail The LINUX](http://www.linux.org/threads/hail-the-linux.5582/)
	[MikeyD](http://www.linux.org/members/mikeyd.5935/) @ 
	
10. [![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.11.png]]](http://www.linux.org/members/urdrwho.15148/)
	[Need to kill install or it kills me](http://www.linux.org/threads/need-to-kill-install-or-it-kills-me.5580/)
	[URDRWHO](http://www.linux.org/members/urdrwho.15148/) @ 
	

### Forum Statistics

Discussions:
5,217

Messages:
16,960

Members:
11,869

User Record:
4,476

Latest Member:
[Ricci](http://www.linux.org/members/ricci.15529/)

<http://www.linux.org/misc/quick-navigation-menu?selected=node-10>[Home](http://www.linux.org/) [Forums](http://www.linux.org/forums/) \> [General](http://www.linux.org/forums/#general.7) \> [Command Line](http://www.linux.org/forums/command-line.10/) \>

.

[![[./_resources/The_number_of_active_connections_to_your_server_`netstat_-anp`__Linux.org_www.linux.org.resources/resource.png]]](http://www.linux.org/)
.

* [Home](http://www.linux.org/)<http://www.linux.org/>

* [Forums](http://www.linux.org/forums/)
	
	* [Search Forums](http://www.linux.org/search/?type=post)
	
* [Recent Posts](http://www.linux.org/find-new/posts)

* [Resources](http://www.linux.org/resources/)<http://www.linux.org/resources/>
* [Members](http://www.linux.org/members/)<http://www.linux.org/members/>

.

* [Contact Us](http://www.linux.org/misc/contact)

* [Help](http://www.linux.org/help/)
* [Home](http://www.linux.org/)
* [Top](http://www.linux.org/threads/the-number-of-active-connections-to-your-server-netstat-anp.12/#navigation)
* [RSS](http://www.linux.org/forums/-/index.rss)
	* [Advertising Positioning](http://advertising.digitalpoint.com/)by Digital Point

* [Terms and Rules](http://www.linux.org/help/terms)

[Forum software by XenForo™ ©2010-2013 XenForo Ltd.](http://xenforo.com/) | [Linux Blog](http://www.linuxbrigade.com/) | [Linux Hosting](http://www.linuxpowerhosting.com/) | [Advertise](http://www.linux.org/pages/advertise/) | [Corporate Sponsors](http://www.linux.org/pages/corporate-sponsors/) | [Download Linux](http://www.download-linux.com/) | [Linux News](http://www.linuxnews.pro/)
