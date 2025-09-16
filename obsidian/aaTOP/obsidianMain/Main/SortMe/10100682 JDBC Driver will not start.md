# 10100682: JDBC Driver will not start

# JDBC Driver will not start

## (Last modified: 08Mar2006)

This document (**10100682**) _is provided subject to the [disclaimer](http://support.novell.com/docs/Tids/Solutions/10100682.html#disclaimer) at the end of this document._

### fact

Nsure Identity Manager 2.0

Novell JDBC Driver

### symptom

JDBC Driver will not start

JDBC exception thrown No suitable Driver found

### cause

In this case the classpath had not been set for the location of the ojdbc14.jar files so when the driver would attempt to start it could not find all the .jar/classes for the java driver.

### fix

Set the classpath to the location fot he ojdbc14.jar file.

Linux:

export CLASSPATH=$CLASSPATH:/path/to/driver files

Windows:

set CLASSPATH=%CLASSPATH%;C:\\path\\to\\files\\

### note

DirXML Log Event -------------------
Driver: \\AISD-IDVDEV\\aisd\\services\\IDM\\IDVDEV-DriverSet\\Consolidated-Database
Status: Error
Message: <description>Unable to connect. There is a connectivity-related problem.</description>
<jdbc:exception jdbc:class="java.sql.SQLException" jdbc:error-code="0" jdbc:sql-state="08001" xmlns:jdbc="urn:dirxml:jdbc">
<jdbc:message>No suitable driver</jdbc:message>
</jdbc:exception>
<jdbc:document xmlns:jdbc="urn:dirxml:jdbc">

### document

|     |     |
| --- | --- |
| **Document Title:** | JDBC Driver will not start |
| **Document ID:** | 10100682 |
| **Solution ID:** | NOVL105391 |
| **Creation Date:** | 08Mar2006 |
| **Modified Date:** | 08Mar2006 |
| **Novell Product Class:** | DirXML |

### disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
