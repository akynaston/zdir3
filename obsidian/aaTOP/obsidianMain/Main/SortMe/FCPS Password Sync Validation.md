# [FCPS] Password Sync Validation

\[FCPS\] Password Sync Validation
\[FCPS\] Password Sync Test - Make sure passwords are in sync
\[FCPS\] Password Sync Test for Students---------------

Uses: fcpsPasswordSyncStatusStudent attributes = CHECK
- [x] Import the schema: 
- [x] Copy in GCVs: 
![[./_resources/FCPS_Password_Sync_Validation.resources/Password Sync Test GCVs.xml]]
- [x] Create Policy in the Subscriber event transform: sub-etp-checkPwdSyncStatus:
![[./_resources/FCPS_Password_Sync_Validation.resources/sub-etp-checkPwdSyncStatus.xml]]
- [x] Put the attr you are using in the filter:
![[./_resources/FCPS_Password_Sync_Validation.resources/PasswordSyncFilter.xml]]

* * *

**My VM Password check timing info:**

DEV - Started 11:49PM..... in DEV with aLL users..... Did til l1:30 - got about 65,000

\[08/26/14 16:06:53.093\]:Student-AD ST:Start transaction.
\[08/26/14 16:06:53.750\]:Student-AD ST:End transaction.

DEV speed test
\[08/27/14 01:17:47.967\]:Student-AD ST:Start transaction.

\[08/27/14 01:17:48.160\]:Student-AD ST:End transaction.

DEV 4,000
:\[08/27/14 01:31:36.184\]:Student-AD
 \[08/27/14 01:43:01.212\]

Production
\[08/27/14 04:25:21.650\]:Student-AD ST:Start transaction.
\[08/27/14 04:25:21.651\]:Student-AD ST:type(modify-entry)entry-id(392937) dn(\\T=FCPS-IDV\\O=FCPS\\OU=Students\\OU=Grades3andUnder\\CN=1657637) class-id(435) class-name(User)

DirXML Log Event -------------------
     Driver:   \\FCPS-IDV\\services\\idm\\Driver Set\\Student-AD
     Channel:  Subscriber
     Object:   \\FCPS-IDV\\FCPS\\Students\\Grades3andUnder\\1657637
     Status:   Success
\[08/27/14 04:25:22.122\]:Student-AD ST:End transaction.

Prod doing about 7,497 in an hour
