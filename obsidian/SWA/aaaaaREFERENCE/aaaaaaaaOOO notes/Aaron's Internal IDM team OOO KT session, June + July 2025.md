6/4/2025 6:29:39 PM
Completed at 3 pm MDT today



5/30/2025 4:57:30 PM
IDM team KT session for my OOO


RECORD MEETING

I'm out June 18-the 20th - W, Th, F, Then I'm out July 11, through July 25: that's a Friday on the 11th, then the next two weeks. I'll be on the road for some of this, then should have internet access; but it may not be consistent. Please IM me when needed, and I'll respond asap when I can.

I sent this email notification to IDtoAviobook, IDtoEmployeeSvc, IDtoApptio, IDtoAutocrib including the fact they should email us if they have questions:

	Team,
	
	I'll be OOO June 18 - 20 (3 days), and then again from July 11 - 25 (11 days). If you need something during this time, please email my team with your request to: CybersecurityEnterpriseEnablementTeam-DG@wnco.com. Otherwise, feel free to email me directly, as I'll periodically check my email and I'll help to resolve it when I'm back in the office. Please feel free to forward this to those who may need to be included.
	
	--Aaron










4 projects: 
1 - IDtoApptio: Shouldn't need anything, we're not far along enough in the development.
2 - **IDtoAutocrib**: the last site is going live on June 15; shouldn't need assistance on this one.
3 - **IDAviobook**: Minor issue around manual creation of users: they shouldn't do it any more; but we can help them if they do 4 (scheduling KT session for ops on this)
4  - **EmployeeSvc**: App team may send INCs to fix users: for now; just fix email address population, swaEmployeeSvcBaseRole, and swaEmployeeSvcElevatedRole.

That leaves only Aviobook and EmployeeSvc to talk about.


Discussion: For both aviobook and empsvc, most items can be fixed by just pushing users, #4#; after they have the right roles:
The first thing to cover is how to confirm users have their roles; and how to watch for other things that could stop a user, such as a bad email address.
Second - we'll talk about cleaning up bad users (aka manually created) in aviobook.


OPS NEEDS THIS ON A KT:
IDtoEmployeeSvc driver roles two kinds, set by MyAccess & ESRMD set: 	
	swaEmpSvcBaseRole - single valued, set by the EmployeeServicesRoleMgmtDriver
	swaEmpSvcElevatedRole - single valued, set by MyAccess

IDtoAviobook driver roles, two kinds MyAccess & RBEAEv1:
	 swaAvioBookRoles - Multivalued, set by MyAccess, e.g. avio_cabin_fa
	 DirXML-EntitlementRef - standard old school Entitlement driver: RBEAEv1
	 * also note: IDtoAviobook and IDtoAviobookPrelive are two separate drivers; and differ only by a single GCV setting to change the role behavior slightly. You should not have to worry about IDtoAviobookPrelive.


















 - Open Postman & ApacheDirectory Studio
 - Don't forget to request admin rights in prod

1 - EmployeeSvc: they may send an INC saying users have some issue, and need to be repushed: this is just the normal migrate from - (#4# on DirXML-Association), or a resetting of the base role; so we'll cover that.
	 - Also: recently had to manually disable some accounts in EmployeeSvc; we're chasing down a bug where we don't disable users.  to do this: See **"auxiliary/IDtoEmployeeSvc Salesforce SOAP API.postman_collection.json"** file on master branch.
		 - IDtoEmployeeSvc PROD -> Prod Login, then open -> User Query -> shows example of how to query for multiple users, then 'UpdateUsers' shows how multiple users can be disabled at a time.
	 - Other possible failures: driver documentation in the troubleshooting section for: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver
		 - 15 known errors documented there; some context on what is going on, 2 of them I don't know how to solve yet; most all issues can be solved by what we're covering today.
2 - Aviobook: There are times they have to create users manually, and do it incorrectly. Their team has been updated and shouldn't do it anymore; but we're chatting about it, and I'll give this same chat with Ops so they can keep an eye on it. See below for details.






MORE DETAILS:


EmployeeSvc:
  They may report disabled users, or users that just need to be repushed:

   - Users can be repushed as normal with #4# on the IDtoEmployeeSvc association.
   - Users will have either a swaEmpSvcBaseRole, or swaEmpSvcElevatedrole
     - if a user has a swaEmpSvcElevated role; then it was populated from Myaccess, just #4# the user, and send it through the IDtoEmployeeSvc driver, see what the error is if any.
     - If the user has a swaEmpSvcBaseRole populated and is incorrect, then do a #4# on the EmployeeServicesRoleMgmtDriver after confirming they have an email address, then do the #4# on the IDtoEmployeeSvc driver.
     - Note: email address is required; add if it is missing.





Aviobook:
  We recently learned they have to create users manually some times when they have a time-sensitive flight and a user needs access.  If they don't match the 'id' and 'username' when creating a user, The user just needs to be deleted in Postman, then #4# to push the user through the driver.
  - Once we fix all users in this state, we shouldn't ever have to do this again; and we don't think we need to add it to the driver.
  - At last count there's only like 10 left of these - we can't fix them because the corresponding user in eDirectory does not qualify for a role. Strictly speaking we should delete them from aviobook; but I can pick this up when I'm back.
  
  
You will know you have an issue if id and username that don't match, you see something like this::
  [{"code":"USER_USERNAME_IN_USE","message":"Username 'e95316' is in use."}] from the driver, because the driver is trying to create a new user with id and username equivalence; and that collides on the username.


  Example of a broken user: $.id, and $.credentials.username must be equal for the driver to process the account (if the driver had the id, it could use that instead; but the design already includes not using this route).


Example of a working user: see how id and username are equal?
      {
-->                   "id": "e100001",
            "email": "Catherine.Rozanas@wnco.com",
            "firstName": "Catherine",
            "middleName": "A",
            "lastName": "Rozanas",
            "credentials": {
-->                    "username": "e100001"
            },
            "organization": "default",
            "systemRole": "USER",
            "locked": false,
            "roles": [
                {
                    "id": "avio_cabin_fa",
                    "type": "USER",
                    "name": "avio_cabin_fa",
                    "organization": "default",
                    "archived": false,
                    "createdAt": "2024-08-09T00:14:42Z",
                    "modifiedAt": "2025-05-30T23:07:30Z"
                }
            ],
            "active": true,
            "archived": false,
            "createdAt": "2024-04-05T20:58:42Z",
            "submittedAt": "2025-04-02T23:54:07.624837Z",
            "submittedBy": "avio-idp-api",
            "modifiedAt": "2025-04-02T23:54:08Z",
            "modifiedBy": "avio-idp-api",
            "function": "UNKNOWN"
        }

Example broken user (we could have written the driver to use an 'id' as the association; but we didn't choose to go that direction).
          {
  -->                 "id": "a280982a-894e-4384-87eb-fc5f4b63ea2c",
            "email": "Celina.Gamble@wnco.com",
            "firstName": "Celina",
            "lastName": "Gamble",
            "info": "SWAU Inflight Initial Training",
            "credentials": {
-->                          "username": "e95316"
            },
            "organization": "default",
            "systemRole": "USER",
            "locked": false,
            "roles": [
                {
                    "id": "avio_cabin_office",
                    "type": "USER",
                    "name": "avio_cabin_office",
                    "organization": "default",
                    "archived": false,
                    "createdAt": "2024-06-25T12:12:47Z",
                    "modifiedAt": "2025-04-30T20:39:24Z"
                }
            ],
            "active": true,
            "archived": false,
            "createdAt": "2024-11-20T01:14:25Z",
            "submittedAt": "2024-11-20T01:14:25.227869Z",
            "submittedBy": "e83397",
            "modifiedAt": "2024-11-20T01:14:25Z",
            "modifiedBy": "e83397",
            "function": "CABIN_CREW"
        },




Update: 6/2/2025 12:31:15 PM

I've found 10 users using a script like this:
curl --location https://prod.swa.aviobook.aero/idp/users?query=id==r* --header "AVIO-Token: %tokenData%" --request GET | jq -r ".items[] | \"username: \" + .credentials.username + \"\tid: \" + .id" >> usersToDelete.txt

Update: I don't think any of these users qualify for an aviobook role . . so we may just need to send an 'archived = true' event.

Users to fix:
username: e112106        id: 307a0690-0dc6-40ab-a6dd-7c690f46240a
username: e140681        id: 32ed82c9-f578-480c-b466-11e1b635c25e
username: e181589        id: 3f159400-b0f1-4fa9-9021-2629b95c4d59
username: e105244        id: 4c2ac4bc-0fdb-4e97-9d3b-4b3371bfebc7
username: e123537        id: 54642814-57b8-4172-9216-cb0e3282f0a6
username: e131022        id: 5ddfb127-d604-4f38-bc98-9a8ac289db0c
username: e135214        id: 60cba945-706c-42b1-9ee1-3cf35c6f704c
username: e95559.old     id: 7fe9d965-21fa-4a7e-b827-198a42378918
username: e131472        id: 841a236f-a6ce-4e86-a570-5ec70bbc9563
username: e8279	         id: 8b219258-25b4-4c02-9355-7e8e02e6e206
username: e129785        id: 8c4bc841-6dce-4cd5-b458-fbe0896c7d68
username: e94416         id: 90aa9805-7e0f-43c6-92d0-23bb19aaa475

All valid static roles (valid in prod as of 6/3/2025 5:06:31 PM)  . .if you need them:

            "name": "connect-admin"
            "name": "api-tech-role"
            "name": "api-user-role"
            "name": "avio_aarp"
            "name": "avio_atc_specialists"
            "name": "avio_cabin_admin"
            "name": "avio_cabin_fa"
            "name": "avio_cabin_if_ops"
            "name": "avio_cabin_office"
            "name": "avio_charter"
            "name": "avio_chiefs"
            "name": "avio_ckp"
            "name": "avio_connect_admin"
            "name": "avio_connect_goadmin "
            "name": "avio_connect_goops"
            "name": "avio_connect_goramp"
            "name": "avio_connect_gosups"
            "name": "avio_connect_office_testing"
            "name": "avio_dispatch_specialists"
            "name": "avio_dispatchers"
            "name": "avio_faa"
            "name": "avio_flight_asap_ert"
            "name": "avio_flight_centralpubs"
            "name": "avio_flight_compliance_dailyops"
            "name": "avio_flight_efb_admin"
            "name": "avio_flight_efb_team"
            "name": "avio_flight_international_etops"
            "name": "avio_flight_nav"
            "name": "avio_flight_qa"
            "name": "avio_flight_rpc"
            "name": "avio_flight_safety"
            "name": "avio_flight_training"
            "name": "avio_moc_admin"
            "name": "avio_moc_controller"
            "name": "avio_moc_manager"
            "name": "avio_network_director"
            "name": "avio_network_directors"
            "name": "avio_noc_admin"
            "name": "avio_noc_team"
            "name": "avio_pilot"
            "name": "avio_product_admin"
            "name": "avio_sod"
            "name": "avio_tech_dev"
            "name": "avio_techops_admin"
            "name": "avio_techops_amt"
            "name": "avio_techops_asap-ert"
            "name": "avio_techops_ocmp"
            "name": "avio_techops_rpc"
            "name": "avio_techops_safety"
            "name": "avio_techops_view_only"
            "name": "aviobook_system"
            "name": "aviocast_avionics_only"
            "name": "aviopilot"
            "name": "full admin"
            "name": "Connect_Admin_Test_Role"
            "name": "idp-user-role"
            "name": "noc_team"
            "name": "pilot_sme"
            "name": "read_only"




Historical: users already archived as they don't qualify for a role:
Users to delete & recreate:  (these ones have been fixed - aka archived since they don't qualify for a role)
username: e95316  id: a280982a-894e-4384-87eb-fc5f4b63ea2c  
username: e149201  id: aca31785-fc30-4089-99f8-40ffc029ee01  
username: e95316  id: a280982a-894e-4384-87eb-fc5f4b63ea2c  
username: e149201  id: aca31785-fc30-4089-99f8-40ffc029ee01  
username: e183499  id: c7ce2c7a-2105-44bf-8578-784a1c9e0d8a  
username: e158503  id: c927843e-07bd-412a-aa97-8a1223fa13ab  
username: e146677  id: d0eeef98-704c-4bb5-beb9-b92091a00b66  
username: e158177  id: d3194a30-18f2-4214-bdf7-b0e84dfa0020  
username: e124557  id: da1a5643-8f33-451c-bee1-6d492a15ff3d  
username: e89246  id: f916b3d9-e763-4936-9b85-c3a8dcfc2724



Script to find all users that have an 'id' that starts with 'r*'; per the query filter:

I've found 10 users using a script like this:
curl --location https://prod.swa.aviobook.aero/idp/users?query=id==r* --header "AVIO-Token: %tokenData%" --request GET | jq -r ".items[] | \"username: \" + .credentials.username + \"\tid: \" + .id" >> usersToDelete.txt
