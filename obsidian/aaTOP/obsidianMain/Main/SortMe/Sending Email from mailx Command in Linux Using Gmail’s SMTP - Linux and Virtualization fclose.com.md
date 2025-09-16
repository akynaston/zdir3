# Sending Email from mailx Command in Linux Using Gmail’s SMTP - Linux and Virtualization [fclose.com]

[Linux and Virtualization](http://fclose.com/b/linux/)

* [Home](http://fclose.com/b/linux/)

* [Solutions](http://fclose.com/b/linux/topic/solution/)
* [Linux](http://fclose.com/b/linux/topic/linux/)
* [Virtualization](http://fclose.com/b/linux/topic/virtualization/)
* [Git](http://fclose.com/b/linux/tag/git/)
* [SSH](http://fclose.com/b/linux/tag/ssh/)
* [iptables](http://fclose.com/b/linux/tag/iptables/)
* [Sitemap](http://fclose.com/b/linux/sitemap/)
* [Subscribe](http://fclose.com/b/linux/subscribe/)
* [About](http://fclose.com/b/linux/about/)

[Home](http://fclose.com/b/linux/) » [Linux](http://fclose.com/b/linux/topic/linux/)

# Sending Email from mailx Command in Linux Using Gmail’s SMTP

By: [Zhiqiang Ma](http://fclose.com/zma/)   In: [Linux](http://fclose.com/b/linux/topic/linux/)

mailx or mail command in Linux is still providing service for guys like me, especially when we need to send email automatically by script. gmail is great. Now, how to use gmail’s smtp in mailx/mail? gmail is a little special since gmail’s smtp server requires tls authorization. The good news is that mailx supports it. Let’s look at how to use it.

First, find out Fixforx’s profile directory in the home directory (I believe most of the users on Linux use Firefox. If you are not using Firefox, what you need to do is try it ;) . It has a format like this:

~/.mozilla/firefox/xxxxxxxx.default

xxxxxxxx is a random string that’s different for different users. You can easily find it out by looking into the directory _~/.mozilla/firefox_.

There are two ways to do this: using all-in-one command or putting configurations into profile. The all-in-one-command way needs no other configurations except the command line itself, while the way using configuration has a clearer command.

### All-in-one command

This is an all-in-one command that sends email to $TO\_EMAIL\_ADDRESS

mailx -v -s "$EMAIL\_SUBJECT"
-S smtp-use-starttls
-S ssl-verify=ignore
-S smtp-auth=login
-S smtp=smtp://smtp.gmail.com:587
-S from="$FROM\_EMAIL\_ADDRESS($FRIENDLY\_NAME)"
-S smtp-auth-user=$FROM\_EMAIL\_ADDRESS
-S smtp-auth-password=$EMAIL\_ACCOUNT\_PASSWORD
-S ssl-verify=ignore
-S nss-config-dir=~/.mozilla/firefox/xxxxxxxx.default/
$TO\_EMAIL\_ADDRESS

Replace the $XXX with the value that is actually used. The meaning is obvious. And remember to change xxxxxxxx to the string that’s part of the Firefox profile directory.

This command will ask for the email content. Type in the mail content and after finishing the email, use “Ctrl+d” to tell mailx you have finished. Then this mail will be sent out through gmail’s smtp server. You can also use pipe like this:

echo "The mail content" | mail -v -s ...

### Use configuration file

There are too many options in the above command? Yes… I must confess so. We can write most of them into mailx/mail’s configuration file _~/.mailrc_

set smtp-use-starttls
set nss-config-dir=~/.mozilla/firefox/xxxxxxxx.default/
set ssl-verify=ignore
set smtp=smtp://smtp.gmail.com:587
set smtp-auth=login
set smtp-auth-user=$FROM\_EMAIL\_ADDRESS
set smtp-auth-password=$EMAIL\_ACCOUNT\_PASSWORD
set from="$FROM\_EMAIL\_ADDRESS($FRIENDLY\_NAME)"

Change the $XXX and xxxxxxx to the right value for you. When sending mails, use this command:

mailx -v -s "$EMAIL\_SUBJECT" $TO\_EMAIL\_ADDRESS

Then, time to enjoy it!

**Update history**
Mar. 11 2010
Apr. 29 2010. Add title.
Jul. 12, 2010. Revise the article.
Jul. 26, 2010. Add highlight colour to pre tags.

Related posts:

* [Configure mailx to Use Gmail’s smtp](http://fclose.com/b/linux/125/%e9%85%8d%e7%bd%aemailx%e4%bd%bf%e7%94%a8gmail%e7%9a%84smtp/)

* [Changing Linux User’s Password in One Command Line](http://fclose.com/b/linux/3198/changing-linux-users-password-in-one-command-line/)
* [Setting Up Git Commit Email Notifications](http://fclose.com/b/linux/1473/setting-up-git-commit-email-notification/)
* [Starting KDE from Command Line by startx](http://fclose.com/b/linux/1896/starting-kde-from-command-line-by-startx/)
* [Linux Cluster Solutions](http://fclose.com/b/linux/2477/linux-cluster-solutions/)
* [Finding out Linux Network Configuration Information](http://fclose.com/b/linux/2350/finding-out-linux-network-configuration-information/)

Like this post? Recommend, share, subscribe, and bookmark it:

[![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.12.png]]](http://fclose.com/b/linux/ http://fclose.com/b/linux/feed/)    [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.png]]](http://fclose.com/b/linux/ http://www.google.com/bookmarks/mark?op=edit&bkmk=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&title=Sending Email from mailx Command in Linux Using Gmail’s SMTP) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.7.png]]](http://fclose.com/b/linux/ http://bookmarks.yahoo.com/myresults/bookmarklet?u=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&title=Sending Email from mailx Command in Linux Using Gmail’s SMTP) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.11.png]]](http://fclose.com/b/linux/ http://delicious.com/save?url=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&title=Sending Email from mailx Command in Linux Using Gmail’s SMTP)    [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.3.png]]](http://fclose.com/b/linux/ http://digg.com/submit?phase=2&url=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&title=Sending Email from mailx Command in Linux Using Gmail’s SMTP) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.1.png]]](http://www.stumbleupon.com/submit?url=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&title=Sending Email from mailx Command in Linux Using Gmail’s SMTP) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.2.png]]](http://fclose.com/b/linux/ http://technorati.com/faves?add=http://fclose.com/b/linux) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.13.png]]](http://fclose.com/b/linux/ http://www.newsvine.com/_tools/seed&save?u=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&h=Sending Email from mailx Command in Linux Using Gmail’s SMTP) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.14.png]]](http://fclose.com/b/linux/ http://reddit.com/submit?url=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&title=Sending Email from mailx Command in Linux Using Gmail’s SMTP) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.8.png]]](http://fclose.com/b/linux/ http://www.mixx.com/submit?page_url=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&title=Sending Email from mailx Command in Linux Using Gmail’s SMTP)    [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.6.png]]](http://fclose.com/b/linux/ http://twitter.com/?status=Sending Email from mailx Command in Linux Using Gmail’s SMTP: http://fclose.com/b/linux/?p=1411) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.5.png]]](http://www.facebook.com/sharer.php?u=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&t=Sending Email from mailx Command in Linux Using Gmail’s SMTP) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.4.png]]](http://fclose.com/b/linux/ http://www.myspace.com/Modules/PostTo/Pages/?u=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&t=Sending Email from mailx Command in Linux Using Gmail’s SMTP)    [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.10.png]]](http://fclose.com/b/linux/ http://www.livejournal.com/update.bml?subject=Sending Email from mailx Command in Linux Using Gmail’s SMTP&event=<a href%3D"http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/">Sending Email from mailx Command in Linux Using Gmail’s SMTP</a>) [![[./_resources/Sending_Email_from_mailx_Command_in_Linux_Using_Gmail’s_SMTP_-_Linux_and_Virtualization_fclose.com.resources/unknown_filename.9.png]]](http://fclose.com/b/linux/ http://www.blogger.com/blog_this.pyra?u=http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/&n=Sending Email from mailx Command in Linux Using Gmail’s SMTP)

Author: [Zhiqiang Ma](http://fclose.com/zma/) Posted on: Mar 10, 2010 Views: 9,485 Tags: [Bash](http://fclose.com/b/linux/tag/bash/), [Client config](http://fclose.com/b/linux/tag/client-config/), [Command line](http://fclose.com/b/linux/tag/command-line/), [Fedora](http://fclose.com/b/linux/tag/fedora/), [google](http://fclose.com/b/linux/tag/google/), [Server config](http://fclose.com/b/linux/tag/server-config/), [Tutorial](http://fclose.com/b/linux/tag/tutorial/)

10 Responses to _Sending Email from mailx Command in Linux Using Gmail’s SMTP_

[« Older Comments](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/comment-page-1/#comments)

	Jim! says [on August 8, 2010 at 11:16 AM:](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/comment-page-2/#comment-83) [Reply](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/?replytocom=83#respond)
	
		
	
	Hey there, I’m sending from a sidux (debian sid) laptop and edited the /etc/nail.rc file (mailx formerly called nail) then symlinked to /etc/mail.rc. File didn’t exist but that may be due to my ensuring sendmail/postfix/etc. were purged from my system.
	
	Once I my server back up and working (Fedora 12/Amahi)‘set nss-config-dir=~/.mozilla/firefox/xxxxxxxx.default/’ may be of use.
	
	BTW you’re original article is concise and to the point unlike others I came across so thank you.
	
	Jim!
	
	roygbiv says [on August 12, 2010 at 9:16 AM:](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/comment-page-2/#comment-84) [Reply](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/?replytocom=84#respond)
	
		
	
	Worked like a charm. Thanks.
	
	Frank says [on December 6, 2010 at 10:53 AM:](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/comment-page-2/#comment-85) [Reply](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/?replytocom=85#respond)
	
		
	
	Hi,
	and how can I send html and binary attachments with mailx ?
	
	regards
	
	[Zhiqiang Ma](http://fclose.com/zma/) says [on December 6, 2010 at 5:04 PM:](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/comment-page-2/#comment-86) [Reply](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/?replytocom=86#respond)
	
		
	
	@ Frank,
	
	For sending binary attachments: using the “-a file” parameter: <http://fclose.com/p/linux/man/1-mailx/#lbAD>
	
	You may need to write html by yourself if you want to use HTML: <http://en.wikipedia.org/wiki/HTML_e-mail> Or I think you can try sending html as an attachment.
	
* Pingback from: [命令列發送郵件 (經密碼驗證) « Jamyy's Weblog](http://cha.homeip.net/blog/2011/05/3122.html)

[« Older Comments](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/comment-page-1/#comments)

Leave your response!

Be nice. Keep it clean. Stay on topic. No spam.

Name (required)

Mail (will not be published) (required)

Website (optional)

Notify me of followup comments via e-mail

« [Guake: An Excellent Quake Like Drop-down Terminal for Gnome](http://fclose.com/b/linux/1358/guake-an-excellent-quake-like-drop-down-terminal-for-gnome/)
[Setting Up a Git Server Using Gitosis](http://fclose.com/b/linux/1432/setting-up-git-server-using-gitosis/) »

Tag Cloud
[ATI](http://fclose.com/b/linux/tag/ati/) [Bash](http://fclose.com/b/linux/tag/bash/) [Chinese](http://fclose.com/b/linux/tag/chinese/) [Client config](http://fclose.com/b/linux/tag/client-config/) [Command line](http://fclose.com/b/linux/tag/command-line/) [Compiz](http://fclose.com/b/linux/tag/compiz/) [dom0](http://fclose.com/b/linux/tag/dom0/) [domu](http://fclose.com/b/linux/tag/domu/) [Download](http://fclose.com/b/linux/tag/download/) [emacs](http://fclose.com/b/linux/tag/emacs/) [Fedora](http://fclose.com/b/linux/tag/fedora/) [fglrx](http://fclose.com/b/linux/tag/fglrx/) [firefox](http://fclose.com/b/linux/tag/firefox/) [font](http://fclose.com/b/linux/tag/font/) [git](http://fclose.com/b/linux/tag/git/) [gnome](http://fclose.com/b/linux/tag/gnome/) [google](http://fclose.com/b/linux/tag/google/) [iptables](http://fclose.com/b/linux/tag/iptables/) [ipv6](http://fclose.com/b/linux/tag/ipv6/) [java](http://fclose.com/b/linux/tag/java/) [kde](http://fclose.com/b/linux/tag/kde/) [lftp](http://fclose.com/b/linux/tag/lftp/) [LVM](http://fclose.com/b/linux/tag/lvm/) [mplayer](http://fclose.com/b/linux/tag/mplayer/) [nfs](http://fclose.com/b/linux/tag/nfs/) [nvidia](http://fclose.com/b/linux/tag/nvidia/) [performance](http://fclose.com/b/linux/tag/performance/) [portforwarding](http://fclose.com/b/linux/tag/portforwarding/) [Programming](http://fclose.com/b/linux/tag/programming/) [scp](http://fclose.com/b/linux/tag/scp/) [Server config](http://fclose.com/b/linux/tag/server-config/) [shell](http://fclose.com/b/linux/tag/shell/) [Software](http://fclose.com/b/linux/tag/software/) [Solution](http://fclose.com/b/linux/tag/solution/) [SSH](http://fclose.com/b/linux/tag/ssh/) [theme](http://fclose.com/b/linux/tag/theme/) [Tip](http://fclose.com/b/linux/tag/tip/) [Tutorial](http://fclose.com/b/linux/tag/tutorial/) [vbd](http://fclose.com/b/linux/tag/vbd/) [vim](http://fclose.com/b/linux/tag/vim/) [vmware](http://fclose.com/b/linux/tag/vmware/) [vnc](http://fclose.com/b/linux/tag/vnc/) [Windows](http://fclose.com/b/linux/tag/windows/) [xen](http://fclose.com/b/linux/tag/xen/) [yum](http://fclose.com/b/linux/tag/yum/)

Recent Posts

* [Disable IPv6 on Linux](http://fclose.com/b/linux/3232/disable-ipv6-on-linux/)

* [Setting Up Ubuntu DomU on Xen: Use Ubuntu 10.10 on Fedora Xen Dom0](http://fclose.com/b/linux/3208/setting-up-ubuntu-domu-on-xen-use-ubuntu-10-10-on-fedora-xen-dom0/)
* [Changing Linux User’s Password in One Command Line](http://fclose.com/b/linux/3198/changing-linux-users-password-in-one-command-line/)
* [Taking Screenshot in MPlayer](http://fclose.com/b/linux/2990/taking-screenshot-in-mplayer/)
* [How to Compress/Uncompress Files in Linux Using gzip, bzip2, 7z, rar and zip](http://fclose.com/b/linux/2939/how-to-compressuncompress-files-in-linux-using-gzip-bzip2-7z-rar-and-zip/)
* [Open Source and Portable SSH, SCP, SFTP and VNC Clients for Windows to Remote Control Linux](http://fclose.com/b/linux/2931/open-source-and-portable-ssh-scp-sftp-and-vnc-clients-for-windows-to-remote-control-linux/)
* [How to Revert Changes in Git](http://fclose.com/b/linux/2845/how-to-revert-changes-in-git/)
* [How to Find out Linux and Windows Uptime](http://fclose.com/b/linux/2849/how-to-find-out-linux-and-windows-uptime/)
* [Improving Font Rendering for Fedora Using Bytecode Interpreter](http://fclose.com/b/linux/2805/improving-font-rendering-for-fedora-using-bytecode-interpreter/)
* [Linux Man Pages](http://fclose.com/b/linux/2791/linux-man-pages/)

Categories

* [Linux](http://fclose.com/b/linux/topic/linux/)

* [Network](http://fclose.com/b/linux/topic/network/)
* [Project](http://fclose.com/b/linux/topic/project/)
* [Software](http://fclose.com/b/linux/topic/software/)
* [Solution](http://fclose.com/b/linux/topic/solution/)
* [Virtualization](http://fclose.com/b/linux/topic/virtualization/)

Most Viewed Posts

* [Set Up a Git Server through SSH Connection](http://fclose.com/b/linux/366/set-up-git-server-through-ssh-connection/)

* [Sending Email from mailx Command in Linux Using Gmail’s SMTP](http://fclose.com/b/linux/1411/sending-email-from-mailx-command-in-linux-using-gmails-smtp/)
* [Setting Up a Git Server Using Gitosis](http://fclose.com/b/linux/1432/setting-up-git-server-using-gitosis/)
* [Setting Up Git Commit Email Notifications](http://fclose.com/b/linux/1473/setting-up-git-commit-email-notification/)
* [Port Forwarding Using iptables](http://fclose.com/b/linux/816/port-forwarding-using-iptables/)
* [Managing Xen Dom0′s CPU and Memory](http://fclose.com/b/linux/2258/managing-xen-dom0s-cpu-and-memory/)
* [Mac OSX-like Gnome Theme Style](http://fclose.com/b/linux/1873/mac-osx-like-gnome-theme-style/)
* [Managing Repositories on Git Server Using Gitosis](http://fclose.com/b/linux/1434/managing-repositories-on-git-server-using-gitosis/)
* [Setting Up Xen pvops Dom0 on Fedora : Xen 3.4.2 + Kernel 2.6.31 with paravirt_ops in Fedora 12](http://fclose.com/b/linux/1535/setting-up-xen-pvops-dom0-on-fedora-xen-3-4-2-kernel-2-6-31-with-paravirt_ops-in-fedora-12/)
* [Setting Up Stable Xen DomU with Fedora: Unmodified Fedora 12 on top of Xenified Fedora 12 Dom0 with ...](http://fclose.com/b/linux/2256/setting-up-stable-xen-domu-with-fedora-unmodified-fedora-12-on-top-of-xenified-fedora-12-dom0-with-xen-4-0-0/)
* [Setting Up Stable Xen Dom0 with Fedora: Xen 4.0.0 with Xenified Linux Kernel 2.6.32.13 in Fedora 12](http://fclose.com/b/linux/2252/setting-up-stable-xen-dom0-with-fedora-xen-4-0-0-with-xenified-linux-kernel-2-6-32-13-in-fedora-12/)
* [Setting up Stable Xen Dom0 with Fedora: Xen 4.0.1 with Xenified Linux Kernel 2.6.32.13 in Fedora 12](http://fclose.com/b/linux/2412/setting-up-stable-xen-dom0-with-fedora-xen-4-0-1-with-xenified-linux-kernel-2-6-32-13-in-fedora-12/)
* [Chinese Charactors Display Settings in Fedora](http://fclose.com/b/linux/298/chinese-charactors-display-settings-in-fedora/)
* [Port Forwarding Using SSH Tunnel](http://fclose.com/b/linux/818/port-forwarding-using-ssh-tunnel/)
* [Unified Linux Login and Home Directory Using OpenLDAP and NFS/automount](http://fclose.com/b/linux/281/unified-linux-login-and-home-directory-using-openldap-and-nfsautomount/)
* [Changing Linux User’s Password in One Command Line](http://fclose.com/b/linux/3198/changing-linux-users-password-in-one-command-line/)
* [Configuration of Linux Kernel Video Mode](http://fclose.com/b/linux/2218/configuration-of-linux-kernel-video-mode/)
* [How to Duplicate Xen DomU Virtual Machines](http://fclose.com/b/linux/605/how-to-duplicate-xen-domu-virtual-machines/)
* [Xen Solutions](http://fclose.com/b/linux/2367/xen-solutions/)
* [How to Run a cron Job Every Two Weeks / Months / Days](http://fclose.com/b/linux/1199/how-to-run-a-cron-job-every-two-weeks-months-days/)

Subscribe
Subscribe and get updates!

Your email:

License
[Fclose.com's License](http://fclose.com/b/license/)

Copyright © 2011 [Linux and Virtualization](http://fclose.com/b/linux/) · All rights reserved | Powered by [WordPress](http://wordpress.org/)
Valid [XHTML](http://validator.w3.org/check?uri=referer) and [CSS 3](http://jigsaw.w3.org/css-validator/check/referer?profile=css3)

Pageloads: 194,913
