---
tags: ["#powershell"]
---
# Exchange 2007 Management Shell cmdlet execution from within IDM Policy Rules | Novell User Communities

## Introduction

For those who have not come across it, PowerShell is Microsoft's new fully featured command [shell](http://www.novell.com/communities/glossary/term/791) for their desktop and [server](http://www.novell.com/communities/glossary/term/2314) operating systems. It is an extensible command-line shell and scripting language that integrates with the .NET Framework. Administrative tasks are achieved by the execution of cmdlets which are special .NET classes and scripts that call the various cmdlets to achieve the required task.

With the release of Exchange 2007, Microsoft have radically rebuilt the Exchange Server product. Notably, the management of the system relies entirely on PowerShell, with a set of cmdlets provided to mange the system from the [command line](http://www.novell.com/communities/glossary/term/527). The hosting mechanism provided by PowerShell means that GUI applications such as the Exchange Management Console effectively run PowerShell cmdlets behind the scenes.

In order to continue to provide support for Exchange Server, the AD driver that ships with Identity Manager v3.5.1 includes a .NET service that is installed along side the remote loader. This provides support for mail enabling users in Exchange 2007 that are provisioned in AD by the IDM AD driver.

### Wouldn't it be great if ...

The AD Driver shipping with IDM v3.5.1 provides the ability to create, move and disable Exchange 2007 mailboxes. This is all great stuff and saves a lot of administrative effort in provisioning fully mail enabled AD accounts. But what if you want to affect some other changes to a mailbox using Exchange 2007 Management Shell cmdlets for existing users?

The short answer is you can't! The IDM v3.5.1 AD driver provides no such support.

A quick check on the forums shows there is some demand here. Some solutions I found on the web were:

1. **Implement the IDM Scripting driver from the IDM Services pack.**
	
	I have tried this driver and it works very well, but perhaps it's 'a sledge hammer to crack a walnut' for Exchange 2007 cmdlets. The Scripting Service driver is a fully featured driver framework. As standard it does nothing, but is a 'skeleton' for you to write your own code for the various events such as add, move, delete etc. You could code it to pretty much replace the AD driver.
	
2. **Write a value to one of the AD ExtensionAttributes and have a scheduled PowerShell script that searches for this value and does something.**
	
	This was detailed in a [Cool Solution by Yancey Yeargan](http://www.novell.com/coolsolutions/tip/19093.html). Whilst this solution detailed a way of mail enabling AD users prior to support being added to the AD Driver, looking at the PowerShell code he submitted, it is evident that this could be adapted to perform other tasks. The down side is it is not real-time and on a big directory could add a considerable load if you got too ambitious.
	
3. **Write your own .NET listener!!**
	
	Wow. Spotted this one in the Forums, clever stuff.
	

This document details a method of executing Exchange 2007 Management cmdlets from within IDM [policy](http://www.novell.com/communities/glossary/term/3000) rules using just the tools available with IDM v3.5.1 and some basic programming skills

It should be noted that the author presupposes the reader has some familiarity with ECMA /Javascript/JScript/BASH scripts,
Designer and the creation of IDM policy rules.

### Environment

Before going any further, a quick mention about the environment this solution was developed on. The Identity Vault was running on SLES 10 SP1 with [eDirectory](http://www.novell.com/communities/glossary/term/3276) v8.8 installed from the OES2 CD. The AD environment was hosted on Microsoft Windows 2003 server, with .NET v2.0 framework, PowerShell v1.0 and the Exchange 2007 management tools.

Note that if you have already deployed the IDM v3.5.1 AD driver and Exchange 2007 service, this already requires .NET v2.0 and the Exchange 2007 management tools in order to function. You will not need to do anything further to the server other than the steps described in later sections.

There's a lot of ground to cover, so lets get started.

## AD Driver Modifications

This section details the modifications to a standard IDM v3.5.1 AD driver that are required.

### ECMA Script Library

The provision of support for ECMA scripting support within drivers was a welcome addition to IDM and is used in this solution. Those of you who are not familiar with the use of ECMA scripts within policy rules might like to take a look at a previous article [Using ECMA Scripts in IDM Policy Rules](http://www.novell.com/communities/node/5883/using-ecma-scripts-idm-policy-rules) I have written on the subject at this point.

Having created your Library object in the AD Driver you will need to add the function shown below

/\*
 \* Function:            runSSH
 \* Version:             1.0
 \* Author:              Justin Birt
 \* Description: Runs the ssh command from the shell
 \* Date:                01 Sept 2008
 \*
 \*/
importPackage(Packages.java.lang);
function runSSH(pshell){
        var error\_code, script;
        script = "ssh \[Server IP\] C:\\\\WINDOWS\\\\System32\\\\Cscript C:\\\\IDM\\\\pshell.js " + pshell;
        try{
                myProcess = new java.lang.Runtime.getRuntime().exec(script);
                error\_code = myProcess.waitFor();
        }
        catch(e){
        
                error\_code = e;
        }
                
        switch(error\_code){
        
                case 0:
                        error\_code = 'The shell script executed OK';
                case 1:
                        error\_code = 'The shell script failed';
                default:
        }
        
        return error\_code;
}

The function described above receives one argument _pshell_ from the calling policy rule and returns an error code.

Having declared the required variables, the _script_ variable is initialised with the command line we want to run in the shell plus the value of the _pshell_ argument tacked on the end.

Next we have a try/catch block that instantiates an instance of the java.lang.Runtime class and calls the exec() method passing the value of our _script_ variable. We wait for the process we have spawned to complete and assign the retuned error code to a variable _error\_code_.

The java.lang.Runtime class allows us to access the command shell of the hosting operating system. On a MS Windows machine this will be cmd.exe and on Linux it will be the bash shell.

There is a final switch block that provides a small amount of decoding for the return code from the Runtime process thread, before this is finally returned to the calling policy rule.

### Subscriber Command Policy Rule

In the [XML](http://www.novell.com/communities/glossary/term/3186) code shown below, I have shown a policy rule example. When a user account is disabled in the Identity Vault, the AD driver takes care of disabling the associated user account in AD. In a lot of environments, accounts are disabled when a user leaves the organisation, prior to being finally deleted. In an Exchange 2007 environment, the user is still visible in the Global Address List (GAL) and any other Address Lists they are a member of, even thou they are disabled.

The rule below addresses this issue.

<rule>
        <description>UAL User: Login Disabled
        <comment xml:space="preserve">When a 'Login Disabled' attribute change occurs, as well as replicating this change of status in AD, we wish to manipulate the MS Exchange 2007 attributes of the user object to hide them from the GAL and other address lists.
This can only be achieved reliably by running Exchange 2007 PowerShell cmdlets.
This rule traps status changes in the 'Login Disabled' attribute and runs a cmdlet on the remote AD server to make a user either visible or invisible in the GAL and other policy driven address list assignments
        <conditions>
                <and>
                        <if-class-name mode="nocase" op="equal">User
                        <if-operation mode="case" op="equal">modify
                        <if-op-attr name="Login Disabled" op="changing"/>
                </and>
        </conditions>
        <actions>
                <do-if>
                        <arg-conditions>
                                <and>
                                        <if-op-attr mode="nocase" name="Login Disabled" op="changing-to">TRUE
                                </and>
                        </arg-conditions>
                        <arg-actions>
                                <do-set-dest-attr-value name="extensionAttribute1">
                                        <arg-value>
                                                <token-dest-attr name="extensionAttribute1"/>
                                                <token-text xml:space="preserve"> LEFT
                                        </arg-value>
                                </do-set-dest-attr-value>
                                <do-set-local-variable name="LV\_Script" scope="policy">
                                        <arg-string>
                                                <token-text xml:space="preserve">set-mailbox -Identity
                                                <token-src-name/>
                                                <token-text xml:space="preserve"> -HiddenFromAddressListsEnabled 1
                                        </arg-string>
                                </do-set-local-variable>
                                <do-set-local-variable name="LV\_Test" scope="policy">
                                        <arg-string>
                                                <token-xpath expression="es:runSSH($LV\_Script)"/>
                                        </arg-string>
                                </do-set-local-variable>
                        </arg-actions>
                        <arg-actions>
                                <do-if>
                                        <arg-conditions>
                                                <and>
                                                        <if-op-attr mode="nocase" name="Login Disabled" op="changing-to">FALSE
                                                </and>
                                        </arg-conditions>
                                        <arg-actions>
                                                <do-set-dest-attr-value name="extensionAttribute1">
                                                        <arg-value>
                                                                <token-split delimiter=" ">
                                                                        <token-dest-attr name="extensionAttribute1"/>
                                                                </token-split>
                                                        </arg-value>
                                                </do-set-dest-attr-value>
                                                <do-set-local-variable name="LV\_Script" scope="policy">
                                                        <arg-string>
                                                                <token-text xml:space="preserve">set-mailbox -Identity
                                                                <token-src-name/>
                                                                <token-text xml:space="preserve"> -HiddenFromAddressListsEnabled 0
                                                        </arg-string>
                                                </do-set-local-variable>
                                                <do-set-local-variable name="LV\_Test" scope="policy">
                                                        <arg-string>
                                                                <token-xpath expression="es:runSSH($LV\_Script)"/>
                                                        </arg-string>
                                                </do-set-local-variable>
                                        </arg-actions>
                                        <arg-actions/>
                                </do-if>
                        </arg-actions>
                </do-if>
        </actions>
</rule>

As with all rules, this example has a conditional command block and an action block.

**Command Block**

It can be seen that this block is testing that the document in the channel is a user object, represents a modify event and that the _Login Disabled_ attribute is changing state.

**Action Block**

In the Action block, further conditional processing occurs by way of the <do-if> command. This allows the rule to construct and pass to the sshRun() function - described earlier - a different string representing the PowerShell cmdlet we wish to execute.

There is one for when the _Login Disabled_ attribute is turning true ...

set-mailbox -Identity \[SourceName\] -HiddenFromAddressListsEnabled 1

which hides a user from Exchange 2007 address lists and one for when the _Login Disabled_ attribute is turning false ...

set-mailbox -Identity \[SourceName\] -HiddenFromAddressListsEnabled 0

which makes the user visible in the address lists again. As you can see overall, this means a users visibility will track the status of the _Login Disabled_ attribute.

These are the only changes that are required to the existing AD driver configuration.

## SLES Configuration Changes

This section examines the minor configuration changes that are required to the SLES server hosting the Identity Vault.

### SSH

For those of you who are unfamiliar with the ssh client (**s**ecure **sh**ell), this is a program that allows remote command execution. An additional feature of interest is that it allows secure authentication to be established using keys, ensuring an encrypted communication channel, with no need for a password.

In order for ssh to be used, a small amount of configuration is required as detailed in the next sub sections.

### SSH Key Generation

As already mentioned, we need to mint some keys in order to establish the communication channel. To achieve this:

1. Login as root on your SLES box hosting the Identity Vault and at the bash prompt issue the command ...
	ssh-keygen -t rsa
	
2. When prompted to _Enter file in which to save the key (/root/.ssh/id\_rsa)_, press Enter.
3. Press Enter twice when prompted for a pass phrase
	
	This will mint two keys **id\_rsa** and **id\_rsa.pub** located in /root/.ssh
	
4. Rename **id\_rsa** to **root** and **id\_rsa.pub** to **root.pub**. The file you have named **root.pub** will be needed on the Windows server, so take a copy at this point.

### SSH Configuration

In order for the ssh client to work, it is also necessary to make some changes to the configuration.

The configuration file can be found in /etc/ssh/ssh\_config. Copy this file to ~/.ssh/config. If like me you are still finding you way with Linux, then the last sentence translates as copy /etc/ssh/ssh\_config to the hidden folder .ssh in the users [home directory](http://www.novell.com/communities/glossary/term/1463). In this example we are using root, so you will have a file /root/.ssh/config

If you open ~/.ssh/config in the editor of your choice look for the line ...

\# IdentityFile ~/.ssh/identity
\# **IdentityFile ~/.ssh/id\_rsa**
\# IdentityFile ~/.ssh/id\_dsa

Edit this to look like this ...

\# IdentityFile ~/.ssh/identity
**IdentityFile ~/.ssh/root**
\# IdentityFile ~/.ssh/id\_dsa

What we have done here is to instruct the ssh client to use the key file **~/.ssh/root** when establishing connections as user root.

## Windows Server Configuration

This section details the configuration changes required on the Windows server already hosting the AD Driver Remote Loader.

### Windows ssh [daemon](http://www.novell.com/communities/glossary/term/539)

PowerShell v1.0, the currently shipping version, has no [remote access](http://www.novell.com/communities/glossary/term/2194) support built in. There are rumours that v2.0 will provide such support, but whether it will be compatible with the Linux ssh client is not clear. As such this solution resorts to other means.

A great program exists - **freeSSHd** - that supports ssh on the Windows platform. A copy of freeSSHd for Windows can be obtained [here](http://www.freesshd.com/?ctt=download).

This program should be installed on the same Windows Server already hosting your AD Driver Remote Loader.

Once installed, there are a few configuration items that need to be addressed, as detailed in the following steps.

1. Create the folder **C:\\Documents and Settings\\root** and copy the **root.pub** file you took from you Identity Vault SLES box to this location.
2. Rename this file from **root.pub** to **root**.
3. Right click the freeSSHd taskbar icon and select **Settings...** from the pop-up menu.
4. In the _freeSSDd Settings_ dialog shown below, select the **Users** tab and click the **Add** button.
	[![[./_resources/Exchange_2007_Management_Shell_cmdlet_execution_from_within_IDM_Policy_Rules__Novell_User_Communities.resources/freesshd_users_0_0.jpg]]](http://www.novell.com/communities/files/u1395/freesshd_users_0_0.jpg)
	
	[Click to view](http://www.novell.com/communities/files/u1395/freesshd_users_0.jpg)
	
	Figure 1 – Configuring a user account in freeSSHd
	
5. In the _User Properties_ dialog, set the _Login_ to **root**, the _Authorization_ to **Public key(SSH only)** and check the _User can use_ radio button to **shell** as shown in the dialog below . Click the **OK** button to close the dialog.
	![[./_resources/Exchange_2007_Management_Shell_cmdlet_execution_from_within_IDM_Policy_Rules__Novell_User_Communities.resources/freesshd_user_pref_0.jpg]]
	
	[Click to view](http://www.novell.com/communities/files/u1395/freesshd_user_pref.jpg)
	
	Figure 2 – Configuring user preferences in freeSSHd
	
	Note that this is not an account on the hosting server but one within the freeSSHd system
	
6. Click the **Authentication** tab on the _freeSSDd Settings_ dialog and configure the _Public key folder_ to **C:\\Documents and Settings\\root**, set the _Password authentication_ to **Disabled** and set _Public key authentication_ to **Allowed**.
	[![[./_resources/Exchange_2007_Management_Shell_cmdlet_execution_from_within_IDM_Policy_Rules__Novell_User_Communities.resources/freesshd_auth_0.jpg]]](http://www.novell.com/communities/files/u1395/freesshd_auth_0.jpg)
	
	[Click to view](http://www.novell.com/communities/files/u1395/freesshd_auth.jpg)
	
	Figure 3 – Configuring Authorisation preferences in freeSSHd
	

### WSH

You will have seen when examining the ECMA code shown in the **ECMA Script Library** section of this article that it invokes a windows program **CScript** via an ssh remote command session with the Windows server. CScript is the command line component of the Windows Script Host (WSH) that Microsoft developed sometime ago. Prior to PowerShell, this was one way of achieving advanced scripting in the Windows environment.

Interestingly, WSH will read scripts written in either VBScript or JScript as standard. As JScript is closely ECMA compliant I have used it in this script file.

Novell use VBScript in their Scripting Service driver which also uses WSH in part.

You will also see that Cscript is invoked with a script file C:\\IDM\\pshell.js passed as the first argument. You should create this file and [directory structure](http://www.novell.com/communities/glossary/term/1267) on your Windows machine and then cut & paste the code shown below into **pshell.js**

/\*
 \*
 \* File:                pshell.js
 \* Version:             1.0
 \* Author:              Justin Birt
 \* Description: A launch wrapper for Powershell.
 \* Date:                01 Sept 2008
 \*
 \*/
var objArgs, ex, log, allArgs = "";
log = new Log;
log.Open();
objArgs = WScript.Arguments;
if(objArgs.length < 1){
        log.Write(Now() + "\\t" + "No arguments passed, program exiting");
        log.Close();
        WScript.Quit(1);
}
for(i=0;i < objArgs.length; ++i){
        allArgs += objArgs(i) + " ";
}
log.Write(Now() + "\\t" + Trim(allArgs));
ex = IDMRun(Trim(allArgs));
log.Close();
WScript.Quit(ex);
/\* Functions-----------------------------------------------------------------------------\*/
function IDMRun(script){
        var shell, exitCode;
        shell = WScript.CreateObject("WScript.Shell");
        try{
                exitCode = shell.Run('"C:\\\\WINDOWS\\\\System32\\\\windowspowershell\\\\v1.0\\\\powershell.exe" -PSConsoleFile "C:\\\\Program Files\\\\Microsoft\\\\Exchange Server\\\\bin\\\\exshell.psc1" -command ' + script, 1, true);
        }
        catch(e){
                exitCode = 1;
                log.Write(Now() + "\\t" + "There was a problem launching PowerShell");
                log.Close();
        }
        
        return exitCode;
}
function Trim(str){
        if(!str || typeof str != 'string')
                return null;
        
        return str.replace(/^\\s+|\\s+$/g,'');
}
function Now(){
        var now, hours, dateStamp;
        
        now = new Date();
      hours = ( now.getHours() < 10 ? "0" : "" ) + now.getHours();
        minutes = ( now.getMinutes() < 10 ? "0" : "" ) + now.getMinutes();
        day = ( now.getDate() < 10 ? "0" : "" ) + now.getDate();
        month = ( now.getMonth() < 10 ? "0" : "" ) + now.getMonth();
        year = ( now.getYear() < 10 ? "0" : "" ) + now.getYear();
        dateStamp = hours + ":" + minutes + " " + day + " " + month + " " + year;
        return dateStamp;
}
/\* Objects -----------------------------------------------------------------------------\*/
function Log(){
        var fs, writer, out;
        fs = WScript.CreateObject("Scripting.FileSystemObject");
        Log.prototype.Open = function(){
                if(!fs.FileExists("C:\\\\IDM\\\\Log.txt")){
                        fs.createTextFile("C:\\\\IDM\\\\Log.txt");
                }
                writer = fs.GetFile("C:\\\\IDM\\\\Log.txt");
                out = writer.OpenAsTextStream(8,0);
        }
        Log.prototype.Write = function(str){
        
                out.WriteLine(str);
        }
        Log.prototype.Close = function(){
                out.close();
        }
}

At first glance this may seem quite complicated but does include a few library functions and objects which make it appear more complex than it really is. Lets run through how it works ...

**Trim()**

This function does what you might imagine and trims leading and trailing white spaces from any string passed and returns the result. It uses a [regular expression](http://www.novell.com/communities/glossary/term/3350) to achieve this.

**Now()**

This funtion returns a time and date string when called and is used when writing to the [log file](http://www.novell.com/communities/glossary/term/1663).

**IDMRun()**

This is the key function in the library and is a launch wrapper for PowerShell. It makes a call to the Wscript.Shell objects Run method to start PowerShell and pass our required cmdlet call as an argument.

**Log()**

This is actually an object for managing a local log file and supports methods for open, close and write. You don't actually need this, I included it whilst I was developing this solution.

The main elements of the script work as follows ...

First we instantiate the log object and call its open() method. This creates a file C:\\IDM\\log.txt, if it doesn't already exist and opens it for writing. Next we assign Wshell.Arguments to a variable which will hold the cmdlet call we constructed way back in the Policy Rule. For protection we check that an argument was passed and throw an error if none is present.

Even though we passed pshell.js a string, Wshell.Arguments stores this as an array, with the split point being a space. Therefore we need to reconstruct this into a string variable using a for/next loop.

Because this reconstruction leaves a trailing space, the variable _allArgs_ is passed to the Trim() function to have leading and trailing spaces removed before being passed to the function IDMRun().

IDMRun() launches PoweShell with the Exchange Management Console commands and our cmdlet call passed as parameters.

Lastly, we close the log and quit.

### PowerShell

For security reasons, PowerShell can only operate interactively as standard, that is, with you typing commands directly into the console. In order for this solution to work the security needs to be relaxed a bit. To achieve this ...

1. On your Windows server start a PowerShell session by clicking **Start > Windows PowerShell 1.0 > Windows PowerShell**.
2. At the console type ...
	set-executionpolicy remotesigned
	

This sets the shell to allow local scripts to execute but still offers protection from 'external' code.

## Testing

Well done if you've got this far, all the configuration is now complete, so we can now do a bit of testing.

From the bash prompt of your SLES box ...

1. type _ssh \[ip address of AD server\]_ and press the **enter** key.
2. When prompted '_The authenticity of host ... Are you sure you want to continue connecting (yes/no)?_' type **yes** and press **enter**.
	This adds the Windows server into the **/root/.ssh/known-hosts** file. Subsequent connection attempts will occur without this prompt.
	

If all has gone well the prompt should change to **C:\\Windows\\System32**. That tests your connection and remote console session on the Windows box. Type **exit** to quit.

You are now ready to test the whole process. Set the _Login Disabled_ attribute of a user and then – allowing for a small amount of [latency](http://www.novell.com/communities/glossary/term/1609) – go and check the user in the Exchange Management Console. You should see that **Hide from Exchange address lists** on the **General** tab is checked. Additionally if you examine the AD attributes of the user object in AD, you should see the multi valued attribute **showInAddressBook** has been cleared. When re-enabling the user, this attribute will be populated with the DNs of all the address books the user is assigned to and **Hide from Exchange address lists** will be unchecked.

## Conclusions

The solution documented here demonstrates a framework for executing Exchange 2007 Management Shell cmdlets from within IDM policy rules. An example rule provides a practical illustration of the framework in action. The benefit of storing the cmdlet calls in the policy rules themselves is that the circumstances under which they are called and the calls themselves appear within the solution documentation that can be generated by Designer.

With a small amount of modification, it is possible to adapt this solution to execute complete script files rather than single cmdlets, allowing for more complex Exchange 2007 management tasks to be accomplished.

### Author Info

17 September 2008 - 3:03pm
Submitted by: [9556613](http://www.novell.com/communities/user/1395)

[Author Blog](http://www.novell.com/communities/blog/1395)
[Author Profile](http://www.novell.com/communities/user/1395)

### Tags

[Identity Manager](http://www.novell.com/communities/taxonomy/term/11) [Identity Manager 3.5](http://www.novell.com/communities/taxonomy/term/3422) [Active Directory](http://www.novell.com/communities/taxonomy/term/162) [Identity Management](http://www.novell.com/communities/taxonomy/term/282)
[Tags Map](http://www.novell.com/communities/site-tags)

## Related Articles

* [Running a Driver Script after AD Account Creation](http://www.novell.com/communities/node/4302/running-a-driver-script-after-ad-account-creation)
* [Using ECMA Scripts in IDM Policy Rules](http://www.novell.com/communities/node/5883/using-ecma-scripts-idm-policy-rules)
* [Load balancing mailboxes across Exchange 2007 message stores using IDM policy rules](http://www.novell.com/communities/node/6256/load-balancing-mailboxes-across-exchange-2007-message-stores-using-idm-policy-rules)
* [Detecting User-Driver Associations](http://www.novell.com/communities/node/3966/detecting-user-driver-associations)
* [Using the IDM GroupWise Driver](http://www.novell.com/communities/node/4325/using-idm-groupwise-driver)

## User Comments

![[./_resources/Exchange_2007_Management_Shell_cmdlet_execution_from_within_IDM_Policy_Rules__Novell_User_Communities.resources/default_user.png]]

## [RE: Exchange 2007 PowerShell Execution](http://www.novell.com/communities/node/6073/exchange-2007-management-shell-cmdlet-execution-within-idm-policy-rules#comment-4729)

Submitted by Anonymous on 18 September 2008 - 1:27pm.

TriVir also has an Exchange 2007 driver that supplements existing AD driver deployments. It manages exchange mailstore [load balancing](http://www.novell.com/communities/glossary/term/2909), anti-affinity, management of mailboxes, group distribution lists, contacts, resource objects and more.

It allows users to simply embed PowerShell scripts from within IDM policies. More information available at [info@trivir.com](mailto:info@trivir.com).

* [Login](http://www.novell.com/communities/user/login?destination=node/6073%2523comment-form) to post comments

![[./_resources/Exchange_2007_Management_Shell_cmdlet_execution_from_within_IDM_Policy_Rules__Novell_User_Communities.resources/default_user.png]]

## [Excellent article](http://www.novell.com/communities/node/6073/exchange-2007-management-shell-cmdlet-execution-within-idm-policy-rules#comment-4730)

Submitted by Anonymous on 18 September 2008 - 3:40pm.

Nicely written, professional and clear.

Thank you !
OG

* [Login](http://www.novell.com/communities/user/login?destination=node/6073%2523comment-form) to post comments

[![[./_resources/Exchange_2007_Management_Shell_cmdlet_execution_from_within_IDM_Policy_Rules__Novell_User_Communities.resources/default_user.png]]](http://www.novell.com/communities/user/12109)

## [WOW...A lot of work just to](http://www.novell.com/communities/node/6073/exchange-2007-management-shell-cmdlet-execution-within-idm-policy-rules#comment-5457)

Submitted by [heerj](http://www.novell.com/communities/user/12109) on 17 December 2008 - 10:02pm.

WOW...A lot of work just to run a simple command on a Windows box in real-time.
I completely agree, real-time is always the way to go. Almost. Sometimes enough is enough and the simplest method is the way to go.

Just write to an attribute in the vault and periodically read the attribute from the Windows box using [LDAP](http://www.novell.com/communities/glossary/term/1613). You can use ICE for this and hardly lift your programming finger.

True, this is not real-time. But if the real-time thing really bugs you. Read the vault attribute every 30 seconds…or 10 seconds... The LDAP calls have virtually no performance impact and is much simply than all the above.

My 2 cents :-)

* [Login](http://www.novell.com/communities/user/login?destination=node/6073%2523comment-form) to post comments

[Novell® Making IT Work As One™](http://www.novell.com/company/strategy.html)

* [Careers](http://www.novell.com/company/careers/index.html)
* [Contact Us](http://www.novell.com/company/contacts-offices)
* [Feedback](http://www.novell.com/inc/feedback/feedback.jsp)
* [Legal](http://www.novell.com/company/legal)
* 

© 2009 Novell, Inc. All Rights Reserved.

![[./_resources/Exchange_2007_Management_Shell_cmdlet_execution_from_within_IDM_Policy_Rules__Novell_User_Communities.resources/0.gif]]
![[./_resources/Exchange_2007_Management_Shell_cmdlet_execution_from_within_IDM_Policy_Rules__Novell_User_Communities.resources/exchange-2007&tzo=420&ms=345.gif]]
