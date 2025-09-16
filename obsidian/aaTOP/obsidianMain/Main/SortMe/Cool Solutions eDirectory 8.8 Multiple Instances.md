# Cool Solutions: eDirectory 8.8 Multiple Instances

# eDirectory 8.8 Multiple Instances

## Novell Cool Solutions: AppNote

[Rate This Page](http://www.novell.com/inc/rater.jsp?url=http://www.novell.com/coolsolutions/appnote/17219.html)

Reader Rating  ![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/stars_5_0.gif]]  from 3 ratings

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)
* [tell a friend](http://www.novell.com/info/sendemail.jsp?url=http://www.novell.com/coolsolutions/appnote/17219.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 10 May 2006_ |     |

### Overview

eDirectory 8.8 now has a new feature called multi-instance support. This means that eDirectory 8.8 can host more than one instance of eDirectory on the same system, and they can coexist peacefully.

Traditionally, a single physical server (host) running the NetWare OS is represented as an NCP server in only one tree. In fact, it does not make much sense to change this for NetWare, so this feature works only on the \*nix platforms supported by eDirectory. For those platforms, the multi-instance feature allows a single host to be represented in the same tree more than once, or even participate in more than one tree. In this AppNote, each instance on my host will represent an individual NCP Server object in my eDirectory tree. It may be easier to think of multi-instance support as "NCP server virtualization" for eDirectory.

To explain this further, let's look at a few examples. These examples will result in two trees, each with three instances all running on a single host. Let's get started with our first tree.

### Single Tree with Multiple Instances on a Single Host

In this example, I am building a lab to be used to do some LDAP development work. I want to make sure that my test lab is taking advantage of eDirectory partition replication across three replicas, so I can observe replication behavior during my testing. Before multi-instance support I would have needed three physical servers to build my lab. Yes, I could use a server virtualization technology like Xen or VMware, but eventually I want to use multi-instance support in production. So, now is a good time to build my lab using multiple instances.

I start by grabbing some spare hardware and installing SUSE Linux Enterprise Server 9. I use a host name of ldaplab and an IP address of 192.168.0.5. I have only one NIC, but I want to associate each of my instances to independent IP addresses, and I want to keep the 192.168.0.5 address specific to the OS-related traffic. So, I get three more IP addresses and use them as virtual aliases during (or after) the OS install.

|     |     |
| --- | --- |
| **Address** | **Purpose** |
| 192.168.0.5 | Primary address for the OS |
| 192.168.0.101 | for eDirectory Instance 1 |
| 192.168.0.102 | for eDirectory Instance 2 |
| 192.168.0.103 | for eDirectory Instance 3 |

Another advantage of associating IP addresses with each eDirectory instance is that the instances are more portable. If I need to move an instance from my current ldaplab host to a new host, I can do so while still keeping its IP address associated to the instance. Since the address can be moved with the eDirectory instance, I don't have to modify my LDAP applications just because my hardware lease is expiring.

Next, I log in to the server as root and install the eDirectory binaries as usual. Once that is done I can create my first instance.

**Creating the First Instance in my Tree**

Since this is my first instance, this instance will also establish my tree. To do so I am using the ndsconfig command. I could simply run ndsconfig with a minimum of options like tree name, admin name and password, but since I am installing multiple instances, I need to take a little more control for multiple instances to work well. Also, I would like to organize my instances so it's easy to administer them.

First I create a directory to store all my eDirectory instance related data files. My server happens to be connected to my lab Storage Area Network (SAN), so I will store my files on the SAN. My mount point for the SAN is /mnt/labsan. I have chosen my tree name to be labtree01, so I create a place for all the files for each instance of my tree on my ldaplab host called:

/mnt/labsan/trees/labtree01

Under the /mnt/labsan/trees/labtree01 structure, I create sub-directories to store each individual NCP server instance that will be running on my ldaplab host within my tree. Although ndsconfig will do this for me, I like to create them manually ahead of time:

/mnt/labsan/trees/labtree01/labsrv01
/mnt/labsan/trees/labtree01/labsrv02
/mnt/labsan/trees/labtree01/labsrv03

For my lab I am not too concerned about formal naming standards, but I have chosen very specific and unique NCP server names so I can easily add address records to my DNS servers for each NCP server. You may want to develop your own scheme to easily identify your NCP server objects among trees.

Now I need to define some parameters to create my tree and its first NCP server. There are a lot of options available for the ndsconfig command - I won't use them all, just some of them to better control my tree and instance creation process:

|     |     |
| --- | --- |
| **Parameter** | **Description** |
| new | Tells ndsconfig to create a new tree |
| \-t labtree01 | My chosen tree name |
| \-a cn=admin.ou=lab | Tree administrator fully distinguished name |
| \-S labsrv01 | NCP server object name instead of the default (which would have matched the server's hostname of ldaplab). Doing this also adds to the portability of the instance I am creating. |
| \-n ou=servers.ou=services.o=lab | NCP server object context |
| \-B 192.168.0.101 | Sets the IP Address and port to which that eDirectory will bind NCP. No port is defined so the default port of 524 will be used |
| \-d /mnt/labsan/trees/labtree01/labsrv01 | eDirectory database file location |
| \-D /mnt/labsan/trees/labtree01/labsrv01 | Location for data files, logs, etc. |
| \--config-file /mnt/labsan/trees/labtree01/labsrv01/nds.conf | Location and name of the instance eDirectory config file |

Because this is a lab, I also want to disable the requirement for TLS for simple LDAP binds, by using the -e argument. So my final ndsconfig command is as follows:

ndsconfig new -t labtree01 -a cn=admin.o=lab -S labsrv01 -n ou=servers.ou=services.o=lab
  -B 192.168.0.101 -d /mnt/labsan/trees/labtree01/labsrv01 -D /mnt/labsan/trees/labtree01/labsrv01
 -e --config-file /mnt/labsan/trees/labtree01/labsrv01/nds.conf

I had no errors during creation, so now I have my first instance on my host. I have now established my tree with its lone NCP server object - "labsrv01". Like any tree that is created the first time, the NCP server holds the Master replica of the \[Root\] partition. There is nothing really multi-instance-related about my installation so far, but it is not exactly a default install, either.

In my tree I now have ensured that the NCP server object that I just created is called labsrv01 instead of matching the server's hostname of ldaplab, like what happens by default. After all, I can't have more than one NCP server object installed into the same tree and context with the same name. Keeping the NCP server object name distinct from the host server's hostname also adds to the portability of the instance, like associating each instance to its own IP address. The only other differences from a default installation is that I have controlled where the eDirectory instance-related files are installed on the host system, and I have told this instance to bind NCP to only one IP address.

**Creating the Second Instance in my Tree**

Now I want to add my second NCP server object to the tree on the same host (ldaplab) so I'll have a R/W replica of the \[Root\] partition. I need to build my next ndsconfig command:

|     |     |
| --- | --- |
| **Parameter** | **Description** |
| add | Tells ndsconfig to add a new NCP server to the tree |
| \-t labtree01 | My chosen (established) tree name |
| \-a cn=admin.ou=lab | Tree administrator fully distinguished name |
| \-S labsrv02 | NCP server object name |
| \-n ou=servers.ou=services.o=lab | NCP server object context |
| \-B 192.168.0.102 | Sets the IP Address and port to which that eDirectory will bind NCP. No port is defined, so the default port of 524 will be used |
| \-p 192.168.0.101 | Not required. But to avoid any name resolution problems, I am telling ndsconfig to contact this IP address to create the new instance. |
| \-L 1389 | This option sets the LDAP port to 1389 instead of the default of 389 (more on this later). |
| \-l 1636 | This option sets the LDAPS port to 1636 instead of the default of 636 (more on this later). |
| \-d /mnt/labsan/trees/labtree01/labsrv02 | eDirectory database file location |
| \-D /mnt/labsan/trees/labtree01/labsrv02 | Location for data files, logs, etc. |
| \--config-file /mnt/labsan/trees/labtree01/labsrv02/nds.conf | Location and name of the instance eDirectory config file |

Once again, I also want to disable the requirement for TLS for simple LDAP binds, by using the -e argument. So my final ndsconfig command is as follows:

ndsconfig add -t labtree01 -a cn=admin.o=lab -S labsrv02 -n ou=servers.ou=services.o=lab
 -B 192.168.0.102 -p 192.168.0.101 -L 1389 -l 1636 -d /mnt/labsan/trees/labtree01/labsrv02
 -D /mnt/labsan/trees/labtree01/labsrv02
 -e --config-file /mnt/labsan/trees/labtree01/labsrv02/nds.conf

Now that the install has started you may be wondering why I used different LDAP ports. I may have a good reason to change LDAP ports to non-standard ports, but I like standards - and not using the standard ports may cause problems for my other LDAP applications in the future. So why did I do it?

Well, it is only a temporary measure to get around a limitation in ndsconfig. The problem is that ndsconfig uses the -B option only for binding the eDirectory NCP port. So when the first instance was created, LDAP binds to "all interfaces" (0.0.0.0) by default. If you try to create the second instance with the default ports of 389 and 636, ndsconfig warns that port 389 is already in use. There is a way to change the first instance to bind LDAP to only the interface that we want, but it can only be done after the instance is created, not during creation. So, since LDAP attempts to bind to all interfaces, ndsconfig checks all interfaces for port conflicts; changing the first instance to bind to only one interface now will not prevent the error. Instead, we use an unused port during the second instance creation and fix the LDAP bindings for each instance, after each is created. Then you can control which address and port will be used for each LDAP instance binding. After we create the third instance, we will change the bindings and ports accordingly.

**Third Instance in my Tree**

Adding a third instance is pretty much the same as adding the second instance:

|     |     |
| --- | --- |
| **Parameter** | **Description** |
| add | Tells ndsconfig to add a new NCP server to the tree |
| \-t labtree01 | My chosen (established) tree name |
| \-a cn=admin.ou=lab | Tree administrator fully distinguished name |
| \-S labsrv03 | NCP server object name |
| \-n ou=servers.ou=services.o=lab | NCP server object context |
| \-B 192.168.0.103 | Sets the IP Address and port to which that eDirectory will bind NCP. No port is defined, so the default port of 524 will be used |
| \-p 192.168.0.101 | Not required. But to avoid any name resolution problems, I am telling ndsconfig to contact this IP address to create the new instance. |
| \-L 2389 | This option sets the LDAP port to 2389 instead of the default of 389 (more on this later). |
| \-l 2636 | This option sets the LDAPS port to 2636 instead of the default of 636 (more on this later). |
| \-d /mnt/labsan/trees/labtree01/labsrv03 | eDirectory database file location |
| \-D /mnt/labsan/trees/labtree01/labsrv03 | Location for data files, logs, etc. |
| \--config-file /mnt/labsan/trees/labtree01/labsrv03/nds.conf | Location and name of the instance eDirectory config file |

Once again, I also want to disable the requirement for TLS for simple LDAP binds, by using the -e argument. So my final ndsconfig command is as follows:

ndsconfig add -t labtree01 -a cn=admin.o=lab -S labsrv03 -n ou=servers.ou=services.o=lab
 -B 192.168.0.103 -p 192.168.0.101 -L 2389 -l 2636
 -d /mnt/labsan/trees/labtree01/labsrv03 -D /mnt/labsan/trees/labtree01/labsrv03
 -e --config-file /mnt/labsan/trees/labtree01/labsrv03/nds.conf

**Fixing the LDAP Bindings and Ports**

An attribute on the LDAP server object called ldapInterfaces which determines which interfaces LDAP binds to. We can modify this attribute in a number of ways, including:

		LDAP (use ldapmodify, an LDIF file, etc.)
	
		ConsoleOne
	
		iManager
	

Here we will use iManager; since our ports are fine on the first instance, we need only change its bindings.

**1**. Log in to iManager and click the View Objects button near the top of page.

**2**. Browse to the container where the server was installed (in our case, servers.services.lab)

**3**. Click the LDAP server object (in our case, LDAP Server - labsrv1) and select Modify Object.

**4**. From the General Tab of the object, Click Other.

**5**. Look for the ldapInterfaces attribute. It is usually listed in the Valued Attributes column. To get around some quirks in iManager, select it and click the Delete button. The attribute will move to the Unvalued Attributes column.

**6**. Click the arrow button to move the attribute back to the Valued Attributes column.

**7**. Find the ldapInterfaces attribute and this time click Edit.

**8**. Type the IP address where you want LDAP to listen, then click OK. In our case we kept it the same as the eDirectory instance: 192.168.0.101. If you do not see a semi-colon at the end of the address, you are in good shape.

**9**. Click Apply. The change should be immediate, but to make sure the change is effective, you should refresh the LDAP server.

**10**. If you clicked Apply and not OK to change the setting, then your focus is still on the LDAP server object. If not, then browse to the LDAP server object again and click Modify Object.

**11**. From the General tab, select Information. On the Information page, click the Refresh button.

**12**. To check if your change took effect you can issue the command: "netstat -nap | grep 389" to check the bindings.

That takes care of the first instance. On our second and third instances we need to change the ldapInterfaces attribute and the LDAP TCP Port and LDAP SSL Port attributes. The process is the same as for changing the ldapInterfaces attribute, except that you can edit the port attributes without deleting and re-adding them. We use the same process to change both of the instance LDAP ports to 389 and all the LDAPS ports to 636.

After all this, I now have a tree with 3 NCP Servers in it all running on the same Linux host. Each operates the same as though it were on individual physical servers. In fact, each instance is running independently of each other and are not even aware that they are on the same host. The same is true for external applications that talk to each instance over LDAP, NCP, or any other protocols; they are just IP addresses to the applications.

However, multi-instance does change how you interact with each instance while at a terminal prompt on the host. Fortunately, the eDirectory commands are multi-instance aware and will prompt you for the instance you want to work with before executing your command. There is also a new interactive utility called ndsmanage. It lets you stop, start, and even remove instances from a host. It also has an option to create an instance, but because of the reasons noted above, you are going to want more control over each instance creation.

**Start-and-Stop Script**

There is one more thing I would like to mention. Although the utilities like ndsstat, ndsconfig, ldapconfig, and others are multi-instance aware, the start and stop scripts that control eDirectory startup and shutdown with the OS are not. So I have created a very simple script that will gracefully start and stop all the instances on a given host. It is not very complex or feature-rich, but it works and is a good place to start:

#!/bin/sh
#pfm: This script can be used as a script to start/stop ALL instances of eDir88 using ndsmanage.
\#       Add this file to /etc/init.d/ with the name ndsdall
\#   Set the execute permissions on the ndsall file
\#       Rename the normal/original S & K symbolic links in ea of the run level dirs
\#       Create new S & K symbolic links to the ndsdall script.
if \[ $1 == start \]; then
        /opt/novell/eDirectory/bin/ndsmanage startall
        #printf "\`date +'%m-%d-%Y %H:%M:%S'\` ndsdall start executed.\\n" >> /ndsd.log
fi
if \[ $1 == stop \]; then
        /opt/novell/eDirectory/bin/ndsmanage stopall
        #printf "\`date +'%m-%d-%Y %H:%M:%S'\` ndsdall stop executed.\\n" >> /ndsd.log
fi
if \[ $1 == status \]; then
        /opt/novell/eDirectory/bin/ndsmanage -a
        #printf "\`date +'%m-%d-%Y %H:%M:%S'\` ndsdall status executed.\\n" >> /ndsd.log
fi

### Multiple Trees on a Single Host

Putting multiple instances on a single host, each in a different tree, is done exactly the same way as for multiple instances in the same tree. For organization purposes, I like to keep all the instances of a given tree under the same file structure on my host system. You may have noticed that technique, back when I created the directory structure for the first tree in the previous example:

/mnt/labsan/trees/labtree01/labsrv01

So, let's build on our first example and add a second tree to the same host system by essentially following the same procedures. If I followed the same methodology, I would want three additional IP addresses to run my second tree. But this time I am going to create a tree where I do not care about standard ports or instance portability. So this time, I am going to use the same IP addresses as my first tree but with different ports. This decision will impact my ndsconfig parameters as well as some applications, more on that issue after we create our second tree.

**First Instance in My Second Tree**

To create another tree, I must have a unique tree name on my network. This time I have chosen my tree name to be devtree01. Once again I will keep the instance files on my SAN so I create a place for my tree files on my ldaplab host called:

/mnt/labsan/trees/devtree01

Under the /mnt/labsan/trees/devtree01 structure, I will create sub-directories to store my individual NCP server instances that will be running on my ldaplab host:

/mnt/labsan/trees/devtree01/devsrv01
/mnt/labsan/trees/devtree01/devsrv02
/mnt/labsan/trees/devtree01/devsrv03

Now I will create my second tree and its first NCP server. This will actually be the fourth eDirectory instance on my host system. Here are the ndsconfig command parameters that I will need:

|     |     |
| --- | --- |
| **Parameter** | **Description** |
| new | Tells ndsconfig to create a new tree |
| \-t devtree01 | My chosen tree name |
| \-a cn=admin.ou=dev | Tree administrator fully distinguished name |
| \-S devsrv01 | NCP server object name instead of the default (which would have matched the server's hostname of ldaplab). Doing this also adds to the portability of the instance I am creating. |
| \-n ou=servers.ou=services.o=dev | NCP server object context |
| \-B 192.168.0.101@1524 | Sets the IP Address and port to which eDirectory will bind NCP. We chose 1524 so that it does not conflict with our first tree. |
| \-L 1389 | This option sets the LDAP port to 1389 instead of the default of 389 (more on this later). |
| \-l 1636 | This option sets the LDAPS port to 1636 instead of the default of 636 (more on this later). |
| \-d /mnt/labsan/trees/devtree01/devsrv01 | eDirectory database file location |
| \-D /mnt/labsan/trees/devtree01/devsrv01 | Location for data files, logs, etc. |
| \--config-file /mnt/labsan/trees/devtree01/devsrv01/nds.conf | Location and name of the instance eDirectory config file |

Once again, I also want to disable the requirement for TLS for simple LDAP binds, by using the -e argument. So my final ndsconfig command is as follows:

ndsconfig new -t devtree01 -a cn=admin.o=dev -S devsrv01 -n ou=servers.ou=services.o=dev
 -B 192.168.0.101@1524 -L 1389 -l 1636 -d /mnt/labsan/trees/devtree01/devsrv01
 -D /mnt/labsan/trees/devtree01/devsrv01
 -e --config-file /mnt/labsan/trees/devtree01/devsrv01/nds.conf

Notice that the -B parameter has changed. Since I am sharing the IP addresses from my first tree with my second tree, I need unique ports. The default NCP port is 524, but I have checked my host - 1524 is available, so I will use it. I also have the same issue with my LDAP ports, so I follow the same method: I use 1389 and 1636 for my LDAP ports.

**Second Instance in my Second Tree**

Just like in the first example, I will add another instance to represent the second NCP server object in my second tree. I need to build my next ndsconfig command:

|     |     |
| --- | --- |
| **Parameter** | **Description** |
| add | Tells ndsconfig to create a new tree |
| \-t devtree01 | My chosen (and established) tree name |
| \-a cn=admin.ou=dev | Tree administrator fully distinguished name |
| \-S devsrv02 | NCP server object name instead of the default (which would have matched the server's hostname of ldaplab) |
| \-n ou=servers.ou=services.o=dev | NCP server object context |
| \-B 192.168.0.102@1524 | Sets the IP Address and port to which eDirectory will bind NCP. We chose 1524 so that it does not conflict with our first tree. |
| \-p 192.168.0.101:1524 | Not required. But to avoid any name/port resolution problems, I am telling ndsconfig to contact this IP address:port to create the new instance. |
| \-L 2389 | This option sets the LDAP port to 2389 instead of the default of 389 (more on this later). |
| \-l 2636 | This option sets the LDAPS port to 2636 instead of the default of 636 (more on this later). |
| \-d /mnt/labsan/trees/devtree01/devsrv02 | eDirectory database file location |
| \-D /mnt/labsan/trees/devtree01/devsrv02 | Location for data files, logs, etc. |
| \--config-file /mnt/labsan/trees/devtree01/devsrv02/nds.conf | Location and name of the instance eDirectory config file |

Once again, I also want to disable the requirement for TLS for simple LDAP binds, by using the -e argument. So my final ndsconfig command is as follows:

ndsconfig add -t devtree01 -a cn=admin.o=dev -S devsrv02 -n ou=servers.ou=services.o=dev
 -B 192.168.0.102@1524 -p 192.168.0.101:1524 -L 2389 -l 2636
 -d /mnt/labsan/trees/devtree01/devsrv02 -D /mnt/labsan/trees/devtree01/devsrv02
 -e --config-file /mnt/labsan/trees/devtree01/devsrv02/nds.conf

**Third Instance in my Second Tree**

Adding a third instance is pretty much the same as adding the second instance:

|     |     |
| --- | --- |
| **Parameter** | **Description** |
| add | Tells ndsconfig to create a new tree |
| \-t devtree01 | My chosen (and established) tree name |
| \-a cn=admin.ou=dev | Tree administrator fully distinguished name |
| \-S devsrv03 | NCP server object name instead of the default (which would have matched the server's hostname of ldaplab) |
| \-n ou=servers.ou=services.o=dev | NCP server object context |
| \-B 192.168.0.103@1524 | Sets the IP Address and port to which eDirectory will bind NCP. We chose 1524 so that it does not conflict with our first tree. |
| \-p 192.168.0.101:1524 | Not required. But to avoid any name/port resolution problems, I am telling ndsconfig to contact this IP address:port to create the new instance. |
| \-L 3389 | Sets the LDAP port to 3389 so that it is unique. Later, we can change this to 1389 to match the first instance in this tree. |
| \-l 3636 | Sets the LDAPS port to 3636 so that it is unique. Later, we can change this to 1636 to match the first instance in this tree. |
| \-d /mnt/labsan/trees/devtree01/devsrv03 | eDirectory database file location |
| \-D /mnt/labsan/trees/devtree01/devsrv03 | Location for data files, logs, etc. |
| \--config-file /mnt/labsan/trees/devtree01/devsrv03/nds.conf | Location and name of the instance eDirectory config file |

Once again, I also want to disable the requirement for TLS for simple LDAP binds, by using the -e argument. So my final ndsconfig command is as follows:

ndsconfig add -t devtree01 -a cn=admin.o=dev -S devsrv03 -n ou=servers.ou=services.o=dev
 -B 192.168.0.103@1524 -p 192.168.0.101:1524 -L 3389 -l 3636
 -d /mnt/labsan/trees/devtree01/devsrv03 -D /mnt/labsan/trees/devtree01/devsrv03
 -e --config-file /mnt/labsan/trees/devtree01/devsrv03/nds.conf

With our second tree built, if desired, we can go back and make changes to the LDAP bindings and ports just as we did in the first tree, so they are consistent throughout our tree.

This time I am have chosen to use non-standard ports so that I can re-use my IP addresses, but doing so may limit functionality. Now, my LDAP applications must be able to change the port that they use to talk to our eDirectory instances. Modifying my LDAP applications may not be convenient, but I checked mine and at least I know that it possible. Of course I am running the risk, albeit low, that some business unit will buy an application that will not let me change the port it uses for LDAP to be different than the standard. Although in our example I did not do this, it is better to choose custom ports in the range 49152-65535. These ports are considered "Dynamic and/or Private" so they can be safely used without IANA registration.

Also, by changing the eDirectory NCP port, I will no longer be able to use any application that is hard-coded to use NCP 524 - most notably the Novell Client and ConsoleOne. For my lab, I don't care - iManager can work with whatever NCP port I choose, and I will never have any clients connecting to this tree using NCP (although I would prefer to use port 524 in order to have more tools and utilities at my disposal). Again, this is for my lab so it is not important. I would likely make a different decision for my production environment.

### Other Considerations

Now we have two trees, each with three instances, for a total of six eDirectory instances running on a single host. Coming from a NetWare background, I think that is pretty cool. But is it smart? Once again, this is a lab environment for me, so it provides me an with an efficient use of lab equipment. Performance is not that important. Besides, even though there are multiple instances on my host, I do not have to have them all up at the same time. So if I need to bulkload a bunch of objects to one of my trees, I can always take down the other tree instances during the bulkload process.

I also have to be aware that not all applications I install on top of eDirectory are necessarily multi-instance aware or capable. So depending on your needs, multi-instance use may not be appropriate. It is best suited for situations where a so called "LDAP Directory" is called for.

**Note**:

<

To ensure that multiple instances restart automatically upon reboot of your host, check out the following TID:
Multiple eDirectory instances aren't correctly started or stopped when rebooting - TID10100947 <http://support.novell.com/cgi-bin/search/searchtid.cgi?10100947.htm>

#### Reader Comments

* Incredibly detailed and very well organized. Thanks, Paul.

[Like what you see?
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/h_link-arrow.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 
[Want to contribute?
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/h_link-arrow.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 
[Like Wikis?
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/h_link-arrow.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/20060127phone.gif]] |     | [Interested?<br>Request a sales call ![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/h_link-arrow.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/spacer.gif]]

_Novell Cool Solutions (corporate web communities) are produced by WebWise Solutions. _

[Advertising in Cool Solutions](http://www.novell.com/coolsolutions/ratecard.html)
[Talk to Us](http://www.novell.com/communities/contact)
[Submit Content](http://www.novell.com/communities/node/1394)
[Subscribe](http://www.novell.com/coolsolutions/forms/subscribe.html)
[Cool Solutions Home (New)](http://www.novell.com/communities/coolsolutions)
[Classic Cool Solutions Home](http://www.novell.com/coolsolutions/index.html)
[Authors](http://www.novell.com/coolsolutions/author)
[Cool Blogs](http://www.novell.com/communities/coolblogs)
[Cool Solutions Wiki](http://wiki.novell.com/)
[Cool Tools](http://www.novell.com/communities/coolsolutions/tools)
Get Involved  _\>_
[Open Audio (podcasts)](http://www.novell.com/company/podcasts/openaudio.html)

* **1.800.529.3400** [local numbers](http://www.novell.com/company/contact.html?sourceid=lbanner_contact)
* [Request Call](http://www.novell.com/company/sales_call_request.jsp?sourceidint=lbanner_sc)

[Novell® Making IT Work As One™](http://www.novell.com/company/strategy.html)

* [Careers](http://www.novell.com/company/careers/index.html)
* [Contact Us](http://www.novell.com/company/contacts-offices)
* [Feedback](http://www.novell.com/inc/feedback/feedback.jsp)
* [Legal](http://www.novell.com/company/legal)
* 

© 2009 Novell, Inc. All Rights Reserved.

![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/0.gif]]
![[./_resources/Cool_Solutions_eDirectory_8.8_Multiple_Instances.resources/search-hl=en-26client=firefox-a-26rls=org.mozilla%3Aen-US%3Aofficial%26q=edirectory+multiple+trees+same+server+don%27t+start+up%26aq=f%26oq=%26aqi=&tzo=420&ms=55]]
