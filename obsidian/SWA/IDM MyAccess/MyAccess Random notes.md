8/21/2025 3:06:26 PM
Worked with mike in QA2, went to path below to update JSPs . . aveksa.war is re-expanded everynow and then, so it isn't permanent what we put there.


QA1
w11qclmyastg001?

QA2
aveksa, then root:
root@w11qclcmyarh004




Cuyrrent path:


/SWA/home/oracle/wildfly-24.0.1.Final/domain/servers/img-server-1/tmp/vfs/deployment/deployment37ab9a95ed32083/aveksa.war-1a365c674fa5647c/custom/external_jsp







MyAccess System Administrator


7/10/2025 2:01:49 PM
MyAccess meeting
MIke
Gokul
Roshani
Vikas
Dhivya

Talking through a created app in my access: SAP BRIM
 - API is what was chosen for collection


 - Resrouces -> appliations -> SAP BRIM -> collectors - 4 of them.
 - Just set up entitlement collectors, and account collectors
 -  "AccountDataCollector", "EntitlementDataCollector"

 - Dhvya: ever static roles period? need both all the time? sounds like yes . .
 - some times, have more than one collector despite only one endoint.
 - Joe: APIs: not doing live role collection . .  . .could natively get thie rroles in apps
   - We've not had a lot of luck with this.

Questions:

1 - Is there a component diagram for MyAccess? There's more pieces than expected.

2 - Also, I'm trying to pick up the vocabulary; is this documented somewhere?

Application -
AccountDataCollector - Is this equivalent to the user-role mapping file?
EntitlementDataCollector - Is this equivalent to the Role definition file? ('technical role' vs 'applicatoin role'
Account - a user that can receive technical roles.
Entitlement - a potentially assignable role aka 'Application role'(such as a group, or application role); though only as a tcechnical role.
Technical Role - Actual assignable role; that can point to 1+ entitlements.(and how does it differ from an Application role?)
Application Role - same as 'entitlement' above. (and how does it differ from an Technical role?)
Collectors - aka: connectors to user store applications like identities.
   - SWA Identity Connector can read . .id or ad . .?
-


 - shjowing SAP brump - all users dump - account dump
 - essentilly just the result of an API GET.
   - pointing out it has a group.
   - also noting - the all groups endpoint
   - showing problems - GUIDs only show up in group file,  . .need to connect to users . .
   - need to coorelate groups na dusers . .
 - now editing account collector
 - collecting accounts
 - then it goes to REST API screen
 - give endpoint, url is graed out - BASE URL is set at the top of the collector deff.
 - talking aobut request headers
 - (pagintation is also there)
 - now talking about how it pulls back data
 - jsonpath - says it sthe format . .dropdown gives 1 option - jsonpath . .lol
 - allows poulation of 'Accountid', and 'BrimAccountID'
 - now - mapping values: Accountid -> Account DN
 - external id - BrimAcocuntid
 - note: all of this is for coorelationg accounts in MyAccess
 - collectors - shows drop down of all idv values ('user id') is one of them.

 - now Entitlement collection! - Mike knows less
 - same look and feel initially - baseurl may change based on endoints
 - colelct accounts . .vs groups:mike never seen have a "collect for groups" on entitlement collector.
 - description . ./Users endpoint - same again; coud put different.  .
 - same pages as before on api page . .
 - except for allgroups.json: now going after resources.groups.value -> ApplicationRoleid
 - also getting ApplicatoinRoleName - display name of the group
 - when collecting - properly collapses groups from userdump! two groups with the same roleid, it knows it's a dup.
 - interesting example: - collecting the entitlements.
 - gokul/mike: if groups dno't have users? will not be collected!
 - now - App-Role account membership data

 Now 'Technical roles
 - What Access -> 13 entitlements - showing raw id and 'display name'
 - this is a list of what we got from the JSON
 - now assinging someone a role
 - "Appliation_acess_for_swa"
 - showing one manual role . .
 ** - this is just a tehncial role, and tied to an entitlement: straight up entitlementsnot acceptiable . .
 ** - Tehcnical roles are the actual requestable roles requestable through Myaccess
 - feed files auomatically create tehncial roles. . .API version does not.
 - showing dtabase collectors . . GitLab Dedicated Deployer Tehnical roles
   - automated way to create technical roles
 - Roles don't change that much . .so not terrible . .

 Now - 'shell roles' -> manual technical role creation.
 - Mike took all entitlements from sap brim
 - MIke saw that a workflow was ignoring SAP* named roles; so api role collections are manually

MyAccess components:

The smallest independent useable component in MyAccess is called an 'Application'. An Application

Rights for the app name maybe: MyAccess System Administrator

 - Joe: add mYaccess special notes to driver pages . .
 - spreadsheet to fill out applications.

Ask mike for the master my access application list spreadsheet?


