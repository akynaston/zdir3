# How to get security updates for Windows XP until April 2019 - gHacks Tech News [www.ghacks.net]

<https://plus.google.com/107836925448900328328/>

[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/unknown_filename.jpeg]]](http://www.ghacks.net/)

* [Home](http://www.ghacks.net/)

* [Windows](http://www.ghacks.net/category/windows/)
* [Software](http://www.ghacks.net/category/software/)
* [Firefox](http://www.ghacks.net/category/firefox/)
* [Google](http://www.ghacks.net/category/google/)
* [Chrome](http://www.ghacks.net/category/google-chrome-browsing/)
* [Android](http://www.ghacks.net/category/google-android-mobiles/)
* [Email](http://www.ghacks.net/category/email/)
* [Internet](http://www.ghacks.net/category/the-web/)
* [Best of](http://www.ghacks.net/best-of/)
* [Contact](http://www.ghacks.net/contact/)

You are here: [Home](http://www.ghacks.net/) > [Windows](http://www.ghacks.net/category/windows/) > How to get security updates for Windows XP until April 2019

# How to get security updates for Windows XP until April 2019

By [Martin Brinkmann](http://www.ghacks.net/author/martin/) on May 24, 2014 in [Windows](http://www.ghacks.net/category/windows/) - Last Update: May 24, 2014 [__ 44](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comments)

Advertisement

Microsoft's official support for the Windows XP operating system ended more than a month ago. While some companies and organizations are still receiving updates for the operating system, end users do not.

These companies pay Microsoft for that, usually because they were not able or willed to migrate computer's running Windows XP to another operating system before the extended support phase for the system ended.

There is another exception to the end of support rule: Windows Embedded Industry, formerly known as Windows Embedded POSReady, operating systems continue to receive updates.

What makes this interesting is the fact that Windows Embedded POSReady 2009 is based on Windows XP Service Pack 3, and that the security updates released for that system are identical with the ones that Microsoft would have released for XP systems.

The extended support for Windows Embedded POSReady 2009 systems ends on April 9th, 2019 which means that you can use the trick to get another five years of security patches for XP.

[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/windows-xp-updates.jpg]]](http://cdn.ghacks.net/wp-content/uploads/2014/05/windows-xp-updates.jpg)

What you cannot do is go ahead and install those updates as you will get a version mismatch error when you try to do so. There is however a trick that you can use to bypass those checks so that you can install those updates on your version of Windows XP.

**Note**: The trick works only for 32-bit versions of Windows XP SP3 and not 64-bit versions. While POSReady systems are very similar to Windows XP systems, it is recommended to back up the system before you make any changes as differences between the systems may result in issues after installing updates designed for it.

All you need to do is add the following to the Windows XP Registry:

> 
> 
> Windows Registry Editor Version 5.00
> 
> \[HKEY\_LOCAL\_MACHINE\\SYSTEM\\WPA\\PosReady\]
> "Installed"=dword:00000001

I have uploaded a Registry file for you that you can use for that purpose. You can download it here: [xp-security-updates.zip (17657 downloads)](http://www.ghacks.net/download/103309/)

If you prefer to create one on your own do the following:

1. Create a new plain text document.

* Paste the contents displayed above into it.
* Save the new document as xp.reg.
* Double-click the Registry file afterwards to add the contents to the Registry.

Alternatively, open the Registry Editor manually: tap on Windows-r, type regedit and hit enter. Navigate to the key listed above and create a new Dword with the value listed there as well. (via [Desk Modder](http://www.deskmodder.de/blog/2014/05/24/windows-xp-weiterhin-aktuell-halten-und-updates-herunterladen/) and [Sebijk](http://www.sebijk.com/community/board15-sonstiges/board73-tutorials/2984-xp-updates-weiterbeziehen/?s=fe09796308d8147b841dc5b6be5f0fbf70783dda))

Both source sites are in German. If you open the Sebijk site, you will also find instructions on how to get this to work on 64-bit Windows XP systems. It involves running a batch file that replaces original update files with temporary ones that bypass the restrictions set in place.

**Closing Words**

If you are running Windows XP and do not want to switch to a new system or cannot, then you may want to try this trick to install security patches designed for the POSReady 2009 operating system on your PC.

I recommend highly that you create a backup before you update the system as there is no guarantee that all updates will work properly on XP PCs. While POSReady 2009 uses the same core, some things are different after all.

Nevertheless, this is better than not installing any security updates.

Summary

![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/windows-xp-updates.jpg]]

Article Name
How to get security updates for Windows XP until April 2019

Author
Martin Brinkmann

Description
Support for Windows XP ended April 2014. but there is a trick that you can make use of to get security updates for the operating system.

**Related Articles**

* [Windows XP users will still get some security-related updates after April 8, 2014](http://www.ghacks.net/2014/01/16/windows-xp-users-will-still-get-security-updates-april-8-2014/)

* [Microsoft Security Updates April 2010](http://www.ghacks.net/2010/04/13/microsoft-security-updates-april-2010/)
* [Windows Security Updates September 2008](http://www.ghacks.net/2008/09/10/windows-security-updates-september-2008/)
**Please share this article**
[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/facebook.png]]](http://www.facebook.com/sharer.php?u=http%3A%2F%2Fwww.ghacks.net%2F2014%2F05%2F24%2Fget-security-updates-windows-xp-april-2019%2F&t=How%20to%20get%20security%20updates%20for%20Windows%20XP%20until%20April%202019&s=100&p[url]=http%3A%2F%2Fwww.ghacks.net%2F2014%2F05%2F24%2Fget-security-updates-windows-xp-april-2019%2F&p[images][0]=http%3A%2F%2Fwww.ghacks.net%2Fwp-content%2Fuploads%2F2014%2F05%2Fwindows-xp-updates.jpg&p[title]=How%20to%20get%20security%20updates%20for%20Windows%20XP%20until%20April%202019)[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/twitter.png]]](http://twitter.com/share?url=http%3A%2F%2Fwww.ghacks.net%2F2014%2F05%2F24%2Fget-security-updates-windows-xp-april-2019%2F&text=Hey%20check%20this%20out)[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/google_plus.png]]](https://plus.google.com/share?url=http%3A%2F%2Fwww.ghacks.net%2F2014%2F05%2F24%2Fget-security-updates-windows-xp-april-2019%2F)[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/reddit.png]]](http://www.reddit.com/submit?url=http%3A%2F%2Fwww.ghacks.net%2F2014%2F05%2F24%2Fget-security-updates-windows-xp-april-2019%2F&title=How%20to%20get%20security%20updates%20for%20Windows%20XP%20until%20April%202019)[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/linkedin.png]]](http://www.linkedin.com/shareArticle?mini=true&url=http%3A%2F%2Fwww.ghacks.net%2F2014%2F05%2F24%2Fget-security-updates-windows-xp-april-2019%2F&title=How%20to%20get%20security%20updates%20for%20Windows%20XP%20until%20April%202019)[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/mail.png]]](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/mailto:?subject=How%20to%20get%20security%20updates%20for%20Windows%20XP%20until%20April%202019&body=Hey%20check%20this%20out:%20http%3A%2F%2Fwww.ghacks.net%2F2014%2F05%2F24%2Fget-security-updates-windows-xp-april-2019%2F)

* * *

**Advertisement**

#### About Martin Brinkmann

Martin Brinkmann is a journalist from Germany who founded Ghacks Technology News Back in 2005. He is passionate about all things tech and knows the Internet and computers like the back of his hand. You can follow Martin on [Facebook](http://www.facebook.com/ghacks), [Twitter](https://twitter.com/ghacks) or [Google+](https://plus.google.com/115604903045061277330?rel=author)
[View all posts by Martin Brinkmann →](http://www.ghacks.net/author/martin/)

__ Filed under: [Windows XP](http://www.ghacks.net/tag/windows-xp/)

[__ MailTrack for Chrome tracks if Gmail emails are read: here is how it works](http://www.ghacks.net/2014/05/24/mailtrack-chrome-tracks-gmail-emails-read-works/)
[Listen Audiobook Player for Android __](http://www.ghacks.net/2014/05/25/listen-audiobook-player-android/)

### Responses to _How to get security updates for Windows XP until April 2019_

		**DrTeeth** May 25, 2014 at 5:39 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2138717)
	
	I hope this works, then I won't have the pain of migrating my wife to Win 7.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2138717)
	

		**Peter888** May 24, 2014 at 3:02 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2134940)
	
	Waouh ! Very interesting if it works !
	I will wait for some feedback before to try it.
	Perhaps a typo : navigate to the "folder" listed above : to the key...
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2134940)
	
		**Keith** May 24, 2014 at 4:09 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2135074)
	
	I wonder how long it will be before Microsoft takes steps to block this fix. I'd love to keep XP for the next 5 years.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2135074)
	
		**Tom Hawack** May 24, 2014 at 7:08 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2135494)
	
	October 25, 2001 - April 9th, 2019 ... that would bring XP to almost 18 years of service. Wow.
	
	The trick is most valuable and if it hadn't been for my old XP equipped computer which left for heaven (or hell) in August 2013, I'd breath this information like a gift :)
	
	Windows XP will maybe appear to be the most successful Microsoft OS. I remember my anxiety when switching from Win95 to what was then the brand new XP. Like when switching to Win7. And, well, no point in getting anxious, in fact less and less point in being worried perhaps (anyway, for using the machine), because everything is easier and easier to use. I recall for instance how complicated it was at one time to update a simple Adobe Flash ... nowadays automatism is everywhere, we spend less time thinking how to use the car and therefor brains are supposed to be left for thinking where to go with it :)
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2135494)
	
			**Dave** May 24, 2014 at 8:28 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2135675)
		
		It's interesting. Getting any updates has been problematic. I had to get SP2 and SP3 manually, as well as the Windows Installer update and IE8. So far I've not been able to get any automatic updates at all, though that's partly because there's no easy way to initiate a check.
		
		This script is the best I've found so far. It ran successfully, but there's still no indication that any updates are available.
		<http://community.spiceworks.com/attachments/post/0000/2355/Force_WSUS_Updates.cmd.txt>
		
			**Dave** May 24, 2014 at 9:01 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2135748)
		
		Updates are working fine now that SP3 is installed and I've activated Windows. Once I've got all updates, I guess I'll check back in the future to see if new ones are available :)
		
	
			**Cassandra** May 26, 2014 at 8:55 am [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2140556)
		
		Dave, to intitiate a manual check of updates, do this:
		Start -> Run -> wuauclt.exe /detectnow
		
		[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2140556)
		
	
			**Gaurav** May 25, 2014 at 1:49 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2138278)
		
		Windows Update/Microsoft Update also works fine.
		
		[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2138278)
		
	
			**InterestedBystander** May 27, 2014 at 3:54 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2145740)
		
		@Wayfarer -- Yes, Zorin is an Ubuntu-based system that looks like XP. Actually, it has a "look-changer" feature that lets you choose XP, Vista, or Win7 appearance. It has a lovely workspace-switcher as well, a feature Windows seems to have trouble implementing well. However, the file structure is likely to confuse a long-term Windows user at first -- no "C drive", and no Windows or System32 folders. The most popular distro, Linux Mint, is not meant to be a Windows clone, but it is very ergonomic and easy to use. It's also very well-maintained, polished, and draws on the large Ubuntu application repository.
		
		But even after finding a great deal of freedom and choice in Linux, I still find Windows necessary for a few niche applications. This may change a bit over time, but... well, I still use iTunes on a 2003-vintage Mac, so there you go. It's all user perception, comfort zone, and specific needs.
		
	
			**Olly** May 25, 2014 at 10:49 am [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2137926)
		
		Turns out I was thinking of an older method/post ( <http://www.msfn.org/board/topic/171814-posready-2009-updates-ported-to-windows-xp-sp3-enu/#entry1077785> ) which has since been updated with a note referencing Sebijk.
		
	
		**[NJ](http://www.nickjoll.co.uk/)** May 25, 2014 at 3:57 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2138544)
	
	You might want to italicise, 'The trick works only for 32-bit versions of Windows XP SP3 and not 64-bit versions'! Just a thought.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2138544)
	
		**dstone** May 25, 2014 at 7:53 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2138935)
	
	I've used iobit's Advanced System Care 7 free version to update windows XP, using the "Vulnerability Fix" option.
	It only downloads the important security updates.
	
	I have windows XP in Virtualbox in Win 7 pro 64bit, I'll give this patch a try.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2138935)
	
		**ditshego Ofentse** May 25, 2014 at 9:02 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2139065)
	
	I am having a problem about my security login help me please.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2139065)
	
		**FUCK-XP** May 25, 2014 at 11:20 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2139313)
	
	Fuck Windows XP, just MOVE ON ALREADY!
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2139313)
	
			**BaliRob** June 6, 2014 at 9:10 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2183651)
		
		@EGbo - I do so agree with you - it's a pity that forums as these do not monitor for such uncouth behaviour
		
		[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2183651)
		
		**BAMBI** May 26, 2014 at 4:51 am [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2140016)
	
	Insightful comment, highly valuable contribution there F.-XP
	
	Now can you go and get your Mommy so we can ask her not to let her BRAT play on her PC. (running XP no doubt)
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2140016)
	
		**Michael Angelo** May 26, 2014 at 2:58 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2141570)
	
	Re-installed Windows XP Pro today to see if this works. After adding the registry key I went back to Windows update and there were two updates included for WinPOS, so I guess, so far so good.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2141570)
	
		**xp2019** May 26, 2014 at 3:22 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2141654)
	
	That's a neat trick.
	
	See this chart for other info.
	<http://localhostr.com/files/gISSbHS/WindowsEmbeddedPOSReady2009.jpg>
	
	With a 900 file minimum install, almost makes me wish I had used it from day one.
	
	That chart also says Office may not run.
	But I guess you could just toggle that registry entry if that happened.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2141654)
	
		**Michael Angelo** May 26, 2014 at 4:20 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2141803)
	
	Well I got the "Updates has ended" message in the right hand corner and it will not let me install security update KB2868509 for XP Embedded. Can I get this update installed anyhow?
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2141803)
	
		**somms** May 26, 2014 at 7:10 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2142229)
	
	<http://i.imgur.com/RrVjG9C.jpg>
	<http://i.imgur.com/RrVjG9C.jpg>
	
	After applying this registry change on 32-bit XP SP3 install that would no longer register any more updates, now 4 more populated w/relevant screenshot attached above via Microsoft Update and were successfully applied! Very good tip and much appreciated!
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2142229)
	
		**Ron S** May 26, 2014 at 7:27 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2142280)
	
	So, Win Update worked fine, and updated with 4 files. Wasn't sure if it was necessary to run the ...for POS files, but thought these might be the OS name that displays instead of Win XP and went ahead. No problem after the post install reboot. Thanks, I guess we'll enjoy it while it lasts. Just wasn't ready to trash an older but running well PC.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2142280)
	
		**58** May 27, 2014 at 1:13 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2145291)
	
	According to Microsoft in their response in the ZDNet article concerning this registry hack, the security updates the hack enables are intended for Windows Embedded and Windows Server 2003 (EOL: July 2015) and "do not fully protect" Windows XP customers. So Microsoft still recommends updating to Windows 7 SP1 or Windows 8.1. XP users, do this registry hack at your own risk.
	
	Also, according to MSDN, the IE8 version for POSReady 2009 is different from the IE8 for XP, and installing IE updates intended for POSReady 2009 may cause undesired behavior in the normal IE8.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2145291)
	
		**[Studio Nti](http://nti.php5.cz/)** May 27, 2014 at 10:54 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2146848)
	
	Outstanding!!! That work correct.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2146848)
	
		**coakl** May 28, 2014 at 1:17 am [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2147187)
	
	One caveat: If you switch the registry to identify yourself as a POS embedded system, Windows Update will try to send you ALL POS embedded updates that you don't have. Including the ones before April 8, all the way back to 2009. That's at least 100+ patches or several hundred MB's of stuff, a.k.a. several hours of updating. Yuck.
	Before you try this trick, switch automatic updates to "Notify but don't download or install", then read the MS security bulletin to find the exact KB number of the post-April 8 update that you want. In the automatic updates pop-up box, pick just those KB numbers.
	
	Another caveat: Some MS patches rely on earlier patches. If you don't install all of the earlier POS updates (pre-April 8), the newer POS updates might not work or crash XP.
	But the more POS updates you install, the more likely you will run into problems.
	Your machine will start to look like a Borg drone (some XP, some POS).
	
	To me, this is all seems risky. I prefer other defenses: EMET, avoiding Flash and Adobe Reader, Firefox with Noscript, ad blocking HOSTS file, and setting my DNS to Symantec Norton Safeweb (still free). The web shield in Avast adds a 4th layer of malware site filtering. You could add a 5th layer with McAfee Siteadvisor / WOT / Bitdefender Trafficlight extension in Firefox.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2147187)
	
			**[Martin Brinkmann](http://www.ghacks.net/)** May 28, 2014 at 6:13 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2149807)
		
		What happens when you try to delete the key?
		
		[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2149807)
		
	
			**onequestion** May 29, 2014 at 4:01 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2153277)
		
		Yep, but already done. PCRegedit was helpful in this situation.
		BTW thanks for pointing me to the right path in the search for a good solution :-)
		
			**[Martin Brinkmann](http://www.ghacks.net/)** May 29, 2014 at 4:13 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2153303)
		
		Glad that you could work it out ;)
		
	
		**paulo oliveira** May 29, 2014 at 8:39 am [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2152123)
	
	Martin, excellent post!
	
	keep on the good work.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2152123)
	
		**ssxt** May 29, 2014 at 4:34 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2153355)
	
	And if MS blocks downloads to non-POS systems, we're in the same boat as before correct? We don't need to remove this reg key?
	Thanks
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2153355)
	
		**somms** June 11, 2014 at 1:26 am [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2198329)
	
	<http://i.imgur.com/9jpRtma.jpg>
	
	Cool! 5 More updates avail today for XP with this reg trick!
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2198329)
	
		**Badass** July 1, 2014 at 4:54 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2262624)
	
	I would like to know how to reverse this because I just wanted to try it.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2262624)
	
		**Vinny** August 8, 2014 at 11:13 pm [#](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2407456)
	
	I haven't been able to get this work-around going so my solution has been to disconnect my legacy XP machine from my router. It has 1 very important application that must be available at a moments notice. LucasArts: Tie Fighter and Balance of Power.
	
	[Reply](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#comment-2407456)
	

### Leave a Reply

Name

Email (will not be published)

Website

Notify me of followup comments via e-mail. You can also [subscribe](http://www.ghacks.net/comment-subscriptions/?srp=103308&sra=s) without commenting.

* [Popular](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#tab-pop)

* [Latest](http://www.ghacks.net/2014/05/24/get-security-updates-windows-xp-april-2019/#tab-latest)

* [My slow withdrawal from all things Google](http://www.ghacks.net/2014/07/02/slow-withdrawal-things-google/) July 2, 2014
	
* [Pale Moon author confirms that browser will not ship with EME, ads or Australis](http://www.ghacks.net/2014/05/21/palemoon-author-confirms-browser-will-ship-eme-ads-australis/) May 21, 2014
	
* [10 Programs that Microsoft should integrate into Windows 9](http://www.ghacks.net/2014/08/13/10-programs-that-microsoft-should-integrate-into-windows-9/) August 13, 2014
	
* [Beware! FileHippo tests adware distributing download manager](http://www.ghacks.net/2014/07/08/beware-filehippo-tests-adware-distributing-download-manager/) July 8, 2014
	
* [Best Free Drive Backup programs for Windows](http://www.ghacks.net/2014/08/08/best-free-drive-backup-programs-for-windows/) August 8, 2014
	

### Advertisement

### Subscribe / Connect

Subscribe to our newsletter, RSS, or follow us on Facebook,Twitter or Google+.
[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/facebook.png]]](https://www.facebook.com/ghacksnet)[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/twitter.png]]](https://twitter.com/ghacksnews)[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/google_plus.png]]](https://plus.google.com/107836925448900328328/)[![[./_resources/How_to_get_security_updates_for_Windows_XP_until_April_2019_-_gHacks_Tech_News_www.ghacks.net.resources/rss.png]]](http://www.ghacks.net/feed/)
 Ghacks Technology Newsletter 

|     |     |
| --- | --- |
|     |     |

### Random Software Reviews

* [Seriousd is a time-tracking app for Windows with access rules](http://www.ghacks.net/2014/05/27/seriousd-time-tracking-app-windows-access-rules/)

### Topics

[Apple](http://www.ghacks.net/category/apple-companies/)
[Development](http://www.ghacks.net/category/webdevelopment/)
[Facebook](http://www.ghacks.net/category/facebook-companies/)
[Games](http://www.ghacks.net/category/games/)
[Ghacks](http://www.ghacks.net/category/ghacks/)
[Hardware](http://www.ghacks.net/category/hardware/)
[Internet Explorer](http://www.ghacks.net/category/internet-explorer-browsing/)
[Linux](http://www.ghacks.net/category/linux/)
[Microsoft](http://www.ghacks.net/category/microsoft-companies/)
[Mobile Computing](http://www.ghacks.net/category/mobile-computing/)
[Music And Video](http://www.ghacks.net/category/music-and-video/)
[Networks](http://www.ghacks.net/category/networks/)
[Opera](http://www.ghacks.net/category/opera/)
[Security](http://www.ghacks.net/category/security/)
[Tutorials](http://www.ghacks.net/category/tutorials-basic/)

### About Ghacks

Ghacks is a technology news blog that was founded in 2005 by Martin Brinkmann. It has since then become one of the most popular tech news sites on the Internet with five authors and regular contributions from freelance writers.

### Information

[About](http://www.ghacks.net/about-us/)
[Disclaimer](http://www.ghacks.net/disclaimer/)
[Rss Feeds](http://www.ghacks.net/ghacksnet-feed-list/)
[Privacy Policy](http://www.ghacks.net/privacy-policy/)

### Authors

[Martin Brinkmann](http://www.ghacks.net/author/martin/)
[Alan Buckingham](http://www.ghacks.net/author/alanbucki/)
[Melanie Gross](http://www.ghacks.net/author/melanie/)

© 2014 gHacks Technology News. All Rights Reserved.

__
