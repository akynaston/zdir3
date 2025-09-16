# rsync file permissions on windows

[Stack Exchange](http://stackexchange.com/)

[sign up](https://superuser.com/users/signup?returnurl=http%3a%2f%2fsuperuser.com%2fquestions%2f69620%2frsync-file-permissions-on-windows) [log in](https://superuser.com/users/login?returnurl=http%3a%2f%2fsuperuser.com%2fquestions%2f69620%2frsync-file-permissions-on-windows) [tour](http://superuser.com/tour) [help](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#)

[Super User](http://superuser.com/)

* [Questions](http://superuser.com/questions)

* [Tags](http://superuser.com/tags)
* [Users](http://superuser.com/users)
* [Badges](http://superuser.com/help/badges)
* [Unanswered](http://superuser.com/unanswered)

* [Ask Question](http://superuser.com/questions/ask)

[Take the 2-minute tour](http://superuser.com/tour) 
Super User is a question and answer site for computer enthusiasts and power users. It's 100% free, no registration required.

# [rsync file permissions on windows](http://superuser.com/questions/69620/rsync-file-permissions-on-windows)

 16  [favorite](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#)
**7**

I have an rsync service that syncs files from remote machine to a machine that drops them on a network drive.

I need the copied files to take on the native permissions of the destination folder.

The sync process runs fine, but after it is finished, I cannot access some of the folders -- Permission Denied.

I am logged in as domain admin; it won't allow me to modify any permissions on said folders, either. What gives?

run command:

    rsync.exe  -v -rlt -z --delete "src_path" "dst_path"
    

[windows](http://superuser.com/questions/tagged/windows) [permissions](http://superuser.com/questions/tagged/permissions) [rsync](http://superuser.com/questions/tagged/rsync)

|     |     |     |
| --- | --- | --- |
| [share](http://superuser.com/q/69620)\|[improve this question](http://superuser.com/posts/69620/edit) | [edited Nov 13 '09 at 18:23](http://superuser.com/posts/69620/revisions) | asked Nov 12 '09 at 17:01<br>[![[./_resources/rsync_file_permissions_on_windows.resources/4854e54cbfb71a1e6be4a4e1e2ded25e.png]]](http://superuser.com/users/14655/avguchenko)<br>[avguchenko](http://superuser.com/users/14655/avguchenko)<br>**351**129 |

|     |     |
| --- | --- |
|     |     |

what command are you currently using to sync? –  [John T](http://superuser.com/users/1931/john-t) [Nov 12 '09 at 17:10](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#comment71785_69620)

|     |     |
| --- | --- |
|     |     |

thanks john T. question edited to include command. –  [avguchenko](http://superuser.com/users/14655/avguchenko) [Nov 12 '09 at 18:44](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#comment71824_69620)

## 3 Answers

[active](http://superuser.com/questions/69620/rsync-file-permissions-on-windows?answertab=active#tab-top) [oldest](http://superuser.com/questions/69620/rsync-file-permissions-on-windows?answertab=oldest#tab-top) [votes](http://superuser.com/questions/69620/rsync-file-permissions-on-windows?answertab=votes#tab-top)

 17  accepted

(from <http://www.samba.org/ftp/rsync/rsync.html>)

In summary: to give destination files (both old and new) the source permissions, use `--perms`.

To give new files the destination-default permissions (while leaving existing files unchanged), make sure that the `--perms` option is off and use `--chmod=ugo=rwX` (which ensures that all non-masked bits get enabled).

If you'd care to make this latter behavior easier to type, you could define a popt alias for it, such as putting this line in the file ~/.popt (the following defines the -Z option, and includes --no-g to use the default group of the destination dir):

        rsync alias -Z --no-p --no-g --chmod=ugo=rwX
    

|     |     |
| --- | --- |
| [share](http://superuser.com/a/69764)\|[improve this answer](http://superuser.com/posts/69764/edit) | answered Nov 12 '09 at 21:32<br>[![[./_resources/rsync_file_permissions_on_windows.resources/4854e54cbfb71a1e6be4a4e1e2ded25e.png]]](http://superuser.com/users/14655/avguchenko)<br>[avguchenko](http://superuser.com/users/14655/avguchenko)<br>**351**129 |

|     |     |
| --- | --- |
|     |     |

thx a lot. I couldn't remember the right flags to use ... –  [Vokuhila-Oliba](http://superuser.com/users/23247/vokuhila-oliba) [Jan 5 '10 at 18:31](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#comment92982_69764)

 10 

Cygwin's "posix" security has caused me lots of problems with Windows NTFS file permissions - even using `--no-perms` with rsync.

I found that newly-created files/folders don't properly inherit default permissions, but every file/folder ends up with lots of `<not inherited>` entries in the Windows file/folder Advnanced security tab. (And this problem is not just rsync-related).

I found this [related post](http://superuser.com/questions/270894/leave-acl-handling-to-windows-with-cygwin-rsync) and [this link](http://i-cat.blogspot.com/2010/01/cygwinnontsec-in-cygwin-17-speak.html) both very helpful in how to resolve these problems using the `noacl` option in cygwin's `/etc/fstab` file. The downside of this solution is that cygwin loses the ability to set file/folder permissions, but in many cases this is not important.

(Googling this topic you'll probably find references to setting the CYGWIN=NONTSEC environment variable, but this is for cygwin v1.5 and doesn't work in cygwin v1.7 onwards.)

|     |     |
| --- | --- |
| [share](http://superuser.com/a/365789)\|[improve this answer](http://superuser.com/posts/365789/edit) | answered Dec 7 '11 at 23:31<br>[![[./_resources/rsync_file_permissions_on_windows.resources/3a57ea0b43a19d9b421a4612055a8b68.png]]](http://superuser.com/users/108621/miking)<br>[miking](http://superuser.com/users/108621/miking)<br>**101**12 |

|     |     |
| --- | --- |
|     |     |

Thanks for clearing up NONTSEC. –  [Ben Challenor](http://superuser.com/users/84756/ben-challenor) [Dec 8 '12 at 13:35](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#comment620332_365789)

|     |     |
| --- | --- |
|     |     |

Editing the /etc/fstab file fixed it for me. I had to use rsync within cygwin instead of another deployment such as DeltaCopy to do this. –  [Matt Connolly](http://superuser.com/users/52119/matt-connolly) [Jan 21 '13 at 2:27](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#comment652727_365789)

 4 

On Windows with **DeltaCopy** I could make it work with:

    rsync --perms --chmod=a=rw,Da+x ...
    

It worked even with `--recursive`

|     |     |
| --- | --- |
| [share](http://superuser.com/a/476579)\|[improve this answer](http://superuser.com/posts/476579/edit) | answered Sep 18 '12 at 13:18<br>[![[./_resources/rsync_file_permissions_on_windows.resources/be1e7ef6ee96f64e1b60d947df30bac0.png]]](http://superuser.com/users/28782/wernight)<br>[Wernight](http://superuser.com/users/28782/wernight)<br>**299**29 |

|     |     |
| --- | --- |
|     |     |

This mostly worked, however, I had to change the --chmod option to include a=rwx so that batch files, etc. would properly execute. –  [Taylor Gerring](http://superuser.com/users/76566/taylor-gerring) [Oct 3 '12 at 18:38](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#comment572781_476579)

|     |     |
| --- | --- |
|     |     |

This is the only option that worked for me. Tried the --no-perms suggested above and the fstab to no avail. This one gave me only some <not inherited> permissions, which were kind of the permissions I wanted and included no Deny permission for the executing user. Thanks! –  [AronVanAmmers](http://superuser.com/users/118499/aronvanammers) [Oct 17 '12 at 10:23](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#comment581246_476579)

|     |     |
| --- | --- |
|     |     |

DeltaCopy also contains a chmod executable that can fix the permissions afterwards, e.g. chmod -R 777 /cygdrive/g –  [jnnnnn](http://superuser.com/users/168143/jnnnnn) [Nov 13 '12 at 0:25](http://superuser.com/questions/69620/rsync-file-permissions-on-windows#comment603821_476579)

## Your Answer

### Sign up or [log in](http://superuser.com/users/login?returnurl=%2fquestions%2f69620%2frsync-file-permissions-on-windows%23new-answer)

Sign up using Google

Sign up using Facebook

Sign up using Stack Exchange

### Post as a guest

**Name**
**Email**

By posting your answer, you agree to the [privacy policy](http://stackexchange.com/legal/privacy-policy) and [terms of service](http://stackexchange.com/legal/terms-of-service).

## Not the answer you're looking for? Browse other questions tagged [windows](http://superuser.com/questions/tagged/windows) [permissions](http://superuser.com/questions/tagged/permissions) [rsync](http://superuser.com/questions/tagged/rsync) or [ask your own question](http://superuser.com/questions/ask).

|     |     |
| --- | --- |
| asked | **5 years ago** |
| viewed | **17973 times** |
| active | **[1 month ago](http://superuser.com/questions/69620/rsync-file-permissions-on-windows?lastactivity)** |

#### Linked

[2](http://superuser.com/q/270894?lq=1)[Leave ACL handling to Windows with Cygwin rsync](http://superuser.com/questions/270894/leave-acl-handling-to-windows-with-cygwin-rsync?lq=1)

#### Related

[1](http://superuser.com/q/164025?rq=1)[rsync permissioning?](http://superuser.com/questions/164025/rsync-permissioning?rq=1)
[4](http://superuser.com/q/303425?rq=1)[How do I sync file permissions (chmod +x) with rsync?](http://superuser.com/questions/303425/how-do-i-sync-file-permissions-chmod-x-with-rsync?rq=1)
[1](http://superuser.com/q/307338?rq=1)[Can rsync have user-specific read-write permissions?](http://superuser.com/questions/307338/can-rsync-have-user-specific-read-write-permissions?rq=1)
[0](http://superuser.com/q/384403?rq=1)[rsync: archiving over ssh](http://superuser.com/questions/384403/rsync-archiving-over-ssh?rq=1)
[1](http://superuser.com/q/506218?rq=1)[rsync: files copied with hidden attribute](http://superuser.com/questions/506218/rsync-files-copied-with-hidden-attribute?rq=1)
[6](http://superuser.com/q/516041?rq=1)[rsync command deletion error “IO error encountered — skipping file deletion”](http://superuser.com/questions/516041/rsync-command-deletion-error-io-error-encountered-skipping-file-deletion?rq=1)
[1](http://superuser.com/q/545892?rq=1)[Control rsync user and group on reciever side](http://superuser.com/questions/545892/control-rsync-user-and-group-on-reciever-side?rq=1)
[0](http://superuser.com/q/563906?rq=1)[Permissions Error Time Capsule (can't rsync owned by root:wheel group)](http://superuser.com/questions/563906/permissions-error-time-capsule-cant-rsync-owned-by-rootwheel-group?rq=1)
[3](http://superuser.com/q/647264?rq=1)[restrict rsync (or bash script) to a directory](http://superuser.com/questions/647264/restrict-rsync-or-bash-script-to-a-directory?rq=1)
[0](http://superuser.com/q/830391?rq=1)[How to tell if a directory is completely synced by rsync?](http://superuser.com/questions/830391/how-to-tell-if-a-directory-is-completely-synced-by-rsync?rq=1)

#### [Hot Network Questions](http://stackexchange.com/questions?tab=hot)

* [What is the recommended height of the blade on a table saw while operating?](http://woodworking.stackexchange.com/questions/1061/what-is-the-recommended-height-of-the-blade-on-a-table-saw-while-operating)

* [Telescopic Parentheses](http://codegolf.stackexchange.com/questions/49042/telescopic-parentheses)
* [When Frodo offers her the ring, is Galadriel really tempted, or just making a point?](http://scifi.stackexchange.com/questions/86701/when-frodo-offers-her-the-ring-is-galadriel-really-tempted-or-just-making-a-po)
* [What exactly does init do?](http://unix.stackexchange.com/questions/197437/what-exactly-does-init-do)
* [version 1.0.6 "game balance adjustments"?](http://gaming.stackexchange.com/questions/214771/version-1-0-6-game-balance-adjustments)
* [If each term in a sum converges, does the infinite sum converge too?](http://math.stackexchange.com/questions/1243761/if-each-term-in-a-sum-converges-does-the-infinite-sum-converge-too)
* [Travelling through the Schengen area with a Refugee Travel Document issued by the USA](http://travel.stackexchange.com/questions/46413/travelling-through-the-schengen-area-with-a-refugee-travel-document-issued-by-th)
* [Does "wind" include the air molecules involved, or merely the kinetic energy?](http://earthscience.stackexchange.com/questions/4715/does-wind-include-the-air-molecules-involved-or-merely-the-kinetic-energy)
* [Did CRS-6 landing fail because the steering fins are ineffective at low speed?](http://space.stackexchange.com/questions/8817/did-crs-6-landing-fail-because-the-steering-fins-are-ineffective-at-low-speed)
* [Why are 2 ways to calculate the energy of the ground state?](http://chemistry.stackexchange.com/questions/29061/why-are-2-ways-to-calculate-the-energy-of-the-ground-state)
* [Has Daredevil ever accidentally killed anyone?](http://scifi.stackexchange.com/questions/86717/has-daredevil-ever-accidentally-killed-anyone)
* [What is the best way to check whether lead belongs to Queue or User?](http://salesforce.stackexchange.com/questions/72817/what-is-the-best-way-to-check-whether-lead-belongs-to-queue-or-user)
* [With the training from the DMG can I receive any feat in any level?](http://rpg.stackexchange.com/questions/59796/with-the-training-from-the-dmg-can-i-receive-any-feat-in-any-level)
* [Buffers comand to show full path and filename](http://vi.stackexchange.com/questions/3016/buffers-comand-to-show-full-path-and-filename)
* [Is MariaDB a secure replacement for MySQL?](http://serverfault.com/questions/683994/is-mariadb-a-secure-replacement-for-mysql)
* [How to find the normalizing constant for a distribution of unbounded support?](http://stats.stackexchange.com/questions/147353/how-to-find-the-normalizing-constant-for-a-distribution-of-unbounded-support)
* [When does randomization speed up algorithms and it "shouldn't"?](http://cstheory.stackexchange.com/questions/31195/when-does-randomization-speed-up-algorithms-and-it-shouldnt)
* [Can cheap vodka be used for cooking (with good results)?](http://cooking.stackexchange.com/questions/56818/can-cheap-vodka-be-used-for-cooking-with-good-results)
* [Decoding SHA-512 value](http://security.stackexchange.com/questions/86416/decoding-sha-512-value)
* [How to write research results when some participants dropped out?](http://academia.stackexchange.com/questions/43928/how-to-write-research-results-when-some-participants-dropped-out)
* [Google Earth Image Offset?](http://gis.stackexchange.com/questions/143266/google-earth-image-offset)
* [Expansion of complex equation.](http://math.stackexchange.com/questions/1243227/expansion-of-complex-equation)
* [What is the minimum number of medieval troops required to conquer and hold a city?](http://worldbuilding.stackexchange.com/questions/14791/what-is-the-minimum-number-of-medieval-troops-required-to-conquer-and-hold-a-cit)
* [What is the significance of 273.16 K?](http://chemistry.stackexchange.com/questions/29050/what-is-the-significance-of-273-16-k)

[question feed](http://superuser.com/feeds/question/69620)

[tour](http://superuser.com/tour) [help](http://superuser.com/help) [blog](http://blog.superuser.com/?blb=1) [chat](http://chat.stackexchange.com/) [data](http://data.stackexchange.com/) [legal](http://stackexchange.com/legal) [privacy policy](http://stackexchange.com/legal/privacy-policy) [work here](http://stackexchange.com/work-here) [advertising info](http://stackexchange.com/mediakit)  **[contact us](http://superuser.com/contact)** **[feedback](http://meta.superuser.com/)**

| Technology |     |     | Life / Arts | Culture / Recreation | Science | Other |
| --- | --- | --- | --- | --- | --- | --- |
| 1. [Stack Overflow](http://stackoverflow.com/)<br>2. [Server Fault](http://serverfault.com/)<br>3. [Super User](http://superuser.com/)<br>4. [Web Applications](http://webapps.stackexchange.com/)<br>5. [Ask Ubuntu](http://askubuntu.com/)<br>6. [Webmasters](http://webmasters.stackexchange.com/)<br>7. [Game Development](http://gamedev.stackexchange.com/)<br>8. [TeX - LaTeX](http://tex.stackexchange.com/) | 1. [Programmers](http://programmers.stackexchange.com/)<br>2. [Unix & Linux](http://unix.stackexchange.com/)<br>3. [Ask Different (Apple)](http://apple.stackexchange.com/)<br>4. [WordPress Development](http://wordpress.stackexchange.com/)<br>5. [Geographic Information Systems](http://gis.stackexchange.com/)<br>6. [Electrical Engineering](http://electronics.stackexchange.com/)<br>7. [Android Enthusiasts](http://android.stackexchange.com/)<br>8. [Information Security](http://security.stackexchange.com/) | 1. [Database Administrators](http://dba.stackexchange.com/)<br>2. [Drupal Answers](http://drupal.stackexchange.com/)<br>3. [SharePoint](http://sharepoint.stackexchange.com/)<br>4. [User Experience](http://ux.stackexchange.com/)<br>5. [Mathematica](http://mathematica.stackexchange.com/)<br>6. [Salesforce](http://salesforce.stackexchange.com/)<br>7. [more (14)](http://stackexchange.com/sites#technology) | 1. [Photography](http://photo.stackexchange.com/)<br>2. [Science Fiction & Fantasy](http://scifi.stackexchange.com/)<br>3. [Graphic Design](http://graphicdesign.stackexchange.com/)<br>4. [Seasoned Advice (cooking)](http://cooking.stackexchange.com/)<br>5. [Home Improvement](http://diy.stackexchange.com/)<br>6. [Personal Finance & Money](http://money.stackexchange.com/)<br>7. [Academia](http://academia.stackexchange.com/)<br>8. [more (10)](http://stackexchange.com/sites#lifearts) | 1. [English Language & Usage](http://english.stackexchange.com/)<br>2. [Skeptics](http://skeptics.stackexchange.com/)<br>3. [Mi Yodeya (Judaism)](http://judaism.stackexchange.com/)<br>4. [Travel](http://travel.stackexchange.com/)<br>5. [Christianity](http://christianity.stackexchange.com/)<br>6. [Arqade (gaming)](http://gaming.stackexchange.com/)<br>7. [Bicycles](http://bicycles.stackexchange.com/)<br>8. [Role-playing Games](http://rpg.stackexchange.com/)<br>9. [more (21)](http://stackexchange.com/sites#culturerecreation) | 1. [Mathematics](http://math.stackexchange.com/)<br>2. [Cross Validated (stats)](http://stats.stackexchange.com/)<br>3. [Theoretical Computer Science](http://cstheory.stackexchange.com/)<br>4. [Physics](http://physics.stackexchange.com/)<br>5. [MathOverflow](http://mathoverflow.net/)<br>6. [more (7)](http://stackexchange.com/sites#science) | 1. [Stack Apps](http://stackapps.com/)<br>2. [Meta Stack Exchange](http://meta.stackexchange.com/)<br>3. [Area 51](http://area51.stackexchange.com/)<br>4. [Stack Overflow Careers](http://careers.stackoverflow.com/) |

site design / logo © 2015 stack exchange inc; user contributions licensed under [cc by-sa 3.0](http://creativecommons.org/licenses/by-sa/3.0/) with [attribution required](http://blog.stackoverflow.com/2009/06/attribution-required/)
rev 2015.4.20.2494
