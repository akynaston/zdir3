# sound - How can I cleanly remove PulseAudio in Ubuntu 14.04? - Ask Ubuntu [askubuntu.com]

* [Ubuntu](http://www.ubuntu.com/)

* [Community](http://community.ubuntu.com/)
* [Ask!](http://askubuntu.com/)
* [Developer](http://developer.ubuntu.com/)
* [Design](http://design.ubuntu.com/)

* [Discourse](http://discourse.ubuntu.com/)
* [Hardware](http://www.ubuntu.com/certification)
* [Insights](http://insights.ubuntu.com/)
* [Juju](http://juju.ubuntu.com/)
* [Shop](http://shop.ubuntu.com/)
* [More ›](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04#)

[Stack Exchange](http://stackexchange.com/)

[sign up](https://askubuntu.com/users/signup?returnurl=http%3a%2f%2faskubuntu.com%2fquestions%2f489609%2fhow-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04) [log in](https://askubuntu.com/users/login?returnurl=http%3a%2f%2faskubuntu.com%2fquestions%2f489609%2fhow-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04) [tour](http://askubuntu.com/tour) [help](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04#)

[Ask Ubuntu](http://askubuntu.com/) .

* [Questions](http://askubuntu.com/questions)

* [Tags](http://askubuntu.com/tags)
* [Users](http://askubuntu.com/users)
* [Badges](http://askubuntu.com/help/badges)
* [Unanswered](http://askubuntu.com/unanswered)

* [Ask Question](http://askubuntu.com/questions/ask)

[Take the 2-minute tour](http://askubuntu.com/tour) 
Ask Ubuntu is a question and answer site for Ubuntu users and developers. It's 100% free, no registration required.

# [How can I cleanly remove PulseAudio in Ubuntu 14.04?](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04)

 1  [favorite](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04#)
**1**

I am having sound issues in Ubuntu 14, mostly underruns causing skipped and ugly noises and I want to remove pulse audio in an attempt to debug.

But when I do this breaks system settings in ubuntu. Fixing this be installing ubuntu-desktop or unity result in pulse being reinstalled.

I have blacklisted a few drivers I'm not using with not positive or negative effect. I have also tried removing pulse and removing the ~/.pulse folder before reinstalling.

Any help appreciated.

[sound](http://askubuntu.com/questions/tagged/sound) [pulseaudio](http://askubuntu.com/questions/tagged/pulseaudio)

|     |     |
| --- | --- |
| [share](http://askubuntu.com/q/489609)\|[improve this question](http://askubuntu.com/posts/489609/edit) | asked Jun 29 at 15:15<br>[![[./_resources/sound_-_How_can_I_cleanly_remove_PulseAudio_in_Ubuntu_14.04_-_Ask_Ubuntu_askubuntu.com.resources/VG67L.jpg]]](http://askubuntu.com/users/198231/noki)<br>[Noki](http://askubuntu.com/users/198231/noki)<br>**74**111 |

|     |     |
| --- | --- |
| **2** |     |

You should try to disable it instead. –  [CameronNemo](http://askubuntu.com/users/112084/cameronnemo) [Jun 29 at 15:24](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04#comment654341_489609)

|     |     |
| --- | --- |
|     |     |

This is a good guide for alsa configuration [wiki.xbmc.org/…](http://wiki.xbmc.org/index.php?title=Archive:HOW-TO:Setup_audio_over_HDMI_on_nVidia_GeForce/nForce_controller) –  [Noki](http://askubuntu.com/users/198231/noki) [Jun 30 at 1:23](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04#comment654621_489609)

## 1 Answer

[active](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04?answertab=active#tab-top) [oldest](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04?answertab=oldest#tab-top) [votes](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04?answertab=votes#tab-top)

 2  accepted

You can't remove Pulseaudio in Ubuntu 14.04 without breaking some dependencies. The sound indicator and the sound options panel, even the control center itself, are dependent on Pulseaudio.

Pulseaudio is just a userspace daemon. But you can't simple kill Pulseaudio since it will be respawned by the init system.

    jorge@den:~$ ps aux | grep pulseaudio
    jorge     3797  0.0  0.1 440464  7360 ?        S<l  17:40   0:00 /usr/bin/pulseaudio --start --log-target=syslog
    jorge     3803  0.0  0.0  98392  3028 ?        S    17:40   0:00 /usr/lib/pulseaudio/pulse/gconf-helper
    jorge     4057  0.0  0.0  23900   924 pts/0    S+   17:51   0:00 grep --color=auto pulseaudio
    jorge@den:~$ pkill -f pulseaudio
    jorge@den:~$ ps aux | grep pulseaudio
    jorge     4063  6.0  0.1 440680  7236 ?        S<l  17:51   0:00 /usr/bin/pulseaudio --start --log-target=syslog
    jorge     4067  0.0  0.0  98392  3028 ?        S    17:51   0:00 /usr/lib/pulseaudio/pulse/gconf-helper
    jorge     4069  0.0  0.0  23900   924 pts/0    S+   17:51   0:00 grep --color=auto pulseaudio
    

You can tell Pulseaudio not to respawn itself by issuing this command:

    echo "autospawn = no" > $HOME/.config/pulse/client.conf
    

You can now kill pulseaudio:

    jorge@den:~$ pkill -f pulseaudio
    jorge@den:~$ ps aux | grep pulse
    jorge     6310  0.0  0.0  23900   916 pts/1    S+   18:11   0:00 grep --color=auto pulse
    

Pulseaudio should be restarted on session startup, but it might be terminated if there is no sound activity, so after you are done, remember to remove the file you have created before, so Pulseaudio can be respawned when needed.

    rm $HOME/.config/pulse/client.conf
    

|     |     |     |
| --- | --- | --- |
| [share](http://askubuntu.com/a/489621)\|[improve this answer](http://askubuntu.com/posts/489621/edit) | [edited Jun 29 at 16:13](http://askubuntu.com/posts/489621/revisions) | answered Jun 29 at 15:55<br>[![[./_resources/sound_-_How_can_I_cleanly_remove_PulseAudio_in_Ubuntu_14.04_-_Ask_Ubuntu_askubuntu.com.resources/97ebc50b7194964c4404646c5242b9eb.png]]](http://askubuntu.com/users/83068/jorge-su%c3%a1rez-de-lis)<br>[Jorge Suárez de Lis](http://askubuntu.com/users/83068/jorge-su%c3%a1rez-de-lis)<br>**967**621 |

|     |     |
| --- | --- |
|     |     |

Thanks for the information. I will now work on ALSA to see if I can get audio working without pulse to see if that's my problem. –  [Noki](http://askubuntu.com/users/198231/noki) [Jun 30 at 0:31](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04#comment654589_489621)

## Your Answer

### Sign up or [log in](http://askubuntu.com/users/login?returnurl=%2fquestions%2f489609%2fhow-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04%23new-answer)

Sign up using Google

Sign up using Facebook

Sign up using Stack Exchange

### Post as a guest

**Name**
**Email**

By posting your answer, you agree to the [privacy policy](http://stackexchange.com/legal/privacy-policy) and [terms of service](http://stackexchange.com/legal/terms-of-service).

## Not the answer you're looking for? Browse other questions tagged [sound](http://askubuntu.com/questions/tagged/sound) [pulseaudio](http://askubuntu.com/questions/tagged/pulseaudio) or [ask your own question](http://askubuntu.com/questions/ask).

|     |     |
| --- | --- |
| asked | **3 months ago** |
| viewed | **1297 times** |
| active | **[3 months ago](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04?lastactivity)** |

#### Related

[10](http://askubuntu.com/q/25622?rq=1)[My sound stopped working today, how can I fix it?](http://askubuntu.com/questions/25622/my-sound-stopped-working-today-how-can-i-fix-it?rq=1)
[0](http://askubuntu.com/q/244870?rq=1)[No Sound through Headphones after recent PulseAudio Updates in Ubuntu 12.04LTS](http://askubuntu.com/questions/244870/no-sound-through-headphones-after-recent-pulseaudio-updates-in-ubuntu-12-04lts?rq=1)
[2](http://askubuntu.com/q/300496?rq=1)[pulseaudio --kill permission denied? (Something's using my soundcard and I don't know what it is.)](http://askubuntu.com/questions/300496/pulseaudio-kill-permission-denied-somethings-using-my-soundcard-and-i-dont?rq=1)
[1](http://askubuntu.com/q/329332?rq=1)[Pulseaudio static crackle in 5.1 analog](http://askubuntu.com/questions/329332/pulseaudio-static-crackle-in-5-1-analog?rq=1)
[1](http://askubuntu.com/q/349427?rq=1)[Two microphones listed in the input section of Pulseaudio, “Internal microphone” and “Microphone” but the problem is that](http://askubuntu.com/questions/349427/two-microphones-listed-in-the-input-section-of-pulseaudio-internal-microphone?rq=1)
[0](http://askubuntu.com/q/349767?rq=1)[Can't Start PulseAudio Ubuntu 12.04 | Can't use USB Headset](http://askubuntu.com/questions/349767/cant-start-pulseaudio-ubuntu-12-04-cant-use-usb-headset?rq=1)
[0](http://askubuntu.com/q/364053?rq=1)[Ubuntu 13.04 Sound Problem after following weird commands](http://askubuntu.com/questions/364053/ubuntu-13-04-sound-problem-after-following-weird-commands?rq=1)
[0](http://askubuntu.com/q/462788?rq=1)[Toshiba Tecra A8 without audio with Ubuntu 14.04 Bug alsa](http://askubuntu.com/questions/462788/toshiba-tecra-a8-without-audio-with-ubuntu-14-04-bug-alsa?rq=1)
[2](http://askubuntu.com/q/475450?rq=1)[Audio suddenly stopped, pulseaudio reinstall has not helped? (14.04)SOLVED](http://askubuntu.com/questions/475450/audio-suddenly-stopped-pulseaudio-reinstall-has-not-helped-14-04solved?rq=1)

#### [Hot Network Questions](http://stackexchange.com/questions?tab=hot)

* [Is the verb "taked" right?](http://ell.stackexchange.com/questions/36566/is-the-verb-taked-right)

* [Dawkin's rebuttal to Aquinas's 'The Argument from Degree'?](http://philosophy.stackexchange.com/questions/17510/dawkins-rebuttal-to-aquinass-the-argument-from-degree)
* [What are some things to keep in mind when designing a calendar?](http://worldbuilding.stackexchange.com/questions/2512/what-are-some-things-to-keep-in-mind-when-designing-a-calendar)
* [Rollback delete of Tridion item](http://tridion.stackexchange.com/questions/8115/rollback-delete-of-tridion-item)
* [Free radar (SAR) satellite data](http://gis.stackexchange.com/questions/118088/free-radar-sar-satellite-data)
* [Calculating the Order of An Element in A Group](http://math.stackexchange.com/questions/972057/calculating-the-order-of-an-element-in-a-group)
* [Why is this version of `and` in C not short-circuit?](http://stackoverflow.com/questions/26343355/why-is-this-version-of-and-in-c-not-short-circuit)
* [Using Cases to get elements in a list](http://mathematica.stackexchange.com/questions/63027/using-cases-to-get-elements-in-a-list)
* [What happens when a class and a function have the same name?](http://stackoverflow.com/questions/26341979/what-happens-when-a-class-and-a-function-have-the-same-name)
* [Sing Happy Birthday to your favourite programming language](http://codegolf.stackexchange.com/questions/39752/sing-happy-birthday-to-your-favourite-programming-language)
* [Will kittens of a feral mom "suddenly become feral" if they are allowed outside?](http://pets.stackexchange.com/questions/6545/will-kittens-of-a-feral-mom-suddenly-become-feral-if-they-are-allowed-outside)
* [How to resize RAW image files without converting to JPEG?](http://photo.stackexchange.com/questions/55855/how-to-resize-raw-image-files-without-converting-to-jpeg)
* [Does it make sense towing airplanes to the head of airstrip by external means?](http://aviation.stackexchange.com/questions/9101/does-it-make-sense-towing-airplanes-to-the-head-of-airstrip-by-external-means)
* [What's that movie where the character travels back in time by his mind?](http://scifi.stackexchange.com/questions/70564/whats-that-movie-where-the-character-travels-back-in-time-by-his-mind)
* [Is it possible to start fire using moonlight?](http://physics.stackexchange.com/questions/140927/is-it-possible-to-start-fire-using-moonlight)
* [Printing primes between user-given numbers](http://codereview.stackexchange.com/questions/66498/printing-primes-between-user-given-numbers)
* [Printing 100 prime numbers](http://codereview.stackexchange.com/questions/66468/printing-100-prime-numbers)
* [Should my rainy day fund be fixed or should I increase it by a little every month?](http://money.stackexchange.com/questions/38727/should-my-rainy-day-fund-be-fixed-or-should-i-increase-it-by-a-little-every-mont)
* [Can Bag of Holding + Portable Hole Turn Enemies Inside-Out?](http://rpg.stackexchange.com/questions/49438/can-bag-of-holding-portable-hole-turn-enemies-inside-out)
[more hot questions](http://askubuntu.com/questions/489609/how-can-i-cleanly-remove-pulseaudio-in-ubuntu-14-04#)

[question feed](http://askubuntu.com/feeds/question/489609)

[tour](http://askubuntu.com/tour) [help](http://askubuntu.com/help) [badges](http://askubuntu.com/help/badges) [blog](http://blog.stackexchange.com/?blb=1) [chat](http://chat.stackexchange.com/) [data](http://data.stackexchange.com/) [legal](http://stackexchange.com/legal) [privacy policy](http://stackexchange.com/legal/privacy-policy) [work here](http://stackexchange.com/work-here) [advertising info](http://stackexchange.com/mediakit)  **[contact us](http://askubuntu.com/contact)** **[feedback](http://meta.askubuntu.com/)**

| Technology |     |     | Life / Arts | Culture / Recreation | Science | Other |
| --- | --- | --- | --- | --- | --- | --- |
| 1. [Stack Overflow](http://stackoverflow.com/)<br>2. [Server Fault](http://serverfault.com/)<br>3. [Super User](http://superuser.com/)<br>4. [Web Applications](http://webapps.stackexchange.com/)<br>5. [Ask Ubuntu](http://askubuntu.com/)<br>6. [Webmasters](http://webmasters.stackexchange.com/)<br>7. [Game Development](http://gamedev.stackexchange.com/)<br>8. [TeX - LaTeX](http://tex.stackexchange.com/) | 1. [Programmers](http://programmers.stackexchange.com/)<br>2. [Unix & Linux](http://unix.stackexchange.com/)<br>3. [Ask Different (Apple)](http://apple.stackexchange.com/)<br>4. [WordPress Development](http://wordpress.stackexchange.com/)<br>5. [Geographic Information Systems](http://gis.stackexchange.com/)<br>6. [Electrical Engineering](http://electronics.stackexchange.com/)<br>7. [Android Enthusiasts](http://android.stackexchange.com/)<br>8. [Information Security](http://security.stackexchange.com/) | 1. [Database Administrators](http://dba.stackexchange.com/)<br>2. [Drupal Answers](http://drupal.stackexchange.com/)<br>3. [SharePoint](http://sharepoint.stackexchange.com/)<br>4. [User Experience](http://ux.stackexchange.com/)<br>5. [Mathematica](http://mathematica.stackexchange.com/)<br>6. [Salesforce](http://salesforce.stackexchange.com/)<br>7. [more (13)](http://stackexchange.com/sites#technology) | 1. [Photography](http://photo.stackexchange.com/)<br>2. [Science Fiction & Fantasy](http://scifi.stackexchange.com/)<br>3. [Graphic Design](http://graphicdesign.stackexchange.com/)<br>4. [Seasoned Advice (cooking)](http://cooking.stackexchange.com/)<br>5. [Home Improvement](http://diy.stackexchange.com/)<br>6. [Personal Finance & Money](http://money.stackexchange.com/)<br>7. [Academia](http://academia.stackexchange.com/)<br>8. [more (10)](http://stackexchange.com/sites#lifearts) | 1. [English Language & Usage](http://english.stackexchange.com/)<br>2. [Skeptics](http://skeptics.stackexchange.com/)<br>3. [Mi Yodeya (Judaism)](http://judaism.stackexchange.com/)<br>4. [Travel](http://travel.stackexchange.com/)<br>5. [Christianity](http://christianity.stackexchange.com/)<br>6. [Arqade (gaming)](http://gaming.stackexchange.com/)<br>7. [Bicycles](http://bicycles.stackexchange.com/)<br>8. [Role-playing Games](http://rpg.stackexchange.com/)<br>9. [more (21)](http://stackexchange.com/sites#culturerecreation) | 1. [Mathematics](http://math.stackexchange.com/)<br>2. [Cross Validated (stats)](http://stats.stackexchange.com/)<br>3. [Theoretical Computer Science](http://cstheory.stackexchange.com/)<br>4. [Physics](http://physics.stackexchange.com/)<br>5. [MathOverflow](http://mathoverflow.net/)<br>6. [more (7)](http://stackexchange.com/sites#science) | 1. [Stack Apps](http://stackapps.com/)<br>2. [Meta Stack Exchange](http://meta.stackexchange.com/)<br>3. [Area 51](http://area51.stackexchange.com/)<br>4. [Stack Overflow Careers](http://careers.stackoverflow.com/?utm_source=stackoverflow.com&utm_medium=site-ui&utm_campaign=footerlink) |

site design / logo © 2014 stack exchange inc; user contributions licensed under [cc by-sa 3.0](http://creativecommons.org/licenses/by-sa/3.0/) with [attribution required](http://blog.stackoverflow.com/2009/06/attribution-required/)
rev 2014.10.13.1935
Ubuntu and Canonical are registered trademarks of Canonical Ltd.
