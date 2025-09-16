# How to OpenVPN over Proxy | Thinking and inspiration [blog.foppiano.org]

# [Thinking and inspiration](http://blog.foppiano.org/)

# Menu

[Skip to content](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/#content)

* [Home](http://blog.foppiano.org/)

* [contacts](http://blog.foppiano.org/contacts/)
* [licence](http://blog.foppiano.org/licenza/)

# How to OpenVPN over Proxy

Sometimes there are places where is impossible to reach to internet without pass through a proxy. Using proxy is problematic because usually is impossible to read mail or use chat, irc and any application which work on a port different from 80 or 443.

This how to should work on most of the cases, unless the proxy policy is too restrictive.

Basically, the idea is to use the main connections to all the application which support proxy and are simple to configure and a customized route only for services that can’t pass thought a proxy.

**Server**

Openvpn uses default port 1194 (TCP or UDP), to pass over a proxy you must use the 443 port. I suggest to leave default openvpn port and apply a prerouting rule on iptables which map the 443 port on 1194:

> `iptables -A PREROUTING -i eth0 -p tcp -m tcp --dport 80 443 -j DNAT --to-destination 192.168.10.127:1194`

Let’s start to configure openvpn service.

First of all you must read [this official howto section](http://openvpn.net/index.php/documentation/howto.html#pki) to understand how to generate certificate (there are a lot of scripts and sample configuratino files shipped with openvpn package); you can also modify and use my configuration file.
Here my server configuration file:

> `mode server local 192.168.10.127 ;port 443 proto tcp dev tun ca keys/ca.crt cert keys/server.crt key keys/server.key # This file should be kept secret dh keys/dh2048.pem server 10.8.0.0 255.255.255.0 push "route 192.168.10.0 255.255.255.0" keepalive 10 120 tls-auth keys/ta.key 0 # This file is secret cipher AES-128-CBC # AES comp-lzo user nobody group nobody persist-key persist-tun verb 5 mute 20`

I stored my certificates into `/etc/openvpn/keys` and my openvpn configuration file into `/etc/openvpn`.
I want to spend just few words about network configuration:

* 192.168.10.0/24 is my home network (192.168.10.127 is my server network address)

* 192.168.x.x/x is network I’m connected with client
* 10.8.0.0/24 is the tunnel network

**Client**

Here a basic configuration (you can find a well explained file into sample configuration openvpn files):

> `client dev tun proto tcp-client remote public_ip_address 443 #Public ip address of your home network resolv-retry infinite nobind persist-key persist-tun cipher AES-128-CBC ca "/etc/openvpn/keys/home/ca.crt" cert "/etc/openvpn/keys/home/client1.crt" key "/etc/openvpn/keys/home/client1.key" tls-auth "/etc/openvpn/keys/home/ta.key" 1 comp-lzo verb 5 http-proxy proxy.ras 80 passwd_file basic #http-proxy-retry http-proxy-option AGENT Mozilla/5.0+(Windows;+U;+Windows+NT+5.0;+en-GB;+rv:1.7.6)+Gecko/20050226+Firefox/1.0.1 `

I will not explain about keys and certificates here because openvpn how to give you a good explanation about it.
If your proxy need authentication, you must put proxy username and proxy password into your passwd\_file, respectly on first and second line.

Now, you can start openvpn on server (`service start openvpn`).
Then you have to start openvpn on client. If you pass through a proxy, services can return you a FAILED, in this case, you should check `/var/log/messages` to get information about it.

If you got something like:

> `Initialization Sequence Completed`

the tunnel is started. To verify that it work, just try to ping other tunnel part.

**Natting and fowarding**
Now is necessary to enable NAT and forward on your openvpn server, to allow certain flows, forwarded througt your vpn can reach internet by passing on your home router.

Just apply this few rules:

> `/bin/echo "1" > /proc/sys/net/ipv4/ip_forward iptables -A FORWARD -i tun0 -j ACCEPT iptables -t nat -A POSTROUTING -s 10.8.0.0/24 -j MASQUERADE`

now the server configuration is done.

Now we have to create static routes:

> `route add -host ip_you_want_to_staticize gw your_vpn_tunnel_address`

for example: jabber, you have to retrieve your jabber server ip address, and insert into route command.as “ip\_you\_want\_to\_staticize”.

If you don’t have a dns into your subnet, to maintain transparency in applications, is better to use /etc/hosts to map every ip address to his name.

I’m using vpn only for jabber and email, I want to use also mugshot but it doesn’t work…dunno why.

Thanks to [Kiwi](http://blog.kiwized.net/) to help me.

This post is under construction…so If you have suggestion or any issue to propose me, don’t hesitate to tell me.

[About these ads](http://en.wordpress.com/about-these-ads/)

### Rate this:

 

2 Votes

### Share this:

* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=digg&nb=1>

* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=stumbleupon&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/#print>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=reddit&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=facebook&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=linkedin&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=twitter&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=google-plus-1&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=tumblr&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=pocket&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=email&nb=1>
* <http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?share=pinterest&nb=1>

### Google+

[![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.4.jpg]]](https://plus.google.com/116910155964313991213)[Luca Foppiano](https://plus.google.com/116910155964313991213)

### Like this:

_Related_

**[How to use spotify from any place](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?relatedposts_to=3528&relatedposts_order=0)**
—In "knowledge"

**[Some humble suggestions on how to improve Wordpress for IOS](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?relatedposts_to=3677&relatedposts_order=1)**
—In "knowledge"

**[New York City](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/?relatedposts_to=3657&relatedposts_order=2)**
—In "travels"

[July 24, 2008](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/)[Luca Foppiano](http://blog.foppiano.org/author/bayzone/)  [linux](http://blog.foppiano.org/tag/linux/), [networking](http://blog.foppiano.org/tag/networking/), [openvpn](http://blog.foppiano.org/tag/openvpn/), [proxy](http://blog.foppiano.org/tag/proxy/), [routing](http://blog.foppiano.org/tag/routing/), [static](http://blog.foppiano.org/tag/static/)

# Post navigation

[← What about symbolic?](http://blog.foppiano.org/2008/07/23/what-about-symbolic/)
[alitaGlia →](http://blog.foppiano.org/2008/07/25/alitaglia/)

## 8 thoughts on “How to OpenVPN over Proxy”

1. ![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.2.png]]
	
	Almar says:
	[July 29, 2008 at 5:58 pm](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/#comment-13092)
	
	Hi. I’m going to give this a try. At some locations I can’t use IM, which is quite annoying.
	NB. The link to the openvpn howto (this official howto section) is invallid.
	
	3
	
	3
	
	 
	
	Rate This
	
2. 
	![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.3.jpg]]
	
	[whitenoise](http://www.foppiano.org/) says:
	[July 29, 2008 at 7:20 pm](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/#comment-13093)
	
	Try it and tell me if you find errors or something else.
	Thanks almar for feedback, I corrected openvpn howto link.
	
	2
	
	2
	
	 
	
	Rate This
	
3. ![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.1.png]]
	
	[Unblock Me](http://www.proxypromote.com/) says:
	[January 29, 2009 at 7:03 pm](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/#comment-13266)
	
	Just wanted to thank you for a really good post. I found it quite useful and will check your site often.
	
	4
	
	3
	
	 
	
	Rate This
	
4. ![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.5.png]]
	
	Dave says:
	[March 5, 2009 at 10:32 pm](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/#comment-13314)
	
	Thanks, this is a great article. Thanks!
	
	3
	
	6
	
	 
	
	Rate This
	
5. ![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.8.jpg]]
	
	[kang@paidjo](http://www.paidjo.web.id/) says:
	[March 26, 2010 at 1:14 am](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/#comment-13638)
	
	Thanks, this is a great article.
	Thanks!
	
	2
	
	1
	
	 
	
	Rate This
	
6. Pingback: [How to OpenVPN over Proxy](http://www.edisonnotes.com/how-to-openvpn-over-proxy/) ~
7. ![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.7.png]]
	
	massimo says:
	[November 13, 2010 at 3:18 pm](http://blog.foppiano.org/2008/07/24/how-to-openvpn-over-proxy/#comment-13859)
	
	hi , nice your post but , the rule of the nat don’t work , I use this :
	
	iptables -t nat -I PREROUTING -p udp -i eth0 –dst myvpnserver –dport 443 -j REDIRECT –to-ports 1194
	
	3
	
	0
	
	 
	
	Rate This
	
8. Pingback: [VPN o SSH attraverso proxy web: qualche consiglio?](http://www.jeby.it/2009/04/vpn-o-ssh-attraverso-proxy-web-qualche-consiglio/) ~

### Leave a Reply

# Behind the scene

* [![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.jpg]]](http://blog.foppiano.org/author/bayzone/)

Search

[ambassador](http://blog.foppiano.org/tag/ambassador/) [Apple](http://blog.foppiano.org/tag/apple/) [berlin](http://blog.foppiano.org/tag/berlin/) [blog](http://blog.foppiano.org/tag/blog/) [byte-code](http://blog.foppiano.org/tag/byte-code/) [city](http://blog.foppiano.org/tag/city/) [development](http://blog.foppiano.org/tag/development/) [english](http://blog.foppiano.org/tag/english/) [europe](http://blog.foppiano.org/tag/europe/) [event](http://blog.foppiano.org/tag/event/) [events](http://blog.foppiano.org/tag/events/) [facebook](http://blog.foppiano.org/tag/facebook/) [fedora](http://blog.foppiano.org/tag/fedora/) [fedoraproject](http://blog.foppiano.org/tag/fedoraproject/) [flickr](http://blog.foppiano.org/tag/flickr/) [food](http://blog.foppiano.org/tag/food/) [freesoftware](http://blog.foppiano.org/tag/freesoftware/) [free software](http://blog.foppiano.org/tag/free-software/) [fudcon](http://blog.foppiano.org/tag/fudcon/) [fun](http://blog.foppiano.org/tag/fun/) [func](http://blog.foppiano.org/tag/func/) [geek](http://blog.foppiano.org/tag/geek/) [GNOME](http://blog.foppiano.org/tag/gnome/) [grails](http://blog.foppiano.org/tag/grails/) [groovy](http://blog.foppiano.org/tag/groovy/) [holland](http://blog.foppiano.org/tag/holland/) [IFTTT](http://blog.foppiano.org/tag/ifttt/) [instagram](http://blog.foppiano.org/tag/instagram/) [it](http://blog.foppiano.org/tag/it/) [italian](http://blog.foppiano.org/tag/italian/) [italy](http://blog.foppiano.org/tag/italy/) [java](http://blog.foppiano.org/tag/java/) [landscape](http://blog.foppiano.org/tag/landscape/) [life](http://blog.foppiano.org/tag/life/) [linux](http://blog.foppiano.org/tag/linux/) [linux day](http://blog.foppiano.org/tag/linux-day/) [linux tag](http://blog.foppiano.org/tag/linux-tag/) [Lodi](http://blog.foppiano.org/tag/lodi/) [LOLUG](http://blog.foppiano.org/tag/lolug/) [lug](http://blog.foppiano.org/tag/lug/) [meeting](http://blog.foppiano.org/tag/meeting/) [morocco](http://blog.foppiano.org/tag/morocco/) [music](http://blog.foppiano.org/tag/music/) [nature](http://blog.foppiano.org/tag/nature/) [nerd](http://blog.foppiano.org/tag/nerd/) [netherlands](http://blog.foppiano.org/tag/netherlands/) [new york](http://blog.foppiano.org/tag/new-york/) [new zealand](http://blog.foppiano.org/tag/new-zealand/) [ny](http://blog.foppiano.org/tag/ny/) [opensource](http://blog.foppiano.org/tag/opensource/) [party](http://blog.foppiano.org/tag/party/) [photo](http://blog.foppiano.org/tag/photo/) [photos](http://blog.foppiano.org/tag/photos/) [picture](http://blog.foppiano.org/tag/picture/) [pictures](http://blog.foppiano.org/tag/pictures/) [Pocket](http://blog.foppiano.org/tag/pocket/) [politics](http://blog.foppiano.org/tag/politics/) [problems](http://blog.foppiano.org/tag/problems/) [programming](http://blog.foppiano.org/tag/programming/) [python](http://blog.foppiano.org/tag/python/) [quiz](http://blog.foppiano.org/tag/quiz/) [rotfl](http://blog.foppiano.org/tag/rotfl/) [software](http://blog.foppiano.org/tag/software/) [sport](http://blog.foppiano.org/tag/sport/) [symbolic](http://blog.foppiano.org/tag/symbolic/) [talk](http://blog.foppiano.org/tag/talk/) [travel](http://blog.foppiano.org/tag/travel/) [trip](http://blog.foppiano.org/tag/trip/) [ubuntu](http://blog.foppiano.org/tag/ubuntu/) [university](http://blog.foppiano.org/tag/university/) [us](http://blog.foppiano.org/tag/us/) [video](http://blog.foppiano.org/tag/video/) [vimeo](http://blog.foppiano.org/tag/vimeo/) [xkcd](http://blog.foppiano.org/tag/xkcd/) [youtube](http://blog.foppiano.org/tag/youtube/)

# [Twitter Updates](http://twitter.com/whitenoise)

* RT @[mindfuleveryday](http://twitter.com/mindfuleveryday): Your past is just a story. And once you realize this, it has no power over you. (via @[BorderlineInfo](http://twitter.com/BorderlineInfo)) [#mindfulness](http://twitter.com/search?q=%23mindfulness) [4 hours ago](http://twitter.com/whitenoise/statuses/424093458828365824)

* RT @[GuyKawasaki](http://twitter.com/GuyKawasaki): A practical primer for appreciating art \[comic\] [is.gd/OuwyMy](http://is.gd/OuwyMy) [4 hours ago](http://twitter.com/whitenoise/statuses/424092952710103040)
* Pipeline Winter 2013 by Eric Sterman [ift.tt/LaQ2bR](http://ift.tt/LaQ2bR) [18 hours ago](http://twitter.com/whitenoise/statuses/423883045553573889)
* Stunning public domain images from space [bittbox.com/resources/35-s…](http://www.bittbox.com/resources/35-stunning-hi-res-public-domain-astronomy-images) [1 day ago](http://twitter.com/whitenoise/statuses/423520773874417664)
* Urriak Hogeita Zortzi by jon aspuru [ift.tt/1cnpiLa](http://ift.tt/1cnpiLa) [2 days ago](http://twitter.com/whitenoise/statuses/423416413538500608)

# Meta

* [Register](http://wordpress.com/signup/?ref=wplogin)

* [Log in](http://bayzone.wordpress.com/wp-login.php)
* [Entries RSS](http://blog.foppiano.org/feed/)
* [Comments RSS](http://blog.foppiano.org/comments/feed/)
* [WordPress.com](http://wordpress.com/)

# Blog Stats

* 165,013 hits

[Blog at WordPress.com](http://wordpress.com/?ref=footer). ~ [The Syntax Theme](http://theme.wordpress.com/themes/syntax/).

[[#|Follow]]

### Follow “Thinking and inspiration”

Get every new post delivered to your Inbox.

Join 76 other followers

[Powered by WordPress.com](http://wordpress.com/signup/?ref=lof)

![[./_resources/How_to_OpenVPN_over_Proxy__Thinking_and_inspiration_blog.foppiano.org.resources/resource.6.gif]]
