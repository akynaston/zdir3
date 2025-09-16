5/9/2024 3:28:55 PM
Without template dn:

 * First, you must still have 'mailbox' since that's what IMAP uses to log in with as the user name and password!
 * Second, you must provide 'Body' instead of a TemplateDN to avoid template validation (and <shortcut/> style element violations)
 * Third: Subject DOES NOT CURRENTLY SUPPORT A REGULAR EXPRESSION!  You either need to have it match exactly, or don't provide it.
 

![[Pasted image 20240509154346.png]]



* Fourth: use this config:
Config:
Set: user, password, server, port, ssl false as follows:
```
	<server>172.17.2.90</server>
	<port>143</port>                
	<ssl>false</ssl>
	<multiplier>
	and so on . .
	```