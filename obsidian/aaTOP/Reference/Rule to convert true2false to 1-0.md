```
<rule>

     <description>Transform 'LOCKUSER' values from boolean 'true/false' to '1/0'</description>

     <conditions>

          <and/>

     </conditions>

     <actions>

          <do-set-local-variable name="LockValues">

               <arg-node-set>

                    <token-op-attr name="LOCKUSER"/>

                    <token-removed-attr name="LOCKUSER"/>

               </arg-node-set>

          </do-set-local-variable>

          <do-for-each>

               <arg-node-set>

                    <token-xpath expression="$LockValues/self::value[.='true']"/>

               </arg-node-set>

               <arg-actions>

                    <do-strip-xpath expression="$current-node/text()"/>

                    <do-append-xml-text expression="$current-node">

                         <arg-string>

                              <token-text xml:space="preserve">1</token-text>

                         </arg-string>

                    </do-append-xml-text>

               </arg-actions>

          </do-for-each>

          <do-for-each>

               <arg-node-set>

                    <token-xpath expression="$LockValues/self::value[.='false']"/>

               </arg-node-set>

               <arg-actions>

                    <do-strip-xpath expression="$current-node/text()"/>

                    <do-append-xml-text expression="$current-node">

                         <arg-string>

                              <token-text xml:space="preserve">0</token-text>

                         </arg-string>

                    </do-append-xml-text>

               </arg-actions>

          </do-for-each>

     </actions>

</rule>
```