12/21/2023 9:10:43 AM


userdn in ldap:
```

	<do-set-local-variable name="userDN" notrace="true" scope="policy">
		<arg-string>
			<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
				<token-xpath expression="query:readObject($srcQueryProcessor, '', 'services\saIDMTemp', '', '')/@qualified-src-dn"/>
			</token-parse-dn>
		</arg-string>
	</do-set-local-variable>
```


12/13/2023 3:45:13 PM

This code is for setting memberQueryURL:

				<definition display-name="Ldap Server Name or IP address" hide="true" name="gcvServiceHost" type="string">
					<description>When using LDAP to access the tree, populate this field if desired.  Leave it blank if using dynamic host resolution, if the driver set is attached to a single server.</description>
					<value/>
				</definition>

				<definition critical-change="true" display-name="LDAP: Use SSL?" name="gcvUseSSL" type="boolean">
					<description>True if SSL should be used.  IP and port are chosen dynamically. This is for all internal LDAP connections made by drivers to update items directly in the tree.</description>
					<value>true</value>
				</definition>


				<definition display-name="Ldap Server port" hide="true" name="gcvServicePort" type="string">
					<description>When Ldap server name or IP is populated, add the port here (Example: 389 or 636)</description>
					<value/>
				</definition>


(note: drvservicehost . .should be set by gettin glocal ip . .may be available in a single IP address)

						<do-set-local-variable name="drvServiceHost" scope="driver">
							<arg-string>
								<token-global-variable name="gcvServiceHost"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="drvServicePort" scope="driver">
							<arg-string>
								<token-global-variable name="gcvServicePort"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="drvHostPort" scope="driver">
							<arg-string>
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve">:</token-text>
								<token-local-variable name="drvServicePort"/>
							</arg-string>
						</do-set-local-variable>


<do-if>
							<arg-conditions>
								<and>
									<if-global-variable mode="nocase" name="gcvUseSSL" op="equal">true</if-global-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvProtocol" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldaps:</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
							<arg-actions>
								<do-set-local-variable name="lvProtocol" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap:</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>


If needed, set job rights . .however, may just read members off of local job object as a dynamicGroupAux!

 <rule name="su-SetJobRights">
            <policy>
				<rule>
					<description>Setup variables.</description>
					<conditions/>
					<actions>
						<do-set-local-variable name="lvPrivilegeRead" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">2</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="lvPrivilegeWrite" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">4</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="lvPrivilegeReadWriteCompare" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">7</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="lvPrivilegeReadWriteCompareInherited" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">71</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable disabled="true" name="lvPrivilegeSupervisor" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">16</token-text>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>



<do-set-local-variable name="lvModifyFilterResult" scope="policy">
	<arg-string>
		<token-xpath expression="es:ldapModifyAttr($drvHostPort, '~gcvUseSSL~', $lvServiceAccountLdapDn, $driver.serviceaccount.password, $lvServiceGroupLdapDn, 'memberQueryURL', 'replace', $lvLdapFilter)"/>
	</arg-string>
</do-set-local-variable>

						<actions>
								<do-set-local-variable name="lvModifyFilterResult" scope="policy">
									<arg-string>
										<token-xpath expression="es:ldapModifyAttr($drvHostPort, '~gcvUseSSL~', $lvServiceAccountLdapDn, $driver.serviceaccount.password, $lvServiceGroupLdapDn, 'memberQueryURL', 'replace', $lvLdapFilter)"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">DEBUG: lvModifyFilterResult: '</token-text>
										<token-local-variable name="lvModifyFilterResult"/>
										<token-text xml:space="preserve">'</token-text>
									</arg-string>
								</do-trace-message>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="nocase" name="lvModifyFilterResult" op="not-equal">success</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lvErrorMsg" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">Update of service group filter failed: </token-text>
												<token-local-variable name="lvModifyFilterResult"/>
											</arg-string>
										</do-set-local-variable>
										<do-trace-message level="1">
											<arg-string>
												<token-text xml:space="preserve">ERROR: </token-text>
												<token-local-variable name="lvErrorMsg"/>
											</arg-string>
										</do-trace-message>
										<do-status level="fatal">
											<arg-string>
												<token-local-variable name="lvErrorMsg"/>
											</arg-string>
										</do-status>
									</arg-actions>
								</do-if>



service driver:

<?xml version="1.0" encoding="UTF-8"?><driver-configuration dn="cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" driver-set-dn="cn=Driver Set,ou=IDM,o=servIces" name="Service-Driver">

	<attributes>
		<configuration-manifest>
			<manifest name="Generic Null">
				<health-config>
					<green>
						<and>
							<and>
								<driver-state state="running"/>
								<in-cache-overflow state="false"/>
								<unprocessed-size op="lt" value="2000000"/>
							</and>
							<or>
								<transactions op="gt" over-last="2" source="publisher-reported-events" value="0"/>
								<sample-history minutes="2" op="lt"/>
							</or>
						</and>
						<actions>
							<generate-event id="1230" level="log-info">
								<event-arguments>
									<event-argument name="value" value="0"/>
									<event-argument name="value3" value="1"/>
								</event-arguments>
							</generate-event>
						</actions>
					</green>
					<yellow>
						<and>
							<and>
								<driver-state state="running"/>
								<unprocessed-size op="lt" value="5000000"/>
							</and>
							<or>
								<transactions op="gt" over-last="20" source="publisher-reported-events" value="0"/>
								<sample-history minutes="20" op="lt"/>
							</or>
						</and>
						<actions>
							<generate-event id="1230" level="log-info">
								<event-arguments>
									<event-argument name="value" value="1"/>
									<event-argument name="value3" value="1"/>
								</event-arguments>
							</generate-event>
						</actions>
					</yellow>
					<red>
						<actions>
							<generate-event id="1230" level="log-info">
								<event-arguments>
									<event-argument name="value" value="3"/>
									<event-argument name="value3" value="1"/>
								</event-arguments>
							</generate-event>
						</actions>
					</red>
				</health-config>
			</manifest>
		</configuration-manifest>
		<driver-filter-xml>
			<filter>
				<filter-class class-name="abcLicence" publisher="ignore" publisher-create-homedir="false" publisher-track-template-member="false" subscriber="sync">
					<?comment Added to set abcIDVCreateDate.?>
					<filter-attr attr-name="abcClassification" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcHasOutstandingProvisos" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcIsValid" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive. - Disabled currently. Not added until ECR 169?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntitiesAndLocations" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcPermittedLegalEntities" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcPermittedWorkingLocations" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
				</filter-class>
				<filter-class class-name="dynamicGroup" publisher="ignore" publisher-create-homedir="true" publisher-track-template-member="true" subscriber="sync">
					<filter-attr attr-name="memberQuery" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment IN the filter to help rebuild static memberQueryURL values; not used otherwise.?>
					</filter-attr>
				</filter-class>
				<filter-class class-name="User" publisher="ignore" publisher-create-homedir="false" publisher-track-template-member="false" subscriber="sync">
					<?comment In the filter to watch for and update user based attributes as needed.?>
					<filter-attr attr-name="abcBusLevel1Code" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel1CodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel1CodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel1Name" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel1NamePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel1NameSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel2Code" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel2CodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel2CodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel2Name" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel2NamePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel2NameSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel3Code" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel3CodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel3CodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel3Name" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel3NamePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcBusLevel3NameSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcCompanyEndDate" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Allows updates for abcContractLength, EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcCompanyStartDate" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Allows updates for abcContractLength, EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcContractLength" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Source for abcRegularEmployee.?>
					</filter-attr>
					<filter-attr attr-name="abcContractType" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Source for abcRegularEmployee, EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptCode" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptCodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptCodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel1Code" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel1CodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel1CodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel1Description" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel1DescriptionPri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel1DescriptionSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel2Code" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel2CodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel2CodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel2Description" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel2DescriptionPri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel2DescriptionSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel3Code" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel3CodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel3CodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel3Description" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel3DescriptionPri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptLevel3DescriptionSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptName" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptNamePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDeptNameSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcDirectionAndControl" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Source for abcRegularEmployee.?>
					</filter-attr>
					<filter-attr attr-name="abcECASBU" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcEndDateSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcEnterpriseCode" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcEnterpriseCodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcEnterpriseCodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcEnterpriseName" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcEnterpriseNamePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcEnterpriseNameSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcFullTimeExclusive" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Source for abcRegularEmployee.?>
					</filter-attr>
					<filter-attr attr-name="abcFuseID" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Triggers a sync in the Fuse Driver.?>
					</filter-attr>
					<filter-attr attr-name="abcGCINumber" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment abcIsUserCompleted: helps to notify driver when this should be set.?>
					</filter-attr>
					<filter-attr attr-name="abcGroupCode" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcGroupCodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcGroupCodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcGroupName" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcGroupNamePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcGroupNameSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLastWorkingDay" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityCode" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityCodePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityCodeSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityCountry" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityCountryPri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityCountrySec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityName" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support, EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityNamePri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLegalEntityNameSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcLevelOfECTraining" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcManagerPri" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcManagerSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcNDASigned" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Source for abcRegularEmployee.?>
					</filter-attr>
					<filter-attr attr-name="abcOverrideLegalEntityName" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcRegularEmployee" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcRegularEmployeeEvaluated" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcSAPKSALastWorkingDay" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Handles terms for KSA-SAP people?>
					</filter-attr>
					<filter-attr attr-name="abcSAPKSAManager" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Allows manager related changes.?>
					</filter-attr>
					<filter-attr attr-name="abcSAPKSAManagerEmail" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Manager email address for abc KSA users.?>
					</filter-attr>
					<filter-attr attr-name="abcSAPKSAManagerWorkforceID" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Manager ID for KSA SAP users.?>
					</filter-attr>
					<filter-attr attr-name="abcSecurityClearance" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcSecurityClearanceLimitations" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcSFEmailAddress" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Needed for test2.5.14ManagerChangeEmail: Manager Selection Job: Change a Managers email address?>
					</filter-attr>
					<filter-attr attr-name="abcStaffingNoAccess" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Source for abcRegularEmployee.?>
					</filter-attr>
					<filter-attr attr-name="abcStaffingNoControl" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Source for abcRegularEmployee.?>
					</filter-attr>
					<filter-attr attr-name="abcStartDateSec" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Secondment support.?>
					</filter-attr>
					<filter-attr attr-name="abcSupervisorVRSID" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Supports supervisor ID changes in the system.?>
					</filter-attr>
					<filter-attr attr-name="abcTrainingAwarenessCompleted" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment abcTrainingLastCompleted: source?>
					</filter-attr>
					<filter-attr attr-name="abcTrainingEnhancedCompleted" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment abcTrainingLastCompleted: source?>
					</filter-attr>
					<filter-attr attr-name="abcTrainingLastCompleted" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
					<filter-attr attr-name="abcUserDeletionDate" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify"/>
					<filter-attr attr-name="carLicense" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Allows manual triggering of secondment attribute reprocessing: set to 'secondment'. Allows cross driver termination, set to 'terminate'.?>
					</filter-attr>
					<filter-attr attr-name="directReports" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify"/>
					<filter-attr attr-name="DirXML-Associations" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment abcIsUserCompleted: helps to notify driver when this should be set.?>
					</filter-attr>
					<filter-attr attr-name="manager" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Allows manager related changes.?>
					</filter-attr>
					<filter-attr attr-name="managerWorkforceID" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment Allows manager related changes, and secondment support.?>
					</filter-attr>
					<filter-attr attr-name="Physical Delivery Office Name" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="notify">
						<?comment EC sensitive.?>
					</filter-attr>
				</filter-class>
			</filter>
		</driver-filter-xml>
		<reciprocal-links>
			<reciprocal-links>
				<link-def attr-name="Equivalent To Me">
					<mapping dest-class="*" reciprocal-attr="Security Equals" src-class="*"/>
				</link-def>
				<link-def attr-name="Group Membership">
					<mapping dest-class="nestedGroupAux" reciprocal-attr="groupMember" src-class="Group"/>
					<mapping dest-class="nestedGroupAux" reciprocal-attr="groupMember" src-class="nestedGroupAux"/>
					<mapping dest-class="*" reciprocal-attr="Member" src-class="*"/>
				</link-def>
				<link-def attr-name="groupMember">
					<mapping dest-class="*" reciprocal-attr="Group Membership" src-class="nestedGroupAux"/>
				</link-def>
				<link-def attr-name="Member">
					<mapping dest-class="*" reciprocal-attr="Group Membership" src-class="*"/>
				</link-def>
				<link-def attr-name="Security Equals">
					<mapping dest-class="*" reciprocal-attr="Equivalent To Me" src-class="*"/>
				</link-def>
				<link-def attr-name="directReports">
					<mapping dest-class="User" reciprocal-attr="manager" src-class="User"/>
				</link-def>
				<link-def attr-name="manager">
					<mapping dest-class="User" reciprocal-attr="directReports" src-class="User"/>
				</link-def>
				<link-def attr-name="abcSAPKSADirectReports">
					<mapping dest-class="abcSAPKSA" reciprocal-attr="abcSAPKSAManager" src-class="abcSAPKSA"/>
				</link-def>
				<link-def attr-name="abcSAPKSAManager">
					<mapping dest-class="abcSAPKSA" reciprocal-attr="abcSAPKSADirectReports" src-class="abcSAPKSA"/>
				</link-def>
			</reciprocal-links>
		</reciprocal-links>
		<driver-image>R0lGODlhYgBPAOZ/AJWp2ank/5TDZJ1yk0u58aTZ+5bY/omFi1Z4ikhJS2Fme7a1tjZabI246Irb/orG9hRwrPT09Pv7+2bJ+FbG/Dw8Pk2q2my65U2QtITc/3WYqXfK8yeNy6220qKXxaioqofI6mXR/wmO2Fmaw9Dw/9nZ2XPD64nV/tLS0sTFxWOp1OXl5TuDrpzh/4jQ+0VpfpyezTut6lWCl7LB27GItKbG5+vs7VJMY5TF4nza/4air2/U/qiUv6yOvDlui2CizG5cb+T1/XB2e5iUmbHI55TA1pvK9HvU/nCftqG74GXA7Lzq/mey3qbN8QB2yx09TR59uo7V9rWXtqt8pIPU+J+ps3e42neEm7aBrTFBIXXY/wQEBF+btZvQ6ozO6wxlnzej31FrOAdJdItphrSWrXzP96zS87LU6863yebd49rL1ioqKazb+i6Z1xgfEO7v8NfX2GNjYuz5/83U19PBzN3c3ff394F1lObn6Ojl59rQ1nKvzHiozh0dHf///////yH5abcAAH8ALAAAAABiAE8AAAf/gH+Cg4SFhoeIiYqLiSspB3EJa2sVCUIfJXaMm5ydnpsoQmtbW32UFWt9pFtxC5+vsLGGb0Kqa5coKxF2KygLBwmkCSmyxcaLKBWlQyt+zs/QbwvKfR/H19gpqnE20N7eEkOkQ9jlsSWjQ9/r3tpbrubxmxLBB942KR8HQkIHHylvvC0ohUKewUTiEkiA9qjfgYcQh6TwllDTwYuC7PTpM9FZhA8Oh3wYSXLIgQURntF7hxHjAVbQQB4QuSBFChQobC74MGQBwy0JLBp6FCmB0aNIkypdyrSpU1MlnqXo96EmihIrsq4okXMnimd2gtUxVCKOqlIb06pdy7at27dw//tU6OjnjcmqV1e8icA3wputvlA+e2mN0AJbQ0rY6Mu4sePHkCNLZsxw5oJcb+xI2MzZzl9fUZ0NjBNh0MAtBxayW826tWvX+v6VyKwamgTPJWw+Q1cBjqASqny+Hk68+GZoQ3rm0szudi+6b1ARkyAEteutJbJr3869u/fv3LHDwZkHmr8Us2uvk/AmN1hUBVdsWdONXYorCBJUQMC/v///ACog4IAEDgjEgQgmiCAZyP2ji3rfSBBBL89EIN0fH1hnX39GyeDhhyACKKIClRRIoIIoAjFGbSPlEgGE4EwYmh82XFidcN/MwZ8MGjDAABJABinkkEBqYKSRCFSQBf8lVzTZ5B1QRgnlGFRWSWVKon3gIoy2TdiMM8DN9YdZM3qjAQIycLEHAi944eabb4Ig55xzNmAnEgmEIYAAWSQAAAyAeiAoDzz0YCgNiGKh6BQDpPEMCg6+yJqEK9Tnx0DD/JFAH19+gyYXVnghAwIOlFpqFKimqqoLrD7wAB8M6LknnzcA8GeggxbaA6I0KIrFAHSAVVN6k/5lx2CoEbNpp9BEgOYeIFAxqqnUUnvCtaxmu0ess86aRa23wpDroYkuSkZtJVy2AnPr8RKQMzaMUpWmnK7zBgKgUpHBqBn0W62112JrBbfdegsuoOJ6QCi5vWIxxRSOPooebRF6Zqn/HxkmUBO9zD5jA74mUJEDv/36+68DAZ8wsKwFe+tnuIMaumvDjJKBpR92cKWXZpxt5tkbtUUwij9jLbvOx1yYcMTICJRs8skor9xyy33aivC4Mys6wABoeIOdXoy9sZg3cQC1ADxGf4O00lqMmkMOTmfggJrVSj011S9frTAQd/Dq8NZq2GaHDVpVuhiEL61R1VgcHw2yFm0j8Hbc+z7BABdUOGD33XhbjSsQN9wwxhS9DjDGAIEb91IfPREjSNr3gLxD2z748MTtuOduORcEcz51FhWELvzwoQPxsOljoHFzayiU3ccBNgkFOzQfY6DEDjv8gAEGPnbfveUMvMCF/wxZ+H63Gy+YSPwYiDJKpRR1HLtaCbXM19MCbxAyvccIWI/97JB7G9z6JYMXiC9zDmBA+czXLTcwoAG28pwCQncHmbUPeaeTgh7ysLwIlK0UcahKCkqjv3qpzQfWC8H/IKcFAfYLAz/QF7UUyMA9oc9OEIwgDBRwh5iRy31jUNEYhlCH2qwuAVW5jAQMsT94oVAJIVAh9ljowrjNcIG+Q98DcJhDzyVMVzM7HvIOgAdomKV1KMjfIZpIoydGUYoAbOHkrGgqGnJOi67iYgRhpjAL0oxRB3iXM8xyGc0kgo02QCEBJvDGFQZwjk674vle4KpK6lGHuAIjr3gVSDP24f8yi0CkD1hgAQpQ4I1SpCIkSybJgqGvVZXcIg73qLeFzYwGUiBDJ59ByIIoQpSkNOUpo+hIOQ4wknXEogDQd4JsxVKWdqJlJmVmKClIYQiC9EMvQ2nCe4zSAgQQZiOn+MhjsjKZYQgDM7EFS0vOEpNfBKM1selJUP6ym9T7JgHCacpxxrGKyCwVA9ywzoA5M5aX9GKuCMWDa2Zzm/fsmBNZAIZ98nOYcFSlOZ+WwBeUKmXNbGce36lQhTHUofX05SHx6bFRgiEGFhUnMclpTMqZCk2mAmm2XIBQkvLRpDygJy8/qVJEIJIBLGhDDGC6T5lmtJw2dcALZAAwgx50pNH/hKegTCrUQRKVmxKlEQN80IaXLrWp/ZzpP1fpr6lWK2U75ak7sxouXHmgq9r8akSPNlYOgMGsTHVqMQFaMre+1apXhWYX6yoovEJ0pWF9w1RVcIHKmsAEGyhDGahwAmq14LOgbUEARhuAAhShCBrQQRFwQNrWkpYNbChAbM1AWzM0gQi4JcIMZtCB3vb2Aw/VK2TtNVkmWBazmaUCAksVWtC6VgdH0kAXXOta2FoXtrU1Q25nkATf/ja49hzuNyQrgx8wwbgXuOwGkttZUzX3s63twpF0QN36XpcNtW1CDWqQhP56twMfWN5jjcpSZ5DXvOc97no3217mvre10NUA/2vrS13rFqAATWiCEfbbX//udgYfkJ9Xw0vgyE71BypQQYLTi9zNIrAFJFhCaElAAtLKl76kXYIc5BAAEsihxqS9sJCNQOQN7ze3up1BFUScVxKvscB1meoIUqxi9Ko3uZkLgDMKAFpnEIC0qm3tEpwBBhL4oQsmGK2QC2CACzchu9rF7YeXnFKwElcGU6byiq/sYi37QQ5K+KwzRCDaAOCg0KMdsx9EYGYQEAC0a76wdWmr3w73ls5DdTIToSxZBIzgByhO8Z5bTAU/+2EJVGjBoGEshyWMdscBUDSj/eBoRL8WthgmMg6y2gElM3nATzaxp0Ed6iorOLMFgEagV/8tBz8oodRklnWjlVDfCxuAyFjt724xPeKiBpu4wwY1lY3N4vUm2w9e+PMEmO0HC5RB1YuWNq2p3Vo2GyAK7SzybXHL7SZ7e9PC5gKxi01u9Rpg0EHwAxtWnXALbADeIpA3CKj9WQNYPGCosviFa3sGfv9auCUGt8AHPu5RH9wPToD3oB2QcBBsQNYSf7TFZz5zSV/Xtvv1dZ33Ot4XhJvkot5zF5zhhDIoetEsVzgBzByEiA+60QSgOXxda21d46C//QY2wNexgrFiYASfBnqV0Tt0lG/ABQlHuqmdAQIR+HnWtbZ1a1tgcbluEQf7zTrIvz1er4M97MQuuXHTbfb/MpxbBKUqANO9IIIYvB3q9aV73fOd4TPoXdOFYOMb/P73gYs76BewgBOckNkyEEAEIgjY6VEfg1JtAPUBUIII6B2Ail88ZTWX7Rks/3HMlzCynP874D9fcOQuWLNHSH57DTB10oLW4ii71sxbcOEATHr3l/935jkdfOGL/bzorawS+HwEBDL/vXT/l8WbH+QLd6EGRMi+nfuOwu19XfjDJz74L6AEJSx4uf8CUsvHfqNVcVHgBSCAA3gnfzznDW8gBmLwBRIogRBQgRYIBRiYgRjIARzQBmXFVBclTCIogsR0BCaTATlwBDswARNAARbFBFZgBUWgA72nfb+3Hk8Q/4ETSIEW2IMVmIEcWFaAZVFEiFYUwEizc0xvo4IsKIL9d1kJOIM1yE0XAw05uINY+AU+CIRBKIR/tVRgGFOnNEXJl3zYw4JoiIb/5wJuggNSuHPi9Q1XmIUTeIEaCAUc2IUe+IUxhYT/8z9pmIalp1yq4gVu+IaZZoODYBZfwQ46mIVbeIcb2IV82FSBeIkseHzK1VmFGIVF0AHfsCm+Nwi1gCProIM+2IOSyIUd+FcWAE4E0H+yOAGyeFmkRgWqkipuIieH2AEdIwEbsQC+oQgZYg+sEQEskIzbk4zM2IzKaH9g94rSaAEJpgT8Z4vqJSdwso1vooCHOANlJBBbcMwDC8A4jbARVdgcxbGO7BgNTMZLqLEANrAI1KEh7XiP+EgcA/FJKSAUiYAOW/AB+TiQBPkNKDA0C1ACnHAYWyAEYVWQEPkab/AB21ATS7SQo7AGJ5ELhdORHvmRIBmSIjmShZMbQxAMrFATJNQJEYACqxAXMBmTMjmTaSEM0DNCsSAhQqAfFdCTPvmTQBmUQjmURFmURZkAcdA6K3CRxkApJQAHUBmVUjmVVFmVVnmVWGmVWAE0LdGVXgkLPROWYjmWZFmWZnmWYRkLgQAAOw==</driver-image>
		<log-events inherit="true"/>
		<trace-file value="/idm/log/drivers/servicedriver.log"/>
		<trace-size-limit value="1000000"/>
		<trace-level value="6"/>
		<driver-trace-level inherit="true"/>
		<log-limit inherit="true"/>
		<log-events-type inherit="true"/>
		<java-module value="com.novell.nds.dirxml.driver.nulldriver.NullDriverShim"/>
		<trace-name value="service"/>
		<policy-linkage>
			<linkage-item dn="cn=Tools,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="0" policy-set="3" policy-set-name="ECMAScript"/>
			<linkage-item dn="cn=WebLibrary,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="1" policy-set="3" policy-set-name="ECMAScript"/>
			<linkage-item dn="cn=lib-DVE-scripts,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="2" policy-set="3" policy-set-name="ECMAScript"/>
			<linkage-item dn="cn=WriteDriverRevOnEvent,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="0" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=lib-UserType,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="1" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-DirectReportInitilization,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="2" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-WebAppObjectDeletedNotification,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="3" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-VetoEvents,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="4" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-PrepareEvent,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="5" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-DefaultAttrs,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="6" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-Job-UpdateTables,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="7" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-Jobs,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="8" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-JobsFinal,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="9" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-JobsSetUserType,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="10" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-SecondmentSwitch,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="11" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-UserTermination,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="12" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-UserTermination-KSA-SAP,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="13" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-SyncFuse,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="14" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-ManageIsUserComplete,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="15" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-ManagerTasks,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="16" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-ManagerTasks-KSA-SAP,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="17" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-ComputedAttributes,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="18" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-RegularEmployeeFlagProcessing,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="19" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-DACUserTerminated,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="20" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-EnforceValidUserDeletionDates,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="21" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-SetOverrideLegalEntityAttrs,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="22" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-WebAppNotificationObjectProcessing,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="23" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-MigrateGreenlnkAttrs,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="24" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=sub-etp-StopProcessing,cn=Subscriber,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="25" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=WriteDriverRevOnEvent,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="0" policy-set="5" policy-set-name="Publisher Event"/>
			<linkage-item dn="cn=su-DeriveHost,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="0" policy-set="15" policy-set-name="Startup"/>
			<linkage-item dn="cn=lib-InitializeCounter,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="1" policy-set="15" policy-set-name="Startup"/>
			<linkage-item dn="cn=su-SetupDynamicComponents,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="2" policy-set="15" policy-set-name="Startup"/>
			<linkage-item dn="cn=su-SetJobRights,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="3" policy-set="15" policy-set-name="Startup"/>
			<linkage-item dn="cn=su-UpdateJobs,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces" order="4" policy-set="15" policy-set-name="Startup"/>
		</policy-linkage>
		<driver-cache-limit value="0"/>
		<shim-auth-password-query/>
		<driver-password-query/>
		<driver-start-option no-resync="true" value="2"/>
		<shim-config-info-xml>
			<driver-config name="Null Driver">
				<publisher-options>
					<configuration-values>
						<definitions>
							<definition display-name="Publisher heartbeat interval" name="pub-heartbeat-interval" type="integer">
								<description>Configures the driver to send a periodic status message on the Publisher channel when there has been no Publisher traffic for the given number of minutes.</description>
								<value>10</value>
							</definition>
						</definitions>
					</configuration-values>
				</publisher-options>
			</driver-config>
		</shim-config-info-xml>
		<global-engine-values>
			<configuration-values>
				<definitions>
					<definition display-name="Subscriber channel retry interval in seconds" display-name-ref="ecnm_rint" name="dirxml.engine.retry-interval" range-lo="1" type="integer">
						<description description-ref="ecds_rint">The subscriber channel retry interval controls how frequently the DirXML Engine will retry the processing of a cached transaction after the application shim's Subscriber object returns a retry status.</description>
						<value>30</value>
					</definition>
					<definition display-name="Qualified form for DN-syntax attribute values" display-name-ref="ecnm_dnvf" name="dirxml.engine.qualified-dn-values" type="boolean">
						<description description-ref="ecds_dnvf">The qualified form for DN-syntax attribute values controls whether values for DN-syntax attribute values are presented in unqualified slash form or qualified slash form. A "true" setting means the values are presented in qualified form.</description>
						<value>false</value>
					</definition>
					<definition display-name="Qualified form for rename events" display-name-ref="ecnm_refm" name="dirxml.engine.qualified-rename-values" type="boolean">
						<description description-ref="ecds_refm">The qualified form for rename events controls whether the new-name portion of rename events coming from the Identity Vault are presented to the Subscriber channel with type qualifier(s) (e.g. CN=). A "true" setting means the names are presented in qualified form.</description>
						<value>false</value>
					</definition>
					<definition display-name="Maximum eDirectory replication wait time in seconds" display-name-ref="ecnm_mrpw" name="dirxml.engine.max-replication-wait" range-lo="1" type="integer">
						<description description-ref="ecds_mrpw">The maximum eDirectory replication wait time controls the maximum time that the DirXML Engine will wait for a particular change to replicate between the local replica and a remote replica. This only affects operations where the DirXML Engine is required to contact a remote eDirectory server in the same tree to perform an operation and may need to wait until some change has replicated to or from the remote server before the operation can be completed (e.g. object moves when the DirXML server does not hold the master replica of the moved object ;file system rights operations for Users created from a template.)</description>
						<value>180</value>
					</definition>
					<definition display-name="Use non-compliant backwards-compatible mode for XSLT" display-name-ref="ecnm_xbcm" name="dirxml.engine.xslt-bc-mode" type="boolean">
						<description description-ref="ecds_xbcm">This control sets the XSLT processor used by the DirXML Engine to a backwards-compatible mode. The backwards-compatible mode causes the XSLT processor to use one or more behaviors that are not XPath 1.0 and/or XSLT 1.0 standards-compliant. This is done in the interest of backwards-compatiblity with existing DirXML stylesheets that depend on the non-standard behavior(s).

 In particular:

 The behavior of the XPath "!=" operator when one operand is a node-set and the other operand is other than a node-set is incorrect in DirXML releases up to and including DirXML 2.0 (Novell Identity Manager 2.0). This behavior has been corrected; however, the corrected behavior is disabled by default through this control in favor of backwards-compatibility with existing DirXML stylesheets.</description>
						<value>true</value>
					</definition>
					<definition display-name="Maximum application objects to migrate at once" display-name-ref="ecnm_mxappm" name="dirxml.engine.max-migrate-app-count" range-lo="1" type="integer">
						<description description-ref="ecds_mxappm">This control is used to limit the number of application objects that the DirXML Engine will request from an application during a single query that is performed as part of a "migrate objects from application" operation.

 If "java.lang.OutOfMemoryError" errors are encountered during a migrate from application operation then this number should be set lower than the default.

 Note that this control does not limit the number of application objects that can be migrated; it merely limits the "batch size".</description>
						<value>50</value>
					</definition>
					<definition display-name="Set creatorsName on objects created in Identity Vault" display-name-ref="ecnm_scrnm" name="dirxml.engine.set-creators-name" type="boolean">
						<description description-ref="ecds_scrnm">This control is used by the DirXML Engine to determine if the creatorsName attribute should be set to the DN of this driver on all objects created in the Identity Vault by this driver.

 Setting the creatorsName attribute allows for easily identifying objects created by this driver, but also carries a performance penalty. If not set, the creatorsName attribute will default to the DN of the NCP Server object that is hosting the driver.</description>
						<value>false</value>
					</definition>
					<definition display-name="Write pending associations" display-name-ref="ecnm_pass" name="dirxml.engine.use-pending-association" type="boolean">
						<description description-ref="ecds_pass">This control determines whether the DirXML Engine will write a pending association on an object during subscriber channel processing.

 Writing a pending association confers little or no benefit but does incur a performance penalty. Nevertheless, the option exists to turn it on for backward compatibility.</description>
						<value>false</value>
					</definition>
					<definition display-name="Use password event values" display-name-ref="ecnm_pevvl" name="dirxml.engine.use-password-event-values" type="boolean">
						<description description-ref="ecds_pevvl">This control determines the source of the value reported for the nspmDistributionPassword attribute for subscriber channel add and modify events.

 Setting the control to false means that the current value of nspmDistributionPassword is obtained and reported as the value of the attribute event. This means that only the current password value is available. This is the default behavior.

 Setting the control to true means that the value recorded with the eDirectory event will be decrypted and reported as the value of the attribute event. This means that both the old password value (if it exists) and the replacement password value at the time of the event are available. This is useful for synchronizing passwords to certain applications that require the old password to enable setting a new password.</description>
						<value>false</value>
					</definition>
					<definition display-name="Enable password synchronization status reporting" display-name-ref="ecnm_pss" name="dirxml.engine.pwd-sync-status" type="boolean">
						<description description-ref="ecds_pss">This control determines whether the DirXML Engine will report the status of subscriber channel password change events.

 Reporting the status of subscriber channel password change events allows applications such as the Identity Manager User Application to monitor the synchronization progress of a password change that should be synchronized to the connected application.</description>
						<value>true</value>
					</definition>
					<definition display-name="Combine values from template object with those from add operation" display-name-ref="ecnm_ctv" name="dirxml.engine.combine-template-values" type="boolean">
						<description description-ref="ecds_ctv">This control determines how the DirXML Engine will use values from a template object when the template is used to create objects in the Identity Vault. Setting the control to true causes multi-valued attribute values from the template to be used in addition to those values for the same attribute that are  specified in the add operation. Setting the control to false causes the value(s) from the template to be ignored if there are values for the same attribute specified in the add operation.</description>
						<value>true</value>
					</definition>
					<definition display-name="Allow event loopback from publisher to subscriber channel" display-name-ref="ecnm_ael" name="dirxml.engine.allow-event-loopback" type="boolean">
						<description description-ref="ecds_ael">This control determines whether the DirXML Engine will allow an event to loopback from the publisher channel of a driver to the subscriber channel of the same driver. Setting the control to false means that the loopback of the event from the publisher to the subscriber channel will not be allowed. Setting the control to true means that events would flow from the publisher channel to the subscriber channel of the same driver.  </description>
						<value>false</value>
					</definition>
					<definition display-name="Revert to calculated membership value behavior" display-name-ref="ecnm_cavl" name="dirxml.engine.use-calculated-values" type="boolean">
						<description description-ref="ecds_cavl">Prior to Identity Manager 3.6 the DirXML Engine retrieved "calculated" values for the attributes "Member" and "Group Membership". The Engine now retrieves static values. This behavior is more generally useful and makes synchronizing Nested Groups possible. Setting this control to true reverts to the pre-3.6 behavior.

 It is possible even with the post-3.6 default behavior to read the calculated values for "Member" and "Group Membership" by using the special attribute names "[pseudo].Member" and "[pseudo].Group Membership".</description>
						<value>true</value>
					</definition>
					<definition display-name="Maximum time to wait for driver shutdown  in seconds" display-name-ref="ecnm_mdst" name="dirxml.engine.max-driver-shutdown-timeout" range-hi="3600" range-lo="5" type="integer">
						<description description-ref="ecds_mdst">This control determines the maximum time in seconds for which the DirXML Engine will wait for the drivers publisher channel to shutdown. If the driver does not shutdown within the provided time value, then the driver will be terminated by the DirXML Engine.</description>
						<value>60</value>
					</definition>
					<definition display-name="Regular Expression escape meta-characters" display-name-ref="ecnm_reecn" name="dirxml.engine.reg-ex-escape-chars" type="string">
						<description description-ref="ecds_reecd">This control determines the meta-characters that will be escaped while evaluating regular expressions. If a meta-char is not present in control value then it will not be escaped during local variable expansion containing a regular expression.

 To escape all the regular expression meta-characters, "\,$,^,.,?,*,+,[,],(,),|" should be added as the value.

 If a meta-character need not be escaped, then remove it from the control value.

 The control value should be a valid comma(,) separated list, else errors may be encountered during policy evaluation.</description>
						<value xml:space="preserve">$</value>
					</definition>
					<definition display-name="Retry of Out of Band events" display-name-ref="ecnm_robe" name="dirxml.engine.retry-outofband-event" type="boolean">
						<description description-ref="ecds_robe">This control determines whether the DirXML Engine will retry an out of band event when the status is a RETRY. Setting the control to false means that the Engine will not retry the Out of Band event on a RETRY status. Setting the control to true means that the Engine will retry the Out of band event on a RETRY status.</description>
						<value>false</value>
					</definition>
					<definition display-name="Use Rhino ECMAScript engine" display-name-ref="ecnm_uree" name="dirxml.engine.rhino-ecma-engine" type="boolean">
						<description description-ref="ecds_uree">This control determines whether DirXML Engine will use the Rhino ECMAScript engine. DirXML Engine uses Rhino as the default ECMAScript engine.</description>
						<value>true</value>
					</definition>
					<definition display-name="Enable Subscriber Service Channel" display-name-ref="ecnm_essc" name="dirxml.engine.enable-subsvc-channel" type="boolean">
						<description description-ref="ecds_essc">This control determines whether the DirXML Engine will send the out of band queries in subscriber service channel. This is applicable only if the driver supports subscriber service channel.If this is set to true, Engine will send the out of band queries in subscriber service channel.</description>
						<value>false</value>
					</definition>
					<definition display-name="Ignore Entitlement Changes of other drivers" display-name-ref="ecnm_ierc" name="dirxml.engine.ignore-entitlement-change" type="boolean">
						<description description-ref="ecds_ierc">This control is used by the DirXML Engine to either ignore or process the Entitlement Changes of other drivers. If this control is set to true, the Entitlement changes of other drivers will be ignored by this driver. If this contorl is set to false, the Entitlement changes of other drivers will be cached and processed by this driver.</description>
						<value>true</value>
					</definition>
					<definition display-name="Allow Entitlement event loopback from cprs to subscriber channel" display-name-ref="ecnm_acel" name="dirxml.engine.allow-cprs-event-loopback" type="boolean">
						<description description-ref="ecds_acel">This control determines whether the DirXML Engine will allow an entitlement event generated by cprs assignment to loopback to the subscriber channel of the driver. Setting the control to false means that the loopback of the event from cprs to the subscriber channel will not be allowed.Setting the control to true means that events would flow from the cprs to the subscriber channelof the same driver. </description>
						<value>false</value>
					</definition>
					<definition display-name="Interpret Time as Signed Integer" display-name-ref="ecnm_itsi" name="dirxml.engine.interpret-time-signed" type="boolean">
						<description description-ref="ecds_itsi">This control determines whether the DirXML Engine will interpret a time value as signed or unsigned integer. If this is set to true, Engine will support time values from 1902 to 2037. If this is set to false, Engine will support time values from 1970 to 2106. </description>
						<value>true</value>
					</definition>
					<definition display-name="Optimize Modify on Publisher Merge" display-name-ref="ecnm_omom" name="dirxml.engine.optimize-modify-merge" type="boolean">
						<description description-ref="ecds_omom">This control determines whether the DirXML Engine will perform optimize modify on publisher merge. If this is set to true, Engine will perform optimize modify on Publisher Merge. </description>
						<value>true</value>
					</definition>
					<definition display-name="Remove Manual/Migrate Associations" display-name-ref="ecnm_rmma" name="dirxml.engine.remove-manual-migrate-assoc" type="boolean">
						<description description-ref="ecds_rmma">This control determines whether the DirXML Engine will remove the manual/migrate association states. If this is set to true, Engine will remove the manual/migrate association </description>
						<value>true</value>
					</definition>
				</definitions>
			</configuration-values>
		</global-engine-values>
		<global-config-values>
			<configuration-values>
				<definitions>
					<header display-name="EC Training Settings"/>
					<definition display-name="Days before Enhanced Expiration for Notification" name="DaysBeforeEnhancedExpirationForNotification" type="string">
						<description>Enter the number of days that indicate how far before the Enhanced Expiration date the notificaiton email will be sent.

Represented as a positive integer. For example the value of 21 would send the Enhanced Expiration Training Notificaiton 21 days before the expiration date.</description>
						<value>21</value>
					</definition>
					<definition display-name="Enter the EC Enhanced Training Lifetime" name="TrainingLifetimeEnhanced" type="string">
						<description>Enter the lifetime of the EC Enhanced Training in days. For example 365</description>
						<value>365</value>
					</definition>
					<definition display-name="Enter the EC Awareness Training Lifetime" name="TrainingLifetimeAwareness" type="string">
						<description>Enter the lifetime of the EC Awareness Training in days. For example 1095</description>
						<value>1094</value>
					</definition>
					<header display-name="HRDS Dynamic Table configuration"/>
					<definition critical-change="true" display-name="Driver URL: username for basic auth" name="driver.input.username" type="string">
						<description>This is the username required for HTTP basic authentication. Example: EC_Auth_Serv_TEST</description>
						<value>EC_Auth_Serv_TEST</value>
					</definition>
					<definition critical-change="true" display-name="Password for user name above" name="driver.input.password" type="password-ref">
						<description>This is the password for the user above.</description>
						<value>driver.input.password</value>
					</definition>
					<definition display-name="HTTP read timeout setting (in milliseconds)" name="driver.dynamic.hrds.timeout" type="string">
						<description>HRDS dynamic data retrieval timeout value in milliseconds (For example: 4500000 would result in a 1.25 hour timeout).</description>
						<value>30000</value>
					</definition>
					<header display-name="People Groups (Lists)"/>
					<definition critical-change="true" display-name="People List Groups OU" dn-space="dirxml" dn-type="ldap" name="PEOPLE_LISTS_OU" type="dn">
						<description>This is the groups OU for people lists. The Service Driver will search here and remove all the group memberships off a user when a abcECASBU changes.</description>
						<value>ou=Lists,o=abcS</value>
					</definition>
					<definition critical-change="true" display-name="Greenlnk Attribute Mapping Table" dn-space="dirxml" dn-type="slash" name="GreenlnkAttrMigrationTable" type="dn">
						<description/>
						<value>servIces\IDM\Driver SET\Service-Driver\GreenlnkAttrMigration</value>
					</definition>
				</definitions>
			</configuration-values>
		</global-config-values>
		<named-password-query display-name="ServiceNow Password" name="ServiceNowPassword"/>
		<named-password-query display-name="driver.input.password" name="driver.input.password"/>
		<application-schema/>

	</attributes>
	<children>
        <jobs>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-DeleteOldUsers">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvZGVmaW5pdGlvbnM+PC9jb25maWd1cmF0aW9uLXZhbHVlcz48L2pvYi1kZWZpbml0aW9uPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImRlIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkFib25uZW50ZW5rYW5hbGF1c2zDtnNlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5NaXQgZGllc2VtIEF1ZnRyYWcgd2VyZGVuIG51bGwgb2RlciBtZWhyIEF1c2zDtnNlcmRva3VtZW50ZSBhbiBkZW4gQWJvbm5lbnRlbmthbmFsIGFiZ2VzZW5kZXQuIERhYmVpIGthbm4gZXMgc2ljaCB1bSBlaW4gRG9rdW1lbnQgcHJvIE9iamVrdCBoYW5kZWxuLCBzb2Zlcm4gZWluIEJlcmVpY2ggZGVmaW5pZXJ0IHd1cmRlLCBvZGVyIHVtIGVpbiBlaW56ZWxuZXMgRG9rdW1lbnQgZsO8ciBqZWRlIEF1ZnRyYWdzYXVzZsO8aHJ1bmcuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+QXVzbMO2c2VyZG9rdW1lbnQgZsO8ciBPYmpla3RlIG9obmUgVHJlaWJlcnp1b3JkbnVuZyBhYnNlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPkF1ZnRyYWdzLUNOIGFscyBBdXNsw7ZzZXJkb2t1bWVudGJlemVpY2huZXIgdmVyd2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5XZW5uIGZlc3RnZWxlZ3QsIHdpcmQgZGVyIENOIGRlcyBBdWZ0cmFnc29iamVrdHMgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5VcnNwcnVuZ3N3ZXJ0IGRlcyBBdXNsw7ZzZXJlbGVtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+WmVpY2hlbmtldHRlLCBkaWUgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldCB3ZXJkZW4gc29sbC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZGUgZsO8ciBkYXMgQWJzZW5kZW4gdm9uIEF1c2zDtnNlcmRva3VtZW50ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+V2FydGVzY2hsYW5nZSAoQ2FjaGUgdmVyd2VuZGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+RGlyZWt0IChDYWNoZSDDvGJlcmdlaGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIHN0YXJ0ZW4sIHNvZmVybiBlciBuaWNodCBiZXJlaXRzIGzDpHVmdDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgbmFjaCBWZXJhcmJlaXRlbiB2b24gQXVzbMO2c2VybiBhbmhhbHRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZW4iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+U3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+VGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5JZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWU8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPnF1ZXVlICh1c2UgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3QgKGJ5cGFzcyBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocyk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImZyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkTDqWNsZW5jaGV1ciBkZSBjYW5hbCBhYm9ubsOpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPkNlIHRyYXZhaWwgYWRyZXNzZSB1biBvdSBwbHVzaWV1cnMgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnMgKG91IG4nZW4gc291bWV0IHBhcykgYXUgY2FuYWwgYWJvbm7DqS4gSWwgcGV1dCBlbnZveWVyIHVuIGRvY3VtZW50IHBhciBvYmpldCwgc2kgdW5lIMOpdGVuZHVlIGEgw6l0w6kgZMOpZmluaWUsIG91IHVuIHNldWwgZG9jdW1lbnQgw6AgY2hhcXVlIGV4w6ljdXRpb24uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U291bWV0dHJlIHVuIGRvY3VtZW50IGTDqWNsZW5jaGV1ciBwb3VyIGxlcyBvYmpldHMgc2FucyBhc3NvY2lhdGlvbiBkZSBwaWxvdGUgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXRpbGlzZXIgbGUgQ04gZHUgdHJhdmFpbCBjb21tZSBpZGVudGlmaWNhdGV1ciBkZSBkb2N1bWVudCBkw6ljbGVuY2hldXIgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5MZSBjYXMgw6ljaMOpYW50LCB1dGlsaXNlciBsZSBDTiBkZSBsJ29iamV0IFRyYXZhaWwgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlZhbGV1ciBzb3VyY2UgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5DaGHDrm5lIMOgIHV0aWxpc2VyIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TcOpdGhvZGUgZGUgc291bWlzc2lvbiBkZSBkb2N1bWVudHMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5maWxlIGQnYXR0ZW50ZSAodXRpbGlzZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3RlICjDqXZpdGVyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5Ew6ltYXJyZXIgbGUgcGlsb3RlIGF1IGJlc29pbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkFycsOqdGVyIGxlIHBpbG90ZSDDoCBsYSBmaW4gZHUgdHJhaXRlbWVudCBkZXMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iamEiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6LO86Kqt6ICF44OB44Oj44ON44Or44OI44Oq44KsPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuOBk+OBruOCuOODp+ODluOBr+OCvOODreOBvuOBn+OBr+ikh+aVsOOBruODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkuizvOiqreiAheODgeODo+ODjeODq+OBq+mAgeS/oeOBl+OBvuOBmeOAguOBk+OBrumAgeS/oeOBr+OCueOCs+ODvOODl+OBjOWumue+qeOBleOCjOOBpuOBhOOCi+WgtOWQiOOBr+OCquODluOCuOOCp+OCr+ODiOOBlOOBqOOBqzHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgIHjgb7jgZ/jga/lkITjgrjjg6fjg5blrp/ooYzjgavlr77jgZfjgaYx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44Go44Gq44KK44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+44OJ44Op44Kk44OQ44Gu6Zai6YCj5LuY44GR44Gq44GX44Gn44Kq44OW44K444Kn44Kv44OI44Gr5a++44GZ44KL44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+44K444On44OWQ07jgpLjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jorZjliKXlrZDjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuioreWumuOBleOCjOOBpuOBhOOCi+WgtOWQiOOAgeOCuOODp+ODluOCquODluOCuOOCp+OCr+ODiOOBrkNO44KS44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GX44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44K944O844K55YCkPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZnjgovmloflrZfliJfjgafjgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBmeOCi+OBn+OCgeOBruaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7jgq3jg6Xjg7wo44Kt44Oj44OD44K344Ol44Gu5L2/55SoKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lKOODkOOCpOODkeOCueOCreODo+ODg+OCt+ODpSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6f6KGM44GX44Gm44GE44Gq44GE5aC05ZCI44OJ44Op44Kk44OQ44KS6ZaL5aeL44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44Gu5Yem55CG44GM57WC5LqG44GX44Gf5aC05ZCI44OJ44Op44Kk44OQ44KS5YGc5q2i44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9DTiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7orqLotK3ogIXpgJrpgZPop6blj5Hlmag8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+6K+l5L2c5Lia5bCG5ZCR6K6i6LSt6ICF6YCa6YGT5o+Q5LqkIDAg5Liq5oiW5aSa5Liq6Kem5Y+R5Zmo5paH5qGj44CC5aaC5p6c5a6a5LmJ5LqG6IyD5Zu077yM5Y+v5Lul5a+55q+P5Liq5a+56LGh5o+Q5Lqk5LiA5Liq5paH5qGj77yM5Lmf5Y+v5Lul5a+55q+P5qyh5L2c5Lia6L+Q6KGM5o+Q5Lqk5LiA5Liq5paH5qGj44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5Li65rKh5pyJ6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7lsIbigJzkvZzkuJogQ07igJ3nlKjkvZzop6blj5HlmajmlofmoaPnmoTmoIfor4bnrKblkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6K6+572u77yM5bCG5oqK6K+l5L2c5Lia5a+56LGh55qEIENOIOeUqOS9nOinpuWPkeWZqOWFg+e0oOeahOKAnOa6kOKAneeJueaAp+eahOWAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinpuWPkeWZqOWFg+e0oOa6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+55So5L2c6Kem5Y+R5Zmo5YWD57Sg4oCc5rqQ4oCd54m55oCn55qE5YC855qE5a2X56ym5Liy44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7mj5DkuqTop6blj5HlmajmlofmoaPnmoTmlrnlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+6Zif5YiX77yI5L2/55So6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqXvvIjnu5Xov4fotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZCv5Yqo6amx5Yqo56iL5bqP77yI5aaC5p6c5pyq6L+Q6KGM77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6M5oiQ5a+56Kem5Y+R5Zmo55qE5aSE55CG5pe25YGc5q2i6amx5Yqo56iL5bqPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9UVyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7oqILplrHogIXpgJrpgZPop7jnmbznqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+5q2k5bel5L2c5pyD5o+Q5Lqk6Zu25YCL5Lul5LiK55qE6Ke455m85paH5Lu26Iez6KiC6Zax6ICF6YCa6YGT44CC5q2k5L2c5qWt5Y+v6IO95q+P5LiA5YCL54mp5Lu25o+Q5Lqk5LiA5Lu95paH5Lu2ICjoi6Xlt7Llrprnvqnnr4TlnI0pIOaIluWPr+iDveavj+S4gOWAi+W3peS9nOaPkOS6pOWWruS4gOS7veaWh+S7tuOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeeCuuaykuaciempheWLleeoi+W8j+mXnOiBr+eahOeJqeS7tuaPkOS6pOinuOeZvOaWh+S7tu+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB5Lul44CM5bel5L2cIENO44CNIOWBmueCuuinuOeZvOaWh+S7tuitmOWIpeeivO+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzoqK3lrprvvIzliYfoq4vku6Xlt6XkvZznianku7bnmoQgQ04g5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Ke455m85YWD57Sg5L6G5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lrZfkuLLvvIzlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuinuOeZvOaWh+S7tueahOaPkOS6pOaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7kvYfliJcgKOS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSAo5LiN5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7llZ/li5XpqYXli5XnqIvlvI8gKOiLpeacquWft+ihjCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7nlbblrozmiJDomZXnkIbop7jnmbznqIvlvI/mmYLlgZzmraLpqYXli5XnqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjwvam9iLWFnZ3JlZ2F0aW9uPg==]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-Scope"/>
					<job-scope-query job-display-name="Subscriber channel trigger" job-name="cn=Job-DeleteOldUsers,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-email-server-query job-name="cn=Job-DeleteOldUsers,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-DeleteOldUsers,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-DeleteOldUsers-Schedule">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY2hlZHVsZT0iMTUgNCAqICogKiIgc2NvcGUtcmVxdWlyZWQ9ImZhbHNlIiB0eXBlPSJqYXZhIj48ZGVzY3JpcHRpb24+eGxmaWQoam9iLWRlc2NyaXB0aW9uKVRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L2Rlc2NyaXB0aW9uPjxjb250YWlubWVudD5EaXJYTUwtRHJpdmVyPC9jb250YWlubWVudD48amF2YS1jbGFzcz5jb20ubm92ZWxsLm5kcy5kaXJ4bWwuam9iLnRyaWdnZXIuVHJpZ2dlcjwvamF2YS1jbGFzcz48Y29uZmlndXJhdGlvbi12YWx1ZXM+PGRlZmluaXRpb25zPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQocHJvY2Vzcy11bmFzc29jaWF0ZWQpU3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPyIgbmFtZT0icHJvY2Vzcy11bmFzc29jaWF0ZWQiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodXNlLWpvYi1jbilVc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj8iIG5hbWU9InVzZS1qb2ItY24iIHR5cGU9ImJvb2xlYW4iPjxkZXNjcmlwdGlvbj54bGZpZCh1c2Utam9iLWNuLWRlc2MpSWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L2Rlc2NyaXB0aW9uPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9ImZhbHNlIj48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHRyaWdnZXItc291cmNlKVRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWUiIG5hbWU9InRyaWdnZXItc291cmNlIiB0eXBlPSJzdHJpbmciPjxkZXNjcmlwdGlvbj54bGZpZCh0cmlnZ2VyLXNvdXJjZS1kZXNjKVN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPjE8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1tZXRob2QpTWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzIiBuYW1lPSJzdWJtaXQtbWV0aG9kIiB0eXBlPSJlbnVtIj48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtcXVldWUpcXVldWUgKHVzZSBjYWNoZSkiPnN1Ym1pdC1xdWV1ZTwvZW51bS1jaG9pY2U+PGVudW0tY2hvaWNlIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LWRpcmVjdClkaXJlY3QgKGJ5cGFzcyBjYWNoZSkiPnN1Ym1pdC1kaXJlY3Q8L2VudW0tY2hvaWNlPjx2YWx1ZT5zdWJtaXQtZGlyZWN0PC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InN1Ym1pdC1kaXJlY3QiPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN0YXJ0LWRyaXZlcilTdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmciIG5hbWU9InN0YXJ0LWRyaXZlciIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPmZhbHNlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InRydWUiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RvcC1kcml2ZXIpU3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocykiIG5hbWU9InN0b3AtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+dHJ1ZTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L2RlZmluaXRpb25zPjwvY29uZmlndXJhdGlvbi12YWx1ZXM+PC9qb2ItZGVmaW5pdGlvbj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJkZSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5BYm9ubmVudGVua2FuYWxhdXNsw7ZzZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+TWl0IGRpZXNlbSBBdWZ0cmFnIHdlcmRlbiBudWxsIG9kZXIgbWVociBBdXNsw7ZzZXJkb2t1bWVudGUgYW4gZGVuIEFib25uZW50ZW5rYW5hbCBhYmdlc2VuZGV0LiBEYWJlaSBrYW5uIGVzIHNpY2ggdW0gZWluIERva3VtZW50IHBybyBPYmpla3QgaGFuZGVsbiwgc29mZXJuIGVpbiBCZXJlaWNoIGRlZmluaWVydCB3dXJkZSwgb2RlciB1bSBlaW4gZWluemVsbmVzIERva3VtZW50IGbDvHIgamVkZSBBdWZ0cmFnc2F1c2bDvGhydW5nLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPkF1c2zDtnNlcmRva3VtZW50IGbDvHIgT2JqZWt0ZSBvaG5lIFRyZWliZXJ6dW9yZG51bmcgYWJzZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5BdWZ0cmFncy1DTiBhbHMgQXVzbMO2c2VyZG9rdW1lbnRiZXplaWNobmVyIHZlcndlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+V2VubiBmZXN0Z2VsZWd0LCB3aXJkIGRlciBDTiBkZXMgQXVmdHJhZ3NvYmpla3RzIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VXJzcHJ1bmdzd2VydCBkZXMgQXVzbMO2c2VyZWxlbWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlplaWNoZW5rZXR0ZSwgZGllIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQgd2VyZGVuIHNvbGwuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2RlIGbDvHIgZGFzIEFic2VuZGVuIHZvbiBBdXNsw7ZzZXJkb2t1bWVudGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPldhcnRlc2NobGFuZ2UgKENhY2hlIHZlcndlbmRlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPkRpcmVrdCAoQ2FjaGUgw7xiZXJnZWhlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBzdGFydGVuLCBzb2Zlcm4gZXIgbmljaHQgYmVyZWl0cyBsw6R1ZnQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIG5hY2ggVmVyYXJiZWl0ZW4gdm9uIEF1c2zDtnNlcm4gYW5oYWx0ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImVuIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPlN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPlRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5TdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5Vc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+SWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5UcmlnZ2VyIGVsZW1lbnQgc291cmNlIHZhbHVlPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5TdHJpbmcgdG8gdXNlIGFzIHRoZSB2YWx1ZSBmb3IgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZCBmb3Igc3VibWl0dGluZyB0cmlnZ2VyIGRvY3VtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5xdWV1ZSAodXNlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0IChieXBhc3MgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0b3AgZHJpdmVyIHdoZW4gZmluaXNoZWQgcHJvY2Vzc2luZyB0cmlnZ2VyKHMpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJmciIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5Ew6ljbGVuY2hldXIgZGUgY2FuYWwgYWJvbm7DqTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5DZSB0cmF2YWlsIGFkcmVzc2UgdW4gb3UgcGx1c2lldXJzIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzIChvdSBuJ2VuIHNvdW1ldCBwYXMpIGF1IGNhbmFsIGFib25uw6kuIElsIHBldXQgZW52b3llciB1biBkb2N1bWVudCBwYXIgb2JqZXQsIHNpIHVuZSDDqXRlbmR1ZSBhIMOpdMOpIGTDqWZpbmllLCBvdSB1biBzZXVsIGRvY3VtZW50IMOgIGNoYXF1ZSBleMOpY3V0aW9uLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlNvdW1ldHRyZSB1biBkb2N1bWVudCBkw6ljbGVuY2hldXIgcG91ciBsZXMgb2JqZXRzIHNhbnMgYXNzb2NpYXRpb24gZGUgcGlsb3RlID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlV0aWxpc2VyIGxlIENOIGR1IHRyYXZhaWwgY29tbWUgaWRlbnRpZmljYXRldXIgZGUgZG9jdW1lbnQgZMOpY2xlbmNoZXVyID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+TGUgY2FzIMOpY2jDqWFudCwgdXRpbGlzZXIgbGUgQ04gZGUgbCdvYmpldCBUcmF2YWlsIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1ci48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5WYWxldXIgc291cmNlIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+Q2hhw65uZSDDoCB1dGlsaXNlciBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk3DqXRob2RlIGRlIHNvdW1pc3Npb24gZGUgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+ZmlsZSBkJ2F0dGVudGUgKHV0aWxpc2VyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0ZSAow6l2aXRlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+RMOpbWFycmVyIGxlIHBpbG90ZSBhdSBiZXNvaW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5BcnLDqnRlciBsZSBwaWxvdGUgw6AgbGEgZmluIGR1IHRyYWl0ZW1lbnQgZGVzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImphIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuizvOiqreiAheODgeODo+ODjeODq+ODiOODquOCrDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7jgZPjga7jgrjjg6fjg5bjga/jgrzjg63jgb7jgZ/jga/opIfmlbDjga7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLos7zoqq3ogIXjg4Hjg6Pjg43jg6vjgavpgIHkv6HjgZfjgb7jgZnjgILjgZPjga7pgIHkv6Hjga/jgrnjgrPjg7zjg5fjgYzlrprnvqnjgZXjgozjgabjgYTjgovloLTlkIjjga/jgqrjg5bjgrjjgqfjgq/jg4jjgZTjgajjgasx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44CB44G+44Gf44Gv5ZCE44K444On44OW5a6f6KGM44Gr5a++44GX44GmMeOBpOOBruODieOCreODpeODoeODs+ODiOOBqOOBquOCiuOBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuODieODqeOCpOODkOOBrumWoumAo+S7mOOBkeOBquOBl+OBp+OCquODluOCuOOCp+OCr+ODiOOBq+WvvuOBmeOCi+ODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuOCuOODp+ODlkNO44KS44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI6K2Y5Yil5a2Q44Go44GX44Gm5L2/55So44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7oqK3lrprjgZXjgozjgabjgYTjgovloLTlkIjjgIHjgrjjg6fjg5bjgqrjg5bjgrjjgqfjgq/jg4jjga5DTuOCkuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOCveODvOOCueWApDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GZ44KL5paH5a2X5YiX44Gn44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZnjgovjgZ/jgoHjga7mlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+44Kt44Ol44O8KOOCreODo+ODg+OCt+ODpeOBruS9v+eUqCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSjjg5DjgqTjg5Hjgrnjgq3jg6Pjg4Pjgrfjg6UpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWun+ihjOOBl+OBpuOBhOOBquOBhOWgtOWQiOODieODqeOCpOODkOOCkumWi+Wni+OBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOOBruWHpueQhuOBjOe1guS6huOBl+OBn+WgtOWQiOODieODqeOCpOODkOOCkuWBnOatouOBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfQ04iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6K6i6LSt6ICF6YCa6YGT6Kem5Y+R5ZmoPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuivpeS9nOS4muWwhuWQkeiuoui0reiAhemAmumBk+aPkOS6pCAwIOS4quaIluWkmuS4quinpuWPkeWZqOaWh+aho+OAguWmguaenOWumuS5ieS6huiMg+WbtO+8jOWPr+S7peWvueavj+S4quWvueixoeaPkOS6pOS4gOS4quaWh+aho++8jOS5n+WPr+S7peWvueavj+asoeS9nOS4mui/kOihjOaPkOS6pOS4gOS4quaWh+aho+OAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuS4uuayoeaciempseWKqOeoi+W6j+WFs+iBlOeahOWvueixoeaPkOS6pOinpuWPkeWZqOaWh+aho+WQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5bCG4oCc5L2c5LiaIENO4oCd55So5L2c6Kem5Y+R5Zmo5paH5qGj55qE5qCH6K+G56ym5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOiuvue9ru+8jOWwhuaKiuivpeS9nOS4muWvueixoeeahCBDTiDnlKjkvZzop6blj5HlmajlhYPntKDnmoTigJzmupDigJ3nibnmgKfnmoTlgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op6blj5HlmajlhYPntKDmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPueUqOS9nOinpuWPkeWZqOWFg+e0oOKAnOa6kOKAneeJueaAp+eahOWAvOeahOWtl+espuS4suOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj55qE5pa55byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPumYn+WIl++8iOS9v+eUqOi2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6l77yI57uV6L+H6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWQr+WKqOmpseWKqOeoi+W6j++8iOWmguaenOacqui/kOihjO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWujOaIkOWvueinpuWPkeWZqOeahOWkhOeQhuaXtuWBnOatoumpseWKqOeoi+W6jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfVFciIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6KiC6Zax6ICF6YCa6YGT6Ke455m856iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuatpOW3peS9nOacg+aPkOS6pOmbtuWAi+S7peS4iueahOinuOeZvOaWh+S7tuiHs+iogumWseiAhemAmumBk+OAguatpOS9nOalreWPr+iDveavj+S4gOWAi+eJqeS7tuaPkOS6pOS4gOS7veaWh+S7tiAo6Iul5bey5a6a576p56+E5ZyNKSDmiJblj6/og73mr4/kuIDlgIvlt6XkvZzmj5DkuqTllq7kuIDku73mlofku7bjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHngrrmspLmnInpqYXli5XnqIvlvI/pl5zoga/nmoTnianku7bmj5DkuqTop7jnmbzmlofku7bvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeS7peOAjOW3peS9nCBDTuOAjSDlgZrngrrop7jnmbzmlofku7borZjliKXnorzvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6Kit5a6a77yM5YmH6KuL5Lul5bel5L2c54mp5Lu255qEIENOIOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinuOeZvOWFg+e0oOS+hua6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+5a2X5Liy77yM5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzmlofku7bnmoTmj5DkuqTmlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+5L2H5YiXICjkvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUgKOS4jeS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZWf5YuV6amF5YuV56iL5byPICjoi6XmnKrln7fooYwpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+55W25a6M5oiQ6JmV55CG6Ke455m856iL5byP5pmC5YGc5q2i6amF5YuV56iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48L2pvYi1hZ2dyZWdhdGlvbj4=]]></ds-value>
					</ds-attribute>
					<job-email-server-query job-name="cn=Job-DeleteOldUsers-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-DeleteOldUsers-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-ECTrainingExpires">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT5mYWxzZTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L2RlZmluaXRpb25zPjwvY29uZmlndXJhdGlvbi12YWx1ZXM+PC9qb2ItZGVmaW5pdGlvbj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJkZSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5BYm9ubmVudGVua2FuYWxhdXNsw7ZzZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+TWl0IGRpZXNlbSBBdWZ0cmFnIHdlcmRlbiBudWxsIG9kZXIgbWVociBBdXNsw7ZzZXJkb2t1bWVudGUgYW4gZGVuIEFib25uZW50ZW5rYW5hbCBhYmdlc2VuZGV0LiBEYWJlaSBrYW5uIGVzIHNpY2ggdW0gZWluIERva3VtZW50IHBybyBPYmpla3QgaGFuZGVsbiwgc29mZXJuIGVpbiBCZXJlaWNoIGRlZmluaWVydCB3dXJkZSwgb2RlciB1bSBlaW4gZWluemVsbmVzIERva3VtZW50IGbDvHIgamVkZSBBdWZ0cmFnc2F1c2bDvGhydW5nLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPkF1c2zDtnNlcmRva3VtZW50IGbDvHIgT2JqZWt0ZSBvaG5lIFRyZWliZXJ6dW9yZG51bmcgYWJzZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5BdWZ0cmFncy1DTiBhbHMgQXVzbMO2c2VyZG9rdW1lbnRiZXplaWNobmVyIHZlcndlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+V2VubiBmZXN0Z2VsZWd0LCB3aXJkIGRlciBDTiBkZXMgQXVmdHJhZ3NvYmpla3RzIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VXJzcHJ1bmdzd2VydCBkZXMgQXVzbMO2c2VyZWxlbWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlplaWNoZW5rZXR0ZSwgZGllIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQgd2VyZGVuIHNvbGwuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2RlIGbDvHIgZGFzIEFic2VuZGVuIHZvbiBBdXNsw7ZzZXJkb2t1bWVudGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPldhcnRlc2NobGFuZ2UgKENhY2hlIHZlcndlbmRlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPkRpcmVrdCAoQ2FjaGUgw7xiZXJnZWhlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBzdGFydGVuLCBzb2Zlcm4gZXIgbmljaHQgYmVyZWl0cyBsw6R1ZnQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIG5hY2ggVmVyYXJiZWl0ZW4gdm9uIEF1c2zDtnNlcm4gYW5oYWx0ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImVuIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPlN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPlRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5TdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5Vc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+SWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5UcmlnZ2VyIGVsZW1lbnQgc291cmNlIHZhbHVlPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5TdHJpbmcgdG8gdXNlIGFzIHRoZSB2YWx1ZSBmb3IgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZCBmb3Igc3VibWl0dGluZyB0cmlnZ2VyIGRvY3VtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5xdWV1ZSAodXNlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0IChieXBhc3MgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0b3AgZHJpdmVyIHdoZW4gZmluaXNoZWQgcHJvY2Vzc2luZyB0cmlnZ2VyKHMpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJmciIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5Ew6ljbGVuY2hldXIgZGUgY2FuYWwgYWJvbm7DqTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5DZSB0cmF2YWlsIGFkcmVzc2UgdW4gb3UgcGx1c2lldXJzIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzIChvdSBuJ2VuIHNvdW1ldCBwYXMpIGF1IGNhbmFsIGFib25uw6kuIElsIHBldXQgZW52b3llciB1biBkb2N1bWVudCBwYXIgb2JqZXQsIHNpIHVuZSDDqXRlbmR1ZSBhIMOpdMOpIGTDqWZpbmllLCBvdSB1biBzZXVsIGRvY3VtZW50IMOgIGNoYXF1ZSBleMOpY3V0aW9uLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlNvdW1ldHRyZSB1biBkb2N1bWVudCBkw6ljbGVuY2hldXIgcG91ciBsZXMgb2JqZXRzIHNhbnMgYXNzb2NpYXRpb24gZGUgcGlsb3RlID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlV0aWxpc2VyIGxlIENOIGR1IHRyYXZhaWwgY29tbWUgaWRlbnRpZmljYXRldXIgZGUgZG9jdW1lbnQgZMOpY2xlbmNoZXVyID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+TGUgY2FzIMOpY2jDqWFudCwgdXRpbGlzZXIgbGUgQ04gZGUgbCdvYmpldCBUcmF2YWlsIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1ci48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5WYWxldXIgc291cmNlIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+Q2hhw65uZSDDoCB1dGlsaXNlciBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk3DqXRob2RlIGRlIHNvdW1pc3Npb24gZGUgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+ZmlsZSBkJ2F0dGVudGUgKHV0aWxpc2VyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0ZSAow6l2aXRlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+RMOpbWFycmVyIGxlIHBpbG90ZSBhdSBiZXNvaW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5BcnLDqnRlciBsZSBwaWxvdGUgw6AgbGEgZmluIGR1IHRyYWl0ZW1lbnQgZGVzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImphIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuizvOiqreiAheODgeODo+ODjeODq+ODiOODquOCrDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7jgZPjga7jgrjjg6fjg5bjga/jgrzjg63jgb7jgZ/jga/opIfmlbDjga7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLos7zoqq3ogIXjg4Hjg6Pjg43jg6vjgavpgIHkv6HjgZfjgb7jgZnjgILjgZPjga7pgIHkv6Hjga/jgrnjgrPjg7zjg5fjgYzlrprnvqnjgZXjgozjgabjgYTjgovloLTlkIjjga/jgqrjg5bjgrjjgqfjgq/jg4jjgZTjgajjgasx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44CB44G+44Gf44Gv5ZCE44K444On44OW5a6f6KGM44Gr5a++44GX44GmMeOBpOOBruODieOCreODpeODoeODs+ODiOOBqOOBquOCiuOBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuODieODqeOCpOODkOOBrumWoumAo+S7mOOBkeOBquOBl+OBp+OCquODluOCuOOCp+OCr+ODiOOBq+WvvuOBmeOCi+ODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuOCuOODp+ODlkNO44KS44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI6K2Y5Yil5a2Q44Go44GX44Gm5L2/55So44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7oqK3lrprjgZXjgozjgabjgYTjgovloLTlkIjjgIHjgrjjg6fjg5bjgqrjg5bjgrjjgqfjgq/jg4jjga5DTuOCkuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOCveODvOOCueWApDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GZ44KL5paH5a2X5YiX44Gn44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZnjgovjgZ/jgoHjga7mlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+44Kt44Ol44O8KOOCreODo+ODg+OCt+ODpeOBruS9v+eUqCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSjjg5DjgqTjg5Hjgrnjgq3jg6Pjg4Pjgrfjg6UpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWun+ihjOOBl+OBpuOBhOOBquOBhOWgtOWQiOODieODqeOCpOODkOOCkumWi+Wni+OBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOOBruWHpueQhuOBjOe1guS6huOBl+OBn+WgtOWQiOODieODqeOCpOODkOOCkuWBnOatouOBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfQ04iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6K6i6LSt6ICF6YCa6YGT6Kem5Y+R5ZmoPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuivpeS9nOS4muWwhuWQkeiuoui0reiAhemAmumBk+aPkOS6pCAwIOS4quaIluWkmuS4quinpuWPkeWZqOaWh+aho+OAguWmguaenOWumuS5ieS6huiMg+WbtO+8jOWPr+S7peWvueavj+S4quWvueixoeaPkOS6pOS4gOS4quaWh+aho++8jOS5n+WPr+S7peWvueavj+asoeS9nOS4mui/kOihjOaPkOS6pOS4gOS4quaWh+aho+OAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuS4uuayoeaciempseWKqOeoi+W6j+WFs+iBlOeahOWvueixoeaPkOS6pOinpuWPkeWZqOaWh+aho+WQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5bCG4oCc5L2c5LiaIENO4oCd55So5L2c6Kem5Y+R5Zmo5paH5qGj55qE5qCH6K+G56ym5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOiuvue9ru+8jOWwhuaKiuivpeS9nOS4muWvueixoeeahCBDTiDnlKjkvZzop6blj5HlmajlhYPntKDnmoTigJzmupDigJ3nibnmgKfnmoTlgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op6blj5HlmajlhYPntKDmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPueUqOS9nOinpuWPkeWZqOWFg+e0oOKAnOa6kOKAneeJueaAp+eahOWAvOeahOWtl+espuS4suOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj55qE5pa55byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPumYn+WIl++8iOS9v+eUqOi2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6l77yI57uV6L+H6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWQr+WKqOmpseWKqOeoi+W6j++8iOWmguaenOacqui/kOihjO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWujOaIkOWvueinpuWPkeWZqOeahOWkhOeQhuaXtuWBnOatoumpseWKqOeoi+W6jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfVFciIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6KiC6Zax6ICF6YCa6YGT6Ke455m856iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuatpOW3peS9nOacg+aPkOS6pOmbtuWAi+S7peS4iueahOinuOeZvOaWh+S7tuiHs+iogumWseiAhemAmumBk+OAguatpOS9nOalreWPr+iDveavj+S4gOWAi+eJqeS7tuaPkOS6pOS4gOS7veaWh+S7tiAo6Iul5bey5a6a576p56+E5ZyNKSDmiJblj6/og73mr4/kuIDlgIvlt6XkvZzmj5DkuqTllq7kuIDku73mlofku7bjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHngrrmspLmnInpqYXli5XnqIvlvI/pl5zoga/nmoTnianku7bmj5DkuqTop7jnmbzmlofku7bvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeS7peOAjOW3peS9nCBDTuOAjSDlgZrngrrop7jnmbzmlofku7borZjliKXnorzvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6Kit5a6a77yM5YmH6KuL5Lul5bel5L2c54mp5Lu255qEIENOIOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinuOeZvOWFg+e0oOS+hua6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+5a2X5Liy77yM5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzmlofku7bnmoTmj5DkuqTmlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+5L2H5YiXICjkvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUgKOS4jeS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZWf5YuV6amF5YuV56iL5byPICjoi6XmnKrln7fooYwpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+55W25a6M5oiQ6JmV55CG6Ke455m856iL5byP5pmC5YGc5q2i6amF5YuV56iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48L2pvYi1hZ2dyZWdhdGlvbj4=]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-Scope"/>
					<job-scope-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ECTrainingExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-email-server-query job-name="cn=Job-ECTrainingExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ECTrainingExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-ECTrainingExpires-AttrUpdate">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT5mYWxzZTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L2RlZmluaXRpb25zPjwvY29uZmlndXJhdGlvbi12YWx1ZXM+PC9qb2ItZGVmaW5pdGlvbj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJkZSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5BYm9ubmVudGVua2FuYWxhdXNsw7ZzZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+TWl0IGRpZXNlbSBBdWZ0cmFnIHdlcmRlbiBudWxsIG9kZXIgbWVociBBdXNsw7ZzZXJkb2t1bWVudGUgYW4gZGVuIEFib25uZW50ZW5rYW5hbCBhYmdlc2VuZGV0LiBEYWJlaSBrYW5uIGVzIHNpY2ggdW0gZWluIERva3VtZW50IHBybyBPYmpla3QgaGFuZGVsbiwgc29mZXJuIGVpbiBCZXJlaWNoIGRlZmluaWVydCB3dXJkZSwgb2RlciB1bSBlaW4gZWluemVsbmVzIERva3VtZW50IGbDvHIgamVkZSBBdWZ0cmFnc2F1c2bDvGhydW5nLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPkF1c2zDtnNlcmRva3VtZW50IGbDvHIgT2JqZWt0ZSBvaG5lIFRyZWliZXJ6dW9yZG51bmcgYWJzZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5BdWZ0cmFncy1DTiBhbHMgQXVzbMO2c2VyZG9rdW1lbnRiZXplaWNobmVyIHZlcndlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+V2VubiBmZXN0Z2VsZWd0LCB3aXJkIGRlciBDTiBkZXMgQXVmdHJhZ3NvYmpla3RzIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VXJzcHJ1bmdzd2VydCBkZXMgQXVzbMO2c2VyZWxlbWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlplaWNoZW5rZXR0ZSwgZGllIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQgd2VyZGVuIHNvbGwuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2RlIGbDvHIgZGFzIEFic2VuZGVuIHZvbiBBdXNsw7ZzZXJkb2t1bWVudGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPldhcnRlc2NobGFuZ2UgKENhY2hlIHZlcndlbmRlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPkRpcmVrdCAoQ2FjaGUgw7xiZXJnZWhlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBzdGFydGVuLCBzb2Zlcm4gZXIgbmljaHQgYmVyZWl0cyBsw6R1ZnQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIG5hY2ggVmVyYXJiZWl0ZW4gdm9uIEF1c2zDtnNlcm4gYW5oYWx0ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImVuIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPlN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPlRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5TdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5Vc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+SWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5UcmlnZ2VyIGVsZW1lbnQgc291cmNlIHZhbHVlPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5TdHJpbmcgdG8gdXNlIGFzIHRoZSB2YWx1ZSBmb3IgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZCBmb3Igc3VibWl0dGluZyB0cmlnZ2VyIGRvY3VtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5xdWV1ZSAodXNlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0IChieXBhc3MgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0b3AgZHJpdmVyIHdoZW4gZmluaXNoZWQgcHJvY2Vzc2luZyB0cmlnZ2VyKHMpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJmciIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5Ew6ljbGVuY2hldXIgZGUgY2FuYWwgYWJvbm7DqTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5DZSB0cmF2YWlsIGFkcmVzc2UgdW4gb3UgcGx1c2lldXJzIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzIChvdSBuJ2VuIHNvdW1ldCBwYXMpIGF1IGNhbmFsIGFib25uw6kuIElsIHBldXQgZW52b3llciB1biBkb2N1bWVudCBwYXIgb2JqZXQsIHNpIHVuZSDDqXRlbmR1ZSBhIMOpdMOpIGTDqWZpbmllLCBvdSB1biBzZXVsIGRvY3VtZW50IMOgIGNoYXF1ZSBleMOpY3V0aW9uLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlNvdW1ldHRyZSB1biBkb2N1bWVudCBkw6ljbGVuY2hldXIgcG91ciBsZXMgb2JqZXRzIHNhbnMgYXNzb2NpYXRpb24gZGUgcGlsb3RlID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlV0aWxpc2VyIGxlIENOIGR1IHRyYXZhaWwgY29tbWUgaWRlbnRpZmljYXRldXIgZGUgZG9jdW1lbnQgZMOpY2xlbmNoZXVyID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+TGUgY2FzIMOpY2jDqWFudCwgdXRpbGlzZXIgbGUgQ04gZGUgbCdvYmpldCBUcmF2YWlsIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1ci48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5WYWxldXIgc291cmNlIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+Q2hhw65uZSDDoCB1dGlsaXNlciBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk3DqXRob2RlIGRlIHNvdW1pc3Npb24gZGUgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+ZmlsZSBkJ2F0dGVudGUgKHV0aWxpc2VyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0ZSAow6l2aXRlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+RMOpbWFycmVyIGxlIHBpbG90ZSBhdSBiZXNvaW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5BcnLDqnRlciBsZSBwaWxvdGUgw6AgbGEgZmluIGR1IHRyYWl0ZW1lbnQgZGVzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImphIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuizvOiqreiAheODgeODo+ODjeODq+ODiOODquOCrDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7jgZPjga7jgrjjg6fjg5bjga/jgrzjg63jgb7jgZ/jga/opIfmlbDjga7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLos7zoqq3ogIXjg4Hjg6Pjg43jg6vjgavpgIHkv6HjgZfjgb7jgZnjgILjgZPjga7pgIHkv6Hjga/jgrnjgrPjg7zjg5fjgYzlrprnvqnjgZXjgozjgabjgYTjgovloLTlkIjjga/jgqrjg5bjgrjjgqfjgq/jg4jjgZTjgajjgasx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44CB44G+44Gf44Gv5ZCE44K444On44OW5a6f6KGM44Gr5a++44GX44GmMeOBpOOBruODieOCreODpeODoeODs+ODiOOBqOOBquOCiuOBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuODieODqeOCpOODkOOBrumWoumAo+S7mOOBkeOBquOBl+OBp+OCquODluOCuOOCp+OCr+ODiOOBq+WvvuOBmeOCi+ODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuOCuOODp+ODlkNO44KS44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI6K2Y5Yil5a2Q44Go44GX44Gm5L2/55So44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7oqK3lrprjgZXjgozjgabjgYTjgovloLTlkIjjgIHjgrjjg6fjg5bjgqrjg5bjgrjjgqfjgq/jg4jjga5DTuOCkuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOCveODvOOCueWApDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GZ44KL5paH5a2X5YiX44Gn44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZnjgovjgZ/jgoHjga7mlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+44Kt44Ol44O8KOOCreODo+ODg+OCt+ODpeOBruS9v+eUqCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSjjg5DjgqTjg5Hjgrnjgq3jg6Pjg4Pjgrfjg6UpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWun+ihjOOBl+OBpuOBhOOBquOBhOWgtOWQiOODieODqeOCpOODkOOCkumWi+Wni+OBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOOBruWHpueQhuOBjOe1guS6huOBl+OBn+WgtOWQiOODieODqeOCpOODkOOCkuWBnOatouOBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfQ04iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6K6i6LSt6ICF6YCa6YGT6Kem5Y+R5ZmoPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuivpeS9nOS4muWwhuWQkeiuoui0reiAhemAmumBk+aPkOS6pCAwIOS4quaIluWkmuS4quinpuWPkeWZqOaWh+aho+OAguWmguaenOWumuS5ieS6huiMg+WbtO+8jOWPr+S7peWvueavj+S4quWvueixoeaPkOS6pOS4gOS4quaWh+aho++8jOS5n+WPr+S7peWvueavj+asoeS9nOS4mui/kOihjOaPkOS6pOS4gOS4quaWh+aho+OAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuS4uuayoeaciempseWKqOeoi+W6j+WFs+iBlOeahOWvueixoeaPkOS6pOinpuWPkeWZqOaWh+aho+WQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5bCG4oCc5L2c5LiaIENO4oCd55So5L2c6Kem5Y+R5Zmo5paH5qGj55qE5qCH6K+G56ym5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOiuvue9ru+8jOWwhuaKiuivpeS9nOS4muWvueixoeeahCBDTiDnlKjkvZzop6blj5HlmajlhYPntKDnmoTigJzmupDigJ3nibnmgKfnmoTlgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op6blj5HlmajlhYPntKDmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPueUqOS9nOinpuWPkeWZqOWFg+e0oOKAnOa6kOKAneeJueaAp+eahOWAvOeahOWtl+espuS4suOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj55qE5pa55byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPumYn+WIl++8iOS9v+eUqOi2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6l77yI57uV6L+H6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWQr+WKqOmpseWKqOeoi+W6j++8iOWmguaenOacqui/kOihjO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWujOaIkOWvueinpuWPkeWZqOeahOWkhOeQhuaXtuWBnOatoumpseWKqOeoi+W6jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfVFciIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6KiC6Zax6ICF6YCa6YGT6Ke455m856iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuatpOW3peS9nOacg+aPkOS6pOmbtuWAi+S7peS4iueahOinuOeZvOaWh+S7tuiHs+iogumWseiAhemAmumBk+OAguatpOS9nOalreWPr+iDveavj+S4gOWAi+eJqeS7tuaPkOS6pOS4gOS7veaWh+S7tiAo6Iul5bey5a6a576p56+E5ZyNKSDmiJblj6/og73mr4/kuIDlgIvlt6XkvZzmj5DkuqTllq7kuIDku73mlofku7bjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHngrrmspLmnInpqYXli5XnqIvlvI/pl5zoga/nmoTnianku7bmj5DkuqTop7jnmbzmlofku7bvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeS7peOAjOW3peS9nCBDTuOAjSDlgZrngrrop7jnmbzmlofku7borZjliKXnorzvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6Kit5a6a77yM5YmH6KuL5Lul5bel5L2c54mp5Lu255qEIENOIOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinuOeZvOWFg+e0oOS+hua6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+5a2X5Liy77yM5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzmlofku7bnmoTmj5DkuqTmlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+5L2H5YiXICjkvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUgKOS4jeS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZWf5YuV6amF5YuV56iL5byPICjoi6XmnKrln7fooYwpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+55W25a6M5oiQ6JmV55CG6Ke455m856iL5byP5pmC5YGc5q2i6amF5YuV56iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48L2pvYi1hZ2dyZWdhdGlvbj4=]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-Scope"/>
					<job-scope-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ECTrainingExpires-AttrUpdate,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-email-server-query job-name="cn=Job-ECTrainingExpires-AttrUpdate,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ECTrainingExpires-AttrUpdate,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-ECTrainingExpires-AttrUpdate-Schedule">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY2hlZHVsZT0iNDUgMiAqICogKiIgc2NvcGUtcmVxdWlyZWQ9ImZhbHNlIiB0eXBlPSJqYXZhIj48ZGVzY3JpcHRpb24+eGxmaWQoam9iLWRlc2NyaXB0aW9uKVRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L2Rlc2NyaXB0aW9uPjxjb250YWlubWVudD5EaXJYTUwtRHJpdmVyPC9jb250YWlubWVudD48amF2YS1jbGFzcz5jb20ubm92ZWxsLm5kcy5kaXJ4bWwuam9iLnRyaWdnZXIuVHJpZ2dlcjwvamF2YS1jbGFzcz48Y29uZmlndXJhdGlvbi12YWx1ZXM+PGRlZmluaXRpb25zPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQocHJvY2Vzcy11bmFzc29jaWF0ZWQpU3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPyIgbmFtZT0icHJvY2Vzcy11bmFzc29jaWF0ZWQiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodXNlLWpvYi1jbilVc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj8iIG5hbWU9InVzZS1qb2ItY24iIHR5cGU9ImJvb2xlYW4iPjxkZXNjcmlwdGlvbj54bGZpZCh1c2Utam9iLWNuLWRlc2MpSWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L2Rlc2NyaXB0aW9uPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9ImZhbHNlIj48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHRyaWdnZXItc291cmNlKVRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWUiIG5hbWU9InRyaWdnZXItc291cmNlIiB0eXBlPSJzdHJpbmciPjxkZXNjcmlwdGlvbj54bGZpZCh0cmlnZ2VyLXNvdXJjZS1kZXNjKVN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPjE8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1tZXRob2QpTWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzIiBuYW1lPSJzdWJtaXQtbWV0aG9kIiB0eXBlPSJlbnVtIj48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtcXVldWUpcXVldWUgKHVzZSBjYWNoZSkiPnN1Ym1pdC1xdWV1ZTwvZW51bS1jaG9pY2U+PGVudW0tY2hvaWNlIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LWRpcmVjdClkaXJlY3QgKGJ5cGFzcyBjYWNoZSkiPnN1Ym1pdC1kaXJlY3Q8L2VudW0tY2hvaWNlPjx2YWx1ZT5zdWJtaXQtZGlyZWN0PC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InN1Ym1pdC1kaXJlY3QiPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN0YXJ0LWRyaXZlcilTdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmciIG5hbWU9InN0YXJ0LWRyaXZlciIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPmZhbHNlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InRydWUiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RvcC1kcml2ZXIpU3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocykiIG5hbWU9InN0b3AtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9kZWZpbml0aW9ucz48L2NvbmZpZ3VyYXRpb24tdmFsdWVzPjwvam9iLWRlZmluaXRpb24+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZGUiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+QWJvbm5lbnRlbmthbmFsYXVzbMO2c2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPk1pdCBkaWVzZW0gQXVmdHJhZyB3ZXJkZW4gbnVsbCBvZGVyIG1laHIgQXVzbMO2c2VyZG9rdW1lbnRlIGFuIGRlbiBBYm9ubmVudGVua2FuYWwgYWJnZXNlbmRldC4gRGFiZWkga2FubiBlcyBzaWNoIHVtIGVpbiBEb2t1bWVudCBwcm8gT2JqZWt0IGhhbmRlbG4sIHNvZmVybiBlaW4gQmVyZWljaCBkZWZpbmllcnQgd3VyZGUsIG9kZXIgdW0gZWluIGVpbnplbG5lcyBEb2t1bWVudCBmw7xyIGplZGUgQXVmdHJhZ3NhdXNmw7xocnVuZy48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5BdXNsw7ZzZXJkb2t1bWVudCBmw7xyIE9iamVrdGUgb2huZSBUcmVpYmVyenVvcmRudW5nIGFic2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+QXVmdHJhZ3MtQ04gYWxzIEF1c2zDtnNlcmRva3VtZW50YmV6ZWljaG5lciB2ZXJ3ZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPldlbm4gZmVzdGdlbGVndCwgd2lyZCBkZXIgQ04gZGVzIEF1ZnRyYWdzb2JqZWt0cyBhbHMgV2VydCBmw7xyIGRhcyBVcnNwcnVuZ3NhdHRyaWJ1dCBkZXMgQXVzbMO2c2VyZWxlbWVudHMgdmVyd2VuZGV0Ljwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlVyc3BydW5nc3dlcnQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5aZWljaGVua2V0dGUsIGRpZSBhbHMgV2VydCBmw7xyIGRhcyBVcnNwcnVuZ3NhdHRyaWJ1dCBkZXMgQXVzbMO2c2VyZWxlbWVudHMgdmVyd2VuZGV0IHdlcmRlbiBzb2xsLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kZSBmw7xyIGRhcyBBYnNlbmRlbiB2b24gQXVzbMO2c2VyZG9rdW1lbnRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5XYXJ0ZXNjaGxhbmdlIChDYWNoZSB2ZXJ3ZW5kZW4pPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5EaXJla3QgKENhY2hlIMO8YmVyZ2VoZW4pPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgc3RhcnRlbiwgc29mZXJuIGVyIG5pY2h0IGJlcmVpdHMgbMOkdWZ0PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBuYWNoIFZlcmFyYmVpdGVuIHZvbiBBdXNsw7ZzZXJuIGFuaGFsdGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJlbiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5TdWJzY3JpYmVyIGNoYW5uZWwgdHJpZ2dlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5UaGlzIGpvYiBzdWJtaXRzIHplcm8gb3IgbW9yZSB0cmlnZ2VyIGRvY3VtZW50cyB0byB0aGUgc3Vic2NyaWJlciBjaGFubmVsLiBUaGUgc3VibWlzc2lvbiBtYXkgZWl0aGVyIGJlIGEgZG9jdW1lbnQgcGVyIG9iamVjdCBpZiBhIHNjb3BlIGlzIGRlZmluZWQgb3IgbWF5IGJlIGEgc2luZ2xlIGRvY3VtZW50IGZvciBlYWNoIGpvYiBydW4uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXNlIEpvYiBDTiBhcyB0cmlnZ2VyIGRvY3VtZW50IGlkZW50aWZpZXI/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPklmIHNldCwgdXNlIHRoZSBqb2Igb2JqZWN0J3MgQ04gYXMgdGhlIHZhbHVlIG9mIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+U3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+cXVldWUgKHVzZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPmRpcmVjdCAoYnlwYXNzIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5TdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmc8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5TdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZnIiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+RMOpY2xlbmNoZXVyIGRlIGNhbmFsIGFib25uw6k8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+Q2UgdHJhdmFpbCBhZHJlc3NlIHVuIG91IHBsdXNpZXVycyBkb2N1bWVudHMgZMOpY2xlbmNoZXVycyAob3UgbidlbiBzb3VtZXQgcGFzKSBhdSBjYW5hbCBhYm9ubsOpLiBJbCBwZXV0IGVudm95ZXIgdW4gZG9jdW1lbnQgcGFyIG9iamV0LCBzaSB1bmUgw6l0ZW5kdWUgYSDDqXTDqSBkw6lmaW5pZSwgb3UgdW4gc2V1bCBkb2N1bWVudCDDoCBjaGFxdWUgZXjDqWN1dGlvbi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5Tb3VtZXR0cmUgdW4gZG9jdW1lbnQgZMOpY2xlbmNoZXVyIHBvdXIgbGVzIG9iamV0cyBzYW5zIGFzc29jaWF0aW9uIGRlIHBpbG90ZSA/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5VdGlsaXNlciBsZSBDTiBkdSB0cmF2YWlsIGNvbW1lIGlkZW50aWZpY2F0ZXVyIGRlIGRvY3VtZW50IGTDqWNsZW5jaGV1ciA/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPkxlIGNhcyDDqWNow6lhbnQsIHV0aWxpc2VyIGxlIENOIGRlIGwnb2JqZXQgVHJhdmFpbCBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXIuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VmFsZXVyIHNvdXJjZSBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPkNoYcOubmUgw6AgdXRpbGlzZXIgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5Nw6l0aG9kZSBkZSBzb3VtaXNzaW9uIGRlIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPmZpbGUgZCdhdHRlbnRlICh1dGlsaXNlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPmRpcmVjdGUgKMOpdml0ZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkTDqW1hcnJlciBsZSBwaWxvdGUgYXUgYmVzb2luPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+QXJyw6p0ZXIgbGUgcGlsb3RlIMOgIGxhIGZpbiBkdSB0cmFpdGVtZW50IGRlcyBkw6ljbGVuY2hldXJzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJqYSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7os7zoqq3ogIXjg4Hjg6Pjg43jg6vjg4jjg6rjgqw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+44GT44Gu44K444On44OW44Gv44K844Ot44G+44Gf44Gv6KSH5pWw44Gu44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6LO86Kqt6ICF44OB44Oj44ON44Or44Gr6YCB5L+h44GX44G+44GZ44CC44GT44Gu6YCB5L+h44Gv44K544Kz44O844OX44GM5a6a576p44GV44KM44Gm44GE44KL5aC05ZCI44Gv44Kq44OW44K444Kn44Kv44OI44GU44Go44GrMeOBpOOBruODieOCreODpeODoeODs+ODiOOAgeOBvuOBn+OBr+WQhOOCuOODp+ODluWun+ihjOOBq+WvvuOBl+OBpjHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgajjgarjgorjgb7jgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7jg4njg6njgqTjg5Djga7plqLpgKPku5jjgZHjgarjgZfjgafjgqrjg5bjgrjjgqfjgq/jg4jjgavlr77jgZnjgovjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7jgrjjg6fjg5ZDTuOCkuODiOODquOCrOODieOCreODpeODoeODs+ODiOitmOWIpeWtkOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+6Kit5a6a44GV44KM44Gm44GE44KL5aC05ZCI44CB44K444On44OW44Kq44OW44K444Kn44Kv44OI44GuQ07jgpLjg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjgr3jg7zjgrnlgKQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBmeOCi+aWh+Wtl+WIl+OBp+OBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GZ44KL44Gf44KB44Gu5pa55rOVPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPuOCreODpeODvCjjgq3jg6Pjg4Pjgrfjg6Xjga7kvb/nlKgpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUo44OQ44Kk44OR44K544Kt44Oj44OD44K344OlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lrp/ooYzjgZfjgabjgYTjgarjgYTloLTlkIjjg4njg6njgqTjg5DjgpLplovlp4vjgZnjgos8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjga7lh6bnkIbjgYzntYLkuobjgZfjgZ/loLTlkIjjg4njg6njgqTjg5DjgpLlgZzmraLjgZnjgos8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9InpoX0NOIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuiuoui0reiAhemAmumBk+inpuWPkeWZqDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7or6XkvZzkuJrlsIblkJHorqLotK3ogIXpgJrpgZPmj5DkuqQgMCDkuKrmiJblpJrkuKrop6blj5HlmajmlofmoaPjgILlpoLmnpzlrprkuYnkuobojIPlm7TvvIzlj6/ku6Xlr7nmr4/kuKrlr7nosaHmj5DkuqTkuIDkuKrmlofmoaPvvIzkuZ/lj6/ku6Xlr7nmr4/mrKHkvZzkuJrov5DooYzmj5DkuqTkuIDkuKrmlofmoaPjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7kuLrmsqHmnInpqbHliqjnqIvluo/lhbPogZTnmoTlr7nosaHmj5DkuqTop6blj5HlmajmlofmoaPlkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuWwhuKAnOS9nOS4miBDTuKAneeUqOS9nOinpuWPkeWZqOaWh+aho+eahOagh+ivhuespuWQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzorr7nva7vvIzlsIbmioror6XkvZzkuJrlr7nosaHnmoQgQ04g55So5L2c6Kem5Y+R5Zmo5YWD57Sg55qE4oCc5rqQ4oCd54m55oCn55qE5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Kem5Y+R5Zmo5YWD57Sg5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7nlKjkvZzop6blj5HlmajlhYPntKDigJzmupDigJ3nibnmgKfnmoTlgLznmoTlrZfnrKbkuLLjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuaPkOS6pOinpuWPkeWZqOaWh+aho+eahOaWueW8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7pmJ/liJfvvIjkvb/nlKjotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpe+8iOe7lei/h+i2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lkK/liqjpqbHliqjnqIvluo/vvIjlpoLmnpzmnKrov5DooYzvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lrozmiJDlr7nop6blj5HlmajnmoTlpITnkIbml7blgZzmraLpqbHliqjnqIvluo88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9InpoX1RXIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuiogumWseiAhemAmumBk+inuOeZvOeoi+W8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7mraTlt6XkvZzmnIPmj5DkuqTpm7blgIvku6XkuIrnmoTop7jnmbzmlofku7boh7PoqILplrHogIXpgJrpgZPjgILmraTkvZzmpa3lj6/og73mr4/kuIDlgIvnianku7bmj5DkuqTkuIDku73mlofku7YgKOiLpeW3suWumue+qeevhOWcjSkg5oiW5Y+v6IO95q+P5LiA5YCL5bel5L2c5o+Q5Lqk5Zau5LiA5Lu95paH5Lu244CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB54K65rKS5pyJ6amF5YuV56iL5byP6Zec6IGv55qE54mp5Lu25o+Q5Lqk6Ke455m85paH5Lu277yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHku6XjgIzlt6XkvZwgQ07jgI0g5YGa54K66Ke455m85paH5Lu26K2Y5Yil56K877yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOioreWumu+8jOWJh+iri+S7peW3peS9nOeJqeS7tueahCBDTiDlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzlhYPntKDkvobmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPuWtl+S4su+8jOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+6Ke455m85paH5Lu255qE5o+Q5Lqk5pa55rOVPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPuS9h+WIlyAo5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lICjkuI3kvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWVn+WLlempheWLleeoi+W8jyAo6Iul5pyq5Z+36KGMKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPueVtuWujOaIkOiZleeQhuinuOeZvOeoi+W8j+aZguWBnOatoumpheWLleeoi+W8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PC9qb2ItYWdncmVnYXRpb24+]]></ds-value>
					</ds-attribute>
					<job-email-server-query job-name="cn=Job-ECTrainingExpires-AttrUpdate-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ECTrainingExpires-AttrUpdate-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-ECTrainingExpires-Schedule">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY2hlZHVsZT0iNDUgNCAqICogKiIgc2NvcGUtcmVxdWlyZWQ9ImZhbHNlIiB0eXBlPSJqYXZhIj48ZGVzY3JpcHRpb24+eGxmaWQoam9iLWRlc2NyaXB0aW9uKVRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L2Rlc2NyaXB0aW9uPjxjb250YWlubWVudD5EaXJYTUwtRHJpdmVyPC9jb250YWlubWVudD48amF2YS1jbGFzcz5jb20ubm92ZWxsLm5kcy5kaXJ4bWwuam9iLnRyaWdnZXIuVHJpZ2dlcjwvamF2YS1jbGFzcz48Y29uZmlndXJhdGlvbi12YWx1ZXM+PGRlZmluaXRpb25zPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQocHJvY2Vzcy11bmFzc29jaWF0ZWQpU3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPyIgbmFtZT0icHJvY2Vzcy11bmFzc29jaWF0ZWQiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodXNlLWpvYi1jbilVc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj8iIG5hbWU9InVzZS1qb2ItY24iIHR5cGU9ImJvb2xlYW4iPjxkZXNjcmlwdGlvbj54bGZpZCh1c2Utam9iLWNuLWRlc2MpSWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L2Rlc2NyaXB0aW9uPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9ImZhbHNlIj48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHRyaWdnZXItc291cmNlKVRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWUiIG5hbWU9InRyaWdnZXItc291cmNlIiB0eXBlPSJzdHJpbmciPjxkZXNjcmlwdGlvbj54bGZpZCh0cmlnZ2VyLXNvdXJjZS1kZXNjKVN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPjE8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1tZXRob2QpTWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzIiBuYW1lPSJzdWJtaXQtbWV0aG9kIiB0eXBlPSJlbnVtIj48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtcXVldWUpcXVldWUgKHVzZSBjYWNoZSkiPnN1Ym1pdC1xdWV1ZTwvZW51bS1jaG9pY2U+PGVudW0tY2hvaWNlIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LWRpcmVjdClkaXJlY3QgKGJ5cGFzcyBjYWNoZSkiPnN1Ym1pdC1kaXJlY3Q8L2VudW0tY2hvaWNlPjx2YWx1ZT5zdWJtaXQtZGlyZWN0PC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InN1Ym1pdC1kaXJlY3QiPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN0YXJ0LWRyaXZlcilTdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmciIG5hbWU9InN0YXJ0LWRyaXZlciIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPmZhbHNlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InRydWUiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RvcC1kcml2ZXIpU3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocykiIG5hbWU9InN0b3AtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9kZWZpbml0aW9ucz48L2NvbmZpZ3VyYXRpb24tdmFsdWVzPjwvam9iLWRlZmluaXRpb24+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZGUiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+QWJvbm5lbnRlbmthbmFsYXVzbMO2c2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPk1pdCBkaWVzZW0gQXVmdHJhZyB3ZXJkZW4gbnVsbCBvZGVyIG1laHIgQXVzbMO2c2VyZG9rdW1lbnRlIGFuIGRlbiBBYm9ubmVudGVua2FuYWwgYWJnZXNlbmRldC4gRGFiZWkga2FubiBlcyBzaWNoIHVtIGVpbiBEb2t1bWVudCBwcm8gT2JqZWt0IGhhbmRlbG4sIHNvZmVybiBlaW4gQmVyZWljaCBkZWZpbmllcnQgd3VyZGUsIG9kZXIgdW0gZWluIGVpbnplbG5lcyBEb2t1bWVudCBmw7xyIGplZGUgQXVmdHJhZ3NhdXNmw7xocnVuZy48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5BdXNsw7ZzZXJkb2t1bWVudCBmw7xyIE9iamVrdGUgb2huZSBUcmVpYmVyenVvcmRudW5nIGFic2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+QXVmdHJhZ3MtQ04gYWxzIEF1c2zDtnNlcmRva3VtZW50YmV6ZWljaG5lciB2ZXJ3ZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPldlbm4gZmVzdGdlbGVndCwgd2lyZCBkZXIgQ04gZGVzIEF1ZnRyYWdzb2JqZWt0cyBhbHMgV2VydCBmw7xyIGRhcyBVcnNwcnVuZ3NhdHRyaWJ1dCBkZXMgQXVzbMO2c2VyZWxlbWVudHMgdmVyd2VuZGV0Ljwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlVyc3BydW5nc3dlcnQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5aZWljaGVua2V0dGUsIGRpZSBhbHMgV2VydCBmw7xyIGRhcyBVcnNwcnVuZ3NhdHRyaWJ1dCBkZXMgQXVzbMO2c2VyZWxlbWVudHMgdmVyd2VuZGV0IHdlcmRlbiBzb2xsLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kZSBmw7xyIGRhcyBBYnNlbmRlbiB2b24gQXVzbMO2c2VyZG9rdW1lbnRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5XYXJ0ZXNjaGxhbmdlIChDYWNoZSB2ZXJ3ZW5kZW4pPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5EaXJla3QgKENhY2hlIMO8YmVyZ2VoZW4pPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgc3RhcnRlbiwgc29mZXJuIGVyIG5pY2h0IGJlcmVpdHMgbMOkdWZ0PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBuYWNoIFZlcmFyYmVpdGVuIHZvbiBBdXNsw7ZzZXJuIGFuaGFsdGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJlbiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5TdWJzY3JpYmVyIGNoYW5uZWwgdHJpZ2dlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5UaGlzIGpvYiBzdWJtaXRzIHplcm8gb3IgbW9yZSB0cmlnZ2VyIGRvY3VtZW50cyB0byB0aGUgc3Vic2NyaWJlciBjaGFubmVsLiBUaGUgc3VibWlzc2lvbiBtYXkgZWl0aGVyIGJlIGEgZG9jdW1lbnQgcGVyIG9iamVjdCBpZiBhIHNjb3BlIGlzIGRlZmluZWQgb3IgbWF5IGJlIGEgc2luZ2xlIGRvY3VtZW50IGZvciBlYWNoIGpvYiBydW4uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXNlIEpvYiBDTiBhcyB0cmlnZ2VyIGRvY3VtZW50IGlkZW50aWZpZXI/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPklmIHNldCwgdXNlIHRoZSBqb2Igb2JqZWN0J3MgQ04gYXMgdGhlIHZhbHVlIG9mIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+U3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+cXVldWUgKHVzZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPmRpcmVjdCAoYnlwYXNzIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5TdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmc8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5TdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZnIiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+RMOpY2xlbmNoZXVyIGRlIGNhbmFsIGFib25uw6k8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+Q2UgdHJhdmFpbCBhZHJlc3NlIHVuIG91IHBsdXNpZXVycyBkb2N1bWVudHMgZMOpY2xlbmNoZXVycyAob3UgbidlbiBzb3VtZXQgcGFzKSBhdSBjYW5hbCBhYm9ubsOpLiBJbCBwZXV0IGVudm95ZXIgdW4gZG9jdW1lbnQgcGFyIG9iamV0LCBzaSB1bmUgw6l0ZW5kdWUgYSDDqXTDqSBkw6lmaW5pZSwgb3UgdW4gc2V1bCBkb2N1bWVudCDDoCBjaGFxdWUgZXjDqWN1dGlvbi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5Tb3VtZXR0cmUgdW4gZG9jdW1lbnQgZMOpY2xlbmNoZXVyIHBvdXIgbGVzIG9iamV0cyBzYW5zIGFzc29jaWF0aW9uIGRlIHBpbG90ZSA/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5VdGlsaXNlciBsZSBDTiBkdSB0cmF2YWlsIGNvbW1lIGlkZW50aWZpY2F0ZXVyIGRlIGRvY3VtZW50IGTDqWNsZW5jaGV1ciA/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPkxlIGNhcyDDqWNow6lhbnQsIHV0aWxpc2VyIGxlIENOIGRlIGwnb2JqZXQgVHJhdmFpbCBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXIuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VmFsZXVyIHNvdXJjZSBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPkNoYcOubmUgw6AgdXRpbGlzZXIgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5Nw6l0aG9kZSBkZSBzb3VtaXNzaW9uIGRlIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPmZpbGUgZCdhdHRlbnRlICh1dGlsaXNlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPmRpcmVjdGUgKMOpdml0ZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkTDqW1hcnJlciBsZSBwaWxvdGUgYXUgYmVzb2luPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+QXJyw6p0ZXIgbGUgcGlsb3RlIMOgIGxhIGZpbiBkdSB0cmFpdGVtZW50IGRlcyBkw6ljbGVuY2hldXJzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJqYSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7os7zoqq3ogIXjg4Hjg6Pjg43jg6vjg4jjg6rjgqw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+44GT44Gu44K444On44OW44Gv44K844Ot44G+44Gf44Gv6KSH5pWw44Gu44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6LO86Kqt6ICF44OB44Oj44ON44Or44Gr6YCB5L+h44GX44G+44GZ44CC44GT44Gu6YCB5L+h44Gv44K544Kz44O844OX44GM5a6a576p44GV44KM44Gm44GE44KL5aC05ZCI44Gv44Kq44OW44K444Kn44Kv44OI44GU44Go44GrMeOBpOOBruODieOCreODpeODoeODs+ODiOOAgeOBvuOBn+OBr+WQhOOCuOODp+ODluWun+ihjOOBq+WvvuOBl+OBpjHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgajjgarjgorjgb7jgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7jg4njg6njgqTjg5Djga7plqLpgKPku5jjgZHjgarjgZfjgafjgqrjg5bjgrjjgqfjgq/jg4jjgavlr77jgZnjgovjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7jgrjjg6fjg5ZDTuOCkuODiOODquOCrOODieOCreODpeODoeODs+ODiOitmOWIpeWtkOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+6Kit5a6a44GV44KM44Gm44GE44KL5aC05ZCI44CB44K444On44OW44Kq44OW44K444Kn44Kv44OI44GuQ07jgpLjg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjgr3jg7zjgrnlgKQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBmeOCi+aWh+Wtl+WIl+OBp+OBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GZ44KL44Gf44KB44Gu5pa55rOVPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPuOCreODpeODvCjjgq3jg6Pjg4Pjgrfjg6Xjga7kvb/nlKgpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUo44OQ44Kk44OR44K544Kt44Oj44OD44K344OlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lrp/ooYzjgZfjgabjgYTjgarjgYTloLTlkIjjg4njg6njgqTjg5DjgpLplovlp4vjgZnjgos8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjga7lh6bnkIbjgYzntYLkuobjgZfjgZ/loLTlkIjjg4njg6njgqTjg5DjgpLlgZzmraLjgZnjgos8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9InpoX0NOIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuiuoui0reiAhemAmumBk+inpuWPkeWZqDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7or6XkvZzkuJrlsIblkJHorqLotK3ogIXpgJrpgZPmj5DkuqQgMCDkuKrmiJblpJrkuKrop6blj5HlmajmlofmoaPjgILlpoLmnpzlrprkuYnkuobojIPlm7TvvIzlj6/ku6Xlr7nmr4/kuKrlr7nosaHmj5DkuqTkuIDkuKrmlofmoaPvvIzkuZ/lj6/ku6Xlr7nmr4/mrKHkvZzkuJrov5DooYzmj5DkuqTkuIDkuKrmlofmoaPjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7kuLrmsqHmnInpqbHliqjnqIvluo/lhbPogZTnmoTlr7nosaHmj5DkuqTop6blj5HlmajmlofmoaPlkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuWwhuKAnOS9nOS4miBDTuKAneeUqOS9nOinpuWPkeWZqOaWh+aho+eahOagh+ivhuespuWQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzorr7nva7vvIzlsIbmioror6XkvZzkuJrlr7nosaHnmoQgQ04g55So5L2c6Kem5Y+R5Zmo5YWD57Sg55qE4oCc5rqQ4oCd54m55oCn55qE5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Kem5Y+R5Zmo5YWD57Sg5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7nlKjkvZzop6blj5HlmajlhYPntKDigJzmupDigJ3nibnmgKfnmoTlgLznmoTlrZfnrKbkuLLjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuaPkOS6pOinpuWPkeWZqOaWh+aho+eahOaWueW8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7pmJ/liJfvvIjkvb/nlKjotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpe+8iOe7lei/h+i2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lkK/liqjpqbHliqjnqIvluo/vvIjlpoLmnpzmnKrov5DooYzvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lrozmiJDlr7nop6blj5HlmajnmoTlpITnkIbml7blgZzmraLpqbHliqjnqIvluo88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9InpoX1RXIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuiogumWseiAhemAmumBk+inuOeZvOeoi+W8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7mraTlt6XkvZzmnIPmj5DkuqTpm7blgIvku6XkuIrnmoTop7jnmbzmlofku7boh7PoqILplrHogIXpgJrpgZPjgILmraTkvZzmpa3lj6/og73mr4/kuIDlgIvnianku7bmj5DkuqTkuIDku73mlofku7YgKOiLpeW3suWumue+qeevhOWcjSkg5oiW5Y+v6IO95q+P5LiA5YCL5bel5L2c5o+Q5Lqk5Zau5LiA5Lu95paH5Lu244CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB54K65rKS5pyJ6amF5YuV56iL5byP6Zec6IGv55qE54mp5Lu25o+Q5Lqk6Ke455m85paH5Lu277yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHku6XjgIzlt6XkvZwgQ07jgI0g5YGa54K66Ke455m85paH5Lu26K2Y5Yil56K877yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOioreWumu+8jOWJh+iri+S7peW3peS9nOeJqeS7tueahCBDTiDlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzlhYPntKDkvobmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPuWtl+S4su+8jOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+6Ke455m85paH5Lu255qE5o+Q5Lqk5pa55rOVPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPuS9h+WIlyAo5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lICjkuI3kvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWVn+WLlempheWLleeoi+W8jyAo6Iul5pyq5Z+36KGMKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPueVtuWujOaIkOiZleeQhuinuOeZvOeoi+W8j+aZguWBnOatoumpheWLleeoi+W8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PC9qb2ItYWdncmVnYXRpb24+]]></ds-value>
					</ds-attribute>
					<job-email-server-query job-name="cn=Job-ECTrainingExpires-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ECTrainingExpires-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-GLAccountExpires">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJ0cnVlIiBkaXNwbGF5LW5hbWU9InhsZmlkKGpvYi1kaXNwbGF5LW5hbWUpU3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXIiIHNjb3BlLXJlcXVpcmVkPSJmYWxzZSIgdHlwZT0iamF2YSI+PGRlc2NyaXB0aW9uPnhsZmlkKGpvYi1kZXNjcmlwdGlvbilUaGlzIGpvYiBzdWJtaXRzIHplcm8gb3IgbW9yZSB0cmlnZ2VyIGRvY3VtZW50cyB0byB0aGUgc3Vic2NyaWJlciBjaGFubmVsLiBUaGUgc3VibWlzc2lvbiBtYXkgZWl0aGVyIGJlIGEgZG9jdW1lbnQgcGVyIG9iamVjdCBpZiBhIHNjb3BlIGlzIGRlZmluZWQgb3IgbWF5IGJlIGEgc2luZ2xlIGRvY3VtZW50IGZvciBlYWNoIGpvYiBydW4uPC9kZXNjcmlwdGlvbj48Y29udGFpbm1lbnQ+RGlyWE1MLURyaXZlcjwvY29udGFpbm1lbnQ+PGphdmEtY2xhc3M+Y29tLm5vdmVsbC5uZHMuZGlyeG1sLmpvYi50cmlnZ2VyLlRyaWdnZXI8L2phdmEtY2xhc3M+PGNvbmZpZ3VyYXRpb24tdmFsdWVzPjxkZWZpbml0aW9ucz48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHByb2Nlc3MtdW5hc3NvY2lhdGVkKVN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj8iIG5hbWU9InByb2Nlc3MtdW5hc3NvY2lhdGVkIiB0eXBlPSJib29sZWFuIj48dmFsdWU+dHJ1ZTwvdmFsdWU+PC9kZWZpbml0aW9uPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHVzZS1qb2ItY24pVXNlIEpvYiBDTiBhcyB0cmlnZ2VyIGRvY3VtZW50IGlkZW50aWZpZXI/IiBuYW1lPSJ1c2Utam9iLWNuIiB0eXBlPSJib29sZWFuIj48ZGVzY3JpcHRpb24+eGxmaWQodXNlLWpvYi1jbi1kZXNjKUlmIHNldCwgdXNlIHRoZSBqb2Igb2JqZWN0J3MgQ04gYXMgdGhlIHZhbHVlIG9mIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+dHJ1ZTwvdmFsdWU+PC9kZWZpbml0aW9uPjxzdWJvcmRpbmF0ZXMgYWN0aXZlLXZhbHVlPSJmYWxzZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh0cmlnZ2VyLXNvdXJjZSlUcmlnZ2VyIGVsZW1lbnQgc291cmNlIHZhbHVlIiBuYW1lPSJ0cmlnZ2VyLXNvdXJjZSIgdHlwZT0ic3RyaW5nIj48ZGVzY3JpcHRpb24+eGxmaWQodHJpZ2dlci1zb3VyY2UtZGVzYylTdHJpbmcgdG8gdXNlIGFzIHRoZSB2YWx1ZSBmb3IgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L2Rlc2NyaXB0aW9uPjx2YWx1ZT4xPC92YWx1ZT48L2RlZmluaXRpb24+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtbWV0aG9kKU1ldGhvZCBmb3Igc3VibWl0dGluZyB0cmlnZ2VyIGRvY3VtZW50cyIgbmFtZT0ic3VibWl0LW1ldGhvZCIgdHlwZT0iZW51bSI+PGVudW0tY2hvaWNlIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LXF1ZXVlKXF1ZXVlICh1c2UgY2FjaGUpIj5zdWJtaXQtcXVldWU8L2VudW0tY2hvaWNlPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1kaXJlY3QpZGlyZWN0IChieXBhc3MgY2FjaGUpIj5zdWJtaXQtZGlyZWN0PC9lbnVtLWNob2ljZT48dmFsdWU+c3VibWl0LWRpcmVjdDwvdmFsdWU+PC9kZWZpbml0aW9uPjxzdWJvcmRpbmF0ZXMgYWN0aXZlLXZhbHVlPSJzdWJtaXQtZGlyZWN0Ij48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdGFydC1kcml2ZXIpU3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nIiBuYW1lPSJzdGFydC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT5mYWxzZTwvdmFsdWU+PC9kZWZpbml0aW9uPjxzdWJvcmRpbmF0ZXMgYWN0aXZlLXZhbHVlPSJ0cnVlIj48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN0b3AtZHJpdmVyKVN0b3AgZHJpdmVyIHdoZW4gZmluaXNoZWQgcHJvY2Vzc2luZyB0cmlnZ2VyKHMpIiBuYW1lPSJzdG9wLWRyaXZlciIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9kZWZpbml0aW9ucz48L2NvbmZpZ3VyYXRpb24tdmFsdWVzPjwvam9iLWRlZmluaXRpb24+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZGUiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+QWJvbm5lbnRlbmthbmFsYXVzbMO2c2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPk1pdCBkaWVzZW0gQXVmdHJhZyB3ZXJkZW4gbnVsbCBvZGVyIG1laHIgQXVzbMO2c2VyZG9rdW1lbnRlIGFuIGRlbiBBYm9ubmVudGVua2FuYWwgYWJnZXNlbmRldC4gRGFiZWkga2FubiBlcyBzaWNoIHVtIGVpbiBEb2t1bWVudCBwcm8gT2JqZWt0IGhhbmRlbG4sIHNvZmVybiBlaW4gQmVyZWljaCBkZWZpbmllcnQgd3VyZGUsIG9kZXIgdW0gZWluIGVpbnplbG5lcyBEb2t1bWVudCBmw7xyIGplZGUgQXVmdHJhZ3NhdXNmw7xocnVuZy48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5BdXNsw7ZzZXJkb2t1bWVudCBmw7xyIE9iamVrdGUgb2huZSBUcmVpYmVyenVvcmRudW5nIGFic2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+QXVmdHJhZ3MtQ04gYWxzIEF1c2zDtnNlcmRva3VtZW50YmV6ZWljaG5lciB2ZXJ3ZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPldlbm4gZmVzdGdlbGVndCwgd2lyZCBkZXIgQ04gZGVzIEF1ZnRyYWdzb2JqZWt0cyBhbHMgV2VydCBmw7xyIGRhcyBVcnNwcnVuZ3NhdHRyaWJ1dCBkZXMgQXVzbMO2c2VyZWxlbWVudHMgdmVyd2VuZGV0Ljwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlVyc3BydW5nc3dlcnQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5aZWljaGVua2V0dGUsIGRpZSBhbHMgV2VydCBmw7xyIGRhcyBVcnNwcnVuZ3NhdHRyaWJ1dCBkZXMgQXVzbMO2c2VyZWxlbWVudHMgdmVyd2VuZGV0IHdlcmRlbiBzb2xsLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kZSBmw7xyIGRhcyBBYnNlbmRlbiB2b24gQXVzbMO2c2VyZG9rdW1lbnRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5XYXJ0ZXNjaGxhbmdlIChDYWNoZSB2ZXJ3ZW5kZW4pPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5EaXJla3QgKENhY2hlIMO8YmVyZ2VoZW4pPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgc3RhcnRlbiwgc29mZXJuIGVyIG5pY2h0IGJlcmVpdHMgbMOkdWZ0PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBuYWNoIFZlcmFyYmVpdGVuIHZvbiBBdXNsw7ZzZXJuIGFuaGFsdGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJlbiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5TdWJzY3JpYmVyIGNoYW5uZWwgdHJpZ2dlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5UaGlzIGpvYiBzdWJtaXRzIHplcm8gb3IgbW9yZSB0cmlnZ2VyIGRvY3VtZW50cyB0byB0aGUgc3Vic2NyaWJlciBjaGFubmVsLiBUaGUgc3VibWlzc2lvbiBtYXkgZWl0aGVyIGJlIGEgZG9jdW1lbnQgcGVyIG9iamVjdCBpZiBhIHNjb3BlIGlzIGRlZmluZWQgb3IgbWF5IGJlIGEgc2luZ2xlIGRvY3VtZW50IGZvciBlYWNoIGpvYiBydW4uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXNlIEpvYiBDTiBhcyB0cmlnZ2VyIGRvY3VtZW50IGlkZW50aWZpZXI/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPklmIHNldCwgdXNlIHRoZSBqb2Igb2JqZWN0J3MgQ04gYXMgdGhlIHZhbHVlIG9mIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+U3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+cXVldWUgKHVzZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPmRpcmVjdCAoYnlwYXNzIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5TdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmc8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5TdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZnIiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+RMOpY2xlbmNoZXVyIGRlIGNhbmFsIGFib25uw6k8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+Q2UgdHJhdmFpbCBhZHJlc3NlIHVuIG91IHBsdXNpZXVycyBkb2N1bWVudHMgZMOpY2xlbmNoZXVycyAob3UgbidlbiBzb3VtZXQgcGFzKSBhdSBjYW5hbCBhYm9ubsOpLiBJbCBwZXV0IGVudm95ZXIgdW4gZG9jdW1lbnQgcGFyIG9iamV0LCBzaSB1bmUgw6l0ZW5kdWUgYSDDqXTDqSBkw6lmaW5pZSwgb3UgdW4gc2V1bCBkb2N1bWVudCDDoCBjaGFxdWUgZXjDqWN1dGlvbi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5Tb3VtZXR0cmUgdW4gZG9jdW1lbnQgZMOpY2xlbmNoZXVyIHBvdXIgbGVzIG9iamV0cyBzYW5zIGFzc29jaWF0aW9uIGRlIHBpbG90ZSA/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5VdGlsaXNlciBsZSBDTiBkdSB0cmF2YWlsIGNvbW1lIGlkZW50aWZpY2F0ZXVyIGRlIGRvY3VtZW50IGTDqWNsZW5jaGV1ciA/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPkxlIGNhcyDDqWNow6lhbnQsIHV0aWxpc2VyIGxlIENOIGRlIGwnb2JqZXQgVHJhdmFpbCBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXIuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VmFsZXVyIHNvdXJjZSBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPkNoYcOubmUgw6AgdXRpbGlzZXIgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5Nw6l0aG9kZSBkZSBzb3VtaXNzaW9uIGRlIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPmZpbGUgZCdhdHRlbnRlICh1dGlsaXNlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPmRpcmVjdGUgKMOpdml0ZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkTDqW1hcnJlciBsZSBwaWxvdGUgYXUgYmVzb2luPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+QXJyw6p0ZXIgbGUgcGlsb3RlIMOgIGxhIGZpbiBkdSB0cmFpdGVtZW50IGRlcyBkw6ljbGVuY2hldXJzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJqYSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7os7zoqq3ogIXjg4Hjg6Pjg43jg6vjg4jjg6rjgqw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+44GT44Gu44K444On44OW44Gv44K844Ot44G+44Gf44Gv6KSH5pWw44Gu44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6LO86Kqt6ICF44OB44Oj44ON44Or44Gr6YCB5L+h44GX44G+44GZ44CC44GT44Gu6YCB5L+h44Gv44K544Kz44O844OX44GM5a6a576p44GV44KM44Gm44GE44KL5aC05ZCI44Gv44Kq44OW44K444Kn44Kv44OI44GU44Go44GrMeOBpOOBruODieOCreODpeODoeODs+ODiOOAgeOBvuOBn+OBr+WQhOOCuOODp+ODluWun+ihjOOBq+WvvuOBl+OBpjHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgajjgarjgorjgb7jgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7jg4njg6njgqTjg5Djga7plqLpgKPku5jjgZHjgarjgZfjgafjgqrjg5bjgrjjgqfjgq/jg4jjgavlr77jgZnjgovjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7jgrjjg6fjg5ZDTuOCkuODiOODquOCrOODieOCreODpeODoeODs+ODiOitmOWIpeWtkOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+6Kit5a6a44GV44KM44Gm44GE44KL5aC05ZCI44CB44K444On44OW44Kq44OW44K444Kn44Kv44OI44GuQ07jgpLjg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjgr3jg7zjgrnlgKQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBmeOCi+aWh+Wtl+WIl+OBp+OBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GZ44KL44Gf44KB44Gu5pa55rOVPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPuOCreODpeODvCjjgq3jg6Pjg4Pjgrfjg6Xjga7kvb/nlKgpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUo44OQ44Kk44OR44K544Kt44Oj44OD44K344OlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lrp/ooYzjgZfjgabjgYTjgarjgYTloLTlkIjjg4njg6njgqTjg5DjgpLplovlp4vjgZnjgos8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjga7lh6bnkIbjgYzntYLkuobjgZfjgZ/loLTlkIjjg4njg6njgqTjg5DjgpLlgZzmraLjgZnjgos8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9InpoX0NOIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuiuoui0reiAhemAmumBk+inpuWPkeWZqDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7or6XkvZzkuJrlsIblkJHorqLotK3ogIXpgJrpgZPmj5DkuqQgMCDkuKrmiJblpJrkuKrop6blj5HlmajmlofmoaPjgILlpoLmnpzlrprkuYnkuobojIPlm7TvvIzlj6/ku6Xlr7nmr4/kuKrlr7nosaHmj5DkuqTkuIDkuKrmlofmoaPvvIzkuZ/lj6/ku6Xlr7nmr4/mrKHkvZzkuJrov5DooYzmj5DkuqTkuIDkuKrmlofmoaPjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7kuLrmsqHmnInpqbHliqjnqIvluo/lhbPogZTnmoTlr7nosaHmj5DkuqTop6blj5HlmajmlofmoaPlkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuWwhuKAnOS9nOS4miBDTuKAneeUqOS9nOinpuWPkeWZqOaWh+aho+eahOagh+ivhuespuWQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzorr7nva7vvIzlsIbmioror6XkvZzkuJrlr7nosaHnmoQgQ04g55So5L2c6Kem5Y+R5Zmo5YWD57Sg55qE4oCc5rqQ4oCd54m55oCn55qE5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Kem5Y+R5Zmo5YWD57Sg5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7nlKjkvZzop6blj5HlmajlhYPntKDigJzmupDigJ3nibnmgKfnmoTlgLznmoTlrZfnrKbkuLLjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuaPkOS6pOinpuWPkeWZqOaWh+aho+eahOaWueW8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7pmJ/liJfvvIjkvb/nlKjotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpe+8iOe7lei/h+i2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lkK/liqjpqbHliqjnqIvluo/vvIjlpoLmnpzmnKrov5DooYzvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7lrozmiJDlr7nop6blj5HlmajnmoTlpITnkIbml7blgZzmraLpqbHliqjnqIvluo88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9InpoX1RXIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuiogumWseiAhemAmumBk+inuOeZvOeoi+W8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7mraTlt6XkvZzmnIPmj5DkuqTpm7blgIvku6XkuIrnmoTop7jnmbzmlofku7boh7PoqILplrHogIXpgJrpgZPjgILmraTkvZzmpa3lj6/og73mr4/kuIDlgIvnianku7bmj5DkuqTkuIDku73mlofku7YgKOiLpeW3suWumue+qeevhOWcjSkg5oiW5Y+v6IO95q+P5LiA5YCL5bel5L2c5o+Q5Lqk5Zau5LiA5Lu95paH5Lu244CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB54K65rKS5pyJ6amF5YuV56iL5byP6Zec6IGv55qE54mp5Lu25o+Q5Lqk6Ke455m85paH5Lu277yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHku6XjgIzlt6XkvZwgQ07jgI0g5YGa54K66Ke455m85paH5Lu26K2Y5Yil56K877yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOioreWumu+8jOWJh+iri+S7peW3peS9nOeJqeS7tueahCBDTiDlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzlhYPntKDkvobmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPuWtl+S4su+8jOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+6Ke455m85paH5Lu255qE5o+Q5Lqk5pa55rOVPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPuS9h+WIlyAo5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lICjkuI3kvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWVn+WLlempheWLleeoi+W8jyAo6Iul5pyq5Z+36KGMKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPueVtuWujOaIkOiZleeQhuinuOeZvOeoi+W8j+aZguWBnOatoumpheWLleeoi+W8jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PC9qb2ItYWdncmVnYXRpb24+]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-Scope"/>
					<job-scope-query job-display-name="Subscriber channel trigger" job-name="cn=Job-GLAccountExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-email-server-query job-name="cn=Job-GLAccountExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-GLAccountExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-GLAccountExpires-Schedule">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJ0cnVlIiBkaXNwbGF5LW5hbWU9InhsZmlkKGpvYi1kaXNwbGF5LW5hbWUpU3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXIiIHNjaGVkdWxlPSIxNSA2ICogKiAqIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvZGVmaW5pdGlvbnM+PC9jb25maWd1cmF0aW9uLXZhbHVlcz48L2pvYi1kZWZpbml0aW9uPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImRlIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkFib25uZW50ZW5rYW5hbGF1c2zDtnNlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5NaXQgZGllc2VtIEF1ZnRyYWcgd2VyZGVuIG51bGwgb2RlciBtZWhyIEF1c2zDtnNlcmRva3VtZW50ZSBhbiBkZW4gQWJvbm5lbnRlbmthbmFsIGFiZ2VzZW5kZXQuIERhYmVpIGthbm4gZXMgc2ljaCB1bSBlaW4gRG9rdW1lbnQgcHJvIE9iamVrdCBoYW5kZWxuLCBzb2Zlcm4gZWluIEJlcmVpY2ggZGVmaW5pZXJ0IHd1cmRlLCBvZGVyIHVtIGVpbiBlaW56ZWxuZXMgRG9rdW1lbnQgZsO8ciBqZWRlIEF1ZnRyYWdzYXVzZsO8aHJ1bmcuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+QXVzbMO2c2VyZG9rdW1lbnQgZsO8ciBPYmpla3RlIG9obmUgVHJlaWJlcnp1b3JkbnVuZyBhYnNlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPkF1ZnRyYWdzLUNOIGFscyBBdXNsw7ZzZXJkb2t1bWVudGJlemVpY2huZXIgdmVyd2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5XZW5uIGZlc3RnZWxlZ3QsIHdpcmQgZGVyIENOIGRlcyBBdWZ0cmFnc29iamVrdHMgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5VcnNwcnVuZ3N3ZXJ0IGRlcyBBdXNsw7ZzZXJlbGVtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+WmVpY2hlbmtldHRlLCBkaWUgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldCB3ZXJkZW4gc29sbC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZGUgZsO8ciBkYXMgQWJzZW5kZW4gdm9uIEF1c2zDtnNlcmRva3VtZW50ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+V2FydGVzY2hsYW5nZSAoQ2FjaGUgdmVyd2VuZGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+RGlyZWt0IChDYWNoZSDDvGJlcmdlaGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIHN0YXJ0ZW4sIHNvZmVybiBlciBuaWNodCBiZXJlaXRzIGzDpHVmdDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgbmFjaCBWZXJhcmJlaXRlbiB2b24gQXVzbMO2c2VybiBhbmhhbHRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZW4iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+U3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+VGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5JZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWU8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPnF1ZXVlICh1c2UgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3QgKGJ5cGFzcyBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocyk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImZyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkTDqWNsZW5jaGV1ciBkZSBjYW5hbCBhYm9ubsOpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPkNlIHRyYXZhaWwgYWRyZXNzZSB1biBvdSBwbHVzaWV1cnMgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnMgKG91IG4nZW4gc291bWV0IHBhcykgYXUgY2FuYWwgYWJvbm7DqS4gSWwgcGV1dCBlbnZveWVyIHVuIGRvY3VtZW50IHBhciBvYmpldCwgc2kgdW5lIMOpdGVuZHVlIGEgw6l0w6kgZMOpZmluaWUsIG91IHVuIHNldWwgZG9jdW1lbnQgw6AgY2hhcXVlIGV4w6ljdXRpb24uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U291bWV0dHJlIHVuIGRvY3VtZW50IGTDqWNsZW5jaGV1ciBwb3VyIGxlcyBvYmpldHMgc2FucyBhc3NvY2lhdGlvbiBkZSBwaWxvdGUgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXRpbGlzZXIgbGUgQ04gZHUgdHJhdmFpbCBjb21tZSBpZGVudGlmaWNhdGV1ciBkZSBkb2N1bWVudCBkw6ljbGVuY2hldXIgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5MZSBjYXMgw6ljaMOpYW50LCB1dGlsaXNlciBsZSBDTiBkZSBsJ29iamV0IFRyYXZhaWwgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlZhbGV1ciBzb3VyY2UgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5DaGHDrm5lIMOgIHV0aWxpc2VyIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TcOpdGhvZGUgZGUgc291bWlzc2lvbiBkZSBkb2N1bWVudHMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5maWxlIGQnYXR0ZW50ZSAodXRpbGlzZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3RlICjDqXZpdGVyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5Ew6ltYXJyZXIgbGUgcGlsb3RlIGF1IGJlc29pbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkFycsOqdGVyIGxlIHBpbG90ZSDDoCBsYSBmaW4gZHUgdHJhaXRlbWVudCBkZXMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iamEiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6LO86Kqt6ICF44OB44Oj44ON44Or44OI44Oq44KsPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuOBk+OBruOCuOODp+ODluOBr+OCvOODreOBvuOBn+OBr+ikh+aVsOOBruODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkuizvOiqreiAheODgeODo+ODjeODq+OBq+mAgeS/oeOBl+OBvuOBmeOAguOBk+OBrumAgeS/oeOBr+OCueOCs+ODvOODl+OBjOWumue+qeOBleOCjOOBpuOBhOOCi+WgtOWQiOOBr+OCquODluOCuOOCp+OCr+ODiOOBlOOBqOOBqzHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgIHjgb7jgZ/jga/lkITjgrjjg6fjg5blrp/ooYzjgavlr77jgZfjgaYx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44Go44Gq44KK44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+44OJ44Op44Kk44OQ44Gu6Zai6YCj5LuY44GR44Gq44GX44Gn44Kq44OW44K444Kn44Kv44OI44Gr5a++44GZ44KL44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+44K444On44OWQ07jgpLjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jorZjliKXlrZDjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuioreWumuOBleOCjOOBpuOBhOOCi+WgtOWQiOOAgeOCuOODp+ODluOCquODluOCuOOCp+OCr+ODiOOBrkNO44KS44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GX44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44K944O844K55YCkPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZnjgovmloflrZfliJfjgafjgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBmeOCi+OBn+OCgeOBruaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7jgq3jg6Xjg7wo44Kt44Oj44OD44K344Ol44Gu5L2/55SoKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lKOODkOOCpOODkeOCueOCreODo+ODg+OCt+ODpSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6f6KGM44GX44Gm44GE44Gq44GE5aC05ZCI44OJ44Op44Kk44OQ44KS6ZaL5aeL44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44Gu5Yem55CG44GM57WC5LqG44GX44Gf5aC05ZCI44OJ44Op44Kk44OQ44KS5YGc5q2i44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9DTiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7orqLotK3ogIXpgJrpgZPop6blj5Hlmag8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+6K+l5L2c5Lia5bCG5ZCR6K6i6LSt6ICF6YCa6YGT5o+Q5LqkIDAg5Liq5oiW5aSa5Liq6Kem5Y+R5Zmo5paH5qGj44CC5aaC5p6c5a6a5LmJ5LqG6IyD5Zu077yM5Y+v5Lul5a+55q+P5Liq5a+56LGh5o+Q5Lqk5LiA5Liq5paH5qGj77yM5Lmf5Y+v5Lul5a+55q+P5qyh5L2c5Lia6L+Q6KGM5o+Q5Lqk5LiA5Liq5paH5qGj44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5Li65rKh5pyJ6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7lsIbigJzkvZzkuJogQ07igJ3nlKjkvZzop6blj5HlmajmlofmoaPnmoTmoIfor4bnrKblkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6K6+572u77yM5bCG5oqK6K+l5L2c5Lia5a+56LGh55qEIENOIOeUqOS9nOinpuWPkeWZqOWFg+e0oOeahOKAnOa6kOKAneeJueaAp+eahOWAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinpuWPkeWZqOWFg+e0oOa6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+55So5L2c6Kem5Y+R5Zmo5YWD57Sg4oCc5rqQ4oCd54m55oCn55qE5YC855qE5a2X56ym5Liy44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7mj5DkuqTop6blj5HlmajmlofmoaPnmoTmlrnlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+6Zif5YiX77yI5L2/55So6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqXvvIjnu5Xov4fotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZCv5Yqo6amx5Yqo56iL5bqP77yI5aaC5p6c5pyq6L+Q6KGM77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6M5oiQ5a+56Kem5Y+R5Zmo55qE5aSE55CG5pe25YGc5q2i6amx5Yqo56iL5bqPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9UVyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7oqILplrHogIXpgJrpgZPop7jnmbznqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+5q2k5bel5L2c5pyD5o+Q5Lqk6Zu25YCL5Lul5LiK55qE6Ke455m85paH5Lu26Iez6KiC6Zax6ICF6YCa6YGT44CC5q2k5L2c5qWt5Y+v6IO95q+P5LiA5YCL54mp5Lu25o+Q5Lqk5LiA5Lu95paH5Lu2ICjoi6Xlt7Llrprnvqnnr4TlnI0pIOaIluWPr+iDveavj+S4gOWAi+W3peS9nOaPkOS6pOWWruS4gOS7veaWh+S7tuOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeeCuuaykuaciempheWLleeoi+W8j+mXnOiBr+eahOeJqeS7tuaPkOS6pOinuOeZvOaWh+S7tu+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB5Lul44CM5bel5L2cIENO44CNIOWBmueCuuinuOeZvOaWh+S7tuitmOWIpeeivO+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzoqK3lrprvvIzliYfoq4vku6Xlt6XkvZznianku7bnmoQgQ04g5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Ke455m85YWD57Sg5L6G5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lrZfkuLLvvIzlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuinuOeZvOaWh+S7tueahOaPkOS6pOaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7kvYfliJcgKOS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSAo5LiN5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7llZ/li5XpqYXli5XnqIvlvI8gKOiLpeacquWft+ihjCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7nlbblrozmiJDomZXnkIbop7jnmbznqIvlvI/mmYLlgZzmraLpqYXli5XnqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjwvam9iLWFnZ3JlZ2F0aW9uPg==]]></ds-value>
					</ds-attribute>
					<job-email-server-query job-name="cn=Job-GLAccountExpires-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-GLAccountExpires-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-LWDCheck">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value><![CDATA[0]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value><![CDATA[0]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvZGVmaW5pdGlvbnM+PC9jb25maWd1cmF0aW9uLXZhbHVlcz48L2pvYi1kZWZpbml0aW9uPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImRlIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkFib25uZW50ZW5rYW5hbGF1c2zDtnNlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5NaXQgZGllc2VtIEF1ZnRyYWcgd2VyZGVuIG51bGwgb2RlciBtZWhyIEF1c2zDtnNlcmRva3VtZW50ZSBhbiBkZW4gQWJvbm5lbnRlbmthbmFsIGFiZ2VzZW5kZXQuIERhYmVpIGthbm4gZXMgc2ljaCB1bSBlaW4gRG9rdW1lbnQgcHJvIE9iamVrdCBoYW5kZWxuLCBzb2Zlcm4gZWluIEJlcmVpY2ggZGVmaW5pZXJ0IHd1cmRlLCBvZGVyIHVtIGVpbiBlaW56ZWxuZXMgRG9rdW1lbnQgZsO8ciBqZWRlIEF1ZnRyYWdzYXVzZsO8aHJ1bmcuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+QXVzbMO2c2VyZG9rdW1lbnQgZsO8ciBPYmpla3RlIG9obmUgVHJlaWJlcnp1b3JkbnVuZyBhYnNlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPkF1ZnRyYWdzLUNOIGFscyBBdXNsw7ZzZXJkb2t1bWVudGJlemVpY2huZXIgdmVyd2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5XZW5uIGZlc3RnZWxlZ3QsIHdpcmQgZGVyIENOIGRlcyBBdWZ0cmFnc29iamVrdHMgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5VcnNwcnVuZ3N3ZXJ0IGRlcyBBdXNsw7ZzZXJlbGVtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+WmVpY2hlbmtldHRlLCBkaWUgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldCB3ZXJkZW4gc29sbC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZGUgZsO8ciBkYXMgQWJzZW5kZW4gdm9uIEF1c2zDtnNlcmRva3VtZW50ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+V2FydGVzY2hsYW5nZSAoQ2FjaGUgdmVyd2VuZGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+RGlyZWt0IChDYWNoZSDDvGJlcmdlaGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIHN0YXJ0ZW4sIHNvZmVybiBlciBuaWNodCBiZXJlaXRzIGzDpHVmdDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgbmFjaCBWZXJhcmJlaXRlbiB2b24gQXVzbMO2c2VybiBhbmhhbHRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZW4iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+U3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+VGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5JZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWU8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPnF1ZXVlICh1c2UgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3QgKGJ5cGFzcyBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocyk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImZyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkTDqWNsZW5jaGV1ciBkZSBjYW5hbCBhYm9ubsOpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPkNlIHRyYXZhaWwgYWRyZXNzZSB1biBvdSBwbHVzaWV1cnMgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnMgKG91IG4nZW4gc291bWV0IHBhcykgYXUgY2FuYWwgYWJvbm7DqS4gSWwgcGV1dCBlbnZveWVyIHVuIGRvY3VtZW50IHBhciBvYmpldCwgc2kgdW5lIMOpdGVuZHVlIGEgw6l0w6kgZMOpZmluaWUsIG91IHVuIHNldWwgZG9jdW1lbnQgw6AgY2hhcXVlIGV4w6ljdXRpb24uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U291bWV0dHJlIHVuIGRvY3VtZW50IGTDqWNsZW5jaGV1ciBwb3VyIGxlcyBvYmpldHMgc2FucyBhc3NvY2lhdGlvbiBkZSBwaWxvdGUgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXRpbGlzZXIgbGUgQ04gZHUgdHJhdmFpbCBjb21tZSBpZGVudGlmaWNhdGV1ciBkZSBkb2N1bWVudCBkw6ljbGVuY2hldXIgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5MZSBjYXMgw6ljaMOpYW50LCB1dGlsaXNlciBsZSBDTiBkZSBsJ29iamV0IFRyYXZhaWwgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlZhbGV1ciBzb3VyY2UgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5DaGHDrm5lIMOgIHV0aWxpc2VyIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TcOpdGhvZGUgZGUgc291bWlzc2lvbiBkZSBkb2N1bWVudHMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5maWxlIGQnYXR0ZW50ZSAodXRpbGlzZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3RlICjDqXZpdGVyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5Ew6ltYXJyZXIgbGUgcGlsb3RlIGF1IGJlc29pbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkFycsOqdGVyIGxlIHBpbG90ZSDDoCBsYSBmaW4gZHUgdHJhaXRlbWVudCBkZXMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iamEiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6LO86Kqt6ICF44OB44Oj44ON44Or44OI44Oq44KsPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuOBk+OBruOCuOODp+ODluOBr+OCvOODreOBvuOBn+OBr+ikh+aVsOOBruODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkuizvOiqreiAheODgeODo+ODjeODq+OBq+mAgeS/oeOBl+OBvuOBmeOAguOBk+OBrumAgeS/oeOBr+OCueOCs+ODvOODl+OBjOWumue+qeOBleOCjOOBpuOBhOOCi+WgtOWQiOOBr+OCquODluOCuOOCp+OCr+ODiOOBlOOBqOOBqzHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgIHjgb7jgZ/jga/lkITjgrjjg6fjg5blrp/ooYzjgavlr77jgZfjgaYx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44Go44Gq44KK44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+44OJ44Op44Kk44OQ44Gu6Zai6YCj5LuY44GR44Gq44GX44Gn44Kq44OW44K444Kn44Kv44OI44Gr5a++44GZ44KL44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+44K444On44OWQ07jgpLjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jorZjliKXlrZDjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuioreWumuOBleOCjOOBpuOBhOOCi+WgtOWQiOOAgeOCuOODp+ODluOCquODluOCuOOCp+OCr+ODiOOBrkNO44KS44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GX44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44K944O844K55YCkPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZnjgovmloflrZfliJfjgafjgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBmeOCi+OBn+OCgeOBruaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7jgq3jg6Xjg7wo44Kt44Oj44OD44K344Ol44Gu5L2/55SoKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lKOODkOOCpOODkeOCueOCreODo+ODg+OCt+ODpSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6f6KGM44GX44Gm44GE44Gq44GE5aC05ZCI44OJ44Op44Kk44OQ44KS6ZaL5aeL44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44Gu5Yem55CG44GM57WC5LqG44GX44Gf5aC05ZCI44OJ44Op44Kk44OQ44KS5YGc5q2i44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9DTiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7orqLotK3ogIXpgJrpgZPop6blj5Hlmag8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+6K+l5L2c5Lia5bCG5ZCR6K6i6LSt6ICF6YCa6YGT5o+Q5LqkIDAg5Liq5oiW5aSa5Liq6Kem5Y+R5Zmo5paH5qGj44CC5aaC5p6c5a6a5LmJ5LqG6IyD5Zu077yM5Y+v5Lul5a+55q+P5Liq5a+56LGh5o+Q5Lqk5LiA5Liq5paH5qGj77yM5Lmf5Y+v5Lul5a+55q+P5qyh5L2c5Lia6L+Q6KGM5o+Q5Lqk5LiA5Liq5paH5qGj44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5Li65rKh5pyJ6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7lsIbigJzkvZzkuJogQ07igJ3nlKjkvZzop6blj5HlmajmlofmoaPnmoTmoIfor4bnrKblkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6K6+572u77yM5bCG5oqK6K+l5L2c5Lia5a+56LGh55qEIENOIOeUqOS9nOinpuWPkeWZqOWFg+e0oOeahOKAnOa6kOKAneeJueaAp+eahOWAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinpuWPkeWZqOWFg+e0oOa6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+55So5L2c6Kem5Y+R5Zmo5YWD57Sg4oCc5rqQ4oCd54m55oCn55qE5YC855qE5a2X56ym5Liy44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7mj5DkuqTop6blj5HlmajmlofmoaPnmoTmlrnlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+6Zif5YiX77yI5L2/55So6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqXvvIjnu5Xov4fotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZCv5Yqo6amx5Yqo56iL5bqP77yI5aaC5p6c5pyq6L+Q6KGM77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6M5oiQ5a+56Kem5Y+R5Zmo55qE5aSE55CG5pe25YGc5q2i6amx5Yqo56iL5bqPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9UVyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7oqILplrHogIXpgJrpgZPop7jnmbznqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+5q2k5bel5L2c5pyD5o+Q5Lqk6Zu25YCL5Lul5LiK55qE6Ke455m85paH5Lu26Iez6KiC6Zax6ICF6YCa6YGT44CC5q2k5L2c5qWt5Y+v6IO95q+P5LiA5YCL54mp5Lu25o+Q5Lqk5LiA5Lu95paH5Lu2ICjoi6Xlt7Llrprnvqnnr4TlnI0pIOaIluWPr+iDveavj+S4gOWAi+W3peS9nOaPkOS6pOWWruS4gOS7veaWh+S7tuOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeeCuuaykuaciempheWLleeoi+W8j+mXnOiBr+eahOeJqeS7tuaPkOS6pOinuOeZvOaWh+S7tu+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB5Lul44CM5bel5L2cIENO44CNIOWBmueCuuinuOeZvOaWh+S7tuitmOWIpeeivO+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzoqK3lrprvvIzliYfoq4vku6Xlt6XkvZznianku7bnmoQgQ04g5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Ke455m85YWD57Sg5L6G5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lrZfkuLLvvIzlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuinuOeZvOaWh+S7tueahOaPkOS6pOaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7kvYfliJcgKOS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSAo5LiN5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7llZ/li5XpqYXli5XnqIvlvI8gKOiLpeacquWft+ihjCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7nlbblrozmiJDomZXnkIbop7jnmbznqIvlvI/mmYLlgZzmraLpqYXli5XnqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjwvam9iLWFnZ3JlZ2F0aW9uPg==]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-Scope"/>
					<job-scope-query job-display-name="Subscriber channel trigger" job-name="cn=Job-LWDCheck,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-email-server-query job-name="cn=Job-LWDCheck,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-LWDCheck,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-LWDCheck-Schedule">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY2hlZHVsZT0iMTUgNSAqICogKiIgc2NvcGUtcmVxdWlyZWQ9ImZhbHNlIiB0eXBlPSJqYXZhIj48ZGVzY3JpcHRpb24+eGxmaWQoam9iLWRlc2NyaXB0aW9uKVRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L2Rlc2NyaXB0aW9uPjxjb250YWlubWVudD5EaXJYTUwtRHJpdmVyPC9jb250YWlubWVudD48amF2YS1jbGFzcz5jb20ubm92ZWxsLm5kcy5kaXJ4bWwuam9iLnRyaWdnZXIuVHJpZ2dlcjwvamF2YS1jbGFzcz48Y29uZmlndXJhdGlvbi12YWx1ZXM+PGRlZmluaXRpb25zPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQocHJvY2Vzcy11bmFzc29jaWF0ZWQpU3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPyIgbmFtZT0icHJvY2Vzcy11bmFzc29jaWF0ZWQiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodXNlLWpvYi1jbilVc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj8iIG5hbWU9InVzZS1qb2ItY24iIHR5cGU9ImJvb2xlYW4iPjxkZXNjcmlwdGlvbj54bGZpZCh1c2Utam9iLWNuLWRlc2MpSWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L2Rlc2NyaXB0aW9uPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9ImZhbHNlIj48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHRyaWdnZXItc291cmNlKVRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWUiIG5hbWU9InRyaWdnZXItc291cmNlIiB0eXBlPSJzdHJpbmciPjxkZXNjcmlwdGlvbj54bGZpZCh0cmlnZ2VyLXNvdXJjZS1kZXNjKVN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPjE8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1tZXRob2QpTWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzIiBuYW1lPSJzdWJtaXQtbWV0aG9kIiB0eXBlPSJlbnVtIj48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtcXVldWUpcXVldWUgKHVzZSBjYWNoZSkiPnN1Ym1pdC1xdWV1ZTwvZW51bS1jaG9pY2U+PGVudW0tY2hvaWNlIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LWRpcmVjdClkaXJlY3QgKGJ5cGFzcyBjYWNoZSkiPnN1Ym1pdC1kaXJlY3Q8L2VudW0tY2hvaWNlPjx2YWx1ZT5zdWJtaXQtZGlyZWN0PC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InN1Ym1pdC1kaXJlY3QiPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN0YXJ0LWRyaXZlcilTdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmciIG5hbWU9InN0YXJ0LWRyaXZlciIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPmZhbHNlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InRydWUiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RvcC1kcml2ZXIpU3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocykiIG5hbWU9InN0b3AtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+dHJ1ZTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L2RlZmluaXRpb25zPjwvY29uZmlndXJhdGlvbi12YWx1ZXM+PC9qb2ItZGVmaW5pdGlvbj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJkZSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5BYm9ubmVudGVua2FuYWxhdXNsw7ZzZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+TWl0IGRpZXNlbSBBdWZ0cmFnIHdlcmRlbiBudWxsIG9kZXIgbWVociBBdXNsw7ZzZXJkb2t1bWVudGUgYW4gZGVuIEFib25uZW50ZW5rYW5hbCBhYmdlc2VuZGV0LiBEYWJlaSBrYW5uIGVzIHNpY2ggdW0gZWluIERva3VtZW50IHBybyBPYmpla3QgaGFuZGVsbiwgc29mZXJuIGVpbiBCZXJlaWNoIGRlZmluaWVydCB3dXJkZSwgb2RlciB1bSBlaW4gZWluemVsbmVzIERva3VtZW50IGbDvHIgamVkZSBBdWZ0cmFnc2F1c2bDvGhydW5nLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPkF1c2zDtnNlcmRva3VtZW50IGbDvHIgT2JqZWt0ZSBvaG5lIFRyZWliZXJ6dW9yZG51bmcgYWJzZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5BdWZ0cmFncy1DTiBhbHMgQXVzbMO2c2VyZG9rdW1lbnRiZXplaWNobmVyIHZlcndlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+V2VubiBmZXN0Z2VsZWd0LCB3aXJkIGRlciBDTiBkZXMgQXVmdHJhZ3NvYmpla3RzIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VXJzcHJ1bmdzd2VydCBkZXMgQXVzbMO2c2VyZWxlbWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlplaWNoZW5rZXR0ZSwgZGllIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQgd2VyZGVuIHNvbGwuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2RlIGbDvHIgZGFzIEFic2VuZGVuIHZvbiBBdXNsw7ZzZXJkb2t1bWVudGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPldhcnRlc2NobGFuZ2UgKENhY2hlIHZlcndlbmRlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPkRpcmVrdCAoQ2FjaGUgw7xiZXJnZWhlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBzdGFydGVuLCBzb2Zlcm4gZXIgbmljaHQgYmVyZWl0cyBsw6R1ZnQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIG5hY2ggVmVyYXJiZWl0ZW4gdm9uIEF1c2zDtnNlcm4gYW5oYWx0ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImVuIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPlN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPlRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5TdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5Vc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+SWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5UcmlnZ2VyIGVsZW1lbnQgc291cmNlIHZhbHVlPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5TdHJpbmcgdG8gdXNlIGFzIHRoZSB2YWx1ZSBmb3IgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZCBmb3Igc3VibWl0dGluZyB0cmlnZ2VyIGRvY3VtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5xdWV1ZSAodXNlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0IChieXBhc3MgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0b3AgZHJpdmVyIHdoZW4gZmluaXNoZWQgcHJvY2Vzc2luZyB0cmlnZ2VyKHMpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJmciIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5Ew6ljbGVuY2hldXIgZGUgY2FuYWwgYWJvbm7DqTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5DZSB0cmF2YWlsIGFkcmVzc2UgdW4gb3UgcGx1c2lldXJzIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzIChvdSBuJ2VuIHNvdW1ldCBwYXMpIGF1IGNhbmFsIGFib25uw6kuIElsIHBldXQgZW52b3llciB1biBkb2N1bWVudCBwYXIgb2JqZXQsIHNpIHVuZSDDqXRlbmR1ZSBhIMOpdMOpIGTDqWZpbmllLCBvdSB1biBzZXVsIGRvY3VtZW50IMOgIGNoYXF1ZSBleMOpY3V0aW9uLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlNvdW1ldHRyZSB1biBkb2N1bWVudCBkw6ljbGVuY2hldXIgcG91ciBsZXMgb2JqZXRzIHNhbnMgYXNzb2NpYXRpb24gZGUgcGlsb3RlID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlV0aWxpc2VyIGxlIENOIGR1IHRyYXZhaWwgY29tbWUgaWRlbnRpZmljYXRldXIgZGUgZG9jdW1lbnQgZMOpY2xlbmNoZXVyID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+TGUgY2FzIMOpY2jDqWFudCwgdXRpbGlzZXIgbGUgQ04gZGUgbCdvYmpldCBUcmF2YWlsIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1ci48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5WYWxldXIgc291cmNlIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+Q2hhw65uZSDDoCB1dGlsaXNlciBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk3DqXRob2RlIGRlIHNvdW1pc3Npb24gZGUgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+ZmlsZSBkJ2F0dGVudGUgKHV0aWxpc2VyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0ZSAow6l2aXRlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+RMOpbWFycmVyIGxlIHBpbG90ZSBhdSBiZXNvaW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5BcnLDqnRlciBsZSBwaWxvdGUgw6AgbGEgZmluIGR1IHRyYWl0ZW1lbnQgZGVzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImphIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuizvOiqreiAheODgeODo+ODjeODq+ODiOODquOCrDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7jgZPjga7jgrjjg6fjg5bjga/jgrzjg63jgb7jgZ/jga/opIfmlbDjga7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLos7zoqq3ogIXjg4Hjg6Pjg43jg6vjgavpgIHkv6HjgZfjgb7jgZnjgILjgZPjga7pgIHkv6Hjga/jgrnjgrPjg7zjg5fjgYzlrprnvqnjgZXjgozjgabjgYTjgovloLTlkIjjga/jgqrjg5bjgrjjgqfjgq/jg4jjgZTjgajjgasx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44CB44G+44Gf44Gv5ZCE44K444On44OW5a6f6KGM44Gr5a++44GX44GmMeOBpOOBruODieOCreODpeODoeODs+ODiOOBqOOBquOCiuOBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuODieODqeOCpOODkOOBrumWoumAo+S7mOOBkeOBquOBl+OBp+OCquODluOCuOOCp+OCr+ODiOOBq+WvvuOBmeOCi+ODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuOCuOODp+ODlkNO44KS44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI6K2Y5Yil5a2Q44Go44GX44Gm5L2/55So44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7oqK3lrprjgZXjgozjgabjgYTjgovloLTlkIjjgIHjgrjjg6fjg5bjgqrjg5bjgrjjgqfjgq/jg4jjga5DTuOCkuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOCveODvOOCueWApDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GZ44KL5paH5a2X5YiX44Gn44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZnjgovjgZ/jgoHjga7mlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+44Kt44Ol44O8KOOCreODo+ODg+OCt+ODpeOBruS9v+eUqCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSjjg5DjgqTjg5Hjgrnjgq3jg6Pjg4Pjgrfjg6UpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWun+ihjOOBl+OBpuOBhOOBquOBhOWgtOWQiOODieODqeOCpOODkOOCkumWi+Wni+OBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOOBruWHpueQhuOBjOe1guS6huOBl+OBn+WgtOWQiOODieODqeOCpOODkOOCkuWBnOatouOBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfQ04iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6K6i6LSt6ICF6YCa6YGT6Kem5Y+R5ZmoPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuivpeS9nOS4muWwhuWQkeiuoui0reiAhemAmumBk+aPkOS6pCAwIOS4quaIluWkmuS4quinpuWPkeWZqOaWh+aho+OAguWmguaenOWumuS5ieS6huiMg+WbtO+8jOWPr+S7peWvueavj+S4quWvueixoeaPkOS6pOS4gOS4quaWh+aho++8jOS5n+WPr+S7peWvueavj+asoeS9nOS4mui/kOihjOaPkOS6pOS4gOS4quaWh+aho+OAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuS4uuayoeaciempseWKqOeoi+W6j+WFs+iBlOeahOWvueixoeaPkOS6pOinpuWPkeWZqOaWh+aho+WQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5bCG4oCc5L2c5LiaIENO4oCd55So5L2c6Kem5Y+R5Zmo5paH5qGj55qE5qCH6K+G56ym5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOiuvue9ru+8jOWwhuaKiuivpeS9nOS4muWvueixoeeahCBDTiDnlKjkvZzop6blj5HlmajlhYPntKDnmoTigJzmupDigJ3nibnmgKfnmoTlgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op6blj5HlmajlhYPntKDmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPueUqOS9nOinpuWPkeWZqOWFg+e0oOKAnOa6kOKAneeJueaAp+eahOWAvOeahOWtl+espuS4suOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj55qE5pa55byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPumYn+WIl++8iOS9v+eUqOi2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6l77yI57uV6L+H6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWQr+WKqOmpseWKqOeoi+W6j++8iOWmguaenOacqui/kOihjO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWujOaIkOWvueinpuWPkeWZqOeahOWkhOeQhuaXtuWBnOatoumpseWKqOeoi+W6jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfVFciIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6KiC6Zax6ICF6YCa6YGT6Ke455m856iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuatpOW3peS9nOacg+aPkOS6pOmbtuWAi+S7peS4iueahOinuOeZvOaWh+S7tuiHs+iogumWseiAhemAmumBk+OAguatpOS9nOalreWPr+iDveavj+S4gOWAi+eJqeS7tuaPkOS6pOS4gOS7veaWh+S7tiAo6Iul5bey5a6a576p56+E5ZyNKSDmiJblj6/og73mr4/kuIDlgIvlt6XkvZzmj5DkuqTllq7kuIDku73mlofku7bjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHngrrmspLmnInpqYXli5XnqIvlvI/pl5zoga/nmoTnianku7bmj5DkuqTop7jnmbzmlofku7bvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeS7peOAjOW3peS9nCBDTuOAjSDlgZrngrrop7jnmbzmlofku7borZjliKXnorzvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6Kit5a6a77yM5YmH6KuL5Lul5bel5L2c54mp5Lu255qEIENOIOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinuOeZvOWFg+e0oOS+hua6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+5a2X5Liy77yM5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzmlofku7bnmoTmj5DkuqTmlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+5L2H5YiXICjkvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUgKOS4jeS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZWf5YuV6amF5YuV56iL5byPICjoi6XmnKrln7fooYwpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+55W25a6M5oiQ6JmV55CG6Ke455m856iL5byP5pmC5YGc5q2i6amF5YuV56iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48L2pvYi1hZ2dyZWdhdGlvbj4=]]></ds-value>
					</ds-attribute>
					<job-email-server-query job-name="cn=Job-LWDCheck-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-LWDCheck-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-ManagerUpdate-MWFID">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value><![CDATA[0]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value><![CDATA[0]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvZGVmaW5pdGlvbnM+PC9jb25maWd1cmF0aW9uLXZhbHVlcz48L2pvYi1kZWZpbml0aW9uPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImRlIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkFib25uZW50ZW5rYW5hbGF1c2zDtnNlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5NaXQgZGllc2VtIEF1ZnRyYWcgd2VyZGVuIG51bGwgb2RlciBtZWhyIEF1c2zDtnNlcmRva3VtZW50ZSBhbiBkZW4gQWJvbm5lbnRlbmthbmFsIGFiZ2VzZW5kZXQuIERhYmVpIGthbm4gZXMgc2ljaCB1bSBlaW4gRG9rdW1lbnQgcHJvIE9iamVrdCBoYW5kZWxuLCBzb2Zlcm4gZWluIEJlcmVpY2ggZGVmaW5pZXJ0IHd1cmRlLCBvZGVyIHVtIGVpbiBlaW56ZWxuZXMgRG9rdW1lbnQgZsO8ciBqZWRlIEF1ZnRyYWdzYXVzZsO8aHJ1bmcuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+QXVzbMO2c2VyZG9rdW1lbnQgZsO8ciBPYmpla3RlIG9obmUgVHJlaWJlcnp1b3JkbnVuZyBhYnNlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPkF1ZnRyYWdzLUNOIGFscyBBdXNsw7ZzZXJkb2t1bWVudGJlemVpY2huZXIgdmVyd2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5XZW5uIGZlc3RnZWxlZ3QsIHdpcmQgZGVyIENOIGRlcyBBdWZ0cmFnc29iamVrdHMgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5VcnNwcnVuZ3N3ZXJ0IGRlcyBBdXNsw7ZzZXJlbGVtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+WmVpY2hlbmtldHRlLCBkaWUgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldCB3ZXJkZW4gc29sbC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZGUgZsO8ciBkYXMgQWJzZW5kZW4gdm9uIEF1c2zDtnNlcmRva3VtZW50ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+V2FydGVzY2hsYW5nZSAoQ2FjaGUgdmVyd2VuZGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+RGlyZWt0IChDYWNoZSDDvGJlcmdlaGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIHN0YXJ0ZW4sIHNvZmVybiBlciBuaWNodCBiZXJlaXRzIGzDpHVmdDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgbmFjaCBWZXJhcmJlaXRlbiB2b24gQXVzbMO2c2VybiBhbmhhbHRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZW4iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+U3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+VGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5JZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWU8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPnF1ZXVlICh1c2UgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3QgKGJ5cGFzcyBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocyk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImZyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkTDqWNsZW5jaGV1ciBkZSBjYW5hbCBhYm9ubsOpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPkNlIHRyYXZhaWwgYWRyZXNzZSB1biBvdSBwbHVzaWV1cnMgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnMgKG91IG4nZW4gc291bWV0IHBhcykgYXUgY2FuYWwgYWJvbm7DqS4gSWwgcGV1dCBlbnZveWVyIHVuIGRvY3VtZW50IHBhciBvYmpldCwgc2kgdW5lIMOpdGVuZHVlIGEgw6l0w6kgZMOpZmluaWUsIG91IHVuIHNldWwgZG9jdW1lbnQgw6AgY2hhcXVlIGV4w6ljdXRpb24uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U291bWV0dHJlIHVuIGRvY3VtZW50IGTDqWNsZW5jaGV1ciBwb3VyIGxlcyBvYmpldHMgc2FucyBhc3NvY2lhdGlvbiBkZSBwaWxvdGUgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXRpbGlzZXIgbGUgQ04gZHUgdHJhdmFpbCBjb21tZSBpZGVudGlmaWNhdGV1ciBkZSBkb2N1bWVudCBkw6ljbGVuY2hldXIgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5MZSBjYXMgw6ljaMOpYW50LCB1dGlsaXNlciBsZSBDTiBkZSBsJ29iamV0IFRyYXZhaWwgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlZhbGV1ciBzb3VyY2UgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5DaGHDrm5lIMOgIHV0aWxpc2VyIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TcOpdGhvZGUgZGUgc291bWlzc2lvbiBkZSBkb2N1bWVudHMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5maWxlIGQnYXR0ZW50ZSAodXRpbGlzZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3RlICjDqXZpdGVyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5Ew6ltYXJyZXIgbGUgcGlsb3RlIGF1IGJlc29pbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkFycsOqdGVyIGxlIHBpbG90ZSDDoCBsYSBmaW4gZHUgdHJhaXRlbWVudCBkZXMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iamEiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6LO86Kqt6ICF44OB44Oj44ON44Or44OI44Oq44KsPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuOBk+OBruOCuOODp+ODluOBr+OCvOODreOBvuOBn+OBr+ikh+aVsOOBruODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkuizvOiqreiAheODgeODo+ODjeODq+OBq+mAgeS/oeOBl+OBvuOBmeOAguOBk+OBrumAgeS/oeOBr+OCueOCs+ODvOODl+OBjOWumue+qeOBleOCjOOBpuOBhOOCi+WgtOWQiOOBr+OCquODluOCuOOCp+OCr+ODiOOBlOOBqOOBqzHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgIHjgb7jgZ/jga/lkITjgrjjg6fjg5blrp/ooYzjgavlr77jgZfjgaYx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44Go44Gq44KK44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+44OJ44Op44Kk44OQ44Gu6Zai6YCj5LuY44GR44Gq44GX44Gn44Kq44OW44K444Kn44Kv44OI44Gr5a++44GZ44KL44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+44K444On44OWQ07jgpLjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jorZjliKXlrZDjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuioreWumuOBleOCjOOBpuOBhOOCi+WgtOWQiOOAgeOCuOODp+ODluOCquODluOCuOOCp+OCr+ODiOOBrkNO44KS44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GX44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44K944O844K55YCkPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZnjgovmloflrZfliJfjgafjgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBmeOCi+OBn+OCgeOBruaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7jgq3jg6Xjg7wo44Kt44Oj44OD44K344Ol44Gu5L2/55SoKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lKOODkOOCpOODkeOCueOCreODo+ODg+OCt+ODpSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6f6KGM44GX44Gm44GE44Gq44GE5aC05ZCI44OJ44Op44Kk44OQ44KS6ZaL5aeL44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44Gu5Yem55CG44GM57WC5LqG44GX44Gf5aC05ZCI44OJ44Op44Kk44OQ44KS5YGc5q2i44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9DTiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7orqLotK3ogIXpgJrpgZPop6blj5Hlmag8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+6K+l5L2c5Lia5bCG5ZCR6K6i6LSt6ICF6YCa6YGT5o+Q5LqkIDAg5Liq5oiW5aSa5Liq6Kem5Y+R5Zmo5paH5qGj44CC5aaC5p6c5a6a5LmJ5LqG6IyD5Zu077yM5Y+v5Lul5a+55q+P5Liq5a+56LGh5o+Q5Lqk5LiA5Liq5paH5qGj77yM5Lmf5Y+v5Lul5a+55q+P5qyh5L2c5Lia6L+Q6KGM5o+Q5Lqk5LiA5Liq5paH5qGj44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5Li65rKh5pyJ6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7lsIbigJzkvZzkuJogQ07igJ3nlKjkvZzop6blj5HlmajmlofmoaPnmoTmoIfor4bnrKblkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6K6+572u77yM5bCG5oqK6K+l5L2c5Lia5a+56LGh55qEIENOIOeUqOS9nOinpuWPkeWZqOWFg+e0oOeahOKAnOa6kOKAneeJueaAp+eahOWAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinpuWPkeWZqOWFg+e0oOa6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+55So5L2c6Kem5Y+R5Zmo5YWD57Sg4oCc5rqQ4oCd54m55oCn55qE5YC855qE5a2X56ym5Liy44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7mj5DkuqTop6blj5HlmajmlofmoaPnmoTmlrnlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+6Zif5YiX77yI5L2/55So6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqXvvIjnu5Xov4fotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZCv5Yqo6amx5Yqo56iL5bqP77yI5aaC5p6c5pyq6L+Q6KGM77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6M5oiQ5a+56Kem5Y+R5Zmo55qE5aSE55CG5pe25YGc5q2i6amx5Yqo56iL5bqPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9UVyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7oqILplrHogIXpgJrpgZPop7jnmbznqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+5q2k5bel5L2c5pyD5o+Q5Lqk6Zu25YCL5Lul5LiK55qE6Ke455m85paH5Lu26Iez6KiC6Zax6ICF6YCa6YGT44CC5q2k5L2c5qWt5Y+v6IO95q+P5LiA5YCL54mp5Lu25o+Q5Lqk5LiA5Lu95paH5Lu2ICjoi6Xlt7Llrprnvqnnr4TlnI0pIOaIluWPr+iDveavj+S4gOWAi+W3peS9nOaPkOS6pOWWruS4gOS7veaWh+S7tuOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeeCuuaykuaciempheWLleeoi+W8j+mXnOiBr+eahOeJqeS7tuaPkOS6pOinuOeZvOaWh+S7tu+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB5Lul44CM5bel5L2cIENO44CNIOWBmueCuuinuOeZvOaWh+S7tuitmOWIpeeivO+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzoqK3lrprvvIzliYfoq4vku6Xlt6XkvZznianku7bnmoQgQ04g5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Ke455m85YWD57Sg5L6G5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lrZfkuLLvvIzlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuinuOeZvOaWh+S7tueahOaPkOS6pOaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7kvYfliJcgKOS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSAo5LiN5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7llZ/li5XpqYXli5XnqIvlvI8gKOiLpeacquWft+ihjCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7nlbblrozmiJDomZXnkIbop7jnmbznqIvlvI/mmYLlgZzmraLpqYXli5XnqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjwvam9iLWFnZ3JlZ2F0aW9uPg==]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-Scope"/>
					<job-scope-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ManagerUpdate-MWFID,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-email-server-query job-name="cn=Job-ManagerUpdate-MWFID,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ManagerUpdate-MWFID,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-ManagerUpdate-MWFID-Schedule">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value><![CDATA[0]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value><![CDATA[0]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY2hlZHVsZT0iMCAyMSAqICogMCIgc2NvcGUtcmVxdWlyZWQ9ImZhbHNlIiB0eXBlPSJqYXZhIj48ZGVzY3JpcHRpb24+eGxmaWQoam9iLWRlc2NyaXB0aW9uKVRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L2Rlc2NyaXB0aW9uPjxjb250YWlubWVudD5EaXJYTUwtRHJpdmVyPC9jb250YWlubWVudD48amF2YS1jbGFzcz5jb20ubm92ZWxsLm5kcy5kaXJ4bWwuam9iLnRyaWdnZXIuVHJpZ2dlcjwvamF2YS1jbGFzcz48Y29uZmlndXJhdGlvbi12YWx1ZXM+PGRlZmluaXRpb25zPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQocHJvY2Vzcy11bmFzc29jaWF0ZWQpU3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPyIgbmFtZT0icHJvY2Vzcy11bmFzc29jaWF0ZWQiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodXNlLWpvYi1jbilVc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj8iIG5hbWU9InVzZS1qb2ItY24iIHR5cGU9ImJvb2xlYW4iPjxkZXNjcmlwdGlvbj54bGZpZCh1c2Utam9iLWNuLWRlc2MpSWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L2Rlc2NyaXB0aW9uPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9ImZhbHNlIj48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHRyaWdnZXItc291cmNlKVRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWUiIG5hbWU9InRyaWdnZXItc291cmNlIiB0eXBlPSJzdHJpbmciPjxkZXNjcmlwdGlvbj54bGZpZCh0cmlnZ2VyLXNvdXJjZS1kZXNjKVN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPjE8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1tZXRob2QpTWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzIiBuYW1lPSJzdWJtaXQtbWV0aG9kIiB0eXBlPSJlbnVtIj48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtcXVldWUpcXVldWUgKHVzZSBjYWNoZSkiPnN1Ym1pdC1xdWV1ZTwvZW51bS1jaG9pY2U+PGVudW0tY2hvaWNlIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LWRpcmVjdClkaXJlY3QgKGJ5cGFzcyBjYWNoZSkiPnN1Ym1pdC1kaXJlY3Q8L2VudW0tY2hvaWNlPjx2YWx1ZT5zdWJtaXQtZGlyZWN0PC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InN1Ym1pdC1kaXJlY3QiPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN0YXJ0LWRyaXZlcilTdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmciIG5hbWU9InN0YXJ0LWRyaXZlciIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPmZhbHNlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InRydWUiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RvcC1kcml2ZXIpU3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocykiIG5hbWU9InN0b3AtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+dHJ1ZTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L2RlZmluaXRpb25zPjwvY29uZmlndXJhdGlvbi12YWx1ZXM+PC9qb2ItZGVmaW5pdGlvbj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJkZSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5BYm9ubmVudGVua2FuYWxhdXNsw7ZzZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+TWl0IGRpZXNlbSBBdWZ0cmFnIHdlcmRlbiBudWxsIG9kZXIgbWVociBBdXNsw7ZzZXJkb2t1bWVudGUgYW4gZGVuIEFib25uZW50ZW5rYW5hbCBhYmdlc2VuZGV0LiBEYWJlaSBrYW5uIGVzIHNpY2ggdW0gZWluIERva3VtZW50IHBybyBPYmpla3QgaGFuZGVsbiwgc29mZXJuIGVpbiBCZXJlaWNoIGRlZmluaWVydCB3dXJkZSwgb2RlciB1bSBlaW4gZWluemVsbmVzIERva3VtZW50IGbDvHIgamVkZSBBdWZ0cmFnc2F1c2bDvGhydW5nLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPkF1c2zDtnNlcmRva3VtZW50IGbDvHIgT2JqZWt0ZSBvaG5lIFRyZWliZXJ6dW9yZG51bmcgYWJzZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5BdWZ0cmFncy1DTiBhbHMgQXVzbMO2c2VyZG9rdW1lbnRiZXplaWNobmVyIHZlcndlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+V2VubiBmZXN0Z2VsZWd0LCB3aXJkIGRlciBDTiBkZXMgQXVmdHJhZ3NvYmpla3RzIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VXJzcHJ1bmdzd2VydCBkZXMgQXVzbMO2c2VyZWxlbWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlplaWNoZW5rZXR0ZSwgZGllIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQgd2VyZGVuIHNvbGwuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2RlIGbDvHIgZGFzIEFic2VuZGVuIHZvbiBBdXNsw7ZzZXJkb2t1bWVudGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPldhcnRlc2NobGFuZ2UgKENhY2hlIHZlcndlbmRlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPkRpcmVrdCAoQ2FjaGUgw7xiZXJnZWhlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBzdGFydGVuLCBzb2Zlcm4gZXIgbmljaHQgYmVyZWl0cyBsw6R1ZnQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIG5hY2ggVmVyYXJiZWl0ZW4gdm9uIEF1c2zDtnNlcm4gYW5oYWx0ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImVuIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPlN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPlRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5TdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5Vc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+SWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5UcmlnZ2VyIGVsZW1lbnQgc291cmNlIHZhbHVlPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5TdHJpbmcgdG8gdXNlIGFzIHRoZSB2YWx1ZSBmb3IgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZCBmb3Igc3VibWl0dGluZyB0cmlnZ2VyIGRvY3VtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5xdWV1ZSAodXNlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0IChieXBhc3MgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0b3AgZHJpdmVyIHdoZW4gZmluaXNoZWQgcHJvY2Vzc2luZyB0cmlnZ2VyKHMpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJmciIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5Ew6ljbGVuY2hldXIgZGUgY2FuYWwgYWJvbm7DqTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5DZSB0cmF2YWlsIGFkcmVzc2UgdW4gb3UgcGx1c2lldXJzIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzIChvdSBuJ2VuIHNvdW1ldCBwYXMpIGF1IGNhbmFsIGFib25uw6kuIElsIHBldXQgZW52b3llciB1biBkb2N1bWVudCBwYXIgb2JqZXQsIHNpIHVuZSDDqXRlbmR1ZSBhIMOpdMOpIGTDqWZpbmllLCBvdSB1biBzZXVsIGRvY3VtZW50IMOgIGNoYXF1ZSBleMOpY3V0aW9uLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlNvdW1ldHRyZSB1biBkb2N1bWVudCBkw6ljbGVuY2hldXIgcG91ciBsZXMgb2JqZXRzIHNhbnMgYXNzb2NpYXRpb24gZGUgcGlsb3RlID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlV0aWxpc2VyIGxlIENOIGR1IHRyYXZhaWwgY29tbWUgaWRlbnRpZmljYXRldXIgZGUgZG9jdW1lbnQgZMOpY2xlbmNoZXVyID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+TGUgY2FzIMOpY2jDqWFudCwgdXRpbGlzZXIgbGUgQ04gZGUgbCdvYmpldCBUcmF2YWlsIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1ci48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5WYWxldXIgc291cmNlIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+Q2hhw65uZSDDoCB1dGlsaXNlciBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk3DqXRob2RlIGRlIHNvdW1pc3Npb24gZGUgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+ZmlsZSBkJ2F0dGVudGUgKHV0aWxpc2VyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0ZSAow6l2aXRlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+RMOpbWFycmVyIGxlIHBpbG90ZSBhdSBiZXNvaW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5BcnLDqnRlciBsZSBwaWxvdGUgw6AgbGEgZmluIGR1IHRyYWl0ZW1lbnQgZGVzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImphIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuizvOiqreiAheODgeODo+ODjeODq+ODiOODquOCrDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7jgZPjga7jgrjjg6fjg5bjga/jgrzjg63jgb7jgZ/jga/opIfmlbDjga7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLos7zoqq3ogIXjg4Hjg6Pjg43jg6vjgavpgIHkv6HjgZfjgb7jgZnjgILjgZPjga7pgIHkv6Hjga/jgrnjgrPjg7zjg5fjgYzlrprnvqnjgZXjgozjgabjgYTjgovloLTlkIjjga/jgqrjg5bjgrjjgqfjgq/jg4jjgZTjgajjgasx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44CB44G+44Gf44Gv5ZCE44K444On44OW5a6f6KGM44Gr5a++44GX44GmMeOBpOOBruODieOCreODpeODoeODs+ODiOOBqOOBquOCiuOBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuODieODqeOCpOODkOOBrumWoumAo+S7mOOBkeOBquOBl+OBp+OCquODluOCuOOCp+OCr+ODiOOBq+WvvuOBmeOCi+ODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuOCuOODp+ODlkNO44KS44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI6K2Y5Yil5a2Q44Go44GX44Gm5L2/55So44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7oqK3lrprjgZXjgozjgabjgYTjgovloLTlkIjjgIHjgrjjg6fjg5bjgqrjg5bjgrjjgqfjgq/jg4jjga5DTuOCkuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOCveODvOOCueWApDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GZ44KL5paH5a2X5YiX44Gn44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZnjgovjgZ/jgoHjga7mlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+44Kt44Ol44O8KOOCreODo+ODg+OCt+ODpeOBruS9v+eUqCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSjjg5DjgqTjg5Hjgrnjgq3jg6Pjg4Pjgrfjg6UpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWun+ihjOOBl+OBpuOBhOOBquOBhOWgtOWQiOODieODqeOCpOODkOOCkumWi+Wni+OBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOOBruWHpueQhuOBjOe1guS6huOBl+OBn+WgtOWQiOODieODqeOCpOODkOOCkuWBnOatouOBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfQ04iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6K6i6LSt6ICF6YCa6YGT6Kem5Y+R5ZmoPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuivpeS9nOS4muWwhuWQkeiuoui0reiAhemAmumBk+aPkOS6pCAwIOS4quaIluWkmuS4quinpuWPkeWZqOaWh+aho+OAguWmguaenOWumuS5ieS6huiMg+WbtO+8jOWPr+S7peWvueavj+S4quWvueixoeaPkOS6pOS4gOS4quaWh+aho++8jOS5n+WPr+S7peWvueavj+asoeS9nOS4mui/kOihjOaPkOS6pOS4gOS4quaWh+aho+OAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuS4uuayoeaciempseWKqOeoi+W6j+WFs+iBlOeahOWvueixoeaPkOS6pOinpuWPkeWZqOaWh+aho+WQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5bCG4oCc5L2c5LiaIENO4oCd55So5L2c6Kem5Y+R5Zmo5paH5qGj55qE5qCH6K+G56ym5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOiuvue9ru+8jOWwhuaKiuivpeS9nOS4muWvueixoeeahCBDTiDnlKjkvZzop6blj5HlmajlhYPntKDnmoTigJzmupDigJ3nibnmgKfnmoTlgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op6blj5HlmajlhYPntKDmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPueUqOS9nOinpuWPkeWZqOWFg+e0oOKAnOa6kOKAneeJueaAp+eahOWAvOeahOWtl+espuS4suOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj55qE5pa55byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPumYn+WIl++8iOS9v+eUqOi2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6l77yI57uV6L+H6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWQr+WKqOmpseWKqOeoi+W6j++8iOWmguaenOacqui/kOihjO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWujOaIkOWvueinpuWPkeWZqOeahOWkhOeQhuaXtuWBnOatoumpseWKqOeoi+W6jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfVFciIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6KiC6Zax6ICF6YCa6YGT6Ke455m856iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuatpOW3peS9nOacg+aPkOS6pOmbtuWAi+S7peS4iueahOinuOeZvOaWh+S7tuiHs+iogumWseiAhemAmumBk+OAguatpOS9nOalreWPr+iDveavj+S4gOWAi+eJqeS7tuaPkOS6pOS4gOS7veaWh+S7tiAo6Iul5bey5a6a576p56+E5ZyNKSDmiJblj6/og73mr4/kuIDlgIvlt6XkvZzmj5DkuqTllq7kuIDku73mlofku7bjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHngrrmspLmnInpqYXli5XnqIvlvI/pl5zoga/nmoTnianku7bmj5DkuqTop7jnmbzmlofku7bvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeS7peOAjOW3peS9nCBDTuOAjSDlgZrngrrop7jnmbzmlofku7borZjliKXnorzvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6Kit5a6a77yM5YmH6KuL5Lul5bel5L2c54mp5Lu255qEIENOIOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinuOeZvOWFg+e0oOS+hua6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+5a2X5Liy77yM5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzmlofku7bnmoTmj5DkuqTmlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+5L2H5YiXICjkvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUgKOS4jeS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZWf5YuV6amF5YuV56iL5byPICjoi6XmnKrln7fooYwpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+55W25a6M5oiQ6JmV55CG6Ke455m856iL5byP5pmC5YGc5q2i6amF5YuV56iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48L2pvYi1hZ2dyZWdhdGlvbj4=]]></ds-value>
					</ds-attribute>
					<job-email-server-query job-name="cn=Job-ManagerUpdate-MWFID-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-ManagerUpdate-MWFID-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-SecondmentExpires">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvZGVmaW5pdGlvbnM+PC9jb25maWd1cmF0aW9uLXZhbHVlcz48L2pvYi1kZWZpbml0aW9uPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImRlIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkFib25uZW50ZW5rYW5hbGF1c2zDtnNlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5NaXQgZGllc2VtIEF1ZnRyYWcgd2VyZGVuIG51bGwgb2RlciBtZWhyIEF1c2zDtnNlcmRva3VtZW50ZSBhbiBkZW4gQWJvbm5lbnRlbmthbmFsIGFiZ2VzZW5kZXQuIERhYmVpIGthbm4gZXMgc2ljaCB1bSBlaW4gRG9rdW1lbnQgcHJvIE9iamVrdCBoYW5kZWxuLCBzb2Zlcm4gZWluIEJlcmVpY2ggZGVmaW5pZXJ0IHd1cmRlLCBvZGVyIHVtIGVpbiBlaW56ZWxuZXMgRG9rdW1lbnQgZsO8ciBqZWRlIEF1ZnRyYWdzYXVzZsO8aHJ1bmcuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+QXVzbMO2c2VyZG9rdW1lbnQgZsO8ciBPYmpla3RlIG9obmUgVHJlaWJlcnp1b3JkbnVuZyBhYnNlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPkF1ZnRyYWdzLUNOIGFscyBBdXNsw7ZzZXJkb2t1bWVudGJlemVpY2huZXIgdmVyd2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5XZW5uIGZlc3RnZWxlZ3QsIHdpcmQgZGVyIENOIGRlcyBBdWZ0cmFnc29iamVrdHMgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5VcnNwcnVuZ3N3ZXJ0IGRlcyBBdXNsw7ZzZXJlbGVtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+WmVpY2hlbmtldHRlLCBkaWUgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldCB3ZXJkZW4gc29sbC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZGUgZsO8ciBkYXMgQWJzZW5kZW4gdm9uIEF1c2zDtnNlcmRva3VtZW50ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+V2FydGVzY2hsYW5nZSAoQ2FjaGUgdmVyd2VuZGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+RGlyZWt0IChDYWNoZSDDvGJlcmdlaGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIHN0YXJ0ZW4sIHNvZmVybiBlciBuaWNodCBiZXJlaXRzIGzDpHVmdDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgbmFjaCBWZXJhcmJlaXRlbiB2b24gQXVzbMO2c2VybiBhbmhhbHRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZW4iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+U3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+VGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5JZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWU8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPnF1ZXVlICh1c2UgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3QgKGJ5cGFzcyBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocyk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImZyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkTDqWNsZW5jaGV1ciBkZSBjYW5hbCBhYm9ubsOpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPkNlIHRyYXZhaWwgYWRyZXNzZSB1biBvdSBwbHVzaWV1cnMgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnMgKG91IG4nZW4gc291bWV0IHBhcykgYXUgY2FuYWwgYWJvbm7DqS4gSWwgcGV1dCBlbnZveWVyIHVuIGRvY3VtZW50IHBhciBvYmpldCwgc2kgdW5lIMOpdGVuZHVlIGEgw6l0w6kgZMOpZmluaWUsIG91IHVuIHNldWwgZG9jdW1lbnQgw6AgY2hhcXVlIGV4w6ljdXRpb24uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U291bWV0dHJlIHVuIGRvY3VtZW50IGTDqWNsZW5jaGV1ciBwb3VyIGxlcyBvYmpldHMgc2FucyBhc3NvY2lhdGlvbiBkZSBwaWxvdGUgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXRpbGlzZXIgbGUgQ04gZHUgdHJhdmFpbCBjb21tZSBpZGVudGlmaWNhdGV1ciBkZSBkb2N1bWVudCBkw6ljbGVuY2hldXIgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5MZSBjYXMgw6ljaMOpYW50LCB1dGlsaXNlciBsZSBDTiBkZSBsJ29iamV0IFRyYXZhaWwgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlZhbGV1ciBzb3VyY2UgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5DaGHDrm5lIMOgIHV0aWxpc2VyIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TcOpdGhvZGUgZGUgc291bWlzc2lvbiBkZSBkb2N1bWVudHMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5maWxlIGQnYXR0ZW50ZSAodXRpbGlzZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3RlICjDqXZpdGVyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5Ew6ltYXJyZXIgbGUgcGlsb3RlIGF1IGJlc29pbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkFycsOqdGVyIGxlIHBpbG90ZSDDoCBsYSBmaW4gZHUgdHJhaXRlbWVudCBkZXMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iamEiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6LO86Kqt6ICF44OB44Oj44ON44Or44OI44Oq44KsPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuOBk+OBruOCuOODp+ODluOBr+OCvOODreOBvuOBn+OBr+ikh+aVsOOBruODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkuizvOiqreiAheODgeODo+ODjeODq+OBq+mAgeS/oeOBl+OBvuOBmeOAguOBk+OBrumAgeS/oeOBr+OCueOCs+ODvOODl+OBjOWumue+qeOBleOCjOOBpuOBhOOCi+WgtOWQiOOBr+OCquODluOCuOOCp+OCr+ODiOOBlOOBqOOBqzHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgIHjgb7jgZ/jga/lkITjgrjjg6fjg5blrp/ooYzjgavlr77jgZfjgaYx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44Go44Gq44KK44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+44OJ44Op44Kk44OQ44Gu6Zai6YCj5LuY44GR44Gq44GX44Gn44Kq44OW44K444Kn44Kv44OI44Gr5a++44GZ44KL44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+44K444On44OWQ07jgpLjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jorZjliKXlrZDjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuioreWumuOBleOCjOOBpuOBhOOCi+WgtOWQiOOAgeOCuOODp+ODluOCquODluOCuOOCp+OCr+ODiOOBrkNO44KS44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GX44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44K944O844K55YCkPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZnjgovmloflrZfliJfjgafjgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBmeOCi+OBn+OCgeOBruaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7jgq3jg6Xjg7wo44Kt44Oj44OD44K344Ol44Gu5L2/55SoKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lKOODkOOCpOODkeOCueOCreODo+ODg+OCt+ODpSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6f6KGM44GX44Gm44GE44Gq44GE5aC05ZCI44OJ44Op44Kk44OQ44KS6ZaL5aeL44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44Gu5Yem55CG44GM57WC5LqG44GX44Gf5aC05ZCI44OJ44Op44Kk44OQ44KS5YGc5q2i44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9DTiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7orqLotK3ogIXpgJrpgZPop6blj5Hlmag8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+6K+l5L2c5Lia5bCG5ZCR6K6i6LSt6ICF6YCa6YGT5o+Q5LqkIDAg5Liq5oiW5aSa5Liq6Kem5Y+R5Zmo5paH5qGj44CC5aaC5p6c5a6a5LmJ5LqG6IyD5Zu077yM5Y+v5Lul5a+55q+P5Liq5a+56LGh5o+Q5Lqk5LiA5Liq5paH5qGj77yM5Lmf5Y+v5Lul5a+55q+P5qyh5L2c5Lia6L+Q6KGM5o+Q5Lqk5LiA5Liq5paH5qGj44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5Li65rKh5pyJ6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7lsIbigJzkvZzkuJogQ07igJ3nlKjkvZzop6blj5HlmajmlofmoaPnmoTmoIfor4bnrKblkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6K6+572u77yM5bCG5oqK6K+l5L2c5Lia5a+56LGh55qEIENOIOeUqOS9nOinpuWPkeWZqOWFg+e0oOeahOKAnOa6kOKAneeJueaAp+eahOWAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinpuWPkeWZqOWFg+e0oOa6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+55So5L2c6Kem5Y+R5Zmo5YWD57Sg4oCc5rqQ4oCd54m55oCn55qE5YC855qE5a2X56ym5Liy44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7mj5DkuqTop6blj5HlmajmlofmoaPnmoTmlrnlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+6Zif5YiX77yI5L2/55So6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqXvvIjnu5Xov4fotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZCv5Yqo6amx5Yqo56iL5bqP77yI5aaC5p6c5pyq6L+Q6KGM77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6M5oiQ5a+56Kem5Y+R5Zmo55qE5aSE55CG5pe25YGc5q2i6amx5Yqo56iL5bqPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9UVyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7oqILplrHogIXpgJrpgZPop7jnmbznqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+5q2k5bel5L2c5pyD5o+Q5Lqk6Zu25YCL5Lul5LiK55qE6Ke455m85paH5Lu26Iez6KiC6Zax6ICF6YCa6YGT44CC5q2k5L2c5qWt5Y+v6IO95q+P5LiA5YCL54mp5Lu25o+Q5Lqk5LiA5Lu95paH5Lu2ICjoi6Xlt7Llrprnvqnnr4TlnI0pIOaIluWPr+iDveavj+S4gOWAi+W3peS9nOaPkOS6pOWWruS4gOS7veaWh+S7tuOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeeCuuaykuaciempheWLleeoi+W8j+mXnOiBr+eahOeJqeS7tuaPkOS6pOinuOeZvOaWh+S7tu+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB5Lul44CM5bel5L2cIENO44CNIOWBmueCuuinuOeZvOaWh+S7tuitmOWIpeeivO+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzoqK3lrprvvIzliYfoq4vku6Xlt6XkvZznianku7bnmoQgQ04g5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Ke455m85YWD57Sg5L6G5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lrZfkuLLvvIzlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuinuOeZvOaWh+S7tueahOaPkOS6pOaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7kvYfliJcgKOS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSAo5LiN5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7llZ/li5XpqYXli5XnqIvlvI8gKOiLpeacquWft+ihjCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7nlbblrozmiJDomZXnkIbop7jnmbznqIvlvI/mmYLlgZzmraLpqYXli5XnqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjwvam9iLWFnZ3JlZ2F0aW9uPg==]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-Scope"/>
					<job-scope-query job-display-name="Subscriber channel trigger" job-name="cn=Job-SecondmentExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-email-server-query job-name="cn=Job-SecondmentExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-SecondmentExpires,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-SecondmentExpires-Schedule">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY2hlZHVsZT0iNDUgNSAqICogKiIgc2NvcGUtcmVxdWlyZWQ9ImZhbHNlIiB0eXBlPSJqYXZhIj48ZGVzY3JpcHRpb24+eGxmaWQoam9iLWRlc2NyaXB0aW9uKVRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L2Rlc2NyaXB0aW9uPjxjb250YWlubWVudD5EaXJYTUwtRHJpdmVyPC9jb250YWlubWVudD48amF2YS1jbGFzcz5jb20ubm92ZWxsLm5kcy5kaXJ4bWwuam9iLnRyaWdnZXIuVHJpZ2dlcjwvamF2YS1jbGFzcz48Y29uZmlndXJhdGlvbi12YWx1ZXM+PGRlZmluaXRpb25zPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQocHJvY2Vzcy11bmFzc29jaWF0ZWQpU3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPyIgbmFtZT0icHJvY2Vzcy11bmFzc29jaWF0ZWQiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodXNlLWpvYi1jbilVc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj8iIG5hbWU9InVzZS1qb2ItY24iIHR5cGU9ImJvb2xlYW4iPjxkZXNjcmlwdGlvbj54bGZpZCh1c2Utam9iLWNuLWRlc2MpSWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L2Rlc2NyaXB0aW9uPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9ImZhbHNlIj48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHRyaWdnZXItc291cmNlKVRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWUiIG5hbWU9InRyaWdnZXItc291cmNlIiB0eXBlPSJzdHJpbmciPjxkZXNjcmlwdGlvbj54bGZpZCh0cmlnZ2VyLXNvdXJjZS1kZXNjKVN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPjE8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1tZXRob2QpTWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzIiBuYW1lPSJzdWJtaXQtbWV0aG9kIiB0eXBlPSJlbnVtIj48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtcXVldWUpcXVldWUgKHVzZSBjYWNoZSkiPnN1Ym1pdC1xdWV1ZTwvZW51bS1jaG9pY2U+PGVudW0tY2hvaWNlIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LWRpcmVjdClkaXJlY3QgKGJ5cGFzcyBjYWNoZSkiPnN1Ym1pdC1kaXJlY3Q8L2VudW0tY2hvaWNlPjx2YWx1ZT5zdWJtaXQtZGlyZWN0PC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InN1Ym1pdC1kaXJlY3QiPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN0YXJ0LWRyaXZlcilTdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmciIG5hbWU9InN0YXJ0LWRyaXZlciIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPmZhbHNlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InRydWUiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RvcC1kcml2ZXIpU3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocykiIG5hbWU9InN0b3AtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+dHJ1ZTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L2RlZmluaXRpb25zPjwvY29uZmlndXJhdGlvbi12YWx1ZXM+PC9qb2ItZGVmaW5pdGlvbj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJkZSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5BYm9ubmVudGVua2FuYWxhdXNsw7ZzZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+TWl0IGRpZXNlbSBBdWZ0cmFnIHdlcmRlbiBudWxsIG9kZXIgbWVociBBdXNsw7ZzZXJkb2t1bWVudGUgYW4gZGVuIEFib25uZW50ZW5rYW5hbCBhYmdlc2VuZGV0LiBEYWJlaSBrYW5uIGVzIHNpY2ggdW0gZWluIERva3VtZW50IHBybyBPYmpla3QgaGFuZGVsbiwgc29mZXJuIGVpbiBCZXJlaWNoIGRlZmluaWVydCB3dXJkZSwgb2RlciB1bSBlaW4gZWluemVsbmVzIERva3VtZW50IGbDvHIgamVkZSBBdWZ0cmFnc2F1c2bDvGhydW5nLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPkF1c2zDtnNlcmRva3VtZW50IGbDvHIgT2JqZWt0ZSBvaG5lIFRyZWliZXJ6dW9yZG51bmcgYWJzZW5kZW4/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5BdWZ0cmFncy1DTiBhbHMgQXVzbMO2c2VyZG9rdW1lbnRiZXplaWNobmVyIHZlcndlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+V2VubiBmZXN0Z2VsZWd0LCB3aXJkIGRlciBDTiBkZXMgQXVmdHJhZ3NvYmpla3RzIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+VXJzcHJ1bmdzd2VydCBkZXMgQXVzbMO2c2VyZWxlbWVudHM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlplaWNoZW5rZXR0ZSwgZGllIGFscyBXZXJ0IGbDvHIgZGFzIFVyc3BydW5nc2F0dHJpYnV0IGRlcyBBdXNsw7ZzZXJlbGVtZW50cyB2ZXJ3ZW5kZXQgd2VyZGVuIHNvbGwuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT5NZXRob2RlIGbDvHIgZGFzIEFic2VuZGVuIHZvbiBBdXNsw7ZzZXJkb2t1bWVudGVuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPldhcnRlc2NobGFuZ2UgKENhY2hlIHZlcndlbmRlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPkRpcmVrdCAoQ2FjaGUgw7xiZXJnZWhlbik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+VHJlaWJlciBzdGFydGVuLCBzb2Zlcm4gZXIgbmljaHQgYmVyZWl0cyBsw6R1ZnQ8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIG5hY2ggVmVyYXJiZWl0ZW4gdm9uIEF1c2zDtnNlcm4gYW5oYWx0ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImVuIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPlN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPlRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT5TdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT5Vc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+SWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5UcmlnZ2VyIGVsZW1lbnQgc291cmNlIHZhbHVlPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5TdHJpbmcgdG8gdXNlIGFzIHRoZSB2YWx1ZSBmb3IgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZCBmb3Igc3VibWl0dGluZyB0cmlnZ2VyIGRvY3VtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5xdWV1ZSAodXNlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0IChieXBhc3MgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlN0b3AgZHJpdmVyIHdoZW4gZmluaXNoZWQgcHJvY2Vzc2luZyB0cmlnZ2VyKHMpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJmciIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT5Ew6ljbGVuY2hldXIgZGUgY2FuYWwgYWJvbm7DqTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5DZSB0cmF2YWlsIGFkcmVzc2UgdW4gb3UgcGx1c2lldXJzIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzIChvdSBuJ2VuIHNvdW1ldCBwYXMpIGF1IGNhbmFsIGFib25uw6kuIElsIHBldXQgZW52b3llciB1biBkb2N1bWVudCBwYXIgb2JqZXQsIHNpIHVuZSDDqXRlbmR1ZSBhIMOpdMOpIGTDqWZpbmllLCBvdSB1biBzZXVsIGRvY3VtZW50IMOgIGNoYXF1ZSBleMOpY3V0aW9uLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlNvdW1ldHRyZSB1biBkb2N1bWVudCBkw6ljbGVuY2hldXIgcG91ciBsZXMgb2JqZXRzIHNhbnMgYXNzb2NpYXRpb24gZGUgcGlsb3RlID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlV0aWxpc2VyIGxlIENOIGR1IHRyYXZhaWwgY29tbWUgaWRlbnRpZmljYXRldXIgZGUgZG9jdW1lbnQgZMOpY2xlbmNoZXVyID88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+TGUgY2FzIMOpY2jDqWFudCwgdXRpbGlzZXIgbGUgQ04gZGUgbCdvYmpldCBUcmF2YWlsIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1ci48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5WYWxldXIgc291cmNlIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+Q2hhw65uZSDDoCB1dGlsaXNlciBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk3DqXRob2RlIGRlIHNvdW1pc3Npb24gZGUgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+ZmlsZSBkJ2F0dGVudGUgKHV0aWxpc2VyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+ZGlyZWN0ZSAow6l2aXRlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+RMOpbWFycmVyIGxlIHBpbG90ZSBhdSBiZXNvaW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5BcnLDqnRlciBsZSBwaWxvdGUgw6AgbGEgZmluIGR1IHRyYWl0ZW1lbnQgZGVzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImphIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPuizvOiqreiAheODgeODo+ODjeODq+ODiOODquOCrDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT7jgZPjga7jgrjjg6fjg5bjga/jgrzjg63jgb7jgZ/jga/opIfmlbDjga7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLos7zoqq3ogIXjg4Hjg6Pjg43jg6vjgavpgIHkv6HjgZfjgb7jgZnjgILjgZPjga7pgIHkv6Hjga/jgrnjgrPjg7zjg5fjgYzlrprnvqnjgZXjgozjgabjgYTjgovloLTlkIjjga/jgqrjg5bjgrjjgqfjgq/jg4jjgZTjgajjgasx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44CB44G+44Gf44Gv5ZCE44K444On44OW5a6f6KGM44Gr5a++44GX44GmMeOBpOOBruODieOCreODpeODoeODs+ODiOOBqOOBquOCiuOBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuODieODqeOCpOODkOOBrumWoumAo+S7mOOBkeOBquOBl+OBp+OCquODluOCuOOCp+OCr+ODiOOBq+WvvuOBmeOCi+ODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuOCuOODp+ODlkNO44KS44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI6K2Y5Yil5a2Q44Go44GX44Gm5L2/55So44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7oqK3lrprjgZXjgozjgabjgYTjgovloLTlkIjjgIHjgrjjg6fjg5bjgqrjg5bjgrjjgqfjgq/jg4jjga5DTuOCkuODiOODquOCrOimgee0oOOBru+9ouOCveODvOOCue+9o+WxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOCveODvOOCueWApDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GZ44KL5paH5a2X5YiX44Gn44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZnjgovjgZ/jgoHjga7mlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+44Kt44Ol44O8KOOCreODo+ODg+OCt+ODpeOBruS9v+eUqCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSjjg5DjgqTjg5Hjgrnjgq3jg6Pjg4Pjgrfjg6UpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWun+ihjOOBl+OBpuOBhOOBquOBhOWgtOWQiOODieODqeOCpOODkOOCkumWi+Wni+OBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOOBruWHpueQhuOBjOe1guS6huOBl+OBn+WgtOWQiOODieODqeOCpOODkOOCkuWBnOatouOBmeOCizwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfQ04iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6K6i6LSt6ICF6YCa6YGT6Kem5Y+R5ZmoPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuivpeS9nOS4muWwhuWQkeiuoui0reiAhemAmumBk+aPkOS6pCAwIOS4quaIluWkmuS4quinpuWPkeWZqOaWh+aho+OAguWmguaenOWumuS5ieS6huiMg+WbtO+8jOWPr+S7peWvueavj+S4quWvueixoeaPkOS6pOS4gOS4quaWh+aho++8jOS5n+WPr+S7peWvueavj+asoeS9nOS4mui/kOihjOaPkOS6pOS4gOS4quaWh+aho+OAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuS4uuayoeaciempseWKqOeoi+W6j+WFs+iBlOeahOWvueixoeaPkOS6pOinpuWPkeWZqOaWh+aho+WQl++8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5bCG4oCc5L2c5LiaIENO4oCd55So5L2c6Kem5Y+R5Zmo5paH5qGj55qE5qCH6K+G56ym5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuWmguaenOiuvue9ru+8jOWwhuaKiuivpeS9nOS4muWvueixoeeahCBDTiDnlKjkvZzop6blj5HlmajlhYPntKDnmoTigJzmupDigJ3nibnmgKfnmoTlgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT7op6blj5HlmajlhYPntKDmupDlgLw8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPueUqOS9nOinpuWPkeWZqOWFg+e0oOKAnOa6kOKAneeJueaAp+eahOWAvOeahOWtl+espuS4suOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj55qE5pa55byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPumYn+WIl++8iOS9v+eUqOi2hemAn+e8k+WtmO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6l77yI57uV6L+H6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWQr+WKqOmpseWKqOeoi+W6j++8iOWmguaenOacqui/kOihjO+8iTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPuWujOaIkOWvueinpuWPkeWZqOeahOWkhOeQhuaXtuWBnOatoumpseWKqOeoi+W6jzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iemhfVFciIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6KiC6Zax6ICF6YCa6YGT6Ke455m856iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuatpOW3peS9nOacg+aPkOS6pOmbtuWAi+S7peS4iueahOinuOeZvOaWh+S7tuiHs+iogumWseiAhemAmumBk+OAguatpOS9nOalreWPr+iDveavj+S4gOWAi+eJqeS7tuaPkOS6pOS4gOS7veaWh+S7tiAo6Iul5bey5a6a576p56+E5ZyNKSDmiJblj6/og73mr4/kuIDlgIvlt6XkvZzmj5DkuqTllq7kuIDku73mlofku7bjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCQkJPHNvdXJjZT7mmK/lkKbopoHngrrmspLmnInpqYXli5XnqIvlvI/pl5zoga/nmoTnianku7bmj5DkuqTop7jnmbzmlofku7bvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeS7peOAjOW3peS9nCBDTuOAjSDlgZrngrrop7jnmbzmlofku7borZjliKXnorzvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6Kit5a6a77yM5YmH6KuL5Lul5bel5L2c54mp5Lu255qEIENOIOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinuOeZvOWFg+e0oOS+hua6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+5a2X5Liy77yM5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7op7jnmbzmlofku7bnmoTmj5DkuqTmlrnms5U8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+5L2H5YiXICjkvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqUgKOS4jeS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZWf5YuV6amF5YuV56iL5byPICjoi6XmnKrln7fooYwpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+55W25a6M5oiQ6JmV55CG6Ke455m856iL5byP5pmC5YGc5q2i6amF5YuV56iL5byPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48L2pvYi1hZ2dyZWdhdGlvbj4=]]></ds-value>
					</ds-attribute>
					<job-email-server-query job-name="cn=Job-SecondmentExpires-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-SecondmentExpires-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-StartToday">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvZGVmaW5pdGlvbnM+PC9jb25maWd1cmF0aW9uLXZhbHVlcz48L2pvYi1kZWZpbml0aW9uPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImRlIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkFib25uZW50ZW5rYW5hbGF1c2zDtnNlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5NaXQgZGllc2VtIEF1ZnRyYWcgd2VyZGVuIG51bGwgb2RlciBtZWhyIEF1c2zDtnNlcmRva3VtZW50ZSBhbiBkZW4gQWJvbm5lbnRlbmthbmFsIGFiZ2VzZW5kZXQuIERhYmVpIGthbm4gZXMgc2ljaCB1bSBlaW4gRG9rdW1lbnQgcHJvIE9iamVrdCBoYW5kZWxuLCBzb2Zlcm4gZWluIEJlcmVpY2ggZGVmaW5pZXJ0IHd1cmRlLCBvZGVyIHVtIGVpbiBlaW56ZWxuZXMgRG9rdW1lbnQgZsO8ciBqZWRlIEF1ZnRyYWdzYXVzZsO8aHJ1bmcuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+QXVzbMO2c2VyZG9rdW1lbnQgZsO8ciBPYmpla3RlIG9obmUgVHJlaWJlcnp1b3JkbnVuZyBhYnNlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPkF1ZnRyYWdzLUNOIGFscyBBdXNsw7ZzZXJkb2t1bWVudGJlemVpY2huZXIgdmVyd2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5XZW5uIGZlc3RnZWxlZ3QsIHdpcmQgZGVyIENOIGRlcyBBdWZ0cmFnc29iamVrdHMgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5VcnNwcnVuZ3N3ZXJ0IGRlcyBBdXNsw7ZzZXJlbGVtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+WmVpY2hlbmtldHRlLCBkaWUgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldCB3ZXJkZW4gc29sbC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZGUgZsO8ciBkYXMgQWJzZW5kZW4gdm9uIEF1c2zDtnNlcmRva3VtZW50ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+V2FydGVzY2hsYW5nZSAoQ2FjaGUgdmVyd2VuZGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+RGlyZWt0IChDYWNoZSDDvGJlcmdlaGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIHN0YXJ0ZW4sIHNvZmVybiBlciBuaWNodCBiZXJlaXRzIGzDpHVmdDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgbmFjaCBWZXJhcmJlaXRlbiB2b24gQXVzbMO2c2VybiBhbmhhbHRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZW4iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+U3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+VGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5JZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWU8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPnF1ZXVlICh1c2UgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3QgKGJ5cGFzcyBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocyk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImZyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkTDqWNsZW5jaGV1ciBkZSBjYW5hbCBhYm9ubsOpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPkNlIHRyYXZhaWwgYWRyZXNzZSB1biBvdSBwbHVzaWV1cnMgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnMgKG91IG4nZW4gc291bWV0IHBhcykgYXUgY2FuYWwgYWJvbm7DqS4gSWwgcGV1dCBlbnZveWVyIHVuIGRvY3VtZW50IHBhciBvYmpldCwgc2kgdW5lIMOpdGVuZHVlIGEgw6l0w6kgZMOpZmluaWUsIG91IHVuIHNldWwgZG9jdW1lbnQgw6AgY2hhcXVlIGV4w6ljdXRpb24uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U291bWV0dHJlIHVuIGRvY3VtZW50IGTDqWNsZW5jaGV1ciBwb3VyIGxlcyBvYmpldHMgc2FucyBhc3NvY2lhdGlvbiBkZSBwaWxvdGUgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXRpbGlzZXIgbGUgQ04gZHUgdHJhdmFpbCBjb21tZSBpZGVudGlmaWNhdGV1ciBkZSBkb2N1bWVudCBkw6ljbGVuY2hldXIgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5MZSBjYXMgw6ljaMOpYW50LCB1dGlsaXNlciBsZSBDTiBkZSBsJ29iamV0IFRyYXZhaWwgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlZhbGV1ciBzb3VyY2UgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5DaGHDrm5lIMOgIHV0aWxpc2VyIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TcOpdGhvZGUgZGUgc291bWlzc2lvbiBkZSBkb2N1bWVudHMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5maWxlIGQnYXR0ZW50ZSAodXRpbGlzZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3RlICjDqXZpdGVyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5Ew6ltYXJyZXIgbGUgcGlsb3RlIGF1IGJlc29pbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkFycsOqdGVyIGxlIHBpbG90ZSDDoCBsYSBmaW4gZHUgdHJhaXRlbWVudCBkZXMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iamEiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6LO86Kqt6ICF44OB44Oj44ON44Or44OI44Oq44KsPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuOBk+OBruOCuOODp+ODluOBr+OCvOODreOBvuOBn+OBr+ikh+aVsOOBruODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkuizvOiqreiAheODgeODo+ODjeODq+OBq+mAgeS/oeOBl+OBvuOBmeOAguOBk+OBrumAgeS/oeOBr+OCueOCs+ODvOODl+OBjOWumue+qeOBleOCjOOBpuOBhOOCi+WgtOWQiOOBr+OCquODluOCuOOCp+OCr+ODiOOBlOOBqOOBqzHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgIHjgb7jgZ/jga/lkITjgrjjg6fjg5blrp/ooYzjgavlr77jgZfjgaYx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44Go44Gq44KK44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+44OJ44Op44Kk44OQ44Gu6Zai6YCj5LuY44GR44Gq44GX44Gn44Kq44OW44K444Kn44Kv44OI44Gr5a++44GZ44KL44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+44K444On44OWQ07jgpLjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jorZjliKXlrZDjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuioreWumuOBleOCjOOBpuOBhOOCi+WgtOWQiOOAgeOCuOODp+ODluOCquODluOCuOOCp+OCr+ODiOOBrkNO44KS44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GX44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44K944O844K55YCkPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZnjgovmloflrZfliJfjgafjgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBmeOCi+OBn+OCgeOBruaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7jgq3jg6Xjg7wo44Kt44Oj44OD44K344Ol44Gu5L2/55SoKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lKOODkOOCpOODkeOCueOCreODo+ODg+OCt+ODpSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6f6KGM44GX44Gm44GE44Gq44GE5aC05ZCI44OJ44Op44Kk44OQ44KS6ZaL5aeL44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44Gu5Yem55CG44GM57WC5LqG44GX44Gf5aC05ZCI44OJ44Op44Kk44OQ44KS5YGc5q2i44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9DTiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7orqLotK3ogIXpgJrpgZPop6blj5Hlmag8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+6K+l5L2c5Lia5bCG5ZCR6K6i6LSt6ICF6YCa6YGT5o+Q5LqkIDAg5Liq5oiW5aSa5Liq6Kem5Y+R5Zmo5paH5qGj44CC5aaC5p6c5a6a5LmJ5LqG6IyD5Zu077yM5Y+v5Lul5a+55q+P5Liq5a+56LGh5o+Q5Lqk5LiA5Liq5paH5qGj77yM5Lmf5Y+v5Lul5a+55q+P5qyh5L2c5Lia6L+Q6KGM5o+Q5Lqk5LiA5Liq5paH5qGj44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5Li65rKh5pyJ6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7lsIbigJzkvZzkuJogQ07igJ3nlKjkvZzop6blj5HlmajmlofmoaPnmoTmoIfor4bnrKblkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6K6+572u77yM5bCG5oqK6K+l5L2c5Lia5a+56LGh55qEIENOIOeUqOS9nOinpuWPkeWZqOWFg+e0oOeahOKAnOa6kOKAneeJueaAp+eahOWAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinpuWPkeWZqOWFg+e0oOa6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+55So5L2c6Kem5Y+R5Zmo5YWD57Sg4oCc5rqQ4oCd54m55oCn55qE5YC855qE5a2X56ym5Liy44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7mj5DkuqTop6blj5HlmajmlofmoaPnmoTmlrnlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+6Zif5YiX77yI5L2/55So6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqXvvIjnu5Xov4fotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZCv5Yqo6amx5Yqo56iL5bqP77yI5aaC5p6c5pyq6L+Q6KGM77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6M5oiQ5a+56Kem5Y+R5Zmo55qE5aSE55CG5pe25YGc5q2i6amx5Yqo56iL5bqPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9UVyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7oqILplrHogIXpgJrpgZPop7jnmbznqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+5q2k5bel5L2c5pyD5o+Q5Lqk6Zu25YCL5Lul5LiK55qE6Ke455m85paH5Lu26Iez6KiC6Zax6ICF6YCa6YGT44CC5q2k5L2c5qWt5Y+v6IO95q+P5LiA5YCL54mp5Lu25o+Q5Lqk5LiA5Lu95paH5Lu2ICjoi6Xlt7Llrprnvqnnr4TlnI0pIOaIluWPr+iDveavj+S4gOWAi+W3peS9nOaPkOS6pOWWruS4gOS7veaWh+S7tuOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeeCuuaykuaciempheWLleeoi+W8j+mXnOiBr+eahOeJqeS7tuaPkOS6pOinuOeZvOaWh+S7tu+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB5Lul44CM5bel5L2cIENO44CNIOWBmueCuuinuOeZvOaWh+S7tuitmOWIpeeivO+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzoqK3lrprvvIzliYfoq4vku6Xlt6XkvZznianku7bnmoQgQ04g5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Ke455m85YWD57Sg5L6G5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lrZfkuLLvvIzlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuinuOeZvOaWh+S7tueahOaPkOS6pOaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7kvYfliJcgKOS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSAo5LiN5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7llZ/li5XpqYXli5XnqIvlvI8gKOiLpeacquWft+ihjCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7nlbblrozmiJDomZXnkIbop7jnmbznqIvlvI/mmYLlgZzmraLpqYXli5XnqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjwvam9iLWFnZ3JlZ2F0aW9uPg==]]></ds-value>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-Scope"/>
					<job-scope-query job-display-name="Subscriber channel trigger" job-name="cn=Job-StartToday,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-email-server-query job-name="cn=Job-StartToday,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-StartToday,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-StartToday-Schedule">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY2hlZHVsZT0iMCA1ICogKiAqIiBzY29wZS1yZXF1aXJlZD0iZmFsc2UiIHR5cGU9ImphdmEiPjxkZXNjcmlwdGlvbj54bGZpZChqb2ItZGVzY3JpcHRpb24pVGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvZGVzY3JpcHRpb24+PGNvbnRhaW5tZW50PkRpclhNTC1Ecml2ZXI8L2NvbnRhaW5tZW50PjxqYXZhLWNsYXNzPmNvbS5ub3ZlbGwubmRzLmRpcnhtbC5qb2IudHJpZ2dlci5UcmlnZ2VyPC9qYXZhLWNsYXNzPjxjb25maWd1cmF0aW9uLXZhbHVlcz48ZGVmaW5pdGlvbnM+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChwcm9jZXNzLXVuYXNzb2NpYXRlZClTdWJtaXQgYSB0cmlnZ2VyIGRvY3VtZW50IGZvciBvYmplY3RzIHdpdGhvdXQgYSBkcml2ZXIgYXNzb2NpYXRpb24/IiBuYW1lPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48Z3JvdXA+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZCh1c2Utam9iLWNuKVVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPyIgbmFtZT0idXNlLWpvYi1jbiIgdHlwZT0iYm9vbGVhbiI+PGRlc2NyaXB0aW9uPnhsZmlkKHVzZS1qb2ItY24tZGVzYylJZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPnRydWU8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0iZmFsc2UiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodHJpZ2dlci1zb3VyY2UpVHJpZ2dlciBlbGVtZW50IHNvdXJjZSB2YWx1ZSIgbmFtZT0idHJpZ2dlci1zb3VyY2UiIHR5cGU9InN0cmluZyI+PGRlc2NyaXB0aW9uPnhsZmlkKHRyaWdnZXItc291cmNlLWRlc2MpU3RyaW5nIHRvIHVzZSBhcyB0aGUgdmFsdWUgZm9yIHRoZSB0cmlnZ2VyIGVsZW1lbnQncyAic291cmNlIiBhdHRyaWJ1dGUuPC9kZXNjcmlwdGlvbj48dmFsdWU+MTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LW1ldGhvZClNZXRob2QgZm9yIHN1Ym1pdHRpbmcgdHJpZ2dlciBkb2N1bWVudHMiIG5hbWU9InN1Ym1pdC1tZXRob2QiIHR5cGU9ImVudW0iPjxlbnVtLWNob2ljZSBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1xdWV1ZSlxdWV1ZSAodXNlIGNhY2hlKSI+c3VibWl0LXF1ZXVlPC9lbnVtLWNob2ljZT48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtZGlyZWN0KWRpcmVjdCAoYnlwYXNzIGNhY2hlKSI+c3VibWl0LWRpcmVjdDwvZW51bS1jaG9pY2U+PHZhbHVlPnN1Ym1pdC1kaXJlY3Q8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0ic3VibWl0LWRpcmVjdCI+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RhcnQtZHJpdmVyKVN0YXJ0IGRyaXZlciBpZiBub3QgcnVubmluZyIgbmFtZT0ic3RhcnQtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+ZmFsc2U8L3ZhbHVlPjwvZGVmaW5pdGlvbj48c3Vib3JkaW5hdGVzIGFjdGl2ZS12YWx1ZT0idHJ1ZSI+PGRlZmluaXRpb24gZGlzcGxheS1uYW1lPSJ4bGZpZChzdG9wLWRyaXZlcilTdG9wIGRyaXZlciB3aGVuIGZpbmlzaGVkIHByb2Nlc3NpbmcgdHJpZ2dlcihzKSIgbmFtZT0ic3RvcC1kcml2ZXIiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjwvZGVmaW5pdGlvbnM+PC9jb25maWd1cmF0aW9uLXZhbHVlcz48L2pvYi1kZWZpbml0aW9uPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImRlIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkFib25uZW50ZW5rYW5hbGF1c2zDtnNlcjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCQkJPHNvdXJjZT5NaXQgZGllc2VtIEF1ZnRyYWcgd2VyZGVuIG51bGwgb2RlciBtZWhyIEF1c2zDtnNlcmRva3VtZW50ZSBhbiBkZW4gQWJvbm5lbnRlbmthbmFsIGFiZ2VzZW5kZXQuIERhYmVpIGthbm4gZXMgc2ljaCB1bSBlaW4gRG9rdW1lbnQgcHJvIE9iamVrdCBoYW5kZWxuLCBzb2Zlcm4gZWluIEJlcmVpY2ggZGVmaW5pZXJ0IHd1cmRlLCBvZGVyIHVtIGVpbiBlaW56ZWxuZXMgRG9rdW1lbnQgZsO8ciBqZWRlIEF1ZnRyYWdzYXVzZsO8aHJ1bmcuPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+QXVzbMO2c2VyZG9rdW1lbnQgZsO8ciBPYmpla3RlIG9obmUgVHJlaWJlcnp1b3JkbnVuZyBhYnNlbmRlbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPkF1ZnRyYWdzLUNOIGFscyBBdXNsw7ZzZXJkb2t1bWVudGJlemVpY2huZXIgdmVyd2VuZGVuPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5XZW5uIGZlc3RnZWxlZ3QsIHdpcmQgZGVyIENOIGRlcyBBdWZ0cmFnc29iamVrdHMgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlIj4KCQkJCQkJPHNvdXJjZT5VcnNwcnVuZ3N3ZXJ0IGRlcyBBdXNsw7ZzZXJlbGVtZW50czwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+WmVpY2hlbmtldHRlLCBkaWUgYWxzIFdlcnQgZsO8ciBkYXMgVXJzcHJ1bmdzYXR0cmlidXQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzIHZlcndlbmRldCB3ZXJkZW4gc29sbC48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPk1ldGhvZGUgZsO8ciBkYXMgQWJzZW5kZW4gdm9uIEF1c2zDtnNlcmRva3VtZW50ZW48L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+V2FydGVzY2hsYW5nZSAoQ2FjaGUgdmVyd2VuZGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+RGlyZWt0IChDYWNoZSDDvGJlcmdlaGVuKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5UcmVpYmVyIHN0YXJ0ZW4sIHNvZmVybiBlciBuaWNodCBiZXJlaXRzIGzDpHVmdDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPlRyZWliZXIgbmFjaCBWZXJhcmJlaXRlbiB2b24gQXVzbMO2c2VybiBhbmhhbHRlbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iZW4iIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+U3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXI8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+VGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPlN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJCQk8c291cmNlPlVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5JZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWU8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJCQk8c291cmNlPlN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJCQk8c291cmNlPnF1ZXVlICh1c2UgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3QgKGJ5cGFzcyBjYWNoZSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+U3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocyk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImZyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQkJCTxoZWFkZXIvPgoJCQkJPGJvZHk+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJCQk8c291cmNlPkTDqWNsZW5jaGV1ciBkZSBjYW5hbCBhYm9ubsOpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPkNlIHRyYXZhaWwgYWRyZXNzZSB1biBvdSBwbHVzaWV1cnMgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnMgKG91IG4nZW4gc291bWV0IHBhcykgYXUgY2FuYWwgYWJvbm7DqS4gSWwgcGV1dCBlbnZveWVyIHVuIGRvY3VtZW50IHBhciBvYmpldCwgc2kgdW5lIMOpdGVuZHVlIGEgw6l0w6kgZMOpZmluaWUsIG91IHVuIHNldWwgZG9jdW1lbnQgw6AgY2hhcXVlIGV4w6ljdXRpb24uPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+U291bWV0dHJlIHVuIGRvY3VtZW50IGTDqWNsZW5jaGV1ciBwb3VyIGxlcyBvYmpldHMgc2FucyBhc3NvY2lhdGlvbiBkZSBwaWxvdGUgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+VXRpbGlzZXIgbGUgQ04gZHUgdHJhdmFpbCBjb21tZSBpZGVudGlmaWNhdGV1ciBkZSBkb2N1bWVudCBkw6ljbGVuY2hldXIgPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT5MZSBjYXMgw6ljaMOpYW50LCB1dGlsaXNlciBsZSBDTiBkZSBsJ29iamV0IFRyYXZhaWwgY29tbWUgdmFsZXVyIGRlIGwnYXR0cmlidXQgInNvdXJjZSIgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyLjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPlZhbGV1ciBzb3VyY2UgZGUgbCfDqWzDqW1lbnQgZMOpY2xlbmNoZXVyPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT5DaGHDrm5lIMOgIHV0aWxpc2VyIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQkJCTxzb3VyY2U+TcOpdGhvZGUgZGUgc291bWlzc2lvbiBkZSBkb2N1bWVudHMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT5maWxlIGQnYXR0ZW50ZSAodXRpbGlzZXIgbGUgY2FjaGUpPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT5kaXJlY3RlICjDqXZpdGVyIGxlIGNhY2hlKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT5Ew6ltYXJyZXIgbGUgcGlsb3RlIGF1IGJlc29pbjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJCQk8c291cmNlPkFycsOqdGVyIGxlIHBpbG90ZSDDoCBsYSBmaW4gZHUgdHJhaXRlbWVudCBkZXMgZMOpY2xlbmNoZXVyczwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCTwvYm9keT4KCQkJPC9maWxlPjwveGxpZmY+PHhsaWZmIHZlcnNpb249IjEuMCI+PGZpbGUgZGF0YXR5cGU9InhsaWZmIiBvcmlnaW5hbD0iVHJpZ2dlci54bWwiIHNvdXJjZS1sYW5ndWFnZT0iamEiIHhtbDpzcGFjZT0icHJlc2VydmUiPgoJCQkJPGhlYWRlci8+CgkJCQk8Ym9keT4KCQkJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRpc3BsYXktbmFtZSI+CgkJCQkJCTxzb3VyY2U+6LO86Kqt6ICF44OB44Oj44ON44Or44OI44Oq44KsPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJCQk8c291cmNlPuOBk+OBruOCuOODp+ODluOBr+OCvOODreOBvuOBn+OBr+ikh+aVsOOBruODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkuizvOiqreiAheODgeODo+ODjeODq+OBq+mAgeS/oeOBl+OBvuOBmeOAguOBk+OBrumAgeS/oeOBr+OCueOCs+ODvOODl+OBjOWumue+qeOBleOCjOOBpuOBhOOCi+WgtOWQiOOBr+OCquODluOCuOOCp+OCr+ODiOOBlOOBqOOBqzHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgIHjgb7jgZ/jga/lkITjgrjjg6fjg5blrp/ooYzjgavlr77jgZfjgaYx44Gk44Gu44OJ44Kt44Ol44Oh44Oz44OI44Go44Gq44KK44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+44OJ44Op44Kk44OQ44Gu6Zai6YCj5LuY44GR44Gq44GX44Gn44Kq44OW44K444Kn44Kv44OI44Gr5a++44GZ44KL44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GX44G+44GZ44GLPzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+44K444On44OWQ07jgpLjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jorZjliKXlrZDjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJCQk8c291cmNlPuioreWumuOBleOCjOOBpuOBhOOCi+WgtOWQiOOAgeOCuOODp+ODluOCquODluOCuOOCp+OCr+ODiOOBrkNO44KS44OI44Oq44Ks6KaB57Sg44Gu772i44K944O844K5772j5bGe5oCn44Gu5YCk44Go44GX44Gm5L2/55So44GX44G+44GZ44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks6KaB57Sg44K944O844K55YCkPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjga7vvaLjgr3jg7zjgrnvvaPlsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZnjgovmloflrZfliJfjgafjgZnjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuODiOODquOCrOODieOCreODpeODoeODs+ODiOOCkumAgeS/oeOBmeOCi+OBn+OCgeOBruaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7jgq3jg6Xjg7wo44Kt44Oj44OD44K344Ol44Gu5L2/55SoKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LWRpcmVjdCI+CgkJCQkJCTxzb3VyY2U+55u05o6lKOODkOOCpOODkeOCueOCreODo+ODg+OCt+ODpSk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6f6KGM44GX44Gm44GE44Gq44GE5aC05ZCI44OJ44Op44Kk44OQ44KS6ZaL5aeL44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+44OI44Oq44Ks44Gu5Yem55CG44GM57WC5LqG44GX44Gf5aC05ZCI44OJ44Op44Kk44OQ44KS5YGc5q2i44GZ44KLPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9DTiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7orqLotK3ogIXpgJrpgZPop6blj5Hlmag8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+6K+l5L2c5Lia5bCG5ZCR6K6i6LSt6ICF6YCa6YGT5o+Q5LqkIDAg5Liq5oiW5aSa5Liq6Kem5Y+R5Zmo5paH5qGj44CC5aaC5p6c5a6a5LmJ5LqG6IyD5Zu077yM5Y+v5Lul5a+55q+P5Liq5a+56LGh5o+Q5Lqk5LiA5Liq5paH5qGj77yM5Lmf5Y+v5Lul5a+55q+P5qyh5L2c5Lia6L+Q6KGM5o+Q5Lqk5LiA5Liq5paH5qGj44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQkJCTxzb3VyY2U+5Li65rKh5pyJ6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj5ZCX77yfPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCQkJPHNvdXJjZT7lsIbigJzkvZzkuJogQ07igJ3nlKjkvZzop6blj5HlmajmlofmoaPnmoTmoIfor4bnrKblkJfvvJ88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQkJCTxzb3VyY2U+5aaC5p6c6K6+572u77yM5bCG5oqK6K+l5L2c5Lia5a+56LGh55qEIENOIOeUqOS9nOinpuWPkeWZqOWFg+e0oOeahOKAnOa6kOKAneeJueaAp+eahOWAvOOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJCQk8c291cmNlPuinpuWPkeWZqOWFg+e0oOa6kOWAvDwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQkJCTxzb3VyY2U+55So5L2c6Kem5Y+R5Zmo5YWD57Sg4oCc5rqQ4oCd54m55oCn55qE5YC855qE5a2X56ym5Liy44CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCQkJPHNvdXJjZT7mj5DkuqTop6blj5HlmajmlofmoaPnmoTmlrnlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQkJCTxzb3VyY2U+6Zif5YiX77yI5L2/55So6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCQkJPHNvdXJjZT7nm7TmjqXvvIjnu5Xov4fotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5ZCv5Yqo6amx5Yqo56iL5bqP77yI5aaC5p6c5pyq6L+Q6KGM77yJPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJzdG9wLWRyaXZlciI+CgkJCQkJCTxzb3VyY2U+5a6M5oiQ5a+56Kem5Y+R5Zmo55qE5aSE55CG5pe25YGc5q2i6amx5Yqo56iL5bqPPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJPC9ib2R5PgoJCQk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9UVyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJCQk8aGVhZGVyLz4KCQkJCTxib2R5PgoJCQkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCQkJPHNvdXJjZT7oqILplrHogIXpgJrpgZPop7jnmbznqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQkJCTxzb3VyY2U+5q2k5bel5L2c5pyD5o+Q5Lqk6Zu25YCL5Lul5LiK55qE6Ke455m85paH5Lu26Iez6KiC6Zax6ICF6YCa6YGT44CC5q2k5L2c5qWt5Y+v6IO95q+P5LiA5YCL54mp5Lu25o+Q5Lqk5LiA5Lu95paH5Lu2ICjoi6Xlt7Llrprnvqnnr4TlnI0pIOaIluWPr+iDveavj+S4gOWAi+W3peS9nOaPkOS6pOWWruS4gOS7veaWh+S7tuOAgjwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJCQk8c291cmNlPuaYr+WQpuimgeeCuuaykuaciempheWLleeoi+W8j+mXnOiBr+eahOeJqeS7tuaPkOS6pOinuOeZvOaWh+S7tu+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQkJCTxzb3VyY2U+5piv5ZCm6KaB5Lul44CM5bel5L2cIENO44CNIOWBmueCuuinuOeZvOaWh+S7tuitmOWIpeeivO+8nzwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lpoLmnpzoqK3lrprvvIzliYfoq4vku6Xlt6XkvZznianku7bnmoQgQ04g5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQkJCTxzb3VyY2U+6Ke455m85YWD57Sg5L6G5rqQ5YC8PC9zb3VyY2U+CgkJCQkJPC90cmFucy11bml0PgoJCQkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCQkJPHNvdXJjZT7lrZfkuLLvvIzlgZrngrrop7jnmbzlhYPntKDkuYvjgIzkvobmupDjgI3lsazmgKflgLzjgII8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJCQk8c291cmNlPuinuOeZvOaWh+S7tueahOaPkOS6pOaWueazlTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCQkJPHNvdXJjZT7kvYfliJcgKOS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJCQk8c291cmNlPuebtOaOpSAo5LiN5L2/55So5b+r5Y+WKTwvc291cmNlPgoJCQkJCTwvdHJhbnMtdW5pdD4KCQkJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7llZ/li5XpqYXli5XnqIvlvI8gKOiLpeacquWft+ihjCk8L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCQkJPHNvdXJjZT7nlbblrozmiJDomZXnkIbop7jnmbznqIvlvI/mmYLlgZzmraLpqYXli5XnqIvlvI88L3NvdXJjZT4KCQkJCQk8L3RyYW5zLXVuaXQ+CgkJCQk8L2JvZHk+CgkJCTwvZmlsZT48L3hsaWZmPjwvam9iLWFnZ3JlZ2F0aW9uPg==]]></ds-value>
					</ds-attribute>
					<job-email-server-query job-name="cn=Job-StartToday-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-StartToday-Schedule,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
            <ds-object ds-object-class="DirXML-Job" ds-object-name="Job-UpdateTables">
				<ds-attributes>
					<ds-attribute ds-attr-name="DirXML-TraceLevel">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="DirXML-TraceSizeLimit">
						<ds-value/>
					</ds-attribute>
					<ds-attribute ds-attr-name="XmlData">
						<ds-value base64-encoded="true"><![CDATA[PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48am9iLWFnZ3JlZ2F0aW9uPjxqb2ItZGVmaW5pdGlvbiBhdXRvLWRlbGV0ZT0iZmFsc2UiIGRpc2FibGVkPSJmYWxzZSIgZGlzcGxheS1uYW1lPSJ4bGZpZChqb2ItZGlzcGxheS1uYW1lKVN1YnNjcmliZXIgY2hhbm5lbCB0cmlnZ2VyIiBzY2hlZHVsZT0iMCAyMCAqICogMCIgc2NvcGUtcmVxdWlyZWQ9ImZhbHNlIiB0eXBlPSJqYXZhIj48ZGVzY3JpcHRpb24+eGxmaWQoam9iLWRlc2NyaXB0aW9uKVRoaXMgam9iIHN1Ym1pdHMgemVybyBvciBtb3JlIHRyaWdnZXIgZG9jdW1lbnRzIHRvIHRoZSBzdWJzY3JpYmVyIGNoYW5uZWwuIFRoZSBzdWJtaXNzaW9uIG1heSBlaXRoZXIgYmUgYSBkb2N1bWVudCBwZXIgb2JqZWN0IGlmIGEgc2NvcGUgaXMgZGVmaW5lZCBvciBtYXkgYmUgYSBzaW5nbGUgZG9jdW1lbnQgZm9yIGVhY2ggam9iIHJ1bi48L2Rlc2NyaXB0aW9uPjxjb250YWlubWVudD5EaXJYTUwtRHJpdmVyPC9jb250YWlubWVudD48amF2YS1jbGFzcz5jb20ubm92ZWxsLm5kcy5kaXJ4bWwuam9iLnRyaWdnZXIuVHJpZ2dlcjwvamF2YS1jbGFzcz48Y29uZmlndXJhdGlvbi12YWx1ZXM+PGRlZmluaXRpb25zPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQocHJvY2Vzcy11bmFzc29jaWF0ZWQpU3VibWl0IGEgdHJpZ2dlciBkb2N1bWVudCBmb3Igb2JqZWN0cyB3aXRob3V0IGEgZHJpdmVyIGFzc29jaWF0aW9uPyIgbmFtZT0icHJvY2Vzcy11bmFzc29jaWF0ZWQiIHR5cGU9ImJvb2xlYW4iPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PGdyb3VwPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQodXNlLWpvYi1jbilVc2UgSm9iIENOIGFzIHRyaWdnZXIgZG9jdW1lbnQgaWRlbnRpZmllcj8iIG5hbWU9InVzZS1qb2ItY24iIHR5cGU9ImJvb2xlYW4iPjxkZXNjcmlwdGlvbj54bGZpZCh1c2Utam9iLWNuLWRlc2MpSWYgc2V0LCB1c2UgdGhlIGpvYiBvYmplY3QncyBDTiBhcyB0aGUgdmFsdWUgb2YgdGhlIHRyaWdnZXIgZWxlbWVudCdzICJzb3VyY2UiIGF0dHJpYnV0ZS48L2Rlc2NyaXB0aW9uPjx2YWx1ZT50cnVlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9ImZhbHNlIj48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHRyaWdnZXItc291cmNlKVRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWUiIG5hbWU9InRyaWdnZXItc291cmNlIiB0eXBlPSJzdHJpbmciPjxkZXNjcmlwdGlvbj54bGZpZCh0cmlnZ2VyLXNvdXJjZS1kZXNjKVN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvZGVzY3JpcHRpb24+PHZhbHVlPjE8L3ZhbHVlPjwvZGVmaW5pdGlvbj48L3N1Ym9yZGluYXRlcz48L2dyb3VwPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN1Ym1pdC1tZXRob2QpTWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzIiBuYW1lPSJzdWJtaXQtbWV0aG9kIiB0eXBlPSJlbnVtIj48ZW51bS1jaG9pY2UgZGlzcGxheS1uYW1lPSJ4bGZpZChzdWJtaXQtcXVldWUpcXVldWUgKHVzZSBjYWNoZSkiPnN1Ym1pdC1xdWV1ZTwvZW51bS1jaG9pY2U+PGVudW0tY2hvaWNlIGRpc3BsYXktbmFtZT0ieGxmaWQoc3VibWl0LWRpcmVjdClkaXJlY3QgKGJ5cGFzcyBjYWNoZSkiPnN1Ym1pdC1kaXJlY3Q8L2VudW0tY2hvaWNlPjx2YWx1ZT5zdWJtaXQtZGlyZWN0PC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InN1Ym1pdC1kaXJlY3QiPjxncm91cD48ZGVmaW5pdGlvbiBkaXNwbGF5LW5hbWU9InhsZmlkKHN0YXJ0LWRyaXZlcilTdGFydCBkcml2ZXIgaWYgbm90IHJ1bm5pbmciIG5hbWU9InN0YXJ0LWRyaXZlciIgdHlwZT0iYm9vbGVhbiI+PHZhbHVlPmZhbHNlPC92YWx1ZT48L2RlZmluaXRpb24+PHN1Ym9yZGluYXRlcyBhY3RpdmUtdmFsdWU9InRydWUiPjxkZWZpbml0aW9uIGRpc3BsYXktbmFtZT0ieGxmaWQoc3RvcC1kcml2ZXIpU3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocykiIG5hbWU9InN0b3AtZHJpdmVyIiB0eXBlPSJib29sZWFuIj48dmFsdWU+dHJ1ZTwvdmFsdWU+PC9kZWZpbml0aW9uPjwvc3Vib3JkaW5hdGVzPjwvZ3JvdXA+PC9zdWJvcmRpbmF0ZXM+PC9ncm91cD48L2RlZmluaXRpb25zPjwvY29uZmlndXJhdGlvbi12YWx1ZXM+PC9qb2ItZGVmaW5pdGlvbj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJkZSIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJPGhlYWRlci8+CgkJPGJvZHk+CgkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCTxzb3VyY2U+QWJvbm5lbnRlbmthbmFsYXVzbMO2c2VyPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQk8c291cmNlPk1pdCBkaWVzZW0gQXVmdHJhZyB3ZXJkZW4gbnVsbCBvZGVyIG1laHIgQXVzbMO2c2VyZG9rdW1lbnRlIGFuIGRlbiBBYm9ubmVudGVua2FuYWwgYWJnZXNlbmRldC4gRGFiZWkga2FubiBlcyBzaWNoIHVtIGVpbiBEb2t1bWVudCBwcm8gT2JqZWt0IGhhbmRlbG4sIHNvZmVybiBlaW4gQmVyZWljaCBkZWZpbmllcnQgd3VyZGUsIG9kZXIgdW0gZWluIGVpbnplbG5lcyBEb2t1bWVudCBmw7xyIGplZGUgQXVmdHJhZ3NhdXNmw7xocnVuZy48L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJPHNvdXJjZT5BdXNsw7ZzZXJkb2t1bWVudCBmw7xyIE9iamVrdGUgb2huZSBUcmVpYmVyenVvcmRudW5nIGFic2VuZGVuPzwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuIj4KCQkJCTxzb3VyY2U+QXVmdHJhZ3MtQ04gYWxzIEF1c2zDtnNlcmRva3VtZW50YmV6ZWljaG5lciB2ZXJ3ZW5kZW4/PC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24tZGVzYyI+CgkJCQk8c291cmNlPldlbm4gZmVzdGdlbGVndCwgd2lyZCBkZXIgQ04gZGVzIEF1ZnRyYWdzb2JqZWt0cyBhbHMgV2VydCBmw7xyIGRhcyBVcnNwcnVuZ3NhdHRyaWJ1dCBkZXMgQXVzbMO2c2VyZWxlbWVudHMgdmVyd2VuZGV0Ljwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQk8c291cmNlPlVyc3BydW5nc3dlcnQgZGVzIEF1c2zDtnNlcmVsZW1lbnRzPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InRyaWdnZXItc291cmNlLWRlc2MiPgoJCQkJPHNvdXJjZT5aZWljaGVua2V0dGUsIGRpZSBhbHMgV2VydCBmw7xyIGRhcyBVcnNwcnVuZ3NhdHRyaWJ1dCBkZXMgQXVzbMO2c2VyZWxlbWVudHMgdmVyd2VuZGV0IHdlcmRlbiBzb2xsLjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCTxzb3VyY2U+TWV0aG9kZSBmw7xyIGRhcyBBYnNlbmRlbiB2b24gQXVzbMO2c2VyZG9rdW1lbnRlbjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtcXVldWUiPgoJCQkJPHNvdXJjZT5XYXJ0ZXNjaGxhbmdlIChDYWNoZSB2ZXJ3ZW5kZW4pPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJPHNvdXJjZT5EaXJla3QgKENhY2hlIMO8YmVyZ2VoZW4pPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN0YXJ0LWRyaXZlciI+CgkJCQk8c291cmNlPlRyZWliZXIgc3RhcnRlbiwgc29mZXJuIGVyIG5pY2h0IGJlcmVpdHMgbMOkdWZ0PC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCTxzb3VyY2U+VHJlaWJlciBuYWNoIFZlcmFyYmVpdGVuIHZvbiBBdXNsw7ZzZXJuIGFuaGFsdGVuPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQk8L2JvZHk+Cgk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJlbiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJPGhlYWRlci8+CgkJPGJvZHk+CgkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCTxzb3VyY2U+U3Vic2NyaWJlciBjaGFubmVsIHRyaWdnZXI8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCTxzb3VyY2U+VGhpcyBqb2Igc3VibWl0cyB6ZXJvIG9yIG1vcmUgdHJpZ2dlciBkb2N1bWVudHMgdG8gdGhlIHN1YnNjcmliZXIgY2hhbm5lbC4gVGhlIHN1Ym1pc3Npb24gbWF5IGVpdGhlciBiZSBhIGRvY3VtZW50IHBlciBvYmplY3QgaWYgYSBzY29wZSBpcyBkZWZpbmVkIG9yIG1heSBiZSBhIHNpbmdsZSBkb2N1bWVudCBmb3IgZWFjaCBqb2IgcnVuLjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQk8c291cmNlPlN1Ym1pdCBhIHRyaWdnZXIgZG9jdW1lbnQgZm9yIG9iamVjdHMgd2l0aG91dCBhIGRyaXZlciBhc3NvY2lhdGlvbj88L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQk8c291cmNlPlVzZSBKb2IgQ04gYXMgdHJpZ2dlciBkb2N1bWVudCBpZGVudGlmaWVyPzwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ1c2Utam9iLWNuLWRlc2MiPgoJCQkJPHNvdXJjZT5JZiBzZXQsIHVzZSB0aGUgam9iIG9iamVjdCdzIENOIGFzIHRoZSB2YWx1ZSBvZiB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQk8c291cmNlPlRyaWdnZXIgZWxlbWVudCBzb3VyY2UgdmFsdWU8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQk8c291cmNlPlN0cmluZyB0byB1c2UgYXMgdGhlIHZhbHVlIGZvciB0aGUgdHJpZ2dlciBlbGVtZW50J3MgInNvdXJjZSIgYXR0cmlidXRlLjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCTxzb3VyY2U+TWV0aG9kIGZvciBzdWJtaXR0aW5nIHRyaWdnZXIgZG9jdW1lbnRzPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQk8c291cmNlPnF1ZXVlICh1c2UgY2FjaGUpPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJPHNvdXJjZT5kaXJlY3QgKGJ5cGFzcyBjYWNoZSk8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCTxzb3VyY2U+U3RhcnQgZHJpdmVyIGlmIG5vdCBydW5uaW5nPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCTxzb3VyY2U+U3RvcCBkcml2ZXIgd2hlbiBmaW5pc2hlZCBwcm9jZXNzaW5nIHRyaWdnZXIocyk8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCTwvYm9keT4KCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImZyIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQk8aGVhZGVyLz4KCQk8Ym9keT4KCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJPHNvdXJjZT5Ew6ljbGVuY2hldXIgZGUgY2FuYWwgYWJvbm7DqTwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJqb2ItZGVzY3JpcHRpb24iPgoJCQkJPHNvdXJjZT5DZSB0cmF2YWlsIGFkcmVzc2UgdW4gb3UgcGx1c2lldXJzIGRvY3VtZW50cyBkw6ljbGVuY2hldXJzIChvdSBuJ2VuIHNvdW1ldCBwYXMpIGF1IGNhbmFsIGFib25uw6kuIElsIHBldXQgZW52b3llciB1biBkb2N1bWVudCBwYXIgb2JqZXQsIHNpIHVuZSDDqXRlbmR1ZSBhIMOpdMOpIGTDqWZpbmllLCBvdSB1biBzZXVsIGRvY3VtZW50IMOgIGNoYXF1ZSBleMOpY3V0aW9uLjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJwcm9jZXNzLXVuYXNzb2NpYXRlZCI+CgkJCQk8c291cmNlPlNvdW1ldHRyZSB1biBkb2N1bWVudCBkw6ljbGVuY2hldXIgcG91ciBsZXMgb2JqZXRzIHNhbnMgYXNzb2NpYXRpb24gZGUgcGlsb3RlID88L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQk8c291cmNlPlV0aWxpc2VyIGxlIENOIGR1IHRyYXZhaWwgY29tbWUgaWRlbnRpZmljYXRldXIgZGUgZG9jdW1lbnQgZMOpY2xlbmNoZXVyID88L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCTxzb3VyY2U+TGUgY2FzIMOpY2jDqWFudCwgdXRpbGlzZXIgbGUgQ04gZGUgbCdvYmpldCBUcmF2YWlsIGNvbW1lIHZhbGV1ciBkZSBsJ2F0dHJpYnV0ICJzb3VyY2UiIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1ci48L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJPHNvdXJjZT5WYWxldXIgc291cmNlIGRlIGwnw6lsw6ltZW50IGTDqWNsZW5jaGV1cjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCTxzb3VyY2U+Q2hhw65uZSDDoCB1dGlsaXNlciBjb21tZSB2YWxldXIgZGUgbCdhdHRyaWJ1dCAic291cmNlIiBkZSBsJ8OpbMOpbWVudCBkw6ljbGVuY2hldXI8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LW1ldGhvZCI+CgkJCQk8c291cmNlPk3DqXRob2RlIGRlIHNvdW1pc3Npb24gZGUgZG9jdW1lbnRzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCTxzb3VyY2U+ZmlsZSBkJ2F0dGVudGUgKHV0aWxpc2VyIGxlIGNhY2hlKTwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtZGlyZWN0Ij4KCQkJCTxzb3VyY2U+ZGlyZWN0ZSAow6l2aXRlciBsZSBjYWNoZSk8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCTxzb3VyY2U+RMOpbWFycmVyIGxlIHBpbG90ZSBhdSBiZXNvaW48L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJPHNvdXJjZT5BcnLDqnRlciBsZSBwaWxvdGUgw6AgbGEgZmluIGR1IHRyYWl0ZW1lbnQgZGVzIGTDqWNsZW5jaGV1cnM8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCTwvYm9keT4KCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9ImphIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQk8aGVhZGVyLz4KCQk8Ym9keT4KCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJPHNvdXJjZT7os7zoqq3ogIXjg4Hjg6Pjg43jg6vjg4jjg6rjgqw8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCTxzb3VyY2U+44GT44Gu44K444On44OW44Gv44K844Ot44G+44Gf44Gv6KSH5pWw44Gu44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6LO86Kqt6ICF44OB44Oj44ON44Or44Gr6YCB5L+h44GX44G+44GZ44CC44GT44Gu6YCB5L+h44Gv44K544Kz44O844OX44GM5a6a576p44GV44KM44Gm44GE44KL5aC05ZCI44Gv44Kq44OW44K444Kn44Kv44OI44GU44Go44GrMeOBpOOBruODieOCreODpeODoeODs+ODiOOAgeOBvuOBn+OBr+WQhOOCuOODp+ODluWun+ihjOOBq+WvvuOBl+OBpjHjgaTjga7jg4njgq3jg6Xjg6Hjg7Pjg4jjgajjgarjgorjgb7jgZnjgII8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJPHNvdXJjZT7jg4njg6njgqTjg5Djga7plqLpgKPku5jjgZHjgarjgZfjgafjgqrjg5bjgrjjgqfjgq/jg4jjgavlr77jgZnjgovjg4jjg6rjgqzjg4njgq3jg6Xjg6Hjg7Pjg4jjgpLpgIHkv6HjgZfjgb7jgZnjgYs/PC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJPHNvdXJjZT7jgrjjg6fjg5ZDTuOCkuODiOODquOCrOODieOCreODpeODoeODs+ODiOitmOWIpeWtkOOBqOOBl+OBpuS9v+eUqOOBl+OBvuOBmeOBiz88L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCTxzb3VyY2U+6Kit5a6a44GV44KM44Gm44GE44KL5aC05ZCI44CB44K444On44OW44Kq44OW44K444Kn44Kv44OI44GuQ07jgpLjg4jjg6rjgqzopoHntKDjga7jgIzjgr3jg7zjgrnjgI3lsZ7mgKfjga7lgKTjgajjgZfjgabkvb/nlKjjgZfjgb7jgZnjgII8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UiPgoJCQkJPHNvdXJjZT7jg4jjg6rjgqzopoHntKDjgr3jg7zjgrnlgKQ8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idHJpZ2dlci1zb3VyY2UtZGVzYyI+CgkJCQk8c291cmNlPuODiOODquOCrOimgee0oOOBruOAjOOCveODvOOCueOAjeWxnuaAp+OBruWApOOBqOOBl+OBpuS9v+eUqOOBmeOCi+aWh+Wtl+WIl+OBp+OBmeOAgjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJzdWJtaXQtbWV0aG9kIj4KCQkJCTxzb3VyY2U+44OI44Oq44Ks44OJ44Kt44Ol44Oh44Oz44OI44KS6YCB5L+h44GZ44KL44Gf44KB44Gu5pa55rOVPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1xdWV1ZSI+CgkJCQk8c291cmNlPuOCreODpeODvCjjgq3jg6Pjg4Pjgrfjg6Xjga7kvb/nlKgpPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJPHNvdXJjZT7nm7TmjqUo44OQ44Kk44OR44K544Kt44Oj44OD44K344OlKTwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJzdGFydC1kcml2ZXIiPgoJCQkJPHNvdXJjZT7lrp/ooYzjgZfjgabjgYTjgarjgYTloLTlkIjjg4njg6njgqTjg5DjgpLplovlp4vjgZnjgos8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3RvcC1kcml2ZXIiPgoJCQkJPHNvdXJjZT7jg4jjg6rjgqzjga7lh6bnkIbjgYzntYLkuobjgZfjgZ/loLTlkIjjg4njg6njgqTjg5DjgpLlgZzmraLjgZnjgos8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCTwvYm9keT4KCTwvZmlsZT48L3hsaWZmPjx4bGlmZiB2ZXJzaW9uPSIxLjAiPjxmaWxlIGRhdGF0eXBlPSJ4bGlmZiIgb3JpZ2luYWw9IlRyaWdnZXIueG1sIiBzb3VyY2UtbGFuZ3VhZ2U9InpoX0NOIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KCQk8aGVhZGVyLz4KCQk8Ym9keT4KCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kaXNwbGF5LW5hbWUiPgoJCQkJPHNvdXJjZT7orqLotK3ogIXpgJrpgZPop6blj5Hlmag8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0iam9iLWRlc2NyaXB0aW9uIj4KCQkJCTxzb3VyY2U+6K+l5L2c5Lia5bCG5ZCR6K6i6LSt6ICF6YCa6YGT5o+Q5LqkIDAg5Liq5oiW5aSa5Liq6Kem5Y+R5Zmo5paH5qGj44CC5aaC5p6c5a6a5LmJ5LqG6IyD5Zu077yM5Y+v5Lul5a+55q+P5Liq5a+56LGh5o+Q5Lqk5LiA5Liq5paH5qGj77yM5Lmf5Y+v5Lul5a+55q+P5qyh5L2c5Lia6L+Q6KGM5o+Q5Lqk5LiA5Liq5paH5qGj44CCPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InByb2Nlc3MtdW5hc3NvY2lhdGVkIj4KCQkJCTxzb3VyY2U+5Li65rKh5pyJ6amx5Yqo56iL5bqP5YWz6IGU55qE5a+56LGh5o+Q5Lqk6Kem5Y+R5Zmo5paH5qGj5ZCX77yfPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InVzZS1qb2ItY24iPgoJCQkJPHNvdXJjZT7lsIbigJzkvZzkuJogQ07igJ3nlKjkvZzop6blj5HlmajmlofmoaPnmoTmoIfor4bnrKblkJfvvJ88L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCTxzb3VyY2U+5aaC5p6c6K6+572u77yM5bCG5oqK6K+l5L2c5Lia5a+56LGh55qEIENOIOeUqOS9nOinpuWPkeWZqOWFg+e0oOeahOKAnOa6kOKAneeJueaAp+eahOWAvOOAgjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQk8c291cmNlPuinpuWPkeWZqOWFg+e0oOa6kOWAvDwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCTxzb3VyY2U+55So5L2c6Kem5Y+R5Zmo5YWD57Sg4oCc5rqQ4oCd54m55oCn55qE5YC855qE5a2X56ym5Liy44CCPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJPHNvdXJjZT7mj5DkuqTop6blj5HlmajmlofmoaPnmoTmlrnlvI88L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCTxzb3VyY2U+6Zif5YiX77yI5L2/55So6LaF6YCf57yT5a2Y77yJPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJPHNvdXJjZT7nm7TmjqXvvIjnu5Xov4fotoXpgJ/nvJPlrZjvvIk8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCTxzb3VyY2U+5ZCv5Yqo6amx5Yqo56iL5bqP77yI5aaC5p6c5pyq6L+Q6KGM77yJPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCTxzb3VyY2U+5a6M5oiQ5a+56Kem5Y+R5Zmo55qE5aSE55CG5pe25YGc5q2i6amx5Yqo56iL5bqPPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQk8L2JvZHk+Cgk8L2ZpbGU+PC94bGlmZj48eGxpZmYgdmVyc2lvbj0iMS4wIj48ZmlsZSBkYXRhdHlwZT0ieGxpZmYiIG9yaWdpbmFsPSJUcmlnZ2VyLnhtbCIgc291cmNlLWxhbmd1YWdlPSJ6aF9UVyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CgkJPGhlYWRlci8+CgkJPGJvZHk+CgkJCTx0cmFucy11bml0IGlkPSJqb2ItZGlzcGxheS1uYW1lIj4KCQkJCTxzb3VyY2U+6KiC6Zax6ICF6YCa6YGT6Ke455m856iL5byPPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9ImpvYi1kZXNjcmlwdGlvbiI+CgkJCQk8c291cmNlPuatpOW3peS9nOacg+aPkOS6pOmbtuWAi+S7peS4iueahOinuOeZvOaWh+S7tuiHs+iogumWseiAhemAmumBk+OAguatpOS9nOalreWPr+iDveavj+S4gOWAi+eJqeS7tuaPkOS6pOS4gOS7veaWh+S7tiAo6Iul5bey5a6a576p56+E5ZyNKSDmiJblj6/og73mr4/kuIDlgIvlt6XkvZzmj5DkuqTllq7kuIDku73mlofku7bjgII8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0icHJvY2Vzcy11bmFzc29jaWF0ZWQiPgoJCQkJPHNvdXJjZT7mmK/lkKbopoHngrrmspLmnInpqYXli5XnqIvlvI/pl5zoga/nmoTnianku7bmj5DkuqTop7jnmbzmlofku7bvvJ88L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbiI+CgkJCQk8c291cmNlPuaYr+WQpuimgeS7peOAjOW3peS9nCBDTuOAjSDlgZrngrrop7jnmbzmlofku7borZjliKXnorzvvJ88L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0idXNlLWpvYi1jbi1kZXNjIj4KCQkJCTxzb3VyY2U+5aaC5p6c6Kit5a6a77yM5YmH6KuL5Lul5bel5L2c54mp5Lu255qEIENOIOWBmueCuuinuOeZvOWFg+e0oOS5i+OAjOS+hua6kOOAjeWxrOaAp+WAvOOAgjwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZSI+CgkJCQk8c291cmNlPuinuOeZvOWFg+e0oOS+hua6kOWAvDwvc291cmNlPgoJCQk8L3RyYW5zLXVuaXQ+CgkJCTx0cmFucy11bml0IGlkPSJ0cmlnZ2VyLXNvdXJjZS1kZXNjIj4KCQkJCTxzb3VyY2U+5a2X5Liy77yM5YGa54K66Ke455m85YWD57Sg5LmL44CM5L6G5rqQ44CN5bGs5oCn5YC844CCPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1tZXRob2QiPgoJCQkJPHNvdXJjZT7op7jnmbzmlofku7bnmoTmj5DkuqTmlrnms5U8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3VibWl0LXF1ZXVlIj4KCQkJCTxzb3VyY2U+5L2H5YiXICjkvb/nlKjlv6vlj5YpPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN1Ym1pdC1kaXJlY3QiPgoJCQkJPHNvdXJjZT7nm7TmjqUgKOS4jeS9v+eUqOW/q+WPlik8L3NvdXJjZT4KCQkJPC90cmFucy11bml0PgoJCQk8dHJhbnMtdW5pdCBpZD0ic3RhcnQtZHJpdmVyIj4KCQkJCTxzb3VyY2U+5ZWf5YuV6amF5YuV56iL5byPICjoi6XmnKrln7fooYwpPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQkJPHRyYW5zLXVuaXQgaWQ9InN0b3AtZHJpdmVyIj4KCQkJCTxzb3VyY2U+55W25a6M5oiQ6JmV55CG6Ke455m856iL5byP5pmC5YGc5q2i6amF5YuV56iL5byPPC9zb3VyY2U+CgkJCTwvdHJhbnMtdW5pdD4KCQk8L2JvZHk+Cgk8L2ZpbGU+PC94bGlmZj48L2pvYi1hZ2dyZWdhdGlvbj4=]]></ds-value>
					</ds-attribute>
					<job-servers-query job-display-name="Subscriber channel trigger" job-name="cn=Job-UpdateTables,cn=Service-Driver,cn=Driver Set,ou=IDM,o=servIces"/>
				</ds-attributes>
			</ds-object>
        </jobs>
        <publisher name="Publisher">
            <attributes/>
            <children/>
        </publisher>
        <resource content-type="application/vnd.novell.dirxml.mapping-table+xml ;charset=UTF-8" name="GreenlnkAttrMigration">
            <content contains="xml">
				<mapping-table>
					<col-def name="original" type="nocase"/>
					<col-def name="greenlnk" type="nocase"/>
					<row>
						<col>DirXML-ADAliasName</col>
						<col>abcGreenlnkDirXML-ADAliasName</col>
					</row>
					<row>
						<col>DirXML-ADContext</col>
						<col>abcGreenlnkDirXML-ADContext</col>
					</row>
					<row>
						<col>Telephone Number</col>
						<col>abcGreenlnkTelephoneNumber</col>
					</row>
					<row>
						<col>abcProxyAddresses</col>
						<col>abcGreenlnkProxyAddresses</col>
					</row>
					<row>
						<col>abcSIPAddress</col>
						<col>abcGreenlnkSIPAddress</col>
					</row>
					<row>
						<col>abcBusinessIPPhoneNumber</col>
						<col>abcGreenlnkBusinessIPPhoneNumber</col>
					</row>
					<row>
						<col>abcGLAccountExpirationDate</col>
						<col>abcGreenlnkAccountExpirationDate</col>
					</row>
					<row>
						<col>abcGLADcompany</col>
						<col>abcGreenlnkADcompany</col>
					</row>
					<row>
						<col>abcGLWriteBackDisabled</col>
						<col>abcGreenlnkWriteBackDisabled</col>
					</row>
					<row>
						<col>abcHomeDomain</col>
						<col>abcGreenlnkDomainName</col>
					</row>
					<row>
						<col>mobile</col>
						<col>abcGreenlnkMobile</col>
					</row>
				</mapping-table>
			</content>
        </resource>
        <resource content-type="text/ecmascript;charset=UTF-8" name="lib-DVE-scripts">
            <content contains="text">importClass(com.novell.nds.dirxml.driver.Trace);
importPackage(Packages.com.novell.xml.util);
importPackage(Packages.com.novell)
importPackage(Packages.javax.xml.parsers)
importPackage(Packages.javax.xml.xpath)
importPackage(Packages.org.xml.sax)
importPackage(Packages.java.io)

const DEFAULT_TRACE = 1;
const NO_TRACE = 0;
const XML_TRACE = 3;
var queryProcessor;
var debug;
var driver;
var addEvent;
var res;
var nonEmptyPattern;
var dateTimePatternSF;
var dateTimePatternVRS;
var attributeName;

// to test outside of IDM:
//Trace.registerImpl(com.trivir.ecma.lib.CustomTraceInterface, 1);
//const trace = new Trace("dveEngine");


function dveEngine(_attributeName, attributeValue, metaData) {
	var event = metaData.get(new com.novell.xml.xpath.StringValue("event"));
    /*(com.novell.nds.dirxml.driver.XdsQueryProcessor)*/
    queryProcessor =  metaData.get(new com.novell.xml.xpath.StringValue("queryProcessor"));
    debug = metaData.get(new com.novell.xml.xpath.StringValue("debug"));
    driver = metaData.get(new com.novell.xml.xpath.StringValue("driverAlias"));
	addEvent = metaData.get(new com.novell.xml.xpath.StringValue("event"));
	nonEmptyPattern = /[A-Za-z0-9]+/;
	dateTimePatternSF =/\b\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}\+\d{2}:\d{2}\b/;
	dateTimePatternVRS =/\b\d{4}-\d{2}-\d{2}\b/;
	dateTimePatternBlank = /\b1899-12-31.*\b/

    // Set to global value so we can use it in any helper function.
    attributeName = _attributeName;

	res = "SUCCESS";
	attributeName = attributeName
    var results = "";
    if (debug === "true") {
        //trace.trace("dveEngineStart# attribute# " + attributeName + "#" + attributeValue + "\n", XML_TRACE);
    }
    var isValidFunctionString = metaData.get(new com.novell.xml.xpath.StringValue("isvalid"));

    var isValidFunction = new Function("attributeName", "attributeValue", "metaData", isValidFunctionString);
    results += isValidFunction(attributeName, attributeValue, metaData);
    return results;
}

function validateAvailableNonEmpty(attributeValue) {
	if (res == "SUCCESS") {
		validateElementNotMissing(attributeValue);
	}

	if (res == "SUCCESS") {
		validateAttrNotEmpty(attributeValue);
	}
}

function validateDate(attributeValue, lowerRange, upperRange) {
	if (res == "SUCCESS") {
		validateAvailableNonEmpty(attributeValue);
	}

	if (driver == "HRDS" &amp;&amp; res == "SUCCESS") {
		validateFormatHRDS(attributeValue);
	}

	if (driver == "VRS" &amp;&amp; res == "SUCCESS") {
		validateFormatVRS(attributeValue);
	}

	if (res == "SUCCESS") {
		validateDateRange(attributeValue, lowerRange, upperRange);
	}
}


function validateElementNotMissing(attributeValue) {
	if (attributeValue === "ELEMENT-MISSING") {
		res = buildFailureVetoMSG(1, attributeName, attributeValue, attributeName + " is missing.")
	}
}

function validateAttrNotEmpty(attributeValue) {
	if (attributeValue === "ELEMENT-EMPTY" || attributeValue === null || attributeValue === undefined || (!nonEmptyPattern.test(attributeValue))) {
		res = buildFailureVetoMSG(2, attributeName, "ELEMENT-EMPTY", "The attribute value must not be empty.");
	}
}

function validateFormatHRDS(attributeValue) {
	if (!(dateTimePatternSF.test(attributeValue))) {
		res = buildFailureRetainMSG(3, attributeName, attributeValue, "Did not match format yyyy-MM-ddTHH:mm:ss zzz.");
	}
}

function validateFormatVRS(attributeValue) {
	if (!(dateTimePatternVRS.test(attributeValue))) {
		res = buildFailureRetainMSG(3, attributeName, attributeValue, "Did not match format yyyy-MM-dd.");
	}
}

function validateDateRange(attributeValue, lowerRangeLimit, upperRangeLimit) {
	if (dateTimePatternBlank.test(attributeValue)) {
		return;
	}

	var currentDate = new Date();
	var attributeDate = new Date(attributeValue);
	// 31536000000 number of milliseconds in a year
	if (lowerRangeLimit != 0) {
		if (((currentDate - attributeDate) / 31536000000) &gt; lowerRangeLimit) {
			res = buildFailureUpdateMSG(7, attributeName, attributeValue, "Is not within " + lowerRangeLimit + " years.");
		}
	}

	if (upperRangeLimit != 0) {
		if (((attributeDate - currentDate) / 31536000000) &gt; upperRangeLimit) {
			res = buildFailureUpdateMSG(7, attributeName, attributeValue, "Is not within " + upperRangeLimit + " years.");
		}
	}
}

function isInIDVList(attributeValue, destDN, xPathStr, index) {
	if (res == "SUCCESS") {
		validateAvailableNonEmpty(attributeValue);
	}

	if (res == "SUCCESS") {
		var scope = "entry";
		var association = "";
		var className = "DirXML-Resource";
		var searchAttr = "";
		var searchValue = "";
		var attrs = "DirXML-Data";

		if (debug === true) {
			results += "scope: " + scope + ", association: " + association + ", destDN: " + destDN + ", className: " + className + ", searchAttr: " + searchAttr + ", searchValue: " + searchValue + ", attrs: " + attrs;
		}

		var queryResults = queryProcessor.search(scope, association, destDN, className, searchAttr, searchValue, attrs);
		var encodedResultString = new Packages.java.lang.String(queryResults);
		var decodedResultString = b64decodeString(encodedResultString);
		/*DocumentBuilderFactory*/	var dbFactory = DocumentBuilderFactory.newInstance();
		/* DocumentBuilder*/		var builder = dbFactory.newDocumentBuilder();
		/* Document*/				var d = builder.parse(new InputSource(new StringReader(decodedResultString)));
		/* XPathFactory*/			var xpf = XPathFactory.newInstance();
		/* XPath*/					var xPath = xpf.newXPath();
		/* XPathExpression */		var expr = xPath.compile(xPathStr);
		/* NodeList*/				var resultNodeList = expr.evaluate(d, XPathConstants.NODESET);

		var hasMatch = false;

		for (var i = 0; i &lt; resultNodeList.getLength(); i++) {
			//Convert text content from object to string for comparison
			if (String(resultNodeList.item(i).getTextContent()) === attributeValue) {
				var hasMatch = true;
				break;
			}
		}

		if (!hasMatch) {
			res = buildFailureRetainMSG(index, attributeName, attributeValue, attributeName +" does not have a match in the "+ destDN + " table.");
		}
	}
}

function isInList(attributeValue, list) {
	if (res == "SUCCESS") {
		validateAvailableNonEmpty(attributeValue);
	}

	if (res == "SUCCESS") {
		var hasVal = false;
		for (var s = 0; s &lt; list.length; s++) {
			if (list[s] === attributeValue) {
				hasVal = true;
			}
		}
		if (!hasVal) {
			res = buildFailureRetainMSG(9, attributeName, attributeValue, attributeValue + " is not in the list ("+ list.toString() +").");
		}

	}
}

function buildFailureRetainMSG(index, attributeName, attributeValue, msg) {
    return "FAIL#" + index + "#retainIDV#" + "Attribute " + attributeName + ", with value of " + attributeValue + " had this issue: " + msg
}
function buildFailureVetoMSG(index, attributeName, attributeValue, msg) {
    return "FAIL#" + index + "#vetoEvent#" + "Attribute " + attributeName + ", with value of " + attributeValue + " had this issue: " + msg
}
function buildFailureUpdateMSG(index, attributeName, attributeValue, msg) {
    return "FAIL#" + index + "#overwriteIDV#" + "Attribute " + attributeName + ", with value of " + attributeValue + " had this issue: " + msg
}
function b64decodeString(encodedString) {
    var base64c = new Packages.com.novell.xml.util.Base64Codec();
    var byteStringArray = base64c.decode(encodedString);
    return new Packages.java.lang.String(byteStringArray);
}

// NOTE: just needed access to static method in String, is there a better way?
// Returns key set as 'delim'-ited string, to allow looping over a hashmap.
function getHashDelimStringFromKeySet(hashMapObject) {
	//return (new java.lang.String()).join(new java.lang.String("#"), hashMapObject.keySet());
	if (hashMapObject == null || hashMapObject.size() == 0) {
		// nothing to do:
		return "";
	}

	// is there a better way to access static java functions from ECMA?
	var dummyString = new java.lang.String();


	//return dummyString.join('#', hashMapObject.keySet())
	it = hashMapObject.keySet().iterator();
	var results = new java.lang.StringBuilder();

	while (it.hasNext()) {
		var key = it.next();
		results.append(key);
		//results.append("---");
		//results.append(hashMapObject.get(key));
		results.append(":");
	}

	// Drop the last # from the string:
	results = results.toString();
	results = results.substring(0, results.length() - 1);

	return results;
}

// Simple file writer for logging
function writeDVELog(fullOutputFilePathNoExt, srcDriver, euid, gciorvrsid, failid, priority, srcAttr, idvAttr, attrValue, message, toSMTPAddresses) {

/*
DateTime Format yyyy-MM-dd'T'HH:mm:sszzz
Driver Driver doing the validation check, e.g. SuccessFactors-Driver
User EUID EUID value of the existing IDV user.
User object reference GCI or VRSID
Failure ID Each validation check failure has a unique ID, which the log file would reference out to, e.g. AS-RO-996-3 is a failure of abcTrainingAwarenessCompleted date format validation check.
Attribute Priority (in line with attribute priority outlined in Person/Licence schema)
	1-Critical
	2-High
	3-Medium
	4-Low
Source Attribute Name Name of attribute from source feed (should be SourceAttributeName from the DVE table).
IDV Attribute Name Name of attribute in IDV.
Source Attribute Value Current attribute value in the feed.
Failure Reason(s) Reason for failure, e.g. "Error occurred due to failure in mapping table {INSERT MAPPING TABLE NAME}"
Recipient email addresses string@abcsystems.com
*/

	if (fullOutputFilePathNoExt.length &gt; 0) {
		// Add the date to the log file name so it rolls over naturally, daily:
		fullOutputFilePathNoExt += "." + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) + ".log";
		var writeString = "";
		var delim = ",";
	    try {
	    	writeString += "\"" + new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm.sszzz").format(new java.util.Date()) + "\"" + delim;
	    	writeString += "\"" + srcDriver + "\"" + delim;
			writeString += "\"" + euid + "\"" + delim;
			writeString += "\"" + gciorvrsid + "\"" + delim;
			writeString += "\"" + failid + "\"" + delim;
			writeString += "\"" + priority + "\"" + delim;
			writeString += "\"" + srcAttr + "\"" + delim;
			writeString += "\"" + idvAttr + "\"" + delim;
			writeString += "\"" + attrValue + "\"" + delim;
			writeString += "\"" + message + "\"" + delim;
			writeString += "\"" + toSMTPAddresses + "\"";
	    	var pw = new java.io.PrintWriter(new java.io.FileWriter(fullOutputFilePathNoExt, true));
	    	pw.println(writeString);
	    	pw.close();
	    } catch (e) {
	    	return "Error:" + e.toString();
	    }
	    return "SUCCESS";
	} else {
	  	return "DVE WARNING: Not logging, no path specified!"
	}
}

// Simple file writer for logging
function writeSnDobMatchLog(fullOutputFilePathNoExt, srcApp, idvGci, idvSurname, idvGivenName, idvPreferredName, idvDob, appGci, appSurname, appGivenName, appPreferredName, appDob, msg) {

/*
DateTime Format yyyy-MM-dd'T'HH:mm:sszzz
Driver Driver doing the validation check, e.g. SuccessFactors-Driver
*/

	if (fullOutputFilePathNoExt.length &gt; 0) {
		// Add the date to the log file name so it rolls over naturally, daily:
		fullOutputFilePathNoExt += "." + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) + ".log";
		var writeString = "";
		var delim = ",";
	    try {
	    	writeString += "\"" + new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm.sszzz").format(new java.util.Date()) + "\"" + delim;
	    	writeString += "\"" + appGci + "\"" + delim;
			writeString += "\"" + appSurname + "\"" + delim;
			writeString += "\"" + appGivenName + "\"" + delim;
			writeString += "\"" + appPreferredName + "\"" + delim;
			writeString += "\"" + appDob + "\"" + delim;
			writeString += "\"" + msg + "\"" + delim;
			writeString += "\"" + idvGci + "\"" + delim;
			writeString += "\"" + idvSurname + "\"" + delim;
			writeString += "\"" + idvGivenName + "\"" + delim;
			writeString += "\"" + idvPreferredName + "\"" + delim;
			writeString += "\"" + idvDob + "\"";
	    	var pw = new java.io.PrintWriter(new java.io.FileWriter(fullOutputFilePathNoExt, true));
	    	pw.println(writeString);
	    	pw.close();
	    } catch (e) {
	    	return "Error:" + e.toString();
	    }
	    return "SUCCESS";
	} else {
	  	return "MATCH WARNING: Not logging, no path specified!"
	}
}

// retrieve proper email address from LMS email string
// input: BU:AIR - "AIR:bicc.support@abcsystems.com,MAR-MS:Export.licence@abcsystems.com,MAR-NS:import.exportdept@abcsystems.com,LAND:LandUK.ExportControl@abcsystems.com
// expected response:
// bicc.support@abcsystems.com
function getLMSAddressByBU(_licenceBU, _lmsToAddressStrings, _dveTeamIDM) {
	//trace.trace("getLMSAddressByBU: entered");
	var returnAddress = "";
	var dveIDMTeam = new java.lang.String(_dveTeamIDM);
	lmsToAddressStrings = (new java.lang.String(_lmsToAddressStrings));
	licenceBU = (new java.lang.String(_licenceBU));

	var emailArray = lmsToAddressStrings.split(",");

	//trace.trace("getLMSAddressByBU: before loop: dveIDMTeam var is [" + dveIDMTeam + "]");

	// special case: if we get "~dveIDMTeam~" as the licence BU, it means we need to send the email to that team, so send it now.
	if (lmsToAddressStrings.equalsIgnoreCase(dveIDMTeam)) {
		//trace.trace("getLMSAddressByBU: returning " + dveIDMTeam + "!");
		return dveIDMTeam;
	}


	for (var i = 0; i &lt; emailArray.length; i++) {
		//trace.trace("getLMSAddressByBU: loop: licenceBU [" + licenceBU + ":]");
		//trace.trace("getLMSAddressByBU: loop: emailArray[i] [" + emailArray[i] + "]");
		if (emailArray[i].startsWith(licenceBU + ":")) {
			returnAddress = emailArray[i].substring(emailArray[i].indexOf(":") + 1);
			//trace.trace("getLMSAddressByBU: returnadress: [" + returnAddress + "]");
		}
	}

	//trace.trace("getLMSAddressByBU: exiting");
	return returnAddress;
}</content>
        </resource>
        <resource content-type="text/ecmascript;charset=UTF-8" name="Tools">
            <content contains="text">/*
 *	Copyright © 2009 TriVir, LLC. All rights reserved.
 *
 *  Except as otherwise permitted by TriVir, LLC., this publication, or parts
 *  thereof, may not be reproduced in any form, by any method, for any purpose.
 */
importPackage(Packages.javax.naming.directory);
importClass(Packages.java.io.File);
importClass(Packages.java.io.FileInputStream);
importClass(Packages.java.lang.System);
importClass(Packages.java.security.KeyStore);
importClass(Packages.java.util.Hashtable);
importClass(Packages.javax.naming.Context);
importClass(Packages.org.w3c.dom.Document);
importClass(Packages.org.w3c.dom.Element);
importClass(Packages.com.novell.nds.dirxml.driver.Trace);
importClass(Packages.com.novell.xml.xpath.NodeSet);
importClass(Packages.com.novell.xml.dom.DocumentFactory);

// Used by getXMLfromURL() function
importClass(Packages.java.net.HttpURLConnection);
importClass(Packages.java.net.URL);
importClass(Packages.java.io.DataOutputStream);
importClass(Packages.java.io.InputStreamReader);
importClass(Packages.java.io.BufferedReader);
importClass(Packages.java.lang.StringBuffer);
importClass(Packages.java.lang.Integer);



var trustStore = null;
var trustStoreType = null;
var trustStorePassword = null;
var debug = false;

//see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
if (!String.prototype.trim) {
  String.prototype.trim = function () {
    return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, '');
  };
}


function isString(string) {
	//TODO: do we need to do an instanceof test also?
    return (typeof string === 'string');
}

function isBlank(string) {
	return (!string || (isString(string) &amp;&amp; !string.trim()));
}

function addErrorStatus(document, ndsElement, error) {
	var outputElement = document.createElement("output");
	ndsElement.appendChild(outputElement);
	var statusElement = document.createElement("status");
	statusElement.setAttributeNS(null, "level", "error");
	statusElement.appendChild(document.createTextNode(error));
	outputElement.appendChild(statusElement);
}

 /**
 	Function wrapper for ldapsearch to help catch errors, and convert the result into a document for easier management
 */
function ldapSearchReturnAsDocument(host, useSSL, user, password, base, scope, filter, attrList) {
	try {
		nodeSetValue = ldapSearch(host, useSSL, user, password, base, scope, filter, attrList);
	} catch (e) {
		new Trace("ldapSearch").trace("Failed while executing ldap search, exception: " + e, 4);
		return "Failed while executing ldap search, exception: " + e;
	}

	try {
		nodeFirst = nodeSetValue.first();
	} catch(e) {
		new Trace("ldapSearch").trace("Failed while calling first: " + e);
		return "Failed while calling first: " + e;
	}

	try {
		return nodeFirst.getOwnerDocument();
	} catch(e) {
		new Trace("ldapSearch").trace("Failed while calling getownerdocument: " + e);
		return "Failed while calling getownerdocument: " + e;
	}

}

/**
 *  ldapSearch
 *
 * @param (String) host             DNS or IP-Address of LDAP server optionally including the listening port (e.g. 192.168.0.1:389)
 * @param (booelan) useSSL          Connect to the server using SSL
 * @param (String) user             Full distinguished name of LDAP account (e.g. sn=admin,o=users)
 * @param (String) password         Password for LDAP account
 * @param (String) base             Search base
 * @param (String) scope            Search scope, either base, one, or sub
 * @param (String) filter           LDAP search filter according to RFC2254
 * @param (String) attrList         Comma separated list of attributes to return
 * @return
 * @type Nodeset
 * @return NodeSet containing instances from search result, or status element with error message
 */
function ldapSearch(host, useSSL, user, password, base, scope, filter, attrList)
{
	var tracePrefix = "ldapSearch";
	var traceLevelDetails = 3;

	var trace = new Trace(tracePrefix);

	trace.trace("Validating parameters for ldapSearch...", traceLevelDetails);

	// Convert string to a full boolean so "if (useSSL)" compares properly:
	if (useSSL == 'true') {
		useSSL = true;
	} else {
		useSSL = false;
	}

	//TODO: if lowercase attr cotains 'password', do not trace the value
	trace.trace("host    : '" + host + "'");
	trace.trace("useSSL  : " + useSSL);
	trace.trace("user    : '" + user + "'");
	if (debug) {
		trace.trace("password: '" + password + "' (Turn off debug to remove this trace.)");
	}
	trace.trace("base    : '" + base + "'");
	trace.trace("scope   : '" + scope + "'");
	trace.trace("filter  : '" + filter + "'");
	trace.trace("attrList: '" + attrList + "'");

	if (isBlank(host)) {
		var msg = "Missing required 'host' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(password)) {
		var msg = "Missing required 'password' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	var nodeSet = new NodeSet();
	var document = DocumentFactory.newDocument();
	var ndsElement   = document.createElement("nds");
	document.appendChild(ndsElement);
	ndsElement.setAttributeNS(null, "dtdversion", "3.5");

    var ctls = new SearchControls();
    ctls.setCountLimit(0);
    ctls.setTimeLimit(0);
    if (scope.equalsIgnoreCase("base")) {
        ctls.setSearchScope(SearchControls.OBJECT_SCOPE);
    } else if (scope.equalsIgnoreCase("one")) {
        ctls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
    } else {
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
    }

	var attrArray = attrList.split(",");

	ctls.setReturningAttributes(attrArray);

	// Validate Trust Store if one is specified
    if (useSSL) {
        if (trustStore != null) {
            if (new File(trustStore).exists() == false) {
                addErrorStatus(document, ndsElement, "Keystore '" + trustStore + "' does not exist.");
                nodeSet.add(ndsElement);
                return nodeSet;
            }

            var keystore;
			try {
				keystore = KeyStore.getInstance(trustStoreType != null ? trustStoreType : KeyStore.getDefaultType());
			} catch (e) {
                addErrorStatus(document, ndsElement, "Error initializing keystore: " + e.javaException.getMessage());
                nodeSet.add(ndsElement);
                return nodeSet;
			}

            // Load the keystore contents
            var inputStream;
			try {
				inputStream = new FileInputStream(trustStore);
			} catch (e) {
                addErrorStatus(document, ndsElement, "Error opening keystore '" + trustStore + "': " + e.javaException.getMessage());
                nodeSet.add(ndsElement);
                return nodeSet;
			}

            try {
				keystore.load(inputStream, null);
			} catch (e) {
                addErrorStatus(document, ndsElement, "Error loading keystore '" + trustStore + "': " + e.javaException.getMessage());
                nodeSet.add(ndsElement);
                return nodeSet;
			}

			try {
				inputStream.close();
			} catch (e) {
                addErrorStatus(document, ndsElement, "Error closing keystore '" + trustStore + "': " + e.javaException.getMessage());
                nodeSet.add(ndsElement);
                return nodeSet;
			}
        }
	}

    var env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, user);
    env.put(Context.SECURITY_CREDENTIALS, password);
    env.put("com.sun.jndi.ldap.connect.timeout", "5000");
    if (useSSL) {
        env.put(Context.PROVIDER_URL, "ldaps://" + host);
        if (trustStore != null) {
            System.setProperty("javax.net.ssl.trustStore", trustStore);
            if (trustStoreType != null) {
                System.setProperty("javax.net.ssl.trustStoreType", trustStoreType);
            }
            if (trustStorePassword != null) {
                System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
            }
        }
        if (debug) {
            System.setProperty("javax.net.debug", "SSL,trustmanager");
        }
    } else {
        env.put(Context.PROVIDER_URL, "ldap://" + host);
	}

	var context = null;
    try {
        context = new InitialDirContext(env);
    } catch (e) {
        if (useSSL) {
            addErrorStatus(document, ndsElement, "Failed to obtain an SSL LDAP Connection: " + e.javaException.getMessage());
            nodeSet.add(ndsElement);
			return nodeSet;
        } else {
            addErrorStatus(document, ndsElement, "Failed to obtain an LDAP Connection: " + e.javaException.getMessage());
            nodeSet.add(ndsElement);
			return nodeSet;
        }
    }

	try {
		var outputElement = document.createElement("output");

		//Find objects with a matching filter
        var searchResults = context.search(base, filter, ctls);
        while (searchResults.hasMore()) {
			var nextEntry = searchResults.next();
        	var foundObjectDn;
        	if(nextEntry.getName() != null &amp;&amp; nextEntry.getName().length() &gt; 0) {
        		foundObjectDn = nextEntry.getName() + "," + base;
        	} else {
    			foundObjectDn = base;
        	}

			// create the instance node
			var instanceElement = document.createElement("instance");
			instanceElement.setAttributeNS(null,"src-dn", foundObjectDn);

			var attributeSet = nextEntry.getAttributes();
			var allAttributes = attributeSet.getAll();

			while (allAttributes.hasMore()) {
				var attribute =	allAttributes.next();
				var attrElement = document.createElement("attr");
				attrElement.setAttributeNS(null, "attr-name", attribute.getID());

				var allValues = attribute.getAll();

				if (allValues != null) {
					while(allValues.hasMoreElements()) {
						var value = allValues.nextElement();
						if (value instanceof String) {
						var valueElement = document.createElement("value");
							valueElement.appendChild(document.createTextNode(value));
						attrElement.appendChild(valueElement);
                        } else {
                            new Trace("ldapSearch").trace("Not adding value for '" + attribute.getID() + "' because it is not a String.", 4);
						}
					}
					instanceElement.appendChild(attrElement);
				}
			}
			outputElement.appendChild(instanceElement);
			nodeSet.add(instanceElement);
		}
		ndsElement.appendChild(outputElement);
	} catch(e) {
        document = DocumentFactory.newDocument();
		ndsElement = document.createElement("nds");
		document.appendChild(ndsElement);
		ndsElement.setAttributeNS(null, "dtdversion", "3.5");
        addErrorStatus(document, ndsElement, e.toString());
        nodeSet.add(ndsElement);
	}

	try {
		context.close();
	} catch (e) {
	}
	return nodeSet;
}

function addErrorStatus(document, ndsElement, error) {
	var outputElement = document.createElement("output");
	ndsElement.appendChild(outputElement);
	var statusElement = document.createElement("status");
	statusElement.setAttributeNS(null, "level", "error");
	statusElement.appendChild(document.createTextNode(error));
	outputElement.appendChild(statusElement);
}


function serialize(nodeSet)
{
	var stringWriter = new java.io.StringWriter();
	for (var node = nodeSet.first(); node; node=nodeSet.next())
	{
		var domWriter = new Packages.com.novell.xml.dom.DOMWriter(node, stringWriter);
		domWriter.setIndent(true);
		domWriter.write();
		domWriter.flush();
		stringWriter.write('\n');
	}
	return stringWriter.toString();
}

// File writer for debug logging
function writeFile(outputDir, driver, message) {

	if (outputDir.length &gt; 0) {
	    var logEntryTimeStamp = new java.text.SimpleDateFormat("yyyy-MM-dd-hh.mm.ss.S").format(new java.util.Date());
	    var logFileTimeStamp = new java.text.SimpleDateFormat("EEEE").format(new java.util.Date());
	    try {
	    	var pw = new java.io.PrintWriter(new java.io.FileWriter(outputDir + "/" + "idmDebug-" + driver + "-" + logFileTimeStamp + ".log", true));
	    	pw.println(logEntryTimeStamp + ": " + driver + " : " + message);
	    	pw.close();
	    } catch (e) {
	    	return "Error:" + e.toString();
	    }
	    return "Successfully wrote to file.";
	  }
	  return "No debug dir, skpping log."
}

// Very simle file writer for simple logging
function writeFileSimple(outputDir, message) {

	if (outputDir.length &gt; 0) {
	    var logEntryTimeStamp = new java.text.SimpleDateFormat("yyyy-MM-dd-hh.mm.ss.SSS").format(new java.util.Date());
	    var logFileTimeStamp = new java.text.SimpleDateFormat("EEEE").format(new java.util.Date());
	    try {
	    	var pw = new java.io.PrintWriter(new java.io.FileWriter(outputDir, true));
	    	pw.println(logEntryTimeStamp + " - " + message);
	    	pw.close();
	    } catch (e) {
	    	return "Error:" + e.toString();
	    }
	    return "Successfully wrote to file.";
	  }
	  return "No debug dir, skpping log."
}

// Expects to connect to a URL that returns an XML document.  Returns that doc as a String.
function getXMLFromURL(urlString)  {

	var url = new URL(urlString);
	var connection = url.openConnection();
	connection.setRequestMethod("GET");


	var responseCode = connection.getResponseCode();

//	var is = connection.getInputStream();
//  var isr = new InputStreamReader(is);
	var br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	var responseBuffer = new StringBuffer();
	var line;
	while ((line=br.readLine()) != null)  {
	  responseBuffer.append(line);
	}
  	br.close();
  	connection.disconnect();


  	var response = responseBuffer.toString();

  	// Sometimes the response begings with an unprintable character.
    if (response.charAt(0) != '&lt;')  {
      response = response.substring(1);
    }

  	return response;
}

importClass(Packages.com.novell.xml.util.Base64Codec);
importClass(java.io.ByteArrayOutputStream);
importClass(java.lang.System);
importClass(java.lang.Integer);

var JString = java.lang.String;

function buildDynamicGroupMemberQuery(tree, context, attrName, attrValue) {
  //00 00 00 00 02 00 00 00 2C 00 00 00
  //O = n o v e l l . t = g w a p p s t r e e
  //00 00 02 00 00 00 01 00 00 00
  //00 00 00 00 07 00 00 00 12 00 00 00
  //eDir-attr-name
  //00 00 00 00 10 00 00 00
  //eDir-attr-value
  //2A 00 00 00

  //Setup a default encoding if nothing is specified previously.
  encoding = System.getProperty("file.encoding")

  var byteData = new ByteArrayOutputStream();
  //outputStream.write(a);
  //outputStream.write(b);

  //Setting up the static part of the value.
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(2);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  //byteData.write(hex2dec("2C"));  //Some kind of byte offset for context/tree length.  For 18 characters (36 bytes), 2C (44) is shown.
  //Example: dc=org,t=gwappstree = 19 chars = 38 bytes = 40 offset = 0x28
  var offsetLength = ((3 + tree.length + context.length) * 2) + 2;
  byteData.write(offsetLength);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);

  //return new JString(Base64Codec.encode(new JString(str).getBytes(encoding)));

  //Add in the context, then the tree.
  //byteData.write(new JString(context).getBytes(encoding));
  var byteArray = spliceBytesWithNulls(new JString(context).getBytes(encoding));
  byteData.write(byteArray, 0, byteArray.length);
  byteData.write(hex2dec("2E"));
  byteData.write(0);
  byteData.write(hex2dec("74"));
  byteData.write(0);
  byteData.write(hex2dec("3D"));
  byteData.write(0);
  //byteData.write(new JString(tree).getBytes(encoding));
  var byteArray = spliceBytesWithNulls(new JString(tree).getBytes(encoding));
  byteData.write(byteArray, 0, byteArray.length);

  //Add in more static stuff.
  byteData.write(0);
  byteData.write(0);
  byteData.write(2);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(1);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(7);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  //byteData.write(hex2dec("12")); //Represents the number of bytes to offset for the attribute name.
  //'uniqueid' = 8 chars = 16 bytes = 18 = 0x12
  var offsetLength = ((attrName.length) * 2) + 2;
  byteData.write(offsetLength);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);

  //Add in the attribute name and, eventually, value.
  //byteData.write(new JString(attrName).getBytes(encoding));
  var byteArray = spliceBytesWithNulls(new JString(attrName).getBytes(encoding));
  byteData.write(byteArray, 0, byteArray.length);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  //byteData.write(hex2dec("10")); //Represents the number of bytes to offset for the value.
  //'test00*' = 7 chars = 14 bytes = 16 = 0x10
  var offsetLength = ((attrValue.length) * 2) + 2;
  byteData.write(offsetLength);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  //byteData.write(new JString(attrValue).getBytes(encoding));
  var byteArray = spliceBytesWithNulls(new JString(attrValue).getBytes(encoding));
  byteData.write(byteArray, 0, byteArray.length);
  byteData.write(0);
  byteData.write(0);

  //The value needs to have a number of bytes that is evenly disible by four, so make sure that happens padding with nulls.
  if(byteData.size() % 4) {
    byteData.write(0);
    byteData.write(0);
  }

  return new JString(Base64Codec.encode(byteData.toByteArray()));
}

/**
 * Silly function to put null bytes between other bytes in a byte array.
 */
function spliceBytesWithNulls(origByteArray) {
  var newByteArrayStream = new ByteArrayOutputStream();
  for(var ctr0 = 0; ctr0 &lt; origByteArray.length; ++ctr0) {
    newByteArrayStream.write(origByteArray[ctr0]);
    newByteArrayStream.write(0);
  }
  return newByteArrayStream.toByteArray();
}

/**
 * Convert a hex string into an integer.
 *
 * @param hexStr     hex string
 * @return intStr    int string
 */
function hex2dec(hexStr) {
  return Integer.parseInt(hexStr, 16);
}




/**
 *  ldapModifyAttr
 *
 * @param (String)  host            DNS or IP-Address of LDAP server optionally including the listening port (e.g. 192.168.0.1:389)
 * @param (boolean) useSSL          Connect to the server using SSL
 * @param (String)  user            Full distinguished name of LDAP account (e.g. sn=admin,o=users)
 * @param (String)  password        Password for LDAP account
 * @param (String)  dn              The DN of the object to modify
 * @param (String)  attr            The name of the attribute to modify
 * @param (String)  op              "add", "replace", or "remove"
 * @param (String)  value           The attribute value to modify
 * @return
 */
function ldapModifyAttr(host, useSSL, user, password, dn, attr, op, value)
{
	//comment out Trace references when testing outside of IDM (at least until we figure out how to register a customer trace handler)

	var tracePrefix = "ldapModifyAttr";
	var traceLevelDetails = 3;

	var trace = new Trace(tracePrefix);

	trace.trace("Validating parameters...", traceLevelDetails);

	// Convert string to a full boolean so "if (useSSL)" compares properly:
	if (useSSL == 'true') {
		useSSL = true;
	} else {
		useSSL = false;
	}



	//TODO: if lowercase attr cotains 'password', do not trace the value
	trace.trace("host    : '" + host + "'");
	trace.trace("useSSL  : " + useSSL);
	trace.trace("user    : '" + user + "'");
	if (debug) {
		trace.trace("password: '" + password + "'");
	}
	trace.trace("dn      : '" + dn + "'");
	trace.trace("attr    : '" + attr + "'");
	trace.trace("op      : '" + op + "'");
	trace.trace("value   : '" + value + "'");

	if (isBlank(host)) {
		var msg = "Missing required 'host' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(password)) {
		var msg = "Missing required 'password' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(dn)) {
		var msg = "Missing required 'dn' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(attr)) {
		var msg = "Missing required 'attr' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(op)) {
		var msg = "Missing required 'op' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(value)) {
		var msg = "Missing required 'value' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	var operation;

	switch (op) {
		case "add":
			operation = DirContext.ADD_ATTRIBUTE
			break;
		case "remove":
			operation = DirContext.REMOVE_ATTRIBUTE
			break;
		case "replace":
			operation = DirContext.REPLACE_ATTRIBUTE
			break;
		default:
		    var msg = "Invalid 'op' param value: '" + op + "'";
			trace.trace(msg);
			return "error: " + msg;
	}

    if (useSSL == 'true') {
        if (trustStore != null) {
			trace.trace("Validating truststore...", traceLevelDetails);

            if (new File(trustStore).exists() == false) {
				var msg = "Keystore '" + trustStore + "' does not exist.";
				trace.trace(msg);
				return "error: " + msg;
            }

            var keystore;
			try {
				keystore = KeyStore.getInstance(trustStoreType != null ? trustStoreType : KeyStore.getDefaultType());
			} catch (e) {
				var msg = "Error initializing keystore: " + e.javaException.getMessage();
				trace.trace(msg);
				return "error: " + msg;
			}

            // Load the keystore contents
            var inputStream;
			try {
				inputStream = new FileInputStream(trustStore);
			} catch (e) {
				var msg = "Error opening keystore '" + trustStore + "': " + e.javaException.getMessage();
				trace.trace(msg);
				return "error: " + msg;
			}

            try {
				keystore.load(inputStream, null);
			} catch (e) {
				var msg = "Error loading keystore '" + trustStore + "': " + e.javaException.getMessage();
				trace.trace(msg);
				return "error: " + msg;
			}

			try {
				inputStream.close();
			} catch (e) {
				var msg = "Error closing keystore '" + trustStore + "': " + e.javaException.getMessage();
				trace.trace(msg);
				return "error: " + msg;
			}
        }
	}

	trace.trace("Getting directory context...", traceLevelDetails);

    var env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, user);
    env.put(Context.SECURITY_CREDENTIALS, password);
    env.put("com.sun.jndi.ldap.connect.timeout", "5000");
    if (useSSL) {
        env.put(Context.PROVIDER_URL, "ldaps://" + host);
        if (trustStore != null) {
            System.setProperty("javax.net.ssl.trustStore", trustStore);
            if (trustStoreType != null) {
                System.setProperty("javax.net.ssl.trustStoreType", trustStoreType);
            }
            if (trustStorePassword != null) {
                System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
            }
        }
        if (debug) {
            System.setProperty("javax.net.debug", "SSL,trustmanager");
        }
    } else {
        env.put(Context.PROVIDER_URL, "ldap://" + host);
	}

	var context = null;
    try {
        context = new InitialDirContext(env);
    } catch (e) {
        if (useSSL) {
			var msg = "Failed to obtain a SSL directory context: " + e.javaException.getMessage();
			trace.trace(msg);
			return "error: " + msg;
        } else {
			var msg = "Failed to obtain a directory context: " + e.javaException.getMessage();
			trace.trace(msg);
			return "error: " + msg;
        }
    }

	trace.trace("Modifying attribute '" + attr + "'...", traceLevelDetails);

	try {
		var modItem = new ModificationItem(operation, new BasicAttribute(attr, value));
		var modItems = [modItem];
		context.modifyAttributes(dn, modItems);
	} catch(e) {
		var msg = "Unable to modify attribute '" + attr + "': " + e.javaException.getMessage();
		trace.trace(msg);
		return "error: " + msg;
	} finally {
		try {
			context.close();
        } catch (e) {
			trace.trace("Failed to close directory context: " + e.javaException.getMessage());
		    //ignore
        }
    }

	trace.trace("Done", traceLevelDetails);

	return "success";
}

/*
 *	Function to get the full count of days between two dates in the yyyy-MM-dd format.
 * Note: Before Aug13, 2018, this was getMonthsBetween; but months aren't clear enough - days are more deterministic; so we've moved to this format.
 */
function getDaysBetween(start, end) {
	var startLD = java.time.LocalDate.parse(start, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
	var endLD = java.time.LocalDate.parse(end, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
	return java.time.temporal.ChronoUnit.DAYS.between(startLD, endLD);
}

/*
 * calculateEventTime - Used to time some events.
 */
function calculateEventTimeSeconds (startTime, endTime) {
	return endTime-startTime;
}
function calculateEventTimeMinutes (startTime, endTime) {
	return (endTime-startTime)/60;
}

function canNotify(currentAttrName, currentAttrValueInSeconds, nowSecondsSince1970, trainingLifetimeSeconds) {
	if (currentAttrValueInSeconds.length == 0) {
		// Avoid the NumberFormatException if we see this:
		currentAttrValueInSeconds = "0";
	}

	if (currentAttrName == "abcTrainingLastCompleted") {
		currentAttrValueInSeconds = java.lang.Long.parseLong(currentAttrValueInSeconds) + java.lang.Long.parseLong(trainingLifetimeSeconds);
	}

	//return "currentAttrValueInSeconds: " + currentAttrValueInSeconds + "\nnowSecondsSince1970: " + nowSecondsSince1970;

	// If the current attr value is greater than our compare to value, it means that the date given us hasn't yet expired, so we don't want to
	//	 update the notification object, and return false;.
	if (java.lang.Long.parseLong(currentAttrValueInSeconds) &gt; java.lang.Long.parseLong(nowSecondsSince1970)) {
		return "false";
	}
	// otherwise, we'll notify on this attribute.
	return "true";
}
</content>
        </resource>
        <resource content-type="text/ecmascript;charset=UTF-8" name="WebLibrary">
            <content contains="text">importClass(com.novell.nds.dirxml.driver.Trace);


importClass(java.io.BufferedReader);
importClass(java.io.IOException);
importClass(java.io.InputStream);
importClass(java.io.InputStreamReader);
importClass(java.net.HttpURLConnection);
importClass(java.net.URL);
importClass(java.nio.file.Files);
importClass(java.nio.file.Paths);
importClass(java.nio.file.StandardCopyOption);
importClass(java.util.Map);

function executeHTTPGetToString(traceName, requestUrl, headers, timeout) {
    return executeRequestReturnResponseAsString(traceName, requestUrl, headers, timeout);
}

// traceName: String to prefix items in driver trace.
// requestURL: full url to pull down the user input file for SF driver.
// filePath: temporary full name to file to write (should end in something other than .xml
// finalExtension: extension that will be added to final file when the driver should process it.
function executeHTTPGetToFile(traceName, requestUrl, filePath, finalExtension, headers, timeout) {
    return executeRequestWriteResponseToFile(traceName, requestUrl, filePath, finalExtension, headers, timeout);
}

function executeRequestReturnResponseAsString(traceName, requestUrl, headers, timeout) {
    var trace = new Trace(traceName);
    var response = executeRequest(trace, requestUrl, headers, timeout);
    if (response != null) {
        try {
            var br = new BufferedReader(new InputStreamReader(response));
            trace.trace("Reading Response...", 5);
            var messageBody = new java.lang.StringBuilder();
            var c;
            while ((c = br.read()) !== -1) {
                messageBody.append(java.lang.Character.toString(c));
            }
            br.close();
            return messageBody.toString();
        } catch (e) {
            trace.trace(java.lang.String.format("ERROR: Unable to process response data: %s", e), 1);
        }
    }
    return null;
}

/*
    Must return a string of the success; do not throw from this function.
*/
function executeRequestWriteResponseToFile(traceName, requestUrl, filePath, finalExtension, headers, timeout) {
    var trace = new Trace(traceName);
    var is;
    try {
        trace.trace("about to execute");
        is = executeRequest(trace, requestUrl, headers, timeout);
        trace.trace("done: about");
    } catch (e) {
        var msg = java.lang.String.format("ERROR: Failed to execute HTTP GET: %s", e);
        trace.trace(msg, 1);
        return msg;
    }

    trace.trace("checking is");

    if (is != null) {
        trace.trace(java.lang.String.format("Writing Response to file: %s", filePath), 5);

        // writing file to temporary place; then renaming below: this ensures the driver doesn't try to read partially downloaded file.
        try {
            Files.copy(is, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            is.close();
        } catch (e) {
            var msg = java.lang.String.format("ERROR: Unable to write response data to output file %s: %s", filePath, e);
            trace.trace(msg, 1);
            return msg;
        }

		// Renaming file so the driver can start processing:
        try {
            Files.copy(Paths.get(filePath), Paths.get(filePath + finalExtension), StandardCopyOption.REPLACE_EXISTING);
        } catch (e) {
            var msg = java.lang.String.format("ERROR: Unable to copy temporary file %s to final driverinput file %s: %s", filePath, (filePath + finalExtension), e);
            trace.trace(msg, 1);
            return msg;
        }
    } else {
        var msg = "ERROR: Failed to get input stream from URL, no additional information available!";
        trace.trace(msg, 1);
        return msg;
    }
    return "Success";
}


/*
 Throws an exception when it fails - must be caught and converted into a policy friendly value.
*/
function executeRequest(trace, requestUrl, headers, timeout) {
    trace.trace("(executeRequest)Retrieving data...", 5);
    var conn;
    try {
        var url = new URL(requestUrl);
        trace.trace("(executeRequest) . . .Opening connection (Timeout: " + timeout + ")", 5);
        conn = url.openConnection(); // doesn't actually connect here . .
		conn.setReadTimeout(timeout); //read timeout in milliseconds
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
    } catch (e) {
        var msg = java.lang.String.format("ERROR: Unable to setup to connect to URL: %s", e);
        trace.trace(msg, 1);
        //return msg;
        throw msg;
    }
    trace.trace("(executeRequest) . . .Setting headers . .", 5);

    if (headers != null &amp;&amp; !headers.isEmpty()) {
        for (i = headers.entrySet().iterator(); i.hasNext();) {
            var headerItem = i.next();
            conn.setRequestProperty(headerItem.getKey(), headerItem.getValue());
        }
    }

    try {
       // Do an explicit connection to do a santicy check . .
       trace.trace("(executeRequest) . . .Testing connection to url:" + requestUrl, 5);
       conn.connect();
    } catch (e) {
        var msg = java.lang.String.format("ERROR: Unable to connect to URL: %s", e)
        trace.trace(msg, 1);
        throw msg;
    }

    trace.trace("(executeRequest) . . .Checking response . .", 5);

  	var responseCode = conn.getResponseCode();
	trace.trace(("Exiting executeRequest response code: " + responseCode), 5);
    try {//It was proposed to move this up two lines above var. abcS never implemented that so it stays here for now - ckynaston
        if (conn.getResponseCode() &lt; 400) {
            return conn.getInputStream();
        } else {
            return conn.getErrorStream();
        }
    } catch (e) {
        var msg = java.lang.String.format("ERROR: Unable to acquire response data: %s", e)
        trace.trace(msg, 1);
        throw msg;
    }
    trace.trace("Exiting executeRequest . . .", 5);
}




// ****************************************************************************
// Use the following when testing out side of Rhino:
// ****************************************************************************
/*
Trace.registerImpl(com.trivir.ecma.lib.CustomTraceInterface, 1);

// test:trivir -
var basicAuth = "Basic dGVzdDp0cml2aXIx"
var headers = new java.util.HashMap();
headers.put("Authorization", basicAuth);
var destFileNameStaging = "output.xml"


//function executeHTTPGetToFile(traceName, requestUrl, filePath, finalExtension, headers,timeout) {
var response = executeHTTPGetToFile('SFFeed', 'http://172.17.2.110:3000/HRDataService.aspx?op=FN_EXPORT_AUTH_EXTRACT&amp;FMT=XML&amp;ACTION=DOWNLOAD&amp;SCHEMA=IGNORE', destFileNameStaging, '.xml', headers,4500000);

var trace = new Trace("FINAL");
trace.trace(response, 5);

*/</content>
        </resource>
        <rule name="lib-DVE-itp-Engine">
            <policy xmlns:hashMap="http://www.novell.com/nxsl/java/java.util.HashMap" xmlns:hashSet="http://www.novell.com/nxsl/java/java.util.HashSet" xmlns:string="http://www.novell.com/nxsl/java/java.lang.String" xmlns:stringvalue="http://www.novell.com/nxsl/java/com.novell.xml.xpath.StringValue" xmlns:xslobject="http://www.novell.com/nxsl/java/com.novell.xsl.extensions.JavaObject">
				<rule>
					<description>Break of not add</description>
					<conditions>
						<or>
							<if-operation mode="nocase" op="not-equal">add</if-operation>
						</or>
					</conditions>
					<actions>
						<do-break/>
					</actions>
				</rule>
				<rule>
					<description>Break if not User (abcPerson) or abcLicence</description>
					<conditions>
						<and>
							<if-class-name mode="nocase" op="not-equal">User</if-class-name>
							<if-class-name mode="nocase" op="not-equal">Licence</if-class-name>
						</and>
					</conditions>
					<actions>
						<do-break/>
					</actions>
				</rule>
				<rule>
					<description>metaData: Set up driver scoped variables</description>
					<comment xml:space="preserve">Since metaData is a driver scoped variable, we'll run this rule only once, the first time it is hit, then we'll just overwrite the hashMap keys as needed.</comment>
					<conditions>
						<or>
							<if-local-variable name="metaData" op="not-available"/>
						</or>
					</conditions>
					<actions>
						<do-set-local-variable name="metaData" scope="driver">
							<arg-object>
								<token-xpath expression="hashMap:new()"/>
							</arg-object>
						</do-set-local-variable>
						<do-set-local-variable name="dummy" scope="policy">
							<arg-object>
								<token-xpath expression="hashMap:put($metaData, 'debug', 'true')"/>
							</arg-object>
						</do-set-local-variable>
						<do-set-local-variable name="dummy" scope="policy">
							<arg-object>
								<token-xpath expression="hashMap:put($metaData, 'queryProcessor', $destQueryProcessor)"/>
							</arg-object>
						</do-set-local-variable>
						<do-set-local-variable name="dummy" scope="policy">
							<arg-object>
								<token-xpath expression="hashMap:put($metaData, 'driverAlias', '~dveDriverAlias~')"/>
							</arg-object>
						</do-set-local-variable>
						<do-set-local-variable name="dveTable" scope="driver">
							<arg-node-set>
								<token-document>
									<arg-string>
										<token-text xml:space="preserve">vnd.nds.stream:</token-text>
										<token-replace-all regex="\\" replace-with="/">
											<token-text xml:space="preserve">\~dirxml.auto.treename~\services\IDM\Driver Set\Operational-Data\lib-DVE-Main</token-text>
										</token-replace-all>
										<token-text xml:space="preserve">#DirXML-Data</token-text>
									</arg-string>
								</token-document>
							</arg-node-set>
						</do-set-local-variable>
					</actions>
				</rule>
				<rule>
					<description>metaData: Set up event specific data (metaData and email results NodeSet, logging info)</description>
					<conditions/>
					<actions>
						<do-set-op-property name="dveVersion">
							<arg-string>
								<token-text xml:space="preserve">1.0</token-text>
							</arg-string>
						</do-set-op-property>
						<do-set-local-variable name="emailFailNodeSet" scope="policy">
							<arg-node-set>
								<token-xml-parse>
									<token-text xml:space="preserve">&lt;emailStrings/&gt;</token-text>
								</token-xml-parse>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="retainAttrsNodeSet" scope="policy">
							<arg-node-set>
								<token-xml-parse>
									<token-text xml:space="preserve">&lt;retainAttrs/&gt;</token-text>
								</token-xml-parse>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="serializeEvent" scope="driver">
							<arg-node-set>
								<token-xml-serialize>
									<token-xpath expression="."/>
								</token-xml-serialize>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="dummy" scope="driver">
							<arg-object>
								<token-xpath expression="hashMap:put($metaData, 'event', $serializeEvent)"/>
							</arg-object>
						</do-set-local-variable>
						<do-set-local-variable name="userEUID" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">No EUID</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="userDN" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="assoc" scope="policy">
							<arg-string>
								<token-association/>
							</arg-string>
						</do-set-local-variable>
						<do-if>
							<arg-conditions>
								<and>
									<if-local-variable mode="regex" name="assoc" op="equal">.+</if-local-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="userDN" scope="policy">
									<arg-string>
										<token-resolve datastore="dest">
											<arg-association>
												<token-association/>
											</arg-association>
										</token-resolve>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
						<do-set-local-variable name="dummy" scope="driver">
							<arg-object>
								<token-xpath expression="hashMap:put($metaData, 'userDN', $userDN)"/>
							</arg-object>
						</do-set-local-variable>
						<do-if>
							<arg-conditions>
								<and>
									<if-local-variable mode="regex" name="userDN" op="equal">.+</if-local-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="userEUID" scope="policy">
									<arg-string>
										<token-parse-dn length="1" start="-1">
											<token-local-variable name="userDN"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Set up event specific data: GCI/VRSID/CN for Log and email messages, blank userEUID if this is a license.</description>
					<conditions/>
					<actions>
						<do-set-local-variable name="givenName" scope="policy">
							<arg-string>
								<token-xpath expression="add-attr[@attr-name='First_Name']/value/text()"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="sn" scope="policy">
							<arg-string>
								<token-xpath expression="add-attr[@attr-name='Surname']/value/text()"/>
							</arg-string>
						</do-set-local-variable>
						<do-if>
							<arg-conditions>
								<and>
									<if-global-variable name="dveDriverAlias" op="equal">HRDS</if-global-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="userGciVrsid" scope="policy">
									<arg-string>
										<token-xpath expression="add-attr[@attr-name='GCI']/value/text()"/>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
						<do-if>
							<arg-conditions>
								<and>
									<if-global-variable name="dveDriverAlias" op="equal">VRS</if-global-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="userGciVrsid" scope="policy">
									<arg-string>
										<token-xpath expression="add-attr[@attr-name='VRS_Reference']/value/text()"/>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
						<do-if>
							<arg-conditions>
								<and>
									<if-global-variable name="dveDriverAlias" op="equal">LMS</if-global-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="userGciVrsid" scope="policy">
									<arg-string>
										<token-association/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="userEUID" scope="policy">
									<arg-string>
										<token-text xml:space="preserve"/>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Loop through DVE main table in the event and begin processing.</description>
					<comment xml:space="preserve">We'll loop through the first column in our DVE table. We'll also initialize the eventNeedsToBeVetoed so we cna record if the event needs to be vetoed.</comment>
					<conditions/>
					<actions>
						<do-set-local-variable name="eventNeedsToBeVetoed">
							<arg-string>
								<token-text xml:space="preserve">false</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-for-each>
							<arg-node-set>
								<token-xpath expression="$dveTable/mapping-table/row/col[position() = 1]"/>
							</arg-node-set>
							<arg-actions>
								<do-set-local-variable name="currentAttrDriverAlias">
									<arg-string>
										<token-upper-case>
											<token-xpath expression="substring-after($current-node, '-')"/>
										</token-upper-case>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="enabled" scope="policy">
									<arg-string>
										<token-upper-case>
											<token-map default-value="DID-NOT-RESOLVE-KEY-IN-DVE-MAIN" dest="enabled" src="attributeName" table="..\Operational-Data\lib-DVE-Main">
												<token-local-variable name="current-node"/>
											</token-map>
										</token-upper-case>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">$currentAttrDriverAlias = string('~dveDriverAlias~')</if-xpath>
											<if-xpath op="true">$enabled = string('TRUE')</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="sourceAttributeName" scope="policy">
											<arg-string>
												<token-map default-value="DID-NOT-RESOLVE-KEY-IN-DVE-MAIN" dest="sourceAttributeName" src="attributeName" table="..\Operational-Data\lib-DVE-Main">
													<token-local-variable name="current-node"/>
												</token-map>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="attributeValue">
											<arg-string>
												<token-xpath expression="add-attr[@attr-name=$sourceAttributeName]/value/text()"/>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<and>
													<if-xpath op="true">not(add-attr[@attr-name=$sourceAttributeName])</if-xpath>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="attributeValue">
													<arg-string>
														<token-text xml:space="preserve">ELEMENT-MISSING</token-text>
													</arg-string>
												</do-set-local-variable>
											</arg-actions>
										</do-if>
										<do-set-local-variable name="requirementID">
											<arg-string>
												<token-upper-case>
													<token-map default-value="DID-NOT-RESOLVE-KEY-IN-DVE-MAIN" dest="requirementID" src="attributeName" table="..\Operational-Data\lib-DVE-Main">
														<token-local-variable name="current-node"/>
													</token-map>
												</token-upper-case>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<and>
													<if-global-variable name="dveDriverAlias" op="equal">LMS</if-global-variable>
													<if-local-variable mode="regex" name="requirementID" op="equal">.*AS-RO-1025.*</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-trace-message level="6">
													<arg-string>
														<token-text xml:space="preserve">Validate Permitted Legal Entity</token-text>
													</arg-string>
												</do-trace-message>
												<do-trace-message disabled="true" level="6">
													<arg-string>
														<token-text xml:space="preserve">Non-traced note. This validation needs to look at this attribute when it is at the root of the document AND if it is nested format of Permitted Legal Entities . </token-text>
													</arg-string>
												</do-trace-message>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="true">add-attr[@attr-name='Permitted_Legal_Entity']/value/text()</if-xpath>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="attributeValue" scope="policy">
															<arg-string>
																<token-xpath expression="add-attr[@attr-name='Permitted_Legal_Entity']/value/text()"/>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
													<arg-actions/>
												</do-if>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="true">add-attr[@attr-name='Permitted_Legal_Entity_With_Nested_Nodes']/value/text()</if-xpath>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="attributeValue" scope="policy">
															<arg-string>
																<token-xpath expression="add-attr[@attr-name='Permitted_Legal_Entity_With_Nested_Nodes']/value/text()"/>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
													<arg-actions/>
												</do-if>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="not-true">add-attr[@attr-name='Permitted_Legal_Entity']/value/text()</if-xpath>
															<if-xpath op="not-true">add-attr[@attr-name='Permitted_Legal_Entity_With_Nested_Nodes']/value/text()</if-xpath>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="attributeValue" scope="policy">
															<arg-string>
																<token-text xml:space="preserve"/>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
													<arg-actions/>
												</do-if>
											</arg-actions>
											<arg-actions/>
										</do-if>
										<do-if>
											<arg-conditions>
												<and>
													<if-global-variable name="dveDriverAlias" op="equal">LMS</if-global-variable>
													<if-local-variable mode="regex" name="requirementID" op="equal">.*AS-RO-1027.*</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-trace-message level="6">
													<arg-string>
														<token-text xml:space="preserve">Validate Permitted Working Location</token-text>
													</arg-string>
												</do-trace-message>
												<do-trace-message disabled="true" level="6">
													<arg-string>
														<token-text xml:space="preserve">Non-traced note. This validation needs to look at this attribute when it is at the root of the document AND if it is nested format of Permitted Legal Entities . </token-text>
													</arg-string>
												</do-trace-message>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="true">add-attr[@attr-name='Permitted_Working_Location']/value/text()</if-xpath>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="attributeValue" scope="policy">
															<arg-string>
																<token-xpath expression="add-attr[@attr-name='Permitted_Working_Location']/value/text()"/>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
													<arg-actions/>
												</do-if>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="true">add-attr[@attr-name='Permitted_Legal_Entity_With_Nested_Nodes']/value/text()</if-xpath>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="attributeValueFullJSONString" scope="policy">
															<arg-string>
																<token-xpath expression="add-attr[@attr-name='Permitted_Legal_Entity_With_Nested_Nodes']/value/text()"/>
															</arg-string>
														</do-set-local-variable>
														<do-set-local-variable name="attributeValue" scope="policy">
															<arg-string>
																<token-replace-first regex=".*:\[\&quot;[: \&quot;]" replace-with="BAD_VALUE">
																	<token-local-variable name="attributeValueFullJSONString"/>
																</token-replace-first>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
													<arg-actions/>
												</do-if>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="not-true">add-attr[@attr-name='Permitted_Working_Location']/value/text()</if-xpath>
															<if-xpath op="not-true">add-attr[@attr-name='Permitted_Legal_Entity_With_Nested_Nodes']/value/text()</if-xpath>
														</and>
														<and>
															<if-local-variable mode="regex" name="attributeValue" op="equal">BAD_VALUE.*</if-local-variable>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="attributeValue" scope="policy">
															<arg-string>
																<token-text xml:space="preserve"/>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
													<arg-actions/>
												</do-if>
											</arg-actions>
											<arg-actions/>
										</do-if>
										<do-if>
											<arg-conditions>
												<and>
													<if-global-variable name="dveDriverAlias" op="equal">LMS</if-global-variable>
													<if-local-variable mode="regex" name="requirementID" op="equal">.*AS-RO-1026.*</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="attributeValue">
													<arg-string>
														<token-xpath expression="add-attr[@attr-name='Prohibited_Nationalities']/value/text()"/>
														<token-xpath expression="add-attr[@attr-name='Nationality']/value/text()"/>
													</arg-string>
												</do-set-local-variable>
											</arg-actions>
										</do-if>
										<do-set-local-variable name="isValidFunctionBody">
											<arg-string>
												<token-map default-value="DID-NOT-RESOLVE-KEY-IN-DVE-MAIN" dest="isValidFunction" src="attributeName" table="..\Operational-Data\lib-DVE-Main">
													<token-local-variable name="current-node"/>
												</token-map>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="validationPriority">
											<arg-string>
												<token-map default-value="DID-NOT-RESOLVE-KEY-IN-DVE-MAIN" dest="priority" src="attributeName" table="..\Operational-Data\lib-DVE-Main">
													<token-local-variable name="current-node"/>
												</token-map>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="idvAttr">
											<arg-string>
												<token-xpath expression="substring-before($current-node, '-')"/>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="dummy">
											<arg-object>
												<token-xpath expression="hashMap:put($metaData, 'idvAttr', $idvAttr)"/>
											</arg-object>
										</do-set-local-variable>
										<do-set-local-variable name="dummy">
											<arg-object>
												<token-xpath expression="hashMap:put($metaData, 'isvalid', $isValidFunctionBody)"/>
											</arg-object>
										</do-set-local-variable>
										<do-set-local-variable name="responseFromDVEEngine" scope="policy">
											<arg-string>
												<token-xpath expression="es:dveEngine($sourceAttributeName, $attributeValue, $metaData)"/>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<and>
													<if-xpath op="true">string-length($attributeValue) = 0</if-xpath>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="attributeValue">
													<arg-string>
														<token-text xml:space="preserve">ELEMENT-EMPTY</token-text>
													</arg-string>
												</do-set-local-variable>
											</arg-actions>
										</do-if>
										<do-if>
											<!--  SUCCESS -->
											<arg-conditions>
												<and>
													<if-xpath op="true">starts-with($responseFromDVEEngine, 'SUCCESS')</if-xpath>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-if>
													<arg-conditions>
														<and>
															<if-global-variable name="dveLogOnSuccess" op="equal">true</if-global-variable>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="requirementID">
															<arg-string>
																<token-upper-case>
																	<token-local-variable name="requirementID"/>
																</token-upper-case>
																<token-text xml:space="preserve">-S</token-text>
															</arg-string>
														</do-set-local-variable>
														<do-set-local-variable name="logResult">
															<arg-string>
																<token-xpath expression="es:writeDVELog('~dveLog~', '~dveDriverAlias~', $userEUID, $userGciVrsid, $requirementID, $validationPriority, $sourceAttributeName, $idvAttr, $attributeValue, 'Successful validation', 'No Email sent as validation succeeded')"/>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
												</do-if>
											</arg-actions>
											<arg-actions/>
										</do-if>
										<!-- If: FAIL -->
										<do-if>
											<arg-conditions>
												<and>
													<if-xpath op="true">starts-with($responseFromDVEEngine, 'FAIL')</if-xpath>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="responseFields" scope="policy">
													<arg-node-set>
														<token-split delimiter="#">
															<token-local-variable name="responseFromDVEEngine"/>
														</token-split>
													</arg-node-set>
												</do-set-local-variable>
												<do-set-local-variable name="attrCheckId" scope="policy">
													<arg-string>
														<token-local-variable name="requirementID"/>
														<token-text xml:space="preserve">-</token-text>
														<token-xpath expression="$responseFields[2]"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="attrAction" scope="policy">
													<arg-string>
														<token-xpath expression="$responseFields[3]"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="attrResultMessage" scope="policy">
													<arg-string>
														<token-xpath expression="$responseFields[4]"/>
													</arg-string>
												</do-set-local-variable>
												<do-if>
													<arg-conditions>
														<and>
															<if-local-variable name="attrAction" op="equal">retainIDV</if-local-variable>
															<if-global-variable name="dveDryRun" op="not-equal">true</if-global-variable>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-if>
															<arg-conditions>
																<and>
																	<if-local-variable mode="regex" name="userDN" op="equal">.+</if-local-variable>
																</and>
															</arg-conditions>
															<arg-actions>
																<do-append-xml-element expression="$retainAttrsNodeSet/retainAttrs" name="attr"/>
																<do-set-xml-attr expression="$retainAttrsNodeSet/retainAttrs/attr[last()]" name="attr-name">
																	<arg-string>
																		<token-local-variable name="idvAttr"/>
																	</arg-string>
																</do-set-xml-attr>
																<do-strip-op-attr name="$sourceAttributeName$"/>
															</arg-actions>
															<arg-actions>
																<do-trace-message>
																	<arg-string>
																		<token-text xml:space="preserve">DVE: attr action: retainIDV, but no existing IDV object, allow! </token-text>
																	</arg-string>
																</do-trace-message>
															</arg-actions>
														</do-if>
													</arg-actions>
												</do-if>
												<do-if>
													<arg-conditions>
														<and>
															<if-local-variable name="attrAction" op="equal">overwriteIDV</if-local-variable>
															<if-global-variable name="dveDryRun" op="not-equal">true</if-global-variable>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-trace-message>
															<arg-string>
																<token-text xml:space="preserve">DVE: attr action: overwriteIDV</token-text>
															</arg-string>
														</do-trace-message>
													</arg-actions>
												</do-if>
												<do-if>
													<arg-conditions>
														<and>
															<if-local-variable name="attrAction" op="equal">vetoEvent</if-local-variable>
															<if-global-variable name="dveDryRun" op="not-equal">true</if-global-variable>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-trace-message>
															<arg-string>
																<token-text xml:space="preserve">DVE: attr action: vetoEvent</token-text>
															</arg-string>
														</do-trace-message>
														<do-set-local-variable name="eventNeedsToBeVetoed">
															<arg-string>
																<token-text xml:space="preserve">true</token-text>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
												</do-if>
												<do-set-local-variable name="emailToAddress">
													<arg-string>
														<token-map default-value="DID-NOT-RESOLVE-KEY-IN-DVE-MAIN" dest="email" src="attributeName" table="..\Operational-Data\lib-DVE-Main">
															<token-local-variable name="current-node"/>
														</token-map>
													</arg-string>
												</do-set-local-variable>
												<!--  Data strings:												* field delimiter												@ record delimiter											 -->
												<do-set-local-variable name="previousEmailFailString">
													<arg-node-set>
														<token-xpath expression="$emailFailNodeSet/emailStrings/team[@email=$emailToAddress]/text()"/>
													</arg-node-set>
												</do-set-local-variable>
												<do-set-local-variable name="updatedFailString" scope="policy">
													<arg-string>
														<token-local-variable name="previousEmailFailString"/>
														<token-text xml:space="preserve">
</token-text>
														<token-local-variable name="attrResultMessage"/>
													</arg-string>
												</do-set-local-variable>
												<do-strip-xpath expression="$emailFailNodeSet/emailStrings/team[@email=$emailToAddress]"/>
												<do-append-xml-element expression="$emailFailNodeSet/emailStrings" name="team"/>
												<do-set-xml-attr expression="$emailFailNodeSet/emailStrings/team[last()]" name="email">
													<arg-string>
														<token-local-variable name="emailToAddress"/>
													</arg-string>
												</do-set-xml-attr>
												<do-append-xml-text expression="$emailFailNodeSet/emailStrings/team[@email=$emailToAddress]">
													<arg-string>
														<token-local-variable name="updatedFailString"/>
													</arg-string>
												</do-append-xml-text>
												<do-if>
													<arg-conditions>
														<or>
															<if-local-variable mode="regex" name="requirementID" op="equal">AS-RO-1001|AS-RO-1000|AS-RO-1034</if-local-variable>
														</or>
													</arg-conditions>
													<arg-actions>
														<do-strip-xpath expression="$emailFailNodeSet/emailStrings/team[@email='~dveIDMTeam~']"/>
														<do-append-xml-element expression="$emailFailNodeSet/emailStrings" name="team"/>
														<do-set-xml-attr expression="$emailFailNodeSet/emailStrings/team[last()]" name="email">
															<arg-string>
																<token-global-variable name="dveIDMTeam"/>
															</arg-string>
														</do-set-xml-attr>
														<do-append-xml-text expression="$emailFailNodeSet/emailStrings/team[@email='~dveIDMTeam~']">
															<arg-string>
																<token-local-variable name="updatedFailString"/>
															</arg-string>
														</do-append-xml-text>
													</arg-actions>
												</do-if>
												<do-set-local-variable disabled="false" name="nodesetdebugnew" scope="policy">
													<arg-string>
														<token-xpath expression="es:serialize($emailFailNodeSet)"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="logResult">
													<arg-string>
														<token-xpath expression="es:writeDVELog('~dveLog~', '~dveDriverAlias~', $userEUID, $userGciVrsid, $attrCheckId, $validationPriority, $sourceAttributeName, $idvAttr, $attributeValue, $attrResultMessage, $emailToAddress)"/>
													</arg-string>
												</do-set-local-variable>
											</arg-actions>
										</do-if>
										<do-if>
											<arg-conditions>
												<and>
													<if-xpath op="true">starts-with($responseFromDVEEngine, 'STOP')</if-xpath>
													<if-global-variable name="dveDryRun" op="not-equal">true</if-global-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-trace-message>
													<arg-string>
														<token-text xml:space="preserve">DVE: was instructed to stop processing attribute due to a certain condition, moving to next attribute. </token-text>
													</arg-string>
												</do-trace-message>
											</arg-actions>
										</do-if>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</arg-actions>
						</do-for-each>
						<!-- String.join("#", hashmaptest.keySet());  -->
					</actions>
				</rule>
				<rule>
					<description>Finalize DVE processing.</description>
					<comment xml:space="preserve">Email results of DVE as needed, retainIDV attrs as needed, then veto if needed.</comment>
					<conditions/>
					<actions>
						<do-set-local-variable disabled="false" name="debugbeforeprocess" scope="policy">
							<arg-string>
								<token-xpath expression="es:serialize($emailFailNodeSet)"/>
							</arg-string>
						</do-set-local-variable>
						<do-if>
							<arg-conditions>
								<and>
									<if-global-variable name="dveDryRun" op="not-equal">true</if-global-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-for-each>
									<arg-node-set>
										<token-xpath expression="$emailFailNodeSet/emailStrings/team"/>
									</arg-node-set>
									<arg-actions>
										<do-set-local-variable name="toAddress">
											<arg-string>
												<token-xpath expression="$current-node/@email"/>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<and>
													<if-global-variable name="dveDriverAlias" op="equal">LMS</if-global-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="toAddress">
													<arg-string>
														<token-xpath expression="es:getLMSAddressByBU(add-attr[@attr-name='Licence_BU']/value/text(), $toAddress, '~dveIDMTeam~')"/>
													</arg-string>
												</do-set-local-variable>
											</arg-actions>
										</do-if>
										<do-if>
											<arg-conditions>
												<and>
													<if-local-variable mode="regex" name="toAddress" op="equal">.+</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-send-email-from-template notification-dn="Security\Default Notification Collection" template-dn="security\Default Notification Collection\abcS-DVE-AttrFailureReport">
													<arg-string name="to">
														<token-local-variable name="toAddress"/>
													</arg-string>
													<arg-string name="sourcesystem">
														<token-global-variable name="dveDriverAlias"/>
													</arg-string>
													<arg-string name="gciorvrs">
														<token-local-variable name="userGciVrsid"/>
													</arg-string>
													<arg-string name="givenName">
														<token-local-variable name="givenName"/>
													</arg-string>
													<arg-string name="sn">
														<token-local-variable name="sn"/>
													</arg-string>
													<arg-string name="euid">
														<token-local-variable name="userEUID"/>
													</arg-string>
													<arg-string name="failureStrings">
														<token-xpath expression="$current-node/text()"/>
													</arg-string>
												</do-send-email-from-template>
											</arg-actions>
										</do-if>
									</arg-actions>
								</do-for-each>
								<do-for-each>
									<arg-node-set>
										<token-xpath expression="$retainAttrsNodeSet/retainAttrs/attr"/>
									</arg-node-set>
									<arg-actions>
										<do-set-local-variable name="idvAttrName">
											<arg-string>
												<token-xpath expression="$current-node/@attr-name"/>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="idvAttrCurrentValue">
											<arg-string>
												<token-dest-attr name="$idvAttrName$">
													<arg-dn>
														<token-local-variable name="userDN"/>
													</arg-dn>
												</token-dest-attr>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<and>
													<if-local-variable mode="regex" name="idvAttrCurrentValue" op="equal">.+</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-strip-op-attr name="$idvAttrName$"/>
												<do-append-xml-element expression="." name="add-attr"/>
												<do-set-xml-attr expression="add-attr[last()]" name="attr-name">
													<arg-string>
														<token-local-variable name="idvAttrName"/>
													</arg-string>
												</do-set-xml-attr>
												<do-append-xml-element expression="add-attr[last()]" name="value"/>
												<do-append-xml-text expression="add-attr[last()]/value">
													<arg-string>
														<token-local-variable name="idvAttrCurrentValue"/>
													</arg-string>
												</do-append-xml-text>
											</arg-actions>
											<arg-actions>
												<do-trace-message>
													<arg-string>
														<token-text xml:space="preserve">DVE: attr was marked as retain, but there wasn't a value on the existing user in eDirectory, so allowing value!</token-text>
													</arg-string>
												</do-trace-message>
											</arg-actions>
										</do-if>
									</arg-actions>
								</do-for-each>
							</arg-actions>
						</do-if>
						<do-trace-message>
							<arg-string>
								<token-text xml:space="preserve">DVE: Processing complete.</token-text>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<or>
									<if-local-variable name="eventNeedsToBeVetoed" op="equal">true</if-local-variable>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DVE: Event was marked as veto, vetoing event now.</token-text>
									</arg-string>
								</do-trace-message>
								<do-veto/>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="lib-GenEUID">
            <policy>
				<rule>
					<description>Prepare variables</description>
					<comment xml:space="preserve">Setup our EUID counter dn. In cases where we're running the tests in a lab, we'll select the IdMUnit counter; otherwise, we'll default to the main counter here.</comment>
					<conditions/>
					<actions>
						<do-set-local-variable name="euidCounterDN" scope="driver">
							<arg-string>
								<token-local-variable name="driver_euidCounterDN"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="sourceName" scope="driver">
							<arg-string>
								<token-lower-case>
									<token-src-name/>
								</token-lower-case>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>
				<rule>
					<description>Prepare variables: Use IdMUnit counter if testing.</description>
					<comment xml:space="preserve">If the source CN starts with 'idmunit' then we're using the IdMUnit counter.</comment>
					<conditions>
						<or>
							<if-local-variable mode="regex" name="sourceName" op="equal">^idmunit.+$</if-local-variable>
							<if-xpath op="true">@source='idmunit'</if-xpath>
						</or>
					</conditions>
					<actions>
						<do-set-local-variable name="euidCounterDN" scope="driver">
							<arg-string>
								<token-local-variable name="driver_euidIdMUnitCounterDN"/>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>
				<rule>
					<description>Generate EUID</description>
					<comment xml:space="preserve">Loads next EUID value, builds the full EUID, writes it on the user, increments the value then writes the updated value back to the tree.  We do the write back to the tree 'directly' to simplify the status documents coming back on the user create.

Note: if the EUIDCounter object DN contains IdMUnit, we'll also use an idmunit prefix so we can easily identify IDMUnit test users.</comment>
					<conditions/>
					<actions>
						<do-set-local-variable name="euidCounterObjectAsXMLAttr" scope="driver">
							<arg-string>
								<token-text xml:space="preserve">vnd.nds.stream:/</token-text>
								<token-replace-all regex="\\" replace-with="/">
									<token-local-variable name="euidCounterDN"/>
								</token-replace-all>
								<token-text xml:space="preserve">#DirXML-Data</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="euidCounterDataXML" scope="driver">
							<arg-node-set>
								<token-document>
									<arg-string>
										<token-local-variable name="euidCounterObjectAsXMLAttr"/>
									</arg-string>
								</token-document>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="euidCounter" scope="driver">
							<arg-node-set>
								<token-xpath expression="$euidCounterDataXML/euid/text()"/>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="prefix" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">UKB</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">contains($euidCounterDN, 'IdMUnit')</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="prefix" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">idmunit</token-text>
										<token-local-variable name="prefix"/>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
							<arg-actions/>
						</do-if>
						<do-set-local-variable name="bsieuid" scope="policy">
							<arg-string>
								<token-local-variable name="prefix"/>
								<token-xpath expression="substring(concat('00000000', $euidCounter), string-length($euidCounter) + 1)"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="euidCounter" scope="driver">
							<arg-node-set>
								<token-xpath expression="$euidCounter + 1"/>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-dest-attr-value class-name="DirXML-Resource" direct="true" name="DirXML-Data">
							<arg-dn>
								<token-replace-all regex="/" replace-with="\\">
									<token-local-variable name="euidCounterDN"/>
								</token-replace-all>
							</arg-dn>
							<arg-value type="octet">
								<token-base64-encode>
									<token-xpath expression="concat('&lt;euid&gt;', $euidCounter, '&lt;/euid&gt;')"/>
								</token-base64-encode>
							</arg-value>
						</do-set-dest-attr-value>
						<do-set-local-variable name="LIBOUT-EUID">
							<arg-string>
								<token-local-variable name="bsieuid"/>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="lib-InitializeCounter">
            <policy>
				<rule>
					<description>Set variables</description>
					<conditions/>
					<actions>
						<do-set-local-variable name="euidLibraryDN" scope="policy">
							<arg-string>
								<token-parse-dn dest-dn-format="src-dn" length="-2" src-dn-format="src-dn">
									<token-global-variable name="dirxml.auto.driverdn"/>
								</token-parse-dn>
								<token-text xml:space="preserve">\EUID-Data</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="driver_euidCounterDN" scope="driver">
							<arg-string>
								<token-local-variable name="euidLibraryDN"/>
								<token-text xml:space="preserve">\EUIDCounter</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="driver_euidIdMUnitCounterDN" scope="driver">
							<arg-string>
								<token-local-variable name="euidLibraryDN"/>
								<token-text xml:space="preserve">\EUIDCounter-IdMUnit</token-text>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>
				<rule>
					<description>Create the EUID library if needed</description>
					<conditions>
						<or>
							<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $euidLibraryDN, "", "")/@src-dn) = 0</if-xpath>
						</or>
					</conditions>
					<actions>
						<do-add-src-object class-name="DirXML-Library">
							<arg-dn>
								<token-local-variable name="euidLibraryDN"/>
							</arg-dn>
						</do-add-src-object>
						<do-set-src-attr-value class-name="DirXML-Library" name="Description">
							<arg-dn>
								<token-local-variable name="euidLibraryDN"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">Note: This library is automatically generated; none of it's contents should need to be modified unless a specific EUID generation counter needs to be chosen.</token-text>
							</arg-value>
						</do-set-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create the Primary EUID generation counter if needed.</description>
					<comment xml:space="preserve">We need to create the counter on the fly: if we included it in the export, then we'd always inadvertently set the counter back to the exported value; so lets create it on the fly if needed. We'll create both the idmunit and the standard versions.</comment>
					<conditions>
						<or>
							<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $driver_euidCounterDN, "", "")/@src-dn) = 0</if-xpath>
						</or>
					</conditions>
					<actions>
						<do-add-src-object class-name="DirXML-Resource">
							<arg-dn>
								<token-local-variable name="driver_euidCounterDN"/>
							</arg-dn>
						</do-add-src-object>
						<do-set-src-attr-value class-name="DirXML-Resource" name="DirXML-Data">
							<arg-dn>
								<token-local-variable name="driver_euidCounterDN"/>
							</arg-dn>
							<arg-value type="octet">
								<token-base64-encode>
									<token-text xml:space="preserve">&lt;euid&gt;1&lt;/euid&gt;</token-text>
								</token-base64-encode>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Resource" name="DirXML-ContentType">
							<arg-dn>
								<token-local-variable name="driver_euidCounterDN"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">text/xml</token-text>
							</arg-value>
						</do-set-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create the IdMUnit EUID generation counter if needed.</description>
					<conditions>
						<or>
							<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $driver_euidIdMUnitCounterDN, "", "")/@src-dn) = 0</if-xpath>
						</or>
					</conditions>
					<actions>
						<do-add-src-object class-name="DirXML-Resource">
							<arg-dn>
								<token-local-variable name="driver_euidIdMUnitCounterDN"/>
							</arg-dn>
						</do-add-src-object>
						<do-set-src-attr-value class-name="DirXML-Resource" direct="true" name="DirXML-Data">
							<arg-dn>
								<token-local-variable name="driver_euidIdMUnitCounterDN"/>
							</arg-dn>
							<arg-value type="octet">
								<token-base64-encode>
									<token-text xml:space="preserve">&lt;euid&gt;1&lt;/euid&gt;</token-text>
								</token-base64-encode>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Resource" name="DirXML-ContentType">
							<arg-dn>
								<token-local-variable name="driver_euidIdMUnitCounterDN"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">text/xml</token-text>
							</arg-value>
						</do-set-src-attr-value>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="lib-JobActivation">
            <policy>
				<description>When job scopes are first added to a job, they have to have an 'updateJob' called on them. This allows the IDM engine to properly process the job.</description>
				<rule>
					<description>Send Job Scope Update Notifications</description>
					<comment xml:space="preserve">This policy uses DXCMD to notify the DirXML engine of job scope changes.			</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdCommand" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">-updatejob</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-local-variable name="lvServiceAccountDotDn"/>
								<token-text xml:space="preserve"> -password </token-text>
								<token-named-password name="pwdServiceAccount"/>
								<token-text xml:space="preserve"> </token-text>
								<token-local-variable name="lvDxcmdCommand"/>
								<token-text xml:space="preserve"> </token-text>
								<token-text xml:space="preserve">'</token-text>
								<token-local-variable name="lvDeleteUsersJobDotDn"/>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command $lvDxcmdCommand$ returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job '~gcvDeleteUsersJobName~': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command $lvDxcmdCommand$ completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-local-variable name="lvServiceAccountDotDn"/>
								<token-text xml:space="preserve"> -password </token-text>
								<token-named-password name="pwdServiceAccount"/>
								<token-text xml:space="preserve"> </token-text>
								<token-local-variable name="lvDxcmdCommand"/>
								<token-text xml:space="preserve"> </token-text>
								<token-text xml:space="preserve">'</token-text>
								<token-local-variable name="lvUpdateFilterJobDotDn"/>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command $lvDxcmdCommand$ returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job '~gcvUpdateFilterJobName~': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command $lvDxcmdCommand$ completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="lib-LogCreate">
            <policy>
				<rule>
					<description>Record the creation.</description>
					<comment xml:space="preserve">Currently from the publisher's perspective . .</comment>
					<conditions/>
					<actions>
						<do-set-local-variable name="logMessage" scope="policy">
							<arg-string>
								<token-time format="dd-MMM-yyyy HH:mm:ss"/>
								<token-text xml:space="preserve">: Creating new object at: </token-text>
								<token-dest-dn/>
							</arg-string>
						</do-set-local-variable>
						<do-add-dest-attr-value class-name="User" name="abcIDMActivity">
							<arg-value type="string">
								<token-text xml:space="preserve">IDM: [~dirxml.auto.driverdn~] : </token-text>
								<token-local-variable name="logMessage"/>
							</arg-value>
						</do-add-dest-attr-value>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="lib-LogMatch">
            <policy>
				<rule>
					<description>Record the match.</description>
					<comment xml:space="preserve">Currently from the publisher's perspective. Note: we have to write directly; as matches result in a match and merge; and the engine trashes the original event.</comment>
					<conditions>
						<and>
							<if-dest-dn op="available"/>
						</and>
					</conditions>
					<actions>
						<do-set-local-variable name="logMessage" scope="policy">
							<arg-string>
								<token-time format="dd-MMM-yyyy HH:mm:ss"/>
								<token-text xml:space="preserve">: Matched object at: </token-text>
								<token-dest-dn/>
							</arg-string>
						</do-set-local-variable>
						<do-add-dest-attr-value class-name="User" direct="true" name="abcIDMActivity">
							<arg-value type="string">
								<token-text xml:space="preserve">IDM: [~dirxml.auto.driverdn~] : </token-text>
								<token-local-variable name="logMessage"/>
							</arg-value>
						</do-add-dest-attr-value>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="lib-RemoveEmptyValues">
            <policy>
				<rule>
					<description>Remove Empty Values on adds</description>
					<comment xml:space="preserve">To avoid a syntax error when adding an empty value this policy removes the add empty value tag from the node set</comment>
					<conditions>
						<or>
							<if-operation mode="nocase" op="equal">add</if-operation>
						</or>
					</conditions>
					<actions>
						<do-set-local-variable name="lvCurrentNodeSet" scope="policy">
							<arg-node-set>
								<token-xpath expression="add-attr"/>
							</arg-node-set>
						</do-set-local-variable>
						<do-for-each>
							<arg-node-set>
								<token-local-variable name="lvCurrentNodeSet"/>
							</arg-node-set>
							<arg-actions>
								<do-set-local-variable name="lvCurrentNodeAttrName" scope="policy">
									<arg-string>
										<token-xpath expression="$current-node/@attr-name"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">AttrName: "</token-text>
										<token-local-variable name="lvCurrentNodeAttrName"/>
										<token-text xml:space="preserve">" </token-text>
										<token-text xml:space="preserve">Attr Value: "</token-text>
										<token-xpath expression="add-attr[@attr-name=$lvCurrentNodeAttrName]/value/text()"/>
										<token-text xml:space="preserve">"</token-text>
									</arg-string>
								</do-trace-message>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length(add-attr[@attr-name=$lvCurrentNodeAttrName]/value/text()) &gt; 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-xpath op="true">starts-with(add-attr[@attr-name=$lvCurrentNodeAttrName]/value/text(), "1899-12-31")</if-xpath>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-strip-xpath expression="add-attr[@attr-name=$lvCurrentNodeAttrName]/value"/>
											</arg-actions>
											<arg-actions/>
										</do-if>
									</arg-actions>
									<arg-actions>
										<do-strip-xpath expression="add-attr[@attr-name=$lvCurrentNodeAttrName]/value"/>
									</arg-actions>
								</do-if>
							</arg-actions>
						</do-for-each>
					</actions>
				</rule>
				<rule>
					<description>Remove Empty Values on modifies</description>
					<comment xml:space="preserve">To avoid a syntax error when adding an empty value this policy removes the add empty value tag from the node set</comment>
					<conditions>
						<or>
							<if-operation mode="nocase" op="equal">modify</if-operation>
						</or>
					</conditions>
					<actions>
						<do-set-local-variable name="lvCurrentNodeSet" scope="policy">
							<arg-node-set>
								<token-xpath expression="modify-attr"/>
							</arg-node-set>
						</do-set-local-variable>
						<do-for-each>
							<arg-node-set>
								<token-local-variable name="lvCurrentNodeSet"/>
							</arg-node-set>
							<arg-actions>
								<do-set-local-variable name="lvCurrentNodeAttrName" scope="policy">
									<arg-string>
										<token-xpath expression="$current-node/@attr-name"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length(modify-attr[@attr-name=$lvCurrentNodeAttrName]/add-value/value/text()) &gt; 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-xpath op="true">starts-with(modify-attr[@attr-name=$lvCurrentNodeAttrName]/add-value/value/text(), "1899-12-31")</if-xpath>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-strip-xpath expression="modify-attr[@attr-name=$lvCurrentNodeAttrName]/add-value"/>
											</arg-actions>
											<arg-actions/>
										</do-if>
									</arg-actions>
									<arg-actions>
										<do-strip-xpath expression="modify-attr[@attr-name=$lvCurrentNodeAttrName]/add-value"/>
									</arg-actions>
								</do-if>
							</arg-actions>
						</do-for-each>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="lib-UserType">
            <policy>
				<rule>
					<description>Exit conditions</description>
					<conditions>
						<or>
							<if-class-name mode="nocase" op="not-equal">User</if-class-name>
							<if-operation mode="nocase" op="equal">delete</if-operation>
						</or>
					</conditions>
					<actions>
						<do-break/>
					</actions>
				</rule>
				<rule>
					<description>Exit if UserType already set.</description>
					<comment xml:space="preserve">Syncs with matches can end up skipping this policy, so it is called again in the creation policy set. This rule will break if the UserType is already set.</comment>
					<conditions>
						<and>
							<if-op-property mode="nocase" name="UserTypeCalcComplete" op="equal">TRUE</if-op-property>
						</and>
					</conditions>
					<actions>
						<do-break/>
					</actions>
				</rule>
				<rule>
					<description>Exit conditions - allowable opperations</description>
					<conditions>
						<and>
							<if-operation mode="nocase" op="not-equal">add</if-operation>
							<if-operation mode="nocase" op="not-equal">modify</if-operation>
							<if-operation mode="nocase" op="not-equal">sync</if-operation>
						</and>
					</conditions>
					<actions>
						<do-break/>
					</actions>
				</rule>
				<rule>
					<description>Set variables for all users.</description>
					<comment xml:space="preserve">Set the UserType to make decisions on other points of the driver.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<and>
									<if-local-variable mode="nocase" name="fromNds" op="equal">TRUE</if-local-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lv_userAssoc" scope="policy">
									<arg-node-set>
										<token-attr name="DirXML-Associations"/>
									</arg-node-set>
								</do-set-local-variable>
							</arg-actions>
							<arg-actions/>
						</do-if>
						<do-set-local-variable name="lv_driverName" scope="policy">
							<arg-string>
								<token-parse-dn dest-dn-format="slash" length="1" src-dn-format="slash" start="-1">
									<token-global-variable name="dirxml.auto.driverdn"/>
								</token-parse-dn>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">UserTypes setting from Service Driver -&gt; </token-text>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>
				<rule>
					<description>Tag UserTypeSF users</description>
					<comment xml:space="preserve">If the user has an SF association or this is the SF dirver, this is an SF user.</comment>
					<conditions/>
					<actions>
						<do-trace-message disabled="true" level="999" notrace="true">
							<arg-string>
								<token-text xml:space="preserve">Comment Only: This is done from the assocation since there is not another determinitisc way to say this is an SF user. The presense of a GCINumber is not good enough since other UserTypes also have GCINumber</token-text>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-local-variable mode="nocase" name="fromNds" op="equal">TRUE</if-local-variable>
									<if-xpath op="true">$lv_userAssoc[contains(component[@name='volume'], 'SuccessFactors-Driver') ]/component[@name='nameSpace']/text()</if-xpath>
								</and>
								<and>
									<if-local-variable mode="nocase" name="lv_driverName" op="equal">SuccessFactors-Driver</if-local-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-op-property name="UserTypeSF">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-op-property>
								<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
									<arg-string>
										<token-local-variable name="traceMsg" notrace="true"/>
										<token-text xml:space="preserve">
                            UserTypeSF=TRUE</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
							<arg-actions>
								<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
									<arg-string>
										<token-local-variable name="traceMsg" notrace="true"/>
										<token-text xml:space="preserve">
                            UserTypeSF=FALSE</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule disabled="true">
					<description>Tag UserTypeNSF - Not Used Yet</description>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<and>
									<if-local-variable mode="nocase" name="fromNds" op="equal">TRUE</if-local-variable>
									<if-attr name="abcGCINumber" op="not-available"/>
								</and>
								<and>
									<if-local-variable mode="nocase" name="fromNds" op="equal">FALSE</if-local-variable>
									<if-op-attr name="abcGCINumber" op="not-available"/>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-op-property name="UserTypeNSF">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-op-property>
								<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
									<arg-string>
										<token-local-variable name="traceMsg" notrace="true"/>
										<token-text xml:space="preserve">
                            UserTypeNSF=TRUE (Or GCI not in current event)</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
							<arg-actions>
								<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
									<arg-string>
										<token-local-variable name="traceMsg" notrace="true"/>
										<token-text xml:space="preserve">
                            UserTypeNSF=FALSE </token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Tag UserTypeKSA-SAP</description>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<and>
									<if-local-variable mode="nocase" name="fromNds" op="equal">TRUE</if-local-variable>
									<if-attr mode="nocase" name="abcSAPKSABusLevel2Code" op="equal">KSA-SA</if-attr>
								</and>
								<and>
									<if-local-variable mode="nocase" name="fromNds" op="not-equal">TRUE</if-local-variable>
									<if-op-attr mode="nocase" name="abcBusLevel2CodePri" op="equal">KSA-SA</if-op-attr>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-op-property name="UserTypeKSA-SAP">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-op-property>
								<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
									<arg-string>
										<token-local-variable name="traceMsg" notrace="true"/>
										<token-text xml:space="preserve">
                            UserTypeKSA-SAP=TRUE </token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
							<arg-actions>
								<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
									<arg-string>
										<token-local-variable name="traceMsg" notrace="true"/>
										<token-text xml:space="preserve">
                            UserTypeKSA-SAP=FALSE </token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Tag UserTypeKSA-SAP-GuestManager</description>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<and>
									<if-op-property mode="nocase" name="UserTypeSF" op="equal">TRUE</if-op-property>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="equal">TRUE</if-op-property>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-op-property name="UserTypeKSA-SAP-GuestManager">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-op-property>
								<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
									<arg-string>
										<token-local-variable name="traceMsg" notrace="true"/>
										<token-text xml:space="preserve">
                            UserTypeKSA-SAP-GuestManager=TRUE</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
							<arg-actions>
								<do-set-local-variable name="traceMsg" notrace="true" scope="policy">
									<arg-string>
										<token-local-variable name="traceMsg" notrace="true"/>
										<token-text xml:space="preserve">
                            UserTypeKSA-SAP-GuestManager=FALSE</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Trace UserType</description>
					<conditions/>
					<actions>
						<do-set-op-property name="UserTypeCalcComplete">
							<arg-string>
								<token-text xml:space="preserve">TRUE</token-text>
							</arg-string>
						</do-set-op-property>
						<do-trace-message level="6">
							<arg-string>
								<token-local-variable name="traceMsg"/>
								<token-text xml:space="preserve">
                            (fromNds: </token-text>
								<token-local-variable name="fromNds"/>
								<token-text xml:space="preserve">)</token-text>
								<token-text xml:space="preserve">
                            End UserType tracing.</token-text>
							</arg-string>
						</do-trace-message>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="sub-etp-VetoEvents">
            <policy>
				<rule>
					<description>Scope events</description>
					<comment xml:space="preserve">As of now, we just need to block deletes.</comment>
					<conditions>
						<and>
							<if-operation mode="nocase" op="equal">delete</if-operation>
						</and>
					</conditions>
					<actions>
						<do-veto/>
					</actions>
				</rule>
				<rule>
					<description>Dynamic Groups: block all events</description>
					<comment xml:space="preserve">These are in the filter only to help with determining the Octet string for static memberQuery urls. We just need the value to show up in the trace once to grab them, then we can veto the events.</comment>
					<conditions>
						<and>
							<if-class-name mode="nocase" op="equal">dynamicGroup</if-class-name>
						</and>
					</conditions>
					<actions>
						<do-veto/>
					</actions>
				</rule>
				<rule>
					<description>Block Out of Scope DirXML-Assocaiton changes</description>
					<comment xml:space="preserve">Used to block events with a particular IdMUnit assocation tag to enable automated testing. Required for tesing of the EC Training Expires Attr Update job.</comment>
					<conditions>
						<and>
							<if-op-attr name="DirXML-Associations" op="changing"/>
							<if-xpath op="true">modify-attr/remove-value/value/component[@name][text()="Disable-Re-Association-Code-For-IdMUnit-Testing"]=true()</if-xpath>
						</and>
					</conditions>
					<actions>
						<do-veto/>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="su-DeriveHost">
            <policy>
				<description>This policy attempts to dynamically figure out what host and port the Service Account should use to authenticate. Enable the first rule and add the GCvs if hardcoded values are desred.</description>
				<rule>
					<description>Break if Host and Port GCVs are Set</description>
					<comment xml:space="preserve">If the host and port are provided via a GCV, use that value. Note: the GCVS are present in the Driver set but ARE HIDDEN. Click Edit XML to change them there if desired.</comment>
					<conditions>
						<and>
							<if-xpath op="true">string-length('~gcvServiceHost~') &gt; 0</if-xpath>
						</and>
					</conditions>
					<actions>
						<do-set-local-variable name="drvServiceHost" scope="driver">
							<arg-string>
								<token-global-variable name="gcvServiceHost"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="drvServicePort" scope="driver">
							<arg-string>
								<token-global-variable name="gcvServicePort"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="drvHostPort" scope="driver">
							<arg-string>
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve">:</token-text>
								<token-local-variable name="drvServicePort"/>
							</arg-string>
						</do-set-local-variable>
						<do-break/>
					</actions>
				</rule>
				<rule>
					<description>Query for Driver Set's Server List</description>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvServerList" scope="policy">
							<arg-node-set>
								<token-query class-name="DirXML-DriverSet" datastore="src" scope="entry">
									<arg-dn>
										<token-parse-dn dest-dn-format="slash" length="-2" src-dn-format="slash" start="0">
											<token-global-variable name="dirxml.auto.driverdn"/>
										</token-parse-dn>
									</arg-dn>
									<arg-string>
										<token-text xml:space="preserve">DirXML-ServerList</token-text>
									</arg-string>
								</token-query>
							</arg-node-set>
						</do-set-local-variable>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">count($lvServerList/attr[@attr-name='DirXML-ServerList']/value) &lt; 1</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to dynamically derive this server's host and port value because this driver's driver set's server list is empty</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
						</do-if>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">count($lvServerList/attr[@attr-name='DirXML-ServerList']/value) &gt; 1</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to dynamically derive this server's host and port values because this driver's driver set's server list contains multiple DNs</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
						</do-if>
						<do-set-local-variable name="lvServerSlashDn" scope="policy">
							<arg-string>
								<token-xpath expression="$lvServerList/attr[@attr-name='DirXML-ServerList']/value"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DEBUG: lvServerSlashDn: '</token-text>
								<token-local-variable name="lvServerSlashDn"/>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">string-length($lvServerSlashDn) = 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to dynamically derive this server's host and port values because this driver's driver set's server list is empty</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Query for Server's Network Addresses</description>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-if>
							<arg-conditions>
								<and>
									<if-global-variable mode="nocase" name="gcvUseSSL" op="equal">true</if-global-variable>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvProtocol" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldaps:</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
							<arg-actions>
								<do-set-local-variable name="lvProtocol" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap:</token-text>
									</arg-string>
								</do-set-local-variable>
							</arg-actions>
						</do-if>
						<do-set-local-variable name="lvQueryResult" scope="policy">
							<arg-node-set>
								<token-query class-name="Server" datastore="src" scope="entry">
									<arg-dn>
										<token-local-variable name="lvServerSlashDn"/>
									</arg-dn>
									<arg-string>
										<token-text xml:space="preserve">Network Address</token-text>
									</arg-string>
								</token-query>
							</arg-node-set>
						</do-set-local-variable>
						<do-for-each>
							<arg-node-set>
								<token-xpath expression="$lvQueryResult/attr[@attr-name='Network Address']/value[component[@name='netAddrType']/text() = '13']"/>
							</arg-node-set>
							<arg-actions>
								<do-set-local-variable name="lvAddress" scope="policy">
									<arg-string>
										<!-- remove all characters except for the ones we want -->
										<!-- remove ^ and @ characters; not sure what the underlying characters actually are, but regexs containing @ and ^ do 						         not work even when escaped-->
										<!-- charsets ISO-8859-1, UTF-8, ASCII yield similar results; UTF-16 variants don't work -->
										<token-replace-all regex="[^A-Za-z0-9\.\/:]" replace-with="">
											<token-base64-decode charset="US-ASCII">
												<token-xpath expression="$current-node/component[@name='netAddr']/text()"/>
											</token-base64-decode>
										</token-replace-all>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">DEBUG: lvAddress: '</token-text>
										<token-local-variable name="lvAddress"/>
										<token-text xml:space="preserve">'</token-text>
									</arg-string>
								</do-trace-message>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">starts-with($lvAddress, $lvProtocol)</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lvLdapAddress" scope="policy">
											<arg-string>
												<token-local-variable name="lvAddress"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
							</arg-actions>
						</do-for-each>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">string-length($lvLdapAddress) &lt; 1</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to dynamically derive this server's host and port values because it does not have a LDAP address</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Set Host and Port Variables (driver scope)</description>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvSplitProtocol" scope="policy">
							<arg-node-set>
								<token-split delimiter="//">
									<token-local-variable name="lvLdapAddress"/>
								</token-split>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="lvSplitHostPort" scope="policy">
							<arg-node-set>
								<token-split delimiter=":">
									<token-xpath expression="$lvSplitProtocol[2]"/>
								</token-split>
							</arg-node-set>
						</do-set-local-variable>
						<do-set-local-variable name="drvServiceHost" scope="driver">
							<arg-string>
								<token-xpath expression="$lvSplitHostPort[1]"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="drvServicePort" scope="driver">
							<arg-string>
								<token-xpath expression="$lvSplitHostPort[2]"/>
							</arg-string>
						</do-set-local-variable>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length($drvServiceHost) &lt; 1</if-xpath>
									<if-xpath op="true">string-length($drvServicePort) &lt; 1</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to dynamically derive this server's host and port values due to a parsing problem</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
						</do-if>
						<do-set-local-variable name="drvHostPort" scope="driver">
							<arg-string>
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve">:</token-text>
								<token-local-variable name="drvServicePort"/>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="su-SetJobRights">
            <policy>
				<rule>
					<description>Setup variables.</description>
					<conditions/>
					<actions>
						<do-set-local-variable name="lvPrivilegeRead" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">2</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="lvPrivilegeWrite" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">4</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="lvPrivilegeReadWriteCompare" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">7</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="lvPrivilegeReadWriteCompareInherited" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">71</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable disabled="true" name="lvPrivilegeSupervisor" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">16</token-text>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>
				<rule>
					<description>Service Account User - Create and set attributes</description>
					<comment xml:space="preserve">This account is used to easily update the memberQueryURL attribute through LDAP. It has very restricted rights, and is only used to change the scope of the membery query url on dynamic job scope groups, update jobs, and start jobs.
Note: we create it 'direct' so that the subsequent attribute updates are always modifies on the account (so we don't hit object already exist errors when a full add would update needed attrs).
User has severely limited rights, so we're ok just using the user DN as the user password.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', '~driver.serviceaccount~', "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="User">
									<arg-dn>
										<token-global-variable name="driver.serviceaccount"/>
									</arg-dn>
								</do-add-src-object>
								<do-set-src-attr-value class-name="User" name="Surname">
									<arg-dn>
										<token-global-variable name="driver.serviceaccount"/>
									</arg-dn>
									<arg-value type="string">
										<token-text xml:space="preserve">sn</token-text>
									</arg-value>
								</do-set-src-attr-value>
							</arg-actions>
						</do-if>
						<do-set-local-variable name="driver.serviceaccount.password" notrace="true" scope="driver">
							<arg-string>
								<token-global-variable name="driver.serviceaccount"/>
							</arg-string>
						</do-set-local-variable>
						<do-set-src-password class-name="User" notrace="true">
							<arg-dn>
								<token-global-variable name="driver.serviceaccount"/>
							</arg-dn>
							<arg-string>
								<token-global-variable name="driver.serviceaccount"/>
							</arg-string>
						</do-set-src-password>
					</actions>
				</rule>
				<rule>
					<description>Service Account User - Configure rights for the service account user</description>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="ou" name="ACL">
							<arg-dn>
								<token-parse-dn dest-dn-format="slash" src-dn-format="ldap">
									<token-global-variable name="PEOPLE_LISTS_OU"/>
								</token-parse-dn>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeReadWriteCompareInherited"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="ou" name="ACL">
							<arg-dn>
								<token-parse-dn dest-dn-format="slash" src-dn-format="ldap">
									<token-global-variable name="PEOPLE_LISTS_OU"/>
								</token-parse-dn>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">abcAsListType</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeReadWriteCompareInherited"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>All jobs: Configure rights - allow jobs to submit events to the driver.</description>
					<comment xml:space="preserve">ACLs need to be set on the driver object; this driver assumes it has rights to write ACLS on this driver.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ECTrainingExpires</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ECTrainingExpires-Schedule</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ECTrainingExpires-AttrUpdate</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ECTrainingExpires-AttrUpdate-Schedule</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-UpdateTables</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-DeleteOldUsers</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-DeleteOldUsers-Schedule</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-SecondmentExpires</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-SecondmentExpires-Schedule</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-LWDCheck</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-LWDCheck-Schedule</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ManagerUpdate-MWFID</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ManagerUpdate-MWFID-Schedule</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-GLAccountExpires</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-GLAccountExpires-Schedule</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-StartToday</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-StartToday-Schedule</token-text>
								</arg-component>
								<arg-component name="privileges">
									<token-text xml:space="preserve">4</token-text>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Configure rights for service account on job objects: Job-ECTrainingExpires-AttrUpdate</description>
					<comment xml:space="preserve">Some basic rights are needed for dynamic groups to work properly; so set them now.

 - Write rights for newly created service account to change memberQueryUrl.
 - Write rights to DirXML-AccessConfigure so we can send the job update notification as the temp service user.
 - Write rights to the DirXML-AccessRun so the user can start the job.
</comment>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-attr-update-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">memberQuery</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ECTrainingExpires-AttrUpdate</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessConfigure</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ECTrainingExpires-AttrUpdate</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessRun</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Configure rights for service account on job objects: Job-ECTrainingExpires</description>
					<comment xml:space="preserve">Some basic rights are needed for dynamic groups to work properly; so set them now.

 - Write rights for newly created service account to change memberQueryUrl.
 - Write rights to DirXML-AccessConfigure so we can send the job update notification as the temp service user.
 - Write rights to the DirXML-AccessRun so the user can start the job.
</comment>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">memberQuery</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ECTrainingExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessConfigure</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ECTrainingExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessRun</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Configure rights for service account on job objects: Job-DeleteOldUsers</description>
					<comment xml:space="preserve">Some basic rights are needed for dynamic groups to work properly; so set them now.

 - Write rights for newly created service account to change memberQueryUrl.
 - Write rights to DirXML-AccessConfigure so we can send the job update notification as the temp service user.
 - Write rights to the DirXML-AccessRun so the user can start the job.
</comment>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-users-to-delete-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">memberQuery</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-DeleteOldUsers</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessConfigure</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-DeleteOldUsers</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessRun</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Configure rights for service account on job objects: Job-SecondmentExpires</description>
					<comment xml:space="preserve">Some basic rights are needed for dynamic groups to work properly; so set them now.

 - Write rights for newly created service account to change memberQueryUrl.
 - Write rights to DirXML-AccessConfigure so we can send the job update notification as the temp service user.
 - Write rights to the DirXML-AccessRun so the user can start the job.
</comment>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-secondment-to-check-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">memberQuery</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-SecondmentExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessConfigure</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-SecondmentExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessRun</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Configure rights for service account on job objects: Job-LWDCheck</description>
					<comment xml:space="preserve">Some basic rights are needed for dynamic groups to work properly; so set them now.

 - Write rights for newly created service account to change memberQueryUrl.
 - Write rights to DirXML-AccessConfigure so we can send the job update notification as the temp service user.
 - Write rights to the DirXML-AccessRun so the user can start the job.
</comment>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-last-working-day-check-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">memberQuery</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-LWDCheck</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessConfigure</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-LWDCheck</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessRun</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Configure rights for service account on job objects: Job-ManagerUpdate-MWFID</description>
					<comment xml:space="preserve">Some basic rights are needed for dynamic groups to work properly; so set them now.

 - Write rights for newly created service account to change memberQueryUrl.
 - Write rights to DirXML-AccessConfigure so we can send the job update notification as the temp service user.
 - Write rights to the DirXML-AccessRun so the user can start the job.
</comment>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-missing-manager-group-mwfid"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">memberQuery</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ManagerUpdate-MWFID</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessConfigure</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ManagerUpdate-MWFID</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessRun</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Configure rights for service account on job objects: Job-GLAccountExpires</description>
					<comment xml:space="preserve">Some basic rights are needed for dynamic groups to work properly; so set them now.

 - Write rights for newly created service account to change memberQueryUrl.
 - Write rights to DirXML-AccessConfigure so we can send the job update notification as the temp service user.
 - Write rights to the DirXML-AccessRun so the user can start the job.
</comment>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-gl-user-expire"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">memberQuery</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-GLAccountExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessConfigure</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-GLAccountExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessRun</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Configure rights for service account on job objects: Job-StartToday</description>
					<comment xml:space="preserve">Some basic rights are needed for dynamic groups to work properly; so set them now.

 - Write rights for newly created service account to change memberQueryUrl.
 - Write rights to DirXML-AccessConfigure so we can send the job update notification as the temp service user.
 - Write rights to the DirXML-AccessRun so the user can start the job.
</comment>
					<conditions/>
					<actions>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-start-today"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">memberQuery</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-StartToday</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessConfigure</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
						<do-add-src-attr-value class-name="DirXML-Job" name="ACL">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-StartToday</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">DirXML-AccessRun</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-global-variable name="driver.serviceaccount"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeWrite"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>All jobs: Configure job scopes</description>
					<comment xml:space="preserve">Some jobs process trigger events; based on a configured scope. set them now. The "-Schedule" versions of the jobs will update the memberQueryURL on the Job's scoped dynamic groups; but we still need to set the scope of the group to begin with.  If they're already set, these will just no-op.</comment>
					<conditions/>
					<actions>
						<do-set-src-attr-value class-name="DirXML-Job" name="DirXML-Scope" when="direct">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ECTrainingExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="nameSpace">
									<token-text xml:space="preserve">0</token-text>
								</arg-component>
								<arg-component name="volume">
									<token-global-variable name="dg-expired-ectraining-group"/>
								</arg-component>
								<arg-component name="path">
									<token-text xml:space="preserve">&lt;scope-def scope="members"/&gt;</token-text>
								</arg-component>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Job" name="DirXML-Scope" when="direct">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ECTrainingExpires-AttrUpdate</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="nameSpace">
									<token-text xml:space="preserve">0</token-text>
								</arg-component>
								<arg-component name="volume">
									<token-global-variable name="dg-expired-ectraining-attr-update-group"/>
								</arg-component>
								<arg-component name="path">
									<token-text xml:space="preserve">&lt;scope-def scope="members"/&gt;</token-text>
								</arg-component>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Job" name="DirXML-Scope">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-DeleteOldUsers</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="nameSpace">
									<token-text xml:space="preserve">0</token-text>
								</arg-component>
								<arg-component name="volume">
									<token-global-variable name="dg-users-to-delete-group"/>
								</arg-component>
								<arg-component name="path">
									<token-text xml:space="preserve">&lt;scope-def scope="members"/&gt;</token-text>
								</arg-component>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Job" name="DirXML-Scope">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-SecondmentExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="nameSpace">
									<token-text xml:space="preserve">0</token-text>
								</arg-component>
								<arg-component name="volume">
									<token-global-variable name="dg-secondment-to-check-group"/>
								</arg-component>
								<arg-component name="path">
									<token-text xml:space="preserve">&lt;scope-def scope="members"/&gt;</token-text>
								</arg-component>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Job" name="DirXML-Scope">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-LWDCheck</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="nameSpace">
									<token-text xml:space="preserve">0</token-text>
								</arg-component>
								<arg-component name="volume">
									<token-global-variable name="dg-last-working-day-check-group"/>
								</arg-component>
								<arg-component name="path">
									<token-text xml:space="preserve">&lt;scope-def scope="members"/&gt;</token-text>
								</arg-component>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Job" name="DirXML-Scope">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-ManagerUpdate-MWFID</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="nameSpace">
									<token-text xml:space="preserve">0</token-text>
								</arg-component>
								<arg-component name="volume">
									<token-global-variable name="dg-missing-manager-group-mwfid"/>
								</arg-component>
								<arg-component name="path">
									<token-text xml:space="preserve">&lt;scope-def scope="members"/&gt;</token-text>
								</arg-component>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Job" name="DirXML-Scope">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-GLAccountExpires</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="nameSpace">
									<token-text xml:space="preserve">0</token-text>
								</arg-component>
								<arg-component name="volume">
									<token-global-variable name="dg-gl-user-expire"/>
								</arg-component>
								<arg-component name="path">
									<token-text xml:space="preserve">&lt;scope-def scope="members"/&gt;</token-text>
								</arg-component>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="DirXML-Job" name="DirXML-Scope">
							<arg-dn>
								<token-global-variable name="dirxml.auto.driverdn"/>
								<token-text xml:space="preserve">\Job-StartToday</token-text>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="nameSpace">
									<token-text xml:space="preserve">0</token-text>
								</arg-component>
								<arg-component name="volume">
									<token-global-variable name="dg-start-today"/>
								</arg-component>
								<arg-component name="path">
									<token-text xml:space="preserve">&lt;scope-def scope="members"/&gt;</token-text>
								</arg-component>
							</arg-value>
						</do-set-src-attr-value>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="su-SetupDynamicComponents">
            <policy xmlns:dxcmd="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.util.DxCommand">
				<rule>
					<description>Setup variables.</description>
					<conditions/>
					<actions>
						<do-set-local-variable name="lvPrivilegeRead" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">2</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable name="lvPrivilegeWrite" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">4</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-set-local-variable disabled="true" name="lvPrivilegeSupervisor" scope="policy">
							<arg-string>
								<token-text xml:space="preserve">16</token-text>
							</arg-string>
						</do-set-local-variable>
					</actions>
				</rule>
				<rule>
					<description>Create Service Group and set Attributes: ~dg-expired-ectraining-attr-update-group~</description>
					<comment xml:space="preserve">This policy creates a Dynamic Group with an LDAP filter to serve as the scope for the ECTraining email.
Note: the tree root right to read member is a standard right built into the schema's ACL template so any user in the tree can read the member attribute.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $dg-expired-ectraining-attr-update-group, "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="dynamicGroup">
									<arg-dn>
										<token-global-variable name="dg-expired-ectraining-attr-update-group"/>
									</arg-dn>
								</do-add-src-object>
							</arg-actions>
						</do-if>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowDuplicates">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-attr-update-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowUnknown">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-attr-update-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgIdentity">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-attr-update-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="owner">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-attr-update-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-attr-update-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">Member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-text xml:space="preserve">\</token-text>
									<token-global-variable name="dirxml.auto.treename"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeRead"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create Service Group and set Attributes: ~dg-expired-ectraining-group~</description>
					<comment xml:space="preserve">This policy creates a Dynamic Group with an LDAP filter to serve as the scope for the ECTraining email.
Note: the tree root right to read member is a standard right built into the schema's ACL template so any user in the tree can read the member attribute.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $dg-expired-ectraining-group, "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="dynamicGroup">
									<arg-dn>
										<token-global-variable name="dg-expired-ectraining-group"/>
									</arg-dn>
								</do-add-src-object>
							</arg-actions>
						</do-if>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowDuplicates">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowUnknown">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgIdentity">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="owner">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-expired-ectraining-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">Member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-text xml:space="preserve">\</token-text>
									<token-global-variable name="dirxml.auto.treename"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeRead"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create Service Group and set Attributes: ~dg-users-to-delete-group~</description>
					<comment xml:space="preserve">This policy creates a Dynamic Group with an LDAP filter to serve as the scope for deleting old users.

Note: the tree root right to read member is a standard right built into the schema's ACL template so any user in the tree can read the member attribute.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $dg-users-to-delete-group, "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="dynamicGroup">
									<arg-dn>
										<token-global-variable name="dg-users-to-delete-group"/>
									</arg-dn>
								</do-add-src-object>
							</arg-actions>
						</do-if>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowDuplicates">
							<arg-dn>
								<token-global-variable name="dg-users-to-delete-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowUnknown">
							<arg-dn>
								<token-global-variable name="dg-users-to-delete-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgIdentity">
							<arg-dn>
								<token-global-variable name="dg-users-to-delete-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="owner">
							<arg-dn>
								<token-global-variable name="dg-users-to-delete-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-users-to-delete-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">Member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-text xml:space="preserve">\</token-text>
									<token-global-variable name="dirxml.auto.treename"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeRead"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create Service Group and set Attributes: ~dg-secondment-to-check-group~</description>
					<comment xml:space="preserve">This policy creates a Dynamic Group with an LDAP filter to serve as the scope for making users seconded.

Note: the tree root right to read member is a standard right built into the schema's ACL template so any user in the tree can read the member attribute.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $dg-secondment-to-check-group, "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="dynamicGroup">
									<arg-dn>
										<token-global-variable name="dg-secondment-to-check-group"/>
									</arg-dn>
								</do-add-src-object>
							</arg-actions>
						</do-if>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowDuplicates">
							<arg-dn>
								<token-global-variable name="dg-secondment-to-check-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowUnknown">
							<arg-dn>
								<token-global-variable name="dg-secondment-to-check-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgIdentity">
							<arg-dn>
								<token-global-variable name="dg-secondment-to-check-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="owner">
							<arg-dn>
								<token-global-variable name="dg-secondment-to-check-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-secondment-to-check-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">Member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-text xml:space="preserve">\</token-text>
									<token-global-variable name="dirxml.auto.treename"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeRead"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create Service Group and set Attributes: ~dg-last-working-day-check-group~</description>
					<comment xml:space="preserve">This policy creates a Dynamic Group with an LDAP filter to serve as the scope for deleting old users.

Note: the tree root right to read member is a standard right built into the schema's ACL template so any user in the tree can read the member attribute.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $dg-last-working-day-check-group, "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="dynamicGroup">
									<arg-dn>
										<token-global-variable name="dg-last-working-day-check-group"/>
									</arg-dn>
								</do-add-src-object>
							</arg-actions>
						</do-if>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowDuplicates">
							<arg-dn>
								<token-global-variable name="dg-last-working-day-check-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowUnknown">
							<arg-dn>
								<token-global-variable name="dg-last-working-day-check-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgIdentity">
							<arg-dn>
								<token-global-variable name="dg-last-working-day-check-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="owner">
							<arg-dn>
								<token-global-variable name="dg-last-working-day-check-group"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-last-working-day-check-group"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">Member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-text xml:space="preserve">\</token-text>
									<token-global-variable name="dirxml.auto.treename"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeRead"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create Service Group and set Attributes: ~dg-missing-manager-group-mwfid~</description>
					<comment xml:space="preserve">This policy creates a Dynamic Group with an LDAP filter to serve as the scope.

Note: the tree root right to read member is a standard right built into the schema's ACL template so any user in the tree can read the member attribute.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $dg-missing-manager-group-mwfid, "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="dynamicGroup">
									<arg-dn>
										<token-global-variable name="dg-missing-manager-group-mwfid"/>
									</arg-dn>
								</do-add-src-object>
							</arg-actions>
							<arg-actions/>
						</do-if>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowDuplicates">
							<arg-dn>
								<token-global-variable name="dg-missing-manager-group-mwfid"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowUnknown">
							<arg-dn>
								<token-global-variable name="dg-missing-manager-group-mwfid"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgIdentity">
							<arg-dn>
								<token-global-variable name="dg-missing-manager-group-mwfid"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="owner">
							<arg-dn>
								<token-global-variable name="dg-missing-manager-group-mwfid"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-missing-manager-group-mwfid"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">Member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-text xml:space="preserve">\</token-text>
									<token-global-variable name="dirxml.auto.treename"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeRead"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create Service Group and set Attributes: ~dg-gl-user-expire~</description>
					<comment xml:space="preserve">This policy creates a Dynamic Group with an LDAP filter to serve as the scope for deleting old users.

Note: the tree root right to read member is a standard right built into the schema's ACL template so any user in the tree can read the member attribute.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $dg-gl-user-expire, "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="dynamicGroup">
									<arg-dn>
										<token-global-variable name="dg-gl-user-expire"/>
									</arg-dn>
								</do-add-src-object>
							</arg-actions>
						</do-if>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowDuplicates">
							<arg-dn>
								<token-global-variable name="dg-gl-user-expire"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowUnknown">
							<arg-dn>
								<token-global-variable name="dg-gl-user-expire"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgIdentity">
							<arg-dn>
								<token-global-variable name="dg-gl-user-expire"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="owner">
							<arg-dn>
								<token-global-variable name="dg-gl-user-expire"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-gl-user-expire"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">Member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-text xml:space="preserve">\</token-text>
									<token-global-variable name="dirxml.auto.treename"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeRead"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
				<rule>
					<description>Create Service Group and set Attributes: ~dg-start-today~</description>
					<comment xml:space="preserve">This policy creates a Dynamic Group with an LDAP filter to serve as the scope for users starting today.

Note: the tree root right to read member is a standard right built into the schema's ACL template so any user in the tree can read the member attribute.</comment>
					<conditions/>
					<actions>
						<do-if>
							<arg-conditions>
								<or>
									<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $dg-start-today, "", "")/@src-dn) = 0</if-xpath>
								</or>
							</arg-conditions>
							<arg-actions>
								<do-add-src-object class-name="dynamicGroup">
									<arg-dn>
										<token-global-variable name="dg-start-today"/>
									</arg-dn>
								</do-add-src-object>
							</arg-actions>
						</do-if>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowDuplicates">
							<arg-dn>
								<token-global-variable name="dg-start-today"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgAllowUnknown">
							<arg-dn>
								<token-global-variable name="dg-start-today"/>
							</arg-dn>
							<arg-value type="string">
								<token-text xml:space="preserve">false</token-text>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="dgIdentity">
							<arg-dn>
								<token-global-variable name="dg-start-today"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-set-src-attr-value class-name="dynamicGroup" name="owner">
							<arg-dn>
								<token-global-variable name="dg-start-today"/>
							</arg-dn>
							<arg-value type="string">
								<token-src-attr class-name="DirXML-Driver" name="Security Equals">
									<arg-dn>
										<token-global-variable name="dirxml.auto.driverdn"/>
									</arg-dn>
								</token-src-attr>
							</arg-value>
						</do-set-src-attr-value>
						<do-add-src-attr-value class-name="dynamicGroup" name="ACL">
							<arg-dn>
								<token-global-variable name="dg-start-today"/>
							</arg-dn>
							<arg-value type="structured">
								<arg-component name="protectedName">
									<token-text xml:space="preserve">Member</token-text>
								</arg-component>
								<arg-component name="trustee">
									<token-text xml:space="preserve">\</token-text>
									<token-global-variable name="dirxml.auto.treename"/>
								</arg-component>
								<arg-component name="privileges">
									<token-local-variable name="lvPrivilegeRead"/>
								</arg-component>
							</arg-value>
						</do-add-src-attr-value>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="su-UpdateJobs">
            <policy xmlns:dxcmd="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.util.DxCommand">
				<description>This policy calls the 'updatejob' parameter in DXCMD. This ensures the newly assigned scopes are loaded into the engine. Technically; this happens already when drivers are loaded; however, if we had to set the scopes during this startup in the previous policy; this ensures they become active immediately rather then on next driver startup.</description>
				<rule>
					<description>Send Job Scope Update Notification: Job-ECTrainingExpires</description>
					<comment xml:space="preserve">Since we just set the DirXML-Scope, we need to tell the engine to reload it. Technically, this only needs to happen the very first time the scope is set; though this ensures the job is ready to go either way.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="driver.serviceaccount"/>
								</token-parse-dn>
								<token-text xml:space="preserve"> -password </token-text>
								<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
								<token-text xml:space="preserve"> -updatejob '</token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ECTrainingExpires</token-text>
								</token-parse-dn>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job 'Job-ECTrainingExpires': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Send Job Scope Update Notification: Job-ECTrainingExpires-AttrUpdate</description>
					<comment xml:space="preserve">Since we just set the DirXML-Scope, we need to tell the engine to reload it. Technically, this only needs to happen the very first time the scope is set; though this ensures the job is ready to go either way.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="driver.serviceaccount"/>
								</token-parse-dn>
								<token-text xml:space="preserve"> -password </token-text>
								<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
								<token-text xml:space="preserve"> -updatejob '</token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ECTrainingExpires-AttrUpdate</token-text>
								</token-parse-dn>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job 'Job-ECTrainingExpires-AttrUpdate': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Send Job Scope Update Notification: Job-DeleteOldUsers</description>
					<comment xml:space="preserve">Since we just set the DirXML-Scope, we need to tell the engine to reload it. Technically, this only needs to happen the very first time the scope is set; though this ensures the job is ready to go either way.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="driver.serviceaccount"/>
								</token-parse-dn>
								<token-text xml:space="preserve"> -password </token-text>
								<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
								<token-text xml:space="preserve"> -updatejob '</token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-DeleteOldUsers</token-text>
								</token-parse-dn>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job 'Job-DeleteOldUsers': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Send Job Scope Update Notification: Job-SecondmentExpires</description>
					<comment xml:space="preserve">Since we just set the DirXML-Scope, we need to tell the engine to reload it. Technically, this only needs to happen the very first time the scope is set; though this ensures the job is ready to go either way.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="driver.serviceaccount"/>
								</token-parse-dn>
								<token-text xml:space="preserve"> -password </token-text>
								<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
								<token-text xml:space="preserve"> -updatejob '</token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-SecondmentExpires</token-text>
								</token-parse-dn>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job 'Job-SecondmentExpires': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Send Job Scope Update Notification: Job-LWDCheck</description>
					<comment xml:space="preserve">Since we just set the DirXML-Scope, we need to tell the engine to reload it. Technically, this only needs to happen the very first time the scope is set; though this ensures the job is ready to go either way.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="driver.serviceaccount"/>
								</token-parse-dn>
								<token-text xml:space="preserve"> -password </token-text>
								<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
								<token-text xml:space="preserve"> -updatejob '</token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-LWDCheck</token-text>
								</token-parse-dn>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job 'Job-LWDCheck': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Send Job Scope Update Notification: Job-ManagerUpdate-MWFID</description>
					<comment xml:space="preserve">Since we just set the DirXML-Scope, we need to tell the engine to reload it. Technically, this only needs to happen the very first time the scope is set; though this ensures the job is ready to go either way.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="driver.serviceaccount"/>
								</token-parse-dn>
								<token-text xml:space="preserve"> -password </token-text>
								<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
								<token-text xml:space="preserve"> -updatejob '</token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-ManagerUpdate-MWFID</token-text>
								</token-parse-dn>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job 'Job-ManagerUpdate-MWFID': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Send Job Scope Update Notification: Job-GLAccountExpires</description>
					<comment xml:space="preserve">Since we just set the DirXML-Scope, we need to tell the engine to reload it. Technically, this only needs to happen the very first time the scope is set; though this ensures the job is ready to go either way.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="driver.serviceaccount"/>
								</token-parse-dn>
								<token-text xml:space="preserve"> -password </token-text>
								<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
								<token-text xml:space="preserve"> -updatejob '</token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-GLAccountExpires</token-text>
								</token-parse-dn>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job 'Job-GLAccountExpires': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
				<rule>
					<description>Send Job Scope Update Notification: Job-StartToday</description>
					<comment xml:space="preserve">Since we just set the DirXML-Scope, we need to tell the engine to reload it. Technically, this only needs to happen the very first time the scope is set; though this ensures the job is ready to go either way.</comment>
					<conditions>
						<and/>
					</conditions>
					<actions>
						<do-set-local-variable name="lvDxcmdArgs" scope="policy">
							<arg-string>
								<token-text xml:space="preserve"> -host </token-text>
								<!-- token-global-variable name="gcvServiceHost"/ -->
								<token-local-variable name="drvServiceHost"/>
								<token-text xml:space="preserve"> -user </token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="driver.serviceaccount"/>
								</token-parse-dn>
								<token-text xml:space="preserve"> -password </token-text>
								<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
								<token-text xml:space="preserve"> -updatejob '</token-text>
								<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
									<token-global-variable name="dirxml.auto.driverdn"/>
									<token-text xml:space="preserve">\Job-StartToday</token-text>
								</token-parse-dn>
								<token-text xml:space="preserve">'</token-text>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message color="yellow">
							<arg-string>
								<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
								<token-local-variable name="lvDxcmdArgs"/>
								<token-text xml:space="preserve">]</token-text>
							</arg-string>
						</do-trace-message>
						<do-set-local-variable name="lvDxcmdResult" scope="policy">
							<arg-string>
								<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
							</arg-string>
						</do-set-local-variable>
						<do-trace-message level="1">
							<arg-string>
								<token-text xml:space="preserve">DXCMD return code: </token-text>
								<token-local-variable name="lvDxcmdResult"/>
							</arg-string>
						</do-trace-message>
						<do-if>
							<arg-conditions>
								<and>
									<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
								</and>
							</arg-conditions>
							<arg-actions>
								<do-set-local-variable name="lvErrorMsg" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob returned error code </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">ERROR: </token-text>
										<token-local-variable name="lvErrorMsg"/>
									</arg-string>
								</do-trace-message>
								<do-status level="fatal">
									<arg-string>
										<token-text xml:space="preserve">Unable to send job update notification for job 'Job-StartToday': $lvErrorMsg$</token-text>
									</arg-string>
								</do-status>
							</arg-actions>
							<arg-actions>
								<do-trace-message>
									<arg-string>
										<token-text xml:space="preserve">DXCMD command -updatejob completed successfully</token-text>
									</arg-string>
								</do-trace-message>
							</arg-actions>
						</do-if>
					</actions>
				</rule>
			</policy>
        </rule>
        <rule name="WriteDriverRevOnEvent">
            <policy>
				<rule>
					<description>Write driver revision in event</description>
					<comment xml:space="preserve">This allows easy reference to drivers version number.</comment>
					<conditions/>
					<actions>
						<do-set-op-property name="DRIVER_REVISION">
							<arg-string>
								<token-text xml:space="preserve">X.X</token-text>
							</arg-string>
						</do-set-op-property>
					</actions>
				</rule>
			</policy>
        </rule>
        <subscriber name="Subscriber">
            <attributes/>
            <children>
                <rule name="sub-etp-ComputedAttributes">
					<policy xmlns:ChronoUnit="http://www.novell.com/nxsl/java/java.time.temporal.ChronoUnit" xmlns:DateTimeFormatter="http://www.novell.com/nxsl/java/java.time.format.DateTimeFormatter" xmlns:LocalDate="http://www.novell.com/nxsl/java/java.time.LocalDate">
						<rule>
							<description>Break if processing is unnecessary.</description>
							<comment xml:space="preserve">Break now if we aren't getting any changes for attributes that need to be figured.</comment>
							<conditions>
								<and>
									<if-op-attr name="abcCompanyStartDate" op="not-changing"/>
									<if-op-attr name="abcCompanyEndDate" op="not-changing"/>
									<if-op-attr name="abcStartDateSec" op="not-changing"/>
									<if-op-attr name="abcEndDateSec" op="not-changing"/>
									<if-op-attr name="abcTrainingAwarenessCompleted" op="not-changing"/>
									<if-op-attr name="abcTrainingEnhancedCompleted" op="not-changing"/>
									<if-op-property mode="nocase" name="checkECTrainingDates" op="not-equal">TRUE</if-op-property>
									<if-op-attr name="abcBusLevel3Code" op="not-changing"/>
									<if-op-attr name="abcBusLevel2Code" op="not-changing"/>
									<if-op-property mode="nocase" name="containsTermination" op="not-equal">TRUE</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Compute: abcContractLength: clear if start or end is empty.</description>
							<comment xml:space="preserve">abcContract length needs to be set whenever abcCompanyStartDate or abcCompanyEndDate changes. If either are blank, we can't set contract length, so clear it now. If we end up doing this, clear the current op attrs to avoid any more processing. Note: we set src and dest to let subsequent policies do processing if needed.</comment>
							<conditions>
								<or>
									<if-op-attr mode="regex" name="abcCompanyStartDate" op="changing"/>
									<if-op-attr mode="regex" name="abcCompanyEndDate" op="changing"/>
								</or>
								<or>
									<if-attr name="abcCompanyStartDate" op="not-available"/>
									<if-attr name="abcCompanyEndDate" op="not-available"/>
								</or>
							</conditions>
							<actions>
								<do-clear-src-attr-value class-name="User" name="abcContractLength"/>
								<do-clear-dest-attr-value class-name="User" name="abcContractLength"/>
								<do-strip-op-attr name="abcCompanyStartDate"/>
								<do-strip-op-attr name="abcCompanyEndDate"/>
							</actions>
						</rule>
						<rule>
							<description>Compute: abcLengthSec: clear if start or end is empty.</description>
							<comment xml:space="preserve">abcContract length needs to be set whenever abcStartDateSec or abcEndDateSec changes. If either are blank, we can't set contract length, so clear it now. If we end up doing this, clear the current op attrs to avoid any more processing.  Note: we set src and dest to let subsequent policies do processing if needed.</comment>
							<conditions>
								<or>
									<if-op-attr mode="regex" name="abcStartDateSec" op="changing"/>
									<if-op-attr mode="regex" name="abcEndDateSec" op="changing"/>
								</or>
								<or>
									<if-attr name="abcStartDateSec" op="not-available"/>
									<if-attr name="abcEndDateSec" op="not-available"/>
								</or>
							</conditions>
							<actions>
								<do-clear-src-attr-value class-name="User" name="abcLengthSec"/>
								<do-clear-dest-attr-value class-name="User" name="abcLengthSec"/>
								<do-strip-op-attr name="abcStartDateSec"/>
								<do-strip-op-attr name="abcEndDateSec"/>
							</actions>
						</rule>
						<rule>
							<description>Compute: abcContractLength: set to abcCompanyEnd - abcCompanyStart (in months)</description>
							<comment xml:space="preserve">Needs to be set whenever abcCompanyStartDate or abcCompanyEndDate changes. Note: if this condition triggers, we know at least one of these values are changing, and they're both populated.</comment>
							<conditions>
								<or>
									<if-op-attr mode="regex" name="abcCompanyStartDate" op="changing"/>
									<if-op-attr mode="regex" name="abcCompanyEndDate" op="changing"/>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="start" scope="policy">
									<arg-string>
										<token-attr name="abcCompanyStartDate"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="end" scope="policy">
									<arg-string>
										<token-attr name="abcCompanyEndDate"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-src-attr-value class-name="User" name="abcContractLength">
									<arg-value type="string">
										<token-xpath expression="es:getDaysBetween($start, $end)"/>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcContractLength">
									<arg-value type="string">
										<token-xpath expression="es:getDaysBetween($start, $end)"/>
									</arg-value>
								</do-set-dest-attr-value>
							</actions>
						</rule>
						<rule>
							<description>Compute: abcLengthSec: set to abcEndDateSec - abcStartDateSec (in months)</description>
							<comment xml:space="preserve">Needs to be set whenever abcStartDateSec or abcEndDateSec changes. Note: if this condition triggers, we know at least one of these values are changing, and they're both populated.</comment>
							<conditions>
								<or>
									<if-op-attr mode="regex" name="abcStartDateSec" op="changing"/>
									<if-op-attr mode="regex" name="abcEndDateSec" op="changing"/>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="start" scope="policy">
									<arg-string>
										<token-attr name="abcStartDateSec"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="end" scope="policy">
									<arg-string>
										<token-attr name="abcEndDateSec"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-src-attr-value class-name="User" name="abcLengthSec">
									<arg-value type="string">
										<token-xpath expression="es:getDaysBetween($start, $end)"/>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcLengthSec">
									<arg-value type="string">
										<token-xpath expression="es:getDaysBetween($start, $end)"/>
									</arg-value>
								</do-set-dest-attr-value>
							</actions>
						</rule>
						<rule>
							<description>Compute: abcLevelOfECTraining, abcTrainingLastCompleted.</description>
							<comment xml:space="preserve">Find out which training is populated: either Awareness or Enhanced. if both are blank, we clear abcLevelOfECTraining. We prefer Enhanced training if populated, otherwise we take Awareness date.
Note: see how src and dest attrs are set: src to actually make the change, dest to let later policies do more processing; such as EC sensitive attribute documentation.</comment>
							<conditions>
								<or>
									<if-op-attr name="abcTrainingAwarenessCompleted" op="changing"/>
									<if-op-attr name="abcTrainingEnhancedCompleted" op="changing"/>
									<if-op-property mode="nocase" name="checkECTrainingDates" op="equal">TRUE</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="abcLevelOfECTraining" scope="policy">
									<arg-string>
										<token-attr name="abcLevelOfECTraining"/>
									</arg-string>
								</do-set-local-variable>
								<do-clear-src-attr-value class-name="User" name="abcLevelOfECTraining"/>
								<do-clear-src-attr-value class-name="User" name="abcTrainingLastCompleted"/>
								<do-set-local-variable name="lv-today" scope="policy">
									<arg-string>
										<token-time format="yyyyMMdd"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-attr name="abcTrainingAwarenessCompleted" op="available"/>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lv-awareness-expired-date" scope="policy">
											<arg-string>
												<token-convert-time dest-format="yyyyMMdd" dest-tz="UTC" offset="$TrainingLifetimeAwareness$" offset-unit="day" src-format="yyyy-MM-dd">
													<token-attr name="abcTrainingAwarenessCompleted"/>
												</token-convert-time>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="lv-awareness-expired-date" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">0</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-attr name="abcTrainingEnhancedCompleted" op="available"/>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lv-enhanced-expired-date" scope="policy">
											<arg-string>
												<token-convert-time dest-format="yyyyMMdd" dest-tz="UTC" offset="$TrainingLifetimeEnhanced$" offset-unit="day" src-format="yyyy-MM-dd">
													<token-attr name="abcTrainingEnhancedCompleted"/>
												</token-convert-time>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="lv-enhanced-expired-date" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">0</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<or>
											<if-local-variable mode="nocase" name="lv-enhanced-expired-date" op="lt">$lv-today$</if-local-variable>
											<if-local-variable mode="nocase" name="lv-enhnaced-expired-date" op="equal">$lv-today$</if-local-variable>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lv-enhanced-expired" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">TRUE</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="lv-enhanced-expired" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<or>
											<if-local-variable mode="nocase" name="lv-awareness-expired-date" op="lt">$lv-today$</if-local-variable>
											<if-local-variable mode="nocase" name="lv-awareness-expired-date" op="equal">$lv-today$</if-local-variable>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lv-awareness-expired" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">TRUE</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="lv-awareness-expired" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="nocase" name="lv-enhanced-expired" op="not-equal">TRUE</if-local-variable>
											<if-local-variable mode="regex" name="lv-enhanced-expired-date" op="not-equal">^$</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="abcLevelOfECTraining">
											<arg-value type="string">
												<token-text xml:space="preserve">Enhanced</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value class-name="User" name="abcLevelOfECTraining">
											<arg-dn>
												<token-src-dn/>
											</arg-dn>
											<arg-value type="string">
												<token-text xml:space="preserve">Enhanced</token-text>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value class-name="User" name="abcTrainingLastCompleted">
											<arg-value type="string">
												<token-attr name="abcTrainingEnhancedCompleted"/>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value class-name="User" name="abcTrainingLastCompleted">
											<arg-dn>
												<token-src-dn/>
											</arg-dn>
											<arg-value type="string">
												<token-attr name="abcTrainingEnhancedCompleted"/>
											</arg-value>
										</do-set-dest-attr-value>
									</arg-actions>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-local-variable mode="nocase" name="lv-awareness-expired" op="not-equal">TRUE</if-local-variable>
													<if-local-variable mode="regex" name="lv-awareness-expired-date" op="not-equal">^$</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-src-attr-value class-name="User" name="abcLevelOfECTraining">
													<arg-value type="string">
														<token-text xml:space="preserve">Awareness</token-text>
													</arg-value>
												</do-set-src-attr-value>
												<do-set-dest-attr-value class-name="User" name="abcLevelOfECTraining">
													<arg-dn>
														<token-src-dn/>
													</arg-dn>
													<arg-value type="string">
														<token-text xml:space="preserve">Awareness</token-text>
													</arg-value>
												</do-set-dest-attr-value>
												<do-set-src-attr-value class-name="User" name="abcTrainingLastCompleted">
													<arg-value type="string">
														<token-attr name="abcTrainingAwarenessCompleted"/>
													</arg-value>
												</do-set-src-attr-value>
												<do-set-dest-attr-value class-name="User" name="abcTrainingLastCompleted">
													<arg-dn>
														<token-src-dn/>
													</arg-dn>
													<arg-value type="string">
														<token-attr name="abcTrainingAwarenessCompleted"/>
													</arg-value>
												</do-set-dest-attr-value>
											</arg-actions>
											<arg-actions>
												<do-clear-src-attr-value class-name="User" name="abcLevelOfECTraining"/>
												<do-clear-dest-attr-value class-name="User" name="abcLevelOfECTraining">
													<arg-dn>
														<token-src-dn/>
													</arg-dn>
												</do-clear-dest-attr-value>
												<do-clear-src-attr-value class-name="User" name="abcTrainingLastCompleted"/>
												<do-clear-dest-attr-value class-name="User" name="abcTrainingLastCompleted">
													<arg-dn>
														<token-src-dn/>
													</arg-dn>
												</do-clear-dest-attr-value>
											</arg-actions>
										</do-if>
									</arg-actions>
								</do-if>
								<do-set-local-variable name="NewabcLevelOfECTraining" scope="policy">
									<arg-string>
										<token-op-attr name="abcLevelOfECTraining"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">$abcLevelOfECTraining = $NewabcLevelOfECTraining</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcLevelOfECTraining"/>
									</arg-actions>
								</do-if>
								<do-clone-xpath dest-expression="../modify" src-expression="@src-dn"/>
								<do-if>
									<arg-conditions>
										<and>
											<if-operation mode="nocase" op="equal">trigger</if-operation>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Trigger work complete now veto</token-text>
											</arg-string>
										</do-trace-message>
										<do-veto/>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Compute: Override legal entity attribute updates</description>
							<comment xml:space="preserve">Legal entity override values are written to history and then cleared on terms and bu changes.</comment>
							<conditions>
								<and>
									<if-op-attr name="abcBusLevel2Code" op="changing"/>
									<if-op-attr mode="regex" name="abcBusLevel2Code" op="not-equal">^$</if-op-attr>
								</and>
							</conditions>
							<actions>
								<do-set-op-property name="ClearOverrideLegalEntityAttrs">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-op-property>
							</actions>
						</rule>
						<rule>
							<description>Map abcBusLevel2Code to the friendly name for abcGreenlnkADcompany &amp; abcECASBU</description>
							<comment xml:space="preserve">Note: see how src and dest attrs are set: src to actually make the change, dest to let later policies do more processing; such as EC sensitive attribute documentation.</comment>
							<conditions>
								<and>
									<if-op-attr mode="regex" name="abcBusLevel2Code" op="changing-to">.+</if-op-attr>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="originalValue" scope="policy">
									<arg-string>
										<token-op-attr name="abcBusLevel2Code"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-dest-attr-value class-name="User" name="abcECASBU">
									<arg-value type="string">
										<token-map default-value="Other" dest="abcECASBU" src="abcBusLevel2Code" table="..\..\Manual-Lookup-Tables\BL2 to BU/GLcompany">
											<token-local-variable name="originalValue"/>
										</token-map>
									</arg-value>
								</do-set-dest-attr-value>
								<do-set-src-attr-value class-name="User" name="abcECASBU">
									<arg-value type="string">
										<token-map default-value="Other" dest="abcECASBU" src="abcBusLevel2Code" table="..\..\Manual-Lookup-Tables\BL2 to BU/GLcompany">
											<token-local-variable name="originalValue"/>
										</token-map>
									</arg-value>
								</do-set-src-attr-value>
								<do-strip-op-attr name="abcECASBU"/>
								<do-set-local-variable name="prevabcECASBU" scope="policy">
									<arg-string>
										<token-src-attr class-name="User" name="abcECASBU"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="newabcECASBU" scope="policy">
									<arg-string>
										<token-op-attr name="abcECASBU"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-attr mode="regex" name="abcBusLevel2Code" op="equal">Qatar.+</if-attr>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lv.domainCoAttr" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">abcQuartzlnkADcompany</token-text>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="lv.domainObjCl" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">abcQuartzlnk</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="lv.domainCoAttr" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">abcGreenlnkADcompany</token-text>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="lv.domainObjCl" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">abcGreenlnk</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-strip-op-attr name="$lv.domainCoAttr$"/>
								<do-add-src-attr-value name="Object Class">
									<arg-value type="string">
										<token-local-variable name="lv.domainObjCl"/>
									</arg-value>
								</do-add-src-attr-value>
								<do-add-dest-attr-value name="Object Class">
									<arg-value type="string">
										<token-local-variable name="lv.domainObjCl"/>
									</arg-value>
								</do-add-dest-attr-value>
								<do-set-src-attr-value class-name="$lv.domainObjCl$" name="$lv.domainCoAttr$">
									<arg-value type="string">
										<token-map default-value="Other" dest="abcADcompany" src="abcBusLevel2Code" table="..\..\Manual-Lookup-Tables\BL2 to BU/GLcompany">
											<token-local-variable name="originalValue"/>
										</token-map>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="$lv.domainObjCl$" name="$lv.domainCoAttr$">
									<arg-value type="string">
										<token-map default-value="Other" dest="abcADcompany" src="abcBusLevel2Code" table="..\..\Manual-Lookup-Tables\BL2 to BU/GLcompany">
											<token-local-variable name="originalValue"/>
										</token-map>
									</arg-value>
								</do-set-dest-attr-value>
								<do-set-op-property name="clearPeopleLists">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-op-property>
							</actions>
						</rule>
						<rule>
							<description>ClearPeopleLists on bu change or terminate - ECR193</description>
							<comment xml:space="preserve">All the people group memberships need to be removed on this user</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="clearPeopleLists" op="equal">TRUE</if-op-property>
									<if-operation mode="nocase" op="not-equal">add</if-operation>
									<if-local-variable mode="nocase" name="prevabcECASBU" op="not-equal">$newabcECASBU$</if-local-variable>
								</and>
								<and>
									<if-op-property mode="nocase" name="containsTermination" op="equal">TRUE</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-trace-message disabled="true" level="6">
									<arg-string>
										<token-text xml:space="preserve">COMMENT Setup the variables for the query.</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="currentUserDnLDAP" notrace="true" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="filter" notrace="true" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">(&amp;(objectClass=groupOfNames)(abcASListType=person)(member=</token-text>
										<token-local-variable name="currentUserDnLDAP"/>
										<token-text xml:space="preserve">))</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message disabled="true" level="6">
									<arg-string>
										<token-text xml:space="preserve">COMMENT Query eDir for all instances where this user is a member of a group in the lists OU.</token-text>
									</arg-string>
								</do-trace-message>
								<do-if>
									<arg-conditions>
										<and>
											<if-op-property mode="nocase" name="containsTermination" op="equal">TRUE</if-op-property>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="logEntry" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">Start - Query for all the people list groups where this user is a member and remove the memberships. (abcECASBU change).</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="logEntry" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">Start - Query for all the people list groups where this user is a member and remove the memberships. (Termination).</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-trace-message level="6">
									<arg-string>
										<token-local-variable name="logEntry"/>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="userResults" scope="policy">
									<arg-node-set>
										<token-xpath expression="es:ldapSearch($drvHostPort, 'true', $userDN, $driver.serviceaccount.password, '~PEOPLE_LISTS_OU~', 'sub', $filter, 'member')"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-trace-message disabled="true" level="6">
									<arg-string>
										<token-text xml:space="preserve">COMMENT Query eDir for all instances where this user is a member of a group in the lists OU.</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="debug" scope="policy">
									<arg-string>
										<token-xpath expression="es:serialize($userResults)"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="regex" name="debug" op="equal">.*level="error".*</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">ERROR: The query to find people groups for this user has failed!</token-text>
											</arg-string>
										</do-trace-message>
										<do-break/>
									</arg-actions>
									<arg-actions/>
								</do-if>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">Loop over the results where members need to be removed.</token-text>
									</arg-string>
								</do-trace-message>
								<do-for-each>
									<arg-node-set>
										<token-local-variable name="userResults"/>
									</arg-node-set>
									<arg-actions>
										<do-trace-message disabled="true" level="6">
											<arg-string>
												<token-text xml:space="preserve">Inside people membership removal - currentNode: (</token-text>
												<token-xpath expression="$current-node/@src-dn"/>
												<token-text xml:space="preserve">)</token-text>
											</arg-string>
										</do-trace-message>
										<do-remove-src-attr-value class-name="Group" name="Member">
											<arg-dn>
												<token-parse-dn dest-dn-format="slash" src-dn-format="ldap">
													<token-xpath expression="$current-node/@src-dn"/>
												</token-parse-dn>
											</arg-dn>
											<arg-value type="string">
												<token-parse-dn dest-dn-format="slash" src-dn-format="ldap">
													<token-local-variable name="currentUserDnLDAP"/>
												</token-parse-dn>
											</arg-value>
										</do-remove-src-attr-value>
									</arg-actions>
								</do-for-each>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">END - Loop over the results where members need to be removed.</token-text>
									</arg-string>
								</do-trace-message>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-DACUserTerminated">
					<policy>
						<rule disabled="true">
							<description>abcLastDayWorked changing</description>
							<comment xml:space="preserve">If abcLastDayWorked is changing, but not being cleared, send out an email notification.

ACs 3.2.2 and 3.2.3 dealing with DAC User Terminations are retired. This policy is now disabled.</comment>
							<conditions>
								<and>
									<if-op-attr name="abcLastWorkingDay" op="changing"/>
									<if-op-attr mode="nocase" name="abcLastWorkingDay" op="not-changing-to"/>
									<if-attr mode="src-dn" name="Group Membership" op="equal">abcS\Groups\DAC</if-attr>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lv-user-dn" scope="policy">
									<arg-string>
										<token-src-dn/>
									</arg-string>
								</do-set-local-variable>
								<do-send-email-from-template notification-dn="Security\Default Notification Collection" template-dn="Security\Default Notification Collection\abcS-SD-DAC User Terminated">
									<arg-string name="to">
										<token-global-variable name="EMAIL_SME"/>
									</arg-string>
									<arg-string name="user_dn">
										<token-parse-dn dest-dn-format="src-dn" length="1" start="-1">
											<token-local-variable name="lv-user-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-send-email-from-template>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-DefaultAttrs">
					<policy>
						<rule>
							<description>Disable all new users</description>
							<comment xml:space="preserve">Users don't directly log into the tree, so we'll disable their login now.</comment>
							<conditions>
								<and>
									<if-operation mode="nocase" op="equal">add</if-operation>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-set-src-attr-value class-name="User" name="Login Disabled">
									<arg-value type="string">
										<token-text xml:space="preserve">true</token-text>
									</arg-value>
								</do-set-src-attr-value>
							</actions>
						</rule>
						<rule>
							<description>Set create date on users and licences.</description>
							<comment xml:space="preserve">When users or licences are created in the tree, mark the create date.</comment>
							<conditions>
								<and>
									<if-operation mode="nocase" op="equal">add</if-operation>
								</and>
							</conditions>
							<actions>
								<do-set-src-attr-value class-name="User" name="abcIDVCreateDate">
									<arg-value type="string">
										<token-time format="yyyy-MM-dd'T'HH:mm:ssXXX"/>
									</arg-value>
								</do-set-src-attr-value>
							</actions>
						</rule>
						<rule>
							<description>Set a default last working day</description>
							<comment xml:space="preserve">2018-10-15: Defect 244 part b: if LWD comes in as a blank element, or isn't provided, we'll interpret it as a default value of 9999-12-31.

This ensures that LWD is always seen in the future when not provided; while this policy does fire very often; it only takes 6 milliseconds on a realtively slow server (VMWare)</comment>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
									<if-operation mode="regex" op="equal">add|modify</if-operation>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="not-equal">TRUE</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lastWorkingDay" scope="policy">
									<arg-string>
										<token-replace-all regex=" " replace-with="">
											<token-attr name="abcLastWorkingDay"/>
										</token-replace-all>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($lastWorkingDay) = 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcLastWorkingDay"/>
										<do-set-dest-attr-value class-name="User" name="abcLastWorkingDay">
											<arg-value type="string">
												<token-text xml:space="preserve">9999-12-31</token-text>
											</arg-value>
										</do-set-dest-attr-value>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Set a default last working day - KSA-SAP</description>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="equal">TRUE</if-op-property>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
									<if-operation mode="regex" op="equal">add|modify</if-operation>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lastWorkingDay" scope="policy">
									<arg-string>
										<token-replace-all regex=" " replace-with="">
											<token-attr name="abcSAPKSALastWorkingDay"/>
										</token-replace-all>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($lastWorkingDay) = 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcSAPKSALastWorkingDay"/>
										<do-set-dest-attr-value class-name="User" name="abcSAPKSALastWorkingDay">
											<arg-value type="string">
												<token-text xml:space="preserve">9999-12-31</token-text>
											</arg-value>
										</do-set-dest-attr-value>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-DirectReportInitilization">
					<policy>
						<rule>
							<description>Initial population of direct reports</description>
							<comment xml:space="preserve">We delete and re-add the manager to trigger the reciprocal config that now exists in the driver. This filter should get removed after the change.</comment>
							<conditions>
								<and>
									<if-op-attr mode="nocase" name="carLicense" op="changing-to">PopulateDirectReports</if-op-attr>
									<if-attr name="manager" op="available"/>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="managerDN" scope="policy">
									<arg-string>
										<token-attr name="manager"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-src-attr-value class-name="User" name="manager">
									<arg-value type="string">
										<token-local-variable name="managerDN"/>
									</arg-value>
								</do-set-src-attr-value>
								<do-clear-src-attr-value class-name="User" name="carLicense"/>
								<do-set-src-attr-value class-name="User" name="abcManagerSFEmail">
									<arg-value type="string">
										<token-query class-name="User" datastore="src" max-result-count="1" scope="entry">
											<arg-dn>
												<token-local-variable name="managerDN"/>
											</arg-dn>
											<arg-string>
												<token-text xml:space="preserve">abcSFEmailAddress</token-text>
											</arg-string>
										</token-query>
									</arg-value>
								</do-set-src-attr-value>
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-EnforceValidUserDeletionDates">
					<policy>
						<rule>
							<description>Break if abcUserDeletionDate isn't changing.</description>
							<conditions>
								<and>
									<if-op-attr name="abcUserDeletionDate" op="not-changing"/>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>abcUserDeletionDate: Set variables.</description>
							<conditions/>
							<actions>
								<do-set-local-variable name="deleteDate" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" dest-tz="GMT" src-format="yyyy-MM-dd" src-tz="GMT">
											<token-op-attr name="abcUserDeletionDate"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="deleteDateMax" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" dest-tz="GMT" src-format="yyyy-MM-dd" src-tz="GMT">
											<token-attr name="abcUserMaximumDeletionDate"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="deleteDateMin" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" dest-tz="GMT" src-format="yyyy-MM-dd" src-tz="GMT">
											<token-attr name="abcUserMinimumDeletionDate"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>abcUserDeletionDate: Keep less than abcUserMaximumDeletionDate</description>
							<conditions>
								<and>
									<if-xpath op="true">$deleteDate &gt; $deleteDateMax</if-xpath>
								</and>
							</conditions>
							<actions>
								<do-set-src-attr-value class-name="User" name="abcUserDeletionDate">
									<arg-value type="string">
										<token-attr name="abcUserMaximumDeletionDate"/>
									</arg-value>
								</do-set-src-attr-value>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>abcUserDeletionDate: Keep greater than abcUserMinimumDeletionDate</description>
							<conditions>
								<and>
									<if-xpath op="true">$deleteDate &lt; $deleteDateMin</if-xpath>
								</and>
							</conditions>
							<actions>
								<do-set-src-attr-value class-name="User" name="abcUserDeletionDate">
									<arg-value type="string">
										<token-attr name="abcUserMinimumDeletionDate"/>
									</arg-value>
								</do-set-src-attr-value>
								<do-break/>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-Jobs">
					<policy xmlns:dxcmd="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.util.DxCommand">
						<description>Policy runs both triggers:

 - The -Schedule Jobs fire on schedule:
 	- Job updates memberquery URL for the scope on the second job.
 	- Starts the second job.
 	 Note: drvHostPort is set to drvServiceHost:drvServicePort that were determined dynamically at driver startup.

2021-03-23 - Disable Jog-GLAccountExpires-Schedule, and Do the work: Trigger: Job-GLAccountExpires as requested.</description>
						<rule>
							<description>Break if not Trigger event</description>
							<conditions>
								<and>
									<if-operation mode="nocase" op="not-equal">trigger</if-operation>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Setup SSL settings.</description>
							<conditions>
								<or/>
							</conditions>
							<actions>
								<do-set-local-variable name="sslDesignator">
									<arg-string>
										<token-text xml:space="preserve"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-global-variable mode="nocase" name="gcvUseSSL" op="equal">true</if-global-variable>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="sslDesignator">
											<arg-string>
												<token-text xml:space="preserve">s</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>All triggers: initialize.</description>
							<comment xml:space="preserve">All jobs need similar configuration; set them up now.
Note: the now minus 344 is to notify some one 21 days before their yearly expiration of their training (365 - 21).</comment>
							<conditions>
								<or>
									<if-op-property mode="nocase" name="source" op="equal">Job-ECTrainingExpires-AttrUpdate-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-ECTrainingExpires-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-DeleteOldUsers-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-SecondmentExpires-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-LWDCheck-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-ManagerUpdate-MWFID-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-GLAccountExpires-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-StartToday-Schedule</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="lvLdapTimeZoneDiff" scope="policy">
									<arg-string>
										<token-convert-time dest-format="Z" src-format="yyyyMMdd">
											<token-time format="yyyyMMdd"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvDateNow" scope="policy">
									<arg-string>
										<token-time format="yyyy-MM-dd"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message disabled="true" level="0">
									<arg-string>
										<token-text xml:space="preserve">Logic for the Enhanced Training notification date below:
 - Enhanced Training is expired after 1 year.
 - To find accounts with the Enhanced Training expiring today, take todays date and subtract 365 days (-365).
 - The notificaiton gets sent BEFORE the expiration, so we add 21 days to the date to find those accounts that will expire in 21 days. (+21)
 - The number of days for the advanced notice is a GCV.

So today -365 + 21 gives the enhanced training notificaiton date.</token-text>
									</arg-string>
								</do-trace-message>
								<do-trace-message level="0">
									<arg-string>
										<token-text xml:space="preserve">EnhancedExpirationLogging 1</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="lvEnhancedExpirationNotificationDate" scope="policy">
									<arg-string>
										<token-convert-time dest-format="yyyy-MM-dd" offset="$DaysBeforeEnhancedExpirationForNotification$" offset-unit="day" src-format="yyyy-MM-dd">
											<token-convert-time dest-format="yyyy-MM-dd" offset="-$TrainingLifetimeEnhanced$" offset-unit="day" src-format="yyyy-MM-dd">
												<token-time format="yyyy-MM-dd"/>
											</token-convert-time>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvNowLdapTime" scope="policy">
									<arg-string>
										<token-local-variable name="lvDateNow"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvServiceAccountLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~driver.serviceaccount~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Specific trigger config: Job-ECTrainingExpires-AttrUpdate-Schedule</description>
							<comment xml:space="preserve">Update our scope date, set the job's scope and re-trigger this job; though this time with a scope. The first time the trigger is sent, no scope is available, so it will be only a single trigger event, and not have any source DN.

Note: we have to set an op-property of startjob, then pick it up in the next policy so that the DirXML-Scope event actually gets written.  when="direct" isn't working on a do-set-src-attr; so we have a timing issue.  We force the DirXML-Scope to be written out by moving the job update and start to a new policy.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-ECTrainingExpires-AttrUpdate-Schedule</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-trace-message level="0">
									<arg-string>
										<token-text xml:space="preserve">EnhancedExpirationAttrUpdateLogging 2</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="enhancedExpirationDate" scope="policy">
									<arg-string>
										<token-convert-time dest-format="yyyy-MM-dd" offset="-$TrainingLifetimeEnhanced$" offset-unit="day" src-format="yyyy-MM-dd">
											<token-local-variable name="lvDateNow"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="awarenessExpirationDate" scope="policy">
									<arg-string>
										<token-convert-time dest-format="yyyy-MM-dd" offset="-$TrainingLifetimeAwareness$" offset-unit="day" src-format="yyyy-MM-dd">
											<token-local-variable name="lvDateNow"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvLdapFilter" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap$sslDesignator$:///</token-text>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~idv.dit.data.users~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
										<token-text xml:space="preserve">??sub?(&amp;(objectClass=User)(|(&amp;(&amp;(|(!(abcTrainingAwarenessCompleted=*))(abcTrainingAwarenessCompleted&lt;=</token-text>
										<token-local-variable name="awarenessExpirationDate"/>
										<token-text xml:space="preserve">))(|(!(abcTrainingEnhancedCompleted=*))(abcTrainingEnhancedCompleted&lt;=</token-text>
										<token-local-variable name="enhancedExpirationDate"/>
										<token-text xml:space="preserve">)))(|(abcTrainingLastCompleted=*)(abcLevelOfECTraining=*)))(&amp;(&amp;(abcTrainingAwarenessCompleted=*)(!(abcTrainingAwarenessCompleted&lt;=</token-text>
										<token-local-variable name="awarenessExpirationDate"/>
										<token-text xml:space="preserve">))(|(!(abcTrainingEnhancedCompleted=*))(abcTrainingEnhancedCompleted&lt;=</token-text>
										<token-local-variable name="enhancedExpirationDate"/>
										<token-text xml:space="preserve">)))(|(!(abcLevelOfECTraining=Awareness))))(&amp;(&amp;(abcTrainingEnhancedCompleted=*)(!(abcTrainingEnhancedCompleted&lt;=</token-text>
										<token-local-variable name="enhancedExpirationDate"/>
										<token-text xml:space="preserve">)))(|(!(abcLevelOfECTraining=Enhanced))))))</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvServiceGroupLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dg-expired-ectraining-attr-update-group~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dirxml.auto.driverdn~\Job-ECTrainingExpires-AttrUpdate', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobDotDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="dirxml.auto.driverdn"/>
											<token-text xml:space="preserve">\Job-ECTrainingExpires-AttrUpdate</token-text>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Specific trigger config: Job-ECTrainingExpires-Schedule</description>
							<comment xml:space="preserve">Update our scope date, set the job's scope and re-trigger this job; though this time with a scope. The first time the trigger is sent, no scope is available, so it will be only a single trigger event, and not have any source DN.

Note: we have to set an op-property of startjob, then pick it up in the next policy so that the DirXML-Scope event actually gets written.  when="direct" isn't working on a do-set-src-attr; so we have a timing issue.  We force the DirXML-Scope to be written out by moving the job update and start to a new policy.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-ECTrainingExpires-Schedule</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-trace-message level="0">
									<arg-string>
										<token-text xml:space="preserve">EnhancedExpirationLogging 2</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="lvLdapFilter" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap$sslDesignator$:///</token-text>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~idv.dit.data.users~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
										<token-text xml:space="preserve">??sub?(&amp;(objectClass=User)(abcTrainingEnhancedCompleted=</token-text>
										<token-local-variable name="lvEnhancedExpirationNotificationDate"/>
										<token-text xml:space="preserve">))</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvServiceGroupLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dg-expired-ectraining-group~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dirxml.auto.driverdn~\Job-ECTrainingExpires', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobDotDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="dirxml.auto.driverdn"/>
											<token-text xml:space="preserve">\Job-ECTrainingExpires</token-text>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Specific trigger config: Job-DeleteOldUsers-Schedule</description>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-DeleteOldUsers-Schedule</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lvLdapFilter" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap$sslDesignator$:///</token-text>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~idv.dit.data.users~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
										<token-text xml:space="preserve">??sub?(&amp;(objectClass=User)(abcUserDeletionDate&lt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">))</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvServiceGroupLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dg-users-to-delete-group~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dirxml.auto.driverdn~\Job-DeleteOldUsers', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobDotDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="dirxml.auto.driverdn"/>
											<token-text xml:space="preserve">\Job-DeleteOldUsers</token-text>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Specific trigger config: Job-SecondmentExpires-Schedule</description>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-SecondmentExpires-Schedule</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lvLdapFilter" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap$sslDesignator$:///</token-text>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~idv.dit.data.users~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
										<token-text xml:space="preserve">??sub?(&amp;(objectClass=abcPerson)(abcStartDateSec=*)(abcEndDateSec=*)(|(&amp;(|(abcSeconded=true)(!(abcSeconded=*)))(|(!(abcStartDateSec&lt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">))(!(abcEndDateSec&gt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">))))(&amp;(|(abcSeconded=false)(!(abcSeconded=*)))(&amp;(abcStartDateSec&lt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">)(abcEndDateSec&gt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">)))))</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvServiceGroupLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dg-secondment-to-check-group~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dirxml.auto.driverdn~\Job-SecondmentExpires', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobDotDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="dirxml.auto.driverdn"/>
											<token-text xml:space="preserve">\Job-SecondmentExpires</token-text>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Specific trigger config: Job-LWDCheck-Schedule</description>
							<comment xml:space="preserve">Note: LWD, by it's nature includes the date it has populated: in otherwords, if populated with 2018-05-15, this means that a user will still be able to work on 2018-05-15; so we need to subtract one day to account for this last working day, since LDAP filters are forced to be '&lt;=', and not just '&lt;'.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-LWDCheck-Schedule</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lvDateNow" scope="policy">
									<arg-string>
										<token-convert-time dest-format="yyyy-MM-dd" dest-tz="GMT" offset="-1" offset-unit="day" src-format="yyyy-MM-dd" src-tz="GMT">
											<token-local-variable name="lvNowLdapTime"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvLdapFilter" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap$sslDesignator$:///</token-text>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~idv.dit.data.users~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
										<token-text xml:space="preserve">??sub?(&amp;(objectClass=User)(|(&amp;(abcLastWorkingDay&lt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">)(!(abcSAPKSABusLevel2Code=KSA-SA)))(abcSAPKSALastWorkingDay&lt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">))(|(!(abcUserDeletionDate=*))(!(abcUserMaximumDeletionDate=*))(!(abcUserMinimumDeletionDate=*))))</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">Termination -  LDAP filter for the term:</token-text>
										<token-local-variable name="lvLdapFilter"/>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="lvServiceGroupLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dg-last-working-day-check-group~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dirxml.auto.driverdn~\Job-LWDCheck', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobDotDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="dirxml.auto.driverdn"/>
											<token-text xml:space="preserve">\Job-LWDCheck</token-text>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Specific trigger config: Job-ManagerUpdate-MWFID-Schedule</description>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-ManagerUpdate-MWFID-Schedule</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lvDateNow" scope="policy">
									<arg-string>
										<token-convert-time dest-format="yyyy-MM-dd" dest-tz="GMT" offset="-1" offset-unit="day" src-format="yyyy-MM-dd" src-tz="GMT">
											<token-local-variable name="lvNowLdapTime"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvLdapFilter" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap:///OU=Users,O=abcS??sub?</token-text>
										<token-text xml:space="preserve">(|
    (&amp;
        (!(manager=*))
        (managerWorkforceID=*)
        (objectClass=abcPerson)
    )
    (&amp;
        (!(abcSAPKSAManager=*))
        (abcSAPKSAManagerWorkforceID=*)
        (objectClass=abcSAPKSA)
    )
    (&amp;
        (!(manager=*))
        (abcSupervisorVRSID=*)
        (!(managerWorkforceID=*))
        (objectClass=abcPerson)
    )
)</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvServiceGroupLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dg-missing-manager-group-mwfid~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dirxml.auto.driverdn~\Job-ManagerUpdate-MWFID', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobDotDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="dirxml.auto.driverdn"/>
											<token-text xml:space="preserve">\Job-ManagerUpdate-MWFID</token-text>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Specific trigger config: Job-StartToday-Schedule (Fuse)</description>
							<comment xml:space="preserve">Note: Start date, by it's nature includes the date it has populated: in otherwords, if populated with 2018-05-15, this means that a user will still be able to work on 2018-05-15.

This job has two use cases when it fires. First time hires going into Fuse and rehires. This difference is demonstrated in the 2 part LDAP filter.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-StartToday-Schedule</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lvDateNow" scope="policy">
									<arg-string>
										<token-convert-time dest-format="yyyy-MM-dd" dest-tz="GMT" offset="-1" offset-unit="day" src-format="yyyy-MM-dd" src-tz="GMT">
											<token-local-variable name="lvNowLdapTime"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvLdapFilter" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap$sslDesignator$:///</token-text>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~idv.dit.data.users~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
										<token-text xml:space="preserve">??sub?</token-text>
										<token-text xml:space="preserve">(|</token-text>
										<token-text xml:space="preserve">(&amp;(objectClass=User)(abcCompanyStartDate&lt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">)(!(abcFuseID=*)))</token-text>
										<token-text xml:space="preserve">(&amp;(objectClass=User)(abcCompanyStartDate=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">)(abcFuseID=*))</token-text>
										<token-text xml:space="preserve">(&amp;(objectClass=User)(abcSAPKSACompanyStartDate&lt;=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">)(!(abcFuseID=*)))</token-text>
										<token-text xml:space="preserve">(&amp;(objectClass=User)(abcSAPKSACompanyStartDate=</token-text>
										<token-local-variable name="lvNowLdapTime"/>
										<token-text xml:space="preserve">)(abcFuseID=*))</token-text>
										<token-text xml:space="preserve">)</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">Filter for startToday job. Updated to also find rehired users where the startDate was moved into the future.</token-text>
										<token-local-variable name="lvLdapFilter"/>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="lvServiceGroupLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dg-start-today~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dirxml.auto.driverdn~\Job-StartToday', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobDotDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="dirxml.auto.driverdn"/>
											<token-text xml:space="preserve">\Job-StartToday</token-text>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule disabled="true">
							<description>Specific trigger config: Job-GLAccountExpires-Schedule</description>
							<comment xml:space="preserve">Note: LWD, by it's nature includes the date it has populated: in otherwords, if populated with 2018-05-15, this means that a user will still be able to work on 2018-05-15; so we need to subtract one day to account for this last working day, since LDAP filters are forced to be '&lt;=', and not just '&lt;'.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-GLAccountExpires-Schedule</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lvDateNowPlus21Days" scope="policy">
									<arg-string>
										<token-convert-time dest-format="yyyy-MM-dd" offset="21" offset-unit="day" src-format="yyyy-MM-dd">
											<token-local-variable name="lvNowLdapTime"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvDateNowPlus7Days" scope="policy">
									<arg-string>
										<token-convert-time dest-format="yyyy-MM-dd" offset="7" offset-unit="day" src-format="yyyy-MM-dd">
											<token-local-variable name="lvNowLdapTime"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvLdapFilter" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">ldap$sslDesignator$:///</token-text>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~idv.dit.data.users~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
										<token-text xml:space="preserve">??sub?(&amp;(objectClass=User)(|</token-text>
										<token-text xml:space="preserve">(abcGLAccountExpirationDate=</token-text>
										<token-local-variable name="lvDateNowPlus21Days"/>
										<token-text xml:space="preserve">)</token-text>
										<token-text xml:space="preserve">(abcGLAccountExpirationDate=</token-text>
										<token-local-variable name="lvDateNowPlus7Days"/>
										<token-text xml:space="preserve">)</token-text>
										<token-text xml:space="preserve">))</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvServiceGroupLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dg-gl-user-expire~', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobLdapDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="query:readObject($srcQueryProcessor, '', '~dirxml.auto.driverdn~\Job-GLAccountExpires', '', '')/@qualified-src-dn"/>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lvJobDotDn" scope="policy">
									<arg-string>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="dirxml.auto.driverdn"/>
											<token-text xml:space="preserve">\Job-GLAccountExpires</token-text>
										</token-parse-dn>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>All triggers: write the updated scope query, and run the real version of the job.</description>
							<conditions>
								<or>
									<if-op-property mode="nocase" name="source" op="equal">Job-ECTrainingExpires-AttrUpdate-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-ECTrainingExpires-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-DeleteOldUsers-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-SecondmentExpires-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-LWDCheck-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-ManagerUpdate-MWFID-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-GLAccountExpires-Schedule</if-op-property>
									<if-op-property mode="nocase" name="source" op="equal">Job-StartToday-Schedule</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="lvModifyFilterResult" scope="policy">
									<arg-string>
										<token-xpath expression="es:ldapModifyAttr($drvHostPort, '~gcvUseSSL~', $lvServiceAccountLdapDn, $driver.serviceaccount.password, $lvServiceGroupLdapDn, 'memberQueryURL', 'replace', $lvLdapFilter)"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">DEBUG: lvModifyFilterResult: '</token-text>
										<token-local-variable name="lvModifyFilterResult"/>
										<token-text xml:space="preserve">'</token-text>
									</arg-string>
								</do-trace-message>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="nocase" name="lvModifyFilterResult" op="not-equal">success</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lvErrorMsg" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">Update of service group filter failed: </token-text>
												<token-local-variable name="lvModifyFilterResult"/>
											</arg-string>
										</do-set-local-variable>
										<do-trace-message level="1">
											<arg-string>
												<token-text xml:space="preserve">ERROR: </token-text>
												<token-local-variable name="lvErrorMsg"/>
											</arg-string>
										</do-trace-message>
										<do-status level="fatal">
											<arg-string>
												<token-local-variable name="lvErrorMsg"/>
											</arg-string>
										</do-status>
									</arg-actions>
								</do-if>
								<do-set-local-variable name="lvDxcmdArgs" scope="policy">
									<arg-string>
										<token-text xml:space="preserve"> -host </token-text>
										<!-- token-global-variable name="gcvServiceHost"/ -->
										<token-local-variable name="drvServiceHost"/>
										<token-text xml:space="preserve"> -user </token-text>
										<token-parse-dn dest-dn-format="dot" src-dn-format="slash">
											<token-global-variable name="driver.serviceaccount"/>
										</token-parse-dn>
										<token-text xml:space="preserve"> -password </token-text>
										<token-local-variable name="driver.serviceaccount.password" notrace="true"/>
										<token-text xml:space="preserve"> -startjob '</token-text>
										<token-local-variable name="lvJobDotDn"/>
										<token-text xml:space="preserve">'</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message color="yellow">
									<arg-string>
										<token-text xml:space="preserve">lvDxcmdArgs: [</token-text>
										<token-local-variable name="lvDxcmdArgs"/>
										<token-text xml:space="preserve">]</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="lvDxcmdResult" scope="policy">
									<arg-string>
										<token-xpath expression="dxcmd:commandLine(string($lvDxcmdArgs))"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="1">
									<arg-string>
										<token-text xml:space="preserve">DXCMD return code: </token-text>
										<token-local-variable name="lvDxcmdResult"/>
									</arg-string>
								</do-trace-message>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">$lvDxcmdResult != 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="lvErrorMsg" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">DXCMD command -startjob for job </token-text>
												<token-local-variable name="lvJobDotDn"/>
												<token-text xml:space="preserve"> returned error code </token-text>
												<token-local-variable name="lvDxcmdResult"/>
											</arg-string>
										</do-set-local-variable>
										<do-trace-message level="1">
											<arg-string>
												<token-text xml:space="preserve">ERROR: </token-text>
												<token-local-variable name="lvErrorMsg"/>
											</arg-string>
										</do-trace-message>
										<do-status level="fatal">
											<arg-string>
												<token-text xml:space="preserve">Unable to start job </token-text>
												<token-local-variable name="lvJobDotDn"/>
												<token-text xml:space="preserve">': $lvErrorMsg$</token-text>
											</arg-string>
										</do-status>
									</arg-actions>
									<arg-actions>
										<do-trace-message>
											<arg-string>
												<token-text xml:space="preserve">DXCMD command -startjob for job </token-text>
												<token-local-variable name="lvJobDotDn"/>
												<token-text xml:space="preserve"> completed successfully</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
								</do-if>
								<do-veto/>
							</actions>
						</rule>
						<rule>
							<description>Do the work: Trigger: Job-ECTrainingExpires</description>
							<comment xml:space="preserve">Sent a warning email to the users's manager.

Note: On the manager GN and SN reading:
Note: we're forcing only 1 result in the query here; the check for a count of 2 is due to the &lt;query-token&gt; also handed back in the node set along with the &lt;instance&gt;
</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-ECTrainingExpires</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="toAddresses" scope="policy">
									<arg-string>
										<token-src-attr class-name="User" name="Internet EMail Address"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-attr name="abcManagerSFEmail" op="available"/>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="toAddresses" scope="policy">
											<arg-string>
												<token-local-variable name="toAddresses"/>
												<token-text xml:space="preserve">,</token-text>
												<token-attr name="abcManagerSFEmail"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-set-local-variable name="gnManager">
									<arg-string>
										<token-text xml:space="preserve">GIVEN NAME OF MANAGER NOT FOUND</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="snManager">
									<arg-string>
										<token-text xml:space="preserve">SURNAME OF MANAGER NOT FOUND</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="managerDNNodeSet" scope="policy">
									<arg-node-set>
										<token-query class-name="User" datastore="src" max-result-count="1">
											<arg-dn>
												<token-global-variable name="idv.dit.data.users"/>
											</arg-dn>
											<arg-match-attr name="abcGCINumber">
												<arg-value type="string">
													<token-attr name="managerWorkforceID"/>
												</arg-value>
											</arg-match-attr>
										</token-query>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($managerDNNodeSet) = 2</if-xpath>
											<if-xpath op="true">name($managerDNNodeSet[1]) = string('instance')</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message color="brpurple" level="0">
											<arg-string>
												<token-text xml:space="preserve">manager - success: Found manager by GCI number, Reading Given Name and Surname now . .</token-text>
											</arg-string>
										</do-trace-message>
										<do-set-local-variable name="managerDN">
											<arg-string>
												<token-xpath expression="$managerDNNodeSet[1]/@src-dn"/>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="gnManager">
											<arg-string>
												<token-src-attr name="Given Name">
													<arg-dn>
														<token-local-variable name="managerDN"/>
													</arg-dn>
												</token-src-attr>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="snManager">
											<arg-string>
												<token-src-attr name="Surname">
													<arg-dn>
														<token-local-variable name="managerDN"/>
													</arg-dn>
												</token-src-attr>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-send-email-from-template notification-dn="Security\Default Notification Collection" template-dn="Security\Default Notification Collection\abcS-SD-EC Training Expired for account">
									<arg-string name="to">
										<token-local-variable name="toAddresses"/>
									</arg-string>
									<arg-string name="EUID">
										<token-src-attr class-name="User" name="CN"/>
									</arg-string>
									<arg-string name="ec-training-expiration-date">
										<token-convert-time dest-format="yyyy-MM-dd" offset="1" offset-unit="year" src-format="yyyy-MM-dd">
											<token-attr name="abcTrainingEnhancedCompleted"/>
										</token-convert-time>
									</arg-string>
									<arg-string name="givenName">
										<token-src-attr class-name="User" name="Given Name"/>
									</arg-string>
									<arg-string name="givenName-Manager">
										<token-local-variable name="gnManager"/>
									</arg-string>
									<arg-string name="sn">
										<token-src-attr class-name="User" name="Surname"/>
									</arg-string>
									<arg-string name="sn-Manager">
										<token-local-variable name="snManager"/>
									</arg-string>
								</do-send-email-from-template>
								<do-veto/>
							</actions>
						</rule>
						<rule>
							<description>Do the work: Trigger: Job-ECTrainingExpires-AttrUpdate</description>
							<comment xml:space="preserve">Sent a warning email to the users's manager.

Note: On the manager GN and SN reading:
Note: we're forcing only 1 result in the query here; the check for a count of 2 is due to the &lt;query-token&gt; also handed back in the node set along with the &lt;instance&gt;
</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-ECTrainingExpires-AttrUpdate</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-trace-message level="0">
									<arg-string>
										<token-text xml:space="preserve">EnhancedExpirationAttrUpdateLogging 3</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-op-property name="checkECTrainingDates">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-op-property>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">Do not veto this since this needs to run through the ECTraining policies.</token-text>
									</arg-string>
								</do-trace-message>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Do the work: Trigger: Job-DeleteOldUsers</description>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-DeleteOldUsers</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-delete-src-object class-name="User"/>
								<do-set-op-property name="CreateWebAppObjectDeletedNotification">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-op-property>
								<do-trace-message disabled="true" level="6">
									<arg-string>
										<token-text xml:space="preserve">Must veto below after creating WebApp Deleted Object Notifications.</token-text>
									</arg-string>
								</do-trace-message>
								<do-veto disabled="true"/>
							</actions>
						</rule>
						<rule>
							<description>Do the work: Trigger: Job-SecondmentExpires</description>
							<comment xml:space="preserve">All of the secondment work is figured in a subsequent policy, so send a marker now to revisit the secondment config.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-SecondmentExpires</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-dest-attr-value class-name="User" name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">secondment</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-veto/>
							</actions>
						</rule>
						<rule>
							<description>Do the work: Trigger: Job-LWDCheck</description>
							<comment xml:space="preserve">All of the termination work is figured in a subsequent policy, so send a marker now.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-LWDCheck</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-dest-attr-value class-name="User" name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">terminate</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-veto/>
							</actions>
						</rule>
						<rule>
							<description>Do the work: Trigger: Job-ManagerUpdate-MWFID</description>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-ManagerUpdate-MWFID</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-dest-attr-value class-name="User" name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">UpdateManagerValuesMWFID</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-veto/>
							</actions>
						</rule>
						<rule>
							<description>Do the work: Trigger: Job-StartToday (Fuse)</description>
							<comment xml:space="preserve">All of the create logic is figured in a subsequent policy, so send a marker now.
</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-StartToday</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-src-attr-value class-name="User" name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">syncFuse</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-veto/>
							</actions>
						</rule>
						<rule disabled="true">
							<description>Do the work: Trigger: Job-GLAccountExpires</description>
							<comment xml:space="preserve">Send the email for the user: note: AC 5.7 and 5.8 differ only in the 21 and 7 day; so this trigger is only sent for users where their expire date is 21 days and 7 days in the future. </comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="source" op="equal">Job-GLAccountExpires</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="abcGLAccountExpiresCTIME" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" dest-tz="UTC" src-format="yyyy-MM-dd">
											<token-attr name="abcGLAccountExpirationDate"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable disabled="true" name="nowPlus7Days" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" dest-tz="UTC" offset="7" offset-unit="day" src-format="!CTIME" src-tz="UTC">
											<token-time format="!CTIME" tz="UTC"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-if disabled="true">
									<arg-conditions>
										<and>
											<if-local-variable mode="numeric" name="abcGLAccountExpiresCTIME" op="lt">$nowPlus7Days$</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="expiringInMsg" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">less than 7 days</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="expiringInMsg" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">less than 21 days</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<or>
											<if-attr name="abcManagerSFEmail" op="available"/>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="toAddresses" scope="policy">
											<arg-string>
												<token-local-variable name="toAddresses"/>
												<token-text xml:space="preserve">,</token-text>
												<token-attr name="abcManagerSFEmail"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-send-email-from-template notification-dn="Security\Default Notification Collection" template-dn="Security\Default Notification Collection\abcS-SD-GL Account Expiring">
									<arg-string name="to">
										<token-attr name="Internet EMail Address"/>
										<token-local-variable name="toAddresses"/>
									</arg-string>
									<arg-string name="sAMAccountName">
										<token-src-attr class-name="User" name="DirXML-ADAliasName"/>
									</arg-string>
									<arg-string name="glAccountExpiresDate">
										<token-src-attr class-name="User" name="abcGLAccountExpirationDate"/>
									</arg-string>
								</do-send-email-from-template>
								<do-veto/>
							</actions>
						</rule>
						<rule>
							<description>KEEP THESE RULES LAST FOR DELETION NOTIFICATIONS - Create WebApp Deleted Object Notification if needed</description>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="CreateWebAppObjectDeletedNotification" op="not-equal">TRUE</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<include name="sub-etp-WebAppObjectDeletedNotification"/>
					</policy>
				</rule>
                <rule name="sub-etp-JobsFinal">
					<policy>
						<rule>
							<description>Break if not Trigger event</description>
							<conditions>
								<or>
									<if-operation mode="nocase" op="not-equal">trigger</if-operation>
									<if-op-property mode="nocase" name="checkECTrainingDates" op="equal">TRUE</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Job processing complete. Veto any additional triggers.</description>
							<conditions/>
							<actions>
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-JobsSetUserType">
					<policy>
						<rule>
							<description>Break if not user</description>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break if User Type already calculated</description>
							<comment xml:space="preserve">The User Type calculation is done in the beginning of the driver. If an event reaches this point and hasn't had UserType calculated it is because it was a job event that started as a trigger. When that happens, the event starts here. The User Type calculation is required.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="UserTypeCalcComplete" op="equal">TRUE</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">User type already calculated. Breaking...</token-text>
									</arg-string>
								</do-trace-message>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Calculate the User Type</description>
							<conditions/>
							<actions>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">User Type not yet calculated. Calculating now...</token-text>
									</arg-string>
								</do-trace-message>
							</actions>
						</rule>
						<include name="..\lib-UserType"/>
					</policy>
				</rule>
                <rule name="sub-etp-Job-UpdateTables">
					<policy xmlns:hashmap="http://www.novell.com/nxsl/java/java.util.HashMap">
						<rule>
							<description>Populate HRDS sourced tables</description>
							<comment xml:space="preserve">XPATH notes: The structure of hte XML's will always be a top root node, then all child nodes will be each of the records, as follows:

&lt;DocumentElement&gt;
         &lt;ORG_GROUP&gt;
                &lt;Effective_From&gt;19000101T00:00:00+00:00&lt;/Effective_From&gt;
                &lt;Enterprise_Code&gt;abcS&lt;/Enterprise_Code&gt;
                &lt;Group_Code&gt;CHO&lt;/Group_Code&gt;
                &lt;Date_Created&gt;20151109T14:45:43+00:00&lt;/Date_Created&gt;
                &lt;Date_Modified&gt;20160223T21:42:15+00:00&lt;/Date_Modified&gt;
                &lt;Effective_To&gt;99991231T00:00:00+00:00&lt;/Effective_To&gt;
                &lt;Group_Description&gt;Corporate Head Office&lt;/Group_Description&gt;
        &lt;/ORG_GROUP&gt;
        .
        .
        .
&lt;/DocumentElement&gt;

XPath statement descriptions:
XPath statement: $resultXML/*/*/*: equivalent to /root-node/record-node/record-child-nodes, or /DocumentElement/ORG_GROUP/(child nodes) above - Gets all records child tags; this allows us to collect all possible column definitions; and removes duplicates as it stores them.
	 - Note that we have two conditions before adding entries to the table headers: The field can't be ignored, and it can't already be in the headers list.
The XPath statement: $resultXML/*/* - then loops through all of the records (ORG_GROUP) to create row elements, then uses $current-node/* to loop through each ORG_GROUP children item and create col elements.
The policy ends by serializing the XML from the variable back into raw text, base64 encodes it, and writes it into the tree, effectively updating the IDM lookup table. We also ignore a set fixed set of fields, hardcoded into the ignoreFields nodeset.

</comment>
							<conditions>
								<and>
									<if-operation mode="nocase" op="equal">trigger</if-operation>
									<if-xpath op="true">operation-data[@source='Job-UpdateTables']</if-xpath>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="hrdsTableIndex" notrace="true" scope="driver">
									<arg-node-set>
										<token-document>
											<arg-string>
												<token-text xml:space="preserve">vnd.nds.stream:/</token-text>
												<token-replace-all regex="\\" replace-with="/">
													<token-parse-dn dest-dn-format="dest-dn" length="-2" src-dn-format="dest-dn">
														<token-global-variable name="dirxml.auto.driverdn"/>
													</token-parse-dn>
												</token-replace-all>
												<token-text xml:space="preserve">/Operational-Data/HRDS Mapping Table Index</token-text>
												<token-text xml:space="preserve">#DirXML-Data</token-text>
											</arg-string>
										</token-document>
									</arg-node-set>
								</do-set-local-variable>
								<do-set-local-variable name="totalRowsFound" scope="policy">
									<arg-string>
										<token-xpath expression="count($hrdsTableIndex/mapping-table/row)"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="totalEnabledRowsFound" scope="policy">
									<arg-string>
										<token-xpath expression="count($hrdsTableIndex/mapping-table/row[col[position() = 1]/text()='1'])"/>
									</arg-string>
								</do-set-local-variable>
								<!-- 				<?xml version="1.0" encoding="UTF-8"?><mapping-table>	<col-def name="EnableStatus" type="nocase"/>	<col-def name="TableCN" type="nocase"/>	<col-def name="HRDSTableURL" type="nocase"/>	<row>		<col>1</col>		<col>ORG_GROUP</col>		<col>https://ftp.trivir.com/outgoing/abcsuk/ORG_GROUP.XML</col>	</row>	<row>		<col>1</col>		<col>ORG_GROUPDISABLED</col>		<col>https://ftp.trivir.com/outgoing/abcsuk/ORG_GROUP.XML</col>	</row>	<row>		<col>0</col>		<col>ORG_GROUP1</col>		<col>https://ftp.trivir.com/outgoing/abcsuk/ORG_GROUP.XML</col>	</row></mapping-table>		 -->
								<do-set-local-variable name="countMSG">
									<arg-string>
										<token-text xml:space="preserve">--------------------HRDS Table Update Started--------------------</token-text>
										<token-text xml:space="preserve">The HRDS table downloading and saving can take 15-20 minutes if all tables are getting updated.</token-text>
										<token-text>Dynamic table Index counts: total configurable rows found: [</token-text>
										<token-local-variable name="totalRowsFound"/>
										<token-text>] Dynamic table Index counts: total enabled rows found: [</token-text>
										<token-local-variable name="totalEnabledRowsFound"/>
										<token-text>]</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="0">
									<arg-string>
										<token-local-variable name="countMSG"/>
									</arg-string>
								</do-trace-message>
								<do-send-email-from-template notification-dn="Security\Default Notification Collection" template-dn="security\Default Notification Collection\abcS-SD-Dynamic HRDS Table Processing Notification">
									<arg-string name="to">
										<token-global-variable name="EMAIL_SME"/>
									</arg-string>
									<arg-string name="to">
										<token-global-variable name="dveIDMTeam"/>
									</arg-string>
									<arg-string name="countTotal">
										<token-local-variable name="totalRowsFound"/>
									</arg-string>
									<arg-string name="countEnabled">
										<token-local-variable name="totalEnabledRowsFound"/>
									</arg-string>
								</do-send-email-from-template>
								<do-set-local-variable name="startVar" notrace="true" scope="policy">
									<arg-string>
										<token-time format="!CTIME" tz="UTC"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="tableReadingStatus" notrace="true" scope="policy">
									<arg-string/>
								</do-set-local-variable>
								<do-trace-message disabled="true" level="0" notrace="true">
									<arg-string>
										<token-text xml:space="preserve">Note that all the lines in the for each loop have tracing disabled to speed up processing. In testing this takes at least two minutes.</token-text>
									</arg-string>
								</do-trace-message>
								<do-for-each notrace="true">
									<arg-node-set>
										<token-xpath expression="$hrdsTableIndex/mapping-table/row"/>
									</arg-node-set>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-xpath op="true">$current-node/col[1]/text() = string('1') </if-xpath>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="TABLE_OUTPUT_CN">
													<arg-string>
														<token-xpath expression="$current-node/col[2]/text()"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="TABLE_SOURCE_URL">
													<arg-string>
														<token-xpath expression="$current-node/col[3]/text()"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="basicAuthHeader" scope="policy">
													<arg-string>
														<token-text xml:space="preserve">Basic </token-text>
														<token-base64-encode>
															<token-global-variable name="driver.input.username"/>
															<token-text xml:space="preserve">:</token-text>
															<token-named-password name="driver.input.password"/>
														</token-base64-encode>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="headers" scope="policy">
													<arg-object>
														<token-xpath expression="hashmap:new()"/>
													</arg-object>
												</do-set-local-variable>
												<do-set-local-variable name="dummy" scope="policy">
													<arg-object>
														<token-xpath expression="hashmap:put($headers, &quot;Authorization&quot;, $basicAuthHeader)"/>
													</arg-object>
												</do-set-local-variable>
												<do-set-local-variable name="mappingTableData" scope="policy">
													<arg-node-set>
														<token-xml-parse>
															<token-text xml:space="preserve">&lt;mapping-table/&gt;</token-text>
														</token-xml-parse>
													</arg-node-set>
												</do-set-local-variable>
												<do-set-local-variable name="ignoreFields" scope="policy">
													<arg-node-set>
														<token-xml-parse>
															<token-text xml:space="preserve">&lt;ignore&gt;&lt;Date_Modified/&gt;&lt;Effective_To/&gt;&lt;Effective_From/&gt;&lt;Date_Created/&gt;&lt;/ignore&gt;</token-text>
														</token-xml-parse>
													</arg-node-set>
												</do-set-local-variable>
												<do-set-local-variable name="resultXML" notrace="true" scope="driver">
													<arg-node-set>
														<token-xml-parse>
															<token-xpath expression="es:executeHTTPGetToString('executeHTTPGetTrace', $TABLE_SOURCE_URL, $headers, '~driver.dynamic.hrds.timeout~')"/>
														</token-xml-parse>
													</arg-node-set>
												</do-set-local-variable>
												<do-trace-message level="0">
													<arg-string>
														<token-text xml:space="preserve">HRDS Mapping Table Update - Reading table: </token-text>
														<token-local-variable name="TABLE_OUTPUT_CN"/>
													</arg-string>
												</do-trace-message>
												<do-for-each notrace="true">
													<arg-node-set>
														<token-xpath expression="$resultXML/*/*/*"/>
													</arg-node-set>
													<arg-actions>
														<do-if>
															<arg-conditions>
																<and>
																	<if-xpath op="true">count($ignoreFields/ignore/*[name(.) = name($current-node)]) = 0</if-xpath>
																	<if-xpath op="not-true">$mappingTableData/mapping-table/col-def/@name = name($current-node)</if-xpath>
																</and>
															</arg-conditions>
															<arg-actions>
																<do-append-xml-element expression="$mappingTableData/mapping-table" name="col-def"/>
																<do-set-xml-attr expression="$mappingTableData/mapping-table/col-def[last()]" name="name">
																	<arg-string>
																		<token-xpath expression="name($current-node)"/>
																	</arg-string>
																</do-set-xml-attr>
																<do-set-xml-attr expression="$mappingTableData/mapping-table/col-def[last()]" name="type">
																	<arg-string>
																		<token-text xml:space="preserve">nocase</token-text>
																	</arg-string>
																</do-set-xml-attr>
															</arg-actions>
														</do-if>
													</arg-actions>
												</do-for-each>
												<do-set-local-variable name="emtpyRecordString" scope="policy">
													<arg-string>
														<token-text xml:space="preserve">&lt;row&gt;</token-text>
													</arg-string>
												</do-set-local-variable>
												<do-for-each>
													<arg-node-set>
														<token-xpath expression="$mappingTableData/mapping-table/col-def"/>
													</arg-node-set>
													<arg-actions>
														<do-set-local-variable name="emtpyRecordString">
															<arg-string>
																<token-local-variable name="emtpyRecordString"/>
																<token-text xml:space="preserve">&lt;col/&gt;</token-text>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
												</do-for-each>
												<do-set-local-variable name="emtpyRecordString">
													<arg-string>
														<token-local-variable name="emtpyRecordString"/>
														<token-text xml:space="preserve">&lt;/row&gt;</token-text>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="emptyRecord">
													<arg-node-set>
														<token-xml-parse>
															<token-local-variable name="emtpyRecordString"/>
														</token-xml-parse>
													</arg-node-set>
												</do-set-local-variable>
												<do-for-each notrace="true">
													<arg-node-set>
														<token-xpath expression="$resultXML/*/*"/>
													</arg-node-set>
													<arg-actions>
														<do-clone-xpath dest-expression="$mappingTableData/mapping-table" src-expression="$emptyRecord"/>
														<do-trace-message disabled="true" level="0">
															<arg-string>
																<token-text xml:space="preserve">mappingdatable is now:[</token-text>
																<token-xml-serialize>
																	<token-xpath expression="$mappingTableData"/>
																</token-xml-serialize>
																<token-text xml:space="preserve">]</token-text>
															</arg-string>
														</do-trace-message>
														<do-for-each>
															<arg-node-set>
																<token-xpath expression="$current-node/*"/>
															</arg-node-set>
															<arg-actions>
																<do-if>
																	<arg-conditions>
																		<and>
																			<if-xpath op="true">count($ignoreFields/ignore/*[name(.) = name($current-node)]) = 0</if-xpath>
																		</and>
																	</arg-conditions>
																	<arg-actions>
																		<do-set-local-variable name="headerIndex">
																			<arg-string>
																				<token-xpath expression="count($mappingTableData/mapping-table/col-def[@name=name($current-node)]/preceding-sibling::*)+1"/>
																			</arg-string>
																		</do-set-local-variable>
																		<do-append-xml-text expression="$mappingTableData/mapping-table/row[last()]/col[number($headerIndex)]">
																			<arg-string>
																				<token-xpath expression="$current-node/text()"/>
																			</arg-string>
																		</do-append-xml-text>
																		<do-trace-message disabled="true" level="0">
																			<arg-string>
																				<token-text xml:space="preserve">NEW COL: mapping datatable is now:[</token-text>
																				<token-xml-serialize>
																					<token-xpath expression="$mappingTableData"/>
																				</token-xml-serialize>
																				<token-text xml:space="preserve">]</token-text>
																			</arg-string>
																		</do-trace-message>
																	</arg-actions>
																</do-if>
															</arg-actions>
														</do-for-each>
													</arg-actions>
												</do-for-each>
												<do-set-local-variable name="tableDN">
													<arg-string>
														<token-parse-dn dest-dn-format="dest-dn" length="-2" src-dn-format="dest-dn">
															<token-global-variable name="dirxml.auto.driverdn"/>
														</token-parse-dn>
														<token-text xml:space="preserve">\HRDS-Dynamic-Tables\</token-text>
														<token-local-variable name="TABLE_OUTPUT_CN"/>
													</arg-string>
												</do-set-local-variable>
												<do-trace-message disabled="true" level="999" notrace="true">
													<arg-string>
														<token-text xml:space="preserve">If the table is empty, we don't write it to eDir. This will cause the driver to fail on startup.</token-text>
													</arg-string>
												</do-trace-message>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="true">boolean($mappingTableData/mapping-table/col-def/@name)</if-xpath>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-trace-message level="0">
															<arg-string>
																<token-text xml:space="preserve">HRDS Mapping Table Update - Reading table: </token-text>
																<token-local-variable name="TABLE_OUTPUT_CN"/>
																<token-text xml:space="preserve"> Successful!</token-text>
															</arg-string>
														</do-trace-message>
														<do-set-local-variable name="tableReadingStatus" scope="policy">
															<arg-string>
																<token-local-variable name="tableReadingStatus"/>
																<token-text xml:space="preserve">
</token-text>
																<token-local-variable name="TABLE_OUTPUT_CN"/>
																<token-text xml:space="preserve"> Success!</token-text>
															</arg-string>
														</do-set-local-variable>
														<do-if>
															<arg-conditions>
																<and>
																	<if-xpath op="true">string-length(query:readObject($srcQueryProcessor, '', $tableDN, "", "")/@src-dn) = 0</if-xpath>
																</and>
															</arg-conditions>
															<arg-actions>
																<do-add-src-object class-name="DirXML-Resource" direct="true">
																	<arg-dn>
																		<token-local-variable name="tableDN"/>
																	</arg-dn>
																</do-add-src-object>
															</arg-actions>
														</do-if>
														<do-set-src-attr-value class-name="DirXML-Resource" direct="true" name="DirXML-Data" notrace="true">
															<arg-dn>
																<token-local-variable name="tableDN"/>
															</arg-dn>
															<arg-value type="octet">
																<token-base64-encode>
																	<token-xml-serialize>
																		<token-xpath expression="$mappingTableData" notrace="true"/>
																	</token-xml-serialize>
																</token-base64-encode>
															</arg-value>
														</do-set-src-attr-value>
														<do-set-src-attr-value class-name="DirXML-Resource" direct="true" name="DirXML-ContentType">
															<arg-dn>
																<token-local-variable name="tableDN"/>
															</arg-dn>
															<arg-value type="string">
																<token-text xml:space="preserve">application/vnd.novell.dirxml.mapping-table+xml ;charset=UTF-8</token-text>
															</arg-value>
														</do-set-src-attr-value>
													</arg-actions>
													<arg-actions>
														<do-trace-message level="0">
															<arg-string>
																<token-text xml:space="preserve">HRDS Mapping Table Update - Reading table: </token-text>
																<token-local-variable name="TABLE_OUTPUT_CN"/>
																<token-text xml:space="preserve"> Failed!</token-text>
															</arg-string>
														</do-trace-message>
														<do-set-local-variable name="tableReadingStatus" scope="policy">
															<arg-string>
																<token-local-variable name="tableReadingStatus"/>
																<token-text xml:space="preserve">
</token-text>
																<token-local-variable name="TABLE_OUTPUT_CN"/>
																<token-text xml:space="preserve"> Failure!</token-text>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
												</do-if>
											</arg-actions>
											<arg-actions/>
										</do-if>
									</arg-actions>
								</do-for-each>
								<do-trace-message level="0">
									<arg-string>
										<token-text xml:space="preserve">

HRDS Table Reading Summary:
</token-text>
										<token-local-variable name="tableReadingStatus"/>
										<token-text xml:space="preserve">
</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="endVar" notrace="true" scope="policy">
									<arg-string>
										<token-time format="!CTIME" tz="UTC"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="eventTimeTakenSeconds" notrace="true" scope="policy">
									<arg-string>
										<token-xpath expression="es:calculateEventTimeSeconds($startVar, $endVar)"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="eventTimeTakenMinutes" notrace="true" scope="policy">
									<arg-string>
										<token-xpath expression="es:calculateEventTimeMinutes($startVar, $endVar)"/>
									</arg-string>
								</do-set-local-variable>
								<do-trace-message level="0">
									<arg-string>
										<token-text xml:space="preserve">Total time for HRDS Updates = </token-text>
										<token-substring length="4">
											<token-local-variable name="eventTimeTakenMinutes"/>
										</token-substring>
										<token-text xml:space="preserve"> minutes.</token-text>
										<token-text xml:space="preserve">(</token-text>
										<token-local-variable name="eventTimeTakenSeconds"/>
										<token-text xml:space="preserve"> seconds).</token-text>
									</arg-string>
								</do-trace-message>
								<do-trace-message level="0">
									<arg-string>
										<token-text xml:space="preserve">--------------------HRDS Table Update Complete-------------------</token-text>
									</arg-string>
								</do-trace-message>
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-ManageIsUserComplete">
					<policy>
						<rule>
							<description>Break now if not user.</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break now if our needed attributes are not changing.</description>
							<conditions>
								<and>
									<if-op-attr name="DirXML-Associations" op="not-changing"/>
									<if-op-attr name="abcGCINumber" op="not-changing"/>
									<if-op-attr mode="nocase" name="carLicense" op="not-changing-to">terminate</if-op-attr>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>DirXML-Associations: check which associations are set if either the associations or GCInumber is set.</description>
							<conditions/>
							<actions>
								<do-set-local-variable name="userAssociations" scope="policy">
									<arg-node-set>
										<token-attr name="DirXML-Associations"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-set-local-variable name="isGLAssociated" scope="policy">
									<arg-node-set>
										<token-xpath expression="$userAssociations[contains(component[@name='volume'], '~driverAD~') ]/component[@name='nameSpace']/text()"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-set-local-variable name="isSFAssociated" scope="policy">
									<arg-node-set>
										<token-xpath expression="$userAssociations[contains(component[@name='volume'], '~driverSF~') ]/component[@name='nameSpace']/text()"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-set-local-variable name="isVRSAssociated" scope="policy">
									<arg-node-set>
										<token-xpath expression="$userAssociations[contains(component[@name='volume'], '~driverVRS~') ]/component[@name='nameSpace']/text()"/>
									</arg-node-set>
								</do-set-local-variable>
							</actions>
						</rule>
						<!-- 	             - SF user (has a GCI number) is associated to GL, SF, and VRS.               - An NSF user (does nto have a GCI number) is associated to GL and VRS.		 -->
						<rule>
							<description>abcIsUserComplete: SF/NSF user: Check states to see if we can mark the user complete</description>
							<conditions/>
							<actions>
								<do-if>
									<arg-conditions>
										<and>
											<if-attr mode="regex" name="abcGCINumber" op="equal">.+</if-attr>
											<if-local-variable mode="nocase" name="isSFAssociated" op="equal">1</if-local-variable>
											<if-local-variable mode="nocase" name="isVRSAssociated" op="equal">1</if-local-variable>
										</and>
										<and>
											<if-attr mode="regex" name="abcGCINumber" op="not-equal">.+</if-attr>
											<if-local-variable mode="nocase" name="isGLAssociated" op="equal">1</if-local-variable>
											<if-local-variable mode="nocase" name="isVRSAssociated" op="equal">1</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value name="abcIsUserComplete">
											<arg-value>
												<token-text xml:space="preserve">true</token-text>
											</arg-value>
										</do-set-src-attr-value>
									</arg-actions>
									<arg-actions>
										<do-set-src-attr-value name="abcIsUserComplete">
											<arg-value>
												<token-text xml:space="preserve">false</token-text>
											</arg-value>
										</do-set-src-attr-value>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Clear carLicense when the termination is complete</description>
							<conditions>
								<or>
									<if-op-attr mode="nocase" name="carLicense" op="equal">terminate</if-op-attr>
								</or>
							</conditions>
							<actions>
								<do-strip-op-attr name="carLicense"/>
								<do-clear-src-attr-value class-name="User" name="carLicense"/>
							</actions>
						</rule>
						<rule>
							<description>Stop processing: Ignore abcGCINumber, DirXML-Association modifies from continuing in this driver</description>
							<comment xml:space="preserve">By the time we get to this rule, we're done looking at these attributes, so remove them from the event.</comment>
							<conditions/>
							<actions>
								<do-strip-op-attr name="DirXML-Associations"/>
								<do-strip-op-attr name="abcGCINumber"/>
							</actions>
						</rule>
						<rule>
							<description>Block empty add/modify operations</description>
							<comment xml:space="preserve">If we only had association updates, we'll have n empty modify here, so we can stop it now.</comment>
							<conditions>
								<and>
									<if-operation mode="nocase" op="equal">add</if-operation>
									<if-xpath op="not-true">add-attr</if-xpath>
								</and>
								<and>
									<if-operation op="equal">modify</if-operation>
									<if-xpath op="not-true">modify-attr</if-xpath>
								</and>
							</conditions>
							<actions>
								<!-- Veto empty modify -->
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-ManagerTasks">
					<policy>
						<rule>
							<description>Break if not user.</description>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break if not manager related attributes changing</description>
							<comment xml:space="preserve">TODO: secondment line manager will be caught here as well when SF driver is built.</comment>
							<conditions>
								<and>
									<if-op-attr name="manager" op="not-changing"/>
									<if-op-attr name="managerWorkforceID" op="not-changing"/>
									<if-op-attr name="abcSupervisorVRSID" op="not-changing"/>
									<if-op-attr name="abcSFEmailAddress" op="not-changing"/>
									<if-op-attr name="abcFuseID" op="not-changing"/>
									<if-attr mode="nocase" name="carLicense" op="not-equal">UpdateManagerValuesMWFID</if-attr>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Manager workforceID changes.</description>
							<comment xml:space="preserve">Look up the new manager, and write to the user.

Note: we're forcing only 1 result in the query here; the check for a count of 2 is due to the &lt;query-token&gt; also handed back in the node set along with the &lt;instance&gt;.

</comment>
							<conditions>
								<or>
									<if-op-attr name="managerWorkforceID" op="changing"/>
									<if-attr mode="nocase" name="carLicense" op="equal">UpdateManagerValuesMWFID</if-attr>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="lv-oldManagerWorkforceID" scope="policy">
									<arg-string>
										<token-xpath expression="modify-attr[@attr-name='managerWorkforceID']/remove-value/value/text()"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="managerDNNodeSet" scope="policy">
									<arg-node-set>
										<token-query class-name="User" datastore="src" max-result-count="1">
											<arg-dn>
												<token-global-variable name="idv.dit.data.users"/>
											</arg-dn>
											<arg-match-attr name="abcGCINumber">
												<arg-value type="string">
													<token-attr name="managerWorkforceID"/>
												</arg-value>
											</arg-match-attr>
										</token-query>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($managerDNNodeSet) = 2</if-xpath>
											<if-xpath op="true">name($managerDNNodeSet[1]) = string('instance')</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message color="brpurple" level="0">
											<arg-string>
												<token-text xml:space="preserve">manager - success: Found manager by GCI number. Setting to: "</token-text>
												<token-xpath expression="$managerDNNodeSet[1]/@src-dn"/>
												<token-text xml:space="preserve">"</token-text>
											</arg-string>
										</do-trace-message>
										<do-set-local-variable name="managerDN">
											<arg-string>
												<token-xpath expression="$managerDNNodeSet[1]/@src-dn"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-attr mode="regex" name="managerWorkforceID" op="equal">.+</if-attr>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-trace-message color="brpurple" level="0">
													<arg-string>
														<token-text xml:space="preserve">manager - failure: Could not find manager gci number, sending email.</token-text>
													</arg-string>
												</do-trace-message>
												<do-send-email-from-template notification-dn="Security\Default Notification Collection" template-dn="Security\Default Notification Collection\abcS-AD-Manager Lookup Failed-MWFID">
													<arg-string name="to">
														<token-global-variable name="EMAIL_MANAGERWORKFORCEID_LOOKUP_FAILURE"/>
													</arg-string>
													<arg-string name="managergci">
														<token-attr name="managerWorkforceID"/>
													</arg-string>
													<arg-string name="user_dn">
														<token-parse-dn dest-dn-format="src-dn" length="1" start="-1">
															<token-src-dn/>
														</token-parse-dn>
													</arg-string>
												</do-send-email-from-template>
											</arg-actions>
											<arg-actions>
												<do-trace-message level="6">
													<arg-string>
														<token-text xml:space="preserve">No email sent on blank managerWorkforceIDs</token-text>
													</arg-string>
												</do-trace-message>
											</arg-actions>
										</do-if>
										<do-clear-src-attr-value class-name="User" name="manager"/>
										<do-clear-src-attr-value class-name="User" name="abcManagerSFEmail"/>
										<do-clear-src-attr-value class-name="User" name="abcManagerFuseID"/>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($managerDN) &gt; 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="manager">
											<arg-value type="string">
												<token-local-variable name="managerDN"/>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-src-attr-value class-name="User" name="abcManagerSFEmail">
											<arg-value type="string">
												<token-src-attr name="abcSFEmailAddress">
													<arg-dn>
														<token-local-variable name="managerDN"/>
													</arg-dn>
												</token-src-attr>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-local-variable name="fuseIDFromManager" scope="policy">
											<arg-string>
												<token-src-attr name="abcFuseID">
													<arg-dn>
														<token-local-variable name="managerDN"/>
													</arg-dn>
												</token-src-attr>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<and>
													<if-local-variable mode="regex" name="fuseIDFromManager" op="not-equal">^$</if-local-variable>
													<if-local-variable mode="regex" name="fuseIDFromManager" op="not-equal">pending</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-src-attr-value class-name="User" name="abcManagerFuseID">
													<arg-value type="string">
														<token-local-variable name="fuseIDFromManager"/>
													</arg-value>
												</do-set-src-attr-value>
											</arg-actions>
											<arg-actions>
												<do-clear-src-attr-value class-name="User" name="abcManagerFuseID"/>
											</arg-actions>
										</do-if>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Manager status change - User becomes Manager (Update Fuse)</description>
							<comment xml:space="preserve">When a user first becomes a manager that user doesn't get any modification on their account. So this policy will generate a sync event for their account so the abcIsManager flag can get updaed and sent to Fuse.</comment>
							<conditions>
								<or>
									<if-xpath op="true">string-length($managerDN) &gt; 0</if-xpath>
								</or>
							</conditions>
							<actions>
								<do-trace-message disabled="true" level="999" notrace="true">
									<arg-string>
										<token-text xml:space="preserve">Next if statement is just to force resyncs for Fuse for first time managers.</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="lv-directReports" scope="policy">
									<arg-node-set>
										<token-src-attr class-name="User" name="directReports">
											<arg-dn>
												<token-local-variable name="managerDN"/>
											</arg-dn>
										</token-src-attr>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($lv-directReports) = 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="carLicense">
											<arg-dn>
												<token-local-variable name="managerDN"/>
											</arg-dn>
											<arg-value type="string">
												<token-text xml:space="preserve">syncFuse</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Manager resync - User2Mgr - Generate a manager sync to send the abcIsManager flag to Fuse since this is the first time this manager became a manager.</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
									<arg-actions>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Manager resync - User2Mgr - Not needed since this user is already a manager.</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Manager status change - User stops being a Manager (Update Fuse)</description>
							<comment xml:space="preserve">When a user stops being a manger that user doesn't get any modification on their account. So this policy will generate a sync event for their account so the abcIsManager flag can get updaed and sent to Fuse. The idea is that if this manager only has 1 directReprts, when this event completes, the manger will have 0 direct reports and abcIsManager needs to be set to FALSE.
</comment>
							<conditions>
								<or>
									<if-local-variable mode="regex" name="lv-oldManagerWorkforceID" op="equal">.+</if-local-variable>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="oldManagerDNNodeSet" scope="policy">
									<arg-node-set>
										<token-query class-name="User" datastore="src" max-result-count="1">
											<arg-dn>
												<token-global-variable name="idv.dit.data.users"/>
											</arg-dn>
											<arg-match-attr name="abcGCINumber">
												<arg-value type="string">
													<token-local-variable name="lv-oldManagerWorkforceID"/>
												</arg-value>
											</arg-match-attr>
										</token-query>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($oldManagerDNNodeSet) = 2</if-xpath>
											<if-xpath op="true">name($oldManagerDNNodeSet[1]) = string('instance')</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message color="brpurple" level="0">
											<arg-string>
												<token-text xml:space="preserve">manager - success: Found old manager by GCI number.</token-text>
											</arg-string>
										</do-trace-message>
										<do-set-local-variable name="oldManagerDN">
											<arg-string>
												<token-xpath expression="$oldManagerDNNodeSet[1]/@src-dn"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions/>
								</do-if>
								<do-set-local-variable name="lv-OldMgrdirectReports" scope="policy">
									<arg-node-set>
										<token-src-attr class-name="User" name="directReports">
											<arg-dn>
												<token-local-variable name="oldManagerDN"/>
											</arg-dn>
										</token-src-attr>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($lv-OldMgrdirectReports) = 1</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="carLicense">
											<arg-dn>
												<token-local-variable name="oldManagerDN"/>
											</arg-dn>
											<arg-value type="string">
												<token-text xml:space="preserve">syncFuse</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Manager resync - Mgr2User - Generate a manager sync to send the abcIsManager flag to Fuse since this is the first time this manager became a manager.</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
									<arg-actions>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Manager resync - Mgr2User - Not required since the manager didn't stop being a manager in this transaction.</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Manager abcSupervisorVRSID changes.</description>
							<comment xml:space="preserve">Identical to managerWorkforceID updates; however, we only do this if some one doesn't have a managerWorkforceID.</comment>
							<conditions>
								<and>
									<if-attr name="managerWorkforceID" op="not-available"/>
									<if-attr name="abcSAPKSAManagerWorkforceID" op="not-available"/>
									<if-op-attr name="abcSupervisorVRSID" op="changing"/>
								</and>
								<and>
									<if-attr name="managerWorkforceID" op="not-available"/>
									<if-attr name="abcSAPKSAManagerWorkforceID" op="not-available"/>
									<if-attr mode="nocase" name="carLicense" op="equal">UpdateManagerValuesMWFID</if-attr>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="managerDNNodeSet" scope="policy">
									<arg-node-set>
										<token-query class-name="User" datastore="src" max-result-count="1">
											<arg-dn>
												<token-global-variable name="idv.dit.data.users"/>
											</arg-dn>
											<arg-match-attr name="abcVRSID">
												<arg-value type="string">
													<token-attr name="abcSupervisorVRSID"/>
												</arg-value>
											</arg-match-attr>
										</token-query>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($managerDNNodeSet) = 2</if-xpath>
											<if-xpath op="true">name($managerDNNodeSet[1]) = string('instance')</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message color="brpurple" level="0">
											<arg-string>
												<token-text xml:space="preserve">manager - success: Found manager by VRSID, setting now.</token-text>
											</arg-string>
										</do-trace-message>
										<do-set-local-variable name="managerDN">
											<arg-string>
												<token-xpath expression="$managerDNNodeSet[1]/@src-dn"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-trace-message color="brpurple" level="0">
											<arg-string>
												<token-text xml:space="preserve">manager - failure: Could not find manager by VRSID, sending email.</token-text>
											</arg-string>
										</do-trace-message>
										<do-send-email-from-template notification-dn="Security\Default Notification Collection" template-dn="Security\Default Notification Collection\abcS-AD-Manager Lookup Failed-VRSID">
											<arg-string name="to">
												<token-global-variable name="EMAIL_SME"/>
											</arg-string>
											<arg-string name="managerVRSID">
												<token-attr name="abcSupervisorVRSID"/>
											</arg-string>
											<arg-string name="user_dn">
												<token-parse-dn dest-dn-format="src-dn" length="1" start="-1">
													<token-src-dn/>
												</token-parse-dn>
											</arg-string>
										</do-send-email-from-template>
										<do-clear-src-attr-value name="manager"/>
										<do-clear-src-attr-value name="abcManagerSFEmail"/>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Set manager related attributes</description>
							<conditions>
								<and>
									<if-xpath op="true">string-length($managerDN) &gt; 0</if-xpath>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lv-abcManagerSFEmail" scope="policy">
									<arg-string>
										<token-src-attr name="abcSFEmailAddress">
											<arg-dn>
												<token-local-variable name="managerDN"/>
											</arg-dn>
										</token-src-attr>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="regex" name="lv-abcManagerSFEmail" op="equal">.+</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="abcManagerSFEmail">
											<arg-value type="string">
												<token-local-variable name="lv-abcManagerSFEmail"/>
											</arg-value>
										</do-set-src-attr-value>
									</arg-actions>
									<arg-actions>
										<do-strip-op-attr name="abcManagerSFEmail"/>
										<do-clear-src-attr-value class-name="User" name="abcManagerSFEmail"/>
									</arg-actions>
								</do-if>
								<do-set-src-attr-value class-name="User" name="manager">
									<arg-value type="string">
										<token-local-variable name="managerDN"/>
									</arg-value>
								</do-set-src-attr-value>
							</actions>
						</rule>
						<rule>
							<description>Manager abcSFEmailAddress changes</description>
							<conditions>
								<and>
									<if-op-attr name="abcSFEmailAddress" op="changing"/>
									<if-attr name="directReports" op="available"/>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lv_DirectReportsNodeSet" scope="policy">
									<arg-node-set>
										<token-attr name="directReports"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-for-each>
									<arg-node-set>
										<token-local-variable name="lv_DirectReportsNodeSet"/>
									</arg-node-set>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="abcManagerSFEmail">
											<arg-dn>
												<token-local-variable name="current-node"/>
											</arg-dn>
											<arg-value type="string">
												<token-op-attr name="abcSFEmailAddress"/>
											</arg-value>
										</do-set-src-attr-value>
									</arg-actions>
								</do-for-each>
							</actions>
						</rule>
						<rule>
							<description>Manager abcFuseID getting from its pending value</description>
							<comment xml:space="preserve">If a manager that already had directReports gets a FuseID, the FuseID needs to be updated on all the directReports of the manager.</comment>
							<conditions>
								<and>
									<if-op-attr mode="nocase" name="abcFuseID" op="changing-from">pending</if-op-attr>
									<if-attr name="directReports" op="available"/>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lv_DirectReportsNodeSet" scope="policy">
									<arg-node-set>
										<token-attr name="directReports"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-for-each>
									<arg-node-set>
										<token-local-variable name="lv_DirectReportsNodeSet"/>
									</arg-node-set>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="abcManagerFuseID">
											<arg-dn>
												<token-local-variable name="current-node"/>
											</arg-dn>
											<arg-value type="string">
												<token-op-attr name="abcFuseID"/>
											</arg-value>
										</do-set-src-attr-value>
									</arg-actions>
								</do-for-each>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-ManagerTasks-KSA-SAP">
					<policy>
						<rule>
							<description>Break if not user.</description>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break if not abcSAPKSAManager related attributes changing</description>
							<comment xml:space="preserve">TODO: secondment line abcSAPKSAManager will be caught here as well when SF driver is built.</comment>
							<conditions>
								<and>
									<if-op-attr name="abcSAPKSAManager" op="not-changing"/>
									<if-op-attr name="abcSAPKSAManagerWorkforceID" op="not-changing"/>
									<if-op-attr name="abcSandlnkMail" op="not-changing"/>
									<if-op-attr name="abcFuseID" op="not-changing"/>
									<if-attr mode="nocase" name="carLicense" op="not-equal">UpdateManagerValuesMWFID</if-attr>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Manager abcSAPKSAManagerWorkforceID changes.</description>
							<comment xml:space="preserve">Look up the new manager, and write to the user.

Note: we're forcing only 1 result in the query here; the check for a count of 2 is due to the &lt;query-token&gt; also handed back in the node set along with the &lt;instance&gt;.

</comment>
							<conditions>
								<or>
									<if-op-attr name="abcSAPKSAManagerWorkforceID" op="changing"/>
									<if-attr mode="nocase" name="carLicense" op="equal">UpdateManagerValuesMWFID</if-attr>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="lv-oldManagerWorkforceID" scope="policy">
									<arg-string>
										<token-xpath expression="modify-attr[@attr-name='abcSAPKSAManagerWorkforceID']/remove-value/value/text()"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="managerDNNodeSet" scope="policy">
									<arg-node-set>
										<token-query class-name="User" datastore="src" max-result-count="1">
											<arg-dn>
												<token-global-variable name="idv.dit.data.users"/>
											</arg-dn>
											<arg-match-attr name="abcGCINumber">
												<arg-value type="string">
													<token-attr name="abcSAPKSAManagerWorkforceID"/>
												</arg-value>
											</arg-match-attr>
										</token-query>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($managerDNNodeSet) = 2</if-xpath>
											<if-xpath op="true">name($managerDNNodeSet[1]) = string('instance')</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message level="0">
											<arg-string>
												<token-text xml:space="preserve">manager - success: Found manager by GCI number. (KSA-SAP) Setting to: "</token-text>
												<token-xpath expression="$managerDNNodeSet[1]/@src-dn"/>
												<token-text xml:space="preserve">"</token-text>
											</arg-string>
										</do-trace-message>
										<do-set-local-variable name="managerDN">
											<arg-string>
												<token-xpath expression="$managerDNNodeSet[1]/@src-dn"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-attr mode="regex" name="abcSAPKSAManagerWorkforceID" op="equal">.+</if-attr>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-trace-message level="0">
													<arg-string>
														<token-text xml:space="preserve">manager - failure: Could not find manager gci number. (KSA-SAP) Sending email.</token-text>
													</arg-string>
												</do-trace-message>
												<do-set-local-variable name="lv_firstNameForEmail" scope="policy">
													<arg-string>
														<token-src-attr class-name="User" name="Given Name"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="lv_lastNameForEmail" scope="policy">
													<arg-string>
														<token-src-attr class-name="User" name="Surname"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="lv_clockNumberForEmail" scope="policy">
													<arg-string>
														<token-src-attr class-name="User" name="abcSAPKSAClockNumber"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="lv_gciNumberForEmail" scope="policy">
													<arg-string>
														<token-src-attr class-name="User" name="abcGCINumber"/>
													</arg-string>
												</do-set-local-variable>
												<do-set-local-variable name="lv_mgrGCI" scope="policy">
													<arg-string>
														<token-src-attr class-name="User" name="abcSAPKSAmanagerWorkforceID"/>
													</arg-string>
												</do-set-local-variable>
												<do-send-email-from-template notification-dn="Security\Default Notification Collection" template-dn="Security\Default Notification Collection\abcS-KSA-SAP-Manager Lookup Failed - KSA-SAP">
													<arg-string name="to">
														<token-global-variable name="KSA-SAP-HR-Email"/>
													</arg-string>
													<arg-string name="firstName">
														<token-local-variable name="lv_firstNameForEmail"/>
													</arg-string>
													<arg-string name="lastName">
														<token-local-variable name="lv_lastNameForEmail"/>
													</arg-string>
													<arg-string name="clockNumber">
														<token-local-variable name="lv_clockNumberForEmail"/>
													</arg-string>
													<arg-string name="gci">
														<token-local-variable name="lv_gciNumberForEmail"/>
													</arg-string>
													<arg-string name="mgrWorkforceID">
														<token-local-variable name="lv_mgrGCI"/>
													</arg-string>
												</do-send-email-from-template>
											</arg-actions>
											<arg-actions>
												<do-trace-message level="6">
													<arg-string>
														<token-text xml:space="preserve">No email sent on blank managerWorkforceIDs (KSA-SAP)</token-text>
													</arg-string>
												</do-trace-message>
											</arg-actions>
										</do-if>
										<do-clear-src-attr-value class-name="User" name="abcSAPKSAManager"/>
										<do-clear-src-attr-value class-name="User" name="abcSAPKSAManagerEmail"/>
										<do-clear-src-attr-value class-name="User" name="abcSAPKSAManagerFuseID"/>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($managerDN) &gt; 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="abcSAPKSAManager">
											<arg-value type="string">
												<token-local-variable name="managerDN"/>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-src-attr-value class-name="User" name="abcSAPKSAManagerEmail">
											<arg-value type="string">
												<token-src-attr class-name="User" name="abcSandlnkMail">
													<arg-dn>
														<token-local-variable name="managerDN"/>
													</arg-dn>
												</token-src-attr>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-local-variable name="fuseIDFromManager" scope="policy">
											<arg-string>
												<token-src-attr name="abcFuseID">
													<arg-dn>
														<token-local-variable name="managerDN"/>
													</arg-dn>
												</token-src-attr>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<and>
													<if-local-variable mode="regex" name="fuseIDFromManager" op="not-equal">^$</if-local-variable>
													<if-local-variable mode="regex" name="fuseIDFromManager" op="not-equal">pending</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-src-attr-value class-name="User" name="abcSAPKSAManagerFuseID">
													<arg-value type="string">
														<token-local-variable name="fuseIDFromManager"/>
													</arg-value>
												</do-set-src-attr-value>
											</arg-actions>
											<arg-actions>
												<do-clear-src-attr-value class-name="User" name="abcSAPKSAManagerFuseID"/>
											</arg-actions>
										</do-if>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Manager status change - User becomes Manager (Update Fuse)</description>
							<comment xml:space="preserve">When a user first becomes a manager that user doesn't get any modification on their account. So this policy will generate a sync event for their account so the abcIsManager flag can get updaed and sent to Fuse.</comment>
							<conditions>
								<or>
									<if-xpath op="true">string-length($managerDN) &gt; 0</if-xpath>
								</or>
							</conditions>
							<actions>
								<do-trace-message disabled="true" level="999" notrace="true">
									<arg-string>
										<token-text xml:space="preserve">Next if statement is just to force resyncs for Fuse for first time managers.</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="lv-directReports" scope="policy">
									<arg-node-set>
										<token-src-attr class-name="User" name="abcSAPKSADirectReports">
											<arg-dn>
												<token-local-variable name="managerDN"/>
											</arg-dn>
										</token-src-attr>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($lv-directReports) = 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="carLicense">
											<arg-dn>
												<token-local-variable name="managerDN"/>
											</arg-dn>
											<arg-value type="string">
												<token-text xml:space="preserve">syncFuse</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Manager resync - User2Mgr - Generate a manager sync to send the abcIsManager flag to Fuse since this is the first time this manager became a manager. (KSA-SAP)</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
									<arg-actions>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Manager resync - User2Mgr - Not needed since this user is already a manager. (KSA-SAP)</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Manager status change - User stops being a Manager (Update Fuse)</description>
							<comment xml:space="preserve">When a user stops being a manger that user doesn't get any modification on their account. So this policy will generate a sync event for their account so the abcIsManager flag can get updaed and sent to Fuse. The idea is that if this manager only has 1 directReprts, when this event completes, the manger will have 0 direct reports and abcIsManager needs to be set to FALSE.
</comment>
							<conditions>
								<or>
									<if-local-variable mode="regex" name="lv-oldManagerWorkforceID" op="equal">.+</if-local-variable>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="oldManagerDNNodeSet" scope="policy">
									<arg-node-set>
										<token-query class-name="User" datastore="src" max-result-count="1">
											<arg-dn>
												<token-global-variable name="idv.dit.data.users"/>
											</arg-dn>
											<arg-match-attr name="abcGCINumber">
												<arg-value type="string">
													<token-local-variable name="lv-oldManagerWorkforceID"/>
												</arg-value>
											</arg-match-attr>
										</token-query>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($oldManagerDNNodeSet) = 2</if-xpath>
											<if-xpath op="true">name($oldManagerDNNodeSet[1]) = string('instance')</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message color="brpurple" level="0">
											<arg-string>
												<token-text xml:space="preserve">manager - success: Found old manager by GCI number.(KSA-SAP)</token-text>
											</arg-string>
										</do-trace-message>
										<do-set-local-variable name="oldManagerDN">
											<arg-string>
												<token-xpath expression="$oldManagerDNNodeSet[1]/@src-dn"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions/>
								</do-if>
								<do-set-local-variable name="lv-OldMgrdirectReports" scope="policy">
									<arg-node-set>
										<token-src-attr class-name="User" name="abcSAPKSADirectReports">
											<arg-dn>
												<token-local-variable name="oldManagerDN"/>
											</arg-dn>
										</token-src-attr>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">count($lv-OldMgrdirectReports) = 1</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="carLicense">
											<arg-dn>
												<token-local-variable name="oldManagerDN"/>
											</arg-dn>
											<arg-value type="string">
												<token-text xml:space="preserve">syncFuse</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Manager resync - Mgr2User - Generate a manager sync to send the abcIsManager flag to Fuse since this is the first time this manager became a manager.(KSA-SAP)</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
									<arg-actions>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">Manager resync - Mgr2User - Not required since the manager didn't stop being a manager in this transaction.(KSA-SAP)</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Set manager related attributes</description>
							<conditions>
								<and>
									<if-xpath op="true">string-length($managerDN) &gt; 0</if-xpath>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lv-abcSAPKSAManagerEmail" scope="policy">
									<arg-string>
										<token-src-attr name="abcSandlnkMail">
											<arg-dn>
												<token-local-variable name="managerDN"/>
											</arg-dn>
										</token-src-attr>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="regex" name="lv-abcSAPKSAManagerEmail" op="equal">.+</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="abcSAPKSAManagerEmail">
											<arg-value type="string">
												<token-local-variable name="lv-abcSAPKSAManagerEmail"/>
											</arg-value>
										</do-set-src-attr-value>
									</arg-actions>
									<arg-actions>
										<do-strip-op-attr name="abcSAPKSAManagerEmail"/>
										<do-clear-src-attr-value class-name="User" name="abcSAPKSAManagerEmail"/>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Manager email changes</description>
							<conditions>
								<and>
									<if-op-attr name="abcSandlnkMail" op="changing"/>
									<if-attr name="abcSAPKSADirectReports" op="available"/>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lv_DirectReportsNodeSet" scope="policy">
									<arg-node-set>
										<token-attr name="abcSAPKSADirectReports"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-for-each>
									<arg-node-set>
										<token-local-variable name="lv_DirectReportsNodeSet"/>
									</arg-node-set>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="abcSAPKSAManagerEmail">
											<arg-dn>
												<token-local-variable name="current-node"/>
											</arg-dn>
											<arg-value type="string">
												<token-op-attr name="abcSandlnkMail"/>
											</arg-value>
										</do-set-src-attr-value>
									</arg-actions>
								</do-for-each>
							</actions>
						</rule>
						<rule>
							<description>Manager abcFuseID getting from its pending value - KSA-SAP</description>
							<comment xml:space="preserve">If a manager that already had abcSAPKSADirectReports gets a FuseID, the FuseID needs to be updated on all the abcSAPKSADirectReports of the manager.</comment>
							<conditions>
								<and>
									<if-op-attr mode="nocase" name="abcFuseID" op="changing-from">pending</if-op-attr>
									<if-attr name="abcSAPKSADirectReports" op="available"/>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="lv_DirectReportsNodeSet" scope="policy">
									<arg-node-set>
										<token-attr name="abcSAPKSADirectReports"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-for-each>
									<arg-node-set>
										<token-local-variable name="lv_DirectReportsNodeSet"/>
									</arg-node-set>
									<arg-actions>
										<do-set-src-attr-value class-name="User" name="abcSAPKSAManagerFuseID">
											<arg-dn>
												<token-local-variable name="current-node"/>
											</arg-dn>
											<arg-value type="string">
												<token-op-attr name="abcFuseID"/>
											</arg-value>
										</do-set-src-attr-value>
									</arg-actions>
								</do-for-each>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-MigrateGreenlnkAttrs">
					<policy>
						<rule>
							<description>Trigger on carLicense</description>
							<comment xml:space="preserve">Looking for carLicense being set to MigrateGLAttrs</comment>
							<conditions>
								<and>
									<if-op-attr mode="case" name="carLicense" op="not-changing-to">MigrateGLAttrs</if-op-attr>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Do Update Attributes</description>
							<conditions>
								<and/>
							</conditions>
							<actions>
								<do-add-src-attr-value name="Object Class">
									<arg-value type="string">
										<token-text xml:space="preserve">abcGreenlnk</token-text>
									</arg-value>
								</do-add-src-attr-value>
								<do-set-local-variable name="lv-attrMappingTableData" scope="policy">
									<arg-node-set>
										<token-xml-parse>
											<token-base64-decode>
												<token-src-attr name="DirXML-Data">
													<arg-dn>
														<token-global-variable name="GreenlnkAttrMigrationTable"/>
													</arg-dn>
												</token-src-attr>
											</token-base64-decode>
										</token-xml-parse>
									</arg-node-set>
								</do-set-local-variable>
								<do-for-each>
									<arg-node-set>
										<token-xpath expression="$lv-attrMappingTableData/mapping-table/row"/>
									</arg-node-set>
									<arg-actions>
										<do-set-local-variable name="lv-og-attr" scope="policy">
											<arg-string>
												<token-xpath expression="$current-node/col[1]"/>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="lv-gl-attr" scope="policy">
											<arg-string>
												<token-xpath expression="$current-node/col[2]"/>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="lv-og-value" scope="policy">
											<arg-string>
												<token-src-attr name="$lv-og-attr$"/>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<and>
													<if-local-variable mode="regex" name="lv-og-value" op="equal">.+</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-src-attr-value name="$lv-gl-attr$">
													<arg-value type="string">
														<token-local-variable name="lv-og-value"/>
													</arg-value>
												</do-set-src-attr-value>
												<do-clear-src-attr-value name="$lv-og-attr$"/>
											</arg-actions>
											<arg-actions/>
										</do-if>
									</arg-actions>
								</do-for-each>
							</actions>
						</rule>
						<rule>
							<description>Remove carLicense Trigger</description>
							<conditions>
								<and/>
							</conditions>
							<actions>
								<do-remove-src-attr-value name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">MigrateGLAttrs</token-text>
									</arg-value>
								</do-remove-src-attr-value>
								<do-strip-op-attr name="carLicense"/>
							</actions>
						</rule>
						<rule>
							<description>Log Attribute Update</description>
							<conditions>
								<and/>
							</conditions>
							<actions>
								<do-set-local-variable name="lv-log-msg" scope="policy">
									<arg-string>
										<token-time format="yyyy-MM-dd HH:mm:ss" tz="UTC"/>
										<token-text xml:space="preserve"> - Greenlnk Attributes Migrated</token-text>
									</arg-string>
								</do-set-local-variable>
								<do-add-src-attr-value name="abcIDMActivity">
									<arg-value type="string">
										<token-local-variable name="lv-log-msg"/>
									</arg-value>
								</do-add-src-attr-value>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-PrepareEvent">
					<policy>
						<rule>
							<description>Break conditions</description>
							<conditions>
								<and>
									<if-operation mode="nocase" op="not-equal">modify</if-operation>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Add DestDN to all events</description>
							<comment xml:space="preserve">This is done to allow the driver to merge any new synthetic modifications into the current modification rather than creating a separate event. This is done so the WebAppNotificatoin objects will have all of the attribute updates in a single modification.</comment>
							<conditions/>
							<actions>
								<do-set-op-dest-dn>
									<arg-dn>
										<token-src-dn/>
									</arg-dn>
								</do-set-op-dest-dn>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-RegularEmployeeFlagProcessing">
					<policy>
						<rule>
							<description>Break now if a regular employee flag attrs are not changing</description>
							<comment xml:space="preserve">If none of these attrs are changing, we're done processing:
abcContractType
abcContractLength
physicalDeliveryOfficeName
abcDirectionAndControl
abcFullTimeExclusive
abcNDASigned
abcStaffingNoControl
abcStaffingNoAccess</comment>
							<conditions>
								<and>
									<if-op-attr name="abcContractType" op="not-changing"/>
									<if-op-attr name="abcContractLength" op="not-changing"/>
									<if-op-attr name="Physical Delivery Office Name" op="not-changing"/>
									<if-op-attr name="abcDirectionAndControl" op="not-changing"/>
									<if-op-attr name="abcFullTimeExclusive" op="not-changing"/>
									<if-op-attr name="abcNDASigned" op="not-changing"/>
									<if-op-attr name="abcStaffingNoControl" op="not-changing"/>
									<if-op-attr name="abcStaffingNoAccess" op="not-changing"/>
									<if-op-attr name="abcLastWorkingDay" op="not-changing"/>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Set abcReguarlEmployee to FALSE on all KSA-SA users.</description>
							<conditions>
								<or>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="equal">TRUE</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-strip-op-attr name="abcRegularEmployee"/>
								<do-strip-op-attr name="abcRegularEmployeeEvaluated"/>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break now if the user is terminated (or being terminated in this event)</description>
							<conditions>
								<and>
									<if-op-attr mode="regex" name="abcLastWorkingDay" op="changing-to">.+</if-op-attr>
									<if-op-attr mode="nocase" name="abcLastWorkingDay" op="not-equal">9999-12-31</if-op-attr>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="abcLastWorkingDay" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" dest-tz="UTC" src-format="yyyy-MM-dd">
											<token-attr name="abcLastWorkingDay"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lv-now" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" src-format="yyyy-MM-dd">
											<token-time format="yyyy-MM-dd"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-local-variable mode="numeric" name="abcLastWorkingDay" op="lt">$lv-now$</if-local-variable>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-trace-message level="0">
											<arg-string>
												<token-text xml:space="preserve">REGEMP: User was terminated, or is already terminated, and regular employee flags were cleared, stopping processing of regular employee and breaking now.</token-text>
											</arg-string>
										</do-trace-message>
										<do-break/>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Record previous regularEmployee status</description>
							<conditions/>
							<actions>
								<do-set-op-property name="regularEmpBeforeRecalc">
									<arg-string>
										<token-src-attr class-name="User" name="abcRegularEmployee"/>
									</arg-string>
								</do-set-op-property>
								<do-set-op-property name="regularEmpEvaluatedBeforeRecalc">
									<arg-string>
										<token-src-attr class-name="User" name="abcRegularEmployeeEvaluated"/>
									</arg-string>
								</do-set-op-property>
							</actions>
						</rule>
						<rule>
							<description>Category 1: Employee - Check contract type, break now if we have an employee</description>
							<comment xml:space="preserve">If user is marked as an employee, we're done, so set and exit.</comment>
							<conditions>
								<and>
									<if-attr mode="nocase" name="abcContractType" op="equal">Employee</if-attr>
								</and>
							</conditions>
							<actions>
								<do-strip-op-attr name="abcRegularEmployee"/>
								<do-strip-op-attr name="abcRegularEmployeeEvaluated"/>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Check for physicalDeliveryOfficeName or contractLength changes</description>
							<comment xml:space="preserve">If physicalDeliveryOfficeName or contractLength is changing, clear the boolean attrs. Also remove them from the event, so the next category forces a false/false - we need the ECO to review.

Since the clear source attr values doesn't happen until after the policy, we need to mark the needECO varaible as contract length and/or pdon are changing.

We still clean up the current document to follow the pattern of having the current doc match eDirectory; though it's only for consistentcy, and doesn't affect the next policy since it has to look in eDirectory directly anyway (as we won't always have the 5 booleans in the event)</comment>
							<conditions>
								<or>
									<if-op-attr name="abcContractLength" op="changing"/>
									<if-op-attr name="Physical Delivery Office Name" op="changing"/>
								</or>
							</conditions>
							<actions>
								<do-clear-src-attr-value name="abcDirectionAndControl"/>
								<do-clear-src-attr-value name="abcFullTimeExclusive"/>
								<do-clear-src-attr-value name="abcNDASigned"/>
								<do-clear-src-attr-value name="abcStaffingNoAccess"/>
								<do-clear-src-attr-value name="abcStaffingNoControl"/>
								<do-strip-op-attr name="abcDirectionAndControl"/>
								<do-strip-op-attr name="abcFullTimeExclusive"/>
								<do-strip-op-attr name="abcNDASigned"/>
								<do-strip-op-attr name="abcStaffingNoAccess"/>
								<do-strip-op-attr name="abcStaffingNoControl"/>
								<do-set-local-variable name="needECO" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Category 3: Non-Employee Rules</description>
							<comment xml:space="preserve">Check for Non-Employee RegularEmployee checking.</comment>
							<conditions>
								<and>
									<if-attr mode="numeric" name="abcContractLength" op="lt">365</if-attr>
									<if-attr mode="nocase" name="abcContractType" op="not-equal">Employee</if-attr>
								</and>
							</conditions>
							<actions>
								<do-strip-op-attr name="abcRegularEmployee"/>
								<do-strip-op-attr name="abcRegularEmployeeEvaluated"/>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break now if any Category 2 boolean attributes are missing. We are checking the operational attrs, not looking at eDirectory - the above do-clear attrs don't get processed until after the policy, hence the need to modify the current event, then look at the current event ONLY here.</description>
							<conditions>
								<or>
									<if-local-variable mode="nocase" name="needECO" op="equal">TRUE</if-local-variable>
									<if-attr name="abcDirectionAndControl" op="not-available"/>
									<if-attr name="abcFullTimeExclusive" op="not-available"/>
									<if-attr name="abcNDASigned" op="not-available"/>
									<if-attr name="abcStaffingNoControl" op="not-available"/>
									<if-attr name="abcStaffingNoAccess" op="not-available"/>
								</or>
							</conditions>
							<actions>
								<do-strip-op-attr name="abcRegularEmployee"/>
								<do-strip-op-attr name="abcRegularEmployeeEvaluated"/>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Set up variables for Category 2 processing</description>
							<conditions/>
							<actions>
								<do-set-local-variable name="physicalDeliveryOfficeNameDescription" scope="policy">
									<arg-string>
										<token-map dest="Description" src="Name" table="..\..\HRDS-Dynamic-Tables\ORG_LOCATION">
											<token-attr name="Physical Delivery Office Name"/>
										</token-map>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Category 2: Check 7 attributes</description>
							<comment xml:space="preserve">Since user wasn't an employee; we have to check the remaining 7 values.</comment>
							<conditions>
								<and>
									<if-attr mode="numeric" name="abcContractLength" op="gt">364</if-attr>
									<if-local-variable mode="regex" name="physicalDeliveryOfficeNameDescription" op="equal">.+</if-local-variable>
									<if-attr mode="regex" name="abcDirectionAndControl" op="equal">TRUE</if-attr>
									<if-attr mode="regex" name="abcFullTimeExclusive" op="equal">TRUE</if-attr>
									<if-attr mode="regex" name="abcNDASigned" op="equal">TRUE</if-attr>
									<if-attr mode="regex" name="abcStaffingNoControl" op="equal">TRUE</if-attr>
									<if-attr mode="regex" name="abcStaffingNoAccess" op="equal">TRUE</if-attr>
								</and>
							</conditions>
							<actions>
								<do-strip-op-attr name="abcRegularEmployee"/>
								<do-strip-op-attr name="abcRegularEmployeeEvaluated"/>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>User is not a regular employee, mark it as such</description>
							<comment xml:space="preserve">We set the attribute in src in edir, and in dest in the resulting event so that later policies have a chance to review the updates and react if needed (regular employee flag is an EC sensitive attribute).</comment>
							<conditions/>
							<actions>
								<do-strip-op-attr name="abcRegularEmployee"/>
								<do-strip-op-attr name="abcRegularEmployeeEvaluated"/>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployee">
									<arg-value type="string">
										<token-text xml:space="preserve">FALSE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-set-src-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-src-attr-value>
								<do-set-dest-attr-value class-name="User" name="abcRegularEmployeeEvaluated">
									<arg-value type="string">
										<token-text xml:space="preserve">TRUE</token-text>
									</arg-value>
								</do-set-dest-attr-value>
								<do-break/>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-SecondmentSwitch">
					<policy>
						<rule disabled="true">
							<description>OPTIONAL: DISABLE SECONDMENT</description>
							<comment xml:space="preserve">This makes it easy to disable secondment support if we need to speed up the driver during initial migration or other times.(df92)</comment>
							<conditions/>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break if not user</description>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
									<if-operation mode="regex" op="not-equal">add|modify</if-operation>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="equal">TRUE</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>ONE TIME: Initialize Secondment checking table</description>
							<conditions>
								<and>
									<if-local-variable name="memorySecTable" op="not-available"/>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="memorySecTable" scope="driver">
									<arg-node-set>
										<token-document>
											<arg-string>
												<token-text xml:space="preserve">vnd.nds.stream:/</token-text>
												<token-replace-all regex="\\" replace-with="/">
													<token-parse-dn dest-dn-format="dest-dn" length="-2" src-dn-format="dest-dn">
														<token-global-variable name="dirxml.auto.driverdn"/>
													</token-parse-dn>
												</token-replace-all>
												<token-text xml:space="preserve">/Operational-Data/SecondmentMappings#DirXML-Data</token-text>
											</arg-string>
										</token-document>
									</arg-node-set>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Check Manual trigger of Secondment verification</description>
							<comment xml:space="preserve">This gives us an ability to request that the Service driver do a manual review of secondment data; so if we need to shut off this code we can.</comment>
							<conditions>
								<or>
									<if-attr mode="nocase" name="carLicense" op="equal">secondment</if-attr>
								</or>
							</conditions>
							<actions>
								<do-remove-src-attr-value class-name="User" name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">secondment</token-text>
									</arg-value>
								</do-remove-src-attr-value>
								<do-strip-op-attr name="carLicense"/>
								<do-set-local-variable name="attrsChanging" scope="policy">
									<arg-string>
										<token-text xml:space="preserve">true-secondment</token-text>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Loop through table checking to see if attrs are changing in the current doc.</description>
							<comment xml:space="preserve">Note: we're checking only secondment and primary attribute values: if ANY of them change, we review ALL of them and ensure the user is pushed properly into or out of secondment. The large xpath below just returns a node set of the attributes that doesn't include the 'current' column: if they change, we just ignore it as there are some corner cases where other systems may update the current versions directly.

if attrsChanging is arleady set, it means we can skip the validation here, and just do the secondment update.</comment>
							<conditions>
								<or>
									<if-local-variable name="attrsChanging" op="not-available"/>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable disabled="true" name="attrsChanging" scope="policy">
									<arg-string/>
								</do-set-local-variable>
								<do-for-each>
									<arg-node-set>
										<token-xpath expression="$memorySecTable/mapping-table/row/col[not(position() = count(/mapping-table/col-def[@name='current']/preceding-sibling::col-def)+1)]/text()"/>
									</arg-node-set>
									<arg-actions>
										<do-if>
											<arg-conditions>
												<and>
													<if-op-attr name="$current-node$" op="changing"/>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="attrsChanging" scope="policy">
													<arg-string>
														<token-local-variable name="attrsChanging"/>
														<token-text xml:space="preserve">true</token-text>
													</arg-string>
												</do-set-local-variable>
											</arg-actions>
											<arg-actions/>
										</do-if>
									</arg-actions>
								</do-for-each>
								<do-if>
									<arg-conditions>
										<or>
											<if-op-attr name="abcStartDateSec" op="changing"/>
											<if-op-attr name="abcEndDateSec" op="changing"/>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="attrsChanging" scope="policy">
											<arg-string>
												<token-local-variable name="attrsChanging"/>
												<token-text xml:space="preserve">true</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Exit if none of our secondment related attributes are changing.</description>
							<conditions>
								<or>
									<if-local-variable mode="regex" name="attrsChanging" op="not-equal">.+</if-local-variable>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Secondment: prepare to check if we're on secondment or not.</description>
							<comment xml:space="preserve">Pick up the start and end dates, and convert them all to seconds since 1970 to make an easy comparison.

 - If we're missing an end date, assume it to be 9999-12-31, the highest possible date value we can hold.</comment>
							<conditions/>
							<actions>
								<do-set-local-variable name="now" scope="policy">
									<arg-string>
										<token-time format="!CTIME" tz="GMT"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-attr mode="regex" name="abcStartDateSec" op="equal">.*</if-attr>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="abcStartDateSec" scope="policy">
											<arg-string>
												<token-convert-time dest-format="!CTIME" dest-tz="GMT" src-format="yyyy-MM-dd" src-tz="GMT">
													<token-attr name="abcStartDateSec"/>
												</token-convert-time>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="abcStartDateSec" scope="policy">
											<arg-string/>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-attr mode="regex" name="abcEndDateSec" op="equal">.*</if-attr>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="abcEndDateSec" scope="policy">
											<arg-string>
												<token-convert-time dest-format="!CTIME" dest-tz="GMT" src-format="yyyy-MM-dd" src-tz="GMT">
													<token-attr name="abcEndDateSec"/>
												</token-convert-time>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="abcEndDateSec" scope="policy">
											<arg-string/>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($abcStartDateSec) = 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message level="0">
											<arg-string>
												<token-text xml:space="preserve">EMAIL: Secondment values appear to be changing; but we can't get a valid start date, defaulting to primary!.</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($abcEndDateSec) = 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="abcEndDateSec" scope="policy">
											<arg-string>
												<token-convert-time dest-format="!CTIME" dest-tz="GMT" src-format="yyyy-MM-dd" src-tz="GMT">
													<token-text xml:space="preserve">9999-12-31</token-text>
												</token-convert-time>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Secondment: see if we're on secondment: default to primary if we can't get a hold of the start/end dates.</description>
							<conditions/>
							<actions>
								<do-if>
									<arg-conditions>
										<or>
											<if-xpath op="true">$abcStartDateSec &lt; $now and $now &lt; $abcEndDateSec</if-xpath>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="attrSelection" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">secondment</token-text>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="abcSeconded" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">true</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="attrSelection" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">primary</token-text>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="abcSeconded" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">false</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Secondment: Whether we're on secondment or not, lets copy all of the data from the proper source column to the 'current' attributes.</description>
							<comment xml:space="preserve">Loop through the table, setting the current values equal to the secondment/non-secondment values as needed. The XPath below just always grabs the attribute designated as 'current' so we're setting the correct attr. Note: we set source to make the changes, and set dest to let remaining policies have a chance to process (such as manager updates). We also clear the current value; if it was the value that was changed to bring us into this policy in the first place.
Note: Only set removed-values on modifies - if this is an add event, it will end up sending multiple modifies.
</comment>
							<conditions/>
							<actions>
								<do-for-each>
									<arg-node-set>
										<token-xpath expression="$memorySecTable/mapping-table/row/col[position() = count(/mapping-table/col-def[@name='current']/preceding-sibling::col-def)+1]"/>
									</arg-node-set>
									<arg-actions>
										<do-set-local-variable name="sourceAttr" scope="policy">
											<arg-string>
												<token-map dest="$attrSelection$" src="current" table="..\..\Operational-Data\SecondmentMappings">
													<token-local-variable name="current-node"/>
												</token-map>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="sourceAttrValue" scope="policy">
											<arg-string>
												<token-attr name="$sourceAttr$"/>
											</arg-string>
										</do-set-local-variable>
										<do-strip-op-attr name="$current-node$"/>
										<do-if>
											<arg-conditions>
												<and>
													<if-local-variable mode="regex" name="sourceAttrValue" op="equal">.+</if-local-variable>
												</and>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="OldeDirValue" scope="policy">
													<arg-string>
														<token-removed-attr name="$sourceAttr$"/>
													</arg-string>
												</do-set-local-variable>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="true">starts-with($sourceAttr, 'abcBusLevel2Code')</if-xpath>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="OldeDirValue" scope="policy">
															<arg-string>
																<token-attr name="abcBusLevel2Code"/>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
												</do-if>
												<do-set-src-attr-value class-name="User" name="$current-node$">
													<arg-value type="string">
														<token-local-variable name="sourceAttrValue"/>
													</arg-value>
												</do-set-src-attr-value>
												<do-set-dest-attr-value class-name="User" disabled="true" name="$current-node$" notrace="true">
													<arg-value type="string">
														<token-local-variable name="sourceAttrValue"/>
													</arg-value>
												</do-set-dest-attr-value>
												<do-if>
													<arg-conditions>
														<and>
															<if-operation op="equal">modify</if-operation>
															<if-local-variable mode="regex" name="OldeDirValue" op="equal">.+</if-local-variable>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-remove-dest-attr-value class-name="abcUser" name="$current-node$">
															<arg-value type="string">
																<token-local-variable name="OldeDirValue"/>
															</arg-value>
														</do-remove-dest-attr-value>
														<do-add-dest-attr-value class-name="abcUser" name="$current-node$">
															<arg-value type="string">
																<token-local-variable name="sourceAttrValue"/>
															</arg-value>
														</do-add-dest-attr-value>
													</arg-actions>
													<arg-actions>
														<do-set-dest-attr-value class-name="User" name="$current-node$">
															<arg-value type="string">
																<token-local-variable name="sourceAttrValue"/>
															</arg-value>
														</do-set-dest-attr-value>
													</arg-actions>
												</do-if>
											</arg-actions>
											<arg-actions>
												<do-clear-src-attr-value name="$current-node$"/>
												<do-if>
													<arg-conditions>
														<and>
															<if-local-variable mode="nocase" name="current-node" op="equal">managerWorkforceID</if-local-variable>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-trace-message level="6">
															<arg-string>
																<token-text xml:space="preserve">Putting managerWorkforceID in the event to fire the manager change code - ckynaston Fuse update AS-2686</token-text>
															</arg-string>
														</do-trace-message>
														<do-clear-dest-attr-value class-name="User" name="managerWorkforceID"/>
													</arg-actions>
													<arg-actions/>
												</do-if>
											</arg-actions>
										</do-if>
									</arg-actions>
								</do-for-each>
								<do-set-src-attr-value name="abcSeconded">
									<arg-value type="string">
										<token-local-variable name="abcSeconded"/>
									</arg-value>
								</do-set-src-attr-value>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-SetOverrideLegalEntityAttrs">
					<policy>
						<rule>
							<description>Clear the override legal entity values on terms and bu changes</description>
							<comment xml:space="preserve">Entity name is done as a removal rather than clear so the notificaiton object code will fire.</comment>
							<conditions>
								<or>
									<if-op-property mode="nocase" name="ClearOverrideLegalEntityAttrs" op="equal">TRUE</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="currentOverrideLegalEntityValue" scope="policy">
									<arg-string>
										<token-attr name="abcOverrideLegalEntityName"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="regex" name="currentOverrideLegalEntityValue" op="not-equal">^$</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-add-dest-attr-value name="abcOverrideLegalEntityHistory">
											<arg-value type="string">
												<token-time format="yyyy-MM-dd'T'HH:mm:ss"/>
												<token-text xml:space="preserve">~~~~IDM~~~~remove~~~~</token-text>
												<token-local-variable name="currentOverrideLegalEntityValue"/>
												<token-text xml:space="preserve">~~~~</token-text>
											</arg-value>
										</do-add-dest-attr-value>
										<do-add-src-attr-value class-name="User" name="abcOverrideLegalEntityHistory">
											<arg-value type="string">
												<token-time format="yyyy-MM-dd'T'HH:mm:ss"/>
												<token-text xml:space="preserve">~~~~IDM~~~~remove~~~~</token-text>
												<token-local-variable name="currentOverrideLegalEntityValue"/>
												<token-text xml:space="preserve">~~~~</token-text>
											</arg-value>
										</do-add-src-attr-value>
										<do-remove-dest-attr-value class-name="User" name="abcOverrideLegalEntityName">
											<arg-value type="string">
												<token-local-variable name="currentOverrideLegalEntityValue"/>
											</arg-value>
										</do-remove-dest-attr-value>
										<do-remove-src-attr-value class-name="User" name="abcOverrideLegalEntityName">
											<arg-value type="string">
												<token-local-variable name="currentOverrideLegalEntityValue"/>
											</arg-value>
										</do-remove-src-attr-value>
										<do-clear-dest-attr-value name="abcOverrideLegalEntityCode"/>
										<do-clear-src-attr-value class-name="User" name="abcOverrideLegalEntityCode"/>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-StopProcessing">
					<policy>
						<rule>
							<description>Stop all standard events.</description>
							<comment xml:space="preserve">When processing reaches this rule, we're done; so stop all standard events. We don't just blindly block all 22 xds events, just the core events: add|modify|move|rename|delete|sync</comment>
							<conditions>
								<and>
									<if-operation mode="regex" op="equal">add|modify|move|rename|delete|sync</if-operation>
								</and>
							</conditions>
							<actions>
								<do-veto/>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-SyncFuse">
					<policy>
						<rule>
							<description>Trigger sync in Fuse</description>
							<comment xml:space="preserve">Trigger a sync in the Fuse Driver.</comment>
							<conditions>
								<and>
									<if-op-attr name="abcFuseID" op="available"/>
									<if-op-attr mode="nocase" name="abcFuseID" op="changing-from">pending</if-op-attr>
								</and>
							</conditions>
							<actions>
								<do-set-src-attr-value class-name="User" name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">syncFuse</token-text>
									</arg-value>
								</do-set-src-attr-value>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-UserTermination">
					<policy>
						<rule>
							<description>User Objects Only (No KSA-SAP Users)</description>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="equal">TRUE</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Last Day Worked set to the past, or carLicence notifier set to 'terminate'</description>
							<comment xml:space="preserve">When Last Day Worked is set to a value in the past or carLicence = terminate - process the termination.
Create a WebAppNotification object to notify the WebApp.
If abcLastWorkingDay is changing, and it is in the future, this is a rehire. Clear the deletion dates (found in the second if statement) (Defect 244)</comment>
							<conditions>
								<or>
									<if-op-attr name="abcLastWorkingDay" op="changing"/>
									<if-op-attr mode="nocase" name="carLicense" op="equal">terminate</if-op-attr>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="abcLastWorkingDay" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" dest-tz="UTC" src-format="yyyy-MM-dd">
											<token-attr name="abcLastWorkingDay"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lv-now" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" src-format="yyyy-MM-dd">
											<token-time format="yyyy-MM-dd"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-op-attr mode="nocase" name="carLicense" op="equal">terminate</if-op-attr>
											<if-local-variable mode="numeric" name="abcLastWorkingDay" op="lt">$lv-now$</if-local-variable>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-op-property name="containsTermination">
											<arg-string>
												<token-text xml:space="preserve">true</token-text>
											</arg-string>
										</do-set-op-property>
										<do-set-op-property name="ClearOverrideLegalEntityAttrs">
											<arg-string>
												<token-text xml:space="preserve">TRUE</token-text>
											</arg-string>
										</do-set-op-property>
										<do-set-src-attr-value name="abcEligibility">
											<arg-value type="string">
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcEligibility">
											<arg-value type="string">
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value name="abcRegularEmployee">
											<arg-value type="string">
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcRegularEmployee">
											<arg-value type="string">
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value name="abcRegularEmployeeEvaluated">
											<arg-value type="string">
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcRegularEmployeeEvaluated">
											<arg-value type="string">
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value name="abcIsUserComplete">
											<arg-value type="string">
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcIsUserComplete">
											<arg-value type="string">
												<token-text xml:space="preserve">FALSE</token-text>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value name="abcUserDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="6" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcLastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcUserDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="6" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcLastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value name="abcUserMinimumDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="6" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcLastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcUserMinimumDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="6" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcLastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value name="abcUserMaximumDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="10" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcLastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcUserMaximumDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="10" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcLastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-dest-attr-value>
										<do-remove-src-attr-value class-name="User" name="Group Membership">
											<arg-value type="dn">
												<token-text xml:space="preserve">abcS\Groups\DAC</token-text>
											</arg-value>
										</do-remove-src-attr-value>
										<do-remove-src-attr-value class-name="User" name="Group Membership">
											<arg-value type="dn">
												<token-text xml:space="preserve">abcS\Groups\EC</token-text>
											</arg-value>
										</do-remove-src-attr-value>
										<do-remove-src-attr-value class-name="User" name="Group Membership">
											<arg-value type="dn">
												<token-text xml:space="preserve">abcS\Groups\NSFAdmin</token-text>
											</arg-value>
										</do-remove-src-attr-value>
										<do-remove-src-attr-value class-name="User" name="Group Membership">
											<arg-value type="dn">
												<token-text xml:space="preserve">abcS\Groups\AA</token-text>
											</arg-value>
										</do-remove-src-attr-value>
										<do-remove-src-attr-value class-name="User" name="Group Membership">
											<arg-value type="dn">
												<token-text xml:space="preserve">abcS\Groups\GEC</token-text>
											</arg-value>
										</do-remove-src-attr-value>
										<do-remove-src-attr-value class-name="User" name="Group Membership">
											<arg-value type="dn">
												<token-text xml:space="preserve">abcS\Groups\AMA</token-text>
											</arg-value>
										</do-remove-src-attr-value>
										<do-set-local-variable name="src-name">
											<arg-string>
												<token-src-name/>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<or>
													<if-xpath op="true">starts-with($src-name, 'idmunit')</if-xpath>
												</or>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="idmunitPrefix">
													<arg-string>
														<token-text xml:space="preserve">idmunit</token-text>
													</arg-string>
												</do-set-local-variable>
											</arg-actions>
										</do-if>
										<do-set-local-variable name="webAppNotificationDN">
											<arg-string>
												<token-global-variable name="idv.dit.data.webappnotifications"/>
												<token-text xml:space="preserve">\</token-text>
												<token-local-variable name="idmunitPrefix"/>
												<token-time format="yyyy-MM-dd-hhmmssSSS"/>
											</arg-string>
										</do-set-local-variable>
										<do-add-src-object class-name="abcWebAppNotification">
											<arg-dn>
												<token-local-variable name="webAppNotificationDN"/>
											</arg-dn>
										</do-add-src-object>
										<do-add-src-attr-value name="abcTargetObject">
											<arg-dn>
												<token-local-variable name="webAppNotificationDN"/>
											</arg-dn>
											<arg-value>
												<token-src-dn/>
											</arg-value>
										</do-add-src-attr-value>
										<do-set-local-variable name="removeVRSAssociation" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">TRUE</token-text>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="removeSFAssociation" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">TRUE</token-text>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="terminateFuse" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">TRUE</token-text>
											</arg-string>
										</do-set-local-variable>
										<do-trace-message level="6">
											<arg-string>
												<token-text xml:space="preserve">carLicense is not stripped yet so it can cause the is user complete policy later.</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
									<arg-actions/>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-op-attr name="abcLastWorkingDay" op="changing"/>
											<if-local-variable mode="numeric" name="abcLastWorkingDay" op="gt">$lv-now$</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-clear-src-attr-value name="abcUserDeletionDate"/>
										<do-clear-src-attr-value name="abcUserMinimumDeletionDate"/>
										<do-clear-src-attr-value name="abcUserMaximumDeletionDate"/>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Remove VRS association if needed</description>
							<comment xml:space="preserve">Remove the VRS association if instructed: this means we terminated for some reason; and need to remove just that driver's association.</comment>
							<conditions>
								<or>
									<if-local-variable mode="nocase" name="removeVRSAssociation" op="equal">TRUE</if-local-variable>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="userAssociations" scope="policy">
									<arg-node-set>
										<token-attr name="DirXML-Associations"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-set-local-variable name="vrsAssociation" scope="policy">
									<arg-node-set>
										<token-xpath expression="$userAssociations[contains(component[@name='volume'], '~driverVRS~') ]"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($vrsAssociation) &gt; 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-remove-src-attr-value class-name="User" name="DirXML-Associations">
											<arg-value type="structured">
												<arg-component name="nameSpace">
													<token-xpath expression="$vrsAssociation/component[@name='nameSpace']/text()"/>
												</arg-component>
												<arg-component name="volume">
													<token-xpath expression="$vrsAssociation/component[@name='volume']/text()"/>
												</arg-component>
												<arg-component name="path">
													<token-xpath expression="$vrsAssociation/component[@name='path']/text()"/>
												</arg-component>
											</arg-value>
										</do-remove-src-attr-value>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Remove SF association if needed</description>
							<comment xml:space="preserve">Remove the SF association if instructed: this means we terminated for some reason; and need to remove just that driver's association.</comment>
							<conditions>
								<or>
									<if-local-variable mode="nocase" name="removeSFAssociation" op="equal">TRUE</if-local-variable>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="userAssociations" scope="policy">
									<arg-node-set>
										<token-attr name="DirXML-Associations"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-set-local-variable name="sfAssociation" scope="policy">
									<arg-node-set>
										<token-xpath expression="$userAssociations[contains(component[@name='volume'], '~driverSF~') ]"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($sfAssociation) &gt; 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-remove-src-attr-value class-name="User" name="DirXML-Associations">
											<arg-value type="structured">
												<arg-component name="nameSpace">
													<token-xpath expression="$sfAssociation/component[@name='nameSpace']/text()"/>
												</arg-component>
												<arg-component name="volume">
													<token-xpath expression="$sfAssociation/component[@name='volume']/text()"/>
												</arg-component>
												<arg-component name="path">
													<token-xpath expression="$sfAssociation/component[@name='path']/text()"/>
												</arg-component>
											</arg-value>
										</do-remove-src-attr-value>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Terminate User in Fuse</description>
							<comment xml:space="preserve">Trigger user termination in the Fuse Driver</comment>
							<conditions>
								<or>
									<if-local-variable mode="nocase" name="terminateFuse" op="equal">TRUE</if-local-variable>
								</or>
							</conditions>
							<actions>
								<do-set-src-attr-value name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">terminateFuse</token-text>
									</arg-value>
								</do-set-src-attr-value>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-UserTermination-KSA-SAP">
					<policy>
						<rule>
							<description>KSA-SAP User Objects Only</description>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="not-equal">TRUE</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Last Day Worked set to the past, or carLicence notifier set to 'terminate'</description>
							<comment xml:space="preserve">When Last Day Worked is set to a value in the past or carLicence = terminate - process the termination.
If abcSAPKSALastWorkingDay is changing, and it is in the future, this is a rehire. Clear the deletion dates (found in the second if statement) (Defect 244)</comment>
							<conditions>
								<or>
									<if-op-attr name="abcSAPKSALastWorkingDay" op="changing"/>
									<if-op-attr mode="nocase" name="carLicense" op="equal">terminate</if-op-attr>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="abcSAPKSALastWorkingDay" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" dest-tz="UTC" src-format="yyyy-MM-dd">
											<token-attr name="abcSAPKSALastWorkingDay"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="lv-now" scope="policy">
									<arg-string>
										<token-convert-time dest-format="!CTIME" src-format="yyyy-MM-dd">
											<token-time format="yyyy-MM-dd"/>
										</token-convert-time>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-op-attr mode="nocase" name="carLicense" op="equal">terminate</if-op-attr>
											<if-local-variable mode="numeric" name="abcSAPKSALastWorkingDay" op="lt">$lv-now$</if-local-variable>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-op-property name="containsTermination">
											<arg-string>
												<token-text xml:space="preserve">true</token-text>
											</arg-string>
										</do-set-op-property>
										<do-set-local-variable name="removeSAPAssociation" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">TRUE</token-text>
											</arg-string>
										</do-set-local-variable>
										<do-set-local-variable name="logMessage" scope="policy">
											<arg-string>
												<token-time format="dd-MMM-yyyy HH:mm:ss"/>
												<token-text xml:space="preserve">: Terminated object: </token-text>
												<token-src-dn/>
												<token-text xml:space="preserve"> : </token-text>
												<token-src-attr name="abcGCINumber"/>
												<token-text xml:space="preserve"> : </token-text>
												<token-src-attr name="abcSAPKSAClockNumber"/>
												<token-text xml:space="preserve"> : </token-text>
												<token-src-attr name="abcSAPKSALastWorkingDay"/>
												<token-text xml:space="preserve"> : </token-text>
												<token-src-attr name="abcSandlnkMail"/>
											</arg-string>
										</do-set-local-variable>
										<do-add-src-attr-value class-name="User" name="abcIDMActivity">
											<arg-value type="string">
												<token-text xml:space="preserve">IDM: [~dirxml.auto.driverdn~] : </token-text>
												<token-local-variable name="logMessage"/>
											</arg-value>
										</do-add-src-attr-value>
										<do-set-src-attr-value name="abcUserDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="6" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcSAPKSALastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcUserDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="6" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcSAPKSALastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value name="abcUserMinimumDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="6" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcSAPKSALastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcUserMinimumDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="6" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcSAPKSALastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-dest-attr-value>
										<do-set-src-attr-value name="abcUserMaximumDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="10" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcSAPKSALastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-src-attr-value>
										<do-set-dest-attr-value name="abcUserMaximumDeletionDate">
											<arg-value type="string">
												<token-convert-time dest-format="yyyy-MM-dd" offset="10" offset-unit="year" src-format="!CTIME" src-tz="UTC">
													<token-local-variable name="abcSAPKSALastWorkingDay"/>
												</token-convert-time>
											</arg-value>
										</do-set-dest-attr-value>
										<do-remove-src-attr-value name="Object Class">
											<arg-value type="string">
												<token-text xml:space="preserve">abcSAPKSA</token-text>
											</arg-value>
										</do-remove-src-attr-value>
										<do-set-local-variable name="src-name">
											<arg-string>
												<token-src-name/>
											</arg-string>
										</do-set-local-variable>
										<do-if>
											<arg-conditions>
												<or>
													<if-xpath op="true">starts-with($src-name, 'idmunit')</if-xpath>
												</or>
											</arg-conditions>
											<arg-actions>
												<do-set-local-variable name="idmunitPrefix">
													<arg-string>
														<token-text xml:space="preserve">idmunit</token-text>
													</arg-string>
												</do-set-local-variable>
											</arg-actions>
										</do-if>
										<do-set-local-variable name="terminateFuse" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">TRUE</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions/>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-op-attr name="abcSAPKSALastWorkingDay" op="changing"/>
											<if-local-variable mode="numeric" name="abcSAPKSALastWorkingDay" op="gt">$lv-now$</if-local-variable>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-clear-src-attr-value name="abcUserDeletionDate"/>
										<do-clear-src-attr-value name="abcUserMinimumDeletionDate"/>
										<do-clear-src-attr-value name="abcUserMaximumDeletionDate"/>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Remove KSA-SAP association if needed</description>
							<conditions>
								<or>
									<if-local-variable mode="nocase" name="removeSAPAssociation" op="equal">TRUE</if-local-variable>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="userAssociations" scope="policy">
									<arg-node-set>
										<token-attr name="DirXML-Associations"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-set-local-variable name="KSA-SAPAssociation" scope="policy">
									<arg-node-set>
										<token-xpath expression="$userAssociations[contains(component[@name='volume'], '~driverKSA-SAP~') ]"/>
									</arg-node-set>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-xpath op="true">string-length($KSA-SAPAssociation) &gt; 0</if-xpath>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-remove-src-attr-value class-name="User" name="DirXML-Associations">
											<arg-value type="structured">
												<arg-component name="nameSpace">
													<token-xpath expression="$KSA-SAPAssociation/component[@name='nameSpace']/text()"/>
												</arg-component>
												<arg-component name="volume">
													<token-xpath expression="$KSA-SAPAssociation/component[@name='volume']/text()"/>
												</arg-component>
												<arg-component name="path">
													<token-xpath expression="$KSA-SAPAssociation/component[@name='path']/text()"/>
												</arg-component>
											</arg-value>
										</do-remove-src-attr-value>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Clear carLicense when the termination is complete</description>
							<comment xml:space="preserve">This is done here in this KSA-SAP policy. It is done later in the driver for SF users because this is part of the abcUserComplete policy.</comment>
							<conditions>
								<or>
									<if-op-attr mode="nocase" name="carLicense" op="equal">terminate</if-op-attr>
								</or>
							</conditions>
							<actions>
								<do-strip-op-attr name="carLicense"/>
								<do-clear-src-attr-value class-name="User" name="carLicense"/>
							</actions>
						</rule>
						<rule>
							<description>Terminate User in Fuse</description>
							<comment xml:space="preserve">Trigger user termination in the Fuse Driver</comment>
							<conditions>
								<or>
									<if-local-variable mode="nocase" name="terminateFuse" op="equal">TRUE</if-local-variable>
								</or>
							</conditions>
							<actions>
								<do-set-src-attr-value name="carLicense">
									<arg-value type="string">
										<token-text xml:space="preserve">terminateFuse</token-text>
									</arg-value>
								</do-set-src-attr-value>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-WebAppNotificationObjectProcessing">
					<policy>
						<rule>
							<description>Break if not user or licence.</description>
							<conditions>
								<and>
									<if-operation mode="nocase" op="not-equal">modify</if-operation>
								</and>
								<and>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
									<if-class-name mode="nocase" op="not-equal">abcLicence</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Appx I: Check EC sensitive attributes, and notify WebApp of Notifications</description>
							<conditions>
								<and>
									<if-local-variable name="ecAttrs" op="not-available"/>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="ecAttrs" scope="driver">
									<arg-node-set>
										<token-document>
											<arg-string>
												<token-text xml:space="preserve">vnd.nds.stream:/</token-text>
												<token-replace-all regex="\\" replace-with="/">
													<token-parse-dn dest-dn-format="dest-dn" length="-2" src-dn-format="dest-dn">
														<token-global-variable name="dirxml.auto.driverdn"/>
													</token-parse-dn>
												</token-replace-all>
												<token-text xml:space="preserve">/Operational-Data/EC Sensitive Attributes#DirXML-Data</token-text>
											</arg-string>
										</token-document>
									</arg-node-set>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Set variables</description>
							<conditions/>
							<actions>
								<do-set-local-variable name="class-name">
									<arg-string>
										<token-class-name/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="nowSecondsSince1970" scope="policy">
									<arg-string>
										<token-time format="!CTIME" tz="UTC"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-attr name="abcLevelOfECTraining" op="equal">Enhanced</if-attr>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="trainingLifetimeSeconds">
											<arg-string>
												<token-xpath expression="~TrainingLifetimeEnhanced~ * 86400"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="trainingLifetimeSeconds">
											<arg-string>
												<token-xpath expression="~TrainingLifetimeAwareness~ * 86400"/>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-set-local-variable name="src-name" scope="policy">
									<arg-string>
										<token-lower-case>
											<token-src-name/>
										</token-lower-case>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-xpath op="true">starts-with($src-name, 'idmunit')</if-xpath>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="idmunitPrefix">
											<arg-string>
												<token-text xml:space="preserve">idmunit</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-set-local-variable name="webAppNotificationDN">
									<arg-string>
										<token-global-variable name="idv.dit.data.webappnotifications"/>
										<token-text xml:space="preserve">\</token-text>
										<token-local-variable name="idmunitPrefix"/>
										<token-time format="yyyy-MM-dd-hhmmssSSS"/>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
						<rule>
							<description>Strip attributes that are not actually chanigng (RegEmployee)</description>
							<comment xml:space="preserve">Some attributes are in the event to help with other processing, but don't need to be written to the tree.</comment>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
								</or>
								<or>
									<if-op-attr name="abcRegularEmployee" op="changing"/>
									<if-op-attr name="abcRegularEmployeeEvaluated" op="changing"/>
								</or>
								<or>
									<if-op-attr mode="nocase" name="abcContractType" op="not-changing-to">Employee</if-op-attr>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="regularEmpRecalculated" scope="policy">
									<arg-string>
										<token-op-attr name="abcRegularEmployee"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="regularEmpEvaluatedRecalculated" scope="policy">
									<arg-string>
										<token-op-attr name="abcRegularEmployeeEvaluated"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-op-property mode="nocase" name="regularEmpBeforeRecalc" op="equal">$regularEmpRecalculated$</if-op-property>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcRegularEmployee"/>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="notifySent" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">notifySent</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-op-property mode="nocase" name="regularEmpEvaluatedBeforeRecalc" op="equal">$regularEmpEvaluatedRecalculated$</if-op-property>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcRegularEmployeeEvaluated"/>
									</arg-actions>
									<arg-actions>
										<do-set-local-variable name="notifySent" scope="policy">
											<arg-string>
												<token-text xml:space="preserve">notifySent</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">debug - regularEmp notify time - </token-text>
										<token-text xml:space="preserve">cn: </token-text>
										<token-src-name/>
										<token-text xml:space="preserve"> regularEmp: </token-text>
										<token-op-property name="regularEmpBeforeRecalc"/>
										<token-text xml:space="preserve">-&gt;</token-text>
										<token-local-variable name="regularEmpRecalculated"/>
										<token-text xml:space="preserve"> evaluated: </token-text>
										<token-op-property name="regularEmpEvaluatedBeforeRecalc"/>
										<token-text xml:space="preserve">-&gt;</token-text>
										<token-local-variable name="regularEmpEvaluatedRecalculated"/>
										<token-text xml:space="preserve"> </token-text>
										<token-local-variable name="notifySent"/>
									</arg-string>
								</do-trace-message>
							</actions>
						</rule>
						<rule disabled="true">
							<description>DISABLED - Strip attributes that are not actually chanigng (RegEmployee)</description>
							<comment xml:space="preserve">DISABLED. Removed when fixing the bug where notifications didn't get generated for reg emp changes. Left hear to re-enable for some IdMUnit testing...</comment>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
								</or>
								<or>
									<if-op-attr name="abcRegularEmployee" op="changing"/>
									<if-op-attr name="abcRegularEmployeeEvaluated" op="changing"/>
								</or>
								<or>
									<if-op-attr mode="nocase" name="abcContractType" op="not-changing-to">Employee</if-op-attr>
								</or>
							</conditions>
							<actions>
								<do-set-local-variable name="RegEmployeeVarPrev" scope="policy">
									<arg-string>
										<token-xpath expression="modify-attr[@attr-name=&quot;abcRegularEmployee&quot;]/remove-value/value/text()"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="RegEmployeeEvalVarPrev" scope="policy">
									<arg-string>
										<token-xpath expression="modify-attr[@attr-name=&quot;abcRegularEmployeeEvaluated&quot;]/remove-value/value/text()"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="RegEmployeeVar" scope="policy">
									<arg-string>
										<token-src-attr class-name="User" name="abcRegularEmployee"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="RegEmployeeEvalVar" scope="policy">
									<arg-string>
										<token-src-attr class-name="User" name="abcRegularEmployeeEvaluated"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="regex" name="RegEmployeeVarPrev" op="equal">^$</if-local-variable>
											<if-op-attr mode="nocase" name="abcRegularEmployee" op="equal">$RegEmployeeVar$</if-op-attr>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcRegularEmployee"/>
									</arg-actions>
									<arg-actions/>
								</do-if>
								<do-if>
									<arg-conditions>
										<and>
											<if-local-variable mode="regex" name="RegEmployeeEvalVarPrev" op="equal">^$</if-local-variable>
											<if-op-attr mode="nocase" name="abcRegularEmployeeEvaluated" op="equal">$RegEmployeeEvalVar$</if-op-attr>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcRegularEmployeeEvaluated"/>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Strip attributes that are not actually chanigng (LastWorkingDay = 9 9 9 9)</description>
							<comment xml:space="preserve">Some attributes are in the event to help with other processing, but don't need to be written to the tree.</comment>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
									<if-op-attr mode="nocase" name="abcLastWorkingDay" op="changing-to">9999-12-31</if-op-attr>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="LastWorkingDay" scope="policy">
									<arg-string>
										<token-src-attr class-name="User" name="abcLastWorkingDay"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-local-variable mode="regex" name="LastWorkingDay" op="equal">^$</if-local-variable>
											<if-local-variable mode="nocase" name="LastWorkingDay" op="equal">9999-12-31</if-local-variable>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcLastWorkingDay"/>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Strip attributes that are not actually chanigng (LastWorkingDay = 9 9 9 9) KSA-SAP</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
									<if-op-attr mode="nocase" name="abcSAPKSALastWorkingDay" op="changing-to">9999-12-31</if-op-attr>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="LastWorkingDay-KSA-SAP" scope="policy">
									<arg-string>
										<token-src-attr class-name="User" name="abcSAPKSALastWorkingDay"/>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-local-variable mode="regex" name="LastWorkingDay-KSA-SAP" op="equal">^$</if-local-variable>
											<if-local-variable mode="nocase" name="LastWorkingDay-KSA-SAP" op="equal">9999-12-31</if-local-variable>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-strip-op-attr name="abcSAPKSALastWorkingDay"/>
									</arg-actions>
									<arg-actions/>
								</do-if>
							</actions>
						</rule>
						<rule>
							<description>Break if UserType is KSA-SAP</description>
							<comment xml:space="preserve">No notifications are created for KSA-SAP users.</comment>
							<conditions>
								<and>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="equal">TRUE</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>For each modify; check to see if we have any EC attrs being changed. If so, loop through them, and create a WebAppNotification object.</description>
							<conditions>
								<and>
									<if-class-name mode="nocase" op="equal">User</if-class-name>
									<if-attr mode="nocase" name="abcIsUserComplete" op="equal">true</if-attr>
									<if-xpath op="true">modify-attr[@attr-name=$ecAttrs/ec/*[name(.) = $class-name]/attr]</if-xpath>
								</and>
								<and>
									<if-class-name mode="nocase" op="equal">abcLicence</if-class-name>
									<if-xpath op="true">modify-attr[@attr-name=$ecAttrs/ec/*[name(.) = $class-name]/attr]</if-xpath>
								</and>
							</conditions>
							<actions>
								<do-if>
									<arg-conditions>
										<and>
											<if-op-attr name="abcLastWorkingDay" op="changing"/>
											<if-op-property name="containsTermination" op="equal">true</if-op-property>
										</and>
									</arg-conditions>
									<arg-actions>
										<do-trace-message>
											<arg-string>
												<token-text xml:space="preserve">Defect: 341 - abcLastWorkingDay change to past detected, though not reporting as term web app notification was already sent.</token-text>
											</arg-string>
										</do-trace-message>
									</arg-actions>
									<arg-actions>
										<do-for-each>
											<arg-node-set>
												<token-xpath expression="modify-attr[@attr-name=$ecAttrs/ec/*[name(.) = $class-name]/attr]"/>
											</arg-node-set>
											<arg-actions>
												<do-set-local-variable name="currentAttrName" scope="policy">
													<arg-string>
														<token-xpath expression="$current-node/@attr-name"/>
													</arg-string>
												</do-set-local-variable>
												<do-if>
													<arg-conditions>
														<and>
															<if-xpath op="true">$ecAttrs/ec/*[name(.) = $class-name]/attr[text() = $currentAttrName]/@avoidReEvalOnFutureDate</if-xpath>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-set-local-variable name="currentAttrValueInSeconds" scope="policy">
															<arg-string>
																<token-convert-time dest-format="!CTIME" dest-tz="UTC" src-format="yyyy-MM-dd" src-tz="UTC">
																	<token-xpath expression="$current-node/add-value/value/text()"/>
																</token-convert-time>
															</arg-string>
														</do-set-local-variable>
														<do-set-local-variable name="canNotify">
															<arg-string>
																<token-xpath expression="es:canNotify($currentAttrName, $currentAttrValueInSeconds, $nowSecondsSince1970, $trainingLifetimeSeconds)"/>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
													<arg-actions>
														<do-set-local-variable name="canNotify">
															<arg-string>
																<token-text xml:space="preserve">true</token-text>
															</arg-string>
														</do-set-local-variable>
													</arg-actions>
												</do-if>
												<do-if>
													<arg-conditions>
														<and>
															<if-local-variable name="canNotify" op="equal">true</if-local-variable>
														</and>
													</arg-conditions>
													<arg-actions>
														<do-if>
															<arg-conditions>
																<or>
																	<if-local-variable name="alreadyCreatedObject" op="not-available"/>
																</or>
															</arg-conditions>
															<arg-actions>
																<do-set-local-variable name="alreadyCreatedObject">
																	<arg-string>
																		<token-text xml:space="preserve">true</token-text>
																	</arg-string>
																</do-set-local-variable>
																<do-add-src-object class-name="abcWebAppNotification">
																	<arg-dn>
																		<token-local-variable name="webAppNotificationDN"/>
																	</arg-dn>
																</do-add-src-object>
																<do-add-src-attr-value name="abcTargetObject">
																	<arg-dn>
																		<token-local-variable name="webAppNotificationDN"/>
																	</arg-dn>
																	<arg-value>
																		<token-src-dn/>
																	</arg-value>
																</do-add-src-attr-value>
															</arg-actions>
														</do-if>
														<do-if>
															<arg-conditions>
																<and>
																	<if-local-variable mode="nocase" name="currentAttrName" op="equal">Physical Delivery Office Name</if-local-variable>
																</and>
															</arg-conditions>
															<arg-actions>
																<do-set-local-variable name="currentAttrName" scope="policy">
																	<arg-string>
																		<token-text xml:space="preserve">physicalDeliveryOfficeName</token-text>
																	</arg-string>
																</do-set-local-variable>
															</arg-actions>
															<arg-actions/>
														</do-if>
														<do-add-src-attr-value name="abcAttributeChangeInfo">
															<arg-dn>
																<token-local-variable name="webAppNotificationDN"/>
															</arg-dn>
															<arg-value type="string">
																<token-local-variable name="currentAttrName"/>
																<token-text xml:space="preserve">~~~~</token-text>
																<token-xpath expression="$current-node/remove-value/value"/>
																<token-text xml:space="preserve">~~~~</token-text>
																<token-xpath expression="$current-node/add-value/value"/>
															</arg-value>
														</do-add-src-attr-value>
													</arg-actions>
												</do-if>
											</arg-actions>
										</do-for-each>
									</arg-actions>
								</do-if>
							</actions>
						</rule>
					</policy>
				</rule>
                <rule name="sub-etp-WebAppObjectDeletedNotification">
					<policy>
						<rule>
							<description>Break if not a deletion</description>
							<comment xml:space="preserve">Deletions could occur directly in the tree (probably not very likely).
Or from the DeleteUsers IDM job.

This condition group below allows this policy to be called in both scenarios. This policy is called from the job code.</comment>
							<conditions>
								<and>
									<if-operation mode="nocase" op="not-equal">delete</if-operation>
									<if-op-property mode="nocase" name="CreateWebAppObjectDeletedNotification" op="not-equal">TRUE</if-op-property>
								</and>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break if not a user</description>
							<conditions>
								<or>
									<if-class-name mode="nocase" op="not-equal">User</if-class-name>
									<if-src-dn op="not-in-subtree">~idv.dit.data.users~</if-src-dn>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Break if KSA-SAP User</description>
							<comment xml:space="preserve">Do not create WebApp notification objects on KSA-SAP users.</comment>
							<conditions>
								<or>
									<if-op-property mode="nocase" name="UserTypeKSA-SAP" op="equal">TRUE</if-op-property>
								</or>
							</conditions>
							<actions>
								<do-break/>
							</actions>
						</rule>
						<rule>
							<description>Create a Deleted Object Notification when a user is deleted</description>
							<conditions/>
							<actions>
								<do-trace-message level="6">
									<arg-string>
										<token-text xml:space="preserve">User object getting deleted.</token-text>
									</arg-string>
								</do-trace-message>
								<do-set-local-variable name="class-name">
									<arg-string>
										<token-class-name/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="src-name" scope="policy">
									<arg-string>
										<token-lower-case>
											<token-src-name/>
										</token-lower-case>
									</arg-string>
								</do-set-local-variable>
								<do-if>
									<arg-conditions>
										<or>
											<if-xpath op="true">starts-with($src-name, 'idmunit')</if-xpath>
										</or>
									</arg-conditions>
									<arg-actions>
										<do-set-local-variable name="idmunitPrefix">
											<arg-string>
												<token-text xml:space="preserve">idmunit</token-text>
											</arg-string>
										</do-set-local-variable>
									</arg-actions>
								</do-if>
								<do-set-local-variable name="notificationDN" scope="policy">
									<arg-string>
										<token-global-variable name="idv.dit.data.webappnotifications"/>
										<token-text xml:space="preserve">\</token-text>
										<token-local-variable name="idmunitPrefix"/>
										<token-time format="yyyy-MM-dd-hhmmssSSS"/>
									</arg-string>
								</do-set-local-variable>
								<do-add-src-object class-name="abcWebAppDelObjectNotification">
									<arg-dn>
										<token-local-variable name="notificationDN"/>
									</arg-dn>
								</do-add-src-object>
								<do-add-src-attr-value name="abcDeletedObjectDN">
									<arg-dn>
										<token-local-variable name="notificationDN"/>
									</arg-dn>
									<arg-value type="string">
										<token-parse-dn dest-dn-format="ldap" src-dn-format="qualified-slash">
											<token-xpath expression="@qualified-src-dn"/>
										</token-parse-dn>
									</arg-value>
								</do-add-src-attr-value>
							</actions>
						</rule>
					</policy>
				</rule>
            </children>
        </subscriber>
    </children>
	<global-config-values>
		<configuration-values>
			<definitions display-name="Common Settings">
				<header display-name="Driver names"/>
				<definition critical-change="true" display-name="Greenlnk driver name (CN only)" hide="false" name="driverAD" type="string">
					<description>Name of the Greenlnk driver to allow the Service driver to determine when it is associated. Example: GL-AD-Driver</description>
					<value>GL-AD-Driver</value>
				</definition>
				<definition critical-change="true" display-name="Success Factors driver name (CN only)" hide="false" name="driverSF" type="string">
					<description>Name of the SuccessFactors driver to allow the Service driver to determine when it is associated. Example: SuccessFactors-Driver</description>
					<value>SuccessFactors-Driver</value>
				</definition>
				<definition critical-change="true" display-name="KSA-SAP driver name (CN only)" hide="false" name="driverKSA-SAP" type="string">
					<description>Name of the KSA-SAP driver to allow the Service driver to determine when it is associated. Example: KSA-SAP-Driver</description>
					<value>KSA-SAP-Driver</value>
				</definition>
				<definition critical-change="true" display-name="Security Vetting System driver name (CN only)" hide="false" name="driverVRS" type="string">
					<description>Name of the VRS driver to allow the Service driver to determine when it is associated. Example: VRS-Driver</description>
					<value>VRS-Driver</value>
				</definition>
				<header display-name="Dynamic Group Settings"/>
				<definition display-name="Driver dynamic Service Account" dn-space="dirxml" dn-type="slash" name="driver.serviceaccount" type="dn">
					<description>IDM Slash format of a temporary service account. Account is created and used where needed, with only explict rights it needs.</description>
					<value>services\saIDMTemp</value>
				</definition>
				<definition critical-change="true" display-name="Job: SF/NSF Users with managerworkforceID, but no manager Group DN" dn-space="dirxml" dn-type="slash" name="dg-missing-manager-group-mwfid" type="dn">
					<description>The DN of the dynamic group containing users with deletion date in the past.</description>
					<value>abcS\Groups\idv-managerworkforce-but-no-manager-MWFID</value>
				</definition>
				<definition critical-change="true" display-name="Job: NSF Users (ONLY) with abcSupervisorVRSID, but no manager Group DN" dn-space="dirxml" dn-type="slash" name="dg-missing-manager-group-vrsid" type="dn">
					<description>The DN of the dynamic group containing users with deletion date in the past.</description>
					<value>abcS\Groups\idv-supervisorid-but-no-manager-VRSID</value>
				</definition>
				<definition critical-change="true" display-name="Job: Expired EC Tranining Dynamic Group DN" dn-space="dirxml" dn-type="slash" name="dg-expired-ectraining-group" type="dn">
					<description>The DN of the dynamic group containing NSF users with an expired EC training.</description>
					<value>abcS\Groups\idv-expired-ectraining</value>
				</definition>
				<definition critical-change="true" display-name="Job: dg-expired-ectraining-attr-update-group Dynamic Group DN" dn-space="dirxml" dn-type="slash" name="dg-expired-ectraining-attr-update-group" type="dn">
					<description>The DN of the dynamic group containing NSF users with an expired EC training.</description>
					<value>abcS\Groups\idv-expired-ectraining-attr-update</value>
				</definition>
				<definition critical-change="true" display-name="Job: Dynamic Group to represent users that should be deleted DN" dn-space="dirxml" dn-type="slash" name="dg-users-to-delete-group" type="dn">
					<description>The DN of the dynamic group containing users with deletion date in the past.</description>
					<value>abcS\Groups\idv-users-to-delete</value>
				</definition>
				<definition critical-change="true" display-name="Job: Secondment Effective Group DN" dn-space="dirxml" dn-type="slash" name="dg-secondment-to-check-group" type="dn">
					<description>The DN of the dynamic group containing users with secondment expiring.</description>
					<value>abcS\Groups\idv-secondment-check</value>
				</definition>
				<definition critical-change="true" display-name="Job: Last Working Day Check Group DN" dn-space="dirxml" dn-type="slash" name="dg-last-working-day-check-group" type="dn">
					<description>The DN of the dynamic group containing users with deletion date in the past.</description>
					<value>abcS\Groups\idv-last-working-day-check</value>
				</definition>
				<definition critical-change="true" display-name="Job: List of users with GL account expires 'soon' Group DN" dn-space="dirxml" dn-type="slash" name="dg-gl-user-expire" type="dn">
					<description>The DN of the dynamic group containing users with deletion date in the past.</description>
					<value>abcS\Groups\idv-gl-account-expires</value>
				</definition>
				<definition critical-change="true" display-name="Job: List of users with last day worked upcoming" dn-space="dirxml" dn-type="slash" name="dg-last-day-worked-upcoming-group" type="dn">
					<description>The DN of the dynamic group containing users with Last Day Worked coming up.

Used in Job-LastDayWorkedUpcoming

</description>
					<value>abcS\Groups\idv-last-day-worked-upcoming</value>
				</definition>
				<definition critical-change="true" display-name="Job: List of users starting today" dn-space="dirxml" dn-type="slash" name="dg-start-today" type="dn">
					<description>The DN of the dynamic group containing users starting today.</description>
					<value>abcS\Groups\idv-start-today</value>
				</definition>
				<definition critical-change="true" display-name="LDAP: Use SSL?" name="gcvUseSSL" type="boolean">
					<description>True if SSL should be used.  IP and port are chosen dynamically. This is for all internal LDAP connections made by drivers to update items directly in the tree.</description>
					<value>true</value>
				</definition>
				<definition display-name="Ldap Server Name or IP address" hide="true" name="gcvServiceHost" type="string">
					<description>When using LDAP to access the tree, populate this field if desired.  Leave it blank if using dynamic host resolution, if the driver set is attached to a single server.</description>
					<value/>
				</definition>
				<definition display-name="Ldap Server port" hide="true" name="gcvServicePort" type="string">
					<description>When Ldap server name or IP is populated, add the port here (Example: 389 or 636)</description>
					<value/>
				</definition>
				<header display-name="Date Settings"/>
				<definition display-name="System attributes that should be treated like dates." item-separator=";" name="ds-DATE-ATTRS" type="list">
					<description>Attributes that need date converstion to the yyyy-MM-dd format.</description>
					<value>
						<item xml:space="preserve">abcDOB</item>
						<item xml:space="preserve">Employee_Date_Of_Birth</item>
						<item xml:space="preserve">abcSecurityExpiry</item>
						<item xml:space="preserve">Security_Clearance_Expiry_Data</item>
						<item xml:space="preserve">abcCompanyStartDate</item>
						<item xml:space="preserve">abcSAPKSACompanyStartDate</item>
						<item xml:space="preserve">Company_Start_Date</item>
						<item xml:space="preserve">abcCompanyEndDate</item>
						<item xml:space="preserve">Employment_End_Date</item>
						<item xml:space="preserve">abcStartDateSec</item>
						<item xml:space="preserve">SECONDMENT_Start_Date</item>
						<item xml:space="preserve">abcEndDateSec</item>
						<item xml:space="preserve">SECONDMENT_End_Date</item>
						<item xml:space="preserve">abcTrainingLastCompleted</item>
						<item xml:space="preserve">EC_Awareness_Training_Last_Completed</item>
						<item xml:space="preserve">EC_Enhanced_Training_Last_Completed</item>
						<item xml:space="preserve">abcLastWorkingDay</item>
						<item xml:space="preserve">Last_Day_At_Work</item>
						<item xml:space="preserve">abcUserDeletionDate</item>
						<item xml:space="preserve">abcUserMinimumDeletionDate</item>
						<item xml:space="preserve">abcUserMaximumDeletionDate</item>
						<item xml:space="preserve">abcLicenceExpirationDate</item>
						<item xml:space="preserve">Licence_Expiration_Date</item>
					</value>
				</definition>
				<header display-name="Common Settings"/>
				<definition display-name="User Container, slash format" dn-space="dirxml" dn-type="slash" name="idv.dit.data.users" type="dn">
					<description>Users contianer, in slash format: abcS\users</description>
					<value>abcS\Users</value>
				</definition>
				<definition display-name="Group Container, slash format" dn-space="dirxml" dn-type="slash" name="idv.dit.data.groups" type="dn">
					<description>Groups contianer, in slash format: abcS\groups</description>
					<value>abcS\Groups</value>
				</definition>
				<definition display-name="Licence Container in IDV, slash format" dn-space="dirxml" dn-type="slash" name="idv.dit.data.licenses" type="dn">
					<description>IDM Slash format of LIcence container. Example: abcS\Licences</description>
					<value>abcS\Licences</value>
				</definition>
				<definition display-name="Web App notification container in IDV, slash format" dn-space="dirxml" dn-type="slash" name="idv.dit.data.webappnotifications" type="dn">
					<description>IDM Slash format of Licence container. Example: abcS\Notifications</description>
					<value>abcS\Notifications</value>
				</definition>
				<header display-name="Email addresses"/>
				<definition display-name="Identity Management Team email address for issue resolution (DVE)" hide="false" name="dveIDMTeam" type="string">
					<description>There are a few situations where this team should be notified as well.  Enter the single group email address here.</description>
					<value>IdentityManagementUK@abcsystems.com</value>
				</definition>
				<definition display-name="SME email address" name="EMAIL_SME" type="string">
					<description>This should be the email address of the System Management Engineer that is in a position to resolve IDV level issues.
Note: this value should be all lowercase to avoid email validation issues in IdMUnit.</description>
					<value>identitymanagementuk@abcsystems.com</value>
				</definition>
				<definition display-name="SF User Matches on Email Only email address" name="EMAIL_SF_USER_MATCH_ON_EMAIL_ONLY" type="string">
					<description/>
					<value>SuccessFactorsSupport@abcsystems.com</value>
				</definition>
				<definition display-name="Job managerWorkforceID Lookup Fails email address" name="EMAIL_MANAGERWORKFORCEID_LOOKUP_FAILURE" type="string">
					<description/>
					<value>SuccessFactorsSupport@abcsystems.com</value>
				</definition>
				<definition display-name="Job abcSupervisorVRSID Lookup Fails email address" name="EMAIL_abcSUPERVISORVRSID_LOOKUP_FAILURE" type="string">
					<description>Email address for the abcSupervisoVRSID lookup failure notifications.</description>
					<value>identitymanagementuk@abcsystems.com</value>
				</definition>
				<definition display-name="Enter the email address for KSA-SAP email notifications. (If this is modified, update the KSA-SAP and Service Drivers)." name="KSA-SAP-HR-Email" type="string">
					<description>Enter the email address for KSA-SAP email notifications. (If this is modified, update the KSA-SAP and Service Drivers).</description>
					<value>hris@abcsystems.com</value>
				</definition>
				<definition display-name="If assistance required contact email (VRS and KSA-SAP)" name="vrs.assistance.required.email" type="string">
					<description>Assistance Required email placed in the following emails:
abcS-VRS-Multiple Matches Found
abcS-KSA-SAP-GCI-Cleared
abcS-KSA-SAP-GCI-Modified</description>
					<value>IdentityManagementUK@abcsystems.com</value>
				</definition>
				<header display-name="DVE Parameters (set defaults in the driver set, override settings in drivers)" hide="false"/>
				<definition display-name="Full path to log file without extension ([current date].log will be postfixed to the end)" hide="false" name="dveLog" type="string">
					<description/>
					<value>/idm/log/drivers/dveLog</value>
				</definition>
				<definition display-name="True if logging should be done for attributes that pass validation in the DVE." hide="false" name="dveLogOnSuccess" type="boolean">
					<description>Specifies whether or not successful attr validations should be written to the log.</description>
					<value>true</value>
				</definition>
				<definition display-name="Driver alias for the main mapping table" hide="true" name="dveDriverAlias" type="string">
					<description>Driver alias marker to process driver specific data</description>
					<value>DRIVERSET</value>
				</definition>
				<definition display-name="Dry-Run Setting" hide="false" name="dveDryRun" type="boolean">
					<description>Enable to only log findings. Can be more useful with dveLogOnSuccess set to true to have more visiblity into the DVE.</description>
					<value>false</value>
				</definition>
			</definitions>
		</configuration-values>
	</global-config-values>
</driver-configuration>



Also note: Description of memberqueryURL and dynamic groups:
https://support.novell.com/techcenter/articles/ana20020405.html




memberqueryurl:

memberQueryURL
This holds the entire search query that is used to define the dynamic membership list in the form of an LDAP URL. The format of LDAP URL is specified in RFC 2255 (see http://ietf.org/rfc/rfc2255.txt) which consists of the following rough format:

ldap://hostname:port/<baseDN>?<attrlist>?<scope>?<search filter>[?<extensions>]
The hostname, port, and attrlist have no effect on dynamic groups, and hence the general format of the memberQueryURL attribute is as follows:

ldap:///<base dn>??<scope>?<search filter>[?x-chain]

<base dn>

The distinguished name of the search base. If the base is not specified the root of the tree is assumed.

<scope>
The scope of the search, which can be one of these values:

base only searches the base object (<base dn>)

one searches the direct subordinates of the base object. The base object itself is not searched

sub searches the base object and all objects in the subtree below it

If the scope is not specified, the base scope is assumed.

<filter>
An LDAP search filter to apply to entries within the specified scope of the search. Only entries matching the search filter will be selected as the result. If the filter is not specified a filter of "objectclass=*" is assumed. LDAP search filters are described in RFC 2254 RFC 2254 (see http://ietf.org/rfc/rfc2254.txt), and most any LDAP reference manual.

<extensions> (x-chain)
A special extension,x-chain is defined for dynamic groups. The x-chain option is used to indicate whether the search for dynamic members should chain across multiple servers, or should be done only on the server containing the dynamic group object. If x-chain is set, then the server will, if needed, communicate with other servers while searching for dynamic members. If the x-chain extension is absent, then the search for dynamic members will not chain across other servers, and return only local results. The use of this extension should be carefully considered, as it can result in lengthy operations. When designing tree structure, you may want to consider ensuring that all possible matches for a dynamic group reside on the local server.

The use of x-chain is optional and the default is to not chain. Currently, the only extension supported in a memberQueryURL is the x-chain extension.
