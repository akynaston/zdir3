
```
<rule>
	<description>Drop empty modifies.</description>
	<comment xml:space="preserve">If the group change above results in an empty modify, veto the event now.</comment>
	<conditions>
		<and>
			<if-operation mode="nocase" op="equal">modify</if-operation>
			<if-xpath op="true">count(modify-attr) = 0</if-xpath>
		</and>
	</conditions>
	<actions>
		<do-veto/>
	</actions>
</rule>
```