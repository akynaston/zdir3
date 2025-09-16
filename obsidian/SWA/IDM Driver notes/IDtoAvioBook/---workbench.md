8/20/2024 12:50:29 PM
Had a call today, e106728 didn't get updated on a PUT; despite the driver matching to it in prelive . .USER_USERNAME_IN_USE I think is the error - shoujdln't have been seen on a put . .

Note: - the ID and username mismatched on username_in_use
w


8/27/2024 12:30:02 PM
Started migratoin #2 today to clear all roles in prelive.

Image 
![[{6A0582A7-90C6-4CD5-A27B-C4709AB82C65}.png]]

10/22/2024 4:42:38 PM

Short description: the RBEAEv1 driver was built based on an IDM shim that depends on native dynamic eDirectory groups. The 'member' attribute that appears on Entitlement Policies (objectClass=DirXML-SharedProfile) is a 'virtual attribute' computed at read time for the group; meaning there is nothing there for an event to trigger, as that attribute would when setting a normal everyday group membership.  For this reason, follow these instructions to update an entitlement policy:

First, locate the 'memberQueryURL'. This attribute must be an ldap filter as described by the 'URI scheme' section here: https://en.wikipedia.org/wiki/Lightweight_Directory_Access_Protocol.

SCREENSHOT OF ENTITLEMENT POLICY

Example:

ldap:///??sub?(&(&(objectClass=inetOrgPerson)(swaDeptCode=17))(|(jobCode=DP06)(jobCode=174D))(|(swaStatus=A)(swaStatus=L)))?x-sparse

Then copy the filter portion of the filter, so just this portion:
(&(&(objectClass=inetOrgPerson)(swaDeptCode=17))(|(jobCode=DP06)(jobCode=174D))(|(swaStatus=A)(swaStatus=L)))

Then update/test/format it using Apache Directory Studio. When complete, copy the filter back into the URI format as shown above. Once that is done, you must execute a re-evaluate memberships

SCREENSHOT OF REVALUATION.

Please note, it may be desirable to select only those users you know are impacted.

TBD - if you do not know the users impacted, view the membership list.





Long description:
The RBEAEv1 driver uses the "com.novell.nds.dirxml.driver.entitlement.EntitlementServiceDriver" shim. Its dependence on using an eDirectory native group has some rather large drawbacks. Please read this article to see how eDirectory native dynamic groups work: https://support.novell.com/techcenter/articles/ana20020405.html.

The definition of an entitlement policy is created by subclassing an eDirectory native dynamic group, meaning that if you populate memberQueryURL, dgIdentity (among other attributes as desired), then the 'member' attribute appears on the object. This member attribute




 While the idea of using a dynamic group is really appealing for a solution to role management and works well for most applications, getting an IDM event submitted to a driver is another matter.

Since the 'member' attribute on an entitlement policy is a 'virtual attirbute' of sorts, it means that this attribute doesn't really exist on the entitlement policy: in fact, you can delete the member attribute entirely (assuming it has no static members), and you'll see it just appears again on the entitlement policy after a moment.

This 'virtual attribute' DOES NOT trigger events to an IDM driver. This is one of the reasons why the design of the driver was initially difficult to get support from NetIQ/OpenText as it only works well when normal every day attribute changes. What is really doing the work in most cases, is that the RBEAEv1 driver's filter is built whenever an entitlement policy definition changes: attributes are added or removed from it's filter when users edit the entitlement policy


If you edit a memberquery:

<nds dtdversion="3.0">
  <source>
    <product build="20190823_0344" instance="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1" version="4.0.0.0">DirXML Entitlement Service Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirdi019#20241022011914#1#1:5ca0dce5-3dfc-4a58-bbc7-e5dca05cfc3d" level="fatal" type="driver-status">
      <description>Entitlement policy 'swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\AvioBook-Flight-avio_atc_specialists' has been edited.  At least one membership query has changed.</description>
      <document xml:space="preserve">&lt;nds dtdversion="4.0" ndsversion="8.x">
        &lt;source>
                &lt;product edition="Advanced" version="4.8.6.0000">DirXML&lt;/product>
                &lt;contact>NetIQ Corporation&lt;/contact>
        &lt;/source>
        &lt;input>
                &lt;modify cached-time="20241022011914.492Z" class-name="DirXML-SharedProfile" event-id="w11dcledirdi019#20241022011914#1#1:5ca0dce5-3dfc-4a58-bbc7-e5dca05cfc3d" qualified-src-dn="O=swaiddev\OU=Services\OU=DirXML\CN=Driver Set AEv1\CN=Entitlement Policies\CN=AvioBook-Flight-avio_atc_specialists" src-dn="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\AvioBook-Flight-avio_atc_specialists" src-entry-id="534539" timestamp="1729559954#1">
                        &lt;association state="associated">{932F0E5E-A152-41ED-9BA1-5E0E2F9352A1}&lt;/association>
                        &lt;modify-attr attr-name="Member">
                                &lt;remove-value>
                                        &lt;value association-ref="{74E01726-214D-4AD1-8F08-2617E0744D21}" timestamp="1729559222#2" type="dn">\DEV_SWACO_ID\swaiddev\Admins\ax266698&lt;/value>
                                &lt;/remove-value>
                                &lt;remove-value>
                                        &lt;value association-ref="{8473AAEF-7F25-4A8E-89BF-EFAA7384257F}" timestamp="1729559222#3" type="dn">\DEV_SWACO_ID\swaiddev\Users\e160035&lt;/value>
                                &lt;/remove-value>
                                &lt;remove-value>
.
.
.
                                &lt;remove-value>
                                        &lt;value association-ref="{0CA4A638-A4AC-4830-0DA0-38A6A40CACA4}" timestamp="1729559222#17" type="dn">\DEV_SWACO_ID\swaiddev\Users\e105127&lt;/value>
                                &lt;/remove-value>
                        &lt;/modify-attr>
                &lt;/modify>
        &lt;/input>
&lt;/nds></document>
      <operation-data DRIVER_REVISION="1.3.1"/>
    </status>
  </output>
</nds>



(&
    (swaDeptCode=17)
    (|
        (jobCode=DP06)
        (jobCode=174D)
    )
    (|
        (swaStatus=A)
        (swaStatus=L)
    )
)




Static first line:
Application ID,Username,Application Role
9216,x266698,Percy-User
9216,[USERCN],[bstack_product]-[bstack_role]



's/"//g'



12/10/2024 2:10:33 PM
Qualification changes needed for https://southwest.atlassian.net/browse/CSEE-4231 - 


IDtoaviobook qualifications


[12/04/24 02:20:09.561]:IDtoAvioBook ST:
<nds dtdversion="3.0">
  <source>
    <product build="20240514_0216" version="1.2.0.0100">Identity Manager REST Driver</product>
    <contact>NetIQ Corporation.</contact>
  </source>
  <output>
    <status event-id="w11dcledirdi019#20241204082006#1#1:914c48e5-82e0-4ce2-9adf-e5484c91e082" level="success" type="driver-general">
      <driver-operation-data class-name="User" command="add" dest-dn="\DEV_SWACO_ID\swaiddev\Users\e102913" event-id="w11dcledirdi019#20241204082006#1#1:914c48e5-82e0-4ce2-9adf-e5484c91e082" is-not-sensitive="true" src-dn="\DEV_SWACO_ID\swaiddev\Users\e102913">
        <response>
          <url-token/>
          <header AVIO-Token="eyJraWQiOiIxNDg4NDk1MTU1IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiIzNTg3ZGQxNS1kZTg4LTQ5NzMtOGNlMS1hOTIzOWQ4NjZjMzQiLCJuYmYiOjE3MzMzMDA0MDksImNhblJldHJpZXZlUGVybWlzc2lvbnMiOnRydWUsInJvbGVzIjpbIjY0YjUwMWE4LWZhMmItNGY2ZC04ZjlmLTcyZDBkNGJlZDdlNSIsImFwaS11c2VyLXJvbGUiXSwib3JnYW5pemF0aW9uIjoiZGVmYXVsdCIsImlzcyI6ImlkZW50aXR5LXByb3ZpZGVyLXNlcnZpY2UiLCJjYW5Bc3NpZ25QZXJtaXNzaW9ucyI6dHJ1ZSwibmFtZSI6IlNXQSBJRFAiLCJ1c2VyVHlwZSI6IlVTRVIiLCJleHAiOjE3MzMzMDA3MDksImlhdCI6MTczMzMwMDQwOSwidXNlcm5hbWUiOiJhdmlvLWlkcC1hcGkifQ.SbxAVb_XEE1cUU11dlylBv-jOjb4_2vDaRicil4iojj1N2PRItFFM11EQKk_E-adDCZQGdvsTjyw9yMnfxx5SpypnpEVdskwtQmVdedsj9cakb9e6pIHnbGXzfHen2jE3JGtQdNYVPz3Hv8cW0YQWbrmxBrPSs2JiYc1u7MQa5ajzHf6eUyMHZWU9NM-3-ixW2wLXNhHjXntCJoYbs45NWxXbVmAn7oUW7f_4pMKVRtwVPZv4TlkLGDig4vGFQAUQdwEDXxoSTrbfFy94ocn0T5wcVeSOBkctKN568nTUrj_ZM9TrxjrkEhs9Y1yjItHB754G7nvgWERKe_j8U6atg" User-Agent="SWA" content-type="application/json"/>
          <header User-Agent="SWA" content-type="application/json"/>
          <header User-Agent="SWA"/>
          <response-header Cache-Control="no-cache, no-store, must-revalidate" Connection="keep-alive" Content-Length="709" Content-Security-Policy="default-src 'self' sandbox ''; frame-ancestors 'self'" Content-Type="application/json" Date="Wed, 04 Dec 2024 08:20:09 GMT" Strict-Transport-Security="max-age=31536000; includeSubDomains" X-Content-Type-Options="nosniff"/>
          <value message="Created" status="201">{"id":"e102913","email":"none@testwnco.com","firstName":"Robyn Nico keith","middleName":"V","lastName":"Carino","preferredName":"Robyn","credentials":{"username":"e102913"},"organization":"default","systemRole":"USER","locked":false,"roles":[{"id":"avio_cabin_fa","type":"USER","name":"avio_cabin_fa","organization":"default","archived":false,"createdAt":"2024-05-30T22:36:59Z","modifiedAt":"2024-12-04T08:20:09.490734Z"}],"active":true,"archived":false,"createdAt":"2024-12-04T08:20:09.492023Z","submittedAt":"2024-12-04T08:20:09.491234Z","submittedBy":"3587dd15-de88-4973-8ce1-a9239d866c34","modifiedAt":"2024-12-04T08:20:09.492023Z","modifiedBy":"3587dd15-de88-4973-8ce1-a9239d866c34","function":"UNKNOWN"}</value>
        </response>
      </driver-operation-data>
      <operation-data DRIVER_REVISION="1.6.5" objectType="employee" opAvioBookRoles="#avio_cabin_fa"/>
    </status>
  </output>
</nds>

build payload:
[12/04/24 02:20:09.575]:IDtoAvioBook ST:      Action: do-invoke-rest-endpoint(auth-method="basic",id="avio-idp-api",time-out="60000",type="PUT",url="https://dev.swa.aviobook.aero/core/api/qualification/20_2/users",arg-password(token-named-password("sub-password")),"/opt/idmfiles/idmkeystores/default/cacerts","changeit","Content-Type","application/json","[
    {
        "id":""+token-xpath("substring-before(substring-after(./driver-operation-data/response/value/text(),'"id":"'),'","')")+"",
  "qualifications": [
    {
      "id": "avio_qual_b737"
    },
    {
      "id": "avio_qual_b737_700"
    },
    {
      "id": "avio_qual_b737_800"
    },
    {
      "id": "avio_qual_b737_max7"
    },
    {
      "id": "avio_qual_b737_max8"
    }
  ]
}
]").




12/9/2024 2:35:46 PM
IDToAviobook quals call
   - IDs are the same idea as the previous model
   - Quals - can be blank .
   - role to qualifications - 0 to many . .
   - soonish . .
   -


12/10/2024 2:13:02 PM
Migrated new roles to prod yesterday: 'Connect' roles - counts


goops - 3306 members
goramp - 14,637 members
gosups - 3,248 members

4/25/2025 10:32:13 AM
Confirmed that we can use swaAviobookRoles to set dynamic roles if they need to be forced. Then, when they gain the autorole, we canr emove the old static role safely. The dynamic role processing does ignore the already set role the first time around.


4/28/2025 12:18:17 PM
Had aviobook meeting: had about 600 users to push - 422 from Duce Duce, then did another for all prehire FAs.
Team, just a quick update for you: Duce has sent a list of 422 users to push as of now. 5 of them didn't exist, 33 were terminated, and a single user, e188711  has an issue in workday that I am asking about. The remaining users have been successfully pushed. I've updated Duce with the latest lists of users that didn't sync for one reason or another.

Resolution above was to use swaAvioBookRoles to manually push about 600 users to aviobook. Note: once these users are hired, I should remove their static role setting:

this query shows all users that have both the manual and dynamic, so need the manual value removed.
```
(&
    (swaAvioBookRoles=avio_cabin_fa)
    (DirXML-EntitlementRef=cn=SWA AvioBook Role,cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#<ref><src>RBE</src><id>SWA-ID\5cServices\5cDirXML\5cDriver Set AEv1\5cEntitlement Policies\5cAvioBook-Cabin-avio_cabin_fa</id><param>avio_cabin_fa</param></ref>)
)
```

4/28/2025 12:47:15 PM
still can't find e188711 - user does appear in an impworker attmept.

4/29/2025 11:15:04 AM

Got e135505 - when sent to aviobook:
[{"code":"USER_USERNAME_IN_USE","message":"Username 'e135505' is in use."}]<

Reason: the ID and username didn't match
```

     "id": "53a72b20-d12a-4924-8c97-de78f277aaa8",  
      "email": "Shaun.Hilliard@wnco.com",  
      "firstName": "Shaun",  
      "lastName": "Hilliard",  
      "info": "SWAU Inflight Initial Training",  
      "credentials": {  
        "username": "e135505"
```

4/29/2025 1:06:21 PM
fixed user: id didn't match unsernmae

{
  "limit": 25,
  "offset": 0,
  "total": 1,
  "items": [
    {
      "id": "53a72b20-d12a-4924-8c97-de78f277aaa8",
      "email": "Shaun.Hilliard@wnco.com",
      "firstName": "Shaun",
      "lastName": "Hilliard",
      "info": "SWAU Inflight Initial Training",

      "credentials": {
        "username": "e135505"
      },
      "organization": "default",
      "systemRole": "USER",
      "locked": false,
      "roles": [
        {
          "id": "avio_cabin_fa",
          "type": "USER",
          "name": "avio_cabin_fa",
          "organization": "default",
          "archived": false,
          "createdAt": "2024-08-09T00:14:42Z",
          "modifiedAt": "2025-04-29T17:05:13Z"
        }
      ],
      "active": true,
      "archived": false,
      "createdAt": "2024-12-03T18:53:45Z",
      "submittedAt": "2024-12-18T01:36:32.12306Z",
      "submittedBy": "e83397",
      "modifiedAt": "2025-04-29T16:36:46Z",
      "modifiedBy": "e83397",
      "function": "CABIN_CREW"
    }
  ]
}



4/29/2025 1:07:14 PM

4/28/2025 1:18:07 PM
avio_cabin_fa - 21,276 in PROD, before swaStatusP added, now 21,632 - increase of 356
ldap:///??sub?(&(|(jobCode=FA99)(jobCode=FABL)(jobCode=FA01))(|(swaStatus=A)(swaStatus=L)(swaStatus=P))(swaDeptCode=04))

avio_cabin_fa in dev - 23,012 beofre, 23,514 after increase




4/29/2025 1:09:21 PM


Query to find users that need manual assignment of the avio_cabin_fa role:
(&
    (!(swaAvioBookRoles=avio_cabin_fa))
    (!(DirXML-EntitlementRef=cn=SWA AvioBook Role,cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#<ref><src>RBE</src><id>SWA-ID\5cServices\5cDirXML\5cDriver Set AEv1\5cEntitlement Policies\5cAvioBook-Cabin-avio_cabin_fa</id><param>avio_cabin_fa</param></ref>))
    (swaDeptCode=04)
    (|
        (swaStatus=L)
        (swaStatus=A)
        (swaStatus=P)
    )
    (|
        (jobCode=FA01)
        (jobCode=FABL)
        (jobCode=FA99)
    )
)

Query to fidn users that have boht the automated and manual role:
(&
    (swaAvioBookRoles=avio_cabin_fa)
    (DirXML-EntitlementRef=cn=SWA AvioBook Role,cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#<ref><src>RBE</src><id>SWA-ID\5cServices\5cDirXML\5cDriver Set AEv1\5cEntitlement Policies\5cAvioBook-Cabin-avio_cabin_fa</id><param>avio_cabin_fa</param></ref>)
)


cn=SWA AvioBook Role,cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#<ref><src>RBE</src><id>SWA-ID\Services\DirXML\Driver Set AEv1\Entitlement Policies\AvioBook-Cabin-avio_cabin_fa</id><param>avio_cabin_fa</param></ref>




Users with a job code  that I don't recognize as a flight attendant, and user status nots:
e185720 - STMS
e145748 - OP01
e104044 - MX15
e147480 - CS02 - L (user on leave . .I'll assume they need to provision anyway)
e178704 - CS01
e177949 - CS01
e163373 - CS01
e163352 - CS01
e163162 - CS01
e150864 - CS01 - T (terminated, not provisioning)
e158723 - CC91 - T (terminated, not provisioning)



4/29/2025 1:36:06 PM

4/28/2025 8:12:51 AM
2025-04-28 Status from today's call:

We discusssed a recent issue where prehired flight attendants need to be provisioned to Aviobook as soon as they appear in the system, and not on their hire date. To solve this issue, there's a short term and long term component:

Short term: We have a way to manually assign the role to users so they can be immediately provisioned (swaAvioBookRoles = avio_cabin_fa) for all FA01, prehire flight attendants. Duce will provide Aaron a list every Friday of the class going live. Additional updated lists may be sent as needed for users coming into the system at odd times.  For each of these lists, Aaron will manually assign the role for those users, and provision them in Aviobook so they have the access they need on day 1 of their prehire state.

Long term: We are going to change the definition of the avio_cabin_fa role to include flight attendants (FA01) in a prehire state (swaStatus=P) to be automatically assigned the avio_cabin_fa role.

Duce has already sent the first list of prehires that should be in the system; so I'll work on provisioning these users asap.







4/28/2025 7:55:09 AM
IDtoAvioBook

Driver doc: swaStatus=P adding to role definition

https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74553541/IDtoAvioBook



Short term: pushing avio_cabin_fa role manually
   - Assign swaAvioBookRole -> avio_cabin_fa
   - Manual prehire vs list of users in class only
   - Friday before week 1 . .
   - Every Friday
     - Duce to generate list in their every Friday
     -

Long term: updating role definition to include swaStatus=P
  (kind of) - - update role definition
  -

Jet bridge Aduio?? separate group


5/2/2025 5:18:34 PM

Whenever an ID does not match a credential.username in aviobook, you can do this to delete and recreate the user through the driver:
Aviobook: Document user re-creation process (easiest path to reoslve bad ID vs usernmae mismatch)
 - First login
 - Get user id: from the 'id' field:
 - HTTP GET https://prod.swa.aviobook.aero/idp/users?query=credentials.username==e107187
 - Copy ID from id field
 - replace it here, then call delete:
 - HTTP DELTE https://prod.swa.aviobook.aero/idp/users/(full id goes here e.g.:7cea0d25-db70-4eab-92bc-774061b31757)



5/5/2025 3:36:00 PM
Having issues with DEV right now - found we may need to remove all of the []'s and make the values not be 1 value array;s but just send them as normal JSON strings now . .asking aviobook support.

Example of a working entry from Production that still relys on this:

```
[05/05/25 16:05:17.831]:IDtoAvioBook ST:Submitting document to subscriber shim:
[05/05/25 16:05:17.831]:IDtoAvioBook ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <driver-operation-data class-name="User" command="add" event-id="w11scledirsi009#20250505210515#1#14:77db8054-d457-4885-8176-5480db7757d4" is-not-sensitive="true" src-dn="\SWACO_ID\SWA-ID\Users\e163215">
      <request>
        <url-token/>
        <header AVIO-Token="eyJraWQiOiIxNTU1NzY2Nzc1IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhdmlvLWlkcC1hcGkiLCJuYmYiOjE3NDY0NzkxMTcsImNhblJldHJpZXZlUGVybWlzc2lvbnMiOnRydWUsInJvbGVzIjpbImFwaS11c2VyLXJvbGUiLCJpZHAtdXNlci1yb2xlIl0sIm9yZ2FuaXphdGlvbiI6ImRlZmF1bHQiLCJpc3MiOiJpZGVudGl0eS1wcm92aWRlci1zZXJ2aWNlIiwiY2FuQXNzaWduUG
VybWlzc2lvbnMiOnRydWUsIm5hbWUiOiJJRFAgQVBJIiwidXNlclR5cGUiOiJVU0VSIiwiZXhwIjoxNzQ2NDc5NDE3LCJpYXQiOjE3NDY0NzkxMTcsInVzZXJuYW1lIjoiYXZpby1pZHAtYXBpIn0.QNMTt5rchihZynbuec63zJmP8V4y5n4JrD_5Px_QUODKnGJXeSQj6DTwAq9nVz9yIYp9XrmvSSMupzQdkpQ605ExcGfQ1fejkqCjdNRI1oWyZO249XevZvGJYvTC2L7-kyaEADjibv9WBYDECYxIh79C4gvv2F2i-lWG6Cg
gq-bhwN2yN8IkWgBSXdqIdJyOPcqN65CiSVrRWZs2W1QFdmiQmLsnZyLuAUj-VylPg24foHxRuJtlVrYbIibln1Ku9Oty6SCsHDn13vSrkCDttLg-mo591b_w3eTR1PlLoXn-w8WYihpwOi2DmY54g7NxGu6p0ijKD0VEhFUbj63rng" User-Agent="SWA" content-type="application/json"/>
        <header User-Agent="SWA" content-type="application/json"/>
        <header User-Agent="SWA"/>
        <value>[{"firstName":["Kendra"],"middleName":["N"],"email":["Kendra.Stewart@wnco.com"],"lastName":["Stewart"],"organization":["default"],"systemRole":["USER"],"active":["true"],"id":"e163215","credentials":{"username":"e163215"},"roles":[{"organization":"default","id":"avio_cabin_fa","name":"avio_cabin_fa"}]
}]</value>
      </request>
      <operation-data DRIVER_REVISION="1.9.0" objectType="employee" opAvioBookRoles="#avio_cabin_fa"/>
    </driver-operation-data>
  </input>
</nds>
[05/05/25 16:05:17.833]:IDtoAvioBook ST:Stripping operation data from input document
[05/05/25 16:05:17.833]:IDtoAvioBook ST:IDtoAvioBook: RESTSubscriptionShim.execute() :
[05/05/25 16:05:17.833]:IDtoAvioBook ST:IDtoAvioBook: addHandler
[05/05/25 16:05:17.833]:IDtoAvioBook ST:IDtoAvioBook: addHandler: class-name == 'User'
[05/05/25 16:05:17.833]:IDtoAvioBook ST:IDtoAvioBook: Add: preparing POST to https://prod.swa.aviobook.aero/idp/users/
[05/05/25 16:05:17.833]:IDtoAvioBook ST:IDtoAvioBook: Resetting headers
[05/05/25 16:05:17.834]:IDtoAvioBook ST:IDtoAvioBook: Setting the following HTTP request properties:
 Authorization: <content suppressed>
[05/05/25 16:05:17.834]:IDtoAvioBook ST:IDtoAvioBook:  User-Agent:SWA
[05/05/25 16:05:17.834]:IDtoAvioBook ST:IDtoAvioBook:  content-type:application/json
[05/05/25 16:05:17.834]:IDtoAvioBook ST:IDtoAvioBook:  AVIO-Token:eyJraWQiOiIxNTU1NzY2Nzc1IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhdmlvLWlkcC1hcGkiLCJuYmYiOjE3NDY0NzkxMTcsImNhblJldHJpZXZlUGVybWlzc2lvbnMiOnRydWUsInJvbGVzIjpbImFwaS11c2VyLXJvbGUiLCJpZHAtdXNlci1yb2xlIl0sIm9yZ2FuaXphdGlvbiI6ImRlZmF1bHQiLCJpc3MiOiJpZGVudGl0eS1w
cm92aWRlci1zZXJ2aWNlIiwiY2FuQXNzaWduUGVybWlzc2lvbnMiOnRydWUsIm5hbWUiOiJJRFAgQVBJIiwidXNlclR5cGUiOiJVU0VSIiwiZXhwIjoxNzQ2NDc5NDE3LCJpYXQiOjE3NDY0NzkxMTcsInVzZXJuYW1lIjoiYXZpby1pZHAtYXBpIn0.QNMTt5rchihZynbuec63zJmP8V4y5n4JrD_5Px_QUODKnGJXeSQj6DTwAq9nVz9yIYp9XrmvSSMupzQdkpQ605ExcGfQ1fejkqCjdNRI1oWyZO249XevZvGJYvTC2L7-k
yaEADjibv9WBYDECYxIh79C4gvv2F2i-lWG6Cggq-bhwN2yN8IkWgBSXdqIdJyOPcqN65CiSVrRWZs2W1QFdmiQmLsnZyLuAUj-VylPg24foHxRuJtlVrYbIibln1Ku9Oty6SCsHDn13vSrkCDttLg-mo591b_w3eTR1PlLoXn-w8WYihpwOi2DmY54g7NxGu6p0ijKD0VEhFUbj63rng
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: Adding Custom Headers to Annonymous login
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: Annonymous login
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP POST with 304 bytes of data to https://prod.swa.aviobook.aero/idp/users/
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: *******************************************************
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: **********************LOGGING REQUEST******************
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: *******************************************************
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: Request URL :https://prod.swa.aviobook.aero/idp/users/
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: Http Method : POST
[05/05/25 16:05:17.835]:IDtoAvioBook ST:IDtoAvioBook: Sending http request with below headers :-
[05/05/25 16:05:17.836]:IDtoAvioBook ST:IDtoAvioBook: Authorization: <content suppressed>
[05/05/25 16:05:17.836]:IDtoAvioBook ST:IDtoAvioBook: User-Agent: SWA
[05/05/25 16:05:17.836]:IDtoAvioBook ST:IDtoAvioBook: content-type: application/json
[05/05/25 16:05:17.836]:IDtoAvioBook ST:IDtoAvioBook: AVIO-Token: eyJraWQiOiIxNTU1NzY2Nzc1IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhdmlvLWlkcC1hcGkiLCJuYmYiOjE3NDY0NzkxMTcsImNhblJldHJpZXZlUGVybWlzc2lvbnMiOnRydWUsInJvbGVzIjpbImFwaS11c2VyLXJvbGUiLCJpZHAtdXNlci1yb2xlIl0sIm9yZ2FuaXphdGlvbiI6ImRlZmF1bHQiLCJpc3MiOiJpZGVudGl0eS1wcm92aWRlci1zZXJ2aWNlIiwiY2FuQXNzaWduUGVybWlzc2lvbnMiOnRydWUsIm5hbWUiOiJJRFAgQVBJIiwidXNlclR5cGUiOiJVU0VSIiwiZXhwIjoxNzQ2NDc5NDE3LCJpYXQiOjE3NDY0NzkxMTcsInVzZXJuYW1lIjoiYXZpby1pZHAtYXBpIn0.QNMTt5rchihZynbuec63zJmP8V4y5n4JrD_5Px_QUODKnGJXeSQj6DTwAq9nVz9yIYp9XrmvSSMupzQdkpQ605ExcGfQ1fejkqCjdNRI1oWyZO249XevZvGJYvTC2L7-kyaEADjibv9WBYDECYxIh79C4gvv2F2i-lWG6Cggq-bhwN2yN8IkWgBSXdqIdJyOPcqN65CiSVrRWZs2W1QFdmiQmLsnZyLuAUj-VylPg24foHxRuJtlVrYbIibln1Ku9Oty6SCsHDn13vSrkCDttLg-mo591b_w3eTR1PlLoXn-w8WYihpwOi2DmY54g7NxGu6p0ijKD0VEhFUbj63rng
[05/05/25 16:05:17.837]:IDtoAvioBook ST:IDtoAvioBook: User-Agent: SWA
[05/05/25 16:05:17.837]:IDtoAvioBook ST:IDtoAvioBook: X-api-version: 1
[05/05/25 16:05:17.837]:IDtoAvioBook ST:IDtoAvioBook: ***************************END**************************
[05/05/25 16:05:17.895]:IDtoAvioBook ST:IDtoAvioBook: ********************************************************
[05/05/25 16:05:17.895]:IDtoAvioBook ST:IDtoAvioBook: ***********************LOGGING RESPONSE*****************
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: ********************************************************
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Http response code : 201
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Http response status : HTTP/1.1 201 Created
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Getting http response with below headers :-
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Date: Mon, 05 May 2025 21:05:17 GMT
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Content-Type: application/json
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Content-Length: 634
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Connection: keep-alive
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Cache-Control: no-cache, no-store, must-revalidate
[05/05/25 16:05:17.896]:IDtoAvioBook ST:IDtoAvioBook: Content-Security-Policy: default-src 'self' sandbox ''; frame-ancestors 'self'
[05/05/25 16:05:17.897]:IDtoAvioBook ST:IDtoAvioBook: X-Content-Type-Options: nosniff
[05/05/25 16:05:17.897]:IDtoAvioBook ST:IDtoAvioBook: Strict-Transport-Security: max-age=31536000; includeSubDomains
[05/05/25 16:05:17.897]:IDtoAvioBook ST:IDtoAvioBook: Sending http response with body :-
[05/05/25 16:05:17.897]:IDtoAvioBook ST:IDtoAvioBook: **********************END*****************************
[05/05/25 16:05:17.897]:IDtoAvioBook ST:IDtoAvioBook: Response code and message: 201 Created
[05/05/25 16:05:17.897]:IDtoAvioBook ST:Restoring operation data to output document
[05/05/25 16:05:17.897]:IDtoAvioBook ST:SubscriptionShim.execute() returned:
[05/05/25 16:05:17.897]:IDtoAvioBook ST:

```

5/5/2025 4:15:13 PM
Debugging error . . the bottom line is that it looks like nothing can be an array except for roles, which must be:


This one works
{
    "firstName": "Idm",
    "email": "idm.tester@gmail.com",
    "lastName": "Tester",
    "organization": "default",
    "systemRole": "USER",
    "active": "true",
    "id": "e8566009432",
    "credentials": {
        "username": "e8566009432"
    },
    "roles": [
        {
            "organization": "default",
            "id": "avio_pilot",
            "name": "avio_pilot"
        }
    ]
}



5/5/2025 12:23:43 PM
avio manual create just succeeded

POST: https://dev.swa.aviobook.aero/idp/users
{
    "firstName": "aaron",
    "middleName": "evans",
    "email": "a.b@wnco.com",
    "lastName": "walternator",
    "organization": "default",
    "systemRole": "USER",
    "active": true,
    "id": "e1071879999",
    "credentials": {
        "username": "e1071879999"
    },
    "locked": false,
    "roles": [
        {
            "organization": "default",
            "id": "avio_cabin_fa",
            "type": "USER",
            "name": "avio_cabin_fa",
        }
    ],
    "function": "UNKNOWN"
}


    {
    "id": "e1071879999",
    "email": "a.b@wnco.com",
    "firstName": "aaron",
    "middleName": "evans",
    "lastName": "walternator",
    "credentials": {
        "username": "e1071879999"
    },
    "organization": "default",
    "systemRole": "USER",
    "locked": false,
    "roles": [
        {
            "id": "avio_cabin_fa",
            "type": "USER",
            "name": "avio_cabin_fa",
            "organization": "default",
            "archived": false,
            "createdAt": "2024-05-30T22:36:59Z",
            "modifiedAt": "2025-04-28T16:24:04Z"
        }
    ],
    "active": true,
    "archived": false,
    "createdAt": "2025-05-05T18:23:11.564832034Z",
    "submittedAt": "2025-05-05T18:23:11.562004382Z",
    "submittedBy": "3587dd15-de88-4973-8ce1-a9239d866c34",
    "modifiedAt": "2025-05-05T18:23:11.564832034Z",
    "modifiedBy": "3587dd15-de88-4973-8ce1-a9239d866c34",
    "function": "UNKNOWN"
}

This one does not . .but if you remove all []'s except for the roles, then it works
[
    {
        "firstName": [
            "Joseph"
        ],
        "middleName": [
            "A"
        ],
        "email": [
            "e70000-invalid@wnco.com"
        ],
        "preferredName": [
            "Joey"
        ],
        "lastName": [
            "Sapiens"
        ],
        "organization": [
            "default"
        ],
        "systemRole": [
            "USER"
        ],
        "active": [
            "true"
        ],
        "id": "e70000",
        "credentials": {
            "username": "e70000"
        },
        "roles": [
            {
                "organization": "default",
                "id": "avio_flight_compliance_dailyops",
                "name": "avio_flight_compliance_dailyops"
            }
        ]
    }
]


5/6/2025 9:45:04 AM
	avio_chiefs
	avio_dispatchers
    avio_dispatch_specialists
    avio_atc_specialists
    avio_chiefs
    avio_network_directors


5/9/2025 11:50:03 AM
Just sent to aviobook team to rpepare for prod deploy

Nader and team, I've completed the latest updates and have validated through QA. Thanks for the idea to use the 'test' end point Nader, that helped get past the worst of my troubles.  Here are the changes going in. Please let me know if/when I can proceed, or if you'd like to chat first.

Version 1.9.4 of the driver has these updates (since version 1.9.0 which is in production now):  
1 - avio_cabin_fa FA role will now be applied to prehire FAs automatically. (Thanks Duce, for helping identify users to push in the mean time. After this deploy, we won't need to do this any more).  
2 - The avio_pilot now receives 6 qualifications; the 5 defaults have been added:  
    "qualifications": [  
        {"id": "fltops_pilot"},  
        {"id": "avio_qual_b737"},  
        {"id": "avio_qual_b737_700"},  
        {"id": "avio_qual_b737_800"},  
        {"id": "avio_qual_b737_max7"},  
        {"id": "avio_qual_b737_max8"}  
      ]  
3 - Some minor corrections have been made to re-org definition on the roles (per recent INCs).



5/9/2025 1:59:15 PM
Notes from Nader - how cool:
![[Pasted image 20250509135919.png]]


5/12/2025 4:21:32 PM



Amy Ashkinazy Murrell


Amy, that chat was FANTASTIC! Thank you for the time.  Here is what we learned:

1 - Any user created manually where the 'id' field is not populated will cause issues for the driver: if id and username mismatch, the user will fail to update the user.
2 - MyAccess seems to have an odd delay between leader approval and fulfillment (aka swaAviobookRoles seems to take longer than expected . . ) we need to find out how long this takes.
3 The - Pilots_D


Action items:

Aaron:
 1 - Aaron to update avio_pilots auto role to essentially be equal to Pilots_D
 2 - Ensure the "CybersecurityEnterpriseEnablementTeam-DG@wnco.com" team is included for every manually created user for now to confirm the driver can keep the user in sync. Long term we'll update Ops so they know how to do this action.
 3 - Aaron to find out how long it takes for a role requested in MyAccess to write to the swaAvioBookRoles attribute.

Amy:
 1 - Confirm EFB team knows to properly match the username and ID during manual user creation.
 2 - Confirm EFB team includes the EE team (Aaron Kynaston for now) on every manual creation so that we can ensure the driver can properly set roles, qualifications and function.



DETAILS:
Here are some users we covered, and information found:
 - e68528: had a new jobcode of 347F, I now have a way to match Pilots_D group; so I'm adding this to our backlog for scheduling.
 - e77932 - the avio_aarp role was not added to the user by MyAccess for some reason: After Amy requested it, and the leader approved it; there seems to be a delay before MyAccess gives this new role to the driver.






1 - Aaron to match pilots_d
2 - Amy to researcha nd update team on manual entry
   - * Ensure id and username match
   - Maybey notify EE: push user through driver, and see the user is clea.






1 - Aaron: reproduce error assign avio_pilot manually, show error in driver
2 - Aaron: Delete user in Avibook - confirm he's gone
*3 - EFB Team: Recreate it - compare it . .
     - making him pilot . .YES: id = username = good
4 - Aaron: Delete ueser in aviobook
*5 - Aaron: driver create it
   - 68528 . . .
   - YES!! Good!!
** - pilots_D must tell me & kinsley: causing: id/username . .
- amy: other issues . . .
Now - e77932 - Grant MOrris
   - Issue: Only had role
    avio_pilot - already had . .
    Amy: avio_aarp - then lost pilot!!
    Requested it . . .Just leader has to approve it . .1:05 - 10 mins ago . .
       - Find out why avio_aarp not written . .
       -





[{"code":"USER_USERNAME_IN_USE","message":"Username 'e68528' is in use."}]



Amy issues described:
   - If I fix driver  = pilots_D & different team, new title . .
     - I need to be a part of this . . .
     - Amy asked team to talk with Pilots_D, to add task to tell me about it . .
   - CybersecurityEnterpriseEnablementTeam-DG@wnco.com


   - bada1bce-c0c1-49f3-a1cb-92da36fbd388
     - When aviobook creates a user -
       -


   - Amy todo: More research on manual creation why/when
     -

  Tom Lews . .


****
1 - Pilots_D != avio_pilots role definition - example: Thomas lewis - e68528
  Amy - note: if add somemone manually, do myaccess . .
  -

2 - MyAccess : and auto roles should be combined; don't seem to always work here . .
   - e35683 - Allen Durham - 745A currently is part of avio_pilots
   - Could be manual work in Avibook . .
   - left with Amy on this one . . .
3 - Question: manual add of person . .
   - when driver enters - los of access
   - How often: If some one doesn't have access: getting ready to fly, need to be able to fly now!!
   - Donesn't happen a lot, but didn't know what we didn't knwo . . .Some things . .
   - If we match up pilots_D


 - Kinsley Johnson - Or Duce Duce (Josuha Duce)
   - Can chat about id/username mismatch . .







5/12/2025 11:30:33 AM
Avio - only a pilot . .


cn=Pilots_D,ou=Groups,o=SWA-ID
   - 11484 members
(&
    (|
        (cn=e77932)
        (cn=e68528)
    )
    (groupMembership=cn=Pilots_D,ou=Groups,o=SWA-ID)
)

5/12/2025 10:37:56 AM
Amy Askinazy Murrell
e68528 - no access now . .
e77932 - has access . .




Questions:
     - Like to resolve 68528 with you; and make sure we're using thes ame vocabulary
     - From my perspective, a user can get access into aviobook in one of two ways: automaitcaly through their data, or exlicitly through MyAccess.
     - Both of those forms of access I'm going to call a role.



     - Within aviobook, along with the role, we also assign a Function, and one or more qualificatoins.
     Roles:
     (two examples of many; both of these are auto roles)
      avio_pilot
      avio_cabin_fa

      qualifications:
          inflight_cabin

          fltops_pilot
          avio_qual_b737
          avio_qual_b737_700
          avio_qual_b737_800
          avio_qual_b737_max7
          avio_qual_b737_max8

      Function - name is different between the API and the GUI; but I think they appear somewhat siliarly.
        CABIN_CREW
        ADMINISTRATOR
        GROUND_HANDLER
        PILOT



   - Who updates the Pilots_D group, and how often does it change?
     - Amy: Changes . .in the last month: new job title . .Tom Lewis . .347F
     - Second person: Grant Morris:
       - Had a role part of Pilots_D, switched role to antoher role . . another in Pilots_D
       - had another request: avio-sme - lost secondary access . .
       - Lost access!
       - avio_pilot_sme
       - e68528 - Fully described: new 347F not part of avio_pilot definition


   - I think you and I have touched on at least two issues:
     - Pilots losing access
     - Adding a second role through MyAccess loses the first one?
- 




5/8/2025 12:21:31 PM
test is now working

{
    "id": "e8566007659",
    "email": "idm.tester@gmail.com",
    "firstName": "Idm",
    "lastName": "Tester",
    "credentials": {
        "username": "e8566007659"
    },
    "organization": "default",
    "systemRole": "USER",
    "locked": false,
    "roles": [
        {
            "id": "avio_pilot",
            "type": "USER",
            "name": "avio_pilot",
            "organization": "default",
            "archived": false,
            "createdAt": "2024-07-12T16:12:21Z",
            "modifiedAt": "2025-05-08T18:20:39Z"
        }
    ],
    "active": true,
    "archived": false,
    "createdAt": "2025-05-08T18:20:39Z",
    "submittedAt": "2025-05-08T18:20:38.93588Z",
    "submittedBy": "avio-idp-api",
    "modifiedAt": "2025-05-08T18:20:39Z",
    "modifiedBy": "avio-idp-api",
    "function": "UNKNOWN"
}




5/8/2025 11:39:30 AM
Aviobook notes:
DEV
  Disabled IDtoaviobookPrelive; since i"m connecting the main driver to test due to the broken api
  -


19 20


5/7/2025 2:05:07 PM
coopervision
found I have an old pdf . . need to get ne offer coe . .



Good:
{
  "firstName": "Idm",
  "email": "idm.tester@gmail.com",
  "lastName": "Tester",
  "organization": "default",
  "systemRole": "USER",
  "active": "true",
  "id": "e8566004870",
  "credentials": {
    "username": "e8566004870",
    "roles": [
      {
        "organization": "default",
        "id": "avio_pilot",
        "name": "avio_pilot"
      }
    ]
  }
}


bad:

{
  "firstName":"Idm",
  "email":"idm.tester@gmail.com",
  "lastName":"Tester",
  "organization":"default",
  "systemRole":"USER",
  "active":"true",
  "id":"e8566004870",
  "credentials":{"username":"e8566004870","roles":[{"organizati
on":"default","id":"avio_pilot","name":"avio_pilot"}]}]


5/12/2025 4:36:41 PM
To query for users with issues, do this:

https://prod.swa.aviobook.aero/idp/users?query=id==7*

Any id that doesn't begin with 'e', means it's not an EID

5/13/2025 3:53:28 PM

5/13/2025 12:04:26 PM
research for Steve Strittmatter
e115706

Steve, from my side, the user does not have the avio_faa role; though I can see it in Aviobook using the API.
on My side, the user has:
  avio_flight_efb_team (a MyAccess explicitly requested role)
  A second role, avio_pilot has been revoked as they have a jobcode of 163F, department code 01 which does not qualify currently in the de
finition.

This means to fix this user, I need to hear the final list of roles the user should have:
  1 - avio_flight_efb_team - should this stick around?
  2 - avio_pilot - should the user be manually assigned as a pilot despite their settings? . .I may be able to pull from workday . .
  3 - avio_faa - This is assigned currently only in aviobook.

Which of these should they keep/add?


Steve had the guy request the pilot_sme role; waiting started at 5/13/2025 12:21:30 PM . .
if 5 mins pass, and no updte, we'll fix manually.


5/14/2025 11:32:18 AM



5/14/2025 9:46:16 AM
John Mapes -IDtoAviobook chat

Summary: I was going to put together a KB article for this; but then realized it probably doesn't merit one; there's nothing special about it, and I wanted to see if you agree; just needed to talk outloud on this.


Create KB article:
   - just migrate user . . .
   - USERNAME ALREADY IN USE - add example of error
   - how to fix it . .
     1 - ask aviobook person to verifiy if id is a guid or eid . .
     2 - dash team . . EFB team . . Amy Murell . .
   - will ovewrite roles/function/qualifications based on what the existing requirements are
   - swaAviobookRoles = Myaccess
   - DirXML-EntitlementRef - RBEAev1 . .








 - So we need to chat through two items:
   1 - We found an issue they were creating by creating manual users.
   2 - Completion of a manually created user by using a driver migrate.


Example user in Aviobook


On #1 - we found their team does need to create pilots, FAs and others . .valid reason.
   - They were making a mistake some times: the ID and username mismatched.
   - Also each user in aviobook has three pieces of data that are important
    1 - Their role - > 'roles' field.
    2 - Their function -> 'function' field.
    3 - Their qualifications -> qualifications - these are harder to see: have to look them up from the qualficatoin side, then see the members listed.




On #2 - When they create users manually, they don't normally get everything perfectly right and following the rules - so a migrate will allow the driver to update the user. . .but this is identical to other situations that you already take care of by pushing users . .










5/14/2025 3:38:38 PM
request to archive users instead of deleting them came in this is how to do it:

5/14/2025 3:25:11 PM
aviobook testing archiving

Before:
GET https://dev.swa.aviobook.aero/idp/users/000fc281-a630-4122-8520-5a7f3d7b7ff9

{
    "id": "000fc281-a630-4122-8520-5a7f3d7b7ff9",
    "firstName": "Will",
    "lastName": "Walsh",
    "credentials": {
        "username": "e84871"
    },
    "organization": "default",
    "systemRole": "USER",
    "locked": false,
    "active": true,
    "archived": false,
    "createdAt": "2023-08-23T16:52:00Z",
    "submittedAt": "2023-08-23T16:52:00Z",
    "modifiedAt": "2023-08-23T16:52:00Z",
    "function": "UNKNOWN"
}

patch https://dev.swa.aviobook.aero/idp/users/000fc281-a630-4122-8520-5a7f3d7b7ff9
body:
{
    "archived": "true"
}


{
    "id": "000fc281-a630-4122-8520-5a7f3d7b7ff9",
    "firstName": "Will",
    "lastName": "Walsh",
    "credentials": {
        "username": "e84871"
    },
    "organization": "default",
    "systemRole": "USER",
    "locked": false,
    "active": true,
    "archived": true,
    "createdAt": "2023-08-23T16:52:00Z",
    "submittedAt": "2025-05-14T21:28:13.546323621Z",
    "submittedBy": "3587dd15-de88-4973-8ce1-a9239d866c34",
    "modifiedAt": "2025-05-14T21:28:13.546775516Z",
    "modifiedBy": "3587dd15-de88-4973-8ce1-a9239d866c34",
    "function": "UNKNOWN"
}



report deletstions o nader
<!--IDtoAvioBook_1.log:[05/15/25 13:34:01.189]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e169630
IDtoAvioBook_1.log:[05/15/25 13:35:38.387]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e133277
IDtoAvioBook_1.log:[05/15/25 13:35:46.021]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e171928
IDtoAvioBook_1.log:[05/15/25 13:35:56.090]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e193610
IDtoAvioBook_1.log:[05/15/25 14:31:44.493]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e181543
IDtoAvioBook_1.log:[05/15/25 14:54:43.427]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e115551
IDtoAvioBook_1.log:[05/15/25 14:54:47.614]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e115551
IDtoAvioBook_2.log:[05/15/25 11:56:44.600]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e194515
IDtoAvioBook_2.log:[05/15/25 11:57:11.130]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e82301
IDtoAvioBook_2.log:[05/15/25 11:57:25.251]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e194447
IDtoAvioBook_2.log:[05/15/25 12:09:14.555]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e193644
IDtoAvioBook_2.log:[05/15/25 12:11:15.424]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e193739
IDtoAvioBook_2.log:[05/15/25 13:18:47.939]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e185556
IDtoAvioBook_2.log:[05/15/25 13:33:57.829]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e169630
IDtoAvioBook_3.log:[05/15/25 08:18:06.966]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e193887
IDtoAvioBook_3.log:[05/15/25 08:18:42.983]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e193535
IDtoAvioBook_4.log:[05/15/25 03:37:37.640]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e109434
IDtoAvioBook_4.log:[05/15/25 03:37:41.076]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e109434
IDtoAvioBook_4.log:[05/15/25 03:38:55.273]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e193169
IDtoAvioBook_4.log:[05/15/25 03:39:22.810]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e193588
IDtoAvioBook_4.log:[05/15/25 04:15:23.365]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x326521
IDtoAvioBook_4.log:[05/15/25 04:15:23.910]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x326525
IDtoAvioBook_4.log:[05/15/25 04:15:27.103]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x326521
IDtoAvioBook_4.log:[05/15/25 04:15:30.002]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x326525
IDtoAvioBook_4.log:[05/15/25 04:16:06.414]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x326530
IDtoAvioBook_4.log:[05/15/25 04:16:07.323]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x330349
IDtoAvioBook_4.log:[05/15/25 04:18:43.715]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x326599
IDtoAvioBook_4.log:[05/15/25 04:19:22.254]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x326474
IDtoAvioBook_6.log:[05/14/25 14:41:02.477]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e185560
IDtoAvioBook_6.log:[05/14/25 14:41:05.880]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e185560
IDtoAvioBook_6.log:[05/14/25 16:02:27.178]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e172589
IDtoAvioBook_6.log:[05/14/25 16:02:31.148]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e172589
IDtoAvioBook_6.log:[05/14/25 16:28:19.446]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x333948
IDtoAvioBook_7.log:[05/14/25 14:05:20.887]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e194518
IDtoAvioBook_7.log:[05/14/25 14:05:24.088]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e194518
IDtoAvioBook_7.log:[05/14/25 14:07:03.669]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/e193640
IDtoAvioBook.log:[05/15/25 16:20:51.443]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x281199
IDtoAvioBook.log:[05/15/25 16:20:55.498]:IDtoAvioBook ST:IDtoAvioBook: Did a HTTP DELETE with 0 bytes of data to https://prod.swa.aviobook.aero/idp/users/x281199

-->

sent already up to now . .


IDtoAvioBook :Applying policy: %+C%14Cotp-UpdateArchiveEventToPATCH%-C.
IDtoAvioBook :  Applying to driver-operation-data #1.
IDtoAvioBook :    Evaluating selection criteria for rule 'Convert archive modifies to an HTTP PATCH'.
IDtoAvioBook :      (if-xpath true "@command="delete"") = TRUE.
IDtoAvioBook :    Rule selected.
IDtoAvioBook :    Applying rule 'Convert archive modifies to an HTTP PATCH'.
IDtoAvioBook :      Action: do-strip-xpath("request/value").
IDtoAvioBook :      Action: do-append-xml-element("value","request").
IDtoAvioBook :      Action: do-append-xml-text("request/value","{ "archived": "true" }").
IDtoAvioBook :        arg-string("{ "archived": "true" }")
IDtoAvioBook :          token-text("{ "archived": "true" }")
IDtoAvioBook :          Arg Value: "{ "archived": "true" }".
IDtoAvioBook :Policy returned:
IDtoAvioBook :
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.10.0.0100">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <driver-operation-data class-name="User" command="delete">
      <request>
        <url-token association="e8999993959"/>
        <header AVIO-Token="eyJraWQiOiI3NzAwMTU4NDMiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhdmlvLWlkcC1hcGkiLCJjYW5SZXRyaWV2ZVBlcm1pc3Npb25zIjp0cnVlLCJyb2xlcyI6WyJhcGktdXNlci1yb2xlIiwiZTZiNDk3YmEtYTc1Ny00Y2RmLWFkZWItMTI1ZjYzZjExY2Y1Il0sImlzcyI6ImlkZW50aXR5LXByb3ZpZGVyLXNlcnZpY2UiLCJjYW5Bc3NpZ25QZXJtaXNzaW9ucyI6dHJ1ZSwibmJmIjoxNzQ3MzM5MDU5LCJvcmdhbml6YXRpb24iOiJkZWZhdWx0IiwibmFtZSI6ImF2aW8taWRwLWFwaSBhdmlvLWlkcC1hcGkiLCJ1c2VyVHlwZSI6IlVTRVIiLCJleHAiOjE3NDczMzkzNTksImlhdCI6MTc0NzMzOTA1OSwiZW1haWwiOiIiLCJ1c2VybmFtZSI6ImF2aW8taWRwLWFwaSJ9.UUjv7E_HSzkKcIktbJmrCxQ0UvhaO9f-yS_eWksOcvc1kH5AC10W3DfscOl5qlkwwLK1PQKNiUMxp6TMYP83tSxqst1a4ARv8fyFJjfvbxkpWjDttXSIJ2bQrjFjiWXpCQrmbvMzOTz6iWoV_WUBqDwIzWExQg1a6xo2kr2WC-uFs0IHjjI-irAzTT-swUFgHEbeM6u0djLXjU3m2lfDpE84HmijUg4FnIelCDh-6Uj4RBMveVEaxlBBFrCgR3Yy5BcPVkFkhi8GmWxLpeoFoRMoMzFYH3HHkZ5MGykA1_-Q1Z0qBeB4I9kras9-ZSChE5PEbBTITC6KM4JSqgyGrw" User-Agent="SWA" content-type="application/json"/>
        <header User-Agent="SWA" content-type="application/json"/>
        <header User-Agent="SWA"/>
        <value>{ "archived": "true" }</value>
      </request>
    </driver-operation-data>
  </input>
</nds>

5/16/2025 12:42:22 PM
deployed yesterday:


idtoaviobook qacr:
CHG0468669 | Change Request | Dash
prod
CHG0468665 | Change Request | Dash



Avio delete/recreate:

delete and recreating:
{
    "limit": 25,
    "offset": 0,
    "total": 1,
    "items": [
        {
            "id": "9e54b58e-d2ce-46c6-b850-9e7b1298189e",
            "email": "Laurie.Evans@wnco.com",
            "firstName": "Laurie",
            "lastName": "Evans",
            "info": "SWAU Inflight TRaining",
            "credentials": {
                "username": "e121384"
            },
            "organization": "default",
            "systemRole": "USER",
            "locked": false,
            "roles": [
                {
                    "id": "avio_cabin_office",
                    "type": "USER",
                    "name": "avio_cabin_office",
                    "organization": "default",
                    "archived": false,
                    "createdAt": "2024-06-25T12:12:47Z",
                    "modifiedAt": "2025-04-30T20:39:24Z"
                }
            ],
            "active": true,
            "archived": false,
            "createdAt": "2024-12-03T18:54:52Z",
            "submittedAt": "2024-12-03T18:54:51.602223Z",
            "submittedBy": "e83397",
            "modifiedAt": "2024-12-03T18:54:52Z",
            "modifiedBy": "e83397",
            "function": "CABIN_CREW"
        }
    ]
}

done:
{
    "limit": 25,
    "offset": 0,
    "total": 1,
    "items": [
        {
            "id": "e121384",
            "email": "Laurie.Evans@wnco.com",
            "firstName": "Laurie",
            "middleName": "J",
            "lastName": "Evans",
            "credentials": {
                "username": "e121384"
            },
            "organization": "default",
            "systemRole": "USER",
            "locked": false,
            "roles": [
                {
                    "id": "avio_cabin_fa",
                    "type": "USER",
                    "name": "avio_cabin_fa",
                    "organization": "default",
                    "archived": false,
                    "createdAt": "2024-08-09T00:14:42Z",
                    "modifiedAt": "2025-05-21T16:28:28Z"
                }
            ],
            "active": true,
            "archived": false,
            "createdAt": "2025-05-21T16:28:28Z",
            "submittedAt": "2025-05-21T16:28:27.860677Z",
            "submittedBy": "avio-idp-api",
            "modifiedAt": "2025-05-21T16:28:28Z",
            "modifiedBy": "avio-idp-api",
            "function": "UNKNOWN"
        }
    ]
}


5/29/2025 1:07:03 PM
Sent this to nader, and has my notes I didn't send him:

Ok, Deploy complete, the diffing is also complete: here's the counts: I'm pushing the new users now:

goops before: 3019
goops after: 3198 - 179 additional goopos

gosups before: 3083
gosups after: 3479 - 396 additional gosups

aviopilots - only 6 new.

cn=e115706,ou=Users,o=SWA-ID
cn=e53207,ou=Users,o=SWA-ID
cn=e58442,ou=Users,o=SWA-ID
cn=e64902,ou=Users,o=SWA-ID
cn=e68528,ou=Users,o=SWA-ID
cn=e74990,ou=Users,o=SWA-ID
CHG0470834

cn=RBEAEv1,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#4#


TODO
5/29/2025 9:43:44 AM
IDtoAviobopprod deploy - prep

** - IDtoaviobook - matching to existing archived accounts isn't working; move from ?query to /rawid
  old: https://acc.swa.aviobook.aero/idp/users?query=credentials.username==e8566202526
  new: https://acc.swa.aviobook.aero/idp/users/e8566202526
  - also don't remove associations for archived users! Need to support matching AND unarchiving users . .

   - delete RemoveStaticMember policy in qa


Aviobook - Prod deploy steps:
done   - export members to get delta!
done   - gitlab run rbeaev1 prep/plan
done   - gitlab run aviobook prep task
done   - start imp task
done   - stop rbe aev1 driver
done   - delete RemoveStaticMember policy in prod and qa
done   - import entitlements
done   - Start RBEAev1 driver
done   - Deploy RBEAev1 driver, stop imp, start validate - see tests pass
done   - stop rbe validatetask
done   - start avoibook imp task
done   - deploy aviobook, sttop impt, start validate
done   - see tests pass
done   - close


avio_pilot
avio_connect_goops,
avio_connect_gosups


5/29/2025 4:50:06 PM
Just completed removing static avio_cabin_fa roles per Kisnleys direction. I sent this in chat and a simliar note in email.

Kinsley, Ron, I just realized Kinsley had already answered what we are doing with them; I will remove the static role for all of them per Kinsley's response a few days ago:
e185720 – released from class; remove
e145748 - released from class; might be back under GO; remove
e104044 – Not in Crew System; remove but can add back if they come to class
e184689 – Not in Crew System; showing as GO; remove but can add back if they come to class
e177949 – released from class; might be back under GO; remove
e173742 – not in Crew System; showing as GO; remove but can add back if they come to class
e163373 – returned to a GO role, remove
e163162 – released from class; might be back under GO; remove
e161737 – not showing in Crew System; showing as GO; remove but can add back if they come to class


6/2/2025 12:43:49 PM

Fixing users where id doesnt' match username: . .looks like I can't, send this to Nader:




Looks like I can't fix them: the first two don't exist in eDirectory, and the last set don't qualify for a role . . I'll leave these alone until you say otherwise . .it maybe that we should just archive them in avibook.

Can't fix the first two:
(cn=e95316) - duplicate, doesn't exist in edir
(cn=e149201) - doesn't exist in edir

None of these users qualify for a role currently. Do you have a preference on what we do with them?
(cn=e149201)
(cn=e183499)
(cn=e158503)
(cn=e146677)
(cn=e158177)
(cn=e124557)
(cn=e89246)

cn=RBEAEv1,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#4#



6/5/2025 1:08:31 PM
Had a conversation with Gabriel Santos at Aviobook support, found I need to cleanup the payload . .notes here:



6/5/2025 11:59:39 AM
 - Same body has been working but is not . .
 - The latest API is enforcing a more strict format to the payload.
 - Prod golive date? no date yet . .
 - INPROGRESS: Gabriel validated that we should be able to go all the way to production . .
 - DEV: 25.2 (snapshot)
 - TEST: 25.1
 - PROD: 24.5

Items remaining:
Test environment: WORKING!!! more enforcement ont he payload.
DEV environment: two tickets.

Alex Fredlake - Update Gabriel
Don't grant access to IDP documentation . .

Future conversation: Send tickets . .





6/10/2025 1:02:47 PM
in the middle of another call with:
Stephen Holmes: working on trn environment, doing multiple users at once - 
Gabriel Santos (External)
Shawn Keith (another guy working with Stephen I think)

Important finding: Had to add this header to allow multiple records to change at once . .interesting:

X-API-Version: 2

The driver doesn't currently use this, but technically could - it was a key piece for Stephen Holmes, since he needs to do more than one user at a time.

other notes from meeting:






DEV1Aca
DEV1Aca999999
DEV1Aca999998





working single user create

{
    "id": "DEV1Aca",
    "firstName": "Cap",
    "lastName": "Tain",
    "credentials": {
        "username": "DEV1Aca",
        "password": "rich557"
    },
    "systemRole": "USER",
    "active": true,
    "organization": "default",
    "roles": [
        {
            "id": "simpilot",
            "name": "simpilot"
        }
    ]
}




[
    {
        "id": "DEV1Aca",
        "firstName": "Cap",
        "lastName": "Tain",
        "credentials": {
            "username": "DEV1Aca",
            "password": "rich557"
        },
        "systemRole": "USER",
        "active": true,
        "organization": "default",
        "roles": [
            {
                "id": "simpilot",
                "name": "simpilot"
            }
        ]
    },
    {
        "id": "DEV1Afo",
        "firstName": "First",
        "lastName": "Officer",
        "credentials": {
            "username": "DEV1Afo",
            "password": "address560"
        },
        "systemRole": "USER",
        "active": true,
        "organization": "default",
        "roles": [
            {
                "id": "simpilot",
                "name": "simpilot"
            }
        ]
    },
    {
        "id": "DEV1Ain",
        "firstName": "In",
        "lastName": "Structor",
        "credentials": {
            "username": "DEV1Ain",
            "password": "retire808"
        },
        "systemRole": "USER",
        "active": true,
        "organization": "default",
        "roles": [
            {
                "id": "simpilot",
                "name": "simpilot"
            }
        ]
    },
    {
        "id": "DEV1Aob",
        "firstName": "Ob",
        "lastName": "Server",
        "credentials": {
            "username": "DEV1Aob",
            "password": "wage806"
        },
        "systemRole": "USER",
        "active": true,
        "organization": "default",
        "roles": [
            {
                "id": "simpilot",
                "name": "simpilot"
            }
        ]
    }
]


Key item learned!
Key item learned: aviobook: have to do the /id version to get archived users:  https://prod.swa.aviobook.aero/idp/users/e151514


6/25/2025 11:43:54 AM
Found with Clayton Miles:
6/24/2025 12:17:44 PM
Aviobook query is working: https://prod.swa.aviobook.aero/idp/users/?query=credentials.username%3D%3D%27e194977%27&read-attr1=
1  - possible matching issue
2  - ID vs username mismatch issue
3  - unarchiving issue




7/3/2025 3:48:32 PM
Name meetings with aviobook folks

6/30/2025 10:01:20 AM
Aviobook meeting
Catoria - names issues in aviobook.
 - PreferredName not being set in the field . .
 - names from connect . .pulling from 'base', not workday.
 - Cabin and flight pull from workday indirectly . .
 - now have double names . .
 - even can have 'catoria catoria' when preferred & given the same . .
 - Cabin and flight both pull from base . .?


 - How does the base databse get populated?
   - can't change flight to pull from base . .Amy . .
   - Will Ware - pilot: verify  . .
   - flight and cabin need both . .
 - Sarah pochyla - can confirm in cabin . .
 - amy: pushing for the same across the board.
 - what does ops suite pulling? . . legal name. (other lady in the meeting.
 - Base gets its data from Workday . .
 - Sarah - backlog too big for us to update GUI .

 - flight needs legal name
 - twop tions:
   - source name the same across the board . .
   -

What aviodoes:
Pilot Names:
  Legal name source: Workday
  Preferred name source: Workday
Flight Attendant Names:
  Legal name source: Workday
  Preferred name source: Workday BUT if COFL has a preferred name available then we override the Workday name with the COFL one

COFL - Crew on Flight Leg
 -

'catoria catoria' -
   - when preferredName matches legal name

If I some times go by 'Bob', are we just saying

"Big Daddy Ron Freer' - in flight and cabin
   - connect too if we make this change (if not going to th
   - would need to limit preferredName . .
   -

What makes preferredName so important? What is pushing us to include it?

Crew scheduling system - has nickname field . .
 - past it was drivven from here
 - got so many crew members, go by preferredname
 - someone with 14 characters - goes by simple . .as nick name
 - Workday - Sue is no derivitev of firstname/middlename; so doesn't alloow it - people are telling them 'sue' and feeding back to COFL feed.

 - Amy - someone allowed gemerain . .

Can I get a summary? What are all of the sources of names that we need to get in sync:
 - The COFL
 - Aviobook Connect database
 - any more?


6/30/2025 10:37:06 AM - call with Sarah
Sarah Pochyla
Sources:
 - Workday - company's source for perferredName, and surname. (derivitiaes ONLY alowed!!???)
 - Entire system for Crews & crew scheduling - tarck of training hours, trips to get paid, schedule . .includes nickname field.
   - they get to say what they want to be called . .this is 'the spreadsheet'.
   - Sarah doesn't pull anything from the spreadsheet - maybe getsw loaded into crew
   - very dififulc to write this - work - Chrisltienbenegim - he goes by Bengimine . .
 - Sarah - aviobook - my world . . connect/flight/cabin
 - COFL feed - simply - data feed Sarah's team gets from the ssytem when crew assigned to flight - comes with legal names and preferrednames. for FA, override aviobook may ahve been the original spreedsheet . .
Sarah Pochyla - profile
   - personal - names
   Sarah Mary Phcyla -
   - onloy use derivitartes of workday . .
   - Lastname may not be considred as perferred firstname . .

Legal firstname
legal middname
legal lastname

legal preferredFirstname

NO restriction on the COFL side . .
How does a flight attendatnate get name . .

Normalize the source for preferredname .

Workday
CSS
COFL


 - Nader, Alica knight, Sarah, Catoria - main folks . .
 -   Amy - main people - Amy only over pilots . .not over ground opts or FA
 - Nader and Sarah are team mates . .






7/7/2025 5:06:14 PM
Dhivya asked me to transfer XORA jobcode mvoe from goramp to goops to Nirosha, these are the transfer notes:

7/7/2025 12:20:39 PM
Nirosha change in Aviobook role definition: Done through RBEAEv1 driver & repo!
 - Done all through LDIF & LDAP!


 - IDtoAviobook
 - IDtoAviobookPrelive
 - RBEAEv1
  Runs on this server
   - w11dcledirdi019.swacorp.com
  Entitlement polices are here:
  base: cn=Entitlement Policies,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev
  Query: (objectClass=*)
  memberQueryURL

Job code: XORA needs to move from go ramp role but needs to be switched to avio_connect_goops.

RBEAEv1/auxiliary/EntitlementPolicies.ldif -> file with actual export of data.
RBEAEv1/auxiliary/decode-base64-ldif.sh -> generates '-decoded' version of the EntitlementPolcies.ldif file.
RBEAEv1/auxiliary/EntitlementPolicies-decoded.ldif -> *READ ONLY*: generated


Start by creating a story under feature: https://southwest.atlassian.net/browse/CYSEE-937


When replacing definitions: always do this:
1 - Stop the RBEAEv1 driver.
2 - Make the role updates - either manually through Apache, or through LDAP/LDIF/iManager.
3 - Start the RBEAEv1 driver.
4 - Identify report of users to push.
5 - Generate LDIF to import users: #4# file
6 - Import file.

Exporting/Importing IDM entitlements (lets you do all of them at once)
 - Export to auxiliary/EntitlementPolicies.ldif
 - Base dn: cn=Entitlement Policies,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev
 - All attributes, objectClass=*, returning attributes (blank, to return all).
 - Run 'ant normalize' to remove members and get file ready for importing in other envs . .
 - Open a bash window in the auxilary folder
 - run ./decode-base64.ldif ->  to get this file: EntitlementPolicies-decoded.ldif


Generating LDIF to import users:
 - Every user that needs to have a role re-evaluation is to send a #4# on the RBEAEv1 driver.
 - Produce import file for groramp:
 - Get memberqueryurl for both entitlement policies
   - Build a query for users ONLY with XORA
(&
    (|
        (swaStatus=L)
        (swaStatus=A)
    )
    (|
        (jobCode=XORA)
    )
    (swaDeptCode=03)
)

Generate a push for all of those users:

dn: cn=x248784,ou=Users,o=swaiddev
changetype: modify
add: DirXML-Associations
Dirxml-Associations: cn=RBEAEv1,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#4#


7/8/2025 11:00:59 AM
found 27 new archived users since yesterday . .
C:\work\work>git diff -ImodifiedAt | grep "^\+      \"id\""
grep: warning: stray \ before +
+      "id": "e121985",
+      "id": "e146245",
+      "id": "e149814",
+      "id": "e166943",
+      "id": "e177881",
+      "id": "e179215",
+      "id": "e179756",
+      "id": "e186427",
+      "id": "e191583",
+      "id": "e194311",
+      "id": "e194983",
+      "id": "e194988",
+      "id": "e194995",
+      "id": "e195164",
+      "id": "e195233",
+      "id": "e195506",
+      "id": "e56548",
+      "id": "e75526",
+      "id": "e90020",
+      "id": "e99040",
+      "id": "x304164",
+      "id": "x322975",
+      "id": "x324527",
+      "id": "x324614",
+      "id": "x324643",
+      "id": "x324678",
+      "id": "x328631",
+      "id": "x331262",
+      "id": "x332799",

C:\work\work>




7/8/2025 1:51:42 PM
 - XOAR status: do export of entitlements, and create mr!

7/10/2025 10:20:55 AM

This list was interesting because it shows users that are recently hired are getting archived . .likely due to roles flipflopping

Users recently hired also on archived list
e186363
e194519
e194547
e194548
e194553
e194554
e194729
e194856
e195028

8/22/2025 2:11:41 PM
Working aviobook link to find archived users:
https://prod.swa.aviobook.aero/idp/users?query=archived==true;credentials.username==e105073

