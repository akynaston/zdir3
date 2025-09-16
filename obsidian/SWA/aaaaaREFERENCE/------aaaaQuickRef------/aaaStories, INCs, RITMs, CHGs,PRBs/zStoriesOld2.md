5/30/2024 12:50:31 PM
previous mcl stories:

4/29/2024 7:10:26 PM

MCL - MCL | IDM | On Leave -> Remove from MCL
https://southwest.atlassian.net/browse/CSEE-3748

MCL - MCL | IDM | On Leave -> Remove from MCL - QA deploy
https://southwest.atlassian.net/browse/CSEE-3749

MCL - MCL | IDM | On Leave -> Remove from MCL - Prod deploy
https://southwest.atlassian.net/browse/CSEE-3750


5/23/2024 4:57:52 PM


previous aviobook stories:

https://southwest.atlassian.net/browse/CSEE-3759 - IDtoAvioBook | IDM | Add Cabin and TechLog roles
https://southwest.atlassian.net/browse/CSEE-3760 - IDtoAvioBook | IDM | Add Cabin and TechLog roles QA Deploy
https://southwest.atlassian.net/browse/CSEE-3761 - IDtoAvioBook | IDM | Add Cabin and TechLog roles Prod Deploy
https://southwest.atlassian.net/browse/CSEE-3762 - IDtoAvioBook | MyAccess | Add Cabin and TechLog roles


New story; appears to be duplicate of CSEE-3759
https://southwest.atlassian.net/browse/CSEE-3778 - Aviobook - Techlog | IDM - DEV Modify - 

5/30/2024 2:43:21 PM
Story fix sent to Farhan just now

I had a quick upate for you: I determined that I had created some avio book stories; but they were attached to the docunet epic, so I think they were lost in the shuffle. I'll go ahead and consolidate all the work we have defined from my stories into the new one; unless you say otherwise:

Here's my plan

Context:
https://southwest.atlassian.net/browse/CSEE-3759 - IDtoAvioBook | IDM | Add Cabin and TechLog roles
https://southwest.atlassian.net/browse/CSEE-3762 - IDtoAvioBook | MyAccess | Add Cabin and TechLog roles

Actions:
3759 - I am going to close/decline/archive this story and move to the actual 3778 story currently in my todo list.
3762 - I am going to close/decline/archive this story and move to the actual 3778 story currently in my todo list.




6/5/2024 1:34:43 PM


Stories closed and moved to this sprint:
Stories moved into this sprint and mark as 'in review' as they were completed:

https://southwest.atlassian.net/browse/CSEE-3747
https://southwest.atlassian.net/browse/CSEE-3757
https://southwest.atlassian.net/browse/CSEE-3758
https://southwest.atlassian.net/browse/CSEE-3801
https://southwest.atlassian.net/browse/CSEE-3802
https://southwest.atlassian.net/browse/CSEE-3803



6/6/2024 2:14:37 PM
Altea  | IDM | Cleanup swaAlteaSuppOfficeID values with '#'
https://southwest.atlassian.net/browse/CSEE-3809
feature: https://southwest.atlassian.net/browse/CYSEE-883


6/7/2024 2:54:49 PM
Created rename support story for Kyle, per the rename thing Kyel and I chatted about:

WorkdayHCM | IDM - Feature: Rename Support
https://southwest.atlassian.net/browse/CSIGA-6343


6/14/2024 12:46:32 PM
REquested from farhan, that he creates:
     - 1 - IDtoAlteaSignDB | IDM | Research which characters need to be escaped in an SQL statment.
     - 2 - IDtoAlteaSignDB | IDM | Research which fileds could have characters that need escaping.
     - 2 - IDtoAlteaSignDB | IDM | DEV Update escpaing in code.
     - 1 - IDtoAlteaSignDB | IDM | QA deploy escaping fixes.
     - 1 - IDtoAlteaSignDB | IDM | PROD deploy escaping fixes.
   -


6/18/2024 12:27:16 PM
		needed part to for: https://southwest.atlassian.net/browse/CSEE-3778
    Aviobook - Techlog & Cabin | IDM - DEV Modify Part 2 - RBE Updates
      https://southwest.atlassian.net/browse/CSEE-3892



6/27/2024 11:57:20 AM

MCL | IDM - Design Transfer
https://southwest.atlassian.net/browse/CSEE-3900


7/11/2024 9:52:39 AM
MCL | IDM - Design Transfer - On going support
https://southwest.atlassian.net/browse/CSEE-3905


7/17/2024 11:25:49 AM
IDtoAvioBookNoAutoRole | IDM - Support 'prelive' roles
https://southwest.atlassian.net/browse/CSEE-3908




7/23/2024 10:55:15 AM
IDtoAvioBook | IDM - Pipeline Deploy Configuration - needed to add pipeline for odd two drivers.
https://southwest.atlassian.net/browse/CSEE-3913



7/23/2024 1:30:57 PM
Farhan, I realized I needed a new QA deploy story, since the prelive driver came in; so I cloned the previous QA deploy story we completed recently to this:

Aviobook - Flight & Cabin | IDM - QA Deploy (Cabin/Flight/prelive)
https://southwest.atlassian.net/browse/CSEE-3920

I also renamed the ALREADY EXISTING prod story to include the 'prelive' portion, and match the prod version:
Aviobook - Flight & Cabin | IDM - Prod Deploy (Cabin/Flight/prelive)
https://southwest.atlassian.net/browse/CSEE-3784


8/2/2024 9:57:25 AM

Aviobook - Flight & Cabin | IDM - QA (Cabin/Flight/prelive) UAT
https://southwest.atlassian.net/browse/CSEE-3931
 - This story will cover the UAT work Nader + team and I will complete hopefully on Monday, Aug 5. This driver is super visible, so we'll need to spend some time on this.


Aviobook - Flight & Cabin | IDM -  (Cabin/Flight/prelive) Put/Post Issue resolution
https://southwest.atlassian.net/browse/CSEE-3932
* This story covers a possible issue with the driver sending an HTTP POST operation when a Put should have been used per the API documentation. . . I am still trying to reproduce the issue and write a test for the situation.


8/12/2024 12:15:43 PM
Miro driver provisions termateidn users:
IDtoMiro | IDM | Avoid provision On Already Termed
https://southwest.atlassian.net/browse/CSEE-3936



8/13/2024 4:17:00 PM
MCL | IDM | Prod cleanup: Deprovision users currently on leave
https://southwest.atlassian.net/browse/CSEE-3941
3 points


8/14/2024 5:39:51 PM
Farhan, I've created two new stories to complete some items with Yatin on the Sprinkler driver. We'll likely be adding a training story for IDM folks on how to use the latest pipelines; but that's a bit less defined right now; so we'll get it done when we can.

Sprinkler | IDM - Configure pipeline
https://southwest.atlassian.net/browse/CSEE-3946
points: 3
Story owner: Aaron Kynaston
Paring Partner: Yatin Dodia

Sprinkler | IDM - Complete IdMUnit Config
https://southwest.atlassian.net/browse/CSEE-3947
points: 3
Story owner: Aaron Kynaston
Paring Partner: Yatin Dodia



8/16/2024 4:08:48 PM

Farhan, FYI: I just created this: it's the next most important think after IDtoSprinkler.  I'll close up IDtoSprinkler tasks after having a sync up with Yatin on Monday.

I am not adding this to the sprint until/unless you ask me to; though it is my current work:

RBEAEv1 | RBE Update | IDM - Add EPs to the Build
https://southwest.atlassian.net/browse/CSEE-4005

8/22/2024 1:24:23 PM

OK, 5 new stories created, 1 points each, set for each of the 5 sprints

MCL | IDM | Sprint 1 Batch Processing
https://southwest.atlassian.net/browse/CSEE-4016 - CSEE 2024.4.1 (8/28- 9/10)

MCL | IDM | Sprint 2 Batch Processing
https://southwest.atlassian.net/browse/CSEE-4017 - CSEE 2024.4.2 (9/11- 9/24)

MCL | IDM | Sprint 3 Batch Processing
https://southwest.atlassian.net/browse/CSEE-4018 - CSEE 2024.4.3 (9/25- 10/8)

MCL | IDM | Sprint 4 Batch Processing
https://southwest.atlassian.net/browse/CSEE-4019 - CSEE 2024.4.4 (10/9- 10/22)

MCL | IDM | Sprint 5 Batch Processing
https://southwest.atlassian.net/browse/CSEE-4020 - CSEE 2024.4.5 (10/23- 11/5)


8/26/2024 12:07:13 PM

Farhan, here's my new stories for the bug fixes I'm making today. I don't know if I'll finish in this sprint, so did not assign them yet. I suspect their epic is old too. I only set the description, AC, and points for now.

IdMUnit swa-scim-connector: Fix MacroMap bug  
[https://southwest.atlassian.net/browse/CSEE-4022](https://southwest.atlassian.net/browse/CSEE-4022 "https://southwest.atlassian.net/browse/csee-4022")

IdMUnit swa-rest-connector: Fix MacroMap bug  
[https://southwest.atlassian.net/browse/CSEE-4023](https://southwest.atlassian.net/browse/CSEE-4023 "https://southwest.atlassian.net/browse/csee-4023")


8/29/2024 12:03:59 PM
Vistair IDtoDocunet | IDM | Remigrate Users on Leave
https://southwest.atlassian.net/browse/CSEE-4028


9/6/2024 12:04:10 PM
SWAV - SAP BRIM | IT-01820 | IDM - Add opGetToken to the IdMUnit SCIM connector
https://southwest.atlassian.net/browse/CSEE-4061


9/30/2024 4:34:57 PM
Sprinkler | IDM - Deploy deprovision fixes to QA
https://southwest.atlassian.net/browse/CSEE-4090

Sprinkler | IDM - Deploy deprovision fixes to PROD
https://southwest.atlassian.net/browse/CSEE-4091



10/4/2024 5:42:22 PM
Sent this to Farhan just now:


FYI: I've created three new stories for IDtoEmployeeSVC driver that seem to need to be done. Yatin needs to confirm still; but I think these are right - I'll plan on assinging them to next sprint unless you get to it before me: IDtoEmployeeSvc | IDM - Deploy Role Removal Code Prod  
[https://southwest.atlassian.net/browse/CSEE-4094](https://southwest.atlassian.net/browse/CSEE-4094 "https://southwest.atlassian.net/browse/csee-4094")  
Description: Deploying some code Yatin made on CSEE-4025.

IDtoEmployeeSvc | IDM - Update and pass IdMUnit tests  
[https://southwest.atlassian.net/browse/CSEE-4095](https://southwest.atlassian.net/browse/CSEE-4095 "https://southwest.atlassian.net/browse/csee-4095")  
Description: Updating and passing tests from Yatin, that he made on CSEE-4025

IDtoEmployeeSvc | IDM - Update Pipeline Config  
[https://southwest.atlassian.net/browse/CSEE-4096](https://southwest.atlassian.net/browse/CSEE-4096 "https://southwest.atlassian.net/browse/csee-4096")  
Description: The driver and build is pretty old, and needs some Pipeline/AWS and build updates.  



10/4/2024 5:47:43 PM
Created to cover the new model:
BrowserStack Percy | IDM - DEV - Update to the Product|||Role model
https://southwest.atlassian.net/browse/CSEE-4097



10/9/2024 5:31:45 PM

BrowserStack Percy | IDM - Change to Percy-UserType Model  
[https://southwest.atlassian.net/browse/CSEE-4105](https://southwest.atlassian.net/browse/CSEE-4105 "https://southwest.atlassian.net/browse/csee-4105")


Vistair IDtoDocunet | IDM | Prepare for and Execute Ops Walkthrough  
[https://southwest.atlassian.net/browse/CSEE-4106](https://southwest.atlassian.net/browse/CSEE-4106 "https://southwest.atlassian.net/browse/csee-4106")

IDtoMiro | IDM | Change License Full error to retry
https://southwest.atlassian.net/browse/CSEE-4107



10/11/2024 4:49:17 PM
IDtoMiro | IDM | Change License Full error to retry - PROD deploy
https://southwest.atlassian.net/browse/CSEE-4113

IDtoMiro | IDM | Change License Full error to retry - QA deploy
https://southwest.atlassian.net/browse/CSEE-4112


BrowserStack Percy | IDM - POC - Create Automated Feed File for MyAccess
https://southwest.atlassian.net/browse/CSEE-4108



10/14/2024 1:38:09 PM
RBEAEv1 | IDM | Remove IDtoSoar Roles
https://southwest.atlassian.net/browse/CSEE-4114
 - This story records the removal of the IDtoSoar driver roles from the RBEAEv1 driver from the tree and the Git repo.
- 10/16/2024 5:56:24 PM

10/16/2024 5:56:27 PM

IDtoAvioBook | IDM | Prepare for and Execute Ops Walkthrough
https://southwest.atlassian.net/browse/CSEE-4122


10/18/2024 5:39:27 PM
BrowserStack Percy | IDM - Add CN to SCIM Payload
https://southwest.atlassian.net/browse/CSEE-4124



10/30/2024 11:25:17 AM
BrowserStack Percy | IDM - Move to Simplified Role
https://southwest.atlassian.net/browse/CSEE-4189
Description: Need to simplify role due to MyAccess restriction.

BrowserStack Percy | IDM - Simplified Role update - QA deploy
https://southwest.atlassian.net/browse/CSEE-4190

BrowserStack Percy | IDM - Simplified Role update - Prod deploy
https://southwest.atlassian.net/browse/CSEE-4191

11/13/2024 1:21:28 PM

IdMUnit swa-soap-connector: Add Tests
https://southwest.atlassian.net/browse/CSEE-4213


11/14/2024 4:00:43 PM
Added a story to unplanned & next sprint, 3 points for next sprint as I'll need to do a migration for QA. Same situation for prod; though I assigned that to the sprint after next:

AvioBook | IT-01934 | IDM - Update Driver - QA - UAT/Migration
https://southwest.atlassian.net/browse/CSEE-4215

AvioBook | IT-01934 | IDM - Update Driver - Prod - Migration
https://southwest.atlassian.net/browse/CSEE-4216


12/4/2024 11:41:52 AM
IDtoEmployeeSvc | IDM | Create error response manager
https://southwest.atlassian.net/browse/CSEE-4228

IDtoEmployeeSvc | IDM | Create error response manager - QA Deploy
https://southwest.atlassian.net/browse/CSEE-4229

IDtoEmployeeSvc | IDM | Create error response manager - Prod Deploy
https://southwest.atlassian.net/browse/CSEE-4230



IDtoAvioBook | IDM | Change default qualifications
https://southwest.atlassian.net/browse/CSEE-4231

IDtoAvioBook | IDM | Change default qualifications - QA Deploy
https://southwest.atlassian.net/browse/CSEE-4232

IDtoAvioBook | IDM | Change default qualifications - Prod Deploy
https://southwest.atlassian.net/browse/CSEE-4233

12/6/2024 3:49:48 PM
IDtoEmployeeSvc | IDM - QA: point to EMPUAT1
https://southwest.atlassian.net/browse/CSEE-4241

12/11/2024 2:02:43 PM
IDtoEmployeeCarePicture | IDM - QA: point to EMPUAT1
https://southwest.atlassian.net/browse/CSEE-4245
2 points


12/18/2024 10:34:11 AM
IDtoEmployeeCarePicture | IDM - QA: point back to FCS3
https://southwest.atlassian.net/browse/CSEE-4258
2 - points

IDtoEmployeeSvc | IDM - QA: point back to FCS3
https://southwest.atlassian.net/browse/CSEE-4259
2 - points
git 

12/20/2024 11:14:03 AM
Fix the base role issue, so all retiress properly get the base role.

IDM | EmployeeServicesRoleManagementDriver - Ensure Retiree Base Role
https://southwest.atlassian.net/browse/CSEE-4261
2 points

IDM | EmployeeServicesRoleManagementDriver - Ensure Retiree Base Role - QA Deploy
https://southwest.atlassian.net/browse/CSEE-4262
1 point

IDM | EmployeeServicesRoleManagementDriver - Ensure Retiree Base Role - Prod Deploy
https://southwest.atlassian.net/browse/CSEE-4263
1 point


1/21/2025 3:01:22 PM
AutoCrib | IDM - Map swaLocation -> dbid
https://southwest.atlassian.net/browse/CSEE-4280

1/24/2025 12:09:21 PM
Vistair IDtoDocunet | IDM | Re-migrate Users in Prod
https://southwest.atlassian.net/browse/CSEE-4313
Points: 2
Timing: Vistair had an issue on their side and ended up missing data. They've asked us to push the data again as soon as we can.

1/27/2025 12:29:00 PM

AutoCrib | IDM - Deprovision/cleanup user
https://southwest.atlassian.net/browse/CSEE-4316

AutoCrib | IDM - Update User: swaLocation changes
https://southwest.atlassian.net/browse/CSEE-4315



