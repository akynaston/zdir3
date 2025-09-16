# [FCPS] CA Expiring in Production - April 2018

\[FCPS\] CA Expiring in Production - April 2018

Team,

The Production eDir Certificate Authority is set to expire in April. When that occurs, any application that authenticates against eDirectory would no longer be able to connect. To avoid any downtime when this happens, we will be taking the following steps:

1. Get a list of ALL the applications that authenticate against eDirectory.
2. Replace the old CA.
3. Do NOT generate the new server certificates.
4. Export the new Certificate Authority certificate.
5. Pass that new certificate out to ALL applications that connect to eDirectory.Wait to re-generate the actual server certificates.
6. Each application owner will import the new certificate into their application. On applications where there are multiple servers, the certificate must be imported into ALL of the servers. (Like Blackboard).
7. Once all the applications have imported the new cert, we can then re-generate the server certificates.
8. As long as the different applications have successfully imported the new certificate there will be NO DOWNTIME for any application or service. 

* * *

PROD Cert
![[./_resources/FCPS_CA_Expiring_in_Production_-_April_2018.resources/ScreenClip.3.png]]

* * *

TEST Cert expires in a year
![[./_resources/FCPS_CA_Expiring_in_Production_-_April_2018.resources/ScreenClip.1.png]]

**PROD cert Aril 2018**

* * *

Carl,

The results of these tests were as follows.
1\. Wrote Program
2\. Tested the connection with the old CA cert and it was successful
3\. Tested the application with a fail scenario by removing the cert and it did fail as a desired result
4\. Removed the CA via iManager
5\. Tested the connection with the old CA Cert and removed CA and it connected successfully
6\. Created a new CA via command line, (see [TID](https://www.novell.com/support/kb/doc.php?id=7013047) for details)  I did it this way because I had an error via iManager
7\. Tested connection and made a successful connection with a new CA created
8\. Recreated server certs with the new CA.  
  \*In iManager, select **Novell Certificate Server** > **Create Server Certificate**. Select the appropriate server, specify a nickname, and accept the rest of the certificate defaults.
9\. Tested the connection.  The connection was successful.

I believe this will successfully show the migration path to a new CA for FCPS.

Thanks,

Colton

* * *

**OpenAir**
4 - Replace the old CA Design work - Design the CA Replacement Plan
4 - Write Java application to do an SSL connection check.
2 - Delete the CA and test with the application.
8 - Re-create the CA and test with the application.
4 - Use the CA to make new server certs and test with the application.
4  - Checklist for FCPS to do this in their env.

CA-3.00
Design the CA replacement process

CA-3.01 Design the CA Replacement Plan
CA-3.02 Write the Java Application to do an SSL connection check

* * *

1. Java program to test our SSL connection.
2. Test with the application. (Will work).
3. Delete the imported cert from the application and make sure it doesn't work.
4. Delete the CA.
5. Test with the application. Record what happens. (Should still work... hopefully).
6. Create a new CA.
7. Test with the application. Record what happens. (Should still work... hopefully).
8. Generate new server certs.
9. Test with the application. Record what happens. (Should still work... hopefully).

Keystore Explorer to view certs
**TID for creating a new CA:** <https://www.novell.com/support/kb/doc.php?id=7013047>
Monique has done this before - we can ping her and see if she ever wrote up  how to do this.----- Carl to cC

* * *

**OLD Notes. No longer valid**

**Part 2**

1. Try connecting with our app. 172.17.2.22. This should work
2. Snapsot your SLES VM.
3. Delete the CA for 172.17.2.22
4. Try connecting with our app again. Does this work?
5. Follow these instructions to create a new CA. <https://www.novell.com/support/kb/doc.php?id=7013047>
6. Try connecting again and see it succeed, asking you to trust the new cert.
7. Read the next part update your estimate and email Carl if your estimate has changed.

* * *

**Part 3 (I think this is too rough to be useful).**
This time we are going to renew the CA WITHOUT any downtime where people can't connect.

1. Restore your Snapshot.
2. This time lets import the actual CA into Apache Directory Studio. In the last test we just used one of the server certs. This time, I want the actual CA in Apache Directory Studio:
	1. Delete all the certs out of Apache Directory Studio. Click Window -> Preferences. You will get a pic sort of like this: <https://directory.apache.org/studio/users-guide/ldap_browser/preferences_certificate_validation.html>
	2. Export the eDir CA from iManager: Follow the "Exporting the Organizational CA's Self-Signed Certificate" instructions here -> <https://www.novell.com/documentation/crt27/?page=/documentation/crt27/crtadmin/data/a2ebop8.html>
3. Drag and drop that cert you exported into the cert window of Apache Directory Studio.
4. Try connecting to eDir over SSL again. You should NOT have to trust any new cert since you already imported the CA. Make sure that it does NOT ask you to trust a new cert.
5. If all that worked as planned, you now have the valid CA in Apache Directory Studio.
6. **Now we want to replace the CA without downtime.** I am not sure how. The instructions above show deleting the old CA first. Is there a way to create the new CA without deleting the old one first? If you can't find an answer to this, please open a Ticket with Microfocus Support.
7. Once you do create a new CA make sure that you can still connect with Apache Directory Studio. The old CA should still be valid so it should be fine.
8. Export the new CA from eDirectory and import it into Apache Directory Studio again.
9. Then remove the old CA from eDirectory.
10. Try connecting with Apache Directory Studio again. Make sure it still does NOT ask you to trust a new cert since you should be using the new CA now.
11. Tell Carl the results :)

* * *

**More info about their PROD env**
![[./_resources/FCPS_CA_Expiring_in_Production_-_April_2018.resources/ScreenClip.2.png]]

* * *

![[./_resources/FCPS_CA_Expiring_in_Production_-_April_2018.resources/ScreenClip.png]]

* * *
