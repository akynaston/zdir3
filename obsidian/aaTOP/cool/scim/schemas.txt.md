
https://miro.com/api/v1/scim/Schemas

example schema;

{
    "schemas": [
        "urn:ietf:params:scim:api:messages:2.0:ListResponse"
    ],
    "meta": {
        "resourceType": "Schema",
        "created": "2023-08-22T22:29:47.703Z",
        "lastModified": "2023-08-22T22:29:47.703Z",
        "location": "https://miro.com/api/v1/scim/Schemas",
        "version": ""
    },
    "totalResults": 3,
    "Resources": [
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:Schema"
            ],
            "id": "urn:ietf:params:scim:schemas:core:2.0:User",
            "name": "User",
            "description": "User Account",
            "attributes": [
                {
                    "name": "id",
                    "type": "string",
                    "multiValued": false,
                    "description": "Unique identifier of the User.",
                    "required": false,
                    "caseExact": true,
                    "mutability": "readOnly",
                    "returned": "always",
                    "uniqueness": "global"
                },
                {
                    "name": "userName",
                    "type": "string",
                    "multiValued": false,
                    "description": "Unique identifier for the User, typically used by the user to directly authenticate to the service provider. Each User MUST include a non-empty userName value. This identifier MUST be unique across the service provider's entire set of Users.",
                    "required": true,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "server"
                },
                {
                    "name": "name",
                    "type": "complex",
                    "subAttributes": [
                        {
                            "name": "familyName",
                            "type": "string",
                            "multiValued": false,
                            "description": "The family name of the User, or last name in most Western languages (e.g., 'Jensen' given the full name 'Ms. Barbara J Jensen, III').",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "givenName",
                            "type": "string",
                            "multiValued": false,
                            "description": "The given name of the User, or first name in most Western languages (e.g., 'Barbara' given the full name 'Ms. Barbara J Jensen, III').",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        }
                    ],
                    "multiValued": false,
                    "description": "The components of the user's real name. Providers MAY return just the full name as a single string in the formatted sub-attribute, or they MAY return just the individual component attributes using the other sub-attributes, or they MAY return both.  If both variants are returned, they SHOULD be describing the same name, with the formatted name indicating how the component attributes should be combined.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "displayName",
                    "type": "string",
                    "multiValued": false,
                    "description": "The name of the User, suitable for display to end-users.  The name SHOULD be the full name of the User being described, if known.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "userType",
                    "type": "string",
                    "multiValued": false,
                    "description": "Used to identify the relationship between the organization and the user. Typical values used might be 'Contractor', 'Employee', 'Intern', 'Temp', 'External', and 'Unknown', but any value may be used.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "active",
                    "type": "boolean",
                    "multiValued": false,
                    "description": "A Boolean value indicating the User's administrative status.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default"
                },
                {
                    "name": "emails",
                    "type": "complex",
                    "subAttributes": [
                        {
                            "name": "value",
                            "type": "string",
                            "multiValued": false,
                            "description": "Email addresses for the user. The value SHOULD be canonicalized by the service provider, e.g., 'bjensen@example.com' instead of 'bjensen@EXAMPLE.COM'. Canonical type values of 'work', 'home', and 'other'.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "display",
                            "type": "string",
                            "multiValued": false,
                            "description": "A human-readable name, primarily used for display purposes.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "primary",
                            "type": "boolean",
                            "multiValued": false,
                            "description": "A Boolean value indicating the 'primary' or preferred attribute value for this attribute, e.g., the preferred mailing address or primary email address.  The primary attribute value 'true' MUST appear no more than once.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default"
                        }
                    ],
                    "multiValued": true,
                    "description": "Email addresses for the user. The value SHOULD be canonicalized by the service provider, e.g., 'bjensen@example.com' instead of 'bjensen@EXAMPLE.COM'. Canonical type values of 'work', 'home', and 'other'.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "photos",
                    "type": "complex",
                    "subAttributes": [
                        {
                            "name": "value",
                            "type": "reference",
                            "multiValued": false,
                            "description": "URL of a photo of the User.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none",
                            "referenceTypes": [
                                "external"
                            ]
                        },
                        {
                            "name": "type",
                            "type": "string",
                            "multiValued": false,
                            "description": "A label indicating the attribute's function. Only 'photo' is supported at the moment.",
                            "required": false,
                            "canonicalValues": [
                                "photo"
                            ],
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        }
                    ],
                    "multiValued": true,
                    "description": "URLs of photos of the User.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default"
                },
                {
                    "name": "roles",
                    "type": "complex",
                    "subAttributes": [
                        {
                            "name": "value",
                            "type": "string",
                            "multiValued": false,
                            "description": "The value of a role.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "display",
                            "type": "string",
                            "multiValued": false,
                            "description": "A human-readable name, primarily used for display purposes.  READ-ONLY.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "type",
                            "type": "string",
                            "multiValued": false,
                            "description": "A label indicating the attribute's function.",
                            "required": false,
                            "canonicalValues": [
                                "organization_user_role"
                            ],
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "primary",
                            "type": "boolean",
                            "multiValued": false,
                            "description": "A Boolean value indicating the 'primary' or preferred attribute value for this attribute.  The primary attribute value 'true' MUST appear no more than once.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default"
                        }
                    ],
                    "multiValued": true,
                    "description": "A list of roles for the User that represent who the User is in organization.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default"
                },
                {
                    "name": "groups",
                    "type": "complex",
                    "subAttributes": [
                        {
                            "name": "value",
                            "type": "string",
                            "multiValued": false,
                            "description": "The identifier of the User's group.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readOnly",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "display",
                            "type": "string",
                            "multiValued": false,
                            "description": "A human-readable name, primarily used for display purposes.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readOnly",
                            "returned": "default",
                            "uniqueness": "none"
                        }
                    ],
                    "multiValued": true,
                    "description": "A list of groups to which the user belongs, either through direct membership, through nested groups, or dynamically calculated.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readOnly",
                    "returned": "default"
                }
            ],
            "meta": {
                "resourceType": "Schema",
                "created": "2023-08-22T22:29:47.700Z",
                "lastModified": "2023-08-22T22:29:47.700Z",
                "location": "https://miro.com/api/v1/scim/Schemas/urn:ietf:params:scim:schemas:core:2.0:User",
                "version": ""
            }
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:Schema"
            ],
            "id": "urn:ietf:params:scim:schemas:core:2.0:Group",
            "name": "Group",
            "description": "Group",
            "attributes": [
                {
                    "name": "id",
                    "type": "string",
                    "multiValued": false,
                    "description": "Unique identifier of the Group.",
                    "required": false,
                    "caseExact": true,
                    "mutability": "readOnly",
                    "returned": "always",
                    "uniqueness": "global"
                },
                {
                    "name": "displayName",
                    "type": "string",
                    "multiValued": false,
                    "description": "A human-readable name for the Group.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "members",
                    "type": "complex",
                    "subAttributes": [
                        {
                            "name": "value",
                            "type": "string",
                            "multiValued": false,
                            "description": "Identifier of the member of this Group.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "immutable",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "type",
                            "type": "string",
                            "multiValued": false,
                            "description": "A label indicating the type of resource, e.g., 'User' or 'Group'.",
                            "required": false,
                            "canonicalValues": [
                                "User",
                                "Group"
                            ],
                            "caseExact": false,
                            "mutability": "immutable",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "display",
                            "type": "string",
                            "multiValued": false,
                            "description": "A human-readable name for the member of this Group.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "immutable",
                            "returned": "default",
                            "uniqueness": "none"
                        }
                    ],
                    "multiValued": true,
                    "description": "A list of members of the Group.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default"
                }
            ],
            "meta": {
                "resourceType": "Schema",
                "created": "2023-08-22T22:29:47.702Z",
                "lastModified": "2023-08-22T22:29:47.702Z",
                "location": "https://miro.com/api/v1/scim/Schemas/urn:ietf:params:scim:schemas:core:2.0:Group",
                "version": ""
            }
        },
        {
            "schemas": [
                "urn:ietf:params:scim:schemas:core:2.0:Schema"
            ],
            "id": "urn:ietf:params:scim:schemas:extension:enterprise:2.0:User",
            "name": "EnterpriseUser",
            "description": "Enterprise User",
            "attributes": [
                {
                    "name": "employeeNumber",
                    "type": "string",
                    "multiValued": false,
                    "description": "Numeric or alphanumeric identifier assigned to a person, typically based on order of hire or association with an organization.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "costCenter",
                    "type": "string",
                    "multiValued": false,
                    "description": "Identifies the name of a cost center.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "organization",
                    "type": "string",
                    "multiValued": false,
                    "description": "Identifies the name of an organization.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "division",
                    "type": "string",
                    "multiValued": false,
                    "description": "Identifies the name of a division.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "department",
                    "type": "string",
                    "multiValued": false,
                    "description": "Identifies the name of a department.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default",
                    "uniqueness": "none"
                },
                {
                    "name": "manager",
                    "type": "complex",
                    "subAttributes": [
                        {
                            "name": "value",
                            "type": "string",
                            "multiValued": false,
                            "description": "The id of the SCIM resource representing the User's manager.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readWrite",
                            "returned": "default",
                            "uniqueness": "none"
                        },
                        {
                            "name": "displayName",
                            "type": "string",
                            "multiValued": false,
                            "description": "The displayName of the User's manager.",
                            "required": false,
                            "caseExact": false,
                            "mutability": "readOnly",
                            "returned": "default",
                            "uniqueness": "none"
                        }
                    ],
                    "multiValued": false,
                    "description": "The User's manager.  A complex type that optionally allows service providers to represent organizational hierarchy by referencing the 'id' attribute of another User.",
                    "required": false,
                    "caseExact": false,
                    "mutability": "readWrite",
                    "returned": "default"
                }
            ],
            "meta": {
                "resourceType": "Schema",
                "created": "2023-08-22T22:29:47.702Z",
                "lastModified": "2023-08-22T22:29:47.702Z",
                "location": "https://miro.com/api/v1/scim/Schemas/urn:ietf:params:scim:schemas:extension:enterprise:2.0:User",
                "version": ""
            }
        }
    ]
}