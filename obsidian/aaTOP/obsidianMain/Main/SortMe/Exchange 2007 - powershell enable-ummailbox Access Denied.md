---
tags: ["#ex2007"]
---
# Exchange 2007 - powershell: enable-ummailbox: Access Denied

Exchange 2007 - powershell: enable-ummailbox: Access Denied

Enable-UMMailbox requires that the remote loader be executed as an exchange administrator.  For some reason, 'local system account' works for enable-mailbox,  . . either way, be sure the remote loader is running as an exchange administrator - "Administrator" of the domain should be sufficient.  INs hort, this is a rights issue.  You can confirm by running the same enable-UMMailbox script in powershell, and seeing if works at all (assuming you are logged in as Adminsitrator).
