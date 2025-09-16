# Untitled Note

ACL rights tool 10/6/2017 1:04:22 PM

ACL Tool requirements:
Overview:
    The purpose of the ACL tool is to give us the ability to automatically document, validate and possibly even reset eDirectory rights using an LDIF file as the mechanism for storage. We will do this work in three phases:

    1 - Documentation
    2 - Validation
    3 - Reset

    1 - Documentation: during this phase our goal will be to write a java based tool that can add a comment line (or multiple) for each ACL present in the LDIF file that describes the integer values of the ACLs, including Inherited rights ACL entries.

        Estimate: 6

    2 - Validation: during this phase, we will update the ACL tool to include the ability to consume an LDIF file with ACL entries that can check that those rights are effective in eDirectory; using the LDAP Extension Get effective rights
        \*Note: the first action

        Estimate: 10

    3 - Reset rights:
         - start by importing the ACL ldif file
         - Check rights not in the ldif file . .

        Estimate: 24

Resources:
Extensions documentation:
https://www.novell.com/developer/ndk/ldap\_extensions\_and\_controls\_for\_jndi.html#bn5n9ae

API (this has the novbp.jar that contains the implementation of the ldap extensions)
ftp://sdk.provo.novell.com/ndk/extjndi/builds/windows/novell-extjndi-devel-2006.02.28-1windows.zip
