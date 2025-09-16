# [Fix] Windows Photo Viewer Takes Too Much Time in Opening Images - AskVG [www.askvg.com]

# \[Fix\] Windows Photo Viewer Takes Too Much Time in Opening Images

[**Windows Photo Viewer**](http://www.askvg.com/tip-make-photo-viewer-app-in-windows-7-and-8-1-metro-style/) is a built-in image viewer program in Windows operating system. It comes preinstalled in Windows 7, Windows 8 and later Windows versions. Windows Photo Viewer was also present in good ol' Windows XP with a different name "Windows Picture and Fax Viewer".

![[./_resources/Fix_Windows_Photo_Viewer_Takes_Too_Much_Time_in_Opening_Images_-_AskVG_www.askvg.com.resources/Windows_Photo_Viewer_Default_White_Background.png]]

Since a few days I was facing a very annoying problem in **[Windows 8.1](http://www.askvg.com/exclusive-windows-8-1-features-list/)**. Windows Photo Viewer was extremely slow and was taking too much time in loading images. Whenever I tried to open a picture file using Windows Photo Viewer program, it was taking long time in opening that picture. The computer is very fast and all Windows updates are installed. Everything runs fine except Windows Photo Viewer.

I searched and found various solutions to fix this strange and irritating problem. Today in this topic, I'm going to share all possible solutions to troubleshoot this **slow Windows Photo Viewer problem**.

If you are also facing this problem, try following solutions:

> **SOLUTION 1: Deleting Display Profile in Color Management**

In Windows XP, the default "Windows Picture and Fax Viewer" program was using GDI+ (Graphics Device Interface) to show graphics on screen but Microsoft changed this behavior in Windows 7. Now "Windows Photo Viewer" program utilizes Windows Imaging Component (WIC) to take all advantages of the advanced Windows Display Driver Model (WDDM) architecture.

Sometimes this change might cause this annoying problem. To fix this problem, you'll need to remove the monitor calibration profile from color management program.

**1.** Press **WIN+R** keys together to launch RUN dialog box. Now type **colorcpl.exe** in RUN dialog box and press Enter. It'll open Color Management window.

**2.** Now go to **Advanced** tab and click on "**Change system defaults...**" button.

![[./_resources/Fix_Windows_Photo_Viewer_Takes_Too_Much_Time_in_Opening_Images_-_AskVG_www.askvg.com.resources/Changing_Color_Management_Default_Settings.png]]

**3.** Now select the default profile and click on **Remove** button.

If you see other profiles having **calibrated** term in their names, delete them as well.

**4.** Close all programs and restart Windows.

It should solve the slow Windows Photo Viewer problem.

> **SOLUTION 2: Another Way to Delete Calibrated Display Profile**

If the first solution doesn't work for you, try following:

**1.** Open Windows Explorer and go to following folder:

> C:\\WINDOWS\\System32\\spool\\drivers\\color

Alternatively, you can direct open it using **%windir%\\system32\\spool\\drivers\\color** command in RUN dialog box.

**2.** Now you'll see various files in **color** folder such as .icc, .camp, .gmmp, .icm, .cdmp, etc. If you find any file with a name similar to **CalibratedDisplayProfile-x.icc**, delete it.

![[./_resources/Fix_Windows_Photo_Viewer_Takes_Too_Much_Time_in_Opening_Images_-_AskVG_www.askvg.com.resources/Deleting_Calibrated_Display_Profile_ICC_File.png]]

**3.** Restart Windows and it should solve the problem.

> **SOLUTION 3: Set Windows Photo Viewer as Default Program**

Make sure Windows Photo Viewer is set as default program to view pictures:

**1.** Open Control Panel, click on **Default Programs** icon and then click on **Set your default programs** link.

Alternatively, you can direct open it using following command in RUN dialog box:

> explorer.exe shell:::{17CD9488-1228-4B2F-88CE-4298E93E0966}\\pageDefaultProgram

**2.** Now click on **Windows Photo Viewer** entry present in the list and then click on "**Set this program as default**" option.

![[./_resources/Fix_Windows_Photo_Viewer_Takes_Too_Much_Time_in_Opening_Images_-_AskVG_www.askvg.com.resources/Set_Windows_Photo_Viewer_Default_Program.png]]

**3.** Close the window and now Windows Photo Viewer should open image files faster.

> **SOLUTION 4: Using Registry Editor**

If above mentioned solutions don't work for you, then it might be a cache problem. I found a Registry tweak on Microsoft support to disable Windows Photo Viewer cache feature which can fix this slowness problem:

**1.** Type **regedit** in RUN or Start search box and press Enter. It'll open **Registry Editor**.

**2.** Now go to following key:

> HKEY\_CURRENT\_USER\\Software\\Microsoft\\Windows Photo Viewer\\Viewer

**3.** In right-side pane, create a new DWORD **CacheSize** and set its value to **0**

![[./_resources/Fix_Windows_Photo_Viewer_Takes_Too_Much_Time_in_Opening_Images_-_AskVG_www.askvg.com.resources/Disable_Windows_Photo_Viewer_Cache.png]]

**4.** Now restart your system and it should speedup Windows Photo Viewer loading time.

I'm not sure which of the above mentioned solutions worked for me but now the slow Windows Photo Viewer problem has been fixed and its opening image files quickly without any delay...

> **Share this article:** [Facebook](https://www.facebook.com/sharer.php?u=http://www.askvg.com/fix-windows-photo-viewer-takes-too-much-time-in-opening-image-files/) | [Twitter](https://twitter.com/share?text=[Fix]%20Windows%20Photo%20Viewer%20Takes%20Too%20Much%20Time%20in%20Opening%20Images-&url=http://www.askvg.com/fix-windows-photo-viewer-takes-too-much-time-in-opening-image-files/) | [Google+](https://plus.google.com/share?url=http://www.askvg.com/fix-windows-photo-viewer-takes-too-much-time-in-opening-image-files/) | [Reddit](http://www.reddit.com/submit?url=http://www.askvg.com/fix-windows-photo-viewer-takes-too-much-time-in-opening-image-files/&title=[Fix]%20Windows%20Photo%20Viewer%20Takes%20Too%20Much%20Time%20in%20Opening%20Images) | [Tell a friend](http://www.askvg.com/fix-windows-photo-viewer-takes-too-much-time-in-opening-image-files/mailto:?subject=[Fix]%20Windows%20Photo%20Viewer%20Takes%20Too%20Much%20Time%20in%20Opening%20Images&body=http://www.askvg.com/fix-windows-photo-viewer-takes-too-much-time-in-opening-image-files/)
> 
> **Posted in:** [Troubleshooting](http://www.askvg.com/category/troubleshooting/), [Windows 7](http://www.askvg.com/category/windows-seven/), [Windows 8 / 8.1](http://www.askvg.com/category/windows-8/)

## Other similar articles that may interest you

* [Fix Windows XP Shows Error Message: Installation of Microsoft Office 2010 Requires MSXML Version 6.10.1129.0](http://www.askvg.com/fix-installation-of-microsoft-office-2010-requires-msxml-version-6-10-1129-0/)

* [Clear Type Tuner: Microsoft Powertoy to Tweak and Customize Clear Type Font Settings in Windows](http://www.askvg.com/clear-type-tuner-microsoft-powertoy-for-windows/)
* [How to Enable / Show Menu Bar Permanently in Microsoft Internet Explorer?](http://www.askvg.com/how-to-enable-show-menu-bar-permanently-in-microsoft-internet-explorer-9-ie9-beta/)
* [Get Windows Vista Look-Like MSPaint in Windows XP](http://www.askvg.com/get-windows-vista-look-like-mspaint-in-windows-xp/)
* [Download Best and Top 5 Free Antivirus and Anti-Spyware Software for Windows](http://www.askvg.com/top-5-best-free-antivirus-and-anti-spyware-software-for-windows/)
* [XWindows Dock: The Real Mac Leopard Dock Emulator](http://www.askvg.com/xwindows-dock-the-real-mac-leopard-dock-emulator/)

## Comments

		**Prabhjot Sohal**
	
	Helpful
	
		**infogain6**
	
	or
	use picasa
	LOL
	
		**Hadrian Embalsado**
	
	Picasa is dirty to use with all the folders it leaves behind when you uninstall it. It really needs a revamp, stat!
	
		**Dev Mitra**
	
	Solution 4 worked for me ....
	thanks :D
	
		**maynak00**
	
	or use IrfanView, FastStone Image Viewer, JPEGView, XnViewMP, ...
	:D
	
		**ImAPc**
	
	cant find anything that says calibrated and on step 4 i cant find that item...
	
		**jassi**
	
	cool..!
	i tried first one, and it worked perfectly again.. thanx..
	

### Leave a Comment

Name (required)

Email (will not be published) (required)

Website or Blog
