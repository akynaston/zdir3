2/14/2024 2:24:53 PM
Contains all my story work and reporting.



1/26/2024 3:16:49 PM

Altea Data Reconiliation Tool: Development & Testing:
See https://southwest.atlassian.net/si/jira.issueviews:issue-xml/CSCE-1954/CSCE-1954.xml, saved XML file in stories folder.


1/11/2024 9:35:42 AM

https://southwest.atlassian.net/browse/CSCE-1848
Altea Drivers | IDM - Finalize Prod Deployment

There is a set of random items that need to be closed up before we can do the deploy.
   - Schedule CR - Maybe Jan 23rd? (24/25 are freeze)
   - Email Joe, Jack, Robert about Altea cronjobs that they need to stay in place.
   - Test initial migration import in QA, and just retreival and creation in PROD.
   - Update biuld to write driver logs configured in a way to enable ping authentication testing without causing issues for Ops.
   - Add POST IMP task to notify core and ops about the new drivers; first for disabled drivers, then when they go live.
   - Add a note somewhere to track the removal/deletion of the old driver and associations.
   - Finish build url config for IDtoAltea for prod (and lower envs to automate build)
   - Research: Postman: confirm ping authentication works in prod, through postman (get cyberark password for ping auth)
   - Optional: AC: document step for Ops to retreive signIDs if missing swaAlteaSignIDs in prod: can't retreive through API.
   - Email from Logan on the UAT - What is a WSAP in production? And we should probably update him on our production deploy time oafter the training today.
   - POST GOLIVE: Add this to consider later: "User ID already allocated to one sign of this office." - can't get signid . .brainstorm.
   - Optional: IDToAlteaSignDB: swaAlteaSignIDs: write test for notify->sync change; and update filter.






1/10/2024 9:38:04 AM
1/10/2024 9:37:57 AM- sent to STephanie
 I created 1839 - the session 2 for UAT; but we need to complete 1838 before 1839. This is AvioBook, so I think may be next sprint:
 https://southwest.atlassian.net/browse/CSCE-1838 (do first - this is the documentation/AC story)
 https://southwest.atlassian.net/browse/CSCE-1839 (this is the second UAT story)







1/9/2024 2:15:46 PM
Stories


IDtoAvioBooks: AC update: latest conditions for provisioning
Assignee: Aaron
External dependency? Yes: I need to speak probably with Nadar, and others that may have the requirements.
ENVs: DEV/QA/PROD
EPIC: this just needs to be assigned as the next action on the AvioBooks driver; probably immediately after MCL
Is 1 Story needed for each environment: No, the definition just needs to be created and documented once.
Iteration: Probably the iteration that starts while we're on site, the week of Jan 15.
Description: The IDtoAvioBooks driver conditions for provisioning as described here: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74553541/IDtoAvioBooks, have recently changed per Nadar. We are in a position where we need to get a super clear path forward on what provisioning conditions are.

Right now, there are to main categories of conditions:
1 - MyAccess: Manual assignemnt of roles (direct NOC role assignment through MyAccess is blocked)
2 - Combination of attributes, swaStatus, swaTitle, swaDeptCode.
   - Note that 6 sets of job codes correspond to one of 6 NOC roles; which are assigned only through these special job codes. See the AC above for details.



Acceptance Criteria: When completed, a paccount created in IDV without a swaRequestID




template example:
IDtoAvioBooks: Complete conditions for provisioning
Assignee: Aaron
External dependency? Yes: I need to speak probably with Nadar, and others that may have the requirements.
ENVs: DEV/QA/PROD
EPIC: this just needs to be assigned as the next action on the AvioBooks driver; probably immediately after MCL
Is 1 Story needed for each environment: No, the definition just needs to be created and documented once.
If there are separate stories, can they bean in the SAME sprint: Yes

Iteration: High priority from CSEE; though I don't know how it compares to current work.

Description: The IDtoLDAP driver should not require swaRequestID.

Acceptance Criteria: When completed, a paccount created in IDV without a swaRequestID


2/14/2024 2:36:19 PM
Paul just had me update a new story: https://southwest.atlassian.net/browse/CSIGA-6024
 - this is our driver set recon story to upgrade to latest build, and reconcile all driver sets acoss all envs.
 -


2/23/2024 5:24:03 PM
Here's my two new stories:   
AlteaOfficeDBtoID | IDM - QA Deploy - prehire to hire fix  
[https://southwest.atlassian.net/browse/CSCE-2002](https://southwest.atlassian.net/browse/CSCE-2002 "https://southwest.atlassian.net/browse/csce-2002")

AlteaOfficeDBtoID | IDM - PROD Deploy - prehire to hire fix  
[https://southwest.atlassian.net/browse/CSCE-2003](https://southwest.atlassian.net/browse/CSCE-2003 "https://southwest.atlassian.net/browse/csce-2003")  

Log in with Atlassian account

Log in to Jira, Confluence, and all other Atlassian Cloud products here. Not an Atlassian user? Sign up for free.



2/23/2024 12:17:27 PM
new conversion work, explicit stories:
Vistair | IDM | Convert Comply365 to IDtoDocunet
https://southwest.atlassian.net/browse/CSCE-2005


Vistair - IDtoDocunet | Convert IDMUnit tests from JDBC to DTF
https://southwest.atlassian.net/browse/CSCE-2006


2/23/2024 2:48:25 PM
MCL | IDM | Bugfix: avoid adding users back when passport expired
https://southwest.atlassian.net/browse/CSCE-2007

MCL | IDM - QA Deploy - passport exp check bug fix
https://southwest.atlassian.net/browse/CSCE-2008


MCL | IDM - PROD Deploy - passport exp check bug fix
https://southwest.atlassian.net/browse/CSCE-2009



2/27/2024 9:48:26 AM
Story scheduleing:


Name: AlteaOfficeDBtoID | IDM - QA Deploy - prehire to hire fix
URL: https://southwest.atlassian.net/browse/CSCE-2002
Action: Move to this sprint, mark done.


Name: AlteaOfficeDBtoID | IDM - PROD Deploy - prehire to hire fix
URL: https://southwest.atlassian.net/browse/CSCE-2003
Action: Move to this sprint, CR submitted, noted in story; scheduled for tonight.


Name: Vistair | IDM | Convert Comply365 to IDtoDocunet
URL: https://southwest.atlassian.net/browse/CSCE-2005
Action: Move to this sprint. I have a good start, but have been slowed due to prod issues.


Name: Vistair - IDtoDocunet | Convert IDMUnit tests from JDBC to DTF
URL: https://southwest.atlassian.net/browse/CSCE-2006
Action: Maybe set on next sprint; I'll definately jump on this and 2005 when deploy stories done.


Name: MCL | IDM | Bugfix: avoid adding users back when passport expired
URL: https://southwest.atlassian.net/browse/CSCE-2007
Action: Move to this sprint, bug fix completed, story done.


MCL | IDM - QA Deploy - passport exp check bug fix
https://southwest.atlassian.net/browse/CSCE-2008
Action: Move to this sprint, will be deployed to QA tomororow, Cr is: CHG0385595


MCL | IDM - PROD Deploy - passport exp check bug fix
https://southwest.atlassian.net/browse/CSCE-2009
Action: Move to this sprint, will be deployed tonight, CR: CHG0385598




2/27/2024 5:08:44 PM
Altea | IDM | AlteaOfficeDBtoID: Support L -> RBAC evaluation
https://southwest.atlassian.net/browse/CSCE-2018

Altea | IDM | AlteaOfficeDBtoID: Deploy QA - Support L -> RBAC evaluation
https://southwest.atlassian.net/browse/CSCE-2019

Altea | IDM | AlteaOfficeDBtoID: Deploy PROD - Support L -> RBAC evaluation
https://southwest.atlassian.net/browse/CSCE-2020


MCL | IDM | Bugfix: Add one day grace to job check
https://southwest.atlassian.net/browse/CSCE-2033

MCL | IDM | QA deploy- Add one day grace to job check
https://southwest.atlassian.net/browse/CSCE-2034

MCL | IDM | Prod deploy- Add one day grace to job check
https://southwest.atlassian.net/browse/CSCE-2035


3/12/2024 4:12:16 PM

IdMUnit - idm-unit-dtf-connector | Bugfix - File order issue
https://southwest.atlassian.net/browse/CSCE-2049
 - This is assigned to me at the moment.
 - I would like this in the 1.4 sprint, starting on 3/13.   

Change Request Documentation | Create an IDM Normal Change Document like Ping's
https://southwest.atlassian.net/browse/CSCE-2050
 - this is currently assigned to Gary; will revisit after we confirm his workload in the sprint. 
 - I suspect this will be in the 3/13 sprint, but we'll confirm with Gary.

3/12/2024 4:24:17 PM- > sent to stephanie



3/14/2024 4:57:48 PM

Vistair - IDtoDocunet | IDM | Test UFM
https://southwest.atlassian.net/browse/CSCE-2052
 - This story covers the work to bring in the SSH IdMUnit connector so I can validate the UFM process is archiving files properly.



3/29/2024 3:39:47 PM


Vistair - IDtoDocunet | IDM | Configure / Setup UFM: GPG encryption
https://southwest.atlassian.net/browse/CSCE-2196



4/15/2024 4:13:28 PM
I've created 3 new stories that the Vistair/Docunet team would like us to do as soon as we can:

3 points: Vistair - IDtoDocunet | IDM | AC5 Increase Output to all available data
https://southwest.atlassian.net/browse/CSEE-3730

2 points: Vistair IDtoDocunet | IDM | QA deploy - AC5 update
https://southwest.atlassian.net/browse/CSEE-3731

2 points: Vistair IDtoDocunet | IDM | PROD deploy - AC5 update
https://southwest.atlassian.net/browse/CSEE-3732




4/26/2024 10:05:24 AM
Standard Change | IDM | Create Standard Change Proposal
https://southwest.atlassian.net/browse/CSEE-3744


4/26/2024 1:13:41 PM
Altea - IDtoAltea | IDM | Set Duty Code to SU
https://southwest.atlassian.net/browse/CSEE-3745

Altea- IDtoAltea | IDM | Deploy to QA for Duty Code update
https://southwest.atlassian.net/browse/CSEE-3746

Altea - IDtoAltea | IDM | Deploy to Prod for Duty Code update
https://southwest.atlassian.net/browse/CSEE-3747

4/29/2024 7:10:26 PM

MCL - MCL | IDM | On Leave -> Remove from MCL
https://southwest.atlassian.net/browse/CSEE-3748

MCL - MCL | IDM | On Leave -> Remove from MCL - QA deploy
https://southwest.atlassian.net/browse/CSEE-3749

MCL - MCL | IDM | On Leave -> Remove from MCL - Prod deploy
https://southwest.atlassian.net/browse/CSEE-3750



4/29/2024 7:31:02 PM
and another:
Vistair IDtoDocunet | IDM | Documentation Update: Troubleshooting & UFM
https://southwest.atlassian.net/browse/CSEE-3751


4/30/2024 4:09:19 PM
Farhan, here are the QA and prod stories that are based on CSEE-3671 to do the promotion to these environments. I should probably have these stories in the next sprint since I've got a lot already commited; though I'll jump on it when I can:

Vistair - IDtoDocunet | IDM | Configure / Setup UFM - Promote to QA
https://southwest.atlassian.net/browse/CSEE-3757

Vistair - IDtoDocunet | IDM | Configure / Setup UFM - Promote to Prod
https://southwest.atlassian.net/browse/CSEE-3758


5/1/2024 8:38:16 PM
Sent to Farhan:
Farhan, Here are the new stories for the IDtoAvioBook driver.  The top three are the standard driver stories.  The last one is a MyAccess story for the roles that are meant to come from there. . .I have no business creating MyAccess stories; so I don't know if it's useful or not; but wanted a place holder at least.


IDtoAvioBook | IDM | Add Cabin and TechLog roles
https://southwest.atlassian.net/browse/CSEE-3759

IDtoAvioBook | IDM | Add Cabin and TechLog roles QA Deploy
https://southwest.atlassian.net/browse/CSEE-3760

IDtoAvioBook | IDM | Add Cabin and TechLog roles Prod Deploy
https://southwest.atlassian.net/browse/CSEE-3761


MyAccess story:

IDtoAvioBook | MyAccess | Add Cabin and TechLog roles
https://southwest.atlassian.net/browse/CSEE-3762


5/7/2024 12:32:04 PM
Vistair - IDtoDocunet | IDM | Replace swaTitleCode with jobCode
https://southwest.atlassian.net/browse/CSEE-3786

Vistair - IDtoDocunet | IDM | Replace swaTitleCode with jobCode QA deploy
https://southwest.atlassian.net/browse/CSEE-3787

Note the missing prod deploy story . .I think I may be able to get this in my next prod deploy story I have already.


5/15/2024 1:36:35 PM
Updates to miro following call; sent to Farhan and Brad just now 5/15/2024 1:45:26 PM


Farhan, I've created the following stories due to my IDtoMiro call. We've identified the following work. I have given a description, and AC and points to each story, I suspect the scheduling and epic among other things needs to be fixed. I have  requested a priority from them; but for now am loosely targeting the end of next PI:

IDtoMiro | IDM | Deprovision On Terminate  
[https://southwest.atlassian.net/browse/CSEE-3794](https://southwest.atlassian.net/browse/CSEE-3794 "https://southwest.atlassian.net/browse/csee-3794")

IDtoMiro | IDM | Deprovision On Terminate: QA Deploy  
[https://southwest.atlassian.net/browse/CSEE-3795](https://southwest.atlassian.net/browse/CSEE-3795 "https://southwest.atlassian.net/browse/csee-3795")

IDtoMiro | IDM | Deprovision On Terminate: Prod Deploy  
[https://southwest.atlassian.net/browse/CSEE-3796](https://southwest.atlassian.net/browse/CSEE-3796 "https://southwest.atlassian.net/browse/csee-3796")

IDtoMiro | IDM | Terminated User Cleanup Assistance  
https://southwest.atlassian.net/browse/CSEE-3797


5/22/2024 11:30:07 AM
Found an event bug in the driver:

Vistair IDtoDocunet | IDM | Fix Bad Event Processing
https://southwest.atlassian.net/browse/CSEE-3801

Vistair IDtoDocunet | IDM | Fix Bad Event Processing - Deploy QA
https://southwest.atlassian.net/browse/CSEE-3802

Vistair IDtoDocunet | IDM | Fix Bad Event Processing - Deploy Prod
https://southwest.atlassian.net/browse/CSEE-3803


5/22/2024 2:05:38 PM
Just had miro call today; now I know that I am probably going to have to do the clean up from the driver side; adding more content here:

IDtoMiro | IDM | Terminated User Cleanup Assistance  
https://southwest.atlassian.net/browse/CSEE-3797
