
[
    {
        "departmentNo": ""
    },
    {
        "departmentNo": ""
    },
    {
        "departmentNo": ""
    },
    {
        "departmentNo": "FA01"
    },
    {
        "departmentNo": "M411"
    },
    {
        "departmentNo": ""
    },
    {
        "departmentNo": "N411999"
    }
]



https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/419594271/IDtoAutocrib


fix: association=""







{
    "errors": [
        {
            "code": 400,
            "message": "The field Description must be a string with a maximum length of 35.",
            "title": "Description"
        }
    ]
}


post
https://api.autocrib.net/v1/Department
{
    "departmentNo": "M41199",
    "description": "TEMP DEPARTMENT-testcreation"
}

201 created
{
    "active": true,
    "budget": 0,
    "customField1": null,
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
    "departmentNo": "M41199",w
    "description": "TEMP DEPARTMENT-testcreation",
    "lastIssue": null,
    "lastUpdated": "2025-01-21T12:16:48.2952551-08:00",
    "lastYearCost": 0,
    "lastYearIssues": 0,
    "monthToDateCost": 0,
    "monthToDateIssues": 0,
    "notes": null,
    "recordID": 4,
    "supervisor": null,
    "yearToDateCost": 0,
    "yearToDateIssues": 0
}



GET
https://api.autocrib.net/v1/Department?fields=description,departmentNo

[
    {
        "description": "Flight Attendant",
        "departmentNo": "FA01"
    },
    {
        "description": "Supv Aircraft Maintenance",
        "departmentNo": "M411"
    },
    {
        "description": "TEMP DEPARTMENT-testcreation",
        "departmentNo": "M41199"
    }
]


{
    "errors": [
        {
            "code": 422,
            "message": "Department 'M41199' already exists.",
            "title": "Department"
        }
    ]
}


Two events:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <driver-operation-data class-name="Department" command="add" event-id="w11dcledirai004#20250121225108#9#2:c402bb54-128c-4bac-8965-54bb02c48c12" src-dn="">
      <request>
        <url-token/>
        <header/>
        <value>{"departmentNo":"M411","description":"M411"}</value>
      </request>
    </driver-operation-data>
    <driver-operation-data class-name="Employee" command="add" event-id="w11dcledirai004#20250121225108#9#2:c402bb54-128c-4bac-8965-54bb02c48c12" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e9889690917">
      <request>
        <url-token association="9889690917"/>
        <header/>
        <value>{"firstName":"Phineas","employeeNo":"9889690917","departmentNo":"M411","customField1":"Autocrib_Helpdesk_S","lastName":"Flynn","badge":"9889690917"}</value>
      </request>
    </driver-operation-data>
  </input>
</nds>




Response from successful create - input to itp-addassociation:

<nds dtdversion="3.0">
  <source>
    <product build="20240514_0216" version="1.2.0.0100">Identity Manager REST Driver</product>
    <contact>NetIQ Corporation.</contact>
  </source>
  <output>
    <status event-id="w11dcledirai004#20250116160557#9#2:5bb5792b-db44-4024-9f72-2b79b55b44db" level="success" type="driver-general">
      <driver-operation-data class-name="Employee" command="modify" dest-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r9870202377" event-id="w11dcledirai004#20250116160557#9#2:5bb5792b-db44-4024-9f72-2b79b55b44db" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r9870202377">
        <response>
          <url-token association="70202377"/>
          <header/>
          <response-header CF-Cache-Status="DYNAMIC" CF-RAY="902f599b2805f0c2-DFW" Cache-Control="no-cache, no-store, must-revalidate" Connection="keep-alive" Content-Type="application/json; charset=utf-8" Date="Thu, 16 Jan 2025 16:05:57 GMT" Server="cloudflare" Transfer-Encoding="chunked" alt-svc='h3=":443"; ma=86400' api-supported-versions="1.0" content-security-policy="default-src 'self'; img-src 'self'; script-src 'self' 'unsafe-inline'; style-src 'self' 'unsafe-inline'" expires="0" message="Employee '70202377' updated successfully." permissions-policy="camera=(),microphone=()" pragma="no-cache" strict-transport-security="max-age=15552000; includeSubDomains" vary="Accept-Encoding" x-content-type-options="nosniff" x-frame-options="SAMEORIGIN" x-powered-by="ASP.NET"/>
          <value message="OK" status="200">{"active":true,"adjust":true,"badge":"70202377","console":false,"costLimit":0.0000,"created":"2025-01-16T08:05:50.533","customField1":null,"customField2":null,"customField3":null,"customField4":null,"customField5":null,"customField6":null,"customField7":null,"customField8":null,"customField9":null,"customField10":null,"customField11":null,"customField12":null,"departmentLock":false,"departmentNo":null,"email":null,"employeeNo":"70202377","endTime":null,"firstName":"Robert","forceReferenceBin":true,"issue":true,"kitIssue":true,"lastIssue":null,"lastName":"Johansson","lastUpdated":"2025-01-16T08:05:50.553","lastYearCost":0.0000,"lastYearIssues":0,"locate":true,"maintain":false,"monthToDateCost":0.0000,"monthToDateIssues":0,"notes":null,"physical":false,"pinHash":null,"recordId":77,"return":true,"startTime":null,"stock":false,"stocker":false,"supervisor":false,"supplierNo":null,"yearToDateCost":0.0000,"yearToDateIssues":0}</value>
        </response>
      </driver-operation-data>
      <operation-data DRIVER_REVISION="XX"/>
    </status>
  </output>
</nds>







Jeevan,

Here's my question: We need to provide a 'departmentNo' field when we create users, and they need to be created before users can be added with those values. If I provide a user create with a departmentNo value that doesn't already exist, the event is thrown away. Assuming this attribute is important, it means I'll need to keep the updated regularly. They also seem to exist per 'dbid' as well, so we'll need to be sensitive to that as well.


DETAILS:

Each call to the Arcturus API for the IDtoAutocrib driver requires the 'dbid' setting.  Here is the table I've been given for this work:


AutocribLocation	DbID	IDM Location

Prod codes:
Southwest Airilnes (Tampa)	10803	TPA
Southwest Airlines (Atlanta)	10632	ATL
Southwest Airlines (Baltimore)	10806	BWI
Southwest Airlines (Denver)	10689	DEN
Southwest Airlines (Fort Lauderdale)	10802	FLL
Southwest Airlines (Houston)	10690	HOU
Southwest Airlines (Las Vegas)	10786	LAS
Southwest Airlines (Los Angeles)	10785	LAX
Southwest Airlines (MDW)	10787	MDW
Southwest Airlines (Milwaukee)	10804	MKE
Southwest Airlines (Orlando)	10691	MCO
Southwest Airlines (Phoenix)	10784	PHX

Development codes:
Southwest Airlines (Sandbox)	9132	 (no location code)
Southwest Airlines DEV (Sandbox)	10636	 (no location code)
Southwest Airlines QA (Sandbox)	10637	 (no location code)

When I list all available departments in dbid 10636, I see these:

GET on https://api.autocrib.net/v1/Department?fields=departmentNo,description

returns this - there's only two values, and we have dozens:

[
    {
        "departmentNo": "FA01",
        "description": "Flight Attendant"
    },
    {
        "departmentNo": "M411",
        "description": "Supv Aircraft Maintenance"
    }
]

When I do the same GET on dbid 10637, it appears to not have any, the payload response is an empty array:

[]

The 10786 dbid responds with this; so some dbids may need some additional setup/config etc to resolve this:

{
    "errors": [
        {
            "code": 401,
            "message": "Unauthorized DbId provided",
            "title": "DbId"
        }
    ]
}








alpha/IDtoAutocrib
{
"namedPasswordKey_1":"subOAuthPwd",
"namedPassword_1":"613c6ae9-437e-4b26-8d0e-8da2a8a5a851",
"namedPasswordDescription_1":"Client secret for authentication."
}





Southwest:613c6ae9-437e-4b26-8d0e-8da2a8a5a851


<do-if>
    <arg-conditions>
        <and>
            <if-association op="available"/>
        </and>
    </arg-conditions>
    <arg-actions>
        <do-set-xml-attr expression="../scim-driver-operation-data[last()]/request[last()]/url-token" name="association">
            <arg-string>
                <token-association/>
            </arg-string>
        </do-set-xml-attr>
    </arg-actions>
    <arg-actions/>
</do-if>




Example modify . . .

<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <driver-operation-data class-name="Employee" command="modify" event-id="w11dcledirai004#20250114222217#10#1:effd306e-33ce-4fd5-ba0b-6e30fdefce33" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e100000">
      <request>
        <url-token/>
        <header/>
        <value>{"firstName":"Mecca2","departmentNo":"FA01","lastName":"Thomas5","employeeNo":"100000","badge":"100000"}</value>
      </request>
    </driver-operation-data>
  </input>
</nds>




Query response from a match:





{



"totalResults": 1,
"results": [



    "active": true,
    "adjust": true,
    "badge": "100000",
    "console": false,
    "costLimit": 0.0000,
    "created": "2025-01-14T12:26:11.633",
    "customField1": null,
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
    "departmentNo": "FA01",
    "email": null,
    "employeeNo": "100000",
    "endTime": null,
    "firstName": "Mecca4",
    "forceReferenceBin": true,
    "issue": true,
    "kitIssue": true,
    "lastIssue": null,
    "lastName": "Thomas5",
    "lastUpdated": "2025-01-14T12:26:11.803",
    "lastYearCost": 0.0000,
    "lastYearIssues": 0,
    "locate": true,
    "maintain": false,
    "monthToDateCost": 0.0000,
    "monthToDateIssues": 0,
    "notes": null,
    "physical": false,
    "pinHash": null,
    "recordId": 6,
    "return": true,
    "startTime": null,
    "stock": false,
    "stocker": false,
    "supervisor": false,
    "supplierNo": null,
    "yearToDateCost": 0.0000,
    "yearToDateIssues": 0

    ]



}

Format needed





Add user attempt



<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <driver-operation-data class-name="Employee" command="add" event-id="w11dcledirai004#20250114202411#10#1:5bb5792b-db44-4024-9f72-2b79b55b44db" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e100000">
      <request>
        <url-token/>
        <header/>
        <value>{"firstName":"Mecca4","departmentNo":"263106","lastName":"Thomas5","employeeNo":"100000","badge":"100000"}</value>
      </request>
    </driver-operation-data>
  </input>
</nds>


response: need dept number

<nds dtdversion="3.0">
  <source>
    <product build="20240514_0216" version="1.2.0.0100">Identity Manager REST Driver</product>
    <contact>NetIQ Corporation.</contact>
  </source>
  <output>
    <status event-id="w11dcledirai004#20250114202411#10#1:5bb5792b-db44-4024-9f72-2b79b55b44db" level="error" type="driver-general">
      <driver-operation-data class-name="Employee" command="add" dest-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e100000" event-id="w11dcledirai004#20250114202411#10#1:5bb5792b-db44-4024-9f72-2b79b55b44db" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e100000">
        <response>
          <url-token/>
          <header/>
          <response-header CF-Cache-Status="DYNAMIC" CF-RAY="902059215fdf67aa-DFW" Cache-Control="no-cache, no-store, must-revalidate" Connection="keep-alive" Content-Type="application/json; charset=utf-8" Date="Tue, 14 Jan 2025 20:24:12 GMT" Server="cloudflare" Transfer-Encoding="chunked" alt-svc='h3=":443"; ma=86400' api-supported-versions="1.0" content-security-policy="default-src 'self'; img-src 'self'; script-src 'self' 'unsafe-inline'; style-src 'self' 'unsafe-inline'" expires="0" permissions-policy="camera=(),microphone=()" pragma="no-cache" strict-transport-security="max-age=15552000; includeSubDomains" vary="Accept-Encoding" x-content-type-options="nosniff" x-frame-options="SAMEORIGIN" x-powered-by="ASP.NET"/>
          <value message="Unprocessable Entity" status="422">{"errors":[{"code":422,"message":"DepartmentNo '263106' does not exist.","title":"DepartmentNo"}]}</value>
        </response>
      </driver-operation-data>
    </status>
  </output>
</nds>



4th policy in output transform
otp-XDStoJSON-simple,cn=Subscriber,cn=IDtoAutocrib,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA#3#2

0#0 - mapping rule

X#1 - input


ECMAscript
0#3 - cn=lib-JSONParsing,cn=SWALibrary,ou=DirXML,ou=Services,o=SWA-IDALPHA#0#3

e179530
cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#0054w00000CDNA1AAP


6th policy in pubcommand
cn=sub-ctp-FinalizeEvent,cn=Subscriber,cn=IDtoAutocrib,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA#5#11

6th policy in subcommand
cn=sub-ctp-FinalizeEvent,cn=Subscriber,cn=IDtoAutocrib,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA#5#10



     <subOAuthURL display-name="Access Token URL">https://identity.autocrib.net/connect/token</subOAuthURL>
        <subOAuthID display-name="User Name">Southwest</subOAuthID>
        <subOAuthPwd display-name="User Password" is-sensitive="true" type="password-ref"><!-- content suppressed --></subOAuthPwd>


working!

<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <driver-operation-data class-name="User" command="add" event-id="w11dcledirai004#20250110215905#10#1:c5335cfd-2818-47ee-a66f-fd5c33c51828" is-sensitive="false" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e100000">
      <request>
        <url-token/>
        <header content-type="application/json"/>
        <value>{"Given Name":["Mecca"],"jobCode":["263106"],"Surname":["Thomas5"],"swaUniqueID":["100000"]}</value>
      </request>
      <operation-data DRIVER_REVISION="XX" association="" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e100000"/>
    </driver-operation-data>
  </input>
</nds>



notrace="true" -> notrace="false"
is-sensitive="true" -> is-sensitive="false"


<driver-operation-data class-name="User" command="add">
    <request method="post" url="https://api.autocrib.net/v1/Employee">
        <url-token association="90101301"/>
        <header content-type="application/json"/>
        <value>{
 "employeeNo": "90101301",
 "firstName": "Aaron",
 "lastName": "Kynaston",
 "badge": "266698",
 "customField1": "Autocrib_Test_account"
}</value>
    </request>
</driver-operation-data>





eyJhbGciOiJSUzI1NiIsImtpZCI6ImpiMlZJODdYMmFXc3FpNjdydVdZVEEiLCJ0eXAiOiJhdCtqd3QifQ.eyJuYmYiOjE3MzY1MzcxMzcsImV4cCI6MTczNjU0MDczNywiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS5hdXRvY3JpYi5uZXQiLCJhdWQiOiJhcmN0dXJ1c3dlYmFwaSIsImNsaWVudF9pZCI6IlNvdXRod2VzdCIsImFwaVNjb3BlIjpbImFwaS5jcmVhdGUiLCJhcGkucmVhZCIsImFwaS51cGRhdGUiLCJhcGkuZGVsZXRlIl0sIkRiSWQiOlsiOTEzMiIsIjEwNjM2IiwiMTA2MzciLCIxMDYzMiJdLCJFcGljb3JDb250cmFjdE51bWJlciI6Ijk5OTkiLCJzY29wZSI6WyJhcmN0dXJ1c3dlYmFwaSJdfQ.crIJnexi67O14A3AxI4Z2cG2rtbML6vm0pdcp9uCOo4ifm9hpOAICMXApFpIo7WEXZAF_JzY5JUUqUUlgW3KXlOCoKi-3mBoM4oZzqiwuBQ6KsbxGPXUri7wLgbHxJeNtejSeD8pNulzO1jhAQlYgQhi3MQAzcZQSCh-BtjH7xC5tTNkLX-O2b7-J2pYB3baCwbYhz_bsoIPFsacXfGtDidZY3Qdc-74Balp6kQHTwR1LUj-BusgHHjNdLVcIduiL4anH17UCMX12nORwdNUPH2bFtABFp7-hyTv137iRt-M0uaEMuKA8CCfB8MLqyAqx4qZLj6lUQact5paQyKvmg

{
 "employeeNo": "90101301",
 "firstName": "Aaron",
 "lastName": "Kynaston",
 "badge": "266698",
 "customField1": "Autocrib_Test_account"
}


Answers to some questions:
 - not using the departmentNo field would save a lot of time, ideally, we'd just stuff the data in customField2 . . (customfield1 is where we put the swaAutoCribRole)
 - 
Team,

We have been given a list of 6 'roles' that should be assignable through MyAccess to represent a user needs an account in MyAccess:

Admin
AMT Mechanic
AMT Supervisor Report Access
Appearance group
Inspector / Quality Control
Inventory

We've recently found that these roles don't have any real meaning in Autocrib; we would just be storing one of the 6 strings above in a text field, called customField1. The Autocrib API engineers have confirmed that we would need to set or clear the following list of 11 boleans to actually represent the rights in Autocrib.

adjust - 1
console - 0
forceReferenceBin - 1
issue - 1
kitIssue - 1
locate - 1
maintain - 0
physical - 0
return - 1
stock- 0
supervisor - 0

Mike,

FYI: the 11 booleans have the following defaults. Assuming we went from top to bottom, our default permissions for newly created users would have '10111100100' as their boolean identifier - here's the list written out:

adjust - 1
console - 0
forceReferenceBin - 1
issue - 1
kitIssue - 1
locate - 1
maintain - 0
physical - 0
return - 1
stock- 0
supervisor - 0



Assuming the above is true, then we have a few tasks to take care of:

1 - We will need to understand the meaning of each of the 11 booleans above; what they actually allow an employee in autocrib to do.
2 - We will then to go through each of the 6 roles, and decide how each of the 11 booleans should be set for each role. This would allow us to give each role meaning in Autocrib.





 <remove-association event-id="w11dcledirai004#20250203082101#9#1:47ed93eb-cd3a-456a-b8f6-eb93ed473acd">10636-9888328687</remove-association>


cn=IDtoAutocrib,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA#1#10636-9888328687




{
    "active": false,
    "employeeNo": "e998877661",
    "badge": "e998877661",
    "firstName": "Admin",
    "lastName": "Admin",
    "customField1": "Admin",
    "customField2": "Role-Storage-User"
}

{
    "active": false,
    "employeeNo": "e998877662",
    "badge": "e998877662",
    "firstName": "AMT Mechanic Mechanic",
    "lastName": "Admin",
    "customField1": "AMT Mechanic",
    "customField2": "Role-Storage-User"
}







objectClass
preferredName
Surname
Internet EMail Address
swaStatus
swaAutocribRole
swaLocation
swaUniqueID
jobCode



firstName
lastName
email
active
customField1/2
dbid
employeeno
departmentNo





autocrib - sync example with dbid that had changed:

<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <sync cached-time="20250127234105.855Z" class-name="User" event-id="w11dcledirai004#20250127234105#10#1:f124ff19-a29b-4627-8ed3-19ff24f19ba2" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e9889718220" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e9889718220" src-entry-id="430381" timestamp="0#0">
      <association state="migrate">10636-9889698220</association>
      <operation-data DRIVER_REVISION="1.0.0-CSEE-4131-x266698" dbid="9132" objectType="employee"/>
    </sync>
  </input>
</nds>

utocrib_Helpdesk_S







IDtoAutocrib:
 - move from populating departmentNo to customfield2. This makes department (jobCode) much easier to populate for now




1/23/2025 11:35:25 AM
IDtoAutocrib

todo: - dbid + swaUniqueID for association: deletions will need dbid!
todo: document: association is dbid + swauniqid, not dbid + cn, the e is removed!




2/6/2025 10:59:11 AM
I am with the EE or enginering enablement team with Farhan, and Mike Labit
 - We are working on the IDtoAutocrib driver.

 - Trying to learn how we can orrectly  manage permissoins in autocrib; that's really the focus right nwo.
 - provisioning typically implies creation, deletion, updates of users, and management of permissions.



Call start
Sean Lockard
William Alyacoub
Joseph Cordasco
Mike Labit
Tyler Vanderwel
Roderick Wilson
Grishma Subbaiah Bittianda

Grishma - get user provisioning in place.




 - IN some conversations with the API folks - Joseph and Jeff at Autocrib, we've learned af ewt higsn:
  - We've visted at least 3 ways that we at one point thought we could manage permissions:
  1 - Directoy on the user.
  2 - through departments
  3 - through profiles.
    - We have since learned that deparmtnets do not provide a mechinism for expression permissions.
     - This means we either need to set permsisions directly ont he user, or through profiles.
     - We then learned that profiles are not expised through the API.

     - Seems like the only pattern left is to set permissions manually on the user.

1 - How dow e manage permissions in autocrib
2 - how do we matching pwt the sithes that have already gone live



Joseph - 2/6/2025 11:09:10 AM- confirmed for me.
   - Roles -> permission levels
- Grishma - Roles -
  AMT
  amt supervisor
  don't confuse with department -
  Roles were dfined as departments . .
 - Grishma: Roles: nthing but sets of permissions

Joseph second question
   - they used departments to track transactions at the machine.
   - they don't need to see the role of the employee wen they performed the transction?
   - Grishma - click on them - access level
     - seems to be permissions on a department . .but no. . .
     - 100094 - has a department, and permissions are set . .
     - How do we go ahead and set an employee?
     - josephL - Access moduel - no longer deisplyaed on website for departments!!
     - Store a list of permissions that correpsond to each role
       -
G: What do these roles mean?
   - J:
   - options on main menu corresondon to the permissions.
   issue
   return
   dull return (not apply)
    . . .- varous menuses . .
  if not issue check, can't issue tools.
  - MS - here's the permisions
  - pass a role - they don't have any
  - don't



Joseph: likely don't send departments . .
 - departments: would give us the ability to format reports . .
 - if not needed, don't populate it.
 - Grisham: do we need this reporting?
 - Roderick Wilson: only need to run reorting base on employee!

 - G: department/role - don't need, only permissions.


 - When I get the role from MyAccess - such as 'MS'
   - it'd also have some payload saying which of the permission booleans need to be true/false.

Need to statically define a role to permission mapping.
MS:
  issue: true
  kit issue: false
  Locate: (leave default)
  .
  .
  .


AMT:
  issue: false
  kit issue (leave default)
  Locate: true
  .
  .
  .


   - Concern: manual tie of permissions to roles.
   - Concern: When we got live for for users that are already live; this will be the first time that permissions are being enforced.
     - logically, its exactly the target: but because permissions are not being enforced now, it is simply somewhat invasive.
     - when we go live, we'd be writing all the permission that should be on a user.
  - Terms of existing permission:
     - Assumption: existing mapping of role to permissions is already correct!!
     - Any unexpected changes to permissions due to driver's initial migration should be minimal

  - Joseph: Note: Profile support in the API: not on the 2025 roadmap . . .
  - Grishma: Make it super clear that we are manualy changing permissions!



     - Question: User can change roles right? Can I safely assume that the driver is authorative for roles?
       - Sean: all roles should cover what we need
       - Joseph - use cases:
        - New employee:
        - existing employee changes role - Yes, this is possible; but rare.
           - e.g.: material specialist -> AMT - typically . .though keep same roles .
        - change permissions of a role . .
           ***- Need to update all employees with new role!
      Assumption
         -

Spreadsheet of roles . .
   - Action items:
   - Aaron - put together permissions in a spreadsheet

Summary:
   - manually setting roles.
   - Spreadhseet for roles
   - initial migration: should be minimal impact: already set roles directly on users.


Sent to:
  "Joseph Cordasco" <jcordasco@autocrib.com>; "Grishma Subbaiah Bittianda" <Grishma.SubbaiahBittianda@wnco.com>; "Clayton Ward" <cward@autocrib.com>; "William Alyacoub" <walyacoub@autocrib.com>; "tvanderwel@autocrib.com" <tvanderwel@autocrib.com>; "Roderick Wilson" <Roderick.Wilson@wnco.com>; "Mike Labit" <Mike.Labit@wnco.com>; "Jeff Ponce de Leon" <jponcedeleon@autocrib.com>; "John Morton" <jmorton@autocrib.com>


Team,

Per our call today, here is a status and some action items.

We discussed the following today:

 - We confirmed that permissions must be set manually on the user.
 - We will need to put together an explicit mapping of role names to the set of boolean permissions; so we can express the concept of a role through the API, with what we have access to now.
 - Profiles, a concept in Autocrib that does allow the idea of roles that have permissions is not yet exposed through the API so cannot be used in this driver.
 - Assumptions: For sites that have already gone live, roles have been manually set according to the definition that we are about to make explicit through a spreadsheet. This means that during initial migration (initial load of the driver to connect up users) we expect minimal changes to existing permissions.
 - We discussed some use cases, such as new employee, existing employees changes role, and role permissions themselves changing the definition.

Action items:
Aaron
  - Create a spreadsheet that explicitly maps each of the known roles to the permission booleans
    Timing for completion: ASAP: I am out tomorrow, and am booked today . . I'll see what I can do.

  - Update the IDM driver documentation with all known use cases and behaviors: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/419594271/IDtoAutocrib
    Timing for completion: I need a few days on this. Perhaps mid next week?

--Aaron



2/20/2025 12:28:49 PM
MyAccess

Mike sent me this; body had to have this:
```
Required for IDtoAutocrib myaccess authenticatoin:
"grant_type=client_credentials&client_id=${TokenUsername}&client_secret=${TokenPassword}"
```


2/20/2025 12:45:09 PM
note: 
**CSEE-4390NotDoing** - not going to be doing the role:partner_role: Myaccess can't match up the return-and report user file!


C:\work\IDtoSprinkler>git lg --all -10
* 4e8695d - (26 hours ago) chore: CSEE-4389 Run build to get latest test updates, and new Analyst and Community Manager tests. - Aaron Kynaston (Contractor) (HEAD -> CSEE-4389, origin/CSEE-4389)
* 19395c1 - (27 hours ago) fix: CSEE-4389 Add Analyst and Community Manager tests, in the old 'role' version (not role:partnerrole). - Aaron Kynaston (Contractor)
| * e5b1146 - (27 hours ago) fix: CSEE-4390 Add role:parternerrole support to tests, add Analyst and Community Manager tests. - Aaron Kynaston (Contractor) (tag: **CSEE-4390NotDoing**, origin/CSEE-4390, CSEE-4390)
| * f925ecf - (2 days ago) fix: CSEE-4390 Move to role:partnerrole formatting for swaSprinklerRole attribute. - Aaron Kynaston (Contractor)
|/
* 6422979 - (2 days ago) chore: CSEE-4389 Run build to get test updates. - Aaron Kynaston (Contractor)
* c3bab32 - (2 days ago) fix: CSEE-4389 Update xls - move swaSprinklerRole next to 'userType' field it pouplates in a test. - Aaron Kynaston (Contractor)
* 6054ecf - (2 days ago) chore: CSEE-4389 Run build to get table update. - Aaron Kynaston (Contractor)
* ae4bbd2 - (2 days ago) chore: CSEE-4389 Run build to bump version number. - Aaron Kynaston (Contractor)
* 0977df3 - (2 days ago) fix: CSEE-4389 Add two new partner roles to the driver, Community Manager, and CE Bilingual Expert. - Aaron Kynaston (Contractor)
* 526a5d3 - (2 days ago) chore: CSEE-4389 Remove packages from gold copy export. - Aaron Kynaston (Contractor)

C:\work\IDtoSprinkler>


2/25/2025 10:44:45 AM
Email I'm about to send to Girshma and team.

Team,

Once I get to step 5, the development of the IDtoAutocrib driver will stop, and I will no longer be able to make progress. I am currently on step 1, as shown below. I expect to get to step 5 in the next two days or so.

To solve #5 and unblock development, I'll need to be able to prepare for initial migration (the process of associating existing users that have already gone live in Autocrib). I have two separate ideas I'd like to discuss with the team to resolve this.

Autocrib next actions:
1 - Resolve some MyAccess concerns: In progress with MyAccess team.
2 - Confirm MyAccess can support the role + permissions payload design.
3 - Update driver code with any role + permission payload design changes.
4 - Re-baseline all tests for the Autocrib driver.
5 - Get All current user data from all DBIDs to enable the creation of the initial migration file, and diffing after initial migration.
6 - Design initial migration.
7 - Complete QA CR paperwork for deployment.
8 - Deploy IDtoAutocrib to QA.
9 - Review the AC with the team and get official acceptance: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/419594271/IDtoAutocrib
10 - Schedule and execute UAT: testing session with Grishma and team, to confirm driver behaves as expected.
11 - Finalize initial migration steps.
12 - Complete Prod CR paperwork for deployment.
13 - Deploy IDtoAutocrib to production.
14 - Execute initial migration steps for sites that have already gone live.
15 - ONGOING for a few weeks as needed: Monitor new sites coming online as requests for new sites come in.

--Aaron

2/27/2025 11:40:26 AM
2/27/2025 11:20:34 AM
useful urls
https://api.autocrib.net/v1/Employee?customField3=myAccessRole

https://api.autocrib.net/v1/Employee?fields=employeeNo,active,customField1,customField2,customField3,customField4,customField5,customField6,customField7,customField8,customField9,customField10,customField11,customField12


3/5/2025 11:35:04 AM
Updating todo list:

Autocrib next actions:
1 - Resolve some MyAccess concerns: In progress with MyAccess team.
2 - Confirm MyAccess can support the role + permissions payload design.
3 - Update driver code with any role + permission payload design changes.
4 - Re-baseline all tests for the Autocrib driver.
5 - Get All current user data from all DBIDs to enable the creation of the initial migration file, and diffing after initial migration.
6 - Design initial migration.
7 - Complete QA CR paperwork for deployment.
8 - Deploy IDtoAutocrib to QA.
9 - Review the AC with the team and get official acceptance: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/419594271/IDtoAutocrib
10 - Schedule and execute UAT: testing session with Grishma and team, to confirm driver behaves as expected.
11 - Finalize initial migration steps.
12 - Complete Prod CR paperwork for deployment.
13 - Deploy IDtoAutocrib to production.
14 - Execute initial migration steps for sites that have already gone live.
15 - ONGOING for a few weeks as needed: Monitor new sites coming online as requests for new sites come in.


3/18/2025 9:30:49 AM
Had autocrib permission meeting. Sean Lockard has the ldif input files to see if he can fix some roles.



3/28/2025 3:34:07 PM
Akilan notes




3/24/2025 3:15:40 PM

Call Akilan . .


For this meeting, we just want to get a head start on these questions:

  - How do we determine that a user is a multi-site user?
    Options:
    1 - Send every user to every site
       Licensing? (email Joseph and Jeff) - how does licening work?
    2 - Answer with MyAccess: example: mechanic to fly to location to check something, can already check in that site . .
       - Create 6 roles * 12 sites = 72 options in MyAccess!
         - have to scroll through this . .
         - Could create custom form to add a new site (need to research here)
         - Exmaple

          TPA - Autocrib-AMT
          TPA - Autocrib-AMTSUPP
          .

          .

          ATL - Autocrib-AMT
          ATL - Autocrib-AMTSUPP
          .
          .

          BWI - Autocrib-AMT
          BWI - Autocrib-AMTSUPP
          .
          .



    3- If there's some data from Workday that would 100% tell us that users are single vs multi, AND include which site . .

  - How do we determine the list of dbids a user needs to be provisioned and managed in since swaLocation only gives a single dbid.


  - How do we determine which of the corresponding 2+ accounts in Autocrib should be active at any one point?
     - Can multi-site users ever differ in role? How should this be exposed in MyAccess?

  - Permanent vs Temporary multi-site?



Autocrib:
 - Send every user to every site?
 -






3/28/2025 3:33:40 PM
We had a multi-site users meeting: this is the results:

3/25/2025 7:01:27 AM
Autocrib multi-site users meeting

Team,

For our discussion this morning, we discussed the following:

 - There isn't a clear way to determine multi-site users by data alone.
 - The need for multi-site provisioning needs to be done through an on demand basis, so we've added this to MyAccess.
 - To expose all sites and all roles, there will need to be 13 * 6 roles, or 78 total items to chose from. We've discussed the following format shown here. Note that the MyAccess team will be consulted to confirm our format will work:
    TPA - Autocrib-AMT

    TPA - Autocrib-AMTSUPP

    - and so on, for a total of 78 options.
 - All accounts that a user has in autocrib will reman active until the user is deprovisioned per one of our deprovision use cases as described here: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/419594271/IDtoAutocrib.
 - We discussed users will likely not differ in role across sites as users typically will have a single designated role that will be reflected in each of their autocrib accounts.
 - Multi site users will be taken care of manually until we can update the driver. Note these users permissions will be updated to match the standard roles when the user requests their role from MyAccess.

Subsequently, Sean has also confirmed that a user may need to be in all 13 locations; so multi-site user support should be able to scale that far.

Action items:
   - Add Dallas to AC:
     - Status: Done.
   - Ask regarding licencing: per user, or per site? both?
     - Status: Question asked through email.
   - Akilan about role owners, and other requirements he'd have for managing 78 items in MyAccess.
     - Status: in progress.




For this meeting, we'll discuss the following items & answers I have so far:

 - How do we determine that a user is a multi-site user?
   A - May not have access to this data; will have to be in MyAccess maybe?
    People responsible for this can go request access.


 - How do we determine the list of dbids a user needs to be provisioned and managed in since swaLocation only gives a single dbid.
   A - Solved by using MyAccess, if desired.

 - How do we determine which of the corresponding 2+ accounts in Autocrib should be active at any one point?
   A - The only disabling we'll do is on one of our three deprovision cases (role removal from MyAccess, termination or deletion of the account in eDirectory)
   Yes - good . . .



 - Can multi-site users ever differ in role? How should this be exposed in MyAccess?
   A - For now, we're assuming someone could select a site and role, then synchronize to that system.



Users usually going as a current role: role is most likely attached to the user, then uses that same role in multiple sites .  .



Possible MyAccess option:
          78 different role choices (13 locations x 6 roles)

          TPA - Autocrib-AMT
          TPA - Autocrib-AMTSUPP
          .
          .

          ATL - Autocrib-AMT
          ATL - Autocrib-AMTSUPP
          .
          .

          BWI - Autocrib-AMT
          BWI - Autocrib-AMTSUPP
          .
          .

Accidental choice causing a difference in roles between sites?
   - Approval process: first to direct manager, second to role owner
   - Third field - MyAccess role owners . .
   - Multiple role owners? no - just one approval here
   - Role owner could confirm correct access . .
   - Multi-site users: timing & plan for manual vs automated.
   - Plans for today: multi site in TPA/FLL: multi-site supervisors: training purposes
   - Ok for now for supervisors . .
   - create users in all envs: Junk in the system:
     - Sean: fairly confident: location only . .
     - LPA: don't want to have accounts that aren't needed . .
   -


Action items:
   - Add Dallas to AC
   - Ask regarding licencing: per user, or per site? both?
   - Akilan about role owners, and other requirements he'd have for managing 78 items in MyAccess.








Fort Lauderdale

scan log for users like this: -
User [e179233] has a swaLocation of: [DMX], and a corresponding dbid does not exist i
n the DBIDTable. Please update the table, or correct the swaLocation value for the user.

126 total users with an autocrib role imported.

These users were not placed as their swaLocation doesn't match a DBID:
[edir@w11scledirsi009 temp]$ grep -Ri "corresponding dbid does not exist" * | grep :User
IDtoAutocrib_2.log:[03/21/25 17:38:37.068]:IDtoAutocrib ST:User [e179233] has a swaLocation of: [DMX], and a corresponding dbid does not exist in the DBIDTable. Please update the table, or correct the swaLocation value for the user.
IDtoAutocrib_5.log:[03/20/25 12:08:04.337]:IDtoAutocrib ST:User [e999002] has a swaLocation of: [DAL], and a corresponding dbid does not exist in the DBIDTable. Please update the table, or correct the swaLocation value for the user.
IDtoAutocrib_5.log:[03/20/25 12:09:57.502]:IDtoAutocrib ST:User [e999001] has a swaLocation of: [DAL], and a corresponding dbid does not exist in the DBIDTable. Please update the table, or correct the swaLocation value for the user.
IDtoAutocrib.log:[03/21/25 17:47:34.640]:IDtoAutocrib ST:User [e44047] has a swaLocation of: [DMX], and a corresponding dbid does not exist in the DBIDTable. Please update the table, or correct the swaLocation value for the user.

e177414 - we had this user had a BWI Location code, and we can't write to that one as it's a future site . .


61 users in 10802
59 users in 10803



I've learned there are two caterogires of multi site people:
   - Admins/suewrpvisrs
   - Traveling mechanics.
   -




10806

todo today:
 - delete e179233 from denver & orlando



fll - 10802 - 83 users - Fort Lauderdale
tpa - 10803 - 81 users



[03/21/25 12:48:54.976]:ID

CSEE-4432 Deploy IDtoAviobook driver in QA: re-verify QA deploy after test fix



4/4/2025 2:21:50 PM

'76' role meeting with Akilan - there's actually 78 (13 sites, not 12), 13 X 6 roles = 78

Akilan Autocrib meeting:
 - Mike used a AUT1
 - for the app . .
 - if you search in dasuh for 'AutoCrib' - AUT1 in dash
 - now one will search for aut1 . .
 - App is setup as AUT1 . .Akilan, new application 

Akilan is super busy at the moment; but showed me the need to clear the worklaod and drive it through PMs.



4/11/2025 11:23:36 AM
note regfarding new support portal - though I need to go through Grishma and Sean:

Hi Aaron Kynaston (Contractor),  
  
We are happy to announce the launch of our new Support Portal! Don't worry, the legacy Support Portal will still be available to you for reference. However, you will now create Technical Support cases from the new Support Portal.  

To access the new Support Portal navigate to [new.autocribsupport.com](https://urldefense.com/v3/__https://new.autocribsupport.com/__;!!BxxYAft0oVuNRA!4eaY_ryA7x2HU5rRPAC80ZX_A75Hy8bdX_xGpWqYfpCND7s-3Gnw52FyC3-lO1-VYmnzywKZxoPtDG4cXSbik8eaBQ$ "https://urldefense.com/v3/__https://new.autocribsupport.com/__;!!BxxYAft0oVuNRA!4eaY_ryA7x2HU5rRPAC80ZX_A75Hy8bdX_xGpWqYfpCND7s-3Gnw52FyC3-lO1-VYmnzywKZxoPtDG4cXSbik8eaBQ$"). To access the legacy Support Portal navigate to [legacy.autocribsupport.com](https://urldefense.com/v3/__https://legacy.autocribsupport.com/__;!!BxxYAft0oVuNRA!4eaY_ryA7x2HU5rRPAC80ZX_A75Hy8bdX_xGpWqYfpCND7s-3Gnw52FyC3-lO1-VYmnzywKZxoPtDG4cXSYG7jy8uw$ "https://urldefense.com/v3/__https://legacy.autocribsupport.com/__;!!BxxYAft0oVuNRA!4eaY_ryA7x2HU5rRPAC80ZX_A75Hy8bdX_xGpWqYfpCND7s-3Gnw52FyC3-lO1-VYmnzywKZxoPtDG4cXSYG7jy8uw$").  

A new Snap-on AutoCrib account has been created for you.

Click the url below to activate your account and select a password:  
  
[https://new.autocribsupport.com/register/0zBTFALyYrKoufdTGPKI](https://urldefense.com/v3/__https://new.autocribsupport.com/register/0zBTFALyYrKoufdTGPKI__;!!BxxYAft0oVuNRA!4eaY_ryA7x2HU5rRPAC80ZX_A75Hy8bdX_xGpWqYfpCND7s-3Gnw52FyC3-lO1-VYmnzywKZxoPtDG4cXSbMLqY71Q$ "https://urldefense.com/v3/__https://new.autocribsupport.com/register/0zBTFALyYrKoufdTGPKI__;!!BxxYAft0oVuNRA!4eaY_ryA7x2HU5rRPAC80ZX_A75Hy8bdX_xGpWqYfpCND7s-3Gnw52FyC3-lO1-VYmnzywKZxoPtDG4cXSbMLqY71Q$")  
  
If the above URL does not work try copying and pasting it into your browser. If you continue to have problems, please feel free to contact us.  
  
Regards,  
Snap-on AutoCrib


5/16/2025 12:42:52 PM




autocrib: push again: dn:
cn=IDtoAutocrib,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#4#

cn=e106105,ou=Users,o=SWA-ID
dn: cn=e135158,ou=Users,o=SWA-ID

Aviobook
 - big regularoty issue . .
