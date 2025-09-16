{
	"info": {
		"_postman_id": "bdff823e-7394-48b6-96f0-4359996ee6f4",
		"name": "Avaya AEC",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "27885065"
	},
	"item": [
		{
			"name": "User_ProvisionUser",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "Qwgd63HO6piBIkGrMowIH_lu76X6fDP8nnjLP2lKT0W1P39tmq_tG2uDeQ1Znf8ttfQzsgvVRGblC_lsC0sML3AeQgnzy1Z7zBcmh6tpKEG7Kj91blXbjgfkzN6nrXEmkp7sDo4ktfC5XYzJpxu4WEzcLvw8Z-l5734bRfZfn9VY7FBuPYERz-2MPyqIWDwqOEkqTM6IpNL88UCF2GW9dl64NSzS7x2-DMqDSYL1N1NJwuDrfkovSuEXw5bsknwM",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"SPS_13062022_ProvUser_132_8888\",\r\n    \"FirstName\":\"John8888\",\r\n    \"LastName\": \"Smith8888\",        \r\n    \"UserID\":\"JSmith8888\",\r\n    \"EmailAddress\":\"JSmith8888@avayacloud.com\",\r\n    \"ProvisioningGroup\":\"Dallas TX - OTCS\",\r\n    \"BundleName\":\"CC Voice\",\r\n    \"ReportUserGroup\":\"Public\",\r\n    \"AddMailbox\":\"false\",\r\n    \"AddSupervisor\":\"false\",\r\n    \"StationTemplate\":\"\",\r\n    \"AgentTemplate\":\"\",\r\n    \"MailboxTemplate\":\"\",\r\n    \"CMSSupervisorTemplate\":\"\",\r\n    \"StationExtension\":\"\",\r\n    \"AgentLoginID\":\"\",\r\n    \"SecondaryUserID\":\"Test U'ser123\",\r\n    \"WsFERole\":\"Agent\",\r\n    \"WsFESupervisor\":\"\",\r\n    \"AXPUserProfile\":null,\r\n    \"AXPUserRoles\": [\"Agent\"],\r\n    \"AXPUserMemberOfGroups\":[],\r\n    \"AXPUserOwnedGroups\":null,\r\n    \"AddVoicemailForExtensionType\":\"agent\",\r\n    \"AddSecondaryExtensionForVoicemail\": \"true\",\r\n    \"PhoneType\":\"IP\",\r\n    \"PhonePort\": \"\",\r\n    \"ADSecurityGroupCollection\":\"\",\r\n    \"OverrideStationAttribute\": {            \r\n\t\t\t\"CommPassword\": \"827599\"\r\n    },\r\n    \"OverrideAgentAttribute\":{},\r\n    \"OverrideMailboxAttribute\":{},\r\n    \"OverrideSupervisorAttribute\":{}\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/user",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user"
					]
				}
			},
			"response": []
		},
		{
			"name": "User_ProvisionUser MINIMAL PAYLOAD",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "Qwgd63HO6piBIkGrMowIH_lu76X6fDP8nnjLP2lKT0W1P39tmq_tG2uDeQ1Znf8ttfQzsgvVRGblC_lsC0sML3AeQgnzy1Z7zBcmh6tpKEG7Kj91blXbjgfkzN6nrXEmkp7sDo4ktfC5XYzJpxu4WEzcLvw8Z-l5734bRfZfn9VY7FBuPYERz-2MPyqIWDwqOEkqTM6IpNL88UCF2GW9dl64NSzS7x2-DMqDSYL1N1NJwuDrfkovSuEXw5bsknwM",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"SPS_13062022_ProvUser_132_9999\",\r\n    \"FirstName\":\"John9999\",\r\n    \"LastName\": \"Smith9999\",        \r\n    \"UserID\":\"JSmith9999\",\r\n    \"EmailAddress\":\"JSmith9999@avayacloud.com\",\r\n    \"ProvisioningGroup\":\"Dallas TX - OTCS\",\r\n    \"BundleName\":\"CC Voice\",\r\n    \"ReportUserGroup\":\"Public\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/user",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user"
					]
				}
			},
			"response": []
		},
		{
			"name": "User_GetUser (original basic auth)",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "{{BaseURL}}/user?userid=JSmith67&withResources=true",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user"
					],
					"query": [
						{
							"key": "userid",
							"value": "JSmith67"
						},
						{
							"key": "withResources",
							"value": "true"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "User_GetUser (WITH TOKEN)",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "Qwgd63HO6piBIkGrMowIH_lu76X6fDP8nnjLP2lKT0W1P39tmq_tG2uDeQ1Znf8ttfQzsgvVRGblC_lsC0sML3AeQgnzy1Z7zBcmh6tpKEG7Kj91blXbjgfkzN6nrXEmkp7sDo4ktfC5XYzJpxu4WEzcLvw8Z-l5734bRfZfn9VY7FBuPYERz-2MPyqIWDwqOEkqTM6IpNL88UCF2GW9dl64NSzS7x2-DMqDSYL1N1NJwuDrfkovSuEXw5bsknwM",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "{{BaseURL}}/user?userid=JSmith67&withResources=true",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user"
					],
					"query": [
						{
							"key": "userid",
							"value": "JSmith67"
						},
						{
							"key": "withResources",
							"value": "true"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "User_GetUser (WITH TOKEN) ALL USERS",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "Qwgd63HO6piBIkGrMowIH_lu76X6fDP8nnjLP2lKT0W1P39tmq_tG2uDeQ1Znf8ttfQzsgvVRGblC_lsC0sML3AeQgnzy1Z7zBcmh6tpKEG7Kj91blXbjgfkzN6nrXEmkp7sDo4ktfC5XYzJpxu4WEzcLvw8Z-l5734bRfZfn9VY7FBuPYERz-2MPyqIWDwqOEkqTM6IpNL88UCF2GW9dl64NSzS7x2-DMqDSYL1N1NJwuDrfkovSuEXw5bsknwM",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "{{BaseURL}}/user",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user"
					]
				}
			},
			"response": []
		},
		{
			"name": "User_ManageBundle",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "Starfish123",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_user_u_044\",\r\n    \"UserID\":\"JSmith67\",\r\n    \"BundleName\":\"UC Basic\",\r\n    \"ProvisioningGroup\":\"\",\r\n    \"ReportUserGroup\":\"\",\r\n    \"AddMailbox\":\"false\",\r\n    \"AddSupervisor\":\"false\",\r\n    \"StationTemplate\":\"\",\r\n    \"AgentTemplate\":\"\",\r\n    \"MailboxTemplate\":\"\",\r\n    \"CMSSupervisorTemplate\":\"\",\r\n    \"StationExtension\":\"\",\r\n    \"AgentLoginID\":\"\",\r\n    \"MailboxNumber\":null,\r\n    \"WsFERole\":\"Agent\",\r\n    \"WsFESupervisor\":\"sf_supervisor\",\r\n    \"AXPUserProfile\":\"AuraVoiceEmailChat\",\r\n    \"AXPUserRoles\": [\"Agent\"],\r\n    \"AXPUserMemberOfGroups\":[\"starfishtest\"],\r\n    \"AXPUserOwnedGroups\":null,\r\n    \"OverrideStationAttributes\": {},\r\n    \"OverrideAgentAttribute\":{},\r\n    \"OverrideMailboxAttribute\":{},\r\n    \"OverrideSupervisorAttribute\":{},\r\n    \"FirstName\":\"test89\",\r\n    \"LastName\": \"test89\",        \r\n    \"EmailAddress\":\"test89@avayacloud.com\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/user:ManageBundle",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user:ManageBundle"
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_ManageBundle",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_resource_bundle_u_026\",\r\n    \"ServerName\":\"\",\r\n    \"ResourceIdentifier\":\"33379\",\r\n    \"NewBundleName\":\"UC Basic\",\r\n    \"Template\":\"SM Default Template\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource:ManageBundle",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource:ManageBundle"
					]
				}
			},
			"response": []
		},
		{
			"name": "User_RenameResources",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"RenameResource_13\",\r\n    \"UserId\":\"JSmith_676\",\r\n    \"NewFirstName\":\"John67\",\r\n    \"NewLastName\":\"Smith676\",\r\n    \"NewEmailAddress\":\"\",\r\n    \"NewUserId\":\"JSmith_676\",\r\n    \"NewSecondaryUserId\":null\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/user:RenameResources",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user:RenameResources"
					]
				}
			},
			"response": []
		},
		{
			"name": "User_RenameResources WITH TOKEN",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "Qwgd63HO6piBIkGrMowIH_lu76X6fDP8nnjLP2lKT0W1P39tmq_tG2uDeQ1Znf8ttfQzsgvVRGblC_lsC0sML3AeQgnzy1Z7zBcmh6tpKEG7Kj91blXbjgfkzN6nrXEmkp7sDo4ktfC5XYzJpxu4WEzcLvw8Z-l5734bRfZfn9VY7FBuPYERz-2MPyqIWDwqOEkqTM6IpNL88UCF2GW9dl64NSzS7x2-DMqDSYL1N1NJwuDrfkovSuEXw5bsknwM",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"RenameResource_9999-IDtoAvaya-2024-12-23\",\r\n    \"UserId\":\"JSmith9999\",\r\n    \"NewEmailAddress\":\"e9999jsmithtest@wnco.com\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/user:RenameResources",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user:RenameResources"
					]
				}
			},
			"response": []
		},
		{
			"name": "User_ReassignUser",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"ReassignUser_17\",\r\n    \"UserId\":\"JSmith67\",\r\n    \"NewFirstName\":\"John68\",\r\n    \"NewLastName\":\"Smith68\",\r\n    \"NewEmailAddress\":\"JSmith68@avayacloud.com\",\r\n    \"NewUserId\":\"JSmith68\",\r\n    \"NewSecondaryUserId\":\"JSmith68-1\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/user:ReassignUser",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user:ReassignUser"
					]
				}
			},
			"response": []
		},
		{
			"name": "User_ChangeReportUserGroup",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "Starfish123",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_user_u_003\",\r\n    \"UserID\":\"JSmith68\",\r\n    \"NewReportUserGroup\":\"Unassigned\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/user:ChangeReportUserGroup/",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user:ChangeReportUserGroup",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_ChangeReportUserGroup",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_resource_u_007\",\r\n    \"ServerName\":\"STarfish4\",\r\n    \"ResourceIdentifier\":\"015033\",\r\n    \"NewReportUserGroup\":\"Sales\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/Resource/ChangeReportUserGroup ",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"Resource",
						"ChangeReportUserGroup "
					]
				}
			},
			"response": []
		},
		{
			"name": "User_DeProvision",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "Ude4BomfPLPqI09jGXUjUquxmT-zk6zKBTVRWIALlOsMVyk6G7a-NNm6sGDMDsMcmo4aY02BOLZO2MZHVeQwdzWpbd3mLzuyJoK6YJZuQB_8F_PopagsDBR3fjT0mZo1U668jT2SkkI0xQ7GkIQLNhU5WvCwG20l1tf-ZZYCYWCp6UdkB8y5F5AO_yLkzF3jcDytuU6HDe6CBVAFAMEJD2XmVgm1U1ixPUwVC2XW4uln0wj1MDfxS8NrInkAOn5G",
							"type": "string"
						}
					]
				},
				"method": "DELETE",
				"header": [],
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
					"raw": "{{BaseURL}}/user/JSmith67/?requestID=dep-132",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user",
						"JSmith67",
						""
					],
					"query": [
						{
							"key": "requestID",
							"value": "dep-132"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "User_DeProvision WITH TOKEN",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "Qwgd63HO6piBIkGrMowIH_lu76X6fDP8nnjLP2lKT0W1P39tmq_tG2uDeQ1Znf8ttfQzsgvVRGblC_lsC0sML3AeQgnzy1Z7zBcmh6tpKEG7Kj91blXbjgfkzN6nrXEmkp7sDo4ktfC5XYzJpxu4WEzcLvw8Z-l5734bRfZfn9VY7FBuPYERz-2MPyqIWDwqOEkqTM6IpNL88UCF2GW9dl64NSzS7x2-DMqDSYL1N1NJwuDrfkovSuEXw5bsknwM",
							"type": "string"
						}
					]
				},
				"method": "DELETE",
				"header": [],
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
					"raw": "{{BaseURL}}/user/JSmith8888/?requestID=IDtoAvaya-2024-12-13",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"user",
						"JSmith8888",
						""
					],
					"query": [
						{
							"key": "requestID",
							"value": "IDtoAvaya-2024-12-13"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_GetStation",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "Starfish123",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
				"url": {
					"raw": "{{BaseURL}}/resource?resourcetype=station",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource"
					],
					"query": [
						{
							"key": "resourcetype",
							"value": "station"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_GetCMSSupervisor",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/cms supervisor/JSmith67",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"cms supervisor",
						"JSmith67"
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_GeMailbox",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/voicemail/522555",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"voicemail",
						"522555"
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_GetSMGR",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
				"url": {
					"raw": "{{BaseURL}}/resource/smgr/JSmith67",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"smgr",
						"JSmith67"
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_AddSMGR",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_sm_a_078746\",\r\n    \"FirstName\":\"John\",\r\n    \"LastName\": \"Smith\",        \r\n    \"UserID\":\"\",\r\n    \"EmailAddress\":\"\",\r\n    \"ProvisioningGroup\":\"Eastern US - 5088\",\r\n    \"ResourceType\": \"SMGR\",\r\n    \"Template\":\"Digital 6408D+_DEFAULT_CM_8_1\",\r\n    \"ResourceIdentifier\":\"33370\",\r\n    \"PhoneType\":\"Digital\",\r\n    \"PhonePort\": \"002V403\",\r\n    \"OverrideResourceAttributes\": {  }\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource/",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "resource_getVoicemail_Address",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/voicemail/33884/address?serverName=IXM",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"voicemail",
						"33884",
						"address"
					],
					"query": [
						{
							"key": "serverName",
							"value": "IXM"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "resource_DeleteVoicemail_Address",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "DELETE",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/voicemail/33884/address?address=JSmith67@avayacloud.com&addressType=Email&requestId=del_addr_006",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"voicemail",
						"33884",
						"address"
					],
					"query": [
						{
							"key": "address",
							"value": "JSmith67@avayacloud.com"
						},
						{
							"key": "addressType",
							"value": "Email"
						},
						{
							"key": "requestId",
							"value": "del_addr_006"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "resource_AddVoicemail_Address",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"13062022_vmadr_8\",\r\n    \"MailboxNumber\":\"33884\",\r\n    \"ServerName\":\"IXM\",\r\n    \"AddressType\": \"Email\",    \r\n    \"Address\":\"JSmith67@avayacloud.com\",    \r\n    \"Label\":\"JSmith67@avayacloud.com\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource/voicemail/address",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"voicemail",
						"address"
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_AddStation",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_sta_add_026\",\r\n    \"FirstName\":\"Par\",\r\n    \"LastName\": \"Tonde\",        \r\n    \"UserID\":\"\",\r\n    \"EmailAddress\":\"PTonde451@starfishassociates.com\",\r\n    \"ProvisioningGroup\":\"Eastern US - 5088\",\r\n    \"BundleName\":\"UC Power\",\r\n    \"ResourceType\": \"station\",\r\n    \"Template\":\"Digital 6408D+_DEFAULT_CM_8_1\",\r\n    \"ResourceIdentifier\":\"33370\",\r\n    \"PhoneType\":\"Digital\",\r\n    \"PhonePort\": \"002V403\",\r\n    \"ReportUserGroup\":\"5088\",\r\n    \"OverrideResourceAttributes\": {            \r\n\t\t\t\"Presence.publishViaAESCollector\": \"On\"\r\n    }\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource/",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "resource_AddSupervisor",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_cms_a_07883\",\r\n    \"FirstName\":\"John67\",\r\n    \"LastName\": \"Smith67\",        \r\n    \"UserID\":\"JSmith67\",\r\n    \"EmailAddress\":\"JSmith67@avayacloud.com\",\r\n    \"ProvisioningGroup\":\"Eastern US - 5088\",\r\n    \"ResourceType\": \"CMS Supervisor\",\r\n    \"Template\":\"Default CMS Template\",\r\n    \"ResourceIdentifier\":\"JSmith67\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource/",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "resource_AddVoicemail",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_voicemail_a_078880\",\r\n    \"FirstName\":\"John67\",\r\n    \"LastName\": \"Smith67\",        \r\n    \"UserID\":\"JSmith67\",\r\n    \"EmailAddress\":\"JSmith67@avayacloud.com\",\r\n    \"ProvisioningGroup\":\"Eastern US - 5088\",\r\n    \"ResourceType\": \"Voicemail\",\r\n    \"Template\":\"IXM with Address\",\r\n    \"ResourceIdentifier\":\"33370\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource/",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_UpdateSMGR",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\": \"res_sm_u_100\",\r\n    \"ResourceType\": \"SMGR\",\r\n    \"Template\": \"Digital 6408D+_DEFAULT_CM_8_1\",\r\n    \"ResourceIdentifier\": \"33370\",\r\n    \"ServerName\":\"SMGR8\",\r\n    \"PhonePort\":\"\",\r\n    \"OverrideResourceAttributes\": {\r\n        \"Surname\":\"Tonde\",\r\n        \"CMEndPoint.voicemailnumber\": \"12457\",\r\n        \"Presence.publishViaAESCollector\": \"Off\"\r\n    }\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource/",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_UpdateSMGRPrimaryProfile",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\": \"res_sm_u_p_023\",\r\n    \"Extension\": \"33370\",\r\n    \"ServerName\": \"SMGR8\",\r\n    \"ResourceIdentifier\": \"JSmith67\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource/smgr/profileset:setdefault",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"smgr",
						"profileset:setdefault"
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_UpdateStation",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "Starfish123",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_u_003\",\r\n    \"ResourceType\": \"Station\",\r\n    \"Template\":\"Station Default Template\",\r\n    \"ResourceIdentifier\":\"33983\",\r\n    \"Target\": \"Starfish4\",\r\n    \"OverrideResourceAttributes\": {            \r\n\t            \"Name\": \"Tonde1, parm27\"\r\n    \r\n    }\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource/",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_UpdateMailbox",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_u_mbx_0027\",\r\n    \"ResourceType\": \"voicemail\",\r\n    \"ResourceIdentifier\":\"33370\",\r\n    \"ServerName\": \"\",\r\n    \"Template\":\"\",\r\n    \"OverrideResourceAttributes\": {            \r\n                \"MbxLocked\": \"true\"\r\n    }\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource"
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_UpdateCMSSupervisor",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "PATCH",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"RequestID\":\"res_u_cmsSupervisor_0024\",\r\n    \"ResourceType\": \"CMS Supervisor\",\r\n    \"ResourceIdentifier\":\"Partonde1\",\r\n    \"OverrideResourceAttributes\": {            \r\n         \"Skill1\": \"4,y,y,n\"\r\n    }\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{BaseURL}}/resource",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource"
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_DeleteSMGR",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "DELETE",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/smgr/33378/?RequestID=del_sm_047&serverName=SMGR8",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"smgr",
						"33378",
						""
					],
					"query": [
						{
							"key": "RequestID",
							"value": "del_sm_047"
						},
						{
							"key": "serverName",
							"value": "SMGR8"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_DeleteStation",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "DELETE",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/station/33370?RequestID=del_023&serverName=Starfish4",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"station",
						"33370"
					],
					"query": [
						{
							"key": "RequestID",
							"value": "del_023"
						},
						{
							"key": "serverName",
							"value": "Starfish4"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_DeleteAgent",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "Starfish123",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "DELETE",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/agent/33970?serverName=Starfish4&RequestID=del_008",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"agent",
						"33970"
					],
					"query": [
						{
							"key": "serverName",
							"value": "Starfish4"
						},
						{
							"key": "RequestID",
							"value": "del_008"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_DeleteVoicemail",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "DELETE",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/voicemail/33884?RequestID=del_034",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"voicemail",
						"33884"
					],
					"query": [
						{
							"key": "RequestID",
							"value": "del_034"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Resource_DeleteCMSSUpervisor",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "DELETE",
				"header": [],
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
					"raw": "{{BaseURL}}/resource/cms supervisor/JSmith67?RequestID=del_Sup_027",
					"host": [
						"{{BaseURL}}"
					],
					"path": [
						"resource",
						"cms supervisor",
						"JSmith67"
					],
					"query": [
						{
							"key": "RequestID",
							"value": "del_Sup_027"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Connectivitytest_CMS",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "https://192.168.52.69/ProvisioningWebService/sps/connectivitytest?systemType=CMS&serverName=CMS",
					"protocol": "https",
					"host": [
						"192",
						"168",
						"52",
						"69"
					],
					"path": [
						"ProvisioningWebService",
						"sps",
						"connectivitytest"
					],
					"query": [
						{
							"key": "systemType",
							"value": "CMS"
						},
						{
							"key": "serverName",
							"value": "CMS"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Connectivitytest_CM",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "https://192.168.52.69/ProvisioningWebService/sps/connectivitytest?systemType=CM&serverName=Starfish3",
					"protocol": "https",
					"host": [
						"192",
						"168",
						"52",
						"69"
					],
					"path": [
						"ProvisioningWebService",
						"sps",
						"connectivitytest"
					],
					"query": [
						{
							"key": "systemType",
							"value": "CM"
						},
						{
							"key": "serverName",
							"value": "Starfish3"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Connectivitytest_ACCCM",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "Starfish123",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "https://192.168.52.69/ProvisioningWebService/sps/connectivitytest?systemType=ACCCM&serverName=ACCM_OCP1",
					"protocol": "https",
					"host": [
						"192",
						"168",
						"52",
						"69"
					],
					"path": [
						"ProvisioningWebService",
						"sps",
						"connectivitytest"
					],
					"query": [
						{
							"key": "systemType",
							"value": "ACCCM"
						},
						{
							"key": "serverName",
							"value": "ACCM_OCP1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Connectivitytest_LDAP",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "Starfish123",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "https://192.168.52.69/ProvisioningWebService/sps/connectivitytest?systemType=LDAP&serverName=AD AADS",
					"protocol": "https",
					"host": [
						"192",
						"168",
						"52",
						"69"
					],
					"path": [
						"ProvisioningWebService",
						"sps",
						"connectivitytest"
					],
					"query": [
						{
							"key": "systemType",
							"value": "LDAP"
						},
						{
							"key": "serverName",
							"value": "AD AADS"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Connectivitytest_AAM",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "Starfish123",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "https://192.168.52.69/ProvisioningWebService/sps/connectivitytest?systemType=AAM&serverName=AAM",
					"protocol": "https",
					"host": [
						"192",
						"168",
						"52",
						"69"
					],
					"path": [
						"ProvisioningWebService",
						"sps",
						"connectivitytest"
					],
					"query": [
						{
							"key": "systemType",
							"value": "AAM"
						},
						{
							"key": "serverName",
							"value": "AAM"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Connectivitytest_Media Server",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "St@rf1sh@098",
							"type": "string"
						},
						{
							"key": "username",
							"value": "starfish",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
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
					"raw": "https://192.168.52.69/ProvisioningWebService/sps/connectivitytest?systemType=MS&serverName=M1",
					"protocol": "https",
					"host": [
						"192",
						"168",
						"52",
						"69"
					],
					"path": [
						"ProvisioningWebService",
						"sps",
						"connectivitytest"
					],
					"query": [
						{
							"key": "systemType",
							"value": "MS"
						},
						{
							"key": "serverName",
							"value": "M1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Token",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "urlencoded",
					"urlencoded": [
						{
							"key": "grant_type",
							"value": "client_credentials",
							"type": "text"
						},
						{
							"key": "client_id",
							"value": "starfish",
							"type": "text"
						},
						{
							"key": "client_secret",
							"value": "St@rf1sh@098",
							"type": "text"
						},
						{
							"key": "",
							"value": "",
							"type": "text",
							"disabled": true
						}
					]
				},
				"url": {
					"raw": "https://portal.glb.nar.swa.avayacloud.com/ProvisioningWebService/Token",
					"protocol": "https",
					"host": [
						"portal",
						"glb",
						"nar",
						"swa",
						"avayacloud",
						"com"
					],
					"path": [
						"ProvisioningWebService",
						"Token"
					]
				}
			},
			"response": []
		}
	]
}