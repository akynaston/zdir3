Stephanie: just wanted to pass on an item of clarity: whenever we pick up an older driver; we may want to dedicate an additional 'baseline' story that should occur very first, even before development begins.

2/21/2024 4:57:03 PM
IDtoDocunet - As always I need the tests to be rock solid - especially in a case where I"m changinng the shim. IN a perfector world, the work I just did would have been already done by the last engineer, if we had all of the process up to speed back then.


case in point: took me 3.5 hours to find the Comply365 


Items learned/clarified:
1 - When we pick up an old driver to work on it for any reason; we may need to dedicate a story to baselining the driver before we can even begin our work. This is a very normal regular thing to do right? when pulling in the driver; theoretically the tests should pass with very little effort; assuming the last guy had clean commits, and put everything in order. Cleaning up after the last devloper can be a big pain.



Details:
  - Any time we need to pick up an old driver; there is most likely more work than expected:
   - 1 - the tests need to be baselined under the latest gradle build.
    - This means that the configuration to connect to downstream applications is likely missing or wrong; need to resolve with the app teams.
    - substitutions used in the spreadsheet don't match the config since we didn't used to include this.
       - ** if idmunit-config.xml isn't commited in git, we have to search for values.
    - We need to update the tests and build framework to gradle: So far, this is the only true sustainable modle we've had around driver development that ensures all driver related data is in the repo, and all passwords are in a secure and securely retrievable place.

