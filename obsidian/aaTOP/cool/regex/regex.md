9/11/2023 11:33:52 AM
regex to replace all non target driver associations:
^(?!DirXML-Associations: cn=IDtoCSS.+|dn:.+|version:).+

And trash hard returns:
^(?!DirXML-Associations: cn=IDtoCSS.+\r\n|dn:.+|version:).+\r\n

^(?!dn:.+\r\n|dn:.+|version:).+\r\n