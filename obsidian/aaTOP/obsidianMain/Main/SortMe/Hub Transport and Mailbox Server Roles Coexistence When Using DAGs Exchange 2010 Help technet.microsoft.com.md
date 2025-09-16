# Hub Transport and Mailbox Server Roles Coexistence When Using DAGs: Exchange 2010 Help [technet.microsoft.com]

* [TechNet](http://technet.microsoft.com/)

* [Products](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx)
* [IT Resources](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx)
* [Downloads](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx)
* [Training](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx)
* [Support](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx)

[![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/BrandLogoExchange.png]]](http://technet.microsoft.com/)

[United States (English)](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#)
[Sign out](http://login.live.com/logout.srf?ct=1418600117&rver=6.0.5276.0&lc=1033&id=254354&ru=http%3a%2f%2ftechnet.microsoft.com%2fen-us%2flibrary%2fff699049%2528v%3dexchg.141%2529.aspx&mkt=en-US)
[TriVir MSDN](http://social.technet.microsoft.com/profile/trivir%20msdn/)

[Home](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx) [Online](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx) [2010](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx) [Other Versions](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx) [Library](http://technet.microsoft.com/library/aa996058(v=exchg.150)) [Forums](http://social.technet.microsoft.com/forums/en-us/category/exchangeserver,exchangeserverlegacy/) [Gallery](http://gallery.technet.microsoft.com/exchange)

[Export (0)](http://technet.microsoft.com/en-us/library/export/help/?returnUrl=%2fen-us%2flibrary%2fff699049(v%3dexchg.141).aspx) [Print](http://technet.microsoft.com/en-us/library/ff699049(d=printer,v=exchg.141).aspx)
[[#|Collapse All]]

<http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#>[TechNet Library](http://technet.microsoft.com/en-us/library/aa991542.aspx)
<http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#>[Office Products](http://technet.microsoft.com/en-us/library/hh220610(v=office.14).aspx)
<http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#>[Exchange](http://technet.microsoft.com/en-us/library/aa996058(v=exchg.150).aspx)
<http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#>[Exchange Server 2010](http://technet.microsoft.com/en-us/library/bb124558(v=exchg.141).aspx)
<http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#>[Transport](http://technet.microsoft.com/en-us/library/dd351247(v=exchg.141).aspx)
<http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#>[Understanding Transport](http://technet.microsoft.com/en-us/library/dd297988(v=exchg.141).aspx)
<http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#>[Understanding Shadow Redundancy](http://technet.microsoft.com/en-us/library/dd351027(v=exchg.141).aspx)
	[Shadow Redundancy Mail Flow Scenarios](http://technet.microsoft.com/en-us/library/dd351091(v=exchg.141).aspx)
	[Hub Transport and Mailbox Server Roles Coexistence When Using DAGs](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx)

Related Help Topics
No resources found.

Related Blog Articles
No resources found.
[Ask a question](http://outlookliveanswers.com/forums)

Related Forum Discussions

* [Ask a question](http://go.microsoft.com/fwlink/?LinkId=163297)

* [Visit the forums](http://go.microsoft.com/fwlink/?LinkID=150026)
* [Exchange 2007](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.80).aspx)
* [Exchange 2010](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.140).aspx)

[[#|![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/ImageSprite.png]]]]
	

# Hub Transport and Mailbox Server Roles Coexistence When Using DAGs

**Exchange 2010**

3 out of 3 rated this helpful \- [Rate this topic](http://technet.microsoft.com/en-us/library/ff699049(v=exchg.141).aspx#feedback)

 

_**Applies to:** Exchange Server 2010 SP3, Exchange Server 2010 SP2_

_**Topic Last Modified:** 2010-07-19_

Microsoft Exchange Server 2007 doesn't support Hub Transport and Mailbox server roles on the same server hardware when high availability features such as single copy cluster (SCC) or cluster continuous replication (CCR) are used. A minimum high availability deployment in Exchange 2007 requires four servers: two nodes for mailbox high availability and two Hub Transport servers for message transfer redundancy.

To reduce the number of servers required to provide a high availability solution, Exchange Server 2010 supports Hub Transport and Mailbox server roles on the same server hardware when using database availability groups (DAGs). Exchange 2010 provides a feature called _shadow redundancy_, which protects against data loss while messages are in transit. When used together, DAGs and shadow redundancy offer a highly resilient messaging infrastructure.

This topic focuses on how the Exchange 2010 Hub Transport server role behaves when deployed on the same server hardware as a Mailbox server that participates in a DAG. To learn more about DAGs, see [Understanding Database Availability Groups](http://technet.microsoft.com/en-us/library/dd979799(v=exchg.141).aspx).

## 
[[#|Message Submission and Delivery]]

Shadow redundancy prevents data loss while messages are in transit by keeping a duplicate copy of the message along the message path. If a message is lost in transit due to a failure, the shadow copy of the message is resubmitted by the Transport component. For detailed information about how shadow redundancy is implemented, see [Understanding Shadow Redundancy](http://technet.microsoft.com/en-us/library/dd351027(v=exchg.141).aspx).

Mailbox servers are involved during initial message submission, when a user clicks **Send**, and during final delivery, when the message is saved to the Inbox of the recipient. When a message is submitted to Transport, the primary copy of that message is in the queues of the Hub Transport server to which the message was submitted. The shadow copy of that message is the item stored in the Sent Items folder of the sender. When a message is delivered, the primary copy is in the recipient's Inbox and the shadow copy of the message is stored in the transport dumpster.

In a high availability scenario where Hub Transport and Mailbox server roles coexist on the same server hardware, it's crucial to try to avoid having both copies of a message reside on the same server. Consider the deployment scenario shown in the following figure. The topology consists of two Exchange servers participating in a DAG with the Hub Transport server role installed. The databases DB1 and DB2 are part of the DAG. Active databases are shown in green, and passive databases are shown in blue.

**Two server high availability topology with Hub Transport and Mailbox server roles**

![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/IC452401.gif]]

In this topology, assume that a user whose mailbox is on DB1 sends a message. If that message is submitted to the Hub Transport server role on Server1, both the primary and shadow messages will be physically stored on Server1. The primary messages will be in the Hub Transport server queues, and the shadow messages will be in the Sent Items folder of the sender, as shown in the following figure.

**Undesirable submission path**

![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/IC452402.gif]]

Similarly, if the Hub Transport server role on Server1 receives a message destined to a user on DB1, the message is delivered directly, and both the primary and shadow messages will be physically stored on Server1. The primary messages will be in the Inbox of the recipient, and the shadow messages will be in the transport dumpster, as shown in the following figure. If a server failure occurs at either of those instances, there's a chance that the message can be lost.

**Undesirable delivery path**

![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/IC452403.gif]]

To avoid these scenarios where message loss can occur, Exchange attempts to submit or deliver messages over a route that ensures that the primary and shadow copies of messages are stored on different physical servers. The modified message submission and delivery behaviors are discussed in the following section.

### 
[[#|Message Submission Behavior]]

When a user whose mailbox is in a database that's a member of a DAG sends a message, the mail submission service gives preference to remote Hub Transport servers if it detects that the Hub Transport server is also installed on the local server. As shown in the figure "Two server high availability topology with Hub Transport and Mailbox server roles", if a user whose mailbox is on DB1 sends a message, the mail submission service will attempt to use the Hub Transport server installed on Server2 for message submission. The following figure shows this preferred message submission path.

**Preferred submission path**

![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/IC452404.gif]]

In the case where no other Hub Transport servers are available in the site (for example, if Server2 is unavailable due to scheduled maintenance), the message submission service will fall back to submitting the message to the local Hub Transport server. Even though this is an undesirable submission path for redundancy, Exchange won't delay delivery of messages. This fallback submission path is desirable for availability and low delivery latency.

### 
[[#|Message Delivery Behavior]]

The message routing and delivery behavior doesn’t change in most cases. For example, if Server1 shown in the figure "Two server high availability topology with Hub Transport and Mailbox server roles" receives a message for a recipient on DB2, it will deliver the message normally because that database is active on a different server. The only scenario when a Hub Transport server will process an incoming message differently is when the target mailbox is on a database that's part of a DAG and is also active on the local server. Because a direct delivery in this situation would result in both the delivered message and the copy in the transport dumpster being on the same server, the Hub Transport server will instead reroute this message to another Hub Transport server within the same site. The following figure shows the message delivery path in this scenario.

**Preferred delivery path**

![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/IC452405.gif]]

In the case where no other Hub Transport servers are available in the site, the Hub Transport server will fall back to local delivery even though it's an undesirable delivery path for redundancy. Again, this fallback delivery path is desirable for availability and low delivery latency.

## 
[[#|Message Flow Scenarios]]

This section explains in detail what happens in various message flow scenarios when Hub Transport and Mailbox server roles coexist on the same server. The topology shown in the following figure is used to illustrate various possible message flow scenarios.

**Sample topology for message flow scenarios**

![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/IC452406.gif]]

The following table shows how the Hub Transport server role on Server1 processes messages in various scenarios. In all of these cases, Server1 is considered the entry point.

| Sender location | Recipient location | Normal message path | High availability scenarios |
| --- | --- | --- | --- |
| DB1, active on Server1 | DB1, active on Server1 | 1. Submission service on Server1 submits a message to the Hub Transport server role on Server2.<br>	<br>2. Hub Transport server role on Server2 delivers the message to DB1 on Server1 and adds the message to the transport dumpster on Server2. | If Server1 fails before the message submission completes, the message in the sender's Outbox may be lost.<br>	<br>		If Server2 fails before the message submission completes, the message is submitted to the Hub Transport server role on Server1.<br>	<br>		If Server1 fails after the message submission to the Hub Transport server role on Server2 completes, DB1 will become active on Server2. The message will be queued on Server2 until DB1 is mounted, and then the Hub Transport server role delivers the message locally.<br>	<br>		If Server2 fails after the message submission to Hub Transport server role on Server2 completes, the shadow message in DB1 is resubmitted to the Hub Transport server role on Server1, which delivers the message locally.<br>	<br>		If Server1 fails after the message delivery is completed, DB1 will become active on Server2. If the delivered message hasn't yet been committed to the database, it's redelivered from the transport dumpster on Server2. |
| DB1, active on Server1 | DB2, active on Server2 | 1. Submission service on Server1 submits the message to the Hub Transport server role on Server2.<br>	<br>2. Hub Transport server role on Server2 reroutes the message to the Hub Transport server role on Server1.<br>	<br>3. Hub Transport server role on Server1 delivers the message to DB2 on Server2 and adds the message to the transport dumpster on Server1. | Any server failures prior to the completion of message submission are handled in the same manner as described in the previous row.<br>	<br>		If Server1 fails after the message submission to the Hub Transport server role on Server2 completes, the Hub Transport server role on Server2 will deliver the message locally.<br>	<br>		If Server2 fails after the message submission to the Hub Transport server role on Server2 completes, DB2 will become active on Server1. After the Hub Transport server role on Server1 detects that the Hub Transport server role on Server2 is unavailable, it will resubmit the shadow message. After DB2 is mounted on Server1, the message will be delivered locally.<br>	<br>		If Server1 fails after the message is rerouted to Server1 for delivery, the Hub Transport server role on Server2 will resubmit the shadow message after it detects the Hub Transport server role on Server1 is unavailable. It will then deliver the message locally.<br>	<br>		If Server2 fails after the message is rerouted to Server1 for delivery, DB2 will become active on Server1. The message will remain queued on Server1 until DB2 is mounted on Server1 and then it's delivered locally.<br>	<br>		If Server2 fails after the message delivery is completed, DB2 will become active on Server1. If the delivered message hasn't yet been committed to the database, it's redelivered from the transport dumpster on Server1. |
| External | DB1, active on Server1 | 1. Hub Transport server role on Server1 reroutes the message to the Hub Transport server role on Server2.<br>	<br>2. Hub Transport server role on Server2 delivers the message to DB1 on Server1 and adds the message to the transport dumpster on Server2. | If Server1 fails before it completes receiving the message from Edge1, Edge1 will attempt delivery to the Hub Transport server role on Server2.<br>	<br>		If Server1 fails after it completes receiving the message from Edge1, Edge1 will resubmit the message to the Hub Transport server role on Server2 after it detects that the Hub Transport server role on Server1 is unavailable. The Hub Transport server role on Server2 will then deliver the message locally after DB1 is mounted on Server2.<br>	<br>		All other failure scenarios are handled in the same manner as described in the first row. |
| External | DB2, active on Server2 | 1. Hub Transport server role on Server1 delivers the message to DB2 on Server2, and adds the message to the transport dumpster on Server1. | If Server1 fails before it completes receiving the message from Edge1, Edge1 will attempt delivery to the Hub Transport server role on Server2.<br>	<br>		If Server1 fails after it completes receiving the message from Edge1, but before delivering to DB2 on Server2, Edge1 will resubmit the shadow message to the Hub Transport server role on Server2. This is because Server1 won't send an acknowledgement to Edge1 until it successfully delivers the message to DB2. Because Edge1 hasn't received an acknowledgement, it will resubmit the message after it detects that Server1 is unavailable.<br>	<br>		If Server2 fails after message delivery is completed, DB2 will become active on Server1. If the delivered message hasn't yet been committed to the database, it's redelivered from the transport dumpster on Server1. |

The preceding table focuses on the minimum scenario where there are only two Hub Transport servers in a site that both coexist with Mailbox server roles that participate in DAGs. In more complex deployments where additional dedicated Hub Transport servers are available, those servers are also used when making routing decisions. However, if you have a large enough deployment where you can employ dedicated Hub Transport servers, it's a best practice to not install the Hub Transport server role on Mailbox servers that participate in a DAG.

 © 2010 Microsoft Corporation. All rights reserved.

Was this page helpful?

Yes
No

## Community Additions

[ADD](http://technet.microsoft.com/en-us/library/community/add/ff699049(v=exchg.141).aspx)

### RE: Surajpa

The scenario you're asking about is described in the first entry in the table above.

[![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/avatar.1.jpg]]](http://social.technet.microsoft.com/profile/jake%20schmidt/)

[Jake Schmidt](http://social.technet.microsoft.com/profile/jake%20schmidt/)
10/29/2012

### Question on Cross Site Dag and Mail routing ??

Hello ,
The Above article is great , But i would like to know that the above scenario talks about Two servers in a DAG in the Same site , does the same Mail routing occur if these two servers for e.g. server1 is in Site A and Server2 is in Site B ??
Kindly let me know
Thanks,
Leon

[![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/avatar.jpg]]](http://social.technet.microsoft.com/profile/leon1093/)

[leon1093](http://social.technet.microsoft.com/profile/leon1093/)
2/12/2012

© 2014 Microsoft

[Manage Your Profile](http://go.microsoft.com/?linkid=8786243)

* [Newsletter](http://technet.microsoft.com/cc543196.aspx)

* |
* [Contact Us](http://technet.microsoft.com/cc512759.aspx)
* |
* [Privacy Statement](http://go.microsoft.com/fwlink/?linkid=248681)
* |
* [Terms of Use](http://technet.microsoft.com/cc300389.aspx)
* |
* [Trademarks](http://www.microsoft.com/About/Legal/EN/US/IntellectualProperty/Trademarks/EN-US.aspx)

|
 [[#| ![[./_resources/Hub_Transport_and_Mailbox_Server_Roles_Coexistence_When_Using_DAGs_Exchange_2010_Help_technet.microsoft.com.resources/ImageSprite.png]]Site Feedback]]
