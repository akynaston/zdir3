
3/24/2025 11:55:41 AM
 todo list
done - Create 6 stories
 - EmployeeServicesRoleMgmt driver:
   - Research to see if 23 -> 7 would affect a lot of people: job prifle code: 955E
     3/24/2025 11:55:48 AM - currently no one in jobcode=955e, swaDeptcode - 0 results: (|(&(swaDeptCode=23)(jobcode=955E))(&(swaDeptCode=23)(swaTitleCode=955E)))
   - do deptcode change
   - maybe see if retiree fix can be added . .but don't do init mig et . .
 - Autocrib: call Sean and see if we can chat multisite design.
 - IDtoAviobook
   - Finish test, confirm dev tests pass, qa test pass locally.
   - get MR aprpoved.
   - deploy to pipeline


(|
    (&
    (swaDeptCode=23)(jobcode=955E)
    )
    (&
        (swaDeptCode=23)(swaTitleCode=955E)
    )
)




QA (RBEAEv1\auxiliary\Entitlement Policies.ldif) is the file with all entitlements. it needs to be updated

Story 1: Update the entitlement policy queries to use the new codes.
   Story 2: Deploy to QA in such a way that doesn't cause a full reevaluation (RBEAev1 driver); but just a review of the updated values.
   Story 3: Deploy to prod; again need to be careful with the RBEAev1 driver.










    EmployeeServicesRoleMgmtDriver/exports/EmployeeServicesRoleMgmtDriver.xml:                                            <if-op-attr mode="regex" name="swaDeptCode" op="equal">~gcv_Emp_SVC_HR_Dept_Code~</if-op-attr>




    EmployeeServicesRoleMgmtDriver/exports/EmployeeServicesRoleMgmtDriver.xml:                                            <if-op-attr mode="regex" name="swaDeptCode" op="equal">~gcv_Emp_SVC_HR_Dept_Code~</if-op-attr>
    EmployeeServicesRoleMgmtDriver/exports/EmployeeServicesRoleMgmtDriver.xml:                                    <if-attr mode="regex" name="swaDeptCode" op="equal">~gcv_Emp_SVC_HR_Dept_Code~</if-attr>
    EmployeeServicesRoleMgmtDriver/exports/EmployeeServicesRoleMgmtDriver.xml:                                    <if-attr mode="regex" name="swaDeptCode" op="not-equal">~gcv_Emp_SVC_HR_Dept_Code~</if-attr>







Dhivya, I'll be creating these six stories, then send you the links:

Re-org stories:
  - EmployeeServicesRoleMgmtDriver
     - update department codes as appropriate.
     - I think I should probably not include the CSEE-4261 retirement fix, as it could change up to 4200 retirees and would be too much ti pick up for now.

  Story 1: Update job codes as appropriate; update tests as needed. Schedule QA/prod deploys.
  Story 2: QA deploy
  Story 3: Prod deploy

   - AvioBook role update:
    Entitlement policy changes.

   Story 1: Update the entitlement policy queries to use the new codes.
   Story 2: Deploy to QA in such a way that doesn't cause a full reevaluation (RBEAev1 driver); but just a review of the updated values.
   Story 3: Deploy to prod; again need to be careful with the RBEAev1 driver.


3/31/2025 1:37:12 PM
Just deployed re-org fix, here's the query to find users with the wrong role:

(&
    (|
        (cn=r0*)
        (cn=r1*)
        (cn=r2*)
        (cn=r3*)
        (cn=r4*)
        (cn=r5*)
        (cn=r6*)
        (cn=r6*)
        (cn=r7*)
        (cn=r8*)
        (cn=r9*)
    )
    (!(swaEmpSvcBaseRole=EmployeeSvc_Retiree*))
    (!(swaEmpSvcElevatedRole=*))
)




































