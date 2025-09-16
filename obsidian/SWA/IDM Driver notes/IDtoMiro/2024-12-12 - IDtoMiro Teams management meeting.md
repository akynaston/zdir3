Summary & questions for the call:


Team, here's a summary of items to cover in this call. Please feel free to add/correct my notes:

Better summary:

 - Scope
 - How to expose thorugh MyAccess
 - Changes in provisioning: yes/no vs teams selected . .
 - 



Summary:
Managing components in Miro is currently done with some Dash pages and user provisioning in MyAccess and  IDM. Teams management is purely done in Dash and is typically manually done by Miro team app owners.

The goal of this call is to talk through our intent to simplify teams membership management and move it from Dash to MyAccess.

The goal of this call is to finalize and decide the following:
1. Identify scope of Dash management items that are moving from DASH to MyAccess:
	1. We want to move team membership management from Dash into MyAccess
	2. What we are NOT moving: Teams management such as adding, renaming,  deleting teams.
3. Design how we want to expose teams management through MyAccess.
	1. There are 253 teams in Miro as of December 10th, and we don't want to expose all of them.
		1. They were imported from many personal boards when a full miro licence was purchased by SWA.
	2. We've discussed bringing in all teams above a certain threshold . .maybe 50 members? 100?
	3. Do we need to be able to produce a MyAccess role import file on a regular basis to keep the manageable teams listed in MyAccess? 
		1. If so, what would this file look like?
		2. Theoretically, we could build it from a SCIM API groups dump response . .though need to confirm this is desirable.
	4. The driver would benefit from receiving both the team name, and the team ID.
4. Discuss changes in provisioning/deprovisioning:
	1. Right now MyAccess provisions users when they request Miro Access. Do we need to change this to require that users request a TEam in MyAccess before provisioning? 
	2. Should the removal of the last MyAccess-exposed team result in an IDM driver deprovision the user?
5. Schedule a time for the Dash team to disable and/or redirect teams membership management to MyAccess assuming this is required/desired.