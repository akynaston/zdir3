# Untitled Note

ACL notes

2#entry#\[Public\]#messageServer
2#entry#\[Root\]#groupMembership
2#entry#\[Root\]#networkAddress
2#subtree#\[Self\]#\[All Attributes Rights\]

Available auto-replacement keys for ACLS when submitting acls with ldif . .
\[Self\] - resolves to the same objects' full dn
\[Creator\] - resolves to creatorsName value

Special keys: not autoreplacement, but useful & meaningful:
\[Public\] - any DN, authenticated or anonymous
\[All Attributes Rights\] - Marker that refers to all attributes (third field)
\[Entry\] - Marker that refers to the entry itself. (third field)
