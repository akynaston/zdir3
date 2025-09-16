# riaschissl: oracle: unexpire and unlock accounts [riaschissl.blogspot.com]

# [riaschissl](http://riaschissl.blogspot.com/)

weird stuff for a weird world

## Monday, July 5, 2010

### oracle: unexpire and unlock accounts

Some of our customers' applications are built around Oracle, so we have to fight the beast from time to time. Unfortunately, some of the surprizes the beast has to offer are quite random and rare, and due to this we tend to simply forget how we fixed and/or circumvented the issues previously.
As usual, google is your friend and one of the most valuable resources on the net we've found is [www.orafaq.com](http://www.orafaq.com/) and most notably its [security FAQs 1](http://www.orafaq.com/wiki/Oracle_database_Security_FAQ)
So this is just an attempt of a small cheat sheat to help our overloaded brains :-)

* _become database admin_
	First log into your host running oracle and become the oracle user.
	% sqlplus /nolog
	SQL> connect / as SYSDBA
	Connected
	SQL>

* _find out which accounts are expired_
	select username, account\_status from dba\_users where ACCOUNT\_STATUS LIKE '%EXPIRED%';
* _unexpire an account_
	once an account has been expired, it can only be revived by assigning it a new password:
	ALTER USER scott IDENTIFIED BY password;
	
* _unlock an account_
	ALTER USER scott ACCOUNT UNLOCK;
* _disable default password expiry [2](http://www.odi.ch/weblog/posting.php?posting=520)_
	this all depends on the profile a user belongs to, to disable password expiry for all users assigned the default user profile do this:
	ALTER PROFILE DEFAULT LIMIT PASSWORD\_LIFE\_TIME UNLIMITED;
	

1. unexpire and unlock the account as explained above

* % emctl stop dbconsole
* change into
	ORACLE\_HOME/<HostName\_SID>/sysman/config, for us this would be for example:
	% cd /opt/oracle/111/klotho\_ABSDEV/sysman/config
* edit the emoms.properties file
	and change the oracle.sysman.eml.mntr.emdRepPwd property to the new password you gave the SYSMAN user.
	Then change the oracle.sysman.eml.mntr.emdRepPwdEncrypted property from TRUE to FALSE (sidenote: Oracle will revert to TRUE automagically once it is restarted).
* change into
	ORACLE\_HOME/<HostName\_SID>/sysman/emd, for us this would be for example:
	% cd /opt/oracle/111/klotho\_ABSDEV/sysman/emd
* edit the target.xml file
	and edit those two properties:
	<Property NAME="UserName" VALUE="SYSMAN" ENCRYPTED="FALSE"/>
	<Property NAME="password" VALUE="TheNewPassword" ENCRYPTED="FALSE"/>
* % emctl start dbconsole
* under "normal" circumstances, everything should be fine now :-)

So, as said above this is just a "small" cheat sheet for some annoyances we have met with the great oracle, of course there is much much more to know about the beast ;-)
\[1\] <http://www.orafaq.com/wiki/Oracle_database_Security_FAQ>
\[2\] <http://www.odi.ch/weblog/posting.php?posting=520>
\[3\] <http://www.articles.freemegazone.com/oracle-sysman-account-locked.php?ref=2>

Eingestellt von [Udo Rader](https://plus.google.com/109885454698481378319) um [12:17 PM](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.html)
[Email This](http://www.blogger.com/share-post.g?blogID=8977568433763795206&postID=1230479952876353736&target=email)[BlogThis!](http://www.blogger.com/share-post.g?blogID=8977568433763795206&postID=1230479952876353736&target=blog)[Share to Twitter](http://www.blogger.com/share-post.g?blogID=8977568433763795206&postID=1230479952876353736&target=twitter)[Share to Facebook](http://www.blogger.com/share-post.g?blogID=8977568433763795206&postID=1230479952876353736&target=facebook)[Share to Pinterest](http://www.blogger.com/share-post.g?blogID=8977568433763795206&postID=1230479952876353736&target=pinterest)

Labels: [oracle](http://riaschissl.blogspot.com/search/label/oracle), [sysadmin](http://riaschissl.blogspot.com/search/label/sysadmin)

#### 4 comments:

1. ![[./_resources/riaschissl_oracle_unexpire_and_unlock_accounts_riaschissl.blogspot.com.resources/anon36.png]]
	
	Anonymous[May 14, 2012 at 8:38 AM](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.html?showComment=1336977517053#c8667927610927694628)
	
	You could do that if you need the new password to be different or the following seems to be a lot easier and I did it straight from toad...
	Logon as valid sysdba user thats not locked
	\--verfiy account is expired
	select username, account\_status from dba\_users order by username;
	ALTER USER SYSMAN IDENTIFIED BY pickNewPassword;
	ALTER USER SYSMAN ACCOUNT UNLOCK;
	\--make sure its now unlocked
	select username, account\_status from dba\_users where username = 'SYSMAN';
	ALTER USER SYSMAN IDENTIFIED BY PutYourOldPasswordBack;
	This way to don't have to fuss with all the other steps to establish new password.
	
	[Reply](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:;)
	
	[Replies](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:;)
	
	* ![[./_resources/riaschissl_oracle_unexpire_and_unlock_accounts_riaschissl.blogspot.com.resources/anon36.png]]
		
		LynC[July 3, 2012 at 4:35 AM](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.html?showComment=1341282930651#c866300327222168372)
		
		That still leaves the account with an expiry date. i.e. it does not do the job.
		
	* ![[./_resources/riaschissl_oracle_unexpire_and_unlock_accounts_riaschissl.blogspot.com.resources/b36-rounded.png]]
		
		[Amby](http://www.blogger.com/profile/10607047882209273565)[June 1, 2013 at 10:31 AM](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.html?showComment=1370075462860#c6279665004793572760)
		
		To make the account not have an expiry date create a new profile that sets the PASSWORD\_LIFE\_TIME to UNLIMITED i.e.
		CREATE PROFILE TEST\_PRF LIMIT
		COMPOSITE\_LIMIT UNLIMITED
		SESSIONS\_PER\_USER UNLIMITED
		CPU\_PER\_SESSION UNLIMITED
		CPU\_PER\_CALL UNLIMITED
		LOGICAL\_READS\_PER\_SESSION UNLIMITED
		LOGICAL\_READS\_PER\_CALL UNLIMITED
		IDLE\_TIME UNLIMITED
		CONNECT\_TIME UNLIMITED
		PRIVATE\_SGA UNLIMITED
		FAILED\_LOGIN\_ATTEMPTS UNLIMITED
		PASSWORD\_LIFE\_TIME UNLIMITED
		PASSWORD\_REUSE\_TIME UNLIMITED
		PASSWORD\_REUSE\_MAX UNLIMITED
		PASSWORD\_VERIFY\_FUNCTION NULL
		PASSWORD\_LOCK\_TIME UNLIMITED
		PASSWORD\_GRACE\_TIME UNLIMITED;
		Modify the user account to use the new profile:
		ALTER USER MYUSER PROFILE TEST\_PRF;
		This way the password will never expire for the users that uses this profile
		
	[Reply](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:;)
	
2. ![[./_resources/riaschissl_oracle_unexpire_and_unlock_accounts_riaschissl.blogspot.com.resources/b36-rounded.png]]
	
	[valiantvimal](http://www.blogger.com/profile/09925725191033973521)[September 24, 2013 at 10:22 AM](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.html?showComment=1380010971483#c5377640472931884771)
	
	Thank you bro..I learned about password expiry and its solution from here..thanks for sharing.
	Regards,
	Vimal.
	
	[Reply](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:;)
	

[Load more...](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:;)

<https://www.blogger.com/comment-iframe.g?blogID=8977568433763795206&postID=1230479952876353736&blogspotRpcToken=1298992>

#### Links zu diesem Post

[Create a Link](http://www.blogger.com/blog-this.g)

[Newer Post](http://riaschissl.blogspot.com/2010/10/bsd-vs-linux-or-what-to-do-when-your.html) [Older Post](http://riaschissl.blogspot.com/2010/06/google-chrome-or-chromium-and-ssl.html) [Home](http://riaschissl.blogspot.com/)

Subscribe to: [Post Comments (Atom)](http://riaschissl.blogspot.com/feeds/1230479952876353736/comments/default)

## Google+ Badge

## Pages

* [the it](http://riaschissl.blogspot.com/)

* [about my company](http://riaschissl.blogspot.com/p/about-my-company.html)
* [about me](https://plus.google.com/+UdoRader/)

## Labels

[about](http://riaschissl.blogspot.com/search/label/about) [blackberry](http://riaschissl.blogspot.com/search/label/blackberry) [development](http://riaschissl.blogspot.com/search/label/development) [fedora](http://riaschissl.blogspot.com/search/label/fedora) [javascript](http://riaschissl.blogspot.com/search/label/javascript) [kvm](http://riaschissl.blogspot.com/search/label/kvm) [mandriva](http://riaschissl.blogspot.com/search/label/mandriva) [openssl](http://riaschissl.blogspot.com/search/label/openssl) [oracle](http://riaschissl.blogspot.com/search/label/oracle) [passphrase](http://riaschissl.blogspot.com/search/label/passphrase) [prism](http://riaschissl.blogspot.com/search/label/prism) [privacy](http://riaschissl.blogspot.com/search/label/privacy) [RAID](http://riaschissl.blogspot.com/search/label/RAID) [SATA](http://riaschissl.blogspot.com/search/label/SATA) [security](http://riaschissl.blogspot.com/search/label/security) [shell](http://riaschissl.blogspot.com/search/label/shell) [subversion](http://riaschissl.blogspot.com/search/label/subversion) [sysadmin](http://riaschissl.blogspot.com/search/label/sysadmin) [thunderbird](http://riaschissl.blogspot.com/search/label/thunderbird) [tor](http://riaschissl.blogspot.com/search/label/tor) [torbutton](http://riaschissl.blogspot.com/search/label/torbutton) [virtualbox](http://riaschissl.blogspot.com/search/label/virtualbox) [virtualization](http://riaschissl.blogspot.com/search/label/virtualization) [web](http://riaschissl.blogspot.com/search/label/web) [x509](http://riaschissl.blogspot.com/search/label/x509)

## Blog Archive

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [2014](http://riaschissl.blogspot.com/search?updated-min=2014-01-01T00:00:00%2B01:00&updated-max=2015-01-01T00:00:00%2B01:00&max-results=4) (4)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [2013](http://riaschissl.blogspot.com/search?updated-min=2013-01-01T00:00:00%2B01:00&updated-max=2014-01-01T00:00:00%2B01:00&max-results=3) (3)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [2012](http://riaschissl.blogspot.com/search?updated-min=2012-01-01T00:00:00%2B01:00&updated-max=2013-01-01T00:00:00%2B01:00&max-results=4) (4)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [2011](http://riaschissl.blogspot.com/search?updated-min=2011-01-01T00:00:00%2B01:00&updated-max=2012-01-01T00:00:00%2B01:00&max-results=1) (1)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [October](http://riaschissl.blogspot.com/2010_10_01_archive.html) (1)

* [oracle: unexpire and unlock accounts](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.html)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [June](http://riaschissl.blogspot.com/2010_06_01_archive.html) (1)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [May](http://riaschissl.blogspot.com/2010_05_01_archive.html) (1)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [March](http://riaschissl.blogspot.com/2010_03_01_archive.html) (1)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [February](http://riaschissl.blogspot.com/2010_02_01_archive.html) (2)

* [►](http://riaschissl.blogspot.com/2010/07/oracle-unexpire-and-unlock-accounts.htmljavascript:void(0))  [2009](http://riaschissl.blogspot.com/search?updated-min=2009-01-01T00:00:00%2B01:00&updated-max=2010-01-01T00:00:00%2B01:00&max-results=30) (30)

|     |     |
| --- | --- |
|     | ## pints of interest<br><br>* [http://www.bestsolution.at](http://www.bestsolution.at/)<br><br>* <http://tomsondev.bestsolution.at/><br>* [http://www.efxclipse.org](http://www.efxclipse.org/)<br>* [http://www.worldcommunitygrid.org](http://www.worldcommunitygrid.org/)<br>* <http://www.europeana.eu/> |

## Subscribe To

  ![[./_resources/riaschissl_oracle_unexpire_and_unlock_accounts_riaschissl.blogspot.com.resources/arrow_dropdown.gif]] ![[./_resources/riaschissl_oracle_unexpire_and_unlock_accounts_riaschissl.blogspot.com.resources/icon_feed12.png]] Posts

  ![[./_resources/riaschissl_oracle_unexpire_and_unlock_accounts_riaschissl.blogspot.com.resources/arrow_dropdown.gif]] ![[./_resources/riaschissl_oracle_unexpire_and_unlock_accounts_riaschissl.blogspot.com.resources/icon_feed12.png]] Comments

|     |     |
| --- | --- |
|     |     |

Awesome Inc. template. Template images by [claylib](http://www.istockphoto.com/googleimages.php?id=2257912&platform=blogger&langregion=en). Powered by [Blogger](http://www.blogger.com/).
