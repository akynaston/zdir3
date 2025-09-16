7/29/2025 8:38:26 AM
EmployeeSvc meeting with Gokul

Two sets of open tasks now:
 - feature covering all existing work - https://southwest.atlassian.net/browse/CYSEE-929
   - Aaron here

 - feature covering the support to the empsvc team - https://southwest.atlassian.net/browse/CYSEE-1514
   - Gokul here




3 drivers:
1 - IDtoEmployeeSvc (CSEE-5025): main driver, does all the commuication to employeeSvc, except for swaImage - over SOAP
2 - EmployeeServicesRoleMgmtDriver (CSEE-5025): responsible for managing swaEmpSvcBaseRole, and swaEmpSvcElevated role:
  swaEmpSvcBaseRole: sets to 1 of the 4 base roles as provided in the build/GCVs.
  swaEmpSvcElevatedRole: set by MyAccess . .if set, swaEmpSvcBaseRole is cleared.
  Important note: Roles: are in a 'roleid/profile ID' format, and are Enviornment specific!
3 - IDtoEmployeeCarePicture (master): manages swaImage over REST.

Enviornments:
IDMDEV1 - used for our DEV
EMPDEV1 - June 10th: they decommisioned without telling us . .it's there; but they use it for soemthing else now.
EMPUAT - Used for our QA
EMPFC3 - also used for QA; they have us swap between them (see note about swapping envs, it's a big pain)
CMAppTest - ??? - If this is a copy of production -
PROD - prod env



IMPORTANT NOTE ABOUT SWAPPING ENVS:
 - Stop & disable EmployeeServicesRoleMgmtDriver
 - Consider associations for IDtoEmployeeSvc: note that they will be wrong with switching enviornments . .
   - Either delete them all up front.
   - Depend on a <sync> to do it for you if they want users synchronzied.
 - Consider the swaEmpSvcBaseRoles and swaEmpSvcElevated roles:
   - If dest envionrment needs users, go ahead and use sync.
   - if they don't necessarially want the users there, just delete associations.
 - UserID and password must be updated, for both IDtoEmployeeSvc, and IDtoEmployeeCarePicture.
   - Be sure to review and update AWS as needed.
   - Note that SOAP just uses a username/password, where REST is a full OAUTH2 client credentials.




