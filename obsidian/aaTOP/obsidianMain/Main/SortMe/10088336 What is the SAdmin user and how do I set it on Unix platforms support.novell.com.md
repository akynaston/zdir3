# 10088336: What is the SAdmin user and how do I set it on Unix platforms? [support.novell.com]

# What is the SAdmin user and how do I set it on Unix platforms?

## (Last modified: 10Nov2003)

This document (**10088336**) _is provided subject to the [disclaimer](http://support.novell.com/docs/Tids/Solutions/10088336.html#disclaimer) at the end of this document._

### goal

What is the SAdmin user and how do I set it on Unix platforms?

### fact

Novell eDirectory 8.7.1 for Solaris

Novell eDirectory 8.7.1 for Linux

Novell eDirectory 8.7.1 for AIX

### fix

You can set up a preconfigured admin user which allows access to the HTTP Protocol Stack (HTTPSTK) when eDirectory is not loaded. The preconfigured admin user, SAdmin, has rights that are equivalent to the eDirectory Admin User object. If the server is in a state where eDirectory is not functioning correctly, you can log in to the server as this user and perform all the diagnostic and debugging tasks necessary that do not require eDirectory.

Use the DHOST remote manager page (accessible through the /dhost URL or from the root page) to set the SAdmin password. Novell eDirectory server must be running on the eDirectory server in order for you to set or change the SAdmin password.

1. Open a Web browser.
	
2. In the address (URL) field, enter the following:
	
	http://_server.name_:_port_/dhost
	
	for example:
	
	http://MyServer:80/dhost
	
	You can also use the server IP address to access the DHost iConsole. For example:
	
	http://137.65.135.150:80/dhost
	
3. Specify a username, context, and password.
	
4. Click HTTP Server, then specify an SAdmin password.
	
5. Verify the password you just specified, then click Submit.
	

ndsconfig

Use the ndsconfig utility to set the SAdmin password. ndsd must be running on the eDirectory server in order for you to set or change the SAdmin password.

Enter the following at the server console

ndsconfig set http.server.sadmin-pwd=_password_

where _password_ is the new SAdmin password.

### note

The SAdmin user is a virtual user object which has limited rights. Even though it states the user has admin rights, this is only for running certain repairs. You cannot run destructive repairs without authenticating as a user with supervisory rights to the tree. Also, the objects can be browsed using the sadmin object but, he effectively uses Public rights to browse. You can limit access to this users password by limiting access to the ndsconfig utility and the nds.conf files, if you feel it necessary however, there is nothing destructive that can be done through this object.

### document

|     |     |
| --- | --- |
| **Document Title:** | What is the SAdmin user and how do I set it on Unix platforms? |
| **Document ID:** | 10088336 |
| **Solution ID:** | NOVL93608 |
| **Creation Date:** | 29Oct2003 |
| **Modified Date:** | 10Nov2003 |
| **Novell Product Class:** | Novell eDirectory |

### disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
