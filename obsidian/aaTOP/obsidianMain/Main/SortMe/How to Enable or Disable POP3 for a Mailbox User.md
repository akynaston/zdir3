---
tags: ["#powershell"]
---
# How to Enable or Disable POP3 for a Mailbox User

 **How to Enable or Disable POP3 for a Mailbox User**

  [Switch on low bandwidth view](http://technet.microsoft.com/en-us/library/bb691018(loband).aspx)
![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]]
![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]][Language Filter : All](http://technet.microsoft.com/en-us/library/bb691018.aspx#Mtps_DropDownFilterText)
Visual Basic
C#
C++
J#
JScript
XAML
F#
How to Enable or Disable POP3 for a Mailbox User

**_Applies to:_** _Exchange Server 2007 SP1, Exchange Server 2007_ **_Topic Last Modified:_** _2007-08-24_

This topic explains how to use the Exchange Management Console or the Exchange Management Shell to enable or disable Post Office Protocol version 3 (POP3) for a Microsoft Exchange Server 2007 mailbox user.

![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]] Before You Begin

To perform this procedure, the account you use must be delegated the following:

* Exchange Recipient Administrator role

For more information about permissions, delegating roles, and the rights that are required to administer Exchange 2007, see [Permission Considerations](http://technet.microsoft.com/en-us/library/aa996881.aspx).

![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]] Procedure

### Exchange 2007 SP1

![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]] To use the Exchange Management Console to enable or disable POP3 for a mailbox user

1. Start the Exchange Management Console.
	
2. In the console tree, expand **Recipient Configuration**, and then click **Mailbox**.
	
3. In the result pane, select the mailbox user for whom you want to enable or disable POP3.
	
4. In the action pane, under the name of the mailbox user, click **Properties**.
	
5. In **<Mailbox User> Properties**, on the **Mailbox Features** tab, click **POP3**, and then click either **Enable** or **Disable.**
	
6. Click **OK**.
	

![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]] To use the Exchange Management Shell to enable or disable POP3 for a mailbox user

		To enable POP3 for the user named John Smith, run the following command.
	
	Set-CASMailbox -Identity "John Smith" -POPEnabled $true
		To disable POP3 for the user named John Smith, run the following command.
	
	Set-CASMailbox -Identity "John Smith" -POPEnabled $false

For detailed syntax and parameter information, see [Set-CASMailbox](http://technet.microsoft.com/en-us/library/bb125264.aspx).

### Exchange 2007 RTM

|     |
| --- |
| **![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/Bb691018.gif]]Note:** |
| In the release to manufacturing (RTM) version of Exchange 2007, you can enable or disable POP3 for a mailbox only by using the **Set-CASMailbox** cmdlet in the Exchange Management Shell. |

![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]] To use the Exchange Management Shell to enable or disable POP3 for a mailbox user

		To enable POP3 for the user named John Smith, run the following command.
	
	Set-CASMailbox -Identity "John Smith" -POPEnabled $true
		To disable POP3 for the user named John Smith, run the following command.
	
	Set-CASMailbox -Identity "John Smith" -POPEnabled $false

For detailed syntax and parameter information, see [Set-CASMailbox (RTM)](http://technet.microsoft.com/en-us/library/bb676507.aspx).

![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]] For More Information

For more information about managing user mailboxes, see [Managing User Mailboxes](http://technet.microsoft.com/en-us/library/bb123720.aspx).

For more information about the Exchange Management Shell, see [Using the Exchange Management Shell](http://technet.microsoft.com/en-us/library/bb123778.aspx).

Tags [![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]]
Community Content   [![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCSection/resources/cchelp.htm)

|     |     |     |
| --- | --- | --- |
|     | [![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]]](http://technet.microsoft.com/en-us/library/community-edits.rss?topic=bb691018\|en-us\|80)  Annotations |     |

|     |     |     |
| --- | --- | --- |
|     |     | \|  |

Tags [![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]]

|     |     |
| --- | --- |
| © 2009 Microsoft Corporation. All rights reserved. [Terms of Use](http://www.microsoft.com/info/cpyright.mspx)  \|  [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx)  \|  [Privacy Statement](http://www.microsoft.com/info/privacy.mspx) | [![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/clear.gif]]](http://www.microsoft.com/) |

![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/trans_pixel.aspx]]
![[./_resources/How_to_Enable_or_Disable_POP3_for_a_Mailbox_User.resources/nojavascript&WT.js=No]]
