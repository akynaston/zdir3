---
tags: ["#vmware"]
---
# VMWARE Cleanup:

VMWARE Cleanup:

 - Log out of tortoiseSVN (right click, and select Settings -> Saved Data - click on clear data next to authentication data)
 - Delete all unnecessary files.
 - Shut down vm
 - delete all snapshots.
 - Zip the VMware
 - Run a zip test
 - Generate md5sum.

Clear event logs
wmic nteventlog where "Logfilename = 'Application'" Call ClearEventLog
wmic nteventlog where "Logfilename = 'Security'" Call ClearEventLog
wmic nteventlog where "Logfilename = 'System'" Call ClearEventLog
wmic nteventlog where "Logfilename = 'Directory Service'" Call ClearEventLog
wmic nteventlog where "Logfilename = 'DNS Server'" Call ClearEventLog
wmic nteventlog where "Logfilename = 'File Replication Service'" Call ClearEventLog
wmic nteventlog where "Logfilename = 'Password Sync'" Call ClearEventLog
wmic nteventlog where "Logfilename = 'PowerShell'" Call ClearEventLog
wmic nteventlog where "Logfilename = 'Windows PowerShell'" Call ClearEventLog

Clear C:\\windows\\system32\\pchealth\\userdumps

Clear designer files
@echo off
rd /s/q C:\\workspace\\.metadata\\.plugins\\org.eclipse.ui.workbench.texteditor
rd /s/q C:\\workspace\\.metadata\\.plugins\\org.eclipse.jdt.core
rd /s/q C:\\workspace\\.metadata\\.plugins\\org.eclipse.jdt.junit
rd /s/q C:\\workspace\\.metadata\\.plugins\\org.eclipse.jdt.launching
rd /s/q C:\\workspace\\.metadata\\.plugins\\org.eclipse.jdt.ui
rd /s/q C:\\workspace\\.metadata\\.plugins\\org.eclipse.ui.workbench

Clear traces
erase C:\\novell\\remoteloader\\ADDriver-initmig-Trace\*
erase C:\\novell\\remoteloader\\ADDrivernew-Trace\*
erase C:\\novell\\remoteloader\\EX2007-PS-Trace\*
erase C:\\novell\\remoteloader\\EX2007-Trace\*
erase C:\\logs\\gsd2idv\*
erase C:\\ExchangeDriverLog.txt
