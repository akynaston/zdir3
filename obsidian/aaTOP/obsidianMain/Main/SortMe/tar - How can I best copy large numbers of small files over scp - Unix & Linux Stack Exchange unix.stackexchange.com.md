# tar - How can I best copy large numbers of small files over scp? - Unix & Linux Stack Exchange [unix.stackexchange.com]

[Stack Exchange](http://stackexchange.com/)

[sign up](https://unix.stackexchange.com/users/signup?returnurl=http%3a%2f%2funix.stackexchange.com%2fquestions%2f10026%2fhow-can-i-best-copy-large-numbers-of-small-files-over-scp) [log in](https://unix.stackexchange.com/users/login?returnurl=http%3a%2f%2funix.stackexchange.com%2fquestions%2f10026%2fhow-can-i-best-copy-large-numbers-of-small-files-over-scp) [tour](http://unix.stackexchange.com/tour) [help](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp#)

[Unix & Linux](http://unix.stackexchange.com/) .

* [**/**Questions](http://unix.stackexchange.com/questions)

* [**/**Tags](http://unix.stackexchange.com/tags)
* [**/**Users](http://unix.stackexchange.com/users)
* [**/**Badges](http://unix.stackexchange.com/help/badges)
* [**/**Unanswered](http://unix.stackexchange.com/unanswered)

* [**/**Ask Question](http://unix.stackexchange.com/questions/ask)

[Take the 2-minute tour](http://unix.stackexchange.com/tour) 
Unix & Linux Stack Exchange is a question and answer site for users of Linux, FreeBSD and other Un\*x-like operating systems.. It's 100% free, no registration required.

# [How can I best copy large numbers of small files over scp?](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp)

 **20**  [favorite](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp#)
**8**

I have a directory that's got several gigabytes and several thousand small files. I want to copy it over the network with scp more than once. CPU time on the source and destination machines is cheap, but the network overhead added by copying each file individually is huge. I would tar/gzip it up and ship it over, but the source machine is short on disk.

Is there a way for me to pipe the output of `tar -czf <output> <directory>` to scp? If not, is there another easy solution? My source machine is ancient (SunOS) so I'd rather not go installing things on it.

[/ tar](http://unix.stackexchange.com/questions/tagged/tar) [/ scp](http://unix.stackexchange.com/questions/tagged/scp)

|     |     |
| --- | --- |
| [share](http://unix.stackexchange.com/q/10026)\|[improve this question](http://unix.stackexchange.com/posts/10026/edit) | asked Mar 24 '11 at 13:57<br>[![[./_resources/tar_-_How_can_I_best_copy_large_numbers_of_small_files_over_scp_-_Unix_&_Linux_Stack_Exchange_unix.stackexchange.com.resources/04bbaf6d73be76d81b13f2e150017691.png]]](http://unix.stackexchange.com/users/6008/nmichaels)<br>[nmichaels](http://unix.stackexchange.com/users/6008/nmichaels)<br>**203**25 |

## 5 Answers

[active](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp?answertab=active#tab-top) [oldest](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp?answertab=oldest#tab-top) [votes](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp?answertab=votes#tab-top)

 **29**  accepted

You can pipe tar across an ssh session:

    $ tar czf - <files> | ssh user@host "cd /wherever; tar xvzf -"
    

|     |     |
| --- | --- |
| [share](http://unix.stackexchange.com/a/10028)\|[improve this answer](http://unix.stackexchange.com/posts/10028/edit) | answered Mar 24 '11 at 14:05<br>[![[./_resources/tar_-_How_can_I_best_copy_large_numbers_of_small_files_over_scp_-_Unix_&_Linux_Stack_Exchange_unix.stackexchange.com.resources/a5c9187f33385b982d75f123774db803.png]]](http://unix.stackexchange.com/users/3001/pdo)<br>[pdo](http://unix.stackexchange.com/users/3001/pdo)<br>**2,049**915 |

|     |     |
| --- | --- |
| **1** |     |

+1 tar-pipe solution. If you have more bandwidth and less CPU you can remove the compression flag (although gzip is pretty lightweight). –  [dietbuddha](http://unix.stackexchange.com/users/5950/dietbuddha) [Mar 24 '11 at 21:32](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp#comment13024_10028)

|     |     |
| --- | --- |
| **1** |     |

And you could drop the compression flag and instead activate it in SSH (`ssh -C` or `Compression yes` in `~/.ssh/config`). –  [Sam Hocevar](http://unix.stackexchange.com/users/5632/sam-hocevar) [Mar 25 '11 at 1:06](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp#comment13040_10028)

|     |     |
| --- | --- |
| **2** |     |

Never thought of using tar like this. Well, thats why I come here! –  [Mr. Shickadance](http://unix.stackexchange.com/users/4856/mr-shickadance) [Mar 25 '11 at 3:13](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp#comment13045_10028)

 **11** 

Tar with bzip2 compression should take as much load off the network and on the cpu.

    $ tar -C /path/to/src/dir -jcf - ./ | ssh user@server 'tar -C /path/to/dest/dir -jxf -'
    

Not using `-v` because screen output might slow down the process. But if you want a verbose output use it on the local side of tar (`-jcvf`), not on the remote part.

If you repeatedly copy over the same destination path, like updating a backup copy, your best choice is rsync with compression.

    $ rsync -az -e ssh /path/to/src/dir/ user@server:/path/to/dest/dir/
    

Notice that both src and dest paths end with a /. Again, not using `-v` and `-P` flags on purpose, add them if you need verbose output.

|     |     |
| --- | --- |
| [share](http://unix.stackexchange.com/a/10037)\|[improve this answer](http://unix.stackexchange.com/posts/10037/edit) | answered Mar 24 '11 at 14:54<br>[![[./_resources/tar_-_How_can_I_best_copy_large_numbers_of_small_files_over_scp_-_Unix_&_Linux_Stack_Exchange_unix.stackexchange.com.resources/434f38acc2b161e174f4a7e2e31775ec.png]]](http://unix.stackexchange.com/users/5666/forcefsck)<br>[forcefsck](http://unix.stackexchange.com/users/5666/forcefsck)<br>**3,343**616 |

 **7** 

use [`rsync`](http://en.wikipedia.org/wiki/Rsync), it uses SSH.

Usage:

    rsync -aPz /source/path destination.server:remote/path
    

The rsync switches care about compression and I-Node information. `-P` displays progress of every file.

You can use `scp -C`, which enables compression, but if possible, use `rsync`.

|     |     |
| --- | --- |
| [share](http://unix.stackexchange.com/a/10027)\|[improve this answer](http://unix.stackexchange.com/posts/10027/edit) | answered Mar 24 '11 at 14:02<br>[![[./_resources/tar_-_How_can_I_best_copy_large_numbers_of_small_files_over_scp_-_Unix_&_Linux_Stack_Exchange_unix.stackexchange.com.resources/fb7188d8be002ece64870dffe9ec6fa7.png]]](http://unix.stackexchange.com/users/1290/polemon)<br>[polemon](http://unix.stackexchange.com/users/1290/polemon)<br>**2,447**1532 |

|     |     |
| --- | --- |
|     |     |

Unfortunately, rsync isn't available on the source machine, and neither is sshd. –  [nmichaels](http://unix.stackexchange.com/users/6008/nmichaels) [Mar 24 '11 at 15:12](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp#comment12981_10027)

|     |     |
| --- | --- |
|     |     |

sshd isn't necessary for those operations on the client machine. –  [polemon](http://unix.stackexchange.com/users/1290/polemon) [Mar 25 '11 at 5:05](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp#comment13046_10027)

 **3** 

You can run `tar` on both ends using ssh. `scp` is part of the `ssh` family of goodness, so you probably have it on both ends.

     8:03AM 12 % tar cf - some_directory | ssh dest_host "tar xf -"
    

There may be a way to work gzip or bzip2 into the pipeline to lessen the network traffic, too.

|     |     |
| --- | --- |
| [share](http://unix.stackexchange.com/a/10029)\|[improve this answer](http://unix.stackexchange.com/posts/10029/edit) | answered Mar 24 '11 at 14:05<br>[![[./_resources/tar_-_How_can_I_best_copy_large_numbers_of_small_files_over_scp_-_Unix_&_Linux_Stack_Exchange_unix.stackexchange.com.resources/d04023769b4d78b1e091358d264b06bf.png]]](http://unix.stackexchange.com/users/732/bruce-ediger)<br>[Bruce Ediger](http://unix.stackexchange.com/users/732/bruce-ediger)<br>**16.1k**12051 |

 **2** 

If you have gzip on both ends: `sourcehost$ cd sourcedir && tar cf - . | gzip -c - | ssh user@destinationhost "cd destinationdir && gzip -c -d | tar xf -"`

If you don't have gzip on the source machine, make sure you have uncompress on the destination: `sourcehost$ cd sourcedir && tar cf - . | compress | ssh user@destinationhost "cd destdir && uncompress | tar xf -"`

This would be faster than first zipping it up, then sending, then unzipping, and it requires no extra disk space on either side. I sikpped the compression (z) flag on tar, because you probably dont have it on the ancient side.

|     |     |     |
| --- | --- | --- |
| [share](http://unix.stackexchange.com/a/10030)\|[improve this answer](http://unix.stackexchange.com/posts/10030/edit) | [edited Mar 24 '11 at 14:22](http://unix.stackexchange.com/posts/10030/revisions) | answered Mar 24 '11 at 14:16<br>[![[./_resources/tar_-_How_can_I_best_copy_large_numbers_of_small_files_over_scp_-_Unix_&_Linux_Stack_Exchange_unix.stackexchange.com.resources/7fb2b188a95faee2db8e1b7365719adf.png]]](http://unix.stackexchange.com/users/5923/mattbianco)<br>[MattBianco](http://unix.stackexchange.com/users/5923/mattbianco)<br>**998**313 |

## Your Answer

### Sign up or [log in](http://unix.stackexchange.com/users/login?returnurl=%2fquestions%2f10026%2fhow-can-i-best-copy-large-numbers-of-small-files-over-scp%23new-answer)

Sign up using Google

Sign up using Facebook

Sign up using Stack Exchange

### Post as a guest

**Name**
**Email**

By posting your answer, you agree to the [privacy policy](http://stackexchange.com/legal/privacy-policy) and [terms of service](http://stackexchange.com/legal/terms-of-service).

## Not the answer you're looking for? Browse other questions tagged [/ tar](http://unix.stackexchange.com/questions/tagged/tar) [/ scp](http://unix.stackexchange.com/questions/tagged/scp) or [ask your own question](http://unix.stackexchange.com/questions/ask).

|     |     |
| --- | --- |
| asked | **3 years ago** |
| viewed | **8817 times** |
| active | **[3 years ago](http://unix.stackexchange.com/questions/10026/how-can-i-best-copy-large-numbers-of-small-files-over-scp?lastactivity)** |

#### Related

[1](http://unix.stackexchange.com/q/17484?rq=1)[Copy/Backup all files except the most recent through scp](http://unix.stackexchange.com/questions/17484/copy-backup-all-files-except-the-most-recent-through-scp?rq=1)
[3](http://unix.stackexchange.com/q/22502?rq=1)[How to pull a file from a server using scp?](http://unix.stackexchange.com/questions/22502/how-to-pull-a-file-from-a-server-using-scp?rq=1)
[5](http://unix.stackexchange.com/q/25566?rq=1)[Copy file over existing SSH session?](http://unix.stackexchange.com/questions/25566/copy-file-over-existing-ssh-session?rq=1)
[26](http://unix.stackexchange.com/q/27419?rq=1)[How to use wildcards (*) when copying with scp?](http://unix.stackexchange.com/questions/27419/how-to-use-wildcards-when-copying-with-scp?rq=1)
[7](http://unix.stackexchange.com/q/37884?rq=1)[How to copy with SCP between two servers using key auth?](http://unix.stackexchange.com/questions/37884/how-to-copy-with-scp-between-two-servers-using-key-auth?rq=1)
[7](http://unix.stackexchange.com/q/42198?rq=1)[Untar only a certain number of files from a large tarball](http://unix.stackexchange.com/questions/42198/untar-only-a-certain-number-of-files-from-a-large-tarball?rq=1)
[2](http://unix.stackexchange.com/q/59122?rq=1)[I can ssh into a remote machine but I can't use scp to copy local stuff to the remote machine](http://unix.stackexchange.com/questions/59122/i-can-ssh-into-a-remote-machine-but-i-cant-use-scp-to-copy-local-stuff-to-the-r?rq=1)
[2](http://unix.stackexchange.com/q/72142?rq=1)[How to scp/tar files that are in between specific days?](http://unix.stackexchange.com/questions/72142/how-to-scp-tar-files-that-are-in-between-specific-days?rq=1)
[3](http://unix.stackexchange.com/q/74357?rq=1)[How can I copy a file between server using bsdtar?](http://unix.stackexchange.com/questions/74357/how-can-i-copy-a-file-between-server-using-bsdtar?rq=1)
[-1](http://unix.stackexchange.com/q/105140?rq=1)[How to copy only new files using “scp” command?](http://unix.stackexchange.com/questions/105140/how-to-copy-only-new-files-using-scp-command?rq=1)

#### [Hot Network Questions](http://stackexchange.com/questions?tab=hot)

* [Where are the instructions for installing the 2.71 Release Candidate?](http://blender.stackexchange.com/questions/13460/where-are-the-instructions-for-installing-the-2-71-release-candidate)

* [What is a good open source information retrieval library (search engine)?](http://softwarerecs.stackexchange.com/questions/7268/what-is-a-good-open-source-information-retrieval-library-search-engine)
* [Detecting cats visually by means of anomaly detection](http://datascience.stackexchange.com/questions/559/detecting-cats-visually-by-means-of-anomaly-detection)
* [Convert 1, 2, 3, 4, 5, 6, 7, 8, and 9 to "one", "two", "three", etc](http://codegolf.stackexchange.com/questions/32151/convert-1-2-3-4-5-6-7-8-and-9-to-one-two-three-etc)
* [Are these parallel theorems from Set Theory and Linear Algebra connected through Category Theory?](http://math.stackexchange.com/questions/846338/are-these-parallel-theorems-from-set-theory-and-linear-algebra-connected-through)
* [How to tell if the collision is elastic or inelastic?](http://physics.stackexchange.com/questions/121663/how-to-tell-if-the-collision-is-elastic-or-inelastic)
* [Are login "certificates" more secure than standard username + password authentication?](http://security.stackexchange.com/questions/61810/are-login-certificates-more-secure-than-standard-username-password-authentic)
* ["mv" command-- file vanished into non-directory](http://unix.stackexchange.com/questions/138868/mv-command-file-vanished-into-non-directory)
* [What's the usage of these holes?](http://electronics.stackexchange.com/questions/116518/whats-the-usage-of-these-holes)
* [Why is Ivory Coast being referred to as "Côte d'Ivoire" in the 2014 World Cup?](http://sports.stackexchange.com/questions/5050/why-is-ivory-coast-being-referred-to-as-c%c3%b4te-divoire-in-the-2014-world-cup)
* [Why does Saruman change his mind?](http://scifi.stackexchange.com/questions/59988/why-does-saruman-change-his-mind)
* [Should I unit test for null values even if it can never happen?](http://sqa.stackexchange.com/questions/9008/should-i-unit-test-for-null-values-even-if-it-can-never-happen)
* [H-S-H vs H-H what can do one and can't another?](http://music.stackexchange.com/questions/20498/h-s-h-vs-h-h-what-can-do-one-and-cant-another)
* [Etymology of certain words ending in "-en"](http://english.stackexchange.com/questions/180564/etymology-of-certain-words-ending-in-en)
* [What colour is this?](http://codegolf.stackexchange.com/questions/32386/what-colour-is-this)
* [Row Level security or Multiple Tables](http://dba.stackexchange.com/questions/68953/row-level-security-or-multiple-tables)
* [What are the balls of yarn for?](http://gaming.stackexchange.com/questions/173686/what-are-the-balls-of-yarn-for)
* [Is there a benefit of compiling your code as you go along?](http://programmers.stackexchange.com/questions/245763/is-there-a-benefit-of-compiling-your-code-as-you-go-along)
* [Are there books describing the general principles of cooking?](http://cooking.stackexchange.com/questions/45082/are-there-books-describing-the-general-principles-of-cooking)
* [German always needs an article even when refering to general things?](http://german.stackexchange.com/questions/13638/german-always-needs-an-article-even-when-refering-to-general-things)
* [Random script that isn't actually random](http://codegolf.stackexchange.com/questions/31836/random-script-that-isnt-actually-random)
* [At what speeds can an airplane land?](http://aviation.stackexchange.com/questions/7452/at-what-speeds-can-an-airplane-land)
* [What do these jokes mean?](http://ell.stackexchange.com/questions/26836/what-do-these-jokes-mean)
* [Why Do Advanced Civilizations In Stargate SG-1 Prefer Energy Weapons](http://scifi.stackexchange.com/questions/59995/why-do-advanced-civilizations-in-stargate-sg-1-prefer-energy-weapons)

[question feed](http://unix.stackexchange.com/feeds/question/10026)

[tour](http://unix.stackexchange.com/tour) [help](http://unix.stackexchange.com/help) [badges](http://unix.stackexchange.com/help/badges) [blog](http://blog.stackexchange.com/?blb=1) [chat](http://chat.stackexchange.com/) [data](http://data.stackexchange.com/) [legal](http://stackexchange.com/legal) [privacy policy](http://stackexchange.com/legal/privacy-policy) [work here](http://stackexchange.com/work-here) [advertising info](http://stackexchange.com/mediakit)  **[contact us](http://unix.stackexchange.com/contact)** **[feedback](http://meta.unix.stackexchange.com/)**

| Technology |     |     | Life / Arts | Culture / Recreation | Science | Other |
| --- | --- | --- | --- | --- | --- | --- |
| 1. [Stack Overflow](http://stackoverflow.com/)<br>2. [Server Fault](http://serverfault.com/)<br>3. [Super User](http://superuser.com/)<br>4. [Web Applications](http://webapps.stackexchange.com/)<br>5. [Ask Ubuntu](http://askubuntu.com/)<br>6. [Webmasters](http://webmasters.stackexchange.com/)<br>7. [Game Development](http://gamedev.stackexchange.com/)<br>8. [TeX - LaTeX](http://tex.stackexchange.com/) | 1. [Programmers](http://programmers.stackexchange.com/)<br>2. [Unix & Linux](http://unix.stackexchange.com/)<br>3. [Ask Different (Apple)](http://apple.stackexchange.com/)<br>4. [WordPress Development](http://wordpress.stackexchange.com/)<br>5. [Geographic Information Systems](http://gis.stackexchange.com/)<br>6. [Electrical Engineering](http://electronics.stackexchange.com/)<br>7. [Android Enthusiasts](http://android.stackexchange.com/)<br>8. [Information Security](http://security.stackexchange.com/) | 1. [Database Administrators](http://dba.stackexchange.com/)<br>2. [Drupal Answers](http://drupal.stackexchange.com/)<br>3. [SharePoint](http://sharepoint.stackexchange.com/)<br>4. [User Experience](http://ux.stackexchange.com/)<br>5. [Mathematica](http://mathematica.stackexchange.com/)<br>6. [more (14)](http://stackexchange.com/sites#technology) | 1. [Photography](http://photo.stackexchange.com/)<br>2. [Science Fiction & Fantasy](http://scifi.stackexchange.com/)<br>3. [Graphic Design](http://graphicdesign.stackexchange.com/)<br>4. [Seasoned Advice (cooking)](http://cooking.stackexchange.com/)<br>5. [Home Improvement](http://diy.stackexchange.com/)<br>6. [Personal Finance & Money](http://money.stackexchange.com/)<br>7. [Academia](http://academia.stackexchange.com/)<br>8. [more (10)](http://stackexchange.com/sites#lifearts) | 1. [English Language & Usage](http://english.stackexchange.com/)<br>2. [Skeptics](http://skeptics.stackexchange.com/)<br>3. [Mi Yodeya (Judaism)](http://judaism.stackexchange.com/)<br>4. [Travel](http://travel.stackexchange.com/)<br>5. [Christianity](http://christianity.stackexchange.com/)<br>6. [Arqade (gaming)](http://gaming.stackexchange.com/)<br>7. [Bicycles](http://bicycles.stackexchange.com/)<br>8. [Role-playing Games](http://rpg.stackexchange.com/)<br>9. [more (21)](http://stackexchange.com/sites#culturerecreation) | 1. [Mathematics](http://math.stackexchange.com/)<br>2. [Cross Validated (stats)](http://stats.stackexchange.com/)<br>3. [Theoretical Computer Science](http://cstheory.stackexchange.com/)<br>4. [Physics](http://physics.stackexchange.com/)<br>5. [MathOverflow](http://mathoverflow.net/)<br>6. [more (7)](http://stackexchange.com/sites#science) | 1. [Stack Apps](http://stackapps.com/)<br>2. [Meta Stack Exchange](http://meta.stackexchange.com/)<br>3. [Area 51](http://area51.stackexchange.com/)<br>4. [Stack Overflow Careers](http://careers.stackoverflow.com/) |

site design / logo © 2014 stack exchange inc; user contributions licensed under [cc by-sa 3.0](http://creativecommons.org/licenses/by-sa/3.0/) with [attribution required](http://blog.stackoverflow.com/2009/06/attribution-required/)
rev 2014.6.24.1676
Linux is a registered trademark of Linus Torvalds. UNIX is a registered trademark of The Open Group.
This site is not affiliated with Linus Torvalds or The Open Group in any way.
