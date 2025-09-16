10/25/2024 4:04:09 PM
Just vlaidated the below with Ruben, and it worked.

5/7/2024 1:07:23 PM - had to use this just now:
 ./driver.sh -h w11dcledirdi013.swacorp.com -t 1636 -u cn=ax266698,ou=admins,o=swaiddev -p 'password' dxcmdConnect
 ./driver.sh -h hdqqcledirqi010.swacorp.com -t 1636 -u cn=ax266698,ou=admins,o=swaiddev -p 'password' dxcmdConnect


error: 1208352771 - seems to be dxcmd.keystor already exists

Odd error
 ./driver.sh -h w11qcledirqi010.swacorp.com -t 1636 -u cn=ax266698,ou=admins,o=swa-idsat -p 'password!' dxcmdConnect

> Configure project :
Gradle Version: Gradle 8.6
Groovy Version: 3.0.17
Java Location: C:\Users\x266698\.jdks\azul-1.8.0_382
Using IGA Standard: 2.3.4

> Task :dxcmdConnect
Command Failed.  Status: 1208352771