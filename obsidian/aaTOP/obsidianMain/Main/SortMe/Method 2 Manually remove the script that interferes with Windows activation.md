# Method 2: Manually remove the script that interferes with Windows activation

### Method 2: Manually remove the script that interferes with Windows activation

**Important** This section, method, or task contains steps that tell you how to modify the registry. However, serious problems might occur if you modify the registry incorrectly. Therefore, make sure that you follow these steps carefully. For added protection, back up the registry before you modify it. Then, you can restore the registry if a problem occurs. For more information about how to back up and restore the registry, click the following article number to view the article in the Microsoft Knowledge Base:
[322756](http://support.microsoft.com/kb/322756)   (http://support.microsoft.com/kb/322756/ )  How to back up and restore the registry in Windows

#### Before you start

To complete these steps, you must have the following:

* The Windows XP CD. Or, access to a folder that contains the files from the i386 folder on the Windows XP CD.
* An account that has administrator rights and permissions.

#### Step 1: Start the computer in safe mode

1. Start the computer.
2. After the computer runs the Power On Self Test (POST), press F8 repeatedly to open the Windows Advanced Options menu.
3. On the Windows Advanced Options menu, use the arrow keys to select **Safe Mode**, and then press ENTER.
4. Use the arrow keys to select the Windows operating system that you want to start, and then press ENTER.
5. When the computer is running in safe mode, log on by using an account that has administrator rights and permissions. Then, click **Yes** in the message that states that Windows is running in safe mode.

#### Step 2: Start Registry Editor

Click **Start**, click **Run**, type regedit, and then click **OK**.

#### Step 3: Remove the RESETS registry subkey

1. In Registry Editor, expand **My Computer**, and then expand **HKEY\_LOCAL\_MACHINE**.
2. Expand **SOFTWARE**, and then expand **Microsoft**.
3. Expand **Windows NT**, and then expand **CurrentVersion**.
4. Expand **Winlogon**, and then expand **Notify**.
5. Under **Notify**, right-click **RESETS**, and then click **Delete**.
6. Click **Yes** to confirm the removal of the RESETS subkey.
	**Note** Do not exit Registry Editor. You must use Registry Editor in "Step 4: Modify the registry to deactivate Windows."

#### Step 4: Modify the registry to deactivate Windows

1. In Registry Editor, expand **My Computer**, and then expand **HKEY\_LOCAL\_MACHINE**.
2. Expand **SOFTWARE**, and then expand **Microsoft**.
3. Expand **Windows NT**, and then expand **CurrentVersion**.
4. Under **CurrentVersion**, click **WPAEvents**.
5. In the right pane (topic area) of Registry Editor, right-click **OOBETimer**, and then click **Modify**.
6. Click to put the pointer in the **Value data** box. Then, modify any character that appears in the **Value data** box.
7. Click **OK**.
	**Note** This step deactivates Windows.
8. Exit Registry Editor.

#### Step 5: Rename the corrupted Windows activation file

1. Click **Start**, click **Run**, type cmd, and then click **OK**.
2. At the command prompt, type the following command, and then press ENTER:
	ren %windir%\\system32\\WPA.dbl wpa.old
	This command renames the WPA.dbl file to WPA.old.
	

#### Step 6: Determine the CD or DVD drive letter

1. Insert the Windows CD.
2. Click **Start**, and then click **My Computer**.
3. Note the CD drive letter or the DVD drive letter that appears under **Drives with Removable Storage**. You have to use this drive letter in the next step.

#### Step 7: Replace the corrupted Windows activation file

1. Click **Start**, click **Run**, type cmd, and then click **OK**.
2. At the command prompt, type the following command, and then press ENTER:
	expand _drive_ :\\i386\\wpa.db\_ %windir%\\system32\\wpa.dbl
	In this command, replace _drive_ with the letter of the drive that contains the Windows CD.
	For example, if the Windows CD is located in drive D, the command appears as follows:
	**expand d:\\i386\\wpa.db\_ %windir%\\system32\\wpa.dbl**
	This command extracts a copy of the Wpa.dbl file from the Windows CD. Then, it puts this file in the System32 folder of the Windows installation.
	
3. Examine the output that appears at the command prompt. If the command runs successfully, information that resembles the following appears:

Microsoft (R) File Expansion Utility Version 5.1.2600.0 Copyright (C) Microsoft Corp 1990-1999. All rights reserved. Expanding d:\\i386\\wpa.db\_ to c:\\windows\\system32\\wpa.dbl. d:\\i386\\wpa.db\_: 2222 bytes expanded to 2126 bytes, -5% increase.

1. Type exit, and then press ENTER to exit the command prompt.

#### Step 8: Remove the files that are associated with the script

1. Click **Start**, and then click **Search**.
2. Under **What do you want to search for**, click **All files and folders**.
3. In the **All or part of the file name** box, type the following, and then click **Search**:
	reset5.exe; reset5.dll; reset5.dat; reset5.dt\*; srvany.exe
	This action performs a search for all the following files:
	
	* Reset5.exe
	* Reset5.dll
	* Reset5.dat
	* Reset5.dt\*
	* Srvany.exe
	
	**Note** If you use a different search tool such as Windows Desktop Search, use this tool to search for each of these individual files.
	

1. In the results pane of the **Search Results** dialog box, right-click each file, and then click **Delete**.
2. Click **Yes** to confirm the removal of the file.
3. When you have finished removing these files, exit the **Search Results** dialog box.
4. Restart the computer and let Windows restart in normal mode.

#### Step 9: Reactivate Windows

1. Click **Start**, point to **All Programs**, point to **Accessories**, point to **System Tools**, and then click **Activate Windows**.
2. If the Windows Product Activation Wizard prompts you to activate Windows, follow the instructions in the wizard to activate Windows.
3. Restart the computer, and then repeat step 1 of "Step 9: Reactivate Windows" to start the Windows Product Activation Wizard again. You take this step to verify that the wizard does not prompt you to activate Windows again.
4. If the Windows Product Activation Wizard displays a "Windows is already activated" message, click **OK** to exit the wizard.

[![[./_resources/Method_2_Manually_remove_the_script_that_interferes_with_Windows_activation.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/312295#top)
