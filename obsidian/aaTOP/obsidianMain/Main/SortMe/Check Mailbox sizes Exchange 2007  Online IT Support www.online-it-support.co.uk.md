# Check Mailbox sizes Exchange 2007 | Online IT Support [www.online-it-support.co.uk]

get size of mailboxes in ex2007.

* * *

## Your gateway to the I.T World

* [Home](http://www.online-it-support.co.uk)

* [Terms](http://www.online-it-support.co.uk/?page_id=2)
* [Contact Us](http://www.online-it-support.co.uk/?page_id=467)

[![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.10.gif]]](http://www.online-it-support.co.uk/?feed=rss)

# [Online IT Support](http://www.online-it-support.co.uk)

# Check Mailbox sizes Exchange 2007

Microsoft Exchange 2007 will not allow you to check Mailbox sizes unless you access each mailbox one at a time. To list mailbox sizes, do the following:

1) Access your Exchange Server
2) Open Exchange Management Shell
3) Type or copy the below command and press enter:

Get-MailboxStatistics | Sort-Object TotalItemSize -Descending | ft DisplayName,@{label=”TotalItemSize(MB)”;expression={$\_.TotalItemSize.Value.ToMB()}},ItemCount

You can now select all and copy to a notepad to analyse the data

          [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.9.png]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkerdigg&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.gif]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkerfacebook&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.2.gif]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkerfurl&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.3.png]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkergoogle&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.8.gif]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkermisterwong&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.11.gif]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkerreddit&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.7.png]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkerspurl&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.6.png]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkersphere&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.1.png]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkerstumble&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.5.png]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkertechnorati&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007) [![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.12.gif]]](http://www.online-it-support.co.uk/wp-content/plugins/obsocialbookmarker/include/obsocialbookmarker_redirect.php?site=obsocialbookmarkerwindowslive&link=http%3A%2F%2Fwww.online-it-support.co.uk%2F%3Fp%3D321&title=Check+Mailbox+sizes+Exchange+2007)

[May 28, 2009](http://www.online-it-support.co.uk/2009/05/) • Tags: [mailbox sizes exchange 2007](http://www.online-it-support.co.uk/?tag=mailbox-sizes-exchange-2007) • Posted in: [Software](http://www.online-it-support.co.uk/?cat=18)

# One Response to “Check Mailbox sizes Exchange 2007”

1. ![4c2a87be38c5994f2e58b4dd98b215ed?s=32&d=http%3A%2F%2Fwww.online-it-support.co.uk%2Fwp-includes%2Fimages%2Fblank.gif&r=G](http://www.gravatar.com/avatar/4c2a87be38c5994f2e58b4dd98b215ed?s=32&d=http%3A%2F%2Fwww.online-it-support.co.uk%2Fwp-includes%2Fimages%2Fblank.gif&r=G) James - July 25th, 2009
	
	What a relief. I have been trying to work out how to do this for hours. Your are a life saver.
	
	Thank you so much!
	

# Leave a Reply

Name, required

Email, will not be published, required

Website

Comments links are nofollow free [click here for details](http://www.online-it-support.co.uk/?p=815).

Enter your email address:

Delivered by [FeedBurner](http://www.feedburner.com)

[![[./_resources/Check_Mailbox_sizes_Exchange_2007__Online_IT_Support_www.online-it-support.co.uk.resources/unknown_filename.4.png]]](http://feeds.feedburner.com/onlineITsupport) [Subscribe in a reader](http://feeds.feedburner.com/onlineITsupport)

## Recent Posts

* [Server error: You are not authorized to use the server Domino](http://www.online-it-support.co.uk/?p=1075)

* [Create security enhanced redirected folders](http://www.online-it-support.co.uk/?p=1067)
* [How to check amount of free white space in Exchange Database](http://www.online-it-support.co.uk/?p=1065)
* [Slow Citrix Logons](http://www.online-it-support.co.uk/?p=1063)
* [Applying Internet Explorer Branding Policy](http://www.online-it-support.co.uk/?p=1061)
* [Shutdown machine via scheduled task](http://www.online-it-support.co.uk/?p=1057)
* [Disable Dr Watson via registry](http://www.online-it-support.co.uk/?p=1055)
* [Change name of ‘My Documents’ folder via registry](http://www.online-it-support.co.uk/?p=1053)
* [Change My Computer name to username and machine name via registry](http://www.online-it-support.co.uk/?p=1051)
* [Disable CDROM Autorun via registry](http://www.online-it-support.co.uk/?p=1050)
	
	* [Announcements](http://www.online-it-support.co.uk/?cat=706)
	* [Citrix](http://www.online-it-support.co.uk/?cat=629)
	* [Data](http://www.online-it-support.co.uk/?cat=19)
	* [Hardware](http://www.online-it-support.co.uk/?cat=17)
	* [Lotus Notes](http://www.online-it-support.co.uk/?cat=717)
	* [Networking](http://www.online-it-support.co.uk/?cat=20)
	* [Pranks](http://www.online-it-support.co.uk/?cat=88)
	* [Scripts](http://www.online-it-support.co.uk/?cat=618)
	* [Search Engines](http://www.online-it-support.co.uk/?cat=24)
	* [Security](http://www.online-it-support.co.uk/?cat=6)
	* [Seo](http://www.online-it-support.co.uk/?cat=8)
	* [Software](http://www.online-it-support.co.uk/?cat=18)
	* [Spyware and Adware](http://www.online-it-support.co.uk/?cat=16)
	* [Websites](http://www.online-it-support.co.uk/?cat=21)
	* [Windows 7](http://www.online-it-support.co.uk/?cat=822)
	
	* [October 2010](http://www.online-it-support.co.uk/?m=201010)
	* [September 2010](http://www.online-it-support.co.uk/?m=201009)
	* [August 2010](http://www.online-it-support.co.uk/?m=201008)
	* [July 2010](http://www.online-it-support.co.uk/?m=201007)
	* [June 2010](http://www.online-it-support.co.uk/?m=201006)
	* [May 2010](http://www.online-it-support.co.uk/?m=201005)
	* [April 2010](http://www.online-it-support.co.uk/?m=201004)
	* [March 2010](http://www.online-it-support.co.uk/?m=201003)
	* [February 2010](http://www.online-it-support.co.uk/?m=201002)
	* [January 2010](http://www.online-it-support.co.uk/?m=201001)
	* [December 2009](http://www.online-it-support.co.uk/?m=200912)
	* [November 2009](http://www.online-it-support.co.uk/?m=200911)
	* [October 2009](http://www.online-it-support.co.uk/?m=200910)
	* [September 2009](http://www.online-it-support.co.uk/?m=200909)
	* [August 2009](http://www.online-it-support.co.uk/?m=200908)
	* [July 2009](http://www.online-it-support.co.uk/?m=200907)
	* [June 2009](http://www.online-it-support.co.uk/?m=200906)
	* [May 2009](http://www.online-it-support.co.uk/?m=200905)
	* [April 2009](http://www.online-it-support.co.uk/?m=200904)
	* [January 2009](http://www.online-it-support.co.uk/?m=200901)
	* [November 2008](http://www.online-it-support.co.uk/?m=200811)
	
	* [Internet Proxy](http://www.online-it-support.co.uk/internetproxy/) - Surf the web anonymously
	* [IT Support For Schools](http://www.sana-tech.net/schools.html)
	* [IT Support Halifax](http://www.sana-tech.net/) - IT Services
	* [Web Design Halifax](http://www.sana-tech.net/web_design.html) - Web Design Services
	
	* [Log in](http://www.online-it-support.co.uk/wp-login.php)
	* [Entries RSS](http://www.online-it-support.co.uk/wp-rss2.php)
	* [Comments RSS](http://www.online-it-support.co.uk/wp-commentsrss2.php)
	

* [« Previous post](http://www.online-it-support.co.uk/?p=314)

* [Next post »](http://www.online-it-support.co.uk/?p=323)
© [Online IT Support](http://www.online-it-support.co.uk).
Powered by [WordPress](http://wordpress.org), styled by [Grey Matter](http://masnikov.com/grey_matter).
