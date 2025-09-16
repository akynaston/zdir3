Driver is in prod already as of a few months ago, but we ran into a few items which ALL need to be documented, and possibly have driver fixes too:


5/1/2024 3:46:33 PM
MIRO
 - We need to at least document the following scenarios I missed on the IDtoMiro driver.  Then, we should ask Hallie Greenwalt if she had expected the driver to be doing more on these items:
  1 - Converstion From Contarctor to employee;
    Notes so far: Hallie lets both accounts create; then manually "merges" the acounts together.
  2 - On termination: The driver should be treating a swaStatus -> T, as a deprovision.
  3 - What do we do with accounts on leave of absence? I don't believe we process this at all; just need to confirm.
  4 - At some point, we likely need to remove users from Miro that have been terminated, and no longer exist in eDirectory.
     - We should probably list all users in Miro, and delete accounts that haven't been used in a while; and/or don't have a corresponding account in eDirectory.

5/6/2024 11:40:06 AM
Passed on this info to Brad to setup a meeting.