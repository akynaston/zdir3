7/3/2024 11:17:42 AM 
We are recording various Design items here for your consideration when retrieving the data from Kafka
* If data changes that is in the filter, then it will trigger an event; and consider the user for the MCL: ![[Pasted image 20240703112859.png]]
* SwaStatus is also considered:
	* A - Active
	* T - Terminate
	* I - Inactive (used by old SAP integration; may not be used any more).
	* L - ON leave
	* S - Separated (handle same as terminate)
	* P - Prehire
	* R  - Retired
		* The "Check user qualifications" rule allows users that are A, I, P will be allowed on the MCL (NEED TO CONFIRM)
		* (NEW)When users go on leave, they need to be removed from the MCL.
			* Any kind of L status will remove users from the MCL.
			* Users are added back immediately upon reactivation if they stull qualify.
* Key groups for MCL eligibility
	* ![[Pasted image 20240703114213.png]]
* If GivenName, Surname and Middle name are present in the event; stop the event, and email  . . the data would have to be sanitized manually . .
![[Pasted image 20240703111955.png]]

* Passports:
	* must not be expired to be on the MCL (aka swaPassportDOE is not in the past + 1 day).
	* If time passes such that passports become expired + 1 day they should be removed from the MCL.
	* When someone receives an updated unexpired passport (aka expiration date is added in the future), allow the user in the MCL.
Example payload currently by the driver:

![[Pasted image 20240703112827.png]]

* After the payload is sent, a subscriber to the JMS Tibco message bus picks up the event . .
*  . .pulls data needed, perform process as needed; such as adding the user to a table, etc.
* Have to have the passport information as seen above:
	* ![[Pasted image 20240703112646.png]]
* Another message queue provides 'licensing' information for the person on the MCL.
* This data is then placed on the MCL Oracle SQL database.


MISC:
* Retiree users are not allowed on the MCL
* Users losing one of the key groups will be removed.
* Block prehires of FA01/FA99 & swaStatus=P if they otherwise qualify for the MCL if their hire date is in the future.
* (note next session: show prehire blocked if date in the future)