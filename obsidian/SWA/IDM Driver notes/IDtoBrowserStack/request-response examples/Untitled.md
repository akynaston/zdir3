After I had already created the user with a different team, "Some randomteam"

I sent again as Digital platform and got the following:

REquest:


{
    "schemas": [
        "urn:ietf:params:scim:schemas:core:2.0:User"
    ],
    "id": 266698,
    "externalId": "AVKTestUser",
    "userName": "AVK.Testuser@wnco.com",
    "active": true,
    "name": {
        "familyName": "AVK",
        "givenName": "TESTUser"
    },
    "emails": [
        {
            "primary": true,
            "value": "avk.testuser@wnco.com"
        }
    ],
    "bstack_role": "User",
    **"bstack_team": "Digital Platforms",**
    "bstack_product": "Percy"
}

Response:

{
    "schemas": [
        "urn:ietf:params:scim:api:messages:2.0:Error"
    ],
    "detail": "AVK.Testuser@wnco.com is already part of a different organization account on BrowserStack. Please reach out to BrowserStack support to get that account deleted before provisioning the user to your current organization account.",
    "status": "422"
}