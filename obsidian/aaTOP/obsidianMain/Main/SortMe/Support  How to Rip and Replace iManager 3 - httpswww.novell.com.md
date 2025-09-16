# Support | How to Rip and Replace iManager 3 - https://www.novell.com/

# How to Rip and Replace iManager 3

This document **(7017751)** _is provided subject to the [disclaimer](https://www.novell.com/support/kb/doc.php?id=7017751#disclaimer) at the end of this document._

### Environment

NetIQ iManager 3.x

### Situation

888 plugins showing as available.
Getting the following error when attempting to login to iManager:
Unable to create AdminNamespace.
java.lang.NoClassDefFoundError: novell/jclient/JCException

### Resolution

Sometimes, due to time constraints, a broken iManager installation can be more easily resolved by completely removing then reinstalling iManager and its components.  Steps are below:
1\. Uninstall iManager 3.x
cd /var/opt/novell/iManager/nps/UninstallerData
./UninstalliManager
2\. After uninstalling iManager the following directories must be removed
\- /var/opt/novell/iManager
\- /var/opt/novell/novlwww
\- /var/opt/novell/tomcat8
\- /etc/opt/novell/iManager
\- /etc/opt/novell/tomcat8
\- /opt/novell/iManager
\- /opt/novell/tomcat8
3\. Uninstall the following rpms if they remain:
novell-plugin-base
novell-imanager-3
novell-plugin-base
novell-tomcat
4\. Reinstall iManager.

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7017751_

* **Creation Date:**20-JUN-16
* **Modified Date:**20-JUN-16

* **NetIQ**iManager

Did this document solve your problem? [[#|Provide Feedback]]
