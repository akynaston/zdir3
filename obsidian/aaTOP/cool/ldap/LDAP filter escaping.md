5/22/2025 10:19:58 AM
at least \5c needs to be escaped:

(&
    (groupMembership=cn=Pilots_D,ou=Groups,o=SWA-ID)
    (!(DirXML-EntitlementRef=cn=SWA AvioBook Role,cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=SWA-ID#1#<ref><src>RBE</src><id>SWA-ID\5cServices\5cDirXML\5cDriver Set AEv1\5cEntitlement Policies\5cAvioBook-Flight-avio_pilot</id><param>avio_pilot</param></ref>))
)

From RFC4515
```

 The <valueencoding> rule ensures that the entire filter string is a
   valid UTF-8 string and provides that the octets that represent the
   ASCII characters "*" (ASCII 0x2a), "(" (ASCII 0x28), ")" (ASCII
   0x29), "\" (ASCII 0x5c), and NUL (ASCII 0x00) are represented as a
   backslash "\" (ASCII 0x5c) followed by the two hexadecimal digits
   representing the value of the encoded octet.
```