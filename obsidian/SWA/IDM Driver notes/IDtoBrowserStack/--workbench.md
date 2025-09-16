8/23/2024 11:16:40 AM
All packages selected for IDtoPercy:
![[Pasted image 20240823111639.png]]

8/26/2024 3:21:22 PM
Had intake form meeting 1 today; stored the form in the repo. DRiver is now IDtoBrowserStack.

8/23/2024 3:12:40 PM
BrowserStatck Percy meeting.

Ideally, after this meeting we'd have the following:

 - The list of fields or attributes we need to sync to BrowserStack Percy
 - API docs that describe BrowserStack's implementation of SCIM
   - Need to know which fields can be updated.
   - What flexibility and limitations we have such as API rate limits and read only attributes.
   - How is authenticatoin set up.
 - Credentials to 3 separate instances: DEV/QA/PROD environments to go test.
 - Understand the naming: BrowserStack seems like a brand name, and Percy seems like the software name.
  - Normally, we'd name the driver sometihnhg like IDto then the


NAME
   -IDtoBrowserStack
Here are the details on the browserstack side of things once beginning the configuration process for user provisioning:
User name
2zDSH7moc4cSKm2XcsMY
Access Key
VeALaAcBnDhohjuz5eto
SCIM Service URL
https://www.browserstack.com/scim/v2/

curl -u "VeALaAcBnDhohjuz5eto:VeALaAcBnDhohjuz5eto" -X GET https://browserstack.com/user/user_detail"

curl -u "2zDSH7moc4cSKm2XcsMY:VeALaAcBnDhohjuz5eto" -X GET https://browserstack.com/user/user_detail"




Initial Migration:
Lots of users request access? or do we need an automated push of users?
 - Don't have current number - Currently 10 users at the moment; 20 later.
 - Requested Roles from Guthrie for existing users? CSV maybe?
 - likley have them go through the process.
 - 20 currently - .com -> 150 maxmimum: UI devs & non . .


MyAccess:
  - UFM Need to have file transfer discussions: form will go over this.
  - Communication to/from MyAccess.
  - Maybe SCIM access from MyAccess?

Guthrie Schoolar: main
Haley Trammel: PO - joined then left.



Also had screenshots int he meeting:

![[Pasted image 20240826161838.jpg]]



![[Pasted image 20240826161845.jpg]]


![[Pasted image 20240826161852.jpg]]

8/27/2024 12:29:23 PM
open questions for BrowserStack support:
 - We intend to enable a process that will make use of the SCIM API to provision accounts into BrowserStack, and subsquently give them Percy access. Here are our questions:
  1 - Once we enable the SCIM API; how do we maintain admin rights in the GUI?
  2 - Two of us, Guthrie Schoolar, and Aaron Kynaston are working together on this. Guthrie needs to maintain full admin rights in BrowserSTack to create manage teams/users. Aaron Kynaston is the SCIM developer that will make use of the API to provision/manage/delete users in BrowserStack, mainly for Percy right now.
    - How can we add Aaron's account to have full access to the SCIM API documentation?
  3 - It appears that a 'Team' is some kind of separation of scopes in BrowserStack.
    - Is this true?
    - Do we need to create an Admin per team?
    - Can we have the SCIM process manage a handful of teams, yet still allow Guthrie to access/manage those teams and users?

9/11/2024 10:29:48 AM
Healthy user:
```
      {
            "schemas": [
               "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 3612258, - Created by Browser STack 
            "externalId": "blakemartin5", - Created by Browser STack
            "userName": "blake.martin@wnco.com", - 'mail'
            "active": true, - swastatus = A
            "name": {
                "familyName": "Martin", - Surname
                "givenName": "Blake" - given Name
            },
            "emails": [
                {
                    "primary": true,  ?????????????
                    "value": "blake.martin@wnco.com" - 'mail'
                }
            ],
            "bstack_role": "User",  - Statically set to Role
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },

```


stop time 9/11/2024 1:43:37 PM















       "id": 8877378, - DONE
            "id": 8884790, - DONE
            "id": 8898036, - done
            "id": 8918994, - done
            "id": 8919005 - done
            "id": 8919028, - now
            "id": 8919034,
            "id": 8919035,
            "id": 8919036,
            "id": 8919038,



https://jira.atlassian.com/browse/CONFCLOUD-67831



{
    "schemas": [
        "urn:ietf:params:scim:api:messages:2.0:ListResponse"
    ],
    "totalResults": 30,
    "startIndex": 1,
    "itemsPerPage": 100,
    "Resources": [
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 3612258,
            "externalId": "blakemartin5",
            "userName": "blake.martin@wnco.com",
            "active": true,
            "name": {
                "familyName": "Martin",
                "givenName": "Blake"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "blake.martin@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 3638685,
            "externalId": "ashishshukla6",
            "userName": "ashish.shukla@wnco.com",
            "active": true,
            "name": {
                "familyName": "Shukla",
                "givenName": "Ashish"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "ashish.shukla@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 5332077,
            "externalId": "toddmilburn_lIgOt7",
            "userName": "todd.milburn@wnco.com",
            "active": true,
            "name": {
                "familyName": "Milburn",
                "givenName": "Todd"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "todd.milburn@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 6327085,
            "externalId": "randysorensen_Qni8v2",
            "userName": "randy.sorensen@wnco.com",
            "active": true,
            "name": {
                "familyName": "Sorensen",
                "givenName": "Randy"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "randy.sorensen@wnco.com"
                }
            ],
            "bstack_role": "Admin",
            "bstack_team": null,
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 7256626,
            "externalId": "howardpatty_I01pKf",
            "userName": "howard.patty@wnco.com",
            "active": true,
            "name": {
                "familyName": "Patty",
                "givenName": "Howard"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "howard.patty@wnco.com"
                }
            ],
            "bstack_role": "Owner",
            "bstack_team": null,
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8216159,
            "externalId": "haleytrammell_E0xgKv",
            "userName": "haley.trammell@wnco.com",
            "active": true,
            "name": {
                "familyName": "Trammell",
                "givenName": "Haley"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "haley.trammell@wnco.com"
                }
            ],
            "bstack_role": "Admin",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8216160,
            "externalId": "jessica_34oitP",
            "userName": "jessica.runandy@wnco.com",
            "active": true,
            "name": {
                "familyName": "Runandy",
                "givenName": "Jessica"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "jessica.runandy@wnco.com"
                }
            ],
            "bstack_role": "Admin",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8216191,
            "externalId": "ravirajuramachan_BxSOY3",
            "userName": "ravi.rajuramachandran@wnco.com",
            "active": true,
            "name": {
                "familyName": "Raju",
                "givenName": "Ravi"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "ravi.rajuramachandran@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8216236,
            "externalId": "jennyhou_uKtXbe",
            "userName": "jenny.hou@wnco.com",
            "active": true,
            "name": {
                "familyName": "Hou",
                "givenName": "Jenny"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "jenny.hou@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8216309,
            "externalId": "paulodarochafilh_hTjz5f",
            "userName": "paulo.darochafilho@wnco.com",
            "active": true,
            "name": {
                "familyName": "Da",
                "givenName": "Paulo"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "paulo.darochafilho@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8284211,
            "externalId": "guthrieschoolar_qjw9VW",
            "userName": "guthrie.schoolar@wnco.com",
            "active": true,
            "name": {
                "familyName": "Schoolar",
                "givenName": "Guthrie"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "guthrie.schoolar@wnco.com"
                }
            ],
            "bstack_role": "Admin",
            "bstack_team": null,
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8512903,
            "externalId": "bencarmen_fvt6lw",
            "userName": "ben.carmen@wnco.com",
            "active": true,
            "name": {
                "familyName": "Carmen",
                "givenName": "Ben"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "ben.carmen@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8847177,
            "externalId": "jayposten_2zlk6v",
            "userName": "jay.posten@wnco.com",
            "active": true,
            "name": {
                "familyName": "",
                "givenName": "jay_posten"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "jay.posten@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Browser-Testing,Mobile-App-Testing,Visual-Testing"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8867202,
            "externalId": "swethapothu_Eivzp1",
            "userName": "swetha.pothu@wnco.com",
            "active": true,
            "name": {
                "familyName": "",
                "givenName": "swetha_pothu"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "swetha.pothu@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8873080,
            "externalId": "michaellevee_BlhcLn",
            "userName": "michael.levee@wnco.com",
            "active": true,
            "name": {
                "familyName": "",
                "givenName": "michael_levee"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "michael.levee@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8873102,
            "externalId": "navinkallolli_j0pyYS",
            "userName": "navin.kallolli@wnco.com",
            "active": true,
            "name": {
                "familyName": "",
                "givenName": "navin_kallolli"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "navin.kallolli@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8874200,
            "externalId": "aaronkynaston_CI57zs",
            "userName": "aaron.kynaston@wnco.com",
            "active": true,
            "name": {
                "familyName": "Kynaston",
                "givenName": "Aaron"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "aaron.kynaston@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8877378,
            "externalId": "caniseeme_6H2Wyo",
            "userName": "cani.seeme@wnco.com",
            "active": true,
            "name": {
                "familyName": "SeeMe",
                "givenName": "CanI"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "cani.seeme@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms1",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8884312,
            "externalId": "davidmorabito_D0VPJS",
            "userName": "david.morabito@wnco.com",
            "active": true,
            "name": {
                "familyName": "Morabito",
                "givenName": "David"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "david.morabito@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8884398,
            "externalId": "vallabhkondra_qz9arj",
            "userName": "vallabh.kondra@wnco.com",
            "active": true,
            "name": {
                "familyName": "",
                "givenName": "vallabh_kondra"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "vallabh.kondra@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": "Digital Platforms",
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8884790,
            "externalId": "caniseeme_qMF1Wg",
            "userName": "cani.seeme2@wnco.com",
            "active": true,
            "name": {
                "familyName": "SeeMe2",
                "givenName": "CanI"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "cani.seeme2@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8898036,
            "externalId": "caniseeme_PmHOxp",
            "userName": "test.orange@wnco.com",
            "active": true,
            "name": {
                "familyName": "SeeMe2",
                "givenName": "CanI"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "test.orange@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8909978,
            "externalId": "ninoangelomagsal_DFoUzX",
            "userName": "ruben.gurung@wnco.com",
            "active": true,
            "name": {
                "familyName": "Angelo",
                "givenName": "Nino"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "ruben.gurung@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": ""
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8918994,
            "externalId": "purpleseeme_MpjxVc",
            "userName": "test.purple@wnco.com",
            "active": true,
            "name": {
                "familyName": "SeeMe2",
                "givenName": "purple"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "test.purple@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": "Percy"
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8919005,
            "externalId": "purpleseeme_je1tMK",
            "userName": "test.green@wnco.com",
            "active": true,
            "name": {
                "familyName": "SeeMe2",
                "givenName": "purple"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "test.green@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": ""
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8919028,
            "externalId": "purpleseeme_8vYGSC",
            "userName": "test.black@wnco.com",
            "active": true,
            "name": {
                "familyName": "SeeMe2",
                "givenName": "purple"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "test.black@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": ""
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8919034,
            "externalId": "williampenn_1xGZdX",
            "userName": "williare@wnco.com",
            "active": true,
            "name": {
                "familyName": "Penn",
                "givenName": "William7"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "williare@wnco.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": ""
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8919035,
            "externalId": "williampenn_iIZQr0",
            "userName": "williare@beep.com",
            "active": true,
            "name": {
                "familyName": "Penn",
                "givenName": "William7"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "williare@beep.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": ""
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8919036,
            "externalId": "williampenn_HWTQl6",
            "userName": "williare@abc.com",
            "active": true,
            "name": {
                "familyName": "Penn",
                "givenName": "William7"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "williare@abc.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": ""
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:User"
            ],
            "id": 8919038,
            "externalId": "williampenn_DUHsiz",
            "userName": "williamhere@gmail.com",
            "active": true,
            "name": {
                "familyName": "Penn",
                "givenName": "William7"
            },
            "emails": [
                {
                    "primary": true,
                    "value": "williamhere@gmail.com"
                }
            ],
            "bstack_role": "User",
            "bstack_team": null,
            "bstack_product": ""
        }
    ]
}







https://miro.com/api/v1/scim/Users?attributes=userName
https://www.browserstack.com/scim/v2/Users?attributes=userName


9 AM Friday



{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User"],"userName":"test.black@wnco.com",     "name":{"givenName":"purple",  "familyName":"SeeMe2"}}
{"schemas":["urn:ietf:params:scim:schemas:core:2.0:User"],"userName":"williamhere@wncotest.com","name":{"givenName":"William7","familyName":"Penn"}}





{
    "schemas": [
        "urn:ietf:params:scim:schemas:core:2.0:User"
    ],
    "externalID": "e9999999999",
    "userName": "test.purple@wnco.com",
    "active": true,
    "name": {
        "givenName": "purple",
        "familyName": "SeeMe2"
    },
    "emails": [
        {
            "primary": true,
            "value": "purple.Seeme2@wnco.com"
        }
    ],
    "bstack_role": "User",
    "bstack_team": "SWATest",
    "bstack_product": "Percy"
}

9/19/2024 12:12:49 PM
I can't seem to disable users:
![[Pasted image 20240919121252.png]]
Doh - a patch is required.


![[Pasted image 20240919123733.jpg]]

interesting - patch works:
manual:
{
    "schemas": [
        "urn:ietf:params:scim:api:messages:2.0:PatchOp"
    ],
    "Operations": [
        {
            "op": "replace",
            "value": {
                "active": false
            }
        }
    ]
}

Shim patch creation:
{
  "schemas": [
    "urn:ietf:params:scim:api:messages:2.0:PatchOp"
  ],
  "Operations": [
    {
      "op": "add",
      "path": "bstack_role",
      "value": "Admin"
    },
    {
      "op": "add",
      "path": "active",
      "value": false
    }
  ]
}


9/19/2024 5:42:03 PM
{
    "schemas": [
        "urn:ietf:params:scim:schemas:core:2.0:User"
    ],
    "id": 8945815,
    "externalId": "preferrednameeaa_s2WAqa",
    "userName": "eaabcc@wnco.com",
    "active": false,
    "name": {
        "familyName": "eAABCC",
        "givenName": "preferredName"
    },
    "emails": [
        {
            "primary": true,
            "value": "eaabcc@wnco.com"
        }
    ],
    "bstack_role": "User",
    "bstack_team": "NonProd",
    "bstack_product": "Percy"
}



Ok all, with other activities going on, our next activity is October 8th. We will be meeting at the church at 6 and making paper airplanes! We'll have a contest, and see who can come up with the best flying plane.



[09/19/24 12:41:57.937]:IDtoBrowserStack ST:Policy returned:
[09/19/24 12:41:57.937]:IDtoBrowserStack ST:
<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoBrowserStack" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <add-association dest-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e98765135493" dest-entry-id="" event-id="w11dcledirai004#20240919174156#10#1:89058cea-d45c-4032-baa2-ea8c05895cd4">8945669<operation-data DRIVER_REVISION="1.0.1-CSEE-3970-x266698" attempt-to-match="true" objectType="employee"/>
    </add-association>
    <status event-id="w11dcledirai004#20240919174156#10#1:89058cea-d45c-4032-baa2-ea8c05895cd4" level="success">
      <operation-data DRIVER_REVISION="1.0.1-CSEE-3970-x266698" attempt-to-match="true" objectType="employee"/>
    </status>
  </output>
</nds>
[09/19/24 12:41:




no matches found:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <query class-name="urn:ietf:params:scim:schemas:core:2.0:User" event-id="0" scope="subtree">
      <search-class class-name="urn:ietf:params:scim:schemas:core:2.0:User"/>
      <search-attr attr-name="userName">
        <value timestamp="1726767301#21" type="string">e98765136923@wnco.com</value>
      </search-attr>
      <read-attr/>
    </query>
  </input>
</nds>
[09/19/24 12:35:03.613]:IDtoBrowserStack ST:        : SCIMSubscriber.execute() started.
[09/19/24 12:35:03.613]:IDtoBrowserStack ST:        : XdsToJsonParser.XdsToJsonParser() object Constructed.
[09/19/24 12:35:03.614]:IDtoBrowserStack ST:        : Transaction() constructed.
[09/19/24 12:35:03.614]:IDtoBrowserStack ST:        : Transaction.execute() called.
[09/19/24 12:35:03.614]:IDtoBrowserStack ST:        : Transaction.resolve() started.
[09/19/24 12:35:03.615]:IDtoBrowserStack ST:        : Transaction.queryHandler() started.
[09/19/24 12:35:03.615]:IDtoBrowserStack ST:        : Transaction.createQuery() started.
[09/19/24 12:35:03.615]:IDtoBrowserStack ST:        : Transaction.createQuery() completed.
[09/19/24 12:35:03.615]:IDtoBrowserStack ST:        : QueryHandler.process() object started.
[09/19/24 12:35:03.616]:IDtoBrowserStack ST:        : Sending command document to subscriber
[09/19/24 12:35:03.616]:IDtoBrowserStack ST:
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



TODO
1 - IDtoBrowserStack match an updates
 - reasses stories? add story for atlea cleanup?
2 - CSMD est
3 - Altea cleanup run
4 - Sprinkler

9/23/2024 4:17:15 PM

Just created the new CI: IDtoBrowserStack.
[RITM10521550](https://southwest.service-now.com/sc_req_item.do?sys_id=c2754e0647f812503df5de5a436d432b&sysparm_view=NULL)


10/4/2024 12:03:33 PM
We got into a chat with guthrie and Howard Patty - chatted about owner/user/admin, and need to com up with a plan - here's the raw notes below.



10/4/2024 11:24:10 AM
Browserstack
myacces: only write from the entitlement name . .
'Percy' entitlement -



Example:

swaBrowserStackRoles:
  UserType:Admin
  Percy
  Browser-Testing

1 - retry for not enabled
2 - long term plan

Owner, Admin, User
Percy, any number of applications . .
 - Driver only supply User

Team,
We've made a few choices, and here's our final plan. We are discussing the setting of a users 'bstack_role' and their 'bstack_product'; both of which are independent sets of strings as follows:

bstack_role: which can be: 'Admin', 'User', or 'Owner'.
bstack_product: which will have one or more of the following: Percy, Browser-Testing, Mobile-App-Testing, Visual-Testing, or others depending on the app name in BrowserStack.

At this point, we believe that MyAccess does not have a way to represent two sets of strings at the same time, and still support future apps, so this is our plan:

1 - The driver will always only set bstack_role as 'User'.
2 - The bstack_role will be managed in the GUI by an administrative user.
3 - The driver has to write full SCIM payloads - including all user data; so any time it sees a corresponding user, it will read use that current user's bstack_role setting.
4 - When Guthrie needs to do admin type work in BrowserStack, he will need to temporarially disable the SCIM api, take the action, then turn it back on again.
5 - On the driver side, if it ever hits an error about the SCIM api being disabled, it will continually retry that event until it is enabled again. This lets the driver preserve any events that need to be processed while Guthrie has the SCIM api disabled. Once the SCIM api is enabled; the driver would succeed within the next 30 seconds.



Example showing when API is turned off

ERROR 422

```


<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoBrowserStack" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirai004#20241004174451#10#1:f0e00871-86ef-464b-a339-7108e0f0ef86" level="error">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Auto User Provisioning is currently not enabled for your organization on Browserstack. Please enable it or contact support.<operation-data DRIVER_REVISION="1.1.2-CSEE-3791-x266698" objectType="employee"/>
    </status>
  </output>
</nds>
[10/04/24 12:44:52.427]:IDtoBrowserStack ST:Applying policy: %+C%14CNETQSCIMDCFG-itp-AppendingAssociationRef%-C.



```


```

<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoBrowserStack" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirai004#20241004174451#10#1:f0e00871-86ef-464b-a339-7108e0f0ef86" level="error">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Auto User Provisioning is currently not enabled for your organization on Browserstack. Please enable it or contact support.<operation-data DRIVER_REVISION="1.1.2-CSEE-3791-x266698" objectType="employee"/>
    </status>
  </output>
</nds>
```










10/4/2024 1:01:57 PM
10/4/2024 12:38:44 PM
Guthrie/Mike chat:

Confirm: Guthrie
 - Do we need to be ready for future applications for BStack.
   - Percy Contract: BrowserStack - ONLY PERCY
   - not likely to have more apps . .
   - other orgs - even have more contracts . .
   - No one is looking at wanting additiona data here
   - Mike - only limited to Percy users?
     - users in MA: would they not even see Percy as requestable?
     - Generally open to all; do we need to seal it down?
     - Guthrie: needs to chat about Contract - currently 'Digital Platforms' -> 'Percy' only.
     - How is licencing handeled?
     - what about additional apps in the future -
     - What about digital platform current team? - want more than percy?
     - Percy - can feed snapshots of HTML, and does visual regression! Strictly for Percy now
     - other apps: Browser-Testing,Mobile-App-Testing,Visual-Testing
     - We are NOT limiting who can see Percy in mya ccess.
      - Discussion of additional attribute consideration to 'expose' Percy requestable access.
   - Open to all

   - other groups - not go to https://www.browserstack.com/scim/v2/Users?
     - just different auth token . .
     - would be a separate driver!!
     - IDtoBrowserStack
     - IDtoBrowserStackCrewScheduling

 - Hierarchical structure?
   - Owner -> Admin -> User
   YES

 - Thinking roles would appear like this in MyAccess:

Only chose 1!
Percy-User
Percy-Admin
Percy-Owner


Mike:
    Feed file?
   - BrowserStack does not support feed file - no kind of export . .
   - Exports to CSV . .
   - have someone manipulate file, then send it to Mike?
   - Bookmark:
     - API query -> jq -> feed file?









abc-User
abc-Admin
abc-Owner

def-User
def-Admin
def-Owner


swaBrowserStackRoles:
  Percy|||User
  def|||Owner
  ghi|||User
  jkl|||User
  mno|||Admin




bstack_product: Percy,def,ghi,jkl,mno
bstack_role: Owner

MA - search for browser stack
   - they would see this:
   -Percy-User  "for users of this product"
    Percy-Admin
    Percy-Owner

    abc-User
    abc-Admin
    abc-Owner

    def-User
    def-Admin
    def-Owner



Summary: need new write up . .


10/4/2024 2:21:20 PM
Sent to Mike and guthrie for review.

Team,

Guthrie, Mike and I were able to discuss a bit more, and now have a simplified plan. At the moment we've decided the following:

1 - Only supporting Percy for now: It simply is unlikely that we'd need to support additional applications in BrowserStack. Exposing only Percy for now makes the most sense as it is the only app that has been contracted at the moment.
2 - Users will be able to select from the following roles in MyAccess. These would be the options that would appear in My Access:

 Percy-User
 Percy-Admin
 Percy-Owner

3 - Engineering note: The driver will not be updated to retry events when the SCIM API is disabled. I the SCIM API is disabled when an event comes through the driver, the the event will be lost. As we don't expect to disable it much or at all this shouldn't be an issue.


10/4/2024 3:25:21 PM
Sent the above note to the chat:
![[{AA6255CA-274C-4306-B0DB-F044471CC1B9}.png]]

![[{1E0D1A5B-B459-4203-90EA-6FB20AD43742}.png]]

10/4/2024 5:48:03 PM
Created story to move to the new prodct|||Role model: (Percy-User/Percy-Admin/Percy-Owner items)

Created to cover the new model:
BrowserStack Percy | IDM - DEV - Update to the Product|||Role model
https://southwest.atlassian.net/browse/CSEE-4097



swaBrowserStackIsAdmin -> bstack_role
swaBrowserStackRoles  -> bstack_product


10/9/2024 11:16:19 AM
Worked on browserstack with mike two days ago - found we didn't have access; he may have access today.
curl -Lu "2zDSH7moc4cSKm2XcsMY:VeALaAcBnDhohjuz5eto" -X GET https://browserstack.com/user/user_detail"



10/10/2024 3:17:12 PM
Aaron Kynaston (Contractor)
10/9/2024 2:52 PM
we decided that we'd set bstack_team to 'NonProd' in test, and 'Digital Platforms' in production. Do you see any chance of actually getting a separate, dedicated instance dedicated to testing? I just need to explicitly document our choice here.
I would assume that we will not get a new instance solely for testing purposes, but I can certainly ask if Browserstack offers that kind of thing. My guess would be we'd have to pen a new contract to get a new instance created, which isn't out of the realm of possibility, but costly. I would put on the record that we'll use the instance we have for now, with a "NonProd" team created for testing to be conducted.


Aaron Kynaston (Contractor)
10/9/2024 3:10 PM
Second question: Do we havea plan to rotate our username/access keys/tokens on a regular basis? Ops has been asking about this, and I think this would be a completely manual process correct?
There is no plan to rotate access on a regular basis. I'm not sure what that looks like from a manual process perspective, but we can do it if need be.




10/11/2024 4:49:45 PM
We were going to write cronjob to send out file; but CN is not in scim result, nor in rest . .can't store CN . need meeting.

MyAccess auto feed generation:
 - Getting access to CN (description?)
 - Getting access to Authentication.



Produce the output file:

 curl --location 'https://miro.com/api/v1/scim/Users' --header 'Authorization: DpM2FTQadZOI5ZmVDKhOD8NuKjj7rFowac4yg6L1cGbhk4pwFrABa1rkDEtUqb8z' | jq . > output.json





10/17/2024 12:03:26 PM
Bottom line is that we are asking for a favor to have access to one more field or an idea to accomplish the following:

We need to be able to produce a report from browserstack that can list all users and their roles - unfortunately, our naming attribute of CN is not currently stored in BrowserStack, a there isn't a an existing field for us to store the CN - we're 99% of the way there hoping you can push us to completion.


BTW - IN my example here - I'm going to show our token on my screen by the way, I would like to make sure that Guthrie and I can generate a new one at least on a yearly basis at some point, for both SCIM and REST; but this is later.

(TASK for later: Learn how to rotate the token)



First:
 - We need to generate a file to give back to MyAccess that includes the CN. MyAccess is where a request could be made for an end user to get access to Percy. After allowing the request, MyAccess then leaves that request in a pending state. To close it; we need to provide a feed file showing that user received that 'role'.



My record as seen through SCIM.  My CN value is x266698, and not stored in a SCIM accessible way. If I requested access to Percy, then I wantedd to produce a feed file back to MyAccess, I don't have a direct way to show that my x266698 value and 'Percy' are now related, and that pending state can be closed.


IN a perfect world, the CN value would be stored in a new field so we can tie the users back to their bstack_product values and report back to MyAccess what has occured on a regular basis to close up requests.

      {
      "schemas": [
        "urn:ietf:params:scim:schemas:core:2.0:User"
      ],
      "id": 8989176,
      "externalId": "aaronkynaston_8rRxja",
      "userName": "aaron.kynaston@wnco.com",
      "active": true,
      "name": {
        "familyName": "Kynaston",
        "givenName": "Aaron"
      },
      "emails": [
        {
          "primary": true,
          "value": "aaron.kynaston@wnco.com"
        }
      ],
      "bstack_role": "Admin",
      "bstack_team": "Digital Platforms",
      "bstack_product": "Percy"
    },


Summary: Produce feed file showing x266698 has access to Percy. Using curl and jq, we can do 99% of this so far:



































For demonstration purposes - I can run something like this to produce a useful report, using curl and jq:



curl -k --location "https://www.browserstack.com/scim/v2/Users" --header "Authorization: Bearer VeALaAcBnDhohjuz5eto" | jq --raw-output ".Resources[] | \"userName: \(.userName)\t bstack_product: \(.bstack_product), cn: \(.id) \" "






Example:

type browser_stack_users.json | jq --raw-output ".Resources[] | \"userName: \(.userName)\t bstack_product: \(.bstack_product), cn: \(.id) \" "














10/17/2024 3:23:40 PM
UAT
10/17/2024 1:57:36 PM
BrowserStack QA UAT -
Goal: The only goal of this call, is to have you send an email or teams message that I can screenshot that says, "The IDtoBrowserStack driver meets the requiremetns as outlined in the driver documentation here: https://southwest.atlassian.net/wiki/spaces/CYSEC/history/354222183/IDtoBrowserStack, version 40".





There are 11 use cases:
 - During each one, I'll take steps to execute the action, then either you can verify in BrowserStack that you see what you want to see, or I can show in Postman that you received the value you watned.
   - in a perfect world, we'd check both, but I'm ok setting our OCD level to be whatever you need to approve of the driver functionality.

completed!

sign off:
![[{51AC7CB6-6CA1-4D08-9ECD-0116B77F9760}.png]]

10/21/2024 11:47:26 AM
Directory I'm using to do my testing - using awk/sed/grep - can't use jq . . maybe not an option.
myaccess_stg@xlqmya01 < avk-myaccess-curl-work >


SCIM:

curl -u "VeALaAcBnDhohjuz5eto:VeALaAcBnDhohjuz5eto" -X GET https://browserstack.com/user/user_detail"

10/21/2024 4:20:11 PM
Work is on hold for the moment, until Mike can get support/help/permission/appral from Dhivya:

10/21/2024 10:51:20 AM
Mike call
- Manoj JSP route: complicated, and really alpha now . .

 - Confirm output file format correct
 - programatically getting token from AWS
 - Getting JQ installed on myaccess servers
 - paggination problem: for grabbing group entitlements
  - IN order to get all roles - rest collectiont o get all roles
 - if more than 100 roles - myaccess doesn't collect second page
 - pagination with a curl command
 -

 Mike:
   - See if JQ installation on any MyAccess server is an option.
   - Select a server that we can run a cronjob on, ideally outputing a file to a location on the server.


 Aaron
   - Work to see if we can build a non JQ option to format the SCIM response as a MyAccess feed file:
    - Do this



doing things like this: type browser_stack_users.json | grep "familyName|bstack_product|bstack_role" | sed -E "s/(familyName)|(bstack_product)/\1,\2/g"






10/22/2024 1:02:28 PM
Note from guthrie regarding user scope:
We'd get a new user added to Percy when a new UI developer is hired, so probably only a handful of times month. However, initial migration will see existing users (20ish) granted the role in myaccess, and then a large migration of existing dotcom UI developers getting access shortly thereafter, which is about 100


10/22/2024 4:44:12 PM
 - brwoser stack: find users with > 40 charctesr for firstname + lastname + 7 digits ('-x266698)
   - out of 123,460 users, 66 of them so .005 super small; added note to doc; not doing antyhing about this.



10/23/2024 2:16:22 PM
Using jsps to solve limitations with built in rest support in myaccess - this is the example groups collection jsp:
JSP external link:
[https://myaccess2.cis.qa.swacorp.com/aveksa/custom/external_jsp/gitlab-groups-collection.jsp](https://myaccess2.cis.qa.swacorp.com/aveksa/custom/external_jsp/gitlab-groups-collection.jsp "https://myaccess2.cis.qa.swacorp.com/aveksa/custom/external_jsp/gitlab-groups-collection.jsp")



10/23/2024 3:36:22 PM
4 users didn't get apps updated, despinte being associated - API just ignores my product setting - any one with 'App Percy' ignored my setting . . .
![[{E9EF3AA6-7342-450E-A340-80C1FFF6BD41}.png]]


All manually fixed - just had to set Percy one more time manually, leaving Howard alone:
![[{BADA078B-926F-4003-98C4-C282AE7D65C4}.png]]

10/23/2024 3:47:36 PM
Summary for Guthrie - email ing now:

subject: IDtoBrowserStack: Initial migration complete. Summary and notes
Guthrie,
  
Per our chat today, we reviewed the following:
  
 - IDtoBrowserStack was deployed to production.
 - Initial migration was completed.
 - We found the name.familyName (surname) field does not support spaces through the API.
  Workaround: we'll remove spaces before writing to that field.
 - We also discussed there may be potentially other characters to remove that aren't 'valid'; so we'll need to esearch.
 - Also, I found some users had an 'App Percy' already, which is different when I set 'Percy'; and these users required another update to get them set properly.
- ​I wrote up two items that we should probably submit as issues, or find out what I am doing wrong . . We'll have a workaround for the first one; but the second is weird. Neither are a huge deal; but wanted it documented either way.
- ​I'll work on the name.familyName space workaround, and check for other characters.
  
  
  
Notes on support tickets:
  
If desired, we should probably open two issue tickets with support; ideally, we'd see if they'd confirm these as bugs or not. We'll do the workaround anyway though I figured the issues should be reported:
 
1 - The name.familyName lack of support of spaces is odd - example: if you submit this as a put, the event is apparently ignored. Removing the spaces from name.familyName seems to workaround the issue. I'll get this workaround asap.


  https://www.browserstack.com/scim/v2/Users/8216309
  {
      "schemas": [
        "urn:ietf:params:scim:schemas:core:2.0:User"
      ],
      "userName": "First.Last Name@wnco.com",
      "active": true,
      "name": {
        "familyName": "Last Name-e142946",
        "givenName": "Paulo"
      },
      "emails": [
        {
          "primary": true,
          "value": "First.Last Name@wnco.com"
        }
      ],
      "bstack_role": "User",
      "bstack_team": "Digital Platforms",
      "bstack_product": "Percy"
    }
  
  
2 - Some users had 'App Percy' listed in their list of apps, where the name of the app through the API is just 'Percy'. Users that had 'App Percy' I could not correct to just 'Percy', and I had to manually fix these over SCIM, as the driver would not recognize the update.
 

--Aaron
10/23/2024 4:31:26 PM
jsp work:


![[Pasted image 20241023163124.png]]


