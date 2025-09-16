---
tags: ["#ex2007"]
---
# Property Sets in Exchange 2007

 **Property Sets in Exchange 2007**

  [Switch on low bandwidth view](http://technet.microsoft.com/en-us/library/bb310768(loband).aspx)
![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]]
Property Sets in Exchange 2007

**_Applies to:_** _Exchange Server 2007 SP1, Exchange Server 2007_ **_Topic Last Modified:_** _2007-03-19_

Earlier versions of Microsoft Exchange Server did not rely heavily on property sets for applying permissions in the domain partition. Although this was not an issue in typical deployments, this became an issue for distributed environments that delegated all tasks. Administrators in these environments had to assign permissions for a multitude of attributes for mail recipients so that appropriate tasks could be delegated in a least-privilege access model. Depending on the version of the Active Directory directory service servers, this can cause serious access control list (ACL) bloat, increasing the size of the Ntds.dit file.

Exchange Server 2007 improves administrative delegation by using property sets for most mail recipient attributes.

![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]] What Are Property Sets?

A property set is a grouping of Active Directory attributes. You can control access to this grouping of Active Directory attributes by setting one access control entry (ACE) instead of setting an ACE on each property. Also, an attribute can only be a member of a single property set.

For example, the Personal-Information property set includes properties such as street address and telephone number. Both of these are properties of user objects.

![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]] Property Sets in Exchange Server 2003

In Exchange Server 2003, the Exchange schema extension process added many Exchange-related mail recipient attributes to the built-in Active Directory property sets, Personal Information and Public Information. The Exchange Enterprise Servers domain local security groups were assigned access to these property sets on the domain partitions during the domain preparation phase so that Recipient Update Service (RUS) could update objects. The following tables list the attributes in the Personal Information and Public Information property sets.

### Public Information property set

|     |     |     |
| --- | --- | --- |
| **allowedAttributes**<br>**allowedAttributesEffective**<br>**allowedChildClasses**<br>**allowedChildClassesEffective**<br>**altRecipient**<br>**altRecipientBL**<br>**altSecurityIdentities**<br>**attributeCertificate**<br>**authOrig**<br>**authOrigBL**<br>**autoReply**<br>**autoReplyMessage**<br>**cn**<br>**co**<br>**company**<br>**deletedItemFlags**<br>**delivContLength**<br>**deliverAndRedirect**<br>**deliveryMechanism**<br>**delivExtContTypes**<br>**department**<br>**description**<br>**directReports**<br>**displayNamePrintable**<br>**distinguishedName**<br>**division**<br>**dLMemberRule**<br>**dLMemDefault**<br>**dLMemRejectPerms**<br>**dLMemRejectPermsBL**<br>**dLMemSubmitPerms**<br>**dLMemSubmitPermsBL**<br>**dnQualifier**<br>**enabledProtocols**<br>**expirationTime**<br>**extensionAttribute1**<br>**extensionAttribute10**<br>**extensionAttribute11**<br>**extensionAttribute12**<br>**extensionAttribute13**<br>**extensionAttribute14**<br>**extensionAttribute15**<br>**extensionAttribute2**<br>**extensionAttribute3**<br>**extensionAttribute4**<br>**extensionAttribute5**<br>**extensionAttribute6**<br>**extensionAttribute7**<br>**extensionAttribute8**<br>**extensionAttribute9**<br>**extensionData**<br>**folderPathname** | **formData**<br>**forwardingAddress**<br>**givenName**<br>**heuristics**<br>**hideDLMembership**<br>**homeMDB**<br>**homeMTA**<br>**importedFrom**<br>**initials**<br>**internetEncoding**<br>**kMServer**<br>**language**<br>**languageCode**<br>**legacyExchangeDN**<br>**mail**<br>**mailNickname**<br>**manager**<br>**mAPIRecipient**<br>**mDBOverHardQuotaLimit**<br>**mDBOverQuotaLimit**<br>**mDBStorageQuota**<br>**mDBUseDefaults**<br>**msDS-AllowedToDelegateTo**<br>**msDS-Approx-Immed-Subordinates**<br>**msDS-Auxiliary-Classes**<br>**msExchADCGlobalNames**<br>**msExchALObjectVersion**<br>**msExchAssistantName**<br>**msExchConferenceMailboxBL**<br>**msExchControllingZone**<br>**msExchCustomProxyAddresses**<br>**msExchExpansionServerName**<br>**msExchFBURL**<br>**msExchHideFromAddressLists**<br>**msExchHomeServerName**<br>**msExchIMACL**<br>**msExchIMAddress**<br>**msExchIMAPOWAURLPrefixOverride**<br>**msExchIMMetaPhysicalURL**<br>**msExchIMPhysicalURL**<br>**msExchIMVirtualServer**<br>**msExchInconsistentState**<br>**msExchLabeledURI**<br>**msExchMailboxFolderSet**<br>**msExchMailboxGuid**<br>**msExchMailboxSecurityDescriptor**<br>**msExchMailboxUrl**<br>**msExchMasterAccountSid**<br>**msExchOmaAdminExtendedSettings**<br>**msExchOmaAdminWirelessEnable**<br>**msExchOriginatingForest**<br>**msExchPfRootUrl** | **msExchPFTreeType**<br>**msExchPoliciesExcluded**<br>**msExchPoliciesIncluded**<br>**msExchPolicyEnabled**<br>**msExchPolicyOptionList**<br>**msExchPreviousAccountSid**<br>**msExchProxyCustomProxy**<br>**msExchQueryBaseDN**<br>**msExchRecipLimit**<br>**msExchRequireAuthToSendTo**<br>**msExchResourceGUID**<br>**msExchResourceProperties**<br>**msExchTUIPassword**<br>**msExchTUISpeed**<br>**msExchTUIVolume**<br>**msExchUnmergedAttsPt**<br>**msExchUseOAB**<br>**msExchUserAccountControl**<br>**msExchVoiceMailboxID**<br>**name**<br>**notes**<br>**o**<br>**objectCategory**<br>**objectClass**<br>**objectGUID**<br>**oOFReplyToOriginator**<br>**otherMailbox**<br>**ou**<br>**pOPCharacterSet**<br>**pOPContentFormat**<br>**protocolSettings**<br>**proxyAddresses**<br>**publicDelegatesBL**<br>**replicatedObjectVersion**<br>**replicationSensitivity**<br>**replicationSignature**<br>**reportToOriginator**<br>**reportToOwner**<br>**securityProtocol**<br>**servicePrincipalName**<br>**showInAddressBook**<br>**sn**<br>**submissionContLength**<br>**supportedAlgorithms**<br>**systemFlags**<br>**targetAddress**<br>**telephoneAssistant**<br>**textEncodedORAddress**<br>**title**<br>**unauthOrig**<br>**unauthOrigBL**<br>**unmergedAtts**<br>**userPrincipalName** |

### Personal Information property set

|     |     |     |
| --- | --- | --- |
| **assistant**<br>**c**<br>**facsimileTelephoneNumber**<br>**homePhone**<br>**homePostalAddress**<br>**info**<br>**internationalISDNNumber**<br>**ipPhone**<br>**l**<br>**mobile**<br>**mSMQDigests**<br>**mSMQSignCertificates**<br>**otherFacsimileTelephoneNumber**<br>**otherHomePhone** | **otherIpPhone**<br>**otherMobile**<br>**otherPager**<br>**otherTelephone**<br>**pager**<br>**personalTitle**<br>**physicalDeliveryOfficeName**<br>**postalAddress**<br>**postalCode**<br>**postOfficeBox**<br>**preferredDeliveryMethod**<br>**primaryInternationalISDNNumber**<br>**primaryTelexNumber**<br>**publicDelegates** | **registeredAddress**<br>**st**<br>**street**<br>**streetAddress**<br>**telephoneNumber**<br>**teletexTerminalIdentifier**<br>**telexNumber**<br>**thumbnailPhoto**<br>**userCert**<br>**userCertificate**<br>**userSharedFolder**<br>**userSharedFolderOther**<br>**userSMIMECertificate**<br>**x121Address** |

However, when it came to delegation of permissions for management of mail recipients, many Active Directory administrators did not assign permissions to Exchange administrators by using these property sets because they provided access to many additional non-Exchange related attributes.

![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]] Property Sets in Exchange 2007

Exchange 2007 takes advantage of property sets by creating two new property sets exclusively for Exchange Server, instead of by relying on preexisting Active Directory property sets. Several of the improvements in Exchange 2007 include the following:

* There is no longer a reliance on default Active Directory property sets. The Exchange-specific property sets address the uncertainty of potential change in future versions of the Active Directory property sets.
* Attributes created by the Exchange schema extension are the only members of the Exchange-specific property sets.
* Exchange-specific property sets enable the creation and deployment of a delegated security permission model that is specific to management of Exchange mail recipient data.

During the schema extension phase, Exchange 2007 performs several actions. These include the following:

* It extends the schema with new classes and attributes.
* It creates the Exchange Information and Exchange Personal Information property sets.
* It adds the appropriate attributes to the Exchange Information and Exchange Personal Information property sets.

Exchange 2003 attributes that had been previously added to the Personal Information or Public Information property sets are moved accordingly to the Exchange-specific property sets.

Because attributes are moved between property sets, you must update the Exchange 2003 recipient permission structure when you implement Exchange 2007 in a legacy environment. You do this either by executing the **setup /PrepareLegacyExchangePermissions** command or the **setup /PrepareSchema** command. For more information about what the **setup /PrepareLegacyExchangePermissions** command does, see [Preparing Legacy Exchange Permissions](http://technet.microsoft.com/en-us/library/aa997914.aspx).

The Exchange Information property set includes the attributes that are listed in the following table. In addition, Authenticated Users have read access to this property set so that they can look up specific pieces of information about mail recipients, for example, by using the Address Book in Microsoft Office Outlook.

### Exchange Information property set

|     |     |     |
| --- | --- | --- |
| **altRecipient**<br>**altRecipientBL**<br>**attributeCertificate**<br>**authOrig**<br>**authOrigBL**<br>**autoReply**<br>**autoReplyMessage**<br>**deletedItemFlags**<br>**delivContLength**<br>**deliverAndRedirect**<br>**deliveryMechanism**<br>**delivExtContTypes**<br>**dLMemberRule**<br>**dLMemDefault**<br>**dLMemRejectPerms**<br>**dLMemRejectPermsBL**<br>**dLMemSubmitPerms**<br>**dLMemSubmitPermsBL**<br>**dnQualifier**<br>**enabledProtocols**<br>**expirationTime**<br>**extensionAttribute1**<br>**extensionAttribute10**<br>**extensionAttribute11**<br>**extensionAttribute12**<br>**extensionAttribute13**<br>**extensionAttribute14**<br>**extensionAttribute15**<br>**extensionAttribute2**<br>**extensionAttribute3**<br>**extensionAttribute4**<br>**extensionAttribute5**<br>**extensionAttribute6**<br>**extensionAttribute7**<br>**extensionAttribute8**<br>**extensionAttribute9**<br>**extensionData**<br>**folderPathname**<br>**formData**<br>**forwardingAddress**<br>**heuristics**<br>**hideDLMembership**<br>**homeMDB**<br>**homeMTA**<br>**importedFrom**<br>**internetEncoding**<br>**kMServer**<br>**language**<br>**languageCode**<br>**mailNickname**<br>**mAPIRecipient**<br>**mDBOverHardQuotaLimit**<br>**mDBOverQuotaLimit** | **mDBStorageQuota**<br>**mDBUseDefaults**<br>**msExchADCGlobalNames**<br>**msExchALObjectVersion**<br>**msExchAssistantName**<br>**msExchConferenceMailboxBL**<br>**msExchControllingZone**<br>**msExchCustomProxyAddresses**<br>**msExchELCExpirySuspensionEnd**<br>**msExchELCExpirySuspensionStart**<br>**msExchELCMailboxFlags**<br>**msExchExpansionServerName**<br>**msExchExternalOOFOptions**<br>**msExchFBURL**<br>**msExchHideFromAddressLists**<br>**msExchHomeServerName**<br>**msExchIMACL**<br>**msExchIMAddress**<br>**msExchIMAPOWAURLPrefixOverride**<br>**msExchIMMetaPhysicalURL**<br>**msExchIMPhysicalURL**<br>**msExchIMVirtualServer**<br>**msExchInconsistentState**<br>**msExchLabeledURI**<br>**msExchMailboxFolderSet**<br>**msExchMailboxGuid**<br>**msExchMailboxOABVirtualDirectoriesLink**<br>**msExchMailboxSecurityDescriptor**<br>**msExchMailboxTemplateLink**<br>**msExchMailboxUrl**<br>**msExchMasterAccountHistory**<br>**msExchMasterAccountSid**<br>**msExchMaxBlockedSenders**<br>**msExchMaxSafeSenders**<br>**msExchMDBRulesQuota**<br>**msExchMessageHygieneSCLJunkThreshold**<br>**msExchMobileAllowedDeviceIDs**<br>**msExchMobileDebugLogging**<br>**msExchMobileMailboxFlags**<br>**msExchMobileMailboxPolicyLink**<br>**msExchOmaAdminExtendedSettings**<br>**msExchOmaAdminWirelessEnable**<br>**msExchOriginatingForest**<br>**msExchPfRootUrl**<br>**msExchPFTreeType**<br>**msExchPoliciesExcluded**<br>**msExchPoliciesIncluded**<br>**msExchPolicyEnabled**<br>**msExchPolicyOptionList**<br>**msExchPreviousAccountSid**<br>**msExchProxyCustomProxy**<br>**msExchPurportedSearchUI** | **msExchQueryBaseDN**<br>**msExchQueryFilterMetadata**<br>**msExchRecipientDisplayType**<br>**msExchRecipientTypeDetails**<br>**msExchRecipLimit**<br>**msExchRequireAuthToSendTo**<br>**msExchResourceCapacity**<br>**msExchResourceDisplay**<br>**msExchResourceGUID**<br>**msExchResourceMetaData**<br>**msExchResourceProperties**<br>**msExchResourceSearchProperties**<br>**msExchServerAdminDelegationBL**<br>**msExchTUIPassword**<br>**msExchTUISpeed**<br>**msExchTUIVolume**<br>**msExchUMAudioCodec**<br>**msExchUMDtmfMap**<br>**msExchUMEnabledFlags**<br>**msExchUMFaxId**<br>**msExchUMListInDirectorySearch**<br>**msExchUMMaxGreetingDuration**<br>**msExchUMOperatorNumber**<br>**msExchUMPinPolicyAccountLockoutFailures**<br>**msExchUMPinPolicyDisallowCommonPatterns**<br>**msExchUMPinPolicyExpiryDays**<br>**msExchUMPinPolicyMinPasswordLength**<br>**msExchUMRecipientDialPlanLink**<br>**msExchUMServerWritableFlags**<br>**msExchUMSpokenName**<br>**msExchUMTemplateLink**<br>**msExchUnmergedAttsPt**<br>**msExchUseOAB**<br>**msExchUserAccountControl**<br>**msExchUserCulture**<br>**msExchVersion**<br>**msExchVoiceMailboxID**<br>**oOFReplyToOriginator**<br>**pOPCharacterSet**<br>**pOPContentFormat**<br>**protocolSettings**<br>**publicDelegatesBL**<br>**replicatedObjectVersion**<br>**replicationSensitivity**<br>**replicationSignature**<br>**reportToOriginator**<br>**reportToOwner**<br>**securityProtocol**<br>**submissionContLength**<br>**supportedAlgorithms**<br>**targetAddress**<br>**telephoneAssistant**<br>**unauthOrig**<br>**unauthOrigBL**<br>**unmergedAtts** |

The Exchange Personal Information property set includes the attributes that are listed in the following table. To make sure that ordinary users cannot retrieve the data that is stored in these attributes, the attributes are put into a separate property set where Authenticated Users are not assigned read access.

### Exchange Personal Information property set

**msExchMessageHygieneFlags**
**msExchMessageHygieneSCLDeleteThreshold**
**msExchMessageHygieneSCLQuarantineThreshold**
**msExchMessageHygieneSCLRejectThreshold**
**msExchSafeRecipientsHash**
**msExchSafeSendersHash**
**msExchUMPinChecksum**
![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]] For More Information

For more information, see the following topics:

* [Preparing Legacy Exchange Permissions](http://technet.microsoft.com/en-us/library/aa997914.aspx)
* [Exchange 2007 Permissions: Frequently Asked Questions](http://technet.microsoft.com/en-us/library/bb310792.aspx)
* [Permission Considerations](http://technet.microsoft.com/en-us/library/aa996881.aspx)

Tags [![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]]
Community Content   [![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCSection/resources/cchelp.htm)

|     |     |     |
| --- | --- | --- |
|     | [![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]]](http://technet.microsoft.com/en-us/library/community-edits.rss?topic=bb310768\|en-us\|80)  Annotations |     |

|     |     |     |
| --- | --- | --- |
|     |     | \|  |

Tags [![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]]

|     |     |
| --- | --- |
| © 2009 Microsoft Corporation. All rights reserved. [Terms of Use](http://www.microsoft.com/info/cpyright.mspx)  \|  [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx)  \|  [Privacy Statement](http://www.microsoft.com/info/privacy.mspx) | [![[./_resources/Property_Sets_in_Exchange_2007.resources/clear.gif]]](http://www.microsoft.com/) |

![[./_resources/Property_Sets_in_Exchange_2007.resources/trans_pixel.mozilla%3aen-US%3aofficial%26client%3dfirefox-a]]
![[./_resources/Property_Sets_in_Exchange_2007.resources/nojavascript&WT.js=No]]
