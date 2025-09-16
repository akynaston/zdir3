---
tags: ["#powershell"]
---
# Untitled Note

\*\*SAMPLE EX2007 POWERSHELL CALLS\*\*

\=============================================================================
EMAIL ADDRESS POLICIES

List all email policies and their versions.
Get-EmailAddressPolicy | Format-List Name,\*RecipientFilter\*,ExchangeVersion > EmailAddressPolicies.txt
Upgrade the email address policy (
Set-EmailAddressPolicy "Default Policy" -IncludedRecipients AllRecipients
Set-EmailAddressPolicy -id "Default Policy"  -EnabledEmailAddressTemplates "SMTP:%m@testdev.com" -RecipientFilter "(mailnickname=\*)"

Dump everything about every email policy and store it in a file:
get-EmailAddressPolicy | Format-List > C:\\EAPs.txt

Re-apply all email address policies (resets email/proxyaddresses for all users - extra granularity is recommended - also, this may take a while . .)
get-emailaddresspolicy | update-emailaddresspolicy

It appears this call shows whether or not the email auto update is set:
(get-mailbox -id testproxyuser).emailaddresspolicyenabled
\[command line this displays\]:
True

Turn off auto updating for a mailbox:
Get-Mailbox _< mailbox ID>_ | Set-Mailbox –EmailAddressPolicyEnabled:$false
Get-Mailbox –Server SRV1 | Set-Mailbox –EmailAddressPolicyEnabled:$false

Note: it appears you can use this emailaddresspolicyenabled flag to trigger an email polciy to run.

\=============================================================================

WORK WITH DISCONNECTED MALIBOXES

\[PS\] C:\\Documents and Settings\\Administrator>
Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like "\*\\dddd"} | select Database
Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null}
connect-mailbox -Identity dddd -database:(Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like "\*\\dddd"} | select Database) -Confirm:$FALSE -Alias dddd -User dddd
Where clause help:
<http://www.microsoft.com/technet/scriptcenter/topics/msh/cmdlets/where-object.mspx>
Enable-Mailbox -Identity 'CN=TestUser4\_2,OU=users,OU=GSD,DC=testdev,DC=com' -Database 'CN=Mailbox Database,CN=First Storage Group,CN=InformationStore,CN=DOMAIN2007,CN=Servers,CN=Exchange Administrative Group (FYDIBOHF23SPDLT),CN=Administrative Groups,CN=First Organization,CN=Microsoft Exchange,CN=Services,CN=Configuration,DC=testdev,DC=com'
connect-mailbox -Identity dddd -database "Mailbox Database" -Confirm:$FALSE -Alias dddd -User dddd
BAE: connect-mailbox example (through gui)
Exchange Management Shell command completed:
Useful lines

connect-mailbox example: Connect-Mailbox -Identity '407b72d1-2e17-428f-a90e-837328e1b170' -Database 'DOMAIN2007.testdev.com\\First Storage Group\\Mailbox Database' -User 'testdev\\akynaston' -Alias 'akynaston'

show distonnected mailbox: Get-MailboxStatistics | where { $\_.DisconnectDate -ne $null } | select DisplayName,DisconnectDate

repply email policies: update-EmailAddressPolicy -Identity 'Default Policy'
new-mailbox (create user in AD): New-Mailbox -Name 'aaaa' -Alias 'aaaa' -OrganizationalUnit 'testdev.com/Users' -UserPrincipalName 'aaaa@testdev.com' -SamAccountName 'aaaa' -FirstName 'aaaa' -Initials '' -LastName '' -Password 'System.Security.SecureString' -ResetPasswordOnNextLogon $false -Database 'CN=Mailbox Database,CN=First Storage Group,CN=InformationStore,CN=DOMAIN2007,CN=Servers,CN=Exchange Administrative Group (FYDIBOHF23SPDLT),CN=Administrative Groups,CN=First Organization,CN=Microsoft Exchange,CN=Services,CN=Configuration,DC=testdev,DC=com'
((((Get-Mailbox -ResultSize:Unlimited | Group-Object -Property:Database | Select-Object Name,Count | Sort-Object -Property:Count)\[0\].Name).Split(\\".\\"))\[0\])
\- Change shim to use from ad driver to exchange driver shim - .25
 - Copy all policies over to Powershell driver and test - 4 hours
 - implement translation of matching query to powershell script - 1
    \[PS\] C:\\Documents and Settings\\Administrator>Get-Mailbox -filter { sAMAccountName -eq 'akynaston'  }
 - implement translation of query results to instance document - 3
 -
 
\- close bugs
 - lob bugs to ac times
 - delete temporary files 5 hours!!???      
Display possible homeMDB values:
 (get-mailboxdatabase).DistinguishedName

length of alis on mailbox
(get-mailbox "mbensin\*").alias.length

function doGALVisibilityWork( $exchangeObjectToProcess, \[boolean\] $hideFromGAL ) {
     $retMsg += "\`nHiding\\Unhiding Exchange object from GAL: flag: \[" + $hideFromGAL + "\] . ."
     $recipientTypeDetails = $exchangeObjectToProcess.RecipientTypeDetails;
    
     $command = $exchangeObjectUpdateCommands\[$recipientTypeDetails\];
    
     if ($command -eq $null -or $command.Length -eq 0) {
          $msg = "Could not determine command for recipient type: \[" + $recipientTypeDetails + "\]";
          throw $msg;
     }    
     $invokeString = "$command -Identity \`$exchangeObjectToProcess.Identity -HiddenFromAddressListsEnabled \`$hideFromGAL";
     $retMsg += "\`nAbout to invoke: \[" + $invokeString + "\]";
     try {
          throwIfError $invokeString;
     } catch {
          $retMsg +="\`nERROR: failed while attempting to execute: \[" + $invokeString + "\], error was: \[" + $\_ + "\]";
          throw $retMsg;
     }
     $retMsg += " . .done processing hide/unhide from GAL: \[" + $hideFromGAL + "\]";
     $retMsg;
}
function hideFromGal( $exchangeObject, \[boolean\] $hideFromGAL) {
     doGALVisibilityWork $exchangeObject $true;
}
function unHideFromGal( $exchangeObject, \[boolean\] $hideFromGAL) {
     doGALVisibilityWork $exchangeObject $false;
}

Show all mailboxes for disabled accounts:

Get-Mailbox |?{$\_.UserAccountControl -Match "AccountDisabled"}| Fl Name,Database,UserAccountControl

Show all mailboxes for disabled accounts that are not hidden yet
Get-Mailbox -resultsize unlimited -Filter {HiddenFromAddressListsEnabled -ne $True} |?{$\_.UserAccountControl -Match "AccountDisabled"} | Fl Name,Database,UserAccountControl

HIide mailboxes for disabled accounts:
Get-Mailbox -resultsize unlimited -Filter {HiddenFromAddressListsEnabled -ne $True} |?{$\_.UserAccountControl -Match "AccountDisabled"} | set-mailbox -HiddenFromAddressListsEnabled $true
