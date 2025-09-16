3/8/2024 2:55:15 PM
Example on how to load data from a tree into a nodeset in a variable:


```
<do-set-local-variable name="driverFilter" scope="policy">
				<arg-node-set>
					<token-document>
						<arg-string>
							<token-text xml:space="preserve">vnd.nds.stream:/</token-text>
							<token-replace-all regex="\\" replace-with="/">
								<token-global-variable name="dirxml.auto.driverdn"/>
							</token-replace-all>
							<token-text xml:space="preserve">#DirXML-Data</token-text>
						</arg-string>
					</token-document>
				</arg-node-set>
			</do-set-local-variable>
			<do-for-each>
				<arg-node-set>
					<token-local-variable name="driverFilter"/>
				</arg-node-set>
				<arg-actions>
					<do-if>
						<arg-conditions>
							<and>
								<if-op-attr name="$current-node" op="not-available"/>
							</and>
						</arg-conditions>
						<arg-actions>
							<do-set-dest-attr-value name="$current-node">
								<arg-value type="string">
									<token-src-attr name="$current-node"/>
								</arg-value>
							</do-set-dest-attr-value>
						</arg-actions>
					</do-if>
				</arg-actions>
			</do-for-each>

```

Example trace results:

```
[03/12/24 12:14:21.008]:IDtoDocunet ST:    Evaluating selection criteria for rule 'Ensure all attributes are available for all non delete events.'.
[03/12/24 12:14:21.009]:IDtoDocunet ST:      (if-class-name equal "User") = TRUE.
[03/12/24 12:14:21.009]:IDtoDocunet ST:      (if-operation match "add|modify") = TRUE.
[03/12/24 12:14:21.009]:IDtoDocunet ST:    Rule selected.
[03/12/24 12:14:21.009]:IDtoDocunet ST:    Applying rule 'Ensure all attributes are available for all non delete events.'.
[03/12/24 12:14:21.010]:IDtoDocunet ST:      Action: do-set-local-variable("driverFilter",scope="policy",arg-node-set(token-document("vnd.nds.stream:/"+token-replace-all("\\","/",token-global-variable("dirxml.auto.driverdn"))+"#DirXML-DriverFilter"))).
[03/12/24 12:14:21.010]:IDtoDocunet ST:        arg-node-set(token-document("vnd.nds.stream:/"+token-replace-all("\\","/",token-global-variable("dirxml.auto.driverdn"))+"#DirXML-DriverFilter"))
[03/12/24 12:14:21.011]:IDtoDocunet ST:          token-document("vnd.nds.stream:/"+token-replace-all("\\","/",token-global-variable("dirxml.auto.driverdn"))+"#DirXML-DriverFilter")
[03/12/24 12:14:21.011]:IDtoDocunet ST:            arg-string("vnd.nds.stream:/"+token-replace-all("\\","/",token-global-variable("dirxml.auto.driverdn"))+"#DirXML-DriverFilter")
[03/12/24 12:14:21.012]:IDtoDocunet ST:              token-text("vnd.nds.stream:/")
[03/12/24 12:14:21.012]:IDtoDocunet ST:              token-replace-all("\\","/",token-global-variable("dirxml.auto.driverdn"))
[03/12/24 12:14:21.061]:IDtoDocunet ST:                token-replace-all("\\","/",token-global-variable("dirxml.auto.driverdn"))
[03/12/24 12:14:21.061]:IDtoDocunet ST:                  token-global-variable("dirxml.auto.driverdn")
[03/12/24 12:14:21.062]:IDtoDocunet ST:                    Token Value: "\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set v3\IDtoDocunet".
[03/12/24 12:14:21.062]:IDtoDocunet ST:                  Arg Value: "\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set v3\IDtoDocunet".
[03/12/24 12:14:21.062]:IDtoDocunet ST:                Token Value: "/DEV_SWACO_ID/swaiddev/Services/DirXML/Driver Set v3/IDtoDocunet".
[03/12/24 12:14:21.063]:IDtoDocunet ST:              token-text("#DirXML-DriverFilter")
[03/12/24 12:14:21.063]:IDtoDocunet ST:              Arg Value: "vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver Set v3/IDtoDocunet#DirXML-DriverFilter".
[03/12/24 12:14:21.064]:IDtoDocunet ST:          Token Value: {/}.
[03/12/24 12:14:21.064]:IDtoDocunet ST:          Arg Value: {/}.
[03/12/24 12:14:21.064]:IDtoDocunet ST:      Action: do-for-each(arg-node-set(token-xpath("$driverFilter/filter/filter-class[@class-name='User']/filter-attr/@attr-name"))).
[03/12/24 12:14:21.065]:IDtoDocunet ST:        arg-node-set(token-xpath("$driverFilter/filter/filter-class[@class-name='User']/filter-attr/@attr-name"))
[03/12/24 12:14:21.065]:IDtoDocunet ST:          token-xpath("$driverFilter/filter/filter-class[@class-name='User']/filter-attr/@attr-name")
[03/12/24 12:14:21.066]:IDtoDocunet ST:          Token Value: {@attr-name = "CN",@attr-name = "Given Name",@attr-name = "Internet EMail Address",@attr-name = "manager",@attr-name = "preferredName",@attr-name = "Surname",@attr-name = "swaDeptCode",@attr-name = "swaDeptDesc",@attr-name = "swaHireDate",@attr-name = "swaPrimaryWorkLocation",@attr-name = "swaStatus",@attr-name = "swaTerminationDate",@attr-name = "swaTitleCode",@attr-name = "swaTitleDesc"}.
[03/12/24 12:14:21.067]:IDtoDocunet ST:          Arg Value: {@attr-name = "CN",@attr-name = "Given Name",@attr-name = "Internet EMail Address",@attr-name = "manager",@attr-name = "preferredName",@attr-name = "Surname",@attr-name = "swaDeptCode",@attr-name = "swaDeptDesc",@attr-name = "swaHireDate",@attr-name = "swaPrimaryWorkLocation",@attr-name = "swaStatus",@attr-name = "swaTerminationDate",@attr-name = "swaTitleCode",@attr-name = "swaTitleDesc"}.
[03/12/24 12:14:21.068]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "CN".
[03/12/24 12:14:21.068]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.068]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.069]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'CN'.
[03/12/24 12:14:21.069]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.069]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.069]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "Given Name".
[03/12/24 12:14:21.070]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.070]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.070]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'Given Name'.
[03/12/24 12:14:21.070]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.071]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.071]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "Internet EMail Address".
[03/12/24 12:14:21.072]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.072]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.072]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'Internet EMail Address'.
[03/12/24 12:14:21.072]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.073]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.073]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "manager".
[03/12/24 12:14:21.073]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.073]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.074]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'manager'.
[03/12/24 12:14:21.074]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.074]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.074]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "preferredName".
[03/12/24 12:14:21.075]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.075]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.075]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'preferredName'.
[03/12/24 12:14:21.075]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.076]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.076]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "Surname".
[03/12/24 12:14:21.076]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.076]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.076]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'Surname'.
[03/12/24 12:14:21.077]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.077]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.077]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "swaDeptCode".
[03/12/24 12:14:21.078]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.078]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.078]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'swaDeptCode'.
[03/12/24 12:14:21.078]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.079]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.079]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "swaDeptDesc".
[03/12/24 12:14:21.079]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.080]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.080]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'swaDeptDesc'.
[03/12/24 12:14:21.080]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.080]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.081]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "swaHireDate".
[03/12/24 12:14:21.081]:IDtoDocunet ST:          Action: do-if().
[03/12/24 12:14:21.081]:IDtoDocunet ST:            Evaluating conditions.
[03/12/24 12:14:21.081]:IDtoDocunet ST:              Expanded variable reference '$current-node$' to 'swaHireDate'.
[03/12/24 12:14:21.082]:IDtoDocunet ST:              (if-op-attr '$current-node$' not-available) = FALSE.
[03/12/24 12:14:21.082]:IDtoDocunet ST:            Performing else actions.
[03/12/24 12:14:21.082]:IDtoDocunet ST:        Performing actions for local-variable(current-node) = @attr-name = "swaPrimaryWorkLocation".
[03/12/24 12:14:21.083]:IDtoDocunet ST:          Action: do-if().

```