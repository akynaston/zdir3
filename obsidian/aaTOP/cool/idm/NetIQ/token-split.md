1/27/2025 10:30:53 AM
 - example how to use split: use arg-node, then 1 based array notation:

```

example split then array:
do-set-local-variable name="var-accountElements" scope="policy">
																<arg-node-set>
																	<token-split delimiter="#">
																		<token-local-variable name="current-node"/>
																	</token-split>
																</arg-node-set>
															</do-set-local-variable>
															<do-set-local-variable name="var-accountElement2" scope="policy">
																<arg-string>
																	<token-xpath expression="$var-accountElements[2]"/>
																</arg-string>
															</do-set-local-variable>
															<do-set-local-variable name="

```