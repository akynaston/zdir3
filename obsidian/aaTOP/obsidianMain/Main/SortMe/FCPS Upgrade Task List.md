# [FCPS] Upgrade Task List

**Things to find out:**
- [ ] Glen FCPS 4.5 Licenses?
- [ ] Checklist says 8.8.4 with the IDM Upgrade..
- [ ] Investigate - Password Filter Update?.

**Steps:**
- [ ] Snapshot the VM
- [ ] Upgrade to SLES 11 SP3 -  Upgrade path to SP3: <https://www.novell.com/support/kb/doc.php?id=7012368> -  Done: SLES 11 SP3: <https://www.netiq.com/documentation/idm45/setup_guide/data/b194dddx.html>
- [ ] Upgrade eDir to 8.8.3 (8.8.4 changes java dir, not doing now).
- [x] Upgrade Designer.
- [ ] Upgrade IDM Engine (Including Driver Shims)
- [ ] iManager Uninstall the old version
- [ ] iManager Install the new Version

- [ ] IDMUnit - Run Tests

* * *

![[./_resources/FCPS_Upgrade_Task_List.resources/IDM 4.xls]]

* * *

\>>> Glen Knutti 4/1/2015 11:50 AM >>>

Kathie,

Sorry, the morning got away from me, but I'm getting really hungry now so I have to finish this! Here are the estimates we've put together...

IDM 4.5 Upgrade Estimate - 475 hrs

\-We've already done the eDir 8.8.8.3 upgrades in DEV and TEST

\-We've already begun working on the TriVir VM tasks

\-We've estimated 24 hrs to move your User App items into IDM Home and estimated 80 hrs to perform that work, but the research will really determine the effort to make the switch. This is the biggest effort of the upgrade.

\-We'll be running IdMUnit tests along the way to make sure we're solid in each environment. This will take a little time, but it's worth the confidence, I think.

r45 Estimate - 178 hrs

\-We have estimated 13 of the 20 items at 134 hrs

\-We have 7 of the 20 items that are estimated at 44 hrs of research in order to determine the full scope of the required change/update. That means that we anticipate additional hrs to complete these 7 items, but we're unsure of that effort until the research is done on those items. So the total r45 estimate could grow to 200 or more depending on the results of the research.

I've attached the spreadsheets we've been working with so you can see the details of where the numbers come from. Please let me know if you have any questions. I'm sure we'll be talking soon to figure out the timing of everything!

Thanks,

Glen
