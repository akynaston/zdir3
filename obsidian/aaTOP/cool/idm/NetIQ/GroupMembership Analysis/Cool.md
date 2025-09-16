6/5/2025 11:36:49 AM
This is a cool way we can ignore membership changes in a driver. Currently in IDtoDocunet, and I had another version in the RBEAEv1 driver.

```
<rule>
                            <description>Drop the group membership change: we're only interested in a single group change.</description>
                            <comment xml:space="preserve">group change events can be dumped now if it isn't a CheckAirMen group.</comment>
                            <conditions>
                                <and>
                                    <if-op-attr name="Group Membership" op="changing"/>
                                </and>
                            </conditions>
                            <actions>
                                <do-if>
                                    <arg-conditions>
                                        <and>
                                            <if-op-attr mode="regex" name="Group Membership" op="not-equal">^.+\\~gcv.CheckAirMenGrpCN~$</if-op-attr>
                                            <if-op-attr mode="regex" name="Group Membership" op="not-changing-from">^.+\\~gcv.CheckAirMenGrpCN~$</if-op-attr>
                                        </and>
                                    </arg-conditions>
                                    <arg-actions>
                                        <do-strip-op-attr name="Group Membership"/>
                                    </arg-actions>
                                    <arg-actions/>
                                </do-if>
                            </actions>
                        </rule>
```