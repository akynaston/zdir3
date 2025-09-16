2/6/2024 3:09:42 PM

Gave to Nirosnha for Akami . .
[3:08 PM] Nirosha Lakku (Contractor)
```
<rule>
		<description>Veto the modify if it is now empty.</description>
		<comment xml:space="preserve">If the modify event is now empty, lets stop it now.  This would happen in cases where only group membership is changing.</comment>
		<conditions>
			<and>
				<if-operation mode="nocase" op="equal">modify</if-operation>
				<if-xpath op="not-true">modify-attr</if-xpath>
			</and>
		</conditions>
		<actions>
			<do-veto/>
		</actions>
	</rule>
```