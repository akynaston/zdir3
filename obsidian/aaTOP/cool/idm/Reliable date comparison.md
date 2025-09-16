9/5/2024 2:56:41 PM
Don't compare dates with if-local-varaible; only use xpath!

```
<rule>
	<description>TEMP DATE TEST</description>
	<comment xml:space="preserve">This policy applies only to User class objects.</comment>
	<conditions>
		<and/>
	</conditions>
	<actions>
		<do-set-local-variable name="lv-StartDate" scope="policy">
			<arg-string>
				<token-convert-time dest-format="!CTIME" dest-tz="UTC" src-format="yyyy-MM-dd">
					<token-text xml:space="preserve">1993-04-04</token-text>
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
				<and>
					<if-local-variable mode="nocase" name="lv-StartDate" op="gt">$lv-now$</if-local-variable>
				</and>
			</arg-conditions>
			<arg-actions>
				<do-trace-message>
					<arg-string>
						<token-text xml:space="preserve">this failed should not be true.</token-text>
					</arg-string>
				</do-trace-message>
			</arg-actions>
			<arg-actions>
				<do-trace-message>
					<arg-string>
						<token-text xml:space="preserve">this succeeded, sartdate is less than now</token-text>
					</arg-string>
				</do-trace-message>
			</arg-actions>
		</do-if>
		<do-if>
			<arg-conditions>
				<and>
					<if-local-variable mode="nocase" name="lv-StartDate" op="lt">$lv-now$</if-local-variable>
				</and>
			</arg-conditions>
			<arg-actions>
				<do-trace-message>
					<arg-string>
						<token-text xml:space="preserve">this succeeded, sartdate is less than now.</token-text>
					</arg-string>
				</do-trace-message>
			</arg-actions>
			<arg-actions>
				<do-trace-message>
					<arg-string>
						<token-text xml:space="preserve">this failed should not be true</token-text>
					</arg-string>
				</do-trace-message>
			</arg-actions>
		</do-if>
		<do-if>
			<arg-conditions>
				<and>
					<if-xpath op="true">$lv-StartDate > $lv-now</if-xpath>
				</and>
			</arg-conditions>
			<arg-actions>
				<do-trace-message>
					<arg-string>
						<token-text xml:space="preserve">this failed should not be true.</token-text>
					</arg-string>
				</do-trace-message>
			</arg-actions>
			<arg-actions>
				<do-trace-message>
					<arg-string>
						<token-text xml:space="preserve">this succeeded, sartdate is less than now</token-text>
					</arg-string>
				</do-trace-message>
			</arg-actions>
		</do-if>
		<do-if>
			<arg-conditions>
				<and>
					<if-xpath op="true">$lv-StartDate &lt; $lv-now</if-xpath>
				</and>
			</arg-conditions>
			<arg-actions>
				<do-trace-message>
					<arg-string>
						<token-text xml:space="preserve">this succeeded, sartdate is less than now.</token-text>
					</arg-string>
				</do-trace-message>
			</arg-actions>
			<arg-actions>
				<do-trace-message>
					<arg-string>
						<token-text xml:space="preserve">this failed should not be true</token-text>
					</arg-string>
				</do-trace-message>
			</arg-actions>
		</do-if>
		<do-veto/>
	</actions>
</rule>
```


```
SuccessFactors-Driver :Applying policy: %+C%14Cpub-mp%-C.
SuccessFactors-Driver :  Applying to add #1.
SuccessFactors-Driver :    Evaluating selection criteria for rule 'TEMP DATE TEST'.
SuccessFactors-Driver :    Rule selected.
SuccessFactors-Driver :    Applying rule 'TEMP DATE TEST'.
SuccessFactors-Driver :      Action: do-set-local-variable("lv-StartDate",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd","1993-04-04")).
SuccessFactors-Driver :        arg-string(token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd","1993-04-04"))
SuccessFactors-Driver :          token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd","1993-04-04")
SuccessFactors-Driver :            token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd","1993-04-04")
SuccessFactors-Driver :              token-text("1993-04-04")
SuccessFactors-Driver :              Arg Value: "1993-04-04".
SuccessFactors-Driver :            Token Value: "733906800".
SuccessFactors-Driver :          Arg Value: "733906800".
SuccessFactors-Driver :      Action: do-set-local-variable("lv-now",scope="policy",token-convert-time(dest-format="!CTIME",src-format="yyyy-MM-dd",token-time(format="yyyy-MM-dd"))).
SuccessFactors-Driver :        arg-string(token-convert-time(dest-format="!CTIME",src-format="yyyy-MM-dd",token-time(format="yyyy-MM-dd")))
SuccessFactors-Driver :          token-convert-time(dest-format="!CTIME",src-format="yyyy-MM-dd",token-time(format="yyyy-MM-dd"))
SuccessFactors-Driver :            token-convert-time(dest-format="!CTIME",src-format="yyyy-MM-dd",token-time(format="yyyy-MM-dd"))
SuccessFactors-Driver :              token-time(format="yyyy-MM-dd")
SuccessFactors-Driver :                Token Value: "2024-09-05".
SuccessFactors-Driver :              Arg Value: "2024-09-05".
SuccessFactors-Driver :            Token Value: "1725494400".
SuccessFactors-Driver :          Arg Value: "1725494400".
SuccessFactors-Driver :      Action: do-if().
SuccessFactors-Driver :        Evaluating conditions.
SuccessFactors-Driver :          Expanded variable reference '$lv-now$' to '1725494400'.
SuccessFactors-Driver :          (if-local-variable 'lv-StartDate' gt "$lv-now$") = TRUE.
SuccessFactors-Driver :        Performing if actions.
SuccessFactors-Driver :          Action: do-trace-message("this failed should not be true.").
SuccessFactors-Driver :            arg-string("this failed should not be true.")
SuccessFactors-Driver :              token-text("this failed should not be true.")
SuccessFactors-Driver :              Arg Value: "this failed should not be true.".
SuccessFactors-Driver :this failed should not be true.
SuccessFactors-Driver :      Action: do-if().
SuccessFactors-Driver :        Evaluating conditions.
SuccessFactors-Driver :          Expanded variable reference '$lv-now$' to '1725494400'.
SuccessFactors-Driver :          (if-local-variable 'lv-StartDate' lt "$lv-now$") = FALSE.
SuccessFactors-Driver :        Performing else actions.
SuccessFactors-Driver :          Action: do-trace-message("this failed should not be true").
SuccessFactors-Driver :            arg-string("this failed should not be true")
SuccessFactors-Driver :              token-text("this failed should not be true")
SuccessFactors-Driver :              Arg Value: "this failed should not be true".
SuccessFactors-Driver :this failed should not be true
SuccessFactors-Driver :      Action: do-if().
SuccessFactors-Driver :        Evaluating conditions.
SuccessFactors-Driver :          (if-xpath true "$lv-StartDate > $lv-now") = FALSE.
SuccessFactors-Driver :        Performing else actions.
SuccessFactors-Driver :          Action: do-trace-message("this succeeded, sartdate is less than now").
SuccessFactors-Driver :            arg-string("this succeeded, sartdate is less than now")
SuccessFactors-Driver :              token-text("this succeeded, sartdate is less than now")
SuccessFactors-Driver :              Arg Value: "this succeeded, sartdate is less than now".
SuccessFactors-Driver :this succeeded, sartdate is less than now
SuccessFactors-Driver :      Action: do-if().
SuccessFactors-Driver :        Evaluating conditions.
SuccessFactors-Driver :          (if-xpath true "$lv-StartDate < $lv-now") = TRUE.
SuccessFactors-Driver :        Performing if actions.
SuccessFactors-Driver :          Action: do-trace-message("this succeeded, sartdate is less than now.").
SuccessFactors-Driver :            arg-string("this succeeded, sartdate is less than now.")
SuccessFactors-Driver :              token-text("this succeeded, sartdate is less than now.")
SuccessFactors-Driver :              Arg Value: "this succeeded, sartdate is less than now.".
SuccessFactors-Driver :this succeeded, sartdate is less than now.
SuccessFactors-Driver :      Action: do-veto().
SuccessFactors-Driver :Policy returned:
SuccessFactors-Driver :
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product version="4.8.7.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input/>
</nds>

```