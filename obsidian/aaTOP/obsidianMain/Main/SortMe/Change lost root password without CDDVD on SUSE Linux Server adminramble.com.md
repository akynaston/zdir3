# Change lost root password without CD/DVD on SUSE Linux Server [adminramble.com]

# [SysAdmin Ramblings](http://adminramble.com/)

## Just another sysadmin blog

[![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.10.jpeg]]](http://adminramble.com/)
Search

### Main menu

[Skip to primary content](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/#content)
[Skip to secondary content](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/#secondary)

* [Home](http://adminramble.com/)

* [Contact](http://adminramble.com/contact/)
* [WebHosting discount codes](http://adminramble.com/webhosting-coupons/)

### Post navigation

[← Previous](http://adminramble.com/convert-batch-doc-files-docx-work-ppt-xls-files/) [Next →](http://adminramble.com/fixed-unable-install-cisco-ipsec-vpn-client-error-27850-file-dneinobj-dll-deterministic-network-enhancer-disk-needed/)

# How to reset lost root password on SUSE Linux Enterprise Server

Posted on [July 25, 2012](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/) by [Rambling SysAdmin](http://adminramble.com/author/adminramble/)

I had to access one of my virtual machines that I didn’t use for a while today, and of course  I couldn’t remember the password I used for it, so I had to change it.

## Here is how to reset a forgotten root password on Novell SLES (I worked on SLES 10 SP3 here):

1. On the boot menu select the first option “SUSE Linux enterprise server” and press _‘e’_ for edit
	
	[![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.9.png]]](http://i2.wp.com/adminramble.com/wp-content/uploads/2012/07/SLES_boot_menu.png)
	

* On the second menu select the kernel option and press _‘e’_ for edit
	
	[![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.4.png]]](http://i0.wp.com/adminramble.com/wp-content/uploads/2012/07/SLES_boot_menu_edit.png)
	
* type ‘ init=/bin/bash’ (**leave empty space** at the begging), and press _‘Enter’_ and then _‘b’_ to boot with that option
	
	[![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.8.png]]](http://i0.wp.com/adminramble.com/wp-content/uploads/2012/07/SLES_init_bin_bash.png)
	
* The system will boot with the root user logged on, type _‘passwd’_ to change the password and input your new password, or just press ‘Enter’ for no password (blank password)
	
	[![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.5.png]]](http://i0.wp.com/adminramble.com/wp-content/uploads/2012/07/SLES_change_password.png)
	
Reboot the server and log on with your new password.

### Related Posts

* [![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.14.png]]](http://adminramble.com/install-mysql-yast/)January 9, 2012 -- [How to install MySQL through YaST](http://adminramble.com/install-mysql-yast/) (0)
	I was looking into Novell Service Desk as solution for our Help-desk department today, so i decided to test it by installing it on a single machine together with a MySQL server to act as its databa...

*  [![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.jpeg]]](http://androidspin.com/2010/12/30/rooted-nookcolors-getting-getting-a-forced-factory-reset/)[Rooted NOOKcolor's getting getting a forced factory Reset?](http://androidspin.com/2010/12/30/rooted-nookcolors-getting-getting-a-forced-factory-reset/)
* [![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.12.jpeg]]promoted](http://www.zdnet.com/five-operating-system-alternatives-to-windows-8-and-xp-7000013765/)[Five operating system alternatives to Windows 8 and XP](http://www.zdnet.com/five-operating-system-alternatives-to-windows-8-and-xp-7000013765/)

### Share this:

* 

* [Digg](http://digg.com/submit?url=http%3A%2F%2Fadminramble.com%2Freset-lost-root-password-suse-linux-enterprise-server%2F&amp;title=How%20to%20reset%20lost%20root%20password%20on%20SUSE%20Linux%20Enterprise%20Server)

* <http://pinterest.com/pin/create/button/?url=http%3A%2F%2Fadminramble.com%2Freset-lost-root-password-suse-linux-enterprise-server%2F&amp;media=http%3A%2F%2Fadminramble.com%2Fwp-content%2Fuploads%2F2012%2F07%2FSLES_change_password.png&amp;guid=iF65z_xLXieV&amp;description=How%20to%20reset%20lost%20root%20password%20on%20SUSE%20Linux%20Enterprise%20Server>
* [Share on Tumblr](http://www.tumblr.com/share/link/?url=http%3A%2F%2Fadminramble.com%2Freset-lost-root-password-suse-linux-enterprise-server%2F&amp;name=How%20to%20reset%20lost%20root%20password%20on%20SUSE%20Linux%20Enterprise%20Server)
* [More](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/#)

### Like this:

This entry was posted in [How-to](http://adminramble.com/category/tutorials/how-to/), [Linux](http://adminramble.com/category/linux-2/), [Novell](http://adminramble.com/category/novell/) and tagged [linux](http://adminramble.com/tag/linux/), [Novell](http://adminramble.com/tag/novell/) by [Rambling SysAdmin](http://adminramble.com/author/adminramble/). Bookmark the [permalink](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/).

* Legitimate work at home

* Free work at home
* Check Your

* Online Course
* Sharing
* Shares
* Course
* Option

## 2 thoughts on “How to reset lost root password on SUSE Linux Enterprise Server”

1. ![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.2.png]]
	
	![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.11.png]]Anonymous on [December 3, 2012 at 17:51](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/comment-page-1/#comment-241) said:
	
	Veri Nice ![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.7.gif]] Thank you very much for your help
	
	[Reply ↓](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/?replytocom=241#respond)
	
2. ![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.2.png]]
	
	![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.3.png]][Felixrising](http://gravatar.com/felixrising) on [April 26, 2013 at 03:09](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/comment-page-1/#comment-298) said:
	
	It would be good to include a alternative method when you have a USB keyboard that doesn’t work (no modules loaded and no usb support compiled into the kernel) when doing a init=/bin/bash recovery.
	
	[Reply ↓](http://adminramble.com/reset-lost-root-password-suse-linux-enterprise-server/?replytocom=298#respond)
	

### Leave a Reply

### Most Viewed Posts

* [Common FortiClient SSL VPN errors (48657)](http://adminramble.com/common-forticlient-ssl-vpn-errors/)

* [FortiClient SSL VPN not connecting, status: connecting stops at 40. Unable to establish the VPN connection. The VPN server may be unreachable -5 (33934)](http://adminramble.com/forticlient-ssl-vpn-connecting-status-connecting-stops-40/)
* [Some FortiGate commands you might need (19032)](http://adminramble.com/fortigate-useful-commands/)

[![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.15.gif]]](http://secure.hostgator.com/~affiliat/cgi-bin/affiliates/clickthru.cgi?id=aramble-)

### Recent Posts

* [New app registered with whostmgr AppConfig: csf](http://adminramble.com/app-registered-whostmgr-appconfig-csf/)

* [ConfigServer Internal Server Error 500, after cPanel update: fixed](http://adminramble.com/configserver-internal-server-error-500-cpanel-update-fixed/)
* [Blue squares and bars when connected with remote desktop](http://adminramble.com/blue-squares-bars-connected-remote-desktop/)

[![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.6.png]]](http://adminramble.com/feed/) [RSS - Posts](http://adminramble.com/feed/)

[NetworkedBlogs](http://www.facebook.com/apps/application.php?id=9953271133)

|     |
| --- |
| Blog: |
| [SysAdmin Ramblings](http://www.networkedblogs.com/blog/sysadminramblings) |
| Topics: |
| [Sysadmin](http://www.networkedblogs.com/topic/Sysadmin), [Computers](http://www.networkedblogs.com/topic/Computers), [Servers](http://www.networkedblogs.com/topic/Servers) |
|     |
| [Follow my blog](http://www.networkedblogs.com/blog/sysadminramblings?ahash=bf0674c9b789e03b8db4328442294180) |

### Categories

* [Android](http://adminramble.com/category/android-2/)

* [Apple](http://adminramble.com/category/apple/)
* [Cisco](http://adminramble.com/category/cisco/)
* [Fortinet](http://adminramble.com/category/fortinet/)
* [How-to](http://adminramble.com/category/tutorials/how-to/)
* [Linux](http://adminramble.com/category/linux-2/)
* [Microsoft](http://adminramble.com/category/microsoft/)
* [Novell](http://adminramble.com/category/novell/)
* [TerminalWorks](http://adminramble.com/category/terminalworks/)
* [Tutorials](http://adminramble.com/category/tutorials/)
* [Uncategorized](http://adminramble.com/category/uncategorized/)
* [Useful apps](http://adminramble.com/category/useful-apps/)
* [Webhosting](http://adminramble.com/category/webhosting/)
* [Wordpress](http://adminramble.com/category/wordpress/)

### Archives

* [July 2013](http://adminramble.com/2013/07/)

* [June 2013](http://adminramble.com/2013/06/)
* [February 2013](http://adminramble.com/2013/02/)
* [September 2012](http://adminramble.com/2012/09/)
* [August 2012](http://adminramble.com/2012/08/)
* [July 2012](http://adminramble.com/2012/07/)
* [June 2012](http://adminramble.com/2012/06/)
* [April 2012](http://adminramble.com/2012/04/)
* [March 2012](http://adminramble.com/2012/03/)
* [February 2012](http://adminramble.com/2012/02/)
* [January 2012](http://adminramble.com/2012/01/)
* [December 2011](http://adminramble.com/2011/12/)

[![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.1.gif]]](http://www.blogged.com/blogs/syadmin-ramblings.html)

[![Hostgator-new-_AN--300x250-.gif](http://tracking.hostgator.com/img/Discount_Shared/Hostgator-new-_AN--300x250-.gif)](http://secure.hostgator.com/~affiliat/cgi-bin/affiliates/clickthru.cgi?id=aramble-)

[Proudly powered by WordPress](http://wordpress.org/)
![[./_resources/Change_lost_root_password_without_CDDVD_on_SUSE_Linux_Server_adminramble.com.resources/unknown_filename.13.gif]]

Searching for **recover suse root password**?
