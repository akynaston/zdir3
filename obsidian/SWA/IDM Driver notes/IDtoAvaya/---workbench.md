12/13/2024 1:05:54 PM
We had this meeting at 11:30 today and I got context on the driver, and we did some basic API testing, and put together a bunch of questions for Lewis.

Postman collection attached to this folder.
[[Avaya AEC.postman_collection.json]]

Email from Parmeshwar Tonde, the apparent API developer, or at least knoel

![[EXTERNAL -  RE_ SWA - Avaya_SWA Admin Portal-API_My Access  2.eml]]

Email from Parmeshwar regarding passwords:
![[EXTERNAL -  RE_ Starfish provisioning web service.eml]]

but they are:
starfish/St@ rf1sh@ 098 ‍ ‍ ‍ ‍ ‍ ‍ ‍ ‍ ‍ ‍ ‍

12/13/2024 11:35:29 AM
Avaya/starfish API testing.
Present:
Butler, Marnie (Marnie) - gave quick initial high level stauts of the proejct.
JOe Gividen
Lewis Harvy - PM for the project
Mark Freedman - secondary PM for now maybe? - mfreedman@starfishassociates.com
Parmeshwar Tonde (External) - likely the Avya API developer or at least knowledgeable on api - ptonde@starfishassociates.com
Veronica Henriques (external)


Admin portal: userprovisionnig by lines of business:
 - api that will integrate portal to myaccess
 - Lews Harvey project PM
 - Marine Butler - (Marnie)
 - retest API see if it's working.
 - Mark Freedman ?
 - Marnie - gave me the context
 - Parmeshwar - had api info
 - Marnie - MyAccess: customer care has new graduationg class - user gets popualted in myaccess flows to portal tool
   - agent portals . .
   - new provisioning
   - modification

Post user_provision
get user_getuser
submit request -

  User_provisionUser
  User_DeProvsion
  User_GetUser

Lewis
  1 Admin Portal - our users would login and auth with ping - SSO into admin portal - they'd be able to do user changes.
   - Next Action? Will use the data userwise . .
     - This is all Ping . .
   Next Action: (Mark Freedman to Team) need to look through this to see the goal of #2 and see how things fit together.
    - helps to differentiate . .
    - Parmesh -> just one group in portal

  2 IDM/MyAccess - WE'd do the provisiong through myaccess.
    "i need 10 users in avaya - myaccess then reach out to avya and do the provisioning."
    future state - is the myccess piece . .current state: get admin portal up and running login and provision people.
   - Next Action?
    12/13/2024 11:57:48 AM- testing API here
   - Fields:
     - Request id: just needs random identifier . .maybe timestamp
     - perhaps: IDtoAvaya-yyyy-MM-dd-hh-mm-ss . .?
     -

 - If any data needs to change, use /user:RenameResources
UPDATES
{
    "RequestID":"RenameResource_9999",
    "UserId":"JSmith9999",
    "NewFirstName":"John67",
    "NewLastName":"Smith676",
    "NewEmailAddress":"",
    "NewUserId":"JSmith_676",
    "NewSecondaryUserId":null
}
HEADS UP - Currently not supporting provisiong group changes
   - Would need to delete user, and recreate with the proper group.
   - BudleName - changes? User_ManageBundle
   - ReportuserGroup - User_ChangeReportUserGroup
   - Delete? ->



CREATIONS:
Minimal payload - took 25 seconds!
{
    "RequestID":"SPS_13062022_ProvUser_132_9999",
    "FirstName":"John9999",
    "LastName": "Smith9999",
    "UserID":"JSmith9999",
    "EmailAddress":"JSmith9999@avayacloud.com",
    "ProvisioningGroup":"Dallas TX - OTCS",
    "BundleName":"CC Voice",
    "ReportUserGroup":"Public"
}

Minimal response:
{
    "Status": true,
    "UserID": "JSmith9999",
    "Message": "User provisioned successfully.",
    "ResourceStatus": [
        {
            "Identifier": "JSmith9999",
            "ResourceType": "ACCCM User",
            "Status": true,
            "Message": "Added ACCCM User JSmith9999.",
            "Target": "ACCCM",
            "Details": null
        },
        {
            "Identifier": "JSmith9999@avayacloud.com",
            "ResourceType": "User Profile",
            "Status": true,
            "Message": "Updated User Profile JSmith9999@avayacloud.com ",
            "Target": "SMGR",
            "Details": null
        },
        {
            "Identifier": "5551110141",
            "ResourceType": "CM Station",
            "Status": true,
            "Message": "Updated station 5551110141.",
            "Target": "CCCM",
            "Details": null
        },
        {
            "Identifier": "jsmith9999@avayacloud.com",
            "ResourceType": "911inform User",
            "Status": true,
            "Message": "Added 911inform User for jsmith9999@avayacloud.com.",
            "Target": "911Lab",
            "Details": null
        },
        {
            "Identifier": "jsmith9999@avayacloud.com",
            "ResourceType": "911inform User",
            "Status": true,
            "Message": "Updated 911inform User for jsmith9999@avayacloud.com.",
            "Target": "911Lab",
            "Details": null
        },
        {
            "Identifier": "JSmith9999",
            "ResourceType": "ACCCM User",
            "Status": true,
            "Message": "Updated ACCCM User JSmith9999.",
            "Target": "ACCCM",
            "Details": null
        },
        {
            "Identifier": "5551120135",
            "ResourceType": "CM Agent",
            "Status": true,
            "Message": "Updated agent 5551120135.",
            "Target": "CCCM",
            "Details": null
        },
        {
            "Identifier": "5551120135",
            "ResourceType": "ACCCM User",
            "Status": true,
            "Message": "Updated agent skills for 5551120135.",
            "Target": "ACCCM",
            "Details": null
        },
        {
            "Identifier": "JSmith9999",
            "ResourceType": "ACCCM User",
            "Status": true,
            "Message": "Enabled Workspace for Elite",
            "Target": "ACCCM",
            "Details": null
        },
        {
            "Identifier": "5551120135",
            "ResourceType": "CM Agent",
            "Status": true,
            "Message": "Updated agent 5551120135.",
            "Target": "CCCM",
            "Details": null
        },
        {
            "Identifier": "5551120135",
            "ResourceType": "CMS Agent",
            "Status": true,
            "Message": "Added CMS Agent 5551120135.",
            "Target": "CMS",
            "Details": null
        },
        {
            "Identifier": "cn=JSmith9999,ou=AOCUsers,dc=avayacloud,dc=com",
            "ResourceType": "Ldap Object",
            "Status": true,
            "Message": "AADS AD user added. User added to security group: CC_USERS. ",
            "Target": "AD AADS",
            "Details": null
        },
        {
            "Identifier": "CN=JSmith9999,OU=AOCUsers,DC=avayacloud,DC=com",
            "ResourceType": "Ldap Object",
            "Status": true,
            "Message": "Updated Directory entry, DN: CN=JSmith9999,OU=AOCUsers,DC=avayacloud,DC=com",
            "Target": "AD AADS",
            "Details": null
        }
    ]
}

Other fields: Provision payload:
{
    "RequestID":"SPS_13062022_ProvUser_132_8888",
         - Random value, maybe IDtoAvaya-yyyy-MM-dd-hh-mm-ss . .?
    "FirstName":"John8888",
       - Ask Lewis - Given Name vs preferredName
    "LastName": "Smith8888",
       -

See table in october 9 email
    "UserID":"JSmith8888",
      - Eid?

    "EmailAddress":"JSmith8888@avayacloud.com",
       - standard wnco email address

    "ProvisioningGroup":"Dallas TX - OTCS",
       - Lewis: standardizing on one group? if more than one, how do we select?

    "BundleName":"CC Voice",
       - Static always set to: 'CC Voice'
       - Lewis: to confirm.

    "ReportUserGroup":"Public",
       - For billing purposes .
       - Public . . .others?
       - Lewis to confirm.

    "AddMailbox":"false",
       - not required - false is default.
       - if need voice mailbox, set to true.
       - Lewis to confirm.

    "AddSupervisor":"false",
       - If true, a supervisor is 'created' . .?
       - Will create 'CMS supervisor account' . .
       - Likely no - Lewis . .

Optional - skip these - all optional; just will use defaults.
   -
    "StationTemplate":"",
    "AgentTemplate":"",
    "MailboxTemplate":"",
    "CMSSupervisorTemplate":"",
    "StationExtension":"",
    "AgentLoginID":"",
    "SecondaryUserID":"Test U'ser123",
    "WsFERole":"Agent",
    "WsFESupervisor":"",
    "AXPUserProfile":null,
    "AXPUserRoles": ["Agent"],
    "AXPUserMemberOfGroups":[],
    "AXPUserOwnedGroups":null,
    "AddVoicemailForExtensionType":"agent",
    "AddSecondaryExtensionForVoicemail": "true",
    "PhoneType":"IP",
    "PhonePort": "",
    "ADSecurityGroupCollection":"",
    "OverrideStationAttribute": {
			"CommPassword": "827599"
    },
    "OverrideAgentAttribute":{},
    "OverrideMailboxAttribute":{},
    "OverrideSupervisorAttribute":{}
}

Testing deletes: - 21 seconds
JSmith8888
User_DeProvision
{{BaseURL}}/user/JSmith8888/?requestID=IDtoAvaya-2024-12-13
headers: only bearer auth

Deprovision response:
{
    "Status": true,
    "UserID": "JSmith8888",
    "Message": "User deprovisioned successfully",
    "ResourceStatus": [
        {
            "Identifier": "JSmith8888",
            "ResourceType": "ACCCM User",
            "Status": true,
            "Message": "Removed ACCCM User JSmith8888.",
            "Target": "ACCCM",
            "Details": null
        },
        {
            "Identifier": "5551120134",
            "ResourceType": "CMS Agent",
            "Status": true,
            "Message": "Removed CMS Agent 5551120134.",
            "Target": "CMS",
            "Details": null
        },
        {
            "Identifier": "jsmith8888@avayacloud.com",
            "ResourceType": "911inform User",
            "Status": true,
            "Message": "Removed 911inform User for jsmith8888@avayacloud.com.",
            "Target": "911Lab",
            "Details": null
        },
        {
            "Identifier": "CN=JSmith8888,OU=AOCUsers,DC=avayacloud,DC=com",
            "ResourceType": "Ldap Object",
            "Status": true,
            "Message": "Deleted directory entry for DN: CN=JSmith8888,OU=AOCUsers,DC=avayacloud,DC=com",
            "Target": "AD AADS",
            "Details": null
        }
    ]
}

Update email - 25 seconds:
{{BaseURL}}/user:RenameResources

request:
{
    "RequestID":"RenameResource_9999-IDtoAvaya-2024-12-23",
    "UserId":"JSmith9999",
    "NewEmailAddress":"e9999jsmithtest@wnco.com"
}

response:

{
    "Status": true,
    "UserID": "JSmith9999",
    "Message": "User updated successfully.",
    "ResourceStatus": [
        {
            "Identifier": "JSmith9999",
            "ResourceType": "ACCCM User",
            "Status": true,
            "Message": "Updated ACCCM User JSmith9999.",
            "Target": "ACCCM",
            "Details": null
        },
        {
            "Identifier": "JSmith9999@avayacloud.com",
            "ResourceType": "User Profile",
            "Status": true,
            "Message": "Updated User Profile JSmith9999@avayacloud.com ",
            "Target": "SMGR",
            "Details": null
        },
        {
            "Identifier": "jsmith9999@avayacloud.com",
            "ResourceType": "911inform User",
            "Status": true,
            "Message": "Removed 911inform User for jsmith9999@avayacloud.com.",
            "Target": "911Lab",
            "Details": null
        },
        {
            "Identifier": "e9999jsmithtest@wnco.com",
            "ResourceType": "911inform User",
            "Status": true,
            "Message": "Added 911inform User for e9999jsmithtest@wnco.com.",
            "Target": "911Lab",
            "Details": null
        },
        {
            "Identifier": "e9999jsmithtest@wnco.com",
            "ResourceType": "911inform User",
            "Status": true,
            "Message": "Updated 911inform User for e9999jsmithtest@wnco.com.",
            "Target": "911Lab",
            "Details": null
        },
        {
            "Identifier": "CN=JSmith9999,OU=AOCUsers,DC=avayacloud,DC=com",
            "ResourceType": "Ldap Object",
            "Status": true,
            "Message": "Updated Directory entry, DN: CN=JSmith9999,OU=AOCUsers,DC=avayacloud,DC=com",
            "Target": "AD AADS",
            "Details": null
        }
    ]
}

Unique/match attr: CN . .
  Lewis: is the e/x id the best target attribute here?



  3 FUTURE STATE: part: another application: WFO two sides:
    Avya side
    Varent side - screen capture - need to provision through IDM as well . .
   - Next Action?



Summary from Call - sent to every one on the call.

subject: Status summary from Starfish API testing session call, 2024-12-13

Team,

Today we had a chance to get to know the team, and talk through some basic context and test the API. We also collected a set of questions on some fields in the API that are included below. Please feel free to make corrections or add updates as needed.



DETAILS:

We discussed 3 components:
1 - Admin portal: There will be an admin portal setup that will make use of the IDM work we're doing below (the likely name will be IDtoAvaya IDM driver for now).
   - The Admin portal will be used to manage the users provisioned and updated through the driver.
2 - IDM driver: a new driver, likely called IDtoAvaya will be created to synchronize updates made from MyAccess and other sources into Avaya, and made available to the admin portal.
3 - We also discussed some future state items, regarding a WFO system with an Avya side, and a 'Varent' side; but this is all future and is not currently in progress.


We then did some basic API testing to provision, update, and deprovision users in Avaya. This testing appeared to work properly. We then collected a series of questions that need to be answered before driver development begins. I am directing these to Lewis for now, though I suspect we'll need to have additional calls and possibly additional people to answer the questions further.


Questions for Lewis:

Lewis, as we spoke with Parmeshwar we determined that we have the following questions regarding the fields.  Each of the following fields appears to be part of the minimal required payload to provision a user in Avaya. Can you confirm these items? Each item is the field name with an example, followed by the question to you:

1.    "FirstName":"John8888", -Should this be mapped to 'Given Name' or preferredName?

2 .   "LastName": "Smith8888", -Confirm: mapped to surname.

3.   "UserID":"JSmith8888", -we suspect this will just be the eid.

4.    "EmailAddress":"JSmith8888@avayacloud.com", -we suspect this will just be the standard wnco email address.

5.    "ProvisioningGroup":"Dallas TX - OTCS", - On this one there was some mention about choosing a group, or picking a static one . .thoughts? Do we have a set of groups we should consider?

6.    "BundleName":"CC Voice" - Statically set to 'CC Voice' for now.

7.    "ReportUserGroup":"Public", - We suspect this will be set to possibly one of several values - will we need to have other values than 'Public'? HOw should we select the proper value? This field has something to do with billing we have heard.

8.    "AddMailbox":"false", Can you confirm if we need voice mailboxes or not?

9.    "AddSupervisor":"false", Can you confirm we'll want supervisor values here? I think not per Parmeshwar, though wanted to confirm.

10.    Can you confirm that we will not be interested in the remaining attributes?

Optional - skip these - all optional. We are not planning on including any of the following fields in the payload:
   -
    "StationTemplate":"",
    "AgentTemplate":"",
    "MailboxTemplate":"",
    "CMSSupervisorTemplate":"",
    "StationExtension":"",
    "AgentLoginID":"",
    "SecondaryUserID":"Test U'ser123",
    "WsFERole":"Agent",
    "WsFESupervisor":"",
    "AXPUserProfile":null,
    "AXPUserRoles": ["Agent"],
    "AXPUserMemberOfGroups":[],
    "AXPUserOwnedGroups":null,
    "AddVoicemailForExtensionType":"agent",
    "AddSecondaryExtensionForVoicemail": "true",
    "PhoneType":"IP",
    "PhonePort": "",
    "ADSecurityGroupCollection":"",
    "OverrideStationAttribute": {
                  "CommPassword": "827599"
    },
    "OverrideAgentAttribute":{},
    "OverrideMailboxAttribute":{},
    "OverrideSupervisorAttribute":{}

Thanks,
--Aaron







2/6/2025 8:02:43 AM
Meeting for idtoavaya api
 - list of preofisiong uints from Mark Freedman
   -JOe discussion of mapping fields from column C org units to workday
   - joe matching phrase version of the org unit to workday . .workday may change this . .-
   -
 2/6/2025 8:22:00 AM- lewis - get entire list of departments?
 - want to just add the departments we need.
 - JOe: give eids to get examples
 - Lewis requesting pooja sharma two wusers in each group, give to joe to get samples.
 - Sagar nirali - mentioend a few itmes around bndles
  - bundles:
    uc power
    uc core
    uc basic
    cc voice
 - Parmeshare To . . . -> talked about some fields not needed
 -



3/13/2025 12:06:06 PM
Verint Integration - JOe says, tis' IDtoAvaya
  - (Starfish) Sagar Nirali - find out wat data from workday can be used to get into Avaya . .
  - Looking at getting proper job title.
  - Harkwell, Annie Marie - didn't include Lewis
  - 3/13/2025 12:08:51 PM Leiws Harvey just joined . .
  - lots of curciular chats . .
  - John Soto - requirements up to now . . .talking through spreadsheet updating 3/13/2025 12:33:05 PM
  - this is their manual process to get things goig I think . .

3/13/2025 1:20:10 PM - I left call early, per JOe's comment








