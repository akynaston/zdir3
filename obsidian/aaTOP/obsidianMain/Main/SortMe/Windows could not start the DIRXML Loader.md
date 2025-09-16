# Windows could not start the DIRXML Loader

# Windows could not start the DIRXML Loader

# I just got this error: server could not set parameter: INVALID\_PARMATER - I think this page says that it's ok . . can't tell yet.

This document **(7003415)** _is provided subject to the [disclaimer](http://www.novell.com/support/viewContent.do?externalId=7003415&sliceId=1#disclaimer) at the end of this document._

### Environment

Microsoft Windows Server 2003 Standard Edition
Novell Identity Manager - Remote Loader
Novell Identity Manager 3.5.1
Novell Identity Manager 3.6

### Situation

In order to be able to provision Exchange 2000 and 2003 accounts, if the driver is running on a member server, you must run the Remote Loader service as a specific domain user with enough rights to delete, create, or move Exchange accounts.
When starting the remote loader from the Services console, getting error:
"Windows could not start the DIRXML loader: C:\\Novell\\RemoteLoader\\ADDriver.dll command: 8000 on Local Computer. For more information, review the System Event log. If this is a non-Microsoft server, contact the service vendor, and refer to service-specific error code 1."
![[./_resources/Windows_could_not_start_the_DIRXML_Loader.resources/cropped-20error.jpg]]
Remote loader instance does not start.

### Resolution

By default, remote loader runs as a Local System account. When changing the settings to run Remote Loader a different user, make sure the new user is a member of a builtin Administrators group.

### Additional Information

After configuring Remote Loader to run as a different user than the Local System account, following problems may occur:
1\. When modifying Remote Driver Configuration you will get an error:
"Service Modification Failed: INVALID\_PARAMETER"
The new settings will take effect regardless of the error.
2\. Trace screen will not come up, the trace will only be saved in the file.

### Document

|     |     |
| --- | --- |
| **Document ID:** | 7003415 |
| **Creation Date:** | 06-01-2009 |
| **Modified Date:** | 06-03-2009 |
| **Novell Product:** | Identity Manager |

### Disclaimer
