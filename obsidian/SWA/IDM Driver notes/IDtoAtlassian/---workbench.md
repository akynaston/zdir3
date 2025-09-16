3/28/2025 3:31:17 PM
Notes from Nirosha's prb/conversion issue resolution call today.

3/28/2025 12:01:40 PM
Atlasian - nirosha prb
 - employees and contractors can have the same email address.
 - Conversion problem:
 - XID still hast he email address associated and blocks the EID from being granted access to email due to conflict.
 - Mike: eid changes first, email changes a week later . .
 - Gokul: idea to query existing id, and then if we have an object; see if this is a conversion.
   - compare emaila address . .
 - yatin: this story when user requests atlasian role: based on swaxid, identify account
   - if identify: update eid and email address based on that . .
     - use library
 - library: depends on email address . .
 - gokul: can't query on email address.
 - yatin: summary: if swaXID is avaialble, match with that; then repurpose the existing xid with eid data.


Just to summarize to wrap my brain around this, it sounds like during a conversion of a contractor to an employee object, we're going to rely on swaXID to match to the existing x account in Atlassian. This will allow us to realize we're doing a conversion. In summary, we'll be fully "repurposing" the existing xid account Atlassian by doing the following (not necessarially in this order):

1 - Remove old association on xid in edirectory.
2 - Add new association on the new e account in eDirectory
3 - Update the new username (x to e) on the user in Atlassian
4 - Update the email address in Atlassian, it likely will be the version '2' of the email address; but this doesn't matter, we'll keep it in sync. on a subsequent email change (if ever) we'll syncronize it as always.
5 - Since the 'trigger' event for this request began by requesting roles on a new account, we'll be removing all permissions for the XID account in Atlassian, then adding all of the new roles that were requested in this event.

Conversion complete!




Answers to questions so far:
 - We cannot query for email address in Atlassian (api limitation maybe?)


Questions still remaning to answer:
 - How to switch roles from the old xid to the new eid:
    - If XID is gone, we won't have a list of the 'old' roles to remove so:
      - Atlassian team: Can we retreive all roles (groups) from the user in Atlassian? This would help remove old xid roles on the repurposed account in Atlassian.
      - Atlassian team: Should we leave the roles there?
      - Atlassian team: When we add the new roles from the new eid, are we ok with the user having both the old xid, and the new eid roles? What should we do here?
 - On a normal termination, do we need to remove all groups?
 - Can a user exist without roles in Atlassian in a disabled state? (maybe it is simliar to gitlab where the user is essentially just a placeholder.)

More questions:
   - Do we remove all roles in eDirectory and Atlassian on a terminate/separated? (swaStatus=S|T)
   - Does the API allow us to remove all roles in Atliassian? (Nirosha to test this now, and answer Joe)
   - Confirm: do we remove all roles on an XID on a terminate?
   - Should we remove all roles on the old XID DURING the new eid hire (conversion process), if we didn't on the terminate?






