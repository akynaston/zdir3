6/10/2024 5:03:39 PM
dxcmd - tried to dump cache from a driver; asked for 999999999 events . .whoops - server ran out of heap space ,and all drivers started having issues; shutting down edir now . .

Log from today:

w11dcledirdi019
 - Attempted to backup IDtoSprinklr cache, 2:35 - did dxcmd dump of like 999999 events; appears to be no early breaks; and server ran out of heapspace.
 - Found edir fail.
 
- about 5 - restarted edir on 19: Saw this after restarting

Select a driver

    driver name                    start option     state
    ================================================================
 1: EmployeeServicesRoleMgmtDriver Auto             Running
 2: IDtoAtlassianCloud             Disabled         Stopped
 3: IDtoAvioBooks                  Auto             Running
 4: IDtoAWSIDC                     Auto             Running
 5: IDtoCargoPricing               Auto             Running
 6: IDtoCyberArk                   Auto             Running
 7: IDtoDocuWare                   Auto             Stopped
 8: IDtoEmployeeCarePicture        Auto             Running
 9: IDtoEmployeeSvc                Auto             Running
10: IDtoGitLab                     Disabled         Stopped
11: IDtoiManage                    Auto             Running
12: IDtoKronos                     Disabled         Stopped
13: IDtoMiro                       Auto             Running
14: IDtoSAPBrim                    Auto             Stopped
15: IDtoSlack                      Auto             Running
16: IDtoSOAR                       Auto             Running
17: IDtoSprinklr                   Disabled         Stopped
18: IDtoWFM                        Auto             Running
19: IDtoWiseLeap                   Manual           Stopped
20: RBEAEv1                        Auto             Running
21: Role and Resource driver       Auto             Running
22: RoleManagementDriver           Auto             Running
23: Test Resource Assignment       Auto             Running
24: User Application Driver        Auto             Running
25: zApproved                      Manual           Stopped
99: Exit

Enter choice:

some still bad; disabled -> back to auto/manual as listed, then drivers tarted:


 7: IDtoDocuWare                   Auto             Stopped
14: IDtoSAPBrim                    Auto             Stopped
19: IDtoWiseLeap                   Manual           Stopped
25: zApproved                      Manual           Stopped


6/10/2024 5:21:12 PM- done