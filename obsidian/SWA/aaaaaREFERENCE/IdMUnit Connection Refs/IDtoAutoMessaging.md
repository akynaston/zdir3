```
			<connection> <!-- IDtoAutoMessaging_Update -->
				<name>IDtoAutoMessaging_Update</name>
				<description>Connector to output of DTF driver</description>
				<server>w11dcledirdi014.swacorp.com</server>
				<use-tls>true</use-tls>
				<trust-all-certs>true</trust-all-certs>
				<port>22</port>
				<user>x266698</user>
				<password>[PASSWORD HERE]</password>
				<type>com.trivir.idmunit.connector.SWADTFConnector</type>
				<read-path>/opt/IDMFeeds/IDtoAutoMessaging/output/update</read-path>
				<write-path>/opt/IDMFeeds/IDtoAutoMessaging/output/update</write-path>
				<delimiter>,</delimiter>
				<row-key>cn</row-key>
				<validate-last-row-only>true</validate-last-row-only>
				<output-file-ext>.csv</output-file-ext>
				<field-definitions>First Name,Last Name,cn,Record Type,SSO User ID,Location 1,Street Address 1,City 1,Postal Code 1,Phone 1,Phone 2,Phone 3,Phone 4,Email Address 1,SMS 1,Custom Field 1,Custom Value 1,Custom Field 2,Custom Value 2,Custom Field 3,Custom Value 3,Custom Field 4,Custom Value 4,Custom Field 5,Custom Value 5,Custom Field 6,Custom Value 6,Custom Field 7,Custom Value 7,Custom Field 8,Custom Value 8,Custom Field 9,Custom Value 9,Custom Field 10,Custom Value 10,Custom Field 11,Custom Value 11,Groups,Group Remove,END</field-definitions>
				<multiplier/> <!-- As needed-->
				<substitutions/>  <!-- As needed-->
				<data-injections/>  <!-- As needed-->
			</connection>
			<connection> <!-- IDtoAutoMessaging_Remove -->
				<name>IDtoAutoMessaging_Remove</name>
				<description>Connector to output of DTF driver</description>
				<server>w11dcledirdi014.swacorp.com</server>
				<port>22</port>
				<use-tls>true</use-tls>
				<trust-all-certs>true</trust-all-certs>
				<user>x266698</user>
				<password>[PASSWORD HERE]</password>
				<type>com.trivir.idmunit.connector.SWADTFConnector</type>
				<read-path>/opt/IDMFeeds/IDtoAutoMessaging/output/remove</read-path>
				<write-path>/opt/IDMFeeds/IDtoAutoMessaging/output/remove</write-path>
				<delimiter>,</delimiter>
				<row-key>cn</row-key>
				<validate-last-row-only>true</validate-last-row-only>
				<output-file-ext>.csv</output-file-ext>
				<field-definitions>First Name,Last Name,cn,Record Type,END</field-definitions>
				<multiplier/> <!-- As needed-->
				<substitutions/>  <!-- As needed-->
				<data-injections/>  <!-- As needed-->
			</connection>

QA
			<connection> <!-- IDtoAutoMessaging_Update -->
				<name>IDtoAutoMessaging_Update</name>
				<description>Connector to output of DTF driver</description>
				<server>w11qcledirqi011.swacorp.com</server>
				<use-tls>true</use-tls>
				<trust-all-certs>true</trust-all-certs>
				<port>22</port>
				<user>x266698</user>
				<password>[PASSWORD HERE]</password>
				<type>com.trivir.idmunit.connector.SWADTFConnector</type>
				<read-path>/opt/IDMFeeds/IDtoAutoMessaging/output/update</read-path>
				<write-path>/opt/IDMFeeds/IDtoAutoMessaging/output/update</write-path>
				<delimiter>,</delimiter>
				<row-key>cn</row-key>
				<validate-last-row-only>true</validate-last-row-only>
				<output-file-ext>.csv</output-file-ext>
				<field-definitions>First Name,Last Name,cn,Record Type,SSO User ID,Location 1,Street Address 1,City 1,Postal Code 1,Phone 1,Phone 2,Phone 3,Phone 4,Email Address 1,SMS 1,Custom Field 1,Custom Value 1,Custom Field 2,Custom Value 2,Custom Field 3,Custom Value 3,Custom Field 4,Custom Value 4,Custom Field 5,Custom Value 5,Custom Field 6,Custom Value 6,Custom Field 7,Custom Value 7,Custom Field 8,Custom Value 8,Custom Field 9,Custom Value 9,Custom Field 10,Custom Value 10,Custom Field 11,Custom Value 11,Groups,Group Remove,END</field-definitions>
				<multiplier/> <!-- As needed-->
				<substitutions/>  <!-- As needed-->
				<data-injections/>  <!-- As needed-->
			</connection>
			<connection> <!-- IDtoAutoMessaging_Remove -->
				<name>IDtoAutoMessaging_Remove</name>
				<description>Connector to output of DTF driver</description>
				<server>w11qcledirqi011.swacorp.com</server>
				<port>22</port>
				<use-tls>true</use-tls>
				<trust-all-certs>true</trust-all-certs>
				<user>x266698</user>
				<password>[PASSWORD HERE]</password>
				<type>com.trivir.idmunit.connector.SWADTFConnector</type>
				<read-path>/opt/IDMFeeds/IDtoAutoMessaging/output/remove</read-path>
				<write-path>/opt/IDMFeeds/IDtoAutoMessaging/output/remove</write-path>
				<delimiter>,</delimiter>
				<row-key>cn</row-key>
				<validate-last-row-only>true</validate-last-row-only>
				<output-file-ext>.csv</output-file-ext>
				<field-definitions>First Name,Last Name,cn,Record Type,END</field-definitions>
				<multiplier/> <!-- As needed-->
				<substitutions/>  <!-- As needed-->
				<data-injections/>  <!-- As needed-->
			</connection>


```