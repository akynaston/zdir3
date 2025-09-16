8/27/2024 11:37:40 AM
High level: what all do we want to cover?

I'd like to quickly chat about:
	IDtoSprinkler: next: IdMUnit tests & pipeline
	IDtoEmployeeSvc: Diff investigation with prod
	NotificationLoopback: Pipeline and build testing










 - IDtoEmployeeServices: Clearly identify the differences between the code in prod, and the code in Git.
 - See if we can classify the change as someone possibly doing some sort of 'emergency change maybe?'



IDtoSprinkler, NotificationLoopback and EmployeeServices right?

IDtoEmployeeServices
* Status: Yatin still working on this.
* Add/update IdMUnit tests?
* Add/update AWS secrets.
* Add/update pipeline 

NotificationLoopback
1. Needs topO fix, see MR here:  https://gitlab-tools.swacorp.com/csiam/idm/NotificationLoopback/-/merge_requests/27
2. Needs endpoint build update for dev/qa/prod.
	1. If you'd like, I can do this - I still have the bandwith to  get this latest data from QA if you'd like, and update the build.
3. Double check pipeline


IDtoSprinkler
Done - 1 - Merge the above MR.
Done 2 - Get the query-value-password value.
Done - 3 - Store password in AWS, including idmunit-config.xml passwords as needed.
4 - Get latest IdmUnit tests - pass and add to Git.
5 - Update idmunit-config to use aws passwords.
6 - Upload AWS passwords.
7 - Commit, push, create new MR.
8 - Test pipeline DEV/QA deploys.
9 - Pipeline deploy Prod.



8/16/2024 11:43:26 AM
Yatin questions: I have 6 minor items 

FYI: this was just reconciling git and the three environments; just gearing up to test the pipelien deploy once you have IdMUnit tests.

1 - FYI: Management of client_id, grant_type, and client_secret.
2 - Q: turn off driverIsRefreshSchema in prod?
3 - Q: JSON Payload that differs between prod and non prod.
4 - Q: The driver is set to driverCustomSchema; which implies a schema file; can I get access to this? Note: see diff: **git diff qaAppSchemaStart..qaAppSchema**



LONG VERSION:

1 - As you mentioned, the credentials come in three pieces:
client_id
grant_type
client_secret

The first two, client_id and grant_type are built directly into the driver as you already know. They don't differ at all between DEV and QA . .though we may still add them to build XML to make it obvious what we are setting. The last one is pure AWS; though it is added as a password-ref; so thankfully ends up just being a normal named password ultimately; see here:

![[Pasted image 20240814170010.png]]
Also, the next complexity is that client_id exists twice in the driver, once under JWT which we're not using, and once under the 'http-query' section, which we are.



2 - driverIsRefreshSchema - is turned on in prod; do we want to turn it off now? this is the one time driver start up schema read per the docs; I don't have any experince with it; other than what I saw in docs (pg 45 https://www.netiq.com/documentation/identity-manager-48-drivers/pdfdoc/scim_driver/scim_driver.pdf )

3 - There's a clientAttributes field that differs between prod and dev/qa - should I assume these values are correct as follows?

	In DEV/QA:
	`{"clientId": 24559,"userType": "$lv_roleName$"}
	
	IN prod:
	`"clientId": 6164,"userType": "$lv_roleName$"

4 - The driver is set to 'driverCustomSchema' for the driver option 'driverSchemaOptions'. Can I get the schema file from you you used for import? If you went another route too; let me know and we'll update this setting - see (git diff qaAppSchemaStart..qaAppSchema) - dev is different too; but didn't prepare tags.
 - The application schema reported to the driver by the application looks very different between QA and prod.
 - The mp-mapping table has 5 more rows than prod does.
 -  pub-itp-add-association - maybe delete in QA?
 - the 'partnercustomProperties is pretty different between QA and prod.
	 - gcvPartlervalue
	 - product seat
	 - clientAttributes - odd, that in QA, the driver has lv_roleName variable instead of hardcoded value.

6 - DEV differences
* App schema is different in dev . . may not be ab ig deal.
* need to delete add-assoc there too maybe? if so, how are we associating?
	

Status - Dev deploy onprem deploy test, though didn't deploy yet:
	https://gitlab-tools.swacorp.com/csiam/idm/idtosprinkler/-/commit/502cc1073f42fd7a6002c1571f4aae79b5ad92ff/pipelines?ref=CSEE-3147
	- Movnig to have new driver repo have 'please write tests test by default;.

Gitlab and Pipeline chats?


9/16/2024 5:08:52 PM
password check
```
nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify class-name="User" dest-dn="\DEV_SWACO_ID\swaiddev\Users\e9999" dest-entry-id="61735" event-id="w11dcledirdi019#20240916223827#1#1:c28f3379-5f88-4ee7-964b-79338fc2885f">
      <modify-attr attr-name="Description">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="Description">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="Description">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="Description">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="Description">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="Description">
        <remove-all-values/>
        <add-value>
          <value type="string">

query-value-password-0
eBAnfhjZW/8tmCXy9bvgIBvcNrN3MFiHNWabxzj9JhllYmFiZTkyNC01Y2RjLTMzMzQtYjU1NS1kNjNkNDc3NDJiNGM=


query-value-password-1
B5jWFpekryfVfNSF4P5dNdEKuFEUdbW9aEDZ85PDdaNwKxcvgaVwZVzAABfEd5QS



</value>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="Description">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
    </modify>
  </input>
</nds>

```





IdMUnit swa-scim-connector: Add client authentication support
https://southwest.atlassian.net/browse/CSEE-4072






Token Details
Token Name
oauth2SprinklerToken
Access Token
3Wkc9m13Wg0tWc3SVwt6Hl1iU9vLVEYKLIaTJuen/MdjMDk4NDQxMi1jYTQyLTM3NDgtOGRhNS1iZDE5YjBhMjVmZmU=
Token Type
Bearer
refresh_token
MNnrBmvE4DY3nYyh7tFAoKep4rm9qc6PWXl3WsPGGWpiOGQyZTBkNC04N2RhLTNmYWYtOGViOS0yNzBmM2MxNTZiMTU=
expires_in
2591999
access_token_url
https://api2.sprinklr.com/oauth/token
client_id
kgqsgfz47n7wb4f5tfwexgxd








guessed:
https://api2.sprinklr.com/api/v2/scim/Schemas

Auth:
https://api2.sprinklr.com/oauth/token

401: Reason: Unauthorized Message: <h1>Developer Inactive</h1>






{
  "schemas": [
    "urn:ietf:params:scim:schemas:core:2.0:User"
  ],
  "name": {
    "givenName": "Inflt",
    "familyName": "Crewmember5"
  },
  "userName": "e999002@wnco.com",
  "isSpaceUser": "true",
  "active": true,
  "globalAttributes": {
    "partnerCustomProperties": {
      "_c_65a965d0ed316372bde492f6": "System Admin"
    },
    "productSeat": "Sprinklr Social",
    "federationId": "e999002",
    "passwordLoginDisabled": "true"
  },
  "clientAttributes": {
    "clientId": 24559,
    "userType": "PARTNER_ADMIN"
  }
}




/tmp/idtosprinklr5.JSON



<?xml version="1.0" encoding="UTF-8"?><schema-def application-name="SCIM " hierarchical="true">
	<class-def class-name="urn:ietf:params:scim:schemas:core:2.0:User">
		<attr-def attr-name="userName" multi-valued="false" type="string"/>
		<attr-def attr-name="active" multi-valued="false" type="boolean"/>
		<attr-def attr-name="name" multi-valued="false" type="string"/>
		<attr-def attr-name="name:givenName" multi-valued="false" type="string"/>
		<attr-def attr-name="name:familyName" multi-valued="false" type="string"/>
		<attr-def attr-name="id" multi-valued="false" type="string"/>
		<attr-def attr-name="clientAttributes" multi-valued="false" type="string"/>
		<attr-def attr-name="isSpaceUser" multi-valued="false" type="string"/>
	</class-def>
</schema-def>



   : The current schema class 'urn:ietf:params:scim:schemas:core:2.0:User' does not contain attribute definition for the attribute 'CN'.
[09/17/24 11:21:02.080]:IDtoSprinkler ST:                        : The current schema class 'urn:ietf:params:scim:schemas:core:2.0:User' does not contain attribute definition for the attribute 'swaSprinklerRole'.
[09/17/24 11:21:02.080]:IDtoSprinkler ST:                        : The current schema class 'urn:ietf:params:scim:schemas:core:2.0:User' does not contain attribute definition for the attribute 'isSpaceUser'.
[09/17/24 11:21:02.081]:IDtoSprinkler ST:                        : The current schema class 'urn:ietf:params:scim:schemas:core:2.0:User' does not contain attribute definition for the attribute 'globalAttributes'.
[09/17/24 11:21:02.081]:IDtoSprinkler ST:                        : The current schema class 'urn:ietf:params:scim:schemas:core:2.0:User' does not contain attribute definition for the attribute 'clientAttributes'.



 - todo: need tog et sprinkler schema file



9/18/2024 4:00:15 PM
Issue fixed with Yatin:
This:
![[Pasted image 20240918160019.png]]
Needs to be this:

![[Pasted image 20240918160043.png]]


Odd - next issue: globalAttritubres is tossed in prod, but no in dev - here's prod on your test where the globalattributes is completely dropped; but it appears otherwise ok

![[Pasted image 20240918165449.png]]


IN dev, when I do an add, it sees the error, but toses the event:

![[Pasted image 20240918165529.png]]

9/24/2024 5:29:00 PM
Fixing auth creds
Vanilla driver bearer:
![[{40A4FED5-51FA-4AFA-99DE-5FBAEE2D008A}.png]]
![[{10F597A0-6983-45B8-8597-CC059A97EB61}.png]]

![[{1A3153FA-5CC7-4578-B026-660DB9427ED0}.png]]



9/25/2024 9:54:06 AM



		<do-set-local-variable name="lv_federationId" scope="policy">
				<arg-string>
					<token-attr name="CN"/>
				</arg-string>
			</do-set-local-variable>
			<do-set-local-variable name="lv_sprinklrRole" scope="policy">
				<arg-string>
					<token-attr name="swaSprinklerRole"/>
				</arg-string>
			</do-set-local-variable>
			<do-if>
				<arg-conditions>
					<and>
						<if-attr mode="regex" name="swaSprinklerRole" op="equal">CE.*</if-attr>
					</and>
				</arg-conditions>
				<arg-actions>
					<do-set-local-variable name="lv_productSeat" scope="policy">
						<arg-string>
							<token-text xml:space="preserve">Sprinklr Service</token-text>
						</arg-string>
					</do-set-local-variable>
				</arg-actions>
				<arg-actions>
					<do-set-local-variable name="lv_productSeat" scope="policy">
						<arg-string>
							<token-text xml:space="preserve">Sprinklr Social</token-text>
						</arg-string>
					</do-set-local-variable>
				</arg-actions>
			</do-if>


et currentPayload = `{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User","urn:scim:schemas:extension:sprinklrGlobalAttributes:2.0:User","urn:scim:schemas:extension:sprinklrClientAttributes:2.0:User","urn:scim:schemas:extension:sprinklrUserAssignmentConfig:2.0:User","urn:scim:schemas:extension:sprinklrUserVoiceConfig:2.0:User"],"id":"1569592","name":{"givenName":"Isitah","familyName":"Hunter"},"photos":[{"value":"https://sprcdn-assets.sprinklr.com/1/profile-a74f6bfa-784f-416a-9e68-40d36d4910de-176564324.png"}],"locale":"EN_US","meta":{"resourceType":"User","createdTime":"2024-06-29 00:47:13","lastModified":"2024-06-29 00:57:57"},"emails":[{"value":"x325868@wncotest.com","primary":true}],"userName":"x325868@wncotest.com","active":true, "clientAttributes":[{"clientId":24559,"userType":"PARTNER_ADMIN"}]}`;
let globalAttributes = '{ "partnerCustomProperties": { "~gcv_partnerValue~": [ "$lv_sprinklrRole$" ] }, "federationId": "$lv_federationId$",  "productSeat": "$lv_productSeat$",   "passwordLoginDisabled": true }';

	jsonPayload = JSON.parse(currentPayload);


	//jsonPayload.photos[0].value = "gotcha"

	toappendPayload = JSON.parse(globalAttributes);
	jsonPayload.globalAttributes = toappendPayload;
console.log(JSON.stringify(jsonPayload, null, 4)); // spacing level = 4)
//	return jsonPayload;






let currentPayload = `{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User","urn:scim:schemas:extension:sprinklrGlobalAttributes:2.0:User","urn:scim:schemas:extension:sprinklrClientAttributes:2.0:User","urn:scim:schemas:extension:sprinklrUserAssignmentConfig:2.0:User","urn:scim:schemas:extension:sprinklrUserVoiceConfig:2.0:User"],"id":"1569592","name":{"givenName":"Isitah","familyName":"Hunter"},"photos":[{"value":"https://sprcdn-assets.sprinklr.com/1/profile-a74f6bfa-784f-416a-9e68-40d36d4910de-176564324.png"}],"locale":"EN_US","meta":{"resourceType":"User","createdTime":"2024-06-29 00:47:13","lastModified":"2024-06-29 00:57:57"},"emails":[{"value":"x325868@wncotest.com","primary":true}],"userName":"x325868@wncotest.com","active":true, "clientAttributes":[{"clientId":24559,"userType":"PARTNER_ADMIN"}]}`;
let globalAttributes = '{ "partnerCustomProperties": { "~gcv_partnerValue~": [ "$lv_sprinklrRole$" ] }, "federationId": "$lv_federationId$",  "productSeat": "$lv_productSeat$",   "passwordLoginDisabled": true }';

	jsonPayload = JSON.parse(currentPayload);


	//jsonPayload.photos[0].value = "gotcha"

	toappendPayload = JSON.parse(globalAttributes);
	jsonPayload.globalAttributes = toappendPayload;
console.log(JSON.stringify(jsonPayload, null, 4)); // spacing level = 4)
//	return jsonPayload;






Successful post - https://api2.sprinklr.com/api/v2/scim/Users

{
    "schemas": [
        "urn:ietf:params:scim:schemas:core:2.0:User",
        "urn:scim:schemas:extension:sprinklrGlobalAttributes:2.0:User",
        "urn:scim:schemas:extension:sprinklrClientAttributes:2.0:User",
        "urn:scim:schemas:extension:sprinklrUserAssignmentConfig:2.0:User",
        "urn:scim:schemas:extension:sprinklrUserVoiceConfig:2.0:User"
    ],
    "name": {
        "givenName": "Isitah",
        "familyName": "Hunter"
    },
    "photos": [
        {
            "value": "https://sprcdn-assets.sprinklr.com/1/profile-a74f6bfa-784f-416a-9e68-40d36d4910de-176564324.png"
        }
    ],
    "locale": "EN_US",
    "meta": {
        "resourceType": "User",
        "createdTime": "2024-06-29 00:47:13",
        "lastModified": "2024-06-29 00:57:57"
    },
    "emails": [
        {
            "value": "aaronavktest@wncotest.com",
            "primary": true
        }
    ],
    "userName": "aaronavktest@wncotest.com",
    "active": true,
    "clientAttributes": [
        {
            "clientId": 24559,
            "userType": "PARTNER_ADMIN"
        }
    ],
    "globalAttributes": {
        "partnerCustomProperties": {
            "_c_65a965d0ed316372bde492f6": "System Admin"
        },
        "productSeat": "Sprinklr Social",
        "federationId": "aaronavktest",
        "passwordLoginDisabled": "true"
    }
}



item learned: put seems to use url-token association value for PUT id!
  <source>
    <product build="20221116_0247" instance="IDtoBrowserStack" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <driver-operation-data class-name="urn:ietf:params:scim:schemas:core:2.0:User" command="modify" event-id="w11dcledirai004#20240919172640#10#1:4eb0ff4c-17f1-4590-bd32-4cffb04ef117" is-not-sensitive="true" src-d
n="\SWACO_IDALPHA\SWA-IDALPHA\Users\e98765111137">
      <request>
        <url-token association="8945615"/>
        <header content-type="application/scim+json"/>
        <value>{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User"],"id":8945615,"externalId":"preferrednametes_CrSsio","userName":"e98765111137@wnco.com","active":false,"name":{"familyName":"Tester","givenNa
me":"preferredName"},"emails":[{"primary":true,"value":"e98765111137@wnco.com"}],"bstack_role":"User","bstack_team":"NonProd","bstack_product":"Percy"}</value>
      </request>
    </driver-operation-data>
  </input>
</nds>






let inputJsonPayload = `{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User","urn:scim:schemas:extension:sprinklrGlobalAttributes:2.0:User","urn:scim:schemas:extension:sprinklrClientAttributes:2.0:User","urn:scim:schemas:extension:sprinklrUserAssignmentConfig:2.0:User","urn:scim:schemas:extension:sprinklrUserVoiceConfig:2.0:User"],"id":"1569592","name":{"givenName":"Isitah","familyName":"Hunter"},"photos":[{"value":"https://sprcdn-assets.sprinklr.com/1/profile-a74f6bfa-784f-416a-9e68-40d36d4910de-176564324.png"}],"locale":"EN_US","meta":{"resourceType":"User","createdTime":"2024-06-29 00:47:13","lastModified":"2024-06-29 00:57:57"},"emails":[{"value":"x325868@wncotest.com","primary":true}],"userName":"x325868@wncotest.com","active":true, "clientAttributes":[{"clientId":24559,"userType":"PARTNER_ADMIN"}]}`;
let toappend = '{  "globalAttributes":  { "partnerCustomProperties": { "~gcv_partnerValue~": [ "$lv_sprinklrRole$" ] }, "federationId": "$lv_federationId$",  "productSeat": "$lv_productSeat$",   "passwordLoginDisabled": true }}';

jsonPayload = JSON.parse(inputJsonPayload);

toappendPayload = JSON.parse(toappend);

jsonPayload.globalAttributes = toappendPayload;




function addGlobalAttributes(currentPayload, globalAttributes)
{
//let currentPayload = `{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User","urn:scim:schemas:extension:sprinklrGlobalAttributes:2.0:User","urn:scim:schemas:extension:sprinklrClientAttributes:2.0:User","urn:scim:schemas:extension:sprinklrUserAssignmentConfig:2.0:User","urn:scim:schemas:extension:sprinklrUserVoiceConfig:2.0:User"],"id":"1569592","name":{"givenName":"Isitah","familyName":"Hunter"},"photos":[{"value":"https://sprcdn-assets.sprinklr.com/1/profile-a74f6bfa-784f-416a-9e68-40d36d4910de-176564324.png"}],"locale":"EN_US","meta":{"resourceType":"User","createdTime":"2024-06-29 00:47:13","lastModified":"2024-06-29 00:57:57"},"emails":[{"value":"x325868@wncotest.com","primary":true}],"userName":"x325868@wncotest.com","active":true, "clientAttributes":[{"clientId":24559,"userType":"PARTNER_ADMIN"}]}`;
//let globalAttributes = '{ "partnerCustomProperties": { "~gcv_partnerValue~": [ "$lv_sprinklrRole$" ] }, "federationId": "$lv_federationId$",  "productSeat": "$lv_productSeat$",   "passwordLoginDisabled": true }';

	jsonPayload = JSON.parse(currentPayload);
	//toappendPayload = JSON.parse(globalAttributes);
	jsonPayload.globalAttributes = globalAttributes;
//console.log(JSON.stringify(jsonPayload, null, 4)); // spacing level = 4)
	return jsonPayload;

}


console.log(JSON.stringify(jsonPayload, null, 4)); // spacing level = 4)



<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <scim-driver-operation-data class-name="urn:ietf:params:scim:schemas:core:2.0:User" command="modify" event-id="w11dcledirdi019#20240920211055#18#1:25afe22d-a2fb-442e-a280-2de2af25fba2" is-sensitive="false" src-dn="\DEV_SWACO_ID\
swaiddev\Users\x325868">
      <request>
        <url-token association="1569592"/>
        <header content-type="application/scim+json"/>
        <value>{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User","urn:scim:schemas:extension:sprinklrGlobalAttributes:2.0:User","urn:scim:schemas:extension:sprinklrClientAttributes:2.0:User","urn:scim:schemas:extension:sprink
lrUserAssignmentConfig:2.0:User","urn:scim:schemas:extension:sprinklrUserVoiceConfig:2.0:User"],"id":"1569592","name":{"givenName":"Isitah","familyName":"Hunter"},"photos":[{"value":"https://sprcdn-assets.sprinklr.com/1/profile-a74f
6bfa-784f-416a-9e68-40d36d4910de-176564324.png"}],"locale":"EN_US","meta":{"resourceType":"User","createdTime":"2024-06-29 00:47:13","lastModified":"2024-06-29 00:57:57"},"emails":[{"value":"x325868@wncotest.com","primary":true}],"u
serName":"x325868@wncotest.com","active":true, "clientAttributes":[{"clientId":24559,"userType":"PARTNER_ADMIN"}]}</value>
      </request>
      <operation-data DRIVER_REVISION="1.0.1-CSEE-3147-x266698" objectType="contractor"/>
    </scim-driver-operation-data>
  </input>
</nds>

scim-driver-operation-data/request/value



"globalAttributes": { "partnerCustomProperties": { "~gcv_partnerValue~": [ "$lv_sprinklrRole$" ] }, "federationId": "$lv_federationId$", "productSeat": "$lv_productSeat$", "passwordLoginDisabled": true },




"globalAttributes":
  {
    "partnerCustomProperties":
      {
        "~gcv_partnerValue~":
          [ "$lv_sprinklrRole$"
          ]
      },
      "federationId": "$lv_federationId$",
      "productSeat": "$lv_productSeat$",
      "passwordLoginDisabled": true
   },







			<do-set-dest-attr-value name="globalAttributes">
				<arg-value type="string">
					<token-text xml:space="preserve">

partnerCustomProperties": {
"~gcv_partnerValue~": "$lv_sprinklrRole$" // swaSprinklerRole
},
"productSeat": "$lv_productSeat$",  (Sprinklr Service or SprinklR Social)
"federationId": "$lv_federationId$", // just the CN
"passwordLoginDisabled": true
</token-text>
				</arg-value>
			</do-set-dest-attr-value>



"globalAttributes": { "partnerCustomProperties": { "~gcv_partnerValue~": [ "$lv_sprinklrRole$" ] }, "federationId": "$lv_federationId$", "productSeat": "$lv_productSeat$", "passwordLoginDisabled": true },







cn=IDtoSprinkler,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA#1#1660039
cn=IDtoSprinkler,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-IDALPHA#1#1660041


succeeds https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e100001%40wnco.com%22
failse:  https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e98765119318%40wnco.com%22


https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e98765119318%40wnco.com%22



Fails from idmunit:
{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User"],"name":{"givenName":"preferredName","familyName":"Tester"},"userName":"e98765119318@wnco.com","active":true,"globalAttributes":{"partnerCustomProperties":{"_c_65a965d0ed316372bde492f6":"System Admin"},"productSeat":"Sprinklr Social","federationId":"e98765119318","passwordLoginDisabled":"true"},"clientAttributes":[{"clientId":24559,"userType":"PARTNER_ADMIN"}]}


succeeds manually
{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User"],"name":{"givenName":"Catherine","familyName":"Rozanas"},"userName":"e100001@wnco.com","active":true,"globalAttributes":{"partnerCustomProperties":{"_c_65a96
5d0ed316372bde492f6":"System Admin"},"productSeat":"Sprinklr Social","federationId":"e100001","passwordLoginDisabled":"true"},"clientAttributes":[{"clientId":24559,"userType":"PARTNER_ADMIN"}]}<



error possibly when swasprinkerlrole is bad . .

<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoSprinkler" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirai004#20240925161808#10#1:89058cea-d45c-4032-baa2-ea8c05895cd4" level="error" type="driver-general">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: {"data":[],"errors":[{"id":"66f437c27712d02b932887ff","code":400,"message":"Cannot invoke \"com.spr.enums.UserType.toString()\" because the return value of \"com.spr.enums.UserType.fromUserTypeDbName(String)\" is null"}]}<operation-data DRIVER_REVISION="1.0.1-HEAD-x266698" objectType="employee"/>
    </status>
  </output>
</nds>


good query:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <query class-name="urn:ietf:params:scim:schemas:core:2.0:User" event-id="0" scope="subtree">
      <search-class class-name="urn:ietf:params:scim:schemas:core:2.0:User"/>
      <search-attr attr-name="userName">
        <value type="string">e100001@wnco.com</value>
      </search-attr>
      <read-attr/>
    </query>
  </input>
</nds>

good query response
<nds dtdversion="4.x" ndsversion="8.x">
  <source>
    <product version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <driver-operation-data class-name="urn:ietf:params:scim:schemas:core:2.0:User" command="query" is-sensitive="true"><!-- content suppressed -->
    </driver-operation-data>
  </input>
</nds>
[09/25/24 11:20:54.695]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Submitting command document to rest subscriber shim
[09/25/24 11:20:54.695]:IDtoSprinkler ST:        IDtoSprinkler__Scim: RESTSubscriptionShim.execute() :
[09/25/24 11:20:54.696]:IDtoSprinkler ST:        IDtoSprinkler__Scim: queryHandler
[09/25/24 11:20:54.696]:IDtoSprinkler ST:        IDtoSprinkler__Scim: queryHandler: class-name  == 'urn:ietf:params:scim:schemas:core:2.0:User'
[09/25/24 11:20:54.696]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Query: preparing GET to https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e100001%40wnco.com%22
[09/25/24 11:20:54.697]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Resetting headers
[09/25/24 11:20:54.697]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Setting the following HTTP request properties:
 Authorization: <content suppressed>
[09/25/24 11:20:54.697]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Trying to use existing token
[09/25/24 11:20:54.698]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Did a HTTP GET with 0 bytes of data to https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e100001%40wnco.com%22
[09/25/24 11:20:54.698]:IDtoSprinkler ST:        IDtoSprinkler__Scim: *******************************************************
[09/25/24 11:20:54.699]:IDtoSprinkler ST:        IDtoSprinkler__Scim: **********************LOGGING REQUEST******************
[09/25/24 11:20:54.699]:IDtoSprinkler ST:        IDtoSprinkler__Scim: *******************************************************
[09/25/24 11:20:54.699]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Request URL :https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e100001%40wnco.com%22
[09/25/24 11:20:54.700]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Http Method : GET
[09/25/24 11:20:54.700]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Sending http request with below headers :-
[09/25/24 11:20:54.700]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Authorization: <content suppressed>
[09/25/24 11:20:54.700]:IDtoSprinkler ST:        IDtoSprinkler__Scim: ***************************END**************************
[09/25/24 11:20:54.806]:IDtoSprinkler ST:        IDtoSprinkler__Scim: ********************************************************
[09/25/24 11:20:54.807]:IDtoSprinkler ST:        IDtoSprinkler__Scim: ***********************LOGGING RESPONSE*****************
[09/25/24 11:20:54.807]:IDtoSprinkler ST:        IDtoSprinkler__Scim: ********************************************************
[09/25/24 11:20:54.807]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Http response code : 200
[09/25/24 11:20:54.808]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Http response status : HTTP/1.1 200 OK
[09/25/24 11:20:54.808]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Getting http response with below headers :-
[09/25/24 11:20:54.808]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Date: Wed, 25 Sep 2024 16:20:54 GMT
[09/25/24 11:20:54.809]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Content-Type: application/scim+json
[09/25/24 11:20:54.809]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Connection: keep-alive
[09/25/24 11:20:54.809]:IDtoSprinkler ST:        IDtoSprinkler__Scim: X-Mashery-Responder: prod-j-worker-us-east-1d-17.use1.mashery.


bad query

<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <query class-name="urn:ietf:params:scim:schemas:core:2.0:User" event-id="0" scope="subtree">
      <search-class class-name="urn:ietf:params:scim:schemas:core:2.0:User"/>
      <search-attr attr-name="userName">
        <value type="string">e98765119318@wnco.com</value>
      </search-attr>
      <read-attr/>
    </query>
  </input>
</nds>



bad query response
[09/25/24 11:23:33.111]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Submitting command document to rest subscriber shim
[09/25/24 11:23:33.112]:IDtoSprinkler ST:        IDtoSprinkler__Scim: RESTSubscriptionShim.execute() :
[09/25/24 11:23:33.112]:IDtoSprinkler ST:        IDtoSprinkler__Scim: queryHandler
[09/25/24 11:23:33.112]:IDtoSprinkler ST:        IDtoSprinkler__Scim: queryHandler: class-name  == 'urn:ietf:params:scim:schemas:core:2.0:User'
[09/25/24 11:23:33.113]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Query: preparing GET to https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e98765119318%40wnco.com%22
[09/25/24 11:23:33.113]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Resetting headers
[09/25/24 11:23:33.113]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Setting the following HTTP request properties:
 Authorization: <content suppressed>
[09/25/24 11:23:33.114]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Trying to use existing token
[09/25/24 11:23:33.114]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Did a HTTP GET with 0 bytes of data to https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e98765119318%40wnco.com%22
[09/25/24 11:23:33.114]:IDtoSprinkler ST:        IDtoSprinkler__Scim: *******************************************************
[09/25/24 11:23:33.115]:IDtoSprinkler ST:        IDtoSprinkler__Scim: **********************LOGGING REQUEST******************
[09/25/24 11:23:33.115]:IDtoSprinkler ST:        IDtoSprinkler__Scim: *******************************************************
[09/25/24 11:23:33.115]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Request URL :https://api2.sprinklr.com/api/v2/scim/Users?filter=userName+eq+%22e98765119318%40wnco.com%22
[09/25/24 11:23:33.116]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Http Method : GET
[09/25/24 11:23:33.116]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Sending http request with below headers :-
[09/25/24 11:23:33.117]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Authorization: <content suppressed>
[09/25/24 11:23:33.118]:IDtoSprinkler ST:        IDtoSprinkler__Scim: ***************************END**************************
[09/25/24 11:23:33.193]:IDtoSprinkler ST:        IDtoSprinkler__Scim: ********************************************************
[09/25/24 11:23:33.193]:IDtoSprinkler ST:        IDtoSprinkler__Scim: ***********************LOGGING RESPONSE*****************
[09/25/24 11:23:33.193]:IDtoSprinkler ST:        IDtoSprinkler__Scim: ********************************************************
[09/25/24 11:23:33.194]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Http response code : 401
[09/25/24 11:23:33.194]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Http response status : HTTP/1.1 401
[09/25/24 11:23:33.194]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Getting http response with below headers :-
[09/25/24 11:23:33.195]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Date: Wed, 25 Sep 2024 16:23:33 GMT
[09/25/24 11:23:33.195]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Content-Type: text/html;charset=iso-8859-1
[09/25/24 11:23:33.195]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Content-Length: 5
[09/25/24 11:23:33.195]:IDtoSprinkler ST:        IDtoSprinkler__Scim: Connection: keep-alive
[09/25/24 11:23:33.196]:IDtoSprinkler ST:        IDtoSprinkler__Scim: X-Mashery-Responder: prod-j-worker-us-east-1b-10.use1.mashery.com



9/25/2024 10:05:40 AM
IDtosprinkler - when grant_type is set to client_credentials
https://www.oauth.com/oauth2-servers/access-tokens/client-credentials/


<?xml version="1.0" encoding="UTF-8"?><!DOCTYPE policy PUBLIC "policy-builder-dtd" "C:\netiq\idm\apps\Designer\plugins\com.novell.idm.policybuilder_4.0.0.202306212152\DTD\dirxmlscript4.8.6.dtd"><policy>
	<rule>
		<description>TEMPORARY DELETE ME</description>
		<conditions/>
		<actions>
			<do-set-src-attr-value class-name="driverAuthBasicPwd" name="driverAuthBasicPwd">
				<arg-value type="string">
					<token-named-password name="driverAuthBasicPwd"/>
				</arg-value>
			</do-set-src-attr-value>
			<do-set-src-attr-value class-name="driverKeystorePassword-1" name="driverKeystorePassword-1">
				<arg-value type="string">
					<token-named-password name="driverKeystorePassword-1"/>
				</arg-value>
			</do-set-src-attr-value>
			<do-set-src-attr-value class-name="driverOAuthPwd" name="driverOAuthPwd">
				<arg-value type="string">
					<token-named-password name="driverOAuthPwd"/>
				</arg-value>
			</do-set-src-attr-value>
			<do-set-src-attr-value class-name="driver-password" name="driver-password">
				<arg-value type="string">
					<token-named-password name="driver-password"/>
				</arg-value>
			</do-set-src-attr-value>
			<do-set-src-attr-value class-name="proxyPassword" name="proxyPassword">
				<arg-value type="string">
					<token-named-password name="proxyPassword"/>
				</arg-value>
			</do-set-src-attr-value>
			<do-set-src-attr-value class-name="query-value-password-0" name="query-value-password-0">
				<arg-value type="string">
					<token-named-password name="query-value-password-0"/>
				</arg-value>
			</do-set-src-attr-value>
			<do-set-src-attr-value class-name="query-value-password-1" name="query-value-password-1">
				<arg-value type="string">
					<token-named-password name="query-value-password-1"/>
				</arg-value>
			</do-set-src-attr-value>
			<do-set-src-attr-value class-name="rl-password" name="rl-password">
				<arg-value type="string">
					<token-named-password name="rl-password"/>
				</arg-value>
			</do-set-src-attr-value>
			<do-veto/>
		</actions>
	</rule>
</policy>


<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify class-name="User" dest-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e99001" dest-entry-id="365255" event-id="w11dcledirai004#20240924232212#10#1:e326d0d1-930c-417b-8348-d1d026e30c93">
      <modify-attr attr-name="driverAuthBasicPwd">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="driverKeystorePassword-1">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="driverOAuthPwd">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="driver-password">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="proxyPassword">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="query-value-password-0">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="query-value-password-1">
        <remove-all-values/>
        <add-value>
          <value type="string">B5jWFpekryfVfNSF4P5dNdEKuFEUdbW9aEDZ85PDdaNwKxcvgaVwZVzAABfEd5QS</value>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="rl-password">
        <remove-all-values/>
        <add-value>
          <value type="string"/>
        </add-value>
      </modify-attr>
    </modify>
  </input>
</nds>






We have built an IDtoMiro driver that I think should take care of these tasks.
https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551026/IDtoMiro





9/25/2024 4:14:07 PM
FYI Yatin: this value is the same in both dev/prod, if you didn't already know:
  gcv_partnerValue:   _c_65a965d0ed316372bde492f6


9/25/2024 5:25:23 PM
Major item learned today: the IdMUnit tests can't use the same creds as the driver; as only one bearerToken and refresh token can be used at the same time!!

I requested an additional client_id and secret from Devin Marshall today.

9/26/2024 5:21:40 PM
scim playlod sprinkler:
![[{DCCEE1C3-C5AD-40A6-99D5-40A77E3861C8}.png]]


![[{EC3C26B4-1D73-4FFD-9747-A3EBF6A38711}.png]]

9/27/2024 6:00:51 PM



Devin,

1 more odd item I see in the API: the globalAttributes.productSeat doesn't seem to return by default; meaning I can't validate that field is populated in Sprinkler.


ONe user sprinkler payload
{
    "schemes": [
        "urn:ietf:params:scim:api:messages:2.0:ListResponse"
    ],
    "Resources": [
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User",
                "urn:scim:schemas:extension:sprinklrGlobalAttributes:2.0:User",
                "urn:scim:schemas:extension:sprinklrClientAttributes:2.0:User",
                "urn:scim:schemas:extension:sprinklrUserAssignmentConfig:2.0:User",
                "urn:scim:schemas:extension:sprinklrUserVoiceConfig:2.0:User"
            ],
            "id": "1660020",
            "userName": "e100001@wnco.com",
            "name": {
                "familyName": "Rozanas",
                "givenName": "Catherine"
            },
            "photos": [
                {
                    "value": "https://sprcdn-assets.sprinklr.com/1/profile-a74f6bfa-784f-416a-9e68-40d36d4910de-176564324.png"
                }
            ],
            "active": true,
            "locale": "EN_US",
            "globalAttributes": {
                "partnerCustomProperties": {
                    "_c_65a965d0ed316372bde492f6": [
                        "System Admin"
                    ]
                },
                "federationId": "e100001",
                "passwordLoginDisabled": true
            },
            "clientAttributes": [
                {
                    "clientId": 24559,
                    "userType": "PARTNER_ADMIN",
                    "phoneNumbers": [
                        {}
                    ],
                    "businessCategory": "CORPORATE"
                }
            ],
            "meta": {
                "resourceType": "User",
                "createdTime": "2024-09-25 16:20:55",
                "lastModified": "2024-09-25 16:38:20"
            },
            "emails": [
                {
                    "value": "e100001@wnco.com",
                    "primary": true
                }
            ]
        }
    ],
    "totalResults": 1,
    "startIndex": 1,
    "itemsPerPage": 100
}



sprinkler user in idmunit:


{"schemes":["urn:ietf:params:scim:api:messages:2.0:ListResponse"],"Resources":[{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User","urn:scim:schemas:extension:sprinklrGlobalAttributes:2.0:User","urn:scim:schemas:extension:sprinklrClientAttributes:2.0:User","urn:scim:schemas:extension:sprinklrUserAssignmentConfig:2.0:User","urn:scim:schemas:extension:sprinklrUserVoiceConfig:2.0:User"],"id":"1660350","userName":"e98765114089@wnco.com","name":{"familyName":"Tester","givenName":"givenName"},"photos":[{"value":"https://sprcdn-assets.sprinklr.com/1/profile-a74f6bfa-784f-416a-9e68-40d36d4910de-176564324.png"}],"active":true,"locale":"EN_US","globalAttributes":{"partnerCustomProperties":{"_c_65a965d0ed316372bde492f6":["System Admin"]},"federationId":"e98765114089","passwordLoginDisabled":true},"clientAttributes":[{"clientId":24559,"userType":"PARTNER_ADMIN","phoneNumbers":[{}],"businessCategory":"CORPORATE"}],"meta":{"resourceType":"User","createdTime":"2024-09-26 14:19:01","lastModified":"2024-09-26 14:19:02"},"emails":[{"value":"e98765114089@wnco.com","primary":true}]}],"totalResults":1,"startIndex":1,"itemsPerPage":100}


fields:





FYI; I'm out sick today and will not be working. I did find my IDtoSprinkler tests were failing as our credentials allow only one concurrent session. The app owner is planning on giving us an additional set today. IDtoBrowserStack sync is now supported. Next is to prep for UAT.



 Good news: I found that the IDtoSprinkler tests were failing due to our credentials allowing only one session, which was being used in the driver! The app owner said they'd have new credentials today.

9/30/2024 2:58:48 PM

Needs 2 - has IdMUnit tests added, and some minor deprovisioning fixes:
https://gitlab-tools.swacorp.com/csiam/idm/idtosprinkler/-/merge_requests/17









Yatin, each of the 3 deprovision use cases I see have issues. Here's the use cases, the issues, and the fixes I am making now, until you say otherwise:



Here are the deprovision cases from From: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/363724873/IDtoSprinklr

1 - User loses swaSprinklerRole -> should disable account in Sprinkler, and remove association in eDirectory.
2 - Users becomes teriminated -> Same thing: disable in sprinkler, remove association.
3 - Deletion -> Do nothing, user stays in Sprinkler.

Here are the issues:

1 - loss of role: The detection for the loss of the role is not working as expected - if-op-attr changing to "" is returning false (see below).
2 - Termination: The association is not removed.
3 - Deletion -> right now the driver is sending on the deletion.

Here are the fixes I'd like to implement:

1 - I'd like to change to 'if op-attr changing' and 'if op attr not available', this seems to detect a removal properly, then add a 'remove-association' call.
2 - I'd like to add a removal of the association.
3 - I'd like to block deletes.




DETAILS:


On Use case 1 -

  On the removal of the role, the 'if-op-attr' changing to "" does not seem to detect a deprovision: it returns false, despite this being a removal.


  [09/30/24 14:28:10.073]:IDtoSprinkler ST:
  <nds dtdversion="4.0" ndsversion="8.x">
    <source>
      <product edition="Advanced" version="4.8.6.0000">DirXML</product>
      <contact>NetIQ Corporation</contact>
    </source>
    <input>
      <modify cached-time="20240930192809.942Z" class-name="User" event-id="w11dcledirai004#20240930192809#10#1:2d80882e-acc1-4b9d-b6c9-2e88802dc1ac" qualified-s
  rc-dn="O=SWA-IDALPHA\OU=Users\CN=e98765314072" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e98765314072" src-entry-id="381857" timestamp="0#0">
        <association state="associated">1661883</association>
        <modify-attr attr-name="swaSprinklerRole">
          <remove-value>
            <value timestamp="1727724484#6" type="string">System Admin</value>
          </remove-value>
        </modify-attr>
        <operation-data DRIVER_REVISION="1.0.1-HEAD-x266698" objectType="employee"/>
      </modify>
    </input>
  </nds>
  .
  .
  .
  </nds>
  [09/30/24 14:28:10.103]:IDtoSprinkler ST:          (if-attr 'swaStatus' match "T|S") = FALSE.
  [09/30/24 14:28:10.104]:IDtoSprinkler ST:          (if-op-attr 'swaSprinklerRole' changing-to "") = FALSE.
  [09/30/24 14:28:10.104]:IDtoSprinkler ST:        Performing else actions.
  [09/30/24 14:28:10.104]:IDtoSprinkler ST:          Action: do-set-dest-attr-value("active","true").
  [09/30/24 14:28:10.105]:IDtoSprinkler ST:            arg-string("true")
  [09/30/24 14:28:10.105]:IDtoSprinkler ST:              token-text("true")
  [09/30/24 14:28:10.105]:IDtoSprinkler ST:              Arg Value: "true".

On use case 2



10/1/2024 3:04:08 PM
Yatin did code walkthrough; this was the afternoon session:
10/1/2024 2:34:30 PM
Yatin - IDtoSprinkler waolk through.
 - Intro, and notes about MyAccess: driver fulfills myaccess requests.
 - Apache dir stodio is open, talking about swaSprinklerRole 10/1/2024 2:37:52 PM
 - 9 roles
 - looking at filter, special swaSprinklerrole attrs
 - showing maping table from swaSrinkler role to partnerrolename.
 - talking through issues he's seen - 10/1/2024 2:43:13 PM
 - IDtoSprinkler-ERR-0003 - these are what incs are created from I think.
 - Clayton miles: someone changes roles; have more than one? Yaton - no
 - ** How driver authenticates.
 -




10/7/2024 6:16:30 PM
prod deploy verification:
Test user did test for sprinkler in prod. Removed swaSpirnklerroles and system removed mail - now deleting user . .
cn=e999999,ou=Users,o=SWA-ID
cn=IDtoSprinkler,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#1664856



12/10/2024 2:03:29 PM
App team wants to have me help them test some new roles. They will be updating their myaccess feed file for qa, hopefully tonight to test some in qa tomorrow (thursday), then thursday night the'll do the same thing to be ready for Friday. Firday morning at 8 am I'll send a few users through.

12/10/2024 10:59:54 AM
 - IDtoSprinkler:
 - Thursday updating feed file . .
 - Friday - morning: sprinkler adding new roles . .
 - Devin Marshall:
   - will update dev/sandbox -
   -



8/22/2025 10:19:00 AM

My minor work I had to do before gokul

We have THREE minor changes to make to the driver. I'll get with Angie to document and schedule the update:

Change 1: Add the CLIENT_USER row to the Sprinkler Parter Role mapping table: (name of the table is "mp-mappingTable")

<row>
    <col>CE Specialist</col>
    <col>CLIENT_USER</col>
</row>

Change 2: We only have three possible partner role values, CLIENT_USER, PARTNER_ADMIN, CLIENT_ADMIN, and have found that if we default any missing roles to CLIENT_USER, we can minimize future issues like this.
CLIENT_USER

We may have additional changes, we’re asking Devin to confirm any items left over; such as adding more parnter roles,etc.

Change 3:

8/19/2025 11:48:33 AM- Devin Marshal confirmed there is both MyAccess, and IDM driver work to expose new roles!





gokul doing some work; I jsut sent him notes like this. He'll deploy my minor updates when he's done with his mulit-attribute work.

 Test items:
          // 1.5 - uses a role called 'ARoleNotInTheTable', and it defaults properly to CLIENT_USER, and does not error out!
          // UC-LEAVE-3.2 User Terminated - failed once while I was running baselines, but I could not reproduce the error . .just a heads up. If you see this fail, I'm happy to take it back and see if I can clean it up.
          // The tests are slow: high timeouts were added to the tests . .it seems sprinkler can be slow, and there seems to be an API rate limit that is pretty sensitive.


        // low priority:
        // JSON pretty printer has been added to the auxiliary folder, and I pretty printed the JSON
        // Postman collections are split across environments, ideally we'd combine all of them into one json.



8/22/2025 10:20:20 AM
This issue appeard for these users when we didn't have a partner role specified! blnak string causes this exception:
(|
(cn=e118641)
(cn=e121800)
(cn=e88776)
(cn=e143973)
)
[07/24/25 23:54:55.383]:IDtoSprinkler ST:
DirXML Log Event -------------------
     Driver:   \SWACO_ID\SWA-ID\Services\DirXML\Driver Set AEv1\IDtoSprinkler
     Channel:  Subscriber
     Object:   \SWACO_ID\SWA-ID\Users\e143973
     Status:   Error
     Message:  com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException
