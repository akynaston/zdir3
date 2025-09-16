# Password Expiry date set to current date in eDirectory after users reset their p

# Password Expiry date set to current date in eDirectory after users reset their passwords in AD Domain

This document **(7001992)** _is provided subject to the [disclaimer](http://www.novell.com/support/viewContent.do?externalId=7001992&sliceId=1#disclaimer) at the end of this document._

### Environment

Identity Manager Active Directory driver
Microsoft Active Directory
Novell eDirectory

### Situation

**Purpose:**
Resetting passwords in Active Directory domain
 
**Symptoms:** 
Password Expiry date set to current date in eDirectory after users resets their passwords in AD Domain

### Resolution

This problem may happen if the driver is setting the password as an Admin rather than the User.  If the GCV 'Publish Passwords to NDS password' is set to true, then the driver will set the password as an Admin user.  This will cause the password to be expired.  Their are two solutions for this issue.

Solution one:
\- Stop the Active Directory driver.
\- Go to the global configuration value tab of the AD driver and make the following modifications.
    - Publish Passwords to NDS password - false
    - Publish Passwords to distribution password - true
\- Save the changes by hitting Apply and OK.
\- Start the driver and change the password of a user in AD and check the same in eDirectory

Solution two:
 - Modify the password policy by checking the setting:  'Do not expire the user's password when the administrator sets the password'

### Document

|     |     |
| --- | --- |
| **Document ID:** | 7001992 |
| **Creation Date:** | 11-23-2008 |
| **Modified Date:** | 01-13-2009 |
| **Novell Product:** | eDirectory |
| **Novell Product:** | Identity Manager |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
