# Support | How to Manually uninstall IDM (Dirxml) Plugins on iManager 2.5 [www.novell.com]

# How to Manually uninstall IDM (Dirxml) Plugins on iManager 2.5

This document **(3622510)** _is provided subject to the [disclaimer](http://www.novell.com/support/kb/doc.php?id=3622510#disclaimer) at the end of this document._

### Environment

Novell iManager 2.5
Nsure Identity Manager 2.0.x

### Situation

Error "The system encountered an unknown error. Please contact Novell Support." while selecting a Dirxml task
Error "A system error occurred." while selecting a Dirxml task
Unable to uninstall Dirxml Plugins
How to Manually uninstall IDM (Dirxml) Plugins on iManager 2.5

### Resolution

This document contains instructions for both OES Linux and OES Netware. It contains generic information such as "stop tomcat" or %Tomcat\_Home%. The following section clarifies what these mean on both the Linux and Netware Platforms.

Netware Specific Commands:

Stop Tomcat- type "TC4STOP" at the system console

Start Tomcat- type "TOMCAT4" at the system console

OES Linux Specifc Commands:

Stop Tomcat- type "/etc/init.d/novell-tomcat4 stop" at a shell prompt

Start Tomcat- type "/etc/init.d/novell-tomcat4 start" at a shell prompt

In this document, %Tomcat\_Home% means:

/var/opt/novell/tomcat4/webapps/ on **OES****Linux**

Sys:\\Tomcat\\4\\webapps on **Netware**

Stop Tomcat. Then delete the files and directories stated below. (NOTE: You probably will not have all the files and directories. Just delete what you have. This a compilation of old and new Dirxml plugins....so depending on what has been installed, you probably will not see all the files and directories).
Delete the following NPMs from the %Tomcat\_Home%\\nps\\packages directory
ADLink.npm
Approvalflow.npm
CredProv.NPM
DirxmlCommon.npm
DirxmlFilter.npm
DirxmlInfo.npm
DirxmlOverview.npm
DirxmlPermit.npm
DirxmlRules.npm
DirxmlScript.npm
dsp.npm
DWiz.npm
entitlement.npm
eProvConsole.npm
ForgottenPassword.npm
notconfig.npm
Nsure\_Identity\_Manager\_2.0.2Plugins.npm
PlatformAdministration.npm
pwdpolicy.npm
pwsyncconfig.npm
SecretStore.npm
StatusLog.npm
UserProfile.npm
Delete the following directories from %Tomcat\_Home%\\nps\\portal\\modules
ADLink
ApprovalFLow
CredProv
Dirxml
DirxmlCommon
DirxmlFilter
DirxmlInfo
DirxmlPermit
DirxmlRules
DirxmlScript
dsp
DWiz
eProv
ForgottenPassword
notconfig
pwdpolicy
pwssyncconfig
SecretStore
StatusLog
UserProfile
Delete the following directories from %Tomcat\_Home%\\nps\\WEB-INF\\modules
ADLink
ApprovalFlow

CredProv
Dirxml
DirxmlCommon
DirxmlFilter
DirxmlInfo
DirxmlPermit
DirxmlRules
DirxmlScript
dsp
DWiz
eProv
ForgottenPassword
notconfig
nsure\_identity\_manager\_plugins
PlatformAdministrationModule
pwdpolicy
pwsyncconfig
SecretStore
StatusLog
UserProfile
Delete the following directories from %Tomcat\_Home%\\nps\\UninstallerData
Uninstall\_ADLink
Uninstall\_ApprovalFlow
Uninstall\_CredPrev
Uninstall\_DirxmlCommon
Uninstall\_DirxmlFilter
Uninstall\_DirxmlInfo
Uninstall\_DirxmlOverview
Uninstall\_DirxmlPermit
Uninstall\_DirxmlRules
Uninstall\_DirxmlScript
Uninstall\_dsp
Uninstall\_DWiz
Uninstall\_entitlement
Uninstall\_eProvConsole
Uninstall\_ForgottenPassword
Uninstall\_notconfig
Uninstall\_Nsure\_Identity\_Manager\_2.0.2\_Plugins
Uninstall\_PlatformAdministration
Uninstall\_pwdpolicy
Uninstall\_pwsyncconfig
Uninstall\_SecretStore
Uninstall\_StatusLog
Uninstall\_UserProfile
Start Tomcat. Log into iManager. Go to Configure (icon of man behind desk) and select Module Installation | Available Novell Plug-in Modules | New | browse to the NSure\_Identity\_Manager\_xxx\_Plugins.npm. Once the npm is copied to the server, select the checkbox and Install. Once installed you will need to stop Tomcat and restart it. Log back into iManager. If you are running RBS, then you will need to update your collection: Configure | Role Based Services | RBS Configuration | Not Installed | Select the Dirxml/Identify Management and install. Once completed, you should now have the Dirxml and Dirxml Utilities Roles.

### Additional Information

Upgraded from iManager 2.0.2 to iManager 2.5
Formerly known as TID# 10097190
Formerly known as TID# NOVL101612

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.
