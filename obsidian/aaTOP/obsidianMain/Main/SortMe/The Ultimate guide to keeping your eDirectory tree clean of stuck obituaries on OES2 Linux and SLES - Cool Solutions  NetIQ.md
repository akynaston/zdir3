# The Ultimate guide to keeping your eDirectory tree clean of stuck obituaries on OES2 Linux and SLES - Cool Solutions | NetIQ

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

* [**United States, English**](https://www.netiq.com/common/util/langselect.php?referer=https%3A//www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/) 
	
	[Close](https://www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/#)
	
* [**Let's Talk**](https://www.netiq.com/company/contact/) 

## [NetIQ Communities](https://www.netiq.com/communities/)

* [NetIQ Cool Solutions __](https://www.netiq.com/communities/cool-solutions/)

* [NetIQ Views __](https://www.netiq.com/communities/cool-solutions/netiq-views/)
* [NetIQ Support Forums __](https://forums.netiq.com/)

## The Ultimate guide to keeping your eDirectory tree clean of stuck obituaries on OES2 Linux and SLES

This guide is designed to help you learn the ins and outs of processing stuck obituaries on OES2 Linux and SLES. It provides all of the required commands to help you stop guessing and panicking in times when you really need it. It also provides some guidelines for learning about the obituary process first so that you don’t do something you should not be doing. In the end, it makes obituary processing easy and straightforward on Linux…

To proactively keep your eDirectory tree healthy, run automated, scheduled reports using iMonitor on a regular basis, and check the results regularly.

Check time synchronization, replica synchronization status and external references for stuck obituaries on a regular basis. Check to make sure all servers are up and running. Follow Novell TID NDS / eDirectory Health Check Procedures – Cross Platform TID (10060600)

If you run into stuck obituaries that will not clear themselves, the following are some tips that can help to clear them.

Be sure to check the health of eDirectory to make sure time is in sync and synchronization of all replicas on servers are processing without errors. Check to make sure all servers are up and running.

– Check eDirectory time synchronization: ndsrepair -T
– Check Replica Synchronization Status: ndsrepair -E
– Check external references for stuck obituaries: ndsrepair -C -Ad -A

Follow Novell TIDs such as How to progress stuck obituaries TID (7002659) for additional details on the obituary process so that you understand the ins and outs of obituary processing.

Go through TID Processing stuck obituaries in All DS versions (7001603) for some of the dsrepair and ndstrace commands on Linux. More useful commands are below.

By going through the above documents first, you will gain a better understanding of how to proactively keep your eDirectory tree healthy and free of stuck obituaries, you will gain a better understanding of the obituary process and the commands involved to better prepare yourself to clean them up completely should you run into stuck obituaries.

After going through the above information, use the following tips to make sure you are not wasting time and effort, and not creating more problems by running processes you should not be running in certain cases.

**Tip #1**

Always remember to get a backup copy of your dibset before going forward with any operations that could negatively affect eDirectory. With Linux or Unix, one alternative for getting a backup is ndsrc.pl script – <http://www.novell.com/communities/node/1129/ndsrc> . Another alternative is to setup dsbk to automate your backups, or to get a backup when you need to using the following documentation. <http://www.novell.com/documentation/edir88/edir88/?page=/documentation/edir88/edir88/data/bsl7jmp.html>

**Tip #2**

Only timestamp an obituary if other new obituaries in the same partition are processing fine but obituaries with older dates and times are still unprocessed. You will notice that the timestamps on these obituaries are older so they are not being seen by the purger (behind the purge vector) ndsrepair -R -Ad -A -OT

This will timestamp all the obits.
Then run: ndstrace
At the ndstrace prompt type: set ndstrace = \*j
Then type: set ndstrace = \*f

Keep in mind that this can take a long time on a large DIB and would probably be better if done on single objects or partitions unless there are too many stuck obituaries throughout the tree.

**Tip #3**

Repair obits that are showing insync with some kind of error EX: -699 or -618. You can use a single object repair with ndsrepair -Ad -J (You will need to provide the Entry ID (in hexadecimal format) of the object you want to repair). Alternatively this can be done using iMonitor to simplify the process.

**Tip #4**

XK3 and then re-backlink servers that show in the backlink list (from the external reference report) with flags of 0000 and don’t hold replicas of the partition.

ndsrepair -R -Ad -Xk3
set ndstrace = +BLNK

**Tip #5**

Check to make sure any server with flags 0000 is up and communicating. You will see these flags in the External Reference report generated..

![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/rating_off.gif]] (_**0** votes, average: **0.00** out of 5_)
_You need to be a registered member to rate this post._

Tags: [Obituaries](https://www.netiq.com/communities/cool-solutions/tag/obituaries/), [Open Enterprise Server](https://www.netiq.com/communities/cool-solutions/tag/open_enterprise_server/), [SUSE Linux Enterprise Server](https://www.netiq.com/communities/cool-solutions/tag/suse_linux_enterprise_server/)
Categories: [eDirectory](https://www.netiq.com/communities/cool-solutions/category/edirectory/), [Technical Solutions](https://www.netiq.com/communities/cool-solutions/category/technical-solutions/)

* [____](https://www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/#)

* [____](https://www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/#)
* [____](https://www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/#)
* [____](https://www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/#)
* [____](https://www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/#)
* [0 ](https://www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/#comments)

* * *

_

_**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment._

_

### Leave a Reply

You must be [logged in](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle%2F) to post a comment.

_No Comments_

![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/8000a2f6c2fe2037e29505f1bee1e597.png]]
By: [VDLeduc](https://www.netiq.com/communities/cool-solutions/author/VDLeduc/)
![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/unknown_filename.1.png]]

October 31, 2011
11:48 am

Reads:
2,299
Score:
Unrated

[![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/pf-print-icon.gif]]Print ![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/pf-pdf-icon.gif]]PDF](http://www.printfriendly.com/print?url=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle%2F)

[![[./_resources/The_Ultimate_guide_to_keeping_your_eDirectory_tree_clean_of_stuck_obituaries_on_OES2_Linux_and_SLES_-_Cool_Solutions__NetIQ.resources/unknown_filename.png]]](https://www.netiq.com/promo/identity-and-access-management/privileged-users-managing-hidden-risk-in-your-organization-flash-point-paper.html?utm_campaign=IPA&utm_source=NetIQCommunities&utm_medium=banner)

### Recent Comments

### Recent Posts

### Categories

### Popular Topics

[Active Directory](https://www.netiq.com/communities/cool-solutions/tag/active_directory/) [Automation](https://www.netiq.com/communities/cool-solutions/tag/automation/) [Cloud Computing](https://www.netiq.com/communities/cool-solutions/tag/cloud-computing/) [Cloud Security](https://www.netiq.com/communities/cool-solutions/tag/cloud-security/) [Configuration](https://www.netiq.com/communities/cool-solutions/tag/configuration/) [Contact Management](https://www.netiq.com/communities/cool-solutions/tag/contact_management/) [Customizing](https://www.netiq.com/communities/cool-solutions/tag/customizing/) [Data Breach](https://www.netiq.com/communities/cool-solutions/tag/data-breach/) [DirXML](https://www.netiq.com/communities/cool-solutions/tag/dirxml/) [Drivers](https://www.netiq.com/communities/cool-solutions/tag/drivers/) [End User Management](https://www.netiq.com/communities/cool-solutions/tag/end-user-management/) [Identity Manager](https://www.netiq.com/communities/cool-solutions/tag/identity-manager/) [Importing-Exporting / ICE/ LDIF](https://www.netiq.com/communities/cool-solutions/tag/importing-exporting_ice_ldif/) [Intelligent Workload Management](https://www.netiq.com/communities/cool-solutions/tag/intelligent-workload-management/) [Knowledge Depot](https://www.netiq.com/communities/cool-solutions/tag/knowledge-depot/) [LDAP](https://www.netiq.com/communities/cool-solutions/tag/ldap/) [Migrating from Windows XP or 2003 to SUSE Linux](https://www.netiq.com/communities/cool-solutions/tag/migrating_from_windows_xp_or_2003_to_suse_linux/) [Monitoring](https://www.netiq.com/communities/cool-solutions/tag/monitoring/) [Open Enterprise Server](https://www.netiq.com/communities/cool-solutions/tag/open_enterprise_server/) [Passwords](https://www.netiq.com/communities/cool-solutions/tag/passwords/) [Reporting](https://www.netiq.com/communities/cool-solutions/tag/reporting/) [Secure Access](https://www.netiq.com/communities/cool-solutions/tag/secure_access/) [Supported](https://www.netiq.com/communities/cool-solutions/tag/supported/) [Synchronization](https://www.netiq.com/communities/cool-solutions/tag/synchronization/) [Troubleshooting](https://www.netiq.com/communities/cool-solutions/tag/troubleshooting/)

### Top Contributors

* [geoffc (42250)](https://www.netiq.com/communities/cool-solutions/author/geoffc)

* [martincotter (10030)](https://www.netiq.com/communities/cool-solutions/author/martincotter)
* [ab (9710)](https://www.netiq.com/communities/cool-solutions/author/ab)
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

* [Request a Call ›](https://www.netiq.com/communities/cool-solutions/ultimate-guide-keeping-your-edirectory-tree-clean-stuck-obituaries-oes2-linux-and-any-sle/#)

* Sales: 1-888-323-6768

© 2015 NetIQ Corporation [Legal](https://www.netiq.com/company/legal/) [Privacy](https://www.netiq.com/company/legal/privacy/) [Feedback](https://www.netiq.com/common/inc/feedback_overlay.html?iframe=true)
