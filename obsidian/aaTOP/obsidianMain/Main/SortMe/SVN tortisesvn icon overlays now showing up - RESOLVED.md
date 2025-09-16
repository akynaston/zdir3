# [SVN] tortisesvn icon overlays now showing up - RESOLVED

1. My Tortise SVN icons were not showing up. Dropbox icons ARE.
2. I Navigated to this registry folder:
3. HKEY\_LOCAL\_MACHINE/SOFTWARE/MICROSOFT/WINDOWS/EXPLORER/ShellIconOverlayIdentifiers
4. I put an X in front of each of the DropBox names and rebooted.
5. That fixed it. I can see both Tortisesvn and Dropbox icon overlays
6. Looks like tortise entries need to be first in this list for them to work. Very stupid.

![[./_resources/SVN_tortisesvn_icon_overlays_now_showing_up_-_RESOLVED.resources/ScreenClip.png]]

SRC:

<http://stackoverflow.com/questions/3735011/tortoise-svn-folder-icons-not-coming>

1. Run regedit

* Navigate to:
	HKEY\_LOCAL\_MACHINE/SOFTWARE/MICROSOFT/WINDOWS/EXPLORER/ShellIconOverlayIdentifiers
	
* If there are more than 11 Folders, then you have too many IconSets 
	:: In my case, it was because of DropBox - the folder names were ("DropboxExt1","DropboxExt2") and my Tortoise was named (1TortoiseNormal,2TortoiseModified)
	\--The problem is that Windows reads this and enables them based on alpha numeric order ('"' comes before '1' in the alphanumeric stack) 
	**SOLUTION** : If you had the same problem as me, you can simply rename the Dropbox registry listings. I renamed my Dropbox listings from('"DropboxExt1"') to ('X"DropboxExt1"'), just adding an 'X' to the beginning of the registry.
	\>>Restart your machine to see the registry listing take effect.
