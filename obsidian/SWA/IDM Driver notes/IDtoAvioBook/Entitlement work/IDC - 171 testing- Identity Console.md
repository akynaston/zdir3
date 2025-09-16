6/13/2024 11:57:12 AM
6/13/2024 11:34:40 AM
IDC notes:
 - ran configure.bat first, password for keys.pfx; added 'trivir'-
 - then error: ccswx64.dll missing . .?
   - installed the NICI_wx64.msi
  - nici install failed:

![[Pasted image 20240613115757.png]]


I re-ran the installer, I think I had clicked no to the 'admin request' to do this portion, it is now installed,
- restarting idc:
	- ran configure.bat again
	- sayd it didn't find my file . .
	- running identity_consol.eexe instead
	- nope: run.bat!! starts edirapi
![[Pasted image 20240613120025.png]]
found configure.bat doesn't create keys.pfx - you have to create them . .version 1.7.2 may create them I see on docs :
https://www.netiq.com/documentation/identity-console/pdfdoc/identity_console-install/identity_console-install.pdf

points at this:

https://www.netiq.com/documentation/edirectory-92/edir_admin/data/b1j4tpo3.html#b1j4u0cm

Found that 1.7.2. may do the keys.pfx creation for me; so got that now;
put under: C:\workarchive\IDC172
* running configure.bat.
* nope; stoped: added to git repo - it's 967 GB . .
* configure.bat still looking for keys.pfx 
* just running run .bat
*

![[Pasted image 20240613125757.png]]

* had to run IDC172/eDirAPI/get_cacert.exe (ip of dest )
* put the cert per the pdf above


had to run get server ert:
```

C:\workArchive\IDC172\eDirAPI>get_servercert.exe help
---------------------
Arguments
1 Enter the eDirectory server IP Address with LDAP port number(Ex: 10.10.10.10:636)
2 Enter the eDirectory username(Ex: cn=admin,ou=sa,o=system)
3 Enter the eDirectory/Identity Vault password
4 Enter the server certificate name
5 Enter the server certificate password
6 Enter the Trusted-root certificate path
---------------------

C:\workArchive\IDC172\eDirAPI>get_servercert.exe 10.10.10:1636 cn=x266698,ou=admins,o=swaiddev C00lB34ns!11 IdentityConsole172Cert swaswa cert\SSCert.pem
LDAP Result Code 200 "Network Error": dial tcp: lookup 10.10.10: no such host

C:\workArchive\IDC172\eDirAPI>get_servercert.exe 10.133.51.164:1636 cn=x266698,ou=admins,o=swaiddev C00lB34ns!11 IdentityConsole172Cert swaswa cert\SSCert.pem
LDAP Result Code 200 "Network Error": tls: failed to verify certificate: x509: cannot validate certificate for 10.133.51.164 because it doesn't contain any IP SANs

C:\workArchive\IDC172\eDirAPI>get_servercert.exe w11dcledirdi019:1636 cn=x266698,ou=admins,o=swaiddev C00lB34ns!11 IdentityConsole172Cert swaswa cert\SSCert.pem
LDAP Result Code 200 "Network Error": tls: failed to verify certificate: x509: certificate is valid for diridvua.cis.dev.swacorp.com, cis-diridvua.glb.dev.swacorp.com, diridvuadc1.cis.dev.w11.swacorp.com, diridvuadc2.cis.dev.w11.swacorp.com, w11dcledirdi019.swacorp.com, w11dcledirdi020.swacorp.com, not w11dcledirdi019

C:\workArchive\IDC172\eDirAPI>get_servercert.exe w11dcledirdi019.swacorp.com:1636 cn=x266698,ou=admins,o=swaiddev C00lB34ns!11 IdentityConsole172Cert swaswa cert\SSCert.pem
LDAP Result Code 49 "Invalid Credentials": NDS error: failed authentication (-669)

C:\workArchive\IDC172\eDirAPI>get_servercert.exe w11dcledirdi019.swacorp.com:1636 cn=ax266698,ou=admins,o=swaiddev C00lB34ns!11 IdentityConsole172Cert swaswa SSCert.pem

C:\workArchive\IDC172\eDirAPI>
```


6/13/2024 1:36:56 PM
Gave up on this: keys.pfx genreated is 0 bytes no matter what I give to get_Serversceriticates . . .
just using ldap for now.


6/13/2024 1:50:41 PM
Got IDC in dev from Robert Wiggington - but may not be able to use . .can't use IDM4 entitlements . .can't createnew eittlements through drive rpage.
https://w11dcledirac001.swacorp.com:9010/identityconsole/#/roleBasedEntitlements



![[Pasted image 20240613135034.png]]

This may be a workaround to specify use legacy entitements
https://support.microfocus.com/kb/doc.php?id=7016893

but out of time for now . .


cool:
can clear editor lock! delete DirXML-SPUIEditorLock!
![[Pasted image 20240613135531.png]]

useful links from Rob wiggington:

[1:57 PM] Robert Wigginton

cool! here's an old explanation on entitlement formats:

[https://www.netiq.com/documentation/identity-manager-47/entitlements/data/identity-manager-supported-entitlement-formats.html](https://www.netiq.com/documentation/identity-manager-47/entitlements/data/identity-manager-supported-entitlement-formats.html "https://www.netiq.com/documentation/identity-manager-47/entitlements/data/identity-manager-supported-entitlement-formats.html")

Entitlements Formats - NetIQ Identity Manager Entitlements Guide

[1:58 PM] Robert Wigginton

and the 48 text:

[https://www.netiq.com/documentation/identity-manager-48/entitlements/data/identity-manager-supported-entitlement-formats.html](https://www.netiq.com/documentation/identity-manager-48/entitlements/data/identity-manager-supported-entitlement-formats.html "https://www.netiq.com/documentation/identity-manager-48/entitlements/data/identity-manager-supported-entitlement-formats.html")

Entitlements Formats - NetIQ Identity Manager Entitlements Guide[1:59 PM] Robert Wigginton

here's the details:

[https://www.netiq.com/documentation/identity-manager-48/entitlements/data/identity-manager-entitlement-formats.html](https://www.netiq.com/documentation/identity-manager-48/entitlements/data/identity-manager-entitlement-formats.html "https://www.netiq.com/documentation/identity-manager-48/entitlements/data/identity-manager-entitlement-formats.html")

Understanding Identity Manager 4.0 and Later Entitlement Formats - NetIQ Identity Manager Entitlements Guide