# Peter Eisentraut's Blog: Running SQL scripts with psql [petereisentraut.blogspot.com]

# [Peter Eisentraut's Blog](http://petereisentraut.blogspot.com/)

on software development, open source, databases, and geek stuff

	

## Sunday, March 14, 2010

### [Running SQL scripts with psql](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html)

If you are using PostgreSQL, have you ever loaded an SQL script file or dump file through psql? Well, duh.

#### \-f vs. <

If you are just starting out, you will probably try this:
psql mydb < dump.sql
and that's quite OK.
Once you hit your first error message such as
ERROR:  syntax error at or near "VEIW"
you might figure out that for some reason
psql mydb -f dump.sql
is better, because it produces
psql:dump.sql:56: ERROR:  syntax error at or near "VEIW"
instead, allowing you to actually find the error in your file.
Now I admit that it is almost entirely me who is to blame for this bizarre difference, because at some point in the distant past, the GNU Coding Standards recommended that programs should behave the same independent of whether the standard input or output is a terminal or a file. The current version of said standard actually explicitly creates an exception saying that error messages should be changed to the noninteractive style when the standard input is not from a terminal. So this should probably be fixed.
Note that the `-f` form above is not portable. It depends on the GNU getopt extension that permits options after nonoption arguments. To be portable, you need to write either
psql -d mydb -f dump.sql
or
psql -f dump.sql mydb
Frankly, I hardly ever do this because I rarely use a non-GNU system, but keep it in mind when writing scripts or documentation intended to be portable.

#### psqlrc

The next thing you should always do when running psql scripts is using the option `-X`, which prevents the reading of the `.psqlrc` file. Because that file could contain anything, and you have no idea how it will interact with your script.
In my mind, this is a design mistake in psql. Unix shells have different startup files for interactive and noninteractive usage, so they don't have this problem.

#### Quiet or Loud

Anyway, if you are restoring a dump, these commands will produce output that does something like this:
CREATE TABLE
CREATE TABLE
CREATE TABLE
CREATE FUNCTION
CREATE TYPE
CREATE FUNCTION
ALTER TABLE
ALTER TABLE
CREATE INDEX
CREATE INDEX
These are the responses from the DDL commands that are in your SQL script file. I personally like to not see these, because they don't tell me anything useful and they cause the important information such as error messages to fly rapidly off the screen.
Some people might like these responses because they serve as a kind of progress indicator. Which is true, but there is a flaw. Creating tables and functions is pretty fast. Chances are that that part of the dump file will fly way off your screen in two seconds. The slow part of a database restore are the `COPY` commands that restore the data. And those do not produce any response at all! So as a progress report, this output is not all that useful. OK, the `ALTER TABLE` parts at the end that create the foreign keys can be slow, and of course the `CREATE INDEX` commands, but in the above example, the longest wait would be after the last `CREATE FUNCTION`.
There are two ways to make this behavior more sane: If you don't want the "progress" output, only the errors and other important messages, use the option `-q` (or `--quiet`). This is probably more useful for restoring a dump on the console. If you want a full progress report, use the option `-a` (or `--all`), which will in addition to the default behavior print each statement from the file before executing it. This is probably fairly useful in batch jobs where you are logging the output to a file or somewhere. But most likely you will want to use one of these two options for almost any noninteractive invocation of psql. You can also somewhat usefully use both options at the same
time; think about it.

#### Notices

On the matter of controlling the output, you might want to hide the `NOTICE` messages such as
NOTICE:  CREATE TABLE / PRIMARY KEY will create implicit index "test1\_pkey" for table "test1"
These get pretty boring quickly, especially when you create a lot of tables with a lot of primary keys.
psql doesn't provide a direct command-line option for turning this off, but there is an obscure method: See the environment variable `PGOPTIONS` to `'--client-min-messages=warning'`, which will pass that option to the server process. So all together, your call might look like
PGOPTIONS='--client-min-messages=warning' psql -d mydb -q -f dump.sql
For some tastes, it might actually make sense to change the `client_min_messages` option permanently in postgresql.conf on the server.
Also note that analogous to the case of `.psqlrc` described above, `PGOPTIONS` could contain all kinds of settings that you don't want. So even if you don't want to disable notices as shown here, it would be most prudent to unset the environment variable in other cases.

#### Transactions

The next thing you might want to consider is using transactions, or rather a single transaction. Otherwise, if the execution of the script or restoration of the backup fails somewhere along the way, you have a half-loaded database and no easy restart point. Sometimes this doesn't matter that much; if you are restoring into a new database, you can just drop it and start over. If you are deploying updates into an existing system, much more care is required. The option to execute a file in a single transaction is `-1` or `--single-transaction`.
Now depending on what exactly is in the file you want to load, using a single transaction may or may not work very well. For dump files created with pg\_dump, it usually works, unless you used the `-c`/`--clean` option, in which case the `DROP` commands that appear at the beginning of the file might not have anything to drop and will fail, failing the entire transaction. That problem could be addressed if pg\_dump used `DROP IF EXISTS`, but it doesn't.
When deploying schema changes into an existing database, this can get very tricky. For functions, you can usually use `CREATE OR REPLACE FUNCTION` to have an idempotent function creation command. Except that it will fail when the return type was changed. And there is no `CREATE OR REPLACE AGGREGATE` or `CREATE OR REPLACE OPERATOR` (yet?). With other object classes such as types or casts it can be easier to just unconditionally drop and recreate the objects. If you drop a type, however, everything that uses that type is also dropped, so be sure to recreate everything (such as functions) afterwards in the same transaction. This won't help when the type is used in tables, though; don't blow away your tables. Exactly how to manage this type of situation is a science of its own and would go beyond the scope of this post.
Side note: An alternative for some situations is using the psql option `ON_ERROR_ROLLBACK`, which allows you to ignore errors but still make use the atomicity property of transactions, useful when doing schema upgrades.
If you are convinced that running SQL scripts in transactions is the right thing, and you have adjusted your scripts to behave properly in that context, then you may also wish to consider the option
\-v ON\_ERROR\_STOP=1
This causes psql to stop execution when a transaction fails. Otherwise it would continue to execute the rest of the script and issuing the error message
ERROR:  current transaction is aborted, commands ignored until end of transaction block
for every command, which makes no sense. There was a discussion a while ago about making `ON_ERROR_STOP` default to on when the single-transaction option is used, but it was not clear how this should interact with savepoints. If you are making use of savepoints, you may want to stay away from this option or evaluate yourself whether it makes sense for you.

#### Pager

If you run a psql script with the output on a terminal (which is normal when installing databases, restoring backups, etc.), the script executes a `SELECT` command, and the output doesn't fit on the screen, the output is run through the pager, which will normally wait for some key to be pressed to continue. This is obviously an extremely useful feature in psql in interactive mode, but it also happens when you run a script, which is dubious.
Often, this won't be a problem, because backup files for instance don't contain `SELECT` commands with large outputs. But you can simulate this by taking any dump file that restores a sequence, which will contain `SELECT setval(...)` calls. If you make your terminal window 4 lines or less, you can see the effect of this. Again, this is contrived, but every so often someone puts a `SELECT` command in a file to create some kind of visual verification that the tables or the functions or the data that the script was supposed to load is now really there. There is nothing wrong with that, except when you run the script from the terminal and forget to check back with extreme frequency. The old joke that someone left a transaction open before going to lunch has never been more real.
Add the option
\--pset pager=off
to the psql invocation to disable this behavior.

#### Summary

OK, got all that? Write this down, here is how you _really_ should execute an SQL script file in psql:
PGOPTIONS='--client-min-messages=warning' psql -X -q -a -1 -v ON\_ERROR\_STOP=1 --pset pager=off -d mydb -f dump.sql
Should be easier? I think so. Discuss.

[Email this](http://feedburner.google.com/fb/a/emailFlare?itemTitle=Running%20SQL%20scripts%20with%20psql&uri=http%3A%2F%2Fpetereisentraut.blogspot.com%2F2010%2F03%2Frunning-sql-scripts-with-psql.html) • [Email the author](http://feedburner.google.com/fb/a/emailFlare?to=peter%40eisentraut.org&itemTitle=Running%20SQL%20scripts%20with%20psql&uri=http%3A%2F%2Fpetereisentraut.blogspot.com%2F2010%2F03%2Frunning-sql-scripts-with-psql.html) • [Save to del.icio.us (17 saves, tagged: admin administration commandline)](http://del.icio.us/post?v=4&partner=fb&url=http%3A%2F%2Fpetereisentraut.blogspot.com%2F2010%2F03%2Frunning-sql-scripts-with-psql.html&title=Running+SQL+scripts+with+psql) • [Digg This!](http://digg.com/submit?phase=2&partner=fb&url=http%3A%2F%2Fpetereisentraut.blogspot.com%2F2010%2F03%2Frunning-sql-scripts-with-psql.html&title=Running+SQL+scripts+with+psql) • [Stumble It!](http://www.stumbleupon.com/submit?url=http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html&title=Running%20SQL%20scripts%20with%20psql) • [Twit This!](http://twitthis.com/twit?url=http%3A%2F%2Fpetereisentraut.blogspot.com%2F2010%2F03%2Frunning-sql-scripts-with-psql.html&title=Running%20SQL%20scripts%20with%20psql)

Posted by Peter Eisentraut at [00:21](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html)
Labels: [Computing](http://petereisentraut.blogspot.com/search/label/Computing), [English](http://petereisentraut.blogspot.com/search/label/English), [PostgreSQL](http://petereisentraut.blogspot.com/search/label/PostgreSQL), [psql](http://petereisentraut.blogspot.com/search/label/psql)

#### 14 comments:

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.5.gif]]](http://www.blogger.com/profile/07875088787463864011)

[Bruce Momjian](http://www.blogger.com/profile/07875088787463864011) said...

Wow, great post. I knew some of these things but never saw it all put together so clearly.

[14 March, 2010 04:17](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1268533069365#c5389463344588915474)

![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.1.gif]]

Tom Lane said...

Well, psql is fundamentally meant as an interactive tool. I think what this demonstrates is that there might be room for a different tool meant for executing scripts.

[14 March, 2010 04:44](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1268534665112#c8308316145029814986)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.5.gif]]](http://www.blogger.com/profile/15990112606815608285)

[Stephen](http://www.blogger.com/profile/15990112606815608285) said...

I found this all really informative. I particularly like that you explained everything and didn't just say "use these args it's better." In fact, I actually just used this information to debug a big schema-modification script. Even with bizarre new errors I'd never seen before to do with composite types, I still managed to get it working in a fraction of the time it would normally take me (I did the psql < file.sql way before).
As far as making it easier, for my own personal use I'll probably alias it in .bashrc, but Tom Lane's idea of a separate tool meant purely for executing (and likely debugging) scripts seems logical.

[15 March, 2010 18:22](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1268670154814#c7306791323598591124)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.11.png]]](http://www.blogger.com/profile/11433622686361556089)

[Berend de Boer](http://www.blogger.com/profile/11433622686361556089) said...

I have used postgresql for years, and I learned things from this. Clearly psql should be changed to have as a default what you describe here (in batch mode that is).

[23 March, 2010 22:56](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1269377800254#c2356477912813004642)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.5.gif]]](http://www.blogger.com/profile/07601338048939864510)

[Big Bear](http://www.blogger.com/profile/07601338048939864510) said...

Hi,
How can you do the opposite of ON\_ERROR\_STOP=1 for batch jobs?
you suggest to use:
\-v ON\_ERROR\_STOP=1, but how can I unset this, so it continues?
I have an export of another database that needs copying to postgres and the current behaviour of psql in batch mode means it stops at the very first error. How can I make it proceed and process all rows and allow me to see all of the rows in the import that need fixing?
PS: The source db is a progress 8.x which does not care or enforce that fields are meant to be of a certain size. (grrrr)

[28 April, 2010 13:51](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1272451879736#c5901409262722475878)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.10.jpeg]]](http://www.blogger.com/profile/02849480732923051923)

[Peter Eisentraut](http://www.blogger.com/profile/02849480732923051923) said...

@Big Bear
Use something like -v ON\_ERROR\_STOP without equal sign to unset a variable. Or the \\unset command in your script.

[28 April, 2010 16:19](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1272460781200#c5257779430552984110)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.5.gif]]](http://www.blogger.com/profile/02965366280536022641)

[Raghavendra](http://www.blogger.com/profile/02965366280536022641) said...

Great Posting Peter,
Does PGOPTIONS will override the .psqlrc or command line option psql --pset <> -c <>
Regards
Raghavendra

[16 June, 2010 09:18](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1276669110459#c4843693342658945185)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.10.jpeg]]](http://www.blogger.com/profile/02849480732923051923)

[Peter Eisentraut](http://www.blogger.com/profile/02849480732923051923) said...

The order of evaluation is
psql command line
PGOPTIONS
.psqlrc
The later overrides the earlier.

[21 June, 2010 23:30](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1277152249942#c7893869590213597650)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.1.gif]]](http://www.zbsports.com/)

[keens sandals](http://www.zbsports.com/) said...

Nice post peter. I been looking for this stuff, been using PostgreSQL for quite sometime everything comes so clear after reading your post.
\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
\--Life can only be understood backwards, but it must be lived forward. ~Soren Kierkegaad

[28 August, 2010 19:34](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1283013291249#c2944151065625816009)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.5.gif]]](http://www.blogger.com/profile/00662452407656665935)

[Venki](http://www.blogger.com/profile/00662452407656665935) said...

Great Post Peter:
Two questions..since you seem to know a lot of psql
1\. Can you give me an example of using the hyphen in the -f option which is the direct input. How do I terminate that? In Unix I used to do < File and end with a File in a new line.
2\. How can I set a variable inside my
psql -f -
set variable here from the shell script
\-
Thanks, Venki

[25 January, 2011 08:50](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1295938209658#c7970488417928356910)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.10.jpeg]]](http://www.blogger.com/profile/02849480732923051923)

[Peter Eisentraut](http://www.blogger.com/profile/02849480732923051923) said...

It's the same syntax:
psql -f- < file

[29 January, 2011 09:27](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1296286036722#c4884213173272799707)

![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.1.gif]]

Anonymous said...

hi i am new to psql , and i am writing a shell script.
i want to pass values from shell scritp to my psql file so that i can run a loop for that number of times ....wht will be the statement to write in shell script......

[04 February, 2011 06:29](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1296793754958#c9178289898395581017)

![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.1.gif]]

Anonymous said...

Very nice post. Thank you for all the clear explanations of what things do and why you would want them to behave that way. I found this to be very helpful.

[16 August, 2011 00:28](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1313443713562#c8649663239612284243)

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.1.gif]]](http://sivers.org/)

[Derek Sivers](http://sivers.org/) said...

Thank you so much for this post! I am using PostgreSQL schema dropping-and-creating in my unit tests, so my screen has been filled with thousands of NOTICEs for months until now. Thanks for taking the time to write this.

[18 November, 2011 04:22](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html?showComment=1321582947765#c2953067491372139398)

#### Post a Comment

<http://www.blogger.com/comment-iframe.g?blogID=5541296000399974369&postID=2579721009362252248&blogspotRpcToken=3730156>

#### Links to this post

[Create a Link](http://www.blogger.com/blog-this.g)

[Newer Post](http://petereisentraut.blogspot.com/2010/04/news-from-sql-standard.html) [Older Post](http://petereisentraut.blogspot.com/2010/03/looking-for-free-hosting.html) [Home](http://petereisentraut.blogspot.com/)

Subscribe to: [Post Comments (Atom)](http://petereisentraut.blogspot.com/feeds/2579721009362252248/comments/default)

	

## About Me

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.6.jpeg]]](http://www.blogger.com/profile/02849480732923051923)

[Peter Eisentraut](http://www.blogger.com/profile/02849480732923051923)
I'm an open source hacker, PostgreSQL core team member, Debian developer, and software engineer at F-Secure. Contact me at <peter@eisentraut.org>.

[View my complete profile](http://www.blogger.com/profile/02849480732923051923)

## Recent Posts

* [git whoami](http://feedproxy.google.com/~r/PeterEisentraut/~3/V0fCgvMU9go/git-whoami.html)

* [Switching desktop environments](http://feedproxy.google.com/~r/PeterEisentraut/~3/E-M4zEW1Rtk/switching-desktop-environments.html)
* [ccache and clang, part 2](http://feedproxy.google.com/~r/PeterEisentraut/~3/bHF8vZX2hY0/ccache-and-clang-part-2.html)
* [Beta work](http://feedproxy.google.com/~r/PeterEisentraut/~3/6t0yiaGZGpk/beta-work.html)
* [Undefined symbol](http://feedproxy.google.com/~r/PeterEisentraut/~3/NossJLL7ygc/undefined-symbol.html)

## Subscribe To

  ![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.gif]] ![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.7.png]] Posts

  ![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.gif]] ![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.7.png]] Comments

## Twitter Updates

* Blog: git whoami <http://t.co/qFYLn7NT> [5 days ago](http://twitter.com/petereisentraut/statuses/139442898688151552)

* Blog: Switching desktop environments <http://t.co/rRARbOLR> [17 days ago](http://twitter.com/petereisentraut/statuses/135382718144983040)
* Of course my wife likes the new GNOME 3. [20 days ago](http://twitter.com/petereisentraut/statuses/134306315953643521)
* Gave up on GNOME 3 after about 15 minutes of trying to get work done. Switched to XFCE now, which works like the old GNOME. [20 days ago](http://twitter.com/petereisentraut/statuses/134004525416718336)
* Blog: ccache and clang, part 2 <http://t.co/EiMwVIJT> [74 days ago](http://twitter.com/petereisentraut/statuses/114543708212432896)
[follow me on Twitter](http://twitter.com/petereisentraut)

## Presentations on SlideShare

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.9.gif]]](http://www.slideshare.net/petereisentraut)

## Blog Archive

*   [2011](http://petereisentraut.blogspot.com/search?updated-min=2011-01-01T00:00:00%2B02:00&updated-max=2012-01-01T00:00:00%2B02:00&max-results=14) (14)

*   [December](http://petereisentraut.blogspot.com/2010_12_01_archive.html) (1)

*   [November](http://petereisentraut.blogspot.com/2010_11_01_archive.html) (2)

*   [October](http://petereisentraut.blogspot.com/2010_10_01_archive.html) (1)

*   [July](http://petereisentraut.blogspot.com/2010_07_01_archive.html) (3)

*   [May](http://petereisentraut.blogspot.com/2010_05_01_archive.html) (5)

*   [April](http://petereisentraut.blogspot.com/2010_04_01_archive.html) (2)

* [Running SQL scripts with psql](http://petereisentraut.blogspot.com/2010/03/running-sql-scripts-with-psql.html)
* [Looking for Free Hosting](http://petereisentraut.blogspot.com/2010/03/looking-for-free-hosting.html)

*   [February](http://petereisentraut.blogspot.com/2010_02_01_archive.html) (1)

*   [January](http://petereisentraut.blogspot.com/2010_01_01_archive.html) (5)

*   [2009](http://petereisentraut.blogspot.com/search?updated-min=2009-01-01T00:00:00%2B02:00&updated-max=2010-01-01T00:00:00%2B02:00&max-results=40) (40)

*   [2008](http://petereisentraut.blogspot.com/search?updated-min=2008-01-01T00:00:00%2B02:00&updated-max=2009-01-01T00:00:00%2B02:00&max-results=26) (26)

*   [2007](http://petereisentraut.blogspot.com/search?updated-min=2007-01-01T00:00:00%2B02:00&updated-max=2008-01-01T00:00:00%2B02:00&max-results=8) (8)

*   [2005](http://petereisentraut.blogspot.com/search?updated-min=2005-01-01T00:00:00%2B02:00&updated-max=2006-01-01T00:00:00%2B02:00&max-results=2) (2)

## Labels

* [APT](http://petereisentraut.blogspot.com/search/label/APT) (2)

* [Autoconf](http://petereisentraut.blogspot.com/search/label/Autoconf) (1)
* [Bash](http://petereisentraut.blogspot.com/search/label/Bash) (1)
* [Bazaar](http://petereisentraut.blogspot.com/search/label/Bazaar) (1)
* [Beamer](http://petereisentraut.blogspot.com/search/label/Beamer) (1)
* [ccache](http://petereisentraut.blogspot.com/search/label/ccache) (2)
* [Chrome](http://petereisentraut.blogspot.com/search/label/Chrome) (1)
* [Clang](http://petereisentraut.blogspot.com/search/label/Clang) (2)
* [Cloud](http://petereisentraut.blogspot.com/search/label/Cloud) (1)
* [Computing](http://petereisentraut.blogspot.com/search/label/Computing) (108)
* [Debian](http://petereisentraut.blogspot.com/search/label/Debian) (39)
* [Deutsch](http://petereisentraut.blogspot.com/search/label/Deutsch) (2)
* [Dresden](http://petereisentraut.blogspot.com/search/label/Dresden) (1)
* [E71](http://petereisentraut.blogspot.com/search/label/E71) (1)
* [Emacs](http://petereisentraut.blogspot.com/search/label/Emacs) (3)
* [English](http://petereisentraut.blogspot.com/search/label/English) (110)
* [EXPLAIN](http://petereisentraut.blogspot.com/search/label/EXPLAIN) (1)
* [Flymake](http://petereisentraut.blogspot.com/search/label/Flymake) (1)
* [FOSDEM](http://petereisentraut.blogspot.com/search/label/FOSDEM) (2)
* [Git](http://petereisentraut.blogspot.com/search/label/Git) (4)
* [GNOME](http://petereisentraut.blogspot.com/search/label/GNOME) (1)
* [GPS](http://petereisentraut.blogspot.com/search/label/GPS) (1)
* [I18n](http://petereisentraut.blogspot.com/search/label/I18n) (1)
* [KDE](http://petereisentraut.blogspot.com/search/label/KDE) (1)
* [LaTeX](http://petereisentraut.blogspot.com/search/label/LaTeX) (1)
* [Linux](http://petereisentraut.blogspot.com/search/label/Linux) (1)
* [LXDE](http://petereisentraut.blogspot.com/search/label/LXDE) (2)
* [Mono](http://petereisentraut.blogspot.com/search/label/Mono) (1)
* [MySQL](http://petereisentraut.blogspot.com/search/label/MySQL) (2)
* [Nokia](http://petereisentraut.blogspot.com/search/label/Nokia) (1)
* [Perl](http://petereisentraut.blogspot.com/search/label/Perl) (1)
* [PL/Proxy](http://petereisentraut.blogspot.com/search/label/PL%2FProxy) (1)
* [PostgreSQL](http://petereisentraut.blogspot.com/search/label/PostgreSQL) (84)
* [psql](http://petereisentraut.blogspot.com/search/label/psql) (1)
* [Psycopg](http://petereisentraut.blogspot.com/search/label/Psycopg) (1)
* [Python](http://petereisentraut.blogspot.com/search/label/Python) (5)
* [Shell](http://petereisentraut.blogspot.com/search/label/Shell) (4)
* [SQL](http://petereisentraut.blogspot.com/search/label/SQL) (7)
* [SSD](http://petereisentraut.blogspot.com/search/label/SSD) (2)
* [StackOverflow](http://petereisentraut.blogspot.com/search/label/StackOverflow) (2)
* [Unix](http://petereisentraut.blogspot.com/search/label/Unix) (1)
* [UserVoice](http://petereisentraut.blogspot.com/search/label/UserVoice) (2)
* [Wahl](http://petereisentraut.blogspot.com/search/label/Wahl) (1)
* [Waldschlösschenbrücke](http://petereisentraut.blogspot.com/search/label/Waldschl%C3%B6sschenbr%C3%BCcke) (1)
* [Xfce](http://petereisentraut.blogspot.com/search/label/Xfce) (1)
* [XSLT](http://petereisentraut.blogspot.com/search/label/XSLT) (1)

## Writing

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.2.jpeg]]](http://www.amazon.de/gp/product/3897217775?ie=UTF8&tag=peteissblo-21&linkCode=as2&camp=1638&creative=6742&creativeASIN=3897217775)![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.8.gif]]

## Hacking

* [PostgreSQL](http://developer.postgresql.org/~petere/)

* [Debian](http://qa.debian.org/developer.php?login=petere)
* [GitHub](https://github.com/petere)

## [![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.12.gif]]](http://www.delicious.com//) [My Delicious Bookmarks](http://www.delicious.com//petereisentraut)

* • [Learn You a Haskell for Great Good! - Chapters](http://learnyouahaskell.com/chapters) / [programming](http://www.delicious.com//petereisentraut/programming) [haskell](http://www.delicious.com//petereisentraut/haskell) [books](http://www.delicious.com//petereisentraut/books)

* • [Jetable.org - Home](http://www.jetable.org/en/index) / [email](http://www.delicious.com//petereisentraut/email) [spam](http://www.delicious.com//petereisentraut/spam) [tools](http://www.delicious.com//petereisentraut/tools) [internet](http://www.delicious.com//petereisentraut/internet)
* • [Spam Gourmet](http://www.spamgourmet.com/) / [email](http://www.delicious.com//petereisentraut/email) [spam](http://www.delicious.com//petereisentraut/spam) [internet](http://www.delicious.com//petereisentraut/internet) [tools](http://www.delicious.com//petereisentraut/tools)
* • [Create your temporary spambox!](http://spambox.us/en_US/) / [email](http://www.delicious.com//petereisentraut/email) [spam](http://www.delicious.com//petereisentraut/spam) [internet](http://www.delicious.com//petereisentraut/internet) [tools](http://www.delicious.com//petereisentraut/tools)
* • [Corsac.net - Echoes](http://www.corsac.net/?rub=blog&post=1493) / [sudo](http://www.delicious.com//petereisentraut/sudo) [pbuilder](http://www.delicious.com//petereisentraut/pbuilder) [cowbuilder](http://www.delicious.com//petereisentraut/cowbuilder)

## Search This Blog

|     |     |
| --- | --- |
|     |     |

|     |     |     |
| --- | --- | --- |
|     | powered by | ![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.3.png]] |

## Some Rights Reserved

[![[./_resources/Peter_Eisentraut's_Blog_Running_SQL_scripts_with_psql_petereisentraut.blogspot.com.resources/unknown_filename.4.png]]](http://creativecommons.org/licenses/by/3.0/)

Peter Eisentraut's Blog by [Peter Eisentraut](http://petereisentraut.blogspot.com/) is licensed under a [Creative Commons Attribution 3.0 Unported License](http://creativecommons.org/licenses/by/3.0/).
