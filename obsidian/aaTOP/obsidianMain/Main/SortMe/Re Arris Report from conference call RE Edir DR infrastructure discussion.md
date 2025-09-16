# Re: [Arris] Report from conference call: RE: Edir DR infrastructure discussion.

Team,

Today we discussed the following:

 - Core eDirectory vocabulary.
 - Discussion of SEP's seesam product to simplify eDirectory backup processes.
 - Discussed potential disaster scenarios.
 - Created a simple scenario where an entire tree was backed up, deleted, then restored for a single server tree.

Next call:
 - We will review object level backups and restores.
 - Potentially will have some discussion regarding forgotten passwords (I may not have an answer for our call for tomorrow morning).

Attached are our notes, and the "Sample Tree.xml" save file from [www.draw.io](http://www.draw.io).  You can go to this site, and import our drawing to review the 'Califorinia partition' we discussed.

Brent,

Joong has requested additional information regarding the behavior of Forgot password.  He would like us to research if the Forgot-Password functionality can be used when a users password is expired, and grace logins are consumed as a mechanism to allow users to change their password. Let discuss this, and confirm the functionality.

\--Aaron

 

TriVir LLC
O: [[tel:8018770509|801-877-0509]]

C: [[tel:8013688633|801-368-8633]]

[www.TriVir.com](http://www.trivir.com/)
[www.idmunit.org](http://www.idmunit.org/)

\>>> Aaron Kynaston 11/16/2013 8:43 PM >>>

(RESEND: fixing date)
Joong, Jason,

Here is our information for our meeting on Monday:

<https://www4.gotomeeting.com/join/220313959>

Dial +1 (773) 897-3015
Access Code: 220-313-959

\--Aaron

 

TriVir LLC
O: [[tel:8018770509|801-877-0509]]

C: [[tel:8013688633|801-368-8633]]

[www.TriVir.com](http://www.trivir.com/)
[www.idmunit.org](http://www.idmunit.org/)

\>>> "Kim, Joong" <Joong.Kim@arrisi.com> 11/13/2013 5:53 PM >>>

Aaron, I meant 8am your local time as we had talked about.  I believe this is 10am of your time?    Yes, I can try to prepped two test machines for this.   Let me if the schedule works for you.  I will get the test machines ready to go by Monday morning at 10AM EST.

\-Joong

**From:** Aaron Kynaston <[akynaston@trivir.com](mailto:akynaston@trivir.com)\>
**Date:** Wednesday, November 13, 2013 at 4:10 PM
**To:** Joong Kim <[joong.kim@arrisi.com](mailto:joong.kim@arrisi.com)\>
**Cc:** Brent Kynaston <[bkynaston@trivir.com](mailto:bkynaston@trivir.com)\>
**Subject:** Re: \[Arris\] Report from conference call: RE: Edir DR infrastructure discussion.

Joong,

I believe that would be 6AM to 7 AM my time.  While I could do this time, I would probably be a little more coherent later in the day.  If you have some flexibility, could we push the times back two hours?  Please let me know if this would be an issue.

Also, the conversations we need to have will definitely take more than an hour for all three calls.  If you don't mind, I'll focus on the core understanding for each item; then we can have additional calls as needed, sound good?

Could you please come to the eDirectory DR call with a new, empty 8.8.7 test tree, and an 8.8.8 test tree? We should start with a single server tree to simplify the situation; then we can add additional servers to ensure we can be prepared for real situations as well, and add multiple servers to the tree; and it would be good for you to see the entire process from tree creation to backup, and restore so the process is fresh in your mind.

What order would you like the calls? The same as was listed below?

Content for calls:

1 - A eDirectory disaster recovery scenario review.
2 - Configuring a A full tree backup executed with an object level backup as a cronjob.
3 - A review of basic eDirectory replication troubleshooting.

\--Aaron

TriVir LLC
O: [[tel:8018770509|801-877-0509]]

C: [[tel:8013688633|801-368-8633]]

[www.TriVir.com](http://www.trivir.com/)
[www.idmunit.org](http://www.idmunit.org/)

\>>> "Kim, Joong" <[Joong.Kim@arrisi.com](mailto:Joong.Kim@arrisi.com)\> 11/13/2013 9:10 AM >>>

Aaron, let’s schedule these for 8am to 9am Monday Tuesday and Thursday of next week.  I’m gone on Friday.  Please invite Jason Burns to these calls.

\-Joong

**From:** Aaron Kynaston <[akynaston@trivir.com](mailto:akynaston@trivir.com)\>
**Date:** Monday, November 11, 2013 at 2:57 PM
**To:** Joong Kim <[joong.kim@arrisi.com](mailto:joong.kim@arrisi.com)\>
**Cc:** Brent Kynaston <[bkynaston@trivir.com](mailto:bkynaston@trivir.com)\>, Glen Knutti <[gknutti@trivir.com](mailto:gknutti@trivir.com)\>, Jim Montgomery <[JMontgomery@trivir.com](mailto:JMontgomery@trivir.com)\>
**Subject:** \[Arris\] Report from conference call: RE: Edir DR infrastructure discussion.

Joong,

I would like to get the three conference calls scheduled below. Would you like to begin as early as this week?  If so, please feel free to send appointment(s), or your availability and we will get them scheduled.

Also, would you like to focus on the work for eDirectory 8.8.7, or should we jump to eDirectory 8.8.8, or both?

\--Aaron

TriVir LLC
O: [[tel:8018770509|801-877-0509]]

C: [[tel:8013688633|801-368-8633]]

[www.TriVir.com](http://www.trivir.com/)
[www.idmunit.org](http://www.idmunit.org/)

\>>> Aaron Kynaston 11/8/2013 4:01 PM >>>

Brent,

I apologize for the long email; but Joong and I covered a lot of material that I think needs to be brought up.  Joong, please let me know if you need to make modifications to what I've recorded here. You and I should touch bases so we can discuss Joong's requests here and confirm the best route.

Joong and I just spoke, and it sounds like there are going to be some relatively large changes to his eDirectory structure.  We identified quite a bit of work to complete to enable this.  Joong requested that we review his hours and confirm we have enough to cover the following items.

 - First, Joong would like to plan some one to come out on site to discuss a potential new IDM AD driver; however, the main goal of the visit would be to have a big-picture discussion, and see how everything would fit together.

Joong has identified at least three more conference calls he would like to have with a resource at TriVir:

1 - A eDirectory disaster recovery scenario review.  This would include going through the process of executing a dibset backup and restore.
2 - Configuring a A full tree backup executed with an object level backup as a cronjob. This includes reviewing how a restore would be done for single objects from the backup.
3 - A review of basic eDirectory replication trouble shooting.  Ideally, this would include simulating a replication issue, then attempting to recover from it.

Next, Joong, is looking at creating replicas of partitions of his tree at different physical locations.  He would like to set up Read/Write replicas at a few separate cities outside of Atlanta. He would like assistance in seeing how that would be set up, and what to do to keep replication healthy and deal with situations such as removing or adding servers to and from a replica ring, and ensuring at least one healthy master exists in each ring. He would like to ensure the existing IDM infrastructure is not negatively impacted due to the change in the tree structure. He would like discussions in how to keep time in sync, how to process and identify stuck obituaries as well.  This training would be done for Joong himself, and possibly 3 other people.  All management of off-site Read/Write replicas would be done remotely; this should be discussed as well.

Joong would like to also upgrade eDirectory and is looking for recommendations on how this can best be done (eDirectory 8.8.7 to eDirectory 8.8.8 upgrade).

There has also been some discussion of the full Access Governance Suite; but Joong would mostly like to have advice on how much to try to get in place now along with other initiatives.  At a minimum, it should be discussed especially now that the tree is going to become more global.

\--Aaron

 

TriVir LLC
O: [[tel:8018770509|801-877-0509]]

C: [[tel:8013688633|801-368-8633]]

[www.TriVir.com](http://www.trivir.com/)
[www.idmunit.org](http://www.idmunit.org/)

\>>> Aaron Kynaston 11/8/2013 2:11 PM >>>

Joong,

Here's the link for our review of your tree today.

As mentioned, the best thing we can do is get a feel for what your tree looks like now, then put together a diagram of what would be an ideal situation for the tree after the updates.

<https://www4.gotomeeting.com/join/841045023>

\--Aaron

 

TriVir LLC
O: [[tel:8018770509|801-877-0509]]

C: [[tel:8013688633|801-368-8633]]

[www.TriVir.com](http://www.trivir.com/)
[www.idmunit.org](http://www.idmunit.org/)

\>>> "Kim, Joong" <[Joong.Kim@arrisi.com](mailto:Joong.Kim@arrisi.com)\> 11/7/2013 5:47 AM >>>

Aaron, I’m good for tomorrow afternoon from 1pm to 5pm.  Let me know if we can fit one hour in there. 

\-Joong

**From:** Brent Kynaston \[<mailto:bkynaston@trivir.com>\]
**Sent:** Monday, November 4, 2013 4:39 PM
**To:** Kim, Joong
**Cc:** Aaron Kynaston; Glen Knutti; Jim Montgomery
**Subject:** Re: Edir DR infrastructure discussion.

Hello Joong - 

Please send Aaron some reading appointments for times that work well for you. He will accept the ones that he can without conflict.

Thanks,

Brent Kynaston

Software Engineer, Consultant

TriVir, LLC

c: 703-772-8689

e: [bkynaston@trivir.com](mailto:bkynaston@trivir.com)

[www.trivir.com](http://www.trivir.com) 

[www.idmunit.org](http://www.idmunit.org)

Sent from my iPad

On Oct 31, 2013, at 1:38 PM, "Kim, Joong" <[Joong.Kim@arrisi.com](mailto:Joong.Kim@arrisi.com)\> wrote:

> Brent, let’s shoot for early next week.  Can you give me a few time slots I can try to work with? 
> 
> **From:** Brent Kynaston \[<mailto:bkynaston@trivir.com>\]
> **Sent:** Wednesday, October 30, 2013 10:33 AM
> **To:** Kim, Joong
> **Cc:** Aaron Kynaston; Glen Knutti; Jim Montgomery
> **Subject:** Re: Fwd: Edir DR infrastructure discussion.
> 
> Joong,
> 
> Sorry for my delayed response, your message never made it to my mailbox. We just went through a change to our hosted mail service provider and I'm working through the wrinkles on my end.
> 
> Yes, we can certainly allocate some time. Advanced notice is helpful as schedules usually fill up the Monday of each week. I know Jim has been online with you this morning.
> 
> If you don't get a response from me within 24 hours call me please. My email may not be the best way to reach me while we iron out the mail transition.
> 
> Thanks,
> 
> Brent
> \>>> Aaron Kynaston 10/30/2013 10:15 AM >>>
> 
> Brent,
> 
> I haven't seen a response to this; can I help?
> 
> \--Aaron
> \>>> "Kim, Joong" <[Joong.Kim@arrisi.com](mailto:Joong.Kim@arrisi.com)\> 10/24/2013 6:32 AM >>>
> 
> Brent, can we get a few hours with Aaron or Keith next week on this topic?     We should have a proposed architecture document to review with you by then. 
> 
> \-Joong

Notes from our call today, November 18, 2013.
Line to execute a backup for a local dibset:
dsbk backup -f /edirbackup/serverDIBBackup.dibback -l /edirbackup/serverDIBBackup.log -e trivir -w -t -b
Example line to create a new tree for the restore; first, create a place holder tree to receive the restore files:
ndsconfig new -t TEST2 -a cn=admin.o=services -S test2 -n servers.services -B 172.17.2.140 -L 389 -l 636 -d /var/opt/novell/eDirectory/data/dib -D /var/opt/novell/eDirectory/ --config-file /etc/opt/novell/eDirectory/conf/ndsd.conf
Call to restore the tree:
Note: this behavior to allow the restore of the dibset and NICI at the same time appears to be new behavior - see the documentation under 'restoring nici' at:
<https://www.netiq.com/documentation/edir88/edir88/data/bunbduw.html>
\- This line appears to successfully restore NICI, and the dibset however, but I suspect would not be officially supported from NetIQ.
dsbk restore -r -f /edirbackup/serverDIBBackup.dibback -l /edirbackup/serverDIBBackup.log -e trivir -a -o -i /backup
\- If a users's password is expired, and grace logins are 0, does Forgotten Password still work?
AKA: does NMAS's Challenge Response bind need to consume a grace login?
Useful tools:
ndsstat - See eDirectory version
ndsstat -R - See basic tree layout from this servers perspective
ndsconfig get - Retrieve basic settings from the tree as installed on this server (hardware).
ndsmanage - manage one or more instances of eDirectory on the server (hardware).
Example backup call:
sles1164bitsp1:/edirbackup # dsbk backup -f /edirbackup/serverDIBBackup.dibback -l /edirbackup/serverDIBBackup.log -e trivir -w -t -b
\[1\] Instance at /etc/opt/novell/eDirectory/conf/ndsd.conf: test1.O=services.TEST
DSBK Backup/Restore has been started, output is in ndsd.log
sles1164bitsp1:/edirbackup # ndsconfig get | grep ndsd
\[1\] Instance at /etc/opt/novell/eDirectory/conf/ndsd.conf: test1.O=services.TEST
n4u.server.log-file=/var/opt/novell/eDirectory/log/ndsd.log
sles1164bitsp1:/edirbackup #
![[./_resources/Re_Arris_Report_from_conference_call_RE_Edir_DR_infrastructure_discussion.resources/Sample tree.xml]]
