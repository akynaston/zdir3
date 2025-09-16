# Understanding Recipients: Exchange 2010 Help

[![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/0.2.gif]]](http://www.omniture.com/)
[Upgrade your Internet Experience](http://clk.atdmt.com/MRT/go/141489559/direct/01/)
 ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]

|     |
| --- |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
|     |
| [More...](http://technet.microsoft.com/en-us/ms376720.aspx) |

[Microsoft.com](http://www.microsoft.com/)
Welcome [Sign in](http://login.live.com/login.srf?wa=wsignin1.0&rpsnv=11&ct=1273685034&rver=6.0.5276.0&wp=MCLBI&wlcxt=technet%24technet%24technet&wreply=http:%2F%2Ftechnet.microsoft.com%2Fen-us%2Flibrary%2Fbb201680.aspx&lc=1033&id=254354)
<http://technet.microsoft.com/en-us/default.aspx>

Suggestions
[Close](http://technet.microsoft.com/en-us/library/bb201680.aspx#)

Exchange Server TechCenter
[Home](http://technet.microsoft.com/en-us/exchange/bb219569.aspx)[2010](http://technet.microsoft.com/en-us/exchange/dd203064.aspx)[2007](http://technet.microsoft.com/en-us/exchange/bb330841.aspx)[Library](http://technet.microsoft.com/en-us/library/aa996058.aspx)[Forums](http://social.technet.microsoft.com/Forums/en-US/category/exchange2010,exchangeserver/)[Exchange Team News](http://technet.microsoft.com/en-us/exchange/teamblog/ee424145.aspx)
  |   [ScriptFree](http://technet.microsoft.com/en-us/library/bb201680.aspx)
 [![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]] Printer Friendly Version](http://technet.microsoft.com/en-us/library/bb201680(printer).aspx)            

|     |     |
| --- | --- |
| Click to Rate and Give Feedback | <http://technet.microsoft.com/en-us/library/bb201680.aspx#> |

Give feedback on this content

![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]

* ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]][TechNet Library](http://technet.microsoft.com/en-us/library/aa991542.aspx)

[TechNet](http://technet.microsoft.com/en-us/ms376608.aspx)
Please Wait

[TechNet Library](http://technet.microsoft.com/en-us/library/aa991542.aspx)
Please Wait

[Exchange Server](http://technet.microsoft.com/en-us/library/aa996058(EXCHG.80).aspx)
Please Wait

[Exchange Server 2010](http://technet.microsoft.com/en-us/library/bb124558.aspx)
Please Wait

[Mailbox](http://technet.microsoft.com/en-us/library/dd351040.aspx)
Please Wait

[Understanding Mailbox](http://technet.microsoft.com/en-us/library/ee694812.aspx)
Please Wait

[Understanding Recipients](http://technet.microsoft.com/en-us/library/bb201680.aspx)
Please Wait

![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]Collapse All Expand All
More Resources

Related Help Topics
![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/progress.gif]]Loading...
No resources found.

* [Understanding Custom Attribute...](http://technet.microsoft.com/en-us/library/Ee423541.aspx)
* [Understanding Disconnected Mai...](http://technet.microsoft.com/en-us/library/Bb232039.aspx)
* [Understanding Importing and Ex...](http://technet.microsoft.com/en-us/library/Ee633455.aspx)
* [Understanding the Microsoft Ex...](http://technet.microsoft.com/en-us/library/Bb430759.aspx)

* [Upgrade Default Address Lists ...](http://technet.microsoft.com/en-us/library/Dd335105.aspx)
* [Add a Member to a Distribution...](http://technet.microsoft.com/en-us/library/Aa995970.aspx)
* [Add an E-Mail Address for a Us...](http://technet.microsoft.com/en-us/library/Bb123794.aspx)
* [Add the Mailbox Import Export ...](http://technet.microsoft.com/en-us/library/Ee633452.aspx)

Related Blog Articles
![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/progress.gif]]Loading...
[Visit the Exchange Team Blog](http://msexchangeteam.com/default.aspx)

Related Forum Discussions
[Ask a question](http://go.microsoft.com/fwlink/?LinkId=163297)
[Visit the forums](http://go.microsoft.com/fwlink/?LinkID=150026)
This page is specific to
**Exchange 2010**

* [Exchange 2007](http://technet.microsoft.com/en-us/library/bb201680(EXCHG.80).aspx)

Understanding Recipients
\[This topic's current status is: [Content Complete](http://technet.microsoft.com/en-us/library/dd298100.aspx).\]

_**Applies to:** Exchange Server 2010_ _**Topic Last Modified:** 2010-02-02_

The people and resources that send and receive messages are the core of any messaging and collaboration system. In an Exchange organization, these people and resources are referred to as _recipients_. A recipient is any mail-enabled object in Active Directory to which Exchange can deliver or route messages.

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Recipient Types

Microsoft Exchange Server 2010 includes several explicit recipient types. Each recipient type is represented by a unique icon in the Exchange Management Console (EMC) and a unique name in the _RecipientTypeDetails_ property in the Exchange Management Shell. The use of explicit recipient types has the following benefits:

* At a glance, you can differentiate between various recipient types.
	
* You can search, sort, and filter by each recipient type.
	
* You can more easily perform bulk management operations for each recipient type.
	
* You can more easily view recipient properties because the EMC uses the recipient types to render different property pages. For example, the resource capacity is displayed for a conference room mailbox, but isn't present for a user mailbox.
	

The following table lists the available recipient types. All these recipient types are discussed in more detail later in this topic.

### Exchange 2010 recipient types

| Recipient type | Description |
| --- | --- |
| Dynamic distribution group | A distribution group that uses recipient filters and conditions to derive its membership at the time messages are sent. |
| Equipment mailbox | A resource mailbox that's assigned to a non-location specific resource, such as a portable computer projector, microphone, or a company car. Equipment mailboxes can be included as resources in meeting requests, providing a simple and efficient way of utilizing resources for your users. |
| Legacy mailbox | A mailbox that resides on a server running Exchange Server 2003. |
| Linked mailbox | A mailbox that's assigned to an individual user in a separate, trusted forest. |
| Mail contact | A mail-enabled Active Directory contact that contains information about people or organizations that exist outside the Exchange organization. Each mail contact has an external e-mail address. All messages sent to the mail contact are routed to this external e-mail address. |
| Mail forest contact | A mail contact that represents a recipient object from another forest. Mail forest contacts are typically created by Microsoft Identity Integration Server (MIIS) synchronization.<br><br>![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Important:<br>Mail forest contacts are read-only recipient objects that are updated only through MIIS or similar custom synchronization. You can't use the EMC or the Shell to remove or modify a mail forest contact. |
| Mail user | A mail-enabled Active Directory user that represents a user outside the Exchange organization. Each mail user has an external e-mail address. All messages sent to the mail user are routed to this external e-mail address.<br><br>A mail user is similar to a mail contact, except that a mail user has Active Directory logon credentials and can access resources. |
| Mail-enabled non-universal group | A mail-enabled Active Directory global or local group object. Mail-enabled non-universal groups were discontinued in Exchange Server 2007 and can exist only if they were migrated from Exchange 2003 or earlier versions of Exchange. You can't use Exchange 2010 to create non-universal distribution groups. |
| Mail-enabled public folder | An Exchange public folder that's configured to receive messages. |
| Mail-enabled universal distribution group | A mail-enabled Active Directory distribution group object that can be used only to distribute messages to a group of recipients. |
| Mail-enabled universal security group | A mail-enabled Active Directory security group object that can be used to grant access permissions to resources in Active Directory and can also be used to distribute messages. |
| Microsoft Exchange recipient | A special recipient object that provides a unified and well-known message sender that differentiates system-generated messages from other messages. It replaces the System Administrator sender used for system-generated messages in earlier versions of Exchange. To learn more, see [Understanding the Microsoft Exchange Recipient](http://technet.microsoft.com/en-us/library/bb430759.aspx). |
| Room mailbox | A resource mailbox that's assigned to a meeting location, such as a conference room, auditorium, or training room. Room mailboxes can be included as resources in meeting requests, providing a simple and efficient way of organizing meetings for your users. |
| Shared mailbox | A mailbox that's not primarily associated with a single user and is generally configured to allow logon access for multiple users. |
| User mailbox | A mailbox that's assigned to an individual user in your Exchange organization. It typically contains messages, calendar items, contacts, tasks, documents, and other important business data. |
| Linked user | New in Exchange 2010, a linked user is a user that resides in one forest while their mailbox resides in another forest. |

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Mailboxes

Mailboxes are the most common recipient type used by information workers in an Exchange organization. Each mailbox is associated with an Active Directory user account. The user can use the mailbox to send and receive messages, and to store messages, appointments, tasks, notes, and documents. Mailboxes are the primary messaging and collaboration tool for the users in your Exchange organization.

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Mailbox Components

Each mailbox consists of an Active Directory user and the mailbox data that's stored in the Exchange mailbox database (as shown in the following figure). All configuration data for the mailbox is stored in the Exchange attributes of the Active Directory user object. The mailbox database contains the actual data that's in the mailbox associated with the user account.

| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Important: |
| --- |
| When you create a mailbox for a new or existing user, the Exchange attributes required for a mailbox are added to the user object in Active Directory. The associated mailbox data isn't created until the mailbox either receives a message or the user logs on to it. |

**Mailbox components**
![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.gif]]

| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.1.gif]]Caution: |
| --- |
| If you remove a mailbox, the mailbox data stored in the Exchange mailbox database is marked for deletion and the associated user account is also deleted from Active Directory. To retain the user account and delete only the mailbox data, you must disable the mailbox. |

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Mailbox Types

Exchange 2010 supports the following mailbox types:

* **User mailboxes**   User mailboxes are assigned to individual users in your Exchange organization. User mailboxes provide your users with a rich collaboration platform. They can send and receive messages, manage their contacts, schedule meetings, and maintain a task list. Users can also have voice mail messages delivered to their mailboxes. User mailboxes are the most commonly used mailbox type and are typically the mailbox type assigned to users in your organization.
	
* **Linked mailboxes**   Linked mailboxes are mailboxes that are accessed by users in a separate, trusted forest. Linked mailboxes may be necessary for organizations that deploy Exchange in a resource forest. The resource forest scenario allows an organization to centralize Exchange in a single forest, while allowing access to the Exchange organization with user accounts in one or more trusted forests.
	As stated earlier, every mailbox must have a user account associated with it. However, the user account that accesses the linked mailbox doesn't exist in the forest where Exchange is deployed. Therefore, a disabled user account that exists in the same forest as Exchange is associated with each linked mailbox. The following figure illustrates the relationship between the linked user account used to access the linked mailbox and the disabled user account in the Exchange resource forest associated with the linked mailbox.
	**Linked mailbox**
	![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.2.gif]]
	
* **Shared mailboxes**   Shared mailboxes aren't primarily associated with individual users and are generally configured to allow logon access for multiple users.
	Although it's possible to grant additional users the logon rights to any mailbox type, shared mailboxes are dedicated for this functionality. The Active Directory user associated with a shared mailbox must be a disabled account. After you create a shared mailbox, you must grant permissions to all users that require access to the shared mailbox.
	
	| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Important: |
	| --- |
	| You can only use the Shell to manage shared mailboxes. Management tasks include creating, removing, enabling, and disabling. After you create a shared mailbox, you can use the EMC for some tasks such as viewing, modifying, or moving the shared mailboxes. We recommend that you use resource mailboxes or Microsoft SharePoint Portal Server portals for collaboration instead of shared mailboxes. To learn more about converting a shared mailbox to a resource mailbox, see [Convert a Mailbox](http://technet.microsoft.com/en-us/library/bb201749.aspx). |
	
* **Legacy mailboxes**   Legacy mailboxes are mailboxes that reside on servers running Exchange 2003. You can manage legacy mailboxes by using the EMC or the Shell. However, not all Exchange 2010 features will apply to these mailboxes.
	
* **Resource mailboxes**   Resource mailboxes are special mailboxes designed to be used for scheduling resources. Like all mailbox types, a resource mailbox has an associated Active Directory user account, but it must be a disabled account. The following are the resource mailbox types:
	
	* **Room mailboxes**   These are resource mailboxes that are assigned to meeting locations, such as conference rooms, auditoriums, and training rooms.
		
	* **Equipment mailboxes**   These are resource mailboxes that are assigned to non-location specific resources, such as portable computer projectors, microphones, or company cars.
		
	
	You can include both types of resource mailboxes in meeting requests, providing a simple and efficient way to utilize resources for your users. You can configure resource mailboxes to automatically process incoming meeting requests based on the resource booking policies that are defined by the resource owners. For example, you can configure a conference room to automatically accept incoming meeting requests except recurring meetings, which can be subject to approval by the resource owner. To learn more about using resource mailboxes, see [Managing Resource Mailboxes and Scheduling](http://technet.microsoft.com/en-us/library/bb124374.aspx).
	

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  System Mailboxes

System mailboxes are created by Exchange in the root domain of the Active Directory forest during installation. Users or administrators can't log on to these mailboxes. System mailboxes are created for Exchange 2010 features such as message approval and Multi-Mailbox Search. This table lists information about system mailboxes as they're displayed in Active Directory.

| Mailbox | Common name (CN) |
| --- | --- |
| Discovery | SystemMailbox {e0dc1c29-89c3-4034-b678-e6c29d823ed9} |
| Message Approval | SystemMailbox {1f05a927-_xxxx_\- _xxxx_ - _xxxx_ -_xxxxxxxxxxxx_}<br><br>where _x_ is a randomly assigned number |
| Federated E-mail | FederatedEmail 4c1f4d8b-8179-4148-93bf-00a95fa1e042 |

If you want to decommission the last Exchange 2010 Mailbox server in your organization, you should first disable these system mailboxes by using the [Disable-Mailbox](http://technet.microsoft.com/en-us/library/aa997210.aspx) cmdlet. When you decommission a Mailbox server that contains these system mailboxes, you should move them to another Mailbox server to make sure that you don't lose functionality.

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Planning for Mailboxes

Mailboxes are created in mailbox databases on Exchange servers that have the Mailbox server role installed. To help provide a reliable and effective platform for your mailbox users, detailed planning for the deployment of Mailbox servers and databases is essential. To learn more about planning for Mailbox servers and databases, see the following topics:

* [Planning Roadmap for New Deployments](http://technet.microsoft.com/en-us/library/bb125239.aspx)
	
* [Exchange 2003 - Planning Roadmap for Upgrade and Coexistence](http://technet.microsoft.com/en-us/library/aa998186.aspx)
	
* [Exchange 2007 - Planning Roadmap for Upgrade and Coexistence](http://technet.microsoft.com/en-us/library/dd638158.aspx)
	
* [Managing Mailbox Databases](http://technet.microsoft.com/en-us/library/dd351078.aspx)
	
* [Managing Mailbox Servers](http://technet.microsoft.com/en-us/library/bb123480.aspx)
	

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Distribution Groups

Distribution groups are mail-enabled Active Directory group objects that are primarily used for distributing messages to multiple recipients. Any recipient type can be a member of a distribution group.

| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Important: |
| --- |
| Note the terminology differences between Active Directory and Exchange 2010. In Active Directory, a distribution group refers to any group that doesn't have a security context, whether it's mail-enabled or not. In Exchange 2010, all mail-enabled groups are referred to as distribution groups, whether they have a security context or not. |

Exchange supports the following types of distribution groups:

* **Mail-enabled universal distribution groups**   These are Active Directory distribution group objects that are mail-enabled. They can be used only to distribute messages to a group of recipients.
	
* **Mail-enabled universal security groups**   These are Active Directory security group objects that are mail-enabled. They can be used to grant access permissions to resources in Active Directory and can also be used to distribute messages.
	
* **Mail-enabled non-universal groups**   These are Active Directory global or local group objects that are mail-enabled. You can create or mail-enable only universal distribution groups. You may have mail-enabled groups that were migrated from previous versions of Exchange that aren't universal groups. These groups can still be managed by using the EMC or the Shell.
	
	| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Note: |
	| --- |
	| To convert a domain-local or a global group to a universal group, you can use the [Set-Group](http://technet.microsoft.com/en-us/library/bb123770.aspx) cmdlet in the Shell. |
	

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Dynamic Distribution Groups

Dynamic distribution groups are distribution groups whose membership is based on specific recipient filters rather than a defined set of recipients.

Unlike regular distribution groups, the membership list for dynamic distribution groups is calculated each time a message is sent to them, based on the filters and conditions that you specify. When an e-mail message is sent to a dynamic distribution group, it's delivered to all recipients in the organization that match the criteria defined for that dynamic distribution group.

| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Important: |
| --- |
| A dynamic distribution group includes any recipient in Active Directory that has attributes that match the group's filter at the time a message is sent. If a recipient's properties are modified to match the group's filter, that recipient could inadvertently become a group member and start receiving messages that are sent to the dynamic distribution group. Well-defined, consistent account provisioning processes can reduce the chances of this issue occurring. |

To help you create recipient filters for dynamic distribution groups, you can use precanned filters. A _precanned filter_ is a commonly used filter that you can use to meet a variety of recipient-filtering criteria. You can use these filters to specify the recipient types that you want to include in a dynamic distribution group. In addition, you can also specify a list of conditions that the recipients must meet. You can create precanned conditions based on the following properties:

* Custom attributes 1–15
	
* State or province
	
* Company
	
* Department
	

You can also specify conditions based on recipient properties other than those previously listed. To do this, you must use the Shell to create a custom query for the dynamic distribution group. Keep in mind that the filter and condition settings for dynamic distribution groups that have custom recipient filters can be managed only by using the Shell. For an example of how to create a dynamic distribution group by using a custom query, see [Create a Dynamic Distribution Group](http://technet.microsoft.com/en-us/library/bb123722.aspx).

| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Note: |
| --- |
| In the EMC, you use the **Distribution Group** node under **Recipient Configuration** to manage dynamic distribution groups. There isn't a separate node for dynamic distribution groups. |

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Mail Contacts

Mail contacts typically contain information about people or organizations that exist outside your Exchange organization. Mail contacts can appear in the global address list (GAL) and other address lists, and can be added as members to distribution groups. Each contact has an external e-mail address, and all e-mail messages that are sent to a contact are automatically forwarded to that address. Contacts are ideal for representing people external to your Exchange organization who don't need access to any internal resources. The following are mail contact types:

* **Mail contacts**   These are mail-enabled Active Directory contacts that contain information about people or organizations that exist outside your Exchange organization.
	
* **Mail forest contacts**   These represent recipient objects from another forest. These contacts are typically created by MIIS synchronization. Mail forest contacts are read-only recipient objects that can be updated or removed only by means of synchronization. You can't use Exchange management interfaces to modify or remove a mail forest contact.
	

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Mail Users

Mail users are similar to mail contacts. Both have external e-mail addresses, both contain information about people outside your Exchange organization, and both can be displayed in the GAL and other address lists. However, unlike a mail contact, mail users have Active Directory logon credentials and can access resources to which they are granted permission.

If a person external to your organization requires access to resources on your network, you should create a mail user instead of a mail contact. For example, you may want to create mail users for short-term consultants who require access to your server infrastructure, but who will use their own external e-mail addresses.

Another scenario is to create mail users in your organization for users who you don't want to maintain an Exchange mailbox. For example, after an acquisition, the acquired company may maintain their separate messaging infrastructure, but may also need access to resources on your network. For those users, you may want to create mail users instead of mailbox users.

| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Note: |
| --- |
| In the EMC, you use the **Mail Contact** node under **Recipient Configuration** to manage mail users. There isn't a separate node for mail users. |

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Mail-Enabled Public Folders

Public folders are intended to serve as a repository for information shared among many users. Mail-enabling a public folder provides an extra level of functionality to users. In addition to being able to post messages to the folder, users can send e-mail messages to, and sometimes receive e-mail messages from, the public folder. Each mail-enabled folder has an object in Active Directory that stores its e-mail address, address book name, and other mail-related attributes.

You can manage public folders by using either the Shell or the Public Folder Management Console. To access the Public Folder Management Console, click the **Toolbox** node in the EMC. For more information about managing mail-enabled public folders, see [Configure Public Folder Properties](http://technet.microsoft.com/en-us/library/bb691327.aspx).

  ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]  Microsoft Exchange Recipient

The Microsoft Exchange recipient is a special recipient object that provides a unified and well-known message sender that differentiates system-generated messages from other messages. It replaces the System Administrator sender that was used for system-generated messages in earlier versions of Exchange.

The Microsoft Exchange recipient isn't a typical recipient object, such as a mailbox, mail user, or mail contact, and it isn't managed by using the typical recipient tools. However, you can use the [Set-OrganizationConfig](http://technet.microsoft.com/en-us/library/aa997443.aspx) cmdlet in the Shell to configure the Microsoft Exchange recipient.

To learn more about the Microsoft Exchange recipient, see [Understanding the Microsoft Exchange Recipient](http://technet.microsoft.com/en-us/library/bb430759.aspx).

| ![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/Bb201680.3.gif]]Note: |
| --- |
| When system-generated messages are sent to an external sender, the Microsoft Exchange recipient isn't used as the sender of the message. Instead, the e-mail address specified by the _ExternalPostmasterAddress_ parameter in the [Set-TransportConfig](http://technet.microsoft.com/en-us/library/bb124151.aspx) cmdlet is used. For more information about the external postmaster address, see [Configure the External Postmaster Address](http://technet.microsoft.com/en-us/library/bb430765.aspx). |

|     |     |
| --- | --- |
| © 2010 Microsoft Corporation. All rights reserved. [Terms of Use](http://www.microsoft.com/info/cpyright.mspx) \| [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx) \| [Privacy Statement](http://www.microsoft.com/info/privacy.mspx) | [![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/clear.gif]]](http://www.microsoft.com/en/us/default.aspx) |

![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/trans_pixel.mozilla%3aen-US%3aofficial%26client%3dfirefox-a]]
![[./_resources/Understanding_Recipients_Exchange_2010_Help.resources/nojavascript&WT.js=No]]
