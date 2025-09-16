

5/17/2024 2:48:45 PM

Ran this today in dir4: 

![[Pasted image 20240517144900.png]]


I took a copy of the todoeetle container, and the backups from last night, so we have a copy of everything form that container.:

![[Pasted image 20240517145905.png]]





5/20/2024 2:20:20 PM
Removing this user

![[Pasted image 20240520142039.png]]

Also removing htis one:

![[Pasted image 20240520142407.png]]

and this:
![[Pasted image 20240520142513.png]]


5/20/2024 2:26:17 PM
Chris still reporting issues; found had to exlude bcparpenter


backed up list of acls: before adding new one:
1#subtree#[Public]#[Entry Rights]
1#subtree#cn=ldap,ou=ToDelete,o=TriVir#[Entry Rights]
1#subtree#cn=proxy,ou=ToDelete,o=TriVir#[Entry Rights]
1073741824#subtree#cn=[root],cn=Novell Certificate Server Management,cn=RBS2,o=services#nDSPKIPrivateKey
1073741824#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nDSPKIPrivateKey
1073741825#subtree#cn=[root],cn=NMAS Management,cn=RBS2,o=services#[Entry Rights]
1073741825#subtree#cn=[root],cn=Novell Certificate Access,cn=RBS2,o=services#[Entry Rights]
1073741825#subtree#cn=[root],cn=Rights Management,cn=RBS2,o=services#[Entry Rights]
1073741826#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginIntruderAddress
1073741826#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginIntruderAttempts
1073741826#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginIntruderResetTime
1073741826#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginIntruderAddress
1073741826#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginIntruderAttempts
1073741826#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginIntruderResetTime
1073741826#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginIntruderAddress
1073741826#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginIntruderResetTime
1073741827#subtree#cn=[root],cn=Help Desk Management,cn=RBS2,o=services#[Entry Rights]
1073741828#subtree#cn=[root],cn=Help Desk Management,cn=RBS2,o=services#sASLoginConfiguration
1073741828#subtree#cn=[root],cn=Help Desk Management,cn=RBS2,o=services#sASLoginConfigurationKey
1073741828#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#sASLoginConfigurationKey
1073741830#subtree#cn=[root],cn=Rights Management,cn=RBS2,o=services#[All Attributes Rights]
1073741831#subtree#cn=[root],cn=eDirectory Administration,cn=RBS2,o=services#[All Attributes Rights]
1073741831#subtree#cn=[root],cn=eDirectory Administration,cn=RBS2,o=services#cn
1073741831#subtree#cn=[root],cn=Help Desk Management,cn=RBS2,o=services#[All Attributes Rights]
1073741831#subtree#cn=[root],cn=LDAP Management,cn=RBS2,o=services#[Entry Rights]
1073741831#subtree#cn=[root],cn=SNMP Management,cn=RBS2,o=services#[Entry Rights]
1073741831#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#[All Attributes Rights]
1073741831#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#[All Attributes Rights]
1073741840#subtree#cn=[root],cn=ApprovalFlowAdministrationRole,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=ApprovalFlowConfigurationRole,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=Archive Version Management,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=CredentialProvisioningRole,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=DirXML Management,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=DirXML Utilities,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=Novell Certificate Server Management,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=PBX Utilities,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=Shared Profile Management,cn=RBS2,o=services#[Entry Rights]
1073741840#subtree#cn=[root],cn=WorkOrders,cn=RBS2,o=services#[Entry Rights]
1073741841#subtree#cn=[root],cn=eDirectory Maintenance Utilities,cn=RBS2,o=services#[Entry Rights]
1073741841#subtree#cn=[root],cn=Schema Management,cn=RBS2,o=services#[Entry Rights]
1073741843#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#[Entry Rights]
1073741845#subtree#cn=[root],cn=Kerberos Management,cn=RBS2,o=services#[Entry Rights]
1073741847#subtree#cn=[root],cn=Partition and Replica Management,cn=RBS2,o=services#[Entry Rights]
1073741847#subtree#cn=[root],cn=WAN Traffic Management,cn=RBS2,o=services#[Entry Rights]
1073741855#subtree#cn=[root],cn=eDirectory Administration,cn=RBS2,o=services#[Entry Rights]
1073741855#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#[Entry Rights]
1073741855#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#[Entry Rights]
1073741855#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#[Entry Rights]
1073741856#subtree#cn=[root],cn=ApprovalFlowAdministrationRole,cn=RBS2,o=services#notfMergeTemplateData
1073741856#subtree#cn=[root],cn=ApprovalFlowAdministrationRole,cn=RBS2,o=services#notfMergeTemplateSubject
1073741856#subtree#cn=[root],cn=ApprovalFlowAdministrationRole,cn=RBS2,o=services#notfSMTPEmailFrom
1073741856#subtree#cn=[root],cn=ApprovalFlowAdministrationRole,cn=RBS2,o=services#notfSMTPEmailHost
1073741856#subtree#cn=[root],cn=ApprovalFlowAdministrationRole,cn=RBS2,o=services#notfSMTPEmailUserName
1073741856#subtree#cn=[root],cn=ApprovalFlowAdministrationRole,cn=RBS2,o=services#sASSecretStore
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#accountBalance
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#allowUnlimitedCredit
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#description
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#dgAllowDuplicates
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#dgAllowUnknown
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#dgIdentity
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#dgTimeOut
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#equivalentToMe
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#excludedMember
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#facsimileTelephoneNumber
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#fullName
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#generationQualifier
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#givenName
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#groupMembership
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#initials
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#l
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#Language
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#lockedByIntruder
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginAllowedTimeMap
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginDisabled
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginExpirationTime
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginGraceLimit
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginGraceRemaining
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginMaximumSimultaneous
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginScript
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#loginTime
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#mail
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#member
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#memberQueryURL
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#messageServer
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#minimumAccountBalance
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#ndsHomeDirectory
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#networkAddress
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#networkAddressRestriction
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#o
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#ou
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#owner
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#passwordAllowChange
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#passwordExpirationInterval
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#passwordExpirationTime
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#passwordManagement
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#passwordMinimumLength
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#passwordRequired
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#passwordUniqueRequired
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#physicalDeliveryOfficeName
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#postalAddress
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#postalCode
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#postOfficeBox
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#Profile
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#sasAuthorizedLoginSequences
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#sasDefaultLoginSequence
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#securityEquals
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#seeAlso
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#sn
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#st
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#street
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#telephoneNumber
1073741856#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#title
1073741856#subtree#cn=[root],cn=Help Desk Management,cn=RBS2,o=services#lockedByIntruder
1073741856#subtree#cn=[root],cn=Help Desk Management,cn=RBS2,o=services#loginIntruderAttempts
1073741856#subtree#cn=[root],cn=Help Desk Management,cn=RBS2,o=services#passwordManagement
1073741856#subtree#cn=[root],cn=LDAP Management,cn=RBS2,o=services#ldapServerList
1073741856#subtree#cn=[root],cn=LinuxUserManagementLUM,cn=RBS2,o=services#groupMembership
1073741856#subtree#cn=[root],cn=NMAS Management,cn=RBS2,o=services#passwordManagement
1073741856#subtree#cn=[root],cn=NMAS Management,cn=RBS2,o=services#sasAuthorizedLoginSequences
1073741856#subtree#cn=[root],cn=NMAS Management,cn=RBS2,o=services#sasDefaultLoginSequence
1073741856#subtree#cn=[root],cn=NMAS Management,cn=RBS2,o=services#sASLoginConfiguration
1073741856#subtree#cn=[root],cn=Novell Certificate Server Management,cn=RBS2,o=services#nDSPKICertificateChain
1073741856#subtree#cn=[root],cn=Novell Certificate Server Management,cn=RBS2,o=services#nDSPKIPublicKeyCertificate
1073741856#subtree#cn=[root],cn=Novell Certificate Server Management,cn=RBS2,o=services#nDSPKIUserCertificateInfo
1073741856#subtree#cn=[root],cn=Novell Certificate Server Management,cn=RBS2,o=services#sASSecretStore
1073741856#subtree#cn=[root],cn=Novell Certificate Server Management,cn=RBS2,o=services#userCertificate;binary
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#cn
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#description
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#notfMergeTemplateData
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#notfMergeTemplateSubject
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#notfSMTPEmailFrom
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#notfSMTPEmailHost
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#notfSMTPEmailUserName
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimAssignments
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimChallengeSetDN
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimChallengeSetGUID
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimForgottenAction
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimForgottenLoginConfig
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimHint
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimMaxResponseLength
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimMinResponseLength
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimNumberRandomQuestions
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimPwdRuleEnforcement
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimRandomQuestions
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nsimRequiredQuestions
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmAdministratorChangeCount
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmCaseSensitive
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmChangePasswordMessage
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmConfigurationOptions
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmDisallowedAttributeValues
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmExcludeList
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmExtendedCharactersAllowed
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMaxConsecutiveCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMaximumLength
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMaxLowerCaseCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMaxNumericCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMaxRepeatedCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMaxSpecialCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMaxUpperCaseCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMinLowerCaseCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMinNumericCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMinPasswordLifetime
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMinSpecialCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMinUniqueCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmMinUpperCaseCharacters
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmNumericAsFirstCharacter
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmNumericAsLastCharacter
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmNumericCharactersAllowed
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmPasswordHistory
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmPasswordHistoryExpiration
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmPasswordHistoryLimit
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmPasswordPolicyDN
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmPolicyAgentContainerDN
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmPolicyPrecedence
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmSpecialAsFirstCharacter
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmSpecialAsLastCharacter
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#nspmSpecialCharactersAllowed
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#passwordAllowChange
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#passwordExpirationInterval
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#passwordExpirationTime
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#passwordManagement
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#passwordMinimumLength
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#passwordRequired
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#passwordUniqueRequired
1073741856#subtree#cn=[root],cn=PwdPolicyManagement,cn=RBS2,o=services#sASSecretStore
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#accountBalance
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#allowUnlimitedCredit
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#description
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#equivalentToMe
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#facsimileTelephoneNumber
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#fullName
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#generationQualifier
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#givenName
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#groupMembership
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#initials
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#l
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#Language
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#lockedByIntruder
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginAllowedTimeMap
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginDisabled
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginExpirationTime
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginGraceLimit
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginGraceRemaining
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginMaximumSimultaneous
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginScript
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#loginTime
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#mail
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#member
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#messageServer
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#minimumAccountBalance
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#ndsHomeDirectory
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#networkAddress
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#networkAddressRestriction
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#ou
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#passwordAllowChange
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#passwordExpirationInterval
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#passwordExpirationTime
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#passwordManagement
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#passwordMinimumLength
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#passwordRequired
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#passwordUniqueRequired
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#physicalDeliveryOfficeName
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#postalAddress
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#postalCode
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#postOfficeBox
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#Profile
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#sasAuthorizedLoginSequences
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#sasDefaultLoginSequence
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#securityEquals
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#seeAlso
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#sn
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#st
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#street
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#telephoneNumber
1073741856#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#title
1073741856#subtree#cn=[root],cn=WAN Traffic Management,cn=RBS2,o=services#member
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#accountBalance
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#allowUnlimitedCredit
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#description
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#dgAllowDuplicates
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#dgAllowUnknown
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#dgIdentity
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#dgTimeOut
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#equivalentToMe
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#excludedMember
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#facsimileTelephoneNumber
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#fullName
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#generationQualifier
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#givenName
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#groupMembership
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#initials
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#l
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#Language
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#ldapServerList
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#lockedByIntruder
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginAllowedTimeMap
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginDisabled
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginExpirationTime
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginGraceLimit
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginGraceRemaining
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginMaximumSimultaneous
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginScript
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginTime
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#mail
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#member
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#memberQueryURL
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#messageServer
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#minimumAccountBalance
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#ndsHomeDirectory
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nDSPKICertificateChain
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nDSPKIPublicKeyCertificate
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nDSPKIUserCertificateInfo
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#networkAddress
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#networkAddressRestriction
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#notfMergeTemplateData
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#notfMergeTemplateSubject
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#notfSMTPEmailFrom
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#notfSMTPEmailHost
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#notfSMTPEmailUserName
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimAssignments
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimChallengeSetDN
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimChallengeSetGUID
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimForgottenAction
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimForgottenLoginConfig
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimHint
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimMaxResponseLength
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimMinResponseLength
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimNumberRandomQuestions
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimPwdRuleEnforcement
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimRandomQuestions
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nsimRequiredQuestions
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmAdministratorChangeCount
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmCaseSensitive
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmChangePasswordMessage
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmConfigurationOptions
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmDisallowedAttributeValues
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmExcludeList
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmExtendedCharactersAllowed
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMaxConsecutiveCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMaximumLength
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMaxLowerCaseCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMaxNumericCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMaxRepeatedCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMaxSpecialCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMaxUpperCaseCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMinLowerCaseCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMinNumericCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMinPasswordLifetime
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMinSpecialCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMinUniqueCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmMinUpperCaseCharacters
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmNumericAsFirstCharacter
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmNumericAsLastCharacter
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmNumericCharactersAllowed
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmPasswordHistory
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmPasswordHistoryExpiration
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmPasswordHistoryLimit
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmPasswordPolicyDN
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmPolicyAgentContainerDN
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmPolicyPrecedence
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmSpecialAsFirstCharacter
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmSpecialAsLastCharacter
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#nspmSpecialCharactersAllowed
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#o
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#ou
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#owner
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#passwordAllowChange
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#passwordExpirationInterval
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#passwordExpirationTime
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#passwordManagement
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#passwordMinimumLength
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#passwordRequired
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#passwordUniqueRequired
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#physicalDeliveryOfficeName
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#postalAddress
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#postalCode
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#postOfficeBox
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#Profile
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#sasAuthorizedLoginSequences
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#sasDefaultLoginSequence
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#sASSecretStore
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#securityEquals
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#seeAlso
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#sn
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#st
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#street
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#telephoneNumber
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#title
1073741856#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#userCertificate;binary
1073741858#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#loginIntruderAttempts
1073741860#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#sASLoginConfiguration
1073741863#subtree#cn=[root],cn=Group Management,cn=RBS2,o=services#cn
1073741863#subtree#cn=[root],cn=User Management,cn=RBS2,o=services#cn
1073741863#subtree#cn=datacenteradmins,ou=Groups,o=TriVir#cn
12#subtree#[This]#nsimHint
12#subtree#[This]#nsimPasswordReminder
16#subtree#cn=admin,o=services#[Entry Rights]
16#subtree#cn=edirbackup_svc,ou=accounts,o=services#[Entry Rights]
17#subtree#cn=gknutti,ou=Users,o=TriVir#[Entry Rights]
17#subtree#cn=hfranklin,ou=Users,o=TriVir#[Entry Rights]
2#entry#[Public]#sssActiveServerList
3#subtree#cn=ldap,ou=ToDelete,o=TriVir#[All Attributes Rights]
3#subtree#cn=proxy,ou=ToDelete,o=TriVir#[All Attributes Rights]
35#subtree#cn=gknutti,ou=Users,o=TriVir#[All Attributes Rights]
35#subtree#cn=hfranklin,ou=Users,o=TriVir#[All Attributes Rights]


Adding this temporarially to the tree.
16#subtree#cn=linux_pam_svc,ou=accounts,o=services#[Entry Rights]

Will delete this shortly after testing:
![[Pasted image 20240520145232.png]]





5/20/2024 3:01:06 PM
5/20/2024 3:00:50 PM
TriVir config



cn=linux_pam_svc,ou=accounts,o=services


16#subtree#cn=linux_pam_svc,ou=accounts,o=services#[Entry Rights]

removed admin rights . .'primary attribute' removed . .

Add CN to the group container for linux svc account to read CN of all groups:

![[Pasted image 20240520150857.png]]