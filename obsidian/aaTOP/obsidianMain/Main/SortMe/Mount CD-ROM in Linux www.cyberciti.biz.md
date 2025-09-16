# Mount CD-ROM in Linux [www.cyberciti.biz]

* [BASH Shell](http://www.cyberciti.biz/faq/category/bash-shell/)

* [Troubleshooting](http://www.cyberciti.biz/faq/category/troubleshooting/)
* [Nginx](http://www.cyberciti.biz/faq/category/nginx/)
* [Networking](http://www.cyberciti.biz/faq/category/networking/)
* [MySQL](http://www.cyberciti.biz/faq/category/mysql/)
* [Google Cloud Platform](http://www.cyberciti.biz/faq/category/google-cloud-platform/)
* [Amazon Cloud Computing](http://www.cyberciti.biz/faq/category/aws-ec2-ebs-cloudfront/)
* [Rackspace Cloud Computing](http://www.cyberciti.biz/faq/category/rackspace-cloud-storage-server-cdnfiles/)
	
	* [CentOS](http://www.cyberciti.biz/faq/category/centos/)
	* [Debian / Ubuntu](http://www.cyberciti.biz/faq/category/debian-ubuntu/)
	* [Ubuntu Linux](http://www.cyberciti.biz/faq/category/ubuntu-linux/)
	* [Suse](http://www.cyberciti.biz/faq/category/suse/)
	* [RedHat and Friends](http://www.cyberciti.biz/faq/category/redhat-and-friends/)
	* [Slackware Linux](http://www.cyberciti.biz/faq/category/slackware-linux/)
	
	* [AIX](http://www.cyberciti.biz/faq/category/aix/)
	* [Mac OS X](http://www.cyberciti.biz/faq/category/mac-os-x/)
	* [FreeBSD](http://www.cyberciti.biz/faq/category/freebsd/)
	* [FreeBSD Jails (VPS)](http://www.cyberciti.biz/faq/category/freebsd-jails-vps/)
	* [Openbsd](http://www.cyberciti.biz/faq/category/openbsd/)
	* [Solaris](http://www.cyberciti.biz/faq/category/solaris/)
* [See all tutorial topics](http://www.cyberciti.biz/faq/category-archives/)
* [Blog](http://www.cyberciti.biz/)
* [About](http://www.cyberciti.biz/tips/about-us)
* [Contact us](http://www.cyberciti.biz/tips/contact-us)
* [Forum](http://nixcraft.com/forum.php)
* [RSS/FEED](http://www.cyberciti.biz/nixcraft-rss-feed-syndication/)
.

[Linux FAQ / Howtos](http://www.cyberciti.biz/faq/)

# Mount CD-ROM in Linux

by [nixCraft](http://www.cyberciti.biz/tips/about-us) on May 6, 2011 · [1 comment](http://www.cyberciti.biz/faq/mounting-cdrom-in-linux/#comments)· LAST UPDATED May 7, 2012

in [Linux](http://www.cyberciti.biz/faq/category/linux/)

[![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/linux-logo.png]]](http://www.cyberciti.biz/faq/category/linux/)

How do I mount a CD-ROM or DVD on Linux operating system using command line options?
You need to use the mount command to mount a CD-ROM or DVD disk under Linux operating systems. First, insert the CD or DVD in the server drive. Next, type the mount command as the root use to mount discs:
`# mount -t iso9660 -o ro /dev/cdrom /cdrom`
OR
`# mkdir /mnt/cdrom # mount -t iso9660 -o ro /dev/cdrom /mnt/cdrom`
Verify that CD/DVD mounted at the /cdrom or /mnt/cdrom, enter:

 **mount****df** 

/cdrom or /mnt/cdrom represents the mount point of the CD or DVD. To view or browse CD or DVD, enter:

 **ls** -l /cdrom**cd** /cdrom**ls** 

To copy a file called foo.txt to the /tmp, enter:

 **cd** /cdrom**cp** -v foo.txt /tmp 

OR

 **cp** -v /cdrom/foo.txt /tmp 

## How do I unmount CD-ROM or DVD on Linux?

Type the following command as the root user:
`# umount /cdrom`
OR
`# umount /dev/cdrom`
OR
`# umount /mnt/cdrom`

		[Tweet](https://twitter.com/intent/tweet?original_referer=http%3A%2F%2Fwww.cyberciti.biz%2Ffaq%2Fmounting-cdrom-in-linux%2F&text=Mount%20CD-ROM%20in%20Linux&tw_p=tweetbutton&url=http%3A%2F%2Fwww.cyberciti.biz%2Ffaq%2Fmounting-cdrom-in-linux%2F&via=nixcraft)
	[0](http://twitter.com/search?q=http%3A%2F%2Fwww.cyberciti.biz%2Ffaq%2Fmounting-cdrom-in-linux%2F)
	
		|     |     |     |
	| --- | --- | --- |
	|     | 0   |     |
	
		|     |     |
	| --- | --- |
	| Like | 1   |
	
		* [StumbleUpon](http://www.stumbleupon.com/submit?url=http%3A%2F%2Fwww.cyberciti.biz%2Ffaq%2Fmounting-cdrom-in-linux%2F)
	
* [Submit](http://www.stumbleupon.com/submit?url=http%3A%2F%2Fwww.cyberciti.biz%2Ffaq%2Fmounting-cdrom-in-linux%2F)

* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/pdfdlv1.jpg]]](http://www.cyberciti.biz/view/pdf/faq/12327.php)

If you would like to be kept up to date with our posts, you can follow us on [Twitter](https://twitter.com/nixcraft), [Facebook](https://facebook.com/nixcraft), [Google+](https://plus.google.com/104257421720370350735), or even by subscribing to our [RSS Feed](http://feeds.cyberciti.biz/Nixcraft-LinuxFreebsdSolarisTipsTricks).

Featured Articles:

* [30 Handy Bash Shell Aliases For Linux / Unix / Mac OS X](http://www.cyberciti.biz/tips/bash-aliases-mac-centos-linux-unix.html)

* [Top 30 Nmap Command Examples For Sys/Network Admins](http://www.cyberciti.biz/networking/nmap-command-examples-tutorials/)
* [25 PHP Security Best Practices For Sys Admins](http://www.cyberciti.biz/tips/php-security-best-practices-tutorial.html)
* [20 Linux System Monitoring Tools Every SysAdmin Should Know](http://www.cyberciti.biz/tips/top-linux-monitoring-tools.html)
* [20 Linux Server Hardening Security Tips](http://www.cyberciti.biz/tips/linux-security.html)
* [Linux: 20 Iptables Examples For New SysAdmins](http://www.cyberciti.biz/tips/linux-iptables-examples.html)
* [Top 20 OpenSSH Server Best Security Practices](http://www.cyberciti.biz/tips/linux-unix-bsd-openssh-server-best-practices.html)
* [Top 20 Nginx WebServer Best Security Practices](http://www.cyberciti.biz/tips/linux-unix-bsd-nginx-webserver-security.html)
* [20 Examples: Make Sure Unix / Linux Configuration Files Are Free From Syntax Errors](http://www.cyberciti.biz/tips/check-unix-linux-configuration-file-for-syntax-errors.html)
* [15 Greatest Open Source Terminal Applications Of 2012](http://www.cyberciti.biz/open-source/best-terminal-applications-for-linux-unix-macosx/)
	![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/new_post.png]]
	
* [My 10 UNIX Command Line Mistakes](http://www.cyberciti.biz/tips/my-10-unix-command-line-mistakes.html)
* [Top 10 Open Source Web-Based Project Management Software](http://www.cyberciti.biz/tips/open-source-project-management-software.html)
* [Top 5 Email Client For Linux, Mac OS X, and Windows Users](http://www.cyberciti.biz/tips/download-email-client-for-linux-mac-osx-windows.html)
* [The Novice Guide To Buying A Linux Laptop](http://www.cyberciti.biz/tips/linux-laptop.html)
.

{ 1 comment… read it below or [add one](http://www.cyberciti.biz/faq/mounting-cdrom-in-linux/#respond) }

<http://metameso.org/~joe>[1](http://www.cyberciti.biz/faq/mounting-cdrom-in-linux/#comment-97526) **[Joe Corneli](http://metameso.org/~joe)** August 27, 2013 at 2:40 pm

Sometimes the relevant device is

cdrw

, not cdrom.

[Reply](http://www.cyberciti.biz/faq/mounting-cdrom-in-linux/?replytocom=97526#respond)

.

Leave a Comment

Name \*

E-mail \*

_You can use these HTML tags and attributes for your code and commands:_ <strong> <em> <ol> <li> <u> <ul> <kbd> <blockquote> <pre> <a href="" title="">

Notify me of followup comments via e-mail

Tagged as: [/dev/cdrom](http://www.cyberciti.biz/faq/tag/devcdrom/), [/dev/dvd](http://www.cyberciti.biz/faq/tag/devdvd/), [cd rom](http://www.cyberciti.biz/faq/tag/cd-rom/), [cdrom](http://www.cyberciti.biz/faq/tag/cdrom/), [command line options](http://www.cyberciti.biz/faq/tag/command-line-options/), [df](http://www.cyberciti.biz/faq/tag/df/), [df command](http://www.cyberciti.biz/faq/tag/df-command/), [iso9660](http://www.cyberciti.biz/faq/tag/iso9660/), [Linux](http://www.cyberciti.biz/faq/tag/linux/), [linux operating systems](http://www.cyberciti.biz/faq/tag/linux-operating-systems/), [mkdir](http://www.cyberciti.biz/faq/tag/mkdir/), [mount -t iso9660 command](http://www.cyberciti.biz/faq/tag/mount-t-iso9660-command/), [mount cd](http://www.cyberciti.biz/faq/tag/mount-cd/), [mount command](http://www.cyberciti.biz/faq/tag/mount-command/), [root user](http://www.cyberciti.biz/faq/tag/root-user/), [umount command](http://www.cyberciti.biz/faq/tag/umount-command/)

Previous Faq: [Ubuntu Linux: Add a User To Group www-data ( Apache Group )](http://www.cyberciti.biz/faq/ubuntu-add-user-to-group-www-data/)

Next Faq: [Use export Command in Linux / Unix](http://www.cyberciti.biz/faq/linux-unix-shell-export-command/)

.

**GET FREE LINUX TIPS**
_Sign up for our newsletter to get howto & news_

		|     |     |
	| --- | --- |
	|     |     |
	
	![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/search_box_icon.png]]
	
		[![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/373520_126000117413375_1406774533_q.jpg]]](https://www.facebook.com/nixcraft)
	**[nixCraft](https://www.facebook.com/nixcraft)**
	
	|     |     |
	| --- | --- |
	| Like |     |
	
	.
	
	41,003 people like [nixCraft](https://www.facebook.com/nixcraft).
	
	* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/161422_1395535762_4753654_q.jpg]]](https://www.facebook.com/bob.demars.7)
	
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/1086731_100007196640416_1010882124_q.jpg]]](https://www.facebook.com/raviteja.teja.33234)

* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/275229_717421517_1191789891_q.jpg]]](https://www.facebook.com/hazzimanaya)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/252231_1002029915278_1941483569_s.jpg]]](https://www.facebook.com/grigori.kozel)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/1076382_1269375549_788128822_q.jpg]]](https://www.facebook.com/salvo92fe)

<https://www.facebook.com/help/?page=209089222464503>

[Facebook social plugin](https://www.facebook.com/help/?page=209089222464503)

.

		### Related Faqs
	
	* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/13.jpg]]](http://www.cyberciti.biz/faq/mounting-cds-dvds-on-hpux-unix-command/)[Mount CD-ROM / DVD in HP-UX Unix](http://www.cyberciti.biz/faq/mounting-cds-dvds-on-hpux-unix-command/)
	
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/21.jpg]]](http://www.cyberciti.biz/faq/mounting-harddisks-in-freebsd-with-mount-command/)[FreeBSD: Mount Hard Drive / Disk](http://www.cyberciti.biz/faq/mounting-harddisks-in-freebsd-with-mount-command/)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/4.jpg]]](http://www.cyberciti.biz/faq/centos-rhel-linux-mount-raid-hard-disk-from-livecd/)[CentOS / Redhat: Chroot And Mount Raid Or Actual Hard Disk From Rescue Kernel / CD](http://www.cyberciti.biz/faq/centos-rhel-linux-mount-raid-hard-disk-from-livecd/)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/warning-40px3-150x150.jpg]]](http://www.cyberciti.biz/faq/mount-command-in-unix/)[Mount Command In UNIX](http://www.cyberciti.biz/faq/mount-command-in-unix/)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/6.jpg]]](http://www.cyberciti.biz/faq/redhat-fedora-enable-ntfs3g-support/)[RHEL / CentOS Linux: Mount and Access NTFS Partition](http://www.cyberciti.biz/faq/redhat-fedora-enable-ntfs3g-support/)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/26.jpg]]](http://www.cyberciti.biz/faq/mount-drive-from-command-line-ubuntu-linux/)[Ubuntu: Mount The Drive From Command Line](http://www.cyberciti.biz/faq/mount-drive-from-command-line-ubuntu-linux/)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/17.jpg]]](http://www.cyberciti.biz/faq/rhel-centos-debian-fedora-mount-partition-label/)[Linux: Mount Disk Partition Using LABEL](http://www.cyberciti.biz/faq/rhel-centos-debian-fedora-mount-partition-label/)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/22.jpg]]](http://www.cyberciti.biz/faq/unmount-iso-image-linux/)[How To: Unmount an ISO Image in Linux](http://www.cyberciti.biz/faq/unmount-iso-image-linux/)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/9.jpg]]](http://www.cyberciti.biz/faq/how-to-mount-bind-partitions-filesystems-in-linux/)[Linux mount: Bind or Remount Part Of File Hierarchy At Another Directory](http://www.cyberciti.biz/faq/how-to-mount-bind-partitions-filesystems-in-linux/)
* [![[./_resources/Mount_CD-ROM_in_Linux_www.cyberciti.biz.resources/15.jpg]]](http://www.cyberciti.biz/faq/linux-unix-mplayer-playing-audio-dvd-cd-using-bash-shell/)[Mplayer: Play Audio CD Using Linux Command Line](http://www.cyberciti.biz/faq/linux-unix-mplayer-playing-audio-dvd-cd-using-bash-shell/)
	* [Valve SteamOS: A Linux-based Gaming Operating System Announced](http://www.cyberciti.biz/linux-games/valve-announces-linux-based-steamos/)
	* [Download of the day: Half-Life 2 For Steam on Linux](http://www.cyberciti.biz/linux-games/download-half-life-2-for-steam-on-linux/)
	* [Download of The Day: Debian Linux 7 ( Wheezy )](http://www.cyberciti.biz/linux-news/download-debian-7-cd-dvd-iso/)
	* [Apache / Nginx: Visualize Web Server Access Log In Real Time](http://www.cyberciti.biz/open-source/use-logstalgia-apachepong-as-website-access-log-realtime-visualization-tool/)
	* [Amazon AWS Route 53 GEO DNS Configurations](http://www.cyberciti.biz/cloud-computing/aws/route-53-geodns-tutorial/)
...

©2006-2013 nixCraft. All rights reserved. Cannot be reproduced without written permission.
[Privacy Policy](http://www.cyberciti.biz/tips/privacy) | [Terms of Service](http://www.cyberciti.biz/tips/disclaimer) | [Questions or Comments](http://www.cyberciti.biz/tips/contact-us) | [Sitemap](http://www.cyberciti.biz/faq/faqsitemaps/)
