5/15/2024 12:45:49 PM
IDtoMiro

Recently had a review meeting regarding some of the following points that I at least need to document in the IDtoMiro driver page, and one item may require a code update and redeploy.


  1 - Conversion From contractor to employee or back:
    Notes so far: Hallie lets both accounts create; then manually "merges" the acounts together.

    Next action: Sounds like I just need to document that this is a manual merge process for now, and we're done on this one.
      Hallie: correct - deactivate to repoint the data - transfer all data from old to new.


  2 - On termination: The driver should be treating a swaStatus -> T, as a deprovision.
    STATUS: Terminations generally should trigger a deprovision in IDM drivers - do any of you have concerns or an opinion on this?

    Next action - Add a termination -> deprovision policy to the driver, and redploy.
       - Yes: 660 curently here: Andrea
       -

    Follow on to #2:
      - Since I haven't been deprovisioning users on a terminateion, I suspect we have at least a handful of users in production that have been terminated in IDV that need to be deprovisioned from Miro.
      - Do any you know if this is the case? What do you do today for terminated accounts?

      Next action: Not known.
         - Andrea - meeting to have them mass delete: next week or so to see if this is an option.
         - note: not 'deleting' - just 'deactivating' and what happens with data.
           - Goal: change licencing . . deactivated status with no licence.
            main issue: 5K licences total avaiable, but above 4K now with all the users!
            - IDtoMiro deprovision is a deactivation . . may still need to consider licences . .
              - See if we can clear a licence in the user . .
           -


  3 - What do we do with accounts on leave of absence? I don't believe we process this; just need to confirm.
    Next Action: Document this: no action taken here.

Team, here's a status and items we discussed from today's call:



1 - Contractor to employee and employee to contractor conversions are a completely manual process.
    Next action: We just need to document this in the IDtoMiro driver page.



2 - The IDtoMiro driver is not currently deprovisioning users on a terminate. To resolve this, we have a code fix, and a step to resolve the users that are currently left over in Miro for terminated accounts.
    Next Actions:
      1 - Code fix: We need to send a 'deprovision' on a terminate (when swaStatus changes to T). This deprovision the driver does through the SCIM api does appear to deactivate the licence: https://help.miro.com/hc/en-us/articles/360025025894-Deactivated-users#:~:text=In%20this%20case%2C%20the%20boards,applied%20to%20another%20active%20user, see the note that deactivation also includes the deactivation of license: You can deactivate a user at any time. When you deactivate a user, they're moved from an Active to a Deactivated state and stop consuming a license.
      2 - Current terminated users fix: Andrea has a pending meeting with Miro to see if we can mass-delete and/or mass-deactivate licences for the 600+ accounts that are in this terminated but not cleaned up state.



3 - We do not do any processing for users on leave.
  Next Actions:
     - document that there is no actions taken when users go on leave.



Stories needed:
1 - IDtoMiro - Make a policy update to deprovision users when they are terminated.
2 - IDtoMiro - Make a policy update to deprovision users when they are terminated QA
3 - IDtoMiro - Make a policy update to deprovision users when they are terminated Prod
4 - Cleanup of existing terminated accounts.




5/15/2024 3:46:31 PM
New items: cacerts reliance?

Tried removing; and it sent this out:

![[Pasted image 20240515154635.png]]

IDtoMiro:
   - I have an automated process process that calls your SCIM api, and I neglected to send a delete call whenever users are termianted in our eDirectory tree this means we have around 600 users in Miro that we now need to deprovision/delete - or at least clean up.
   - month old . .
   Tom Godlewski
   Andy Fang
  - I have two items I need to take care of in my driver.
  - As long as users provisioned through SCIM, then miro - appsociated to idp . .
  Andrew Fang
  **- deprovisiong would deactivate the user - and users licences . .
  - default: scim: deprovision: user gets deactivated
     - ownership of boards stay with the deactivated user; by default.
     - If decide to delete the user: completely deletes the user from deactivation
     - Automatically reiassigneds all content to oldest admin on the account.
     - content lifecycle:
       * - 1 - Simplest: keep user deactivated with content owned by users (most traditional)
         - just deactivate the acount, enough boomerang . .



1 - We want to just deactivate users:
   - 1 - Free up the license
   - 2 - NOt deleting because we still want the content to stay with the deactivate users.

   - Ownership enhancements: UI can set this . .
     - Extended 'C . . .' admin permissions: can automate/configure how the content will be reassigned.
   - 'Content Admin': Gives access to team admins, per user basis.
     - in their own teams, perform actions on behalf of users . .
     - Andrea: minor for now; can just be reactive for cleanup . .

    - Sharing settings for deactivated users - doesn't affect other users if already shared properly
     - e.g.: board editors can help manage this.

Questions left over:
1 - We need to identify terminated users . .
  1 - List all users in Miro.
  2 - Identify users that have been terminated to comeup with a list of users to deactivate in Miro.
  3 - Produce an API call per user that can deactivate the target user.
 Andrea: - LIcence type moves back to 'free restricted'?
 - If we deactivate: does it change lience type?
 - State of "licence type" DOES NOT NEED TO CHANGE! - licence count would be properly updated.

 - As long as users synced up to 'provider'
   - if the user was manually added; needs to be a "push"
   - since not all users wwere pushed by the driver
 - Andy: Can Miro support team provide deacitavtion of users?
   - one-time syncup within miro?
   - This can be done . .
   - email field used as unique: once synced . .
   -











Question:
   - once the driver has deactivate -
     -


 - EXAMPLE: Okta - does this through group management . .





TODO ITEMS:

 - Update the driver to begin deactivating users that are terminated

Cleanup:
1 - List all 'Active' users in Miro
2 - Identify users in that list that have been terminated to comeup with a list of users to deactivate in Miro.
   - Maybe subtract off the users from eDirectory
3 - Produce an API call per user that can deactivate the target user.
4 - Have Andy and team do final review if there is any more cleanup.
 - Before we hit licence limits . .



Question: Can I assume that if a user doesn't appear in eDirectory by email address, then they have been deleted?
  We think this is afe . .5/22/2024 1:44:55 PM




7084 (42 different from Andy; confirmed it)
5891 active
1193 incative


Retrieve all 5891 active users by email:
   - Any users that don't appear in eDirectory should be 'deactivated' in Miro.
   - Confirm 'delete' in SCIM shim translates to a deactivation.
 -

Summary from our meeting:
 - We discussed the following context: As of now, there are 7084 users in Miro. 5891 of them are currently active; and we suspect around 600 of these users need to be deactivated as the users have since been terminated. This means we have three activites to resolve this.

 1 - Update the IDtoMiro driver to begin deactivate users upon termination.
 2 - Identify the 600 or so users, then send a SCIM call to deactivate them.
 3 - Notify the Miro team to see if we need to do a push from the idp to further align users that may have been provisioned outside of the driver.




