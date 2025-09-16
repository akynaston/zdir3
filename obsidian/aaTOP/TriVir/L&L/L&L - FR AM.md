6/12/2024 11:34:05 AM
Chir shelping

each will have systemd script

three compoents for AM
config
userstore
cts store - auth tokens

systemctl status ds-config.service (not ds-config1 and 2, keep consistent instead.)

pefixed all ports with 1 on am1, 2 on am2.

replicatoin works between am1 am2

on server:
/opt/forgerock/ds-config
looking at bin

running command - las tpage
![[ForgeRock Accreditation L&L.pdf]]



./dsrepl status --hostname ds-config2 --port 1444 --bindDN "uid=admin" --bindPassword 'TriVir#1' --trustAll

See "dsrepl --help" to get more usage help

bash: TriVir#1: command not found...
[root@am1 bin]# 'TriVir#1' --trustAll^C
[root@am1 bin]# ./dsrepl status --hostname ds-config2 --port 1444 --bindDN "uid=admin" --bindPassword 'TriVir#1' --trustAll
Base DN       Status  Receive     Replay
                      delay (ms)  delay (ms)
--------------------------------------------
ou=am-config  GOOD             0           0
uid=Monitor   GOOD             0           0
cn=schema     GOOD             0           0
[root@am1 bin]#


Good! Checked ds-config1

side note: geographic - 2 and 2 in 2 different ports.
rep servers handling replicas . .

6/12/2024 11:59:42 AM
Jeremiah now



9/11/2024 12:03:02 PM





9/18/2024 12:06:01 PM
L&L - Sep 18
Realms discussion - can have multiple realms
 - can use this for divisions: e.g.: employees vs customers 
 - example of creating a new realm.
 - can be active/disabled: can't be used if disabled.
 - can also include oauth client to a specific realm . .(brian)
 - can give realm alias & dns alias
 - members realm has a dns alias . .
 - creating 'parent' realm example.
 - client side sessions: JWT  has all the info
 - now seein realm overview - 'realm dahsboard'
 - showing realm dashboard - going down left menu
 - identities, identity stores, sciprts, 
 - secret stores - hen we setup AM - copied global system am secret stores; can hve different secret stores per realm.
 - sessions - can see server side sessions here
 - STS - secure token service
	- can transform tokens: am session - can receive SAML asertion, oauthid token . .in accrditation - take token, conert to saml . .etc . .
 - People ralm.
 - now adding an identity store
 - new identity store:
	 - picking name - he said userstore
	 - differen options
	 - select OpenDJ
	 - big page with lots of info - now typingin gin:
		dsconfig1.dev.trivir.com:1636
	 - review of all settings - about two dozen
 - all this gets reate din foncifg store.
 - next tab: plugin confguatin
	 - ldapv3 - djldapv3repo
	 - show some supported types and operations
	 - can select only read for a read only user store.
 - next tab: user configuration
 - talking about custom use type
	 - auth directory: only auth info at afcu. 
 - next tabl: authenticatoin confugration
	 - naming attibute - uid for now.
 - nxt tab group configuratin
	 - persistent searches
 - next tabl: ' just an arrow
	 - has in dropdown: persistent search control, eror handling config,a nd cache control
 - can click on save changes in cache area, and get it to reload attrs on pages. (huston commented this)
 - deploymen t-> servers:
	 - can get url to get eployment id
 - in userstore - only use uid -am-idenit-bind .  don't use admin
	 - password - whever ou set . .
	 - amidentity-bind-account
 -enable affinity
 - mTLS - not sure (mutual tls) not doing
 - then last test created new identity, and can populate attrs.
 

9/25/2024 1:11:05 PM
fixed servers, now with Carl
![[Pasted image 20240925131109.png]]

now create new identity store
 - best name: identitystore1, deleting existin gone:
- ![[Pasted image 20240925131306.png]]
![[Pasted image 20240925131356.png]]