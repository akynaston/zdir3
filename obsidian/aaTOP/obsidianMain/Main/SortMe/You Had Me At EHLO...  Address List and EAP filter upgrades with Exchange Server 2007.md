---
tags: ["#powershell"]
---
# You Had Me At EHLO... : Address List and EAP filter upgrades with Exchange Server 2007

Welcome to Exchange Team Blog [Sign in](http://msexchangeteam.com/login.aspx?ReturnUrl=/archive/2007/01/11/432158.aspx) | [Join](http://msexchangeteam.com/user/CreateUser.aspx?ReturnUrl=/archive/2007/01/11/432158.aspx) | [Help](http://msexchangeteam.com/languages/en-US/docs/faq.aspx)

|     |     |     |
| --- | --- | --- |
|     | [Blogs](http://msexchangeteam.com/default.aspx) |     |

[Videos](http://msexchangeteam.com/videos/default.aspx)[Photos](http://msexchangeteam.com/photos/default.aspx)[Files](http://msexchangeteam.com/files/default.aspx) 

#### Syndication

* [RSS 2.0](http://msexchangeteam.com/rss.aspx)
* [Atom 1.0](http://msexchangeteam.com/atom.aspx)

#### This Blog

* [Home](http://msexchangeteam.com/default.aspx)
* [About](http://msexchangeteam.com/about.aspx)
* [Links](http://msexchangeteam.com/linklist.aspx)

#### Post Categories

* [Administration (208)](http://msexchangeteam.com/archive/category/3648.aspx)
* [All Posts (671)](http://msexchangeteam.com/archive/category/8162.aspx)
* [Announcements (4)](http://msexchangeteam.com/archive/category/11163.aspx)
* [Calendaring (30)](http://msexchangeteam.com/archive/category/5471.aspx)
* [Clustering (43)](http://msexchangeteam.com/archive/category/3896.aspx)
* [Community (176)](http://msexchangeteam.com/archive/category/5472.aspx)
* [Development (36)](http://msexchangeteam.com/archive/category/3305.aspx)
* [Directory (69)](http://msexchangeteam.com/archive/category/3304.aspx)
* [Documentation (84)](http://msexchangeteam.com/archive/category/4981.aspx)
* [Documentation updates (28)](http://msexchangeteam.com/archive/category/11153.aspx)
* [Exchange 2007 (379)](http://msexchangeteam.com/archive/category/10058.aspx)
* [Exchange Bloggers OPML (1)](http://msexchangeteam.com/archive/category/4976.aspx)
* [Exchange Labs (3)](http://msexchangeteam.com/archive/category/11159.aspx)
* [History (32)](http://msexchangeteam.com/archive/category/3460.aspx)
* [Hyper-V (1)](http://msexchangeteam.com/archive/category/11161.aspx)
* [Job Openings (14)](http://msexchangeteam.com/archive/category/9915.aspx)
* [Microsoft (109)](http://msexchangeteam.com/archive/category/4429.aspx)
* [Microsoft IT (14)](http://msexchangeteam.com/archive/category/10426.aspx)
* [Mobility (57)](http://msexchangeteam.com/archive/category/3827.aspx)
* [MVP Bios (1)](http://msexchangeteam.com/archive/category/7219.aspx)
* [Outlook (47)](http://msexchangeteam.com/archive/category/4478.aspx)
* [Outlook Web Access (64)](http://msexchangeteam.com/archive/category/3990.aspx)
* [Protocols (10)](http://msexchangeteam.com/archive/category/3776.aspx)
* [Role: Client Access (55)](http://msexchangeteam.com/archive/category/11156.aspx)
* [Role: Edge Transport (13)](http://msexchangeteam.com/archive/category/11158.aspx)
* [Role: Hub Transport (23)](http://msexchangeteam.com/archive/category/11155.aspx)
* [Role: Mailbox (78)](http://msexchangeteam.com/archive/category/11154.aspx)
* [Role: Unified Messaging (13)](http://msexchangeteam.com/archive/category/11157.aspx)
* [Scripting (19)](http://msexchangeteam.com/archive/category/11149.aspx)
* [Security (30)](http://msexchangeteam.com/archive/category/11152.aspx)
* [Setup (50)](http://msexchangeteam.com/archive/category/3308.aspx)
* [Storage (87)](http://msexchangeteam.com/archive/category/3303.aspx)
* [Team Bios (276)](http://msexchangeteam.com/archive/category/3078.aspx)
* [Tips 'n Tricks (253)](http://msexchangeteam.com/archive/category/3307.aspx)
* [Tools (144)](http://msexchangeteam.com/archive/category/3309.aspx)
* [Transport & Routing (78)](http://msexchangeteam.com/archive/category/3754.aspx)
* [Troubleshooting (151)](http://msexchangeteam.com/archive/category/3306.aspx)
* [Unified Messaging (18)](http://msexchangeteam.com/archive/category/11150.aspx)
* [Virtualization (2)](http://msexchangeteam.com/archive/category/11160.aspx)
* [Webcast (1)](http://msexchangeteam.com/archive/category/11162.aspx)

#### Archives

* [March 2009 (2)](http://msexchangeteam.com/archive/2009/03.aspx)
* [February 2009 (7)](http://msexchangeteam.com/archive/2009/02.aspx)
* [January 2009 (11)](http://msexchangeteam.com/archive/2009/01.aspx)
* [December 2008 (10)](http://msexchangeteam.com/archive/2008/12.aspx)
* [November 2008 (10)](http://msexchangeteam.com/archive/2008/11.aspx)
* [October 2008 (11)](http://msexchangeteam.com/archive/2008/10.aspx)
* [September 2008 (9)](http://msexchangeteam.com/archive/2008/09.aspx)
* [August 2008 (16)](http://msexchangeteam.com/archive/2008/08.aspx)
* [July 2008 (13)](http://msexchangeteam.com/archive/2008/07.aspx)
* [June 2008 (13)](http://msexchangeteam.com/archive/2008/06.aspx)
* [May 2008 (12)](http://msexchangeteam.com/archive/2008/05.aspx)
* [April 2008 (15)](http://msexchangeteam.com/archive/2008/04.aspx)
* [March 2008 (20)](http://msexchangeteam.com/archive/2008/03.aspx)
* [February 2008 (22)](http://msexchangeteam.com/archive/2008/02.aspx)
* [January 2008 (11)](http://msexchangeteam.com/archive/2008/01.aspx)
* [December 2007 (13)](http://msexchangeteam.com/archive/2007/12.aspx)
* [November 2007 (17)](http://msexchangeteam.com/archive/2007/11.aspx)
* [October 2007 (21)](http://msexchangeteam.com/archive/2007/10.aspx)
* [September 2007 (17)](http://msexchangeteam.com/archive/2007/09.aspx)
* [August 2007 (19)](http://msexchangeteam.com/archive/2007/08.aspx)
* [July 2007 (15)](http://msexchangeteam.com/archive/2007/07.aspx)
* [June 2007 (14)](http://msexchangeteam.com/archive/2007/06.aspx)
* [May 2007 (14)](http://msexchangeteam.com/archive/2007/05.aspx)
* [April 2007 (19)](http://msexchangeteam.com/archive/2007/04.aspx)
* [March 2007 (20)](http://msexchangeteam.com/archive/2007/03.aspx)
* [February 2007 (27)](http://msexchangeteam.com/archive/2007/02.aspx)
* [January 2007 (26)](http://msexchangeteam.com/archive/2007/01.aspx)
* [December 2006 (19)](http://msexchangeteam.com/archive/2006/12.aspx)
* [November 2006 (27)](http://msexchangeteam.com/archive/2006/11.aspx)
* [October 2006 (32)](http://msexchangeteam.com/archive/2006/10.aspx)
* [September 2006 (18)](http://msexchangeteam.com/archive/2006/09.aspx)
* [August 2006 (21)](http://msexchangeteam.com/archive/2006/08.aspx)
* [July 2006 (14)](http://msexchangeteam.com/archive/2006/07.aspx)
* [June 2006 (27)](http://msexchangeteam.com/archive/2006/06.aspx)
* [May 2006 (15)](http://msexchangeteam.com/archive/2006/05.aspx)
* [April 2006 (16)](http://msexchangeteam.com/archive/2006/04.aspx)
* [March 2006 (18)](http://msexchangeteam.com/archive/2006/03.aspx)
* [February 2006 (12)](http://msexchangeteam.com/archive/2006/02.aspx)
* [January 2006 (10)](http://msexchangeteam.com/archive/2006/01.aspx)
* [December 2005 (12)](http://msexchangeteam.com/archive/2005/12.aspx)
* [November 2005 (12)](http://msexchangeteam.com/archive/2005/11.aspx)
* [October 2005 (11)](http://msexchangeteam.com/archive/2005/10.aspx)
* [September 2005 (9)](http://msexchangeteam.com/archive/2005/09.aspx)
* [August 2005 (14)](http://msexchangeteam.com/archive/2005/08.aspx)
* [July 2005 (14)](http://msexchangeteam.com/archive/2005/07.aspx)
* [June 2005 (14)](http://msexchangeteam.com/archive/2005/06.aspx)
* [May 2005 (10)](http://msexchangeteam.com/archive/2005/05.aspx)
* [April 2005 (13)](http://msexchangeteam.com/archive/2005/04.aspx)
* [March 2005 (15)](http://msexchangeteam.com/archive/2005/03.aspx)
* [February 2005 (13)](http://msexchangeteam.com/archive/2005/02.aspx)
* [January 2005 (12)](http://msexchangeteam.com/archive/2005/01.aspx)
* [December 2004 (13)](http://msexchangeteam.com/archive/2004/12.aspx)
* [November 2004 (14)](http://msexchangeteam.com/archive/2004/11.aspx)
* [October 2004 (17)](http://msexchangeteam.com/archive/2004/10.aspx)
* [September 2004 (10)](http://msexchangeteam.com/archive/2004/09.aspx)
* [August 2004 (16)](http://msexchangeteam.com/archive/2004/08.aspx)
* [July 2004 (21)](http://msexchangeteam.com/archive/2004/07.aspx)
* [June 2004 (24)](http://msexchangeteam.com/archive/2004/06.aspx)
* [May 2004 (26)](http://msexchangeteam.com/archive/2004/05.aspx)
* [April 2004 (24)](http://msexchangeteam.com/archive/2004/04.aspx)
* [March 2004 (31)](http://msexchangeteam.com/archive/2004/03.aspx)
* [February 2004 (18)](http://msexchangeteam.com/archive/2004/02.aspx)

#### Address List and EAP filter upgrades with Exchange Server 2007 ![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-left-on.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-right-on.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-left-off.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-right-off.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-left-off.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-right-off.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-left-off.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-right-off.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-left-off.gif]]![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/star-right-off.gif]]

As discussed in [this earlier blog post on OPATH Filters](http://msexchangeteam.com/archive/2007/01/10/432143.aspx), Exchange 2007 uses a new style of filter syntax to replace the LDAP filters of previous versions. This blog post will talk about the steps you can take to upgrade your legacy LDAP filters to the new syntax, allowing you to upgrade your Address List and Email Address Policy objects to the Exchange 2007 object version.

Note that if you decide _not to_ upgrade the ALs or EAPs, there will be no broken functionality from the Exchange 2007 side. New users will still be provisioned according to those policies. However you will not be able to edit those objects from 2007 Exchange Management Console until they are upgraded.

There are two types of EAPs and ALs you might be looking to upgrade: The built-in, default objects (Default Policy, All Users, etc) and custom objects (MyCompany Sales Org). It's very straight-forward to do filter upgrades for the built-in, default objects since these are well known and have standard filters in place. Upgrades for custom EAP and AL objects requires a bit more work, and we'll cover that later in the blog post.

**Upgrading your default Email Address Policy**

There's only one default EAP in your organization. This is the EAP which is usually called "Default Policy", and it will be specifically identified by the "Priority" value of "lowest". While it's quite likely you have created other custom EAPs, this EAP is the "fall-through" EAP which will match any recipient not matched to a higher-priority policy.

Therefore, you may notice that the default policy has a very inclusive LDAP recipient filter: "(mailnickname=\*)". Thus, it matches any recipient object.

So first let's talk about how to confirm you need to upgrade the filter (and the version) on your EAP. There are a couple of key indicators you can check. The first is that if you try to edit the EAP in Exchange 2007 GUI, you'll get a screen with this error - "_Unable to edit the specified E-mail address policy. E-mail address policies created with legacy versions of Exchange must be upgraded using the 'Set-EmailAddressPolicy' task, with the Exchange 2007 Recipient Filter specified._":

[![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/original.1.aspx]]](http://msexchangeteam.com/photos/postpictures2/images/432157/original.aspx)

Another way to check that doesn't rely on the GUI is to issue this one-liner:

Get-EmailAddressPolicy | Format-List Name,\*RecipientFilter\*,ExchangeVersion

This cmdlet will return all of your EAPs, and will include any properties containing RecipientFilter and the ExchangeVersion property. Look for these clues:

* LdapRecipientFilter is populated but RecipientFilter is empty - Exchange 2003 doesn't populate RecipientFilter; that's what we're about to do!
* RecipientFilterType is "Legacy"
* ExchangeVersion is "0.0 (6.5.6500.0)"

Matching these characteristics, you've now got a sense of which EAPs need to have their filters upgraded. Another shortcut now that we've talked about the details is that you might just run a one-liner like this to get the consolidated list:

Get-EmailAddressPolicy | where { $\_.RecipientFilterType -eq "Legacy" }

Next step, how to do the upgrade on the default EAP (we'll talk about custom EAPs later in the post).

Since the "Default Policy" EAP has a well-known filter, we can simply provide the Exchange 2007 equivalent of this well-known filter to do the upgrade. Here's the one-liner:

Set-EmailAddressPolicy "Default Policy" -IncludedRecipients AllRecipients

When you run this one-liner, you'll be prompted to ask whether you REALLY want to do the upgrade with this text: "_To save changes on object "Default Policy", the object must be upgraded to the current Exchange version. After the upgrade, this object cannot be managed by a previous version of Exchange System Manager. Do you want to continue to upgrade and save the object?_"

Once you've committed to a "Y" answer on this confirmation, the "Default Policy" EAP will be upgraded to Exchange 2007 version with the new Exchange 2007 filter in place. You can confirm this by looking at the same properties as before. Now you'll notice that there is a RecipientFilter property populated, that the RecipientFilterType is "Precanned", and that the Exchange version has bumped to 0.1 (8.0.535.0). Further, you may notice that you can no longer make changes to the recipient policy through Exchange 2003 ESM, although the Exchange 2003 Recipient Update Service (RUS) will continue to process these recipient policies just fine.

**ForceUpgrade parameter**

Many have noticed that there's a "-ForceUpgrade" parameter on the Set-EmailAddressPolicy and Set-AddressList cmdlets. Note that this parameter does NOT construct the proper replacement RecipientFilter for your object or do the upgrade. This parameter simply suppresses the confirmation question discussed just above so that you can do these upgrades in a script, if needed.

This means that if you run a one-liner like: Set-EmailAddressPolicy "Default Policy" -ForceUpgrade, nothing will happen. This is because you've told it to suppress the confirmation prompt, but without a new filter provided on the one-liner, there's no upgrade and therefore no upgrade confirmation to suppress!

**Upgrading your Default Address Lists**

Exchange 2003 creates a number of default address lists for exposure to the client side. These are named to match what objects they contain: "All Users", "All Groups", "All Contacts", "Public Folders", and the "Default Global Address List". Exchange 2007 adds one new AL to expose just the resource mailboxes of type room: "All Rooms".

The "All Rooms" AL is already updated to Exchange 2007 filter and version, but the other five default ALs are not. Like with the default EAP example above, you can try to edit these in the GUI or you can run a simple one-liner to confirm that these ALs are in need of an upgrade:

Get-AddressList | Format-List Name,\*RecipientFilter\*,ExchangeVersion

Get-GlobalAddressList | Format-List Name,\*RecipientFilter\*,ExchangeVersion

The exact same "clues" criteria apply to legacy AddressLists:

* LdapRecipientFilter is populated but RecipientFilter is empty - Exchange 2003 doesn't populate RecipientFilter; that's what we're about to do!
* RecipientFilterType is "Legacy"
* ExchangeVersion is "0.0 (6.5.6500.0)"

So, now that you've made an inventory of your legacy ALs, let's get those default ones upgraded!

Since these five ALs have well-known filters, we can simply provide the Exchange 2007 equivalent of these well-known filters to do the upgrades. Here are the one-liners:

Set-AddressList "All Users" -IncludedRecipients MailboxUsers

Set-AddressList "All Groups" -IncludedRecipients MailGroups

Set-AddressList "All Contacts" -IncludedRecipients MailContacts

And the last two that are slightly different, since there are not "precanned" filters for public folder recipient type:

Set-AddressList "Public Folders" -RecipientFilter { RecipientType -eq 'PublicFolder' }

Set-GlobalAddressList "Default Global Address List" -RecipientFilter {(Alias -ne $null -and (ObjectClass -eq 'user' -or ObjectClass -eq 'contact' -or ObjectClass -eq 'msExchSystemMailbox' -or ObjectClass -eq 'msExchDynamicDistributionList' -or ObjectClass -eq 'group' -or ObjectClass -eq 'publicFolder'))}

When you run these one-liners, you'll be prompted to ask whether you REALLY want to do the upgrade with this text: "_To save changes on object "<whichever one you're upgrading>", the object must be upgraded to the current Exchange version. After the upgrade, this object cannot be managed by a previous version of Exchange System Manager. Do you want to continue to upgrade and save the object?_"

Once you've committed to a "Y" answer on this confirmation, the Address List will be upgraded to Exchange 2007 version with the new Exchange 2007 filter in place. You can confirm this by looking at the same properties as before. Now you'll notice that there is a RecipientFilter property populated, that the RecipientFilterType is "Precanned", and that the Exchange version has bumped to 0.1 (8.0.535.0). Further, you may notice that you can no longer make changes to address list through Exchange 2003 ESM, although the Exchange 2003 Recipient Update Service (RUS) will continue to process these recipient policies just fine.

**ForceUpgrade parameter**

Many have noticed that there's a "-ForceUpgrade" parameter on the Set-EmailAddressPolicy and Set-AddressList cmdlets. Note that this parameter does NOT construct the proper replacement RecipientFilter for your object or do the upgrade. This parameter simply suppresses the confirmation question discussed just above so that you can do these upgrades in a script, if needed.

This means that if you run a one-liner like: Set-AddressList "All Users" -ForceUpgrade, nothing will happen. This is because you've told it to suppress the confirmation prompt, but without a new filter provided on the one-liner, there's no upgrade and therefore no upgrade confirmation to suppress!

**Custom Email Address Policy and Address List filters**

But what if you've created some special EAP or AL objects for your organization, over and above the built-in set of EAP and AL objects? How can you convert the "not-so-well-known" LDAP filter you have created into an equivalent OPATH filter for use by PowerShell?

The process I've covered earlier in my blog (<http://blogs.technet.com/evand/archive/2006/09/14/456310.aspx>), but I'm going to revisit it here so that it's available together with the default objects above.

The key part of this exercise has two parts: 1) figure out what the filter is actually filtering, followed by 2) reconstruct the filter with PowerShell syntax as OPATH and set it on the object.

So here's a sample "custom filter" you might have built:

(&(&(|(&(&(objectCategory=user)(msExchHomeServerName=/o=ORG/ou=SITE/cn=Configuration/cn=Servers/cn=\*)))(&(|(objectCategory=group)(objectCategory=msExchDynamicDistributionList))(displayname=IT\*)))))

On to step 1 - figuring out what this actually filters!

There are a couple things you can do at this stage to help yourself out. You can copy and paste this filter into a "search" action in LDP (subtree, starting at the root) and see what it returns. At a high-level, this will at least help you to know what sort of things you're looking for in your OPATH translation (you can tell if you're way off after you've finished).

The more practical way of doing this is to paste it into notepad and break it out into indented lines so you can see the logical flow:

(&
  (&
  (|
    (&
      (&
      (objectCategory=user)(msExchHomeServerName=/o=ORG/ou=SITE/cn=Configuration/cn=Servers/cn=\*)
       )
     )
     (&
     (|
       (objectCategory=group)(objectCategory=msExchDynamicDistributionList)
      )
     (displayname=IT\*)
      )
    )
  )
)

Alright, that seems fairly easy... give or take.

Translated to English, it looks something like this:

	* All user-category objects that have home server in a particular admin group (this would only be mailbox objects in that AG)
* AND
	* All (Groups OR Dynamic Distribution Groups) that start with a particular displayname wildcard

Great! So that's a start. Now we at least know what we should expect to find if we do issue the LDAP search in LDP!

Next, on to part two... translating the logical filter we've just determined into OPATH syntax:

First, let's diagram it loosely like above. Then we can go into the actual cmdlet syntax...

	* (ServerLegacyDN -like "/o=ORG/ou=SITE/cn=Configuration/cn=Servers/cn=\*")
* \-and
	* ( (RecipientType -eq "<_one of several group recipient-types_\>" -or RecipientType -eq "DynamicDL")
		* \-and
	* ( DisplayName - like "IT\*" ) )

Not so bad, really. You're just swapping some filtering keywords and the LDAP style of syntax for the OPATH style.

Since you're upgrading your existing EAP (or Address List), now you're ready to use the appropriate Set cmdlet to save this change to your object.

This will be a "custom filter" created from the shell, since it doesn't fall under the "precanned" filter options. This means you will create it using the "RecipientFilter" parameter and you'd end up with a long, but manageable, one-liner something like this:

Set-EmailAddressPolicy eap1 -RecipientFilter { (ServerLegacyDN -like "/o=ORG/ou=SITE/cn=Configuration/cn=Servers/cn=\*" ) -or ( ( RecipientType -eq "MailEnabledUniversalDistributionGroup" -or RecipientType -eq "MailEnabledUniversalSecurityGroup" -or RecipientType -eq "MailEnabledNonUniversalGroup" -or RecipientType -eq "DynamicDL") -and ( DisplayName -like "IT\*" ) ) }

There are nearly infinite possible "custom" filters you may have created and need to upgrade, so we can't cover all of them in a blog post. I have created a wiki page over at <http://www.exchangeninjas.com/> to host any such filters you've converted and wish to share. See the page at: <http://www.exchangeninjas.com/EAPAndALFilterUpgrades>

Also, this page will be a great place to post your LDAP filters (be sure to strip out anything sensitive from the filters before posting!) and ask if anyone else has already done the work of converting a similar filter and might be able to help.

**NOTE:** a sample script that you can use to upgrade your default policy as well as your default ALs is attached. Please see the UpgradeDefaultFilters.txt attached below!

\- [Evan Dodds](http://msexchangeteam.com/archive/2004/02/13/72684.aspx)

Published Thursday, January 11, 2007 10:05 AM by [Exchange](http://msexchangeteam.com/user/Profile.aspx?UserID=3106)
Filed Under: [Administration](http://msexchangeteam.com/archive/category/3648.aspx), [Exchange 2007](http://msexchangeteam.com/archive/category/10058.aspx)
**Attachment(s):** [UpgradeDefaultFilters.txt](http://msexchangeteam.com/attachment/432158.ashx)

### Comments

|     |     |
| --- | --- |
|     | #### [Joesph Worrall](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>The command:<br>Set-AddressList "All PublicFolders" –RecipientFilter { RecipientType –eq 'PublicFolder' }<br>Results in the error:<br>Set-AddressList : Cannot bind parameter 'RecipientFilter' to the target. Except<br>ion setting "RecipientFilter": """ is not a valid operator. For a list of suppo<br>rted operators see the command help.<br>"( RecipientType -eq 'publicfolder' )" at position 17."<br>At line:1 char:50<br>\+ Set-AddressList "Public Folders" -RecipientFilter  <<<< {( RecipientType -eq<br>'publicfolder' )}<br>January 11, 2007 2:09 PM |
|     | ####  said:<br><br>Joseph, two ideas on what might be wrong (we are unable to reproduce it):<br>1) Are you running RTM?<br>2) Did you run the script or cut/paste the string (and maybe smart quotes?) from the post?<br>January 11, 2007 6:31 PM |
|     | ####  said:<br><br>Could you guys do a writeup regarding the tcp ports used for Outlook 2007 to Exchange 2007 communication?  Something like the KB article at <http://support.microsoft.com/?id=270836> but updated for 2007.  We have a hardware firewall inbetween our citrix servers (outlook 2007) and our exchange server -- wondering what ports we'll need to open and/or if ex2007 will need registry modification to hard-code ports.  We plan to use ISA 2006 to broker OWA, activesync, and Outlook Anywhere connections - should it also be used for direct, internal outlook 2007 use?<br>thanks!<br>Wes<br>January 12, 2007 2:53 AM |
|     | #### [Jeroen](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>when i execute: Set-EmailAddressPolicy "Default Policy" –IncludedRecipients AllRecipients<br>i get this error:<br>Set-EmailAddressPolicy : The recipient policy "Default Policy" with mailbox man<br>ager settings cannot be managed by the current version of Exchange Management C<br>onsole. Please use a management console with the same version as the object.<br>At line:1 char:23<br>\+ Set-EmailAddressPolicy  <<<< "Default Policy" -IncludedRecipients AllRecipien<br>ts<br>is there an other way to update the Default Policy?<br>runnning on 2003 x64 with exchange 2007 RTM<br>January 12, 2007 1:29 PM |
|     | #### [onovotny](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>I get the same error as Jeroen when I try to update the Default Policy.<br>January 12, 2007 4:12 PM |
|     | #### [Evan](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fblogs.technet.com%2fevand) said:<br><br>Jeroen and onovotny - this error message indicates that it's not just a recipient policy but that you also have mailbox manager policy settings on this object. Since Mailbox Manager policies no longer exist in Exchange 2007, you need to remove the mailbox manager policy settings from this recipient policy object using Exchange 2003 before you can upgrade the policy to Exchange 2007 version (you can create another mailbox manager policy that has no email address policy settings in Exchange 2003 if you want to keep the mailbox manager settings).<br>January 13, 2007 11:18 AM |
|     | #### [Rhoderick](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>Thanks Evan, but what about the error that Joseph posted?  That one is on the PF address list.<br>January 16, 2007 9:41 AM |
|     | #### [Mitchell-MTI](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>The documentation regarding the -Forceupgrade parameter for set-emailaddresspolicy doesn't seem to match with what is said in this post:<br><http://technet.microsoft.com/en-us/library/bb124517.aspx><br>It seems to imply that the -forceupgrade parameter is updating the version attribute, not just suppressing the warning dialog.  Also, it would be a lot clearer in the documentation for this command if it indicated that it needs to be run with the parameters to create a new recipient filter.<br>January 16, 2007 10:04 AM |
|     | #### [Dgoldman's WebLog](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fblogs.msdn.com%2fdgoldman%2farchive%2f2007%2f01%2f14%2foab-generation-fails-with-9108-9126-9175-and-mapi-error-0x80040402.aspx) said:<br><br>If you are not familiar with what OPATH is, then you must read these two blogs when you are done reading<br>January 21, 2007 1:03 PM |
|     | #### [Evan](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fblogs.technet.com%2fevand) said:<br><br>Rhoderick and Mitchell - sorry for the delay, I've been out of this office this week on vacation.<br>The error that Joseph posted I can't seem to reproduce. The syntax in the script and in the blog post works fine when I run it. My thoughts: Is this an RTM build of the server? (some of the filterable properties changed from Beta2 -> RTM). Did you cut/paste rather than running the script or retyping it? (sometimes the cut/paste approach leads to high-ascii or unicode characters like "smartquotes" that the shell won't like in the parser).<br>Mitchell - the description of ForceUpgrade in this post is the correct one. There's been a great deal of confusion about what this parameter does, so I've passed along the link you posted and we'll get it fixed up. Please let us know if you run across other confusing descriptions of ForceUpgrade or other parameters.<br>Thanks!<br>Evan<br>January 21, 2007 1:19 PM |
|     | #### [Evan Dodds - Microsoft Exchange Server Blog](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fblogs.technet.com%2fevand%2farchive%2f2007%2f01%2f23%2fexchange-2007-sysmgmt-team-blog-posts-roundup.aspx) said:<br><br>I have previously listed the progress we've been making in posting ITPro focused Systems Management blog<br>January 23, 2007 6:44 PM |
|     | #### [Richard](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>Had the same problem as Joseph (Joesph?) did.<br>I had to change "All PublicFolders" to "Public Folders", probably because I had an Exchange2000 environment.<br>After that it still did not work, because of the minus characters (ASCII problem indeed!).<br>Retyping it myself in PowerShell did the trick for me.<br>January 30, 2007 9:48 AM |
|     | #### [Johnny](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>I'm getting this error when trying to run Set-EmailAddressPolicy "Default Policy" –IncludedRecipients AllRecipients<br>Unable to validate the filter: 'An Exchange 2007 server on which an address list service is active cannot be found.'<br>At line:1 char:1<br>\+ S <<<< et-EmailAddressPolicy 'Default Policy' -IncludedRecipients AllRecipients<br>January 31, 2007 12:21 PM |
|     | #### [Carl Johnson](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>Ok .. custom address list with A/D contacts that have the mail attribute populated? When I try to create an address list with a specific recipient policy it does not work and I get an error as such:<br>WARNING: The recipient "(\[DN\])" is invalid and could not be updated.<br>I would think this is possible since the contact has a email address, etc?<br>February 21, 2007 5:38 PM |
|     | #### [Ronald Top](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>Hi there,<br>I try to change the GAL with set-globaladdresslist , but it returns always cannot be performed on object def. gal. Any ideas how i can change the gal filter ??<br>BR,<br>Ronald<br>February 21, 2007 6:11 PM |
|     | #### [Evan](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fblogs.technet.com%2fevand%2f) said:<br><br>Ronald - the GAL filter syntax provided in the post is correct for updating the GAL filter. Can you make sure you're typing it correctly and/or use the attachment script file to do the upgrade? What's the exact error it's returning?<br>Evan<br>February 21, 2007 6:44 PM |
|     | #### [Ronald Top](http://msexchangeteam.com/user/Profile.aspx?UserID=1001) said:<br><br>Hi Evan,<br>Sorry for my late reply, here's what exactly happens :<br>Set-GlobalAddressList : The operation can not be done on the default global address list object, "Default Global Address List".<br>At line:1 char:22<br>Any ideas ? This is my last road blocker before moving to ex 2007.<br>Thanks and best regards,<br>Ronald Top<br>February 24, 2007 8:06 PM |
|     | #### [Evan](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fblogs.technet.com%2fevand%2f) said:<br><br>Ronald - generally this error message means it's already been upgraded (once it's upgraded to use the static E2k7 filter, the filter is fixed and cannot be customized). Can you do "Get-GlobalAddressList \| fl" and look to see both what is the configured RecipientFilter and also what is the ExchangeVersion? No need to post them here - please go ahead and shoot me some email (evandATmicrosoft) if you're still having trouble with it after that point.<br>Thanks!<br>Evan<br>February 26, 2007 4:17 PM |
|     | #### [Nick Smith](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fwww.officeanyplace.com) said:<br><br>We're in teh process of installing 1st Ex2007 server in our 2003 domain. Preliminary bits went fine, but then failed to install Mailbox role with: "<br>Error:<br>The Exchange server address list service failed to respond. This could be because of an address list or email address policy configuration error.<br>Warning:<br>An unexpected error has occurred and a Watson dump is being generated: The Exchange server address list service failed to respond. This could be because of an address list or email address policy configuration error. It was running command '$error.Clear(); $count=0; $ExchangeServers = Get-ExchangeServer -DomainController $RoleDomainController; foreach($server in $ExchangeServers) { if(($server.AdminDisplayVersion.Build -gt 641) -and ($server.IsMailboxServer -eq $true)) { $count++; } } if( $count -eq 1) { Set-OrganizationConfig -DomainController $RoleDomainController; }'.<br>\*\*\*\*\*\*\*\*\*\*\*\*\*<br>Only help we can find on the web is someone who said he'd deleted all his recipient policies. We're \*very\* loth to do this especially as any attempt to create new policy/GAl from the Ex2007 mangement console bascially results in same error. So we \*could\* delete all our policies and GALs but woudl then have to recreate manually in Ex2003 which would bring us full circle.<br>Any ideas?<br>February 27, 2007 11:23 AM |
|     | ####  said:<br><br>Nick,<br>Well, seeing that the blog does not work very well for troubleshooting, I'd ask you to either go to our newsgroups with this or open a support case on it. It is hard to tell why this is happening in your environment.<br>February 27, 2007 3:31 PM |
|     | #### [You Had Me At EHLO...](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fmsexchangeteam.com%2farchive%2f2007%2f03%2f12%2f436983.aspx) said:<br><br>After installing Exchange 2007 into your existing Exchange organization, the address lists and recipient...<br>March 12, 2007 6:08 PM |
|     | #### [travelling without moving](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fwww.stealthpuppy.com%2fblogs%2ftravelling%2farchive%2f2007%2f04%2f17%2fan-exchange-2007-upgrade-is-like-a-poke-in-the-eye.aspx) said:<br><br>I've upgraded our internal Exchange organisation over the last week and I've got to say Exchange 2007<br>April 16, 2007 11:29 AM |
|     | #### [An Exchange 2007 Upgrade Is Like a Poke in the Eye \| stealthpuppy.com](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fblog.stealthpuppy.com%2fexchange%2fan-exchange-2007-upgrade-is-like-a-poke-in-the-eye) said:<br><br>PingBack from <http://blog.stealthpuppy.com/exchange/an-exchange-2007-upgrade-is-like-a-poke-in-the-eye><br>May 29, 2007 12:05 AM |
|     | #### [Evan Dodds - Microsoft Exchange Server Blog](http://msexchangeteam.com/utility/Redirect.aspx?U=http%3a%2f%2fblogs.technet.com%2fevand%2farchive%2f2007%2f02%2f19%2ffilterable-properties-in-exchange-2007-rtm.aspx) said:<br><br>Since I've posted a number of times about OPATH filters for Exchange 2007 and RecipientFilter parameter<br>June 20, 2007 9:37 AM |

_New Comments to this post are disabled_

#### News

This is provided "AS IS" with no warranties, and confers no rights. Use of included script samples are subject to the terms specified in the [Terms of Use](http://www.microsoft.com/info/cpyright.htm).
**New!** Would you like to suggest a topic for the Exchange team to blog about? Send [suggestions to us](http://msexchangeteam.com/archive/2004/12/10/279655.aspx).
[![[./_resources/You_Had_Me_At_EHLO...__Address_List_and_EAP_filter_upgrades_with_Exchange_Server_2007.resources/original.aspx]]](http://www.cafepress.com/ehlo)

#### Poll:

#### Other Exchange Blogs

* [Dillon TenBrink](http://tenbrink.us/dillon/category/12.aspx)
* [Glen's Exchange Dev Blog](http://gsexdev.blogspot.com/)
* [Michael B. Smith](http://theessentialexchange.com/blogs/michael)
* [msgoodies](http://msgoodies.blogspot.com/)
* [C:>telnet 127.0.0.1 25](http://telnetport25.wordpress.com/)
* [Exchange Development Blog](http://blogs.msdn.com/exchangedev)
* [Elan Shudnow’s Blog](http://www.shudnow.net/)

#### Other Cool Places

* [Microsoft Exchange](http://www.microsoft.com/exchange)
* [Exchange TechCenter](http://www.microsoft.com/technet/prodtechnol/exchange/default.mspx)
* [Search Exchange](http://searchexchange.techtarget.com/)
* [MSExchange.org](http://www.msexchange.org/)
* [Messagingtalk.org](http://www.messagingtalk.org/)
* [The Official Microsoft Speech Server Blog](http://blogs.msdn.com/mssblog)
* [The Official SBS Blog](http://blogs.technet.com/sbs)
* [Sharepoint Team Blog](http://blogs.msdn.com/sharepoint)
* [Exchange 2007 Wiki](http://www.exchangeninjas.com/)
* [Microsoft Office Outlook Team Blog](http://blogs.msdn.com/outlook)
* [Microsoft Forefront Server Security Blog](http://blogs.technet.com/fss)
* [Windows Virtualization Team Blog](http://blogs.technet.com/virtualization)
* [Ask The Performance Team Blog](http://blogs.technet.com/askperf)
* [Office Communications Server Team](http://communicationsserverteam.com/default.aspx)
* [Office Communicator Team Blog](http://communicatorteam.com/default.aspx)
* [Office for Mac Team Blog](http://blogs.msdn.com/macmojo)
* [Security Vulnerability Research & Defense](http://blogs.technet.com/swi/default.aspx)
* [The Master Blog](http://blogs.technet.com/themasterblog)

#### International

* [Exchange FAQ (Danish)](http://www.exchange-faq.dk/)
* [Exchange User Group Europe](http://www.eugeurope.org/)
* [Rui José Silva MVP (Portuguese)](http://ehlo.blogspot.com/)
* [Anderson Patricio MVP (Brazilian Portuguese)](http://spaces.msn.com/andersonpatricio)
* [Grupo Latino de usuarios de Exchange](http://www.msglue.org/)
* [chrischmi.de (German)](http://chrischmi.de/blog)
* [Pro-Exchange (Belgium)](http://www.proexchange.be/)
* [Markus' Messaging Blog (German)](http://msg-blog.de/)
* [Frank's Exchange FAQ (German)](http://www.msxfaq.de/)
* [Το Ελληνικό Exchange Blog (Greek)](http://blogs.technet.com/pamal)
* [Groupe des Utilisateurs Exchange (French)](http://www.msexchange.fr/)
* [E-mail és a detektívek (Hungarian)](http://emaildetektiv.hu/)

#### \[MS\] Exchange Blogs

* [KC Lemson Exch PM](http://blogs.msdn.com/kclemson)
* [Evan Dodds Exch PM](http://blogs.technet.com/evand)
* [Gerod Serafin MCS](http://blogs.msdn.com/Gerod_Serafin)
* [Stephen Griffin Escalation Engineer](http://blogs.msdn.com/stephen_griffin)
* [Sean Daniel SBS PM](http://seanda.blogspot.com/)
* [Dave Goldman Exch CPR](http://blogs.msdn.com/dgoldman)
* [Eileen Brown IT Pro Evangelist](http://blogs.technet.com/eileen_brown)
* [Matt Stehle Dev Support](http://blogs.msdn.com/mstehle)
* [Harold Wong IT Evangelist](http://blogs.technet.com/haroldwong)
* [The CollabTools blog](http://blogs.technet.com/collabtools)
* [Jason Mayans Program Mgr Lead](http://blogs.technet.com/jmayans)
* [Vivek Sharma Program Manager](http://www.viveksharma.com/techlog)
* [Scott Schnoll Principal Technical Writer](http://blogs.technet.com/scottschnoll)
* [Ewan Dalton Solutions Architect](http://blogs.technet.com/ewan)
* [Doug Gowans MCS](http://blogs.msdn.com/douggowans)
* [Ben Winzenz CSS](http://blogs.technet.com/benw)
* [Feroze Daud Exch Dev](http://blogs.msdn.com/feroze_daud)
* [David Strome Sr Technical Writer](http://blogs.technet.com/dstrome)
* [Jeff Stokes CSS](http://blogs.technet.com/jeff_stokes/default.aspx)
* [Mike Lagase CSS](http://blogs.technet.com/mikelag)
* [Microsoft UK UC Blog](http://blogs.technet.com/msukucc)
* [Tim McMichael CSS](http://blogs.technet.com/timmcmic)
* [Bharat Suneja Sr Technical Writer](http://www.exchangepedia.com/blog)

#### \[MVP\] Blogs/Sites

* [MS Exchange Blog](http://hellomate.typepad.com/)
* [rcpt to:](http://msexchange.blogspot.com/)
* [Paul's Down-Home Page](http://www.robichaux.net/blog)
* [Slipstick](http://www.slipstick.com/exs/index.htm)
* [The P0stmaster's Blog](http://p0stmaster.blogspot.com/)
* [Susan Bradley's SBS Blog](http://msmvps.com/bradley)
* [SBS FAQ](http://www.sbsfaq.com/)
* [Chad Gross SBS](http://msmvps.com/cgross)
* [Kevin Weilbacher SBS](http://msmvps.com/kwsupport)
* [Jim McBee](http://mostlyexchange.blogspot.com/)
* [MCSEworld by Daniel Petri](http://www.petri.co.il/)
* [subject: exchange](http://msmvps.com/blogs/ehlo/default.aspx)
* [Vlad Mazek](http://www.vladville.com/)
* [Thierry Deman](http://www.faqexchange.info/)
* [Henrik Walther Blog](http://blogs.msexchange.org/walther)
* [Devin L. Ganger's Blog](http://blogs.3sharp.com/blog/deving)
* [MM&M UG UK](http://www.mmmug.co.uk/)
* [BlankMan's Blog](http://blankmanblog.spaces.live.com/)
* [Archiving101](http://www.archiving101.com/)
* [Exchange_genie](http://www.exchange-genie.com/)
* [Jan Geisbauer's Blog](http://blog.geisbauer.de/)
