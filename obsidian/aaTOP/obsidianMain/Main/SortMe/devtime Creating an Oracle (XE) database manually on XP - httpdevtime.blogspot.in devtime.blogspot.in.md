# devtime: Creating an Oracle (XE) database manually on XP - http://devtime.blogspot.in/ [devtime.blogspot.in]

# [devtime](http://devtime.blogspot.in/)

## Friday, January 27, 2006

### Creating an Oracle (XE) database manually on XP

There are two ways for creating an Oracle database, one is using Oracle Database Configuration Assistant and the other is manually, I'll provide a small step by step guide for the latter on windows XP.
This are the main steps:
1\. Create the directory structure
2\. Declare an oracle SID name.
3\. Create a windows service and password file
4\. Create the init.ora file
5\. Start the instance in nomount mode
6\. Use the Create database command
7\. Create Data Dictionary
1\. Create the directory structure
Under the admin directory (C:\\oraclexe\\app\\oracle\\admin\\) we have to create the structure for the new database (this is called OFA Oracle Flexible Arquitecture), the directory is called oraXE which will be the name of the database, and the directories adump, bdump, cdump, dpdump, pfile, udump are created in it:
[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/oraStructure_r1_c1.jpg]]](http://photos1.blogger.com/blogger/5893/1902/1600/oraStructure_r1_c1.jpg)
2\. Declare an oracle SID name.
Using the this command we declare the variable for oracle SID. Since could be more than one oracle instance running, oracle uses the SID to difference them.

    set ORACLE_SID=oraXE

3\. Create a windows service and password file
Every instance on windows requires a windows service which can be created using oradim tool, the created service can be checked in the services list: type services.msc in the console or a link can be found in the control panel -> admin tools -> Services. Also a password file is created under database directory (ORACLE\_HOME\\database) with the SID embedded in the name (PWDoraXE.ora), this password file is used to authenticate the DBA before starting an instance.

    oradim -new -sid %ORACLE_SID% -intpwd passwordhere -startmode M

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/passwd_r1_c1.jpg]]](http://photos1.blogger.com/blogger/5893/1902/1600/passwd_r1_c1.jpg)
Important : Remember to stop the default service for the "XE" database which is called "OracleServiceXE" and start the service just created "OracleServiceoraXE" for our new database in the services console.
4\. Create the init.ora file
Open a text editor, add the lines below and save it as initoraXE.ora in C:\\oraclexe\\app\\oracle\\admin\\oraXE\\pfile\\. This are just some basic initial parameters, the ones that are not specified are taken by default.

    control_files = (C:\oraclexe\oradata\oraXE\control01.ctl,C:\oraclexe\oradata\oraXE\control02.ctl,C:\oraclexe\oradata\oraXE\control03.ctl)undo_management = autodb_name         = oraXEdb_block_size       = 8192

control\_files : Here we define where will be our control files, those are used for store management information of the database like location of the datafiles, timestamp of the creation of the database,etc. In this case there are three files copies, its recommended to store each copy on different physical disk which is called multiplexing.
undo\_management: this parameter is used for choosing between automatic undo management (AUTO) or manually undo management (MANUAL, this is the default) in the latter is needed to create , size and monitor closely undo (rollback) segments, it's recommended to be set to AUTO.
db\_name : The database name must be the same used in the create statement.
db\_block\_size : The default or standard database block size, this is the mininal logical unit of storage in oracle this should be a multiple of the operating system block size.
5\. Start the instance in nomount mode
Before you try to connect to start the instance check that you have the right ORACLE\_SID:
`  echo %ORACLE_SID% oraXE  `
You can now authenticate through the operating system (no login or password) to start up the database, like this:

    sqlplus /nologsql>connect / as sysdbasql>startup nomount pfile=C:\oraclexe\app\oracle\admin\oraXE\pfile\initoraXE.oraORACLE instance started.Total System Global Area  113246208 bytesFixed Size                  1246556 bytesVariable Size              58722980 bytesDatabase Buffers           50331648 bytesRedo Buffers                2945024 bytes

sqlplus /nolog : start the sqlplus client , the "/nolog" is to not be prompted for username/password.
connect / as sysdba : authenticate through the operating system with sysdba privileges. If you don't have the right ORACLE\_SID ("oraXE") you may get an "ORA-12560: TNS:protocol adapter error".
startup nomount... : we must startup the db in nomount mode because at this point there a no database (physical files) to mount. The pfile that created in step 4 (C:\\oraclexe\\app\\oracle\\admin\\oraXE\\pfile\\initoraXE.ora) must be specified otherwise it will look for the default location. If you get a ORA-01081 error is because probably the "XE" database is already started and you can't have two databases mounted at the same time, so first shutdown the running database using the shutdown command.
6\. Use the Create database command
With this command we create the database:

    

7\. Create Data Dictionary
Finally, the scripts for creating the data dictionary are under ORACLE\_HOME\\rdbms\\admin.
Run:

    

? this will be replaced by the value of $ORACLE\_HOME
catalog.sql creates the data dictionary views.
catproc.sql creates the dictionary items necessary for PL/SQL functionality.

Posted by [carlos](http://www.blogger.com/profile/15934070138187932218) at [6:47 AM](http://devtime.blogspot.in/2006/01/creating-oracle-xe-database-manually.html)
[Email This](http://www.blogger.com/share-post.g?blogID=19309483&postID=113837344759882620&target=email)[BlogThis!](http://www.blogger.com/share-post.g?blogID=19309483&postID=113837344759882620&target=blog)[Share to Twitter](http://www.blogger.com/share-post.g?blogID=19309483&postID=113837344759882620&target=twitter)[Share to Facebook](http://www.blogger.com/share-post.g?blogID=19309483&postID=113837344759882620&target=facebook)[Share to Pinterest](http://www.blogger.com/share-post.g?blogID=19309483&postID=113837344759882620&target=pinterest)

#### 47 comments:

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

Hi,
thank you for this article that has made complicated things simple for me. However, to make DB creation possible, it's necessary to allow all tablespaces to grow: the temp tablespace grows to 14 MB during the execution of catproc.sql on Oracle XE 10.2.0.1.0. The undo tablespace would or would not extend later, depending on application. So the last part of the 'create database' command should be changed to something like this:
undo tablespace undo
datafile 'C:\\oraclexe\\oradata\\oraXE\\undo.dbf'
size 10M
autoextend on
next 5M maxsize 100M
default temporary tablespace temp
tempfile 'C:\\oraclexe\\oradata\\oraXE\\temp.dbf'
size 10M
autoextend on
next 5M maxsize 100M;
Mirko Sebart

[1:17 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1142327820000#c114232784725011140)

[![[]]](http://www.blogger.com/profile/11826191899902022198)
[carlos mafla](http://www.blogger.com/profile/11826191899902022198) said...

Hi Mirko
You're right , actually i forgot to mention that this database was not
intended to be used by any real application just for testing purposes, so the values in the sizes
are aleatory and very small to not use many hard disk space, when i wrote the post i didn't run
the dictionary scripts (you got me :P). The 10M of temporary tablespace would be out of space with practically
any sort without the autoextent on clause as you mention. I'm gonna make the corrections.
Thanks

[9:05 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1142399100000#c114239914659483239)

[![[]]](http://www.blogger.com/profile/11826191899902022198)
[carlos mafla](http://www.blogger.com/profile/11826191899902022198) said...

After recreating the database without 'autoextend on' on the temporary tablespace and running catproc.sql the mentioned error is raised:
BEGIN
\*
ERROR at line 1:
ORA-01652: unable to extend temp segment by 256 in tablespace TEMP
ORA-06512: at "SYS.DBMS\_STATS", line 13210
ORA-06512: at "SYS.DBMS\_STATS", line 13517
ORA-06512: at "SYS.DBMS\_STATS", line 15859
ORA-06512: at "SYS.DBMS\_STATS", line 15901
ORA-06512: at line 1
ORA-06512: at "SYS.DBMS\_REGISTRY", line 585
ORA-06512: at "SYS.DBMS\_REGISTRY", line 664
ORA-06512: at line 4
This error si solved adding the 'autoextend on' to the temporary tablespace (at least when
running the script).
Also maybe someone else experience this other problem:
I got a lot of ORA-00604 and ORA-04031 while running catalog.sql :
ORA-00604: error occurred at recursive SQL level 2
ORA-04031: unable to allocate 4108 bytes of shared memory ("shared
pool","select inst\_id, plw...","Typecheck","seg:kggfaAllocSeg")
Seems like by default oracle allocates 32M of shared\_pool\_size:
SQL> show parameters shared%
NAME TYPE VALUE
\------------------------------------ ----------- ------------------------------
hi\_shared\_memory\_address integer 0
max\_shared\_servers integer
shared\_memory\_address integer 0
shared\_pool\_reserved\_size big integer 1677721
shared\_pool\_size big integer 32M
shared\_server\_sessions integer
shared\_servers integer 0
and its not enough to load the whole script. I increased the value to 64M in the initialization parameters and the scripts then ran without any error.

[2:44 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1142635440000#c114263546066685724)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

Hello,
it's strange but my DB seems to behave in a different way. I actually \*reduced\* the SGA and PGA sizes right after the installation through the web interface because I wasn't happy with the huge amount of RAM consumed by Oracle on my 256MB machine. So, SGA target can safely go down from 140MB to 80MB. Reducing it further to 72MB provokes the same error as you mentioned, and 60MB crashes the database so thoroughly that it won't even execute "startup nomount" again. The PGA aggregate target can go down from 16MB to 10MB.
Parts of the SGA, including shared pool, are managed automatically by default; if you set their sizes, you actualy set minimum sizes. In my case, Oracle reserved 48MB (out of 80MB SGA) for the shared pool.
It's too bad that no useful DBA documentation is provided with the XE and one needs to read the "real" 10g documentation, hoping that details we're discussing here work the same way on XE.
Mirko Sebart

[12:10 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1143447000000#c114344703539558815)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...
_This comment has been removed by a blog administrator._
[10:20 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1148016000000#c114801603041022930)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

Super color scheme, I like it! Keep up the good work. Thanks for sharing this wonderful site with us.
[»](http://4135.acroweb.info/)

[10:35 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1148016900000#c114801692958263566)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...
_This comment has been removed by a blog administrator._
[1:55 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1149929700000#c114992974737657784)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...
_This comment has been removed by a blog administrator._
[3:51 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1153522260000#c115352229485884603)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
John said...

Thanks for this solutions. I created my new database on Oracle XE, but now I have problem with connected to it. Start listener service and my new DB service, but I alwey connect to XE database... How can I connect to my new database (from sqlplus and web)?

[4:13 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1160694780000#c116069478482778792)

[![[]]](http://www.blogger.com/profile/11826191899902022198)
[carlos mafla](http://www.blogger.com/profile/11826191899902022198) said...

Hi john,
You may have not defined the SID environment variable or/and you have the XE service started. First, check the actual value of your SID:
c:>echo %ORACLE\_XE%,
It should print the name you set, i.e. "OraXE", but not "XE".
Additionally, check your list of services to make sure that you only have one service running which is the one that you created, not the Service to connect to the "XE" db wich is started by default and should be stopped to connect to another db. It can create conflicts when you have more than one process listening.
I hope it helps, bye.

[8:42 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1160754120000#c116075412203342155)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

please tell me which username / password must I use to connect ot the newly created database

[5:18 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1161001080000#c116100111053523506)

[![[]]](http://www.blogger.com/profile/11826191899902022198)
[carlos mafla](http://www.blogger.com/profile/11826191899902022198) said...

You can connect authenticating with the operating system user:
In a dos window type:
c:> sqlplus /nolog
That will open sqlplus and when you are in sqlplus type:
SQL> connect / as sysdba
If the db is no started type :
startup pfile=C:\\oraclexe\\app\\oracle\\admin\\oraXE\\pfile\\initoraXE.ora

[2:27 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1161206820000#c116120687988867430)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

after the step:
"connect /as sysdba"
i got error:
ORA-12560: TNS:protocol adapter error
i don't know why ;(((
please help ;)

[12:41 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1162327260000#c116232731646486825)

[![[]]](http://www.blogger.com/profile/11826191899902022198)
[carlos mafla](http://www.blogger.com/profile/11826191899902022198) said...

First check that your ORACLE\_SID is correct. For example, if you want to connect to a database named "oraXE" you should set your ORACLE\_SID to "oraXE":
c:\\>set ORACLE\_SID=oraXE
Otherwise, you will get:
SQL> connect / as sysdba
ERROR:
ORA-12560: TNS:error del adaptador de protocolo
Also check that the service for the database is running, remember it must be the service for the database name that you have in the ORACLE\_SID .
Hope it helps...

[10:50 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1162407000000#c116240703592510762)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
mnemotronic AT-SIGN netscape.net said...

Thx for this guide. Here are some observations as I work through it:
I didn't install XE into the default location (C:\\oraclexe) but discovered right away that the Oracle XE install path can't include SPACE chars (flashback to DOS 3.1 days!), so I used "C:\\progra~1\\Oracle\\XE" (I had previously installed Oracle 9i ODBC into "C:\\progra~1\\Oracle"). The install went ok. Using your guide (**SUGGESTION:** Allow for a "your OracleXE install directory" instead of assuming "C:\\oraclexe"), I created a directory structure for a new database "OraXE-TmTrk" instead of "OraXE" (**SUGGESTION:** Warn about the connections between desired database name, dir name, SID name, pfile name, pfile db\_name, init.ora file name, etc). Your instructions say something about a password file being created under the database directory, but doesn't state explicitly if the system or user does this.
After getting several steps down, I discovered another DOS limitation - no names longer than 8 chars! (**SUGGESTION:** Warn users about this). Another problem was that the pfile param in "startup nomount" needed quotes around it : 'startup nomount pfile="C:\\...etc..." '. I changed the name to "OraXEtt" (assuming that the "-" would cause Oracle to blow it's stack at some point) and renamed/modified the dir, pfile, db\_name, and ORACLE\_SID, deleted the OraXe-TmTrk SID ("oradim -delete -SID OraXE-TmTrk") and created a new one. The instance started with numbers similiar to yours. The "create database" returned a control file error - I had a typo in my "initOraXEtt.ora" file. I corrected that by still had a problem. I had to shutdown the instance and restart it to get it to re-read the ".ora" file. After that, the db was successfully created, but the "create database" command is **very** confusing - Apparently I have to enter all those lines, not just the first. And after entering just the first line, it would be nice to know how to undo that. I eventually entered enough combinations of abort / shutdown / drop / mount / exclusive / restrict where I got something to happen.
Creating the data dictionary spews about a billion lines. It might be a good idea to have the user confirm the ORACLE\_HOME environment var \*BEFORE\* running those 2 commands. The operation eventually stopped with this:
\----
CREATE OR REPLACE PACKAGE utl\_raw IS
\*
ERROR at line 1:
ORA-06554: package DBMS\_STANDARD must be created before using PL/SQL
ERROR:
ORA-00942: table or view does not exist
.
.
\*
ERROR at line 1:
ORA-06553: PLS-213: package STANDARD not accessible
\----
ah well, that was fun. Now where is the "uninstall"....

[8:29 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1164644940000#c116464496762423962)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]](http://www.blogger.com/profile/11826191899902022198)
[carlos mafla](http://www.blogger.com/profile/11826191899902022198) said...

Hi mnemotronic thanks a lot for your suggestions.
_I didn't install XE into the default location (C:\\oraclexe) but discovered right away that the Oracle XE install path can't include SPACE chars (flashback to DOS 3.1 days!), so I used "C:\\progra~1\\Oracle\\XE" (I had previously installed Oracle 9i ODBC into "C:\\progra~1\\Oracle"). The install went ok. Using your guide (SUGGESTION: Allow for a "your OracleXE install directory" instead of assuming "C:\\oraclexe"),_
\* The idea with "static names" was to try to make easier to follow the instructions and to have just one name to reference and less variables to deal with. This is just one way to create the database, and if you make little changes maybe you end up with different results as you figured out. The steps where intended to be very basic focusing on the main goal that was just to create the database with very basic instructions.
_I created a directory structure for a new database "OraXE-TmTrk" instead of "OraXE" (SUGGESTION: Warn about the connections between desired database name, dir name, SID name, pfile name, pfile db\_name, init.ora file name, etc)._
\* Ok, that´s one of the reasons why I used a particular name. I think is clear that the database name and SID should be the same (I commented that in the step 4), and that's the most important thing. You can name the init.ora file and dir name as you want (but you shouldn't do that as good practice), and the pfile is created based on the SID that you set in the shell.
_Your instructions say something about a password file being created under the database directory, but doesn't state explicitly if the system or user does this._
\* The password file is created after running the 'oradim' command. You can check the image in the step 3, it shows the file in the bottom left corner 'PWDoraXE.ora'
_After getting several steps down, I discovered another DOS limitation - no names longer than 8 chars! (SUGGESTION: Warn users about this). Another problem was that the pfile param in "startup nomount" needed quotes around it : 'startup nomount pfile="C:\\...etc..." '. I changed the name to "OraXEtt" (assuming that the "-" would cause Oracle to blow it's stack at some point) and renamed/modified the dir, pfile, db\_name, and ORACLE\_SID, deleted the OraXe-TmTrk SID ("oradim -delete -SID OraXE-TmTrk") and created a new one. The instance started with numbers similiar to yours. The "create database" returned a control file error - I had a typo in my "initOraXEtt.ora" file. I corrected that by still had a problem. I had to shutdown the instance and restart it to get it to re-read the ".ora" file. After that, the db was successfully created, but the "create database" command is very confusing - Apparently I have to enter all those lines, not just the first. And after entering just the first line, it would be nice to know how to undo that._
\* Yes, I now that the create command has a lot of lines and can be very confusing, the idea was that anyone could copy and paste it in SQL\*Plus. There are a lot topics that are not covered here like tablespaces, group files, etc. The lines you enter in SQL\*Plus are kept in the sql buffer , you can use the 'edit' command to edit the buffer, use the 'change' command to change a line of the buffer or just 'clear buffer' command and start over, when is a small sql command I often just send the command to the server (with ;) without taking care of the errors and start over.
Tx again.
Carlos Mafla

[2:33 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1165789980000#c116579002414587183)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
oguzu said...

Hi
Thanks for cool solution.This article got me a key of understanding oracle basic architecture.
And I have one question.
When Runninng below command, I saw some "ORA-04031" error messages.
@?\\rdbms\\admin\\catproc.sql
after creating database, I can create new tables on newly database,so I seemed to do well.
Can I egnore those error messages when run that command after creating database?

[5:16 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1170983760000#c117098378481456296)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]](http://www.blogger.com/profile/11826191899902022198)
[carlos mafla](http://www.blogger.com/profile/11826191899902022198) said...

I had this same issue before (I also posted this before) , I got a lot of ORA-00604 and ORA-04031 while running catalog.sql :
ORA-00604: error occurred at recursive SQL level 2
ORA-04031: unable to allocate 4108 bytes of shared memory ("shared
pool","select inst\_id, plw...","Typecheck","seg:kggfaAllocSeg")
It Seems like by default oracle allocates 32M of shared\_pool\_size:
SQL> show parameters shared%
NAME TYPE VALUE
\------------------------------------ ----------- ------------------------------
hi\_shared\_memory\_address integer 0
max\_shared\_servers integer
shared\_memory\_address integer 0
shared\_pool\_reserved\_size big integer 1677721
shared\_pool\_size big integer 32M
shared\_server\_sessions integer
shared\_servers integer 0
and it's not enough to load the whole script. I increased the value to 64M in the initialization parameters and the scripts then ran without any error.

[7:10 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1171293000000#c117129300096498101)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

Hi all,
I have tried what you wrote for creating database. I could create my own database. However, I just did everything by using command line mode. Could you please tell me how can I manipulate on the database, e.g. create table, trigers, etc. with the GUI. I have tried with "Go to Database Home Page". However, this one is just for XE database, not my own new database.
Thank

[11:35 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1182148500000#c6512692135656824736)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/13236664837691376730)
[shoaib ali](http://www.blogger.com/profile/13236664837691376730) said...

hi there
when i try to execute the create database command and add the code with it , it gives me error i.e
sysaux datafile 'c:\\oracle\\oradata\\ab\\sysaux.dbf'
error at line 12
ora-02165: invalid option for create database

[1:36 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1183062960000#c2392300500218228947)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/16163997997821881026)
[Carlos](http://www.blogger.com/profile/16163997997821881026) said...
_This comment has been removed by the author._
[2:18 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1183065480000#c7867376690234900169)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/16163997997821881026)
[Carlos](http://www.blogger.com/profile/16163997997821881026) said...

hi,
You may have to check that the 'c:\\oracle\\oradata\\ab\\sysaux.dbf' path is correct, if you're using xe probably your path would start at c:\\oraclexe
good luck

[2:20 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1183065600000#c6415298549535751034)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/13236664837691376730)
[shoaib ali](http://www.blogger.com/profile/13236664837691376730) said...

The problem is persisting
the path i.e
sysaux datafile 'c:\\oracle\\oradata\\ab\\sysaux.dbf' seems to be correct
but the thing is that my ab folder in oradata is empty do i need to create any file there first ....?
please help

[7:45 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1183128300000#c8727302482304537875)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/13236664837691376730)
[shoaib ali](http://www.blogger.com/profile/13236664837691376730) said...

hi carlos ,
i am stuck at this for a long time . i have to give my 1z0-031 exams pretty soon so please help......good luck

[11:34 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1184654040000#c6973740746106163234)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

I tried to create a database using command prompt. Below command I used for this
create database demo
logfile
group 1 (
'd:\\oracle\\product\\10.2.0\\oradata\\demo\\redolog\_g1\_m1.rdo',
'd:\\oracle\\product\\10.2.0\\oradata\\demo\\redolog\_g1\_m2.rdo'
) size 102400K reuse,
group 2 (
'd:\\oracle\\product\\10.2.0\\oradata\\demo\\redolog\_g2\_m1.rdo',
'd:\\oracle\\product\\10.2.0\\oradata\\demo\\redolog\_g3\_m2.rdo'
) size 102400K reuse
datafile 'd:\\oracle\\product\\10.2.0\\oradata\\demo\\system\_01.dbf' size 512000K reuse
extent management local
sysaux datafile 'd:\\oracle\\product\\10.2.0\\oradata\\demo\\sysaux.dbf' size 1048576k reuse
default temporary tablespace temp
tempfile 'd:\\oracle\\product\\10.2.0\\oradata\\demo\\temp\_01.dbf' size 1048576k reuse
extent management local uniform size 1m
undo tablespace UNDOTBS1
datafile 'd:\\oracle\\product\\10.2.0\\oradata\\demo\\undo\_01.dbf' size 1048576k reuse
;
After run this command it is giving a message "Database created "
After that we run the below scripts to create the data dictionaries
@%ORACLE\_HOME%\\rdbms\\admin\\catalog.sql
@%ORACLE\_HOME%\\rdbms\\admin\\catproc.sql
After ran those it showing this message "PL/SQL procedure successfully completed"
But it is not creating the new database entry in 'Oracle enterprise manager console'
Can somebody please help me on this problem.

[5:22 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1194441720000#c7011816622386010244)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
kirsten said...

Hi. I am facing issues with the listener as well. When i run services.msc, i've found OracleXETNSListener started it, however it is still not listening to the database i've created. every step i've followed as posted on this blog but brings to no avail.
Is there a need to modify any C:\\oraclexe\\app\\oracle\\product\\10.2.0\\server\\NETWORK\\ADMIN\\listener.ora or C:\\oraclexe\\app\\oracle\\product\\10.2.0\\server\\NETWORK\\ADMIN\\sqlnet.ora or C:\\oraclexe\\app\\oracle\\product\\10.2.0\\server\\NETWORK\\ADMIN\\tnsnames.ora?
p/s: Thanks for this blog. It helped me create the database but now i'm just facing issues with the listener.

[3:49 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1206614940000#c6038510648255083759)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
kirsten said...

27-MAR-2008 19:03:10 \* (CONNECT\_DATA=(SID=TestDB)(CID=(PROGRAM=)(HOST=\_\_jdbc\_\_)(USER=))) \* (ADDRESS=(PROTOCOL=tcp)(HOST=127.0.0.1)(PORT=50052)) \* establish \* TestDB \* 12505
lefTNS-12505: TNS:listener does not currently know of SID given in connect descriptor
This was the C:\\oraclexe\\app\\oracle\\product\\10.2.0\\server\\NETWORK\\log\\listener.log output when i've tried to connect using an oracle client.

[4:06 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1206615960000#c7299491756814480865)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]](http://www.blogger.com/profile/15934070138187932218)
[carlos](http://www.blogger.com/profile/15934070138187932218) said...

Hi Kristen, If you followed the steps described here you should notice that the ORACLE\_SID was called 'oraXE', I see in your log message the error :
'TNS:listener does not currently know of SID given in connect descriptor' and the ORACLE\_SID shown is 'TestDB'.
So first check what ORACLE\_SID did you use to create the windows service and then check what ORACLE\_SID you actually set in your shell before trying to connect to oracle.
You can set your ORACLE\_SID like this:
set ORACLE\_SID=oraXE
or check the actual value:
echo %ORACLE\_SID%
Good luck ;)

[6:42 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1206625320000#c7316329879823009266)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

I think I have a functional database named XE. I've moved the old XE out of the way and installed a new database. The one thing that I first noticed there is no user.dbf and users.dbf files. Why?
Also when I try to connect to the database using the HTML link provided by Oracle install, I get page not found error. I rename the data directory back to the original, ithe page is found. I did a grep and found that sysaux.dbf and system.dbf seem to have 127.0.0.1 in there, so how do I add that to the new database DBF files?
THX!

[1:31 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1208291460000#c8073831617950031910)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/13194003589428590504)
[Peter](http://www.blogger.com/profile/13194003589428590504) said...

excellent blog! very helpful. Just one comment.
it requires one more step to execute at the end. As user system (not sys) should be executed following script:
@?\\sqlplus\\admin\\pupbld.sql
otherwise it complains when I connect with newly created users:
SQL> connect orabpel/orabpel
Error accessing PRODUCT\_USER\_PROFILE
Warning: Product user profile information not loaded!
You may need to run PUPBLD.SQL as SYSTEM
Connected.
anyway good job!

[8:04 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1209049440000#c574476521519004965)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/02979510483072688296)
[feiroz](http://www.blogger.com/profile/02979510483072688296) said...

Can i used these steps in oracle 10g standard edition.

[9:47 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1225385220000#c4337572633951862339)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/12631695910781807324)
[Roxana Gabriela](http://www.blogger.com/profile/12631695910781807324) said...

Hi Carlos,
Thanx again for a very useful article. Unfortunately i got stuck close to the shore while executing
@?\\rdbms\\admin\\catalog.sql
Indeed my shared\_pool\_size is 32. I tried to increase it:
alter system set shared\_pool\_size=64M;
but i get the flowing:
\*
ERROR at line 1:
ORA-02097: parameter cannot be modified because specified value is invalid
ORA-04033: Insufficient memory to grow pool
Do you have any advice? How did u manage to increase ur shared\_pool\_size?
Looking forward for ur answer
Cheers
Roxana

[2:38 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1231324680000#c2955012369616984088)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

you don't write that we need to create the dir oradata/oraXE manually!

[7:55 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1240412100000#c2436149300846451795)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]](http://www.blogger.com/profile/15934070138187932218)
[carlos](http://www.blogger.com/profile/15934070138187932218) said...

Sorry, but I think you should know how to create a directory in windows.

[7:37 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1242052620000#c5607763958460354975)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...
_This comment has been removed by a blog administrator._
[7:11 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1243433486922#c314751507955876030)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]](http://willinghams.net/)
[Brian](http://willinghams.net/) said...

Awesome write up.. Its very helpful.

[1:18 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1254514682665#c5769757978580535723)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
vivan said...

Hi,
Is it posible if I copy paste the old database from oracle 9.2 to oracle 10g XE manually?
I follow the step until step 5, I already create new SID and can connect/run the new instance/service, but I cannot login to database homepage.
I copy the database folder from "oracle/ora92/db\_name" to oraclexe/oradata/db\_name"
I try to login to homepage using username and password from default oracle 10gXE cannot, i try to login using username and password from the new ORACLE\_SID also cannot, I try using id and pass from old database cannot.
What should i do? thanks.

[7:46 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1268192802453#c1171992000406562591)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

Hi Carlos,
i am using Oracle 10g Express and server 2003 Sp2 i want to change the oracle sid from XE to SM7 i am following the steps .. .
i have encounter the problem that when i type
SQL>connect / as sysdba
ORA-12560 TNS protocol adapter error
how will i give it sysdba priviliges ?
Thanks,
\-Mohsin

[4:43 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1303818201740#c6274354568838684360)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

HI Carlos,
On this step
oradim -new -sid %ORACLE\_SID% -intpwd passwordhere -startmode M
i get error and i think there will be start mode =auto ? and what about pfile? parameter
on this step i am getting error when i put start mode M
Unable to find error file %ORACLE\_HOME%\\RDBMS\\opw.msb
Message 51 not found; No message file for product=RDBMS, facility=ORADIM
and when i put startmode auto then it gives me error
Unable to find error file %ORACLE\_HOME%\\RDBMS\\opw.msb
Message 51 not found; No message file for product=RDBMS, facility=ORADIM
then let me know what is the problem ???
Regard,
Mohsin

[5:09 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1303819778910#c3522682390720332189)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

Nice blog

[10:48 PM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1309153683658#c2795629469571129095)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/01098030924982534728)
[BGeorge](http://www.blogger.com/profile/01098030924982534728) said...

Thanks a lot for the details. It is a very good tutorial to understand the basic architecture of oracle db. By the way, the create database command failed for me many time and finally I created the folder oraXE under the folder "C:\\oraclexe\\oradata\\" and then the database got created. Is this necessary or the create database command will create the directory if it is not there? Please advise...

[2:18 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1309511914688#c3712280071803988555)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/04089729577393298841)
[anand](http://www.blogger.com/profile/04089729577393298841) said...

hi,im working in xp.iam install a oracle then sql devloper.im creating a new database but im in fail.its show me the error is test fail lo exception. the netwrk adapter could not establish the coonection.plz show me the soloution of dis error

[11:08 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1311962906055#c7754991851143060823)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/04089729577393298841)
[anand](http://www.blogger.com/profile/04089729577393298841) said...

im created in new data base but ican create dis.im using cmd
den i write sqlplus/as sysdba
its not conected wat can i do and mi window is xp

[11:14 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1311963262421#c8915747808661893642)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/04089729577393298841)
[anand](http://www.blogger.com/profile/04089729577393298841) said...

im using in new connection a
connection name-abc
username-hr
passwrd-hr
host name-localhost
port-1521
sid-xe
plz tell me im right or nt

[11:19 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1311963555730#c6913366800576151103)

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/b16-rounded.gif]]](http://www.blogger.com/profile/04655066505669896615)
[Krish](http://www.blogger.com/profile/04655066505669896615) said...

Good tutorial. Really Googled a lot time to find the perfect tutor.
Everything worked fine, except step 3 for me..
"oradim -new -sid %ORACLE\_SID% -intpwd passwordhere -startmode M"
i used the following cmd
"oradim -new -sid mandb1 -syspwd sys -startmode manual -pfile F:\\oracle\\product\\10.2.0\\admin\\mandb1\\pfile\\init.ora.3232010121242
"
Thanks for the wonderful guidelines.

[4:55 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1317210954014#c987999155018041466)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

Hemant :======
very nice 1 ...thanks a lot..
will u tell me hw to clone database using cold backup
my id is:
hakhandare@gmail.com

[9:53 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1321206816968#c979208248919881339)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/blank.gif]]
Anonymous said...

We need to set sga\_target = 800M in the initXE.ora

[8:03 AM](http://devtime.blogspot.com/2006/01/creating-oracle-xe-database-manually.html?showComment=1405177385187#c9006805941599461276)

[Post a Comment](http://www.blogger.com/comment.g?blogID=19309483&postID=113837344759882620)

[Newer Post](http://devtime.blogspot.in/2006/02/web-20.html) [Older Post](http://devtime.blogspot.in/2006/01/firefox-extension-ie-tab.html) [Home](http://devtime.blogspot.in/)

Subscribe to: [Post Comments (Atom)](http://devtime.blogspot.com/feeds/113837344759882620/comments/default)

## About Me

[![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/me_small.jpg]]](http://www.blogger.com/profile/15934070138187932218)

[carlos](http://www.blogger.com/profile/15934070138187932218)
CALI, VALLE DEL CAUCA, Colombia
I am a LAMP freelance web developer who loves Symfony framework, Linux server administration and a little bit DB administration.

[View my complete profile](http://www.blogger.com/profile/15934070138187932218)

## Blog Archive

* [[#|►]]  [2012](http://devtime.blogspot.in/search?updated-min=2012-01-01T00:00:00-08:00&updated-max=2013-01-01T00:00:00-08:00&max-results=1) (1)

* [[#|►]]  [2011](http://devtime.blogspot.in/search?updated-min=2011-01-01T00:00:00-08:00&updated-max=2012-01-01T00:00:00-08:00&max-results=7) (7)

* [[#|►]]  [2010](http://devtime.blogspot.in/search?updated-min=2010-01-01T00:00:00-08:00&updated-max=2011-01-01T00:00:00-08:00&max-results=1) (1)

* [[#|►]]  [2009](http://devtime.blogspot.in/search?updated-min=2009-01-01T00:00:00-08:00&updated-max=2010-01-01T00:00:00-08:00&max-results=4) (4)

* [[#|►]]  [2008](http://devtime.blogspot.in/search?updated-min=2008-01-01T00:00:00-08:00&updated-max=2009-01-01T00:00:00-08:00&max-results=10) (10)

* [[#|►]]  [2007](http://devtime.blogspot.in/search?updated-min=2007-01-01T00:00:00-08:00&updated-max=2008-01-01T00:00:00-08:00&max-results=12) (12)

* [[#|►]]  [December](http://devtime.blogspot.in/2006_12_01_archive.html) (2)

* [[#|►]]  [October](http://devtime.blogspot.in/2006_10_01_archive.html) (1)

* [[#|►]]  [August](http://devtime.blogspot.in/2006_08_01_archive.html) (1)

* [[#|►]]  [July](http://devtime.blogspot.in/2006_07_01_archive.html) (1)

* [[#|►]]  [June](http://devtime.blogspot.in/2006_06_01_archive.html) (2)

* [[#|►]]  [May](http://devtime.blogspot.in/2006_05_01_archive.html) (1)

* [[#|►]]  [April](http://devtime.blogspot.in/2006_04_01_archive.html) (1)

* [[#|►]]  [March](http://devtime.blogspot.in/2006_03_01_archive.html) (1)

* [[#|►]]  [February](http://devtime.blogspot.in/2006_02_01_archive.html) (2)

* [Creating an Oracle (XE) database manually on XP](http://devtime.blogspot.in/2006/01/creating-oracle-xe-database-manually.html)

* [Firefox extension: IE Tab](http://devtime.blogspot.in/2006/01/firefox-extension-ie-tab.html)
* [Download Oracle XE with wget](http://devtime.blogspot.in/2006/01/download-oracle-xe-with-wget.html)

* [[#|►]]  [2005](http://devtime.blogspot.in/search?updated-min=2005-01-01T00:00:00-08:00&updated-max=2006-01-01T00:00:00-08:00&max-results=5) (5)

![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/oracle_certasso.gif]]
![[./_resources/devtime_Creating_an_Oracle_(XE)_database_manually_on_XP_-_httpdevtime.blogspot.in_devtime.blogspot.in.resources/lpic1_large.gif]]

|     |     |
| --- | --- |
|     |     |

|     |     |
| --- | --- |
|     |     |

Simple template. Powered by [Blogger](https://www.blogger.com/).
