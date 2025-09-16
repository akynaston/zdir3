---
tags: ["#ex2007","#powershell"]
---
# Add Proxy Addresses to Many Users' Accounts with Windows PowerShell

 **Add Proxy Addresses to Many Users' Accounts with Windows PowerShell**

|     |     |
| --- | --- |
| Rate | <http://help.outlook.com/en-us/140/cc967281.aspx#> |

Give feedback on this content

Add Proxy Addresses to Many Users' Accounts with Windows PowerShell

You can use Windows PowerShell to add additional e-mail addresses, also known as _proxy addresses_, to existing user accounts in Outlook Live. Such alternative e-mail addresses let users receive e-mail that is sent to different e-mail addresses. For example, e-mail sent to walter@contoso.edu and walter@alumni-contoso.edu is delivered to the same mailbox. You can add additional e-mail addresses to mailboxes by using the Web management interface for Outlook Live, but if you want to add additional e-mail addresses to many existing mailboxes, using Windows PowerShell can be more efficient. To learn how to add and remove additional e-mail addresses one at a time, see [Add or Remove Proxy Addresses to a User's Account](http://help.outlook.com/en-us/140/cc498704.aspx).

![[./_resources/Add_Proxy_Addresses_to_Many_Users'_Accounts_with_Windows_PowerShell.resources/clear.gif]] Something to consider

When you add additional e-mail addresses to existing user accounts, you're adding proxy addresses from a different domain to the user accounts. For example, if your Outlook Live users have their primary e-mail addresses in the @contoso.com domain, you can use this procedure to give every user account an additional proxy address in the @contoso.org domain. You're not adding a proxy address with a different alias to an existing user account. So, if a mailbox has the primary e-mail address user1@contoso.com, you can't add postmaster@contoso.com or postmaster@contoso.edu as a proxy address with this procedure. For more information, see [Proxy Addresses in Outlook Live](http://help.outlook.com/en-us/140/cc511403.aspx).

![[./_resources/Add_Proxy_Addresses_to_Many_Users'_Accounts_with_Windows_PowerShell.resources/clear.gif]] Before you begin

To learn how to install and configure Windows PowerShell and connect to Outlook Live, see [Use Windows PowerShell](http://help.outlook.com/en-us/140/cc546278.aspx).

Before you can add a proxy address to an existing user account, you must configure the address space as an accepted domain. Here's how: [Create Accepted Domains](http://help.outlook.com/en-us/140/cc511375.aspx), or [Create Accepted Domains - Friends & Family](http://help.outlook.com/en-us/140/dd793604.aspx).

![[./_resources/Add_Proxy_Addresses_to_Many_Users'_Accounts_with_Windows_PowerShell.resources/clear.gif]] To add proxy addresses to existing user accounts

Run the following commands after you have connected to the Outlook Live server-side session:

$users = Get-Mailbox
foreach ($a in $users) {$a.emailaddresses.Add("$($a.alias)@<new domain name>")}
$users | %{Set-Mailbox $\_.Identity -EmailAddresses $\_.EmailAddresses}

For example, if your existing Outlook Live domain is contoso.com, and you want to add an additional address to every user account for the accepted domain corp.contoso.com, run the following commands:

$users = Get-Mailbox
foreach ($a in $users) {$a.emailaddresses.Add("$($a.alias)@corp.contoso.com")}
$users | %{Set-Mailbox $\_.Identity -EmailAddresses $\_.EmailAddresses}
Related Topics
![[./_resources/Add_Proxy_Addresses_to_Many_Users'_Accounts_with_Windows_PowerShell.resources/progress.gif]] Loading...
No resources were found.
![[./_resources/Add_Proxy_Addresses_to_Many_Users'_Accounts_with_Windows_PowerShell.resources/trans_pixel.mozilla%3aen-US%3aofficial%26client%3dfirefox-a]]
![[./_resources/Add_Proxy_Addresses_to_Many_Users'_Accounts_with_Windows_PowerShell.resources/nojavascript&WT.js=No]]
