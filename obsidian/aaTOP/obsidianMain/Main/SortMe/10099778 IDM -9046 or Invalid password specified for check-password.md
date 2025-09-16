# 10099778: IDM -9046 or Invalid password specified for check-password

# IDM -9046 or Invalid password specified for check-password

## (Last modified: 24Mar2006)

This document (**10099778**) _is provided subject to the [disclaimer](http://support.novell.com/docs/Tids/Solutions/10099778.html#disclaimer) at the end of this document._

### goal

IDM -9046 or Invalid password specified for check-password

### fact

Identity Manager

IDM

DirXML

iManager

### symptom

"This check-password result is expected. It is the result of the shim verifying that the driver object password is non-empty. Code(-9046) Invalid password specified for check-password."

"<status level="fatal" type="app-authentication">handshake failed: missing password</status>"

### cause

Some password/cryptography/authentication related data is incorrect or inconsistant on the driver object. As convinced as you might be that you cleared it all out, the steps below are required to clear it out properly. Please try the FIX steps, in order.
Customer tried...various procedures several times over a few days, with the exception of step (4) and not always step (2). Carried out step (2) in isolation several times.
Inspected the driver configurations to confirm that the certificate wizard had re-entered the certificate references to the Authentication ID fields of the drivers.
Finally started up both drivers. As before, the one driver started but failed to establish a connection with the other driver. The other driver failed to start, giving the -9005 error and message about a password missing, as before.
Added the same password to both the Driver Object Password and Application Password fields of both drivers. Did this several times over last few days anyway. However, on this occasion the drivers started synchronising data between the two directories.

### fix

1) Stop the IDM drivers.
2) Remove the passwords from the drivers.
3) Delete the certificates used by the drivers.
4) Delete the Authentication ID entry (referring to the certificates) from the drivers.
5) Use the Certificate Wizard to create new certificates.

### document

|     |     |
| --- | --- |
| **Document Title:** | IDM -9046 or Invalid password specified for check-password |
| **Document ID:** | 10099778 |
| **Solution ID:** | NOVL104374 |
| **Creation Date:** | 28Nov2005 |
| **Modified Date:** | 24Mar2006 |
| **Novell Product Class:** | DirXML |

### disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
