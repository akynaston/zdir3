Status report for week ending 9-12

Yvonne,

Here's our weekly status report:

MyAccess:
  - Mike has the collection done for both FrontDoor and TargetProcess. 
  - He's needing to expose more roles and configure them; and we found out today that the app owner wont have the final list for several weeks!
  - I sent a big email regarding our meeting today with all the gory details if you're curious.
  - I have deployed the latest drivers into QA to enable some simple end-to-end testing when Mike is back home.
  
IDtoApptionFrontDoor: Driver is complete; waiting on end to end testing with MyAccess. (NO CHANGE)
IDtoApptionTargetProcess: Driver user create, matching, and update is complete, the first of two deprovision use cases is complete.

Items still need to be resolved:
 - The TargetProcess API oddly has the api token in clear text on the URL which is a major security issue. We've reported it to the app owner, but don't have a solution to this yet. 