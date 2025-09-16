
1/10/2024 8:26:35 AM
RITM9588566 - https://southwest.service-now.com/sc_req_item.do?sys_id=d846459787afb9105542a9773cbb3562&sysparm_view=NULL
     - rename IDtoAvioBooks -> IDtoAvioBook
     - 1/10/2024 8:46:11 AM- reported complete.
     - 1/10/2024 8:47:53 AM - confirmed done.


1/17/2024 3:23:56 PM
RITM9515901 - create new swaMCLPassportExpirationReported in DEv.
https://southwest.service-now.com/sc_req_item.do?sys_id=64d51b37978339545dbf7cd11153af3d&sysparm_view=NULL



RITM9760865 - request to create MCL IDM Driver CI
https://southwest.service-now.com/nav_to.do?uri=sc_req_item.do?sys_id=e4f15826876c069076e9ca27dabb35be%26sysparm_view=NULL


[RITM9819209](https://southwest.service-now.com/sc_req_item.do?sys_id=2fab21abc3f8ce14c1a6f2bdc00131c3&sysparm_view=NULL) - request to create ritm for IDtoDocunet

[RITM9819350](https://southwest.service-now.com/sc_req_item.do?sys_id=f2857563c3300254c1a6f2bdc0013187&sysparm_view=NULL) RITM for IDtoAltea

[RITM9819388](https://southwest.service-now.com/sc_req_item.do?sys_id=b2e77defc3300254c1a6f2bdc0013132&sysparm_view=NULL) RITM for AlteaOfficeDBtoID

[RITM9819402](https://southwest.service-now.com/sc_req_item.do?sys_id=5a09fdabc3700254c1a6f2bdc0013129&sysparm_view=NULL) RITM for IDtoAlteaSignDB


3/14/2024 5:21:17 PM

[RITM9825801](https://southwest.service-now.com/sc_req_item.do?sys_id=b4595444c3498a54c1a6f2bdc0013186&sysparm_view=NULL) to add README.md to newconnector repo


3/26/2024 1:08:18 PM

[RITM9866147](https://southwest.service-now.com/sc_req_item.do?sys_id=9b72ddfb874d0e145b77337d0ebb35b2&sysparm_view=NULL) RITM to request firewall rule from DEV to Vistair


4/18/2024 12:47:19 PM
[RITM9946772](https://southwest.service-now.com/sc_req_item.do?sys_id=c13aaf8733650a50e1b09a6c2d5c7b80&sysparm_view=NULL) - Requested to create swaDocunetRole.


4/24/2024 12:43:12 PM
RITMS from Mickias just now to create groups:

RITM9892886 - 	Joakim Kanaan
MOMENTS_IF_FRONTLINE

(&
    (swaDeptCode=04)
      (|
        (swaWorkClassification=USA_WF_ONSITE)
        (!(swaLocation=HDQ))
    )
     (|
        (wd-ManagementLevel=Supervisor_Team_Lead)
        (wd-ManagementLevel=Manager)
        (wd-ManagementLevel=Assistant_Manager)
        (wd-ManagementLevel=Senior_Manager)
    )
)

230 users -- 203 users in excel

RITM9892885 - Danny Kearney
MOMENTS_IF_CORP

(&
    (swaDeptCode=04)
    (|
        (swaLocation=HDQ)
        (!(swaWorkClassification=USA_WF_ONSITE))
    )
    (|
        (wd-ManagementLevel=Supervisor_Team_Lead)
        (wd-ManagementLevel=Manager)
        (wd-ManagementLevel=Assistant_Manager)
        (wd-ManagementLevel=Senior_Manager)
    )
)

59 results---- need to find 44 result

RITM9892883 - Juan Alonzo
MOMENTS_IF_CORP_DIR
(&
     (swaDeptCode=04)
    (|
        (swaLocation=HDQ)
        (!(swaWorkClassification=USA_WF_ONSITE))
    )
    (|
        (wd-ManagementLevel=Director)
        (wd-ManagementLevel=Managing_Director)
    )
)

5 users found -match good

RITM9892880 - Danny Kearney
MOMENTS_IF_BASE_COORDINATOR

(&
    (swaDeptCode=04)
    (swaTitleDesc=Base Coordinator)
)

57 users--good match

RITM9892879 - Monique Rodriguez
MOMENTS_FO_CORP_MGR

(&
    (swaDeptCode=01)
  (|
        (swaLocation=HDQ)
        (!(swaWorkClassification=USA_WF_ONSITE))
    )
    (|
        (wd-ManagementLevel=Supervisor_Team_Lead)
        (wd-ManagementLevel=Manager)
        (wd-ManagementLevel=Assistant_Manager)
(wd-ManagementLevel=Senior_Manager)
    )
)

72 users --66 users found in excel

RITM9893862 - 	Danny Kearney
MOMENTS_FO_CORP_DIR

(&
    (swaDeptCode=01)
    (|
        (swaLocation=HDQ)
        (!(swaWorkClassification=USA_WF_ONSITE))
    )
    (|
        (wd-ManagementLevel=Director)
        (wd-ManagementLevel=Managing_Director)
    )
)

14 results found --result ok

RITM9893863 - 	Hector Meza
MOMENTS_FO_BASE_COORDINATOR
(&
    (swaDeptCode=01)
    (|
        (swaTitleDesc=Crew Base Coordinator)
        (swaTitleDesc=Sr Crew Base Coordinator)
    )
)

33  users found---good

RITM9893866 - 	Juan Alonzo
MOMENTS_CSS_CORP_DIR


(&
    (swaDeptCode=99)
    (|
        (wd-ManagementLevel=Director)
        (wd-ManagementLevel=Managing_Director)

    )
)

5 users --validated and ok

RITM9893934 - 	Juan Alonzo
MOMENTS_CSS_CORP_MGR
(&
(swaDeptCode=99)

    (|
        (wd-ManagementLevel=Supervisor_Team_Lead)
        (wd-ManagementLevel=Senior_Manager)
        (wd-ManagementLevel=Manager)
        (wd-ManagementLevel=Assistant_Manager)
    )
)

230 users--- 222 users in excel


RITM9893935 - Juan Alonzo
MOMENTS_CARGO_LDRS_FLINE


(&
    (swaDeptCode=57)
      (swaWorkClassification=USA_WF_ONSITE)
      (!(swaLocation=HDQ))
     (|
        (wd-ManagementLevel=Supervisor_Team_Lead)
        (wd-ManagementLevel=Manager)
        (wd-ManagementLevel=Assistant_Manager)
        (wd-ManagementLevel=Senior_Manager)
    )
)

66 results found -- 63 results in excel

RITM9893936 - Juan Alonzo
MOMENTS_TO_LDRS_FLINE
(&
    (swaDeptCode=02)
      (swaWorkClassification=USA_WF_ONSITE)
      (!(swaLocation=HDQ))
     (|
        (wd-ManagementLevel=Supervisor_Team_Lead)
        (wd-ManagementLevel=Manager)
        (wd-ManagementLevel=Assistant_Manager)
        (wd-ManagementLevel=Senior_Manager)
    )
)

482   results found -- 474 found in excel

RITM9894335 - Suryaprakash Challagundla
MOMENTS_NOC_DIR

(&
    (|
        (swaDeptCode=25)
        (swaDeptCode=17)
    )
    (|
        (wd-ManagementLevel=Director)
        (wd-ManagementLevel=Managing_Director)
    )
)

20 results found -- 19 results except e115834


RITM9894337 - Hector Meza
MOMENTS_NOC_MGR

(&
    (|
        (swaDeptCode=25)
        (swaDeptCode=17)
    )
     (|
        (wd-ManagementLevel=Supervisor_Team_Lead)
        (wd-ManagementLevel=Manager)
        (wd-ManagementLevel=Assistant_Manager)
        (wd-ManagementLevel=Senior_Manager)
    )
)

65 results found -- 64 results in excel

RITM9894338 - David Rosales
MOMENTS_CREW_SCHED_DIR
(&
    (swaDeptCode=77)
    (|
        (wd-ManagementLevel=Director)
		(wd-ManagementLevel=Managing_Director)
    )
)

4 results -OK


RITM9894339 - 	Claudio Reyes
MOMENTS_CREW_SCHED_MGR

(&
(swaDeptCode=77)

    (|
        (wd-ManagementLevel=Supervisor_Team_Lead)
        (wd-ManagementLevel=Senior_Manager)
        (wd-ManagementLevel=Manager)
        (wd-ManagementLevel=Assistant_Manager)
    )
)


71 results -- 69 results in excel
has context menu


has context menu


4/29/2024 9:18:29 PM
RITM to fix gitlab mfa . .
|[RITM9983003](https://southwest.service-now.com/sc_req_item.do?sys_id=51fa7d32c3fd461482de35fdd401313f&sysparm_view=NULL)|


6/7/2024 11:58:31 AM
REquest to decommissino altea:
RITM10134321
Details:
The cn=Altea,cn=SDC Driver Set,ou=DirXML,ou=Services,o=SWA-ID driver is an old driver and should be decommissioned (deleted). 

 - The driver has been backedup from the latest code base in production (this backup commit is here: https://gitlab-tools.swacorp.com/csiam/idm/Altea/-/tree/df2ebf4f0f2dc41d7bcaba24c42530f6967121c6)
 - We may want to delete the associations for this driver before deleting it; and this process likely should be done after hours as it will remove the association for all users that still have it.
 - I'll submit another RITM for the archiving of the repo.

6/7/2024 12:06:09 PM
REquest to archive repo:
[RITM10134357](https://southwest.service-now.com/sc_req_item.do?sys_id=6950c19347628e9c567de1b4236d4325&sysparm_view=NULL)
Target repo:
https://gitlab-tools.swacorp.com/csiam/idm/Altea

6/25/2024 2:54:53 PM
[RITM10202847](https://southwest.service-now.com/sc_req_item.do?sys_id=6f53524d338b0650ca399aa13d5c7bde&sysparm_view=NULL) - Created to get merge rights to https://gitlab-tools.swacorp.com/csiam/idm/rbeaev1/-/merge_requests/11

7/9/2024 12:09:08 PM
 RITM10253174 - Request to delete IDtoAvioBookNoAutoRoles repo.l



7/30/2024 12:10:23 PM
RITM10333658 - create IDtoMiro CI



8/6/2024 2:01:16 PM
[RITM10365098](https://southwest.service-now.com/sc_req_item.do?sys_id=781a16ea473fc2985f488f2f016d4346&sysparm_vie - w=NULL) - submitted to fix newdriver tempalte repo to let us have rights to master to let us merge
 - 8/13/2024 12:12:49 PM - Saulo Oliva fixed it by setting rights to merge from Maintainers -> Developers & Maintainers
- 8/13/2024 12:15:47 PM


8/13/2024 12:15:49 PM
|[RITM10392516](https://southwest.service-now.com/sc_req_item.do?sys_id=ea05c6b8930c5a5c9bcd73647aba10f1&sysparm_view=NULL)|| Request to delete https://gitlab-tools.swacorp.com/csiam/idm/rightstomergetestrepo, the repo I just used with Saulo Olivia to test merge ability - looks like it mvoes to here when deleted:  git@gitlab-ssh.apex-tools.prod0.prod.aws.swacorp.com:csiam/idm/rightstomergetestrepo-deleted-160556.git, then two days later it is actually removed, per a timestamp on the repo page.

9/12/2024 1:38:19 PM
RITM10488339 - RITM to get rights to merge to master on IDtoBrowserStack.


9/13/2024 12:58:04 PM
RITM10483761 - swaBrowserStackRoles, CIS multivalued
RITM10491757 - swaBrowserStackIsAdmin boolean.

9/23/2024 4:17:15 PM
Just created the new CI: IDtoBrowserStack.
[RITM10521550](https://southwest.service-now.com/sc_req_item.do?sys_id=c2754e0647f812503df5de5a436d432b&sysparm_view=NULL)

10/2/2024 10:25:14 AM
(MISTAKE, didn't put in proper name: )RITM10555399 new ci IDtoSprinkler.
[RITM10555434](https://southwest.service-now.com/sc_req_item.do?sys_id=6b1d87b4930d5a543c5b75ea6aba1096&sysparm_view=NULL)


10/9/2024 3:58:30 PM
[RITM10521550](https://southwest.service-now.com/sc_req_item.do?sys_id=c2754e0647f812503df5de5a436d432b&sysparm_view=NULL)  - remove swaBrowserStackIsAdmin - can't use it, myaccess can only set one attr at time, so just using swaBrowserStackRoles.

10/22/2024 5:43:28 PM
REquest to add a commit to create the default 'master' branch on https://gitlab-tools.swacorp.com/csiam/idm/common/app-as-id-data-files
[RITM10630062](https://southwest.service-now.com/sc_req_item.do?sys_id=195fa39bc315525078ce3fff050131bf&sysparm_view=NULL)

11/12/2024 11:46:34 AM
[RITM10698327](https://southwest.service-now.com/sc_req_item.do?sys_id=ebb47a4e473dd21c567de1b4236d4324&sysparm_view=NULL)
 - This RITM is my idotoducnet ufm ritm request. . .doh forgot this part:
 - 


_Please enable log monitoring on the host above_

_The log to be monitored is located in **/opt/UFM/bin/alert.log**_

_The format of the log entries are as follows:_  
_[<date> <time>][<severity>][<component group>][<component name>][<hostname>][<summary>;<description>]_

_Please adjust the severity of the INC generated based on what is described in the [severity] section of the log message._  
_For the incidents "Short description" use "UFM CLIENT ISSUE: $hostname + $summary" if possible._  
_Use the entire log entry for the incidents "detailed Description"_  
_If an INC is already open with the same Short Description, please do not open another_

_A sample log entry for each severity is below_

_Low:_

_[2019/11/14 13:32:36.497][Low][example-dashgroup][UFM-v249:appName=geese:ft-geese-null-dev1-consumed-interval-test-send.log][xldjms01][geese (swacat) s3Put_cyberark_fail;22 - APPAP292E Unrecoverable error previously occurred. Avoiding approach to the Vault.]_

_Medium:_  
_[2019/11/14 13:32:36.497][Medium][example-dashgroup][UFM-v249:appName=geese:ft-geese-null-dev1-consumed-interval-test-send.log][xldjms01][geese (swacat) s3Put_cyberark_fail;22 - APPAP292E Unrecoverable error previously occurred. Avoiding approach to the Vault.]_

_High:_  
_[2019/11/14 13:32:36.497][High][example-dashgroup][UFM-v249:appName=geese:ft-geese-null-dev1-consumed-interval-test-send.log][xldjms01][geese (swacat) s3Put_cyberark_fail;22 - APPAP292E Unrecoverable error previously occurred. Avoiding approach to the Vault.]_

11/13/2024 9:53:40 AM
RITM10703137 - request to delete: https://southwest.gitlab-dedicated.com/csiam/idm/aarons-deleteable-test-project