3/17/2025 1:04:57 PM

**CONTEXT:**
======================================================================
As a normal part of working on an IDM driver, the "Initial Migration" is a step that needs to be taken immediately after deploying a driver to production. This process brings all existing accounts into alignment with the known use-cases, and adds what is called a 'DirXML-Association' to each user account in eDirectory. This association is what helps the This process would also involve a MyAccess 'Collection' where MyAccess could scan all of the data in Autocrib so that MyAccess could then begin to allow management of all existing roles, as if they were assigned by MyAccess in the first place.

Autocrib does not have an API accessible concept of a role. Instead, the rights in Autocrib are managed by 11 booleans. This means I had the responsibility of matching up all of the existing sets of 11 booleans for each user to see which role they actually have assigned. This would give us a good clean way to designate the role assignment in eDirectory (where the IDtoAutocrib IDM driver runs), and then subsequently in MyAccess.




**THE ISSUE**
======================================================================
The issue I ran into is as I was looking at the users, a majority of the users' permission booleans do not match up to one of the 6 roles we had defined as follows:

![[{83F7646A-D602-43B3-9F5C-9E8173EAC6EA}.png]]

Permissions spreadsheet:
https://wnco-my.sharepoint.com/:x:/r/personal/grishma_subbaiahbittianda_wnco_com/_layouts/15/doc2.aspx?sourcedoc=%7BD9E30795-A8A5-4FFE-BDC2-99459819D84A%7D&file=autocrib_roles_permission.xlsx&action=default&mobileredirect=true&DefaultItemOpen=1&isSPOFile=1&ovuser=f5d3bd9c-a8c2-4efc-9493-ddf2d4b42f17%2CAaron.Kynaston%40wnco.com&clickparams=eyJBcHBOYW1lIjoiVGVhbXMtRGVza3RvcCIsIkFwcFZlcnNpb24iOiI0OS8yNTAxMTYyNDMxOSIsIkhhc0ZlZGVyYXRlZFVzZXIiOmZhbHNlfQ%3D%3D

This means that I do not have an official role to assign for a majority of the existing users. For the users that do match (about 200/1000), these will immediately be manageable by MyAccess.



THE IMPACT:
======================================================================
This means that I do not have an official role to assign for a majority of the existing users. This would mean MyAccess would know nothing about them. So here's the impact. I've realized I could make use of an 'UNDEFINED-ROLE' value for users that fall into this category; but these users would have this impact:

1 - Not manageable by MyAccess: The users that don't match would have this undefined role, be invisible to MyAccess (aka it wouldn't 'collect' those users.)
2 - MyAccess would overwrite upon new role requests: If these users did request a role in MyAccess, they would get it, and their permissions would be updated to match the role.
3 - Design/technical level: purpose of having defined roles: Instead of having an official role marked on the user, it would be listed as 'UNDEFINED-ROLE' meaning a large portion of our users would not fall into one of the defined roles and so cannot be managed in a role way when we've had a big push to govern users this way.
4 - IDM Initial Migration would need to be done to preserve the existing permissions along with the UNDEFINED-ROLE VALUE; The only drawback here is more time to do initial migration. Now that I have the code base to do the permission checking it should be minimal.
	* I am setup to do a diff before and after for the 4 sites that have gone live, so I will know how much I affect during initial migration, and can fix issues on demand.




OPTIONS & CONCERNS:
======================================================================
I suspect our chosen path forward will be to make use of the UNDEFINED-ROLE . . however, I have seen changes to permission booleans over the last 5 days (between March 12 - March 17) for 10691-Orlando.json, I assume this is just administrators updating the system manually to get the system working; can you confirm?





TECHNICAL DETAILS ON INITIAL MIGRATION:
======================================================================

This is what a single record looks like for initial migration. It's in an LDIF file format that allows me to set the explicit roles, and cause the driver to look at it, and see what needs to be done. Keep in mind some users do have a 'departmentNo' populated - and we could use this as a guide for role assignment . .however, if we used this as their role; we'd be changing the users's booleans to match that role upon assignment. . .This may be desireable; but we'd have to decide what we want to do.



This is an example of an exact match in Atlanta, there were only 3:
```
dn: cn=e35940,ou=users,o=swaiddev
changetype: modify
#User's current permissions in Autocrib: adjust:FALSE|||console:FALSE|||forceReferenceBin:FALSE|||issue:TRUE|||kitIssue:FALSE|||locate:TRUE|||maintain:FALSE|||physical:FALSE|||return:TRUE|||stock:FALSE|||supervisor:FALSE|||
replace: swaAutocribRole
#User had exact match to a permission
swaAutocribRole: Autocrib-AMT|||adjust:FALSE|||console:FALSE|||forceReferenceBin:FALSE|||issue:TRUE|||kitIssue:FALSE|||locate:TRUE|||maintain:FALSE|||physical:FALSE|||return:TRUE|||stock:FALSE|||supervisor:FALSE|||
```

This is an example of a user that did not match:
However, we can still explicitly set them as 'UNDEFINED-ROLE, and use the exact same set of booleans that they are set to now:'
```
dn: cn=e100295,ou=users,o=swaiddev
changetype: modify
#User's current permissions in Autocrib: adjust:FALSE|||console:FALSE|||forceReferenceBin:TRUE|||issue:TRUE|||kitIssue:FALSE|||locate:FALSE|||maintain:FALSE|||physical:FALSE|||return:TRUE|||stock:FALSE|||supervisor:FALSE|||
replace: swaAutocribRole
swaAutocribRole: UNDEFINED-ROLE|||adjust:FALSE|||console:FALSE|||forceReferenceBin:TRUE|||issue:TRUE|||kitIssue:FALSE|||locate:FALSE|||maintain:FALSE|||physical:FALSE|||return:TRUE|||stock:FALSE|||supervisor:FALSE|||
#departmentNo: NO DEPARTMENT
```

In a perfect world we'd come back to these UNDEFINED-ROLE entries, and assign them an actual role with the expected permissions, assuming those users needed to be managed by MyAccess, and we wanted their permission set to match our definition.
