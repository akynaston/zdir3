# How to make HP-UX Korn shell similar to Linux Bash | DaDBm [www.dadbm.com]

#### [DaDBm](http://www.dadbm.com/)

Data and Database Management – Oracle Consulting and DBMS Blog

* [HOME](http://www.dadbm.com/)

* [About Me](http://www.dadbm.com/about/about-oracle-consultant/)

* [My Profile](http://www.dadbm.com/about/oracle-consultant-profile/)
* [My Presentations](http://www.dadbm.com/about/my-presentations/)

* [Services](http://www.dadbm.com/oracle-consulting-services/)
* [Feedback](http://www.dadbm.com/feedback/)
* [Blog](http://www.dadbm.com/dbms-blog/)
* [Contact](http://www.dadbm.com/oracle-consultant-contact/)

**You are here:** [Home](http://www.dadbm.com/) » [Blog](http://www.dadbm.com/dbms-blog/) » [How-to](http://www.dadbm.com/category/how-to/) » How to make HP-UX Korn shell similar to Linux Bash
[Share on facebook](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#) [Share on google](http://www.addthis.com/bookmark.php?v=300&winname=addthis&pub=xa-4e5ca3794d331c78%23async%3D1&source=tbx-300&lng=en-US&s=google&url=http%3A%2F%2Fwww.dadbm.com%2Fhow-to-make-hp-ux-korn-shell-similar-to-linux-bash%2F&title=How%20to%20make%20HP-UX%20Korn%20shell%20similar%20to%20Linux%20Bash%20%7C%20DaDBm%20%5Bwww.dadbm.com%5D&ate=AT-xa-4e5ca3794d331c78%23async%3D1/-/-/53f26090956cf00f/2&frommenu=1&uid=53f26090678ba565&ct=1&ui_cobrand=DaDBm.com&pre=https%3A%2F%2Fwww.google.com%2F&tt=0&captcha_provider=nucaptcha) [Share on twitter](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#) [Share on linkedin](http://www.addthis.com/bookmark.php?v=300&winname=addthis&pub=xa-4e5ca3794d331c78%23async%3D1&source=tbx-300&lng=en-US&s=linkedin&url=http%3A%2F%2Fwww.dadbm.com%2Fhow-to-make-hp-ux-korn-shell-similar-to-linux-bash%2F&title=How%20to%20make%20HP-UX%20Korn%20shell%20similar%20to%20Linux%20Bash%20%7C%20DaDBm%20%5Bwww.dadbm.com%5D&ate=AT-xa-4e5ca3794d331c78%23async%3D1/-/-/53f26090956cf00f/3&frommenu=1&uid=53f26090f627e4fe&ct=1&ui_cobrand=DaDBm.com&pre=https%3A%2F%2Fwww.google.com%2F&tt=0&captcha_provider=nucaptcha) [Share on email](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#) [Share on print](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#) [More Sharing Services](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#)

Bookmark & Share:

[← Previous article](http://www.dadbm.com/oracle-openworld-2012-wrap-up-part-2/) [Next article→](http://www.dadbm.com/oracle-11g-rac-database-on-asm-acfs-or-ocfs2/)

# How to make HP-UX Korn shell similar to Linux Bash

October 26, 2012 by [Kirill Loifman](http://www.dadbm.com/author/admin/) [2 Comments](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#comments) 

<http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#>

Working as Oracle DBA on HP-UX and Linux both I prefer Bash shell which is available on Linux compared to Korn shell which is default shell on HP-UX. It’s more convenient to work on Linux Bash using handy key combinations, etc. Unfortunately Bash is not installed on HP-UX by default and also not officially supported there – you will not get help from HP support if problems with it arise.

Nevertheless, I could find a way of improving environment settings on HP-UX to make the backspace and some other keys work similar to Linux and Bash shell. See below my usual .profile file on HP-UX.
If somebody has more useful tips on environment settings or key combinations on HP-UX, feel free to comment.

``stty kill "^U" intr "^C" erase "^?" eof "^D" susp "^Z" dsusp "^Y" \ hupcl ixon ixoff cs8 -istrip umask 027 export PATH=$PATH:/sbin EDITOR=vi ; export EDITOR # Enable usage of arrow keys in command line # If not set, use (Esc-K/Esc-J for command repeat) set -o emacs alias __A=`echo "\020"` # up arrow = back a command alias __B=`echo "\016"` # down arrow = down a command alias __C=`echo "\006"` # right arrow = forward a character alias __D=`echo "\002"` # left arrow = back a character alias __H=`echo "\001"` # home = start of line; work with Putty -> Function Keys=SCO alias __Q=`echo "\005"` # end = end of line - does not work for me # Some sets for vi & avoid exit on Ctrl-d set -o ignoreeof ``

Some other key combinations I use:
\- Esc-H – Remove a line

### Related posts:

1. [Towards LAMP 2 – Oracle on Linux](http://www.dadbm.com/towards-lamp-oracle-on-linux/)

* [Oracle 11gR2 vs 10gR2 installation on Linux RHEL 5/OEL 5](http://www.dadbm.com/oracle-11gr2-vs-10gr-installation-linux/)
* [How to fix ORA-12547 TNS lost contact when try to connect to Oracle](http://www.dadbm.com/how-to-fix-ora-12547-tns-lost-contact-when-try-to-connect-to-oracle/)
* [Oracle Export and Import utilities tips](http://www.dadbm.com/oracle-export-import-utilities-tips/)

**Enjoyed this article?** Please share it with others using the social site of your choice:
<http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#>

**Filed under** [How-to](http://www.dadbm.com/category/how-to/), [UNIX, Linux](http://www.dadbm.com/category/unix-linux/) · **Tags** [Bash](http://www.dadbm.com/tag/bash/), [HP-UX](http://www.dadbm.com/tag/hp-ux/), [Linux](http://www.dadbm.com/tag/linux/), [shell](http://www.dadbm.com/tag/shell/)

[← Previous article](http://www.dadbm.com/oracle-openworld-2012-wrap-up-part-2/) [Next article→](http://www.dadbm.com/oracle-11g-rac-database-on-asm-acfs-or-ocfs2/)

### Comments

**2 Responses to “How to make HP-UX Korn shell similar to Linux Bash”**

1. ![[./_resources/How_to_make_HP-UX_Korn_shell_similar_to_Linux_Bash__DaDBm_www.dadbm.com.resources/4992f2e86c6fa8dbf5ab6b0dc0bd36dc.png]] Suzette B. Hays says:
	[January 26, 2013 at 08:44](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/comment-page-1/#comment-316)
	
	The oraenv and coraenv utilities both aid in setting the Oracle environment on UNIX / Linux systems (other utilities exist on Windows platform that enable the Oracle Home to be set.) The coraenv utility is appropriate for the UNIX / Linux C Shell; oraenv should be used with either the Bourne or Korn shells.
	
2. ![[./_resources/How_to_make_HP-UX_Korn_shell_similar_to_Linux_Bash__DaDBm_www.dadbm.com.resources/4992f2e86c6fa8dbf5ab6b0dc0bd36dc.png]] Jag says:
	[April 8, 2013 at 11:19](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/comment-page-1/#comment-353)
	
	It worked for Meee, Thanks a lot ![[./_resources/How_to_make_HP-UX_Korn_shell_similar_to_Linux_Bash__DaDBm_www.dadbm.com.resources/icon_wink.gif]]
	

### Add a Comment

**We welcome thoughtful and constructive comments from readers.
If you want your own picture to show with your comment?** Go get a [Globally Recognized Avatar](http://gravatar.com/)!

Name (required)

Mail (will not be published) (required)

Website

Notify me of followup comments via e-mail

.

		#### About Me
	
	![[./_resources/How_to_make_HP-UX_Korn_shell_similar_to_Linux_Bash__DaDBm_www.dadbm.com.resources/unknown_filename.jpeg]]
	
	**Kirill Loifman**
	\- Oracle DBA, Germany
	
	Being an Oracle Certified Professional database administrator I have more than a decade full-time DBA experience.
	
	Enjoy reading my DBMS Blog and feel free to hire me as an Oracle consultant.
	
		#### Follow DaDBm on Facebook
	
		#### Follow DaDBm on Google+
	
	* [Data Integration](http://www.dadbm.com/category/data-integration/) (2)

* [Data security](http://www.dadbm.com/category/data-security/) (3)
* [Database general](http://www.dadbm.com/category/database-general/) (4)
* [Database High Availability](http://www.dadbm.com/category/database-high-availability/) (8)
* [Database software](http://www.dadbm.com/category/database-software/) (10)
* [DBMS Comparison](http://www.dadbm.com/category/dbms-comparison/) (4)
* [How-to](http://www.dadbm.com/category/how-to/) (12)
* [IT Strategy](http://www.dadbm.com/category/it-strategy/) (6)
* [News & Events](http://www.dadbm.com/category/news-events/) (14)
* [Oracle](http://www.dadbm.com/category/oracle/) (63)
* [Oracle backup recovery](http://www.dadbm.com/category/oracle-backup-recovery/) (2)
* [Oracle Exadata](http://www.dadbm.com/category/oracle-exadata/) (3)
* [Oracle scripts](http://www.dadbm.com/category/oracle-scripts/) (1)
* [Oracle troubleshooting](http://www.dadbm.com/category/oracle-troubleshooting/) (8)
* [Security](http://www.dadbm.com/category/security/) (2)
* [Shell Scripting](http://www.dadbm.com/category/shell-scripting/) (2)
* [SQL Server](http://www.dadbm.com/category/sql-server/) (1)
* [UNIX, Linux](http://www.dadbm.com/category/unix-linux/) (8)
* [Windows](http://www.dadbm.com/category/windows/) (1)
		#### Master Index – tags
	
	[11g](http://www.dadbm.com/tag/11g/) [11gR2](http://www.dadbm.com/tag/11gr2/) [12c](http://www.dadbm.com/tag/12c/) [ASM](http://www.dadbm.com/tag/asm/) [CDB](http://www.dadbm.com/tag/cdb/) [Container Database](http://www.dadbm.com/tag/container-database/) [cost savings](http://www.dadbm.com/tag/cost-savings/) [data](http://www.dadbm.com/tag/data/) [database](http://www.dadbm.com/tag/database/) [Data Pump](http://www.dadbm.com/tag/data-pump/) [DBA](http://www.dadbm.com/tag/dba/) [downtime](http://www.dadbm.com/tag/downtime/) [error](http://www.dadbm.com/tag/error/) [Exadata](http://www.dadbm.com/tag/exadata/) [Export](http://www.dadbm.com/tag/export/) [feature](http://www.dadbm.com/tag/feature/) [Grid Infrastructure](http://www.dadbm.com/tag/grid-infrastructure/) [HA](http://www.dadbm.com/tag/ha/) [high availability](http://www.dadbm.com/tag/high-availability/) [housekeeping](http://www.dadbm.com/tag/housekeeping/) [IT](http://www.dadbm.com/tag/it/) [LAMP](http://www.dadbm.com/tag/lamp/) [Linux](http://www.dadbm.com/tag/linux/) [OEM](http://www.dadbm.com/tag/oem/) [Open Source](http://www.dadbm.com/tag/open-source/) [ORA-](http://www.dadbm.com/tag/ora/) [Oracle](http://www.dadbm.com/tag/oracle/) [Oracle error](http://www.dadbm.com/tag/oracle-error/) [OUI](http://www.dadbm.com/tag/oui/) [PDB](http://www.dadbm.com/tag/pdb/) [performance](http://www.dadbm.com/tag/performance/) [performance tuning](http://www.dadbm.com/tag/performance-tuning/) [Pluggable Database](http://www.dadbm.com/tag/pluggable-database/) [PSU](http://www.dadbm.com/tag/psu/) [RAC](http://www.dadbm.com/tag/rac/) [RDBMS](http://www.dadbm.com/tag/rdbms/) [schema](http://www.dadbm.com/tag/schema/) [script](http://www.dadbm.com/tag/script/) [Security](http://www.dadbm.com/tag/security/) [service](http://www.dadbm.com/tag/service/) [software](http://www.dadbm.com/tag/software/) [SQL](http://www.dadbm.com/tag/sql/) [TNS](http://www.dadbm.com/tag/tns/) [training](http://www.dadbm.com/tag/training/) [Unix](http://www.dadbm.com/tag/unix/)
	
	* Kirill Loifman on [How to troubleshoot Oracle remote database connection](http://www.dadbm.com/how-to-troubleshoot-oracle-remote-database-connection/comment-page-1/#comment-27434)
	* Samer on [How to troubleshoot Oracle remote database connection](http://www.dadbm.com/how-to-troubleshoot-oracle-remote-database-connection/comment-page-1/#comment-27222)
	* Samer on [How to troubleshoot Oracle remote database connection](http://www.dadbm.com/how-to-troubleshoot-oracle-remote-database-connection/comment-page-1/#comment-27216)
	* Nickita on [Oracle database 12c wish list](http://www.dadbm.com/oracle-database-12c-wish-list/comment-page-1/#comment-27066)
	* Kirill Loifman on [Enable Oracle database to send emails via SMTP server](http://www.dadbm.com/enable-oracle-database-to-send-emails-via-smtp-server/comment-page-1/#comment-26540)
	
	* [July 2014](http://www.dadbm.com/2014/07/)
	* [May 2014](http://www.dadbm.com/2014/05/)
	* [April 2014](http://www.dadbm.com/2014/04/)
	* [March 2014](http://www.dadbm.com/2014/03/)
	* [February 2014](http://www.dadbm.com/2014/02/)
	* [January 2014](http://www.dadbm.com/2014/01/)
	* [December 2013](http://www.dadbm.com/2013/12/)
	* [November 2013](http://www.dadbm.com/2013/11/)
	* [October 2013](http://www.dadbm.com/2013/10/)
	* [September 2013](http://www.dadbm.com/2013/09/)
	* [July 2013](http://www.dadbm.com/2013/07/)
	* [June 2013](http://www.dadbm.com/2013/06/)
	* [May 2013](http://www.dadbm.com/2013/05/)
	* [April 2013](http://www.dadbm.com/2013/04/)
	* [March 2013](http://www.dadbm.com/2013/03/)
	* [February 2013](http://www.dadbm.com/2013/02/)
	* [January 2013](http://www.dadbm.com/2013/01/)
	* [November 2012](http://www.dadbm.com/2012/11/)
	* [October 2012](http://www.dadbm.com/2012/10/)
	* [May 2012](http://www.dadbm.com/2012/05/)
	* [March 2012](http://www.dadbm.com/2012/03/)
	* [February 2012](http://www.dadbm.com/2012/02/)
	* [January 2012](http://www.dadbm.com/2012/01/)
	* [December 2011](http://www.dadbm.com/2011/12/)
	* [November 2011](http://www.dadbm.com/2011/11/)
	* [October 2011](http://www.dadbm.com/2011/10/)
	* [April 2011](http://www.dadbm.com/2011/04/)
	* [January 2011](http://www.dadbm.com/2011/01/)
	* [November 2010](http://www.dadbm.com/2010/11/)
	* [October 2010](http://www.dadbm.com/2010/10/)
	* [September 2010](http://www.dadbm.com/2010/09/)
	* [August 2010](http://www.dadbm.com/2010/08/)
	* [June 2010](http://www.dadbm.com/2010/06/)
	* [May 2010](http://www.dadbm.com/2010/05/)
	* [April 2010](http://www.dadbm.com/2010/04/)
	* [March 2010](http://www.dadbm.com/2010/03/)
	* [January 2010](http://www.dadbm.com/2010/01/)
	* [December 2009](http://www.dadbm.com/2009/12/)
	* [October 2009](http://www.dadbm.com/2009/10/)
	* [September 2009](http://www.dadbm.com/2009/09/)
	* [August 2009](http://www.dadbm.com/2009/08/)
	* [July 2009](http://www.dadbm.com/2009/07/)

**DBMS Blog Updates :** ![[./_resources/How_to_make_HP-UX_Korn_shell_similar_to_Linux_Bash__DaDBm_www.dadbm.com.resources/unknown_filename.1.png]] RSS: [Subscribe to Articles](http://www.dadbm.com/feed/) · [Subscribe to Comments](http://www.dadbm.com/comments/feed/) ![[./_resources/How_to_make_HP-UX_Korn_shell_similar_to_Linux_Bash__DaDBm_www.dadbm.com.resources/unknown_filename.2.png]] Receive site updates via email

		#### Popular Tags
	
	[Oracle](http://www.dadbm.com/tag/oracle/) [database](http://www.dadbm.com/tag/database/) [SQL](http://www.dadbm.com/tag/sql/) [12c](http://www.dadbm.com/tag/12c/) [11gR2](http://www.dadbm.com/tag/11gr2/) [software](http://www.dadbm.com/tag/software/) [schema](http://www.dadbm.com/tag/schema/) [11g](http://www.dadbm.com/tag/11g/) [high availability](http://www.dadbm.com/tag/high-availability/) [DBA](http://www.dadbm.com/tag/dba/) [HA](http://www.dadbm.com/tag/ha/) [Security](http://www.dadbm.com/tag/security/) [CDB](http://www.dadbm.com/tag/cdb/) [PDB](http://www.dadbm.com/tag/pdb/) [Pluggable Database](http://www.dadbm.com/tag/pluggable-database/) [Linux](http://www.dadbm.com/tag/linux/) [feature](http://www.dadbm.com/tag/feature/) [Oracle error](http://www.dadbm.com/tag/oracle-error/) [ASM](http://www.dadbm.com/tag/asm/) [Export](http://www.dadbm.com/tag/export/) [performance tuning](http://www.dadbm.com/tag/performance-tuning/) [data](http://www.dadbm.com/tag/data/)

		#### My Short Profile
	
	* · Over 17 years of full-time Oracle DBA experience
	
* · Expert in Oracle performance, security and troubleshooting

* · Oracle certified professional DBA (OCP) 9i, 10g, 11g
* · Certified in ITIL, Project & Service management
* · Masters degree in IT

		#### Core Services
	
	* · Oracle database health-checks
	
* · Oracle database troubleshooting

* · Oracle performance tuning
* · Oracle Consulting

		#### Contact Me
	
	* · **[Contact Form »](http://www.dadbm.com/oracle-consultant-contact/)**
	
* · **Skype Me :** [DaDBm](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/skype:loifmkir?chat)

* · **Follow me :**
	

Copyright © 2009-2014 [DaDBm](http://www.dadbm.com/) · [About](http://www.dadbm.com/about/about-oracle-consultant/) · [Oracle Consulting](http://www.dadbm.com/oracle-consulting-services/) · [DBMS Blog](http://www.dadbm.com/dbms-blog/) · [My Profile](http://www.dadbm.com/about/oracle-consultant-profile/) · [Contact](http://www.dadbm.com/oracle-consultant-contact/) · [Feedback](http://www.dadbm.com/feedback/)

[![[./_resources/How_to_make_HP-UX_Korn_shell_similar_to_Linux_Bash__DaDBm_www.dadbm.com.resources/unknown_filename.3.png]]](http://www.dadbm.com/how-to-make-hp-ux-korn-shell-similar-to-linux-bash/#top)
