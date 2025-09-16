# How to identify a match from merge scenario

![[./_resources/How_to_identify_a_match_from_merge_scenario.resources/ScreenClip.png]]

                    <conditions>
                        <and>
                            <if-operation mode="case" op="equal">modify</if-operation>
                            <if-xpath op="true">@from-merge="true"</if-xpath>
                        </and>
                    </conditions>

![[./_resources/How_to_identify_a_match_from_merge_scenario.resources/sub-ctp-UserMatchAttrSet.xml]]
