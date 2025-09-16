5/27/2025 11:39:17 AM

5/27/2025 8:09:35 AM

Form filling out meeting with Ben and Ashleigh

Apptio
 - selected domain: always only one domain
 - then grant roles -
 - 'customer' southewestairlines.com
   - environment
    - pov, clodabilyg main, sandox
 - 'main' production
 - probably not all of the roles . .
 - just targetprocess User
 - Account in aptio without any roles
 - then confirm
 - Then aaron in the system
 - I can log in to fron door
 - main - and target process
 - this as far as we want to go . .
 - SECOND HALF . .don't know all this
   - in target process . .
   - takes a sec to appear in the system . .
   - then select a portoflio
   - Role will then have a role . .
   - Aaron Keener , "Assignee" default role
 - can then add specific app roles
 - INititiave owner . .
 - We don't want to head down this role yet
 - Still learning the app roles
 - Roles - front door roles . .
   - application acess roles
   - Also roles to the other applications
   - Wiating on fiance to learn roles
 - maybe have target process user in myaccess . .
 - maybe Cludability
 -





5/27/2025 12:31:26 PM
Ashlegh
 - Where can we store the e/x id??
 - SSO - bypass options?
 - Delete may be an option . .but not desirbale . .
 - DEV/QA - note:; all user info in the same DB . .
 ENVIRONMENTS
 - front door is lowest user space
 - 'main' is production
 - 'sandbox' - Just need to copy . . .but could use this, lots of integrations don't use this . .
 - 'pov' - DEV and QA for now . .

Ashleigh - todo: separate domain for testing?
   - separate auth policy ..

email - XXXXXXXX@invalid.wnco.com
 - atlassian driver: dev driver turned on and against prod for once . .
  - a user put in a ticket . .was batman . .


TODO
 - Asleigh - can We disable SSO? not sure; maybe want to bypass ping in some cases. . .
 - Find out if API has limits
 - Can we setup sandbox for development - Ashleigh: yes . .
     - Maybe: sandbox-apptio.southwestairlines.com
 - Delete research: should be able to delete test users at will . . but for terminations; other times where we delete the account out of edirectory . .should we delete in frontdoor?
 - Ashleigh - Create IDM service accounts in frontdoor.
 -

learned:
 - post login to save key in postman works
 - create minimal works
 -

username=login
{
    "error": "Both users must be non-null."
}


Corrected key:
Authentication: 8b314380-6b0c-42da-bb17-498ec27967c2
Secret: RBGKTLkr8NJVolKZFgyOgZ7ZKHtSGdFHSUtColV4aQKE9O2r3FZnc8BXaWRG



{
    "id": "e2076e09-6a78-441a-91aa-8a85725db982",
    "login": "aaronusertest2@invalid.wnco.com",
    "active": true,
    "email": "aaronusertest2@invalid.wnco.com",
    "persona": "NONE",
    "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "aaron.kynaston@wnco.com",
    "createdOn": 1748373195538,
    "updatedBy": "aaron.kynaston@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}




POST https://frontdoor.apptio.com/api/user
{
    "login": "aaronusertest@invalid.wnco.com",
    "email": "aaronusertest@invalid.wnco.com",
    "domain": "southwestairlines"
}



{
    "error": "Users Active status can only be modified by using PUT /user/activate or PUT /user/deactivate APIs.",
    "translationKey": "FD_ACTIVE_STATUS_REQUIRES_ACTIVATE_DEACTIVATE_APIS_ERROR",
    "substitutions": []
}


Activate user . .
PUT -=
https://frontdoor.apptio.com/api/user/activate
https://frontdoor.apptio.com/api/user/activate
{
    "login": "aaronusertest2@invalid.wnco.com",
}


{
    "id": "7bda3210-d712-4ce1-8847-441c9b15eee3",
    "login": "aaronusertest@invalid.wnco.com",
    "active": true,
    "email": "aaronusertest@invalid.wnco.com",
    "persona": "NONE",
    "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "ashleigh.wansbrough@wnco.com",
    "createdOn": 1748372666307,
    "updatedBy": "ashleigh.wansbrough@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}






{
    "id": "fb45fe0e-1d98-4de3-97e4-19eebeacf6cd",
    "login": "aaron.kynaston@wnco.com",
    "active": true,
    "full": "Aaron Kynaston",
    "email": "aaron.kynaston@wnco.com",
    "persona": "NONE",
    "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "ashleigh.wansbrough@wnco.com",
    "createdOn": 1748355036733,
    "updatedBy": "ashleigh.wansbrough@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}

We're developing against sensitive data here . .


Two types of roles to grant . .
   1 - "Targetprocess User" is the name of the role that grants access here
   - Focusing on this . .
   - learning what roles needed to be requestable in MyAccess . .
     - Some grant applicatoin access and other permission . .
   - Still in the research area trying to determine proper roles, especially those that grant cross application rights . . .
   - Target process is ready for now . . - focusing on this one.
Phase 2 (possibly) still in research
   - looking on the gear in target process
   - looking at super granular role definition within target process
   - left: search for people
   - looked up me:
     - under my name: Assignee role . .by default when Targetprocess asigned
     - TLDR: Assinging this default role covers "global entities"
     - 'Portfolios' -> Budgeting . .I could be assigned to lots of portfolioas
     - "Portfolio roles" - "Budgeting Assing"
     - Further: could also have a team . .
Summary:
App level role - e.g "Targetprocess User"
Portfolio level role  - e.g. "Budgeting"
Team level role - e.g. "CSEE"

Phase 1: grant access to "Targetprocess User"
Phase 2: portfolio & team level role . . still need to see

Target dates?
   - 7/21/2025 - Phase 1 piece . .

Ben, 
 
Ashleigh and I had an excellent API review working session. Thanks [@Ashleigh](mailto:Ashleigh.Wansbrough@wnco.com)! That was a super useful session; Please feel free to correct/add update any notes here as needed.

Here is what we learned:

1 - We completed the IDM form (see attached).
2 - We can now do a minimal user creation through the API.
3 - We can activate/deactivate users through the API.
4 - We can do some basic modifications through the API.
5 - We confirmed we can delete accounts through the API.
6 - Ashleigh has good access to generating service accounts and corresponding API keys for the IDM, and IdMUnit service accounts that we'll want to set up.
7 - We learned that many actions require a different endpoint. .so these pieces will be custom, we'll not be able to rely on the default config as much as I had hoped, but it's not a show stopper.
8 - Creating a new 'domain' may help us isolate test data from prod data, this is still TBD. Right now, ALL users appear to be in the same area, called FrontDoor. All Apptio apps depend on this user database. It's not clear now if a new domain would give us a new set of users.
9 - Phase 1 would likely be exposing Apptio applications through MyAccess. Ideally, Phase 2 would include exposing application sub-roles and team roles.
 

We identified the following next actions:
**Ashleigh**:
- Research if we can enable SSO bypass in some special situations.
- Find out if we can fully set up the sandbox as a dev environment, maybe domain: sandbox-apptio.southwestairlines.com
-  Create IDM service accounts as needed:
    

- Ideally, we'd have three sets of credentials for DEV/QA/PROD once we formalize the sandbox above.
    

**Ashleigh** & **Aaron**

- Find out if API has limits
    
- Research Delete vs disable. We may want to leave users in normal business use cases, where test accounts will be deleted.
    

  

**Aaron**

- Define MyAccess work.
    
- Begin driver documentation.
    
- Continue API learning as needed.
    
- Create a vanilla REST driver for IDtoApptio.
    

  

  

--Aaron





API:
may not be used: access_key: - aW4vrKnBdEyIGdEhTB5JybOAWbFObJ4KO9nNc7eJldeakWkwRialTq0EPcdd
Public Key: 0594e675-1959-4e26-b299-3d30c1ce2280
Private Key: YrxaUUWTiqo6jSQDr8z2c5XC3vlggcdmpu1owOEfTnyZgwelXLZceJ9u7mgA

Temp token example: 2d5322d843a2141c63a4a88fb929da67efb9c874290599e759bf1aa1488eb02d4e11fe86a56347b386339c1d5f437f3df7f6205bb797e172436524207c7dd082

{

    "ping_uname": "Ashleigh.Wansbrough@wnco.com",
    "ping_pwd": "YrxaUUWTiqo6jSQDr8z2c5XC3vlggcdmpu1owOEfTnyZgwelXLZceJ9u7mgA",
    "keyAccess": "6cb0f001-9606-4885-ac30-72652ea44ff4" ,
    "keySecret": "aW4vrKnBdEyIGdEhTB5JybOAWbFObJ4KO9nNc7eJldeakWkwRialTq0EPcdd"
}

{
    "keyAccess": "6cb0f001-9606-4885-ac30-72652ea44ff4",
    "keySecret": "aW4vrKnBdEyIGdEhTB5JybOAWbFObJ4KO9nNc7eJldeakWkwRialTq0EPcdd"
}



5/27/2025 1:59:44 PM - call end
================================================


5/27/2025 3:19:42 PM
UUID's from our call today:
Target Process:
Main: d675e95f-b4af-56b8-6ea6-e9ed5041eab3
POV: 0c5845ea-43ff-5481-1fce-71f58ba2ff4d
Sandbox: 177932c3-5bac-53a1-fda9-33dc1f99c26c



Aaron Kynaston corrected key: 
validated: 5/27/2025 4:37:17 PM
Authentication: 8b314380-6b0c-42da-bb17-498ec27967c2
Secret: RBGKTLkr8NJVolKZFgyOgZ7ZKHtSGdFHSUtColV4aQKE9O2r3FZnc8BXaWRG


6/10/2025 4:48:48 PM
notes from today




wfn:
<resrc-handlerConf display-name="Rest Handler Details">userRole/#0#1#Content-Type;application/json userRole/&lt;querystring>#2#0#Content-Type;application/json userRole/&lt;association>#1#3#Content Type;application/json</resrc-handlerConf>

resrc-handlerConf display-name="Rest Handler Details">service/apikeylogin/&lt;association>#0#1# api/User#1#1#</resrc-handlerConf>


https://frontdoor.apptio.com/api/user


https://frontdoor.apptio.com/service/apikeylogin


```
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.10.0.0200">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <status level="success" type="startup"/>

    <driver-operation-data class-name="User" command="modify" event-id="" src-dn="">
      <request method="POST" url="https://frontdoor.apptio.com/service/apikeylogin">
        <url-token/>
        <header/>
        <value>{ "keyAccess": "830aa07b-a859-4f8d-afb3-3a3f00e711ae", "keySecret": "secret here" }</value>
      </request>
    </driver-operation-data>


  </input>
</nds>

```







































[06/10/25 13:21:31.592]:IDtoApptio ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set v3\IDtoApptio
     Channel:  Subscriber
     Status:   Fatal
     Message:  Failed to authenticate to Apptio, stopping driver now! Response from authentication attempt:{"error":"Unable to log in user. Validate that the ApiKey access/secret are valid","translationKey":"FD_AUTH_APIKEY_UNABLE_TO_VALIDATE","substitutions":[]}
[06/10/25 13:21:31.595]:IDtoApptio ST:Stopping driver due to an error in Startup policies.
[06/10/25 13:21:31.596]:IDtoApptio ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set v3\IDtoApptio
     Channel:  Subscriber
     Status:   Fatal
     Message:  Code(-9173) A policy issued a "fatal" status indicating that the driver should be shut down. Detail from policy: Failed to authenticate to Apptio, stopping driver now! Response from authentication attempt:{"error":"Unable to log in user. Validate that the ApiKey access/secret are valid","translationKey":"FD_AUTH_APIKEY_UNABLE_TO_VALIDATE","substitutions":[]}
[06/10/25 13:21:31.600]:IDtoApptio ST:Requesting termination.




driverAPIToken

nds/output/status/driver-operation-data/response/response-header/@apptio-opentoken


IDtoApptio toDocument:
   - IN progress Asleigh - domain research: secondary for dev/qa
   - Notes: I lost rights on our 'dev' key; and this appears; didn't get the error code . .maybe 404?


HTTP GET https://frontdoor.apptio.com/api/user/aaronusertest3@invalid.wnco.com

{
    "error": "You do not have the required permissions to perform READ on USER",
    "translationKey": "FD_FORBIDDEN_OPERATION_ON_RESOURCE_ERROR",
    "substitutions": [
        "FD_PERM_CHECK_OP_READ",
        "FD_PERM_CHECK_RESOURCE_USER"
    ]
}




{ "keyAccess": "830aa07b-a859-4f8d-afb3-3a3f00e711ae", "keySecret": "dlqucIvhGCWwW4W9hq8SCf2xA1OE0R7yfN2yhjtJGPtgFZXzoDfHfDJAeHJ9" }




			apptio-opentoken: b253d616018e8ea18d62a8b7f92f2432c1ae29ed77a4c2fc968e14f5d720280c81914555990b51a390e9ca0bc857469050be7a77c3bd44960ca38b5621267f1d



Authorization: Basic OTRiNGUwNjUtOWJkZS00ZDY3LTk3YTUtOTEyODFlZDYzOTRjOm9BSVZPR2s1NFdGMUs3OFVHdWJERjR3dGxJV0dlYWx2YVRXd1loN00zeVpJNmNiU1hEZWtuNk5mQTFnTw==


{
    "keyAccess": "{{apptioProdAccess}}",  830aa07b-a859-4f8d-afb3-3a3f00e711ae
    "keySecret": "{{apptioProdSecret}}"   oAIVOGk54WF1K78UGubDF4wtlIWGealvaTWwYh7M3yZI6cbSXDekn6NfA1gO
}



                    <filter-attr attr-name="swaApptioRole" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>

                <attr-name class-name="User">
                    <nds-name>swaWFNRole</nds-name>
                    <app-name>userRole</app-name>
                </attr-name>


6/16/2025 2:19:53 PM
old stuff from preveious session






6/13/2025 2:32:24 PM
IDToApptio

LIkely full user, user dump from API

{
    "id": "5132ff75-efcd-4f2c-a2a8-9600cdea6740",
    "login": "aaronusertest5@invalid.wnco.com",
    "active": true,
    "email": "aaronusertest5@invalid.wnco.com",
    "persona": "NONE",
    "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "frontdoor-myaccess-integration@wnco.com",
    "createdOn": 1749846770497,
    "updatedBy": "frontdoor-myaccess-integration@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}


Basic user creation:
{
    "id": "CAN'T WRITE TO THIS FIELD!!",
    "login": "aaronusertest5@invalid.wnco.com",
    "active": true,
    "email": "aaronusertest5@invalid.wnco.com",
    "persona": "NONE",
    "domain": "southwestairlines",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}


Response
{
    "id": "5132ff75-efcd-4f2c-a2a8-9600cdea6740",
    "login": "aaronusertest5@invalid.wnco.com",
    "active": true,
    "email": "aaronusertest5@invalid.wnco.com",
    "persona": "NONE",
    "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "frontdoor-myaccess-integration@wnco.com",
    "createdOn": 1749846770497,
    "updatedBy": "frontdoor-myaccess-integration@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}





6/16/2025 2:12:05 PM
Session #2 with Ashleigh

Environment IDs:3
Main: d675e95f-b4af-56b8-6ea6-e9ed5041eab3
POV:  0c5845ea-43ff-5481-1fce-71f58ba2ff4d
Cloudability: 5b1b8db8-86aa-4eb5-a817-65d5cc00fa82

6/16/2025 11:48:50 AM - created this user

{
    "full": "John Doe15 - e9999998765",
    "email": "e9999998765@invalid.wnco.com",
    "domain": "southwestairlines",
    "login": "e9999998765@invalid.wnco.com",
    "active": "TRUE",
    "accountType": "STANDARD",
    "persona": "NONE"
}

{
    "id": "ffd5d0a7-4301-4f7a-9554-78a2e539f67f",
    "login": "e9999998765@invalid.wnco.com",
    "active": true,
    "full": "John Doe15 - e9999998765",
    "email": "e9999998765@invalid.wnco.com",
    "persona": "NONE",
    "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "frontdoor-myaccess-integration@wnco.com",
    "createdOn": 1750096121923,
    "updatedBy": "frontdoor-myaccess-integration@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}

Assigned 'Targetprocess User'

{
  "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
  "user": "e9999998765@invalid.wnco.com",
  "defaultRoles": [{
     "name": "Targetprocess User"
  }],
  "customRoles": []
}



{
    "customerName": "southwestairlines.com",
    "id": "8b5c6609-0f44-43d7-a305-92cbe1072c23",
    "userId": "ffd5d0a7-4301-4f7a-9554-78a2e539f67f",
    "defaultRoles": [
        {
            "name": "Targetprocess User",
            "applicationTypes": []
        }
    ],
    "customRoles": [],
    "apiKeyRoles": [],
    "user": "e9999998765@invalid.wnco.com",
    "fullname": "John Doe15 - e9999998765",
    "email": "e9999998765@invalid.wnco.com",
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "environmentName": "main",
    "customer": "southwestairlines.com",
    "sso_granted_roles": false
}


Second assignment: 'Power User'

{
  "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
  "user": "e9999998765@invalid.wnco.com",
  "defaultRoles": [{
     "name": "Targetprocess User"
  }],
  "customRoles": []
}


MUST BE A PUT to update!


Failed: user already exists:
{
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "user": "e9999998765@invalid.wnco.com",
    "defaultRoles": [
        {
            "name": "Targetprocess User"
        },
        {
            "name": "Power User"
        }
    ],
    "customRoles": []
}


{
    "error": "EnvironmentUser with the given Environment and User already exists",
    "translationKey": "FD_ENVIRONMENT_USER_ALREADY_EXISTS",
    "substitutions": []
}


GET mike: https://frontdoor.apptio.com/api/user/Mike.labit@wnco.com


6/16/2025 12:02:13 PM
Now getting mike enviornment information:

GET https://frontdoor.apptio.com/api/environment/southwestairlines/5b1b8db8-86aa-4eb5-a817-65d5cc00fa82



https://frontdoor.apptio.com/api/environment/southwestairlines.com/main




GET -
https://frontdoor.apptio.com/api/v2/environmentusers/environment/5b1b8db8-86aa-4eb5-a817-65d5cc00fa82?searchString=mike.labit@wnco.com

{
    "status": 200,
    "requestId": "xs2lt7IC",
    "data": {
        "total_results": 1,
        "index": 0,
        "objects": [
            {
                "customerName": "southwestairlines.com",
                "id": "f520a85e-8dba-44bd-803f-a055e218bb76",
                "userId": "8b95d4b7-c657-4926-8121-e71843d8fdd1",
                "defaultRoles": [
                    {
                        "name": "Admin",
                        "applicationTypes": []
                    },
                    {
                        "name": "Cloudability User",
                        "applicationTypes": []
                    },
                    {
                        "name": "Self-Service Reporting Admin",
                        "applicationTypes": []
                    }
                ],
                "customRoles": [],
                "apiKeyRoles": [
                    {
                        "environment": "5b1b8db8-86aa-4eb5-a817-65d5cc00fa82",
                        "apiKeyId": "6d8f5cb2-fa10-44c9-a329-1883ffd9de61",
                        "apiKeyName": "MyAccessKey",
                        "user": "mike.labit@wnco.com",
                        "defaultRoles": [
                            {
                                "name": "Admin",
                                "applicationTypes": []
                            },
                            {
                                "name": "Cloudability User",
                                "applicationTypes": []
                            }
                        ],
                        "customRoles": [],
                        "customer": "southwestairlines.com",
                        "environmentName": "cloudability"
                    }
                ],
                "user": "mike.labit@wnco.com",
                "fullname": "Mike Labit",
                "email": "mike.labit@wnco.com",
                "environment": "5b1b8db8-86aa-4eb5-a817-65d5cc00fa82",
                "environmentName": "cloudability",
                "customer": "southwestairlines.com",
                "sso_granted_roles": false
            }
        ],
        "latestResultTimestamp": 1749741818465
    }
}

6/17/2025 12:41:17 PM
Email sent on current status of driver:

Dhivia, Ashleigh, ben, mike, joe

Team,

I wanted to update the team on the status and information about the IDtoApptio driver development as it stands now, as I will be OOO for two separate times starting tomorrow, one from Jan 18 - 20, then again from July 11 - July 25th.

The next major step in this project is to schedule the design and implementation of the MyAccess work once the Apptio roles have been defined.

Ashleigh and her team would like to set a target date for having the driver at 'phase 1' in QA, See 'Aaron action item #5' below. Ideally, this would include enough of the driver & MyAccess development for Ashleigh to do preliminary testing there. The action items we are currently working on are listed below. I will send a follow-up to this email at the end of the day to comment on my progress on my to-do items.




DETAILS:

I do not expect someone to pick up driver development while I am gone for the 18th-20th, nor from July 11th to the 25th; however, this should be enough information to pick it up if needed. I will work get far enough in driver development to have something Ashleigh can test.

Driver development status:

 - The IDtoApptio git repo exists.
 - The current build properly creates the 'final' folder from the existing export/IDtoApptio.xml file.
 - The Driver exists in DEV, and can authenticate using the goofy Apptio API:
   - Uses the 'lib-Authenticate' policy which can be included in the policy at any point to re-authenticate. Currently added as a startup policy to test authentication upon startup; but intended to be inserted anywhere in the policy flow to authenticate as needed.
   - Authentication seems valid for around 16 hours (from response header valid_till); see Postman collection in Git, and dev/IDtoApptio in AWS for the username/password - aka: keyAccess/keySecret
   - Driver does not yet 're-authenticate' when authentication expires.
 - I have just started writing tests, and updating swa-rest-connector on CSEE-4986 to support their weird authentication.
 - The swaApptioRoles attribute has been requested to be created in at least DEV/QA, under RITM11443777.
 - The IDtoApptio CI has been requested under RITM11421774.
 - The driver documentation is super messy right now, as it has lots of random thoughts from discussions with Ashleigh: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/629866534/IDtoApptio. I'll work to clean this up.

MyAccess preliminary work so far:
 - The swaApptioRoles attribute should be created soon, and is a case ignore, multi-valued string attribute. This attribute should contain single API-ready role values, such as "Power User" or "Targetprocess User" are the exact role strings.
 - We've discussed the three components, Ashleigh is familiar with the process, having worked on Atlassian with Mike. The components we mentioned are:
   - file: Role definition file: talked about how it lists possible roles, and role owners.
   - file: User to Role file: talked about how it shows all users and their corresponding roles.
   - Collection: we've talked about how the API should be able to be used for collection: See "Get Users roles" in the Postman collection in Git . .the eid will have to be stored at the end of the 'full' field that currently stores the full names of users; driver will have to do this.



Action items:

 - Ashleigh:  todo items along with expected ETA:
   1 - Creating a basic concept flow on how MyAccess would be used to request a role; may be complete by EOB on June 17.
   2 - Send a list of all possible roles by EOB on Wednesday, June 18.

 - Aaron: I'll work to complete items 1 and 2 today.
  1 - Work with the MyAccess team once we receive the new roles to design the implementation.
  2 - To enable MyAccess collection, I'll postfix the eid to the 'full' field (fullname in Apptio through the API) so:
    "fullname": "First Last"
    becomes:
    "fullname": "First Last - e123456" - will work to complete this now.
  3 - Complete the swa-rest-connector update to support HTTP body based authentication, and Apptio token from the response header, and merge to master; then update the swa-rest-connector dependency version in build.gradle in the IDtoApptio repo.
  4 - Make the driver documentation first rough notes section presentable and readable. Include Asleigh's concept flow chart from her4 action item #1 above as appropriate.
  5 - Work to complete Phase 1 of the driver: Two-part Front door API call to A) provision the user, and B) assign the user to a role and environment.




6/17/2025 12:41:24 PM





Time sensitive items
done - Request new CI: IDtoApptio has been requested.
done - Aaron: Request new swaApptioRoles - multivalued attribute.
in prog - Ashleigh: focusing on Apptio Conceptual flow chart.
 - Dhivya: confirm MyAccess timeline for apptio support & MyAccess population of roles . .
        - Role definition file - CSV request -
        - User to role - don't have any right now . .
*       - Collection: Need to store the eid . . .
 - Build driver: provision and set roles, two ```
```<driver-operation-data> elements . .```
 -



Phase 2
   - Second MyAccess reuqest? (Apptio Target process)




Ashleigh - probably not amke the 7/21, reasons why - before 8/25

 - not really enviormnets - scope of applicatoins . .
  Cloudability (why ignore apptioone in clouability: when request cloudability; get everything they need there.)
  pov
  main

6/17/2025 4:47:09 PM
Phineas Flynn - e9897 69472] but was: [
Phineas Flynn - e9897969472


{
      "id": "6507ce75-9758-419a-a1ce-d90dcde3f538",
      "login": "9897962524@wnco.com",
      "active": true,
      "full": " - e9897962524",
      "email": "9897962524@wnco.com",
      "persona": "NONE",
      "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "frontdoor-myaccess-integration@wnco.com",
    "createdOn": 1750198087132,
    "updatedBy": "frontdoor-myaccess-integration@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}




401 when not authenticated.

{
    "error": "You are not authorized to make this call. Please make sure you set the proper authentication headers. If you're using an auth-token already, make sure it hasn't expired. ",
    "translationKey": "FD_NOT_AUTHENTICATED_ERROR",
    "substitutions": []
}







       - Aaron: I'll work to complete items 1 and 2 today.
        1 - Work with the MyAccess team once we receive the new roles to design the implementation.
        2 - To enable MyAccess collection, I'll postfix the eid to the 'full' field (fullname in Apptio through the API) so:
          "full": "First Last"
          becomes:
          "full": "First Last - e123456" - will work to complete this now.
        3 - Complete the swa-rest-connector update to support HTTP body based authentication, and Apptio token from the response header, and merge to master; then update the swa-rest-connector dependency version in build.gradle in the IDtoApptio repo.
        4 - Make the driver documentation first rough notes section presentable and readable. Include Asleigh's concept flow chart from her4 action item #1 above as appropriate.
        5 - Work to complete Phase 1 of the driver: Two-part Front door API call to A) provision the user, and B) assign the user to a role and environment.






IDtoApptio - 15 hour timeout maybe - from response header: valid_till="1750247039565"
Login around:
Tuesday, June 17,        2:43:59.82  PM
Wednesday, June 18, 2025 5:43:59.565 AM GMT-06:00 DST


Ashleigh's Feature for Apptio - attachment includes a flow diagram.
https://southwest.atlassian.net/browse/SPME-1244

EE feature for Apptio
https://southwest.atlassian.net/browse/CYSEE-1349




6/25/2025 9:54:38 AM
Apptio: Julie Rios meeting
 - Up to date with Ashleigh
   - API discussion, working session to ensure we know how to use it.
   - Any questions?

 - I have a provision working in the Driver, would like to have you verify a test user if we can.
   - Kevin Moss - may be able to help review here . .


 - We're working to get MyAccess going; but it seemed like you and Ashleigh were expecting a testable release before we'd have the MyAccess stuff complete so I wanted to discuss plans with you here.


 - use cases . .
   -


prevous notes:

dump all environment information:
https://frontdoor.apptio.com/api/environment/southwestairlines.com/main


 - IDtoApptio - need a version of the drive rin QA by July 9th, and it has the most







6/24/2025 11:40:46 AM
Example to dump a users's roles:

%BASE_URL_ENVIRONMENT%/%TARGET_ENVIRONMENT%?searchString=9897964546777@wnco.com

https://frontdoor.apptio.com/api/v2/environmentusers/environment


{
    "status": 200,
    "requestId": "NGBBymbr",
    "data": {
        "total_results": 1,
        "index": 0,
        "objects": [
            {
                  "customerName": "southwestairlines.com",
                  "id": "bebc8108-060a-4272-be78-a5b126eac973",
                  "userId": "3d3be19c-0e9b-40ca-b74f-7305752e24ee",
                  "defaultRoles": [
                      {
                          "name": "Power User",
                          "applicationTypes": []
                      },
                      {
                          "name": "Targetprocess User",
                          "applicationTypes": []
                      }
                  ],
                  "customRoles": [],
                  "apiKeyRoles": [],
                  "user": "9897964546777@wnco.com",
                  "fullname": " - e9897964546",
                  "email": "9897964546777@wnco.com",
                  "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
                  "environmentName": "main",
                  "customer": "southwestairlines.com",
                  "sso_granted_roles": false
            }
        ],
        "latestResultTimestamp": 1750786824055
    }
}

compared to normal:
{
    "id": "3d3be19c-0e9b-40ca-b74f-7305752e24ee",
    "login": "9897964546777@wnco.com",
    "active": true,
    "full": " - e9897964546",
    "email": "9897964546777@wnco.com",
    "persona": "NONE",
    "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "frontdoor-myaccess-integration@wnco.com",
    "createdOn": 1750720749521,
    "updatedBy": "frontdoor-myaccess-integration@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}







{
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "user": "9897962533@wnco.com",
    "login": "9897962533@wnco.com",
    "defaultRoles": [{"name": "Power User"},{"name": "Targetprocess User"} ]
}


{
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "user": "9897969239@wnco.com",
    "login": "9897969239@wnco.com",
    "ROLESINSERTHERE": "ROLESVALUE"

    "defaultRoles": [{"name": "Power User"},{"name": "Targetprocess User"} ]
}

{"name": "Power User"}

"defaultRoles": [{"name": "Power User"}]




Create second payload to assign user to an environment



1 - Authenticate
2 - Create user: POST simple: https://frontdoor.apptio.com/api/user
      {
          "email": "9897964546777@wnco.com",
          "domain": "southwestairlines",
          "login": "9897964546777@wnco.com",
          "active": "TRUE",
          "accountType": "STANDARD",
          "persona": "NONE",
          "full": " - e9897964546"
      }
      note: didnt' have swaPreferredFullname pouplated, so it doesn't have the name there .


3 - Can see user at: https://frontdoor.apptio.com/api/user/9897964546777@wnco.com
4 - ASsign enviornment: POST simple: https://frontdoor.apptio.com/api/environmentuser
    {
        "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
        "user": "9897964546@wnco.com",
        "login": "9897964546@wnco.com",
        "defaultRoles": [
            {
                "name": "Power User"
            }
        ],
        "customRoles": []
    }
5 - See the full suer user that was granted:
GET: https://frontdoor.apptio.com/api/v2/environmentusers/environment/d675e95f-b4af-56b8-6ea6-e9ed5041eab3?searchString=9897964546@wnco.com




6/27/2025 1:48:40 PM

myaccess discussion with Dhivya, apptio team, Mike, maybe chandu . .





6/27/2025 10:59:49 AM
IDtoApptio: MyAccess & use cases

Apptio
  - FrontDoor
  -

Initial migration -
   - User will exist in TargetProcess - but NOT Frontdoor . .
   - Front door is app access . .
   - What is the state of users here???

  Phase 2:
     - Will exist in TargetProcess . . will eventually need a role in target process . .

  Ashleigh
     Cloudability
      - cloudability (tony star?)  -> Role: "?"
     main
      - Apptioone -> Role: "?"
      - TargetProcess -> Role: "Targetprocess User"

Example: Julie.rios: has a main, pov, and sanbox access to targetprocess.
 - now Julie - seeing in target process - appears in target process . .
   - 'assignee' is example target process role . .

 - End users won't know the env . .but they should know app and role
 - "integration user" doesn't have an ccount in front door


 - Dhivya PDOS -> target process database?
    - Why not use drivers to provision to target process?
    -

Mike: POC? Julie: Well underway here . .
   - timeline: multiple golives - Manual user provisiong for now
   - Original ask: 7/21;
   - frontloading October: well before then.


MyAccess:
   -> Can we 'segregate' each application? not just 'Apptio'?

Use case:
   - come into mya: search cloudability
   - select list of roles . .all three roles auto provisioned


Frontdoor is implied
   - when selecting any role . .


1.1 User Provision

  Environment:Application:Role

  1 - If here: need to make a choice of which roles
    Main:ApptioOne:XXXXXXXXX (multiple, NA now.)*

  2 - Auto provision all 3
    Cloudability:Cloudability:XXXXXXXXX  - AUTO ASSIGNED
    Cloudability:Cloudability:CloudabilityUser  - AUTO ASSIGNED
    Cloudability:Cloudability:XXXXXXXXX - AUTO ASSIGNED

  3 - Auto give them 'Targetprocess User', then (phase 2: TargetProcess roles)
    Main:TargetProcess -> "Targetprocess User" (no further rights in Phase 1)
        phase 2: initiative/epic owner + 98% of roles available now 6/27/2025 11:27:14 AM


Any roles multually exclusive? Nope . .

 - swaApptioRoles will maintain all roles . .
 -



Matching:
   - 1 - actual account in Frontdoor
   - 2 - tie to the enviornment + role that the user has
   - 3 (phase 2) (targetprocess account . .PDOS . .)
     - connect between frontdoor and targetprocess user database should be autorcam
     - user would still need to get 'Targetprocess User' role.
   -


update cases: Issue with perferred vs legal name
   - Ashleigh - PDOS fighting with IDM system
     - When logged in to Apptio, names are fed from SSO
     - For Ashleigh, she shows up as 'Ashleigh Wansbrough'
     - PDOS - shows based on legal name - thankfully, email is legal, and this is username
     - Asleigh legal name: Sybil
     - every morning, Ashey's user name will swap back and forth.
     - Possible solution? Have PDOS send preferredName?
     - Julie Rios: If someone has name change in Workday -> PDOS
       - Wether first or last; email eventually updates . .
       - behind the scenes: frontdoor/tp stay in sync . .
   - Ashlegh: pick 'login' . .
     - Automation role: can keep login based on email . .
   - Vendor controls connectivity between FD/TP . .



   - Target process does have it's own user database; Cloability and apptio1 use frontdoor


   - Mike: user experience:
     - one query: show 'Apptio' . .
     - When in mya for 'self' - wants dedicated 'Apptio' -> then show list of applicatoins . .



Team,

The Apptio app team, and the EE team were able to discuss the IDtoApptio driver & MyAccess requirements in our all today.  Here is what we covered:

 - We began a use case discussion to design what the driver should behave.
 - We discussed initial migration and how the preexisting TargetProcess user database would require a change to the plans.
 - We discussed how Target Process internal roles would be added in Phase 2.
 - We covered some ideas on how Apptio could be presented in MyAccess, such as in its own dedicated 'access for self' menu item, or otherwise.
 - We covered some base use cases, such as provision, updates, and deprovision.
 - We discussed concerns around email/login staying in sync.
 - We covered some concerns around what values we should use for the association.
 - Confirmed SSO uses legal name, where we'd rather use the preferred name.
 - Discussed legal vs preferredName swapping that is occurring for Ashleigh due to having a preferredName different than Legal.
 - We agreed that a Phase 1 with all first level roles (all application roles, but not targetprocess sub-roles) could be deployed all the way to production if needed.
 - Dates mentioned for targeting: Before 8/25 for phase 1, Before October for phase 2.



We have the following remaining questions:
 - PDOS questions:
   - What is the PDOS process?
   - Where does it run?
   - What is its source of data?
 - Conversions issues: we still need to discuss what kind of conversion issues we need to solve still.
 - Initial migration: Confirm the flow, when installing in prod for the first time flow should be:
   - User hired in Workday.
   - User (possibly) is then created in TargetProcess user database through PDOS.
   - END USER: requests one or more roles involving TargetProces in MyAccess.
   - User is created/matched into front door.
   - User is assigned the "Targetprocess User" role.
   - Do we do more at this point to tie the FrontDoor, and (TP) users together?



We have the following todo items identified from this meeting:
Ashleigh & team:
  1 - MyAccess: Total list of roles: static list required in MyAccess format. Ashleigh is still waiting on finance - ApptioOne (finance app)
  2 - Get access to an IDM Apptio support person who can answer the following questions:
     1 - What is used in FrontDoor to keep users unique? We see an 'id', and we see 'login' and 'email' fields; but only 'login' seems to be required for most API calls.
     2 - TargetProcess:
      2a - If a user exists in the TargetProcess database before the FrontDoor user database, do we need to 'tie' the users together?
      2b - If so, how?
      2c - How do we know the tie is complete?
      2d - Do we need to use both the FrontDoor api and the TargetProcess API to make updates to the user after that point?
  3 - Data Integrity work:
     - Chris at PDOS may be able to help resolve preferredName vs legal name swapping issues.
     - A developer on Ashleigh's team may be able to help keep login & email fields in sync in Apptio (warning: the IDM driver does need to be able to uniquely identify accounts and is currently set to email - if email changes in Front Door without the driver's knowledge, this will cause issues).

  4 - Phase 2: Work with Aaron to send TargetProcess API, and possibly have a working session to resolve issues & answer questions.

Dhivya:
 - Setting up a meeting with the Core team to see if we can add 'Apptio' to the MyAccess 'access for self' list.

Aaron:
   1 - Clean up and send Postman project to Mike & Ashleigh. .
   2 - Update use cases from rough notes to the AC standard.

Aaron and Mike:
   1 - Discuss options to do collections through MyAccess if possible; or report feed files are the only option if appropriate.

Aaron and Ashleigh:
   1 - Find out how to read, update, and manipulate users through the TargetProcess API.


--Aaron



GET
https://frontdoor.apptio.com/api/v2/environmentusers/environment/0c5845ea-43ff-5481-1fce-71f58ba2ff4d?searchString=e9897124707@wnco.com

if not found:

{
    "status": 200,
    "requestId": "rpTf3MHI",
    "data": {
        "total_results": 0,
        "index": 0,
        "objects": [],
        "latestResultTimestamp": 1751040728763
    }
}



#649503-04c

When trying to change login:
Post on normal payload:
{
    "error": "Both users must be non-null."
}


REst driver version:
<product build="20240611_0145" version="1.3.0.0100">Identity Manager REST Driver</product>







6/30/2025 3:47:39 PM
work to see if driver-operation-data is open
RACE:  IDtoApptio: Created modify handler for resource custom-authentication that calls http POST on uri https://frontdoor.apptio.com/service/apikeylogin/<association>
DirXML: [06/30/25 16:36:20.99]: TRACE:  IDtoApptio: Created add handler for resource User that calls http POST on uri https://frontdoor.apptio.com/api/user
DirXML: [06/30/25 16:36:20.99]: TRACE:  IDtoApptio: Created query handler for resource User that calls http GET on uri https://frontdoor.apptio.com/api/user/<querystring>
DirXML: [06/30/25 16:36:20.99]: TRACE:  IDtoApptio: Created modify handler for resource User that calls http PUT on uri https://frontdoor.apptio.com/api/user/<association>
DirXML: [06/30/25 16:36:20.99]: TRACE:  IDtoApptio: Created add handler for resource User-environment that calls http POST on uri https://frontdoor.apptio.com/api/environmentuser




Taylor
Carl,
Colton


:
6/30/2025 1:46:45 PM
Doing driver-operation-data manual payload test

base url:
https://frontdoor.apptio.com/


login:
https://frontdoor.apptio.com/services/apikeylogin


Findings:

After deleting all 'resources' and the base url, this is seen as a result of any payload I send to the shim:
<nds dtdversion="3.0">
  <source>
    <product build="20240611_0145" version="1.3.0.0100">Identity Manager REST Driver</product>
    <contact>NetIQ Corporation.</contact>
  </source>
  <output>
    <status level="success" type="driver-general">
      <description>Subscriber is configured to be inactive.</description>
    </status>
  </output>
</nds>


NOw adding a single 'default' class name to see if it lets me submit activities.





Joe,

Q for you: the Apptio driver just got more complicated; and I found not only will I have mulitiple endpoints, and have been able to successfully map some custom 'classes' to enable the mapping of an XDS event to a REST call. However, I found I'll have a second base url when working with TargetProcess, another app in the Apptio suite. One option would be to use a second driver . .but I think that'd get messier than we want.


User -> XDS Add -> HTTP GET /api/v1
User-update -> XDS Add -> HTTP POST /api/updateUser


User -> XDS Modify -> HTTP PUT







Alternatively and ideally, I'd just build up the driver-operation-data payloads on my own, using the command, method, and url values below, as in:

    <driver-operation-data class-name="User" command="modify" event-id="" src-dn="">
      <request method="POST" url="https://frontdoor.apptio.com/service/apikeylogin">
        <url-token/>
        <header/>
        <value>{ "keyAccess": "830aa07b-a859-4f8d-afb3-3a3f00e711ae", "keySecret": "secret here" }</value>
      </request>
    </driver-operation-data>

I am going to go see if the 'default' mode allows me to just write in the data vs the 'custom' mode that we click on to map each XDS call to the corresponding HTTP call. I am going to go test this now unless you already have more context here.






    <driver-operation-data class-name="TargetProcess" command="modify" event-id="" src-dn="">
      <request method="POST" url="https://frontdoor.apptio.com/service/apikeylogin">
        <url-token/>
        <header/>
        <value>{ "keyAccess": "830aa07b-a859-4f8d-afb3-3a3f00e711ae", "keySecret": "secret here" }</value>
      </request>
    </driver-operation-data>



Learned that setting a resource to 'default' means that it makes up all of the calls for you . .which seem to likely never be right as REST doesn't seem to be super consistent: the default setting does this:

irXML: [06/30/25 15:28:51.87]: TRACE:  IDtoApptioTEMPORARY: Created default add handler for resource custom-authentication that calls http POST on uri http://custom-authentication
DirXML: [06/30/25 15:28:51.87]: TRACE:  IDtoApptioTEMPORARY: Created default modify handler for resource custom-authentication that calls http PUT on uri http://custom-authentication
DirXML: [06/30/25 15:28:51.87]: TRACE:  IDtoApptioTEMPORARY: Created default delete handler for resource custom-authentication that calls http DELETE on uri http://custom-authentication
DirXML: [06/30/25 15:28:51.87]: TRACE:  IDtoApptioTEMPORARY: Created default query handler for resource custom-authentication that calls http GET on uri http://custom-authentication


So the assumption that each http action appears that way, and just appends the resource name, the default mode appears likely almost always useless . .

So another core problem is this a 'command' is required on the driver-operation-data; which maps to a shim 'handler'. If it's there, then it implys a handeler is used, and then it implies the method, despite being available ont he request element.

      <input>
                <driver-operation-data event-id="0" src-dn="">
                        <request method="POST" url="https://frontdoor.apptio.com/service/apikeylogin">
                                <url-token/>
                                <header/>
                                <value is-sensitive="true"><!-- content suppressed --></value>
                        </request>
                </driver-operation-data>
        </input>
</nds>
DirXML: [06/30/25 15:44:08.87]: TRACE:  IDtoApptioTEMPORARY: RESTSubscriptionShim.execute() :
DirXML: [06/30/25 15:44:08.87]: TRACE:  Remote Loader: SubscriptionShim.execute() returned:
DirXML: [06/30/25 15:44:08.87]: TRACE:  <nds dtdversion="3.0">
        <source>
                <product build="20240611_0145" version="1.3.0.0100">Identity Manager REST Driver</product>
                <contact>NetIQ Corporation.</contact>
        </source>
        <output>
                <status event-id="0" level="error" type="driver-general">Exception: Missing command for the operation.</status>
        </output>
</nds>


7/2/2025 12:23:25 PM
from our call today:







swaApptioRolesMain
swaApptioRolesCloudability

Apptio:


swaApptioRoles:
pov|||enviornmentguid|||AptioOne PowerUser|||customroles
pov|||enviornmentguid|||AptioOne PowerUser|||customroles
main|||enviormentguid|||Targetprocess User|||customrole5

swaApptioRoles:
ApptioOne "Power User"





The Apptio is a suite of products,
   - but the suites of applciations are organized into what htey call enviornments.

 - Target process - one of the sub apps and has a completely separate apai
 -

Is this call mainly focusing on the MyAccess side?
 -

Flow
 -


MyAccess
Two scopes of roles in Myaccess:

Roles appearing MyAccess for everyone
 - Apptio:ApptioOne:Role1
 - Apptio:ApptioOne:Role2
 - Apptio:ApptioOne:Role3
 - Apptio:Cloudability:(3 roles; we always assign all three)
 - Apptio:TargetProcess:'Targetprocess User' (then phase 2 -> sub role)

Roles for Apptio App team only
  - Apptio:FrontDoor:Admin
  -



Questions:
 - Confirm: Is the target process user required for access?
 - PDOS - BOOO!!!
 - Consider multiple drivers . .
   - How close can we get this to a simple straightforward process? (sailpoint focus)
 - What makes the driver unique (aka a problem for sailpoint)
   - Using two apis . .
 -0 fullfilment can be dcoubled from the roles . .
 - 1 vs 3 drivers not too probelmatic ..
 - JSP - Allows custom coding . . .allows proxy
   - ANY kind of preprocessing . .aka combine multiple API . .

MAIN TAKE AWAYS:
1 - Need to design ALL AT THE SAME TIME
   - 1 MyAccess role exposure,
   - 2 Role communication to edir,
   - 3 Edir -> fulfill all at the same time.
2 - Asleigh: Need to get final number of environments . .
3 - Main goal: end target: make whatever MyAccess Requests = to what it can collect . . .
4 - Final roles: need to build technical roles . .
     - Aptioone power user tech role name
     - Entitlement layer: 0c5845ea-43ff-5481-1fce-71f58ba2ff4d:Power User
Goal: Every entitlement doesn't need its own routing
 -


User experience:
   - If a Targetprocess user has admin role . .could go straight there
   - Should we split to 3 apps?












https://frontdoor-ui.apptio.com/home?domain=southwestairlines&searchBy=customer&tab=environments&value=southwestairlines.com








7/7/2025 4:05:35 PM
Major calls today: myaccess + IDtoApptio driver design:

Team,

Today we had calls with both the MyAccess team and the apptio app team, and discussed the following items. Please let me know if you have questions. The summary is that Ashleigh and the team is now working to see what options she has to have the two files needed for MyAccess.


DETAILS:

1 - API based collection is not an option, as Apptio's API does not follow a standard authentication model that MyAccess can use.
2 - We discussed the role mapping file, and the user to role mapping file that the Apptio team will need to generate. The user-to-role mapping file will need to be generated on a daily basis.
3 - We discussed some items we'll need to resolve before the Apptio team's file generation can work properly
4 - We noted a few questions regarding the requirements in the role file.

The action items are as follows:

Ashleigh:
* Confirm Apptio team (Mike or Paul maybe?) Can pick up the generation of the role and user to role mapping files.
* Confirm Apptio team can get access to AD (This is in Aaron's todo list below as well).
* Talk with leaders and epic owners to describe this work as clear as possible:
      * End goal: need to be able to programmatically collect all role definition data, and current user -> role assignment data, and return it in two reports for MyAccess.
* Getting access to an IDM developer to answer some questions:
      * Can we store eid somewhere that both the Frontdoor and Targetprocess API's? Maybe - consider ‘email for [x123456@wnco.com](mailto:x123456@wnco.com)’ for the eid? Why does this create a duplicate account in Target Process, etc?
      * Can we use a standard auth method for Apptio? Or at least an auth method that returns the key in the body?        
    - Are we missing some API calls? For example, Is there one to list all roles for all applications in all environments?
- Questions to answer from Aaron:
      - If a user is being processed for the first time in the driver, we will be deleting all the roles for all environments, including target process, then rebuilding their roles that we received from MyAccess. Any concerns? Would there be any data loss from this role reconciliation process?



Aaron:
* Ashleigh has requested some examples from other teams that are producing the Role and User to role files; and has these questions:
      * How are these teams automating this work?
      * What can we also do to avoid "recreating the wheel here"?
* Ashleigh would like to split The MyAccess portion into three apps:
      * Environments would be: 
            * ApptioOne
            * Cloudability
            * TargetProcess
      * Does this also mean three separate swaApptioRoles attributes in eDirectory?
      * Does it also imply we may be better using three drivers, that process one of the three apptio roles attributes?
* Question: How does Ashleigh get access to AD? - no direct access (they’ve asked Johny Nelson for one-offs; they’ve fixed issues on an on-demand basis).  It sounds as if most app teams have access to pull data from AD; yet I don't know what options they have to access it.
* Question: When we get to phase 2, can we use parenthesis to store the TargetProcess sub role? This is one of 68 roles that appears as a string, and has to be set by the TargetProcess API - example user with two 'default' roles, and two 'custom' roles, and has 'Epic Owner' as their target process sub role:
1234,e332211,main|||Targetprocess User(Epic Owner):::Power User|||Custom Role1:::Custom Role2
* Question: Is there an actionable response to the concern that Frontdoor is the user data store for DEV/QA/PROD? I don't think we have a way around this unless we purchase another apptio instance . . .
 
     
--Aaron

more ntoes:

7/7/2025 1:58:12 PM
Ashleigh: Apptio MyAccess call.
Intro:
   - Aaron Kynaston - IDM dev on ID
   - Gokul - taking over driver while Aaron is out
   - Chris: epic owner (Cristino Santiago)
   - Julie Rios - PO

gokul:
   - multiple apps -> requires multiple attributes.
   - Customrole:::customrole2 -> vs multiep elines
   -



{
    "environment": "0c5845ea-43ff-5481-1fce-71f58ba2ff4d",
    "user": "e9897122478@wnco.com",
    "login": "e9897122478@wnco.com",
    "defaultRoles": [
        {
            "name": "Targetprocess User",
            "applicationTypes": []
        },
        {
            "name": "Power User",
            "applicationTypes": []
        }
    ],
    "customRoles": [
        {
            "name": "Custom Role 1",
            "applicationTypes": []
        },
        {
            "name": "Custom Role 2",
            "applicationTypes": []
        }
    ]
}



1234,e332211,main|||Targetprocess User(Epic Owner):::Power User|||Custom Role1:::Custom Role2

7/10/2025 10:18:04 AM






7/9/2025 11:15:58 AM
Ashleigh feed file meeting
Aaron
Paul Slusar
Michael Darragh
Dhivya
Mike Labit
Aaron Kynaston

Discussing Tony Agent - IBM apptio developer . .
 - Mike - Automated or manual files? Automatd is ideal
 - Role file may not need to automate.

 - 'art is possible for myaccess' . . Sailpoint direction . .
 - biggest requirement: need to have certain set of roles expoed to general public

MIke: how would the admin vs world accessible role pages be expressed in MyAccess?

Dhivya's notes:
General population::
  1 - Goto MyAccess to request access to certain roles
Specific Access:
  1 - Users will reach out to Ashley's Team for special roles.
  2 - Ashley wants to be able to goto MyA and request it for them

Mike: working to describe

Dhivya:
 - exposure: specific roles in prod that need to be hidden/controlled. . . What about 'roll over' ownership?
 - Maybe just have one screen; but make Ashleigh + administrators be the only people that can approve thos roles?
 - Ashleigh - won't avertise additional roles - you'll know you need it; users would arleady be talking with apptio team.
 - Volume of users for these restricted roles? - "very low, and very few and far between".

Mike - can role owner login and make request for someone else?

Dhivya - want a group to designate
  Action item for us::
  Can the above mentioned specific access be done thru MyA?

Asleigh - dont' have dev env for cloudability . .
   - Don't want to do this in non prod.
   - Staight up do not have lower env for cloudability.
   - Don't have reason for this yet: Ashleigh wasn't there when they setup cloduability.

*****Tony StoneBarger: asking about having dev acces to cloduability.

Ashleigh; summary: roles to expose and roles not to expose.

Date converation: must do todo items . . and UFM in place. Can't go live without UFM.

Joe: don't even know if we can split 1, 2 or 3 - need answer to questions. could then define timelines for each app. Asliegh - priority: All three have a piece of phase 1, front door.
  3 apps:
  Apptio 1 - phase 1 (aug)
  TargetProcess - phase 1 (aug) /Phase 2 (oct)
  Cloudability - Phase 1 (aug)

Mike: example of automatch feed files:
  App that is automatically creating feed files and sending through UFM:
   - Another person to reach out to, who has helped many app teams setting up UFM and automating these files is Nishant Seth


  Oracle Cloud Interface
  Jay Allen is a good person to reach out to.
 - Ahsliehs creen share:
   - Add a user, showing create user process.

Dhiviya:
  Actual UFM in SWA is owned by a Team n one of the SMEs there is Chandra Billava


Discussion of setting roels on Ashleigh's screen - role + env is what is unique . .
 - example: user getting 3 standard cloudability - but if need to add one more.

Joe - yes, cloudability sooner . .Ashleigh: almost have final list of all roles main env . .
   - same setup as cloudabilty; just separate roles.
   - Joe: still Need to align on ufm
   - One role with cloudability . . this makes it easier for both role definition and report back.

Ashleigh - 'assigne' current default role, may be called "default"

'integration management'
   - users getting loaded into target process.
   - PDOS, integration user or not? (Aaron question: need to know how to match up data)

** targetprocess: has a 'Resource ID field'
 - reason behind phase 2 target process roles:
   - enables wave deployment of stuff.

Default role in target process: other requestinable roles?

Joe: maybe:
  - Two drivers now: Clloudability & Main (Frontdoor in main driver) target process role
  - Driver frontdoor: 1 driver . .
  - Second driver - different data, PDOS data, porbably not user reation driver.
     - PDOS
     - just matching on existng
  - Find existing user, give licene to log in . .
  - authoritagive only about roles.



 - just because you exist in target process: don't have  front door acount required for tp!

 - challenge: linkage between target process front door . .
   - timing on role assingment betwen target procss . .
   - could preassign roles; but not log in until front door account.
 - Targetprocess api, do two things:
   - Asign role
   ****- link between frontdoor/target process - don't ned to know or care, email si the same i'll lnk.
 - TP use resource eid to find the user . .
 - different end point . .
 -

 - Frontdoor driver,
 - Target process driver
   - why uncheck integration box: oh - convert PDOS to actual account, by having frontdoor . .
   -

 - Targetprocess - only like 10 to be exposed to general public


1 - Frontdoor driver
2 - Target process api driver: just licencing driver
  - PDOS - guarnatiees user will exist, so tp driver can be just matching.

UFM is one of the biggest concerns.
   - Joe - may not need ufm for target process . .api may be good enough
   - frontdoor is bad api, requires ufm now, and may not be supported in saipoint day.
   - need to massage data.

Ashleigh would prefer to have more defaulted items, and less choice in the forms.

two files: role, and user->role.
   - values inside can be changed . .

Format: what does it need to be?  .
Ashleigh/joe: application entitlement field . .

needed fields:
  App ID,
  no groups . .
  app role: name in myaccess for end users
  Application entitlement - really in debate still: applicatoin entitlement. heart of driver to apply role. Still need to design/debate this one.
    - may have multiple sets of data . .this makes it difficult.
***  - the prolblem: when sending file back: Entitlement above has tmatch the entitlement below.
  - Joe: have to designate all user data matches the role entitlement in role file!
 - ashlieh: double focusing on app entitlement = app role files . .

ashleih wrapping head around it
 - If apptio has ability to write role name to custom field in apptio, then we could just define custom field in UFM.
   -

Option C details: 'super roles' - can use a single string to easily report as an entitlement, and collect on the way back from app to MyAcess!
   - Since we don't have a place to write a role in Apptio, option C is not an option.
  Option C: easier file, more difficult driver, needs fields in apptio.

Opt B not an option: too much manual work, C is out - A is our option, it'll be a bunch of work for Apptio team.


Ashleigh's action items:

GOAL: 8/25 for prod!!??

Need answers to the questions to establish dates::
  Cloudability is easier to build
  Possibility of multiple drivers
    2 divers (one for frontdoor, and one for Target process)
    Frontdoor is provisioning driver
    targetprocess is licensing  only driver
UFM
  Potential for TP Access might not need UFM
  Will need will UFM for Frontdoor
  Steps:
    Create the files
    automate our process to dump it into UFM

1. Email that Aaron sent out
2. Gouda to work on UFM Files and get with teams that have already done this
3. Need these to establish dates

Can have target process play opiton . .
 - if one driver, can pretend in pvo, just not write clouabildy
 - can use POV for cloduability roles!

POV - would be nice to have POV QA . .
sandbox for apito 1 and target process maybe . .not target process.
   - no pdos data here . .; but just a few users is fine

Or, point dev & Qa both to POV .
 - Ashleigh famliar with this . .

Big item: making sure dev and QA drivers not active when working with prod.

***For DEV & QA - restrictions on eid's that we can use . .
   - specific users . .
   - won't have specific users for target users . .

Ashleigh list:
Current Action Items:
1 - Email that Aaron sent out
2 - Gouda to work on UFM Files and get with teams that have already done this
3 - Need these to establish dates
4 - Ashleigh to look at Sandbox for Dev environment

Joe: need to have some users to match on . .
   - targartet process needs october . .

Joe:
today: 1 driver to put users into front door.
 - one ufm process to get users to roles
 - possible to hig august

Joe: key question: Can Ahsliegh get the file back to them. .
  - most enviroments not this complicated.

role definition file: manualy build this
user -> role file that needs to be manually created.
 - key: can we get away with one simple role that menas more in system: option c
 -  . . .or super roles . . problem, too inconsistent . .

(shssshh . .lol) Joe: go live with provisioning first (

Ahslieh: if have bad prlbleM: can auto cllose? no . .

Cyber: We want to be compliant . .need myaccess.

MyAccess wont' be depcrecated until sailpoint ui is avialble and make that switch. Parts will start disappearing. others will be there for a while . ideally not have people use both - maybe end of 2026.

Ahslieh has seen unclosed role assignments from MyAccess . .naughtly list . .
 - Ashleigh looking to get with team . .entitlements are scary, but not impossible.
 - joe: multipe role more complicated . .

Ashleigh: more concerned about migration.
   - joe: why more complicated? ashligy: just thining . .
   - 40 people have admin access . .
   - when we write roles; we provde what we want, rest goes away . .

 - Better understnading of files - Paul and Michael.
 - michael & paul, "little bit of sense".
 Ashleigh: taking a stab at creating role files; then take stab at autobuild - mayve just a handful of users.

Aaron is out - Joe is main

 - multipel myaccess fo ridfferent aps??
 - Dhivya - said might do it as seprate apps
 - Ashleigh happy to  do the best
   - easy enough for end users to understand.
 - What do users need to understand?
  - ahslieh to create kb article . .
   - 1 - look for apptio suite of tools (may search for rargetprocess/cloudability . . )
     - joe: for mike: what to name the role names?
     - navigating: apptio first . .cloudablity in role name isr equired.
  - all apptio, so app is aptio: rolenames: be specific about which role gives what access in what app.

Mike & Ashleigh - working together on MyAccess.
 - 1 driver, 1 myaccess app - 'IDtoapptioFrontdoor'
 - phase 2 - 1 driver,  . . app #? . .later

 - taget parocess: would have to look at the edir attr, and only process tp roles.

October - future second river for taget

Ashleigh, reshare . .
 - need to clearly delinate target process roles in swaApptilroles, so second driver can identify them . .

 - when adding target process roles, need to send them later.

 - can include tp roles now . .


want to move to these now
Main: d675e95f-b4af-56b8-6ea6-e9ed5041eab3
POV:  0c5845ea-43ff-5481-1fce-71f58ba2ff4d
Cloudability: 5b1b8db8-86aa-4eb5-a817-65d5cc00fa82

* everyone to get target process user . .

Can role owners make requests on non requestable roles?
   - mike talking about how to make the proper list of roles appear for the end user.
   - key: AShleigh doesn't even want people requesting admin roles . .
   - don't know if it'll be a set of users, or just role owner . .
   -

Writing roles

PUT EVERYTING IN THIS DOC!





Items missing from the todo list:
 - Ashleigh needs names of people building feed files today: both automatic and manual
 - Ahsleigh wants two separate views to MyAccess: one for all admin roles, one for all roles.



7/9/2025 10:14:50 AM
--==TODO==--
 - Send todo list for Ashleigh to the shared chat.


Ashleigh and team,

We've had a lot of conversations over the last few days, and have had a lot of changes, and things to do. The driver development and MyAccess work is essentially stopped until we can get most of these items completed.

Here are all of the TODO items I captured over the last week or so:

1 - Communicate the UFM/MyAccess file creation/sending requirement to Apptio team leaders.
   - The end goal: need to be able to programmatically collect all role definition data, and current user -> role assignment data, and return it in two reports for MyAccess.

2 - Confirm developer Apptio Team can generate the role definition and user to role mapping files.
   - Ashleigh mentioned Paul and Mike as two possible developer names; though I don't have more context on this.

3 - Give Joe.Gividen access to Apptio's GUI, and Targetprocess's API when approriate.
   - Joe will be working on the driver while I'm gone.

4 - Get access to an IBM/Apptio developer; we have various questions:
  The questions are as follows:
   - Can we store eid somewhere that both the Frontdoor and Targetprocess API's? Maybe - consider ‘email for [x123456@wnco.com](mailto:x123456@wnco.com)’ for the eid? Why does this create a duplicate account in Target Process, etc?
     - Note: This the SWA site set up for for email -> eid/xid lookup: https://wpsecadmin01.luv.ad.swacorp.com/IAMToolsLinks/ - this tool acceps the email adress as the 'id': https://wpsecadmin01.luv.ad.swacorp.com/ADUser/
   - Does there exist an authentication method that follows a standard, such as OAUTH2 that we can we use an for Apptio's FrontDoor API? It looks like Target process uses a standard HTTP Basic Authentication, so no issues there.
    - Are we missing some API calls? For example, Is there one to list all roles for all applications in all environments?

5 - We need to ultimately decide how we are exposing Apptio in MyAccess. So far, our plan is this:
   - Split the Apptio product into three apps:
   1 - Target process (in main env). Requires Front door 'Targetprocess User' role, plus (PHASE2) 68 sub roles, using a separate API.
   2 - Cloudability (in cloudability env). Hardcoded single role in MyAccess should set 3 static roles, 100% of the time.
   3 - ApptioOne - May have around 15 default + custom roles

  Next action: Sync up between Apptio team, MyAccess team, and IDM team. Confirm our chosen path is viable, and 'future friendly' to Sailpoint.

6 - Once we have answered #4, we need to clearly define the MyAccess role definition file, and the daily User->Roles file for consumption in MyAccess.
  1 - We'll need both files for every app exposed in MyAccess, for a total of 6 files assuming we split to 3 apps.
  2 - We do not currently have a place to store the eid/xid in a FrontDoor-API accessible way. This is required for direct collection by MyAccess. The Apptio Dev team should have access to AD to map email address to eid/xid.
  3 - We'll likely want to have a 1->1 relationship between selectable role in myaccess, and the resulting roles: exept for Cloudability which is 1->3, or any other situation where we need a single MyAccess role to represent a series of actual roles in Apptio.

7 - Question from Aaron: I need the Apptio team to confirm the following.
  - Due to the nature of assinging roles to environments (HTTP POST vs PUT problem), and also to keep MyAccess to be the authoritative source for roles, we are going to remove all roles in main and Cloudability in some situations, such as on an initial user match.

8 - Finalize Initial Migration
   - It is very normal to need to push all users when adding a new driver, we call this initial migration. We should finalize our plan. When we have a payload, we likely wil be building a tool that will allow us to update all users to have the swaApptioRoles attribute(s) that will match what is already in Apptio; then when we push, we'd reset all of the roles, and end up with making zero changes to the rights there as a result; we should confirm this is the goal and is correct.

9 - LOWER PRIORITY: We need access to the Targetprocess API.
   - Aaron already has rights to Frontdoor, but doesn't have Target Process api access.
   - Joe Gividen needs access to both.



Other todo items:

10 - Sooner than later, when we have all definition, and it is recorded in the driver document, we need official approval/acceptance of the driver design. This API and driver in particular has some unique issues to overcome; so this is doubly important - Once you approve, we should add the date and the fact that you approve/agree to our  'Acceptance' section at the top of the page on https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/629866534/IDtoApptio.



Reference:
 - Another option to get AD information (like email -> eid/xid) is this. When on the VPN, open a PowerShell window, that has the ActiveDirectory plugins, run this command:
  get-aduser -filter {emailaddress -like "john.mapes@wnco.com"} -Server luv.ad.swacorp.com -Properties * | select emailaddress,UserPrincipalName,DistinguishedName

emailaddress        UserPrincipalName
------------        -----------------
John.Mapes@wnco.com John.Mapes@wnco.com








>>>>>>> Stashed changes




7/10/2025 10:19:42 AM


7/8/2025 2:28:02 PM

Joe, here's notes from our call on IDtoApptio driver pass-off work today.

I did not finish cleaning things up. I wanted us to at least have a copy of our chat in an email thread. In the morning I'll finish reviewing our notes and turn it into action items as I mentioned. These are my very rough notes that you saw I took while we spoke; so they're not super obvious yet.



Aaron action items so far:
   - Ashleigh: create an account for Joe Gividen? He's an engineer on my team, and will be taking over my work while I'm out.
   - EOB thursday - check in with Joe. (CSEE-4989 - latest code)
   - Put latest postman project in git, alnong with variable docs.
   DONE - Give Joe clear 'prod' and 'dev' keys.




DETAILS - 'ROUGH NOTES':
 - Apptio: suite of apps
   - has 'enviornments' which is a goofy term for this . ."app space" maybe?


Here's some useful urls, I'll request your user: URLs:

Admin UI
https://frontdoor-ui.apptio.com/home?domain=southwestairlines

Actual Apptio app (suite):
https://frontdoor.apptio.com/home?customer=

Postman: shows how this token is retrieved, and set as a cookie on subsequent calls:
 - apptio-opentoken


Todo items:
   - Use main and pov from a non prod perspective: we need to avoid dev/qa/prod interaction!!
     - may have to scope immediately, only allow certain users etc . .
     - swaApptioRoles - CIS - multivalued string
   - IBM Dev person: still need one; add questions here . .
    Major questions:
     - Can we use eid@wnco.com - can we also get this data in an API & from GUI??
     - need to fully understand how frontdoor & target process on how they relate.
   - Main: confirm all apps here . .
   - Cloudability: only one app?
   - There appears to NOT be a call to list all roles in an enviorment!!!
   - Stop using main: favor pov over main . .
   - What does  "applicationTypes": [] do on the role assignment call?
   - Postman variable discussion:
   - Targetprocess items to learn:
     - Where is the new user e9999999996666@wnco.com in Target process?
   - custom = Ashleigh created, defaultrole - out of the box . .
   - I haven't done any work with sync's or modifies in the driver.
   - Association: email adress . . booo!!
   - What should Aaron complete before I'm out?
   - Add guids to example data in driver doc.
   - Tell Ashleigh: give GUIDs in payload (need to have flexibility to communicate this fornew roles/new envs . .etc . .)
   - three recommended enviornments from App team:
    1. (main)Target process - Requires Front ONE SINGLE ROLE, “Targetprocess User”  - door API + Target Process API: for ONE SINGLE SUB ROLE
    2. (cloudability)Cloudability - hardcoded to have all three roles
    3. (main)ApptioOne - Role count?
   - What exactly do we gain with "enviornments": is each app completely separate from the same instance in another enviornment?
   - How confident are we that Cloudability 1-3 roles is always there?
   - Discussion about Main -> for only prod, pov only for dev:
     - Can we use:
     - Prod -> main & cloudability
     - QA -> pov-qa (new)?
     - DEV -> pov?
   - PDOS: all data not user provisiooing: just need data as referential data . .solves just basic user information . .
     - Baron's concern: WorkdayHCM vs PDOS -
       - PDOS - can support data translations; and data would match up!!
***     - PDOS vs SSO: legal vs preferredname
    - Asleigh - Did 1000 users in frontdoor and 3k users in target process, POV targetprocess: 6k both come from PDOS?   - - we seen non wnco accounts: user names that are just fullname vs wnco.com vs cprime . . ???
   - Whats CPrime?? maybe that's tennant name?
   - major cleanup step would be needed . .



SOAR
   - Has two apps, one is redeem app . . .
   - We did one driver here to get redeem app . .simliar to Apptio.
   - Didn't want a second driver to do redeem app work . .
   - Leaning towards one IDtoApptio driver . .
   - If 3 drivers - probably fit sailpoint models . .
   - Sailpoint . .goofy . .
   - Benefit of 3 drivers:
     - simplify payload . .
     - draw backs:
       - Each driver woul have to be able to create . . or associate existing object . .
       - What exactly do we gain with "enviornments": is each app completely separate from the same instance in another enviornment?
       - Pieces get complicated when we start assinging roles: run into triple attempts of actions from eDirectory.
       - CANNOT have two drivers write to the same enviornment . .
       - All roles are envionrmnet specific . .
       ***- IDtoApptioCloudability could be it's own driver . .but its still a lot of work for not a whole of payoff . .
         - could
       - every driver would have to do frontdoor work the same: either create/match to existing object.
       - 1 to 3 role relationpship for cloudability hardcoded . .
      - then IDtoApptioMain driver . .
         -
       - *** - IDtoApptioTargetProcess driver . .? due to separate API - but don't understand relationship between apptio and Target process . .
         - when requesting targetprocess - have main driver to create the driver
         - goal: setup 'dumb channels': should translate to sailpoint . .
***- Big question: how does Frontdoor and Target process users interact? Provisioning & create?
       - IDtoApptioTargetProcess - how do the frontdoor processing for taget process? Piggyback on one of the other drivers. This driver won't do anything with frontdoor.
         - summary: target process
         - if loose integration between frontdoor and targetprocess . .
*** - Target process: probably could be dealt with in MyAccess API for role collection . .
   - scenario: Could wrap up full "Business Analyst role A" -> points to set of roles across all apps!
   - swaApptioRoles: BUSINESS_ANALYST_ROLE_A
   - Could then hardcode assignments to role in A . .
   - Also 'Business Marketing role A' - could then include these sets of roles . .would just be an additive set of roles between the set . .
   - 1 -> Many static relationship on really well defined roles.
   - problem: actual role definitions would be inside of idm . .
   - if they can't define these roles; then we can't do this. .
   -


7/10/2025 10:19:49 AM
We changed my email to eid@wnco.com . . it created two target process users - 2959 is the original.


User
#2959
Aaron Kynaston
aaron.kynaston@wnco.com

User
#2968
Aaron Kynaston
x266698@wnco.com


7/10/2025 10:20:44 AM


7/8/2025 12:17:14 PM
Road blocks:
 - MyAccess team: approval of 3 separate apps.
 - Meeting:
  ping Baron: next few days: Meet with them and Baron/joe/mike/gokul/Dhviya
  -



Gokul chat:
 -
XXXX,,ApptioOneRole1 Human Friendly Name,main|||ApptioOneRole1|||,Referral Program Team Member,,,,,ES Operations,
XXXX,,Targetprocess - Business User,main|||Targetprocess User(Business User)|||,Referral Program Team Member,,,,,ES Operations,
XXXX,,CustomRole1,main||||||CustomRole1,Referral Program Team Member,,,,,ES Operations,
XXXX,,Cloudability Human Friendly,Cloudability|||Cloudability User:::CloudabilityPlanningRestrictedUser:::Self- Service Reporting User|||,Referral Program Team Member,,,,,ES Operations,


swaApptioRoles
main|||ApptioOneRole1|||
main|||Targetprocess User(Business User)|||
main||||||CustomRole1

 - We Don't have the targetProcess API user  . .
** - only login is unique . .!!email is not unique!! . .
** - PUT's can be used all the time!

If you use a PUT the first time for a user/enviornment
  {
    "error": "EnvironmentUser with Environment [0c5845ea-43ff-5481-1fce-71f58ba2ff4d] not found, see PII for details",
    "translationKey": "FD_ENVIRONMENT_USER_NOT_FOUND_PII_ERROR",
    "substitutions": [
        "0c5845ea-43ff-5481-1fce-71f58ba2ff4d"
    ]
}

 - discussion on matching:
   - any time we get a match:
   1 - post to update frontdoor user
   2 - delete cloudability environment
   3 - delete main envrionment.
   4 - loop through swaApptioRoles and set roles for each enviornment.

Discussion on three myAccess apps:

(main)Target process - Requires Front ONE SINGLE ROLE, “Targetprocess User”  - door API + Target Process API: for ONE SINGLE SUB ROLE
(cloudability)Cloudability - hardcoded to have all three roles
(main)ApptioOne - Role count?
 - not exposing POV through MyAccess
 -


Assumed payload:

main|||ApptioOneRole1|||
main|||Targetprocess User(Business User)|||
main||||||CustomRole1


DELETE on main: d675e95f-b4af-56b8-6ea6-e9ed5041eab3,
THEN POST on main: POST (brand new roles) - to https://frontdoor.apptio.com/api/environmentuser
{
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "user": "e999999999444@wnco.com",
    "defaultRoles": [
        {
            "name": "ApptioOneRole1",
            "applicationTypes": []
        },
        {
            "name": "Targetprocess User",
            "applicationTypes": []
        },
        {
            "name": "CustomRole1",
            "applicationTypes": []
        }
    ]
}

OR

1 POST, 2 puts - but this is silly . .

POST:
{
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "user": "e999999999444@wnco.com",
    "defaultRoles": [
        {
            "name": "ApptioOneRole1",
            "applicationTypes": []
        }
    ]
}


Put 1
{
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "user": "e999999999444@wnco.com",
    "defaultRoles": [
        {
            "name": "ApptioOneRole1",
            "applicationTypes": []
        },
        {
            "name": "Targetprocess User",
            "applicationTypes": []
        },
    ]
}

Put 2
{
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "user": "e999999999444@wnco.com",
    "defaultRoles": [
        {
            "name": "ApptioOneRole1",
            "applicationTypes": []
        },
        {
            "name": "Targetprocess User",
            "applicationTypes": []
        },
        {
            "name": "CustomRole1",
            "applicationTypes": []
        }
    ]
}

Email address change: yes

PUT: can't put ID on URL . .

TODO: come back and show example of multiple calls


<driver-operation-data command="add">
</driver-operation-data>
<driver-operation-data>
</driver-operation-data>

Ashleigh:
 - SSO concerns: email & login differ . .concerns
 -


















Added corrected columns to the role and user to role mapping file.


XXXX,,ApptioOneRole1 Human Friendly Name,main|||ApptioOneRole1|||,Referral Program Team Member,,,,,ES Operations,
XXXX,,Targetprocess - Business User,main|||Target process(Business User)|||,Referral Program Team Member,,,,,ES Operations,
XXXX,,CustomRole1,main||||||CustomRole1,Referral Program Team Member,,,,,ES Operations,
XXXX,,Cloudability Human Friendly,main|||Cloudability User:::CloudabilityPlanningRestrictedUser:::Self- Service Reporting User|||,Referral Program Team Member,,,,,ES Operations,


7/10/2025 11:37:52 AM
Massive notes Aaron and Ashleigh put together eob yesterday:

2025-07-09 Summary notes from IDtoApptio MyAccess + Driver Design conversation


Aaron Kynaston (Contractor)
​
Ashleigh Wansbrough;​
Cristino Santiago (Contractor);​
Dhivya Balasubramanian;​
Joe Gividen;​
Julie Rios;​+2 others
​
​
​
Angie Johnson (Contractor);​
Yvonne Umeh​
Team,

Today we had some very useful calls and made quite a few decisions. Below, we've identified open questions, and then listed the key points that we covered.  We covered a HUGE amount of data here; please add to this thread as needed.


Key questions that we have identified are as follows:
 - We need to know if it is possible to administer not just the world accessible roles, but also the admin roles by the appropriate people. Mike's version: "Can role owners make requests on non-requestable roles?"
   - NEXT ACTIONS: Mike to answer Ashleigh, then they'll work together to review.
   
 - Ashleigh to confirm if email can be eid/xid@wnco.com in Frontdoor/Targetprocess to avoid name change and conversion issue.
   - NEXT ACTIONS: Ashleigh to see if this is an option, then will report to the team.

 - Can the TargetProcess API clear the integration flag.
   - NEXT ACTIONS: Ashleigh is confident it can be; but Aaron & Ashleigh need to test.

 - Exposing a high number of rules in MyAccess under 1 app:
   - We have a lot of roles to expose in MyAccess:
     - Question: is this unwieldy/confusing for the end user?
     - NEXT ACTIONS: Maybe Mike can confirm?
     
   - Use app name dash role name for the end user: "ApptioOne - Budget Process Owner"
     - Question: How does Ashleigh delineate between Frontdoor and TargetProcess? Answer so far: Every role that starts with 'TargetProcess' will be for that driver.
     - NEXT ACTIONS: Ashleigh to confirm - We believe the 'Answer so far' mentioned above should work for this.
 
 - When a role is removed from Frontdoor, or a sub role from TargetProcess, is there anything lost more than just the role assignment? Answer so far: no. This won't be a problem, though we need to test this.
   - NEXT ACTIONS: Aaron and Ashleigh to run a test to confirm API removal doesn't remove unexpected data.


Key points:
 - We don't have a non-prod environment for cloudability (though we can mimic this with fake roles).
 - We confirmed we can't go live with any portion until UFM components are included to expose the roles and enable the collection that are going live. The Apptio team is responsible for this.
 - We ultimately decided to expose 1 MyAccess apps, and 1 driver for phase 1, and second driver for TargetProcess.
   - PHASE 1: FrontDoor Main (for Cloudability and ApptioOne, provision only for "Targetprocess User" role)
     - TBD on date for UAT
     - Goal: August 25 for production.
   - PHASE 2: TargetProcess (User matching/role only driver) - Focused entirely on TargetProcess API.
     - TBD on date for UAT
     - UAT goal is before October 15th for prod deployment for this component.
   Also note:
     - only the roles included in the Role definition file will be exposed in MyAccess.
     - The role entitlement file will be purely manual as the role definitions should be pretty static.
     - Who and how we are actually building the files is TBD.
   NEXT ACTION: - Ashleigh to work with Mike on end-user interface for MyAccess.
 - We covered Jay Allen and Nishant Seth are contacts for an example of automated MyAccess role generation.
 - UFM is owned by Chandra Billava
 - Roles don't need to include Apptio in the name, but should include the name of app and role (however, see question below)
 - We've decided to provide the GUID instead of an environment short name to enable GUID/env changes as needed
 - SUPER KEY TO THE FILES!! - The "Application Entitlement" field must be identical to the "Application Role" in the user-to-role mapping file.
 - We decided Cloudability is a minor different case: it'll be added to the role file as a single MyAccess requestable role, and result in 3 role assignments in Cloudability.
 - Cloudability will also have one or more administrative roles, ideally, assignable only by the Apptio app team.
 - TargetProcess default sub role (after getting "Targetprocess User" in FrontDoor) is 'Assignee' but may be changed to something like 'default' later. Target Process config will initial setting (note: they'll get this default role upon being brought into the system from PDOS).
 - TargetProcess has a 'Resource ID' field in the GUI which will be used eid/xid - this will also help with TargetProcess driver matching/association.
 - We have multiple Phases to help rollout Apptio (see phases above).
 - PDOS engineers have updated Target Process steps to pull the preferred name instead of the Legal name. This means users like Ashleigh (preferred = Ashleigh, legal = Sybil), allows names to match (name mismatch issues haven't occurred since this fix)
 - We don't need to concern ourselves with the Frontdoor database vs TargetProcess database; this appears to be managed automatically, based on email address.
 - We would like to use 'eid/xid@wnco.com' for all email addresses in Frontdoor and TargetProcess Databases. This will help avoid conversion/name change issues, yet still allow email sending due to the aliases.
 - This eid/xid email also gives us a place to store the eid/xid! This doesn't help MyAccess as it would have to parse off @wnco.com . .but is still useful as a reference.
 - For a user to use TargetProcess, they do need the FrontDoor "TargetProcess user" role.
 - FrontDoor driver, and TargetProcess drivers will need to work together to fully provision a TargetProcess account.
 - The Targetprocess User Frontdoor role, only gives application access - unchecking the 'integration' flag to false allows the target process role to grant permissions.
 - For all MyAccess exposed apps, they'll appear in the Apptio App section, but must have:
 - The fact that PDOS is used to bring the data into TargetProcess, means the TargetProcess driver can assume the user will exist 100% of the time in TargetProcess.
 - TargetProcess API may be good enough to do MyAccess Collection process.
 - We confirmed we are putting all actual data in the MyAcces files, so there is minimal driver rework (e.g., including the guids in the file).
 - TargetProcess Non prod environments will need some manually created users by Ashleigh as needed - to emulate PDOS data in non prod (possibly sandbox - POV already has PDOS source) . .
 - Non prod versions of both drivers from both phases need to be severely restricted to users who can modify: Goal: avoid goofy up FrontDoor/main data changes (The Batman problem).
 - We can not automatically close MyAccess role requests.
 - We believe MyAccess won't be deprecated until end of 2026, and the role def + role, and the user to role mapping files should be SailPoint-friendly.
 - Initial migration: We have an initial migration planned to build: The goal of this is to make the system behave as if all existing data went through our process in the first place. Before and after initial migration, there should be minimal (aka 0) changes in roles, assuming we won't be changing roles during the migration.
 - Who and how we are building the files is TBD.

--Aaron

7/29/2025 4:12:50 PM


[edir@w11dcledirdi013 IDtoApptioFrontDoor]$ rdxmlmanage listinfo IDtoApptioFrontDoor

/opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/IDtoApptioFrontDoor
total 988K
-rw-rw-r-- 1 edir edir  361 Jun 11 13:13 IDtoApptio.cfg
-rw------- 1 edir edir   20 Jun 11 13:15 lpwd8006
-rw------- 1 edir edir  293 Jun 11 13:15 dpwd8006
-rw------- 1 edir edir 973K Jul 29 14:20 rdxml.bin8006.log

/opt/idmlogs/IDtoApptioFrontDoor
total 352K
drwxrwxr-x 3 edir edir 4.0K Jul 29 14:12 old
-rw------- 1 edir edir  26K Jul 29 14:23


IDtoApptioFrontDoorrl.log
-rw-r----- 1 edir edir 318K Jul 29 14:23 IDtoApptioFrontDoor.log

/opt/netiq/rdxmlrl/var/opt/novell/dirxml/rdxml
total 4.0K
-rw------- 1 edir edir 31 Jul 29 14:22 rdxml.bin.pid
[edir@w11dcledirdi013 IDtoApptioFrontDoor]$


7/29/2025 4:13:00 PM
MAIN TAKEAWAYS FROM TODAY:

1 - We'd have to avoid depending on SSO for authentication . .I am going to try and setup a normal TargetProcess authentication that sets a token (your POV_API variable Ashleigh), then see if that allows the GET on the Role file dump.

2 - To enable collection this way, the resulting file needs to be in JSON format, not CSV/TSV that it is now. Is it possible to produce a JSON response instead of a table? If not, then we'd need to leave the data in a table as you have it for UFM . . .






Ashleigh, Micahel,

API collection based approach #2 results:

Items learned when trying to pull TPM Studio table data into MyAccess, we have two relatively large roadblocks to overcome:

1 - We'd have to avoid depending on SSO for authentication . .I am going to try and setup a normal TargetProcess authentication that sets a token (your POV_API variable Ashleigh), then see if that allows the GET on the Role file dump.

2 - To enable collection this way, the resulting file needs to be in JSON format, not CSV/TSV that it is now. Is it possible to produce a JSON response instead of a table? If not, then we'd need to leave the data in a table as you have it for UFM . . .




Joe, Just so you are kept in the loop and per our design, I am going to go build these drivers:
  Phase 1: Build IDtoApptioFrontDoor only driver - use the existing swaApptioRoles for this.
  Phase 2: Build IDtoApptiTargetprocess driver - and use a new attribute, swaApptioRolesTargetProcess

swaApptioRoles format:
  Env guild|||Frontdoor role

  e.g.:
  d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole1


swaApptioRolesTargetProcess format:
  Env guild|||Frontdoor role|||TargetProcess role


  e.g.:
  d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process|||Business User




Dhivya,  Yes - the main focus now is the app team is working on building the Role definition and user to role mapping files for MyAccess.

   Status on IDM: At the moment, I heard the ||| vs having multiple eDirectory attriutes is up for consideration. Baron & team, do we have a preferred route for now? I am going to continue with the current ||| design until I hear differently from you: I have a day or two of activites before it becomes a problem.



Baron, Right now the payload design is as follows (for both the MyAccess entitlement, and the swaApptioRoles attribute:
  Front door env GUID|||FrontDoorRole:TargetProcess role (if any)

  Example non target process role (aka phase 1)
  d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole1

  Example target process role (aka phase 2)

  d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process:::Business User


   Status on File creation: The app team appears to be maybe 80% complete with the role file, and are just starting the user file.  We also found that the TBM Studio where they are creating the file provides a URL for data access! This may mean that MyAccess can do API based collection, since it's all based on the TargetProcess API! Will test with Mike asap.






 - Update IDtoApptio postman project; integrated targetprocess project


7/28/2025 1:46:05 PM
Asleigh - meeting to sync up with engineering folks - had a aplan, but then had to pivot . .
Nathan Drenhofer - aws engineer - cloud stuff . .
Michael Darragh - dev to help build fil emaybe? apptio admin

Nathan worked with first week:
   - AWS Lambda function: to create the files,
     - Found issue: get files to myaccess, server based option . .
     - Ahsleigh - continued up to last Friday; spoke with Mike Labit
       - may be able to do an SFTP option.
     - Also met with
       - Bob Moheler - ?
       - David Smith - entp aritcet doesn't want aws overhead. move to tbm studio . .
        - then use data link; (Michael D should be able to help
   - Nathan - lambda - can sftp to UFM
   Asliehg doesn't have a server, so has worked on these optoins:

Summary from our chat today:
   - plan A: tbm studio & MyAccess Pulls!!!
   - plan B: tbm studio & datalink
   - plan C: Nathan's awws & lambda function.
   - plan D: use idm server as our temporary UFM jumping off place.




 - Bypass ufm stuff? - Asleigh spoke with Mike L.
   - SFTP - originally design for external partners . .
 - they're ok building the file . .
 - Ashlieh - tlkin aout cleaning up cloudability roles to have just the 3 main . .
 - file internal
   -https://southwest.atlassian.net/wiki/spaces/APIGW/pages/101253744/Internal+File+Transfer+On-boarding+Guide
 - seeing myaccess roles  - apptio myaccess roles excel spreadsheet

 - *** Learned that TBM studio may be able to provide a url to a link to the file data!!

 - TargetProcess API - Better API . . can get user and role data in a simple format . .




8/4/2025 3:22:43 PM
Just updated story: https://southwest.atlassian.net/browse/CSEE-5075 with this data . . I'm only supporting simple role parsing for now; but I think we'll need to expand it 

So far, I’m going with a super simple ‘swaApptioRoles’ CIS multi-valued attribute that just holds the strings of the roles, and only supporting main, and defaultRoles (not customRoles). We likely will need to expand this design; but I can’t nail it down until the MyAccess API collection work is nearly complete.

I’m GUESSING - We may need to move to something like this:

Instead of just ‘swaApptioRoles’ . we may need to do this:

**4 new CIS multi-valued attributes that just contain the strings of these environments:**

swaApptioMainDefaultRoles

swaApptioMainCustomRoles

swaApptioCloudDefaultRoles

swaApptioCloudCustomRoles

Then the swaApptioFrontDoor driver will support these 4 attrs changing, and build the payload accordingly.

For Phase 2, we’ll likely need to add another, which will be another CIS, with just targetProcess Strings, and will only be honored if swaApptioMainDefaultRoles contains a ‘Targetprocess User’ role:

swaApptioTargetProcessRoles

8/4/2025 5:03:47 PM

{
    "customerName": "southwestairlines.com",
    "id": "c14a8d58-528c-4e20-9504-51100618eebd",
    "userId": "f6db9a5f-feb0-48f0-9a94-bb714e1cc4ad",
    "defaultRoles": [
        {
            "id": "d6ee3579-5b82-11f0-b998-06726f6550e7",
            "name": "TargetProcess User",
            "applicationTypes": []
        }
    ],
    "customRoles": [],
    "apiKeyRoles": [],
    "user": "e999999999@wnco.com",
    "fullname": "First Last - e999999999",
    "email": "e999999999@wnco.com",
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "environmentName": "main",
    "customer": "southwestairlines.com",
    "sso_granted_roles": false
},

{
    "id": "040178c5-6b4d-4a61-a1e6-ec20d63a0f95",
    "login": "e9897126828@wnco.com",
    "active": true,
    "full": "Phineas Flynn - e9897126828",
    "email": "e9897126828@wnco.com",
    "persona": "NONE",
    "forcePwdChange": false,
    "domain": "southwestairlines",
    "failedLoginCount": 0,
    "createdBy": "frontdoor-myaccess-integration@wnco.com",
    "createdOn": 1754344259961,
    "updatedBy": "frontdoor-myaccess-integration@wnco.com",
    "accountType": "STANDARD",
    "external": true,
    "accountStatus": "ACTIVE"
}

{
    "environment": "d675e95f-b4af-56b8-6ea6-e9ed5041eab3",
    "user": "e9897126828@wnco.com",
    "login": "e9897126828@wnco.com",
    "defaultRoles": [
        {
            "name": "Targetprocess User"
        },
        {
            "name": "Power User"
        }
    ],
    "customRoles": []
}



<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.10.0.0200">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <add cached-time="20250804195311.187Z" class-name="User" event-id="w11dcledirdi013#20250804195311#2#1:a2d7cd50-6eef-444d-98e1-50cdd7a2ef6e" qualified-src-dn="O=swaiddev\OU=Users\CN=e9897119768" src-dn="\DEV_SWACO_ID\swaiddev\Users\e9897119768" src-entry-id="1288745" timestamp="1754337187#12">
      <add-attr attr-name="Internet EMail Address">
        <value timestamp="1754337184#9" type="string">e9897119768@wnco.com</value>
      </add-attr>
      <add-attr attr-name="swaApptioRoles">
        <value timestamp="1754337184#7" type="string">Power User</value>
        <value timestamp="1754337184#8" type="string">Targetprocess User</value>
      </add-attr>
      <add-attr attr-name="swaPreferredFullName">
        <value timestamp="1754337187#12" type="string">Phineas Flynn</value>
      </add-attr>
      <add-attr attr-name="swaStatus">
        <value timestamp="1754337184#6" type="string">A</value>
      </add-attr>
      <operation-data DRIVER_REVISION="1.0.0-CSEE-4986-x266698" objectType="employee"/>
    </add>
  </input>
</nds>



Team,

I need some input.

We have a swaApptioRoles attribute created right now. To make MyAccess more forward compatible with Sailpoint, I've been asked to keep my attributes syntax more simple. This means I should probably make a

swaApptioRolesMain
swaApptioRolesCloudability
swaApptioRolesTargetProcess




https://trivir.udemy.com/course/git-complete/learn/lecture/1438990



BEFORE STARTING: REMOVE  THIS FROM AL LHISTORY:

String body = "{ \"keyAccess\": \"830aa07b-a859-4f8d-afb3-3a3f00e711ae\", \"keySecret\": \"dlqucIvhGCWwW4W9hq8SCf2xA1OE0R7yfN2yhjtJGPtgFZXzoDfHfDJAeHJ9\"   }";




{ "apptio-opentoken": "12341234" }



/SWA/home/oracle/wildfly-24.0.1.Final/domain/servers/img-server1/log




w11qclcmyarh004 - run test:

SHTTPCert test: version: 1.0
Starting HTTPCert test, against: [https://frontdoor.apptio.com/service/apikeylogin]
###################################################################
First attempt, is allowing SSL to occur normally:
Done reading the response while SSL is left intact,
Response code was: [200]
response buffer was: [{"result":"login successful"}]
Apptio token if available:
{ "apptio-opentoken": "391c2eb59b5f5134cce3e4fc220420e6dd0b23b9960a790dd4e9a1e5289db79a42d5e222b2aa8e829bb548a38c909b676801b71fbc67f6a84436191c11bb5d82" }
Just disconnected, now ignoring SSL, and running again:
###################################################################
Second attempt, is ignoring SSL certs:
Done reading the response while SSL was IGNORED,
Response code was: [200]
response buffer was: [{"result":"login successful"}]
Apptio token if available:
{ "apptio-opentoken": "da66bc61cf36ababfe409fbf68aeb892c1568fdeb9309c59bb0c1238b1548ffcab05531eb845f8e180d66cf37c233f71bd1f83e8f5dee39bea7d32e91fdeb4b9" }
[root@w11qclcmyarh004 labit]# java -version
openjdk version "1.8.0_432"
OpenJDK Runtime Environment (Temurin)(build 1.8.0_432-b06)
OpenJDK 64-Bit Server VM (Temurin)(build 25.432-b06, mixed mode)
[root@w11qclcmyarh004 labit]# which java
/usr/lib/jvm/jdk8u432-b06/bin/java




C:\z>git config --list | grep fff
alias.fff=!git fetch --depth=1 && git hardclean

C:\z>git config --list | grep hardclean
alias.hardclean=!git reflog expire --expire=now --expire-unreachable=now --all && git gc --prune=now --aggressive
alias.fff=!git fetch --depth=1 && git hardclean



8/1/2025 12:19:50 PM



Bottom line recap from Dhivya, on 8/1/2025 2:11:36 PM
Quick recap:::

1 - Assuming by EOD Monday we get the cert error resolved, we spend Tues/Wed trying out the API route with hardcoded tokens. Lets regroup Thurs to get a feel of where we are.
2 - On Thurs, If things aren't looking good at all, we can sync with Baron to take the file based approach and we can revisit during SP migration
3 - But if it is promising, we can make a call on what needs to get done in IDM and start making progress in IDM as well.

Also, worst case, if we cannot meet the Aug 25 date, they will manually load the users. SO, there is no risk to go live of the App, just a risk to how users are managed!





MAJOR ISSUE:
Starting point for Dhivya - before we start: : I thought Michael Darragh was giving us real data, but it turns out he's only feeding us a static table that Ashely built for him!!!
   - IN short: he was giving us a POC table, where I thought he was already pulling real data.
   - He began asking me how to use his datalynk software . . I spent 5 mins talking through the API to avoid being rude . . then let him know he'll need to get an API key from AShly probably . .


























Two possible routes:

Direct: (API collection only)
1 - Authenticate: https://frontdoor.apptio.com/service/apikeylogin
2 - Get the data: https://frontdoor.apptio.com/api/v2/environmentusers/environment/5b1b8db8-86aa-4eb5-a817-65d5cc00fa82?pageSize=10&roles=Cloudability User

Why we threw this option away?
Aaron (but Mike L mentiones these are ok)
   - 1 - JSP requirement for auth
   - 2 - Need to pull Main & cloudability as two endpoints



TBM:(API collection AND UFM . .)
1 - Authenticate: https://frontdoor.apptio.com/service/apikeylogin
2 - Get the data: https://southwestairlines.apptio.com/biit/api/v2/report.json?reportPath=-@Csouthwestairlines.com%3ACost+Transparency/Reports/.DateGoesHere/CostModels/Default/.View%3ARole+List&date=Jul:FY2025&componentId=1&environment=stg&userLanguage=en-US


WITH THAT SAID: Here's the note to POE (if we can get past cert issues . .could theoretically use this option.)

(concern: Steve not available until July 13 . .)

*** - Update Michael D - not using TBM studio data . .


Dhivya:

Obstacles:

1 - Authentication Token is sent in response header instead of response body - requiring us to have a JSP.
2 - TBM option: The JSON response back is in an array, instead of key/value pairs, making the collectors be reliant on the array format
3 (should be 1) - We have a cert error for connecting to front door (a 1 time issue) which is yet to be resolved.

 LOTS of obstacles
 - Cert error - may ahve more than one: to auth url, and then TBM url
 - Get the authetnciation token (JSP required)
 - Then we need to actually make the call to get the Role and user data.
 - Then we need to parse the goofy JSON format.
 - What other obstacles are there at this point? We just don't know.


COE Chat group: message:

Agreed . .The cert error we are seeing (see attachment for details) - of: javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target, is typically would be resolved by placing the right cert into the correct cacerts in use by the correct JVM.

This case is confusing: If this is an HTTPS error, all of the certs involved should already be trusted by default CA certs in cacerts in the MyAccess JVM right? I can't think of a reason why there'd be any other SSL errors, since this is the only SSL we're doing.

WE have the following two urls that we've tried to connect to with MyAccess:

1 - https://frontdoor.apptio.com/service/apikeylogin
2 - https://southwestairlines.apptio.com/biit/api/v2/report.json?reportPath=-@Csouthwestairlines.com%3ACost+Transparency/Reports/.DateGoesHere/CostModels/Default/.View%3ARole+List&date=Jul:FY2025&componentId=1&environment=stg&userLanguage=en-US


1 - The first server, frontdoor.apptio.com uses a cert trusted by "DigiCert SHA2 Extended Validation Server CA" . .which is a standard cert I think.
2 - The second server, southwestAriliens.apptio.com uses a cert trusted by, "DigiCert Global G2 TLS RSA SHA256 2020 CA1" which I think is also an industry standard cert.






I'd like to post this to the COE group; I've requested access; but am not in yet.  For now, here's the bottom line:

We are experiencing a cert issue (see attachment)


Mike and I have been trying an option to have MyAccess do API based collection for Apptio. We need some assistance in finding a solution. We have a number of rather difficult obstacles, and suspect that what we are trying to do, is difficult at best and time consuming to get right.

We need assistance with resolving a cert error.

(with attachment)




Dhivya:
 - workaround: manually send us a file regularly?? while building the automated file . .
 - Dhivya:
   - Ashleigh: Maybe pause TBM STudio/Datalink work for a week (Mike D)
   - Steve is out . . Taylor maybe . doesn't know . .
   - Sean/harsh/baron - keep bugging . .
 - For Aaron and Mike L: Get past cert issue for authentication in Apptio. See if either direct or TBM will work.

Unknowns:
   - Auth issue: need JSP and cert error.
   - Second entitlement collection (one for main one for cloudability)
   - pages & pagnation
   - TBM route? Not sure if the format of the table would work.
   - IDM:
     - Need to know format of payload
     - Need to know where payload is being written.
     - Phase  2!! IDtoApptioTargetProcess driver.

























8/1/2025 11:46:12 AM
Meeting MIchael Darragh
 - Datalynk . .
 - apptio hosted tool . .
 - SFTP egress connection - requires setup of cloud type agent - only username and pass
 -


Authentication Token is sent in response header instead of response body - requiring us to have a JSP to parse the response
The JSON response back is in an array, instead of key/value pairs, making the collectors be reliant on the array format
We have a cert error for connecting to front door (a 1 time issue) which is yet to be resolved


8/1/2025 11:26:55 AM
Works!
curl 'https://southwestairlines.apptio.com/biit/api/v2/report.json?reportPath=-%40Csouthwestairlines.com%3ACost+Transparency%2FReports%2F.DateGoesHere%2FCostModels%2FDefault%2F.View%3ARole+List&date=Jul%3AFY2025&componentId=1&environment=stg&userLanguage=en-US' \
--header 'apptio-opentoken: 3d9a661a6fcf24d060c40a36b3c6cdb24b96fbf5338aee70c712dee13ce543a4a159d730837a691d89e20df03705cb39f23f9bf34e105e596ac28a1f0aded681' \
--header 'apptio-current-environment: d675e95f-b4af-56b8-6ea6-e9ed5041eab3' \
--header 'Cookie: _bff_csrf=485fded0-8e8b-45ba-8d7c-0567d5aac596; BIGip=9735392b0940cb27; _csrf=485fded0-8e8b-45ba-8d7c-0567d5aac596; _van_c=eyJzX2V4cCI6MTc1NDEyNjMyNDU5NX0=; _van_s=PgZANaurr4M93yxwvcxtyTvCmG29LZCBsN8rvNaAzsOvTC2OD8RYu8TSLVgAhgoIFtvXKNevOESMwsX9NPMi52flgDuETHcABUoLOtKZUbv9S0Df0IvajEPzAX59iT5HwVNA84ck9xf5ONWOVNMce7bmZlZogbenzqttLB4tNTTryCfwzwZsY7GTqfpzKGcCaiuBJJbGfFyPRzzhsm0q8JIK709VEpUQg2Zj_kPRALHa2-iP8PKDbz9nl6DF8WA3Y9X5kGRktqWvbfeTGFZC0iLjJz_zQfQIjgRDA5GNgxbEVSPAYSwjxiIZPDGlZN-ENKbKXCKzQViyGjI3vya5lMUAsUOM7mcRfZR6kH7sPG-fTXu86LS-e-l4-NJKXlUVKHFUsdehWm-Q0EKjPnNtwG6lIjbJ2U_p-yvOxcyGT7R1ZhIBRL8VNj0WsGGyACGkeDQDxqxm9IwQD-B5zlQf2TJuPze9KAZN8toGbUGnRvtH8TLI-gFKLIjipMUDfY_hWBiiV5UM4a5yfjDUxBjYUVCLeebTvf6TvXaauqYcvwuzXH1ntN1SZx4bTqxMPz7yjkYdpfcPT58oy8hWmm1b2aE6FHPK6tOHpZFeVQN-gCXMnfZa953nL_n83dUCZ2TraI2OzVhATEf_mHNpp6YocBzoW5VP972aBFIFVJkqf1jUT53jQJ90tvvlrU1s_Q0cUPAjHrzHzsYyFV9oZQLYsjp844MKtLwASCLTvDnOvlqDgFMVBRD_742zR0lZpMvtmZP2OkNYcD_HkPJSGJ8nU8XiIFV-8txu3FK34Up_pwNUkFMTFWintEfa9e90hxTSpDEdnPGl6CwLKIDxy49XyCk2KF9-0re4fYrWmi0EPseqt37QdWqOi7Bi_p9117YyUWtL7NcFJgM4ICuJ2FVAlwTWQzfyJDVAnaHm-jeBGy7wcrNYK9IxDds0ENHFr9bU7lPJKbVkJiT8GP0Mwbyt9D3PXVjIBRvhHwP9yDtCdS0XDyIG11187f6ORSfDnaX4q0gw0_F7PXdwbWe07VMVwA37LLfZuuxveqvHSxHWo7EAtza1fOxb0f943zHnPlR809JxPcY4PaN-ZnkMtjAEOVREvY_ljGgh2sU6x7KFgmtvCn4jTa0lYItowgg7N1o2FljdkTVdeHGRwU4q_mz2zca6diqP6upVWuGOD3tEEuUJtrxLbM4_UYGqs7EhU9rpeMh1LFIuCSRRdJ0MACUCBNfvB49hecSHbkNZoA8BxHODhcZqLx6FeDQnlw9TEXKrfq8GU42e5mhU7DSTnpl-26KperOi0lM3Nflk0NyriB6D1Oo20SojqUFX_v1q2NJoeQEOBwmZLIFH5d_OTRcDdSKntNCis0vNuyg9xZf7M1T6otS3FSA5Ga66iLmHeonAI_r1vgv60GGTVXIfcDnr_Pok5StHWOeEU7C8ZaFE3Vmr-b_AvoweMkaM530GxFitUTUZEGogNRyI82bBxxg1Kfo39WPIRkMrzoT33RtS7RO2Fau0_PYrYcbeC-zlNhczlvj9ZU1Hjjt5m-Zh0Ik2uNObuRI1t6iXTTW_-mIsWH36WOqYJCjEOXubQadcsHSc507803Cboc3iHhlzM7_7jC0zeuXK2-qTG0xh0HRFmZ1epyr1hLVRJxs96ff-oiGGr9FiE_aU6p-FDjRb-b5bKuKS7M30N3yAfELqvrRvFQNVhyBn6mImIKFz2s1NJItI9Liz1DXfSG8KpsDMHjucEmkp0ir1ivxs8uvmeP8FYeUgFM39; envid=d675e95f-b4af-56b8-6ea6-e9ed5041eab3'





google:
HttpsURLConnection and ignoring all ssl
ai:

    import javax.net.ssl.X509TrustManager,java.security.cert.X509Certificate

    public class TrustAllCertificates implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Do nothing - trust all client certificates
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Do nothing - trust all server certificates
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0]; // No accepted issuers
        }
    }

    import javax.net.ssl.HostnameVerifier;
    import javax.net.ssl.SSLSession;

    public class TrustAllHostnames implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true; // Trust all hostnames
        }
    }

        import javax.net.ssl.HttpsURLConnection;
    import javax.net.ssl.SSLContext;
    import javax.net.ssl.TrustManager;
    import java.net.URL;

    public class HttpsConnectionExample {
        public static void main(String[] args) throws Exception {
            // Create an SSLContext that uses our custom TrustManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new TrustAllCertificates()}, new java.security.SecureRandom());

            // Set the default SSLSocketFactory and HostnameVerifier
            // WARNING: This affects ALL HttpsURLConnection instances in the JVM
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new TrustAllHostnames());

            // Now, HttpsURLConnection will ignore all SSL certificate and hostname validation
            URL url = new URL("https://example.com"); // Replace with your target URL
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            // Perform your operations with the connection
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // ... further operations
            connection.disconnect();
        }
    }




7/31/2025 4:18:10 PM
TrustManager work - idmunit example:
 - site that shows this too, plus the set only on my connection setting:
  https://stackoverflow.com/questions/33084855/way-to-ignore-ssl-certificate-using-httpsurlconnection



set JAVA_HOME=C:\Users\x266698\.jdks\disabled-azul-1.8.0_382.intellij

Due to the chat with dhivya, doing trust manager work above . .



 - We determined, that even with small custom JSP, we were not able to get access to token as the frontdoor API url due to the following issues:
   - 1 have to use a JSP.
   - 2 The format of the provided JSON is too generic (it uses raw arrays instead of the standard key/value pairs), while it is possible to represent the data we want to get, this would require additional testing, and we've run out of time at this point.
   - 3 The certificate required by the API was replaced June 5, and does not yet exist in the JVM MyAccess uses . . .







Issued On	Thursday, June 5, 2025 at 6:00:00 PM
Expires On	Tuesday, April 14, 2026 at 5:59:59 PM



{
    "keyAccess": "{{apptioProdAccess}}",
    "keySecret": "{{apptioProdSecret}}"
}





    <script>authenticateToApptio();</script>

     var body = '{
            \"keyAccess\": \"{{apptioProdAccess}}\",
            \"keySecret\": \"{{apptioProdSecret}}\"
        }'


Step 1:
POST: https://frontdoor.apptio.com/service/apikeylogin
{
    "keyAccess": "{{apptioProdAccess}}",
    "keySecret": "{{apptioProdSecret}}"
}

Retrieve the apptio-opentoken from the *response header* (this is why we need to be in a JSP.



Step 2: GET on https://southwestairlines.apptio.com/biit/api/v2/report.json?reportPath=-@Csouthwestairlines.com%3ACost+Transparency/Reports/.DateGoesHere/CostModels/Default/.View%3ARole+List&date=Jul:FY2025&componentId=1&environment=stg&userLanguage=en-US

Headers:
apptio-opentoken - (authentication results)
apptio-current-environment - d675e95f-b4af-56b8-6ea6-e9ed5041eab3












7/31/2025 9:47:45 AM
apptio-current-environment - d675e95f-b4af-56b8-6ea6-e9ed5041eab3


Next actions:
   -
x - plan A - TBM Studio: MyAccess retreives it by itself (CAN'T DO THIS: NO ACCESS TO THE RESPONSE HEADER FOR AUTH!)
   - Alternative - JSP . . ? for auth?
   - Spend one more day . .
 - Plan B: TBM Studio: UFM route . . .
   -


7/31/2025 10:13:08 AM - just sent this email:

Team,

We had a very useful call this morning. Thanks, team! We successfully retrieved the TBM table data through an API call! This means our next step is to make sure that MyAccess can retrieve the authentication token and make the HTTP GET call properly.

Items we learned/confirmed today:
 - The authentication for FrontDoor and the TBM Studio API/URL both seem to accept the 'apptio-opentoken' as a simple header for authentication (a cookie also works, but is not required).
  e.g.: Adding the 'apptio-opentoken' header, along with its value retrieved from a keyAccess/keySecret authentication, works properly!
 - We needed to add a header called 'apptio-current-environment' that must be set to the main environment guild, which is 'd675e95f-b4af-56b8-6ea6-e9ed5041eab3'.

Summary: The 4 plans we are considering are as follows. Our call today was to push more on plan A:

   - plan A: TBM studio & MyAccess pulls the data, aka 'MyAccess API collection method'.
   - plan B: TBM studio & datalink and UFM
   - plan C: Nathan's aws & lambda function to UFM . .
   - plan D: use idm server as our temporary UFM file sending method.

Next actions:
 - We've tentatively planned one more day on Plan A to see if MyAccess can properly retrieve and parse this data. If this does not pan out, we'll go down the list of plans as mentioned above.


--Aaron


FYI: We'll continue to research Plan A. . .but if it doesn't pan out, we likely will need to use Plan B next week



Phase 1 (now): swaApptioRoles attribute, IDtoApptioFrontDoor driver:
eDir attribute: swaApptioRoles:
d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole1|||
d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole2|||
d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole3|||
d675e95f-b4af-56b8-6ea6-e9ed5041eab3||||||ApptioOneCustomRole3


d675e95f-b4af-56b8-6ea6-e9ed5041eab3||||||TargetProcess User

GUID|||Defaultrole|||CustomRole



Phase 2 (before october): swaApptioRolesTargetProcess attribute, IDtoApptioTargetProcess
d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process:::Business User


Concerns:
 - Concern with building up complicated payloads . .
 - Bottom line: keeping conversion to Sailpoint in mind. . .
   - When doing collection: maybe split between collectors:
     - Would a low 'main' collection or 'cloudability' collection. .
 - Translation in & out required . . this is extra work
 - IDM - maybe have multiple attributes . . .
    main default roles - swaApptioMainDefaultRoles
    main custom roles  - swaApptioMainCustomRoles
    cloudoudability default roles - swaApptioCloudDefaultRoles
    cloudability custom roles - swaApptioCloudCustomRoles
 - Each entitlement to be set/collected can have all of it's own metadata
   - This can simplify the payload.







































d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole1|||
d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole2|||
d675e95f-b4af-56b8-6ea6-e9ed5041eab3||||||ApptioOneCustomRole3


5b1b8db8-86aa-4eb5-a817-65d5cc00fa82


d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process:::Business User




8/22/2025 2:11:16 PM

Cloudability roles
Cloudability User
CloudabilityPlanningRestrictedUser
Self-Service Reporting




DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set v3\IDtoApptioFrontDoor
     Channel:  Subscriber
     Status:   Fatal
     Message:  Code(-9005) The driver returned a "fatal" status indicating that the driver should be shut down. Detail from driver: <description>java.lang.IllegalArgumentException: Source string may not be null</description>
<exception class-name="java.lang.IllegalArgumentException">
        <message>Source string may not be null</message>
        <stack-trace>java.lang.IllegalArgumentException: Source string may not be null
        at org.apache.http.util.Args.notNull(Args.java:54)
        at org.apache.http.entity.StringEntity.&lt;init>(StringEntity.java:65)
        at org.apache.http.entity.StringEntity.&lt;init>(StringEntity.java:116)
        at com.novell.nds.dirxml.driver.rest.HttpRESTAddOperation.sendHttpRequest(HttpRESTOperations.java:910)
        at com.novell.nds.dirxml.driver.rest.RESTSubscriptionShim.handleDriverOperationNode(RESTSubscriptionShim.java:947)
        at com.novell.nds.dirxml.driver.rest.RESTSubscriptionShim.handleCommandOperation(RESTSubscriptionShim.java:1093)
        at com.novell.nds.dirxml.driver.rest.RESTSubscriptionShim.addHandler(RESTSubscriptionShim.java:1125)
        at com.novell.nds.dirxml.driver.rest.RESTSubscriptionShim.dispatch(RESTSubscriptionShim.java:861)
        at com.novell.nds.dirxml.driver.rest.RESTSubscriptionShim.execute(RESTSubscriptionShim.java:680)
        at com.novell.nds.dirxml.remote.loader.Driver.driverStart(Driver.java:160)
        at com.novell.nds.dirxml.remote.loader.RemoteLoader.run(RemoteLoader.java:1309)
        at java.base/java.lang.Thread.run(Unknown Source)


/SWA/home/oracle/wildfly-24.0.1.Final/domain/servers/img-server-1/tmp/vfs/deployment/deployment206f259bb252b300/aveksa.war-3ead7d9c42b19ec5/custom/external_jsp/



fz3kGAWHVS72zdn



1.25

8/8/2025 1:24:17 PM
MIke - JSP work for role collection


https://frontdoor.apptio.com/service/apikeylogin

MyAccess: Authenticate
  JSP1 - apptio-opentoken




MyAccess proceeds with collection
  JSP2
     - input:
       - apptio-opentoken
       - API call url WITH desired GUID for envionrment: https://frontdoor.apptio.com/api/v2/environmentusers/environment/${enviornmentGuid}
       - pageSize
       - start
     - Pagination is assumed from MyAccess, so from JSP point of view:
      https://frontdoor.apptio.com/api/v2/environmentusers/environment/5b1b8db8-86aa-4eb5-a817-65d5cc00fa82?pageSize=500&start=0
      https://frontdoor.apptio.com/api/v2/environmentusers/environment/5b1b8db8-86aa-4eb5-a817-65d5cc00fa82?pageSize=500&start=500


     - Make enough calls to paginate through all results:
       - Call 1 (500 expected results)
        - pageSize=500
        - start=0
       - Call 2 (34 expected results)
        - pageSize=500
        - start=500



Step 1:
   - make authentication disableable (not in POC anymore
   - Can I receive an envryment gui as part of the url?



JSP2 actions:

 - Call this URL for each page of data:

Call 1 -  https://frontdoor.apptio.com/api/v2/environmentusers/environment/5b1b8db8-86aa-4eb5-a817-65d5cc00fa82?pageSize=500&start=0
Call 2 -  https://frontdoor.apptio.com/api/v2/environmentusers/environment/5b1b8db8-86aa-4eb5-a817-65d5cc00fa82?pageSize=500&start=500





https://myaccess.cis.qa.w11.swacorp.com/aveksa/main?Oid=3462&ReqType=Table&TableID=FilesTable&Action=file&filename=MyAccessAuthenticateToApptio1-0b.jsp

https://myaccess.cis.qa.w11.swacorp.com/aveksa/custom/external_jsp/autocrib_groups_collections.jsp





8/5/2025 1:12:52 PM
Mike chat
QA2 - green h004
QA1 - Yellow myaccess.cis.qa.w11.swacorp.com
Steps:
1 - Collect users
   - email - RELATE ON THIS
   - full name

2 - Collect roles
   - email - RELATE ON THIS
   - Role name
   - Role ID

3 - relate:
   - list of users swith their roles







8/5/2025 10:52:21 AM
Ashleigh: getting tokens for Targetprocess:

TargetProcess: POV token:

Name: IDM Service Account Token in pov


NEW
Name: IDM Service Account Token in pov
Token:  NzIyMTpoTE5yODNGOHUrT0ZYTFAvVVFCRlNsaWthZE1PTTJONGprZTNxdnZKdEUwP



Target process:

Get Active Users Filtered API V2 NonPag:
https://southwestairlinespov.tpondemand.com/svc/tp-apiv2-streaming-service/stream/users?where=(isintegration == false and resourceeid != null)&select={Email,ResourceEid:resourceeID,role.id,role.name}&access_token=NzIyMTpCbXRsTWVaUVU1QjVSQzY4ZlRWQWxabFI4aUZ6TTlNUVQzS1JqL3dDbVFJPQ==


   - Only pulls active users (IsIntegration = false . .), and only EID folks . .
   - Pulls roles
   - Example:
        {
            "email": "andrew.xxxx@wnco.com",
            "resourceEid": "E105893",
            "id": 141,
            "name": "Tech Leader - Active",
            "__id": 5559
        },


Get all TargetProcess roles:
https://southwestairlinespov.tpondemand.com/svc/tp-apiv2-streaming-service/stream/roles?access_token={{TP_POV_API}}


Notes:
   - not exposing all: admin/vs non?
    8/5/2025 11:01:22 AM- YES - '-Active' roles are ones users can request . .at least in POV, don't know how e're doing this in main.
    - Note: Exactly 100 roles right now! 8/5/2025 11:03:38 AM
    - Concern: NOT using 'eid/xid' in email in target process . .we have the rsource id . .
    - NOte: I did use my eid/xid' acocunt to create my token!
   - Main: repeat!

    name: IDM Service account: in main
    token:

Q==



works: GET on: https://southwestairlinespov.tpondemand.com/api/v1/users?where=(email eq 'elaine.hopkins@wnco.com')&access_token=NzIyMTpCbXRsTWVaUVU1QjVSQzY4ZlRWQWxabFI4aUZ6TTlNUVQzS1JqL3dDbVFJPQ==








7/10/2025 11:29:32 AM


TODO:
   - Move massive summary email to confuence page . .RAW NOtes . .
   - Add make sure it's clear default/custom roles are identified at least by order in the entlement.
   - Work over the next few weeks:
     - 1 - SLOW: Assist Apptio team to create proper feed files (could take two weeks.)
     - 2 - Test feed files with Mike.
     - 3 - Split exisitng driver and create IDtoApptioFrontDoor driver
           - pick some temporary payload format; confirm with Ashleigh
           - parsing apptio roles . .

           Phase 1 entitlement role
           cloudability GUID|||(static three roles)
           main GUID|||default1|||  (could
           main GUID|||default2|||
           main GUID||||||custom1
           main GUID|||default3|||
           main GUID||||||custom2

Phase 1: swaApptioRoles attribute, IDtoApptioFrontDoor driver:
Ae95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole1

Phase 2: swaApptioRolesTargetProcess attribute, IDtoApptioTargetProcess
d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process:::Business User




           Phase 1:
            main GUID|||Targetprocess User|||

           Phase 2:
            main GUID|||Targetprocess User;;;Epic Owner|||


                      main GUID|||Targetprocess User(Epic Owner)|||

      User to role mapping file
         - 1234,e332211,d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole1|||
         - 1234,e332211,d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process;;;Business User|||
         - 1234,e332211,d675e95f-b4af-56b8-6ea6-e9ed5041eab3||||||CustomRole1
         - 1234,e332211,5b1b8db8-86aa-4eb5-a817-65d5cc00fa82|||Cloudability


      Example: user e332211 payload - swaApptioRoles for a specific user:
         d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||ApptioOneRole1|||
         d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process;;;Business User1|||         5b1b8db8-86aa-4eb5-a817-65d5cc00fa82|||Cloudability
         5b1b8db8-86aa-4eb5-a817-65d5cc00fa82|||Cloudability
         d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process;;;Business User2|||
         d675e95f-b4af-56b8-6ea6-e9ed5041eab3|||Target process;;;Assignee|||
         d675e95f-b4af-56b8-6ea6-e9ed5041eab3||||||CustomRole1
         5b1b8db8-86aa-4eb5-a817-65d5cc00fa82|||Cloudability

    Key point: first target process role we use: needs to match the default
       - gives us a good phase1 approach to minimize mismatched targetprocess roles . .


Dhivya,

Joe and I are in sync now. We wanted to give you some information:


CURRENT STATUS:
 1 - We're about 75 percent complete on the IDtoApptioFrontDoor, the driver needed for Phase 1.
 2 - We haven't started the Phase 2 driver (probably IDtoApptioTargetProcess), though this can be written between now and October.
 3 - The driver work cannot be completed until we have a clear payload for role assignments.
 4 - The MyAccess work is stopped until we get the 2 feed files (Role Def & user->Role files) from the Apptio team.

We think at this point, Joe likely will be in a support role for the Apptio team; as they have a bit of work to complete. There are some items we could optionally do to help speed up the project:



POSSIBLE SPEED-UP-THE-PROJECT IDEAS:
1 - The driver is only waiting on the actual entitlement (aka swaApptioRoles driver attribute) definition before the driver work can proceed . . . If we could confirm that one field in the MyAccess files, the work could start sooner rather than later.

2 - The MyAccess work can begin as soon as we have sample files that are at least close to what we're looking for. We do not need to wait for them to automate their creation to move forward on development; we just need example files that are super close (if not exact) to what they will end up with.

3 - If you can help push on the IBM vendor with Ashleigh, that would help too. These are the 5 questions that we're trying to answer.
   Q1 - eid/xid storage: Where can we store this in an API accessible field? Can we use 'email' as in eid@wnco.com? This would make the user->role mapping file possible, and make the IDM matching rule much better.

   Q2- Either way, Ashleigh has access to the link that has 10+ web apps to help them look up data: https://wpsecadmin01.luv.ad.swacorp.com/IAMToolsLinks/.

   Q3 - Is there a standard auth method? This is very likely no, but we wanted to try one more time.

   Q4 - How does linkage between FrontDoor and TargetProcess work? We think we don't care as that relationship may be completely managed on their side . .but things like mismatches between FrontDoor& TargetProcess, and how we can reconcile the FrontDoor database and the TargetProcess database.

   Q5 - Are we missing some API calls? For example, Is there a call that can list all available roles in all environments?

Let me know if you have questions! I'll check my email occasionally and respond to items as appropriate.

Thanks,
--Aaron





POV: 0c5845ea-43ff-5481-1fce-71f58ba2ff4d (this environment is only for dev purposes)
Main: d675e95f-b4af-56b8-6ea6-e9ed5041eab3 (ApptioOne and Target Process)
Cloudability: 5b1b8db8-86aa-4eb5-a817-65d5cc00fa82



















Joe IDtoApptio check in -
I think we are already in sync, except for a few minor items

 - Work over the next two weeks.



1 - Ashleigh and I send out yet another big email with the summary and open questions from our major decision chat between the three of us.


2 - I've been trying to get the latest stuff into the doc; but had other things to wrap up . .
 https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/629866534/IDtoApptio

3 - When we emulate cloudability roles in POV; we may have to deal with the fake roles coming in as 'customRoles' . . ideally, they'd be default roles; but I don't know if that's possible.
   - Maybe:
   swaApptioRoles
    GUID|||DefaultRoles|||CustomRoles


4 - Latest postman collection is on CSEE-4989, commit id: d65c517
  - this just has some of the fixes and testing you and I did together during the handoff call.



Quick summary of decision made to double check:

  1 - 1 Single MyAccess app:
     - I believe the main reason for this is to simplify both the MyAccess work, and only have a total of two required files, and UFM processes for each file for MyAccess work.
     - I've sent out concerns about the high number of roles under 1 app; sounds like Mike is looking into this; it's listed in our questions in the big summary Asleigh and I sent out yesterday.

     Joe - more for the user experience . .may be technical reason for different apps . .but just one for now. May be easier to collect, etc . .

  2 - A total of two IDM drivers will be built:
    Phase 1:
       - 1 total driver: Name: IDtoApptioFrontDoor maybe . .?
        - This driver ONLY focuses on A) provisioning to Frontdoor, and B) assinging roles to apps in FrontDoor.
       - 1 total MyAccess app.

    Phase 2: Name: IDToApptioTargetProcess maybe?
       - 2 Total drivers . .
        - This driver ONLY focuses on Specific Target Process roles using the Target process API.
       - 1 - STILL only 1 total MyAccess app . .
       - Apptio appteam - they'll just start adding target process role definitions to the file .

       Joe: PDOS is behind IDM as far as user base is considered, don't know how far. Concern: If user tries to request role for target process . .
       - concern: Problem: this is a matchingrule driver . . would need subsequent event to attempt a match again . .
        *** - big point: if user not found int arget process, what are we doing?
        - possible solution: maybe have a job to regularly check "Slow PDOS users."





  3 - With #1, and #2 in mind above, MyAccess work should become more simple:
     - Ashleigh knows that editing existing roles can cause issues. . .
     - It sounded like she intends to send all of the frontdoor roles initially, then add all target process roles for phse 2 . and I think this would work nicely for MyAccess.












Team,

Mike and I have been trying an option to have MyAccess do API based collection for Apptio. We need some assistance in finding a solution. We have a number of rather difficult obstacles, and suspect that what we are trying to do, is difficult at best and time consuming to get right.

1 - Authentication Token is sent in response header instead of response body - requiring us to have a JSP
2 - The JSON response back is in an array, instead of key/value pairs, making the collectors be reliant on the array format
3 - We have a cert error for connecting to front door (a 1 time issue) which is yet to be resolved.

 LOTS of obstacles
 - Cert error - may ahve more than one: to auth url, and then TBM url
 - Get the authetnciation token (JSP required)
 - Then we need to actually make the call to get the Role and user data.
 - Then we need to parse the goofy JSON format.
 - What other obstacles are there at this point? We just don't know.

Cloudability roles:
  Cloudability User
  CloudabilityPlanningRestrictedUser
  Self- Service Reporting User

email postfix in QA
  mail.wnemail.com



8/27/2025 4:10:25 PM
old notes  that were in a wrong spot.

Example working payload - using custom-authentication to give me the proper url
```

<nds dtdversion="4.0" ndsversion="8.x">
  <input>
    <driver-operation-data class-name="custom-authentication" command="modify" event-id="" src-dn="">
      <request>
        <url-token/>
        <header/>
        <value>{ "keyAccess": "94b4e065-9bde-4d67-97a5-91281ed6394c", "keySecret": "oAIVOGk54WF1K78UGubDF4wtlIWGealvaTWwYh7M3yZI6cbSXDekn6NfA1gO" }</value>
      </request>
    </driver-operation-data>
  </input>
</nds>
```
