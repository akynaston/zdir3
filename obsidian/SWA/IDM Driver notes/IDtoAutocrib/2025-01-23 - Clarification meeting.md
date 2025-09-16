1/23/2025 10:26:17 AM
IDtoAutoCrib Design meeting/working session:

Attendees:
Joseph Cordasco  jcordasco@autocrib.com
Aaron Kynaston
Jeff Ponce de Leon jponcedeleon@autocrib.com


Goals
G1 - Confirm what we're trying to do is clearly the desirable target. Should include Southwest folks + some that know the API well. Nirosha did a lot of the ground work; so this should just be finalizing some of the finer points. I apologize if I've missed stuff, I've been through all of Nirosha's notes, and am familiar with the API now.

G2 - Working session: confirm the path forward in a short working session. Should include API folks, with backup from SWA folks.






















Main goal now is G1: once we have a clear definition of the target, we may need to talk through a working session on the REST api and do some final testing.


Questions:
 - What is the dbid? Are they completely separate databases (dbid = database id?) - that independently stores data in autocrib?
	 - A: dbid's represent sites in Arcturus has its own set of items: departments, employees, bins - each site is still separate, specific to this site.
	 - Helps to separate rights to site access and data.
 - What purpose does the departmentNo field cover? Setting it has quite a bit of work to be done, and I want to make sure we're solving a problem, or gaining some valuable, desirable result.
	 - API level: helps to isolate the user into that department for that dbid . .
	 - 
 - It doesn't appear that I can delete departments, correct? I need to be able to test the autocreation of new departments . . I will be running a LOT of tests, and creating many departments, will this be a problem if I create dozens of randomly named departments?
	 - Reasoning: if you delete department: lose ability report on historical transactions . .
	 - URL for web app: 
		 - For prod: Jeevan - May help get access to Admin access url in prod . .Shan Lockard/Grisham
		 - 10636 - Make user on sandbox accounts: 



Action items:
* Jeff/Joseph - To create super admin account in three sandbox accounts: 10636
	* URL for standard login page web access: [https://www4.autocrib.net/](https://www4.autocrib.net/ "https://www4.autocrib.net/"), but separate URL for SSO
	* 	* AKynaston@southwestairlinesdev_sandbox (password in email)
	* URL for SSO login: [https://www4.autocrib.net/login/ssologin](https://www4.autocrib.net/login/ssologin "https://www4.autocrib.net/login/ssologin")
		* My email address & My creds . . 
* All of us - Confirm Pro tier before setting up dbids
	* Confirm which of the DBids would affect billing




Notes:
I use user/employee interchangeably. The API calls them 'Employee' and 'Department' objects. I'll try to refer to these proper names.

Issues/Concerns:
Context: IDM is event driven: meaning the cleanest most direct path for IDM (Identity Manager) is to have a change in an attribute from one value to a distinct value. When data changes, that data is reported in an XML format, that is then translated to a payload used in the actual REST call to the API.

Since IDM is event driven, it means the more operation, querying, and code branching that happens means the driver is slowed down.


First: what does autocrib solve? Sounds like it manages physical lockers right? 
	* Yes - has a touch screen & gui - Issue/return machine: secure tools for people, not personal lockers. Item code -> locker
	* Someone can choose item based on serial number etc, could tighten rights: mostly based on rights to getting items and returning them.
	* VIDEO about lockers: [https://www.youtube.com/watch?v=40vnbWJIDts](https://www.youtube.com/watch?v=40vnbWJIDts "https://www.youtube.com/watch?v=40vnbwjidts")
	* 


Enjoy the videos and music you love, upload original content, and share it all with friends, family, and the world on YouTube.
	Are these people that need the lockers always employees? (eids) Will there ever be any contractors that need the system?
	* **QUESTION FOR SOUTHWEST SIDE . . .**

FYI: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/419594271/IDtoAutocrib - link for the Autocrib driver: pretty rough right now; but I'll put everything I know there.






C1 - The dbid has to be included in every REST call. The table we've put together. Note that IDM Location will be matched up with our 'swaLocation' attribute.
Are there any changes needed to this table? Do you have a sense for how often this table will change? 
	* We believe we've put together this table with some SWA folks
	* all have a DBID and match as shown.
	* The client is required to have a 'claim' on autocrib side . .will receive unauthorized.
	* An email exists to be able to onboard the dbids . .web service support:
		* wssupport@autocrib.com
		* Note: Adding a new one affects billing in a way . . though API access may not affect anything.
			* Joseph/Aaron: need to confirm billing.
				* Talk with Grisham/Jeevan to find out when we add them.
				* May make sense to add them all now if we're already on the 'pro tier'.
			* 
		* Example: when receiving this.
		* 
				{
				    "errors": [
				        {
				            "code": 401,
				            "message": "Unauthorized DbId provided",
				            "title": "DbId"
				        }
				    ]
				}
	* Also note: if new ones need to be added, then we need to request through the email above about these.
		* Example: ATL is 'type 4': this means: enumeration in the database: includes SSO - Arcutrus pro: if already in 4, won't affect billing.
		* Chicago: type 2 . .but not in the list here . .2019 . . old one . .
		* Each has a 'type' that defines the billing: once they have a 'crib' - that would manage that site . .? any crib places you into a tier.
			* cribs: Vending machine holding the tools - or 'StationNo'. AKA - crib/station/machine/locker
			* lockers: a type of crib.
	* Jeff L's call: only atlanta at the time . .with Nirosha.
	* Also: if 'no machine setup' aka 'crib' - don't fall into any tiers, and don't get billed . . .
	* probably will go to tier 4 notes.
	* 
![[{50F04D81-9ECD-49ED-A476-AB6F0799B438}.png]]



{
 "employeeNo": "00101301",
 "firstName": "Tauna",
 "lastName": "Aspley",
 "badge": "101301",
 "customField1": "Autocrib_Helpdesk_S" - Free field to store data . .anyc ustom 
 "departmentNo": "HAS TO MATCH EXISTING DEPARTMENT IN THAT DBID/ departmentNo"
 }


C2 - Departments need to be added before the user add. This means that for every user add, I have three options:
  With all of the options below, since I think each dbid represents an entirely independent instance of data; this means I'll need to consider all potential dbids for the solution too - so whatever plan we come up with will need to be accomplished per dbid instance, currently about 15 of these! 
  
  Also - Right now, I'm populating the departmentNo and description with the same value as I won't always have access to the description.


Business reason to populate:
1 - retry after error - top priority . .
2 - create user  without department . .add them later somehow
3 - create before every user create
4 - query before
5 - pre-populate

  C2-1 - Could go ahead and send the user create: if error 422, "departmentNo doesnt exist,' then create the department, and set the user create to 'retry'.
  
  C2-2 - Create user without department number. Could create user without department number . .then have a second process to come by and add it later when we know it exists . .
  
  C2-3 - Create every time: Send a create of a department before every Employee create. This isn't entirely efficient, and means it'll error out a bit for departments that exist already. . .not terrible; but not super ideal.
  - Getting the description for the department would require another query, and yet another code branch for possible failure: meaning I couldn't provide a description.

  C2-4 - Query department before every create: slightly more efficient, though will push back our first revision in prodcution, but reuqires custom code to have a full back and forth conversation with the API; then means a create would require yet even more requests to the API. Logically, this is appealing to me, though does require a bit of custom work.

  C2-5 - Pre-populate all departments on a regular basis: This idea would seem to work; however, gathering this data on my side is going to be tricky: I'd either need to gather it from the users as would be done in ideas 1 and 2.
     - The biggest drawback on this idea is that any users that come in with new departmentNo (jobCode values) that come in will cause user creation to fail, and need to be reprocessed once the departments are created.
     - In the near future I will not have a clear access to lists of departments that need to be created at some point, so managing these may be tricky.
     - We may be forced to do a mass creation of departments on a regular basis to ensure they all exist; but determine what this regular update should be is going to be problematic.
     - 4,456 jobcodes . .
     - not super static means we'd be updating data like mad the time . . 
    
    





 - Could do error handling on the response . . .
	- 
```
{
    "errors": [
        {
            "code": 422,
            "message": "DepartmentNo 'Test' does not exist.",
            "title": "DepartmentNo"
        }
    ]
}
```

1/23/2025 12:44:29 PM- Existing on boarded sites . .already have lots of users in the system?
	 - One off initial load: minimize the initial trouble . .
	 - Could add all departments to all DBIDs - add them all dbids . . Jeff L: just more data on this system . . 
	 - When an employee is added: worst case scenario: 30 second wait to retry the user . . .




C3 - Discussion of deprovisioning: employees is going to be tricky as well: I'll lose the swaLocation value for the user, and will need to add custom code to keep which dbid the user was in.
	- I may have a solution for this; but it means further custom code. Not a show stopper, but again pushes the final deploy date.
	- We have Employees and contractors in the system: do they both need to be created in autocrib?
	- cases to discuss:
	- Answer: Can either disable or delete!
		- C3-1 - Employee/Contractor is terminated: delete
		- C3-2 - Employee/Contractor loses swaAutocribRole (the attribute that is used as the gating attribute in MyAccess) - populates 'customField1' (show dump of a user): delete
		- C3-3 - Employee/Contractor is disabled: set active to false.
		- C3-4 - Employee/Contractor is deleted: Should likely delete in this case . . 








C4 - The preparation of the dbid's on your side.
	- As we've seen, some of the dbid's appear to not be set up yet: I'd assume we'd want to get them all ready to go so I can ensure I can properly create departments and employees in all of them.
	-  Is there some benefit from not having all of them setup now? When we go into production, Ideally, we'd already know that all of them will work properly.
	- Answer: Send an email to support listing all dbids to fully enable for our account.
		- wssupport above . .
	
 


C5 - Change of swaLocation . . 
	- Fully deprovision in old dbid
	- Fully add to the new dbid . .
	- Recommended: mark the inactive rather than deleting . . .
	
C6 - Emloyee stays at the same location; but changes department
	 - Change the departmentNo

C7 - Loses badge - reassign? badge won't change
	* EmployeeNo = badge number - concern?
	* Recommendation: 
		* two ways to log in: scan or type it in . .or proximity card
		* If use physical badge, need to set the output of the badge . . 
		* Question: how do people log in? Proximity authentication would be an option; but would need 'badge' updated to equal result of scan.
		*  Start with employee number in badge . .later, 

	
Permission discussion:
Some attributes require rights discussions, like:
issue, etc . .
some people responsible for stocking . .etc. . .
Need to represent rights . .
Question: what do we need to expose
List of fields:
Issue

Questions regarding permissions can be asked . .

![[Pasted image 20250123125943.jpg]]
About a dozen rights related attrs;

issue
kitIssue
return
'dull return' - deprecated
locate
adjust
stock
physical
maintain
console
forceReferenceBin
active
relocate - not in the API, does work in arcturus . .not exposed in API - feature likely not being used in SWA . . not for our industry . .could talk.

issue, kitIssue, return, *Dull return*, locate, adjust, stock, physical, maintain, console, forceReferenceBin, *relocate*. Note that Dull return and relocate are NOT accessible through the API.

API changes?
 - V1 - could make breaking change, and move to a new version.
 - Arcuturs agreement: 90 day notice and move to the new version.
 - Adding a field: NBC (non breaking change)

DOCUMENT WHICH ARE DEFAULT SETTINGS:
{
    "active": true,
    "adjust": true,
    "badge": "9999991234",
    "console": false,
    "costLimit": 0,
    "created": "2025-01-23T12:04:20.344",
    "customField1": "Testing default values ",
    "customField2": null,
    "customField3": null,
    "customField4": null,
    "customField5": null,
    "customField6": null,
    "customField7": null,
    "customField8": null,
    "customField9": null,
    "customField10": null,
    "customField11": null,
    "customField12": null,
    "departmentLock": false,
    "departmentNo": null,
    "email": null,
    "employeeNo": "00101888888",
    "endTime": null,
    "firstName": "JosephTest",
    "forceReferenceBin": true,
    "issue": true,
    "kitIssue": true,
    "lastIssue": null,
    "lastName": "CordascoTest-AVK",
    "lastUpdated": "2025-01-23T12:04:20.679",
    "lastYearCost": 0,
    "lastYearIssues": 0,
    "locate": true,
    "maintain": false,
    "monthToDateCost": 0,
    "monthToDateIssues": 0,
    "notes": null,
    "physical": false,
    "pinHash": null,
    "recordId": 414,
    "return": true,
    "startTime": null,
    "stock": false,
    "stocker": false,
    "supervisor": false,
    "supplierNo": null,
    "yearToDateCost": 0,
    "yearToDateIssues": 0
}



'dull return' - deprecated
active
adjust
console
forceReferenceBin
issue
kitIssue
locate
maintain
physical
relocate 
return
stock
Default values:
```

{
    "active": true,
    "adjust": true,
    "console": false,
    "forceReferenceBin": true,
    "issue": true,
    "kitIssue": true,
    "locate": true,
    "maintain": false,
    "physical": false,
    "return": true,
    "stock": false,
 }

```


Status email: sent just now 1/23/2025 2:23:59 PM
to:
Jeevan Gogineni
Grishma Subbaiah Bittianda
Joseph Cordasco - autocrib
Jeff Ponce de Leon - autocrib
cc Farhan raman, mike labit angie johnson


1/23/2025 1:08:03 PM
Team,

Today I was able to speak with Joseph Cordasco, and Jeff Ponce de Leon from Autocrib regarding my API questions. I wanted to provide a status on our call. I apologize for the wordy email, there was a lot to cover! We have a set of action items, some for Autocrib, and some for our side at Southwest. Farhan, Mike and Angie, I've included you assuming you need to be aware of these updates.



Here are the action items from our call:

  - Joseph and Jeff - can you please do the following?
     - Please verify the "Example request to onboard dbids" section below?
     - Please answer the 'Questions for Autocrib' below.
  - Jeevan, can you please do the following?
     - Review the 'Business use case questions remaining' question set below? Per our chat, there's more we need to define to complete the driver.


Note that all of the items I learn and plan as part of the driver design will eventually be documented here:
https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74553541/IDtoAvioBook

Items discussed in our call:
* We identified a number of business use case items that I need to clarify with you Jeevan, see the questions below.
* We confirmed a number of items at the API level that will help resolve some concerns I've had with the driver development.


Detailed Items covered:
 - The dbid's represent a full, independent instance of autocrib, meaning they have their own departments and users.
 - dbid and departmentNo are fields used to help further separate and identify user access in autocrib.
 - The department objects' population within each dbid needs to happen before user creation.
 - I will be creating lots of departments in dbid 10636 during testing. They cannot be deleted through the API; though I do have GUI access that allows me to manually delete them from the 10636 dbid environment which should be sufficient for our needs.
   - In production, we shouldn't need to delete them, though Southwest autocrib admins can manage them as needed through the GUI.
 - We talked about enabling additional dbids for our API access that may affect billing, added a question below about this concern.
 - Joseph and Jeff sent an excellent YouTube video describing the purpose and capabilities of Autocrib: https://www.youtube.com/watch?v=40vnbWJIDts
 - To ensure dbids are enabled on our API, we can email wssupport@autocrib.com along with a request to do so. See the example below.
 - We discussed a few options for deciding how & when to ensure the corresponding departments existed in the autocrib system.
 - Discussed deprovision use cases.
 - Discussed Change of swaLocation which changes a dbid; which means we'd need to conceptually 'move' users between 'db's.
 - Discussed the change of departmentNo (our jobCode value) which would require a 'department move' scenario.
 - Discussed the loss of a 'badge' and need to change.
 - Discussed authentication options into autocrib for end users: manual typing, scan of barcode, or proximity scan (badge value).


Questions for Autocrib: Joseph & Jeff:
 -  If we fully enabled all 15 of our dbids (10803, 10632, 10806, 10689, 10802, 10690, 10786, 10785, 10787, 10804, 10691, 10784, 9132, 10636, 10637) Can you confirm any changes in billing for Southwest?
 - (question asked and answered previously) Can you think of any API reason why we should use departmentNo?  What would we lose by simply populating it in customField2?
   - Answer: At the functionality level, Only reporting would be affected. A custom report would need to be built to display 'customfield2'
 - Does 'dbid' stand for 'database id'? I just need the vocabulary to refer to it properly.


Business use case questions remaining:
 - We would like to set up all of the dbids in production so they are ready to be used before we go to production. Enabling a dbid for our accss may affect billing for Southwest. Can we please go through the process of enabling all dbids in production, assuming minimal and/or known impact to billing?
 - Will only employees need to be in autocrib? Do we need to include SWA contractors? Any other kinds of people such as retirees, robotic accounts etc?
 - Does Southwest have an explicit reason for using the departmentNo field? Any concern if we move it to customField2 instead? The departmentNo field adds on some time intensive complications.
 - What is Southwest's plan for authentication for end users into autocrib? Options are manual typing of username/password, scanning of a barcode, or a poximity badge. This affects our population of the 'badge' field.
 - There are about a dozen boolean attributes that describe permissions for users in autocrib. Can we please review these with Autocrib to decide what we want to do? Until we have this conversation; the following defaults will be in place (note that the 'relocate' and 'dull return' values are not accessible through the API, so are not listed here):
 {
    "active": true,
    "adjust": true,
    "console": false,
    "forceReferenceBin": true,
    "issue": true,
    "kitIssue": true,
    "locate": true,
    "maintain": false,
    "physical": false,
    "return": true,
    "stock": false,
 }


Example request to onboard dbids:
 - Joseph and Jeff, please confirm this is a workable example:

  To: wssupport@autocrib.com
  From: (SWA autocrib admins)
  Subject: Please enable these dbids on our API:

  AutocribLocation: Tampa (example city)
  DBID: 10803 (example DBID)
  IDM location: TPA (example swaLocation value to help keep them tied together)

  The result of this email would ensure that our REST api to autocrib can properly create users and departments in the corresponding DBId.




Thanks,
--Aaron



