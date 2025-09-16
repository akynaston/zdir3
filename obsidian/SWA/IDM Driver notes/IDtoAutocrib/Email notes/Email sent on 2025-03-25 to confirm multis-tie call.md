Aaron Kynaston (Contractor)

Sean Lockard;
Grishma Subbaiah Bittianda;
Stephanie Smith;
Yvonne Umeh;
Akilan Rajendran (Contractor);
Jeevan Gogineni (Contractor);
Dhivya Balasubramanian
Team,

For our discussion this morning, we discussed the following:

 - There isn't a clear way to determine multi-site users by data alone.
 - The need for multi-site provisioning requires on on-demand format, so we've decided to move the dbid selection to MyAccess.
 - To expose all sites and all roles, there will need to be 13 * 6 roles, or 78 total items to chose from. We've discussed the following format shown here. Note that the MyAccess team will be consulted to confirm our format will work:
    TPA - Autocrib-AMT
    TPA - Autocrib-AMTSUPP
    - and so on, for a total of 78 options.
 - All accounts that a user has in autocrib will reman active until the user is deprovisioned per one of our deprovision use cases as described here: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/419594271/IDtoAutocrib.
 - We discussed that users will likely not differ in role across sites, as users typically will have a single designated role that will be reflected in each of their Autocrib  accounts.
 - Multi site users will be taken care of manually until we can update the driver. Note these users permissions will be updated to match the standard roles when the user requests their role from MyAccess.

Subsequently, Sean has also confirmed that a user may need to be in all 13 locations; so multi-site user support should be able to scale that far.

Action items:
   - Add Dallas to AC: 
     - Status: Done.
   - Ask regarding licencing: per user, or per site? both? 
     - Status: Question asked through email.
   - Akilan about role owners, and other requirements he'd have for managing 78 items in MyAccess.
     - Status: in progress.
   

--Aaron