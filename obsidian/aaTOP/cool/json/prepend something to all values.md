10/30/2024 11:09:49 AM
Got this from chat gpt:

// Prepend 'Percy-' to every bstack_product field
const data = {
    "schemas": [
        "urn:ietf:params:scim:api:messages:2.0:ListResponse"
    ],
    "totalResults": 22,
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
                "familyName": "Martin-e152852",
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
                "familyName": "Shukla-e173729",
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
        }        
    ]
};

// Prepend 'Percy-' to every bstack_product field
data.Resources.forEach(resource => {
    if (resource.bstack_product) {
        resource.bstack_product = 'Percy-' + resource.bstack_product;
    }
});

console.log(JSON.stringify(data, null, 2));
