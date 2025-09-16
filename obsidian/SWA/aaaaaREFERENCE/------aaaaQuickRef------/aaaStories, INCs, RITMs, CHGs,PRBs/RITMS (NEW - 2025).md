
3/13/2025 4:59:49 PM
Created to allow me to install Designer 4.10
[RITM11100987](https://southwest.service-now.com/sc_req_item.do?sys_id=beb6be81479426505f488f2f016d43b3&sysparm_view=NULL)

3/25/2025 10:27:33 AM
Created to change swaAutocribRole to multivalued, or new swaAutocribRoles attribute + multivalued.
[RITM11140553](https://southwest.service-now.com/sc_req_item.do?sys_id=15afc374936c26502594b53a7bba1014&sysparm_view=NULL)

3/28/2025 4:15:59 PM


4/28/2025 11:07:17 AM
[RITM11257924](https://southwest.service-now.com/sc_req_item.do?sys_id=f78f5eb3938d6614527bb31efaba10f1&sysparm_view=NULL) - created to have e188711 to be pushed from workday (swaStatus_CF) isn't populating.


5/19/2025 2:15:37 PM
Request to delete "swaAutocribRoles" plural version
[RITM11328379](https://southwest.service-now.com/sc_req_item.do?sys_id=dc0497a2c325ae10d8c2300f05013141&sysparm_view=NULL)


6/11/2025 11:28:52 AM
[RITM11421774](https://southwest.service-now.com/sc_req_item.do?sys_id=3b6a89022bce62d41367f709f291bfda&sysparm_view=NULL) - to request IDtoApptio CI

8/12/2025 5:57:31 PM
RITM11666716
Requested attrs on this:

Due to restrictions for attribute formats, and in an effort to be future-friendly to SailPoint, we've recently learned that the existing swaApptioRoles attribute is insufficient to meet our needs. Instead, we've been asked to have super simple payloads in attributes.  For this reason, we need these 5 multi-valued case ignore string attributes, added to the normal aux class (swaPerson I believe):

swaApptioRolesMainDefault
swaApptioRolesMainCustom
swaApptioRolesCloudabilityDefault
swaApptioRolesCloudabilityCustom
swaApptioRolesTargetProcess

We can also delete swaApptioRoles; we will not be using this attribute.


8/15/2025 7:53:25 AM
RITM11677010 - submitted to get DEV/QA certs for PSM links in cyberark: prod works, but QA/DEV aren't trusted:
DEV_PSM = "https://pvwa-sapm.cis.dev.swacorp.com/PasswordVault/v10/PSM-SSH-MFA-Caching" # Do not edit
QA_PSM = "https://pvwa-sapm.cis.qa.swacorp.com/PasswordVault/v10/PSM-SSH-MFA-Caching" # Do not edit
PRD_PSM = "https://pvwa-sapm.cis.prod.swacorp.com/PasswordVault/v10/PSM-SSH-MFA-Caching" # Do not edit

