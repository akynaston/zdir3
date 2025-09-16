# Oracle database Security FAQ - Oracle FAQ

|     |     |
| --- | --- |
| [![[./_resources/Oracle_database_Security_FAQ_-_Oracle_FAQ.resources/unknown_filename.jpeg]]](http://www.orafaq.com/) |     |

# Oracle database Security FAQ

[Oracle database](http://www.orafaq.com/wiki/Oracle_database) Security FAQ:

## Contents

\[[[#|hide]]\]

* [[#Why_should_databases_be_secured.2F_hardened.3F|1 Why should databases be secured/ hardened?]]
* [[#How_does_one_change_an_Oracle_user.27s_password.3F|2 How does one change an Oracle user's password?]]
* [[#How_does_one_create.2C_manage_and_drop_database_users.3F|3 How does one create, manage and drop database users?]]
* [[#How_does_one_enforce_strict_password_controls.3F|4 How does one enforce strict password controls?]]
* [[#Can_one_switch_to_another_database_user_without_a_password.3F|5 Can one switch to another database user without a password?]]
* [[#Why_are_OPS.24_accounts_a_security_risk_in_a_client.2Fserver_environment.3F|6 Why are OPS$ accounts a security risk in a client/server environment?]]
* [[#Managing_administrative_.28privileged.29_users_and_password_files|7 Managing administrative (privileged) users and password files]]
* [[#What_is_a_Virtual_Private_Database.3F|8 What is a Virtual Private Database?]]
* [[#What_is_Fine_Grained_Auditing.3F|9 What is Fine Grained Auditing?]]
* [[#What_is_Oracle_Label_Security.3F|10 What is Oracle Label Security?]]

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=1)\] Why should databases be secured/ hardened?

[Data](http://www.orafaq.com/wiki/Data) is any company's greatest asset and the only "safe" database is one that has nothing in it. A lot of people think that hackers are all outside the firewall which is false. The greatest threat to your database is the person in the cube next to you who has access to it. For this reason databases should be secured to ensure its data is properly protected.

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=2)\] How does one change an Oracle user's password?

Issue the following [SQL](http://www.orafaq.com/wiki/SQL) command to change a user's password:

ALTER USER <username> IDENTIFIED BY <new\_password>;

Starting from [Oracle 8](http://www.orafaq.com/wiki/Oracle_8) you can just type _password_ from [SQL*Plus](http://www.orafaq.com/wiki/SQL%2APlus), or if you need to change another user's password, type _password user\_name_. Look at these examples:

SQL> password
Changing password for SCOTT
Old password:
New password:
Retype new password:

SQL> passw scott
Changing password for scott
New password:
Retype new password:
Password changed

Note: Oracle usernames and passwords are **not case sensitive** in database versions below [Oracle 11g](http://www.orafaq.com/wiki/Oracle_11g).

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=3)\] How does one create, manage and drop database users?

One can add, drop and manage database users from the Enterprise Manager GUI. The following examples will show how the same can be achieved from the SQL\*Plus command prompt:

CREATE USER scott 
       IDENTIFIED BY tiger		-- Assign password
        DEFAULT	TABLESPACE  tools	-- Assign space for table and index segments
        TEMPORARY TABLESPACE temp;	-- Assign sort space

DROP USER scott CASCADE;		-- Remove user

After creating a new user, assign the required privileges:

GRANT CONNECT, RESOURCE TO scott;
GRANT DBA TO scott;	-- Make user a DB Administrator

Remember to give the user some space quota on its tablespaces:

ALTER USER scott QUOTA UNLIMITED ON tools;

Oracle user accounts can be locked, unlocked, forced to choose new passwords, etc. For example, all accounts except SYS and SYSTEM will be locked after creating an Oracle9iDB database using the DB Configuration Assistant (dbca). DBA's must unlock these accounts to make them available to users.

Look at these examples:

ALTER USER scott ACCOUNT LOCK    -- lock a user account
ALTER USER scott ACCOUNT UNLOCK; -- unlocks a locked users account

ALTER USER scott PASSWORD EXPIRE;  -- Force user to choose a new password

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=4)\] How does one enforce strict password controls?

By default Oracle's security is not extremely good. For example, Oracle will allow users to choose single character passwords and passwords that match their names and userids. Also, passwords don't ever expire. This means that one can hack an account for years without ever locking the user.

From [Oracle 8](http://www.orafaq.com/wiki/Oracle_8) one can manage passwords through profiles. Some of the things that one can restrict:

* FAILED\_LOGIN\_ATTEMPTS - failed login attempts before the account is locked

* PASSWORD\_LIFE\_TIME - limits the number of days the same password can be used for authentication
* PASSWORD\_REUSE\_TIME - number of days before a password can be reused
* PASSWORD\_REUSE\_MAX - number of password changes required before the current password can be reused
* PASSWORD\_LOCK\_TIME - number of days an account will be locked after maximum failed login attempts
* PASSWORD\_GRACE\_TIME - number of days after the grace period begins during which a warning is issued and login is allowed
* PASSWORD\_VERIFY\_FUNCTION - password complexity verification script

Look at this simple example:

CREATE PROFILE my\_profile LIMIT
       PASSWORD\_LIFE\_TIME 30;
ALTER USER scott PROFILE my\_profile;

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=5)\] Can one switch to another database user without a password?

Users normally use the "CONNECT" statement to connect from one database user to another. However, DBAs can switch from one user to another without a password. Of course it is not advisable to bridge Oracle's security, but look at this example:

SQL> CONNECT / as sysdba
Connected.

SQL> SELECT password FROM dba\_users WHERE  username='SCOTT';
PASSWORD
--------------- ---------------
F894844C34402B67

SQL> ALTER USER scott IDENTIFIED BY anything;
User altered.

SQL> CONNECT scott/anything
Connected.

OK, we're in. Let's quickly change the password back before anybody notices.

SQL> ALTER USER scott IDENTIFIED BY **VALUES 'F894844C34402B67'**;
User altered.

Note: Also see the [su.sql](http://www.orafaq.com/scripts/index.htm#GENDBA) script in the _Scripts and Sample Programs_ section of this site.

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=6)\] Why are OPS$ accounts a security risk in a client/server environment?

If you allow people to log in with OPS$ accounts from Windows Workstations, you cannot be sure who they really are. With terminals, you can rely on operating system passwords, with Windows, you cannot.

If you set REMOTE\_OS\_AUTHENT=TRUE in your init.ora file, Oracle assumes that the remote OS has authenticated the user.

If REMOTE\_OS\_AUTHENT is set to FALSE (recommended), remote users will be unable to connect without a password. IDENTIFIED EXTERNALLY will only be in effect from the local host. Also, if you are using "OPS$" as your prefix, you will be able to log on locally with or without a password, regardless of whether you have identified your ID with a password or defined it to be IDENTIFIED EXTERNALLY.

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=7)\] Managing administrative (privileged) users and password files

An administrative account is a user that is granted SYSOPER or SYSDBA privileges. Oracle DBAs and operators typically use administrative accounts to manage the database and database instance.

SYSDBA and SYSOPER allow access to a database instance even if it is not running. Control of these privileges is managed outside of the database via password files and special operating system groups (dba on Unix/Linux and ORA\_DBA on Windows). External password files are created with the [orapwd](http://www.orafaq.com/wiki/Orapwd) utility.

**Connecting as an administrative user:**

If an administrative users belongs to the "dba" group on Unix, or the "ORA\_DBA" (ORA\_sid\_DBA) group on Windows, he/she can connect like this:

connect / as sysdba

No password is required. This is equivalent to the desupported "connect internal" method.

A password is required for "non-secure" administrative access. These passwords are stored in password files. Remote connections via Net8 are classified as non-secure. Look at this example:

connect sys/password as sysdba

**Password files:**

The Oracle Password File ($ORACLE\_HOME/dbs/orapw or orapwSID) stores passwords for users with administrative privileges. One needs to create a password files before remote administrators (like OEM) will be allowed to connect.

Follow this procedure to create a new password file:

* Log in as the Oracle software owner
* Run command: orapwd file=$ORACLE\_HOME/dbs/orapw$ORACLE\_SID password=mypasswd
* Shutdown the database (SQLPLUS> SHUTDOWN IMMEDIATE)
* Edit the INIT.ORA file and ensure REMOTE\_LOGIN\_PASSWORDFILE=exclusive is set.
* Startup the database (SQLPLUS> STARTUP)\[/list\]

NOTE: The orapwd utility presents a security risk in that it receives a password from the command line. This password is visible in the process table (at least as long as orapwd is running) and in the shell's history file of many systems. Administrators needs to be aware of this!

**Adding users to Password File:**

One can select from the SYS.V\_$PWFILE\_USERS view to see which users are listed in the password file. New users can be added to the password file by granting them SYSDBA or SYSOPER privileges, or by using the orapwd utility.

GRANT SYSDBA TO scott;

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=8)\] What is a Virtual Private Database?

[Oracle 8i](http://www.orafaq.com/wiki/Oracle_8i) introduced the notion of a [Virtual Private Database](http://www.orafaq.com/wiki/Virtual_Private_Database) (VPD). A VPD offers Fine-Grained Access Control (FGAC) for secure separation of data. This ensures that users only have access to data that pertains to them. Using this option, one could even store multiple companies' data within the same schema, without them knowing about it.

VPD configuration is done via the DBMS\_RLS (Row Level Security) package. Select from SYS.V$VPD\_POLICY to see existing VPD configuration.

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=9)\] What is Fine Grained Auditing?

Fine Grained Auditing ([DBMS_FGA](http://www.orafaq.com/wiki/DBMS_FGA)) allows auditing records to be generated when certain rows are selected from a table. A list of defined policies can be obtained from DBA\_AUDIT\_POLICIES. Audit records are stored in DBA\_FGA\_AUDIT\_TRAIL. Look at this example:

\-- Add policy on table with auditing condition...
execute dbms\_fga.add\_policy('HR', 'EMP', 'policy1', 'deptno > 10');
-- Must ANALYZE, this feature works with CBO (Cost Based Optimizer)
analyze table EMP compute statistics;

select \* from EMP where c1 = 11;  -- Will trigger auditing
select \* from EMP where c1 = 09;  -- No auditing

-- Now we can see the statements that triggered the auditing condition...
select sqltext from sys.fga\_log$;
delete from sys.fga\_log$;

## \[[edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit&section=10)\] What is Oracle Label Security?

Oracle Label Security (formerly called Trusted Oracle MLS RDBMS) uses the [VPD](http://www.orafaq.com/wiki/VPD) (Virtual Private Database) feature of Oracle 8i to implement row level security. Access to rows are restricted according to a user's security sensitivity tag or label. Oracle Label Security is configured, controlled and managed from the Policy Manager, an Enterprise Manager-based GUI utility.

[[/wiki/Special:Categories|Category]]: [[/wiki/Category:Frequently_Asked_Questions|Frequently Asked Questions]]

* [Page](http://www.orafaq.com/wiki/Oracle_database_Security_FAQ)

* [[/wiki/Talk:Oracle_database_Security_FAQ|Discussion]]
* [Edit](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=edit)
* [History](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&action=history)

* [Log in / create account](http://www.orafaq.com/forum/l/0/)

<http://www.orafaq.com/wiki/Main_Page>

##### Site Navigation

* [Wiki Home](http://www.orafaq.com/wiki/Main_Page)

* [Forum Home](http://www.orafaq.com/forum)
* [Blogger Home](http://www.orafaq.com/)

##### Site highlights

* [Blog Aggregator](http://www.orafaq.com/aggregator)

* [[/wiki/Category:Frequently_Asked_Questions|FAQ's]]
* [Mailing Lists](http://www.orafaq.com/wiki/Mailing_lists)
* [Usenet News](http://www.orafaq.com/wiki/Usenet)
* [RSS Feeds](http://www.orafaq.com/wiki/XML/RSS_Newsfeeds)

##### Wiki Navigation

* [[/wiki/Category:Top_level|Categories]]

* [[/wiki/Special:RecentChanges|Recent changes]]
* [[/wiki/Special:Random|Random page]]
* [[/wiki/Help:Contents|Help]]

##### Search

##### Toolbox

* [[/wiki/Special:WhatLinksHere/Oracle_database_Security_FAQ|What links here]]

* [[/wiki/Special:RecentChangesLinked/Oracle_database_Security_FAQ|Related changes]]
* [[/wiki/Special:Upload|Upload file]]
* [[/wiki/Special:SpecialPages|Special pages]]
* [Printable version](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&printable=yes)
* [Permanent link](http://www.orafaq.com/wiki/index.php?title=Oracle_database_Security_FAQ&oldid=12370)

[![[./_resources/Oracle_database_Security_FAQ_-_Oracle_FAQ.resources/unknown_filename.1.gif]]](http://www.orafaq.com/)

* This page was last modified on 19 April 2010, at 16:19.

**.::** [Wiki Home](http://www.orafaq.com/wiki) **::** [Blogger Home](http://www.orafaq.com/) **::** [Forum Home](http://www.orafaq.com/forum) **::** [Contact](http://www.orafaq.com/feedback) **::** [[/wiki/Oracle_FAQ:Privacy_policy|Privacy]] **::.**
