# Linux iptables: Port Redirection Example [www.cyberciti.biz]

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
* [Linux Scripting Guide](http://bash.cyberciti.biz/guide/Main_Page)
* [RSS/FEED](http://www.cyberciti.biz/nixcraft-rss-feed-syndication/)
.

[Linux FAQ / Howtos](http://www.cyberciti.biz/faq/)

# Linux iptables: Port Redirection Example

by [Nix Craft](http://www.cyberciti.biz/tips/about-us) on February 1, 2010 · [18 comments](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comments)· LAST UPDATED February 1, 2010

in [Iptables](http://www.cyberciti.biz/faq/category/iptables/)

[![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/firewall.png]]](http://www.cyberciti.biz/faq/category/iptables/)

How do I redirect 80 port to 8123 using iptables?
You can easily redirect incoming traffic by inserting rules into PREROUTING chain of the nat table. You can set destination port using the REDIRECT target.

## Syntax

The syntax is as follows to redirect tcp $srcPortNumber port to $dstPortNumber:

iptables -t nat -A PREROUTING -i eth0 -p tcp --dport $srcPortNumber -j REDIRECT --to-port $dstPortNumbe

The syntax is as follows to redirect udp $srcPortNumber port to $dstPortNumber:

iptables -t nat -A PREROUTING -i eth0 -p udp --dport $srcPortNumber -j REDIRECT --to-port $dstPortNumbe

Replace eth0 with your actual interface name. The following syntax match for source and destination ips:

iptables -t nat -I PREROUTING --src $SRC\_IP\_MASK --dst $DST\_IP -p tcp --dport $portNumber -j REDIRECT --to-ports $rediectPort

## Examples:

The following example redirects TCP port 25 to port 2525:

iptables -t nat -A PREROUTING -i eth0 -p tcp --dport 25 -j REDIRECT --to-port 2525

In this example all incoming traffic on port 80 redirect to port 8123

iptables -t nat -I PREROUTING --src 0/0 --dst 192.168.1.5 -p tcp --dport 80 -j REDIRECT --to-ports 8123

Quoting from the iptables man page:

 This  target is only valid in the nat table, in the PREROUTING and OUTPUT
       chains, and user-defined chains which are only  called  from  those
       chains.   It redirects the packet to the machine itself by changing the
       destination IP  to  the  primary  address  of  the  incoming  interface
       (locally-generated  packets  are  mapped to the 127.0.0.1 address).  It
       takes one option:
       --to-ports port\[-port\]
              This specifies a destination port or  range  of  ports  to  use:
              without  this,  the  destination port is never altered.  This is
              only valid if the rule also specifies -p tcp or -p udp.

The OUTPUT chain example:

iptables -t nat -I OUTPUT --src 0/0 --dst 192.168.1.5 -p tcp --dport 80 -j REDIRECT --to-ports 8123

### How Do I View NAT Rules?

Type the following command:

iptables -t nat -L -n -v

### How Do I Save NAT Redirect Rules?

Type the following command:

iptables-save

#### References:

* man page - iptables

* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/spreddit7.gif]]](http://www.reddit.com/submit)

* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/pdfdlv1.jpg]]](http://www.cyberciti.biz/view/pdf/faq/6366.php)
Featured Articles:

* [30 Cool Open Source Software I Discovered in 2013](http://www.cyberciti.biz/open-source/30-cool-best-open-source-softwares-of-2013/)
	![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/new_post.png]]
	
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
* [My 10 UNIX Command Line Mistakes](http://www.cyberciti.biz/tips/my-10-unix-command-line-mistakes.html)
* [Top 10 Open Source Web-Based Project Management Software](http://www.cyberciti.biz/tips/open-source-project-management-software.html)
* [Top 5 Email Client For Linux, Mac OS X, and Windows Users](http://www.cyberciti.biz/tips/download-email-client-for-linux-mac-osx-windows.html)
* [The Novice Guide To Buying A Linux Laptop](http://www.cyberciti.biz/tips/linux-laptop.html)
.

{ 18 comments… read them below or [add one](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#respond) }

[1](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-47246) **tapas mishra** May 8, 2010 at 12:21 pm

Just came across this one.Never tried but good idea.

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=47246#respond)

.

[2](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-54934) **Nir** January 16, 2011 at 8:55 pm

gotta love this site.

thanks for the 1000th time ;)

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=54934#respond)

.

[3](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-55402) **Piyush** February 7, 2011 at 6:30 am

Hi,

Nice Article… !!!

Please check my query and update me if it is possible by iptables or any other software…

I have 2 application servers (i.e. A and B)

A ip is :- 192.168.11.22 and port :- 7013 (single lan card)

B ip is :- 10.10.10.22 and port :- 8014 (single lan card)

Now i want to set port fowarding/ redirection. When any client request to 192.168.11.22:7013 it will redirect to 10.10.10.22:8014 . How it is possible by iptables or any other way ?

Thank you.

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=55402#respond)

.

[4](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-55403) **Rocky** February 7, 2011 at 10:24 am

Hi,

I think for nat , two lan cards are required……

and can we pass one machine traffic to other which are on internet via port redirection….?

Thansks

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=55403#respond)

.

[5](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-55747) **Mikhail** February 18, 2011 at 4:50 am

Thank you! I always forget how to redirect

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=55747#respond)

.

[6](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-62183) **Steve** September 6, 2011 at 3:31 am

Well heck. I thought this was my answer but adding the iptables rule to redirect outbound port 25 traffic to port 2525 has no effect. (Ubuntu 10.04)

Mixmaster is giving me cat fits because ISPs have decided that we are not allowed to send RFC compliant e-mail any more. Ever. No matter what. Any suggestions?

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=62183#respond)

.

[7](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-62190) **Rocky Patel** September 6, 2011 at 10:52 am

Hi,

Can we see packet , means redirection from port 80 to port 3128 or redirect of confiugred ports in iptables rule.

My question is that , is there any tool or utility, by use of it we can see how packet handle by iptables.

Thanks,
ROcky

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=62190#respond)

.

[8](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-62409) **Cr0t** September 14, 2011 at 1:36 am

How about redirecting an internal request to go out over a different interface.

I got bond0 and wlan0.

The request for a specific server let’s call it foobar on port 443. I always want to go out over wlan0 and never over bond0.

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=62409#respond)

.

[9](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-67685) **Gary Largeman** January 31, 2012 at 9:45 pm

God bless you. I’ve been looking for these!

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=67685#respond)

.

[10](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-67836) **Elton Rauh** February 7, 2012 at 7:49 pm

all connections are being redirected to the proxy … Why, if it is set different from the 172.16.0.0/12 and those connections I’m also going through the proxy

$IPTABLES -A PREROUTING -t nat -p tcp -i eth2 -s 10.18.83.0/24 -d ! 172.16.0.0/12 -m multiport –dports 80,443 -j DNAT –to 172.19.100.206:3128

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=67836#respond)

.

[11](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-68403) **Josh** March 15, 2012 at 9:08 pm

Thanks, this was very helpful :)

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=68403#respond)

.

[12](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-69172) **Oliver** May 3, 2012 at 10:15 am

Hi, I’ve got a quite funny setup. I connect with ssh to server1 and establish a tunnel. Packets are generated I mark the packets on the OUTPUT chain and redirect them with ip route through a vpn gateway. This works fine.

But I want to redirect the port from 80 to 3028 and this does not work on the output chain. The rule is ignored. How can I redirect the port on the Postrouting chain?

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=69172#respond)

.

[13](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-71427) **Marian** September 4, 2012 at 10:25 am

single rule doesnt work if You have a big script. Could You please publish complete firewall script with all settings ?

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=71427#respond)

.

[14](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-91990) **PacoBell** May 7, 2013 at 6:35 am

Does this syntax guarantee the return path from $dstPortNumber back to $srcPortNumber as well? I tried this out and it seems that my client can receive packets on the dstPort just fine, but those sent back are lost somehow.

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=91990#respond)

.

[15](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-97628) **higkoo** August 30, 2013 at 4:56 am

Can you do it without iptables?

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=97628#respond)

.

[16](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-97873) **NeMewSys** September 4, 2013 at 6:43 pm

If I use this:

iptables -t nat -A PREROUTING -i eth0 -p tcp --dport 25 -j REDIRECT --to-port 2525

every packet arriving to port 25 will be forward to 2525, but what happens to packets arriving to port 2525? I would like to redirect them to 25, should I also add this rule?

iptables -t nat -A PREROUTING -i eth0 -p tcp --dport 2525 -j REDIRECT --to-port 25

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=97873#respond)

.

[17](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-100353) **lorenzo** October 31, 2013 at 9:23 am

iptables -t nat -A PREROUTING -i venet0 -p tcp –dport 1:20 -j REDIRECT –to-port 411
following request:
iptables: No chain/target/match by that name.

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=100353#respond)

.

[18](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/#comment-117982) **anonymous** February 14, 2014 at 3:04 am

lorenzo,

sysctl net.ipv4.ip\_forward=1

NeMewSys,

You want to redirect 2525 -> 25, and 25 -> 2525 – why on earth would you think that’s a great idea?

[Reply](http://www.cyberciti.biz/faq/linux-port-redirection-with-iptables/?replytocom=117982#respond)

.

Leave a Comment

Name \*

E-mail \*

Notify me of followup comments via e-mail

Tagged as: [192](http://www.cyberciti.biz/faq/tag/192/), [chains](http://www.cyberciti.biz/faq/tag/chains/), [destination ip](http://www.cyberciti.biz/faq/tag/destination-ip/), [destination port](http://www.cyberciti.biz/faq/tag/destination-port/), [incoming interface](http://www.cyberciti.biz/faq/tag/incoming-interface/), [incoming traffic](http://www.cyberciti.biz/faq/tag/incoming-traffic/), [interface name](http://www.cyberciti.biz/faq/tag/interface-name/), [iptables redirect ip](http://www.cyberciti.biz/faq/tag/iptables-redirect-ip/), [iptables redirect local port](http://www.cyberciti.biz/faq/tag/iptables-redirect-local-port/), [iptables redirect port 80](http://www.cyberciti.biz/faq/tag/iptables-redirect-port-80/), [iptables-save](http://www.cyberciti.biz/faq/tag/iptables-save/), [man page](http://www.cyberciti.biz/faq/tag/man-page/), [mask](http://www.cyberciti.biz/faq/tag/mask/), [match](http://www.cyberciti.biz/faq/tag/match/), [NAT Redirect](http://www.cyberciti.biz/faq/tag/nat-redirect/), [nat rules](http://www.cyberciti.biz/faq/tag/nat-rules/), [OUTPUT](http://www.cyberciti.biz/faq/tag/output/), [ports](http://www.cyberciti.biz/faq/tag/ports/), [PREROUTING](http://www.cyberciti.biz/faq/tag/prerouting/), [REDIRECT](http://www.cyberciti.biz/faq/tag/redirect/), [target](http://www.cyberciti.biz/faq/tag/target/), [tcp port](http://www.cyberciti.biz/faq/tag/tcp-port/)

Previous Faq: [Debian / Ubuntu Linux: Install and Configure snmpd Service](http://www.cyberciti.biz/faq/debain-ubuntu-install-net-snmpd-server/)

Next Faq: [HowTo: Check RAM Size In Ubuntu Linux](http://www.cyberciti.biz/faq/check-ram-in-ubuntu/)

.

|     |     |     |     |     |     |
| --- | --- | --- | --- | --- | --- |
| [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/twitter.png]]](https://twitter.com/nixcraft) | [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/youtube.png]]](https://youtube.com/user/nixcraftcom) | [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/googleplus.png]]](https://plus.google.com/+nixCraftadmin?prsrc=5) | [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/facebook.png]]](https://facebook.com/nixcraft) | [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/rss.png]]](http://feeds.cyberciti.biz/Nixcraft-LinuxFreebsdSolarisTipsTricks) | [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/email.png]]](http://feedburner.google.com/fb/a/mailverify?uri=Nixcraft-LinuxFreebsdSolarisTipsTricks) |

		### Related Faqs
	
	* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/1.jpg]]](http://www.cyberciti.biz/faq/linux-iptables-multiport-range/)[Linux: Iptables Forward Multiple Ports](http://www.cyberciti.biz/faq/linux-iptables-multiport-range/)
	
* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/1.jpg]]](http://www.cyberciti.biz/faq/howto-display-linux-iptables-loaded-rules/)[Linux Firewall: Display Status and Rules of Iptables Firewall](http://www.cyberciti.biz/faq/howto-display-linux-iptables-loaded-rules/)

* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/22.jpg]]](http://www.cyberciti.biz/faq/iptables-delete-ip-address-subnet-from-linux-firewall/)[Iptables: Unblock / Delete an IP Address Listed in IPtables Tables](http://www.cyberciti.biz/faq/iptables-delete-ip-address-subnet-from-linux-firewall/)
* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/5.jpg]]](http://www.cyberciti.biz/faq/linux-iptables-drop/)[Iptables Drop IP Address](http://www.cyberciti.biz/faq/linux-iptables-drop/)
* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/18.jpg]]](http://www.cyberciti.biz/faq/linux-iptables-add-delete-ip-address/)[Linux Iptables: Add / Delete An IP Address Remotely Using A Shell Script](http://www.cyberciti.biz/faq/linux-iptables-add-delete-ip-address/)
* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/0.jpg]]](http://www.cyberciti.biz/faq/iptables-invert-ip-or-protocol-with/)[Iptables: Invert IP, Protocol, Or Interface Test With !](http://www.cyberciti.biz/faq/iptables-invert-ip-or-protocol-with/)
* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/Ubuntu-ufw-firewall-enable-disable-150x150.png]]](http://www.cyberciti.biz/faq/ubuntu-server-disable-firewall/)[Disable / Turn Off Firewall in Ubuntu Linux Server](http://www.cyberciti.biz/faq/ubuntu-server-disable-firewall/)
* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/16.jpg]]](http://www.cyberciti.biz/faq/what-ports-need-to-be-open-for-samba-to-communicate-with-other-windowslinux-systems/)[What Ports Need To Be Open For Samba To Communicate With Other Windows/Linux Systems?](http://www.cyberciti.biz/faq/what-ports-need-to-be-open-for-samba-to-communicate-with-other-windowslinux-systems/)
* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/26.jpg]]](http://www.cyberciti.biz/faq/howto-find-subnet-mask-on-unix/)[Find subnet mask on UNIX](http://www.cyberciti.biz/faq/howto-find-subnet-mask-on-unix/)
* [![[./_resources/Linux_iptables_Port_Redirection_Example_www.cyberciti.biz.resources/23.jpg]]](http://www.cyberciti.biz/faq/linux-parse-ip-address/)[Linux: Parse an IP Address](http://www.cyberciti.biz/faq/linux-parse-ip-address/)
	* [10 Linux/Unix Bash and KSH Shell Job Control Examples](http://www.cyberciti.biz/howto/unix-linux-job-control-command-examples-for-bash-ksh-shell/)
	* [Download of The Day: FreeBSD 10 ISO DVD / CD Images](http://www.cyberciti.biz/open-source/download-freebsd-10-0-iso-dvd-cd/)
	* [30 Cool Open Source Software I Discovered in 2013](http://www.cyberciti.biz/open-source/30-cool-best-open-source-softwares-of-2013/)
	* [Download Of The Day: Fedora Linux 20 (Heisenbug) CD / DVD ISO](http://www.cyberciti.biz/linux-news/fedora-linux-20-download-cd-dvd-iso/)
	* [Valve SteamOS: A Linux-based Gaming Operating System Announced](http://www.cyberciti.biz/linux-games/valve-announces-linux-based-steamos/)
...
©2000-2014 nixCraft. All rights reserved. [Privacy Policy](http://www.cyberciti.biz/tips/privacy) - [Terms of Service](http://www.cyberciti.biz/tips/disclaimer) - [Questions or Comments](http://www.cyberciti.biz/tips/contact-us) - We are proudly powered by Linux + Nginx + WordPress.
The content is [copyrighted to nixCraft](http://www.cyberciti.biz/tips/copyright) and may not be reproduced on other websites.
