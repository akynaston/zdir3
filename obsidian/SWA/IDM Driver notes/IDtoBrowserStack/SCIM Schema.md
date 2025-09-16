{
    "id": "urn:ietf:params:scim:schemas:core:2.0:User",
    "name": "User",
    "description": "User Schema",
    "attributes": [
        {
            "name": "userName",
            "type": "string",
            "multiValued": false,
            "required": true,
            "caseExact": false,
            "mutability": "readWrite",
            "returned": "default",
            "uniqueness": "server",
            "description": "Unique identifier for the User, typically used by the user to directly authenticate to the service provider. Each User MUST include a non-empty userName value. This identifier MUST be unique across the service provider's entire set of Users."
        },
        {
            "name": "name",
            "type": "complex",
            "multiValued": false,
            "required": false,
            "mutability": "readWrite",
            "returned": "default",
            "uniqueness": "none",
            "description": "The components of the user's real name. Providers MAY return just the full name as a single string in the formatted sub-attribute, or they MAY return just the individual component attributes using the other sub-attributes, or they MAY return both.  If both variants are returned, they SHOULD be describing the same name, with the formatted name indicating how the component attributes should be combined.",
            "subAttributes": [
                {
                    "name": "familyName",
                    "type": "string",
                    "multiValued": false,
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none",
                    "description": "The family name of the User, or last name in most Western languages (e.g., 'Jensen' given the full name 'Ms. Barbara J Jensen, III')."
                },
                {
                    "name": "givenName",
                    "type": "string",
                    "multiValued": false,
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none",
                    "description": "The given name of the User, or first name in most Western languages (e.g., 'Barbara' given the full name 'Ms. Barbara J Jensen, III')."
                }
            ]
        },
        {
            "name": "active",
            "type": "boolean",
            "multiValued": false,
            "required": true,
            "mutability": "readWrite",
            "returned": "default",
            "uniqueness": "none",
            "description": "A Boolean value indicating the User's status."
        },
        {
            "name": "bstack_team",
            "type": "string",
            "multiValued": false,
            "required": false,
            "mutability": "readWrite",
            "returned": "default",
            "uniqueness": "none",
            "description": "A String value indicating the User's Team in BrowserStack"
        },
        {
            "name": "bstack_role",
            "type": "string",
            "multiValued": false,
            "required": false,
            "mutability": "readWrite",
            "returned": "default",
            "uniqueness": "none",
            "description": "A String value indicating the User's Role in BrowserStack"
        },
        {
            "name": "bstack_product",
            "type": "string",
            "multiValued": true,
            "required": false,
            "mutability": "readWrite",
            "returned": "default",
            "uniqueness": "none",
            "description": "A String value indicating the User's Product accesses in BrowserStack"
        }
    ],
    "meta": {
        "resourceType": "Schema",
        "location": "https://www.browserstack.com/scim/v2/Schemas/urn:ietf:params:scim:schemas:core:2.0:User"
    }
}