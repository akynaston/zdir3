# -701 FFFFFD43 SYNCHRONIZATION DISABLED [www.novell.com]

**\-701 FFFFFD43 SYNCHRONIZATION DISABLED**

**Source**

NDS® or Novell® eDirectoryTM

**Explanation**

An attempt was made by the NDS or eDirectory Replica Synchronization process to start synchronization with the target server while the target server's inbound NDS or eDirectory Replica Synchronization is disabled.

**Warning:** Applying all solutions mentioned in this topic could make the problem worse if the actual cause of the problem is not known. Before following a course of action, make sure that you understand the cause of the error and the consequences for the actions suggested.

**Possible Cause**

This error could occur if an attempt is made to initiate inbound NDS or eDirectory Replica Synchronization while the process is disabled on the target server. The following message will appear if the target server is using DSTRACE with the Synchronization and Inbound flags set:

\*SKULKER: SYNCHRONIZATION DISABLED

**Action**

Enable inbound replica synchronization using the command, SET DSTRACE = !S1.

**Possible Cause**

An attempt was made to audit NDS or eDirectory on a server whose auditing is not open.

**Action**

Disable or enable auditing from an appropriate container or server.

**Possible Cause**

This error could occur if an attempt is made to initiate an outbound NDS or eDirectory Replica Synchronization while the process is disabled on the source server.

This will result in the following DSTRACE message if the source server is using DSTRACE with the Minimum or Synchronization flags set:

SYNC: SYNCHRONIZATION DISABLED

**Action**

Enable outbound replica synchronization using the command, SET DSTRACE = !S1.

A trademark symbol (®, TM, etc.) denotes a Novell trademark. An asterisk (\*) denotes a third-party trademark. For information on trademarks, see [Legal Notices](http://www.novell.com/documentation/nwec/nwec_enu/nwec_trademarks.html).

[Error Codes Contents](http://www.novell.com/../index.html)
