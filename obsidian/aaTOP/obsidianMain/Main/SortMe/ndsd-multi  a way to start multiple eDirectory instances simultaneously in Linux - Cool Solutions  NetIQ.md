# ndsd-multi : a way to start multiple eDirectory instances simultaneously in Linux - Cool Solutions | NetIQ

[NetIQ | Micro Focus](https://www.netiq.com/)

* [**Solutions**](https://www.netiq.com/solutions-industries/) 

* [**Products**](https://www.netiq.com/products/) 
* [**Industries**](https://www.netiq.com/solutions-industries/#industries) 
* [**Support**](https://www.netiq.com/services/) 
* [**About**](https://www.netiq.com/company/) 
* [Partners](https://www.partnernetprogram.com/)
* [Communities](https://www.netiq.com/communities/)
[**Let's Talk**](https://www.netiq.com/company/contact/) 
_Search_

* [**Aaron Kynaston**](https://www.netiq.com/f/mynetiq/)

* [Logout](https://www.netiq.com/f/mynetiq/logout.asp)
* [**United States, English**](https://www.netiq.com/common/util/langselect.php?referer=https%3A//www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/) 
	
	[Close](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)
	
* [**Let's Talk**](https://www.netiq.com/company/contact/) 

## [NetIQ Communities](https://www.netiq.com/communities/)

* [NetIQ Cool Solutions __](https://www.netiq.com/communities/cool-solutions/)

* [NetIQ Views __](https://www.netiq.com/communities/cool-solutions/netiq-views/)
* [NetIQ Support Forums __](https://forums.netiq.com/)

## Welcome back, akynaston

[Add new post __](https://www.netiq.com/communities/cool-solutions/wp-admin/post-new.php)

## ndsd-multi : a way to start multiple eDirectory instances simultaneously in Linux

**License:**
GPLv3

[Download ndsd-multi_1.bz2](https://www.netiq.com/communities/cool-solutions/wp-content/uploads/sites/2/2010/06/ndsd-multi_1.bz2)

Since the release of eDirectory 8.8.0 support for multiple instances of eDirectory on a single box has been available. Using the ndsconfig and especially the newer ndsmanage tool configuring multiple instances of eDirectory is also very easy to do. One feature that has been missing since that time has been the ability to start/stop multiple instances as easily as one can start/stop the first root-based eDirectory instance of a root-installed eDirectory during startup/shutdown. The time has come to overcome that.

To this day the eDirectory init script (/etc/init.d/ndsd) only starts the first instance of eDirectory it finds in the /etc/opt/novell/eDirectory/conf/.edir/instances.0 file which only works for a root-based eDirectory installation. Starting/stopping other instances isn’t a terrible thing to do, but if you forget to stop your instance before rebooting all of the other instances (besides the aforementioned first instance) are killed (which could lead to corruption of the DIB eventually), and if you forget to start your other eDirectory instances you can have more downtime than desired. Creating a script from /etc/init.d/skeleton for this task is fairly simple but I need to make note of a few decisions made during this process just to help make sure everything is clear with the script.

**First**, I presume in most cases this will be used for root-based installations of eDirectory. With that in mind I believe this script, with one minor but planned-for modification, will work with non-root installations of eDirectory. A variable defined as $EDIR\_BASE\_PATH exists which specifies the base of the eDirectory application installation, which by default is a null value. This is the prefix before /opt/novell/eDirectory…. or /var/opt/novell/eDirectory which does not exist for a root-based installation. Change this one variable to the location where a non-root eDirectory installation is extracted and I believe this script will work for those, though I have not tested that at all at this point.

**Second**, I assume the script, when running, will have ‘root’ rights. Modifying it to not need that should be possible but as this is made to be a startup/shutdown script it doesn’t make sense to me to do that. Copy/paste code to do that kind of thing if you’d like but having a system where this is not needed but starting/stopping multiple instances is while having multiple users owning the instances seems like a fairly odd situation.

**Third**, I assume ‘sudo’ is okay on your system. As this runs as ‘root’ I can’t imagine it’s a huge deal since SUSE’s /etc/sudoers file allows root to do whatever no matter what. Other distros (I have not tested RedHat) may have complaints, but workarounds in /etc/sudoers should be trivial. I tried going with startproc but because (in theory) all of the eDirectory instances use the same binary and since I did not want to duplicate what the ‘ndsmanage’ or ‘ndsd’ scripts do already in creating my own PID file I am using sudo. It does the job nicely and if you would like to change things that is fine but this is the way it is for now.

**Fourth** I decided to create a log file for this script in (by default) /var/opt/novell/eDirectory/log/ndsd-multi.log which is root-owned. Currently default permissions are set by the system and you can change them. This log file is never truncated or rotated so keep track of it if you reboot often.

**Fifth**, the script uses the ‘logger’ command when it starts/stops instances since implementing that could be useful and was trivial to enable syslog events from the script overall. The logger output is very basic and not dependent on success/failure at all….. just there so you can keep track and do a little debugging of this script’s interactions with eDirectory.

**Sixth**, because multiple instances are involved and any number could be up/down at a time the start/stop statuses are not reliable at all. I’m open to suggestions on how to make this perfect; my only idea currently is to sum up all of the return codes from sudo and if any of them are non-zero the sum will be non-zero and that can be the status, but I hate doing weird stuff like that since it just means everything shows up broken instead of everything showing up working.

**Seventh**, the script works for multiple users on the same system. I did this by creating a configuration file located at (by default) /etc/opt/novell/eDirectory/conf/ndsd-multi.conf which has one nds.conf file (which corresponds to one eDirectory instance each) per line. These files are case-sensitive as always and there should be no spaces before/after them… just one eDirectory configuration file per line. The script determines who owns that eDirectory instance and then tries to start it appropriately with the existing ndsmanage command. Logs are written as mentioned above.

**Eighth**, I opted to have the ‘status’ feature of this script call ndsstat for each instance that is configured. This can have a large annoying delay if an instance is down though that should not be the norm. Also the status output is not written to the log file mentioned above as it doesn’t seem to be as useful (you’re already getting the status somehow and presumably using the output) and it could cause the file to bloat more than expected (a fair bit of output can come from the ndsstat command).

**Ninth**, so far this script does not like my Solaris 10 box. For reasons like this I like writing in Perl that just works across platforms a bit more nicely than Bash, but oh well for Solaris users at this point in time. I imagine an experienced Solaris admin can port this in about ten minutes after they finish laughing at my poor coding.

**Tenth**, this should not be used on the instance already managed by the /etc/init.d/ndsd script as it duplicates that effort. Either do not use the other at all or do not use this one for that one’s eDirectory instance.

**Eleventh**, and hopefully this is obvious, but use bunzip2, bzcat, file-roller or something like that to extract the script from the compressed file attached to this post.

![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/rating_half.gif]] (**3** votes, average: **4.67** out of 5)

Tags: [Administration](https://www.netiq.com/communities/cool-solutions/tag/administration/), [Bash](https://www.netiq.com/communities/cool-solutions/tag/bash/), [Scripting](https://www.netiq.com/communities/cool-solutions/tag/scripting/)
Categories: [Cool Tools](https://www.netiq.com/communities/cool-solutions/category/cool-tools/), [eDirectory](https://www.netiq.com/communities/cool-solutions/category/edirectory/)

* [____](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)

* [____](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)
* [____](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)
* [____](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)
* [____](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)
* [0 ](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#comments)

* * *

_

_**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment._

_

### Leave a Reply

[Logged in as akynaston](https://www.netiq.com/communities/cool-solutions/wp-admin/profile.php). [Log out?](https://www.netiq.com/communities/cool-solutions/wp-login.php?action=logout&redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fcool_tools%2Fndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux%2F&_wpnonce=83c2e1e2c1)

**Comment**

#### Leave a Comment

	![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/-s=32&d=identicon&r=g.png]] aburgemeister says:
	[June 9, 2010 at 7:34 am](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#comment-8038)
	
	The updated script, by the way, causes the location of the ndsd-multi configuration file to be changed when the location of a non-root installation of eDirectory is specified. This may not be intuitive initially but I think it makes sense in the long run. If you already give somebody access to the system with non-root installations in another location it is probably safe to assume it is also okay to give them direct access to the configuration file that controls the startup of those eDirectory instances. Anyway, hopefully it will help overall with functionality.
	
	[Reply](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#comment-8038)
	

![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/73ae119b003cd5ef13cee884c720950d.png]]
By: [ab](https://www.netiq.com/communities/cool-solutions/author/ab/)
![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/unknown_filename.png]]

June 9, 2010
3:10 pm

Reads:
3,252
Score:
4.67

[![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/pf-print-icon.gif]]Print ![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/pf-pdf-icon.gif]]PDF](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)

[![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/unknown_filename.1.png]]](https://www.netiq.com/communities/cool-solutions/sign-take-user-tests-earn-amazon-gift-cards/)

[![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/unknown_filename.2.png]]](https://www.netiq.com/promo/identity-and-access-management/privileged-users-managing-hidden-risk-in-your-organization-flash-point-paper.html?utm_campaign=IPA&utm_source=NetIQCommunities&utm_medium=banner)

### Recent Comments

### Recent Posts

### Categories

[Active Directory](https://www.netiq.com/communities/cool-solutions/tag/active_directory/) [Automation](https://www.netiq.com/communities/cool-solutions/tag/automation/) [Cloud Computing](https://www.netiq.com/communities/cool-solutions/tag/cloud-computing/) [Cloud Security](https://www.netiq.com/communities/cool-solutions/tag/cloud-security/) [Configuration](https://www.netiq.com/communities/cool-solutions/tag/configuration/) [Customizing](https://www.netiq.com/communities/cool-solutions/tag/customizing/) [Data Breach](https://www.netiq.com/communities/cool-solutions/tag/data-breach/) [DirXML](https://www.netiq.com/communities/cool-solutions/tag/dirxml/) [Drivers](https://www.netiq.com/communities/cool-solutions/tag/drivers/) [End User Management](https://www.netiq.com/communities/cool-solutions/tag/end-user-management/) [Identity Manager](https://www.netiq.com/communities/cool-solutions/tag/identity-manager/) [Importing-Exporting / ICE/ LDIF](https://www.netiq.com/communities/cool-solutions/tag/importing-exporting_ice_ldif/) [Intelligent Workload Management](https://www.netiq.com/communities/cool-solutions/tag/intelligent-workload-management/) [Knowledge Depot](https://www.netiq.com/communities/cool-solutions/tag/knowledge-depot/) [LDAP](https://www.netiq.com/communities/cool-solutions/tag/ldap/) [Migrating from Windows XP or 2003 to SUSE Linux](https://www.netiq.com/communities/cool-solutions/tag/migrating_from_windows_xp_or_2003_to_suse_linux/) [Monitoring](https://www.netiq.com/communities/cool-solutions/tag/monitoring/) [Open Enterprise Server](https://www.netiq.com/communities/cool-solutions/tag/open_enterprise_server/) [Passwords](https://www.netiq.com/communities/cool-solutions/tag/passwords/) [Reporting](https://www.netiq.com/communities/cool-solutions/tag/reporting/) [Secure Access](https://www.netiq.com/communities/cool-solutions/tag/secure_access/) [Sentinel](https://www.netiq.com/communities/cool-solutions/tag/sentinel/) [Supported](https://www.netiq.com/communities/cool-solutions/tag/supported/) [Troubleshooting](https://www.netiq.com/communities/cool-solutions/tag/troubleshooting/) [Workflow](https://www.netiq.com/communities/cool-solutions/tag/workflow/)

### Top Contributors

* [geoffc (67600)](https://www.netiq.com/communities/cool-solutions/author/geoffc)

* [martincotter (14645)](https://www.netiq.com/communities/cool-solutions/author/martincotter)
* [ab (11660)](https://www.netiq.com/communities/cool-solutions/author/ab)
* [tisenberg (7680)](https://www.netiq.com/communities/cool-solutions/author/tisenberg)
* [cstumula (5490)](https://www.netiq.com/communities/cool-solutions/author/cstumula)
* [alexmchugh (3250)](https://www.netiq.com/communities/cool-solutions/author/alexmchugh)
* [TSureshkumar (2570)](https://www.netiq.com/communities/cool-solutions/author/TSureshkumar)
* [ScorpionSting (2400)](https://www.netiq.com/communities/cool-solutions/author/ScorpionSting)
* [ncashell (1885)](https://www.netiq.com/communities/cool-solutions/author/ncashell)
* [alekz (1370)](https://www.netiq.com/communities/cool-solutions/author/alekz)

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

* [Request a Call ›](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)

* Sales: 1-888-323-6768

© 2016 Micro Focus [Legal](https://www.netiq.com/company/legal/) [Privacy](https://www.netiq.com/company/legal/privacy/) [Feedback](https://www.netiq.com/common/inc/feedback_overlay.html?iframe=true)

[Scroll to Top](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#)

[Skip to toolbar](https://www.netiq.com/communities/cool-solutions/cool_tools/ndsd-multi-way-start-multiple-edirectory-instances-simultaneously-linux/#wp-toolbar)

* normal[My Sites](https://www.netiq.com/communities/wp-admin/my-sites.php) normal

* normal[Cool Solutions](https://www.netiq.com/communities/cool-solutions/wp-admin/) normal
* normal[New](https://www.netiq.com/communities/cool-solutions/wp-admin/post-new.php) normal
	* normal
		
		Search
		
		normal
	* normal[Howdy, akynaston![[./_resources/ndsd-multi__a_way_to_start_multiple_eDirectory_instances_simultaneously_in_Linux_-_Cool_Solutions__NetIQ.resources/dc1626821e3d28c54253a175efbdd7c4.png]]](https://www.netiq.com/communities/cool-solutions/wp-admin/profile.php) normal
[Log Out](https://www.netiq.com/communities/cool-solutions/wp-login.php?action=logout&_wpnonce=83c2e1e2c1)
