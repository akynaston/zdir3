2/25/2025 10:36:16 AM

Joe, call about git flow
   - Deciding when to do that first MR has been a big pain for a while . . the IGA team hasn't had to do a lot of new stuff; so I don't think it's gotten a lot of attention.
   - Up to this point, I suppose I just defaulted to having a fully working version of the driver that was able to go to production; but yes, it is a huge nearly unmanageable MR to review. We just about need to break it up into separate MRs like this:
   1 - MR: Initial vanilla driver, deletion of default sample files + build run to have a final/* folder as well.
   2 - Introduction of test idmunit-config.xml file, for at least DEV, QA (optionally ALPHA) along with proper AWS references to passwords stored there.
   3 - Test MR: spreadsheet, and Java runner containing passing tests + build to have a set of JSON files recording the state of the tests.
   4 - Pipeline configuration: Pipeline should be able to properly deploy the driver and pass tests in all listed environments.
