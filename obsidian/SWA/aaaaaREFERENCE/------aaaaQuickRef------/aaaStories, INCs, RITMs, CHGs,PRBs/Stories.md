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

5/16/2025 4:28:49 PM
stories already sent to Ben
New stories
IDtoEmployeeSvc | IDM | Research: Retirees: Alumni Portal Access
https://southwest.atlassian.net/browse/CSEE-5019
points: 3

IDtoEmployeeSvc | IDM | Research: Default Roles for Separated Retirees
https://southwest.atlassian.net/browse/CSEE-5020
points: 3

IDtoEmployeeSvc | IDM | Research: Confirm API Limits
https://southwest.atlassian.net/browse/CSEE-5022
points: 3

IDtoEmployeeSvc | IDM | Fix: Disable Users when Pass Benefits Disabled
https://southwest.atlassian.net/browse/CSEE-5023
points: 2


more:
IDtoEmployeeSvc | IDM | UAT for Error Manager
https://southwest.atlassian.net/browse/CSEE-5025
points 5: This requires lots of another team's interaction; so this has been set high.



5/19/2025 12:34:24 PM
One more employeeSvc story:
IDtoEmployeeSvc | IDM | UAT for Error Manager
https://southwest.atlassian.net/browse/CSEE-5025
points 5: This requires lots of another team's interaction; so this has been set high.


Aviobook stories:
Aviobook | IDM -  Update pilot Definition to Match Pilot_D
https://southwest.atlassian.net/browse/CSEE-5028
points: 2

Aviobook | IDM -  KT Session to Discuss User Migration Fixing
https://southwest.atlassian.net/browse/CSEE-5029
points: 3

Aviobook | IDM - Fix Bad ID for Users Error
http://southwest.atlassian.net/browse/CSEE-5030
points: 2

Aviobook | IDM - Unarchive users that are rehired/re-enabled
https://southwest.atlassian.net/browse/CSEE-5033
points: 3



Deploy stories: Total fixes:
   - Unarchive users upon reneable/rehire
   - Update Pilot definition to be equal to Pilots_D

Aviobook | IDM - Deploy Latest Fixes to QA
https://southwest.atlassian.net/browse/CSEE-5031
points: 1

Aviobook | IDM - Deploy Latest Fixes to Prod
https://southwest.atlassian.net/browse/CSEE-5032
points: 1

6/16/2025 3:04:14 PM
Vistair - IDtoDocunet | IDM | Push all Users Again for Docunet
https://southwest.atlassian.net/browse/CSEE-5043
Points: 3 - We think we're doing this over Normal changes now; so will require multiple CRs' and scheduling multiple 1 am sessions.

INC Generation process | IDM | Document process to generate INCs in drivers
https://southwest.atlassian.net/browse/CSEE-5044
Points: 3 - Learning this process likely involves both driver changes,


7/9/2025 5:21:32 PM (all stories above are older from another 'stories' file in obsidian, moed to here for consiceness . .)

5 new stories sent to Farhan for IDtoAutocrib work

2/6/2025 3:20:45 PM

To farhan:
Here's my new stories I'm working on now - I see 5 new stories . .!! crazy eh?

AutoCrib | IDM - Dev - Permissions: Parse Permissions Payload  
[https://southwest.atlassian.net/browse/CSEE-4334](https://southwest.atlassian.net/browse/CSEE-4334 "https://southwest.atlassian.net/browse/csee-4334")  
points: 3

AutoCrib | IDM - Dev - Permissions: user changes roles  
[https://southwest.atlassian.net/browse/CSEE-4335](https://southwest.atlassian.net/browse/CSEE-4335 "https://southwest.atlassian.net/browse/csee-4335")  
points: 2

AutoCrib | IDM - Dev - Permissions: Role permission changes  
https://southwest.atlassian.net/browse/CSEE-4336  
points: 5

AutoCrib | IDM - Design Initial Migration  
https://southwest.atlassian.net/browse/CSEE-4337
points: 3

AutoCrib | IDM - Prod - Execute Initial Migration  
https://southwest.atlassian.net/browse/CSEE-4338  
points: 3

AutoCrib | IDM - Ops Driver Walkthrough
https://southwest.atlassian.net/browse/CSEE-4339
points: 1

AutoCrib | IDM - Update AC with Permission Design
https://southwest.atlassian.net/browse/CSEE-4340
points: 1

2/18/2025 4:46:39 PM
Sprinkler | IDM - Configure Update partner role table - Community Manager
https://southwest.atlassian.net/browse/CSEE-4389
points: 1


Sprinkler | IDM - Move to new Role/Partner Role model
https://southwest.atlassian.net/browse/CSEE-4390
points: 2


2/20/2025 4:29:36 PM

Sprinkler | IDM - Configure Update partner role table - QA Deploy
https://southwest.atlassian.net/browse/CSEE-4400
1 point

Sprinkler | IDM - Configure Update partner role table - PROD Deploy
https://southwest.atlassian.net/browse/CSEE-4401
1 point


3/13/2025 9:41:19 AM
IDtoAvioBook | IDM | Change default qualifications - UAT
https://southwest.atlassian.net/browse/CSEE-4430

3/17/2025 12:51:13 PM
IDtoDocunet | IDM/UFM | KB and KT Session to Resolve UFM Issues
2 points


3/18/2025 11:36:11 AM
AutoCrib | IDM - Initial Migration: Add fix role support
https://southwest.atlassian.net/browse/CSEE-4437
2 points

3/26/2025 9:35:44 AM


IDM | EmployeeServicesRoleManagementDriver - Update Department Codes
https://southwest.atlassian.net/browse/CSEE-4540

IDM | EmployeeServicesRoleManagementDriver - Update Department Codes - QA deploy
https://southwest.atlassian.net/browse/CSEE-4541

IDM | EmployeeServicesRoleManagementDriver - Update Department Codes - Prod deploy
https://southwest.atlassian.net/browse/CSEE-4542


IDM | IDtoAvioBook - Update Department Codes - Entitlement Policies
https://southwest.atlassian.net/browse/CSEE-4543

IDM | IDtoAvioBook - Update Department Codes - Entitlement Policies - QA deploy
https://southwest.atlassian.net/browse/CSEE-4544

https://southwest.atlassian.net/browse/CSEE-4545
IDM | IDtoAvioBook - Update Department Codes - Entitlement Policies - Prod deploy



4/4/2025 12:12:07 PM
All,

Here are the set of stories I've created to cover the new IDtoMiro work, some IDtoAltea work, and IDtoAutocrib go-live work:

IDtoMiro | IDM | Validate API and Admin GUI Match Counts
https://southwest.atlassian.net/browse/CSEE-4629
points: 3
  
IDtoMiro | MyAccess | Dynamic Group List of Roles
https://southwest.atlassian.net/browse/CSEE-4630
points: 5 for now, until a MyAccess engineer can update.
 
IDtoMiro | IDM | Update swaMiroRoles Content and Format
https://southwest.atlassian.net/browse/CSEE-4631
points: 3
  
IDtoMiro | IDM and MyAccess | Design the Teams modification Payload
https://southwest.atlassian.net/browse/CSEE-4632
points: 3

IDtoMiro | IDM and MyAccess | Design Plan for Loss of Groups/Users
https://southwest.atlassian.net/browse/CSEE-4633
points: 3

IDtoMiro | IDM | Update Driver to Support Teams
https://southwest.atlassian.net/browse/CSEE-4634
points 3

IDtoAltea | IDM | Add new SuppOfficeID IdMUnit test for fix in CSEE-4505
https://southwest.atlassian.net/browse/CSEE-4635
points 2
 
AutoCrib | IDM | Assist with Go-Live for Apr 14 - DAL
https://southwest.atlassian.net/browse/CSEE-4642
points 1

AutoCrib | IDM | Assist with Go-Live for Apr 22 - MDW
https://southwest.atlassian.net/browse/CSEE-4643 
points 1

AutoCrib | IDM | Assist with Go-Live for May 6 - MKE
https://southwest.atlassian.net/browse/CSEE-4644
points 1

AutoCrib | IDM | Assist with Go-Live for May 18 - BWI
https://southwest.atlassian.net/browse/CSEE-4645
points 1

AutoCrib | IDM | Assist with Go-Live for June 1 - LAX
https://southwest.atlassian.net/browse/CSEE-4646
points 1

AutoCrib | IDM | Assist with Go-Live for June 8 - LAS
https://southwest.atlassian.net/browse/CSEE-4647
points 1

AutoCrib | IDM | Assist with Go-Live for June 15 - PHX
https://southwest.atlassian.net/browse/CSEE-4648
points 1



4/8/2025 2:26:23 PM
Team,

Per Logini's latest request, here are the items that require stories. The stopping and starting of the driver during their migration does not require a story. 

Here are some additional stories to cover the move of the QA employee service driver to EMPUAT1, then later, we'll need to move it back to FC3:

IDtoEmployeeSvc | IDM | QA: Move to EMPUAT1: build update
https://southwest.atlassian.net/browse/CSEE-4679
points: 2

IDtoEmployeeSvc | IDM | QA: Move to EMPUAT1: Deploy to QA
https://southwest.atlassian.net/browse/CSEE-4680
points 1:

IDtoEmployeeSvc | IDM | QA: Move to FC3: build update
https://southwest.atlassian.net/browse/CSEE-4681
points: 2

IDtoEmployeeSvc | IDM | QA: Move to FC3: Deploy to QA
https://southwest.atlassian.net/browse/CSEE-4682
points: 1

--Aaron


4/10/2025 2:11:54 PM
FYI: I've added these stories to the backlog. I'll go assign stories to this sprint that I have completed, then place the story I'm working on in the 'in progress' column:

Backlog:
https://southwest.atlassian.net/jira/software/c/projects/CSEE/boards/6663/backlog?assignee=712020%3A42a564de-7116-4fb9-83b1-7854dca5fb9a


New stories:
AutoCrib | IDM | Prod - Update Format of swaAutocribRole attribute
https://southwest.atlassian.net/browse/CSEE-4698
points: 3

AutoCrib | IDM | Develop: Field Restrictions
https://southwest.atlassian.net/browse/CSEE-4699
points: 1

AutoCrib | IDM | Field Restrictions Deploy to QA
https://southwest.atlassian.net/browse/CSEE-4700
points: 1

AutoCrib | IDM | Field Restrictions Deploy to Prod
https://southwest.atlassian.net/browse/CSEE-4701
points: 1

4/24/2025 8:50:26 AM
IDtoEmployeeSvc | IDM | Monitor New Error Manager: Prep for Ops KT Session
https://southwest.atlassian.net/browse/CSEE-4778
Story points 3 - level of effort on this is a little higher, as we're trying to collect any errors that are infinte retries.
note: Added as a comment just now:  4/25/2025 4:25:29 PM
I’ve spent a bit of time on this, and wanted to document why. The summary is that having three drivers to manage this work is quite a bit more work than a single driver. Also, the Carepicture driver uses a different API and more complicated credentials . .Details:

I’ve been finding that the authentication config for the three EmployeeSvc drivers is more complicated than previously thought. Over the last week or so, we were asked to stop using FC3 as they were doing work there and wanted all the latest stuff in EMPUAT1. it turns out that for the SOAP API, there is a username and password, the REST API uses the username, password, client ID and client secret. For this reason, we have quite a bit more than the normal amount of password management for drivers; summary:

Environments:

**EMPDEV1**: we’ve been given roles/profiles, and authentication info to use this environment again.

**EMPUAT1**: we’ve been requested to move the three drivers to this environment during the recent updates.

**Prod**: no change.

Drivers: I had assumed it was an option to use FC3 for both IDtoEmployeeSvc and IToEmployeCarePicture for both drivers just to enable development; but this has been resolved:

**IDtoEmployeeSvc**: had to move from FC3 to EMPUAT1 in QA, and had to move from FC3 to EMPDEV1 in DEV.

**EmployeeServicesRoleMgmtDriver**: Had to update 4 base roles from FC3 to EMPUAT1 in DEV; also had build issue to resolve.

**IDtoEmployeeCarePicture**: had to move from FC3 to EMPUAT1 in QA, and had to move from FC3 to EMPDEV1 in DEV; also, this driver uses the REST API, so we had to have a username/password/clientid/client password.

AWS: All of the credentials have to be updated in AWS; updated in the tree for DEV, QA,, and then have all tests pass. SO - this is why this task is taking a while!!




Note: updated name to contain the ops kt ession note just now. 4/25/2025 9:22:58 AM



4/25/2025 3:17:55 PM
Aviobook - Flight & Cabin | IDM -  Update avio_cabin_fa role to include prehires
https://southwest.atlassian.net/browse/CSEE-4830
points: 2 - the manual push of existing users in this state adds a bit more effort.

Aviobook - Flight & Cabin | IDM -  Deploy updated avio_cabin_fa role to QA
https://southwest.atlassian.net/browse/CSEE-4831
points: 1

Aviobook - Flight & Cabin | IDM -  Deploy updated avio_cabin_fa role to Prod
https://southwest.atlassian.net/browse/CSEE-4832
points: 1




As of 2025-04-25, there are 21,235 users in this role. When we add swaStatus of P to the list, we will have 21,627. For an additional 392 users that will have this role.

5/1/2025 9:51:09 AM

Hola :-) I've created a new story to resolve at least one entitlement policy:

Aviobook - ReorgFix| IDM -  Update roles not affected by reorg
https://southwest.atlassian.net/browse/CSEE-4835


I've repurposed these stories to also include the reorg fixes along with the avio_cabin_fa items:

Aviobook - Flight & Cabin | IDM -  Deploy avio_cabin_fa/reorg role fixes to QA
https://southwest.atlassian.net/browse/CSEE-4831

Aviobook - Flight & Cabin | IDM -  Deploy avio_cabin_fa/reorg role fixes to Prod
https://southwest.atlassian.net/browse/CSEE-4832


5/2/2025 4:36:02 PM

FYI: another good example of something that just came up: While confirming some Aviobook updates in the near future, they requested another update -> 3 stories. It's a small update; but it's using a new table I built in the previous release; so I'd like to test it fully: 

Aviobook | IDM -  Update pilot qualifications  
[https://southwest.atlassian.net/browse/CSEE-4838](https://southwest.atlassian.net/browse/CSEE-4838 "https://southwest.atlassian.net/browse/csee-4838")

**CANCELED** - ALREADY HAVE STORIES ABOVE
Aviobook | IDM -  Update pilot qualifications - Deploy QA  
[https://southwest.atlassian.net/browse/CSEE-4839](https://southwest.atlassian.net/browse/CSEE-4839 "https://southwest.atlassian.net/browse/csee-4839")

**CANCELED** - ALREADY HAVE STORIES ABOVE
Aviobook | IDM -  Update pilot qualifications - Deploy Prod  
[https://southwest.atlassian.net/browse/CSEE-4840](https://southwest.atlassian.net/browse/CSEE-4840 "https://southwest.atlassian.net/browse/csee-4840") This is a small simple update; and I am already creating CRs for a related component on this driver; so figured I'd add them and do it now. Without Miro on my plate, I think I can do this.


5/2/2025 4:56:29 PM

NEW story to deploy the latest error response manager:
IDtoEmployeeSvc | IDM | Update to the latest error response manager - QA Deploy
https://southwest.atlassian.net/browse/CSEE-4841

Repurposed story to be the prod deploy:
IDtoEmployeeSvc | IDM | Update to the latest error response manager - PROD Deploy
https://southwest.atlassian.net/browse/CSEE-4230

5/21/2025 2:15:59 PM

Ben,

FYI: I renamed this story to include the 'new role definitions', and attached a spreadsheet with the data - just so it's not a surprise when you see it next:

Aviobook | IDM -  Update pilot Definition to Match Pilot_D, add new role definitions 
https://southwest.atlassian.net/browse/CSEE-5028
Points are now 3 (was 2).


6/3/2025 4:11:09 PM
Ben - FYI: new story: this is part 2, we had an initial discussion; but this will be reviewing the actual email messages, and resolving issues.

EmployeeSvc | IDM -  KT Session to Discuss issue resolution, part 2  
[https://southwest.atlassian.net/browse/CSEE-5038](https://southwest.atlassian.net/browse/CSEE-5038 "https://southwest.atlassian.net/browse/csee-5038")  
points: 2


6/5/2025 1:32:11 PM
YI: here's the new stories for Aviobook, and one for IDtoDocunet below.

Aviobook | IDM - Research Simplified Payload Creation  
[https://southwest.atlassian.net/browse/CSEE-5039](https://southwest.atlassian.net/browse/CSEE-5039 "https://southwest.atlassian.net/browse/csee-5039")  
points: 3

Aviobook | IDM - Implement Add Payload  
[https://southwest.atlassian.net/browse/CSEE-5040](https://southwest.atlassian.net/browse/CSEE-5040 "https://southwest.atlassian.net/browse/csee-5040")  
points: 1

Aviobook | IDM - Implement Modify Payload  
[https://southwest.atlassian.net/browse/CSEE-5041](https://southwest.atlassian.net/browse/CSEE-5041 "https://southwest.atlassian.net/browse/csee-5041")  
points: 1

Also, Docunet has asked for a full push of all employees and Contractors. I'd like Ops to do this, so this story will be helping them do this:

Vistair - IDtoDocunet | IDM | Help Ops Push All Employees and Contractors  
[https://southwest.atlassian.net/browse/CSEE-5042](https://southwest.atlassian.net/browse/CSEE-5042 "https://southwest.atlassian.net/browse/csee-5042")  
points: 3

6/24/2025 5:31:39 PM
reported to ben:
IDtoEmployeeSvc | IDM | Fix Termination -> Deactivation bug
https://southwest.atlassian.net/browse/CSEE-5046
points: 2

6/25/2025 1:57:47 PM
Sent to Angie, Ben, Brad, Dhivya, Yvonne
Aaron Kynaston (Contractor) added Ben Cundy and 3 others to the chat. 

When I create stories, I'll send to this group, unless/until we setup a single contact here:
IDtoEmployeeSvc | IDM | Fix "Cannot create a portal user without contact" error  
[https://southwest.atlassian.net/browse/CSEE-5052](https://southwest.atlassian.net/browse/CSEE-5052 "https://southwest.atlassian.net/browse/csee-5052")  
Points 3
This is one of our known issues without a fix; I believe I have one now and didn't want to lose the todo item; just putting in the backlog for now.  



6/27/2025 10:12:39 AM
Sent to ben/angie/yvonne - then later to dhivya

IDtoEmployeeSvc | IDM | Research Loki INC Generation
https://southwest.atlassian.net/browse/CSEE-5072

IDtoEmployeeSvc | IDM | Add Loki Trace Markers
https://southwest.atlassian.net/browse/CSEE-5073

IDtoEmployeeSvc | IDM | Train Ops on new INCS
https://southwest.atlassian.net/browse/CSEE-5074


7/2/2025 9:24:18 AM
Guys, here are two new stories for work that has finally been made clear and can be done now.  I'd like to chat with you to decide how much and what items you'd like me to complete before my OOO starting July 11.  These two stores in my mind are the top priority; and I think I should shoot to complete both by EOB on Thursday the 10th:

Apptio Domain Mgmt | IDM | Implement new swaApptioRoles Format  
[https://southwest.atlassian.net/browse/CSEE-5075](https://southwest.atlassian.net/browse/CSEE-5075 "https://southwest.atlassian.net/browse/csee-5075")  
points: 3

Apptio Domain Mgmt | IDM | Implement Initial Migration tool  
[https://southwest.atlassian.net/browse/CSEE-5076](https://southwest.atlassian.net/browse/CSEE-5076 "https://southwest.atlassian.net/browse/csee-5076")  
points: 3

7/9/2025 5:21:56 PM
Sent this to team before my ohio trip . . may just be non prod issue, per Logini's email.
"Cannot create portal user with out a contact"
IDtoEmployeeSvc | IDM | Research "Cannot create portal user without a contact"
https://southwest.atlassian.net/browse/CSEE-5099


8/1/2025 9:51:54 AM
IDtoEmployeeSvc | IDM | Non-prod Email Postfix Workaround
https://southwest.atlassian.net/browse/CSEE-5152
points: 2
 - Also requires a QA/Prod deployment story . . but we may abe able to combine this with ongoing work . .



9/3/2025 1:52:13 PM
Documented issue in docuware - some data isn't fitting in a column . .
Guys,
FYI: I created a research story for an issue in IDtoDocuware I heard from Ops; all the info is here. The Parent of the story is NOT correct . . I don't know where we'd put this . .maybe in a 'unexpected fixes needed' parent? Not sure - either way here's the story with all the details:
[https://southwest.atlassian.net/browse/CSEE-5259](https://southwest.atlassian.net/browse/CSEE-5259)
I plan on spending probably another 15 minutes determining what the actual issue is, and determine the path forward.  This would likely be good work for Nirosha if the EmployeeSvc stuff is too difficult to pass on btw . .


--Aaron