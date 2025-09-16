# Error -125 when logging to iManager or changing password [www.novell.com]

# Error -125 when logging to iManager or changing password

This document **(7003079)** _is provided subject to the [disclaimer](http://www.novell.com/support/viewContent.do?externalId=7003079&sliceId=1#disclaimer) at the end of this document._

### Environment

Novell iManager 2.7
Novell eDirectory 8.8 for Windows 2003

### Situation

When logging to iManager getting error:
(Error -125) An attempt was made to log out of a connection that the user was not logged in to.
When changing password for a user through ConsoleOne getting error:
(Error -125) An attempt was made to log out of a connection that the user was not logged in to.

### Resolution

Some required modules are not loaded in Novell eDirectory Services for Windows.
Check that the following services are running in Novell eDirectory Services console:
dconserv.dlm
ds.dlm
dsloader.dlm
gams.dlm
hconserv.dlm
httpstk.dlm
ncpengine.dlm
niciext.dlm
nmas.dlm
pki.dlm
rollcall.dlm
sasl.dlm
If the required services are not starting automatically, change the startup option from manual to automatic by clicking on Startup button on Services tab.

### Document

|     |     |
| --- | --- |
| **Document ID:** | 7003079 |
| **Creation Date:** | 04-22-2009 |
| **Modified Date:** | 04-22-2009 |
| **Novell Product:** | eDirectory |
| **Novell Product:** | iManager |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
