
Store eDirectory value in variable:

<do-set-local-variable name="euidCounterObjectAsXMLAttr" scope="driver">
    <arg-string>
        <token-text xml:space="preserve">vnd.nds.stream:/</token-text>
        <token-replace-all regex="\\" replace-with="/">
            <token-local-variable name="euidCounterDN"/>
        </token-replace-all>
        <token-text xml:space="preserve">#DirXML-Data</token-text>
    </arg-string>
</do-set-local-variable>


						