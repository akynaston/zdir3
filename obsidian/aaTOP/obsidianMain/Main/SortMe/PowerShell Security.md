# PowerShell Security

<http://ad.doubleclick.net/click%3Bh%3Dv8/39a1/3/0/%2a/q%3B224510817%3B0-0%3B0%3B17085286%3B3454-728/90%3B36552383/36570291/1%3Bu%3D%2Cns-15702469_1274455429%2C118df38608869cb%2Cisecgener%2C%3B%7Eaopt%3D2/1/53/1%3B%7Esscs%3D%3fhttp://altfarm.mediaplex.com/ad/nc/3992-101511-21584-0?mpt=5410368><http://ad1.netshelter.net/jump/ns.windowssecurity/general;ppos=atf;kw=;tile=1;sz=728x90;ord=123456789?>

<http://banman.isoftmarketing.com/a.aspx?ZoneID=18&SiteID=6&PageID=6656&Task=Click&Random=1274455425650&Mode=HTML&Keywords=PowerShellSecurity>

* [Articles](http://www.windowsecurity.com/articles_tutorials/)
* [Authors](http://www.windowsecurity.com/authors/)
* [Blogs](http://blogs.windowsecurity.com/)
* [ISA Server Articles](http://www.isaserver.org/)
* [Links](http://www.windowsecurity.com/pages/links.asp)
* [Message Boards](http://www.security-forums.com/forum/)
* [Newsletter](http://www.windowsecurity.com/pages/newsletter.asp)
* [RSS](http://rss.techgenix.com/)
* [Security Tests](http://www.windowsecurity.com/securitytests/)
* [Services](http://www.windowsecurity.com/services/)
* [Software](http://www.windowsecurity.com/software/)
* [White Papers](http://www.windowsecurity.com/whitepapers/)

[![[./_resources/PowerShell_Security.resources/logo-sec.gif]]](http://www.windowsecurity.com/)

Site Search

[Advanced Search](http://www.windowsecurity.com/search-adv.asp)

# PowerShell Security

<http://banman.isoftmarketing.com/a.aspx?ZoneID=54&Task=Click&Mode=HTML&SiteID=7&PageID=63187>

|     |     |
| --- | --- |
| The built-in PowerShell security features as well as some additional security you can configure once in PowerShell. |     |
| ![[./_resources/PowerShell_Security.resources/DSC_0249_small1106731326183.bmp]]<br><br>* Published: **Sep 13, 2007**<br>* Updated: **Sep 13, 2007**<br>* Section: **[Articles :: Windows OS Security](http://www.windowsecurity.com/articles/windows_os_security/)**<br>* Author: **[Derek Melber](http://www.windowsecurity.com/Derek_Melber/)**<br>* **[Printable Version](http://www.windowsecurity.com/articles/PowerShell-Security.html?printversion)**<br>* Adjust font size: [![[./_resources/PowerShell_Security.resources/icon.gif]]](http://www.windowsecurity.com/articles/PowerShell-Security.html#)[![[./_resources/PowerShell_Security.resources/icon.1.gif]]](http://www.windowsecurity.com/articles/PowerShell-Security.html#)<br>* Rating: **3.8/5 - 22 Votes**<br><br>* 1<br>* 2<br>* 3<br>* 4<br>* 5<br><br>[![[./_resources/PowerShell_Security.resources/lg-bookmark-en.gif]]](http://www.addthis.com/bookmark.php?v=120&winname=addthis&pub=TechGenix&source=men-120&lng=en&s=&url=http%3A%2F%2Fwww.windowsecurity.com%2Farticles%2FPowerShell-Security.html&title=PowerShell%20Security&logo=&logobg=&logocolor=&ate=AT-TechGenix/-/-/4bf6a58b47179a38/1/4bf6a58fd5a8ab79&uid=4bf6a58fd5a8ab79&CXNID=2000001.5215456080540439074NXC&pre=http%3A%2F%2Fwww.google.com%2Fsearch%3Fclient%3Dfirefox-a%26rls%3Dorg.mozilla%253Aen-US%253Aofficial%26channel%3Ds%26hl%3Den%26source%3Dhp%26q%3Drun%2Bunsigned%2Bscript%26btnG%3DGoogle%2BSearch&tt=0) |

If you have not heard of PowerShell you must be living under a rock. If you have heard about PowerShell, then you must have been wondering how and if PowerShell is secure. I saw PowerShell for the first time about 4 years ago at an MVP conference. With all of the effort and sweat that has gone into PowerShell, it had better come with some advanced security. Well, it does! PowerShell is not just your routine scripting language. There are built in security features, as well as some additional security you can configure once in PowerShell.

## PowerShell Default Security

Just getting to the PowerShell interface can be a task for some. Not that this is security related, just that you must be in the PowerShell interface before you can do much of anything. This in itself is security. There are however, some default security measures that are there by design to help ensure that anyone with malicious intent is denied their efforts.

**_What is in a path?_**

The first default security measure that you will encounter is that fact that PowerShell won’t run scripts that are in the current folder. This is so that malicious scripts attempting to intercept cmdlets and command names will fail.

For example, if you wanted to run a script named Example.ps1 from the C:\\scripts folder, you would need to include the full path to the script, even if you were in the C:\\scripts folder within PowerShell. Figure 1 illustrates what happens when you just try to run Example.ps1 without a path.

![[./_resources/PowerShell_Security.resources/image0021189420953657.jpg]]
**Figure 1:** Scripts must include the path to the script to run successfully

Now, look at what happens when you run the script including the path to the script, as shown in Figure 2.

![[./_resources/PowerShell_Security.resources/image0041189420953673.jpg]]
**Figure 2:** When the path is included with the script, the script runs without a hitch

**_Why am I Restricted?_**

Another default setting that is directly related to security is the fact that all scripts must be run interactively. This is a security measure that ensures that PowerShell scripts cannot be executed from a script based virus. This means that you must be at the PowerShell interface and run the script in real time for it to function.

This default setting is associated with the ExecutionPolicy setting within PowerShell. The ExecutionPolicy by default is set to Restricted, as shown in Figure 3.

![[./_resources/PowerShell_Security.resources/image0061189420993001.jpg]]
**Figure 3:** The ExecutionPolicy by default is set to Restricted to secure the execution of remote PowerShell scripts

## Going Beyond the Defaults

The default ExecutionPolicy in PowerShell is very secure. It does not allow for any scripts to be run, from anywhere. So, scripts that you create and put on a system won’t run. Scripts that you download from the Internet won’t run. Scripts that you even sign and secure to the nth degree won’t run. Therefore, you will need to reset the level of ExecutionPolicy before you can run your scripts.

**_Setting the ExecutionPolicy Level_**

There are four levels of the ExecutionPolicy. These four levels provide you with great security over what scripts can run and what requirements need to be associated with the script to run. The four levels and the requirements include:

**Restricted
**This is the default configuration in PowerShell. This setting means that no script can run, regardless of its signature. The only thing that can be run in PowerShell with this setting are individual commands.

**AllSigned
**This setting does allow scripts to run in PowerShell. The script must have an associated digital signature from a trusted publisher. There will be a prompt before you run the scripts from trusted publishers. This exposes you to running signed, but malicious, scripts.

**RemoteSigned
**This setting allows scripts to be run, but requires that the script and configuration files that are downloaded from the Internet have an associated digital signature from a trusted publisher. Scripts run from local computer don’t need to be signed. There are no prompts before running the script. Still exposes you to scripts that are signed, yet malicious.

**Unrestricted
**This is not a suggested setting! This allows unsigned scripts to run, including all scripts and configuration files downloaded from the Internet. This will include files from Outlook and Messenger. The risk here is running scripts without any signature or security.

To set anyone of these levels, just type set-executionpolicy <level>, as shown in Figure 4.

![[./_resources/PowerShell_Security.resources/image0081189420993001.jpg]]
**Figure 4:** Setting the ExecutionPolicy is as easy as running the set-executionpolicy command.

**_Using Group Policy_**

PowerShell is great, but if scripts can’t run on computers in your environment, it does have limitations. First, you must get PowerShell on each computer. Since PowerShell is installed via an EXE, it is very easy to install the application. You can either use a ZAP file and push it out using Group Policy, or you can use your current centralized method of installing applications. Keep in mind that PowerShell is considered a hotfix, so Windows Update can also push out the installation of PowerShell.

After you get PowerShell installed, we just investigated that you need to enable scripts to run. With the ExecutionPolicy set at Restricted as a default, you need to configure every computer to run scripts, that will run scripts. This could take days if you are trying to do this manually.

However, you can also use Group Policy to get this done for you. Of course, you could create your own Administrative Template (ADM file) to make this change, or download the ADM template that Microsoft provides for you. I suggest you do the latter by downloading [the ADM template](http://www.microsoft.com/downloads/details.aspx?FamilyID=2917a564-dbbc-4da7-82c8-fe08b3ef4e6d&DisplayLang=en#QuickInfoContainer).

After downloading, you will need to install the MSI. I will admit, it is not the cleanest or most efficient install. After installation, the ADM file is shoved under the C:\\program files\\Microsoft Group Policy folder. If nothing else, this is great security! The file you need to import into the Group Policy Object Editor is PowerShellExtensionPolicy.ADM. After importing, you will have two new nodes in your Group Policy Object. One will be at Computer Configuration\\Administrative Templates\\Windows Components\\Windows PowerShell and the other at User Configuration\\Administrative Templates\\Windows Components\\Windows PowerShell, as shown in Figure 5.  

![[./_resources/PowerShell_Security.resources/image0101189420993017.jpg]]
**Figure 5:** PowerShell ADM template adds settings to Computer Configuration and User Configuration for script execution

When you go to configure this policy, you will see that you have three options for a setting, as shown in Figure 6.

![[./_resources/PowerShell_Security.resources/image0121189420993017.jpg]]
**Figure 6:** The ExecutionPolicy settings for PowerShell in a GPO

## Summary

PowerShell is the new kid on the block. With Windows Server 2008 coming out in early 2008, PowerShell will take off like a rocket ship. With all of the attention that PowerShell is getting, everyone is hoping that it comes with security already built-in. Well, the worry is over. PowerShell provides security directly out of the box, with default security features. The fact that the scripts are set to have a restricted execution policy is fantastic. Even if you have created a .PS1 file, that script being associated with Notepad is nice default security. Even if you can get to the PowerShell interface, the fact that the path to the script must be typed in adds value. Beyond the defaults, being able to set the execution policy and control PowerShell through Group Policy gives centralized control over PowerShell security.

# About Derek Melber

![[./_resources/PowerShell_Security.resources/DSC_0249_small1106731326183.bmp]] Derek Melber, MCSE, MVP, is an independent consultant, speaker, author, and trainer. Derek’s latest book, [The Group Policy Resource Kit](http://www.microsoft.com/MSPress/books/9556.aspx) by Microsoft Press, is his latest best-selling book covering all of the new Group Policy features and settings in Windows Server 2008 and Vista. Derek educates and evangelizes Microsoft technology, focusing on Active Directory, Group Policy, Security, and desktop management. Derek speaks and trains for [MISTI](http://www.misti.com/), [TechMentor](http://techmentorevents.com/), [Windows Connections](http://www.winconnections.com/default.asp), and [TechEd](http://www.microsoft.com/techedonline/). You can bring Derek to your office for training or consulting, just email him at [derekm@braincore.net](mailto:derekm@braincore.net).

**[Click here](http://www.windowsecurity.com/Derek_Melber/)** for Derek Melber's section.

# Receive all the latest articles by email!

Get all articles delivered directly to your mailbox as and when they are released on WindowSecurity.com! Choose between receiving instant updates with the Real-Time Article Update, or a monthly summary with the Monthly Article Update.

* Real-Time Article Update ([click for sample](http://www.windowsecurity.com/WindowSecurity.com-Real-Time-Article-Update-Newsletter-Sample.htm))
* Monthly Article Update ([click for sample](http://www.windowsecurity.com/WindowSecurity.com-Monthly-Article-Update-Newsletter-Sample.htm))

# Latest articles by Derek Melber

* [Desktops: Local Rights and Privileges](http://www.windowsecurity.com/articles/Desktops-Local-Rights-Privileges.html)
* [Security Compliance Manager Goes Beta](http://www.windowsecurity.com/articles/Security-Compliance-Manager-Goes-Beta.html)
* [Quick Guide to Troubleshooting Group Policy Security Settings](http://www.windowsecurity.com/articles/Quick-Guide-Troubleshooting-Group-Policy-Security-Settings.html)
* [Video: Setting up Subscriptions for Event Log Forwarding](http://www.windowsecurity.com/articles/Video_Setting_up_Subscriptions_Event_Log_Forwarding.html)
* [Configuring Advanced IE Settings Using Group Policy](http://www.windowsecurity.com/articles/Configuring-Advanced-IE-Settings-Using-Group-Policy.html)

# Related links

* [Secure Socket Layer](http://www.windowsecurity.com/articles/Secure_Socket_Layer.html)
* [Building a Bastion Host Using HP-UX 11](http://www.windowsecurity.com/whitepaper/Building_a_Bastion_Host_Using_HPUX_11.html)
* [Understanding E-mail Spoofing](http://www.windowsecurity.com/articles/Email-Spoofing.html)
* [Hidden Threat: Alternate Data Streams](http://www.windowsecurity.com/articles/Alternate_Data_Streams.html)
* [10 Steps to a Secure FTP Server](http://www.windowsecurity.com/articles/Secure_FTP_Server.html)

# Featured Links\*

|     |
| --- |
| [**Tired of running multiple backup tasks?**](http://banman.isoftmarketing.com/a.aspx?Task=Click&ZoneID=16&CampaignID=1302&AdvertiserID=25&BannerID=1133&SiteID=6&RandomNumber=2072054083&Keywords=PowerShellSecurity)<br>GFI Backup - Business Edition is an easy-to-use backup solution which allows you to implement company-wide backup policies in a single task. Download a free trial today! |
| [**Security Monitoring through Event Logs**](http://banman.isoftmarketing.com/a.aspx?Task=Click&ZoneID=16&CampaignID=1255&AdvertiserID=25&BannerID=1036&SiteID=6&RandomNumber=1672416521&Keywords=PowerShellSecurity)<br>Get the event log information that really matters through automated alerts on critical security events. Install, set and pat yourself on the back! |
| [**Completely Free Network Event Log Software for IT Pros and Security Experts**](http://banman.isoftmarketing.com/a.aspx?Task=Click&ZoneID=16&CampaignID=1379&AdvertiserID=117&BannerID=1130&SiteID=6&RandomNumber=1672416521&Keywords=PowerShellSecurity)<br>Download free IT management software to help maintain security of your network. Get event logs, monitor your network, run a help desk, & more - all 100% free! |

<http://banman.isoftmarketing.com/a.aspx?ZoneID=16&SiteID=6&PageID=6656&Task=Click&Random=1274455425666&Mode=HTML&Keywords=PowerShellSecurity>

<http://banman.isoftmarketing.com/a.aspx?ZoneID=16&SiteID=6&PageID=6656&Task=Click&Random=1274455425667&Mode=HTML&Keywords=PowerShellSecurity>

<http://banman.isoftmarketing.com/a.aspx?ZoneID=16&SiteID=6&PageID=6656&Task=Click&Random=1274455425668&Mode=HTML&Keywords=PowerShellSecurity>

<http://banman.isoftmarketing.com/a.aspx?ZoneID=16&SiteID=6&PageID=6656&Task=Click&Random=1274455425669&Mode=HTML&Keywords=PowerShellSecurity>

<http://banman.isoftmarketing.com/a.aspx?ZoneID=16&SiteID=6&PageID=6656&Task=Click&Random=1274455425670&Mode=HTML&Keywords=PowerShellSecurity>

# Receive all the latest articles by email!

Receive Real-Time & Monthly WindowSecurity.com article updates in your mailbox. Enter your email below!
Click for [Real-Time sample](http://www.windowsecurity.com/WindowSecurity.com-Real-Time-Article-Update-Newsletter-Sample.htm) & [Monthly sample](http://www.windowsecurity.com/WindowSecurity.com-Monthly-Article-Update-Newsletter-Sample.htm)

# Become a WindowSecurity.com member!

Discuss your security issues with thousands of other network security experts. [Click here](http://www.security-forums.com/profile.php?mode=register) to join!

### Community Area

[Log in](http://www.security-forums.com/login.php) | [Register](http://www.security-forums.com/profile.php?mode=register)

<http://banman.isoftmarketing.com/a.aspx?ZoneID=30&SiteID=6&PageID=6656&Task=Click&Random=1274455425666&Mode=HTML&Keywords=PowerShellSecurity>

<http://ad1.netshelter.net/jump/ns.windowssecurity/general;ppos=btf;kw=;tile=3;sz=120x600,160x600;ord=123456789?>

<http://banman.isoftmarketing.com/a.aspx?ZoneID=19&SiteID=6&PageID=6656&Task=Click&Random=1274455425666&Mode=HTML&Keywords=PowerShellSecurity>

### Solution Center

* [Articles & Tutorials](http://www.windowsecurity.com/articles/PowerShell-Security.html#)
	* [Authentication, Access Control & Encryption](http://www.windowsecurity.com/articles_tutorials/authentication_and_encryption/)
	* [Content Security (Email & FTP)](http://www.windowsecurity.com/articles_tutorials/content_security/)
	* [Firewalls & VPNs](http://www.windowsecurity.com/articles_tutorials/firewalls_and_VPN/)
	* [Intrusion Detection](http://www.windowsecurity.com/articles_tutorials/intrusion_detection/)
	* [Misc Network Security](http://www.windowsecurity.com/articles_tutorials/misc_network_security/)
	* [Product Reviews](http://www.windowsecurity.com/articles_tutorials/Product_Reviews/)
	* [Viruses, trojans and other malware](http://www.windowsecurity.com/articles_tutorials/viruses_trojans_malware/)
	* [Web Application Security](http://www.windowsecurity.com/articles_tutorials/Web_Application_Security/)
	* [Web Server Security](http://www.windowsecurity.com/articles_tutorials/web_server_security/)
	* [Windows 2003 Security](http://www.windowsecurity.com/articles_tutorials/windows_2003_security/)
	* [Windows Networking](http://www.windowsecurity.com/articles_tutorials/windows_networking/)
	* [Windows OS Security](http://www.windowsecurity.com/articles_tutorials/windows_os_security/)
	* [Wireless Security](http://www.windowsecurity.com/articles_tutorials/Wireless_Security/)
* [Authors](http://www.windowsecurity.com/articles/PowerShell-Security.html#)
	* [Jesper M. Christensen](http://www.windowsecurity.com/Jesper_M_Christensen/)
	* [Chris Sanders](http://www.windowsecurity.com/Chris_Sanders/)
	* [Derek Melber](http://www.windowsecurity.com/Derek_Melber/)
	* [Don Parker](http://www.windowsecurity.com/Don_Parker/)
	* [Jakob H. Heidelberg](http://www.windowsecurity.com/Jakob_H_Heidelberg/)
	* [Martin Kiaer](http://www.windowsecurity.com/Martin_Kiaer/)
	* [Ricky M. Magalhaes](http://www.windowsecurity.com/Ricky_M_Magalhaes/)
	* [Thomas Shinder](http://www.windowsecurity.com/Thomas_Shinder/)
	* [Brien Posey](http://www.windowsecurity.com/Brien_Posey/)
	* [Deb Shinder](http://www.windowsecurity.com/Deb_Shinder/)
	* [Justin Troutman](http://www.windowsecurity.com/Justin_Troutman/)
	* [Mitch Tulloch](http://www.windowsecurity.com/Mitch_Tulloch/)
	* [Robert J. Shimonski](http://www.windowsecurity.com/Robert_J_Shimonski/)
* [Blogs](http://blogs.windowsecurity.com/)
* [Message Boards](http://www.security-forums.com/forum/)
* [Newsletter Signup](http://www.windowsecurity.com/pages/newsletter.asp)
* [RSS Feed](http://rss.windowsecurity.com/)
* [Security Tests](http://www.windowsecurity.com/securitytests/)
* [Services](http://www.windowsecurity.com/articles/PowerShell-Security.html#)
	* [Email Security Services](http://www.windowsecurity.com/services/Email-Security-Services/)
	* [Managed security services](http://www.windowsecurity.com/services/Managed-security-services/)
* [Software](http://www.windowsecurity.com/articles/PowerShell-Security.html#)
	* [Anti Virus](http://www.windowsecurity.com/software/Anti-Virus/)
	* [Authentication / Smart cards](http://www.windowsecurity.com/software/Authentication---Smart-cards/)
	* [Email Anti-Virus](http://www.windowsecurity.com/software/Email-Anti-Virus/)
	* [Email Content Security](http://www.windowsecurity.com/software/Email-Content-Security/)
	* [Email Encryption](http://www.windowsecurity.com/software/Email-Encryption/)
	* [Encryption](http://www.windowsecurity.com/software/Encryption/)
	* [Endpoint Security](http://www.windowsecurity.com/software/Endpoint-Security/)
	* [Event Log Monitoring](http://www.windowsecurity.com/software/Event-Log-Monitoring/)
	* [File integrity checkers](http://www.windowsecurity.com/software/File-integrity-checkers/)
	* [Firewall security log analyzers](http://www.windowsecurity.com/software/Firewall-security-log-analyzers/)
	* [Firewalls](http://www.windowsecurity.com/software/Firewalls/)
	* [Group Policy Management](http://www.windowsecurity.com/software/Group-Policy-Management/)
	* [Intrusion Detection](http://www.windowsecurity.com/software/Intrusion-Detection/)
	* [Misc. Network Security Tools](http://www.windowsecurity.com/software/Misc.-Network-Security-Tools/)
	* [Network Auditing](http://www.windowsecurity.com/software/Network-Auditing/)
	* [Patch Management](http://www.windowsecurity.com/software/Patch-Management/)
	* [Security Scanners](http://www.windowsecurity.com/software/Security-Scanners/)
	* [VPNs](http://www.windowsecurity.com/software/VPNs/)
	* [Web Application Security](http://www.windowsecurity.com/software/Web-Application-Security/)
	* [Web Content Security](http://www.windowsecurity.com/software/Web-Content-Security/)
* [White Papers](http://www.windowsecurity.com/whitepapers/)

### Featured Products

|     |
| --- |
| [![[./_resources/PowerShell_Security.resources/eventsentry-ad.jpg]]<br>Free Version Available<br>Readers' Choice '09+'10](http://banman.isoftmarketing.com/a.aspx?Task=Click&ZoneID=17&CampaignID=1386&AdvertiserID=72&BannerID=1138&SiteID=6&RandomNumber=1172216613&Keywords=PowerShellSecurity) |
| [![[./_resources/PowerShell_Security.resources/LANSS_Vul_Backdoor_freeware_125x125-2009.gif]]](http://banman.isoftmarketing.com/a.aspx?Task=Click&ZoneID=17&CampaignID=1256&AdvertiserID=25&BannerID=1000&SiteID=6&RandomNumber=1750405408&Keywords=PowerShellSecurity)[GFI LANguard - v9<br>Download FREEWARE!](http://www.gfi.com/lannetscan/free-network-security-scanner/?adv=142&loc=74) |

<http://banman.isoftmarketing.com/a.aspx?ZoneID=17&SiteID=6&PageID=6656&Task=Click&Random=1274455425681&Mode=HTML&Keywords=PowerShellSecurity>

<http://banman.isoftmarketing.com/a.aspx?ZoneID=17&SiteID=6&PageID=6656&Task=Click&Random=1274455425682&Mode=HTML&Keywords=PowerShellSecurity>

### Readers' Choice

**Which is your preferred Email Anti-Virus solution?**

* Alt-N SecurityGateway for Exchange / SMTP Servers
* BitDefender Antivirus 2010
* GFI MailSecurity for Exchange/SMTP
* Kaspersky Security for Mail Server
* Panda Security for Enterprise
* Sophos Email Security and Data Protection
* Symantec AntiVirus for Messaging
* Trend Micro InterScan Messaging Security Suite
* Other

### TechGenix Sites

[ISAserver.org](http://www.isaserver.org/)
[The No.1 ISA Server 2006 / 2004 / 2000 resource site.](http://www.isaserver.org/)
[MSExchange.org](http://www.msexchange.org/)
[The leading Microsoft Exchange Server 2007 / 2003 / 2000 resource site.](http://www.msexchange.org/)
[WindowsNetworking.com](http://www.windowsnetworking.com/)
[Windows Server 2008 / 2003 & Windows Vista networking resource site.](http://www.windowsnetworking.com/)
[VirtualizationAdmin.com](http://www.virtualizationadmin.com/)
[The essential Virtualization resource site for administrators.](http://www.virtualizationadmin.com/)

[![[./_resources/PowerShell_Security.resources/follow_bird_us-b.png]]](http://www.twitter.com/TechGenix)

* [Articles](http://www.windowsecurity.com/articles_tutorials/)
* [Authors](http://www.windowsecurity.com/authors/)
* [Blogs](http://blogs.windowsecurity.com/)
* [Books](http://www.windowsecurity.com/pages/books.asp)
* [ISA Server Articles](http://www.isaserver.org/)
* [Links](http://www.windowsecurity.com/pages/links.asp)
* [Message Boards](http://www.security-forums.com/forum/)
* [Newsletter](http://www.windowsecurity.com/pages/newsletter.asp)
* [RSS](http://rss.techgenix.com/)
* [Security Tests](http://www.windowsecurity.com/securitytests/)
* [Services](http://www.windowsecurity.com/services/)
* [Software](http://www.windowsecurity.com/software/)
* [White Papers](http://www.windowsecurity.com/whitepapers/)

[About Us](http://www.techgenix.com/aboutus.htm) : [Email us](mailto:info@windowsecurity.com) : [Product Submission Form](http://www.windowsecurity.com/software/submissionform.asp) : [Advertising Information](http://www.techgenix.com/advert/index.htm)
WindowsSecurity.com is in no way affiliated with Microsoft Corp. \*Links are sponsored by advertisers.

Copyright © 2010 [TechGenix Ltd.](http://www.techgenix.com/) All rights reserved. Please read our [Privacy Policy](http://www.windowsecurity.com/pages/privacy.asp) and [Terms & Conditions](http://www.windowsecurity.com/pages/terms.asp).
