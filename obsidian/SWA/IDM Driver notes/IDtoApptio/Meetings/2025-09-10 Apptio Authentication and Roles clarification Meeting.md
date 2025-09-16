9/11/2025 9:39:44 AM

3 Items to mention, then 1 role management discussion:
* Concerns regarding the IDtoApptioTargetProcess authentication model: I recently got some push back from the core team: The API in clear text on the URL is pretty frowned on: we need to either move to Basic authentication using a username/password, or get some kind of security exception assuming everything we do is behind the firewall.
	* Ideally, we'd change to at least HTTP Basic auth if we can use a username/password.
	* If this is not possible; I'm thinking we'll need to see if it is possible to request an exception.
	* Next action: change auth method, or see if requesting an exception is an option:
		* DO: Need to have separate meeting . .

DirXML: [09/11/25 10:48:19.86]: TRACE:  IDtoApptioTargetProcess: RESTSubscriptionShim.execute() :
DirXML: [09/11/25 10:48:19.86]: TRACE:  IDtoApptioTargetProcess: addHandler
DirXML: [09/11/25 10:48:19.86]: TRACE:  IDtoApptioTargetProcess: addHandler: class-name == 'User'
DirXML: [09/11/25 10:48:19.86]: TRACE:  IDtoApptioTargetProcess: Add: preparing POST to https://southwestairlinespov.tpondemand.com/api/v1/users?access_token=NTUxOTo2UkZVUlZpUWlsMjkwZjRVM1FYY2FLelVJVVYvOFF5K2ZRRXRTcnd0QS9ZPQ==&format=json
DirXML: [09/11/25 10:48:19.86]: TRACE:  IDtoApptioTargetProcess: Setting the following HTTP request properties:
DirXML: [09/11/25 10:48:19.86]: TRACE:  IDtoApptioTargetProcess:  Content-Type:application/json
DirXML: [09/11/25 10:48:19.86]: TRACE:  IDtoApptioTargetProcess: Did a HTTP POST with 211 bytes of data to https://southwestairlinespov.tpondemand.com/api/v1/users?access_token=NTUxOTo2UkZVUlZpUWlsMjkwZjRVM1FYY2FLelVJVVYvOFF5K2ZRRXRTcnd0QS9ZPQ==&format=json
DirXML: [09/11/25 10:48:20.19]: TRACE:  IDtoApptioTargetProcess: Response code and message: 201 Created

	
* It appears TargetProcess users can only have one role at a time! For you Mike, that would mean that we'd only ever want to have one role in the swaApptioRolesTargetProcess attribute.
	* This is just to make sure we're all on the same page: if someone requests a second target process role; they'd of course lose their first one; which is not the case in FrontDoor.
	* Next action: confirm MyAccess is only sending one value (aka should be a replace, not an 'add').
		* Confirmed . . 
* Need to get approval on documentation; it's about 40% complete; but I'd value a discussion sooner than later to make sure we've covered all use cases on both the IDtoApptioFrontDoor and IDtoApptioTargetProcess drivers.
	* Next action: setup a meeting for a quick chat: we could probably do both driver docs in 30 mins, assuming we just stayed high level at the beginning.
	* 
* We have a series of questions that came up in a discussion with Mike as follows:




Rough notes with our questions: Note: we really need to cover these on the phone; I think all of them will require discussion.

1 - Which kinds of people would request roles like "Targetprocess Admin" and "Targetprocess Contributor?"
   - Isn't it an option (at least in our first release to production) to show all roles to everyone when in MyAccess and rely on role owners & managers to avoid invalid role assignments?
   - I think your main goal was to make sure that we don't lose roles for people that have them in FrontDoor/TargetProcess when requesting them from MyAccess, correct?
	   - Concerns from People perspective: we can ask for Jira Administrators . . too many . .also to high . . 
	   - Can't rely on owners of these roles . .can only have one role owner on paper . . .
	   - If missing role owner defaults to a group!
	   - Mike: confirm if we can default to a group for owner
	   - For all admin type roles: if someone requests - auto decline . . - unless role owner is requesting on behalf some one else . . .
		   - Allow ONLY role assignment if role owner on behalf . . new form and new customization . . trying to avoid this.
		

2 - We have at least two categories of roles in MyAccess that require the setting of other roles for various reasons. For example, we know of possibly two relationships. We need to define the role -> entitlement relationship, and see if there's any others that have a possible 1 to many mapping like this:

  1 - Role: "Cloudability User Access" request requires:
    1 - FrontDoor: "Cloudability User"
    2 - FrontDoor: "CloudabilityPlanningRestrictedUser"
    3 - FrontDoor: "Self-Service Reporting User"
   (this is a 1 to 3 relationship)

  2 - Role example: 'Developer - Targetprocess' user request requires:
    1 - FrontDoor: "Targetprocess User" role
    2 - TargetProcess:, ID: "1" (which means developer in this example . . ) - any role!!
  (this is a 1 to 2 relationship) 
* ANY TARGET PROCESS ROLE

Next action:
NEED 10 ROLES REQUESTABLE:
 - Need discussion on date, Ashleigh does have the list; but also switching due to info during go-live
 
  
----> Question for Mike: If a user already has swaApptioRolesMainDefault = "Targetprocess User" - I assume it won't error out as it goes to set both this value, and the new Target process role?
	 - swaApptioRolesMainDefault = "Targetprocess User" (even if they already have TargetProcess admin/contributor )
	 - swaApptioRolesTargetProcess  =  all roles
	 
  In summary: are there any other roles that have a 1 to many relationship?
 - We can expose admin/contributor - work with role owners to make sure they're declined . .



3 - Which FrontDoor and Target process roles need to be requestable?
   - I believe Mike sent an email with this question.
   - I see at least 72 roles in Targetprocess (main production), and a few in FrontDoor (getting a count is harder here)
- Confirmed . . .

  This is the total list of requestable roles/relationships we know about now as mentioned above:

  1 - Cloudability User Access (will need three application roles)
  2 - (ALL target process roles) (will need two roles, one FD, one TP)

  So for example: role "141 - "Tech - Leader" target process role - this seems like it's kind of an administrative role . .so would we add Targetprocess Admin instead of Targetprocess User? Maybe both?
	  * no: always add FD role:  "Targetprocess User"
	  * Asleigh: can we expose roles we "DONT want to expose" in another app . .?
	  * Mike: two apps? 
		  * 4 drop downs: apptio admin roles/apptio user roles . .
		  * Can put in filter for admin the users: can statically assign members to be admins; to show this. . 
		  * Yes - seems plausible . .researching . . .
	  * Need clear static list of user roles, and admin roles

NEED TO DISCUSS:
	MIKE: 46
	pov - 101
	prod - 72
	need to reconcile this	



4 - Is it possible for some one to just request FrontDoor "Targetprocess User" with no Targetprocess role?
   - I think the answer is no: Every requestable target process option will of course just be the list of target process roles.


5 - DATES DISCUSSION
	- Auto collect? YES - We can collect in the API!
	- Ashleigh:
	- Context: Manually provisioning Jira Align for 5 years . . .
		- Automating Apptio and going live does not require automation for critical path . .
		- Priority discussion: Migrate users & move to 'LIVE' - needed . .
		- Most recent golive, "Workforce Strategy" - initial roles & permissions work, but people need a combination role problem.
			- In TP: someone may need Leader AND Solution Architect
			- Can't create a custom role for every combo perspective . .
			- also can't regularly switch roles: not daily; but close to it . .
			- Trying to research this . .need to switch roles . .can't turn on MyAccess until this is solved.
			- Some managers need to take care of multiple roles of rights; . .can't seem to represent unless we create custom roles . .
			- Current impact, only 7-8 - but will increase exponentially with wave 4 - 'Initiative & epic owner is an example'
			- With such a high number of processes being moved into TP, this is now a problem . .
		- Managers: Veritas/TIR Finance/Quickbase . . too many rights/roles at the same time . .
		- Major concern: super high number of custom roles with combination of roles . ..
			- Would MyAccess be used to switch?? 
		- Major limitation: one role per-person
			- Configuration decision: made by compass group 
		- Discussion of multiple teams assigned to a user . .
			- It was decided not to do this: increases complexity too much if we modified roles on teams when it comes to LPA . .
				- Ashleigh: is ATP Admin, but member of two separate teams which can have a role assigned to them . .
		- API can handle multiple TEAMS -> Roles, but this is too complicated to manage
		- THIS is why dates are less important: roles definition and design needs to be resolved first.
		- 10/15 - original second date: No concern at the moment . .
		- Need work done; but less time sensitive . . 
	- Update/Plan: still move all the way to production asap . .
		- Shouldn't affect what we do . .
		- Less than < 0.1% chance of api change . .
	- Mike: Role switching: Ashleigh: if we can define combo roles to simplify this, can avoid switching roles . .
		- "Combo Roles": 
			- Note: in MyAccess/IDM teams
			- Example: Role 101 would still have everything needed:
	      "Role": {
	        "ResourceType": "Role",
	        "Id": 101,
	        "Name": "ATP Admin"
	      },
Mike: Roles list needed . .
	* note: concern: Mike: if we add new roles; will need to add more technical roles, to expose them in MyAccess . .
 - What is reasonable?
	 - need roles defined further . .
	 - IF more than 1 week . . . reassignment concern . . 
 Action items:
	 * Ashleigh: - backlog discussion to plan, schedule and complete the backlog combo role planning and discussion.
	 * Aaron/Mike: finish as much as we can . .
	 * Next question: once we get answers per roles; how long to pivot to this?
		 * MIke: other than the form creation, collectiing all roles . .

TODO items:
	* What's likely? estimate: two sprints (aka 6 weeks) from now - get info, then sprint to test . . . .end of the year?
	* 


	 


EMAIL SENT - 
SUBJECT: 2025-09-11 - Apptio Roles Discussion: Action items and notes 
		
		
Team,

Mike, Ashleigh and I were able to discuss a few items and start to make some plans. The major summary, is that due to an unforeseen complexity with roles, our dates are changing again. Once we've completed most of the action items below, we can come up with a new target date for completion. We may be looking at 4-6 weeks from the Apptio Team to resolve a "combo-role" issue mentioned here in the notes.

@Ashleigh, @Mike, Please let me know if changes are needed to this.

@Dhivya, we should have a brief discussion to cover which commitments are changing, and possibly update how Mike and I proceed on this project.




We discussed:

1 - Confirmed we need to resolve the API key on the url concern with the TargetProcess API, see next-action #1 below:
2 - We need to have a review of driver documentation, and confirm we've taken care of all use cases.
3 - TargetProcess roles discussion:
3a - Administrative Role exposure: we'll need to research a way to separate TP roles into two lists: Admin roles, and User roles. Research this, see next actions below. Relying on role owners & managers has been problematic at best; so can't depend on the normal route . .
3b - Role approval: can we default to a group for approval? Research this, see next actions below.
4 - One to many role relationships: There are two situations where more than one role needs to be assigned when a user requests 1 role in MyAccess:
4a - If a user requests the "Cloudability User Access" role, it needs to result in 3 FrontDoor roles:
  1 - FrontDoor: "Cloudability User"
  2 - FrontDoor: "CloudabilityPlanningRestrictedUser"
  3 - FrontDoor: "Self-Service Reporting User"
4b - When a user requests ANY TargetProcess role, two roles need to be assigned:
  1 - FrontDoor: "Targetprocess User" role (regardless of other roles, it is acceptable to add this, or let it error out if already assigned.)
  2 - TargetProcess: role in ID format, such as '1' which represents the 'Developer' role.
5 - We confirmed we see 101 TargetProcess roles in POV, 72 in production, and Mike has filtered it down to 46; so we'll need to reconcile this list, see
6 - We confirmed it is not possible to request just the FrontDoor "Targetprocess User" role. It is auto assigned when a TargetProcess role is requested; as it is required for a user to have an Apptio Frontdoor account.
7 - We discussed 'Combo roles' That Ashleigh and team are putting together; though these would most likely result in zero changes to MyAccess or IDM driver changes: it would simply be a single role assignment as always.
8 - Dates discussion: we found that there are many users that have a high number of roles needed in TargetProcess to do many tasks that have been put into Apptio/TargetProcess. TargetProcess doesn't have a super clear, desirable way to represent this yet, the Apptio team is still planning this, and expect to need 4-6 weeks to fully define. We discussed there are the concept of 'teams' in the API; but the level of complexity to manage least-privileged-roles is too complicated to be a viable solution.
9 - Our previous date of 10/15 is no longer the target; but completing as much as we can in the mean time through production is still desirable as we'd be able to finalize as soon as we get answers from the Apptio team.


Next actions:

Ashleigh is going into a backlog meeting and will work to schedule/resolve as much of the items below as possible, as we work to define a new target date for completion:

1 - We need to identify the list of roles to expose for FrontDoor, then expose them in MyAccess
2 - We need to identify the list of "admin roles" to expose for TargetProcess, then expose them in MyAccess as admin roles.
3 - We need to identify the list of "user roles" to expose for TargetProcess, then expose them in MyAccess as user roles.
4 - TargetProcess API authentication: We need to test and use a username and password -> HTTP: Basic Auth method for authentication.
5 - Meeting - Aaron & Ashleigh, possibly Mike - review and approve both IDtoApptioFrontDoor, and IDtoApptioTargetProcess driver documentation design.
6 - Research - MyAccess - Mike/Aaron: need to research/define a filter to be able to expose user roles, and admin roles in separate dropdown lists in MyAccess.
7 - Research - MyAccess - Mike/Aaron: need to research the ability to allow a group to be enabled for role approval/denial.
8 - Aaron/Mike: Reconcile TargetProcess role counts, then confirm the lists from Ashleigh won't be an issue to expose due to our findings.

--Aaron