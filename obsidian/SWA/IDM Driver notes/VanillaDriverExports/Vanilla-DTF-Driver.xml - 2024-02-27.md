```

<?xml version="1.0" encoding="UTF-8"?><driver-configuration dn="cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" driver-set-dn="cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" name="DTF-Vanilla-Example" package-id="RISDO559_201006151053480765">
	<packages>
		<package id="RISDO559_201006151053480765" symbolic-name="com.netiqcorporation.novldtxtbase" version="2.3.5.20190905105253"/>
	</packages>
	<attributes package-id="RISDO559_201006151053480765" package-version="2.3.5.20190905105253">
		<configuration-manifest>
			<manifest name="Delimited Text">
				<capability name="password-sync"/>
				<capability name="password-subscribe"/>
				<capability name="processNewXsl"/>
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
				<filter-class class-name="User" publisher="sync" subscriber="sync">
					<filter-attr attr-name="Description" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Facsimile Telephone Number" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Given Name" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Internet EMail Address" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="mobile" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Surname" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Telephone Number" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="Title" publisher="sync" subscriber="sync"/>
					<filter-attr attr-name="workforceID" publisher="sync" subscriber="sync"/>
				</filter-class>
			</filter>
		</driver-filter-xml>
		<reciprocal-links>
			<reciprocal-links/>
		</reciprocal-links>
		<driver-image>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</driver-image>
		<log-events inherit="true"/>
		<trace-file inherit="true"/>
		<trace-size-limit inherit="true"/>
		<trace-level inherit="true"/>
		<driver-trace-level inherit="true"/>
		<log-limit inherit="true"/>
		<log-events-type inherit="true"/>
		<java-module value="com.novell.nds.dirxml.remote.driver.DriverShimImpl"/>
		<policy-linkage>
			<linkage-item dn="cn=NOVLDTXTBASE-smp,cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" order="0" policy-set="0" policy-set-name="Schema Mapping"/>
			<linkage-item dn="cn=NOVLDTXTBASE-its,cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" order="0" policy-set="1" policy-set-name="Input"/>
			<linkage-item dn="cn=NOVLDTXTBASE-ots,cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" order="0" policy-set="2" policy-set-name="Output"/>
			<linkage-item dn="cn=NOVLDTXTBASE-sub-ets,cn=Subscriber,cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" order="0" policy-set="4" policy-set-name="Subscriber Event"/>
			<linkage-item dn="cn=NOVLDTXTBASE-pub-mp,cn=Publisher,cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" order="0" policy-set="7" policy-set-name="Publisher Matching"/>
			<linkage-item dn="cn=NOVLDTXTBASE-pub-cp,cn=Publisher,cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" order="0" policy-set="9" policy-set-name="Publisher Create"/>
			<linkage-item dn="cn=NOVLDTXTBASE-pub-pp,cn=Publisher,cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" order="0" policy-set="13" policy-set-name="Publisher Placement"/>
			<linkage-item dn="cn=NOVLDTXTBASE-GCVs,cn=DTF-Vanilla-Example,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" order="0" policy-set="14" policy-set-name="Global Configs"/>
		</policy-linkage>
		<driver-cache-limit value="0"/>
		<shim-auth-password-query/>
		<shim-auth-server value="REMOTE(hostname= port=8090)"/>
		<driver-password-query/>
		<driver-start-option no-resync="" value="2"/>
		<shim-config-info-xml>
			<driver-config name="Delimited Text">
				<driver-options>
					<configuration-values>
						<definitions>
							<gcv-ref driver-param-name="field-delimiter" name="driver.field.delimiter"/>
							<!-- <definition display-name="xlfid(NOVLDTXTBASE.initial.settings.param.field-delimiter)Field Delimiter:" name="field-delimiter" type="string">
								<value>,</value>
							</definition> -->
							<gcv-ref driver-param-name="field-names" name="driver.field-names"/>
							<!--	<definition display-name="xlfid(NOVLDTXTBASE.initial.settings.param.field-names)Field Names (Field1, Field2, Field3...):" name="field-names" type="string">
								<value>WorkforceID,LastName,FirstName,Title,Email,WorkPhone,Fax,WirelessPhone,Description</value>
							</definition> -->
							<definition display-name="Object Class Name:" name="object-class-name" type="string">
								<value>User</value>
							</definition>
							<definition display-name="Allow Driver to Consume Its Own Output?" name="allow-loopback" type="string">
								<value>no</value>
							</definition>
							<gcv-ref driver-param-name="drivertraceData" name="driver.traceData"/>
						</definitions>
					</configuration-values>
				</driver-options>
				<subscriber-options>
					<configuration-values>
						<definitions>
							<definition display-name="Output File Path:" name="output-dir" type="string">
								<?generatePrompt?>
								<value xml:space="preserve">/var/netiq/idm/users/output</value>
							</definition>
							<definition display-name="Output File Extension:" name="output-ext" type="string">
								<value>.csv</value>
							</definition>
							<definition display-name="Add Header to output file:" name="addOutputHeader" type="enum">
								<description>Select yes to include the xml declaration in output xml file.</description>
								<enum-choice display-name="Yes">yes</enum-choice>
								<enum-choice display-name="No">no</enum-choice>
								<value>no</value>
							</definition>
							<definition display-name="Destination File Character Encoding (leave blank for default):" name="output-char-encoding" type="string">
								<value/>
							</definition>
							<definition display-name="Maximum Number of Transactions per Output File:" name="transactions-per-file" type="string">
								<value>200</value>
							</definition>
							<definition display-name="Maximum Time in Seconds before Flushing All Transactions:" name="file-time-out" type="string">
								<value>30</value>
							</definition>
							<definition display-name="Allow Duplicate Records:" name="allowDuplicates" type="enum">
								<description>Select yes to enable the duplicate records.</description>
								<enum-choice display-name="Yes">yes</enum-choice>
								<enum-choice display-name="No">no</enum-choice>
								<value>no</value>
							</definition>
							<definition display-name="Time of Day (Local Time) to Flush All Transactions:" name="time-of-day" type="string">
								<value/>
							</definition>
						</definitions>
					</configuration-values>
				</subscriber-options>
				<publisher-options>
					<configuration-values>
						<definitions>
							<definition display-name="Input File Path:" name="input-dir" type="string">
								<?generatePrompt?>
								<value xml:space="preserve">/var/netiq/idm/users/input</value>
							</definition>
							<definition display-name="Input File Extension:" name="input-ext" type="string">
								<value>.csv</value>
							</definition>
							<definition display-name="Source File Character Encoding (leave blank for default):" name="input-char-encoding" type="string">
								<value/>
							</definition>
							<definition display-name="Rename File Extension:" name="input-rename-ext" type="string">
								<value>.bak</value>
							</definition>
							<definition display-name="Polling Rate (in seconds):" name="input-poll-rate" type="string">
								<value>10</value>
							</definition>
							<definition display-name="Publisher heartbeat interval" name="pub-heartbeat-interval" type="integer">
								<description>Configures the driver shim to send a periodic status message on the Publisher channel when there has been no Publisher traffic for the given number of minutes.</description>
								<value>1</value>
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
						<value>false</value>
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
					<definition display-name="Retrieve Application Schema" display-name-ref="ecnm_rasc" name="dirxml.engine.retrieve-application-schema" type="boolean">
						<description description-ref="ecds_rasc">This control determines whether the DirXML Engine will query for application schema. For some drivers like generic null where application does not have any schema, this control can be set to false so that Engine does not query for application schema.</description>
						<value>true</value>
					</definition>
				</definitions>
			</configuration-values>
		</global-engine-values>
		<global-config-values/>
		<application-schema>
			<schema-def>
				<class-def class-name="User">
					<attr-def attr-name="Description" multi-valued="false" type="string"/>
					<attr-def attr-name="Email" multi-valued="false" type="string"/>
					<attr-def attr-name="Fax" multi-valued="false" type="string"/>
					<attr-def attr-name="FirstName" multi-valued="false" type="string"/>
					<attr-def attr-name="LastName" multi-valued="false" type="string"/>
					<attr-def attr-name="Title" multi-valued="false" type="string"/>
					<attr-def attr-name="WirelessPhone" multi-valued="false" type="string"/>
					<attr-def attr-name="WorkforceID" multi-valued="false" type="string"/>
					<attr-def attr-name="WorkPhone" multi-valued="false" type="string"/>
				</class-def>
			</schema-def>
		</application-schema>
		<pkg-initial-states>
			<pkg-initial-state package-id="RISDO559_201006151053480765" pkg-assoc-id="JDN19F9U_201006151146570171" version="2.3.5.20190905105253">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMRFRYVEJBU0UtcHViLWNwIiBuYW1lPSJOT1ZMRFRYVEJBU0UtcHViLWNwIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPlJlcXVpcmVkIEF0dHJpYnV0ZXM8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxvcj4KCQkJCQkJCQk8aWYtY2xhc3MtbmFtZSBvcD0iZXF1YWwiPlVzZXI8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQk8L29yPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXZldG8taWYtb3AtYXR0ci1ub3QtYXZhaWxhYmxlIG5hbWU9IkdpdmVuIE5hbWUiLz4KCQkJCQkJCTxkby12ZXRvLWlmLW9wLWF0dHItbm90LWF2YWlsYWJsZSBuYW1lPSJTdXJuYW1lIi8+CgkJCQkJCQk8ZG8tdmV0by1pZi1vcC1hdHRyLW5vdC1hdmFpbGFibGUgbmFtZT0iSW50ZXJuZXQgRU1haWwgQWRkcmVzcyIvPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJCTxydWxlPgoJCQkJCQk8ZGVzY3JpcHRpb24+TmFtZS1CYXNlZCBPYmplY3QgTmFtaW5nIC0gVmFyaWFibGUgTGVuZ3RoPC9kZXNjcmlwdGlvbj4KCQkJCQkJPGNvbmRpdGlvbnM+CgkJCQkJCQk8YW5kPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG9wPSJlcXVhbCI+VXNlcjwvaWYtY2xhc3MtbmFtZT4KCQkJCQkJCTwvYW5kPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJ0bXBTdXJuYW1lIj4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLW9wLWF0dHIgbmFtZT0iU3VybmFtZSIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJzdHJpcFN1cm5hbWUiPgoJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQk8dG9rZW4teHBhdGggZXhwcmVzc2lvbj0idHJhbnNsYXRlKCR0bXBTdXJuYW1lLCZxdW90Oy0rJmFwb3M7JnF1b3Q7LCZxdW90OyZxdW90OykiLz4KCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQk8L2RvLXNldC1sb2NhbC12YXJpYWJsZT4KCQkJCQkJCTxkby1zZXQtbG9jYWwtdmFyaWFibGUgbmFtZT0idG1wR2l2ZW5uYW1lIj4KCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJPHRva2VuLW9wLWF0dHIgbmFtZT0iR2l2ZW4gTmFtZSIvPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQkJPGRvLXNldC1sb2NhbC12YXJpYWJsZSBuYW1lPSJzdHJpcEdpdmVubmFtZSI+CgkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCTx0b2tlbi14cGF0aCBleHByZXNzaW9uPSJ0cmFuc2xhdGUoJHRtcEdpdmVubmFtZSwmcXVvdDstKyZhcG9zOyZxdW90OywmcXVvdDsmcXVvdDspIi8+CgkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJPC9kby1zZXQtbG9jYWwtdmFyaWFibGU+CgkJCQkJCQk8ZG8tc2V0LWxvY2FsLXZhcmlhYmxlIG5hbWU9InVuaXF1ZS1jbiIgc2NvcGU9ImRyaXZlciI+CgkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCTx0b2tlbi11bmlxdWUtbmFtZSBjb3VudGVyLWRpZ2l0cz0iMyIgY291bnRlci1wYWQ9ImZhbHNlIiBjb3VudGVyLXBhdHRlcm49ImZpcnN0IiBuYW1lPSJDTiIgc2NvcGU9InN1YnRyZWUiPgoJCQkJCQkJCQkJPGFyZy1zdHJpbmc+CgkJCQkJCQkJCQkJPHRva2VuLWxvd2VyLWNhc2U+CgkJCQkJCQkJCQkJCTx0b2tlbi1zdWJzdHJpbmcgbGVuZ3RoPSIxIj4KCQkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJzdHJpcEdpdmVubmFtZSIvPgoJCQkJCQkJCQkJCQk8L3Rva2VuLXN1YnN0cmluZz4KCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9InN0cmlwU3VybmFtZSIvPgoJCQkJCQkJCQkJCTwvdG9rZW4tbG93ZXItY2FzZT4KCQkJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCQkJCTxhcmctc3RyaW5nPgoJCQkJCQkJCQkJCTx0b2tlbi1sb3dlci1jYXNlPgoJCQkJCQkJCQkJCQk8dG9rZW4tc3Vic3RyaW5nIGxlbmd0aD0iMiI+CgkJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0ic3RyaXBHaXZlbm5hbWUiLz4KCQkJCQkJCQkJCQkJPC90b2tlbi1zdWJzdHJpbmc+CgkJCQkJCQkJCQkJCTx0b2tlbi1sb2NhbC12YXJpYWJsZSBuYW1lPSJzdHJpcFN1cm5hbWUiLz4KCQkJCQkJCQkJCQk8L3Rva2VuLWxvd2VyLWNhc2U+CgkJCQkJCQkJCQk8L2FyZy1zdHJpbmc+CgkJCQkJCQkJCQk8YXJnLXN0cmluZz4KCQkJCQkJCQkJCQk8dG9rZW4tbG93ZXItY2FzZT4KCQkJCQkJCQkJCQkJPHRva2VuLXN1YnN0cmluZyBsZW5ndGg9IjMiPgoJCQkJCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9InN0cmlwR2l2ZW5uYW1lIi8+CgkJCQkJCQkJCQkJCTwvdG9rZW4tc3Vic3RyaW5nPgoJCQkJCQkJCQkJCQk8dG9rZW4tbG9jYWwtdmFyaWFibGUgbmFtZT0ic3RyaXBTdXJuYW1lIi8+CgkJCQkJCQkJCQkJPC90b2tlbi1sb3dlci1jYXNlPgoJCQkJCQkJCQkJPC9hcmctc3RyaW5nPgoJCQkJCQkJCQk8L3Rva2VuLXVuaXF1ZS1uYW1lPgoJCQkJCQkJCTwvYXJnLXN0cmluZz4KCQkJCQkJCTwvZG8tc2V0LWxvY2FsLXZhcmlhYmxlPgoJCQkJCQk8L2FjdGlvbnM+CgkJCQkJPC9ydWxlPgoJCQkJPC9wb2xpY3k+CgkJCTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1pbnN0YWxsYXRpb25kaXJlY3RpdmUiPgoJCQk8ZHMtdmFsdWU+UEQ5NGJXd2dkbVZ5YzJsdmJqMGlNUzR3SWlCbGJtTnZaR2x1WnowaVZWUkdMVGdpUHo0OGFXNXpkR0ZzYkdGMGFXOXVMV1JwY21WamRHbDJaVDRLQ1R4d2JHRmpaVzFsYm5RZ2JHOWpZWFJwYjI0OUluQjFZbXhwYzJobGNpSXZQZ29KUEdSekxXRjBkSEpwWW5WMFpYTXZQZ29KUEhCdmJHbGplUzFzYVc1cllXZGxQZ29KQ1R4d2IyeHBZM2t0YzJWMElHTm9ZVzV1Wld3OUluQjFZbXhwYzJobGNpSWdibUZ0WlQwaVkzSmxZWFJwYjI0aUlHOXlaR1Z5UFNKc1lYTjBJaTgrQ2drOEwzQnZiR2xqZVMxc2FXNXJZV2RsUGdvOEwybHVjM1JoYkd4aGRHbHZiaTFrYVhKbFkzUnBkbVUrPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjI2NTk5NjI0NDc8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT5KRE4xOUY5VV8yMDEwMDYxNTExNDY1NzAxNzE8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+UklTRE81NTlfMjAxMDA2MTUxMDUzNDgwNzY1PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4yNTUzOTg0MTk3PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="RISDO559_201006151053480765" pkg-assoc-id="QA93SVD4_201006151147020234" version="2.3.5.20190905105253">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMRFRYVEJBU0UtcHViLW1wIiBuYW1lPSJOT1ZMRFRYVEJBU0UtcHViLW1wIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPk1hdGNoIGJhc2VkIG9uIEludGVybmV0IEVtYWlsIEFkZHJlc3M8L2Rlc2NyaXB0aW9uPgoJCQkJCQk8Y29uZGl0aW9ucz4KCQkJCQkJCTxvcj4KCQkJCQkJCQk8aWYtY2xhc3MtbmFtZSBvcD0iZXF1YWwiPlVzZXI8L2lmLWNsYXNzLW5hbWU+CgkJCQkJCQk8L29yPgoJCQkJCQk8L2NvbmRpdGlvbnM+CgkJCQkJCTxhY3Rpb25zPgoJCQkJCQkJPGRvLWZpbmQtbWF0Y2hpbmctb2JqZWN0IHNjb3BlPSJzdWJ0cmVlIj4KCQkJCQkJCQk8YXJnLW1hdGNoLWF0dHIgbmFtZT0iSW50ZXJuZXQgRU1haWwgQWRkcmVzcyIvPgoJCQkJCQkJPC9kby1maW5kLW1hdGNoaW5nLW9iamVjdD4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbkIxWW14cGMyaGxjaUl2UGdvSlBHUnpMV0YwZEhKcFluVjBaWE12UGdvSlBIQnZiR2xqZVMxc2FXNXJZV2RsUGdvSkNUeHdiMnhwWTNrdGMyVjBJR05vWVc1dVpXdzlJbkIxWW14cGMyaGxjaUlnYm1GdFpUMGliV0YwWTJocGJtY2lJRzl5WkdWeVBTSnNZWE4wSWk4K0NnazhMM0J2YkdsamVTMXNhVzVyWVdkbFBnbzhMMmx1YzNSaGJHeGhkR2x2Ymkxa2FYSmxZM1JwZG1VKzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4yMDQ2MDY4ODk4PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2Vhc3NvY2d1aWQiPgoJCQk8ZHMtdmFsdWU+UUE5M1NWRDRfMjAxMDA2MTUxMTQ3MDIwMjM0PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2VndWlkIj4KCQkJPGRzLXZhbHVlPlJJU0RPNTU5XzIwMTAwNjE1MTA1MzQ4MDc2NTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1jb250ZW50Y2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MzI2OTY3ODc2PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCTwvZHMtYXR0cmlidXRlcz4KPC9kcy1vYmplY3Q+</pkg-initial-state>
			<pkg-initial-state package-id="RISDO559_201006151053480765" pkg-assoc-id="WOMKYWGB_201006151147060859" version="2.3.5.20190905105253">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMRFRYVEJBU0UtcHViLXBwIiBuYW1lPSJOT1ZMRFRYVEJBU0UtcHViLXBwIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHBvbGljeT4KCQkJCQk8cnVsZT4KCQkJCQkJPGRlc2NyaXB0aW9uPlVzZXIgb2JqZWN0IHBsYWNlbWVudDwvZGVzY3JpcHRpb24+CgkJCQkJCTxjb25kaXRpb25zPgoJCQkJCQkJPG9yPgoJCQkJCQkJCTxpZi1jbGFzcy1uYW1lIG9wPSJlcXVhbCI+VXNlcjwvaWYtY2xhc3MtbmFtZT4KCQkJCQkJCTwvb3I+CgkJCQkJCTwvY29uZGl0aW9ucz4KCQkJCQkJPGFjdGlvbnM+CgkJCQkJCQk8ZG8tc2V0LW9wLWRlc3QtZG4+CgkJCQkJCQkJPGFyZy1kbj4KCQkJCQkJCQkJPHRva2VuLWdsb2JhbC12YXJpYWJsZSBuYW1lPSJpZHYuZGl0LmRhdGEudXNlcnMiLz4KCQkJCQkJCQkJPHRva2VuLXRleHQgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+XDwvdG9rZW4tdGV4dD4KCQkJCQkJCQkJPHRva2VuLWxvY2FsLXZhcmlhYmxlIG5hbWU9InVuaXF1ZS1jbiIvPgoJCQkJCQkJCTwvYXJnLWRuPgoJCQkJCQkJPC9kby1zZXQtb3AtZGVzdC1kbj4KCQkJCQkJPC9hY3Rpb25zPgoJCQkJCTwvcnVsZT4KCQkJCTwvcG9saWN5PgoJCQk8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0taW5zdGFsbGF0aW9uZGlyZWN0aXZlIj4KCQkJPGRzLXZhbHVlPlBEOTRiV3dnZG1WeWMybHZiajBpTVM0d0lpQmxibU52WkdsdVp6MGlWVlJHTFRnaVB6NDhhVzV6ZEdGc2JHRjBhVzl1TFdScGNtVmpkR2wyWlQ0S0NUeHdiR0ZqWlcxbGJuUWdiRzlqWVhScGIyNDlJbkIxWW14cGMyaGxjaUl2UGdvSlBHUnpMV0YwZEhKcFluVjBaWE12UGdvSlBIQnZiR2xqZVMxc2FXNXJZV2RsUGdvSkNUeHdiMnhwWTNrdGMyVjBJR05vWVc1dVpXdzlJbkIxWW14cGMyaGxjaUlnYm1GdFpUMGljR3hoWTJWdFpXNTBJaUJ2Y21SbGNqMGliR0Z6ZENJdlBnb0pQQzl3YjJ4cFkza3RiR2x1YTJGblpUNEtQQzlwYm5OMFlXeHNZWFJwYjI0dFpHbHlaV04wYVhabFBnPT08L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+NDEwMjQzMTY0NjwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPldPTUtZV0dCXzIwMTAwNjE1MTE0NzA2MDg1OTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5SSVNETzU1OV8yMDEwMDYxNTEwNTM0ODA3NjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjM0OTIwMTMzODI8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="RISDO559_201006151053480765" pkg-assoc-id="ARS8VSYS_201006151203150906" version="2.3.5.20190905105253">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVN0eWxlU2hlZXQiIGRzLW9iamVjdC1uYW1lPSJOT1ZMRFRYVEJBU0Utc3ViLWV0cyIgbmFtZT0iTk9WTERUWFRCQVNFLXN1Yi1ldHMiPgoJPGRzLWF0dHJpYnV0ZXM+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9IlhtbERhdGEiPgoJCQk8ZHMtdmFsdWU+CgkJCQk8eHNsOnN0eWxlc2hlZXQgdmVyc2lvbj0iMS4wIiB4bWxuczpxdWVyeT0iaHR0cDovL3d3dy5ub3ZlbGwuY29tL254c2wvamF2YS9jb20ubm92ZWxsLm5kcy5kaXJ4bWwuZHJpdmVyLlhkc1F1ZXJ5UHJvY2Vzc29yIiB4bWxuczp4c2w9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvWFNML1RyYW5zZm9ybSI+CgkJCQkJPHhzbDpwYXJhbSBuYW1lPSJzcmNRdWVyeVByb2Nlc3NvciIvPgoJCQkJCTwhLS0gVGhlIGZpcnN0IHR3byB0ZW1wbGF0ZXMgaW1wbGVtZW50IHRoZSBpZGVudGl0eSB0cmFuc2Zvcm0uCS0tPgoJCQkJCTwhLS0gYW55dGhpbmcgdGhhdCBkb2Vzbid0IG1hdGNoIGEgbW9yZSBzcGVjaWZpYyB0ZW1wbGF0ZSB3aWxsCS0tPgoJCQkJCTwhLS0gYmUgY29waWVkIGFzIGlzIHRvIHRoZSBvdXRwdXQgCQkJCQkJCQktLT4KCQkJCQk8eHNsOnRlbXBsYXRlIG1hdGNoPSIvIj4KCQkJCQkJPHhzbDphcHBseS10ZW1wbGF0ZXMgc2VsZWN0PSJub2RlKCl8QCoiLz4KCQkJCQk8L3hzbDp0ZW1wbGF0ZT4KCQkJCQk8eHNsOnRlbXBsYXRlIG1hdGNoPSJub2RlKCl8QCoiPgoJCQkJCQk8eHNsOmNvcHk+CgkJCQkJCQk8eHNsOmFwcGx5LXRlbXBsYXRlcyBzZWxlY3Q9Im5vZGUoKXxAKiIvPgoJCQkJCQk8L3hzbDpjb3B5PgoJCQkJCTwveHNsOnRlbXBsYXRlPgoJCQkJCTx4c2w6dGVtcGxhdGUgbWF0Y2g9Im1vZGlmeXxzeW5jIj4KCQkJCQkJPCEtLSBjb252ZXJ0IG1vZGlmeSBvciBzeW5jIHdpdGggYW4gYXNzb2NpdGlvbiB0byBhbiBpbnN0YW5jZSBzbyB0aGF0IC0tPgoJCQkJCQk8IS0tIG91dHB1dCB0cmFuc2Zvcm0gY2FuIGNyZWF0ZSBhIGNvbXBsZXRlIG91dHB1dCByZWNvcmQgLS0+CgkJCQkJCTx4c2w6dmFyaWFibGUgbmFtZT0iYXNzb2NpYXRpb25WYWx1ZSIgc2VsZWN0PSJzdHJpbmcoYXNzb2NpYXRpb24vdGV4dCgpKSIvPgoJCQkJCQk8eHNsOmNob29zZT4KCQkJCQkJCTx4c2w6d2hlbiB0ZXN0PSJhc3NvY2lhdGlvbltAc3RhdGUgPSAnZGlzYWJsZWQnXSI+CgkJCQkJCQkJPCEtLSBpZ25vcmUgaWYgdGhlIGFzc29jaWF0aW9uIGlzIGRpc2FibGVkIC0tPgoJCQkJCQkJPC94c2w6d2hlbj4KCQkJCQkJCTx4c2w6b3RoZXJ3aXNlPgoJCQkJCQkJCTwhLS0gaWYgYSBtb2RpZnkgb24gYW4gYXNzb2NpYXRlZCBvYmplY3QgdGhlIGFzc29jaWF0aW9uIHJlcGxhY2UgaXQgd2l0aCB0aGUgaW5zdGFuY2UgLS0+CgkJCQkJCQkJPCEtLSByZXR1cm5lZCBieSBxdWVyeWluZyB0aGUgb2JqZWN0IC0tPgoJCQkJCQkJCTx4c2w6dmFyaWFibGUgbmFtZT0icXVlcnkiPgoJCQkJCQkJCQk8bmRzIGR0ZHZlcnNpb249IjEuMCIgbmRzdmVyc2lvbj0iOC41Ij4KCQkJCQkJCQkJCTxpbnB1dD4KCQkJCQkJCQkJCQk8IS0tIG1heSB3YW50IHRvIHNwZWNpZml5IGEgZGVzdC1kbiBoZXJlIHRvIHNwZWNpZnkgdGhlIHJvb3Qgb2YgdGhlIHNlYXJjaCAtLT4KCQkJCQkJCQkJCQk8cXVlcnkgY2xhc3MtbmFtZT0iVXNlciIgZGVzdC1kbj0ie0BzcmMtZG59IiBkZXN0LWVudHJ5LWlkPSJ7QHNyYy1lbnRyeS1pZH0iIHNjb3BlPSJlbnRyeSI+CgkJCQkJCQkJCQkJCTwhLS0gdGhpcyBzaG91bGQgbWF0Y2ggdGhlIGF0dHJpYnV0ZXMgaW4gdGhlIHN1YnNjcmliZXIgZmlsdGVyIC0tPgoJCQkJCQkJCQkJCQk8cmVhZC1hdHRyIGF0dHItbmFtZT0iRGVzY3JpcHRpb24iLz4KCQkJCQkJCQkJCQkJPHJlYWQtYXR0ciBhdHRyLW5hbWU9IkZhY3NpbWlsZSBUZWxlcGhvbmUgTnVtYmVyIi8+CgkJCQkJCQkJCQkJCTxyZWFkLWF0dHIgYXR0ci1uYW1lPSJHaXZlbiBOYW1lIi8+CgkJCQkJCQkJCQkJCTxyZWFkLWF0dHIgYXR0ci1uYW1lPSJJbnRlcm5ldCBFTWFpbCBBZGRyZXNzIi8+CgkJCQkJCQkJCQkJCTxyZWFkLWF0dHIgYXR0ci1uYW1lPSJtb2JpbGUiLz4KCQkJCQkJCQkJCQkJPHJlYWQtYXR0ciBhdHRyLW5hbWU9IlN1cm5hbWUiLz4KCQkJCQkJCQkJCQkJPHJlYWQtYXR0ciBhdHRyLW5hbWU9IlRlbGVwaG9uZSBOdW1iZXIiLz4KCQkJCQkJCQkJCQkJPHJlYWQtYXR0ciBhdHRyLW5hbWU9IlRpdGxlIi8+CgkJCQkJCQkJCQkJCTxyZWFkLWF0dHIgYXR0ci1uYW1lPSJ3b3JrZm9yY2VJRCIvPgoJCQkJCQkJCQkJCQk8cmVhZC1hdHRyIGF0dHItbmFtZT0iRGlyWE1MLUVudGl0bGVtZW50UmVmIi8+CgkJCQkJCQkJCQkJPC9xdWVyeT4KCQkJCQkJCQkJCTwvaW5wdXQ+CgkJCQkJCQkJCTwvbmRzPgoJCQkJCQkJCTwveHNsOnZhcmlhYmxlPgoJCQkJCQkJCTwhLS0gcXVlcnkgTkRTIC0tPgoJCQkJCQkJCTx4c2w6dmFyaWFibGUgbmFtZT0icmVzdWx0IiBzZWxlY3Q9InF1ZXJ5OnF1ZXJ5KCRzcmNRdWVyeVByb2Nlc3NvciwkcXVlcnkpIi8+CgkJCQkJCQkJPCEtLSBjb3B5IHRoZSBpbnN0YW5jZSBpbnRvIHRoZSBvdXRwdXQgLS0+CgkJCQkJCQkJPHhzbDpjb3B5LW9mIHNlbGVjdD0iJHJlc3VsdC8vaW5zdGFuY2UiLz4KCQkJCQkJCTwveHNsOm90aGVyd2lzZT4KCQkJCQkJPC94c2w6Y2hvb3NlPgoJCQkJCTwveHNsOnRlbXBsYXRlPgoJCQkJPC94c2w6c3R5bGVzaGVldD4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW5OMVluTmpjbWxpWlhJaUx6NEtDVHhrY3kxaGRIUnlhV0oxZEdWekx6NEtDVHh3YjJ4cFkza3RiR2x1YTJGblpUNEtDUWs4Y0c5c2FXTjVMWE5sZENCamFHRnVibVZzUFNKemRXSnpZM0pwWW1WeUlpQnVZVzFsUFNKbGRtVnVkQ0lnYjNKa1pYSTlJbVpwY25OMElpOCtDZ2s4TDNCdmJHbGplUzFzYVc1cllXZGxQZ284TDJsdWMzUmhiR3hoZEdsdmJpMWthWEpsWTNScGRtVSs8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tZGlyZWN0aXZlY2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+Njg2NzA1NDkwPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2Vhc3NvY2d1aWQiPgoJCQk8ZHMtdmFsdWU+QVJTOFZTWVNfMjAxMDA2MTUxMjAzMTUwOTA2PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2VndWlkIj4KCQkJPGRzLXZhbHVlPlJJU0RPNTU5XzIwMTAwNjE1MTA1MzQ4MDc2NTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1jb250ZW50Y2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+Mjg2NzQ0NjI4MTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
			<pkg-initial-state package-id="RISDO559_201006151053480765" pkg-assoc-id="IPGT5IQI_201006151205300468" version="2.3.5.20190905105253">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVN0eWxlU2hlZXQiIGRzLW9iamVjdC1uYW1lPSJOT1ZMRFRYVEJBU0Utb3RzIiBuYW1lPSJOT1ZMRFRYVEJBU0Utb3RzIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHhzbDpzdHlsZXNoZWV0IGV4Y2x1ZGUtcmVzdWx0LXByZWZpeGVzPSJleHQiIHZlcnNpb249IjEuMCIgeG1sbnM6Y21kPSJodHRwOi8vd3d3Lm5vdmVsbC5jb20vbnhzbC9qYXZhL2NvbS5ub3ZlbGwubmRzLmRpcnhtbC5kcml2ZXIuWGRzQ29tbWFuZFByb2Nlc3NvciIgeG1sbnM6ZXh0PSJodHRwOi8vZXhzbHQub3JnL2NvbW1vbiIgeG1sbnM6eHNsPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L1hTTC9UcmFuc2Zvcm0iPgoJCQkJCTx4c2w6cGFyYW0gbmFtZT0ic3JjQ29tbWFuZFByb2Nlc3NvciIvPgoJCQkJCTwhLS0gZWFjaCBhcHBsaWNhdGlvbiBtdXN0IGZpbGwgaW4gdGhlIG5hbWUgb2YgdGhlIGZpZWxkIHRoYXQgcHJvdmlkZXMgdGhlIGFzc29jaWF0aW9uIGtleSAtLT4KCQkJCQk8eHNsOnZhcmlhYmxlIG5hbWU9ImFzc29jaWF0aW9uLWZpZWxkLW5hbWUiIHNlbGVjdD0iJ35kcml2ZXIuYXNzb2NpYXRpb24uYXR0cmlidXRlficiLz4KCQkJCQk8eHNsOnZhcmlhYmxlIG5hbWU9ImZpZWxkLWxpc3QiIHNlbGVjdD0iJ35kcml2ZXIuZmllbGQtbmFtZXN+JyIvPgoJCQkJCTx4c2w6dmFyaWFibGUgbmFtZT0iREVMSU1JVEVSIiBzZWxlY3Q9Iid+ZHJpdmVyLmZpZWxkLmRlbGltaXRlcn4nIi8+CgkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJ0IiBzZWxlY3Q9IiZhcG9zOyYjeDk7JmFwb3M7Ii8+CgkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJ0cmFjZUVuY3J5cHREYXRhIiBzZWxlY3Q9Iid+ZHJpdmVyLnRyYWNlRGF0YX4nIi8+CgkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJsd2RlbGltaXRlciIgc2VsZWN0PSJ0cmFuc2xhdGUoJERFTElNSVRFUiwnQUJDREVGR0hJSktMTU5PUFFSU1RVVldYWVonLCdhYmNkZWZnaGlqa2xtbm9wcXJzdHV2d3h5eicpIi8+CgkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJkZWxpbWl0ZXIiPgoJCQkJCQk8eHNsOmNob29zZT4KCQkJCQkJCTx4c2w6d2hlbiB0ZXN0PSIkbHdkZWxpbWl0ZXI9J3t0YWJ9JyI+CgkJCQkJCQkJPHhzbDp2YWx1ZS1vZiBzZWxlY3Q9IiR0Ii8+CgkJCQkJCQk8L3hzbDp3aGVuPgoJCQkJCQkJPHhzbDpvdGhlcndpc2U+CgkJCQkJCQkJPHhzbDp2YWx1ZS1vZiBzZWxlY3Q9IiRERUxJTUlURVIiLz4KCQkJCQkJCTwveHNsOm90aGVyd2lzZT4KCQkJCQkJPC94c2w6Y2hvb3NlPgoJCQkJCTwveHNsOnZhcmlhYmxlPgoJCQkJCTx4c2w6dmFyaWFibGUgbmFtZT0iU3BsaXRXb3Jkc0xpc3QiPgoJCQkJCQk8eHNsOmNhbGwtdGVtcGxhdGUgbmFtZT0ic3BsaXQiPgoJCQkJCQkJPHhzbDp3aXRoLXBhcmFtIG5hbWU9Im5UZXh0IiBzZWxlY3Q9IiRmaWVsZC1saXN0Ii8+CgkJCQkJCTwveHNsOmNhbGwtdGVtcGxhdGU+CgkJCQkJPC94c2w6dmFyaWFibGU+CgkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJ2U3BsaXRXb3JkcyIgc2VsZWN0PSJleHQ6bm9kZS1zZXQoJFNwbGl0V29yZHNMaXN0KS8qIi8+CgkJCQkJPHhzbDp0ZW1wbGF0ZSBtYXRjaD0ibmRzW2lucHV0XSI+CgkJCQkJCTwhLS0gb25seSBsb29rIGF0IDxhZGQ+IGV2ZW50cyBhbmQgPGluc3RhbmNlcz4gYXBwbHkgYSB0ZW1wbGF0ZSBmb3IgZWFjaCBhZGQgdHJhbnNhY3Rpb24tLT4KCQkJCQkJPHhzbDphcHBseS10ZW1wbGF0ZXMgc2VsZWN0PSIvL2FkZHwvL2luc3RhbmNlfC8vcXVlcnkiLz4KCQkJCQk8L3hzbDp0ZW1wbGF0ZT4KCQkJCQk8eHNsOnRlbXBsYXRlIG1hdGNoPSJuZHNbb3V0cHV0XSI+CgkJCQkJCTx4c2w6Y29weS1vZiBzZWxlY3Q9Ii4iLz4KCQkJCQk8L3hzbDp0ZW1wbGF0ZT4KCQkJCQk8IS0tIG5vdyBoZXJlJ3MgdGhlIHRlbXBsYXRlIC0tPgoJCQkJCTx4c2w6dGVtcGxhdGUgbWF0Y2g9ImlucHV0L2FkZHxpbnB1dC9pbnN0YW5jZSI+CgkJCQkJCTx4c2w6Y2hvb3NlPgoJCQkJCQkJPHhzbDp3aGVuIHRlc3Q9Ii8vQGlzLXNlbnNpdGl2ZSBhbmQgc3RhcnRzLXdpdGgoJHRyYWNlRW5jcnlwdERhdGEsJ3llcycpIj4KCQkJCQkJCQk8aW5wdXQgaXMtc2Vuc2l0aXZlPSJ0cnVlIj4KCQkJCQkJCQkJPHhzbDpjYWxsLXRlbXBsYXRlIG5hbWU9ImR1bW15Ii8+CgkJCQkJCQkJPC9pbnB1dD4KCQkJCQkJCTwveHNsOndoZW4+CgkJCQkJCQk8eHNsOm90aGVyd2lzZT4KCQkJCQkJCQk8eHNsOmNhbGwtdGVtcGxhdGUgbmFtZT0iZHVtbXkiLz4KCQkJCQkJCTwveHNsOm90aGVyd2lzZT4KCQkJCQkJPC94c2w6Y2hvb3NlPgoJCQkJCTwveHNsOnRlbXBsYXRlPgoJCQkJCTx4c2w6dGVtcGxhdGUgbmFtZT0iZHVtbXkiPgoJCQkJCQk8IS0tIGNyZWF0ZSBhc3NvY2lhdGlvbiBpZiBuZWVkZWQgYW5kIHdlIGhhdmUgZW5vdWdoIGluZm8gLS0+CgkJCQkJCTx4c2w6dmFyaWFibGUgbmFtZT0iaGFzQXNzb2NpYXRpb24iIHNlbGVjdD0ic3RyaW5nKGFzc29jaWF0aW9uKSAhPSAnJyIvPgoJCQkJCQk8eHNsOnZhcmlhYmxlIG5hbWU9ImFzc29jaWF0aW9uVmFsdWUiIHNlbGVjdD0iKlsoQGF0dHItbmFtZSA9ICRhc3NvY2lhdGlvbi1maWVsZC1uYW1lKV1bMV0vdmFsdWVbMV0vdGV4dCgpIi8+CgkJCQkJCTx4c2w6aWYgdGVzdD0ibm90KCRoYXNBc3NvY2lhdGlvbikgYW5kICRhc3NvY2lhdGlvblZhbHVlIj4KCQkJCQkJCTx4c2w6dmFyaWFibGUgbmFtZT0iZHVtbXkiPgoJCQkJCQkJCTxhZGQtYXNzb2NpYXRpb24gZGVzdC1kbj0ie0BzcmMtZG59IiBkZXN0LWVudHJ5LWlkPSJ7QHNyYy1lbnRyeS1pZH0iPgoJCQkJCQkJCQk8eHNsOnZhbHVlLW9mIHNlbGVjdD0iJGFzc29jaWF0aW9uVmFsdWUiLz4KCQkJCQkJCQk8L2FkZC1hc3NvY2lhdGlvbj4KCQkJCQkJCTwveHNsOnZhcmlhYmxlPgoJCQkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJkdW1teTIiIHNlbGVjdD0iY21kOmV4ZWN1dGUoJHNyY0NvbW1hbmRQcm9jZXNzb3IsICRkdW1teSkiLz4KCQkJCQkJPC94c2w6aWY+CgkJCQkJCTx4c2w6YXBwbHktdGVtcGxhdGVzIHNlbGVjdD0iJHZTcGxpdFdvcmRzIj4KCQkJCQkJCTx4c2w6d2l0aC1wYXJhbSBuYW1lPSJpbnB1dCIgc2VsZWN0PSIuIi8+CgkJCQkJCTwveHNsOmFwcGx5LXRlbXBsYXRlcz4KCQkJCQkJPCEtLSBmaW5pc2ggdGhlIHJlY29yZCB3aXRoIGEgbmV3bGluZSAtLT4KCQkJCQkJPCEtLSB1bmNvbW1lbnQgbmV4dCBsaW5lIHRvIGhhdmUgRE9TIHN0eWxlIGVuZCBvZiBsaW5lICgwRDBBKSwgb3RoZXJ3aXNlIGp1c3QgMEEgLS0+CgkJCQkJCTwhLS0gPHhzbDp2YWx1ZS1vZiBzZWxlY3Q9IicmI3gwRDsnIi8+IC0tPgoJCQkJCQk8eHNsOnZhbHVlLW9mIHNlbGVjdD0iJmFwb3M7JiN4YTsmYXBvczsiLz4KCQkJCQk8L3hzbDp0ZW1wbGF0ZT4KCQkJCQk8IS0tIEJlbG93IHNwbGl0cyB0aGUgZmllbGQtbmFtZXMgY29udGFpbmVkIGluIGZpZWxkLWxpc3QgLS0+CgkJCQkJPHhzbDp0ZW1wbGF0ZSBuYW1lPSJzcGxpdCI+CgkJCQkJCTx4c2w6cGFyYW0gbmFtZT0iblRleHQiLz4KCQkJCQkJPHhzbDpwYXJhbSBuYW1lPSJuRWxlbU5hbWUiIHNlbGVjdD0iJ3dvcmQnIi8+CgkJCQkJCTx4c2w6dmFyaWFibGUgbmFtZT0iZmlyc3QiIHNlbGVjdD0ic3Vic3RyaW5nLWJlZm9yZShjb25jYXQoJG5UZXh0LCcsJyksJywnKSIvPgoJCQkJCQk8eHNsOnZhcmlhYmxlIG5hbWU9InJlbWFpbmluZyIgc2VsZWN0PSJzdWJzdHJpbmctYWZ0ZXIoJG5UZXh0LCcsJykiLz4KCQkJCQkJPHhzbDplbGVtZW50IG5hbWU9InskbkVsZW1OYW1lfSI+CgkJCQkJCQk8eHNsOnZhbHVlLW9mIHNlbGVjdD0iJGZpcnN0Ii8+CgkJCQkJCTwveHNsOmVsZW1lbnQ+CgkJCQkJCTx4c2w6Y2hvb3NlPgoJCQkJCQkJPHhzbDp3aGVuIHRlc3Q9IiRyZW1haW5pbmciPgoJCQkJCQkJCTx4c2w6Y2FsbC10ZW1wbGF0ZSBuYW1lPSJzcGxpdCI+CgkJCQkJCQkJCTx4c2w6d2l0aC1wYXJhbSBuYW1lPSJuVGV4dCIgc2VsZWN0PSIkcmVtYWluaW5nIi8+CgkJCQkJCQkJCTx4c2w6d2l0aC1wYXJhbSBuYW1lPSJuRWxlbU5hbWUiIHNlbGVjdD0iJG5FbGVtTmFtZSIvPgoJCQkJCQkJCTwveHNsOmNhbGwtdGVtcGxhdGU+CgkJCQkJCQk8L3hzbDp3aGVuPgoJCQkJCQk8L3hzbDpjaG9vc2U+CgkJCQkJPC94c2w6dGVtcGxhdGU+CgkJCQkJPHhzbDp0ZW1wbGF0ZSBtYXRjaD0id29yZCI+CgkJCQkJCTx4c2w6cGFyYW0gbmFtZT0iaW5wdXQiLz4KCQkJCQkJPHhzbDppZiB0ZXN0PSJwb3NpdGlvbigpID4gMSI+CgkJCQkJCQk8eHNsOnZhbHVlLW9mIHNlbGVjdD0iJGRlbGltaXRlciIvPgoJCQkJCQk8L3hzbDppZj4KCQkJCQkJPHhzbDpjaG9vc2U+CgkJCQkJCQk8eHNsOndoZW4gdGVzdD0iJGlucHV0LypbKEBhdHRyLW5hbWUgPSBjdXJyZW50KCkpXS92YWx1ZS9AdHlwZT0nc3RydWN0dXJlZCciPgoJCQkJCQkJCTx4c2w6Y2FsbC10ZW1wbGF0ZSBuYW1lPSJvdXRwdXQtZmllbGQiPgoJCQkJCQkJCQk8eHNsOndpdGgtcGFyYW0gbmFtZT0iZmllbGQtdmFsdWUiIHNlbGVjdD0iJGlucHV0LypbKEBhdHRyLW5hbWUgPSBjdXJyZW50KCkpXS92YWx1ZS9jb21wb25lbnRbMV0vdGV4dCgpIi8+CgkJCQkJCQkJPC94c2w6Y2FsbC10ZW1wbGF0ZT4KCQkJCQkJCTwveHNsOndoZW4+CgkJCQkJCQk8eHNsOm90aGVyd2lzZT4KCQkJCQkJCQk8eHNsOmNhbGwtdGVtcGxhdGUgbmFtZT0ib3V0cHV0LWZpZWxkIj4KCQkJCQkJCQkJPHhzbDp3aXRoLXBhcmFtIG5hbWU9ImZpZWxkLXZhbHVlIiBzZWxlY3Q9IiRpbnB1dC8qWyhAYXR0ci1uYW1lID0gY3VycmVudCgpKV0vdmFsdWUiLz4KCQkJCQkJCQk8L3hzbDpjYWxsLXRlbXBsYXRlPgoJCQkJCQkJPC94c2w6b3RoZXJ3aXNlPgoJCQkJCQk8L3hzbDpjaG9vc2U+CgkJCQkJPC94c2w6dGVtcGxhdGU+CgkJCQkJPHhzbDp0ZW1wbGF0ZSBuYW1lPSJvdXRwdXQtZmllbGQiPgoJCQkJCQk8eHNsOnBhcmFtIG5hbWU9ImZpZWxkLXZhbHVlIi8+CgkJCQkJCTx4c2w6Y2hvb3NlPgoJCQkJCQkJPHhzbDp3aGVuIHRlc3Q9ImNvdW50KCRmaWVsZC12YWx1ZSk+MSI+CgkJCQkJCQkJPHhzbDpmb3ItZWFjaCBzZWxlY3Q9IiRmaWVsZC12YWx1ZSI+CgkJCQkJCQkJCTx4c2w6dmFsdWUtb2Ygc2VsZWN0PSIuIi8+CgkJCQkJCQkJCTx4c2w6aWYgdGVzdD0icG9zaXRpb24oKSAhPSBsYXN0KCkiPnw8L3hzbDppZj4KCQkJCQkJCQk8L3hzbDpmb3ItZWFjaD4KCQkJCQkJCTwveHNsOndoZW4+CgkJCQkJCQk8eHNsOndoZW4gdGVzdD0iY29udGFpbnMoJGZpZWxkLXZhbHVlWzFdLCAkREVMSU1JVEVSKSI+CgkJCQkJCQkJPCEtLSBpZiB0aGUgZmllbGQgdmFsdWUgY29udGFpbnMgYSBkZWxpbWl0ZXIsIHRoZW4gZW5jbG9zZSBpbiBxdW90ZXMgLS0+CgkJCQkJCQkJPHhzbDp0ZXh0PiI8L3hzbDp0ZXh0PgoJCQkJCQkJCTx4c2w6dmFsdWUtb2Ygc2VsZWN0PSIkZmllbGQtdmFsdWUiLz4KCQkJCQkJCQk8eHNsOnRleHQ+IjwveHNsOnRleHQ+CgkJCQkJCQk8L3hzbDp3aGVuPgoJCQkJCQkJPHhzbDpvdGhlcndpc2U+CgkJCQkJCQkJPCEtLSBvdGhlcndpc2Ugb3V0cHV0IGl0IHJhdyAtLT4KCQkJCQkJCQk8eHNsOnZhbHVlLW9mIHNlbGVjdD0iJGZpZWxkLXZhbHVlIi8+CgkJCQkJCQk8L3hzbDpvdGhlcndpc2U+CgkJCQkJCTwveHNsOmNob29zZT4KCQkJCQk8L3hzbDp0ZW1wbGF0ZT4KCQkJCQk8eHNsOnRlbXBsYXRlIG1hdGNoPSJAKnxub2RlKCkiPgoJCQkJCQk8eHNsOmNvcHk+CgkJCQkJCQk8eHNsOmFwcGx5LXRlbXBsYXRlcyBzZWxlY3Q9IkAqfG5vZGUoKSIvPgoJCQkJCQk8L3hzbDpjb3B5PgoJCQkJCTwveHNsOnRlbXBsYXRlPgoJCQkJPC94c2w6c3R5bGVzaGVldD4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW1SbFptRjFiSFFpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlQ0S0NRazhjRzlzYVdONUxYTmxkQ0J1WVcxbFBTSnZkWFJ3ZFhRaUlHOXlaR1Z5UFNKbWFYSnpkQ0l2UGdvSlBDOXdiMnhwWTNrdGJHbHVhMkZuWlQ0S1BDOXBibk4wWVd4c1lYUnBiMjR0WkdseVpXTjBhWFpsUGc9PTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1kaXJlY3RpdmVjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT4yMzY0MjQxODE2PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2Vhc3NvY2d1aWQiPgoJCQk8ZHMtdmFsdWU+SVBHVDVJUUlfMjAxMDA2MTUxMjA1MzAwNDY4PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLXBhY2thZ2VndWlkIj4KCQkJPGRzLXZhbHVlPlJJU0RPNTU5XzIwMTAwNjE1MTA1MzQ4MDc2NTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1jb250ZW50Y2hlY2tzdW0iPgoJCQk8ZHMtdmFsdWU+MTY0NjA5MTE5MzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
			<pkg-initial-state package-id="RISDO559_201006151053480765" pkg-assoc-id="DOMS694Q_201006151206020343" version="2.3.5.20190905105253">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVN0eWxlU2hlZXQiIGRzLW9iamVjdC1uYW1lPSJOT1ZMRFRYVEJBU0UtaXRzIiBuYW1lPSJOT1ZMRFRYVEJBU0UtaXRzIj4KCTxkcy1hdHRyaWJ1dGVzPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJYbWxEYXRhIj4KCQkJPGRzLXZhbHVlPgoJCQkJPHhzbDpzdHlsZXNoZWV0IGV4dGVuc2lvbi1lbGVtZW50LXByZWZpeGVzPSJueHNsIiB2ZXJzaW9uPSIxLjAiIHhtbG5zOm54c2w9Imh0dHA6Ly93d3cubm92ZWxsLmNvbS9ueHNsIiB4bWxuczp4c2w9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvWFNML1RyYW5zZm9ybSI+CgkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJhc3NvY2lhdGlvbi1maWVsZC1uYW1lIiBzZWxlY3Q9Iid+ZHJpdmVyLmFzc29jaWF0aW9uLmF0dHJpYnV0ZX4nIi8+CgkJCQkJPHhzbDp0ZW1wbGF0ZSBtYXRjaD0iLyI+CgkJCQkJCTx4c2w6Y2hvb3NlPgoJCQkJCQkJPCEtLSBpZiBkb2N1bWVudCBlbGVtZW50IGlzIGRlbGltaXRlZC10ZXh0LCB0aGVuIHdlIG5lZWQgdG8gZG8gdGhlIHRyYW5zZm9ybWF0aW9uIC0tPgoJCQkJCQkJPHhzbDp3aGVuIHRlc3Q9ImRlbGltaXRlZC10ZXh0Ij4KCQkJCQkJCQk8bmRzIGR0ZHZlcnNpb249IjEuMSIgbmRzdmVyc2lvbj0iOC42IiB4bWw6c3BhY2U9ImRlZmF1bHQiPgoJCQkJCQkJCQk8aW5wdXQ+CgkJCQkJCQkJCQk8IS0tIGZvciBlYWNoIHJlY29yZCwgZG8gYW4gYWRkIC0tPgoJCQkJCQkJCQkJPHhzbDpmb3ItZWFjaCBzZWxlY3Q9ImRlbGltaXRlZC10ZXh0L3JlY29yZCI+CgkJCQkJCQkJCQkJPCEtLSBzZWUgTkRTRFREIGRvYyBvbiB3ZWIgZm9yIEFkZCB2ZXJiIHN5bnRheCAmIGRldGFpbHMgLS0+CgkJCQkJCQkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJzcmNkbiIgc2VsZWN0PSJ0cmFuc2xhdGUoZmllbGRbQG5hbWU9JGFzc29jaWF0aW9uLWZpZWxkLW5hbWVdLCcrPSwuXCcsJy0tLS0tJykiLz4KCQkJCQkJCQkJCQk8IS0tIGdlbmVyYXRlIHRoZSBhZGQgZXZlbnQgLS0+CgkJCQkJCQkJCQkJPGFkZCBjbGFzcy1uYW1lPSJVc2VyIiBzcmMtZG49Inskc3JjZG59Ij4KCQkJCQkJCQkJCQkJPCEtLSBnZW5lcmF0ZSB0aGUgYXNzb2NpYXRpb24gLS0+CgkJCQkJCQkJCQkJCTxhc3NvY2lhdGlvbj4KCQkJCQkJCQkJCQkJCTx4c2w6dmFsdWUtb2Ygc2VsZWN0PSJmaWVsZFtAbmFtZT0kYXNzb2NpYXRpb24tZmllbGQtbmFtZV0iLz4KCQkJCQkJCQkJCQkJPC9hc3NvY2lhdGlvbj4KCQkJCQkJCQkJCQkJPCEtLSBoYW5kbGUgZWFjaCBmaWVsZCAtLT4KCQkJCQkJCQkJCQkJPHhzbDpmb3ItZWFjaCBzZWxlY3Q9ImZpZWxkW3N0cmluZygpXSI+CgkJCQkJCQkJCQkJCQk8eHNsOnZhcmlhYmxlIG5hbWU9ImF0dHJOYW1lIiBzZWxlY3Q9IkBuYW1lIi8+CgkJCQkJCQkJCQkJCQk8IS0tIGRvIG5vdCB0cmFuc2xhdGUgZmllbGRzIHdpdGhvdXQgYSAnbmFtZScgYXR0cmlidXRlIC0tPgoJCQkJCQkJCQkJCQkJPHhzbDppZiB0ZXN0PSJzdHJpbmctbGVuZ3RoKCRhdHRyTmFtZSk+MCI+CgkJCQkJCQkJCQkJCQkJPHhzbDp2YXJpYWJsZSBuYW1lPSJmaWVsZFZhbHVlIiBzZWxlY3Q9Im5vcm1hbGl6ZS1zcGFjZSguKSIvPgoJCQkJCQkJCQkJCQkJCTwhLS0gb25seSBhZGQgZmllbGQgdmFsdWUgaWYgbG9uZ2VyIHRoYW4gMSBjaGFyYWN0ZXIgLS0+CgkJCQkJCQkJCQkJCQkJPHhzbDppZiB0ZXN0PSJzdHJpbmctbGVuZ3RoKCRmaWVsZFZhbHVlKT4wIGFuZCBAbmFtZSAhPSAnJyI+CgkJCQkJCQkJCQkJCQkJCTwhLS0gZ2VuZXJhdGUgdGhlIGFkZC1hdHRyIC0tPgoJCQkJCQkJCQkJCQkJCQk8YWRkLWF0dHIgYXR0ci1uYW1lPSJ7QG5hbWV9Ij4KCQkJCQkJCQkJCQkJCQkJCTwhLS0gZ2VuZXJhdGUgdGhlIHZhbHVlIGVsZW1lbnQgdXNpbmcgc3RyaW5nIHN5bnRheCAtLT4KCQkJCQkJCQkJCQkJCQkJCTwhLS0gbm90ZSB0aGF0IGF0dHJpYnV0ZXMgdGhhdCByZXF1aXJlIGEgc3RydWN0dXJlZCBvciBvY3RldCBzeW50YXggLS0+CgkJCQkJCQkJCQkJCQkJCQk8IS0tIG1heSByZXF1aXJlIHNwZWNpYWwgaGFuZGxpbmcgaGVyZSAtLT4KCQkJCQkJCQkJCQkJCQkJCTx2YWx1ZSB0eXBlPSJzdHJpbmciPgoJCQkJCQkJCQkJCQkJCQkJCTx4c2w6dmFsdWUtb2Ygc2VsZWN0PSIkZmllbGRWYWx1ZSIvPgoJCQkJCQkJCQkJCQkJCQkJPC92YWx1ZT4KCQkJCQkJCQkJCQkJCQkJPC9hZGQtYXR0cj4KCQkJCQkJCQkJCQkJCQk8L3hzbDppZj4KCQkJCQkJCQkJCQkJCTwveHNsOmlmPgoJCQkJCQkJCQkJCQk8L3hzbDpmb3ItZWFjaD4KCQkJCQkJCQkJCQk8L2FkZD4KCQkJCQkJCQkJCTwveHNsOmZvci1lYWNoPgoJCQkJCQkJCQk8L2lucHV0PgoJCQkJCQkJCTwvbmRzPgoJCQkJCQkJPC94c2w6d2hlbj4KCQkJCQkJCTx4c2w6b3RoZXJ3aXNlPgoJCQkJCQkJCTwhLS0gaWYgdGhlIGRvY3VtZW50IGVsZW1lbnQgaXMgbm90IDxkZWxpbWl0ZWQtdGV4dD4gY29weSBhcyBpcy0tPgoJCQkJCQkJCTx4c2w6Y29weS1vZiBzZWxlY3Q9Ii4iLz4KCQkJCQkJCTwveHNsOm90aGVyd2lzZT4KCQkJCQkJPC94c2w6Y2hvb3NlPgoJCQkJCTwveHNsOnRlbXBsYXRlPgoJCQkJPC94c2w6c3R5bGVzaGVldD4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW1SbFptRjFiSFFpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlQ0S0NRazhjRzlzYVdONUxYTmxkQ0J1WVcxbFBTSnBibkIxZENJZ2IzSmtaWEk5SW1acGNuTjBJaTgrQ2drOEwzQnZiR2xqZVMxc2FXNXJZV2RsUGdvOEwybHVjM1JoYkd4aGRHbHZiaTFrYVhKbFkzUnBkbVUrPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjkzNjE0MjI1MzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPkRPTVM2OTRRXzIwMTAwNjE1MTIwNjAyMDM0MzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5SSVNETzU1OV8yMDEwMDYxNTEwNTM0ODA3NjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjI4OTkyNTI0MzM8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJPC9kcy1hdHRyaWJ1dGVzPgo8L2RzLW9iamVjdD4=</pkg-initial-state>
			<pkg-initial-state package-id="RISDO559_201006151053480765" pkg-assoc-id="5TADED7P_201306141739380843" version="2.3.5.20190905105253">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLVJ1bGUiIGRzLW9iamVjdC1uYW1lPSJOT1ZMRFRYVEJBU0Utc21wIiBtYXBwaW5nLXBvbGljeT0idHJ1ZSIgbmFtZT0iTk9WTERUWFRCQVNFLXNtcCI+Cgk8ZHMtYXR0cmlidXRlcz4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iWG1sRGF0YSI+CgkJCTxkcy12YWx1ZT4KCQkJCTxhdHRyLW5hbWUtbWFwPgoJCQkJCTxjbGFzcy1uYW1lPgoJCQkJCQk8bmRzLW5hbWU+VXNlcjwvbmRzLW5hbWU+CgkJCQkJCTxhcHAtbmFtZT5Vc2VyPC9hcHAtbmFtZT4KCQkJCQk8L2NsYXNzLW5hbWU+CgkJCQkJPGF0dHItbmFtZSBjbGFzcy1uYW1lPSJVc2VyIj4KCQkJCQkJPG5kcy1uYW1lPkRlc2NyaXB0aW9uPC9uZHMtbmFtZT4KCQkJCQkJPGFwcC1uYW1lPkRlc2NyaXB0aW9uPC9hcHAtbmFtZT4KCQkJCQk8L2F0dHItbmFtZT4KCQkJCQk8YXR0ci1uYW1lIGNsYXNzLW5hbWU9IlVzZXIiPgoJCQkJCQk8bmRzLW5hbWU+RmFjc2ltaWxlIFRlbGVwaG9uZSBOdW1iZXI8L25kcy1uYW1lPgoJCQkJCQk8YXBwLW5hbWU+RmF4PC9hcHAtbmFtZT4KCQkJCQk8L2F0dHItbmFtZT4KCQkJCQk8YXR0ci1uYW1lIGNsYXNzLW5hbWU9IlVzZXIiPgoJCQkJCQk8bmRzLW5hbWU+R2l2ZW4gTmFtZTwvbmRzLW5hbWU+CgkJCQkJCTxhcHAtbmFtZT5GaXJzdE5hbWU8L2FwcC1uYW1lPgoJCQkJCTwvYXR0ci1uYW1lPgoJCQkJCTxhdHRyLW5hbWUgY2xhc3MtbmFtZT0iVXNlciI+CgkJCQkJCTxuZHMtbmFtZT5JbnRlcm5ldCBFTWFpbCBBZGRyZXNzPC9uZHMtbmFtZT4KCQkJCQkJPGFwcC1uYW1lPkVtYWlsPC9hcHAtbmFtZT4KCQkJCQk8L2F0dHItbmFtZT4KCQkJCQk8YXR0ci1uYW1lIGNsYXNzLW5hbWU9IlVzZXIiPgoJCQkJCQk8bmRzLW5hbWU+bW9iaWxlPC9uZHMtbmFtZT4KCQkJCQkJPGFwcC1uYW1lPldpcmVsZXNzUGhvbmU8L2FwcC1uYW1lPgoJCQkJCTwvYXR0ci1uYW1lPgoJCQkJCTxhdHRyLW5hbWUgY2xhc3MtbmFtZT0iVXNlciI+CgkJCQkJCTxuZHMtbmFtZT5TdXJuYW1lPC9uZHMtbmFtZT4KCQkJCQkJPGFwcC1uYW1lPkxhc3ROYW1lPC9hcHAtbmFtZT4KCQkJCQk8L2F0dHItbmFtZT4KCQkJCQk8YXR0ci1uYW1lIGNsYXNzLW5hbWU9IlVzZXIiPgoJCQkJCQk8bmRzLW5hbWU+VGVsZXBob25lIE51bWJlcjwvbmRzLW5hbWU+CgkJCQkJCTxhcHAtbmFtZT5Xb3JrUGhvbmU8L2FwcC1uYW1lPgoJCQkJCTwvYXR0ci1uYW1lPgoJCQkJCTxhdHRyLW5hbWUgY2xhc3MtbmFtZT0iVXNlciI+CgkJCQkJCTxuZHMtbmFtZT5UaXRsZTwvbmRzLW5hbWU+CgkJCQkJCTxhcHAtbmFtZT5UaXRsZTwvYXBwLW5hbWU+CgkJCQkJPC9hdHRyLW5hbWU+CgkJCQkJPGF0dHItbmFtZSBjbGFzcy1uYW1lPSJVc2VyIj4KCQkJCQkJPG5kcy1uYW1lPndvcmtmb3JjZUlEPC9uZHMtbmFtZT4KCQkJCQkJPGFwcC1uYW1lPldvcmtmb3JjZUlEPC9hcHAtbmFtZT4KCQkJCQk8L2F0dHItbmFtZT4KCQkJCTwvYXR0ci1uYW1lLW1hcD4KCQkJPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpUNEtDVHh3YkdGalpXMWxiblFnYkc5allYUnBiMjQ5SW1SbFptRjFiSFFpTHo0S0NUeGtjeTFoZEhSeWFXSjFkR1Z6THo0S0NUeHdiMnhwWTNrdGJHbHVhMkZuWlQ0S0NRazhjRzlzYVdONUxYTmxkQ0JqYUdGdWJtVnNQU0p3ZFdKc2FYTm9aWElpSUc1aGJXVTlJbk5qYUdWdFlTSWdiM0prWlhJOUlsZGxhV2RvZENJZ2RtRnNkV1U5SWpVd01DSXZQZ29KUEM5d2IyeHBZM2t0YkdsdWEyRm5aVDRLUEM5cGJuTjBZV3hzWVhScGIyNHRaR2x5WldOMGFYWmxQZz09PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjUyOTk5Njg5NTwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlYXNzb2NndWlkIj4KCQkJPGRzLXZhbHVlPjVUQURFRDdQXzIwMTMwNjE0MTczOTM4MDg0MzwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+CgkJPGRzLWF0dHJpYnV0ZSBkcy1hdHRyLW5hbWU9ImlkbS1wYWNrYWdlZ3VpZCI+CgkJCTxkcy12YWx1ZT5SSVNETzU1OV8yMDEwMDYxNTEwNTM0ODA3NjU8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tY29udGVudGNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjEwMjM4MDUxNDwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
			<pkg-initial-state package-id="RISDO559_201006151053480765" pkg-assoc-id="2ISPXUXI_201211161505500546" version="2.3.5.20190905105253">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48ZHMtb2JqZWN0IGRzLW9iamVjdC1jbGFzcz0iRGlyWE1MLUdsb2JhbENvbmZpZ0RlZiIgZHMtb2JqZWN0LW5hbWU9Ik5PVkxEVFhUQkFTRS1HQ1ZzIiBuYW1lPSJOT1ZMRFRYVEJBU0UtR0NWcyI+Cgk8ZHMtYXR0cmlidXRlcz4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWluc3RhbGxhdGlvbmRpcmVjdGl2ZSI+CgkJCTxkcy12YWx1ZT5QRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUJsYm1OdlpHbHVaejBpVlZSR0xUZ2lQejQ4YVc1emRHRnNiR0YwYVc5dUxXUnBjbVZqZEdsMlpTQnRiMlJsUFNKaGJHd2lQZ29KUEhCc1lXTmxiV1Z1ZENCc2IyTmhkR2x2YmowaVpHVm1ZWFZzZENJdlBnb0pQR1J6TFdGMGRISnBZblYwWlhNdlBnb0pQR052Ym1acFozVnlZWFJwYjI0dGRtRnNkV1Z6UGdvSkNUeGtaV1pwYm1sMGFXOXVjeUJrYVhOd2JHRjVMVzVoYldVOUlrTnZibVpwWjNWeVlYUnBiMjRpUGdvSkNRazhhR1ZoWkdWeUlHUnBjM0JzWVhrdGJtRnRaVDBpZUd4bWFXUW9UazlXVEVSVVdGUkNRVk5GTG1kc2IySmhiR052Ym1acFp5NU9UMVpNUkZSWVZFSkJVMFZIUTFaekxtZGpkaTVvWldGa1pYSXVSSEpwZG1WeWNHRnlZVzFsZEdWeUtVUnlhWFpsY2lCd1lYSmhiV1YwWlhJaUx6NEtDUWtKUEdSbFptbHVhWFJwYjI0Z1pHbHpjR3hoZVMxdVlXMWxQU0o0YkdacFpDaE9UMVpNUkZSWVZFSkJVMFV1WjJ4dlltRnNZMjl1Wm1sbkxrNVBWa3hFVkZoVVFrRlRSVWREVm5NdVoyTjJMbVJ5YVhabGNpNW1hV1ZzWkM1a1pXeHBiV2wwWlhJcFJtbGxiR1FnUkdWc2FXMXBkR1Z5T2lJZ2JtRnRaVDBpWkhKcGRtVnlMbVpwWld4a0xtUmxiR2x0YVhSbGNpSWdkSGx3WlQwaWMzUnlhVzVuSWo0S0NRa0pDVHhrWlhOamNtbHdkR2x2Ymk4K0Nna0pDUWs4ZG1Gc2RXVStMRHd2ZG1Gc2RXVStDZ2tKQ1R3dlpHVm1hVzVwZEdsdmJqNEtDUWtKUEdSbFptbHVhWFJwYjI0Z1pHbHpjR3hoZVMxdVlXMWxQU0o0YkdacFpDaE9UMVpNUkZSWVZFSkJVMFV1WjJ4dlltRnNZMjl1Wm1sbkxrNVBWa3hFVkZoVVFrRlRSVWREVm5NdVoyTjJMbVJ5YVhabGNpNW1hV1ZzWkMxdVlXMWxjeWxHYVdWc1pDQk9ZVzFsY3lBb1ptbGxiR1F4TEdacFpXeGtNaXhtYVdWc1pETXVMaTRwT2lJZ2JtRnRaVDBpWkhKcGRtVnlMbVpwWld4a0xXNWhiV1Z6SWlCMGVYQmxQU0p6ZEhKcGJtY2lQZ29KQ1FrSlBHUmxjMk55YVhCMGFXOXVMejRLQ1FrSkNUeDJZV3gxWlQ1WGIzSnJabTl5WTJWSlJDeE1ZWE4wVG1GdFpTeEdhWEp6ZEU1aGJXVXNWR2wwYkdVc1JXMWhhV3dzVjI5eWExQm9iMjVsTEVaaGVDeFhhWEpsYkdWemMxQm9iMjVsTEVSbGMyTnlhWEIwYVc5dVBDOTJZV3gxWlQ0S0NRa0pQQzlrWldacGJtbDBhVzl1UGdvSkNRazhaR1ZtYVc1cGRHbHZiaUJrYVhOd2JHRjVMVzVoYldVOUluaHNabWxrS0U1UFZreEVWRmhVUWtGVFJTNW5iRzlpWVd4amIyNW1hV2N1VGs5V1RFUlVXRlJDUVZORlIwTldjeTVuWTNZdVpISnBkbVZ5TG1GemMyOWphV0YwYVc5dUxtRjBkSEpwWW5WMFpTbEJjM052WTJsaGRHbHZiaUJCZEhScFluVjBaVG9pSUc1aGJXVTlJbVJ5YVhabGNpNWhjM052WTJsaGRHbHZiaTVoZEhSeWFXSjFkR1VpSUhSNWNHVTlJbk4wY21sdVp5SStDZ2tKQ1FrOFpHVnpZM0pwY0hScGIyNCtlR3htYVdRb1RrOVdURVJVV0ZSQ1FWTkZMbWRzYjJKaGJHTnZibVpwWnk1T1QxWk1SRlJZVkVKQlUwVkhRMVp6TG1kamRpNWtjMk55TG1SeWFYWmxjaTVoYzNOdlkybGhkR2x2Ymk1aGRIUnlhV0oxZEdVcFZHaGxJR0YwZEhKcFluVjBaU0IyWVd4MVpTQjBieUJpWlNCMWMyVmtJR0Z6SUdGdUlHRnpjMjlqYVdGMGFXOXVMand2WkdWelkzSnBjSFJwYjI0K0Nna0pDUWs4ZG1Gc2RXVStSVzFoYVd3OEwzWmhiSFZsUGdvSkNRazhMMlJsWm1sdWFYUnBiMjQrQ2drSkNUeGtaV1pwYm1sMGFXOXVJR055YVhScFkyRnNMV05vWVc1blpUMGlkSEoxWlNJZ1pHbHpjR3hoZVMxdVlXMWxQU0o0YkdacFpDaE9UMVpNUkZSWVZFSkJVMFV1WjJ4dlltRnNZMjl1Wm1sbkxrNVBWa3hFVkZoVVFrRlRSVWREVm5NdVoyTjJMbVJ5YVhabGNpNTBjbUZqWlVSaGRHRXBVM1Z3Y0hKbGMzTWdSVzVqY25sd2RHVmtJRUYwZEhKcFluVjBaU0JwYmlCVWNtRmpaU0lnYm1GdFpUMGlaSEpwZG1WeUxuUnlZV05sUkdGMFlTSWdkSGx3WlQwaVpXNTFiU0krQ2drSkNRazhaR1Z6WTNKcGNIUnBiMjQrZUd4bWFXUW9UazlXVEVSVVdGUkNRVk5GTG1kc2IySmhiR052Ym1acFp5NU9UMVpNUkZSWVZFSkJVMFZIUTFaekxtZGpkaTVrYzJOeUxtUnlhWFpsY2k1MGNtRmpaVVJoZEdFcFFua2dSR1ZtWVhWc2RDQkVaV3hwYldsMFpYSWdWR1Y0ZENCRWNtbDJaWElnVTNWd2NISmxjM01nZEdobElHTnZiblJsYm5Rc0lGTmxkQ0FpVG04aUlIUnZJSFpwWlhjZ2RHaGxJR052Ym5SbGJuUWdhVzRnVkhKaFkyVXVQQzlrWlhOamNtbHdkR2x2Ymo0S0NRa0pDVHhsYm5WdExXTm9iMmxqWlNCa2FYTndiR0Y1TFc1aGJXVTlJbmhzWm1sa0tFNVBWa3hFVkZoVVFrRlRSUzVuYkc5aVlXeGpiMjVtYVdjdVRrOVdURVJVV0ZSQ1FWTkZSME5XY3k1blkzWXVZMmh2YVdObExtUnlhWFpsY2k1MGNtRmpaVVJoZEdFdVdXVnpLVmxsY3lJK2VXVnpQQzlsYm5WdExXTm9iMmxqWlQ0S0NRa0pDVHhsYm5WdExXTm9iMmxqWlNCa2FYTndiR0Y1TFc1aGJXVTlJbmhzWm1sa0tFNVBWa3hFVkZoVVFrRlRSUzVuYkc5aVlXeGpiMjVtYVdjdVRrOVdURVJVV0ZSQ1FWTkZSME5XY3k1blkzWXVZMmh2YVdObExtUnlhWFpsY2k1MGNtRmpaVVJoZEdFdVRtOHBUbThpUG01dlBDOWxiblZ0TFdOb2IybGpaVDRLQ1FrSkNUeDJZV3gxWlQ1NVpYTThMM1poYkhWbFBnb0pDUWs4TDJSbFptbHVhWFJwYjI0K0Nna0pQQzlrWldacGJtbDBhVzl1Y3o0S0NUd3ZZMjl1Wm1sbmRYSmhkR2x2YmkxMllXeDFaWE0rQ2drOGNHOXNhV041TFd4cGJtdGhaMlUrQ2drSlBIQnZiR2xqZVMxelpYUWdibUZ0WlQwaVoyTjJJaUJ2Y21SbGNqMGlkMlZwWjJoMElpQjJZV3gxWlQwaU5EVXdJaTgrQ2drOEwzQnZiR2xqZVMxc2FXNXJZV2RsUGdvOEwybHVjM1JoYkd4aGRHbHZiaTFrYVhKbFkzUnBkbVUrPC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWRpcmVjdGl2ZWNoZWNrc3VtIj4KCQkJPGRzLXZhbHVlPjE4Mjk1ODEzOTA8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWFzc29jZ3VpZCI+CgkJCTxkcy12YWx1ZT4ySVNQWFVYSV8yMDEyMTExNjE1MDU1MDA1NDY8L2RzLXZhbHVlPgoJCTwvZHMtYXR0cmlidXRlPgoJCTxkcy1hdHRyaWJ1dGUgZHMtYXR0ci1uYW1lPSJpZG0tcGFja2FnZWd1aWQiPgoJCQk8ZHMtdmFsdWU+UklTRE81NTlfMjAxMDA2MTUxMDUzNDgwNzY1PC9kcy12YWx1ZT4KCQk8L2RzLWF0dHJpYnV0ZT4KCQk8ZHMtYXR0cmlidXRlIGRzLWF0dHItbmFtZT0iaWRtLWNvbnRlbnRjaGVja3N1bSI+CgkJCTxkcy12YWx1ZT40NzA5NDkyNDwvZHMtdmFsdWU+CgkJPC9kcy1hdHRyaWJ1dGU+Cgk8L2RzLWF0dHJpYnV0ZXM+CjwvZHMtb2JqZWN0Pg==</pkg-initial-state>
		</pkg-initial-states>
	</attributes>
	<children>
		<publisher name="Publisher">
			<attributes/>
			<children>
				<rule checksum="2553984197" name="NOVLDTXTBASE-pub-cp" package-id="RISDO559_201006151053480765" pkg-assoc-id="JDN19F9U_201006151146570171">
					<policy>
						<rule>
							<description>Required Attributes</description>
							<conditions>
								<or>
									<if-class-name op="equal">User</if-class-name>
								</or>
							</conditions>
							<actions>
								<do-veto-if-op-attr-not-available name="Given Name"/>
								<do-veto-if-op-attr-not-available name="Surname"/>
								<do-veto-if-op-attr-not-available name="Internet EMail Address"/>
							</actions>
						</rule>
						<rule>
							<description>Name-Based Object Naming - Variable Length</description>
							<conditions>
								<and>
									<if-class-name op="equal">User</if-class-name>
								</and>
							</conditions>
							<actions>
								<do-set-local-variable name="tmpSurname">
									<arg-string>
										<token-op-attr name="Surname"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="stripSurname">
									<arg-string>
										<token-xpath expression="translate($tmpSurname,&quot;-+&apos;&quot;,&quot;&quot;)"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="tmpGivenname">
									<arg-string>
										<token-op-attr name="Given Name"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="stripGivenname">
									<arg-string>
										<token-xpath expression="translate($tmpGivenname,&quot;-+&apos;&quot;,&quot;&quot;)"/>
									</arg-string>
								</do-set-local-variable>
								<do-set-local-variable name="unique-cn" scope="driver">
									<arg-string>
										<token-unique-name counter-digits="3" counter-pad="false" counter-pattern="first" name="CN" scope="subtree">
											<arg-string>
												<token-lower-case>
													<token-substring length="1">
														<token-local-variable name="stripGivenname"/>
													</token-substring>
													<token-local-variable name="stripSurname"/>
												</token-lower-case>
											</arg-string>
											<arg-string>
												<token-lower-case>
													<token-substring length="2">
														<token-local-variable name="stripGivenname"/>
													</token-substring>
													<token-local-variable name="stripSurname"/>
												</token-lower-case>
											</arg-string>
											<arg-string>
												<token-lower-case>
													<token-substring length="3">
														<token-local-variable name="stripGivenname"/>
													</token-substring>
													<token-local-variable name="stripSurname"/>
												</token-lower-case>
											</arg-string>
										</token-unique-name>
									</arg-string>
								</do-set-local-variable>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="326967876" name="NOVLDTXTBASE-pub-mp" package-id="RISDO559_201006151053480765" pkg-assoc-id="QA93SVD4_201006151147020234">
					<policy>
						<rule>
							<description>Match based on Internet Email Address</description>
							<conditions>
								<or>
									<if-class-name op="equal">User</if-class-name>
								</or>
							</conditions>
							<actions>
								<do-find-matching-object scope="subtree">
									<arg-match-attr name="Internet EMail Address"/>
								</do-find-matching-object>
							</actions>
						</rule>
					</policy>
				</rule>
				<rule checksum="3492013382" name="NOVLDTXTBASE-pub-pp" package-id="RISDO559_201006151053480765" pkg-assoc-id="WOMKYWGB_201006151147060859">
					<policy>
						<rule>
							<description>User object placement</description>
							<conditions>
								<or>
									<if-class-name op="equal">User</if-class-name>
								</or>
							</conditions>
							<actions>
								<do-set-op-dest-dn>
									<arg-dn>
										<token-global-variable name="idv.dit.data.users"/>
										<token-text xml:space="preserve">\</token-text>
										<token-local-variable name="unique-cn"/>
									</arg-dn>
								</do-set-op-dest-dn>
							</actions>
						</rule>
					</policy>
				</rule>
			</children>
		</publisher>
		<subscriber name="Subscriber">
			<attributes/>
			<children>
				<stylesheet checksum="2867446281" name="NOVLDTXTBASE-sub-ets" package-id="RISDO559_201006151053480765" pkg-assoc-id="ARS8VSYS_201006151203150906">
					<xsl:stylesheet version="1.0" xmlns:query="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.driver.XdsQueryProcessor" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
						<xsl:param name="srcQueryProcessor"/>
						<!-- The first two templates implement the identity transform.	-->
						<!-- anything that doesn't match a more specific template will	-->
						<!-- be copied as is to the output 								-->
						<xsl:template match="/">
							<xsl:apply-templates select="node()|@*"/>
						</xsl:template>
						<xsl:template match="node()|@*">
							<xsl:copy>
								<xsl:apply-templates select="node()|@*"/>
							</xsl:copy>
						</xsl:template>
						<xsl:template match="modify|sync">
							<!-- convert modify or sync with an assocition to an instance so that -->
							<!-- output transform can create a complete output record -->
							<xsl:variable name="associationValue" select="string(association/text())"/>
							<xsl:choose>
								<xsl:when test="association[@state = 'disabled']">
									<!-- ignore if the association is disabled -->
								</xsl:when>
								<xsl:otherwise>
									<!-- if a modify on an associated object the association replace it with the instance -->
									<!-- returned by querying the object -->
									<xsl:variable name="query">
										<nds dtdversion="1.0" ndsversion="8.5">
											<input>
												<!-- may want to specifiy a dest-dn here to specify the root of the search -->
												<query class-name="User" dest-dn="{@src-dn}" dest-entry-id="{@src-entry-id}" scope="entry">
													<!-- this should match the attributes in the subscriber filter -->
													<read-attr attr-name="Description"/>
													<read-attr attr-name="Facsimile Telephone Number"/>
													<read-attr attr-name="Given Name"/>
													<read-attr attr-name="Internet EMail Address"/>
													<read-attr attr-name="mobile"/>
													<read-attr attr-name="Surname"/>
													<read-attr attr-name="Telephone Number"/>
													<read-attr attr-name="Title"/>
													<read-attr attr-name="workforceID"/>
													<read-attr attr-name="DirXML-EntitlementRef"/>
												</query>
											</input>
										</nds>
									</xsl:variable>
									<!-- query NDS -->
									<xsl:variable name="result" select="query:query($srcQueryProcessor,$query)"/>
									<!-- copy the instance into the output -->
									<xsl:copy-of select="$result//instance"/>
								</xsl:otherwise>
							</xsl:choose>
						</xsl:template>
					</xsl:stylesheet>
				</stylesheet>
			</children>
		</subscriber>
		<stylesheet checksum="1646091193" name="NOVLDTXTBASE-ots" package-id="RISDO559_201006151053480765" pkg-assoc-id="IPGT5IQI_201006151205300468">
			<xsl:stylesheet exclude-result-prefixes="ext" version="1.0" xmlns:cmd="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.driver.XdsCommandProcessor" xmlns:ext="http://exslt.org/common" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
				<xsl:param name="srcCommandProcessor"/>
				<!-- each application must fill in the name of the field that provides the association key -->
				<xsl:variable name="association-field-name" select="'~driver.association.attribute~'"/>
				<xsl:variable name="field-list" select="'~driver.field-names~'"/>
				<xsl:variable name="DELIMITER" select="'~driver.field.delimiter~'"/>
				<xsl:variable name="t" select="&apos;&#x9;&apos;"/>
				<xsl:variable name="traceEncryptData" select="'~driver.traceData~'"/>
				<xsl:variable name="lwdelimiter" select="translate($DELIMITER,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"/>
				<xsl:variable name="delimiter">
					<xsl:choose>
						<xsl:when test="$lwdelimiter='{tab}'">
							<xsl:value-of select="$t"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$DELIMITER"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:variable>
				<xsl:variable name="SplitWordsList">
					<xsl:call-template name="split">
						<xsl:with-param name="nText" select="$field-list"/>
					</xsl:call-template>
				</xsl:variable>
				<xsl:variable name="vSplitWords" select="ext:node-set($SplitWordsList)/*"/>
				<xsl:template match="nds[input]">
					<!-- only look at <add> events and <instances> apply a template for each add transaction-->
					<xsl:apply-templates select="//add|//instance|//query"/>
				</xsl:template>
				<xsl:template match="nds[output]">
					<xsl:copy-of select="."/>
				</xsl:template>
				<!-- now here's the template -->
				<xsl:template match="input/add|input/instance">
					<xsl:choose>
						<xsl:when test="//@is-sensitive and starts-with($traceEncryptData,'yes')">
							<input is-sensitive="true">
								<xsl:call-template name="dummy"/>
							</input>
						</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="dummy"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:template>
				<xsl:template name="dummy">
					<!-- create association if needed and we have enough info -->
					<xsl:variable name="hasAssociation" select="string(association) != ''"/>
					<xsl:variable name="associationValue" select="*[(@attr-name = $association-field-name)][1]/value[1]/text()"/>
					<xsl:if test="not($hasAssociation) and $associationValue">
						<xsl:variable name="dummy">
							<add-association dest-dn="{@src-dn}" dest-entry-id="{@src-entry-id}">
								<xsl:value-of select="$associationValue"/>
							</add-association>
						</xsl:variable>
						<xsl:variable name="dummy2" select="cmd:execute($srcCommandProcessor, $dummy)"/>
					</xsl:if>
					<xsl:apply-templates select="$vSplitWords">
						<xsl:with-param name="input" select="."/>
					</xsl:apply-templates>
					<!-- finish the record with a newline -->
					<!-- uncomment next line to have DOS style end of line (0D0A), otherwise just 0A -->
					<!-- <xsl:value-of select="'&#x0D;'"/> -->
					<xsl:value-of select="&apos;&#xa;&apos;"/>
				</xsl:template>
				<!-- Below splits the field-names contained in field-list -->
				<xsl:template name="split">
					<xsl:param name="nText"/>
					<xsl:param name="nElemName" select="'word'"/>
					<xsl:variable name="first" select="substring-before(concat($nText,','),',')"/>
					<xsl:variable name="remaining" select="substring-after($nText,',')"/>
					<xsl:element name="{$nElemName}">
						<xsl:value-of select="$first"/>
					</xsl:element>
					<xsl:choose>
						<xsl:when test="$remaining">
							<xsl:call-template name="split">
								<xsl:with-param name="nText" select="$remaining"/>
								<xsl:with-param name="nElemName" select="$nElemName"/>
							</xsl:call-template>
						</xsl:when>
					</xsl:choose>
				</xsl:template>
				<xsl:template match="word">
					<xsl:param name="input"/>
					<xsl:if test="position() > 1">
						<xsl:value-of select="$delimiter"/>
					</xsl:if>
					<xsl:choose>
						<xsl:when test="$input/*[(@attr-name = current())]/value/@type='structured'">
							<xsl:call-template name="output-field">
								<xsl:with-param name="field-value" select="$input/*[(@attr-name = current())]/value/component[1]/text()"/>
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="output-field">
								<xsl:with-param name="field-value" select="$input/*[(@attr-name = current())]/value"/>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:template>
				<xsl:template name="output-field">
					<xsl:param name="field-value"/>
					<xsl:choose>
						<xsl:when test="count($field-value)>1">
							<xsl:for-each select="$field-value">
								<xsl:value-of select="."/>
								<xsl:if test="position() != last()">|</xsl:if>
							</xsl:for-each>
						</xsl:when>
						<xsl:when test="contains($field-value[1], $DELIMITER)">
							<!-- if the field value contains a delimiter, then enclose in quotes -->
							<xsl:text>"</xsl:text>
							<xsl:value-of select="$field-value"/>
							<xsl:text>"</xsl:text>
						</xsl:when>
						<xsl:otherwise>
							<!-- otherwise output it raw -->
							<xsl:value-of select="$field-value"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:template>
				<xsl:template match="@*|node()">
					<xsl:copy>
						<xsl:apply-templates select="@*|node()"/>
					</xsl:copy>
				</xsl:template>
			</xsl:stylesheet>
		</stylesheet>
		<stylesheet checksum="2899252433" name="NOVLDTXTBASE-its" package-id="RISDO559_201006151053480765" pkg-assoc-id="DOMS694Q_201006151206020343">
			<xsl:stylesheet extension-element-prefixes="nxsl" version="1.0" xmlns:nxsl="http://www.novell.com/nxsl" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
				<xsl:variable name="association-field-name" select="'~driver.association.attribute~'"/>
				<xsl:template match="/">
					<xsl:choose>
						<!-- if document element is delimited-text, then we need to do the transformation -->
						<xsl:when test="delimited-text">
							<nds dtdversion="1.1" ndsversion="8.6" xml:space="default">
								<input>
									<!-- for each record, do an add -->
									<xsl:for-each select="delimited-text/record">
										<!-- see NDSDTD doc on web for Add verb syntax & details -->
										<xsl:variable name="srcdn" select="translate(field[@name=$association-field-name],'+=,.\','-----')"/>
										<!-- generate the add event -->
										<add class-name="User" src-dn="{$srcdn}">
											<!-- generate the association -->
											<association>
												<xsl:value-of select="field[@name=$association-field-name]"/>
											</association>
											<!-- handle each field -->
											<xsl:for-each select="field[string()]">
												<xsl:variable name="attrName" select="@name"/>
												<!-- do not translate fields without a 'name' attribute -->
												<xsl:if test="string-length($attrName)>0">
													<xsl:variable name="fieldValue" select="normalize-space(.)"/>
													<!-- only add field value if longer than 1 character -->
													<xsl:if test="string-length($fieldValue)>0 and @name != ''">
														<!-- generate the add-attr -->
														<add-attr attr-name="{@name}">
															<!-- generate the value element using string syntax -->
															<!-- note that attributes that require a structured or octet syntax -->
															<!-- may require special handling here -->
															<value type="string">
																<xsl:value-of select="$fieldValue"/>
															</value>
														</add-attr>
													</xsl:if>
												</xsl:if>
											</xsl:for-each>
										</add>
									</xsl:for-each>
								</input>
							</nds>
						</xsl:when>
						<xsl:otherwise>
							<!-- if the document element is not <delimited-text> copy as is-->
							<xsl:copy-of select="."/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:template>
			</xsl:stylesheet>
		</stylesheet>
		<rule checksum="102380514" name="NOVLDTXTBASE-smp" package-id="RISDO559_201006151053480765" pkg-assoc-id="5TADED7P_201306141739380843">
			<attr-name-map>
				<class-name>
					<nds-name>User</nds-name>
					<app-name>User</app-name>
				</class-name>
				<attr-name class-name="User">
					<nds-name>Description</nds-name>
					<app-name>Description</app-name>
				</attr-name>
				<attr-name class-name="User">
					<nds-name>Facsimile Telephone Number</nds-name>
					<app-name>Fax</app-name>
				</attr-name>
				<attr-name class-name="User">
					<nds-name>Given Name</nds-name>
					<app-name>FirstName</app-name>
				</attr-name>
				<attr-name class-name="User">
					<nds-name>Internet EMail Address</nds-name>
					<app-name>Email</app-name>
				</attr-name>
				<attr-name class-name="User">
					<nds-name>mobile</nds-name>
					<app-name>WirelessPhone</app-name>
				</attr-name>
				<attr-name class-name="User">
					<nds-name>Surname</nds-name>
					<app-name>LastName</app-name>
				</attr-name>
				<attr-name class-name="User">
					<nds-name>Telephone Number</nds-name>
					<app-name>WorkPhone</app-name>
				</attr-name>
				<attr-name class-name="User">
					<nds-name>Title</nds-name>
					<app-name>Title</app-name>
				</attr-name>
				<attr-name class-name="User">
					<nds-name>workforceID</nds-name>
					<app-name>WorkforceID</app-name>
				</attr-name>
			</attr-name-map>
		</rule>
		<global-config-def checksum="47094924" name="NOVLDTXTBASE-GCVs" package-id="RISDO559_201006151053480765" pkg-assoc-id="2ISPXUXI_201211161505500546">
			<attributes>
				<global-config-values>
					<configuration-values>
						<definitions display-name="Configuration">
							<header display-name="Driver parameter"/>
							<definition display-name="Field Delimiter:" name="driver.field.delimiter" type="string">
								<description/>
								<value>,</value>
							</definition>
							<definition display-name="Field Names (field1,field2,field3...):" name="driver.field-names" type="string">
								<description/>
								<value>WorkforceID,LastName,FirstName,Title,Email,WorkPhone,Fax,WirelessPhone,Description</value>
							</definition>
							<definition display-name="Association Attibute:" name="driver.association.attribute" type="string">
								<description>The attribute value to be used as an association.</description>
								<value>Email</value>
							</definition>
							<definition critical-change="true" display-name="Suppress Encrypted Attribute in Trace" name="driver.traceData" type="enum">
								<description>By Default Delimiter Text Driver Suppress the content, Set "No" to view the content in Trace.</description>
								<enum-choice display-name="Yes">yes</enum-choice>
								<enum-choice display-name="No">no</enum-choice>
								<value>yes</value>
							</definition>
						</definitions>
					</configuration-values>
				</global-config-values>
			</attributes>
		</global-config-def>
	</children>
	<global-config-values/>
</driver-configuration>
```