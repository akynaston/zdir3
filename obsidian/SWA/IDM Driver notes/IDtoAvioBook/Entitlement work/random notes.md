

6/12/2024 3:31:05 PM
Kyle chat - from above items learned
   - Myaccess route? Why did it get slow/crash/etc?
   - We collect groups in AD as the entitlements.
   - We would collect roles as entitlemnet for aviobook.
   - App aviobook -
   - MyAccess - sceanrion
   - Kyle wnats to chat talking with Baron - wants to revisit the myaccess roadblocks.

Joe
  Routes:
   1 - RBE + LDIF
    Workable . .but messy & manual
    Scenario: say we deploy . .
       - AvioBook: says we need to make change . .
       -
   2 - MyAccess long term? why did it fail in the first place?
   3 - Internal driver lookup table.
     - Solves Joe's SOAR problem . .
     - issue: management of it thorugh swa processess . .
     - Change requires CR . .
     -

joe frustration:
   - Customer needs to make a change to role . .
   - needs to make our life easier here: RBE may work; but takes more work than an IDM table despite it being part of the driver . . .
   - need to do scale test . . 12K for aviobook . .everyone needs SOAR . 90K . .
   - Use case discussion:
     - Create a CR to change entitlenet plicy?

Takeaways:
   - If RBE doesn't streamline vs driver/mapping table.
    - CORE: Ability to make changes?? CR - just add RBE . . & export new policy . .
    - don't necessarially need to import the export . .
   - Do scale testing: see all get avio_pilot (disable driver right now)
   - Rever to Pilots_D in aviobook documentation!
   - normalizer: LDIF

