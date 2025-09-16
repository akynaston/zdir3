4/16/2024 3:56:33 PM


E100016,E100016,0030RT,DALWN01XX,THONGPRACHANE,Rhonda,GSSU
E100016,E100016,0038RT,DALWN01CP,THONGPRACHANE,Rhonda,SU

E100016: 	signID issue: user:[E100016] - expected [2] Office/signid pairs, but actual count was: [1]
E100016: OfficeID issue: expected officeID/signID: [DALWN01XX/0030RT] but was: [null/null]

Note: on this one: XX/XY/XZ - these are place holders . .
   - Possible issue: note: could have switched user in altea; but didn't update database . .
   - there are 20K
   ***- If the only thing that expected is wrong AND succeeded on at least one other value for is xx/xy/xz: don't treat it as a failure
   ***- drop firstName validation? Maybe do this on a future phase.
    - Trying to determine who is authoritative: in theory, IDM is authoritative.
    - For Auditing purposes, it helps to have a record . .
    - If the user is 'temping' - want to have the temp date . .
    - swa issues where swaAlteasignid - disagrees with swaAlteaOfficeID
    -


![[Pasted image 20240416155600.png]]

 - IAH vs HOU
 -
Started chat about dallas & huston:
 - Brandon: have to open temp request main office and external offic e. .
 - Need to test secnario where supplemetnal is sthe same as rbac  . .maybe? 4/16/2024 4:01:32 PM
 - When expiration comes through: may delete; but rbac should still remain! If the same signid; could run into issue temp at a place; becomes your peromanent; then temp expires in altea, might attempt to remove office id; RBAC one may remain . .one suppl, one rbac; same value . .
 - When try to remove suppl; removes, but leaves as arbac; gets removed!
- 
- if in dallas, temp in huston,
- then become huston employee, just wipes all out; then just rbac only . .

* now discussing removal completely of offices; then add it back: if altea tries to assign ofice id; won't get sign id  .
* Braondon:Some permissions assigned to users at their user level and associated to sign id . .
	* joe . .what??
	* brandon: if user has office id, existing sign; user lost office id; gained office id with new sign; don't get same sign!
	* joe yes
	* brandon: but - permission 
	* aaron: maybe out of band sign ids . .?
* Braond: yes; we do want to review the data
* brandond: Especially ground ops . .
	* joe: scalled down report: only looking for specific problem.
	* then just this one.
* if we eliminate just xx/xy/xz, how much shrink file?
* drop firstname changes
* only office id's and signs
* if complete and total discrepancy: auditing won't work.
* how many do we have left at this point and how to fix them . .

Then do master file to see what is left.

* 1 remove place holders
* 2 names
* 3 JOe: after get master list: sort by ID - same time notiing SQL
Report mid day tomorrow - 


