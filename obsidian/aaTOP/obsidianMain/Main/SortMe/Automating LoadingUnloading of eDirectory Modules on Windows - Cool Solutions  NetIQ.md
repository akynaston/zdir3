# Automating Loading/Unloading of eDirectory Modules on Windows - Cool Solutions | NetIQ

[NetIQ](https://www.netiq.com/)

* [**Solutions**](https://www.netiq.com/solutions-industries/) 

* [**Products**](https://www.netiq.com/products/) 
* [**Industries**](https://www.netiq.com/solutions-industries/#industries) 
* [**Support**](https://www.netiq.com/services/) 
* [**About**](https://www.netiq.com/company/) 
* [Partners](https://www.partnernetprogram.com/)
* [Communities](https://www.netiq.com/communities/)
[**Let's Talk**](https://www.netiq.com/company/contact/) 
_Search_

* [Login](https://www.netiq.com/f/mynetiq/login.asp)

* [**United States, English**](https://www.netiq.com/common/util/langselect.php?referer=https%3A//www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/) 
	
	[Close](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#)
	
* [**Let's Talk**](https://www.netiq.com/company/contact/) 

## [NetIQ Communities](https://www.netiq.com/communities/)

* [NetIQ Cool Solutions __](https://www.netiq.com/communities/cool-solutions/)

* [NetIQ Views __](https://www.netiq.com/communities/cool-solutions/netiq-views/)
* [NetIQ Support Forums __](https://forums.netiq.com/)

## Automating Loading/Unloading of eDirectory Modules on Windows

### Problem

Loading and unloading eDirectory modules on Windows is performed using a GUI by either running “Novell eDirectory Services” from the Control Panel or invoking NDSCons.exe.

Using the GUI will not help in the following cases:

* Load or unload of eDirectory module from the command line

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
	
	Above can be automated by writing a command into the batch file at eDirectory installed location (by default C:\\Novell\\NDS). Run the created batch file when ever there is a requirement of backup of eDirectory.
	
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
	

![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/rating_off.gif]] (_**0** votes, average: **0.00** out of 5_)
_You need to be a registered member to rate this post._

Categories: Uncategorized

* [____](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#)

* [____](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#)
* [____](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#)
* [____](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#)
* [____](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#)
* [0 ](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#comments)

* * *

_

_**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment._

_

### Leave a Reply

You must be [logged in](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fautomating-loadingunloading-edirectory-modules-windows%2F) to post a comment.

#### Leave a Comment

	![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/-d=identicon&s=32.png]] sashwin says:
	[June 28, 2009 at 10:03 pm](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#comment-6353)
	
	Windows users should be part of ‘Administrators’ group to execute dhostcon.exe.
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fautomating-loadingunloading-edirectory-modules-windows%2F)
	

![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/7284b4ad8922ec74a1edb41a90193fdc.png]]
By: [sashwin](https://www.netiq.com/communities/cool-solutions/author/sashwin/)
![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/unknown_filename.1.png]]

June 25, 2009
4:50 pm

Reads:
1,146
Score:
Unrated

[![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/pf-print-icon.gif]]Print ![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/pf-pdf-icon.gif]]PDF](http://www.printfriendly.com/print?url=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fautomating-loadingunloading-edirectory-modules-windows%2F)

[![[./_resources/Automating_LoadingUnloading_of_eDirectory_Modules_on_Windows_-_Cool_Solutions__NetIQ.resources/unknown_filename.png]]](https://www.netiq.com/promo/identity-and-access-management/privileged-users-managing-hidden-risk-in-your-organization-flash-point-paper.html?utm_campaign=IPA&utm_source=NetIQCommunities&utm_medium=banner)

### Recent Comments

### Recent Posts

### Categories

### Popular Topics

[Active Directory](https://www.netiq.com/communities/cool-solutions/tag/active_directory/) [Automation](https://www.netiq.com/communities/cool-solutions/tag/automation/) [Cloud Computing](https://www.netiq.com/communities/cool-solutions/tag/cloud-computing/) [Cloud Security](https://www.netiq.com/communities/cool-solutions/tag/cloud-security/) [Configuration](https://www.netiq.com/communities/cool-solutions/tag/configuration/) [Contact Management](https://www.netiq.com/communities/cool-solutions/tag/contact_management/) [Customizing](https://www.netiq.com/communities/cool-solutions/tag/customizing/) [Data Breach](https://www.netiq.com/communities/cool-solutions/tag/data-breach/) [DirXML](https://www.netiq.com/communities/cool-solutions/tag/dirxml/) [Drivers](https://www.netiq.com/communities/cool-solutions/tag/drivers/) [End User Management](https://www.netiq.com/communities/cool-solutions/tag/end-user-management/) [Identity Manager](https://www.netiq.com/communities/cool-solutions/tag/identity-manager/) [Importing-Exporting / ICE/ LDIF](https://www.netiq.com/communities/cool-solutions/tag/importing-exporting_ice_ldif/) [Intelligent Workload Management](https://www.netiq.com/communities/cool-solutions/tag/intelligent-workload-management/) [Knowledge Depot](https://www.netiq.com/communities/cool-solutions/tag/knowledge-depot/) [LDAP](https://www.netiq.com/communities/cool-solutions/tag/ldap/) [Migrating from Windows XP or 2003 to SUSE Linux](https://www.netiq.com/communities/cool-solutions/tag/migrating_from_windows_xp_or_2003_to_suse_linux/) [Monitoring](https://www.netiq.com/communities/cool-solutions/tag/monitoring/) [Open Enterprise Server](https://www.netiq.com/communities/cool-solutions/tag/open_enterprise_server/) [Passwords](https://www.netiq.com/communities/cool-solutions/tag/passwords/) [Reporting](https://www.netiq.com/communities/cool-solutions/tag/reporting/) [Secure Access](https://www.netiq.com/communities/cool-solutions/tag/secure_access/) [Supported](https://www.netiq.com/communities/cool-solutions/tag/supported/) [Synchronization](https://www.netiq.com/communities/cool-solutions/tag/synchronization/) [Troubleshooting](https://www.netiq.com/communities/cool-solutions/tag/troubleshooting/)

### Top Contributors

* [geoffc (42900)](https://www.netiq.com/communities/cool-solutions/author/geoffc)

* [martincotter (10825)](https://www.netiq.com/communities/cool-solutions/author/martincotter)
* [ab (10360)](https://www.netiq.com/communities/cool-solutions/author/ab)
* [tisenberg (6970)](https://www.netiq.com/communities/cool-solutions/author/tisenberg)
* [cstumula (3215)](https://www.netiq.com/communities/cool-solutions/author/cstumula)
* [alexmchugh (2600)](https://www.netiq.com/communities/cool-solutions/author/alexmchugh)
* [TSureshkumar (1425)](https://www.netiq.com/communities/cool-solutions/author/TSureshkumar)
* [ScorpionSting (1325)](https://www.netiq.com/communities/cool-solutions/author/ScorpionSting)
* [dlugohernandez (1235)](https://www.netiq.com/communities/cool-solutions/author/dlugohernandez)
* [alekz (1230)](https://www.netiq.com/communities/cool-solutions/author/alekz)

**Join the conversation on social media:**

* [Facebook](http://www.facebook.com/NetIQ)

* [Linked-In](http://www.linkedin.com/company/netiq)
* [Google+](https://plus.google.com/u/0/104155365122160260564)
* [Twitter](https://twitter.com/NetIQ)
* [YouTube](http://www.youtube.com/user/netiqTV)
* [SlideShare](http://www.slideshare.net/NetIQ/)

**Subscribe to our technical newsletter:**

![[]]

Let's talk.

* [Request a Call ›](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#)

* Sales: 1-888-323-6768

© 2015 NetIQ Corporation [Legal](https://www.netiq.com/company/legal/) [Privacy](https://www.netiq.com/company/legal/privacy/) [Feedback](https://www.netiq.com/common/inc/feedback_overlay.html?iframe=true)

[Scroll to Top](https://www.netiq.com/communities/cool-solutions/automating-loadingunloading-edirectory-modules-windows/#)
