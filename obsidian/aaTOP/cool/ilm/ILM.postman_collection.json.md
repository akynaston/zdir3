9/10/2024 1:35:34 PM
Collection I got from Jim

```

{
	"info": {
		"_postman_id": "43d690fa-9359-44ce-8e88-777eaf5eb880",
		"name": "ILM",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "52277"
	},
	"item": [
		{
			"name": "Login",
			"item": [
				{
					"name": "Tenant Admin Login",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"sets anticsrfToken to env\", function() {\r",
									"\r",
									"    let jsonData = pm.response.json();\r",
									"\r",
									"    pm.environment.set('anticsrftoken', jsonData.anti_xsrf_token)\r",
									"\r",
									"})"
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"tenant\": \"{{tenantName}}\",\n    \"type\": \"user\",\n    \"password\": \"{{tenantPassword}}\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "https://dev-eks-ilm.ilm.cyberresdev.com/v2/ilm/ds/login",
							"protocol": "https",
							"host": [
								"dev-eks-ilm",
								"ilm",
								"cyberresdev",
								"com"
							],
							"path": [
								"v2",
								"ilm",
								"ds",
								"login"
							]
						}
					},
					"response": []
				},
				{
					"name": "SaaS Admin Login",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"sets anticsrfToken to env\", function() {\r",
									"\r",
									"    let jsonData = pm.response.json();\r",
									"\r",
									"    pm.environment.set('anticsrftoken_saas', jsonData.anti_xsrf_token)\r",
									"\r",
									"})"
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"type\": \"user\",\n    \"client\": \"admin\",\n    \"password\": \"novell\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{base_url}}/login",
							"host": [
								"{{base_url}}"
							],
							"path": [
								"login"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Schema",
			"item": [
				{
					"name": "Get Schemas",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "eyJhbGciOiJkaXIiLCJhdWQiOiJ0cyIsImVuYyI6IkExMjhDQkMtSFMyNTYiLCJpc3MiOiJ0cyIsInRlbiI6ImU3N2I0ZjZjZGQzNjExZWViYzY2MDI0MmFjMTEwMDAzIn0..c1TZY6iiBol8nTfZiM7eAg.Y7XQhR85zOQNipMdZNVLWmroRY6YF402K-Rvcn54ZcKcqDBMGbQpea8Kh-W5c5NrJ3N9G-WsWxQm89Cx57arlIa6m1YAISDSGlT1dMF4C38knWe4TrJNMud7K87pA1KSBK8JOveSmdU6VQMa--neqS2nyGkuQiTMSuMhdSZDxaSDxwvvy3HkjGn_ZjWSmmmUFyaurWGsLUCkC1BQN7arhJqlUrK5wqJHRRYNl95toyOW-XJpPBdRUnfVvpmXqzF9bqPq0pppAX1bNHdCMtrExMQDcrP-GcMlO349ANFkRpYuSmx0ETeyCb0ZtxoivY8oZgnd4x-EvPxcQf_cPN54htMX6uVwdViH8Oo2zaOy1ZtZ-qYoi_-LVHzh79zPpGIpjV8B3w6g-OnJs7XE8rLCnA.fMjy1ZHjRWFRiKjIxgKUgQ",
									"type": "string"
								}
							]
						},
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Schemas",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Schemas"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get Schemas URN - ILM",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Schemas/urn:ietf:params:scim:schemas:core:2.0:User",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Schemas",
								"urn:ietf:params:scim:schemas:core:2.0:User"
							]
						}
					},
					"response": []
				},
				{
					"name": "Create Schema",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\": \"Employee\",\r\n    \"description\": \"Organization Employee\",\r\n    \"attributes\": [\r\n        {\r\n            \"name\": \"name\",\r\n            \"description\": \"Name of the employee\",\r\n            \"type\": \"string\",\r\n            \"multiValued\": false,\r\n            \"required\": true,\r\n            \"caseExact\": false,\r\n            \"mutability\": \"readWrite\",\r\n            \"returned\": \"always\",\r\n            \"uniqueness\": \"none\",\r\n            \"subAttributes\": [\r\n                {\r\n                    \"name\": \"givenname\",\r\n                    \"description\": \"Given Name of the Employee\",\r\n                    \"type\": \"string\",\r\n                    \"multiValued\": false,\r\n                    \"required\": true,\r\n                    \"caseExact\": false,\r\n                    \"mutability\": \"readWrite\",\r\n                    \"returned\": \"always\",\r\n                    \"uniqueness\": \"none\",\r\n                    \"canonicalValues\": []\r\n                }\r\n            ]\r\n        }\r\n    ],\r\n    \"schemas\": [\r\n        \"urn:ietf:params:scim:schemas:core:2.0:Schema\",\r\n        \"urn:ietf:params:scim:schemas:ilm:static:1.0:Schema\"\r\n    ],\r\n    \"urn:ietf:params:scim:schemas:ilm:static:1.0:Schema\": {\r\n        \"description\": \"Employee of the Organization\",\r\n        \"endpoint\": \"Employees\"\r\n    },\r\n    \"id\": \"urn:ietf:params:scim:schemas:ilm:core:custom:Employee\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Schemas",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Schemas"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Driver",
			"item": [
				{
					"name": "Drivers GetAll",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Drivers",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Drivers"
							]
						}
					},
					"response": []
				},
				{
					"name": "Drivers Get",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Drivers/1476",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Drivers",
								"1476"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get Driver Statistics",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/DriverSets/{{driverId}}",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"DriverSets",
								"{{driverId}}"
							]
						}
					},
					"response": []
				},
				{
					"name": "Drivers Patch",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "PATCH",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"schemas\": [\n        \"urn:ietf:params:scim:api:messages:2.0:PatchOp\"\n    ],\n    \"Operations\": [\n        {\n            \"op\": \"add\",\n            \"path\": \"urn:ietf:params:scim:schemas:ilm:core:1.0:Driver:details\",\n            \"value\": [\n                {\n                    \"key\": \"dataSourceConnUniqueId\",\n                    \"type\": \"str\",\n                    \"value\": \"Naga_5dec_ldap\"\n                },\n                {\n                    \"key\": \"port\",\n                    \"type\": \"str\",\n                    \"value\": \"8100\"\n                },\n                {\n                    \"key\": \"hostname\",\n                    \"type\": \"str\",\n                    \"value\": \"10.71.33.130\"\n                },\n                {\n                    \"key\": \"agentId\",\n                    \"type\": \"str\",\n                    \"value\": \"Naga_5dec\"\n                }\n            ]\n        }\n    ]\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Drivers/1476",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Drivers",
								"1476"
							]
						}
					},
					"response": []
				},
				{
					"name": "Drivers Get Query",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Drivers?attributes=urn:ietf:params:scim:schemas:ilm:core:1.0:Driver:id",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Drivers"
							],
							"query": [
								{
									"key": "attributes",
									"value": "urn:ietf:params:scim:schemas:ilm:core:1.0:Driver:id"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "Drivers Delete",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "DELETE",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Drivers/{{driverId}}",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Drivers",
								"{{driverId}}"
							]
						}
					},
					"response": []
				},
				{
					"name": "Drivers Update",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "PATCH",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"schemas\": [\n        \"urn:ietf:params:scim:api:messages:2.0:PatchOp\"\n    ],\n    \"Operations\": [\n        {\n            \"op\": \"replace\",\n            \"value\": {\n                \"urn:ietf:params:scim:schemas:microfocus:idrepo:ILMDriver:container\": \"/v2/ilm/Configurations/7f021dc7-2b11-4c99-b568-4b1777bfd2df\"\n            }\n        }\n    ]\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Drivers/c58f8a71-e3a6-4692-b76a-a8e9d5138ec2",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Drivers",
								"c58f8a71-e3a6-4692-b76a-a8e9d5138ec2"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Driver Operations",
			"item": [
				{
					"name": "ILM-Rest Swagger",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "9cbb1f4a-0cfd-4ba1-9040-e37e179fdb59",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_rest_api_url}}/swagger#/",
							"host": [
								"{{ilm_rest_api_url}}"
							],
							"path": [
								"swagger"
							],
							"hash": "/"
						}
					},
					"response": []
				},
				{
					"name": "Driver State",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_rest_api_url}}/driver/{{driverId}}/state",
							"host": [
								"{{ilm_rest_api_url}}"
							],
							"path": [
								"driver",
								"{{driverId}}",
								"state"
							]
						}
					},
					"response": []
				},
				{
					"name": "Driver Stop",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_rest_api_url}}/driver/{{driverId}}/stop",
							"host": [
								"{{ilm_rest_api_url}}"
							],
							"path": [
								"driver",
								"{{driverId}}",
								"stop"
							]
						}
					},
					"response": []
				},
				{
					"name": "Driver Start",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "http://10.71.33.51:9990/api/ilm/rest/v1/driver/626/start",
							"protocol": "http",
							"host": [
								"10",
								"71",
								"33",
								"51"
							],
							"port": "9990",
							"path": [
								"api",
								"ilm",
								"rest",
								"v1",
								"driver",
								"626",
								"start"
							]
						}
					},
					"response": []
				},
				{
					"name": "Driver Statistics",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "http://10.71.39.100:9990/api/ilm/rest/v1/DriverSetStatistics",
							"protocol": "http",
							"host": [
								"10",
								"71",
								"39",
								"100"
							],
							"port": "9990",
							"path": [
								"api",
								"ilm",
								"rest",
								"v1",
								"DriverSetStatistics"
							]
						}
					},
					"response": []
				},
				{
					"name": "Base URL Core",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "9cbb1f4a-0cfd-4ba1-9040-e37e179fdb59",
								"type": "text"
							},
							{
								"key": "tenant-id",
								"value": "jaydeep",
								"type": "text"
							}
						],
						"url": {
							"raw": "http://10.71.128.168:9888/api/ilm/rest/v1/core",
							"protocol": "http",
							"host": [
								"10",
								"71",
								"128",
								"168"
							],
							"port": "9888",
							"path": [
								"api",
								"ilm",
								"rest",
								"v1",
								"core"
							]
						}
					},
					"response": []
				},
				{
					"name": "Base URL Core Driver-Start",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "9cbb1f4a-0cfd-4ba1-9040-e37e179fdb59",
								"type": "text"
							},
							{
								"key": "tenant-id",
								"value": "jaydeep",
								"type": "text"
							}
						],
						"url": {
							"raw": "https://localhost:8480/api/ilm/rest/v1/driver/{{driverId}}/start",
							"protocol": "https",
							"host": [
								"localhost"
							],
							"port": "8480",
							"path": [
								"api",
								"ilm",
								"rest",
								"v1",
								"driver",
								"{{driverId}}",
								"start"
							]
						}
					},
					"response": []
				},
				{
					"name": "Migrate Into ILM",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							},
							{
								"key": "tenant-id",
								"value": "jaydeep",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n\t\"queries\": [\r\n        {\r\n\t\t\t\"resourceType\": \"user\",\r\n\t\t\t\"attributes\": [\r\n                {\r\n\t\t\t\t\t\"name\": \"givenName\",\r\n\t\t\t\t\t\"pattern\": \"Aditi\"\r\n                }\r\n            ]\r\n        }\r\n    ]\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "https://localhost:8480/api/ilm/rest/v1/driver/{{driverId}}/migrate/into-ilm",
							"protocol": "https",
							"host": [
								"localhost"
							],
							"port": "8480",
							"path": [
								"api",
								"ilm",
								"rest",
								"v1",
								"driver",
								"{{driverId}}",
								"migrate",
								"into-ilm"
							]
						}
					},
					"response": []
				},
				{
					"name": "Migrate From ILM",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							},
							{
								"key": "tenant-id",
								"value": "jaydeep",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"resourceSet\": [\r\n        {\r\n            \"resourceType\": \"User\",\r\n\t\t\t\"resources\": [\r\n                \"cn=drichie,ou=users,o=data\"\r\n            ]\r\n        }\r\n    ]\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_core_rest_api_url}}/Drivers/cn=Azure,cn=driverset1,o=system/migrate/from-ilm",
							"host": [
								"{{ilm_core_rest_api_url}}"
							],
							"path": [
								"Drivers",
								"cn=Azure,cn=driverset1,o=system",
								"migrate",
								"from-ilm"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "User",
			"item": [
				{
					"name": "Users Delete",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "DELETE",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Users/{{userId}}",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Users",
								"{{userId}}"
							]
						}
					},
					"response": []
				},
				{
					"name": "Users GetAll",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"auth": {
							"type": "oauth2",
							"oauth2": [
								{
									"key": "clientSecret",
									"value": "secret-i9ryqySAmREj4HBc5U61tVMV8Oz9WowB",
									"type": "string"
								},
								{
									"key": "client_authentication",
									"value": "body",
									"type": "string"
								},
								{
									"key": "clientId",
									"value": "t5",
									"type": "string"
								},
								{
									"key": "accessTokenUrl",
									"value": "https://ilm.or.cyberresdev.com/osp/a/ILM/auth/oauth2/token",
									"type": "string"
								},
								{
									"key": "grant_type",
									"value": "client_credentials",
									"type": "string"
								},
								{
									"key": "addTokenTo",
									"value": "header",
									"type": "string"
								}
							]
						},
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Users",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Users"
							]
						}
					},
					"response": []
				},
				{
					"name": "Create User",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"schemas\": [\r\n        \"urn:ietf:params:scim:schemas:core:2.0:User\",\r\n        \"urn:ietf:params:scim:schemas:extension:enterprise:2.0:User\",\r\n        \"urn:ietf:params:scim:schemas:ilm:static:1.0:User\",\r\n        \"urn:ietf:params:scim:schemas:ilm:extension:1.0:User\"\r\n    ],\r\n    \"userName\": \"pshanyu\",\r\n    \"title\": \"HR\",\r\n    \"userType\": \"Employee\",\r\n    \"preferredLanguage\": \"en-US\",\r\n    \"active\": true,\r\n    \"password\": \"novell@123\",\r\n    \"emails\": [\r\n        {\r\n            \"value\": \"pshanyu@microfocus.com\",\r\n            \"type\": \"work\",\r\n            \"primary\": true\r\n        }\r\n    ],\r\n    \"name\": {\r\n        \"formatted\": \"pshanyu\",\r\n        \"familyName\": \"mir\",\r\n        \"givenName\": \"pshanyu\",\r\n        \"honorificPrefix\": \"Mr\"\r\n    },\r\n    \"urn:ietf:params:scim:schemas:ilm:static:1.0:User\": {\r\n        \"C\": \"IN\",\r\n        \"nspmDistributionPassword\": \"@Dirxml1\"\r\n    }\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Users",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Users"
							]
						}
					},
					"response": []
				},
				{
					"name": "Users Get",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Users/{{userId}}",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Users",
								"{{userId}}"
							]
						}
					},
					"response": []
				},
				{
					"name": "Search Users",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Users?filter=urn:ietf:params:scim:schemas:core:2.0:User:userName eq \"pnaga\"",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Users"
							],
							"query": [
								{
									"key": "filter",
									"value": "urn:ietf:params:scim:schemas:core:2.0:User:userName eq \"pnaga\""
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "User Patch",
					"request": {
						"method": "PATCH",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"schemas\": [\r\n        \"urn:ietf:params:scim:api:messages:2.0:PatchOp\"\r\n    ],\r\n    \"Operations\": [\r\n        {\r\n            \"op\": \"replace\",\r\n            \"value\": {\r\n                \"urn:ietf:params:scim:schemas:core:2.0:User:emails\": [\r\n                    {\r\n                        \"display\": \"Office Email\",\r\n                        \"primary\": true,\r\n                        \"type\": \"work\",\r\n                        \"value\": \"kamal@ilmfalcon.com\"\r\n                    }\r\n                ]\r\n            }\r\n        }\r\n    ]\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Users/{{userId}}",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Users",
								"{{userId}}"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Group",
			"item": [
				{
					"name": "Groups Delete",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"request": {
						"method": "DELETE",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Groups/{{groupId}}",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Groups",
								"{{groupId}}"
							]
						}
					},
					"response": []
				},
				{
					"name": "Group GetAll",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Groups",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Groups"
							]
						}
					},
					"response": []
				},
				{
					"name": "Group Get",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript",
								"packages": {}
							}
						}
					],
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Groups/{{groupId}}",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Groups",
								"{{groupId}}"
							]
						}
					},
					"response": []
				},
				{
					"name": "Search Users",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Groups?filter=urn:ietf:params:scim:schemas:core:2.0:Group:displayName eq \"ILMGrp\"",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Groups"
							],
							"query": [
								{
									"key": "filter",
									"value": "urn:ietf:params:scim:schemas:core:2.0:Group:displayName eq \"ILMGrp\""
								}
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "JOB",
			"item": [
				{
					"name": "Job Start",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "http://10.71.34.215:9990/api/ilm/rest/v1/job/2470/start",
							"protocol": "http",
							"host": [
								"10",
								"71",
								"34",
								"215"
							],
							"port": "9990",
							"path": [
								"api",
								"ilm",
								"rest",
								"v1",
								"job",
								"2470",
								"start"
							]
						}
					},
					"response": []
				},
				{
					"name": "Job Patch Update",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "PATCH",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"schemas\": [\n        \"urn:ietf:params:scim:api:messages:2.0:PatchOp\"\n    ],\n    \"Operations\": [\n        {\n            \"op\": \"replace\",\n            \"value\": {\n                \"urn:ietf:params:scim:schemas:microfocus:idrepo:ILMDataCenter:bootstrapServer\": [\n                    {\n                        \"key\": \"bootstrap.servers\",\n                        \"value\": \"kafka:9092\"\n                    },\n                    {\n                        \"key\": \"max.request.size\",\n                        \"value\": \"2000000\"\n                    }\n                ]\n            }\n        }\n    ]\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/DataCenters/{{dataCenterId}}",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"DataCenters",
								"{{dataCenterId}}"
							]
						}
					},
					"response": []
				},
				{
					"name": "Job Stop",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "x-csrf-token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "http://10.71.34.48:9990/api/ilm/rest/v1/job/4953/abort",
							"protocol": "http",
							"host": [
								"10",
								"71",
								"34",
								"48"
							],
							"port": "9990",
							"path": [
								"api",
								"ilm",
								"rest",
								"v1",
								"job",
								"4953",
								"abort"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get JOB",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Jobs/{{jobid}}?attributes=urn:ietf:params:scim:schemas:microfocus:idrepo:Job:state",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Jobs",
								"{{jobid}}"
							],
							"query": [
								{
									"key": "attributes",
									"value": "urn:ietf:params:scim:schemas:microfocus:idrepo:Job:state"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "Get JOBS",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Jobs",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Jobs"
							]
						}
					},
					"response": []
				},
				{
					"name": "Create JOB",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"schemas\": [\r\n        \"urn:ietf:params:scim:schemas:microfocus:idrepo:Job\"\r\n    ],\r\n    \"dn\": \"DemoJob\",\r\n    \"container\": \"/v2/ilm/Drivers/702\",\r\n    \"state\": 0,\r\n    \"data\": \"PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPGpvYi1hZ2dyZWdhdGlvbj4KCTxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVJhbmRvbSBQYXNzd29yZCBHZW5lcmF0b3IiIHNjaGVkdWxlPSIwIDEgKiAqIDAiIHNjb3BlLXJlcXVpcmVkPSJ0cnVlIiB0eXBlPSJqYXZhIj4KCQk8ZGVzY3JpcHRpb24+eGxmaWQoam9iLWRlc2NyaXB0aW9uKVRoaXMgam9iIGdlbmVyYXRlcyBhIHJhbmRvbSBwYXNzd29yZCBmb3IgZWFjaCBvYmplY3QgaW4gc2NvcGUsIGFjY29yZGluZyB0byB0aGUgcGFzc3dvcmRwb2xpY3kgcmVmZXJlbmNlZCBieSB0aGUgam9iLiBUaGUgam9iIHdpbGwgc3VibWl0IHRoZSBnZW5lcmF0ZWQgcGFzc3dvcmQgdG8gdGhlIGNvbnRhaW5pbmcgZHJpdmVyLjwvZGVzY3JpcHRpb24+CgkJPGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PgoJCTxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IucGFzc2dlbi5QYXNzR2VuPC9qYXZhLWNsYXNzPgoJCTxjb25maWd1cmF0aW9uLXZhbHVlcz4KCQkJPGRlZmluaXRpb25zPgoJCQkJPGRlZmluaXRpb24gYXR0ci1uYW1lPSJuc3BtUGFzc3dvcmRQb2xpY3lETiIgYXV4LWNsYXNzLW5hbWU9IkRpclhNTC1QYXNzd29yZEdlbmVyYXRpb24iIGRpc3BsYXktbmFtZT0ieGxmaWQocHdkLXBvbGljeSlQYXNzd29yZCBQb2xpY3kgb2JqZWN0IHVzZWQgZm9yIHBhc3N3b3JkIGdlbmVyYXRpb24iIG5hbWU9InB3ZC1wb2xpY3kiIHR5cGU9ImRuLXJlZiI+CgkJCQkJPHRhcmdldC1jbGFzcz5uc3BtUGFzc3dvcmRQb2xpY3k8L3RhcmdldC1jbGFzcz4KCQkJCTwvZGVmaW5pdGlvbj4KCQkJCTxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQocHJvY2Vzcy11bmFzc29jaWF0ZWQpR2VuZXJhdGUgYSBwYXNzd29yZCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPyIgbmFtZT0icHJvY2Vzcy11bmFzc29jaWF0ZWQiIHR5cGU9ImJvb2xlYW4iPgoJCQkJCTx2YWx1ZT5mYWxzZTwvdmFsdWU+CgkJCQk8L2RlZmluaXRpb24+CgkJCTwvZGVmaW5pdGlvbnM+CgkJPC9jb25maWd1cmF0aW9uLXZhbHVlcz4KCTwvam9iLWRlZmluaXRpb24+Cgk8eGxpZmYgdmVyc2lvbj0iMS4wIj4KCQk8ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJQYXNzR2VuLnhtbCIgc291cmNlLWxhbmd1YWdlPSJkZSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCTxoZWFkZXIvPgoJCQk8Ym9keT4KCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQk8c291cmNlPlp1ZmFsbHNwYXNzd29ydGdlbmVyYXRvcjwvc291cmNlPgoJCQkJPC90cmFucy11bml0PgoJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJPHNvdXJjZT5NaXQgZGllc2VtIEF1ZnRyYWcgd2lyZCBnZW3DpMOfIGRlciBQYXNzd29ydHJpY2h0bGluaWUsIGRpZSB2b24gZGllc2VtIEF1ZnRyYWcgcmVmZXJlbnppZXJ0IHdpcmQsIGVpbiB6dWbDpGxsaWdlc1Bhc3N3b3J0IGbDvHIgamVkZXMgT2JqZWt0IGltIEJlcmVpY2ggZ2VuZXJpZXJ0LiBEZXIgQXVmdHJhZyBzZW5kZXQgZGFzIGdlbmVyaWVydGUgUGFzc3dvcnQgYW4gZGVuIFRyZWliZXIuPC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8dHJhbnMtdW5pdCBpZD0icHdkLXBvbGljeSI+CgkJCQkJPHNvdXJjZT5QYXNzd29ydHJpY2h0bGluaWVub2JqZWt0LCBkYXMgenVtIEdlbmVyaWVyZW4gdm9uIFBhc3N3w7ZydGVybiB2ZXJ3ZW5kZXQgd2lyZDwvc291cmNlPgoJCQkJPC90cmFucy11bml0PgoJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQk8c291cmNlPkVpbiBQYXNzd29ydCBmw7xyIE9iamVrdGUgb2huZSBUcmVpYmVyenVvcmRudW5nIGdlbmVyaWVyZW4/PC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCTwvYm9keT4KCQk8L2ZpbGU+Cgk8L3hsaWZmPgoJPHhsaWZmIHZlcnNpb249IjEuMCI+CgkJPGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iUGFzc0dlbi54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZW4iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQk8aGVhZGVyLz4KCQkJPGJvZHk+CgkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJPHNvdXJjZT5SYW5kb20gUGFzc3dvcmQgR2VuZXJhdG9yPC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQk8c291cmNlPlRoaXMgam9iIGdlbmVyYXRlcyBhIHJhbmRvbSBwYXNzd29yZCBmb3IgZWFjaCBvYmplY3QgaW4gc2NvcGUsIGFjY29yZGluZyB0byB0aGUgcGFzc3dvcmQgcG9saWN5IHJlZmVyZW5jZWQgYnkgdGhlIGpvYi4gVGhlIGpvYiB3aWxsIHN1Ym1pdCB0aGUgZ2VuZXJhdGVkIHBhc3N3b3JkIHRvIHRoZSBjb250YWluaW5nIGRyaXZlci48L3NvdXJjZT4KCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTx0cmFucy11bml0IGlkPSJwd2QtcG9saWN5Ij4KCQkJCQk8c291cmNlPlBhc3N3b3JkIFBvbGljeSBvYmplY3QgdXNlZCBmb3IgcGFzc3dvcmQgZ2VuZXJhdGlvbjwvc291cmNlPgoJCQkJPC90cmFucy11bml0PgoJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQk8c291cmNlPkdlbmVyYXRlIGEgcGFzc3dvcmQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJCTwvdHJhbnMtdW5pdD4KCQkJPC9ib2R5PgoJCTwvZmlsZT4KCTwveGxpZmY+Cgk8eGxpZmYgdmVyc2lvbj0iMS4wIj4KCQk8ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJQYXNzR2VuLnhtbCIgc291cmNlLWxhbmd1YWdlPSJmciIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCTxoZWFkZXIvPgoJCQk8Ym9keT4KCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQk8c291cmNlPkfDqW7DqXJhdGV1ciBkZSBtb3RzIHBhc3NlIGFsw6lhdG9pcmVzPC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQk8c291cmNlPkNlIHRyYXZhaWwgZ8OpbsOocmUgdW4gbW90IGRlIHBhc3NlIGFsw6lhdG9pcmUgcG91ciBjaGFxdWUgb2JqZXQgZGUgbCfDqXRlbmR1ZSwgc2Vsb24gbGEgc3RyYXTDqWdpZSByw6lmw6lyZW5jw6llIHBhciBsZSB0cmF2YWlsLiBMZSB0cmF2YWlsIHNvdW1ldHRyYSBsZSBtb3QgZGUgcGFzc2UgZ8OpbsOpcsOpIGF1IHBpbG90ZSBxdWkgbGUgY29udGllbnQuPC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8dHJhbnMtdW5pdCBpZD0icHdkLXBvbGljeSI+CgkJCQkJPHNvdXJjZT5PYmpldCBkZSBzdHJhdMOpZ2llIGRlIG1vdCBkZSBwYXNzZSB1dGlsaXPDqSBwb3VyIGxhIGfDqW7DqXJhdGlvbiBkZXMgbW90cyBkZSBwYXNzZTwvc291cmNlPgoJCQkJPC90cmFucy11bml0PgoJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQk8c291cmNlPlZvdWxlei12b3VzIGfDqW7DqXJlciB1biBtb3QgZGUgcGFzc2UgcG91ciBsZXMgb2JqZXRzIHNhbnMgYXNzb2NpYXRpb24gZGUgcGlsb3RlID88L3NvdXJjZT4KCQkJCTwvdHJhbnMtdW5pdD4KCQkJPC9ib2R5PgoJCTwvZmlsZT4KCTwveGxpZmY+Cgk8eGxpZmYgdmVyc2lvbj0iMS4wIj4KCQk8ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJQYXNzR2VuLnhtbCIgc291cmNlLWxhbmd1YWdlPSJqYSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCTxoZWFkZXIvPgoJCQk8Ym9keT4KCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQk8c291cmNlPuODqeODs+ODgOODoOODkeOCueODr+ODvOODieOCuOOCp+ODjeODrOODvOOCvzwvc291cmNlPgoJCQkJPC90cmFucy11bml0PgoJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJPHNvdXJjZT7jgZPjga7jgrjjg6fjg5bjga/jgIHjgrjjg6fjg5bjgZTjgajjgavlj4LnhafjgZXjgozjgovjg5Hjgrnjg6/jg7zjg4njg53jg6rjgrfjg7zjgavmupbjgZjjgabjgIHjgrnjgrPjg7zjg5flhoXjga7lkITjgqrjg5bjgrjjgqfjgq/jg4jjgavjg6njg7Pjg4Djg6Djg5Hjgrnjg6/jg7zjg4njgpLnlJ/miJDjgZfjgb7jgZnjgILjgZPjga7jgrjjg6fjg5bjga/jgIHjgZPjgozjgpLlkKvjgoDjg4njg6njgqTjg5DjgavjgIHnlJ/miJDjgZXjgozjgZ/jg5Hjgrnjg6/jg7zjg4njgpLpgIHkv6HjgZfjgb7jgZnjgII8L3NvdXJjZT4KCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTx0cmFucy11bml0IGlkPSJwd2QtcG9saWN5Ij4KCQkJCQk8c291cmNlPuODkeOCueODr+ODvOODieOBrueUn+aIkOOBq+S9v+eUqOOBleOCjOOCi+ODkeOCueODr+ODvOODieODneODquOCt+ODvOOBruOCquODluOCuOOCp+OCr+ODiDwvc291cmNlPgoJCQkJPC90cmFucy11bml0PgoJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQk8c291cmNlPuODieODqeOCpOODkOOBrumWoumAo+S7mOOBkeOBjOOBquOBhOOCquODluOCuOOCp+OCr+ODiOOBq+ODkeOCueODr+ODvOODieOCkueUn+aIkOOBl+OBvuOBmeOBi+OAgjwvc291cmNlPgoJCQkJPC90cmFucy11bml0PgoJCQk8L2JvZHk+CgkJPC9maWxlPgoJPC94bGlmZj4KCTx4bGlmZiB2ZXJzaW9uPSIxLjAiPgoJCTxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlBhc3NHZW4ueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9InpoX0NOIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJPGhlYWRlci8+CgkJCTxib2R5PgoJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCTxzb3VyY2U+6ZqP5py65Y+j5Luk55Sf5oiQ5ZmoPC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQk8c291cmNlPuatpOS9nOS4muagueaNruWPgueFp+eahOWPo+S7pOetlueVpeS4uuiMg+WbtOWGheeahOavj+S4quWvueixoeeUn+aIkOmaj+acuuWPo+S7pOOAguS9nOS4muWwhuaKiueUn+aIkOeahOWPo+S7pOS6pOWIsOWMheWQq+mpseWKqOeoi+W6j+OAgjwvc291cmNlPgoJCQkJPC90cmFucy11bml0PgoJCQkJPHRyYW5zLXVuaXQgaWQ9InB3ZC1wb2xpY3kiPgoJCQkJCTxzb3VyY2U+55So5LqO55Sf5oiQ5Y+j5Luk55qE5Y+j5Luk562W55Wl5a+56LGhPC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCTxzb3VyY2U+6KaB5Li65LiN5bim6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh55Sf5oiQ5Y+j5Luk5ZCX77yfPC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCTwvYm9keT4KCQk8L2ZpbGU+Cgk8L3hsaWZmPgoJPHhsaWZmIHZlcnNpb249IjEuMCI+CgkJPGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iUGFzc0dlbi54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfVFciIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQk8aGVhZGVyLz4KCQkJPGJvZHk+CgkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJPHNvdXJjZT7pmqjmqZ/lr4bnorznlKLnlJ/lmag8L3NvdXJjZT4KCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCTxzb3VyY2U+5qC55pOa5bel5L2c5Y+D6ICD55qE5a+G56K86KaP5YmH77yM5q2k5bel5L2c5pyD54K65q+P5YCL54mp5Lu255Si55Sf5p+Q5YCL56+E5ZyN55qE6Zqo5qmf5a+G56K844CC5bel5L2c5pyD5bCH5bey55Si55Sf55qE5a+G56K85o+Q5Lqk5Yiw5YyF5ZCr55qE6amF5YuV56iL5byP44CCPC9zb3VyY2U+CgkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8dHJhbnMtdW5pdCBpZD0icHdkLXBvbGljeSI+CgkJCQkJPHNvdXJjZT7nlKjmlrznlKLnlJ/lr4bnorznmoTlr4bnorzopo/liYc8L3NvdXJjZT4KCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJPHNvdXJjZT7nlKLnlJ/nianku7blr4bnorzvvIzkvYbkuI3lu7rnq4vpqYXli5XnqIvlvI/pl5zoga/ll47vvJ88L3NvdXJjZT4KCQkJCTwvdHJhbnMtdW5pdD4KCQkJPC9ib2R5PgoJCTwvZmlsZT4KCTwveGxpZmY+Cjwvam9iLWFnZ3JlZ2F0aW9uPgo=\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Jobs",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Jobs"
							]
						}
					},
					"response": []
				},
				{
					"name": "Job Update",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "PATCH",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"schemas\": [\n        \"urn:ietf:params:scim:api:messages:2.0:PatchOp\"\n    ],\n    \"Operations\": [\n        {\n            \"op\": \"replace\",\n            \"value\": {\n                \"urn:ietf:params:scim:schemas:microfocus:idrepo:Job:scope\": \"cn=Anil,ou=admin,o=data\"\n            }\n        }\n    ]\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Jobs/2486",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Jobs",
								"2486"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "ILM Rule",
			"item": [
				{
					"name": "Get ILM Rule",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Rules",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Rules"
							]
						}
					},
					"response": []
				},
				{
					"name": "Create ILM Rule",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n  \"dn\": \"cn=MFAZUREDFCG-sub-etp,cn=Subscriber,cn=Azure AD Driver-516,cn=driverset1,o=system\",\r\n  \"name\": {\r\n    \"displayName\": \"MFAZUREDFCG-sub-etp\",\r\n    \"locale\": \"en_US\"\r\n  },\r\n  \"cn\": \"MFAZUREDFCG-sub-etp\",\r\n  \"data\": \"PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPHBvbGljeT4KCQkJCQkJPHJ1bGU+CgkJCQkJCQk8ZGVzY3JpcHRpb24+dmV0byBtb3ZlIG9wZXJhdGlvbnM8L2Rlc2NyaXB0aW9uPgoJCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJPGlmLW9wZXJhdGlvbiBtb2RlPSJub2Nhc2UiIG9wPSJlcXVhbCI+bW92ZTwvaWYtb3BlcmF0aW9uPgoJCQkJCQkJCTwvYW5kPgoJCQkJCQkJPC9jb25kaXRpb25zPgoJCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQkJPGRvLXZldG8vPgoJCQkJCQkJPC9hY3Rpb25zPgoJCQkJCQk8L3J1bGU+CgkJCQkJCTxydWxlPgoJCQkJCQkJPGRlc2NyaXB0aW9uPkhhbmRsZSByZW1vdmUgYXNzb2NpYXRpb248L2Rlc2NyaXB0aW9uPgoJCQkJCQkJPGNvbW1lbnQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+SWYgZXZlbnQgaXMgbW9kaWZ5IERpclhNTC1Bc3NvY2lhdGlvbiBhbmQgcmVtb3ZlIGl0LCByZW1vdmUgZnJvbSBBenVyZSBBRCBkcml2ZXIgYXMgd2VsbDwvY29tbWVudD4KCQkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5Vc2VyPC9pZi1jbGFzcy1uYW1lPgoJCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5tb2RpZnk8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQkJPGlmLW9wLWF0dHIgbmFtZT0iRGlyWE1MLUFzc29jaWF0aW9ucyIgb3A9ImNoYW5naW5nIi8+CgkJCQkJCQkJCTxpZi14cGF0aCBvcD0idHJ1ZSI+Li4vbW9kaWZ5L21vZGlmeS1hdHRyL3JlbW92ZS12YWx1ZS92YWx1ZS9jb21wb25lbnRbQG5hbWU9J25hbWVTcGFjZSddL3RleHQoKT0xPC9pZi14cGF0aD4KCQkJCQkJCQk8L2FuZD4KCQkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJCTxkby1pZj4KCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJPGFuZD4KCQkJCQkJCQkJCQk8aWYtZ2xvYmFsLXZhcmlhYmxlIG1vZGU9Im5vY2FzZSIgbmFtZT0iZHJ2LmNvZXgubW9kZSIgb3A9ImVxdWFsIj50cnVlPC9pZi1nbG9iYWwtdmFyaWFibGU+CgkJCQkJCQkJCQk8L2FuZD4KCQkJCQkJCQkJPC9hcmctY29uZGl0aW9ucz4KCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJhZERyaXZlckROIiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249Ii4uL21vZGlmeS9tb2RpZnktYXR0ci9yZW1vdmUtdmFsdWUvdmFsdWUvY29tcG9uZW50W0BuYW1lPSd2b2x1bWUnXS90ZXh0KCkiLz4KCQkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCTxkby1mb3ItZWFjaD4KCQkJCQkJCQkJCQk8YXJnLW5vZGUtc2V0PgoJCQkJCQkJCQkJCQk8dG9rZW4tZ2xvYmFsLXZhcmlhYmxlIG5hbWU9ImRydi5zeW5jLmlkZW50aXR5Ii8+CgkJCQkJCQkJCQkJPC9hcmctbm9kZS1zZXQ+CgkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQk8ZG8tdHJhY2UtbWVzc2FnZT4KCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSckY3VycmVudC1ub2RlL2RlZmluaXRpb25bQG5hbWU9ImRydi1hZC1kcml2ZXItZG4iXS92YWx1ZS90ZXh0KCknLz4KCQkJCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCQkJPC9kby10cmFjZS1tZXNzYWdlPgoJCQkJCQkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9ImN1cnJBRERyaXZlckROIiBzY29wZT0icG9saWN5Ij4KCQkJCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPlw8L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJPHRva2VuLWdsb2JhbC12YXJpYWJsZSBuYW1lPSJkaXJ4bWwuYXV0by50cmVlbmFtZSIvPgoJCQkJCQkJCQkJCQkJCTx0b2tlbi10ZXh0IHhtbDpzcGFjZT0icHJlc2VydmUiPlw8L3Rva2VuLXRleHQ+CgkJCQkJCQkJCQkJCQkJPHRva2VuLXhwYXRoIGV4cHJlc3Npb249JyRjdXJyZW50LW5vZGUvZGVmaW5pdGlvbltAbmFtZT0iZHJ2LWFkLWRyaXZlci1kbiJdL3ZhbHVlL3RleHQoKScvPgoJCQkJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCQkJCQkJPGRvLWlmPgoJCQkJCQkJCQkJCQkJPGFyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJCTxhbmQ+CgkJCQkJCQkJCQkJCQkJCTxpZi1sb2NhbC12YXJpYWJsZSBtb2RlPSJub2Nhc2UiIG5hbWU9ImN1cnJBRERyaXZlckROIiBvcD0iZXF1YWwiPiRhZERyaXZlckROJDwvaWYtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQkJCQkJCQkJPC9hbmQ+CgkJCQkJCQkJCQkJCQk8L2FyZy1jb25kaXRpb25zPgoJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJCTxkby1yZW1vdmUtYXNzb2NpYXRpb24gZGlyZWN0PSJ0cnVlIj4KCQkJCQkJCQkJCQkJCQkJPGFyZy1hc3NvY2lhdGlvbj4KCQkJCQkJCQkJCQkJCQkJCTx0b2tlbi1hc3NvY2lhdGlvbi8+CgkJCQkJCQkJCQkJCQkJCTwvYXJnLWFzc29jaWF0aW9uPgoJCQkJCQkJCQkJCQkJCTwvZG8tcmVtb3ZlLWFzc29jaWF0aW9uPgoJCQkJCQkJCQkJCQkJCTxkby1icmVhay8+CgkJCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJCQkJPGFyZy1hY3Rpb25zLz4KCQkJCQkJCQkJCQkJPC9kby1pZj4KCQkJCQkJCQkJCQk8L2FyZy1hY3Rpb25zPgoJCQkJCQkJCQkJPC9kby1mb3ItZWFjaD4KCQkJCQkJCQkJPC9hcmctYWN0aW9ucz4KCQkJCQkJCQkJPGFyZy1hY3Rpb25zLz4KCQkJCQkJCQk8L2RvLWlmPgoJCQkJCQkJCTxkby12ZXRvLz4KCQkJCQkJCTwvYWN0aW9ucz4KCQkJCQkJPC9ydWxlPgoJCQkJCQk8cnVsZT4KCQkJCQkJCTxkZXNjcmlwdGlvbj5yZW1vdmUgQ04gYXR0cmlidXRlIGZyb20gbW9kaWZ5IGV2ZW50czwvZGVzY3JpcHRpb24+CgkJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCQk8YW5kPgoJCQkJCQkJCQk8aWYtb3BlcmF0aW9uIG1vZGU9Im5vY2FzZSIgb3A9ImVxdWFsIj5tb2RpZnk8L2lmLW9wZXJhdGlvbj4KCQkJCQkJCQkJPGlmLW9wLWF0dHIgbmFtZT0iQ04iIG9wPSJhdmFpbGFibGUiLz4KCQkJCQkJCQk8L2FuZD4KCQkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJCTxkby1zdHJpcC1vcC1hdHRyIG5hbWU9IkNOIi8+CgkJCQkJCQk8L2FjdGlvbnM+CgkJCQkJCTwvcnVsZT4KCQkJCQk8L3BvbGljeT4=\",\r\n  \"type\": \"Input\",\r\n  \"container\": {\r\n    \"$ref\": \"/v2/ilm/Drivers/699\"\r\n  },\r\n  \"schemas\": [\r\n    \"urn:ietf:params:scim:schemas:microfocus:idrepo:ILMRule\"\r\n  ]\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{ilm_scim_api_url}}/Rules",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Rules"
							]
						}
					},
					"response": []
				},
				{
					"name": "Delete ILM Rule",
					"request": {
						"method": "DELETE",
						"header": [
							{
								"key": "X-CSRF-Token",
								"value": "{{anticsrftoken}}",
								"type": "text"
							}
						],
						"url": {
							"raw": "{{ilm_scim_api_url}}/Rules/599",
							"host": [
								"{{ilm_scim_api_url}}"
							],
							"path": [
								"Rules",
								"599"
							]
						}
					},
					"response": []
				}
			]
		}
	]
}
```


```
{
	"id": "ae6b50fe-6464-4b81-be2a-76937a120343",
	"name": "ILM-Integrated - api.dev-eks-ilm.ilm.cyberresdev.com",
	"values": [
		{
			"key": "base_url",
			"value": "https://api.dev-eks-ilm.ilm.cyberresdev.com/",
			"type": "default",
			"enabled": true
		},
		{
			"key": "ilm_scim_api_url",
			"value": "https://api.dev-eks-ilm.ilm.cyberresdev.com/v2/ilm/ds",
			"type": "default",
			"enabled": true
		},
		{
			"key": "ilm_rest_api_url",
			"value": "https://api.dev-eks-ilm.ilm.cyberresdev.com/api/ilm/rest/v1",
			"type": "default",
			"enabled": true
		},
		{
			"key": "ilm_core_rest_api_url",
			"value": "http://172.24.184.130:5000/api/ilm/rest/v1/core/v2/ilm",
			"type": "default",
			"enabled": true
		},
		{
			"key": "anticsrftoken",
			"value": "7de661b9-d36b-474e-8a46-3d2cd7682866",
			"type": "default",
			"enabled": true
		},
		{
			"key": "anticsrftoken_saas",
			"value": "20d4bef8-e781-4c03-9cee-c0be8ee41522",
			"type": "default",
			"enabled": true
		},
		{
			"key": "configurationId",
			"value": "1109",
			"type": "default",
			"enabled": true
		},
		{
			"key": "dataCenterId",
			"value": "618",
			"type": "any",
			"enabled": true
		},
		{
			"key": "remoteLoaderId",
			"value": "589",
			"type": "default",
			"enabled": true
		},
		{
			"key": "driverId",
			"value": "1476",
			"enabled": true
		},
		{
			"key": "tenantId",
			"value": "2c7dd647-bc46-4824-b456-64b5288c49e0",
			"enabled": true
		},
		{
			"key": "tenantName",
			"value": "ilmphoenix",
			"type": "default",
			"enabled": true
		},
		{
			"key": "tenantPassword",
			"value": "jZWAxQnq42l2",
			"type": "default",
			"enabled": true
		},
		{
			"key": "tenantDBUrl",
			"value": "api.dev-eks-ilm.ilm.cyberresdev.com",
			"type": "default",
			"enabled": true
		},
		{
			"key": "tenantDBUser",
			"value": "neo4j",
			"type": "default",
			"enabled": true
		},
		{
			"key": "tenantDBPassword",
			"value": "novell",
			"type": "default",
			"enabled": true
		},
		{
			"key": "userId",
			"value": "7530",
			"type": "any",
			"enabled": true
		},
		{
			"key": "jobid",
			"value": "2486",
			"type": "default",
			"enabled": true
		},
		{
			"key": "groupId",
			"value": "1902",
			"type": "default",
			"enabled": true
		}
	],
	"_postman_variable_scope": "environment",
	"_postman_exported_at": "2024-09-10T20:44:56.428Z",
	"_postman_exported_using": "Postman/11.11.1"
}
```