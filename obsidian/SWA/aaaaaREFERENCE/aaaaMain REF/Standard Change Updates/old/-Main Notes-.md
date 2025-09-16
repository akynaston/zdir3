5/14/2024 1:16:36 PM

Proposal:
[STDCHG0002891](https://southwest.service-now.com/nav_to.do?uri=std_change_proposal.do?sys_id=d75d4cfdc371c214b6c13b2f05013149)


Here's the oneline entries, 1-4 are below as separate files.
5 - Change Owning Group: CS-EE
6 - Primary Business Service (Maintenance Window) - Manage Security Services
7 - Reason for Change (separate file)
8 - Environment: LEAVE BLANK: use for QA & Prod!!
9 Source of change: Change to service


5/14/2024 2:16:07 PM
 - resubmitted latest . .

5/16/2024 1:41:47 PM - sent this to John on our May 
John Maples just requested to cancel our review meeting #2; I offered to put together a write up; doing that here. Rescheduled for Monday, 20th.
 - Changes made:
	 - Restricted variables only to the 'Detailed Description'.
		 - Documented all variables, and the fact that they existed only in Detailed Description.
		 - Removed all variable references, except for those in Detailed Description:
			 -  Updated all other fields & references in other locations to be more generic, such as referring to the 'Primary server' or 'Secondary server' as a name rather than a variable.
	 - CTASK changes:
		 - CTASK: #0: Add note per Bruce M to tell IDM end user to be sure to add the GitLab Pipeline URL used for deployment.
		 - CTASK: #7: GitLab: Added per Bruce M: to help engineers to prep the Gitlab pipelines for testing.		 - 
		 - Renumbered all tasks to sort easily.
		 - Renamed tasks that didn't fit within the short 'Name' field.
		 - Deleted update Driver revision update Post-imp task; as this isn't a priority any more.
Also: - just found an 'order' column on the CTASKS, so set them all to clean proper ordered values.
	(added this one to john at 5/16/2024 2:41:48 PM)



5/24/2024 10:24:55 AM

had std change meeting today in CAB: 5/24/2024 9:04:18 AM
CAB: std change notes on the meeting:
 - Please match your CTASKS closure to you actually doing your work: they have a start and stop button which automaticaly populates the timestamp; not sure that's always been there, but it's useful for easy clean tracking.
 - Once in a change window: either successful or not successful only result: Don't make any progress on CTASKS until your window. Don't start a change until all pre-imp tasks are done which should increase your chances for a successful change.
 - PIR - post implemenation review tab: used in failure meetings.

late to cab:
   - why late, why pressing and can't be rescheduled.
   - core members: must reach out
   - approved at end of day.






Yea! standard change approved!

Documentation starter:


To use the standard change for IDM drivers, select the following from the standard change catalog:

![[Pasted image 20240524102504.png]]


If you want to confirm you used the correct standard change  template, it can be seen here:
After you click on this, then click save for the first time (after filling out some of the required fields, such as the  change owner, and target environment):
Under 'governance': you can see that the standard change tempalte version was: STDCHG0002891 which is 

![[Pasted image 20240524102850.png]]