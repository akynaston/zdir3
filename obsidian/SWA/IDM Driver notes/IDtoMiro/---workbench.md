8/13/2024 1:40:38 PM

Call with ARvin - plans made:

1 - Get a list of all users from Miro (email address, and Role required, employeeNumber)
2 - Get a list of all users from eDirectory
3 - Determine users that should be deleted from Miro as they no longer exist in eDirectory.
   - Ignore 'Company Admin' roles.
   - Ignore any one that has activity within the last XXXXX?
4 - Should we just deactivate users for now, then fully delete in a month or so?

Can use the "inactive for 180 days" - 6 months . .

Next steps:
 - Aaron to see if API lets us pull all Miro users that:
   - Are not "Company Admin".
   - Haven't logged in for at least 180 days.



8/15/2024 11:05:45 AM
For meeting on Aug 15:
Before we start, I'd like to confirm the prod deploy and define vocab.
 - I'd like to deploy the IDtoMiro into production asap - this change will deprovision users on terminate as you know; can I deploy now? As mentioned yesterday, this is the change needed so all future terminates are properly deprovisioned.
 - IDtoMiro Production deploy CR: CHG0414489


Define some vocabulary:
Inactive in the technical sense: Users' active field is set to false; they can't log in; lets call this 'inactive by attribute' 'disabled users'
Inactive in the practical sense: Users haven't used the system for a period of time; but could actually log in 'inactive by not logging in'.
 - I don't think we'll have access to the 'last activity date'. It is not available in the miro schema, and the REST API that is also available seems to be focused more on the teams and boards inside of miro than actually providing data about the users themselves.


Ultimate goal: is to free up licences.


























Reports: taken on 8/15/2024 11:23:42 AM
7368 total users: https://miro.com/api/v1/scim/Users?attributes=userName&&sortBy=name.givenName&sortOrder=ascending&startIndex=1&count=9999

6200 - Active= true users https://miro.com/api/v1/scim/Users?attributes=userName&filter=active eq true&sortBy=name.givenName&sortOrder=ascending&startIndex=1&count=9999
 - TODO: identify Guests??? - these aren't  problem; users invited to view board - all have wnco email . . not sure why they are guests . .
 - Identify who these are, and send to Arvin.

1168 - users active = false: https://miro.com/api/v1/scim/Users?attributes=userName&filter=active eq false&sortBy=name.givenName&sortOrder=ascending&startIndex=1&count=9999






Report as of 8/13/2024 2:47:44 PM
 - Miro total users: 7,365 in production.
	 - 
 - Miro Inactive; 1,175 (attribute active = false, these users can't log in.)
	 - 214 of these users still are listed as having a 'Full' license, they can't - I think this takes away from your license count.
	 - I think we have two options:
		 - I suspect we can fully delete this object.
		 - or attempt to down grade to 'Free Restricted'
		 - 6204 total = 4489 full + 1711 free + 4 guests
 - Miro active:   6,190
	 -  Arvin shows:
		 - total licenses 5000
		 - Licences used: 4489 
		 - means 4489 full members
		 - 4489
	 - 
 - After IDtoMiro prod deploy:
	 - There are currently 69 terminated users in Miro that are termianted and should be drpvosiioned.
		(&(DirXML-Associations=cn=IDtoMiro,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#*)(swaStatus=T))
		
I think we want to do the following:
 - Confirm number of licenses is our final goal.
	 - Active vs inactive vs Full vs Free
 - Start by detecting exactly how many licenses we are using, and how many are free. This will help monitor our progress and confirm our success.
 - ~~Confirm what the 'last active date' is figured from; so we can trust it as a way to leave users there.~~
 - 








8/15/2024 11:19:12 AM
First cleanup steps:
 - **Aaron:** Production IDtoMiro driver deploy
	 - 69 - Delete: Start with 69 already terminated + associated in Miro.
		 - **Next Action:** Aaron can do this immediately after deploy; Aaron to do on Aug 15.
 - **Arvin:** 214 - Delete users that are disabled and full licenses - **DELETION CANIDATES - 214 Not Active And have full licence.txt**
	 - These are the safest to delete, since they can't log in.
	 - These users are not in the active list.
	 - **Next action:** will sample about 20 of them to verify, waiting on Arvin
* **Aaron:** List all users in Miro
	* Produce a list of users in Miro that don't have a corresponding eDirectory user.
		* Combination of the following: - this is the most difficult part . .
			* Manually created users - TBD . .??
			* Admin/meta users that need to be in Miro
			* Terminated users that can be safely deleted.
	* **Arvin**: Note: ideally; if we could identify users that haven't used Miro for 90 days, can we deactivate them? (30 is too aggressive, 180 is too long)
		* This may need to go to support.
		* by deactivate - in SCIM terminology:
			* active to false
			* usertype = 'Free Restricted'
				* SCIM:             
					* "userType": "Free Restricted",
					* "active": false,
		* This would let us easily reactivate them.
			
		
Total: 7368
Total Active: 6200
Total Full: 4489
Total Free: 1679 (Correction from 1711; there are 32 unaccounted for free accounts that the GUI does not show.)
Total Inactive: 1168 


Main miro screen from:  https://miro.com/app/settings/company/3074457347390819556/users
	Full: 4489
	Free Restricted: 1679 (total free restricted 2632 - 953 disabled users = 1679)
	Guests: 4
	
Free restricted total, active and inactive: 2632 
	URL: https://miro.com/api/v1/scim/Users?filter=active eq false and userType eq "Free Restricted"&sortBy=name.givenName&sortOrder=ascending&startIndex=1&count=9999

Free Restricted, active false: 953
	URL: https://miro.com/api/v1/scim/Users?filter=active eq false and userType eq "Free Restricted"&sortBy=name.givenName&sortOrder=ascending&startIndex=1&count=9999

1679 = total free

Before:
Total: 7368
Total Active: 6200
Total Full: 4489
Total Free: 1679 (Correction from 1711; there are 32 unaccounted for free accounts that the GUI does not show.)
Total Inactive: 1168

After deploy work:
Total: 7300 (difference of 1; haven't found out why), query "MAIN - GET ALL USERS"
Total Active: 6137 (difference of 63, 6 missing)  query: "MAIN - Get ALL USERS active=true"
Total Full: 4425 (64, 5 unaccounted for)
Total Free (active) :1680 (new one during deploy)
Total inactive: 1163 (5 less)


MAIN Get Free restricted & Active only


8/15/2024 12:53:20 PM- next - Listing all users in Miro, and finding which of them no longer exist in eDirectory.

4425 - query: MAIN - Get ALL USERS active and full, appears as this online.


9/24/2024 12:29:39 PM
call today

9/24/2024 12:02:28 PM
Automate miro users . .
  Aaron Smith - Miro
  Matt Skipper - Solutions with Mir
  Arvin Kamau - allthings miro
  Aaron Kynaston
  Farhan Rahman
  Aaron Kynaston - IDM engineer focusing on the IDtoMiro driver.
  Jeff Wade -

* Default licence: Free restricted, despite me setting 'full'.
* Matt Skipper:
  1 - Free restricted to full is manual request process
     - Matt: from free restricted to free . . why FR?
     - Then users would be created as free . .
     - When they hit the point to get to full
     - High level - created as free user
     - if lightweight miro user - stay as a free user
     **** - FreeR -> Full go to edit or create a board - automatically upgraded.
     - today, there requires ana pproval flow  -> freer -> full
     - Arvin - what flow do you process ARvin?
       - Just approve
     - 4,566 - full members
     - 1950 - fre restricted . .
     - Can we deactive to a free licence? if not use for 90 days?
     - Matt Skipper
       - Deletion vs downgrade.
       - aARON sMITH 5000 going to 6000 in oCTOBER
       - changing default to 'free' and upgarde to full won't be a big problem, only 0 licence
       - Downgrade and re-upgrade multiple times . .
       - people using it quarterly - need to keep full licence
       - General concerna bout abusing licenses.
  2 - TeamID
     - SCIMm does have this capability!?
     - Teams names in Miro - 'Best Team Ever'  . .lol
     - 



![[Pasted image 20240924122945.png]]
9/24/2024 12:36:02 PM
talking about permissions:
![[Pasted image 20240924123605.png]]

Some groups need different discovery settings
 - some hidden, some open.
 - When created as a miro user, which default groups? Obboarding is configured . .
 - We can automate users being part of a team.

recap
 - Free REstirect to Free
 - Matt and Aaron and Team to discuss.

====================================================================================================================
10/9/2024 11:13:16 AM
Getting ready for Friday meeting With Arvin:

TODO: Miro
Arvin Questions:
   - Regular monitoring of licences?
   - See if we can setup regular licence count; yes - see below




https://miro.com/api/v1/scim/Users?filter=active eq true and userType eq "Full"&count=0

result:

{
    "schemas": [
        "urn:ietf:params:scim:api:messages:2.0:ListResponse"
    ],
    "totalResults": 4393
}

curl -u "2zDSH7moc4cSKm2XcsMY:VeALaAcBnDhohjuz5eto" -X GET 


https://browserstack.com/user/user_detail"


\
Arvin: Get screenshot of current licence usage
   - How can Ops check the totals?: See if we can produce regular report??
Brandon:
   - swaMiroRoles:
       - userType is 'Free Restricted' -> 'Free' Upgrades to using one license.
       - Free Restricted
       - Free (upgrades to full upon attempt of team or board creation.)
       - Full
   - Arvin & Miro: discussion on 'expiring' old accounts.






Seen when we already have 20 full users in Miro sandbox.
```
<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoMiro" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirdi019#20240723235255#1#1:bb6ca994-a5b5-44ff-af1e-94a96cbbb5a5" level="error" type="driver-general">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Full users limit reached for organization<operation-data DRIVER_REVISION="1.6.0" objectType="employee"/>
    </status>
  </output>
</nds>
```

trace when this happens:
```


[10/10/24 14:49:20.561]:IDtoMiro ST:IDtoMiro__Scim: X-XSS-Protection: 1; mode=block
[10/10/24 14:49:20.562]:IDtoMiro ST:IDtoMiro__Scim: X-Content-Type-Options: nosniff
[10/10/24 14:49:20.562]:IDtoMiro ST:IDtoMiro__Scim: Content-Security-Policy: default-src 'unsafe-inline' 'unsafe-eval' data: blob: filesystem: about: miroapp: wss: ws: *; frame-src 'unsafe-inline' 'unsafe-eval' data: blob: miroapp: *; base-uri 'unsafe-inline' about: data: *; form-action 'unsafe-inline' data: post-it-alpha: post-it: com.mmm.postit.miro: *; worker-src 'unsafe-inline' data: blob: miroapp: *; report-uri https://o881784.ingest.us.sentry.io/api/4504797931438080/security/?sentry_key=5bc71a227959462c9e67f7be3ec5777d&sentry_environment=production;
[10/10/24 14:49:20.563]:IDtoMiro ST:IDtoMiro__Scim: X-Cache: Error from cloudfront
[10/10/24 14:49:20.563]:IDtoMiro ST:IDtoMiro__Scim: Via: 1.1 54963428d4c2676f98e0ada205d50c32.cloudfront.net (CloudFront)
[10/10/24 14:49:20.563]:IDtoMiro ST:IDtoMiro__Scim: X-Amz-Cf-Pop: DFW56-P8
[10/10/24 14:49:20.564]:IDtoMiro ST:IDtoMiro__Scim: Alt-Svc: h3=":443"; ma=86400
[10/10/24 14:49:20.564]:IDtoMiro ST:IDtoMiro__Scim: X-Amz-Cf-Id: ZaxUPdaEbdWZ6SP8NjCsLsbiL04Ktktosj-sY8unouXNUhkP-sLlBQ==
[10/10/24 14:49:20.564]:IDtoMiro ST:IDtoMiro__Scim: Sending http response with body :-
[10/10/24 14:49:20.564]:IDtoMiro ST:IDtoMiro__Scim: **********************END*****************************
[10/10/24 14:49:20.565]:IDtoMiro ST:IDtoMiro__Scim: Response code and message: 409 Conflict
[10/10/24 14:49:20.565]:IDtoMiro ST:IDtoMiro__Scim: Rest SubscriptionShim.execute() returns:
[10/10/24 14:49:20.565]:IDtoMiro ST:: Received response document from subscriber
[10/10/24 14:49:20.566]:IDtoMiro ST:
<nds dtdversion="3.0">
  <source>
    <product build="20230622_0130" version="1.2.0.0000">Identity Manager REST Driver</product>
    <contact>NetIQ Corporation.</contact>
  </source>
  <output>
    <status event-id="w11dcledirai004#20241010194918#10#1:e326d0d1-930c-417b-8348-d1d026e30c93" level="error" type="driver-general">
      <driver-operation-data class-name="urn:ietf:params:scim:schemas:core:2.0:User" command="add" dest-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e9870019960" event-id="w11dcledirai004#20241010194918#10#1:e326d0d1-930c-417b-8348-d1d026e30c93" is-sensitive="true" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e9870019960"><!-- content suppressed -->
      </driver-operation-data>
    </status>
  </output>
</nds>
[10/10/24 14:49:20.568]:IDtoMiro ST:: Transaction.execute() completed.
[10/10/24 14:49:20.568]:IDtoMiro ST:: SCIMSubscriber.execute() completed.
[10/10/24 14:49:20.568]:IDtoMiro ST:Restoring operation data to output document
[10/10/24 14:49:20.568]:IDtoMiro ST:SubscriptionShim.execute() returned:
[10/10/24 14:49:20.568]:IDtoMiro ST:
<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoMiro" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirai004#20241010194918#10#1:e326d0d1-930c-417b-8348-d1d026e30c93" level="error" type="driver-general">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Full users limit reached for organization<operation-data DRIVER_REVISION="1.8.0-CSEE-3936-x266698" objectType="employee"/>
    </status>
  </output>
</nds>
[10/10/24 14:49:20.570]:IDtoMiro ST:Applying input transformation policies.
[10/10/24 14:49:20.570]:IDtoMiro ST:Applying policy: %+C%14Clib-DriverRevision%-C.
[10/10/24 14:49:20.570]:IDtoMiro ST:  Applying to status #1.
[10/10/24 14:49:20.570]:IDtoMiro ST:    Evaluating selection criteria for rule 'lib-DriverRevision: mark each event with the current driver revision:'.
[10/10/24 14:49:20.571]:IDtoMiro ST:    Rule selected.
[10/10/24 14:49:20.571]:IDtoMiro ST:    Applying rule 'lib-DriverRevision: mark each event with the current driver revision:'.
[10/10/24 14:49:20.571]:IDtoMiro ST:      Action: do-set-op-property("DRIVER_REVISION","1.8.0-CSEE-3936-x266698").
[10/10/24 14:49:20.571]:IDtoMiro ST:        arg-string("1.8.0-CSEE-3936-x266698")
[10/10/24 14:49:20.571]:IDtoMiro ST:          token-text("1.8.0-CSEE-3936-x266698")
[10/10/24 14:49:20.572]:IDtoMiro ST:          Arg Value: "1.8.0-CSEE-3936-x266698".
[10/10/24 14:49:20.572]:IDtoMiro ST:Policy returned:
[10/10/24 14:49:20.572]:IDtoMiro ST:
<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoMiro" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirai004#20241010194918#10#1:e326d0d1-930c-417b-8348-d1d026e30c93" level="error" type="driver-general">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Full users limit reached for organization<operation-data DRIVER_REVISION="1.8.0-CSEE-3936-x266698" objectType="employee"/>
    </status>
  </output>
</nds>
[10/10/24 14:49:20.574]:IDtoMiro ST:Applying schema mapping policies to input.
[10/10/24 14:49:20.574]:IDtoMiro ST:Applying policy: %+C%14Csmp-SchemaMapping%-C.
[10/10/24 14:49:20.575]:IDtoMiro ST:Resolving association references.
[10/10/24 14:49:20.575]:IDtoMiro ST:Processing returned document.
[10/10/24 14:49:20.575]:IDtoMiro ST:Processing operation <status> for .
[10/10/24 14:49:20.575]:IDtoMiro ST:
DirXML Log Event -------------------
     Driver:   \SWACO_IDALPHA\SWA-IDALPHA\Services\DirXML\Driver Set AEv1\IDtoMiro
     Channel:  Subscriber
     Object:   \SWACO_IDALPHA\SWA-IDALPHA\Users\e9870019960
     Status:   Error
     Message:  com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Full users limit reached for organization
[10/10/24 14:49:20.577]:IDtoMiro ST:End transaction.
[10/10/24 14:49:21.681]:IDtoMiro ST:Start transaction.
[10/10/24 14:49:21.681]:IDtoMiro ST:Discarding transaction because of optimization.

```
With fix in place - the retry occurs indefinitely:

![[{781FE26E-B9D1-4ED3-8E83-DEC49F55119B}.png]]





10/22/2024 11:32:53 AM
Example paging:
https://miro.com/api/v1/scim/Users?count=3&startIndex=2



10/25/2024 2:05:39 PM
trying to get group mods to work through driver:

PUT on /Groups is not allowed:
PUT: https://miro.com/api/v1/scim/Groups/3458764604543786382

```
{
  "schemas": [
    "urn:ietf:params:scim:schemas:core:2.0:Group"
  ],
  "id": "3458764604543786382",
  "meta": {
    "resourceType": "Group",
    "location": "https://miro.com/api/v1/scim/Groups/3458764604543786382",
    "version": ""
  },
  "displayName": "Southwest Sandbox team 2",
  "members": [
    {
      "value": "3074457358396112732",
      "type": "User",
      "display": "Aaron Kynaston"
    },
    {
      "value": "3458764530280031299",
      "type": "User",
      "display": "Arvin Kamau"
    }
  ]
}
```

```

<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoMiro" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirdi019#20241025200358#18#1:17881b93-1f95-4d16-b225-931b8817951f" level="error" type="driver-general">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: {"error":{"message":"Endpoint is found, but this method is not allowed","reason":"methodNotAllowed","code":405}}<operation-data DRIVER_REVISION="1.9.0"/>
    </status>
  </output>
</nds>

```



group manipulation

Good patch operatoin notes:
https://is.docs.wso2.com/en/6.0.0/apis/scim2-patch-operations/
 {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "userName": "Frank.Tester@wnco.com",
            "displayName": "Frank V Tester",
            "userType": "Full",
            "active": true,
            "emails": [
                {
                    "value": "Frank.Tester@wnco.com",
                    "display": "Frank.Tester@wnco.com",
                    "primary": true
                }
            ],
            "photos": [
                {
                    "type": "photo"
                }
            ],
            "groups": [
                {
                    "value": "3458764575358774713",
                    "display": "Southwest Sandbox"
                },
                {
                    "value": "3458764604543786383",
                    "display": "Southwest Sandbox team 3"
                },
                {
                    "value": "3458764604543786382",
                    "display": "Southwest Sandbox team 2"
                }
            ],
            "roles": [
                {
                    "value": "ORGANIZATION_INTERNAL_ADMIN",
                    "display": "Company Admin",
                    "type": "organization_user_role",
                    "primary": true
                }
            ],
            "meta": {
                "resourceType": "User",
                "location": "https://miro.com/api/v1/scim/Users/3074457358396112732"
            }
        },




Aaron groups example
in prod:
   "groups": [
                {
                    "value": "3458764601040268321",
                    "display": "Onboarding"
                },
                {
                    "value": "3458764601040268300",
                    "display": "CyberSecurity"
                }
            ],

in dev:
 "groups": [
                {
                    "value": "3458764575358774713",
                    "display": "Southwest Sandbox"
                }
            ],



11/6/2024 1:34:04 PM
ARvin - Miro
 - Free Restircted -> Free -> full
 - From their end - they set this as a default.
 - caveat - they have mentioned - free restrcited to Free - no option to do this . .
 - don't have a scenario from freer-restrcited to free . .odd
 -  toying with an idea - of deleting fee restricted, then recreate as free . .
 - Arvin montiring this eversince change was done - haven't recieved so many people saying full license . .
 - they go as myacces . .
 - so far less work for Arvin.
 - finally got contact for Dash side - Steve Pan
   - Arvin talking with them: changing team name from ABC to XYZ - actually a manual effort to change team display name . .
   - e.g - i aaron add team to xyz - don't see xyc - see ABC . .
   - Dash . .they have to change this . .
   - How do you autosync dash names to the miro . .

 - Dash name kept in sync . . .

 - may want team displayname change - this is a pain . .

 - MyAccess: which groups to expose?

 - Super odd: 2-3 months ago - about 92 teams outside of enterprise license . . .
   - some times people can go around the pattern - and use external @wnco address . .then asked to purchase a licence . .
   - Already had a licence . . had to undertake process to bring everyone in!!
   - All 92 @wnco.com addresses had to be pulled in . .
   - We do have teams their own perosnal notebook!! but we brought it in . . .
   - Could be 50-70 teams that just have one member . . just super simple; unnecesary . .
   - Don't want to expose all the teams, as some of them should probably be deleted. . .etc . .

 - MyAccess vs Dash?
   - What do we do in Dash for teams?
   Current state:
   - Dash: Request for new team comes in . .
   - Request for
    - User to be added to team.
    - User to be removed from a team.
    - REquest to change team name
   - All come in as a DASH ticket RITM
   - Arvin - manually doing this in the GUI!!
   - Implies: Dash has it's own database of available teams and names (which are very hard to change)
   - How many groups are exposed through DASH? about 100 . .
   - Ideally Myaccess would expose at least hte same set of groups.

most people submit miro "
submit a dash ticket for a miro request."

 - Miro request - KB0102802
 - e.g. john doe - request type: add a team member
 - under add a team: select a team - some how popualting





Questions:
 - Who is this?
  Shawn Currey

1. Add or reactivate a team member
2. Remove a team member 
3. Update a team member’s access level  
4. Update team admin 
5. Create new Miro team 
6. Assistance / Question
7. 

How is this dropdownpopulated?
![[{04B62508-B751-4E99-B2F1-811FDB07908F}.png]]licence: showing how full and free restricted are optoins . .
also has database of users!!


e.g. - if one person doesn't show up in dropdown - user has to request license . . .

when did myaccess having issues about how to represent this . .
ideally - train team admins to be able to add uers . . 










Dash contact:
  Dash accessing miro directly: Aaron - talk with Steve Pan - Also Shan Currey (might be PM for dash)
	  they took his demand to how to get all udpated in dash
  

Summary email

Subject: [IDtoMiro] Summary from Miro Licensing & Teams discussion with app owner Arvin

Farhan, Angie, Brad,

Arvin and I had a chance to talk today and discussed the following items. Ultimately the next action is to discuss some options with architects to decide how we want to build and expose teams to end users. Could we please bring in the appropriate people who can make Dash/MyAccess design decisions? See details below:

Arvin, please let me know if I missed anything, or if corrections are needed.




DETAILS:
We covered the following in our discussions:

* The change from default 'Free Restricted' to 'Full' appears to have been successful, and has started to reduce Arvin's manual work (YEA!).
* We then discussed the remaining pain points related to team manipulation:
      * Dash is the only way people can request access, meaning Arvin receives manual tasks all day every day to keep people signed up for Miro.
      * Dash appears to have its own database of requestable teams that is very difficult to update.

We then discussed that ideally, Dash and/or MyAccess would standardize on a consistent way to expose groups; such as relying on the SCIM API if possible, to avoid maintaining separate databases of all team names and corresponding IDs.

Later, we discussed ways to decide which groups to expose in Dash/MyAccess based on member count, as some groups are really just imported 'personal notebook'  teams that people have created.

Next actions are as follows:
* We need to include architects who can review the following issues, and direct us toward the most desirable pattern to solve these kinds of items: 
      * We need to devise and standardize a way to list all available teams (such as an HTTP GET from https://miro.com/api/v1/scim/Groups) so MyAccess and Dash can more easily stay in sync, assuming we need both systems.
      * Dash: we need to find out what options there are in Dash to build the list of selectable groups.
      * MyAccess: based on the above bullets, we then need to build a way to expose the desirable set of groups to the end user for adding/removing users to/from a team.
* IDM driver: Once users make the appropriate requests, the IDM driver needs the ability to identify the proper teams to modify based on the request - such as receiving the actual team id - e.g. 3458764575358774713 so that the driver can be used to do the fulfillment.

Other items learned and confirmed - Technical Items learned about the API:
* The SCIM api cannot create or delete groups.
* The SCM api cannot designate admin vs user type permissions in groups.

--Aaron



11/13/2024 10:14:06 AM
Had meetings yesterday discussing how to expose teams in myaccess, and moving dash functionality to MyAccess.

11/12/2024 10:24:41 AM
Shelly Easley
idtomiro - dash
 - Dash assignment groups
 - if you want to be added; has to myaccess . .
 - Shelly's team would be the team
   - Leader on the team . .
   -

Summary:
The next actions on the Miro teams management update, we need to do the following
1 - We need to document all posible teams actions that need to be exposed: such as 'add member', 'remove member', 'change team name'.
2 - For each item in #1, decide whether or not we'd like MyAcess or Dash to provide that functionality. We will be limited by the SCIM api (it can only add/remove members); but I'd like to have super explicit list of items to cover.
3 - possiblity: can Dash make direct SCIM calls, parse JSON and populate dropdowns on the fly?
4 - Schedule with Shawn Currey, the PO for the Dash team.

Summary for Miro meeting:
 1 - FUNCTIONALITY PLACEMENT: We need to talk through how only the team membership functionality that allows adding and removing users to and from a group is going to be moved from Dash to MyAccess.  Does this change anything, or create any concern?
 2 - MYACCESS DESIGN: Assuming #1 is good, then I'd like to design how we populate the list of teams people can add/remove members to and from: Can we do it dynamically; or should we build a feedfile/jsp dynamic solution?
 3 - IDM DRIVER DESIGN: once we have the teams exposed in MyAcces, How do we want to represent team management in eDirectory from MyAccess?



12/10/2024 3:06:25 PM


4/29/2025 11:33:14 AM
Discussion with Access for Self: - could add a Miro one, but core team doesn't like this:

![[{5E8FE66B-3786-4B79-BD60-5ACB29003F60}.png]]

Atlassian example: Example - had to have a new "atlassian_cloud_role"
1608
![[Pasted image 20250429113507.png]]

4/29/2025 1:06:08 PM

$.Resources[*][?count(@.members[*]) >= 0].displayName


4/29/2025 11:38:14 AM
After discussing the next steps with Mike, here are the set of questions I need to answer now

1 - Should we add a new "Access for self & others" Miro teams entry, or add all miro teams to the preexisting applications and roles area in MyAccess?
2 - We need to determine how to use jsonPath to limit members basd on jsonpath
3 - If a displayName changes on a team, can we confirm this wouldn't cause issues?
4 - Need to decide on format of IDtoMiroRoles: would it be possible to have miro acces,s but no teams? so at least one entry of "MiroWhiteboard" maybe? This item has a story: CSEE-4631 - maybe loop through id|||displayName, and assign teams?








5/6/2025 12:01:33 PM
Miro meeting:
Aaron Kynaston
Ben Cundy
Arvin Kamau
Mike Labit
Eric Carmichael
Mark Ashley

Ben - intro
 - impasse on how to proceed
Difficulties in expsoing members through the API
 - high number of items to expose
 - Looping through the json payload to exose group > X members etc.
 - They handle 100+ tickets on a monthly basis.
 - Most just assigning folks to different teams in Miro.
 - Aaron introw
 - Mike - high number, user count . .
 - Arvin
   - stagnant updating teams from Miro - super manual, doesn't update.
   - We're pursing driver and/or myaccess to reduce manual ticint efort
   - auto approval of licence?
 - Mike:
   - Yes does exist - but any one could go in . .
   - Arvin: highest number of folks: technology
   - just technology . .just deal with it..
 - ben: lists in miro: ask to join: sends dash ticket . .
   - finding out people just let people in to miro boards . .
 - Ben: auto approving  . .
 - Arvin: get license from miro and use
   - to be coorprate team, this is a second step.
 - Ben: some 'just join', others' ask to join.
 - ASking if we can change all 'ask to join' to just 'join . .
   - not better; but it's what we're doing.
 arvin:- If Ben creates a board
   - Ben will try to get aaron miro license.
   - Ben wants me to join "Fingerprint Security" . .
   - "Digital Workplace Solutions" -> Join . .
   - ideally; board owner would approve.
   - rather stay with in miro for this process . .
   - Ben: is there a scenario where governance does need to be in place?
     - or is Scenario: only some people to approve?
     - Do some boards need the approval?
     - or Everything routes through MyAccess for approval? -> beginning of call .
   - Ben: using Dash for now . . need to confirm in App itself . .
     - dash is 'throw away effort' . .ideal, just autoapprove
   - Confirming provisioning on the normal route . .
 - people can view the board, but that's it, kwithout a licence.
 - correct - in terms of giving access: anyone can access . .
   - Arvin: yes . .concerning to give all access . .
   - Arvin to ask if there's a way to route
 - Ben: maybe designate board owner: to then go to settings; configure it . .
   - in an ideall world - they would say if possible, grea t. .
   - but if not -
 - ben: no governance now . .we could improve this . .
   - Board owners may not know to not put data . .
   - Ben - legal team request: no one confirming . .
   - If already have reduced version of control, lets do less work!
   - We should know what options are: maybe configure per board?
   - First dozen or so, have lots of users  - first 20 have lots, after that < 40 members; may be stale.
 - Arvin to find out from Miro: circle back.
  Arvin owns miro for entire entprires: Mark Ashely . .
  - Ben: confirming they se are app owners . .
  - Miro roels attribute: one is orgaination user, one is mirowhiteboard . .
  - Ben coming upw ith plan
  - Simplest path forward.
  - Arvin: confirm how to move forward: maybe trash dash.


action items from this was to wait for Arvin to talk with the app team, and see if Miro can handle all of the governance stuff as much as is needed for team assignments, and get rid of Dash's involvement.



