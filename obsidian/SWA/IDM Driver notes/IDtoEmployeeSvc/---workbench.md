10/4/2024 about 10 am
Rough notes from Yatin earlier today:

mployeeSvc - removed code dependency -Employee
   - Yatin:
   - Commented code -
   - Now Test case modifications
   - swaEmpSvcBaseRole - testUserTerm
   empleesvc_employee.+
   - Remove dependency on entitlements
   - dirxml-entitlement
   -
employeerolemangement - removed



10/4/2024 5:43:06 PM



3 new stories - Yatin passed on some work ;I suspect this needs to be done:
[https://southwest.atlassian.net/browse/CSEE-4094](https://southwest.atlassian.net/browse/CSEE-4094 "https://southwest.atlassian.net/browse/csee-4094")  
Description: Deploying some code Yatin made on CSEE-4025.

IDtoEmployeeSvc | IDM - Update and pass IdMUnit tests  
[https://southwest.atlassian.net/browse/CSEE-4095](https://southwest.atlassian.net/browse/CSEE-4095 "https://southwest.atlassian.net/browse/csee-4095")  
Description: Updating and passing tests from Yatin, that he made on CSEE-4025

IDtoEmployeeSvc | IDM - Update Pipeline Config  
[https://southwest.atlassian.net/browse/CSEE-4096](https://southwest.atlassian.net/browse/CSEE-4096 "https://southwest.atlassian.net/browse/csee-4096")  
Description: The driver and build is pretty old, and needs some Pipeline/AWS and build updates.  


As part of the 4094 story; I should delete these values:
My plan, in addition to deploying the latest, (it's a change to sub-ctp-createEmployeeSvcUser), I should delete the following objects:
Entitlements:
  SFLicence
  SFProfile
  SFRole
Entitlement config object:
  EntitlementConfiguration



11/1/2024 1:11:40 PM
Worked with Ugandhar to send thorugh a user . .appoarently he wants an 'active retiree'


Search:
o=swa-idsat
(&(cn=r*)(swaStatus=S)(swaPersonType=FE))

only this user currently, I forced the FE:

cn=r999904,ou=Users,o=swa-idsat

11/5/2024 12:35:21 PM
11/4/2024 3:50:03 PM





11/4/2024 12:28:40 PM
Logini Sivalogan - IDtoEmployeeSvc meeting
svc & migration support.
-

QA roles:

00E3t000001bvXyEAI
EC Inflight  Admin ES Leader


00E3t000001bvY3EAI
EC Inflight Admin ES Employee


00E3t000001bvY8EAI
EC InFlt Admin ES InFlt Leave Leader


00E2E000002RP3VUAW
HRIS Leader


00E2E000002RP3XUAW
Knowledge Content Leader


00E2E000002RP3YUAW
Knowledge Content Manager


00E2E000002RP3dUAG
Leave Time Keeping and Travel Manager


00E2E000002RP3eUAG
Organizational Management Leader


00E2E000002RP3fUAG
Organizational Management Team Member


00E4w000001uxENEAY
Pre-Employee Team Leader


00E4w000001uxEOEAY
Pre-Employee Team Member


00E4w000001rMa9EAE
Travel Lead





11/4/2024 10:53:21 AM
Yatin: only goal here is to determine which driver code is the latest.
   - Git appears to be the latest, and we just need to deploy to dev/qa/andprod
   - while we remove and pass all the tests.
 - latest driver isin prod; test all the changes I see.




11/7/2024 1:33:51 PM
Found today a few things:

Both DEV and QA drivers use the same authentication URL of:
    https://test.salesforce.com/services/Soap/c/47.0/0DFS00000008iMR

```

		<serverUrl>https://southwest-es--empdev1.sandbox.my.salesforce.com/services/Soap/c/47.0/00D030000008k6a/0DFS00000008iMR</serverUrl>
```

```

		<serverUrl>https://swa--fc3swa.sandbox.my.salesforce.com/services/Soap/c/47.0/00D2h0000008eea/0DFS00000008iMR</serverUrl>
```


The problem though is that we don't have any working role/profile ids for southwest-es-empdevl1.sandbox.my.salesforce.com, we'll set the QA crednetials for DEV and Qa to this environment.

This means that we'll use the QA credentials, so that we use the swa--fc3swa.sandbox.my.salesforce.com site for our DEV and QA eDirectory trees.


11/7/2024 4:47:46 PM
idmunit tests spreadhseet updates:
  - disable nrf* rows
   - changed queryUser_Test to QueryUser in





11/12/2024 1:12:14 PM
"Discuss wordkay -> IDM TEst envionement"
 - LOgini Sivalogan"
 - Emily Fogel
trying to get context
 - trying to get 'retree' role cleaned up . .
 - two ways to get records:
   - IDtoEmployeeSvc: regular users
   - Josh Saulson
   -Employees active
   - want to get them set to retired
   - Separate rule
     - "LInda guluge"
   -




 - Next contact for backlog: Shawn Currey




 - Dash challengs - table integrate dinto form
   -

11/13/2024 10:57:06 AM
Example of invalid login:
```
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sf="urn:fault.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Body>
        <soapenv:Fault>
            <faultcode>INVALID_LOGIN</faultcode>
            <faultstring>INVALID_LOGIN: Invalid username, password, security token; or user locked out.</faultstring>
            <detail>
                <sf:LoginFault xsi:type="sf:LoginFault">
                    <sf:exceptionCode>INVALID_LOGIN</sf:exceptionCode>
                    <sf:exceptionMessage>Invalid username, password, security token; or user locked out.</sf:exceptionMessage>
                </sf:LoginFault>
            </detail>
        </soapenv:Fault>
    </soapenv:Body>
</soapenv:Envelope>
```


11/19/2024 11:37:25 AM
11/19/2024 10:15:17 AM
Logini - Aug 4 - to now, too long to become retiree . .
 - Understanding the process is the goal
 - When an employee becomes a retiree, rules/permissions assined in salesforce.
 - Goal for meeting today: take an active person in QA, make them a retiree.
   - Determine what we need to conver a user to a retiree to confirm how the user is getting the information.
 - Jeff Willton
  Who is setting these? - Yatin confirmed, EmployeeRoleMgntSvc driver.
   - Role ID 00E2E000002RP3oUAG
   - profile id: 00e2E000001IUCiQAO

149 users in prod that have one or both of these values:
r100346
EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO
 - Not getting assigned the role
 - If not renaming: IDF - data dumps - not show it as an R account . .
   - Data gets provisioned from IDM . .
   - also get dtaa dump - IDF - "Data Lake" user information possibly . .

Takeaway: 11/19/2024 11:38:00 AM
 - EmployeeRoleMgmt driver sets actual retiree role int he swaEmpSvcBaseRole attribute.
 - wd-e-Leave has to contain 


11/21/2024 3:19:27 PM

Per our session today, Logini, Jeff Wilton and I worked through som eissues.





cn=e32892,ou=Users,o=SWA-ID
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#0052E00000Loe6IQAR

homeEmailAddress: TESTalott12@gmail.com


11/21/2024 1:01:03 PM- Just sent this in prod:
      <ProfileId>00e2E000001IUCdQAO</ProfileId>
      <UserRoleId>00E2E000002RP3aUAG</UserRoleId>





cn=r32892,ou=Users,o=SWA-ID


Nader - start in pi, but end in december . .
-






Few items to consider:
 - Don't let anything
 - Sync up with Farhan . .
 - How time sensitive r32892?
   - Issue: need to undrestand what is happening . .
   - Contact record not being there . .odd situation . .
 - Send driver docs . .
 - We need more debug info: instead of content not alowed in prolog
 - Retirees: When and how is the <Email/> place holder set . . .??
 - Ensure all error messages: DirXML Log Event -------------------
     Driver:   \SWACO_ID\SWA-ID\Services\DirXML\Driver Set AEv1\IDtoEmployeeSvc
     Channel:  Subscriber
     Object:   \SWACO_ID\SWA-ID\Users\r32892
     Status:   Error
     Message:  IDtoEmployeeSvc-ERR-0057:Create user failed CN=r32892 ErrorCode=REQUIRED_FIELD_MISSING ErrorMsg=Required fields are missing: [Email]

     New Solution??!!?
     - Monitoring - Conrad's team . .

    Yes, I would work with my Product Owner (Tim Short), Tech Lead (Chaitanya) and Automation Engineer (Phil Critchfield).


 - r32892 - find out when contact would have been created . .
 - We also have an additional set of error situations where the retiree DOES have a contact account . .
   -
 -



 - 11/21/2024 1:19:05 PM- no retirees since 8/22 . .
 TODO:
 - Send: cn=r32892,ou=Users,o=SWA-ID




other notes:




11/19/2024 4:20:18 PM
Logini - when was this user sent to employeesvc?
e32892






The long story short here, is that it appears that the IDtoEmployeeSvc driver has a very specific use case around 'active' retirees, and I need to know what these look like.


Ugandhar, When you get a moment to chat, could we get on the phone and talk about the following?



I've been able to dig into the driver more, and I can see some of the requirements around a retiree. For example, it seems the only kind of active retiree we support are those that have these attributes:

swaStatus = S
swaPersonType = FE
wd-E-LeaveType = .*Furlough.*

Which makes me think we only support retirees that were seperated as a result of of furlough . .which may or may not be happening any more. I'd also like to confirm with you if this is the same use case that you were concerned about testing.










11/21/2024 1:59:29 PM
Summary on IDtoEmployeeServices discussion today:
 - Discussing INC: INC6276942 - We found today that retirees are not coming across since late August.
 - Possibly due to CHG0420393, the most recent deploy of the IDtoEmployeeSvc driver.
 - Confirmed that the lib-sub-etp-ClassifyEvent policy was not in production that identifies object types.
 - We confirmed that retirees are not being properly managed as the driver can't classify object types.
 - ON a related note: Also found sync events are not supported (The ClassifyEvents policy needs to write objectType on the synthetic CN modify event)
 - Confirmed that there are many times where an HTTP 200 (OK or successful) value is returned, yet there is an error message that we need to know about.
  - Need to add monitoring to track these.
  - Found that when retirees are created, we need to confirm their contact can properly get created.

I'm breaking this down into stories, and working to resolve now.




11/22/2024 11:33:46 AM
Q &A session



```

Hi Aaron, here are the questions we have for you -
1. When User data is pushed to SF manually, does it use the normal workflow where policies are applied, or does it bypass the policies?

2. When IDM sends user data via automated process, do you also create contact record when we do not have one in SF?

3. Can we get a list of the default base-level Roles in Prod IDM (HR, Emp, Leader, Retiree)?

4. We know that IDM sends a Role and Profile when creating new retiree User records, but does IDM assign that Role always, or does IDM only assign the Role when it does not come from Workday?

5.I have reached out to WD regarding testing in lower environment.  we will need to know endpoints from IDM is setup to SF (we are receiving data from IDM in our FC3 environment).  we will need to make sure WD is setup on this environment to test full end to end.

6. is there away we can back up the existing Retiree data in prod before we move the missing policies?


Answers:
1 - IDM works by data changes. The core issue is causing a driver to process something when there's not an actual data change. drivers can be written to be sensitive to this; though it takes some creativity. All policies are hit the same way whether actual data changes, or we do an artificial 'sync' event it's called (aka a '#4#'); though generally this causes a 'replay' of all the available data and should hit all normal policies.

2 - Yes, there is some code in the driver to do contact work; though it won't fire if object types can't be classified..

3 - Not sure I understand this one - we recently covered this, and I learened that the hardcoded values in the EmployeeRoleMgmtDriver (a separate driver) holds these values; and they are the only somewhat 'static base' roles that I know of. They are the ones I sent to Jeff for validation.
            <param name="gcv_SVC_HR_Role" expression="EmployeeSvc_HR|||00E2E000002RP3SUAW|||00e2E000001IUCdQAO"/>
            <param name="gcv_svc_Emp_Role" expression="EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO"/>
            <param name="gcv_svc_leader_role" expression="EmployeeSvc_Leader|||00E2E000002RP3aUAG|||00e2E000001IUCdQAO"/>
            <param name="gcv_svc_Retiree_Role" expression="EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO"

4 - The driver doesn't care where data comes from: if it is in the object at the time of processing, it'll process it. As long as the data is in the correct attribute with the correct formating, it'll be used. And yes, the default payload appears to provide the profile and roleid; though we saw recently that there are times where a smaller version of a payload is used in special cases; so not all data is synchronzied all the time.

5 - Ok, and understood. We are connected to FCS3 in our DEV tree, and our QA tree; so we should be able to test without trouble once the data makes it into the tree.

6 - What data do you want to backup, the actual retiree objects in eDirectory? We can do that; the only data we can't backup easily is encrypted/hidden data like passwords. And to be clear, we'll be adding the missing policies, then we'll need to push the users through the driver again.

7 - Yes, there is a specific policy that creates contacts for retirees; but it depends on being able to detect retirees; and that's the policy that's missing. At this point, I'm confident that when we add the missing rule, you'll start seeing contacts get created again.


```



11/27/2024 2:50:05 PM
Start of notes from worknotes of notes test session

IDtoEmployeeSvc:


 - User set 1: Write code to migrate identified user set, 214 above currently.
 - User set 2: arbitrary id list send migrates for these accounts.


dev : EmployeeSvc_Retiree|||00E2h000000RMT8EAO|||00e2h000000EcgoAAC
prod: EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO



<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<soapenv:Header>
<urn:SessionHeader>
</urn:SessionHeader>
</soapenv:Header>
<soapenv:Body>
<urn:update>
<urn1:sObjects xsi:type="urn1:User">
<urn1:Id>005D2000005VUPJIA4</urn1:Id>
<urn1:LocaleSidKey>en_US</urn1:LocaleSidKey>
<urn1:EmailEncodingKey>ISO-8859-1</urn1:EmailEncodingKey>
<urn1:LanguageLocaleKey>en_US</urn1:LanguageLocaleKey>
<Username>r13018@wnco.com.swadev</Username>
                                <FederationIdentifier>r13018</FederationIdentifier>
                                <EmployeeNumber>r13018</EmployeeNumber>
                                <Alias>TToep</Alias>
                                <IsActive>TRUE</IsActive><FirstName>Traci</FirstName><LastName>Toepperwein</LastName><Email>r13018@default.wnco.com</Email><ProfileId>00e2h000000EcgoAAC</ProfileId>
                                <UserRoleId>00E2h000000RMT8EAO</UserRoleId>
                        </urn1:sObjects>
</urn:update>
</soapenv:Body>
</soapenv:Envelope>


<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns
:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <soapenv:Header>
     <urn:SessionHeader>
     </urn:SessionHeader>
  </soapenv:Header>
  <soapenv:Body>
      <urn:update>
         <urn1:sObjects xsi:type="urn1:User">
          <urn1:Id>005D2000005VUPJIA4</urn1:Id>
         <Alias>TToep</Alias>
                                <IsActive>TRUE</IsActive>
                                <ProfileId>00e2h000000EcgoAAC</ProfileId>
                                <UserRoleId>00E2h000000RMT8EAO</UserRoleId>
                        </urn1:sObjects>
      </urn:update>
  </soapenv:Body>
</soapenv:Envelope>








Driver update
 - allow swaStatus of T match . . .
   - find a match - associate, but ensure object is in disabled state.
   - don't find a match - veto
 - delete .tgz files on w11qcledirqi012 ~/avk*





Test verification steps needed:
 - Need to be able to double check associations on demand . . .

 - e128926: Needed to associate to exsiting account: always need to be able to validate existing users since they aren't deleted . .
 - on sync we can' delete association; ahve to let process normally
 -





Testing status:

Test case 1 is complete.
Test case 2: waiting on rehire
Test case 3: further refining, are we ready to test? If not, what's missing?
Test case 4: further refining, are we ready to test? If not, what's missing?

Known, but separate issues:
These items are known issues . . I didn't think they would affect our testing with the EmployeeSvc team testing.
 - During a retire:
  1 - The user in workday should get the new 'rid' to fully be retired. This is not happening in swa3 currently.
  2 - The users 'status is terminated' doesn't change to reflect their retiree status.
 - Also note: I attempted the known workaround for e138225; and I saw the correct rename 'r138225' go back; but we have yet to see workday receive this value per #1, and have their status change per #2.

 - 11/26/2024 12:02:35 PM - call
 - Alignment
 - 4 test cases, identified porential users.


************************************************************************************
1) Terminated -> Rehired - ensure rehire activation works properly
Status: Complete
User: cn=e117406,ou=Users,o=swa-idsat
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000i8LxAAI
  swastatus = term
  User: inactive
  Contact: terminated
************************************************************************************
Test Case 2) Terminated -> Retired -> Rehired - ensure activated
Status: All but the rehire.
New user: cn=e136054,ou=Users,o=swa-idsat
    old userUser: cn=e138225,ou=Users,o=swa-idsat
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000iKrFAAU
  swastatus = term
  User: inactive
  contact: terminated

  CASE #2 - 136054 - They are a terminated employee (technically would not be eligible as a retiree) to make them a retiree, they need Travel AND Retiree status updated - would like to see this flow to IDM and IDM send back the RiD (this is the way it is supposed to work) - AFTER IDM runs, we can then key a rehire - to see IDM run and update back to EID

Process Flows:
1 Terminated in Workday (term reason not separated reason)
2 IDM gets term data
3 TESS INT runs INT5019 -> Manually keyed is required; normally done by an integration.
  1 Updates Travel Flag
  2 Updates Retiree Status
4 IDM gets Retiree & Travel Data
5 Workday Accounts updates from Eid to Rid (not sure of timing as I can't see audit trail for this piece) (no issues currently).

cn=e136054,ou=Users,o=swa-idsat
  Retire/contact/user: enabled where they need to be
  - Ready to rehire 136054
  - Processing rehire: hire event
  - 11/26/2024 2:41:35 PM- Shelly rehiring now; waiting for rehire.
r136054 is inactive
raccount inactive

*** - ON a rehire: when would we get the data enough to re-enable the account?
 - Workday - midnight onboarding process
  - Midnight process: manually?
 - TODO: Won't get email until midnight . .
 - e account in Workday: in a prehire status . . .Not a T any more; but
 - WorkdayHCM would have to see the P . . .
 - Need to fnish validation:
  [edir@w11qcledirqi012 avk-empsvctesting]$





************************************************************************************

Test case 3) Active -> Terminated in past -> Retired - ensure Retiree created properly
Status: still being defined
User: cn=e128926,ou=Users,o=swa-idsat (11/26/2024 2:25:29 PM)
  swastatus: active
  (minimum 10 year requirement not met; but should work)
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#005D2000005lshHIAQ
  user: active
  contact: active
  - Pass date: did

  complete:
    completed: we moved to e128926.
    details:CASE #3 - 123039 - Can we pick a different EID - this person is active with lots of Admin security roles =- do not want to mess up their ability to work in SWA3 as they are wokring in it daily

cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#00523000001Qa2eAAC
corrected:
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000iExWAAU

  user: User is now inactive. cm__User due to the disable is removed, contact information from IDf.
  contact: may not be updated by this process, not associated for the user.

11/26/2024 3:27:37 PM- Now part 3
 - Shelley starting 'TESS INT'
  (from above)
  3 TESS INT runs INT5019 -> Manually keyed is required; normally done by an integration.
    1 Updates Travel Flag
    2 Updates Retiree Status
  4 IDM gets Retiree & Travel Data
  5 Workday Accounts updates from Eid to Rid (not sure of timing as I can't see audit trail for this piece) (no issues currently).

11/26/2024 3:33:32 PM - waiting on retiree . .
11/26/2024 3:41:15 PM - REceived retiree, it's enabled, test case is done.
11/26/2024 3:41:43 PM - the rID did make it back to workday per Shelley.
Users:
cn=e128926,ou=Users,o=swa-idsat
cn=r128926,ou=Users,o=swa-idsat


*******
11/26/2024 3:42:59 PM - Question:
(possible test case 3 alternative: termination in the future)
 - picking active account to be terminated
cn=e128877,ou=Users,o=swa-idsat
   - cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000iExpAAE
   user: active
   contact: active
   association: correct

11/26/2024 3:46:07 PM- waiting on future dated term.
11/26/2024 3:47:50 PM - keying is done, waiting additional processes . .
11/26/2024 3:48:59 PM- got event . .
11/26/2024 3:50:15 PM - future dated term only updates transaction log, among other potentially unrelated attributes - nothing seen in IDtoEmployeeSvc.

next action: See after 11/29 - termination completed.
*******



PAUSING HERE

Test summary

Test case 1 is complete.
Test case 2: not complete: need to confirm why existing eid account didn't get rematched (Workday integration issue).
Test case 3: Complete.
Test case 3b: New: almost complete: Future term: complete: no event see in IDtoEmployeeSvc - After 11/29, confirm user/contact is terminated
Test case 4: Ready to start.
Test case 5: Ready to start. New: Active -> Separate with a reason -> Retire

TEst case 2 need to review: 11/26/2024 4:10:55 PM
C:\work\emp-testcase-2-review\emp-testcase-2-review\emp-testcase-2-review\WorkdayHCM_3.log




Test 4) Active -> Separated -> Retired - ensure Retiree created properly
Status: still being defined
User: cn=e128864,ou=Users,o=swa-idsat
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000iExQAAU (association corrected 11/26/2024 3:29:08 PM)
  swaStatus - Active
  contact: active
  user: active

  CASE #4 - 128864 - we can terminate this one - need to know which Separated path you would like to go.
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#00523000001Qa2jAAC
    1 - Term with no separation reason
      - allow IDM to run
      - then correct the reason code to a separation one
      - allow IDM to run
      - then update Travel flag
      - allow IDM to run
      - RID should update in Workday
      - for this scenario they will not get a retiree status as separated people do not get retiree status.

Test case 5) Proposed test case 5
  cn=e128928,ou=Users,o=swa-idsat

  0052h000000iF05AAE - 11/27/2024 8:06:51 AM- congfirmed.
  Active -> Separated with reason intially
 - Term with WITH separation reason
      - allow IDM to run
      - then update Travel flag
      - allow IDM to run
      - RID should update in Workday - for this scenario they will not get a retiree status as separated people do not get retiree status.




  We should also do the opposite separated type where they are terminated with the Separated reason initially.  All the above would be accurate except no correction of reason code




 - Marci Godfrey - Rids not coming back to workday.
 - Heather wilson - due to the issue, Cheryl - we need defects resolved and then test.
 - marci - second scenario: waiting for rehire happen in workday - not a true test.
   - don't know if we do all this and looks like it's ok and have another change.
 - logini: issue in prod rids not comiong through; due to our bug.
 - Cheryl - several things going on
   - salesforce: receive info from IDM/IDF. Both sides broken . .
   - Cheryl about to start userstry to resolve IDF problem.
   - salesforce is only getting rid from idm.
   - logini: get user which enables all user types to log in & have contact do need both.
   - Cheryl - three things that are broken
 - Cheryl - everything fo rid for access purposes.
 - login -> jeff: see both eid and rid from idf.
 - aaron - ahrd to test when fixes happening . .
 - Marci - need to do testing for both things.
  - half a day for one scenario: time commitment is rough.
 - logini p2 - we need help . .
 - Cheryl - issues may be related don't want to sped days here, then days elsewhere.
  - if we know the issue & know how to fix; and run schearions. feels like we're grasping at straws.
  - want to get all on the same page.
 - Farhan - don't have dependencies - just had our idtoempsvc fix
 - loigni: summary: changes for workday on core, doesn't affect ee right?
 - Farhan logini: overall date going to prod . .
 (dhivya talking with Kyle)
 - Cooper - urgency - two fold
  1 - persistent issue in employee svc . .retiree
  2 - planned go live 12/9 - release to reitrees new alunmi portal going live.
    this is a blocker; don't wnt to go live without access to retirees.
    - if we need more time to do this the right way, need to know sooner than later.
    - realistic turn around?
    - open to moving go live; but need to have realistic timeline for all teams  involved.
 -marci: additionally: separted employees  . .
   - the rid issue not coming back to employees - when we separate employess - VSP situation.
   - Their status isn't changing, status doesn't change to 'R' . .generlaly should hve rid.
   - this is the real issue.
   - alumni need access.
    - retireestatus - happens with term to retiree . .
 - when some one separates, this separated employee will ahve travel eligiblity.
   - should get an rid.
   - Active/terminated/retired/spearated.
 - logini -> Kyle
   - kyle: not putting fixes into.
 - Cheryul
  Aaron - fix idtoemployeesvc
   1 - Aaron idtoemployeesvc
   2 - Kyle rename fix
   3 - feed from idf to workday

   Need idm to send back to workday - VSPs have the rename problem.
   - Kyle: changing the way data came in.
 - marci: want all fixe sin place, and test everything together.
 - dhivya - don't want to confirm utnil we wknow.
 - kyle: only issue:


w11qcledirqi012: /swa/opt/netiq/avk-empsvc/hcm/WorkdayHCM_4.log

Cheryl's three issues:
1 - Aaron's IDtoemployeesvc fixes: status: in QA (also swa3 tennant in workdayHCM)
2 - Kyle's WorkdayHCM fixes: status about to be in QA.
3 - Feed from IDF to Workday: Status: unknown













IDtoEmployeeSvc - soap api guides: - make sure on version 47
https://trailhead.salesforce.com/content/learn/modules/api_basics/api_basics_soap
https://developer.salesforce.com/docs/atlas.en-us.224.0.api.meta/api/sforce_api_quickstart_intro.htm


objects - at least shows fields in soap body
https://developer.salesforce.com/docs/atlas.en-us.222.0.api.meta/api/sforce_api_objects_user.htm

error codes possibly helpful . .
https://developer.salesforce.com/docs/marketing/marketing-cloud/guide/1000_1999_account_object.html

Good morning Cheryl & Marci, Could you all please send over test data for us?
Our test scenarios are the same as what Josh provided yesterday -
    1) Terminated -> Rehired - ensure rehire activation works properly
    2) Terminated -> Retired -> Rehired - ensure activated
    3) Active -> Terminated -> Retired - ensure Retiree created properly
    4) Active -> Separated -> Retired - ensure Retiree created properly

(|
(cn=e117406)
(cn=r117406)
(cn=e138225)
(cn=r138225)
(cn=e123039)
(cn=r123039)
(cn=e128864)
(cn=r128864)
)


1) Terminated -> Rehired - ensure rehire activation works properly
User: cn=e117406,ou=Users,o=swa-idsat
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000i8LxAAI
  swastatus = term
  User: inactive
  Contact: terminated

2) Terminated -> Retired -> Rehired - ensure activated
User: cn=e138225,ou=Users,o=swa-idsat
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000iKrFAAU
  swastatus = term
  User: inactive
  contact: terminated

3) Active -> Terminated -> Retired - ensure Retiree created properly
User: cn=e123039,ou=Users,o=swa-idsat
  swastatus: active
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#005D2000005lshHIAQ
  user: active
  contact: active

4) Active -> Separated -> Retired - ensure Retiree created properly
User: cn=e128864,ou=Users,o=swa-idsat
  cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#00523000001Qa09AAC
  swaStatus - Active
  contact: active
  user: active









IDtoEmpSvc still to do:
 - Error management:
  - Every error should be classified as one of the following:
  - Stop the driver: if the connectivity can no longer be trusted, and we don't want to lose events.
  -




cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#4#



schedule deletion:
cn=SFLicense,cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swa-idsat#1#005D2000005sD7rIAE
cn=EntitlementConfiguration,cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swa-idsat
cn=SFProfile,cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swa-idsat
cn=SFRole,cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swa-idsat

 - remove rows that check for swaEmpSvcBaseRole shortening . .
 - testUserActiveRetiree - add more delay for term

Summary of the issue with IDtoEmployeeSvc:
 - Had a driver deploy about August 28.
 - The deploy missed some policies that were in Git, but not deployed.
 - Aug 28 - last push to prod.
   - Second issue: password not handed to call.
 -



Issues:
 1 - bad deploy, 28th
 2 -


Impact to the system due to the issues
 - Retiree objects were not getting created (retirees not classified): due to missing policy from Aug 28 deploy.
 - Due to a authentication issue, occasionally events were discarded such as rehires, so rehired employees could not log in.
 -

Missing policy:
cn=lib-sub-etp-ClassifyEvent,cn=SWALibrary,ou=DirXML,ou=services,o=swa-idsat#1#4


Fixes:
 - Git -> Pipeline -> will fix classification issue (retiree issue)
 - Password setting will fix occasional event loss (employee rehire issue)


Replay:
 - Retirees since Aug 28 (cn=r* & swaTerminationDate > 27th)
 - Rehires since Aug 28 (swaHireDate? not getting reenabled)
 - Retry IDtoEmployeeSvc.log-failEvents.txt


Later
 - Retirees staying enabled.
 -

 - Deploy & test in QA.
 -





e151000 Sandre Kemar Thompson




11/27/2024 8:00:08 AM
Test case 2 review


retiree added back!
[11/26/24 15:36:26.655]:WorkdayHCM PT:      Action: do-add-dest-object(class-name="User",arg-dn(token-local-variable("plvRetireeObjectDN"))).

Looks like this was due to a misinterpretation of the event: Received swaReitreePB after the retiree obejct was fully deleted, the policy: SWAWRKDAYCFG-pub-ctp-Retirees saw that swastatus was T, and created the retiree again. I don't know how the workday driver would be able to detect this.


[11/26/24 15:36:26.595]:WorkdayHCM PT:      (if-dest-attr 'swaStatus' equal "T") = TRUE.
[11/26/24 15:36:26.596]:WorkdayHCM PT:    Rule selected.
[11/26/24 15:36:26.596]:WorkdayHCM PT:    Applying rule 'Detect retiring employee - add retiree object'.
[11/26/24 15:36:26.597]:WorkdayHCM PT:      Action: do-trace-message(level="3","### Retiree detected, applying business logic ###").




<nds dtdversion="4.5">
  <source>
    <product build="20211210_0504" instance="WorkdayHCM" version="1.3.0.0100">Identity Manager Driver for Workday</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify class-name="User" dest-dn="swa-idsat\Users\e136054" dest-entry-id="1383738" src-dn="Employee_ID-136054">
      <association>Employee_ID-136054</association>
      <modify-attr attr-name="wd-TransactionLog">
        <remove-value>
          <value timestamp="1730885810#20" type="string">2024-10-21T00:00:00.000-07:00-Terminate: Desmond Camp (Terminated) (136054)</value>
        </remove-value>
        <add-value>
          <value>2024-11-26T00:00:00.000-08:00-Edit Worker Additional Data Event: Desmond Camp (Terminated) (136054) on 11/26/2024</value>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="swaRetireePB">
        <remove-all-values/>
        <add-value>
          <value>Y</value>
        </add-value>
      </modify-attr>
      <operation-data DRIVER_REVISION="6.23.0"/>
    </modify>
  </input>
</nds>








11/27/2024 8:10:41 AM
cn=e128864,ou=Users,o=swa-idsat
 - test case 4
 11/27/2024 8:10:48 AM - waiting on socket timeout . .
 - User: inactive
 - Contact: association is gone

  - separation reason added . .should see T to an s . .
11/27/2024 8:15:51 AM - stillw aiting for event . .
11/27/2024 8:17:45 AM . .
11/27/2024 8:20:58 AM - T to an S occured, ended up being isActive false; but was already that way; no update.
     - then update Travel flag - now doing this . .11/27/2024 8:21:47 AM
      - allow IDM to run
      - RID should update in Workday
      - for this scenario they will not get a retiree status as separated people do not get retiree status.

11/27/2024 8:23:10 AM - shelly completed . . should be about 5 mins
11/27/2024 8:28:50 AM -
11/27/2024 8:31:10 AM - got r account, rename back to workday worked.

[11/27/24 09:31:55.155] Message:  IDtoEmployeeSvc-ERR-0059: Update user failed CN=r128864 ErrorCode=UNABLE_TO_LOCK_ROW ErrorMsg=unable to obtain exclusive access to this record or 1 records: 005D2000005smGPIA
 - Later: retry until succeeds

User account: isActive: true . . Logini - this is needed: need to access.
Contact: rid contact is just a shell


cn=e128864,ou=Users,o=swa-idsat
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000iExQAAU

cn=r128864,ou=Users,o=swa-idsat
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#005D2000005smGPIAY

 - funny situation . . must have an enabled account . .
 - profile of retiree
 - role of retiree role
 - Test 4 - appears to be a retiree . .
   - if this was in production: would have got separated status from contact on IDF. ****
   - 4 times a day, 6 hours starting 8:30 am . .

test case 4 complete.

11/27/2024 8:39:55 AM
test case 5
cn=e128928,ou=Users,o=swa-idsat
  Active -> Separated with reason intially
 - Term with WITH separation reason
      - allow IDM to run
      - then update Travel flag
      - allow IDM to run
      - RID should update in Workday - for this scenario they will not get a retiree status as separated people do not get retiree status.
 - 11/27/2024 8:42:44 AM - EmployeeSvc_Employee|||00E2h000000RMSdEAO|||00e2h000000EcRCAA0 was set, A -> S, disabled account.
 - 11/27/2024 8:43:19 AM- shelly done doing travle flag update . .
 - 11/27/2024 8:43:25 AM - waiting . .
 - 11/27/2024 8:51:38 AM


cn=e128928,ou=Users,o=swa-idsat
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#0052h000000iF05AAE

cn=r128928,ou=Users,o=swa-idsat

User: active, prorfilre tiree . .
contact

sell contact:

test 5 complete.



 -
11/27/2024 8:54:36 AM
test case 2
 - e136054
 - Shelly saying still correct . .

 - 11/27/2024 8:57:56 AM- may need to retest


Test Case 2) Terminated -> Retired -> Rehired - ensure activated
Status: All but the rehire.
 - cn=e128933,ou=Users,o=swa-idsat - nope


  cn=r57416,ou=Users,o=swa-idsat
  cn  =IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#005D2000005sD78IAE
  user/contact active . .super odd. .new needed


Test case 2
cn=r61796,ou=Users,o=swa-idsat
11/27/2024 9:02:29 AM - we can proceed with this account r61796
11/27/2024 9:05:26 AM - associations good
11/27/2024 9:09:30 AM - still waiting on rehire
11/27/2024 9:10:23 AM - shelly - done rehire, wating for event
11/27/2024 9:11:39 AM - waiting
11/27/2024 9:14:50 AM - expected r to inactive . .
  shelly - r as active until hiredate . .until 129 . .
    - from workday - accurate by having e . .
    - will have dual role
    - joe says both should be active
    -
Logini: pstatus only from idf . .
 - does IDM wait on that date . .
 - simlier to future termination date?

odd . .tring another account
cn=e32388,ou=Users,o=swa-idsat

test case 5 - needed proper state user:
cn=e75548,ou=Users,o=swa-idsat - termed+ retired
0052h000000iiwwAAA

cn=r75548,ou=Users,o=swa-idsat
005D2000005sD8VIAU


rehtiring sooner than 12/2
11/27/2024 9:38:16 AM - waiting for event 11/29
11/27/2024 9:43:34 AM - waiting
11/27/2024 9:44:06 AM - e75548


11/27/2024 9:48:41 AM- note from shelly - 61796 - did switch to an E immediately
 - 75548 - this one didn't update username . .


FUTURE DATED VERIFICATIONS
test 5: e75548 - confirm user is rehired after 11/29 (shelly: when r to an e in workday, 61796 happened immediate.)
test 3b: e128877 - confirm user is terminated after 11/29

11/27/2024 9:56:01 AM - Monday - Validate future termination set correctly, and future hire date.


11/27/2024 10:10:11 AM
Retroactive Aug 26th
 - Everyone that had been retired or separated since aug 26
 - Eeveryone that had been rehired since aug 26

User set 1: all retirees created since Aug 25 that have a swastatus (to eliminate non rids)
  - Do not include modified since then: Too much data changes for modifyTimestamp to be useable . .

214 - retirees created since aug 25 . .

(&
    (cn=r*)
    (swaStatus=*)
    (|
        (createTimestamp>=20240825000000Z)
    )
)


User set 2: rehires . . finding a way to identify these users . .
  Logini & Jeff . . retire -> rehire: two contact accounts (one e, one r)

PRB0082579

TODO:
 - User set 1: Write code to migrate identified user set, 214 above currently.
 - User set 2: arbitrary id list send migrates for these accounts.



Team, here is the status from our call on Nov 27:
 - Prior to this call, Kyle was able to deploy an update to fix the e -> rid issue in Workday.
 - Completed test cases 4 and 5, and retested case 2, so testing is completed except for two future dated events that are not show stoppers.
 - The two future dated items to verify sometime after 11/29: scheduled on a call on Monday to complete this.
 - Created deploy plan.
 - Aaron set CR for prod deploy of the IDtoEmployeeSvc driver to: 2024-12-02 15:00:00, per CHG0437245
 - Created post deploy plan.

 - Action items:
  Logini - Asking for rehires since August 25th to help replay missed accounts.
  Jeff - see if we can tell how many retires August 25th? - currently 79 contact records; need to verify.
  Aaron - be able to migrate two users sets: one based on ldap query, one based on list of CNs (if we get them from workday)

 - Confirmed we're ready to do prod deploy on Monday.


We also created an explicit deploy plan that we will start Monday at 3pm:

Deploy plan:
Pre-deploy: confirm Kyle has WorkdayHCM change deployed.
1 - Aaron starts CR - at 3 pm
2 - Aaron deploys prod driver.
3 - Aaron verifies an event or two on test accounts in prod.
4 - Aaron closes CR.
5 - Aaron notifies team to begin migration work.
Logini/Jeff Join:
6 - Generate list of users to migrate
7 - Aaron runs code to produce migration push file
8 - Aaron/Logini/Jeff push a few and verify results.
9 - Team push all migration users.
10 - Go live: Dec



After the deploy, the remaining work is as follows (TBD on scheduling, though ideally would be asap.)
 - Fix driver 'Content Not allowed in prolog' issue hiding real error information.
 - Continue error collection process to identify as many error conditions as possible.
 - Classify each error condition based on what we should do, e.g. stop driver, retry event, needs INC, etc.
 - For all errors requring an INC, confirm process and ensure it is working properly (Enterprise Monitoring? Conrad Yanez team?)






























User Set 1: Users that are swaStatus S or T since Aug 25 - 657
(&
    (swaTerminationDate>=20240825000000Z)
    (|
        (swaStatus=S)
        (swaStatus=T)
    )
)


User Set 2 - swaHireDate >= 20240820 - picking date to select between user sets desired
   - All users hired since this date, that have a termination date
   - 68 users . .
   - discussion about e isactive=true, r isactive=false
   - Retiree rehires . .
   - active employees good; status on retiree objects . .
   - retiree became active employee . .
   Since aug 26 - how many retirees rehired? - confirm: - discussion about e isactive=true, r isactive=false
     - rid's suspect . . .
   -
















(&
    (swaTerminationDate>=20240825000000Z)
    (swaHireDate>=20240820)
)




























cn=e999999,ou=Users,o=SWA-ID
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#0053t000009DmmeAAC


Plan:
 - Jeff Wilton to send scenarios to Josh/Workday
 - Aaron to set WorkdayHCM/IDtoEmployeeSvc traces high to capture any terminates in prod.
 - Aaron to enable INVALID_LOGIN error debugging flag to driver.
   - As soon as we confirm it's not IDtoEmployeeSvc causing this problem, Jeff may create us a dedicated account so we don't have this issue any more.
 - Aaron to deploy to QA
 - Aaron to gear up to deploy to production with VP approval.


 - WorkdayHCM - trace high
 - IDtoEmployeeService trace high



Changes to driver needed AFTER Prod:
 - Allow displaying password on demand through trace to confirm daily invalid logins
  - Identify regular lockout problem . .
  - If we don't have an issue from this: Need to move to dedicated acount
  - Jeff: lets do this first - potentially create a dedicted IDM service account . .
  - current account in prod:
    idmsysuser@wnco.com



11/25/2024 11:43:29 AM
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#4#


 - IDtoEmployeeSVCTests > org.idmunit.IdMUnitTestCase.testUserModifyTC4EmptoHR[52] FAILED
    junit.framework.AssertionFailedError: Expected regex: [HR] did not match [Employee]
        at org.idmunit.IdMUnitTestCase.runTest(IdMUnitTestCase.java:153)

1 - Have a retiree object in eDirectory that hasn't gone to IDtoEmployeeSvc
   - sync the user: confirm they are created properly.
   - Confirm rehire has contact - default email
   r1000 - can't use, already there: 0052h000000jSiYAAU
   - WD - Ideally, we'd have them trigger a full termination -> retiree . . .

   r100343 - Success; but may have already existed . .
    User object: Created
    Contact object: Created

   r100766
     - contact present . .not user . .
     - showing all data on the account - filtering for employee
     - base_employee_id__c -> r100766
     - **CM USER** - not tied after just creation of the user object.
      - scheduled job user -> contact/ contact -> user . . can we run manually?
      - User: switch to setup menu, search from there . .running the job . .
      - Coming back to this later: for some reason Gulledge Customer Person Account Persona ccount - possible incorrect role mapping of some sort . .
      - Job should run on a schedule in prod.
    -r100766 - come back! see if user/contact are connected - 11/25/2024 12:29:01 PM- confirmed they are connected!
    HR|||00E2h000000RMSmEAO|||00e2h000000EcRCAA0
    **** - odd: how did the job update it, and not update the 'last modified by'?
       - Jeff - theory: linking contact to user: contact to user . . may not be a system . .
       - almost like another driver is locking out the account? 204.97.14.68 - from Jeff: this is the IP where it is coming from
    -



2 - Terminate -> Rehire
   - Confirm rehire has contact - default email
   - Recent rehire problem . .
   - problem: recently rehired employees are 'inactive'?
   - Checking prod issue
    - instead looking at employee: e125516 that can't log in per INC6278035
    - someone did a manual sync - Message:  IDtoEmployeeSvc-INFO-0001: User ID Found for User :e125516: 0052E00000Ji1kGQAR
       - Know the user existed . .
       - User was enabled: sync event was enough in prod.
   - Noticed at 2:36 AM - failed login until 4:10 am . .
     - Need to detect this problem, and avoid losing events . . .
   - INC6278035 Can be closed by the person that did the sync on the account . .
   - '-failed file'
   - *** - Can use -failed file to come up with users to resync
   - 11/25/2024 12:52:45 PM- Jeff finding this has happened the last few months . .
   - Summary: we were able to confirm - AS long as we don't have the weird lockout problem; this works fine.
     - Willaim Da Souzoua
     e125516
   - We don't need workday folks: but still need to fix invalid login . .
   ****- Do need password on demand fix



3 - Terminate -> Retired -> Rehire
   - This is a superset of case 2; where the WorkdayHCM policy "SWAWRKDAYCFG-pub-etp-RehireRetirees" would dissasociate and remove match attribute, and allow the employee account to be recreated/rematched to IDV, then rematched to employee services


4 - Disable user account (isActive = false on user) - "cme__CM_User__c" on contact was lost . .
   Answer: - Renable the account then run user -> Contact & Contact -> User jobs
   - Job runs how often in production? Once a day at 6 am and 7 for the other job.


5 - Broken user migration test:
   - Define sets of users to re-push
   Sync these users:
   - All CN=r* & swaTerminateDate > Aug 26th
   ***-

   Logini Use cases:
    1 - Terminate -> Rehire - ensure rehire activation works properly
    2 - Terminate -> Retire -> rehire - ensure actived
    3 - Active -> Retired - ensure retired created properly
   Josh coordinating this.

1 - Terminate an account with pass benefits (create a retiree account).
2 -








Document list of fixes . .
High priority
 - Proper Assignment of the lib-etp-ClassifyEvent to identify users.
   - 95% - fixes retiree issue: where they couldn't log in due to missing their contact object.
   - Possibly fixes employee rehire issue
 - Fixed issue with supporting sync events.
   - Allows us to push users through the driver on demand.

Others:
 - Fixed authentication issue on driver restart.





TBD & TODO -
 - Good logging (per Sept, 2024 - should have INC mechanism in place.)
   - Suppressed INC management . .
   - New driver went live: issues are suppressed; supposed to active inc
 - INC detection/creation
 -















CHG0437245 - https://southwest.service-now.com/nav_to.do?uri=change_request.do?sys_id=083bed5ac38a965478ce3fff050131fa%26sysparm_view=Standard



Can I please get a review for each of my CRs? We need to deploy as soon as manual tests pass and we get approvals
QA review task: https://southwest.service-now.com/nav_to.do?uri=change_task.do?sys_id=27a665d2c34a965478ce3fff05013185%26sysparm_view=Standard
Prod review task: https://southwest.service-now.com/nav_to.do?uri=change_task.do?sys_id=668ba1dac38a965478ce3fff050131a7%26sysparm_view=Standard

Planned Start Date
2024-11-25 12:00:00

CHG0437236 - QA: Deploy/Update ----  IDM Driver IDtoEmployeeSvc update to resolve issues around retirees & recent rehires, and resolve INC6276942, INC6278035



    Current Primary server: w11qcledirqi013
    Current Backup server: hdqqcledirqi013
    Designer version: 4.8.7.0100
    Driver to deploy: IDtoEmployeeSvc
    Driver version number: 12.5.2
    Team responsible for the changes: Cybersecurity EE Team

    CSEE Deployment: IDtoEmployeeSvc
    Change Number: CHG0437236
    Change Owner/POC: Me
    Environment: QA
    Implementation: Deploy/Update ----  IDM Driver IDtoEmployeeSvc update to resolve issues around retirees & recent rehires, and resolve INC6276942
    Change Window: 2024-11-25 12:00:00
    Reason For Change: Resolve recent retiree/rehire issues, and fix INC6276942
    Impact: None.
    Outage: A few moments during a driver restart.




CHG0437245 - Prod: Deploy/Update ----  IDM Driver IDtoEmployeeSvc update to resolve issues around retirees & recent rehires, and resolve INC6276942, INC6278035
  URL for CR: https://southwest.service-now.com/nav_to.do?uri=change_request.do?sys_id=083bed5ac38a965478ce3fff050131fa%26sysparm_view=Standard

https://southwest.service-now.com/nav_to.do?uri=change_task.do?sys_id=668ba1dac38a965478ce3fff050131a7%26sysparm_view=Standard


    Current Primary server: w11scledirsi009
    Current Backup server: sdcpcledirpi013
    Designer version: 4.8.7.0100
    Driver to deploy: IDtoEmployeeSvc
    Driver version number: 12.5.2
    Team responsible for the changes: Cybersecurity EE Team


    CSEE Deployment: IDtoEmployeeSvc
    Change Number: CHG0437245
    Change Owner/POC: Me
    Environment: Prod
    Implementation: Deploy/Update ----  IDM Driver IDtoEmployeeSvc update to resolve issues around retirees & recent rehires, and resolve INC6276942
    Change Window: 2024-11-26 08:00:00 (As soon as possible to resolve P2 incidents
    Reason For Change: Resolve recent retiree/rehire issues, and fix INC6276942
    Impact: None.
    Outage: A few moments during a driver restart.




11/25/2024 10:46:46 AM
 - Items to test: confirm we can restore a relationship after a disable (isActive = false, -> isActive = True, does cm_User get restored?)
 - retiree contact creation: confirm objecttype classification and default email is set
 - Josh: recent rehires?
 -

Ok, to summarize, here's what I think I've heard so far for items we need to test in FCS3:

1 - Confirm a user being converted to a retiree ends up properly created (with a contact) and can authenticate to EmployeeSvc(Salesforce)
2 - Confirm a user that has been recently rehired is properly re-enabled in EmployeeSvc.





11/22/2024 2:17:16 PM
COME BACK LIST:
 - 9/16 latest contact: confirm this!! see if we can create them now . .
   - LIkely related to object type
 - interesting: does status break relationship?? can't really inacttivate a contact . . .




From 3 montsh ago: this is why retirees are staying active!
52295a8
   <rule>
                            <description>Change status for retiree deleted</description>
                            <comment xml:space="preserve">This rule checks to see if retiree deleted. IF so, then user status is inactive</comment>
                            <conditions>
                                <and>
                                    <if-class-name mode="nocase" op="equal">User</if-class-name>
                                    <if-op-property mode="nocase" name="objectType" op="equal">retiree</if-op-property>
                                </and>
                            </conditions>
                            <actions>
                                <do-if>
                                    <arg-conditions>
                                        <and>
                                            <if-operation mode="nocase" op="equal">delete</if-operation>
                                        </and>
                                    </arg-conditions>
                                    <arg-actions>
                                        <do-set-op-property name="Op-User-Status">
                                            <arg-string>
                                                <token-global-variable name="gcvEmployeeSvcStatusInActive"/>
                                            </arg-string>
                                        </do-set-op-property>
                                    </arg-actions>
                                    <arg-actions>
                                        <do-set-op-property name="Op-User-Status">
                                            <arg-string>
                                                <token-global-variable name="gcvEmployeeSvcStatusActive"/>
                                            </arg-string>
                                        </do-set-op-property>
                                    </arg-actions>
                                </do-if>
                            </actions>
                        </rule>
                    </policy>





Good to know:
 - IDF/DRiver - contacts. .
 - cme__CM_User__c may not be able to be read by the driver user . . .gets cleared from contact when user is disabled.
 - estimating: Aug 15: driver was correct (estimating) that retirees were active




11/22/2024 2:00:25 PM
User: Active - TRUE/FALSE
Contact: STatus field: Active/Rtireed/terminated/separated


From QA:
cn=r48986,ou=Users,o=swa-idsat
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#005D2000005sD7rIAE


Ron Jones
User: Active
  <sf:IsActive>true</sf:IsActive>

Contact: retired
  Payload: <sf:SWACM_Customer_Specific_Employee_Status__c>Retired</sf:SWACM_Customer_Specific_Employee_Status__c>


11/22/2024 2:26:29 PM
CHANGES:
IsActive is now false!!!

causes 'CM User' link to go away!!
one field that

cme__CM_User__c



















































IDtoEmployeeSvc
Major findings:
 - Found and fixed an issue with authentication if the matcing rule never gets hit after driver restart.
    - Engineering details: lvCreds only set in matching rule! if match attempt not completed; then it's not set; now set on driver startup policy.
 - Found and confirmed adding the missing policy resolves the retiree creation problem.
 - Found and fixed the issue stopping sync events from processing properly.




cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#4#



 - I see 17,458 total retiree objects, and only 18 fall into this funny 'active retiree' state. I'd love to confirm that this is the known/desired state that so few have this access. The app going live on Dec 2; would it apply to only these 18 people? I don't have an issue with this; but that's only .1 percent of all retirees and want to be explicit that this is correct.




<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise
.soap.sforce.com"><soapenv:Header/><soapenv:Body><urn:login><urn:username>idm.employeesvc@wnco.com.fc3swa</urn:username><urn:password></urn:password></urn:login></soapenv:B
ody></soapenv:Envelope>





IDtoEmployeeSvc-ERR-0059: Update user failed CN=r8898875060ErrorCode=UNKNOWN_EXCEPTION ErrorMsg=group membership operation already in progress





comfirm in dev: adding the classify user policy fixes retiree creation problem.



Hey, any change at all in prod is not allowed except with VP approval right? One of the items missed during the deploy, is simply a policy that wasn't attached. ll the code is there; but not firing.  I assume re-attaching this policy and restarting the driver would still require a vpn approval right? The reason I ask, is that it is





CHG0436849 QA - Deploy/Update ----  IDM Driver IDtoAviobook (RBEAEv1 entitlements only) update to add new roles.
w11qcledirqi013
hdqqcledirqi013

    Current Primary server: w11qcledirqi013
    Current Backup server: hdqqcledirqi013


     Current Primary server: w11pcledirpi010
     Current Backup server: sdcpcledirpi010
     Designer version: 4.8.7.0.100
     Driver to deploy: IDtoDocunet
     Driver version number: 1.4.0







11/18/2024 3:01:06 PM
Debgging odd retiree retry
[11/18/24 16:00:48.814]:IDtoEmployeeSvc ST:          Arg Value: "Retry Status: [1/5] IDtoEmployeeSvc-INFO-0012: Create contact success CN=r8898866197 EmpSVC ContactId=003D200000pQiNZIA0 Association has been added".
[11/18/24 16:00:48.814]:IDtoEmployeeSvc ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoEmployeeSvc
     Channel:  Subscriber
     Object:   \DEV_SWACO_ID\swaiddev\Users\r8898866197
     Status:   Retry
     Message:  Retry Status: [1/5] IDtoEmployeeSvc-INFO-0012: Create contact success CN=r8898866197 EmpSVC ContactId=003D200000pQiNZIA0 Association has been added
[11/18/24 16:00:48.816]:IDtoEmployeeSvc ST:Requesting 30 second retry delay.
[11/18/24 16:00:48.818]:IDtoEmployeeSvc ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoEmployeeSvc
     Channel:  Subscriber
     Status:   Retry
     Message:  Code(-9174) A policy issued a "retry" status indicating that the current operation should be retried. Detail from policy: Retry Status: [1/5] IDtoEmployeeSvc-INFO-0012: Create contact success CN=r8898866197 EmpSVC ContactId=003D200000pQiNZIA0 Association has been added


this is the time and the event I created that gets retried
```

[11/18/24 16:00:47.189]:IDtoEmployeeSvc ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <add cached-time="20241118220047.123Z" class-name="User" event-id="w11dcledirdi019#20241118220047#3#2:5ca0dce5-3dfc-4a58-bbc7-e5dca05cfc3d" qualified-src-dn="O=swaiddev\OU=Users\CN=r8898866197" src-dn="\DEV_SWACO_ID\swaiddev\Users\r8898866197" src-entry-id="587815" timestamp="1731967245#24">
      <add-attr attr-name="Given Name">
        <value timestamp="1731967245#22" type="string">goose</value>
      </add-attr>
      <add-attr attr-name="swaStatus">
        <value timestamp="1731967245#24" type="string">R</value>
      </add-attr>
      <add-attr attr-name="homeEmailAddress">
        <value timestamp="1731967245#6" type="string">goose.retiree@test.wnco.com</value>
      </add-attr>
      <add-attr attr-name="Surname">
        <value timestamp="1731967245#3" type="string">retiree</value>
      </add-attr>
    </add>
  </input>
</nds>

```






Team, here is the status from our call on Nov 27:  
- Prior to this call, Kyle was able to deploy an update to fix the e -> rid issue in Workday.  
- Completed test cases 4 and 5, and retested case 2, so testing is completed except for two future dated events that are not show stoppers.  
- The two future dated items to verify sometime after 11/29: scheduled on a call on Monday to complete this.  
- Created deploy plan.  
- Aaron set CR for prod deploy of the IDtoEmployeeSvc driver to: 2024-12-02 15:00:00, per CHG0437245  
- Created post deploy plan.

- Action items:  
  Logini - Asking for rehires since August 25th to help replay missed accounts.  
  Jeff - see if we can tell how many retires August 25th? - currently 79 contact records; need to verify.  
  Aaron - be able to migrate two users sets: one based on ldap query, one based on list of CNs (if we get them from workday)

- Confirmed we're ready to do prod deploy on Monday.

We also created an explicit deploy plan that we will start Monday at 3pm:

Deploy plan:  
Pre-deploy: confirm Kyle has WorkdayHCM change deployed (this will not happen though isn't a concern; just a note on the current state.)
1 - Aaron starts CR - at 3 pm  
2 - Aaron deploys prod driver.  
3 - Aaron verifies an event or two on test accounts in prod.  
4 - Aaron closes CR.  
5 - Aaron notifies team to begin migration work.  
Logini/Jeff Join:  
6 - Generate list of users to migrate  
7 - Aaron runs code to produce migration push file  
8 - Aaron/Logini/Jeff push a few and verify results.  
9 - Team push all migration users.  
10 - IDtoEmployeeSvc Team go-live: early December

After the deploy, the remaining work is as follows (TBD on scheduling, though ideally would be asap.)  
- Fix driver 'Content Not allowed in prolog' issue hiding real error information.  
- Continue error collection process to identify as many error conditions as possible.  
- Classify each error condition based on what we should do, e.g. stop driver, retry event, needs INC, etc.  
- For all errors requring an INC, confirm process and ensure it is working properly (Enterprise Monitoring? Conrad Yanez team?)

12/10/2024 2:11:22 PM
10 r/e accounts that were missing: . .all are deleted, so I assume they don't need to be pushed through; Logini is out today; may talk tomorrow:

(|
(cn=R4738)
(cn=r103505)
(cn=r105764)
(cn=r116125)
(cn=r118014)
(cn=r138744)
(cn=r31257)
(cn=r44817)
(cn=r77622)
(cn=r93311)
(cn=e4738)
(cn=e103505)
(cn=e105764)
(cn=e116125)
(cn=e118014)
(cn=e138744)
(cn=e31257)
(cn=e44817)
(cn=e77622)
(cn=e93311)
)

12/10/2024 2:56:26 PM
12/2/2024 9:36:57 AM
IDtoEmployeeSvc - test case 3b ok and passed, TEst case 5 started inactive . .not valid eid for scenario.
test case 4 - 128865

128928
   - active to separation reason code
   - IDM ran, tralve updated, idm ran.
   - separated with r id.
   - employee id should have ahd an updated by -
 -128928 -
   - double checking these for e/r ids.
 - User: eid active
   contact: r inactive





12/2/2024 6:49:15 AM
idtoempsvc
tc2 45 - HR, but was employee

test failures . .boo!


take a look at this in dev:
https://southwest.gitlab-dedicated.com/csiam/idm/IDtoEmployeeSvc/-/jobs/75526498
IDtoEmployeeSVCTests > org.idmunit.IdMUnitTestCase.testUserModifyTC3HRtoEmp[53] FAILED
    junit.framework.AssertionFailedError: Expected regex: [Employee] did not match [HR]
        at org.idmunit.IdMUnitTestCase.runTest(IdMUnitTestCase.java:153)


in QA: https://southwest.gitlab-dedicated.com/csiam/idm/IDtoEmployeeSvc/-/jobs/75526502
IDtoEmployeeSVCTests > org.idmunit.IdMUnitTestCase.testUserModifyTC2LeaderHR[45] FAILED
    junit.framework.AssertionFailedError: Expected regex: [HR] did not match [Employee]
        at org.idmunit.IdMUnitTestCase.runTest(IdMUnitTestCase.java:153)

IDtoEmployeeSVCTests > org.idmunit.IdMUnitTestCase.testUserModifyTC4EmptoHR[52] FAILED
    junit.framework.AssertionFailedError: Expected regex: [HR] did not match [Employee]
        at org.idmunit.IdMUnitTestCase.runTest(IdMUnitTestCase.java:153

IDtoEmployeeSVCTests > org.idmunit.IdMUnitTestCase.testUserTerm[42] FAILED
    junit.framework.AssertionFailedError: swaEmpSvcBaseRole expected:<[EmployeeSvc_HR]> but was:<[EmployeeSvc_HR|||00E2h000000RMSmEAO|||00e2h000000EcRCAA0]>

IDtoEmployeeSVCTests > org.idmunit.IdMUnitTestCase.testUserTerm[45] FAILED
    junit.framework.AssertionFailedError: swaEmpSvcBaseRole expected:<[EmployeeSvc_HR]> but was:<[EmployeeSvc_HR|||00E2h000000RMSmEAO|||00e2h000000EcRCAA0]>



12/10/2024 3:03:02 PM
Older confirmation - regarding the url switcharoo after authentication.

Guys, I got it. I hadn't realized the test.salesforce.com seems to send us to a different location based on what we log in with, see this:



When we authenticate using https://test.salesforce.com/services/Soap/c/47.0/0DFS00000008iMR, If we use the QA credentials, it sends us to FC3 -
https://swa--fc3swa.sandbox.my.salesforce.com/services/Soap/c/47.0/00D2h0000008eea/0DFS00000008iMR



Then this post succeeds!



4/25/2025 10:16:02 AM
Had working session with Jeff/Logini - random notes:



INC6558445
cn=r43664,ou=Users,o=SWA-ID
role/profile was correct; but user was not synchroinzed to empsvc.
EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO




IDtoEmployeeSvc | IDM | Monitor New Error Manager
https://southwest.atlassian.net/browse/CSEE-4778
Story points 3 - level of effort on this is a little higher, as we're trying to collect any errors that are infinte retries.


4/29/2025 1:06:45 PM



cn=e59369,ou=Users,o=swa-idsat
EmployeeSvc_Leader|||00E2h000000RMSuEAO|||00e2h000000EcRCAA0
EmployeeSvc_Leader|||00E2E000002RP3aUAG|||00e2E000001IUCdQAO

4/28/2025 2:51:48 PM
new error:
(-9174) A policy issued a "retry" status indicating that the current operation should be retried. Detail from policy: IDtoEmployeeSvc-ERR-0059: Update user failed CN=e8898797356ErrorCode=UNABLE_TO_LOCK_ROW ErrorMsg=unable to obtain exclusive access to this record or 1 records: 005Dl00000C5t1VIAR
Waiting for data... (interrupt to abort)





Log in again .. maybe only attempt once?

DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoEmployeeSvc
     Channel:  Subscriber
     Status:   Retry
     Message:  Code(-9174) A policy issued a "retry" status indicating that the current operation should be retried. Detail from policy: IDtoEmployeeSvc-RETRY-001
: ErrorMsg=RETRY: HTTP 500 Server Error, SOAP faultcode=sf:INVALID_SESSION_ID




========================================================
4/29/2025 1:36:30 PM
mpsvc updates:
IDtoEmployeeSvc connector:
  %refProgramTeam_RoleName% = ADA ACT Leader



$.roles[*].id


Hello sir - I've been able to confirm the EMPDEV1 username/password; but not the client id/secret value:





4/29/2025 1:37:04 PM


FCreate of retiree in prod:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com"
 xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<soapenv:Header>
<urn:SessionHeader>
</urn:SessionHeader>
</soapenv:Header>
<soapenv:Body>
<urn:create>
<urn1:sObjects xsi:type="urn1:User">
<urn1:TimeZoneSidKey>America/Chicago</urn1:TimeZoneSidKey>
<urn1:LocaleSidKey>en_US</urn1:LocaleSidKey>
<urn1:EmailEncodingKey>ISO-8859-1</urn1:EmailEncodingKey>
<urn1:LanguageLocaleKey>en_US</urn1:LanguageLocaleKey>

<Alias>AIban</Alias>
                                <Username>r35317@wnco-eshr.com.prod</Username>
                                <FederationIdentifier>r35317</FederationIdentifier>
                                <EmployeeNumber>r35317</EmployeeNumber>
                                <ProfileId>00e2E000001IUCiQAO</ProfileId>
                                <UserRoleId>00E2E000002RP3oUAG</UserRoleId><FirstName>Amy</FirstName><LastName>Ibanez</LastName><Email>r35317@default.wnco.com</Email></urn1:sObjects>
</urn:create>
</soapenv:Body>
</soapenv:Envelope>




Create in QA:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com"
 xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<soapenv:Header>
<urn:SessionHeader>
</urn:SessionHeader>
</soapenv:Header>
<soapenv:Body>
<urn:create>
<urn1:sObjects xsi:type="urn1:User">
<urn1:TimeZoneSidKey>America/Chicago</urn1:TimeZoneSidKey>
<urn1:LocaleSidKey>en_US</urn1:LocaleSidKey>
<urn1:EmailEncodingKey>ISO-8859-1</urn1:EmailEncodingKey>
<urn1:LanguageLocaleKey>en_US</urn1:LanguageLocaleKey>

<Alias>JBarr</Alias>
                                <Username>e193804@wnco-eshr.com.prod.empuat1</Username>
                                <FederationIdentifier>e193804</FederationIdentifier>
                                <EmployeeNumber>e193804</EmployeeNumber>
                                <ProfileId>00e2E000001IUCdQAO</ProfileId>
                                <UserRoleId>00E2E000002RP3JUAW</UserRoleId><FirstName>Josiah</FirstName><LastName>Barry</LastName><Email>e193804-invalid@wnco.com</Email></urn1:sObjects>
</urn:create>
</soapenv:Body>
</soapenv:Envelope>

4/29/2025 1:37:35 PM




SWACM_Employee_ID__c


Odd this user had two assocs . .doing a #4# after deletilng both
cn=e7582,ou=Users,o=swa-idsat
cn=IDtoEmployeeCarePicture,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#068D2000002ZG6bIAG
cn=IDtoEmployeeCarePicture,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#1#068D2000002ZG6gIAG






Logini, Jeff,

Just to give you a quick status; here is the state of things:

1 - IDtoEmployeeSvc, the main driver is in place and processing properly against EMPUAT1.
2 - EmployeeServicesRoleMgmt driver, the driver that assigns roles is properly assiging the roles; though I suspect the reitree role may be incorrect.
3 - IDtoEmployeeCarePicture: this driver responsible for the images appears to need more configuration. I'm working with Jeff to resolve ASAP.

In the mean time, I've created a user, e97454 in EMPUAT1 that you should be able to see now.  I went ahead and attempted to push a retiree; though The role/profile combo I have for retirees may be incorrect. I'll work with Jeff to resolve this as well.


DETAILS:

Successfully created user in EMPUAT1:
e97454 - created in EMPUAT1
   - id: cn=e97454,ou=Users,o=swa-idsat
   - role and profile: EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO

Failed to create retiree in EMPUAT1:
r45990 - Attempted in EMPUAT1 (FAILED)
   - Failed: getting this error when using this retiree role/profile:
   EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO
   - Error received:
    FIELD_INTEGRITY_EXCEPTION: role type must match user type
   - This is the URL and payload that caused the above integrity exception to see if we could debug it.

This URL:
  https://southwest-es--empuat1.sandbox.my.salesforce.com/services/Soap/c/47.0/00Ddl000000miht

Sent this this payload:
```

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com"
 xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Header>
        <urn:SessionHeader>
        </urn:SessionHeader>
    </soapenv:Header>
    <soapenv:Body>
        <urn:update>
            <urn1:sObjects xsi:type="urn1:User">
                <urn1:Id>0052E00000LowNOQAZ</urn1:Id>
                <urn1:LocaleSidKey>en_US</urn1:LocaleSidKey>
                <urn1:EmailEncodingKey>ISO-8859-1</urn1:EmailEncodingKey>
                <urn1:LanguageLocaleKey>en_US</urn1:LanguageLocaleKey>
                <Username>r45990@wnco-eshr.com.prod.empuat1</Username>
                <FederationIdentifier>r45990</FederationIdentifier>
                <EmployeeNumber>r45990</EmployeeNumber>
                <Alias>NKemp</Alias>
                <IsActive>TRUE</IsActive>
                <FirstName>Nancy</FirstName>
                <LastName>Kemp</LastName>
                <Email>r45990@default.wnco.com</Email>
                <ProfileId>00e2E000001IUCiQAO</ProfileId>
                <UserRoleId>00E2E000002RP3oUAG</UserRoleId>
            </urn1:sObjects>
        </urn:update>
    </soapenv:Body>
</soapenv:Envelope>

```





EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO




cn=e97456,ou=Users,o=swa-idsat
old FC3 association: #4# this on empuat1 . .
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#0#00523000001VgeUAAS

https://southwest.gitlab-dedicated.com/csiam/idm/IDtoEmployeeSvc/-/merge_requests/35
https://southwest.gitlab-dedicated.com/csiam/idm/EmployeeServicesRoleMgmtDriver/-/merge_requests/34
https://southwest.gitlab-dedicated.com/csiam/idm/IDtoEmployeeCarePicture/-/merge_requests/17/commits



Write up how the driver deals with this; and that we'll hit it a lot when moving between FC3 and EMPUAT1.
"Received INVALID_CROSS_REFERENCE_KEY; which likely means association is invalid. Removing and retrying: IDtoEmployeeSvc-ERR-
0059: Update user failed CN=e97455ErrorCode=INVALID_CROSS_REFERENCE_KEY ErrorMsg=invalid cross reference id".









Testing errors with this:
cn=e177432
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#4#


HOw am I seeing this again, while auth is checked on startup?

04/21/25 14:59:36.341]:IDtoEmployeeSvc ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoEmployeeSvc
     Channel:  Subscriber
     Object:   \DEV_SWACO_ID\swaiddev\Users\e177432
     Status:   Retry
     Message:  IDtoEmployeeSvc-RETRY-001 : ErrorMsg=RETRY: ECMA exception at LINE 103: exception: JavaException: org.xml.sax.SAXParseException: Content is not allowed in prolog.
[04/21/25 14:59:36.345]:IDtoEmployeeSvc ST:




    CSEE Deployment: Deploy/Update ----  IDM Driver IDtoEmployeeSvc update to point to EMPUAT1, add error manager
    Change Number: CHG0463802
    Change Owner/POC: Me
    Environment: QA
    Implementation: Deploy/Update ----  IDM Driver IDtoEmployeeSvc update to point to EMPUAT1, add error manager
    Change Window: 2025-04-21 17:00:00
    Reason For Change: Need to point to EMPUAT1 endpoint; and will be updated to have better error support.
    Impact: None, except for driver restart which takes < 1 min
    Outage: None, except for driver restart which takes < 1 min




CHG0463802
CSEE-4679 Update IDtoEmployeeSvc to point to EMPUAT1, and add simplified error manager


 - Move to EMPUAT1 for qa now . .


```

<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.10.0.0100">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify cached-time="20250420072105.489Z" class-name="User" event-id="w11dcledirdi019#20250420072105#2#38:768756dc-ae4d-41de-b234-dc5687764dae" qualified-src-dn="O=swaiddev\OU=Users\CN=e192613" src-dn="\DEV_SWACO_ID\swaiddev\Users\e192613" src-entr
y-id="601501" timestamp="1745133660#142">
      <modify-attr attr-name="Given Name">
        <remove-value>
          <value timestamp="1745069468#24" type="string">Jarrod</value>
        </remove-value>
        <add-value>
          <value timestamp="1745133660#116" type="string">Brandon</value>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="Surname">
        <remove-value>
          <value timestamp="1745069468#26" type="string">Schultz</value>
        </remove-value>
        <add-value>
          <value timestamp="1745133660#142" type="string">Westbrook</value>
        </add-value>
      </modify-attr>
    </modify>
  </input>
</nds>
```

[04/20/25 11:26:41.064]:IDtoEmployeeSvc ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoEmployeeSvc
     Channel:  Subscriber
     Status:   Retry
     Message:  Code(-9174) A policy issued a "retry" status indicating that the current operation should be retried. Detail from policy: IDtoEmployeeSvc-ERR-0057:Create user failed CN=e192613 ErrorCode=REQUIRED_FIELD_MISSING ErrorMsg=Required fields are missing: [Email, ProfileId]





5/7/2025 10:53:30 AM
My chat with Josh Saulson - trying to determin why some users don't have a 'CM User' reference on their contact object . . especially when we can see a urn:update in the payload below . . it's almost like the alias matches up with the contact, and that's what populates it; but this is a complete guess.

5/7/2025 10:33:37 AM
call with Josh: PXP alumni portal: only for retiree
  Screen share to discuss r accounts missing id . .
   - have to be active retiree, and have userid . .
   - background process creates contact id - sync happens automatically to 'sync up' user to contat . .
   - Workday has a list of retirees that they maintain
   - spreadsheet: etirement elibble and travel benefits . .
   - On PXP report - vlookup -
   - sowing me how he selected a set of users that couldn't log in . .-
   - another 16 on this page that don't have access . .
   - curios why on pxp report if not travel elegible . .
   - 2XX - 24 - 273 - why active contacts, but not on workday's report?
   - What is missing? (aaron)
   - have to have active an active id . .
   *****- r2757 - doesn't have CM User populated from contact that points back to a user . .

Just for your notes, here's the payload that appears to have fixed r101420: There's nothing obvious about it that would fix a user . .except maybe something like the 'Alias' matches up with a contact, so that's what connects them again is my working theory is anyway:
 ```

<?xml version="1.0"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <soapenv:Header>
    <urn:SessionHeader>
    </urn:SessionHeader>
  </soapenv:Header>
  <soapenv:Body>
    <urn:update>
      <urn1:sObjects xsi:type="urn1:User">
        <urn1:Id>0054w00000DWm03AAD</urn1:Id>
        <Alias>LStoc</Alias>
        <IsActive>TRUE</IsActive>
        <ProfileId>00e2E000001IUCiQAO</ProfileId>
        <UserRoleId>00E2E000002RP3oUAG</UserRoleId>
      </urn1:sObjects>
    </urn:update>
  </soapenv:Body>
</soapenv:Envelope>
```

5/7/2025 10:55:04 AM

helpful commands to do the review - this'g ets the cns . .
grep lib-CheckError-IDtoEmployeeSvc reviewMe | awk -F '\\' '{print $7}' | awk '{print $1}' | sort | uniq > usersToFixRoles


                EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO

5/7/2025 9:56:32 AM
4 roles currently in production:

     <definition display-name="Employee SVC HR Role Name" name="gcv_SVC_HR_Role" type="string">
                        <description/>
                        <value>EmployeeSvc_HR|||00E2E000002RP3SUAW|||00e2E000001IUCdQAO</value>
                    </definition>
                    <definition display-name="Employee SVC Leader Role" name="gcv_svc_leader_role" type="string">
                        <description/>
                        <value>EmployeeSvc_Leader|||00E2E000002RP3aUAG|||00e2E000001IUCdQAO</value>
                    </definition>
                    <definition display-name="Employee SVC employee Role" name="gcv_svc_Emp_Role" type="string">
                        <description/>
                        <value>EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO</value>
                    </definition>
                    <definition display-name="Employee SVC retiree Role" name="gcv_svc_Retiree_Role" type="string">
                        <description/>
                        <value>EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO</value>
                    </definition>





5/9/2025 11:31:13 AM
Have hit some concerns with the employeeSvc team; I want to help them and make sure they have what they need; so I sent this to dhivya and ben justnow:


Dhivya, Ben,

  

Sorry for the book-sized email; I have a plan here that I think will help regain her confidence, though we can cover it when/if we meet later. Here's a cookie 🍪 to make it more bearable 🙂.  Happy weekend!

  

  

Summary:

  

I put together an email here for the EmployeeSvc team that I'd like to pass by you. I would like to deploy the latest versions of the EmployeeSvc drivers (IDtoEmployeeSvc, IDtoEmployeeCarePicture, and EmployeeServicesRoleMgmtDriver) through production over the next few days. In an effort to regain trust and be super transparent, we've typically decided to do something like this. This is a deeply detailed list of updates regarding the driver. My only hesitation is that it can create possible issues as they may expect this kind of detailed information in the future. This isn't bad; just takes more time than we typically don't have. This does give her the ability to have a discussion with her 'SA' . .(not sure what that is yet); but does give all of us some power to make visible choices across both EE and the app team. It could also trigger a few calls & working sessions where we go into further detail, which again, aren't terrible and would help regain their trust but again will require additional time.

  

These updates are a deeply improved error management in the driver; along with documentation and a KTs session with Ops (On May 14th). I feel good about the updates made and lets us more easily identify new issues that I haven't seen yet from the goofy Salesforce SOAP API.  Ops should be able to jump in and help fix issues, in many cases, before the App team even knows about it, which would be a major win here. 

  

  

Please let me know your thoughts. It won't break my heart if we need to go another route or change the email message below.

  

  

  

  

  

  

Logini,

  

I have the following changes that I will be completing validation in QA in the next day or so. Once you are good with the updates and have communicated with your leadership, let me know and I'll proceed.  The main changes are around error handling. I've documented every error I saw, and will have a KT session with Ops to see if we can all work to resolve issues on the driver; ideally even before INCs need to be generated manually.

  

Please let me know if you have any questions:

  

DETAILS:

  

The following changes will bring the driver from 12.5.6 to 12.5.11. (Note: the 0.0.5 version bump is not significant; it simply increases every time I run a build. I add them here so we can identify which driver is in which environment. Right now, here are the versions and the environment they're in:

  

DEV:  12.5.11

QA:   12.5.11

Prod: 12.5.6

  

 - Driver build has been updated as follows. These changes were made to avoid using FC3 for now, and to better isolate testing. Jeff was able to provide working credentials and working roles/profile combinations - Thx Jeff!!

      - Driver in DEV now using EMPDEV1.

      - Driver in QA is now using EMPUAT1.

      - Driver in Prod is unchanged.

  

  - The driver no longer incorrectly processes users that are missing a role definition, or has a role definition that does not use the correct format. This reduces false error reporting when users are simply not ready to be processed. Roles can be fixed realtively easily now; then the driver will proceed.

 - Driver now verifies authentication upon startup. This will remove issues with trying to verify the authentication after the driver deploys.

 - Driver no longer hides authentication issues, and now gives the error message provided by the API. While these aren't always super useful, it's much better than having the error hidden.

 - Email notifications for previously identified all-driver situations have been updated to the latest.

 - 12 issues have been identified and will be communicated to Ops on May 14th in a KT session.

  See the information located in the 'Response Codes / Troubleshooting -> Error Management' section of the driver documentation here: [https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver](https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver)

 - A better error handler has been added: 'lib-checkError' will now retry everything indefinitely except for items that cannot succeed on a retry. This resolves several issues:

   - Events are no longer lost: If the driver gets into a situation where retrying doesn't resolve a situation I haven't categorized yet, we'll get an INC regarding the cache being too large, and then we can decide what to do about it, and let the driver continue.

   - 6 of the issues that required special handling has been added. Some situations the driver is able to identify and recover from automatically now.

   - Additional people interested in keeping the driver up and running have been added to the new email notification sent for the newly classified errors. Once these people are trainined up, we may update the list to be the Ops distribution list when they are ready to help resolve issues.

  

 I believe having Ops better informed and working to manage a driver that can more easily report and classify errors will really help us here. Also note that we have MANY roles to fix throughout the tree for users that have been there for years

  

--Aaron

5/9/2025 10:10:10 PM
proof that drivers were stopped: per my CTASK on 
	note: x238772 was als oon the serve r. not sure who that is . .

[edir@w11scledirsi009 ~]$ w
 23:01:56 up 53 days, 21:06,  2 users,  load average: 0.12, 0.77, 0.89
USER     TTY      FROM             LOGIN@   IDLE   JCPU   PCPU WHAT
x238772  pts/0    10.138.169.227   22:42    8:52   0.05s  0.00s sshd: x238772 [
x266698  pts/1    10.193.19.125    23:01    3.00s  0.03s  0.00s sshd: x266698 [
[edir@w11scledirsi009 ~]$ dxcmd -port 1524 -user ax266698.admins.swa-id

	
![[{5893F8D3-0225-4076-A045-17A5FC6B928B}.png]]



5/12/2025 11:18:24 AM
Prod work recently:

New url due to their ugprade over the weekened
https://login.salesforce.com/services/Soap/c/63.0/0DFQn0000000gyX

NOte: driver restarted about 2.5 hours early for some reason:
[05/10/25 02:38:29.113]:IDtoEmployeeSvc :Trace Level: 44




Jeff and team, I heard that there may be a new connection URL for IDM after the upgrade/changes on your side. Is this the case? I have not received a new URL yet, I'll wait another 15 minutes from now, then proceed with reenabling the drivers with the old connection URL, https://login.salesforce.com/services/Soap/c/47.0/0DFS00000008iMR.


5/10/2025 9:22:12 PM
prod empsvc authetnication; valid as of now
idmsysuser@wnco.com
SWAIDMSys@2025.03.04TKiMpqB0BYr38gEDdgY8xX4oO

POST: https://login.salesforce.com/services/Soap/c/63.0/0DF4w000000kA03
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com">
   <soapenv:Header>
      <urn:LoginScopeHeader>
      </urn:LoginScopeHeader>
   </soapenv:Header>
   <soapenv:Body>
      <urn:login>
         <urn:username>{{empsvcProdUserName}}</urn:username>
         <urn:password>{{empsvcProdUserPassword}}</urn:password>
      </urn:login>
   </soapenv:Body>
</soapenv:Envelope>

```

<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="urn:enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Body>
        <loginResponse>
            <result>
                <metadataServerUrl>https://southwest-es.my.salesforce.com/services/Soap/m/63.0/00D2E000000ps8Z</metadataServerUrl>
                <passwordExpired>false</passwordExpired>
                <sandbox>false</sandbox>
                <serverUrl>https://southwest-es.my.salesforce.com/services/Soap/c/63.0/00D2E000000ps8Z/0DF4w000000kA03</serverUrl>
                <userId>0052E00000JhSAPQA3</userId>
                <userInfo>
                    <accessibilityMode>false</accessibilityMode>
                    <chatterExternal>false</chatterExternal>
                    <currencySymbol>$</currencySymbol>
                    <orgAttachmentFileSizeLimit>5242880</orgAttachmentFileSizeLimit>
                    <orgDefaultCurrencyIsoCode>USD</orgDefaultCurrencyIsoCode>
                    <orgDefaultCurrencyLocale>en_US</orgDefaultCurrencyLocale>
                    <orgDisallowHtmlAttachments>false</orgDisallowHtmlAttachments>
                    <orgHasPersonAccounts>false</orgHasPersonAccounts>
                    <organizationId>00D2E000000ps8ZUAQ</organizationId>
                    <organizationMultiCurrency>false</organizationMultiCurrency>
                    <organizationName>Employee Services Case &amp; Leave</organizationName>
                    <profileId>00e2E000001IUChQAO</profileId>
                    <roleId>00E2E000002RP3rUAG</roleId>
                    <sessionSecondsValid>900</sessionSecondsValid>
                    <userDefaultCurrencyIsoCode xsi:nil="true"/>
                    <userEmail>jeffery.wilton@wnco.com</userEmail>
                    <userFullName>IDM SystemUser</userFullName>
                    <userId>0052E00000JhSAPQA3</userId>
                    <userLanguage>en_US</userLanguage>
                    <userLocale>en_US</userLocale>
                    <userName>idmsysuser@wnco.com</userName>
                    <userTimeZone>America/Chicago</userTimeZone>
                    <userType>Standard</userType>
                    <userUiSkin>Theme3</userUiSkin>
                </userInfo>
            </result>
        </loginResponse>
    </soapenv:Body>
</soapenv:Envelope>
```


5/13/2025 2:36:04 PM
Email #1 to Logini for error resolution:

Logini,

  

I'm working on getting the full list of attribute-based issues, but I wanted to give a high-level review of what we've done so far:

  

1 - swaEmpSvcBaseRole/swaEmpSvcElevatedRole issues will be included in LDIF files as soon as I can collect all issues I can think of. This is the request for all broken roles I am working on now.

  

2 - Driver/API based issues have now been fully documented.  Please see the 'Response Codes / Troubleshooting -> Error Management' section of the driver documentation here: [https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver](https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver "https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver")

  

3 - The driver error manager has been completed. It can now properly retry various issues, and retries the rest, properly triggering an INC if the cache ends up in a overload state.  Please review the doc above for more details.

  

4 - We need to schedule a UAT to go through the most recent updates to show you the resolution to the issues and ensure your team is on board. I am working on putting together a comprehensive set of tests we can go through. We'll review the issues documented above, and see what we need to test, and if we can uncover any other issues.

  Some examples of tests will be:

  1 - Confirming the driver will not start without valid credentials (this resolves 2 issues).

  2 - Confirm attribute-based issues (#1 above) can be resolved now by the system, then pushed to EmployeeSvc. This set of issues appear in at least two kinds of categories: incorrectly formatted values, and 'wrong' role/profileIDs.

- And so on as needed.
    

  

5 - UAT sign off: Once the UAT testing has completed in #4 and all has passed, we'll schedule the production deploy.

  

  

Once I've sent the file(s) for #1, let me know when we could schedule the UAT & issue review.

  

--Aaron


Email #2 for error resolution:

Logini & team,

  

I had a lot to say here, please let me know if you'd benefit from a discussion.

  

Attached is the lists of attribute-based issues I've found so far. At the moment, I am unable to think of any additional queries I can run to detect errors. I believe that all of our issues either fall into the attribute-based error category or an API issue that was described in item #2 in my previous email. These files will help resolve the first category of issues, the 'attribute-based' issues. Per my previous email, Items #2, #3, and #4 will help resolve issues related to the API. The drivers can now better deal with issues and will help to keep them more visible as we work to minimize user-reported issues. We will confirm this in our UAT. Please note that if/when we find attribute-based issues outside of this set, I'll look to see why I did not include them.

  

Please let me know how you would like to proceed, and/or if you would like to talk about file format, and how to use them. I believe in the past you may have benefited from CSV files, let me know your preferences and which attributes from the users are useful to include.

  

  

  

  

DETAILS:

Attached is a zip file with permutations of attribute value-based issues found in the system.  By far, the largest list is the 11,328 retiree users who have an incorrect retiree role. I do not have complete context on why these values are bad, but it is likely that they are still populated with the old style of the role when the UserApp driver was removed a while back. I have some vague memories of engineers working on fixing roles, but this was before I had started working on the drivers, and can not offer additional historical information. The EmployeeSvc drivers can fix these issues automatically now, however, since base roles are based on each users's base attributes they not typically automatically re-evaluated. The re-evaluation only happens when a user is created, explicitly changes roles, or we push the user through manually.

  

  

**Resolution for attribute-based issues:** A large portion (if not all) of these issues can be fixed by pushing the users through the role determination code again. Some minor additional cleanup can be done as needed, as described below. Here is a description of the files attached. The ML prefix is 'master list', along with a user count found in that file. As I've come up to speed on learning the system, the role assigning mechanisms and started researching API behavior in the drivers I've learned more about how & why the system behaves as it does. The files are text files, and can be opened with any text based editor.

  

  

ML-11328-RetireeRolesBad.ldif - Have only a value of 'EmployeeSvc_Retiree' and no role or profile ID. As mentioned, this was the old method for assigning roles, when another process (UserApp) was used to assign roles. This UserApp process was based on software from OpenText that was no longer supported, was showing issues and no longer allowed us to properly set values so we needed to remove it and move to the new 3 value format (human readable + role id + profiled). It appears not all users were resolved during the work here.

  

ML-75-HaveBothBaseAndElevatedRolePopulated.ldif - These simply have both the base and elevated role specified. This isn't technically an issue as only the elevated role is used if specified, but this state can be confusing to Ops and other IDM engineers trying to manage the roles on these users. Resolution: delete the swaEmpSvcBaseRole value.

  

ML-19-emp-roles-issues.ldif - This file has users where the format of the role is bad and is not assigned to the proper user, for example: a retiree may have an employee role instead, causing them to be improperly categorized in EmployeeSvc.

  

The remaining files have additional leader/hr roles that can be resolved the same way; but there's only a total of two in these categories.

  

ML-1-empsvc_leader-issues.ldif

ML-1-HR-rolesbad.ldif

  

  

--Aaron

5/13/2025 3:52:52 PM
Note: These are some of the permutations I could come up with to uncover any issues. Please note that some of these roles are set on the wrong user type; such as retirees having the EmployeeSvc_Leader.


This covers users that have a valid formatted retiree role; but it isn't the correct value:
(&
(swaEmpSvcBaseRole=EmployeeSvc_Retiree*) - 11,328
(!(swaEmpSvcBaseRole=EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO))
)


HR role populated, bad value: 1 total
(&
    (swaEmpSvcBaseRole=EmployeeSvc_HR*)
    (!(swaEmpSvcBaseRole=EmployeeSvc_HR|||00E2E000002RP3SUAW|||00e2E000001IUCdQAO))
)

emprole - excluding eleveated roles . . 19
(&
    (swaEmpSvcBaseRole=EmployeeSvc_Employee*)
    (!(swaEmpSvcBaseRole=EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO))
    (!(swaEmpSvcElevatedRole=*))
)

emprole - excluding eleveated roles . . 35
(&
    (swaEmpSvcBaseRole=EmployeeSvc_Employee*)
    (!(swaEmpSvcBaseRole=EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO))
    (!(swaEmpSvcElevatedRole=*))
)

EmployeeSvc_Leader role incorrect:
(&
    (swaEmpSvcBaseRole=EmployeeSvc_Leader*)
    (!(swaEmpSvcBaseRole=EmployeeSvc_Leader|||00E2E000002RP3aUAG|||00e2E000001IUCdQAO))
)

Logini, there are various files attached here.

ML-11328-RetireeRolesBad.ldif
ML-38-HaveBothBaseAndElevatedRolePopulated.ldif
ML-35-emp-rolesbad-but-eleveantedMayBeOk.ldif
ML-19-emp-roles-issues.ldif
ML-3-empsvc_leader-bad-but-elevated.ldif
ML-1-empsvc_leader-issues.ldif
ML-1-HR-rolesbad.ldif





5/13/2025 3:54:45 PM
5/13/2025 8:46:34 AM
Email to Logini

Logini,

I'm still working on getting a full list of issues, but I wanted to give a high level review now:

1 - swaEmpSvcBaseRole/swaEmpSvcElevatedRole issues will be included in LDIF files as soon as I can collect all issues I can think of. This is the request for all broken roles I am working on now.
2 - Driver/API based issues have now been fully documented.  Please see the 'Response Codes / Troubleshooting -> Error Management' section of the driver documentation here: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver
3 - The driver error manager has been completed. It can now properly retry 6 explicit issues, and retries the rest.  Read the doc above for more details.
4 - We need to schedule a UAT to go through the most recent updates to show you the resolution to the issues and ensure your team is on board. I am working on putting together a comprensive set of tests we can go through.
  Some examples of tests will be:
  1 - Confirming the driver will not start without valid credentials.
  2 - Confirm attribute based issues (#1 above) can be resolved now by the driver; then pushed to EmployeeSvc. This set of issues appear in at least two kinds of categories: incorrectly formatted values, and 'wrong' role/profileIDs.
5 - UAT sign off: Once the UAT testing has completed in #4 and all has passed, we'll schedule the production deploy.







Logini,

I have the following changes that I will be completing validation in QA in the next day or so. Once you are good with the updates and have communicated with your leadership, let me know and I'll proceed.  The main changes are around error handling. I've documented every error I saw, and will have a KT session with Ops to see if we can all work to resolve issues on the driver; ideally even before INCs need to be generated manually.

Please let me know if you have any questions:

DETAILS:

The following changes will bring the driver from 12.5.6 to 12.5.11. (Note: the 0.0.5 version bump is not significant; it simply increases every time I run a build. I add them here so we can identify which driver is in which environment. Right now, here are the versions and the environment they're in:

DEV:  12.5.11
QA:   12.5.11
Prod: 12.5.6

 - Driver build has been updated as follows. These changes were made to avoid using FC3 for now, and to better isolate testing. Jeff was able to provide working credentials and working roles/profile combinations - Thx Jeff!!
      - Driver in DEV now using EMPDEV1.
      - Driver in QA is now using EMPUAT1.
      - Driver in Prod is unchanged.

  - The driver no longer incorrectly processes users that are missing a role definition, or has a role definition that does not use the correct format. This reduces false error reporting when users are simply not ready to be processed. Roles can be fixed realtively easily now; then the driver will proceed.
 - Driver now verifies authentication upon startup. This will remove issues with trying to verify the authentication after the driver deploys.
 - Driver no longer hides authentication issues, and now gives the error message provided by the API. While these aren't always super useful, it's much better than having the error hidden.
 - Email notifications for previously identified all-driver situations have been updated to the latest.
 - 12 issues have been identified and will be communicated to Ops on May 14th in a KT session.
  See the information located in the 'Response Codes / Troubleshooting -> Error Management' section of the driver documentation here: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver
 - A better error handler has been added: 'lib-checkError' will now retry everything indefinitely except for items that cannot succeed on a retry. This resolves several issues:
   - Events are no longer lost: If the driver gets into a situation where retrying doesn't resolve a situation I haven't categorized yet, we'll get an INC regarding the cache being too large, and then we can decide what to do about it, and let the driver continue.
   - 6 of the issues that required special handling has been added. Some situations the driver is able to identify and recover from automatically now.
   - Additional people interested in keeping the driver up and running have been added to the new email notification sent for the newly classified errors. Once these people are trainined up, we may update the list to be the Ops distribution list when they are ready to help resolve issues.

 I believe having Ops better informed and working to manage a driver that can more easily report and classify errors will really help us here. Also note that we have MANY roles to fix throughout the tree for users that have been there for years









 - Putting together lists of attribute based issues
 - Need to show you API based issues, and the fixes we'll do for it.
 - Plan for UAT testing
 - Plan to deploy
 - Pland to resolve


IDtoEmployeeSvc - does the connection
IDtoEmployeeCarePicture - swaimage
EmployeeServicesRoleMgmtDriver - Determins base role 4 . .



 - Finish categorizing errors
 - document how we'll fix each
 - point to driver page
 - Schedule a UAT! - Add Angie, Ben, Brad.
   - Sign off in an email or screen shots: offically capture sign off with evidence . .
   - Assign stories to customer . .
   - They have a sign off story . . .
     - AC of the story would be the sign off evidence . . .
     - Story is on our board; and assigned to analyst - assign app team as 'watchers'
     - Allows all watchers to respond.
 - Show resolution of errors . .
 - Need Sign off . .





I"m putting together a response now to deal with a newly reported user issue, and start the conversation about some proactive error resolution, and the next release of the drivers that should cover all of the erros I know baout. She also was in a chat with others, and asked about another retiree that had a role from an old configuration the driver.





I'm putting together a mster list of all issues I can find. Theres a few categories, and the one reported this morning, I wasn't aware of: there's a lot of retirees that were created when we still had the UserApp driver in place, and we have not done a good job in setting all the proper roles; so I"m working on getting that resolved.


r23554
swaEmpSvcBaseRole=EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO
                  EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO


5/12/2025 4:40:31 PM
master list for roles to fix in EmployeeSvc.
Logini,

A portion of the issues are due to incorrect swaEmpSvcBaseRole/swaEmpSvcElevatedRole attributes. These are the style of issues that we can resolve. Another portion of the known issues will be resolved with the next release of the Employee Service drivers to production.






Logini,

The issues we've seen so far have fallen in to quite a few different categories; but thankfully most can be resolved the same way. With this in mind, I've approached this issue list by resolution methods instead of problem categories:

1 - Resoluion by role resetting (swaEmpSvcBaseRole and swaEmpSvcElevatedRole):
  The correct format of these attributes is: the human friendly/readable role name, plus three bars: '|||', plus the role ID, plus three bars: '|||', plus the profile id. The Role and Profile ID are environment specific. If id's come through the driver that are not meant for that environment, you'll get a weird error that recommends that you ask for additional rights to set those roles.

  Resoluion of swaEmpSvcBaseRole values: This attribute is populated by the EmployeeServicesRoleMgmtDriver (ESRMD). If the base role value is
  incorrect, or in the wrong format, the base role can simply be deleted. The ESRMD driver will re-calculate the role and populate. Then the IDtoEmployeeSvc driver takes the update and writes it to EmployeeServices.


2 - Resolution of issues by the driver:
  There is now a table of 12 issues I've seen from the driver, along with a description, status, resolution notes, and other info. This is where I have made code updates to the driver to see if we can minimize the number of broken users.

  Please see the "Resppingnse Codes / Troubleshooting -> Error Management section".

5/16/2025 12:45:00 PM


5/15/2025 11:37:40 AM
Employee services meeting - sent this update to pms:
Updates: EmployeeSvc: Just had retiree discussion meeting. The bottom line is that there is some new work, a bug fix, Continued research into current retiree issues, then, long term: handing off the resolution work to Ops.

Baron also brought up that we should determine which team should take point on this. Unless I've been assigned or need to be assigned to something else, I could stay on these drivers.

Details:
 - We talked about various states retirees could be in that may affect how we process them.
 - From the EmployeeSvc perspective, if a user has a retiree object, it should be active and have rights in Employee services (except for the new work in the next item).
 - NEW: Discussed Retirees that lose their pass benefits need to be disabled in employeeSvc: I believe this is a new ask and is new work.
 - NEW: I just found a bug in the driver: if a user is deleted in eDirectory, they should lose access in EmployeeSvc.


Baron and I have synced up on this, and have a reasonable understanding of the next actions which are:

Next actions:
1 - Question 1: if a retiree account gets created with status of S, what is the base role assingment? I can't tell if this is an existing, working use case in the drivers.
2 - If we fix roles en-masse, I need to confirm how nosiy the driver is going to be and what kind of INCs will be generated if any.
3 - NEW WORK: if an r account is deleted from edir or  and swaREitreePB change to !Y -> IsActive = false . .
4 - NEW WORK: if
4 - Stories . . Confirm with Baron to finalize requirements . .







?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="urn:enterprise.soap.sforce.com">
  <soapenv:Header>
    <LimitInfoHeader>
      <limitInfo>
        <current>43805</current>
        <limit>431355000</limit>
        <type>API REQUESTS</type>
      </limitInfo>
    </LimitInfoHeader>
  </soapenv:Header>
  <soapenv:Body>
    <updateResponse>
      <result>
        <id>0054w00000CCoTpAAL</id>
        <success>true</success>
      </result>
    </updateResponse>
  </soapenv:Body>
</soapenv:Envelope>





5/15/2025 11:08:18 AM






5/15/2025 10:43:31 AM
Baron chat on retiree
Q - REtiree of S - setting role propbelry?
 - Baron - two scenarios when we have an rid; both should therotieclly be temporary (pass benefits are prelivige)
 to create retiree: swaReitreePB = Y
 - tells workday to create rid . .
 - regardless of swaStatus . .could be a T/R/S at the time
 - Normal retiree: have swaStatus = R . .username r*  & swaretireeb
 -


  1 - to create retiree


swaRetireePB=Y

Status of an S . . cong to have an rid in both cases . . .

Normal:
swaStatus = R
  cn = r12345
  swaRetireePB = Y
  loginDisabled != TRUE

Separated with Benefits:
  swaStatus = S
  cn = r12345
  swaRetireePB = Y
  loginDisabled != TRUE

If have an r account should ahve access - on the removal we have a problem . .
   - don't send retireepb . . if we delet eout of the vault: doesn;t vlow . .
   - users are separted, not going to get a new status . . pass benefits then revoked . .
   - don't know if we delete immediately in the vault . .
   - effectively no attributes are changing when they lose access . .
   - if we do store retireepb . . if does change prior to deletion . .

   - regardless of VSP - only reason why you have retiree . . having passbenefits . .
   - if swaReitreePB = N, no longer need in system!





from IAM - we'll delete account . .can't log in
 - they want us to send an actual event . .
 - swaREtireePb

 - IsActive - set to false
  - on deletion: set isActive to false . .
  - swaRetireepb changes to anyting byt a Y - IsActive to false . .

EmployeeSvc_HR|||00E2E000002RP3SUAW|||00e2E000001IUCdQAO
EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO
EmployeeSvc_Leader|||00E2E000002RP3aUAG|||00e2E000001IUCdQAO
EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO











5/15/2025 9:48:30 AM
EmpSvc review meeting
Katherine Boschert - running meeting
slide dec
TESS determines retirement eleigibliyt
   - Marci: retirement & indicators sent to IDM, then rid generated.
   -

Logini -
eid record terminated
rid genreated from idm & sent to workday
(new from jeff tegue)

short; TESS Retirement Elgibility --> Workday --> IDM (creates rID)

 Two categories of issues:
   1 - bad, or incorrect roles
   2 - An issue diuring

Baron: only have the base role.
(incorrect) swaEmpSvcBaseRole = EmployeeSvc_Retiree
(correct) swaEmpSvcBaseRole = EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO

Baron: vsp vs retiree . .status of S vs Status of R

*** - Retirees with Status of S . .
*** Use Case / Feature Request: VSP Users losing privileges should be indicated as such in Employee Salesforce Org
   - Active vs not . .for retirement validation . .
   - baron: what is expecte benefit when lsing pass benefits: logini - user account inactivated

Jeff Teague: do we need to move S back to T?
 - Marci: don't have way to chagne status: have to change term code in workday.
   - Marci would like to not use separated status for these kinds of events. Creating term codes for a VSP.
   - Marci and jeff teague: clarifiying T -> R . .workday event . .
   - Marci: can't S -> T - no business process in workday . .S is an SWA only thing
   - Baron: changing term codes around vsp?
   - Marci: never done S -> R . .if we did this, now revoke retiree event . .
   - Tess: marci getting more famliar with it:
      2 ways  . . .retiree field + travel eligblity yes/no
      - marci thinking that reitree there is having issue . .
      - if travel elbibliy is no . .
Marci sharing screen 5/15/2025 10:25:24 AM
 - Cliffye Elyse - status of retire, travel elibity no . .
 - thinks this is a vsp . .
 - if they have a N, should they have a retired status??
 - Jeff: yes based on current implemetnation . .should be separted with limited access
 - marci: could need a limited set of access . .
 - VSP - 2020 - until 2024 . . back to 2022, back to active.
 - left again in 2025 - vsp travel expired in 24, shouldn't have retiree indicator or vsp . .
 - these poepl getting it back . .if hr status
 Boomerang cases: coming back while in or out of travel elibility . .
  - marci: should not get eligbilty if they come back during their elibitlity . .
 - Katherine: defning next steps
   - Jeff/Marci? - marci: like to chat with travel friends . .
   - Baron - term vs separated?

Baron and aaron to talk about travel benefits: yes vs no . .
Josh: 109 people - no sw retirement: travel benefits . .










  As near as I can tell all 4 of these users appear to be good on the edir side; so likely just need to be pushed:
  - I want to see what we're fixing in the employeeSvc side; so we can find others in the same state and proactivelyf ix them.





initial users to check.:

grep -iE "R49183|r15198|r23554|r16738"

(|
(cn=R49183)
(cn=r15198)
(cn=r23554)
(cn=r16738)
)

Correct role values in produciton as of May 2025:

EmployeeSvc_HR|||00E2E000002RP3SUAW|||00e2E000001IUCdQAO
EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO
EmployeeSvc_Leader|||00E2E000002RP3aUAG|||00e2E000001IUCdQAO
EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO

  INC?XXXXXX  R49183 - the pptx file says the user is good. The role looks good, and user has an association . .seems ok; can't say more without pushing again.
  INC6601072: Veronica Afo - cn=r15198,ou=Users,o=SWA-ID - User not in Master list bad role files, Role is good . .association is good, can't say more without pushing again.
  INC6603533: Bill Alexiou - cn=r23554,ou=Users,o=SWA-ID - User not in master list bad role files, Role is good . .association is good, can't say more without pushing again.
  INC6578410: Benny McCuistion - cn=r16738,ou=Users,o=SWA-ID - I ran the master list files after this user was resolved; though the role before fixing was one of the old 'EmployeeSvc_Retiree' roles - and would have showed up in the "ML-11328-RetireeRolesBad.ldif" file - marked as resolved, this user I believe originally had a bad role, and fixing the role allowed the user to flow.




5/16/2025 4:44:41 PM

5/16/2025 1:56:56 PM

Katherine,

Jeff and I had an excellent discussion on recent issues and wanted to update you on issues (both retiree access issues and otherwise):

We were able to confirm 3 root causes of issues:
1 - The PXP Permission Set assignment flow fails when Contact/User triggers are enabled and activity levels are high.
  Possible workaround/solution: run the triggers after hours.

2 - IDM Role issues: Master-list files have been generated listing users with broken roles in eDirectory. These do not guarantee there are problems; only that the driver won't be able to properly proceed without manual intervention.
  Workaround/Solution: Push the users through the role evaluation process, and confirm they flow to EmployeeSvc; while someone can validate that data is updated properly.

3 - IDM API related issues: The latest updates to IDtoEmployeeSvc has a much better error handler that should be able to proactively notify us when there are issues; by either an email, or an INC in the case of new issues.
  Workaround/Solution: I'm working on setting up a UAT session to test the latest updates in the driver, then will deploy to prod when the EmployeeSvc team is ready for it.






Jeff, Here's the items learned/confirmed in our meeting today. Please add/modify if you disagree or need to fix something; I wanted to record what we learned; as I'll forget over a weekend :-)

1 - We have the following categories of issues:
  On the IDM side:
   - Situations where roles are incorrect (not using the three piece style)
     - We've identified the users with issues, adn produces 'master lists' that have been sent to Logini and team.
   - Situations where the API reports an error
     - The driver has a much better management of errors now; just need to do the UAT to deploy to prod.

  On the EmployeeSvc side:
   - We believe there may be a trigger + locking timing issue that Jeff has discovered; though running the triggers after hours to set roles & tie users to contacts has mitigated this issue.
   - Jeff has a way to monitor for this specific issue regularly on his side.



Jeff Wilton - about 5/16/2025 2:55:21 PM
Funny, I was also working on a recap:
Just wanted to recap our findings so far.
Two separate root causes have been identified
1. The PXP Permission Set assignment flow fails when Contact/User triggers are enabled (during off-business hours)
2. IDM can fail when trying to update an existing User that has does not have the "newer" profile-to-role mapping assigned.

For issue #1, this is not caused by IDM, but the Flow will run successfully when IDM re-pushes the User record during business hours/while triggers are inactive. To fix the root cause will require further analysis by PXP/ESP teams.

For issue #2, Aaron can fix by manually re-pushing the older user records so that they receive the proper profile-to-role mapping.




Jeff
Questions:
 - Can we see a pattern with broken users?
 - Can we confirm a retiree is fully fixed?
r23554 -

Summary of issues/considerations
 - Contact does not show users (CM User field):
  Contact from IDF
  User from IDM
  - which ever is last causes the sync up
  *actual syncup after hours triggers
-


Notes:
Jeff is confident: any active retiree should have access that does not have access, should be ok . .
   - Query not showing anyone broken . .
   - could be other issues . .
   - Jeff: pretty clear on issues; and what he can confirm with his query
   - Jeff: maybe run query automatically? Jeff currently keeping an eye on this . .

UAT planning:
   - Logini
   - Jeff
   - Josh Salson
   - Come up Error management . .
     - driver checks authetnication on startup
     - Session renewal . .



Jeff: *****LOWER PRIORITY:****** thinks this is on his side; though idm push may help.
INC?XXXINC6618124XXX    R49183 - the pptx file says the user is good. The role looks good, and user has an association . .seems ok; can't say more without pushing again.
INC6601072: Veronica Afo - cn=r15198,ou=Users,o=SWA-ID - User not in Master list bad role files, Role is good . .association is good, can't say more without pushing again.
  Both of these: Harsha fixed both of these: manually fixing the flow . .
  Two separate issues:
   1 - Permission sets not applied due to error on platform/application side . .
   2 - Jeff: strange thing: user role is blank . . .
   - record looked good; but missing permission sets . .16 others with this issue . .
  Jeff: already fixed all these . .
  Jeff to keep an eye on this . .Missing permission sets query!!
     - Issue sems to be happening when we get a retiree reocrd from IDF; we want to sync the contact to the user . .
     - The linkage from contact to the user is temporarily disabled . .
     - it's disabled because they use a trigger process that may be locked up due to high usage . .
     - Jeff: turned off triggers during business hours to proces records . .
     - All of these cases where the flow fails; could be failing during the time tirggers are running . .
     summary: triggers trying to udpate users; associted contact updated, user fails due to trigger: chicken/egg
     - When triggers not enabled: shouldn't ahve problem at all . .User record updated, fine . .
       - permissions will be applied later in the day . .
       - issue realy only happening during contact to user sync . .
       - working to get rid of this . .temporary issue; connectme . .going away?




INC6603533: Bill Alexiou - cn=r23554,ou=Users,o=SWA-ID - User not in master list bad role files, Role is good . .association is good, can't say more without pushing again.
   Didn't seem like any action has ahpened
   - 5/12 - didn't work
   - 5/13 - @ 10:02 am. - got user data??\
   Questions: why are two events so different??
   Quesiton: Why did it fix the user?
   Jeffs thoughts: Could have started out as inactive . . .
     - but if was active; may have been the case as the first two . .
     - Repushing the user record may have triggered the event . .This is good to know . .****
  REmove retiree role:
  ```

avk: note: this is an example of a merge user . .different than an update or create; happens on an <add> event; so just not associated!

  <?xml version="1.0"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <soapenv:Header>
    <urn:SessionHeader>
    </urn:SessionHeader>
  </soapenv:Header>
  <soapenv:Body>
    <urn:update>
      <urn1:sObjects xsi:type="urn1:User">
        <urn1:Id>0052E00000LovzDQAR</urn1:Id>
        <urn1:LocaleSidKey>en_US</urn1:LocaleSidKey>
        <urn1:EmailEncodingKey>ISO-8859-1</urn1:EmailEncodingKey>
        <urn1:LanguageLocaleKey>en_US</urn1:LanguageLocaleKey>
        <Username>r23554@wnco-eshr.com.prod</Username>
        <FederationIdentifier>r23554</FederationIdentifier>
        <EmployeeNumber>r23554</EmployeeNumber>
        <Alias>WAlex</Alias>
        <IsActive>TRUE</IsActive>
        <FirstName>William</FirstName>
        <LastName>Alexiou</LastName>
        <Email>r23554@default.wnco.com</Email>
        <ProfileId>00e2E000001IUCiQAO</ProfileId>
        <UserRoleId>00E2E000002RP3oUAG</UserRoleId>
      </urn1:sObjects>
    </urn:update>
  </soapenv:Body>
</soapenv:Envelope>
```

    REtiree role added back:
    Alias: 1 of firstname, 4 charachtesr of surname
     - It appears the role was reset at this time, which caused the following event to work properly:
      ```
      <?xml version="1.0"?>
      <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
        <soapenv:Header>
          <urn:SessionHeader>
          </urn:SessionHeader>
        </soapenv:Header>
        <soapenv:Body>
          <urn:update>
            <urn1:sObjects xsi:type="urn1:User">
              <urn1:Id>0052E00000LovzDQAR</urn1:Id>
              <Alias>WAlex</Alias>
              <IsActive>TRUE</IsActive>
              <ProfileId>00e2E000001IUCiQAO</ProfileId>
              <UserRoleId>00E2E000002RP3oUAG</UserRoleId>
            </urn1:sObjects>
          </urn:update>
        </soapenv:Body>
      </soapenv:Envelope>
```


Has a few incs . .
INC6582125
INC6578410: Benny McCuistion - cn=r16738,ou=Users,o=SWA-ID - I ran the master list files after this user was resolved; though the role before fixing was one of the old 'EmployeeSvc_Retiree' roles - and would have showed up in the "ML-11328-RetireeRolesBad.ldif" file - marked as resolved, this user I believe originally had a bad role, and fixing the role allowed the user to flow.
   -
<?xml version="1.0"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <soapenv:Header>
    <urn:SessionHeader>
    </urn:SessionHeader>
  </soapenv:Header>
  <soapenv:Body>
    <urn:update>
      <urn1:sObjects xsi:type="urn1:User">
        <urn1:Id>0054w00000CtSOoAAN</urn1:Id>
        <urn1:LocaleSidKey>en_US</urn1:LocaleSidKey>
        <urn1:EmailEncodingKey>ISO-8859-1</urn1:EmailEncodingKey>
        <urn1:LanguageLocaleKey>en_US</urn1:LanguageLocaleKey>
        <Username>r16738@wnco-eshr.com.prod</Username>
        <FederationIdentifier>r16738</FederationIdentifier>
        <EmployeeNumber>r16738</EmployeeNumber>
        <Alias>BMcCu</Alias>
        <IsActive>TRUE</IsActive>
        <FirstName>Benjamin</FirstName>
        <LastName>McCuistion</LastName>
        <Email>r16738@default.wnco.com</Email>
        <ProfileId>00e2E000001IUCiQAO</ProfileId>
        <UserRoleId>00E2E000002RP3oUAG</UserRoleId>
      </urn1:sObjects>
    </urn:update>
  </soapenv:Body>
</soapenv:Envelope>



=<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com"
 xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <soapenv:Header>
     <urn:SessionHeader>
     </urn:SessionHeader>
  </soapenv:Header>
  <soapenv:Body>
      <urn:update>
         <urn1:sObjects xsi:type="urn1:User">
          <urn1:Id>0054w00000CtSOoAAN</urn1:Id>
         <Alias>BMcCu</Alias>
                                <IsActive>TRUE</IsActive>
                                <ProfileId>00e2E000001IUCiQAO</ProfileId>
                                <UserRoleId>00E2E000002RP3oUAG</UserRoleId>
                        </urn1:sObjects>
      </urn:update>
  </soapenv:Body>
</soapenv:Envelope>



Large vs msall doc - found and sent to jeff Wilton:
FYI: I found that the larger API doc was due to a merge: when the driver needs to re-associate the user; the larger merge doc is sent.  The second smaller doc is just a standard update user when the role is being re-evaluated and fixed; so good news: we have lots of options to resolve accounts, and can decide whether or not we need a full merge, or just role update.

```




| -5/30/2025 9:56:07 AM
| -EmpSvc discussion:
| -Learned the following items
| - - About mid last year or so Logini and I were looking at higher priority stuff, and saw that users were not being disabled; but put it on the todo list as what we were doing needed to be resolved first; and I haven't made it back yet to this until now:
| -
| -Current code: The code attempts to disable users in one of two situations:
| -  - swaStatus change to S or T (note: there may be a bug here: separated retirees would be disabled up front, we don't want this)
| -  - Deletion of account
| -
| -Thoughts:
| -  - The deletion of an account does not properly disable the user (it attempts to set role/profile and they're not available so event fails).
| -
| -Flow: Employees:
| -  - Workday sends a terminate - swaStatus of T
| -     - IDtoEmployeeSvc sets isActive to false.
| -  - Workday sends a delete - remove the account from eDirectory
| -     - IDtoEmployeeSvc: does nothing on a delete.
| -
| -
| -
| -
| -Flow: Employee -> terminated, created retiree
| -  - Workday sends a terminate - swaStatus of T or S for the Employee
| -     T: - **Ensure eid gets set to isActive = false
| -     S: - **Ensure retiree gets through the system . .
| -       - **endup with a retiree with swaStatus of S - the user created disabled.
| -
| -     - Create Retiree object
| -       - Copies data from employee.
| -       - Q: swaStatus - Confirm - Logini: always swaStatus R on a retiree . . .
| -         - Caveat: Some retirees have lifetime benefit . .enabled and active always
| -           - EmployeeSvc can't tell if lifetime or vsp - vsp has timeframe . . .
| -           - VSP - Voluntary separation - same benefit as retiree; but expires . .
| -           - swaRetireePB?
| -           - flight benefits: Ben is it only flights? Is there a business requirement for something outside of flight benefits? when expired, loss of flight benefits only?
| -       - * retiree is enabled and ready to go.
| -
| -  - Workday sends a delete - remove the account from eDirectory (e account)
| -     - IDtoEmployeeSvc: does nothing on a delete.
| -
| -**Note: employeeSvc has only visibility into active or inactive accounts. If they have pass benefits, yes active - if remove access, inactivate account . .
| -  POC - Workday
| -
| -
| -  - Goal: Keep the disabling should be done on the terminate instead . .
| -
| -  - (not done) Separated retirees: still need to test this scenario: after chatting with Baron, I know what these look like now and can test them specifically.
| -
| - - VSP & retirees look identical in empsvc
| -
| - - if you take vsp - come through as retiree, no issues.
| - - if not elegible for benefits, come through as retiree still; only deactivated after 5 years . .
| - - if VSP, r id exists.
| -
| -
| -
| -
| -
| - I have not reproduced the problem in the INC6652030; here's the resarch I've done:
| -  - Active User - then terminated, this works.
| -  - Active retiree - then terminated, this works
| -
| -  The normal process to disable on a terminate does appear to be working - EMPDEV user test e899972837, and r8998878882; but not on the 23 users.
| -
| -  Logs have rolled off, and I don't have any recent deletes; but I'll keep looking.
| -    5/30/2025 10:53:38 AM - NEW: at 2:31 this morning a user: e55414 was terminated, and is properly disabled. . .
| -
| -
| -  ***Goal***: Have events succeed, or know about them before the customers do.
| -
| - - Complete UAT & deploy latest updates: Any time the API returns an error now, we'll see one of these things happen:
| -  1 - If the error is known, and the driver can resolve the issue, it will.
| -  2 - if the error is known, and won't work on a retry, an email notification will be sent (INC generation is still not available for this)
| -  3 - if the error is not known; but works on a retry; the issue would be resolved.
| -  4 - if the error is not known, it will retry until the cache is full; and this does trigger an INC; since it's just a file system monitor.
| -
| -
| -Future: Move to newer API? SCIM . .?
| -
| -
| -

Actual notes sent in an email:
Team,

Today we discussed the INC6652030, and further clarified steps that need to be taken before we can deploy to production. I wanted to send this out to have a history and notes on what we discussed.

The key items were:

We need to differentiate between VSP, and long term benefit users (retirees)
We need to know if we can rely on the swaRetireePB flag from Workday to indicate when users lose access.
Terminations/separations of employees need to properly disable accounts.
The latest version of the driver will process errors in 1 of 4 ways; which will make errors such as described in the INC above more visible. The following 4 approaches to errors should allow us to know when there are issues:
 -  1 - If the error is known, and the driver can resolve the issue, it will proceed with the fix, and retry.
 -  2 - if the error is known, and won't work on a retry, an email notification will be sent (INC generation is still not available for this)
 -  3 - if the error is not known; but works on a retry; the issue would be resolved due to the retry.
 -  4 - if the error is not known, it will retry until the cache is full; and this does trigger an INC; since it's just a file system monitor.


The final to-do list is this (These are the same notes sent in the chat). Please note that these are rough notes and have been included here to maintain a history of the todo items; please let me know if you have questions.
```
1 - Finish the separated retiree disable test (Logini swaStatus should always = R); ensure we can disable separated retirees properly.
 2 - Stop trying to disable accounts on a delete in eDirectory: these events will fail 100% of the time; and just cause unnecessary notifications -
   - Q: Confirm driver operation on a xds <delete> to EmployeeSvc . .
 3 - ONGOING: watch for a terminate of employees and retirees: confirm they are disabled.
  notes: search for terminates using this:  grep '>T<' * -A5 -B5 | more
 4 - lifetime retiree benefits . . . swaRetirePB:
     - Workday: confirm swaRetireePB_CF - changes to anything but Y .  = vsp expiring?
     - Workday: If vsp expires, what happens in Workday? Is it just swaRetireePB_CF = N?
     - lifetime: is swaRetireePB_CF always Y?
     - Assumptions: someone has benefits as VSP, or lifetime as retiree only? . .
 5 - All eids - S|T needs to be set to isActive=false (cover INC6652030)
 6 - All eids - prehire: leave this alone . . .
  ***Leave this alone:***
    P - not yet active (not yet active . . .)
    A - isActive=true . .
 7 - Schedule and run the UAT: see what issues we can reproduce
 8 - KT session scheduled with Ops: to deal with all known classified issues, and INC on cache overflow
 9 - Schedule the Prod deploy.
```




```

todo now: 5/30/2025 12:02:46 PM
Summary: TODO:
 1 - Finish the separated retiree disable test (Logini swaStatus should always = R); ensure we can disable separated retirees properly.
 2 - Stop trying to disable accounts on a delete in eDirectory: these events will fail 100% of the time; and just cause unnecessary notifications -
   - Q: Confirm driver operation on a xds <delete> to EmployeeSvc . .
 3 - ONGOING: watch for a terminate of employees and retirees: confirm they are disabled.
  notes: search for terminates using this:  grep '>T<' * -A5 -B5 | more
 4 - lifetime retiree benefits . . . swaRetirePB:
     - Workday: confirm swaRetireePB_CF - changes to anything but Y .  = vsp expiring?
     - Workday: If vsp expires, what happens in Workday? Is it just swaRetireePB_CF = N?
     - lifetime: is swaRetireePB_CF always Y?
     - Assumptions: someone has benefits as VSP, or lifetime as retiree only? . .
 5 - All eids - S|T needs to be set to isActive=false (cover INC6652030)
 6 - All eids - prehire: leave this alone . . .
  ***Leave this alone:***
    P - not yet active (not yet active . . .)
    A - isActive=true . .
 7 - Schedule and run the UAT: see what issues we can reproduce
 8 - KT session scheduled with Ops: to deal with all known classified issues, and INC on cache overflow
 9 - Schedule the Prod deploy.
```

adding missing error handling notes:
 - Complete UAT & deploy latest updates: Any time the API returns an error now, we'll see one of these things happen:
 -  1 - If the error is known, and the driver can resolve the issue, it will.
 -  2 - if the error is known, and won't work on a retry, an email notification will be sent (INC generation is still not available for this)
 -  3 - if the error is not known; but works on a retry; the issue would be resolved.
 -  4 - if the error is not known, it will retry until the cache is full; and this does trigger an INC; since it's just a file system monitor.



6/4/2025 6:31:05 PM
 notes moved to obs today:



1 - Deploy the latest drivers through production:

I've almost completed a list of UAT discussions/tests that we can go through.  Assuming your team would benefit from this, could we schedule a time to discuss and test how the drivers deal with each of the errors now?
   - Goal: Ensure EmployeeSvc team is ready to deploy to production.
   - Schedule: Late Friday Morning . .

**** May 30 for UAT . .

   Admin/housekeeping: I'm learning a new pattern in our team: whenever we have a UAT; we add watchers to our stories apparently, can I add you to my UAT story now, and see if it keeps you updated?
     - Just tag in comments . .


   General goal with driver release:
    - Can't generate INCs and PRBS directly from the driver . . needed a way to make errors visible and fix them before end users see them.
    - Not lose events. We didn't have a way until now to properly respond to errors; what we really needed to do was this:
       - 1. identify errors that just need to be retried.
       - 2. Identify errors that can't be resolved by a retry (such as bad data); log and notify on these so we can fix them.
       - 3. Any issues I haven't discovered: will infintely retry until an inc is generated due to the larger than normal cache: An INC can be generated here as it's just a pure file system check that can be done outside of a driver.

   The general goal with this release, is to properly deal with every error we possibly can and avoid losing events. This means we retry everyting indefinately: We've identified about 15 different error cases reported from the API; and the driver either ntofiies of the issues and stops if a retry doesn't work, and retryes everything else indefinately. This will cause an incident to be generated for any issues I've missed instead of losing events.



   Context: Open driver page: error section: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver
   - I'm ready for production; would like your team to have confidence in the work we've done; and asnwer questions about behavior as needed.







The next two items are the todo items Logini assigned to Me, Baron, and herself:

2- Discuss this: I'd like to get further clarification on todo items: "Determine when VSP expires, ESP receives user status is set to inactive". I need to map this vocabulary to driver attributes. Baron and I are now in sync.
   - Goal: complete task.
   - Define:
    ESP - Employee Salesforce Platform (Logini's team) . . ?
    VSP - I believe this refers to a retiree with benefits; but seems to specify a specific type.
       - Voluntiner Separation Package: not technically a retiree from a HR dept.
       - We offer VSP - in one of two ways - (early exit packge)
         - 1 - can take vsp, essentially is early retirement + benefits.
         - 2 - Others, don't qualify for retirement benefits; but does get 3 years flight benefits (THIs is the main group of people)
           - need PXP portal access & active . . 6months to 5-10 years . .
         - Issue: some were given option #2 don't have access and need it
****         - Ensure deletion of r account disables PXP account
  IsActive = False
         - Most issues: If VSP#2 -> 2020 vps offerd . .still need to get a job . .work with Google (eg) - bneefits last 5 years . .  Boomerang . .already had rid but had it revoked; then need it again . .
         - Aaron: requested to see someone come back on a boomerang, and see what is up . .




   - We haven't done much around inactivation: the WorkdayHCM driver deletes retirees that lose their passbenefits; so we haven't had any todo items
   here; though it sounded like on our most recent call; there was some concern about people still having access? Should we dig deeper here?
   - also; we won't create retiree objects in eDirectory if they don't have pass benefits; so employeeSvc would never see these.
    *** We need to define somet estable usecases here, and confirm VSP both types can get access, before and after boomerang . .







3 - Let me know when you'd like to finalize the "retrofit all the rids to have correct profile name and format" set of users. I believe todo item is you and me going through the master lists and deciding how proactive we want to be with their resolution.
   - Goal: Confirm that the eDirectory side does need an update; though Employee servcies may be ok arleady: conclusively: know that the driver likely hasn't updated those retirees; and they may not be in the expected state.
   - When we are ready to resolve these; we should spot check a few; see what state they're in, then see what fixing the role does to them.
   - For users that are already correct in EmployeeSvc, this will jsut be a noop; but will ensure the driver can manage the account properly.
   11,327 of these users as of 5/20/2025 10:10:53 AM MDT.

   - The correct role values for production for the swaEmpSvcBaseRole and swaEmpSvcElevated role are these:

      EmployeeSvc_HR|||00E2E000002RP3SUAW|||00e2E000001IUCdQAO
      EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO
      EmployeeSvc_Leader|||00E2E000002RP3aUAG|||00e2E000001IUCdQAO
      EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO

    - Many users have the old style role, just the human readable first piece: EmployeeSvc_Retiree.

  Jeff - Yes: need to cover all 4 roletypes + elevated role types . .
   - WARNING: Need to make sure everything lines up . .

  Josh: Trying to cleanup elevated roles in Salesforce: too many licenses
     - 5/20/2025 1:59:26 PM- some users manually added: have elevated roles and some showing active/inactive; all no longer with company . .
     - Requesting list of users . .
     - Few of them don't have eids . . just delete on salesforce . .


4 - Random question: Does the EmployeeSvc drivers need to support a furloughed use case? It's been an odd use case where many drivers have some old code but none of it seems to be active; trying to determine what the use case is here: driver page says that a furlough is a manual process.
   - Josh: First furlough - In February: Set these users to LOA . .(swaStatus = L?)
   - Announced layoffs: can't layoff people for 60 days . .put on leave for 60 days. .
   - Workday: re-activated: had to return from leave, then be terminated.
   - COVID? - Most likely would be VSP's. Late 2020: thought furlough was needed; notified operatoins; but government helped out . .
   - Not necesarially a process yet . . the LOA above may have been this; but don't have a clear pattern yet on this.
   - Note: for the most part, furlough is L, then ->A -> T, to finalize.
















"IDtoEmployeeSvc-ERR-0059: Update user failed CN=e192116ErrorCode=MALFORMED_ID ErrorMsg=Profile ID: id value of incorrect type: wrong"
EmployeeSvc_Employee|||00E2E000002RP3JUAW|||00e2E000001IUCdQAO
cn=e97401,ou=Users,o=swaiddev
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#1#0052E00000Ji4I0QAJ


6/13/2025 10:37:42 AM


6/11/2025 11:38:20 AM
Work with Jack:

 - Created as a remote loader to make the shim, memory space as much as we can we mvoe out the processing from ndsd.
File has to sit here to load as a remote loader:
/opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/  MCL/
MCL example
   dpw8004
   lpw8004


remote loader info:

Get all status:
rdxmlmanage status










6/17/2025 10:05:48 AM


(cn=r8200041474)
(cn=r8200040689)
(cn=r8200045156)
(cn=r145248)

r145248 - reporting ErrorCode=INVALID_CROSS_REFERENCE_KEY ErrorMsg=Cannot create a portal user without contact.
   - but this is the contact I just created!


<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <soapenv:Header>
     <urn:SessionHeader>
     </urn:SessionHeader>
  </soapenv:Header>
   <soapenv:Body>
      <urn:create>
         <urn1:sObjects xsi:type="urn1:Contact">
           <Base_Employee_ID__c>r145248</Base_Employee_ID__c>
           <FirstName>Daisy</FirstName>
           <LastName>Epple</LastName>
         </urn1:sObjects>
      </urn:create>
   </soapenv:Body>
</soapenv:Envelope>




e70200
e178692
e191789
e169626


<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <soapenv:Header>
     <urn:SessionHeader>
     </urn:SessionHeader>
  </soapenv:Header>
   <soapenv:Body>
      <urn:create>
         <urn1:sObjects xsi:type="urn1:Contact">
           <Base_Employee_ID__c>r8200041474</Base_Employee_ID__c>
           <FirstName>Barry</FirstName>
           <LastName>Johnson</LastName>
         </urn1:sObjects>
      </urn:create>
   </soapenv:Body>
</soapenv:Envelope>







<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<soapenv:Header>
<urn:SessionHeader>
</urn:SessionHeader>
</soapenv:Header>
<soapenv:Body>
<urn:create>
<urn1:sObjects xsi:type="urn1:User">
<urn1:TimeZoneSidKey>America/Chicago</urn1:TimeZoneSidKey>
<urn1:LocaleSidKey>en_US</urn1:LocaleSidKey>
<urn1:EmailEncodingKey>ISO-8859-1</urn1:EmailEncodingKey>
<urn1:LanguageLocaleKey>en_US</urn1:LanguageLocaleKey>

<Alias>BJohn</Alias>
                                <Username>r8200041474@wnco-eshr.com.prod.idmdev1</Username>
                                <FederationIdentifier>r8200041474</FederationIdentifier>
                                <EmployeeNumber>r8200041474</EmployeeNumber>
                                <ProfileId>00e2E000001IUCiQAO</ProfileId>
                                <UserRoleId>00E2E000002RPIPUA4</UserRoleId><FirstName>Barry</FirstName><LastName>Johnson</LastName><Email>r8200041474@default.wnco.com</Email></urn1:sObjects>
</urn:create>
</soapenv:Body>
</soapenv:Envelope>











e8898596692


6/17/2025 11:10:19 AM
6/17/2025 11:01:17 AM
Jeff Wade - meeting to discuss postfix of email addresses: leaning towards updating in driver only in non prod envs . .
 - Microsoft365 three envs . .
   - prod wnco.com
   - QA - wncoqa.com -> nope: xxxxxx@wnemail.com
   - dev - wncodev.com -> nope: xxxxxx@dev.qa.swab2b.com
    - @invalid.wnco.com? issue??
       - mail - @wncox.com.wnco.com
       - Standard from Jeff?
       - Stay away from updating edir data . .
         - IDToEmployeeSvc: update to add .wnco.com postfix . .
   - if need mailboxes . . different discussion . .

7/10/2025 10:18:53 AM
7/10/2025 9:35:10 AM
INC6765254: send active record for:  e149122

User was found; can't tell on status:

<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="urn:enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:sf="urn:sobject.enterprise.soap.sforce.com">
    <soapenv:Header>
        <LimitInfoHeader>
            <limitInfo>
                <current>56985</current>
                <limit>433010000</limit>
                <type>API REQUESTS</type>
            </limitInfo>
        </LimitInfoHeader>
    </soapenv:Header>
    <soapenv:Body>
        <queryResponse>
            <result>
                <done>true</done>
                <queryLocator xsi:nil="true"/>
                <records xsi:type="sf:User">
                    <sf:Id>0054w00000BJqqgAAD</sf:Id>
                    <sf:EmployeeNumber>e149122</sf:EmployeeNumber>
                    <sf:FederationIdentifier>e149122</sf:FederationIdentifier>
                    <sf:Name>Rodney Brown</sf:Name>
                    <sf:Profile xsi:type="sf:Profile">
                        <sf:Id xsi:nil="true"/>
                        <sf:Name>ConnectMe Communities User</sf:Name>
                    </sf:Profile>
                    <sf:Username>e149122@wnco-eshr.com.prod</sf:Username>
                </records>
                <size>1</size>
            </result>
        </queryResponse>
    </soapenv:Body>
</soapenv:Envelope>

Then sent activation in standard update:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com" xmlns:urn1="urn:sobject.enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Header>
        <urn:SessionHeader>
        </urn:SessionHeader>
    </soapenv:Header>
    <soapenv:Body>
        <urn:update>
            <urn1:sObjects xsi:type="urn1:User">
                <urn1:Id>0054w00000BJqqgAAD</urn1:Id>
                <urn1:LocaleSidKey>en_US</urn1:LocaleSidKey>
                <urn1:EmailEncodingKey>ISO-8859-1</urn1:EmailEncodingKey>
                <urn1:LanguageLocaleKey>en_US</urn1:LanguageLocaleKey>
                <Username>e149122@wnco-eshr.com.prod</Username>
                <FederationIdentifier>e149122</FederationIdentifier>
                <EmployeeNumber>e149122</EmployeeNumber>
                <Alias>RBrow</Alias>
                <IsActive>TRUE</IsActive>
                <FirstName>Rodney</FirstName>
                <LastName>Brown</LastName>
                <Email>Rodney.Brown@wnco.com</Email>
                <ProfileId>00e2E000001IUCdQAO</ProfileId>
                <UserRoleId>00E2E000002RP3JUAW</UserRoleId>
            </urn1:sObjects>
        </urn:update>
    </soapenv:Body>
</soapenv:Envelope>


and it succeeded, time stamp:

[07/10/25 10:36:41.743]:IDtoEmployeeSvc ST:            EC: HTTP status: 200

<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="urn:enterprise.soap.sforce.com">
    <soapenv:Header>
        <LimitInfoHeader>
            <limitInfo>
                <current>56985</current>
                <limit>433010000</limit>
                <type>API REQUESTS</type>
            </limitInfo>
        </LimitInfoHeader>
    </soapenv:Header>
    <soapenv:Body>
        <updateResponse>
            <result>
                <id>0054w00000BJqqgAAD</id>
                <success>true</success>
            </result>
        </updateResponse>
    </soapenv:Body>
</soapenv:Envelope>


DirXML Log Event -------------------
     Driver:   \SWACO_ID\SWA-ID\Services\DirXML\Driver Set AEv1\IDtoEmployeeSvc
     Channel:  Subscriber
     Object:   \SWACO_ID\SWA-ID\Users\e149122
     Status:   Success
     Message:  IDtoEmployeeSvc-INFO-0060:Update (merge) user success CN=e149122 EmployeeSvc UserId=0054w00000BJqqgAAD Association has been updated




7/29/2025 4:13:46 PM


Yvonne, Gokul,

Here's the notes we came up with during our meeting:

7/29/2025 8:38:26 AM
EmployeeSvc meeting with Gokul

Two sets of open tasks now:
 - feature covering all existing work - https://southwest.atlassian.net/browse/CYSEE-929
   - Aaron here

 - feature covering the support to the empsvc team - https://southwest.atlassian.net/browse/CYSEE-1514
   - Gokul here




3 drivers:
1 - IDtoEmployeeSvc (CSEE-5025): main driver, does all the communication to employeeSvc, except for swaImage - over SOAP
2 - EmployeeServicesRoleMgmtDriver (CSEE-5025): responsible for managing swaEmpSvcBaseRole, and swaEmpSvcElevated role:
  swaEmpSvcBaseRole: sets to 1 of the 4 base roles as provided in the build/GCVs.
  swaEmpSvcElevatedRole: set by MyAccess . .if set, swaEmpSvcBaseRole is cleared.
  Important note: Roles: are in a 'roleid/profile ID' format, and are Enviornment specific!
3 - IDtoEmployeeCarePicture (master): manages swaImage over REST.

Environments:
IDMDEV1 - used for our DEV
EMPDEV1 - June 10th: they decommissioned without telling us . .it's there; but they use it for soemthing else now.
EMPUAT - Used for our QA
EMPFC3 - also used for QA; they have us swap between them (see note about swapping envs, it's a big pain)
CMAppTest - ??? - If this is a copy of production -
PROD - prod env



IMPORTANT NOTE ABOUT SWAPPING ENVS:
 - Stop & disable EmployeeServicesRoleMgmtDriver
 - Consider associations for IDtoEmployeeSvc: note that they will be wrong with switching enviornments . .
   - Either delete them all up front.
   - Depend on a <sync> to do it for you if they want users synchronized.
 - Consider the swaEmpSvcBaseRoles and swaEmpSvcElevated roles:
   - If dest environment needs users, go ahead and use sync.
   - if they don't necessarily want the users there, just delete associations.
 - UserID and password must be updated for both IDtoEmployeeSvc, and IDtoEmployeeCarePicture.
   - Be sure to review and update AWS as needed.
   - Note that SOAP just uses a username/password, where REST is a full OAUTH2 client credentials.



--Aaron