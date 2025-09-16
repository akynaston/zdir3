9/11/2023 11:40:00 AM
dirxml-replacement-Notes.txt

replace this with this, to get the deletions:
o=swa-idsat$
o=swa-idsat\r\nchangetype: modify\r\ndelete: DirXML-Associations


Next, replace this with this to add on #4#, AND REMOVE ASSOCIATION VALUE!
(o=swa-idsat#1#.+\r\n)
($1)-\r\nadd: DirXML-Associations\r\nDirXML-Associations: cn=IDtoCSS,cn=Driver Set v3,ou=DirXML,ou=services,o=swa-idsat#4#\r\n