4/4/2025 11:29:57 AM
This is the search ADS does when reading the schema!
```
#!SEARCH REQUEST (126) OK
#!CONNECTION ldap://w11dcledirdi019.swacorp.com:1636
#!DATE 2025-04-04T17:28:43.094
# LDAP URL     : ldaps://w11dcledirdi019.swacorp.com:1636/cn=schema?objectClasses,attributeTypes,ldapSyntaxes,matchingRules,matchingRuleUse,createTimestamp,modifyTimestamp??(objectClass=subschema)
# command line : ldapsearch -H ldaps://w11dcledirdi019.swacorp.com:1636 -x -D "CN=ax266698,ou=admins,o=swaiddev" -W -b "cn=schema" -s base -a always "(objectClass=subschema)" "objectClasses" "attributeTypes" "ldapSyntaxes" "matchingRules" "matchingRuleUse" "createTimestamp" "modifyTimestamp"
# baseObject   : cn=schema
# scope        : baseObject (0)
# derefAliases : derefAlways (3)
# sizeLimit    : 0
# timeLimit    : 0
# typesOnly    : False
# filter       : (objectClass=subschema)
# attributes   : objectClasses attributeTypes ldapSyntaxes matchingRules matchingRuleUse createTimestamp modifyTimestamp

```