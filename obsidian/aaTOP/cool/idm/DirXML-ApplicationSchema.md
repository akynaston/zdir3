8/20/2025 4:08:02 PM
Today, worked to see if DirXML-Application schema is populated by the import into Designer, and then into the tree:

TEST:
1 - Delete: DirXML-ApplicationSchema attribute from object:    cn=IDtoSprinkler,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev
2 - Import driver into designer an "<application-schema>" element.

See how the application schema DOES NOT even come into Designer:

![[Pasted image 20250820160941.png]]


Then I confirmed that clicking 'refresh application schema in Designer populated the DirXML-ApplicationSchema attribute.'
![[{229D9452-A48F-4BFD-9B20-CBAC0022DF17}.png]]

Interesting finding: After doing that refresh, I exported and diffed, and saw this!

![[{5BBF0806-C0E3-438F-8C13-84B97D5E7DC4}.png]]
