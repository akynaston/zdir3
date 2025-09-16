```

<rule>
	<description>TEMPORARY DELETE ME</description>
	<conditions/>
	<actions>
		<do-set-local-variable name="showvar1" scope="policy">
			<arg-string>
				<token-named-password name="broker0.connection.Password"/>
			</arg-string>
		</do-set-local-variable>
		<do-set-src-attr-value class-name="showvar1" name="showvar2">
			<arg-value type="string">
				<token-local-variable name="showvar1"/>
			</arg-value>
		</do-set-src-attr-value>
		<do-veto/>
	</actions>
</rule>

```