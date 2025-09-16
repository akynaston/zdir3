```

<?xml version="1.0" encoding="UTF-8"?><policy>
	<rule>
		<description>Strip Empty Elements.</description>
		<comment xml:space="preserve">Strips empty elements from instance, add, modify documents.</comment>
		<comment name="author" xml:space="preserve">Lothar Haeger (Added by Aaron Kynaston)</comment>
		<comment name="version" xml:space="preserve">1.0</comment>
		<comment name="lastchanged" xml:space="preserve">2023-05-01</comment>
		<conditions/>
		<actions>
			<do-strip-xpath expression="self::instance/attr/value[not(*)][not(text()) or text()='']"/>
			<do-strip-xpath expression="self::instance/attr[not(*)]"/>
			<do-strip-xpath expression="self::add/add-attr/value[not(*)][not(text()) or text()='']"/>
			<do-strip-xpath expression="self::add/add-attr[not(*)]"/>
			<do-strip-xpath expression="self::modify/modify-attr/remove-value/value[not(*)][not(text()) or text()='']"/>
			<do-strip-xpath expression="self::modify/modify-attr/remove-value[not(*)]"/>
			<do-strip-xpath expression="self::modify/modify-attr/add-value/value[not(*)][not(text()) or text()='']"/>
			<do-strip-xpath expression="self::modify/modify-attr/add-value[not(*)]"/>
			<do-strip-xpath expression="self::modify/modify-attr[not(*)]"/>
		</actions>
	</rule>
	<rule>
		<description>Veto empty modify operations</description>
		<comment xml:space="preserve">If we get this far, it means a modify has been completely removed of empty values.</comment>
		<comment name="author" xml:space="preserve">Aaron Kynaston</comment>
		<comment name="version" xml:space="preserve">1.0</comment>
		<comment name="lastchanged" xml:space="preserve">2023-05-01</comment>
		<conditions>
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
	<rule>
		<description>Veto empty add operations</description>
		<comment xml:space="preserve">If we get this far, it means the add has been completely removed of empty values.</comment>
		<comment name="author" xml:space="preserve">Aaron Kynaston</comment>
		<comment name="version" xml:space="preserve">1.0</comment>
		<comment name="lastchanged" xml:space="preserve">2023-05-01</comment>
		<conditions>
			<and>
				<if-operation mode="nocase" op="equal">add</if-operation>
				<if-xpath op="not-true">add-attr</if-xpath>
			</and>
		</conditions>
		<actions>
			<!-- Veto empty modify -->
			<do-veto/>
		</actions>
	</rule>
</policy>

```
<?xml version="1.0" encoding="UTF-8"?><policy>
	<rule>
		<description>Strip Empty Elements.</description>
		<comment xml:space="preserve">Strips empty elements from instance, add, modify documents.</comment>
		<comment name="author" xml:space="preserve">Lothar Haeger (Added by Aaron Kynaston)</comment>
		<comment name="version" xml:space="preserve">1.0</comment>
		<comment name="lastchanged" xml:space="preserve">2023-05-01</comment>
		<conditions/>
		<actions>
			<do-strip-xpath expression="self::instance/attr/value[not(*)][not(text()) or text()='']"/>
			<do-strip-xpath expression="self::instance/attr[not(*)]"/>
			<do-strip-xpath expression="self::add/add-attr/value[not(*)][not(text()) or text()='']"/>
			<do-strip-xpath expression="self::add/add-attr[not(*)]"/>
			<do-strip-xpath expression="self::modify/modify-attr/remove-value/value[not(*)][not(text()) or text()='']"/>
			<do-strip-xpath expression="self::modify/modify-attr/remove-value[not(*)]"/>
			<do-strip-xpath expression="self::modify/modify-attr/add-value/value[not(*)][not(text()) or text()='']"/>
			<do-strip-xpath expression="self::modify/modify-attr/add-value[not(*)]"/>
			<do-strip-xpath expression="self::modify/modify-attr[not(*)]"/>
		</actions>
	</rule>
	<rule>
		<description>Veto empty modify operations</description>
		<comment xml:space="preserve">If we get this far, it means a modify has been completely removed of empty values.</comment>
		<comment name="author" xml:space="preserve">Aaron Kynaston</comment>
		<comment name="version" xml:space="preserve">1.0</comment>
		<comment name="lastchanged" xml:space="preserve">2023-05-01</comment>
		<conditions>
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
	<rule>
		<description>Veto empty add operations</description>
		<comment xml:space="preserve">If we get this far, it means the add has been completely removed of empty values.</comment>
		<comment name="author" xml:space="preserve">Aaron Kynaston</comment>
		<comment name="version" xml:space="preserve">1.0</comment>
		<comment name="lastchanged" xml:space="preserve">2023-05-01</comment>
		<conditions>
			<and>
				<if-operation mode="nocase" op="equal">add</if-operation>
				<if-xpath op="not-true">add-attr</if-xpath>
			</and>
		</conditions>
		<actions>
			<!-- Veto empty modify -->
			<do-veto/>
		</actions>
	</rule>
</policy>


<?xml version="1.0" encoding="UTF-8"?><nds dtdversion="4.0" ndsversion="8.x">
	<source>
		<product version="4.8.6.0000">DirXML</product>
		<contact>NetIQ Corporation</contact>
	</source>
	<input>
		<add class-name="empty"/>
		<modify class-name="empty"/>
		<add class-name="user">
			<add-attr attr-name="bob">
				<value>heres a value1</value>
			</add-attr>
			<add-attr attr-name="bob">
				<value>heres a value2</value>
			</add-attr>
			<add-attr attr-name="bobmissing">
				<value/>
			</add-attr>
			<add-attr attr-name="bob">
				<value>heres a value3</value>
			</add-attr>
			<add-attr attr-name="bob">
				<value>heres a value4</value>
			</add-attr>
		</add>
		<add class-name="addeventuallyempty">
			<add-attr attr-name="bob">
				<value/>
			</add-attr>
		</add>
		<modify class-name="modifyeventuallyempty">
			<modify-attr attr-name="hasmissingremovevalue1">
				<remove-value>
					<value/>
				</remove-value>
				<add-value>
					<value/>
				</add-value>
			</modify-attr>
		</modify>
		<modify class-name="user">
			<modify-attr attr-name="hasmissingremovevalue1">
				<remove-value>
					<value/>
				</remove-value>
				<add-value>
					<value>value here to add</value>
				</add-value>
			</modify-attr>
			<modify-attr attr-name="hasmissingaddvalue2">
				<remove-value>
					<value>removevalue</value>
				</remove-value>
				<add-value>
					<value/>
				</add-value>
			</modify-attr>
			<modify-attr attr-name="anattr3">
				<remove-value>
					<value>avalue to remove</value>
				</remove-value>
				<add-value>
					<value>value here to add</value>
				</add-value>
			</modify-attr>
			<modify-attr attr-name="shouldnotseeme4">
				<remove-value>
					<value/>
				</remove-value>
				<add-value>
					<value/>
				</add-value>
			</modify-attr>
		</modify>
		<instance class-name="instanceempty">
			<attr>
				<value/>
			</attr>
		</instance>
		<instance class-name="instancegood">
			<attr>
				<value>beep</value>
			</attr>
		</instance>
	</input>
</nds>