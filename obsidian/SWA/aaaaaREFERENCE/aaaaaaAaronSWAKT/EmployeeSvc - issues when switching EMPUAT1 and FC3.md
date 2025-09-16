6/6/2025 11:59:15 AM
They have us switch between environments every now and then; the issue is that when we switch, all user associations to the IDtoEmployeeSvc driver are now invalid, and all swaEmployeeSvcBaseRole and swaEmployeeElevated role attributes are invalid.

The fix is easy enough: 
1. Update the EmployeeServicesRoleMgmtDriver to contain the 4 new base roles for the new env, and deploy to QA.
2. Stop and disable IDtoEmployeeSvc, unless you want to send a bunch of events while fixing; which may be desirable.
3. 4. Delete all swaEmployeeSvcBaseRole attribute values. The EmployeeServiceRoleMgmt driver sets all base roles to correct values.
4. 5. Export all swaEmployeeElevatedRoles, send to Empsvc team: Jeff Wilton is a good choice: ask him to give the EMPUAT1, or FC3 roles, then apply them.
5. Remove all IDtoEmployeeSvc associations
6. Enable and start IDtoEmployeeSvc.
7. Push any users that specifically need to be migrated.
8. 