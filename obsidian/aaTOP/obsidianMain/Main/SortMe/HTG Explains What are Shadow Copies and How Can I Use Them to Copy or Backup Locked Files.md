# HTG Explains: What are Shadow Copies and How Can I Use Them to Copy or Backup Locked Files?

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.5.gif]]](http://www.howtogeek.com/)

<http://www.howtogeek.com/>

* [ARTICLES](http://www.howtogeek.com/129188/htg-explains-what-are-shadow-copies-and-how-can-i-use-them-to-copy-or-backup-locked-files/#)

* [DISCUSSION](http://discuss.howtogeek.com/)

* [SUBSCRIBE](http://www.howtogeek.com/129188/htg-explains-what-are-shadow-copies-and-how-can-i-use-them-to-copy-or-backup-locked-files/#)

* [GADGETS](http://www.howtogeek.com/t/gadgets)

* [GEEK SCHOOL](http://www.howtogeek.com/school/)

SEARCH

.
.

## [HTG Explains: What are Shadow Copies and How Can I Use Them to Copy or Backup Locked Files?](http://www.howtogeek.com/129188/htg-explains-what-are-shadow-copies-and-how-can-i-use-them-to-copy-or-backup-locked-files/)

![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/image161.png]]

When trying to create simple file copy backups in Windows, a common problem is locked files which can trip up the operation. Whether the file is currently opened by the user or locked by the OS itself, certain files have to be completely unused in order to be copied. Thankfully, there is a simple solution: Shadow Copies.

Using our simple tool, you can easily access shadow copies which allows access to point-in-time copies of the currently locked files as created by Windows Restore.

_Image credit: [Best Backup Services](http://www.bestbackupservices.com/)_

### What are Shadow Copies?

Shadow copies are a concept which was first introduced in Windows Server 2003. It works by Windows periodically crawling the system and looking for file changes made since the last crawl and recording the changes. These changes are indexed and stacked on top of each other which creates a history of the file/folder. This process was then added to the Windows Vista OS under the System Restore function which is where it remains today. The technology is the foundation of the [Windows previous versions functionality](http://www.howtogeek.com/56891/use-windows-7s-previous-versions-to-go-back-in-time-and-save-your-files/).

This is done in the background as a system level process (a Restore Point creation) which isn’t subject to the same limitations as user initiated file operations. As a result, the system is able to capture changes to files which are locked to the user.

So in order to access a locked file, we simply need to access the latest shadow copy. This is the same premise used by Windows Backup and other commercial backup products which are able to access, for example, Outlook PST files while Outlook remains open.

It is important to note, however, that since shadow copies are taken when a system restore point is created, the contents between the live file and shadow copy version can be different. By default, [Windows creates a restore point every day](http://www.howtogeek.com/howto/windows-vista/change-how-often-system-restore-creates-restore-points-in-windows-vista/) so for most situations this should be a reasonable candidate for backup.

### Accessing Shadow Copies

From this point, the article assumes you are using our tool provided via the link at the bottom of the article. The batch script should be placed in a folder set in your Windows PATH variable. If you are unsure, just place it in your C:\\Windows directory and that should be good enough.

In order to access the files saved within shadow copies, we utilize the VSSAdmin command line tool which is included with Windows. This tool must be run as the administrator in order to function properly so when you open a command prompt, be sure to right-click and select the option to ‘Run as Administrator’.

![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/image162.png]]

Once open, our tool does the heavy lifting for you. To view the syntax and header information for the tool, just enter:

> MountLatestShadowCopy /?

![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/image163.png]]

As an example, the command:

> MountLatestShadowCopy C:\\LatestShadow\\ C:

will perform the following actions:

1. Locate the latest shadow copy for drive C.

* Create a symbolic link/pseudo-directory “C:\\LatestShadow”
* Make the entire contents of the shadow copy available at this directory.

Once complete, you are free browse the contents either through the command prompt:

![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/image164.png]]

or through Windows Explorer, just like any other folder.

![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/image165.png]]

When you are finished, you can simply delete the pseudo-directory through the command prompt using:

> RMDIR C:\\LatestShadow

or directly through Windows Explorer. The delete action simply unmounts the folder and does not actually delete the shadow copy.

![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/image166.png]]

### Using in Scripts / Automated Tasks

The information above is all fine and dandy, but through manual operation it is more relevantly accessible via Windows previous versions. The leverage our tool provides is during automated processes.

For example, the script below will mount the latest shadow copy to the local directory “C:\\MyShadow” and then copy the “outlook.pst” located in user JDoe’s documents folder to a backup server. Once finished, the local directory which held the shadow copy location is removed to clean itself up.

> CALL MountLatestShadowCopy C:\\MyShadow\\
> 
> XCOPY “C:\\MyShadow\\Users\\JDoe\\Documents\\Outlook\\outlook.pst” “\\\\BackupServer\\MyFiles\\”
> 
> RMDIR C:\\MyShadow

If you tried to copy the live version of the same file and the user had it open at the time, your file copy operation would fail. However, since we accessed the file via a shadow copy, there are no locks and the copy procedure virtually always succeeds. As stated previously, this procedure is pretty much exactly how popular backup products are able to do the same thing.

An important piece of information noted above is that in order to run the above script, or any script which uses the MountLatestShadowCopy.bat tool (which, again makes use of the VSSAdmin tool), the command prompt must be run as the administrator account. In order to use this tool inside of a scheduled task, the respective task must be set to ‘Run with highest privileges’ so that the automated process will have the ability to mount shadow copies using the VSSAdmin tool.

![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/image167.png]]

In a nutshell, performing file copy backups is almost always the safest when copying from shadow copies. While you will not always get the most up to date version of a file, the fact that you know the file will not be locked and the copy procedure will run can be quite advantageous under most circumstances.

[Download MountLatestShadowCopy tool](http://cdn5.howtogeek.com/wp-content/uploads/2012/11/MountLatestShadowCopy.zip) from HowToGeek.com

[JOIN THE DISCUSSION](http://discuss.howtogeek.com/)

[Jason Faulkner](http://jasonfaulkner.com/) is a developer and IT professional who never has a hot cup of coffee far away. Interact with him on [Google+](https://plus.google.com/101815490703182350015?rel=author)

* Published 11/26/12

[by Taboola](http://www.taboola.com/en/popup?template=colorbox&taboola_utm_source=howtogeek-howtogeek&taboola_utm_medium=bytaboola&taboola_utm_content=thumbs-2r:below-article:)
[Sponsored Links](http://www.taboola.com/en/popup?template=colorbox&taboola_utm_source=howtogeek-howtogeek&taboola_utm_medium=bytaboola&taboola_utm_content=thumbs-2r:below-article:)

FROM THE WEB

[SHOW ARCHIVED READER COMMENTS (10)](http://www.howtogeek.com/129188/htg-explains-what-are-shadow-copies-and-how-can-i-use-them-to-copy-or-backup-locked-files/?showcomments=1#comments)

#### GEEK TRIVIA

[In Iceland There’s A Smartphone App To Help Prevent?](http://www.howtogeek.com/trivia/in-iceland-theres-a-smartphone-app-to-help-prevent/)

#### DID YOU KNOW?

When Texas State University researchers ran out of funding for their expedition to uncover artifacts from the wreck of 17th century pirate Captain Morgan’s ship, the necessary funds were supplied by the Captain Morgan rum company.

#### BEST OF HOW-TO GEEK

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.8.webp]]](http://www.howtogeek.com/135976/how-to-update-your-graphics-drivers-for-maximum-gaming-performance/)
[How to Update Your Graphics Drivers for Maximum Gaming Performance](http://www.howtogeek.com/135976/how-to-update-your-graphics-drivers-for-maximum-gaming-performance/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.2.webp]]](http://www.howtogeek.com/135005/how-to-use-a-windows-installer-disc-to-back-up-your-files-when-your-computer-wont-boot/)
[How to Use a Windows Installer Disc to Back Up Your Files When Your Computer Won’t Boot](http://www.howtogeek.com/135005/how-to-use-a-windows-installer-disc-to-back-up-your-files-when-your-computer-wont-boot/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.10.webp]]](http://www.howtogeek.com/172768/why-old-programs-dont-run-on-modern-versions-of-windows-and-how-you-can-run-them-anyway/)
[Why Old Programs Don’t Run on Modern Versions of Windows (and How You Can Run Them Anyway)](http://www.howtogeek.com/172768/why-old-programs-dont-run-on-modern-versions-of-windows-and-how-you-can-run-them-anyway/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.9.webp]]](http://www.howtogeek.com/164413/how-and-why-to-back-up-your-cloud-data/)
[How and Why to Back Up Your Cloud Data](http://www.howtogeek.com/164413/how-and-why-to-back-up-your-cloud-data/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.4.webp]]](http://www.howtogeek.com/169477/ask-how-to-geek-where-can-i-find-good-multiplayer-games/)
[Ask How-To Geek: Where Can I Find Good Multiplayer Games?](http://www.howtogeek.com/169477/ask-how-to-geek-where-can-i-find-good-multiplayer-games/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.7.webp]]](http://www.howtogeek.com/197980/6-great-windows-10-features-you-can-get-today-on-windows-7-or-8/)
[6 Great Windows 10 Features You Can Get Today on Windows 7 or 8](http://www.howtogeek.com/197980/6-great-windows-10-features-you-can-get-today-on-windows-7-or-8/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.3.webp]]](http://www.howtogeek.com/howto/38107/htg-explains-why-does-photo-paper-improve-print-quality/)
[HTG Explains: Why Does Photo Paper Improve Print Quality?](http://www.howtogeek.com/howto/38107/htg-explains-why-does-photo-paper-improve-print-quality/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.webp]]](http://www.howtogeek.com/170648/10-commands-included-in-chrome-oss-hidden-crosh-shell/)
[10+ Commands Included In Chrome OS’s Hidden Crosh Shell](http://www.howtogeek.com/170648/10-commands-included-in-chrome-oss-hidden-crosh-shell/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.6.webp]]](http://www.howtogeek.com/164570/how-to-install-android-in-virtualbox/)
[How to Install Android in VirtualBox](http://www.howtogeek.com/164570/how-to-install-android-in-virtualbox/)

[![[./_resources/HTG_Explains_What_are_Shadow_Copies_and_How_Can_I_Use_Them_to_Copy_or_Backup_Locked_Files.resources/unknown_filename.1.webp]]](http://www.howtogeek.com/204335/warning-encrypted-wpa2-wi-fi-networks-are-still-vulnerable-to-snooping/)
[Warning: Encrypted WPA2 Wi-Fi Networks Are Still Vulnerable to Snooping](http://www.howtogeek.com/204335/warning-encrypted-wpa2-wi-fi-networks-are-still-vulnerable-to-snooping/)

.

.
.
.

ABOUT

* [About Us](http://www.howtogeek.com/about/)

* [Contact Us](http://www.howtogeek.com/contact/)
* [Advertising](http://purch.com/)
* [Privacy Policy](http://www.howtogeek.com/privacy-policy/)

GET ARTICLES BY EMAIL

Enter your email address to get our daily newsletter.

FOLLOW US

* [Twitter](https://twitter.com/intent/user?original_referer=http://www.howtogeek.com&region=following&screen_name=howtogeeksite&tw_p=followbutton&variant=2.0)

* [Facebook](http://facebook.com/thehowtogeek)
	* [Google+](http://plus.google.com/+howtogeek)
	* [RSS Feed](http://feeds.howtogeek.com/howtogeek)

Copyright © 2006-2015 How-To Geek, LLC  All Rights Reserved. Hosted by [Linode](https://www.linode.com/?r=6740c4467b19609240eba084832097902986f20b).
