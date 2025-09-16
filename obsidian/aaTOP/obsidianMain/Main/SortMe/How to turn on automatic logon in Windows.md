# How to turn on automatic logon in Windows

Current winlogin key in FCPS vm from glen - (I added default password, don't know if it works yet)
Windows Registry Editor Version 5.00
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\]
"AutoRestartShell"=dword:00000001
"DefaultDomainName"="TRIVIRDEV"
"DefaultUserName"="Administrator"
"LegalNoticeCaption"=""
"LegalNoticeText"=""
"PowerdownAfterShutdown"="0"
"ReportBootOk"="1"
"Shell"="Explorer.exe"
"ShutdownWithoutLogon"="0"
"System"=""
"Userinit"="C:\\\\WINDOWS\\\\system32\\\\userinit.exe,"
"VmApplet"="rundll32 shell32,Control\_RunDLL \\"sysdm.cpl\\""
"SfcQuota"=dword:ffffffff
"allocatecdroms"="0"
"allocatedasd"="0"
"allocatefloppies"="0"
"cachedlogonscount"="10"
"forceunlocklogon"=dword:00000000
"passwordexpirywarning"=dword:0000000e
"scremoveoption"="0"
"AllowMultipleTSSessions"=dword:00000001
"AppSetup"=""
"UIHost"=hex(2):25,00,53,00,79,00,73,00,74,00,65,00,6d,00,52,00,6f,00,6f,00,74,\\
  00,25,00,5c,00,73,00,79,00,73,00,74,00,65,00,6d,00,33,00,32,00,5c,00,6c,00,\\
  6f,00,67,00,6f,00,6e,00,75,00,69,00,2e,00,65,00,78,00,65,00,00,00
"DebugServerCommand"="no"
"SFCDisable"=dword:00000000
"WinStationsDisabled"="0"
"ShowLogonOptions"=dword:00000001
"AltDefaultUserName"="Administrator"
"AltDefaultDomainName"="TRIVIRDEV"
"AutoAdminLogon"="1"
"DisableLockWorkstation"=dword:00000000
"CachePrimaryDomain"="TRIVIRDEV"
"DCacheUpdate"=hex:b8,b1,b3,2e,3d,fb,c9,01
"DefaultPassword"="trivir"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\CustomBrand\]
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\CustomBrand\\{F20B21BE-5E3D-11d2-8789-68CB20524153}\]
@="r2brand.dll, -1001"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\CustomBrand\\{F20B21BF-5E3D-11d2-8789-68CB20524153}\]
@="r2brand.dll, -1002"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\CustomBrand\\{F20B21C0-5E3D-11d2-8789-68CB20524153}\]
@="r2brand.dll, -1001"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\CustomBrand\\{F20B21C1-5E3D-11d2-8789-68CB20524153}\]
@="r2brand.dll, -1002"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\DomainCache\]
"TRIVIRDEV"="trivirdev.com"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\]
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{0ACDD40C-75AC-47ab-BAA0-BF6DE7E7FE63}\]
@="Wireless Group Policy"
"ProcessGroupPolicyEx"="ProcessWIRELESSPolicyEx"
"GenerateGroupPolicy"="GenerateWIRELESSPolicy"
"DllName"=hex(2):67,00,70,00,74,00,65,00,78,00,74,00,2e,00,64,00,6c,00,6c,00,\\
  00,00
"NoUserPolicy"=dword:00000001
"NoGPOListChanges"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{25537BA6-77A8-11D2-9B6C-0000F8080861}\]
@="Folder Redirection"
"ProcessGroupPolicyEx"="ProcessGroupPolicyEx"
"DllName"=hex(2):66,00,64,00,65,00,70,00,6c,00,6f,00,79,00,2e,00,64,00,6c,00,\\
  6c,00,00,00
"NoMachinePolicy"=dword:00000001
"NoSlowLink"=dword:00000001
"PerUserLocalSettings"=dword:00000001
"NoGPOListChanges"=dword:00000000
"NoBackgroundPolicy"=dword:00000000
"GenerateGroupPolicy"="GenerateGroupPolicy"
"EventSources"=hex(7):28,00,46,00,6f,00,6c,00,64,00,65,00,72,00,20,00,52,00,65,\\
  00,64,00,69,00,72,00,65,00,63,00,74,00,69,00,6f,00,6e,00,2c,00,41,00,70,00,\\
  70,00,6c,00,69,00,63,00,61,00,74,00,69,00,6f,00,6e,00,29,00,00,00,00,00
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{35378EAC-683F-11D2-A89A-00C04FBBCFA2}\]
"Status"=dword:00000000
"RsopStatus"=dword:00000000
"LastPolicyTime"=dword:00ecc564
"PrevSlowLink"=dword:00000000
"PrevRsopLogging"=dword:00000001
"ForceRefreshFG"=dword:00000000
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{3610eda5-77ef-11d2-8dc5-00c04fa31a66}\]
@="Microsoft Disk Quota"
"NoMachinePolicy"=dword:00000000
"NoUserPolicy"=dword:00000001
"NoSlowLink"=dword:00000001
"NoBackgroundPolicy"=dword:00000001
"NoGPOListChanges"=dword:00000001
"PerUserLocalSettings"=dword:00000000
"RequiresSuccessfulRegistry"=dword:00000001
"EnableAsynchronousProcessing"=dword:00000000
"DllName"=hex(2):64,00,73,00,6b,00,71,00,75,00,6f,00,74,00,61,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
"ProcessGroupPolicy"="ProcessGroupPolicy"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{426031c0-0b47-4852-b0ca-ac3d37bfcb39}\]
@="QoS Packet Scheduler"
"ProcessGroupPolicy"="ProcessPSCHEDPolicy"
"DllName"=hex(2):67,00,70,00,74,00,65,00,78,00,74,00,2e,00,64,00,6c,00,6c,00,\\
  00,00
"NoUserPolicy"=dword:00000001
"NoGPOListChanges"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{42B5FAAE-6536-11d2-AE5A-0000F87571E3}\]
@="Scripts"
"ProcessGroupPolicy"="ProcessScriptsGroupPolicy"
"ProcessGroupPolicyEx"="ProcessScriptsGroupPolicyEx"
"GenerateGroupPolicy"="GenerateScriptsGroupPolicy"
"DllName"=hex(2):67,00,70,00,74,00,65,00,78,00,74,00,2e,00,64,00,6c,00,6c,00,\\
  00,00
"NoSlowLink"=dword:00000001
"NoGPOListChanges"=dword:00000001
"NotifyLinkTransition"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{4CFB60C1-FAA6-47f1-89AA-0B18730C9FD3}\]
@="Internet Explorer Zonemapping"
"DllName"=hex(2):69,00,65,00,64,00,6b,00,63,00,73,00,33,00,32,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
"ProcessGroupPolicy"="ProcessGroupPolicyForZoneMap"
"NoGPOListChanges"=dword:00000001
"RequiresSucessfulRegistry"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{827D319E-6EAC-11D2-A4EA-00C04F79F83A}\]
"ProcessGroupPolicy"="SceProcessSecurityPolicyGPO"
"GenerateGroupPolicy"="SceGenerateGroupPolicy"
"ExtensionRsopPlanningDebugLevel"=dword:00000001
"ProcessGroupPolicyEx"="SceProcessSecurityPolicyGPOEx"
"ExtensionDebugLevel"=dword:00000001
"DllName"=hex(2):73,00,63,00,65,00,63,00,6c,00,69,00,2e,00,64,00,6c,00,6c,00,\\
  00,00
@="Security"
"NoUserPolicy"=dword:00000001
"NoGPOListChanges"=dword:00000001
"EnableAsynchronousProcessing"=dword:00000001
"MaxNoGPOListChangesInterval"=dword:000003c0
"PreviousPolicyAreas"=dword:00000009
"Status"=dword:00000000
"RsopStatus"=dword:00000000
"LastPolicyTime"=dword:00ecc564
"PrevSlowLink"=dword:00000000
"PrevRsopLogging"=dword:00000001
"ForceRefreshFG"=dword:00000000
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{A2E30F80-D7DE-11d2-BBDE-00C04F86AE3B}\]
"ProcessGroupPolicyEx"="ProcessGroupPolicyEx"
"GenerateGroupPolicy"="GenerateGroupPolicy"
"ProcessGroupPolicy"="ProcessGroupPolicy"
"DllName"=hex(2):69,00,65,00,64,00,6b,00,63,00,73,00,33,00,32,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
@="Internet Explorer Branding"
"NoSlowLink"=dword:00000001
"NoBackgroundPolicy"=dword:00000000
"NoGPOListChanges"=dword:00000001
"NoMachinePolicy"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{B1BE8D72-6EAC-11D2-A4EA-00C04F79F83A}\]
"ProcessGroupPolicy"="SceProcessEFSRecoveryGPO"
"DllName"=hex(2):73,00,63,00,65,00,63,00,6c,00,69,00,2e,00,64,00,6c,00,6c,00,\\
  00,00
@="EFS recovery"
"NoUserPolicy"=dword:00000001
"NoGPOListChanges"=dword:00000001
"RequiresSuccessfulRegistry"=dword:00000001
"Status"=dword:00000000
"RsopStatus"=dword:80070032
"LastPolicyTime"=dword:00ecc564
"PrevSlowLink"=dword:00000000
"PrevRsopLogging"=dword:00000001
"ForceRefreshFG"=dword:00000000
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{C631DF4C-088F-4156-B058-4375F0853CD8}\]
@="Microsoft Offline Files"
"DllName"=hex(2):25,00,53,00,79,00,73,00,74,00,65,00,6d,00,52,00,6f,00,6f,00,\\
  74,00,25,00,5c,00,53,00,79,00,73,00,74,00,65,00,6d,00,33,00,32,00,5c,00,63,\\
  00,73,00,63,00,75,00,69,00,2e,00,64,00,6c,00,6c,00,00,00
"EnableAsynchronousProcessing"=dword:00000000
"NoBackgroundPolicy"=dword:00000000
"NoGPOListChanges"=dword:00000000
"NoMachinePolicy"=dword:00000000
"NoSlowLink"=dword:00000000
"NoUserPolicy"=dword:00000001
"PerUserLocalSettings"=dword:00000000
"ProcessGroupPolicy"="ProcessGroupPolicy"
"RequiresSuccessfulRegistry"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{c6dc5466-785a-11d2-84d0-00c04fb169f7}\]
@="Software Installation"
"DllName"=hex(2):61,00,70,00,70,00,6d,00,67,00,6d,00,74,00,73,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
"ProcessGroupPolicyEx"="ProcessGroupPolicyObjectsEx"
"GenerateGroupPolicy"="GenerateGroupPolicy"
"NoBackgroundPolicy"=dword:00000000
"RequiresSucessfulRegistry"=dword:00000000
"NoSlowLink"=dword:00000001
"PerUserLocalSettings"=dword:00000001
"EventSources"=hex(7):28,00,41,00,70,00,70,00,6c,00,69,00,63,00,61,00,74,00,69,\\
  00,6f,00,6e,00,20,00,4d,00,61,00,6e,00,61,00,67,00,65,00,6d,00,65,00,6e,00,\\
  74,00,2c,00,41,00,70,00,70,00,6c,00,69,00,63,00,61,00,74,00,69,00,6f,00,6e,\\
  00,29,00,00,00,28,00,4d,00,73,00,69,00,49,00,6e,00,73,00,74,00,61,00,6c,00,\\
  6c,00,65,00,72,00,2c,00,41,00,70,00,70,00,6c,00,69,00,63,00,61,00,74,00,69,\\
  00,6f,00,6e,00,29,00,00,00,00,00
"NoUserPolicy"=dword:00000000
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\GPExtensions\\{e437bc1c-aa7d-11d2-a382-00c04f991e27}\]
@="IP Security"
"ProcessGroupPolicyEx"="ProcessIPSECPolicyEx"
"GenerateGroupPolicy"="GenerateIPSECPolicy"
"DllName"=hex(2):67,00,70,00,74,00,65,00,78,00,74,00,2e,00,64,00,6c,00,6c,00,\\
  00,00
"NoUserPolicy"=dword:00000001
"NoGPOListChanges"=dword:00000000
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\]
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\crypt32chain\]
"Asynchronous"=dword:00000000
"Impersonate"=dword:00000000
"DllName"=hex(2):63,00,72,00,79,00,70,00,74,00,33,00,32,00,2e,00,64,00,6c,00,\\
  6c,00,00,00
"Logoff"="ChainWlxLogoffEvent"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\cryptnet\]
"Asynchronous"=dword:00000000
"Impersonate"=dword:00000000
"DllName"=hex(2):63,00,72,00,79,00,70,00,74,00,6e,00,65,00,74,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
"Logoff"="CryptnetWlxLogoffEvent"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\cscdll\]
"DLLName"="cscdll.dll"
"Logon"="WinlogonLogonEvent"
"Logoff"="WinlogonLogoffEvent"
"ScreenSaver"="WinlogonScreenSaverEvent"
"Startup"="WinlogonStartupEvent"
"Shutdown"="WinlogonShutdownEvent"
"StartShell"="WinlogonStartShellEvent"
"Impersonate"=dword:00000000
"Asynchronous"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\dimsntfy\]
"Asynchronous"=dword:00000001
"DllName"=hex(2):64,00,69,00,6d,00,73,00,6e,00,74,00,66,00,79,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
"Startup"="WlDimsStartup"
"Shutdown"="WlDimsShutdown"
"Logon"="WlDimsLogon"
"Logoff"="WlDimsLogoff"
"StartShell"="WlDimsStartShell"
"Lock"="WlDimsLock"
"Unlock"="WlDimsUnlock"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\ScCertProp\]
"DLLName"="wlnotify.dll"
"Logon"="SCardStartCertProp"
"Logoff"="SCardStopCertProp"
"Lock"="SCardSuspendCertProp"
"Unlock"="SCardResumeCertProp"
"Enabled"=dword:00000001
"Impersonate"=dword:00000000
"Asynchronous"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\Schedule\]
"Asynchronous"=dword:00000000
"DllName"=hex(2):77,00,6c,00,6e,00,6f,00,74,00,69,00,66,00,79,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
"Impersonate"=dword:00000000
"StartShell"="SchedStartShell"
"Logoff"="SchedEventLogOff"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\sclgntfy\]
"Logoff"="WLEventLogoff"
"Impersonate"=dword:00000000
"Asynchronous"=dword:00000001
"DllName"=hex(2):73,00,63,00,6c,00,67,00,6e,00,74,00,66,00,79,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\SensLogn\]
"DLLName"="WlNotify.dll"
"Lock"="SensLockEvent"
"Logon"="SensLogonEvent"
"Logoff"="SensLogoffEvent"
"Safe"=dword:00000001
"MaxWait"=dword:00000258
"StartScreenSaver"="SensStartScreenSaverEvent"
"StopScreenSaver"="SensStopScreenSaverEvent"
"Startup"="SensStartupEvent"
"Shutdown"="SensShutdownEvent"
"StartShell"="SensStartShellEvent"
"PostShell"="SensPostShellEvent"
"Disconnect"="SensDisconnectEvent"
"Reconnect"="SensReconnectEvent"
"Unlock"="SensUnlockEvent"
"Impersonate"=dword:00000001
"Asynchronous"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\termsrv\]
"Asynchronous"=dword:00000000
"DllName"=hex(2):77,00,6c,00,6e,00,6f,00,74,00,69,00,66,00,79,00,2e,00,64,00,\\
  6c,00,6c,00,00,00
"Impersonate"=dword:00000000
"Logoff"="TSEventLogoff"
"Logon"="TSEventLogon"
"PostShell"="TSEventPostShell"
"Shutdown"="TSEventShutdown"
"StartShell"="TSEventStartShell"
"Startup"="TSEventStartup"
"MaxWait"=dword:00000258
"Reconnect"="TSEventReconnect"
"Disconnect"="TSEventDisconnect"
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\Notify\\wlballoon\]
"DLLName"="wlnotify.dll"
"Logon"="RegisterTicketExpiredNotificationEvent"
"Logoff"="UnregisterTicketExpiredNotificationEvent"
"Impersonate"=dword:00000001
"Asynchronous"=dword:00000001
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\SpecialAccounts\]
\[HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\SpecialAccounts\\UserList\]
"TsInternetUser"=dword:00000000
"SQLAgentCmdExec"=dword:00000000
"NetShowServices"=dword:00000000
"HelpAssistant"=dword:00000000
"IWAM\_"=dword:00010000
"IUSR\_"=dword:00010000
"VUSR\_"=dword:00010000

# How to turn on automatic logon in Windows

[View products that this article applies to.](http://support.microsoft.com/kb/324737#appliesto)
This article was previously published under Q324737
For a Microsoft Windows 2000 version of this article, see [310584](http://support.microsoft.com/kb/310584)  (http://support.microsoft.com/kb/310584/ ) .

## 

* [![[./_resources/How_to_turn_on_automatic_logon_in_Windows.resources/downarrow.gif]]SUMMARY](http://support.microsoft.com/kb/324737#)
	* [![[./_resources/How_to_turn_on_automatic_logon_in_Windows.resources/downarrow.gif]]Use Registry Editor to turn on automatic logon](http://support.microsoft.com/kb/324737#)

 | 

## 

## This article describes how to configure Windows to automate the logon process b...

This article describes how to configure Windows to automate the logon process by storing your password and other pertinent information in the registry database. With this feature, other users can start your computer and use the account that you establish to automatically log on.
**IMPORTANT**: The autologon feature is convenient; however, this feature may be a security risk. If you set a computer for autologon, anyone who can physically obtain access to the computer can gain access to all of the computer's contents, including any network or networks it is connected to. Additionally, when autologon is turned on, the password is stored in the registry in plain text. The specific registry key that stores this value can be remotely read by the Authenticated Users group. This setting is only recommended for cases it which the computer is physically secured and steps have been taken to make sure that untrusted users cannot remotely access the registry.
[![[./_resources/How_to_turn_on_automatic_logon_in_Windows.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/324737#top)

### Use Registry Editor to turn on automatic logon

**Important** This section, method, or task contains steps that tell you how to modify the registry. However, serious problems might occur if you modify the registry incorrectly. Therefore, make sure that you follow these steps carefully. For added protection, back up the registry before you modify it. Then, you can restore the registry if a problem occurs. For more information about how to back up and restore the registry, click the following article number to view the article in the Microsoft Knowledge Base:
[322756](http://support.microsoft.com/kb/322756)  (http://support.microsoft.com/kb/322756/ ) How to back up and restore the registry in Windows

To use Registry Editor (Regedt32.exe) to turn on automatic logon, follow these steps:

1. Click **Start**, and then click **Run**.
2. In the **Open** box, type Regedt32.exe, and then press ENTER.
3. Locate the following subkey in the registry:
	**HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon**
	
4. Double-click the **DefaultUserName** entry, type your user name, and then click **OK**.
5. Double-click the **DefaultPassword** entry, type your password, and then click **OK**.**NOTE**: If the **DefaultPassword** value does not exist, it must be added. To add the value, follow these steps:
	
	1. On the **Edit** menu, click **New**, and then point to **String Value**.
	2. Type DefaultPassword, and then press ENTER.
	3. Double-click **DefaultPassword**.
	4. In the **Edit String** dialog, type your password and then click **OK**.
	
	**NOTE**: If no DefaultPassword string is specified, Windows automatically changes the value of the **AutoAdminLogon** key from 1 (true) to 0 (false), disabling the AutoAdminLogon feature.
	

1. On the **Edit** menu, click **New**, and then point to **String Value**.
2. Type AutoAdminLogon, and then press ENTER.
3. Double-click AutoAdminLogon.
4. In the **Edit String** dialog box, type 1 and then click **OK**.
5. Quit Registry Editor.
6. Click **Start**, click **Shutdown**, and then type a reason in the **Comment** text box.
7. Click **OK** to turn off your computer.
8. Restart your computer. You can now log on automatically.

**Notes** To bypass the AutoAdminLogon process and to log on as a different user, hold down the SHIFT key after you log off or after Windows restarts.
Registry change will not work if the “Logon Banner” is defined on the server either by a Group Policy object (GPO) or by a local policy. When policy is changed to not impact server, the feature works as expected.
An interactive console logon that has a different user on the server changes the DefaultUserName registry entry as the last logged on user indicator. AutoAdminLogon relies on the DefaultUserName entry to match the user and the password. Therefore, AutoAdminLogon may fail. You may configure a shutdown script to set the correct DefaultUserName entry for AutoAdminLogonAs. For more information, click the following article number to view the article in the Microsoft Knowledge Base:
[119364](http://support.microsoft.com/kb/119364)  (http://support.microsoft.com/kb/119364/ ) AutoAdminLogon loses DefaultUserName
[![[./_resources/How_to_turn_on_automatic_logon_in_Windows.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/324737#top)

* * *

##### APPLIES TO

* Microsoft Windows Server 2003, Datacenter Edition (32-bit x86)
* Microsoft Windows Server 2003, Enterprise Edition (32-bit x86)
* Microsoft Windows Server 2003, Standard Edition (32-bit x86)
* Microsoft Windows Server 2003, Web Edition
* Microsoft Windows Server 2003, 64-Bit Datacenter Edition
* Microsoft Windows Server 2003, Enterprise x64 Edition
* Microsoft Windows Small Business Server 2003 Premium Edition
* Microsoft Windows Small Business Server 2003 Standard Edition

![[./_resources/How_to_turn_on_automatic_logon_in_Windows.resources/uparrow.gif]][Back to the top](http://support.microsoft.com/kb/324737#top)

|     |     |
| --- | --- |
| ##### Keywords: | kbmgmtservices kbhowtomaster KB324737 |

[![[./_resources/How_to_turn_on_automatic_logon_in_Windows.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/324737#top)

|     |     |
| --- | --- |
|     |     |

![[./_resources/How_to_turn_on_automatic_logon_in_Windows.resources/gss_sticky_panel_top.png]]
![[./_resources/How_to_turn_on_automatic_logon_in_Windows.resources/gss_sticky_panel_footer.png]]
