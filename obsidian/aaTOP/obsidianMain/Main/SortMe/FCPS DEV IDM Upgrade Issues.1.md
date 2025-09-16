# [FCPS] DEV IDM Upgrade Issues

==Aaron's notes are highlighted.==

**NOTES**
**Password resets happen in the following conditions**
 - Ctrl-Alt-Delete (Password change happens in AD.)
 - AD Password change tool that Matt wrote (Password change happens in AD.)
 - SSPR - SSPR sets grace logins, expiration date etc.
 - Admin reset - NMAS settings set grace logins etc.

==SSPR General notes:==
 ==- You can edit SSPRConfiguration.xml, though after saving it to disk, the web will report 5053 ERROR\_APP\_UNAVAILABLE - wait 10 seconds, then refresh again.==
 ==- Thought/recommendation: I want to change the NMAS CR questions to be prefixed with the word NMAS, so we know when questions are being generated from the nmas password policy . .==
 ==- the "selected profile" text doesn't update when moving between CR and PP profile pages; though it is showing 'default' by default; it's just a cosmetic thing that can cause confusion.==

* * *

**Challenge Questions and Password Policies in SSPR**
- [x] Setup Challenge Questions in SSPR to match eDir in DEVL
- [ ] Setup Challenge Questions in SSPR to match eDir (in production!)
- [x] Setup the Employee Password Policy in SSPR to match eDir
- [ ] Setup the NonEmployee Password Policy in SSPR to match eDir
- [x] Doc up how to setup Challenge Questions in SSPR. (This might be simple enough to just have a few lines of documentation. Not sure.)
      -   Go to https://\[server:port\]/sspr/private/config/ConfigEditor -> click on top center button 'Configuration Editor'
      -   Review/update values under Settings ->Challenge Settings to cover global settings, and Profiles -> Challenge Profiles to actually setup a challenge response.

- [x] Doc up how to setup the password Policy in DEV. (This might be simple enough to just have a few lines of documentation. Not sure.)
      -   Go to https://\[server:port\]/sspr/private/config/ConfigEditor -> click on top center button 'Configuration Editor'
      -   Review/update values under Settings ->Password Settings to cover global settings, and Profiles -> Password Policy Profiles to actually setup a challenge response.

- [x] Find a way to export/import password policies so hopefully we can just set this up once. 
      - Copy and paste the netiq/idm/apps/tomcat/webaps/sspr/SSPRConfiguration.xml file! This includes EVERYTHING in SSPR - PP's, CR's, customized text, config password.

 ==- POST UPGRADE Concerns:==
      ==- Need at least one NMAS password policy to:==
            ==- Allow nspmDistributionPasswords to be set for IDM synchronization.==
           ==- To allow admin.services/uaadmin.fcps to retrieve passwords (don't know if this is strictly necessary)==

==NMAS Password Policy items that appear to not be covered in SSPR:==
 ==- Verify whether existing passwords comply with the password policy (verification occurs on login)==
 ==- Allow user to initiate password change: I think this occurs in SSPR by default.==

==SSPR app concerns:==
     ==- - may not be a problem: Userapp auth takes care of this by getting email address as well: -  LDAP Duplicate mode (processr of dulicate user cn's during authentication for example) fails==

* * *

**iManager Error**
- [ ] When doing a password sync check on users in iManager, an error pops up.

![[./_resources/FCPS_DEV_IDM_Upgrade_Issues.1.resources/I was trying to check password syn status in iMana.docx]]

==Owner of this issue: Ezel reported this bug.==

==SR submitted (1/22/2016 4:18:34 PM): SR#10989041631, "iManager issue with check password status"==

**==TODO:==**
 **==- our VM should be updated to 2.7.7.4 to match DEVL!==**

==Next step: get response on SR.==

==Extra notes:==

==I've narrowed this down to the ADLDS driver; for some reason the driver was marked as supporting password sync, and so was included in the password sync check. Any time a password sync check is done on the ADAM driver, it appears to respond properly with an error 49 (failed authentication) as expected, but a bad character is returned along with the message . .a "^@" appears in the trace, and I think it may be the issue; though I haven't figured out how to resolve it aside from removing LDAP== 

- [x] Fix error with iManager plugins not working
[[iManager Plugins upgrade and test]]
<https://www.evernote.com/l/AAYJ3NOixJ9PkbbucGdnYl4hZskSHSmvHSU><https://www.evernote.com/l/AAYJ3NOixJ9PkbbucGdnYl4hZskSHSmvHSU>

* * *

**IDM Home Issues**
- [ ] When you are on the page in IDM Home, there is a typo: It reads: "In you forget your password" instead of "if you forget your password". I think we will be able to fix this by downloading the localization file, finding that string, fixing the typo, and re-uploading. (Carl can show where this is done).
- [ ] FCPS reported that when doing a change password process, they were prompted to enter the password again after changing it. Is this normal?
- [ ] Do a test and make sure it throws an error if you try to answer all the challenge quesitons with the same answer.
- [ ] Find out how FCPS got this error and fix it: <http://www.evernote.com/l/AAZvTAxeZxdNMb2Rh2wUMNLByCNDQjJsW9Q/> ([[FCPS Password Expired Error 5071]])
- [ ] On the workflow page, it still reads, "NetIQ Identity Manager" at the top of that page. This is a UserApp page, I am not sure where that title comes from or how to change it. It should read "FCPS Identity Manager". Carl needs notes about where this is done to do it in TEST and Production.

* * *

**Figure out IDM Home / UserApp scoping**

* Right now the scope is set to o=FCPS.
* FCPS doesn't want students or parents to be able to login to IDM Home.
* That means we would need to put it at "o=FCPS,ou=Staff". But we can't do this since the admin user is in o=FCPS.
* Is production setup at o=FCPS?
* Carl thinks the solution here would be to make all the IDM Home buttons only appear for the O=FCPS,ou=Staff.

- [ ] (5 Hours) Currently in Production, is the UserApp scope o=FCPS? (Once you answer this talk to Carl about next actions).

* * *

**SSPR Grace Logins Issue**

* SSPR is consuming 3 grace logins on each login.
* We can update the password policy to 8 so users can get logged in. 
* But we have to remember the initial migration scenario. Even if we update the password policy to have 8 grace logins, users will still have only 2 grace logins on their accounts. Are we going to need to do some kind of LDIF file to update everyon'es grace logins?

- [ ] Brainstorm how to handle the number of grace logins the pre-existing users will have after the upgrade.

- [ ] Find out why SSPR is consuming 3 grace logins instead of just 1. (Micro Focus ticket?).

* * *

**AUP/TAC Fix**

* Employees will have another line of text under:"You have agreed to the FCPS Time and Attendance Policy."
* That line will only appear for employees and will be:             "<p>For further regulation information, click on this link: 

- [ ] Find the Complete.jsp page

- [ ] Write a conditional statement that says if employee: print the text shown above. If Non-Employee print nothing.

* * *

**Deploy the student drivers to DEV**
Carl may need to do this, but here are the steps.
(Carl thinks this will take a full 12 hours)
- [ ] Cleanup the mapping table read code in the VM. (Resulting from the changes we had to do ofr IDM 4.5).
- [ ] Export the driver and make sure all mapping table calls are being done the new way. I really need to make sure I am building the values correctly too.
- [ ] Export from our VM
- [ ] Build for DEV
- [ ] Paste the latest IdMUnit mapping table entries into the DEV table.

- [ ] Deploy drivers in DEV
- [ ] Run IdMUnit tests in DEV.

* * *

IE Edge issue - complete Matt is turning this off on these two IPs:

**10.3.5.103**
**10.3.5.108**

* * *

**Work with Jeremiah on this:**
[[FCPS Workflow Errors]]

* * *

**Questions**
- [ ] SSPR Does it to Admin password resets?

V1.0 (testing to see if carl sees my latest changes)

[[FCPS Dev Testing Greenlight from Brunda]]
