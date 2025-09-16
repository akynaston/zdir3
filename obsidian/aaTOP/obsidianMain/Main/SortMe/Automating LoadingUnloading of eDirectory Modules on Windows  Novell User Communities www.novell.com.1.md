# Automating Loading/Unloading of eDirectory Modules on Windows | Novell User Communities [www.novell.com]

[![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows__Novell_User_Communities_www.novell.com.1.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/communities/node/8569/#top)

		### [Solutions](http://www.novell.com/solutions/)
	
		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners](http://www.novell.com/partners/)
	
		### [Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/communities/node/8569/automating-loadingunloading-edirectory-modules-windows) **_United States,_ English**

[**Login**](http://www.novell.com/communities/login?destination=node/8569/automating-loadingunloading-edirectory-modules-windows)

[Close](http://www.novell.com/communities/node/8569/#)

[Request a Sales Call](http://www.novell.com/company/sales_call_request_popup.html?refid=novell.comleftnav&profile_url=http%3A//www.novell.com/communities/)

[800-529-3400](http://www.novell.com/company/contact.html)

# Article

* [Cool Solutions](http://www.novell.com/communities/coolsolutions)

* [Novell Forums](http://forums.novell.com)
* [PartnerNet](http://www.novell.com/communities/node/2093/partners)
* [Developer](http://developer.novell.com/wiki/index.php/DeveloperNet)
* [NUI](http://www.novell.com/communities/node/2039/novell%20users%20international%20nui)
* [Novell Blogs](http://www.novell.com/company/blogs/)
* [Help   _>_](http://www.novell.com/communities/node/1382/help)

* [Novell Home](http://www.novell.com)

* [Communities Home](http://www.novell.com/communities)
* [Technical Support](http://www.novell.com/support)
* [Technical Training](http://www.novell.com/training)

## [Search](http://www.novell.com/communities/node/8569/#)

## [Shameless Plugs](http://www.novell.com/communities/node/8569/#)

## [Most Popular](http://www.novell.com/communities/node/8569/#)

### Last viewed:

* [ndsd-multi : a way to start multiple eDirectory instances simultaneously in Linux](http://www.novell.com/communities/node/8954/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux)

* [Configuring the LDAP TLS Required Option](http://www.novell.com/communities/node/9089/configuring-ldap-tls-required-option)
* [Diagnostic tool for DNS Records](http://www.novell.com/communities/node/8955/verifying-dns-zone-records-domain-and-member-server)

## [Who's online](http://www.novell.com/communities/node/8569/#)

There are currently _5 users_ and _174 guests_ online.

### Online users

* [coolguys](http://www.novell.com/communities/user/756)

* [davidkrotil](http://www.novell.com/communities/user/8421)
* [skipthompson81](http://www.novell.com/communities/user/3191)
* [Sgallagher](http://www.novell.com/communities/user/25749)
* [aim_cade](http://www.novell.com/communities/user/25090)

[![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows__Novell_User_Communities_www.novell.com.1.resources/unknown_filename.3.png]]](http://www.novell.com/communities/user/1802)

article

Reads:

## 2433

Score:

0

Comments:

## 2

## Automating Loading/Unloading of eDirectory Modules on Windows

### Author Info

25 June 2009 - 3:50pm
Submitted by: [sashwin](http://www.novell.com/communities/user/1802)

[Author Blog](http://www.novell.com/communities/blog/1802)
[Author Profile](http://www.novell.com/communities/user/1802)

### Tags

[eDirectory](http://www.novell.com/communities/taxonomy/term/7)
[Tags Map](http://www.novell.com/communities/site-tags)

[_(View Disclaimer)_](http://www.novell.com/communities/node/8569/#disclaimer)

### Problem

Loading and unloading [eDirectory](http://www.novell.com/communities/glossary/term/3276) modules on Windows is performed using a GUI by either running “Novell eDirectory Services" from the Control Panel or invoking NDSCons.exe.

Using the GUI will not help in the following cases:

* Load or unload of eDirectory module from the [command line](http://www.novell.com/communities/glossary/term/527)

* To automate backup of eDirectory
* Automate loading and unloading of modules
* To list loaded modules of eDirectory

### Solution

There is an easy way of loading and unloading eDirectory modules using dhostcon.exe, dhostcon.exe helps in overcoming problem of using GUI.

dhostcon.exe is installed by default along with eDirectory (by default at C:\\Novell\\NDS\\).

* **Load or Unload of eDirectory Module from the Command Line**
	
	Usage:
	dhostcon.exe <Loacal IP Address> <load/unload> <eDirectory module>
	
	example: Loading and Unloading of Repair module of eDirectory:
	c:\\novell\\nds\\dhostcon.exe 192.168.1.1 load dsrepair.dlm
	c:\\novell\\nds\\dhostcon.exe 192.168.1.1 unload dsrepair.dlm
	

* **To Automate Backup of eDirectory**
	
	Usage:
	dhostcon.exe 192.168.1.1 load dsbk backup -b -f <Backup File> -l <Log File> -t -w
	
	example:
	c:\\novell\\nds\\dhostcon.exe 192.168.1.1 load dsbk backup -b -f edirbackup.bak -l c:\\novell\\edir-backup.log -t -w
	
	Above can be automated by writing a command into the [batch file](http://www.novell.com/communities/glossary/term/1024) at eDirectory installed location (by default C:\\Novell\\NDS). Run the created batch file when ever there is a requirement of backup of eDirectory.
	
	1. Create C:\\Novell\\NDS\\auto\_ld.bat.
	2. Add the following commands to the file:
		C:\\Novell\\NDS\\dhostcon.exe 192.168.1.1 load dsrepair.dlm
		C:\\Novell\\NDS\\dhostcon.exe 192.168.1.1 load dstrace.dlm
	3. Run the batch file auto\_ld\_unld.bat at the command line.
* **To list loaded modules of eDirectory**
	
	Usage:
	dhostcon.exe <IP Address> modules
	
	example:
	C:\\Novell\\NDS\\dhostcon.exe 192.168.1.1 modules
	

_**Disclaimer:** As with everything else at Cool Solutions, this content is definitely not supported by Novell (so don't even think of calling Support if you try something and it blows up)._

_It was contributed by a community member and is published "as is." It seems to have worked for at least one person, and might work for you. But please be sure to test, test, test before you do anything drastic with it._

## Related Articles

* [Moving of eDirectory Database in Windows 32-Bit and 64-Bit](http://www.novell.com/communities/node/8540/moving-edirectory-database-windows-32-bit-and-64-bit)

* [Solving Error: NDMP Error NDMP_NO_DEVICE_ERR (16)...](http://www.novell.com/communities/node/2886/solving-error-ndmp-error-ndmpnodeviceerr-16)
* [Imaging Patch for ZENworks for Desktops 3 Abends](http://www.novell.com/communities/node/737/imaging%20patch%20zenworks%20desktops%203%20abends)
* [eDirectory 8.8 SP6 XDAS Audit to File](http://www.novell.com/communities/node/12176/edirectory-88-sp6-xdas-audit-to-file)
* [eDirectory 8.8 SP6 XDAS Audit to Syslog](http://www.novell.com/communities/node/12249/edirectory-88-sp6-xdas-audit-syslog)

## User Comments

[![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows__Novell_User_Communities_www.novell.com.1.resources/unknown_filename.2.jpeg]]](http://www.novell.com/communities/user/583)

## [Windows rights required?](http://www.novell.com/communities/node/8569/automating-loadingunloading-edirectory-modules-windows#comment-6348)

Submitted by [dgersic](http://www.novell.com/communities/user/583) on 26 June 2009 - 7:08am.

Any idea what rights the local user has to have in order to run dhostcon?

* Be the first to comment!  To leave a comment you need to [Login or Register](http://www.novell.com/communities/login?destination=node%2F8569)
	

[![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows__Novell_User_Communities_www.novell.com.1.resources/unknown_filename.1.png]]](http://www.novell.com/communities/user/1802)

## [Rights required to run dhostcon.exe](http://www.novell.com/communities/node/8569/automating-loadingunloading-edirectory-modules-windows#comment-6353)

Submitted by [sashwin](http://www.novell.com/communities/user/1802) on 28 June 2009 - 9:03pm.

Windows users should be part of 'Administrators' group to execute dhostcon.exe.

* Be the first to comment!  To leave a comment you need to [Login or Register](http://www.novell.com/communities/login?destination=node%2F8569)
	

© 2011 Novell

* [Careers](http://www.novell.com/company/careers/index.html)

* [Legal](http://www.novell.com/company/legal/)

[close](http://www.novell.com/communities/node/8569/#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/communities/node/8569/#)
* [800-529-3400](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/communities/node/8569/#)

[Novell](http://www.novell.com/) Making IT Work As One™
