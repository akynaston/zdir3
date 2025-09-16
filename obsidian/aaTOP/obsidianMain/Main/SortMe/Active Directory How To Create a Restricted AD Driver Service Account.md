# Active Directory: How To Create a Restricted AD Driver Service Account

Active Directory: How To Create a Restricted AD Driver Service Account

Relevant Documentation:
[Create an Administrative Account](https://www.netiq.com/documentation/identity-manager-46-drivers/ad/data/bp7wru3.html)
[Configuring System Permissions](https://www.netiq.com/documentation/identity-manager-46-drivers/ad/data/b10m9z1j.html)
[Changing permissions on a deleted object container](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/cc816824(v=ws.10)#Anchor_0)
[Allow AD user to set passwords but no other attributes](https://serverfault.com/questions/410267/allow-ad-user-to-set-passwords-but-no-other-attributes)

TODO: Reduce all of this to a dsacls script

Summary (collected from the above links)
To create an AD service account the following have to be considered:
 - The user needs Read and "Replicating Directory Changes" at the root of the domain
 - The user needs Write rights to any object modified In AD (Write rights can be restricted to the containers and attributes that are written by the Subscriber channel)
 - To obtain delete events from Active Directory, you need permission to view the contents of the deleted objects container. 
 - To enable password sync, on the Publisher channel, the driver requires system permissions in addition to Active Directory permissions.
     - Identity Manager also configures specific permissions for its own internal components. On domain controllers, the PWFilter component runs using SYSTEM privileges, so the local system account should have full permissions to the HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Novell\\PwFilter\\Data registry key, as well as any sub-keys.
     - The driver shim runs using SYSTEM privileges by default, so the system account should also have full permissions to the HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Novell\\PassSync\\Data registry key, as well as any sub-keys. If the driver is run using any other account, that account should be given full permissions to the HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Novell\\PwFilter\\Data registry key, as well as any sub-keys.
    _**NOTE:**_The driver automatically provides default permissions to both PWFilter and the driver shim.

In Active Directory Users and Computers (ADUC, dsa.msc)... 

1. Create a user account in the domain in question
	1. On the password page...
		1. Uncheck the "User must change password at next login" checkbox
		2. If customer policy permits, check the "Password never expires" checkbox
2. Grant "Replicating Directory Changes" rights to the new user account
	1. Right-click on the domain object > Security (tab) 
	2. Using the Add button, add the new user account to the "Group or user names:" scrollbox
	3. In the "Permissions for _<account-name>_" scrollbox, check the Allow "Replicating Directory Changes" checkbox
3. Add granular permissions to containers _and their descendants_ where the driver will create/modify Users in
	1. For each container...
		1. Right-click on the container > Security (tab)
		2. Using the Add button, add the new user account to the "Group or user names:" scrollbox
		3. In the "Permissions for _<account-name>_" scrollbox
			1. Check the Allow Read checkbox (it should be already)
		4. Click the Advanced button
		5. In the "Permission entries:" scrollbox, scroll down to the new user account
		6. Click the Edit button
		7. In the "Applies to:" dropdown, select "Descendant User objects"
		8. For each object class the attributes belong to (typically User)
			1. Click the Add button
			2. Click on the "Select a principal" link and find the new user account
			3. In the "Applies to:" dropdown, select "Descendant _<class>_ objects"
				1. The attribute in question may only show up on the User or InetOrgPerson classes or some other base class altogether. Check these classes first.
			4. Scroll down in the Properties: section and find the attribute name
			5. Check the "Write _<attr-name>_" checkbox for each attribute of the class
			6. Note: The UPN or userPrinicpalName attribute isn't specifically listed in ADUC. It's comprised of two attributes: "Logon Name (pre-windows 2000)" (aka sAMAccountName) and "Logon Name" Check both. (unvetted)
		9. To grant the User create permission... (unvetted)
			1. Click the Add button
			2. Click on the "Select a principal" link and find the new user account
			3. In the "Applies to:" dropdown, select "This object and all descendant objects"
			4. Scroll down to the "Permissions:" section
			5. Check the "Create User objects" checkbox
		10. To grant the User create permission... (unvetted)
			1. Click the Add button
			2. Click on the "Select a principal" link and find the new user account
			3. In the "Applies to:" dropdown, select "This object and all descendant objects"
			4. Scroll down to the "Permissions:" section
			5. Check the "Delete User objects" checkbox
4. For the Publisher to monitor delete events, grant read permissions to the "Deleted Objects" container
	1. Follow the basic instructions here: [Changing permissions on a deleted object container](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/cc816824(v=ws.10)#Anchor_0)
	2. From an Administrative command-line as a domain admin, type this command:
		1. dsacls "CN=Deleted Objects,_<domain-ldap-dn>_" /takeownership
			1. e.g., dsacls "CN=Deleted Objects,DC=WIN,DC=NARA,DC=GOV" /takeownership
		2. dsacls "CN=Deleted Objects,_<domain-ldap-dn>_" /G _<domain-dotted>_\\_<user-or-group>_:_<permissions>_
			1. /G = Grant
			2. e.g., dsacls "CN=Deleted Objects,DC=WIN,DC=NARA,DC=GOV" /G WIN.NARA.GOV\\addriver:GR
				1. GR = Generic Read

If the driver to set passwords... (TODO: Identify the exact permissions rather than use the wizard)
In ADUC...

1. For each container where the driver will be managing objects
	1. Right-click > "Delegate Control" > "Next>" (button) 
	2. Add the user to the "Selected users and groups:" scrollbox
	3. Select the "Delegate the following common tasks:" radio button
	4. Check the "Reset user passwords and force passwords to change at next login" checkbox
	5. "Next>" button
	6. "Finish"

If the Publisher will be syncing passwords...
In Regedit...

1. Follow the basic instructions here:  [Configuring System Permissions](https://www.netiq.com/documentation/identity-manager-46-drivers/ad/data/b10m9z1j.html)
2. For these keys: HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Novell\\PwFilter\\Data and HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Novell\\PassSync\\Data
	1. Righ-click on the key > "Permissions..."
	2. Select the user account in the "Group or user names:" scrollbox
	3. In the "Permissions for ALL APPLICATIONS PACKAGES" box, check the Allow "Full Control" checkbox

Property UPN is a property =
Logon Name (pre-windows 2000) = sAMAccountName
Logon Name
