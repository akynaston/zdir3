# Re: "Setup was unable create a new system partitio... - SanDisk Forums [forums.sandisk.com]

Newbie

[![[./_resources/Re_Setup_was_unable_create_a_new_system_partitio..._-_SanDisk_Forums_forums.sandisk.com.resources/message.png]]](http://forums.sandisk.com/t5/user/viewprofilepage/user-id/65898)

Posts: 2
Registered: ‎06-20-2012

0

.

.

# Re: "Setup was unable create a new system partition" error installing Win7

.

[Options](http://forums.sandisk.com/t5/SanDisk-Extreme-SSD-Legacy/quot-Setup-was-unable-create-a-new-system-partition-quot-error/m-p/284070/highlight/true#)

.

.

.
.

‎09-24-2012 12:34 PM

In such a situation, you can clean the entire SSD using diskpart and this will ensure that the boot sector and system reserved partition is also cleaned. Try using the following method to clean the SSD and use the windows automatic partitioning to create partition for the installation of the operating system.

1\. Insert the windows 7 DVD into the DVD drive.
2.On the disk selection screen, press SHIFT+F10. A Command Prompt window opens.
3.Type diskpart, and then press ENTER to open the diskpart tool.
4.Type list disk, and then press ENTER. A list of available hard disks is displayed.
5.Type sel disk number, and then press ENTER. number is the number of the hard disk that you want to clean. The hard disk is now selected.
6.Type det disk, and then press ENTER. A list of partitions on the hard disk is displayed. Use this information to verify that the correct disk is selected.
7.Make sure that the disk does not contain required data, type clean all, and then press ENTER to clean the disk.

All the partitions and all the data on the disk is permanently removed.
8.Type exit, and then press ENTER to close

9\. Continue istallation of Windows OS by using automatic partitioning scheme rather than creating partitions yourself.

This worked for me in a similar situation. Hope will work for you as well. Best of Luck

:-)

.
.
.

.
