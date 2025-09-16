# How do I move the Organizational CA to another server? [www.novell.com]

# Note: this process doesn't mention the CRL.  IMporting a new CA will create a new CRL, so ensure that any previous revoked certificate configuration items are brought over

The CRL file path on edir/windows are:
     C:\\novell\\nds\\htdoc\\crl\\
     /var/opt/novell/eDirectory/data/nds-http/crl

Also, the "CRL object in the tree is not deleted/recreated when you reimport the Ca.

# 

# How do I move the Organizational CA to another server?

This document **(3618399)** _is provided subject to the [disclaimer](http://www.novell.com/support/#disclaimer) at the end of this document._

### Environment

Novell Open Enterprise Server
Novell NetWare 6.5
Novell NetWare 6.0
Novell Small Business Suite 6.0
Novell NetWare 5.1
Novell NetWare 5.0
Novell Small Business Suite 5.1
Novell Small Business Suite 5.0
Novell eDirectory 8.8 for All Platforms
Novell Open Enterprise Server 2 (OES 2) Linux Support Pack 3

### Situation

\- Directory services removed from server that holds the CA (Certificate Authority).
\- Server crashed and CA was damaged or corrupted.
\- Planning on removing the server holding the Certificate Authority from the tree and want to move it to another server.
\- How do I move the Organizational CA to another server?

### Resolution

**Option I. If the server is up and running, and if the Certificate authority was created with Certificate Server version 2.0 or later, AND your Certificate Authority Server is still up and running or you have a export of your Certificate Authority's Self Signed Certificate with the private key, you can export the certificate of the current server and import it on a new server.**
This is easy to tell under what version of Certificate Server was created, as you can try to export it, and if you don't have the option to export the Self Signed Certificate with a private key, it is non exportable and you will need to follow option II below.
To do so do the following.

1\. In iManager, Directory Administration Role, select Modify Object and browse to the Certificate Authority object for your tree which is under the Security Container at the top of the tree. Then select the Certificates tab, check the Self Signed Certificate and select export

![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.4.jpeg]]

Make sure Export Private Key is checked, put in a password, and remember it as you will not be able to import the key without that password, and click next

![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.8.jpeg]]

Click on the "Save the exported certificate" link and save the export to any location on your local computer. Then close the and exit out of modifying your Certificate Authority object.

![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.3.jpeg]]

2\. Delete your existing Certificate Authority in the tree. This can be done under the Directory Administration role, Delete Object task. Select your Certificate Authority object and delete it.

3\. Now create a new Certificate Authority object. This is done under the Novell Certificate Server role, by selecting configure Certificate Authority. Then browse and select the server you want to be the new TREE CA Server, and give it a name. This can be any name but was originally called "<treename> CA" by default.  Then **select Import as the Creation Method** and click Next to continue.

![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.6.jpeg]]

Next browse out and and select the pfx file you exported in step 1 above, and enter the password, then click OK.
![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.7.jpeg]]

Then select Next to continue.
![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.1.jpeg]]

And finally Finish to create your Tree CA object.
![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.jpeg]]

And OK to exit. If you view the properties of this certificate just created, it will have the same key, along with the same Effective and Expiration date as the original Certificate Authority object.

The move of your CA to another server is complete.

NOTE: It is now recommended to save the exported certificate you just created above it in a secure location in case the server crashes. Remember to save the password for the exported certificate as well or you will not be able to import in disaster recovery.

**Option II. If the server is up and running, and if the Certificate authority was created prior to Certificate Server version 2.0, or your Certificate Server is NOT up and running and you do not have an export of your Certificate Authorities Self Signed Certificate, you CANNOT export the certificate off the current server and import it on a new server.**
You will have to delete and recreate your Certificate Authority object and update all certificates in your tree with the new Certificate information from the new Certificate Authority object.
To move an Organizational CA to another server, you must:
1\. Delete the Organizational CA object.
NOTE: Deleting the Organizational CA object will not invalidate any certificates that have been signed by the Organizational CA, such as the Certificates (Key Material Objects) created for each of your servers. They will continue to function until they expire. However, you will not be able to install new servers into the tree or issue new certificates until you delete and create a new Certificate Authority.

2\. Delete all user certificates (stored in user objects) that were signed by the Organizational CA.
NOTE: User certificates signed by external CAs imported into your tree like VeriSign do not need to be deleted.
3\. Create a new Certificate Authority object. This is done in iManager under the Novell Certificate Server role, by selecting configure Certificate Authority. Then browse and select the server you want to be the new TREE CA Server, and give it a name. This can be any name but was originally called "<treename> CA" by default. Then leave Standard selected as the Creation method and click next to continue.
![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.2.jpeg]]
Click Finished on the summary screen to complete the your Certificate Authority creation.
![[./_resources/How_do_I_move_the_Organizational_CA_to_another_server_www.novell.com.resources/unknown_filename.5.jpeg]]
And OK to exit.
NOTE: It is now recommended to export a copy of the new Certificate you created above and save it in a secure location in case the server crashes.  Remember to save the password for the exported certificate as well or you will not be able to import in disaster recovery.  Follow the steps in Option I to export the certificate.

4\. Next you will need to update certificates associated with each server in the tree. This is done by running iManager | Novell Certificate Server | Repair Default Certificates, or PKIDIAG (on NetWare) for each of the servers and rebooting them.

NOTE: PKIDIAG will update the certificate information for the SSL Certificate DNS, and SSL Certificate IP objects associated with your servers. The IP AG certificate for your server, which is created by default during a server install, will not be updated. That certificate was created but not used for any purpose (by default) and can simply be deleted. Other Certificates you create manually, or for other purposes, such as through the Novell Identity Manager eDirectory Driver Certificate Wizard, will not be updated as well, you will need to delete them and create them as needed to get the new certificate information from your newly created Certificate Authority object.

NOTE: Server certificates that have been signed by an external CA such as VeriSign will continue to be valid and do not need to be replaced. 
You will then need to reboot your servers for these certificates to be used by services such as ldap or tomcat / apache.

NOTE: Some services, such as Tomcat, may require you to import the current certificate into the application. tckeygen.ncf can be used to do this for Tomcat, and other services may require additional steps.
Delete and create any custom certificates you have created and use besides the SSL Certificate DNS, and SSL Certificate IP certificates.

The corresponding Linux command that accomplishes the same functionality as PKIDIAG is "ndsconfig upgrade", which can be executed as root. The Server certificates must be deleted prior to running ndsconfig upgrade.   ndsconfig upgrade will recreate the server certificates.

There is no corresponding utility for eDirectory on Windows. You will need to manually delete and recreate your certificates for windows servers, or use the recommended iManager Repair Default Certificates task.

5\. Tell all users who have imported the Organizational CA's certificate into their browsers as a trusted root to delete the certificate. Replace this certificate with the self-signed certificate of the new Organizational CA.
6\. Make sure that all services that use certificates, are configured to use the new certificates created in step 5. The most common services are LDAP, Portal Server, Web Server, and Border Manager. However, there may be others. Because the SSL Certificate DNS and SSL Certificate IP were simply Rekeyed, and not deleted and recreated on NetWare and Linux Servers. Services using these certificates should not be affected. However if you have to delete a certificate and recreate it, the service may be affected, and may need to be relinked to the certificate.
7\. Recreate user certificates as desired.

### Additional Information

\*NOTE:\* The Organizational CA's private key is encrypted in a NICI-provided, server-specific key. A server-specific key is known only to the server that created it and cannot be shared with other servers. Therefore, encrypting the CA's private key in a server-specific key ensures that only one server can act as the CA. It also makes it difficult to move the CA from one server to another.

\*NOTE:\* Currently, there is no utility which can migrate the CA's private key from one server to another server. Please read the entire section for moving an Organizational CA to another server before attempting this procedure.

Formerly known as TID# 10060118

### Change Log

March 4, 2011 - Fixed some typos and added minor clarifications.

### Document

|     |     |
| --- | --- |
| **Document ID:** | 3618399 |
| **Creation Date:** | 03-01-2007 |
| **Modified Date:** | 04-21-2011 |
| **Novell Product:** | eDirectory |
| **Novell Product:** | NetWare |
| **Novell Product:** | Open Enterprise Server |
| **Novell Product:** | SUSE Linux Enterprise Server |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
