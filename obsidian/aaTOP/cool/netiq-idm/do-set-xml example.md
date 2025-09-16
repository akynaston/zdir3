```
<!-- Add add-attr element for nspmDistributionPassword attribute -->
<do-add-dest-attr-value name="nspmDistributionPassword">
    <arg-value>
        <token-password/>
    </arg-value>
</do-add-dest-attr-value>
<!-- Add a validate-password attribute to previous add-attr element -->
<do-set-xml-attr expression="add-attr[@attr-name = 'nspmDistributionPassword'][last()]" name="enforce-password-policy">
    <arg-string>
        <token-global-variable name="enforce-password-policy"/>
    </arg-string>
</do-set-xml-attr>

```