Short Description
(story) (Deploy|Update) (drivername) in (qa|prod)

CSIGA-6755 Update IDtoDocunet in QA
CSIGA-6755 Update IDtoDocunet in Production

CHG0449886 - CSEE-4137 Deploy IDtoAutocrib driver in QA
CHG0449896 - CSEE-4233 Deploy IDtoAutocrib driver in PROD


CHG0454321 - CSEE-4232 Deploy IDtoAviobook driver in QA - 3/6/2025 10:33:52 AM - 	2025-03-06 12:00:00
CHG0454614 - CSEE-4233 Deploy IDtoAviobook driver in Prod - 3/7/2025 10:56:43 AM - 2025-03-26 12:00:00


CHG0451726 - CSEE-4400 Deploy IDtoSprinkler driver in QA
CHG0451730 - CSEE-4401 Deploy IDtoSprinkler driver in Prod
AEv1
```
QA
Current Primary server: w11qcledirqi013
Current Backup server: hdqqcledirqi013
Designer version: 4.8.7.0100
X
Team responsible for the changes: Cybersecurity EE Team


Driver to deploy: IDtoAutocrib
Driver version number: 1.0.3

Driver to deploy: IDtoAvioBook
Driver version number: 1.0.3

Current Primary server: w11qcledirqi013
Current Backup server: hdqqcledirqi013
Designer version: 4.8.7.0100
Driver to deploy: IDtoSprinkler
Driver version number: 1.2.4
Team responsible for the changes: Cybersecurity EE Team

Current Primary server: w11qcledirqi013
Current Backup server: hdqqcledirqi013
Designer version: 4.8.7.0100
Driver to deploy: IDtoAvioBook
Driver version number: 1.6.7
Team responsible for the changes: Cybersecurity EE Team


Prod
Current Primary server: w11scledirsi009
Current Backup server: sdcpcledirpi013
Designer version: 4.8.7.0100
Driver to deploy: IDtoAutocrib
Driver version number: 1.0.3
Team responsible for the changes: Cybersecurity EE Team



CIs QA - AEV1
w11qcledirqi013
hdqqcledirqi013
identity_manager_qa
IDtoAutocrib

CIs Prod - AEV1
w11scledirsi009
sdcpcledirpi013
IDtoAutocrib
identity_manager_production


Ops team update:

QA
CSEE Deployment: IDtoAutocrib IDM driver
Change Number: CHG0449886
Change Owner/POC: Me
Environment: QA
Implementation: CSEE-4137 Deploy IDtoAutocrib driver in QA
Change Window: 2025-02-12 12:00:00
Reason For Change: Initial deploy of the driver.
Impact: None, except for < 1 minute driver restart.
Outage: None, except for < 1 minute driver restart.

    CSEE Deployment: IDtoApptioFrontDoor/IDtoApptioTargetProcess IDM driver
    Change Number: CHG0491008
    Change Owner/POC: Me
    Environment: QA
    Implementation: Deploy/Update ----  IDM Drivers IDtoApptio for FrontDoor & TargetProcess
    Change Window: 2025-09-08 08:00:00
    Reason For Change: Deploy new drivers to support Apptio.
    Impact: None, an early, tested version of the drivers are being deployed to begin MyAccess end-to-end-testing.
    Outage: None.
    

CSEE Deployment: IDtoAvioBook IDM driver: dynamic qualifications
Change Number: CHG0454321
Change Owner/POC: Me
Environment: QA
Implementation: CSEE-4232 Deploy IDtoAviobook driver in QA to add dynamic qualifications.
Change Window: 2025-03-07 12:00:00
Reason For Change: Adds support for 4 roles map to one of two new qualifications.
Impact: None, except for < 1 minute driver restart.
Outage: None, except for < 1 minute driver restart.




CSEE Deployment: IDtoSprinkler IDM driver
Change Number: CHG0451726
Change Owner/POC: Me
Environment: QA
Implementation: CSEE-4400 Deploy IDtoSprinkler driver in QA
Change Window: 2025-02-20 15:30:00
Reason For Change: Two new roles in the role -> parter mapping table.
Impact: None, except for < 1 minute driver restart.
Outage: None, except for < 1 minute driver restart.

PROD
CSEE Deployment: IDtoAutocrib IDM driver
Change Number: CHG0449896
Change Owner/POC: Me
Environment: PROD
Implementation: CSEE-4137 Deploy IDtoAutocrib driver in PROD
Change Window: 2025-02-18 13:00:00
Reason For Change: Initial deploy of the driver.
Impact: None, except for < 1 minute driver restart.
Outage: None, except for < 1 minute driver restart.
```

V3 
```
QA
Current Primary server: w11qcledirqi010
Current Backup server: hdqqcledirqi010
Designer version: 4.8.7.0100
Driver to deploy: IDtoApptioFrontDoor, IDtoApptioTargetProcess
Driver version number: 1.2.0, 1.0.1
Team responsible for the changes: Cybersecurity EE Team
	
	most recent: CHG0491008 - 9/5/2025 5:23:24 PM

Prod
Current Primary server: w11pcledirpi010
Current Backup server: sdcpcledirpi010
Designer version: 4.8.7.0100
Driver to deploy: IDtoApptioFrontDoor, IDtoApptioTargetProcess
Driver version number: 1.2.0, 1.0.1
Team responsible for the changes: Cybersecurity EE Team
	
	most recent: CHG0491007 - 9/5/2025 4:56:33 PM



CIs QA
w11qcledirqi010
hdqqcledirqi010
IDtoDocunet
identity_manager_qa

CIs Prod
w11pcledirpi010
sdcpcledirpi010
IDtoDocunet
identity_manager_production


Ops team update:

QA
CSEE Deployment: IDtoDocunet IDM driver
Change Number: CHG0443332
Change Owner/POC: Me
Environment: QA
Implementation: CSIGA-6755 Update IDtoDocunet in QA
Change Window: 2025-01-09 13:00:00
Reason For Change: CSIGA-6755 - fix association bug in driver.
Impact: None, except for < 1 minute driver restart.
Outage: None, except for < 1 minute driver restart.

PROD
CSEE Deployment: IDtoDocunet IDM driver
Change Number: CHG0443335
Change Owner/POC: Me
Environment: PROD
Implementation: CSIGA-6755 Update IDtoDocunet in pROD
Change Window: 2025-01-14 12:00:00
Reason For Change: CSIGA-6755 - fix association bug in driver.
Impact: None, except for < 1 minute driver restart.
Outage: None, except for < 1 minute driver restart.

```

cr creation notes:




3/26/2025 9:53:13 AM
CR management:


Aviobook:
  c - Prod, will do both IDtoAviobook, and IDtoAviobookPrelive on this.
  CHG0457932 - QA - Prelive deploy only.
  CHG0457693 - QA - Reverfy test after QA deploy.
  RBEAEv1
  CSEE-4544 - QA deploy for re-org updates.
  CSEE-4545 - Prod deploy for re-org updates.


EntitlementServiceRoleMgmtDriver
   DONE! as of 3/26/2025 11:17:22 AM CHG0458543  - QA - CSEE-4541 Deploy EntitlementServiceRoleMgmtDriver for department code changes to support recent SWA re-org
      2025-03-26 13:00:00




RBEAEv1

QA:
w11qcledirqi013
hdqqcledirqi013

PROD:
w11scledirsi009
sdcpcledirpi013



w11qcledirqi013
hdqqcledirqi013
IDtoAviobooks


w11scledirsi009
sdcpcledirpi013
IDtoAviobooks

prod
Current Primary server: w11scledirsi009
Current Backup server: sdcpcledirpi013
Designer version: 4.8.7.0100
Driver to deploy: IDtoAvioBook (entitlement policies)
Driver version number: 1.8.2
Team responsible for the changes: Cybersecurity EE Team


CSEE Deployment: IDtoAvioBook (entitlement policies)
Change Number: CHG0458918
Change Owner/POC: Me
Environment: Prod
Implementation: Updates will be made to support the recent SWA re-org.
Change Window: 2025-03-31 14:00:00
Reason For Change: Updates to support recent SWA re-org.
Impact: None, other than a driver restart.
Outage: None, other than a driver restart.






QA
Current Primary server: w11qcledirqi013
Current Backup server: hdqqcledirqi013
Designer version: 4.8.7.0100
Driver to deploy: IDtoAvioBook (entitlement policies)
Driver version number: 10.8.3
Team responsible for the changes: Cybersecurity EE Team

CSEE Deployment: IDtoAvioBook (entitlement policies)
Change Number: CHG0458910
Change Owner/POC: Me
Environment: QA
Implementation: Updates will be made to support the recent SWA re-org.
Change Window: 2025-03-28 08:00:00
Reason For Change: Updates to support recent SWA re-org.
Impact: None, other than a driver restart.
Outage: None, other than a driver restart.





ESRMD
QA:
w11qcledirqi013
hdqqcledirqi013

PROD:
w11scledirsi009
sdcpcledirpi013

Current Primary server: w11scledirsi009
Current Backup server: sdcpcledirpi013
Designer version: 4.8.7.0100
Driver to deploy: EmployeeServicesRoleMgmtDriver
Driver version number: 10.8.3
Team responsible for the changes: Cybersecurity EE Team


CSEE Deployment: EmployeeServicesRoleMgmtDriver
Change Number: CHG0458555
Change Owner/POC: Me
Environment: Prod
Implementation: Updates to support recent SWA re-org.
Change Window: 2025-04-01 14:00:00 (subject to change due to re-org sync up with Sean Carroll)
Reason For Change: Updates to support recent SWA re-org.
Impact: None, other than a driver restart.
Outage: None, other than a driver restart.




Current Primary server: w11qcledirqi013
Current Backup server: hdqqcledirqi013
Designer version: 4.8.7.0100
Driver to deploy: EmployeeServicesRoleMgmtDriver
Driver version number: 10.8.3
Team responsible for the changes: Cybersecurity EE Team

CSEE Deployment: EmployeeServicesRoleMgmtDriver
Change Number: CHG0458543
Change Owner/POC: Me
Environment: QA
Implementation: Updates to support recent SWA re-org.
Change Window: 2025-03-26 13:00:00
Reason For Change: Updates to support recent SWA re-org.
Impact: None, other than a driver restart.
Outage: None, other than a driver restart.



and





   - I have two duplicate stories now that I've combined the reorg and retiree work for the EmployeeRoleServicesManamgenet driver, CSEE-4262 and CSEE-4263 can be canceled


I realized that I need a correction to some stories


These are now duplicate stories: they were the QA/Prod deploy stories for the retiree updates. The retiree work was less than I thought so I'll use the new QA/PROD stories to deploy both updates:

IDM | EmployeeServicesRoleManagementDriver - Ensure Retiree Base Role - QA Deploy
https://southwest.atlassian.net/browse/CSEE-4262

IDM | EmployeeServicesRoleManagementDriver - Ensure Retiree Base Role - Prod Deploy
https://southwest.atlassian.net/browse/CSEE-4263



Here's the latest status:

Assignments:
    EmployeeServicesRoleMgmtDriver - 2025-03-26 - Aaron: code changes complete; testing pipeline & doing QA/Prod CR paperwork.
    IDtoMaintenix - Kyle
    IDtoOpsSuite - Yatin
    IDtoCrowd - 2025-03-06: Kyle waiting on answers to see if changes are needed.
    NotificationLoopback - Kyle? (may already be done)

Entitlement Policies - 2025-03-24 - Aaron - Started.
    avio_dispatchers
    avio_dispatch_specialists
    avio_atc_specialists
    avio_chiefs
    avio_network_directors


Completed, or no longer needs changes:
    IDtoLogicMonitor - Joe - Not needed




Kynaston, Aaron-660602
gitlab--csiam-idm--dev-deploy



On Aarons plate for now:

1 - Reorg:
  A) EmployeeServicesRoleMgmtDriver: stories created; not scheduled.
  B) Aviobook entitlement policies updated: stories created, not scheduled.
2 - Autocrib - ON HOLD, pending multi-site verification: Will need new stories.
3 - Aviobook - Prelive driver deploy, then full prod deploy; stories created and scheduled.
4 - EmployeeServicesRoleMgmt (again) - Retiree initial migration fix.




