# Replacing default certificates in iManager 2.7 (non-OES install) [www.novell.com]

# Replacing default certificates in iManager 2.7 (non-OES install)

This document **(3092268)** _is provided subject to the [disclaimer](http://www.novell.com/support/#disclaimer) at the end of this document._

### Environment

Novell iManager 2.7
Novell eDirectory 8.8 for Linux
SUSE Linux Enterprise Server 10
Novell Certificate Server (PKIS)

### Situation

**Background:**
When iManager 2.7 is installed on a Linux server (non-OES) Tomcat5 web service is used for HTTP\\HTTPs . This service uses two sets of certificates for securing two different types of ssl traffic. This TID discusses the second type of certificate (Tomcat certificate) described below.

**1\. LDAP Certificate**
This secures the backend traffic between these two services. By default, when a user logs in, iManager will create a secure LDAP connection to eDirectory. First it will try the the JVM keystore. If that fails it tries the iManager specific keystore located in /var/opt/novell/iManager/nps/WEB-INF/iMKS. Using the default settings, iManager populates this keystore on-the-fly by importing the eDirectory Root CA certificate. (This behavior can be changed via the /var/opt/novell/iManager/nps/WEB-INF/config.xml file.)
For more information please see the following:
<http://support.novell.com/cgi-bin/search/searchtid.cgi?/10098346.htm>
<http://http://www.novell.com/documentation/imanager26/index.html>

**2.****Tomcat certificate.**
A second certificate and keystore are used for secure HTTPS traffic between a client web browser and iManager's Tomcat service. This is the certificate that must be accepted by all client browsers connecting to iManager. By default, a temporary non-CA signed certificate is generated during the installation of iManager. It is not signed and has a CN of Temporary Certificate and an expiration date of one year. It is recommended to replace this certificate as soon as possible prior to its expiration. Moreover, when configuring iChain to authenticate to iManager a certificate chained to a CA must be used or the iChain to iManager authentication will fail.

There are 3 options to replace the Temporary Certificate for iManager and Tomcat. They are:

1\. Generate a public and private key within eDirectory using Novell Certificate Server.
2\. Generate a public and private key with the Tomcat keystore utility and have Novell Certificate Server sign the certificate.
3\. Buy a signed server certificate from one of the many certificate vendors.
(Instructions on how to use 3rd party certificates vary. Please refer to the specific vendor website for more information.)

### Resolution

The remainder of this document will discuss option 1 (Generate a public and private key within eDirectory using Novell Certificate Server)
Novell Certificate Server is a robust solution that securely generates, tracks, stores and revokes certificates with no further investment. A brief overview of the steps include: create the keypair in eDirectory and export the Public, Private and Root CA keys via a PKCS#12 file onto the Linux file system and modify Tomcat's server.xml configuration file in order to use the PKCS12 directive and point the configuration to an actual P12 file.
File Locations:
The temporary keypair is held in the/var/opt/novell/novlwww/.keystore file.
The file for configuring Tomcat's use of certificates is /etc/opt/novell/tomcat5/server.xml
Below are the steps to replace the Temporary Certificate with an eDirectory certificate:
1.Create a new Server Certificate.
Login to iManager and select the Novell Certificate Server role | Create Server Certificate - Select server and choose a Nickname | Next | Finish
2\. Export the Server Certificate to the tomcat home directory (/var/opt/novell/novlwww).
Login to iManager and select the Directory Administration role | Modify Object | Browse to and select the Server Certificate (created in step 1) | Select the Certificates Tab | Select the Certificate and select Export | Select the Server Certificate from the drop down menu (select the Certificate created in step 1) | Also verify "Export private key" is selected and enter a password (For demonstration purposes, we will use the password of "changeit" | Next | Click "Save the exported certificate" link and save the file to the /var/opt/novell/novlwww/ directory where iManager is installed.
3.Convert the pkcs12 (pfx) file to a PEM file.
nts32:/var/opt/novell/novlwww # **openssl pkcs12 -in cert.pfx -out cert.pem**
**Enter Import Password:**
Input the password used in step 2. (step 2 used "changeit")
**MAC verified OK**
Once the password is verified, you will be prompted to enter a new password to protect the new PEM file. You can use the same password, or a different password, if desired. This new password is used to protect the private key.
**Enter PEM pass phrase:**
**Verifying - Enter PEM pass phrase:**
4.Convert the PEM file to a P12 file.
nts32:/var/opt/novell/novlwww # **openssl pkcs12 -export -in cert.pem -out cert.p12 -name "nts32-iManager"**
**Enter pass phrase for cert.pem:**
**Enter Export Password:**
**Verifying - Enter Export Password:**
The "pass phrase" for cert.pem is the password used in Step 3. When prompted to "Enter Export Password" **you must use use the password "changeit** ". Tomcat will use this password by default. The certificate is secure due to its directory location.
5.Stop Tomcat
/etc/init.d/novell-tomcat5 stop
6.Edit the tomcat configuration file /etc/opt/novell/tomcat5/server.xml
Tomcat5 (iManager 2.7)
maxThreads="150" minSpareThreads="25" maxSpareThreads="75"
enableLookups="false" disableUploadTimeout="true"
acceptCount="100" debug="0" scheme="https" secure="true"
clientAuth="false" sslProtocol="TLS" **keystoreType="PKCS12" keystoreFile="/var/opt/novell/novlwww/cert.p12**"/>
Tomcat4 (for iManager 2.6)
\-
port="8443" minProcessors="5" maxProcessors="75" enableLookups="true"
acceptCount="100" debug="0" scheme="https" secure="true"
useURIValidationHack="false" disableUploadTimeout="true">
clientAuth="false" protocol="TLS"**keystoreType="PKCS12"**
**keystoreFile="/var/opt/novell/novlwww/cert.p12"**/>

Add the **bold statements** regarding keystoreType and keystoreFile substituting in the applicable p12 filename.
NOTE: When the keystore type is changed to PKCS12 you must specify the entire path as Tomcat will no longer default to using the Tomcat home path.
7.Change the P12 file ownership to novlwww and permissions to user=rw, group=rw and others=r.
nts32:/var/opt/novell/novlwww # **chown novlwww cert.p12**
nts32:/var/opt/novell/novlwww # **chmod 654 cert.p12**
8\. Restart Tomcat
nts32:/var/opt/novell/novlwww # **/etc/init.d/novell-tomcat5 start**
9\. Open a web browser and go to https://ip\_address:8443/nps/iManager.html
When connecting to iManager and selecting to view the certificate during the Security Alert dialog, one can see that the subject name is the server's name, the certificate has a two year expiration and there exists a Certification Path up to the tree's Organizational CA.
If there are any problems look for error messages in **/var/opt/novell/tomcat5/logs/catalina.out**

[![[./_resources/Replacing_default_certificates_in_iManager_2.7_(non-OES_install)_www.novell.com.resources/unknown_filename.gif]]](http://www.youtube.com/watch?v=lKVelISwyIk)

[+ Advanced eDirectory Troubleshooting](http://www.youtube.com/watch?v=lKVelISwyIk)

### Document

|     |     |
| --- | --- |
| **Document ID:** | 3092268 |
| **Creation Date:** | 10-11-2007 |
| **Modified Date:** | 10-15-2009 |
| **Novell Product:** | eDirectory |
| **Novell Product:** | PKIS (Novell Certificate Server) |
| **Novell Product:** | SUSE Linux Enterprise Server |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
