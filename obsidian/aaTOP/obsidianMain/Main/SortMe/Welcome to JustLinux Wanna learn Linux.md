# Welcome to JustLinux: Wanna learn Linux?

 

[![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/ln.gif]]](http://www.justlinux.com/)
Mon, 24-Aug-2009 20:46:34 GMT
Forum: [Registered](http://www.justlinux.com/forum/register.php?action=signup) Users: **73334**, [Online:](http://www.justlinux.com/forum/online.php) **189**
       

## Help File Library: Fly Swapping

Written By: [test](mailto:evil@freakish.f9.co.uk)

## A little Background

Fly swapping or as it should be called, Swap on-the-Fly allows the addition of swap space as and when needed. This is very handy if you have just ran out of Memory while trying to do a big compile or, more often, you mis-configured your swap at installation and ran out of memory before even X starts.

Though this process is by no means a solution to the problem (there are speed implications) it is non the less a nice quick fix, and I have used this method on many Unix variants.

## How do we do it

Well first we must be root to do this, the we need to use the command "dd" to create a swap file, this is not too bad.

Decide how much more swap you need, but dont worry too much since you can add multiple swap files.

Lets take an example that we need 20Mb more of swap, so first we execute the command :-

"dd if=/dev/zero of=/usr/local/newswap bs=1000000 count=20"

This will go and create a file of 20Mb called newswap in the /usr/local directory and it will be filled with zero's.

We must next format the file to accept being used as a swap file, first we must set its permissions so everyone on the system can use it, use the command :-

"chmod 600 /usr/local/newswap"

Now we actualy apply a file system to the file (bit of a strange concept, but hey ;) ), use the command :-

"mkswap /usr/loca/newswap"

Nearly done now, all that needs to be done is to mount it, this can be achieved useing this command :-

"swapon /usr/local/newswap"

And with any luck if you type swapon -s you should see the file listed...

You can have this swap file, and others, mounted during bootup, by editing your /etc/fstab and under the current swap mounting add

"/location/to/swapfile swap swap defaults 0 0"

Don't forget to change "/location/to/swapfile" to the actual location of the swapfile, such as /usr/local/newswap.

If at any time you wih to stop useing this swap file, just issue the command (as root) "swapoff /location/to/swapfile"

And now a little script to automate the process

#!/bin/sh

if \[ \`id | awk '{print$1}' | tr "()" " " | awk '{print$2}'\` != root \];
then
  clear
  echo "You must be logged in as root to build images."
  exit 1
fi

dd if=/dev/zero of=/usr/local/${1}-megs bs=1000000 count=$1
chmod 777 /usr/local/${1}-megs
mkswap /usr/local/${1}-megs
swapon /usr/local/${1}-megs

\# Remove the next line to NOT auto mount at bootup

echo "/usr/local/${1}-megs       swap   swap  defaults   0 0" >>
/etc/fstab

if swapon -s | grep -q ${1} ; then
     echo "Fly Swap was sucessfull"
     echo
fi

This will allow you to excute the command "fly-swap.sh 20" and get the same results as the example. The parameter is the number of megs you want.

![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/icomtop.gif]]
![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/clear.gif]]![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/clear.gif]]![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/clear.gif]][IT](http://www.internet.com/it)
[Developer](http://www.internet.com/developer)
[Internet News](http://www.internetnews.com/)
[Small Business](http://www.smallbusinesscomputing.com/)
[Personal Technology](http://www.internet.com/personaltechnology)
[Search internet.com](http://search.internet.com/)
[Advertise](http://www.internet.com/mediakit)
[Corporate Info](http://www.webmediabrands.com/corporate)
[Newsletters](http://e-newsletters.internet.com/)
[Tech Jobs](http://www.justtechjobs.com/)
[E-mail Offers](http://e-newsletters.internet.com/mailinglists.html)![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/clear.gif]]
![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/commercetop.gif]]
![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/clear.gif]]![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/clear.gif]]![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/clear.gif]][Be a Commerce Partner](http://www.internet.com/partners)
[Car Donations](http://www.carangel.com/) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp1) 
[Online Universities](http://www.elearners.com/) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp2) 
[Boat Donations](http://www.boatangel.org/) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp3) 
[IT Careers](http://mjxads.internet.com/RealMedia/ads/click_lx.cgi/intm/it/www.justlinux.com/nhf/Filesystems/L4/1255778758/cp4/WMBrands/House_justtechjobs_14zy/ITCareers.html/502b4a646d5571532f433841422b532f) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp4) 
[IT Legal Contracts](http://www.contractedge.com/) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp5) 
[PDA Phones & Cases](http://shopping.yahoo.com/b:PDAs:20148420) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp6) 
[Business Liability](http://www.techsinsurance.com/) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp7) 
[Dedicated Servers](http://mjxads.internet.com/RealMedia/ads/click_lx.cgi/intm/it/www.justlinux.com/nhf/Filesystems/L4/645178247/cp8/WMBrands/Colocation_America_CP_10e/DedicatedServers.html/502b4a646d5571532f433841422b532f) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp8) 
[Desktop Computers](http://shopping.yahoo.com/b:Desktops:22483485) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp9) 
[Online Education](http://www.elearners.com/) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]] [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!cp10)![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/clear.gif]]

[![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/502b4a646d5571532f433841422b532f-.gif]]](http://mjxads.internet.com/RealMedia/ads/click_lx.ads/intm/it/www.justlinux.com/nhf/Filesystems/L7/1905810236/468x60-2/WMBrands/MSFT_Virtual_SC_GEMS_1f/MSVirtSC_LEO_CostVideo.gif/502b4a646d5571532f433841422b532f) [![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/Filesystems@send,house_ribbon,468x60-1,125x800,468.1.gif]]](http://63.236.18.118/RealMedia/ads/click_nx.ads/intm/it/www.justlinux.com/nhf/Filesystems@send,house_ribbon,468x60-1,125x800,468x60-2,cp1,cp10,cp11,cp12,cp13,cp14,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9!468x60-2)

![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/wmb_footer.png]]

[![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/intm_footer.png]]](http://www.internet.com/)![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/ruledivide_foot.gif]][![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/mb_footer.png]]](http://www.mediabistro.com/)![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/ruledivide_foot.gif]][![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/jtj_footer.png]]](http://www.justtechjobs.com/)![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/ruledivide_foot.gif]][![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/gdc_footer.png]]](http://www.graphics.com/)

**Search:**

[WebMediaBrands Corporate Info](http://www.webmediabrands.com/)
Copyright 2009 WebMediaBrands Inc. All Rights Reserved. Copyright 2009 WebMediaBrands Inc. All Rights Reserved.

[Legal Notices](http://www.webmediabrands.com/corporate/legal.html), [Licensing](http://www.webmediabrands.com/corporate/reprints.html#Licensing1), [Reprints](http://www.webmediabrands.com/corporate/reprints.html#Reprints1), [Permissions](http://www.webmediabrands.com/corporate/reprints.html#Permissions), [Privacy Policy](http://www.webmediabrands.com/corporate/privacy/privacypolicy.html).
[Advertise](http://www.internet.com/mediakit) | [Newsletters](http://e-newsletters.internet.com/) | [Shopping](http://www.internetshopper.com/) | [E-mail Offers](http://e-newsletters.internet.com/announcement_list.html) | [Freelance Jobs](http://freelancer.internet.com/) ![[./_resources/Welcome_to_JustLinux_Wanna_learn_Linux.resources/icon_new.jpg]]

[Solutions](http://www.justlinux.com/nhf/Filesystems/Fly_Swapping.html#)

## Whitepapers and eBooks

|     |     |     |
| --- | --- | --- |
| [Internet.com eBook: Becoming a Better Project Manager](http://www.devx.com/ebook/Article/38087)<br>[Microsoft Partner Portal: What Azure Means for Microsoft Partners](http://www.devx.com/MS_Partner/Door/35665)<br>[Internet.com eBook: Web Development Frameworks for Java](http://www.devx.com/ebook/Article/40784) |     | [Internet.com eBook: Developing a Content Management System Strategy](http://www.devx.com/ebook/Article/40319)<br>[MORE WHITEPAPERS, EBOOKS, AND ARTICLES](http://www.devx.com/solutions) |

## Webcasts

|     |     |     |
| --- | --- | --- |
| [SAP BusinessObjects Webcast: Unlock the Power of Reporting](http://www.devx.com/Webcasts/Door/42469)<br>[Ipswitch Video: A Closer Look--WS_FTP Server](http://solutions.internet.com/6036_closerLook) |     | [MORE WEBCASTS, PODCASTS, AND VIDEOS](http://www.devx.com/solutions) |

## Downloads and eKits

|     |     |     |
| --- | --- | --- |
| [Amyuni: PDF & PDF/A Engine for .NET and ActiveX Apps](http://www.devx.com/Amyuni/Door/39454)<br>[Iron Speed Designer Application Generator](http://www.devx.com/IronSpeedVS/Door/17479) |     | [MORE DOWNLOADS, EKITS, AND FREE TRIALS](http://www.devx.com/solutions) |

## Tutorials and Demos

|     |     |     |
| --- | --- | --- |
| [Internet.com Hot List: Get the Inside Scoop on the Hottest IT and Developer Products](http://www.devx.com/HotList/Link/40644) |     | [MORE TUTORIALS, DEMOS AND STEP-BY-STEP GUIDES](http://www.devx.com/solutions) |
