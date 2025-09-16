# Ex2003/2007 - combined email address policies

Ex2003/2007 - combined email address policies

If you upgrade to 2007, my 2003 policies quit working, so ex2003 users dint' get an email.
AFter restarting inormation store, and looking at this, I was sucdesful.
http://www.tek-tips.com/viewthread.cfm?qid=873233

|     |     |
| --- | --- |
| [hbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 2 Jul 04 14:14 |

We have a new user in our office as of today (a temp). In Active Directory on the Exchange 2003 machine, I copied our most recent temp's user and created our new user from that. I then deleted the previous temp.
I setup the new user with her info and then went to log her into her machine - Outlook loaded up and then said that it couldn't find her username on the [server](http://www.tek-tips.com/viewthread.cfm?qid=873233#) (no mailbox).
I doublechcked that I had spelled/typed it correctly and it was. I even went in, killed her mailbox via Active Directory -> Exchange Tasks and created a new one. Still no luck.
I looked in her Active Directory profile and saw that under e-mail addresses, she had nothing. Previously, when creating users, it would automatically create the e-mail info when we setup the user and their mailbox...
I have tried searching and have phoned our other IT guy and both of us are stumped on this.
Any ideas?

|     |     |
| --- | --- |
| ![[./_resources/Ex20032007_-_combined_email_address_policies.resources/star.gif]][FilthPig](http://www.tek-tips.com/userinfo.cfm?member=FilthPig) (MIS) | 2 Jul 04 14:45 |

In Exchange System Manager expand your organization, Recipients, Recipient update service.  Right-click on your RUS for your domain and rebuild it.

Marc Creviere

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 2 Jul 04 15:00 |

There are two RUS there, and I rebuilt both - it says that the changes are done "at the next update interval".
Our update interval is set (for both) at "Always" - so I guess I don't need to wait on that.
We have a small office, so there isn't a lot for it to churn though and neither the PDC nor the mailserver are showing any major load (outside of anything normal).
So would it be safe to assume that it ran?
If so, then it apparently didn't resolve the issue, since the user still has no e-mail addresses showing up under the "e-mail addresses" tab in their Active Directory profile.
"Automatically update addresses based on the recipient policy" is checked for that user on that tab.
And under the default (and only) recipient policy it shows the e-mail configuration that all of the other users show.
Not sure what is causing this - the most recent change (prior to this was the last time we added a new user to the AD) was that the PDC was upgraded to Windows Server 2003 from Server 2000.

|     |     |
| --- | --- |
| ![[./_resources/Ex20032007_-_combined_email_address_policies.resources/star.gif]][FilthPig](http://www.tek-tips.com/userinfo.cfm?member=FilthPig) (MIS) | 2 Jul 04 15:11 |

Now run an update now.

Marc Creviere

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 2 Jul 04 15:29 |

Assuming you mean an update on the RUS - I did that on both of them and still no luck.
(I hadn't looked in that folder before, or at least not in a long time - year or so - so I don't recall if we always had two - but one has our domain name after it, and one has "enterprise configuration" next to it - they are both the same in all other respects... not sure if that matters - I have been rebuilding/updating both as you suggest)
Going into that user's AD profile, the e-mail addresses tab still shows no addresses and she doesn't show up for Outlook either.

|     |     |
| --- | --- |
| ![[./_resources/Ex20032007_-_combined_email_address_policies.resources/star.gif]][FilthPig](http://www.tek-tips.com/userinfo.cfm?member=FilthPig) (MIS) | 2 Jul 04 15:34 |

If you look on that [exchange server's](http://www.tek-tips.com/viewthread.cfm?qid=873233#) mailbox store do you see a mailbox for this user?
Any errors in your event viewers on the exchange machine or domain controllers?

Marc Creviere

|     |     |
| --- | --- |
| [mjpolito](http://www.tek-tips.com/userinfo.cfm?member=mjpolito) (MIS) | 2 Jul 04 15:39 |

Trying going to another [workstation](http://www.tek-tips.com/viewthread.cfm?qid=873233#) & sending an email to this new user.
I think a new account needs to be initialized this way before a mailbox is truly created for them.
Mike

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 2 Jul 04 15:41 |

ahh, good point.
Looking at her AD profile, under "Exchange General" it claims that she has a mailbox at "MAILSERVER/First Storage Group/Mailbox Store (MAILSERVER)", but then if I go in on the server and look in its first storage group and then into the mailboxes - no luck - that user doesn't have anything.
I have even gone so far in the past to right click on the user in AD and do Excahnge Tasks and delete the mailbox that it thinks it has, and then go back in and create one.
This seems to be the issue, but now I have no clue what is causing it.

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 2 Jul 04 15:44 |

Our IT consultant also noted that I should try sending her an e-mail to initialize the account - but I have never had to do this in the past.
I tried it, and she doesn't show up in the addresses in our Outlook, but I just put the address to our domain anyway and then sent it.
Got a message back from the system attendant saying that there is no such user.

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 2 Jul 04 15:51 |

Lots of Group Policy errors in the event log on the PDC.
Gonna need to check that out later - company party just came up :)

|     |     |
| --- | --- |
| ![[./_resources/Ex20032007_-_combined_email_address_policies.resources/star.gif]][FilthPig](http://www.tek-tips.com/userinfo.cfm?member=FilthPig) (MIS) | 2 Jul 04 16:28 |

Maybe you should kick off a cleanup agent on the mailbox store.  Expand System Manager to the 'Mailboxes' underneath your mailbox store.  Right-click on it and 'Run Cleanup Agent'.

Marc Creviere

|     |     |
| --- | --- |
| [houttum](http://www.tek-tips.com/userinfo.cfm?member=houttum) (Instructor) | 2 Jul 04 16:59 |

How about trying to create a new account with a mailbox and seeing whether all goes well?
Steven

|     |     |
| --- | --- |
| ![[./_resources/Ex20032007_-_combined_email_address_policies.resources/star.gif]][xmsre](http://www.tek-tips.com/userinfo.cfm?member=xmsre) (ISP) | 2 Jul 04 18:34 |

The RUS is responsible for processing recipient policies and stamping addresses.  The two most common reason the RUS fails are invalid endpoints and missing address generation dlls.  
You should first verify the endpoints.  You have at least two RUS'; the enterprise RUS and a RUS for each domain.  The domain RUS is the one we are concerned with here.  On the properties of the RUS, make sure it points to a valid domain controller and exchange server.
After you verify the endpoints, check your application log.  Many times fax [software](http://www.tek-tips.com/viewthread.cfm?qid=873233#) or other connectors add proxy address generation DLLs.  If this dll is missing from the exchange server that the RUS is on, an event 2027, 2035, and 2037 will be logged and recipient policies will not be processed.  You can fix this by simply copying the missing dll to the required location as stated in the event.

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 5 Jul 04 10:00 |

I ran the mailbox cleanup, nothing regarding this issue appeared to change.
I created a new user (copying the profile of my own account in this case), and had it create a mailbox with it... no mailbox showed up.
I rebuilt the RUS (both, just for good measure) and also did updates on them.
Still no mailbox for the new user attempt there.
Both RUS point at our primary domain controller.
Looking on both the mailserver and the PDC, there are no event 2027, 2035, nor 2037s.
On the PDC though, there are a ton of 1030 and 1058 (which are the group policy errors that I alluded to before).
Looking here <http://support.microsoft.com/default.aspx?scid=kb;en-us;830676> shows that I should run "dfsutil /PurgeMupCache" (getting that off of the support tools from the Server 2k3 cd).
I did that - still no luck (created a new user, copying my own profile, etc - no mailbox).
So going back to this <http://www.eventid.net/display.asp?eventid=1030&eventno=1542&source=Userenv&phase=1> I can see other things to try to resolve the errors.
We don't have a mutli-homed PDC, so that suggestion is out.
The services that it says need to be started and automatic are indeed started and are automatic - and there are now FRS issues.
We did have a new network anti-virus client on the PDC installed recently by our IT guy (around when we were having the problems - so I went in and excluded the sysvol folders in hopes of that being the issue - the client on this machine takes up a ton of [processor](http://www.tek-tips.com/viewthread.cfm?qid=873233#) time anyway, so for now I have disabled it entirely to try to resolve this issue).
So far nothing I have tried has worked at resolving this issue - but the issue at first glance seems to not be with the mailserver in this case, but instead with the PDC and its inability to have permission/access to the gpt.ini file after our IT consultant came in and converted the Win 2K box to a Win 2k3 system.
Hopefully once this issue is resolved, the mailserver issue will be resolved with it.

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 5 Jul 04 13:33 |

It appears that I have now sorted out the Group Policy issue (after many changes, none of which appeared to stop the errors showing up in the PDC event log every 5 minutes, I finally rebooted and when it came up, threw 4 error events for it, and then hasn't thrown any since... which appears to still be broken perhaps, but isn't doing it every 5 minutes which would seem to be some sort of improvement).
That said - the mailserver issue still stands unresolved - unable to create a mailbox for a user (the process looks successful, and no errors regarding it are thrown on the mailserver event log - but then no mailbox shows up when looking in the system manager).

|     |     |
| --- | --- |
| [McLarnon](http://www.tek-tips.com/userinfo.cfm?member=McLarnon) (TechnicalUser) | 7 Jul 04 4:11 |

esmithbda,
          I just logged on so that I could post about the exact same problem.  I had tried everything that you seem to have after reading various ng's and kb articles.
Anyone got any suggestions?

|     |     |
| --- | --- |
| [McLarnon](http://www.tek-tips.com/userinfo.cfm?member=McLarnon) (TechnicalUser) | 7 Jul 04 5:53 |

I just found a post advising to download and install Service Pack 1 for exchange 2003 as this has been known to fix this problem.  Has anyone tried this or know of any problems that have occured from this service pack?
I'm reluctant to install the service pack as in my experience I have given myself more problems from Windows updates.
Thanks

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 7 Jul 04 8:29 |

We are still having the problem for the most part.
Our IT consultant (I'm really more of a programmer, but I am in house, so I get the IT role if we can't get the consultant in) came in and forced the user's mailbox creation.
She now has a mailbox listed in the mailboxes, but she still doesn't show up when you write an e-mail (not in the GAL).
I just tried to log her into Outlook on her system and it can't find her username either (clearly the same issue as when I try to send e-mail to her).
I really hate installing service packs - as you say, there could be issues that I don't want to add on top of this - and even more so I hate installing them while people are in the office using this.
But this user has gone several days now without e-mail and she is starting to get quite unhappy with me (explaining to her that I have never even seen this happen before seemed to make it worse).
Someone else recommended that we install the service pack 1 here on it (more in passing than as a resolution to any of these issues).
So I guess that is what I will be doing - I'll keep you posted if it breaks anything (although in my experience anything that it breaks won't show up for a day or two).

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 7 Jul 04 9:17 |

Looking here (<http://www.msexchange.org/tutorials/MF017.html>) I saw to check the "showInAddressBook" still wasn't populated - it wasn't. I contemplated just manually forcing it in ADSI Edit, but then decided that was asking for trouble and wouldn't resolve the larger issue.
But it certainly seems like an issue of the RUS not working properly. Our RUS points to the PDC that used to be a Win2k box until it was recently rebuilt as a Win2k3 box by our IT consultant.
It seems very likely that this is the cause of the problem, even though he swears up and down that this couldn't be it - we never had this issue until that event.
Looking at this page (<http://hellomate.typepad.com/exchange/2003/07/is_your_rus_not.html>), it recommends some things to do if the RUS is bad - I am going to look into these before I install the SP1 since I would really rather do that over a weekend with much more time and no users in here.
I will keep this posted as to what I end up figuring out.

|     |     |
| --- | --- |
| [McLarnon](http://www.tek-tips.com/userinfo.cfm?member=McLarnon) (TechnicalUser) | 7 Jul 04 10:05 |

I downloaded the SP1, read the release notes and before installing it decided that I'm holding off for a weekend instead.  (Its like Russian Roulette).
For the time being all of my users are active and not experiencing any problems, I don't have to create an additonal 18 accounts until the end of July so I have some time and I would only kick myself later if the SP1 brought down email.
Keep me posted.
Cheers.

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 7 Jul 04 10:36 |

Here are some things I looked at - it is so frustrating that on these issues everyone is like "oh hey, all you have to do it this and bam, it works!" and then you do it and... nope, doesn't work. And then there is no help for that.
Here are the KB articles I looked at, and how they relate to mine:
Q297124
This looks a lot like our problem, but going through the steps, all of our stuff is checked the way they say, so no go.
Tested after checking this - still doesn't work.
Q319065
I thought this might help. I went into see if the [servers](http://www.tek-tips.com/viewthread.cfm?qid=873233#) weren't working right for this. The enterprise setup let me point at our mailserver and pdc, but then the domain one wouldn't let me point to the pdc - but I could point to the bdc - so I did.
Tried it all again - still didn't work. Then it let me change it back to the pdc (which it had been originally set to), so perhaps the domain one just can't be changed to what it currently already is?
In the end, this didn't help either.
Q286356
This doesn't appear to apply to us. We don't get any error messages logged on the mailserver or the PDC/BDC regarding this.
Q287137
We don't have anything hidden - but just in case I went through and made sure that any special permissions on what they talk about were set to Allow for Modify Permissions.
After testing, this didn't change anything for us.
I checked this ([http://www.ftponline.com/wss/2003_07/magazine/columns/askpros/](http://www.ftponline.com/wss/2003_07/magazine/columns/askpros)), but there was nothing new mentioned in there that helped.
Both Q837444 and this (<http://www.experts-exchange.com/Networking/Email_Groupware/Q_20973671.html>), which are essentially the same thing since the latter links to the former, refer to installing SP1.
I am hoping at this point it will resolve our issue since there doesn't really seem to be much else out there that I haven't tried yet.
Although that isn't exactly the same problem we are having (it talks about errors logged in the event viewer and we aren't seeing any anywhere).
It is almost as if the service just isn't running anywhere - which would point to perhaps the loss of the DLLs (like what xmsre) said up there. Apparently that is usually due to fax software, and we don't have any of that installed.
That said, the IT consultant did add Norton's anti-virus onto the machine and didn't exclude any directories and I am wondering if that screwed something up while it was running that way.
I am going to investigate the dll issue - but I suspect that the SP1 will possibly resolve that, if nothing more than indirectly, due to replacing those with newer/improved dlls anyway.
I thought maybe after all of those changes or attempts, something might have clicked. I also wondered if the fact that copying users would create some different issue (which is usually how I deal with new users).
So I created a new "testuser" account and... same problem.
Many of the "solutions" say to either login to the account via the client machine and Outlook, or to send them an e-mail.
I have tried this repeatedly, and it doesn't work for us. Using Outlook on the machine just says that the user doesn't exist.
Sending them an e-mail, they don't show up in the GAL, and if you do it straight up through SMTP, it gets sent back saying that such a user doesn't exist.
At this point I am going to look into the DLL issue for a bit, and if that doesn't resolve it - then the service pack.
I really don't want to do this prior to the weekend, but I have a trickle down anger situation where a new employee is getting angry at me for not having an e-mail for her, because higher ups are angry at her for not being able to e-mail out to resolve certain issues.
Fantastic.

|     |     |
| --- | --- |
| [McLarnon](http://www.tek-tips.com/userinfo.cfm?member=McLarnon) (TechnicalUser) | 7 Jul 04 12:17 |

You're problem is identical to mine, especially where you said:
"Many of the "solutions" say to either login to the account via the client machine and Outlook, or to send them an e-mail.
I have tried this repeatedly, and it doesn't work for us. Using Outlook on the machine just says that the user doesn't exist.
Sending them an e-mail, they don't show up in the GAL, and if you do it straight up through SMTP, it gets sent back saying that such a user doesn't exist."
Thankfully I don't have anyone on my case just yet and my director (who is quite technially savy) agrees that we should hold fire until a weekend.  I'm still gonna need to bite the bullet and install this SP1 though.
Happy Days, eh!

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 7 Jul 04 12:32 |

We have two DCs, the PDC and the BDC. The PDC has recently been rebuilt from 2k up to 2k3. The BDC is still on 2k sp3 (I have seen reports that there are some issues if the DC is not at least sp3, but we have that covered).
I enabled MSExchangeAL logging to the highest level and all I ever see are 8012 and 8011s. 8012 seems to indicate that it either can't find anything, or doesn't see anything new to update (depending on how you want to interpret it).
Doing searches on that turned a series of newsgroup posts which then led me to run some diagnostics on the DCs. On the 2k3 box, it is failing on FRS tests. On the 2k box it won't even run the diagnostic (apparently doesn't have the support tools installed yet).
While that is not bad, I'm not really sure how much that would break RUS (not saying that it wouldn't, just saying that I don't know off the top of my head if they are related).
Then saw a post recommending this (<http://support.microsoft.com/?id=288807>) and I have long since lost track if I had seen that before - but I think it is new to me.
One of the issues that it recommends is that you check DNS issues.
Just yesterday we ran into a problem where we saw that the IT consultant that rebuilt our PDC up to 2k3 put in the wrong gateway for the two DCs during the process.
This caused the DNS records to eventually just bail and it caused a network issue until we finally traced that down.
So now I am going to follow that path.
Doing an nslookup on our PDC resolves a single IP.
Doing an nslookup on our BDC resolves to two IPs!
Looking into that, it is because we have two modem connections into our office off of the BDC and when they come in, they are given an IP and it attaches to that machine.
Whether or not that breaks this? I have no clue.
I am just stepping down through every possible avenue to see if I can fix this thing without SP1 and then putting that on over the weekend instead of during a workday.

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 7 Jul 04 15:15 |

The FRS issue was resolved, doesn't seem to be related. (they were older event log issues that I wasn't sure if they overlapped/correlated to this issue).
I put in a hosts entry for each DC and their IP on the mailserver.
We have all of the DLLs that are listed as issues with this problem - even though when they are listed it is with a slightly different issue that we have, but at least it is an RUS issue.
Looking back at this (<http://support.microsoft.com/?id=288807>) again, number 3 at the very bottom says to check "msExchPoliciesIncluded" - after checking with LDP.exe on the users that are new, this doesn't exist - but it is there on previously created users (that aren't having problems).
No idea what that means for us, but it is more data for the next person that searches for this sort of thing so that they don't have to also do all of the stupid searching that I am currently trying to do.

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 8 Jul 04 15:53 |

As an update... I set the user up with another account for now (a pre-existing one, which is a silly thing to have to do) until I can come in over the weekend and really get on this thing.
Another thing that has happened out of nowhere is that our OWA went from needing "DomainName\\UserName" when you logged in (even though the domain is filled out in the Exchange node for webmail), and then it stopped requiring that for at least a month, and then... now again requires it as of today. (to be fair it might have started some other time prior to today, but on this last Saturday it definitely did not require it)
Great stuff.
I ran "dcdiag /e /v /c /f:c:\\dcdiag.log" on the PDC (and running it that way finds all of the DCs and then writes it out to the logfile).
There are a few issues that show up in there, so I am trying to resolve those to see if those are the reason we are having this problem.
I tried pointing the RUS to other DCs and I also separately I tried creating an entirely new RUS - neither of those worked to solve my issue.
This machine runs OWA, but it is not a front end. I know that were this a front end, it would not run the RUS services.
I am wondering if there is some way that it thinks it is a front end, even though that box isn't checked in the settings for the server.
I have also read that I should try running the Exchange setup /forestprep and then setup /domainprep again to force through the correct permissions and such.
In the same places that I read to do that, I read a lot of comments saying that it rarely helps.
I am still going to try it this weekend.
I have also seen mention that just rebooting the server fixes this issue - again, I will try that this weekend. (seems a bit retarded to have to do that every time I want to add users)

|     |     |
| --- | --- |
| ![[./_resources/Ex20032007_-_combined_email_address_policies.resources/star.gif]][xmsre](http://www.tek-tips.com/userinfo.cfm?member=xmsre) (ISP) | 9 Jul 04 11:53 |

rerunning domain prep will reset some permissions.  Did you try running policytest to see if you even need to?

|     |     |
| --- | --- |
| ![[./_resources/Ex20032007_-_combined_email_address_policies.resources/star.gif]][paulbenn](http://www.tek-tips.com/userinfo.cfm?member=paulbenn) (Programmer) | 9 Jul 04 17:25 |

Hi guys,
I had this problem today... I run RUS and it put an error in the Application Log.
I rebooted the server and run RUS again and everything now works!!

Kind Regards, Paul Benn
\*\*\*\* Never Giveup, keep trying, the answer is out there!!! \*\*\*\*

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 11 Jul 04 13:26 |

Sure enough, I rebooted the server and checked the user - no emails in her AD panel on the Exchange 2k3 server.
So I opened up the System Manager and went to the RUS.
I should have just hit rebuild and then update now just to see what would happen - but instead I changed it from pointing over to the BDC to the PDC (I had tried this several times prior to the reboot with no positive effect) and then I chose "rebuild" and then after watching the task manager and being satisfied that it wasn't really doing anything - I did "update now" (we have a very small AD tree - about 20 users beyond all built in objects).
I looked in the AD panel for e-mails and sure enough, fully populated.
I was all ready to try any number of things and all it needed was a frickin reboot.
Oh well - at least it went fast over the weekend and now I can use the time here that I had allotted to fix this towards other things.
(I am going to hold off on SP1 for a little while longer - I am always hesitant with those things)

|     |     |
| --- | --- |
| ![[./_resources/Ex20032007_-_combined_email_address_policies.resources/star.gif]][xmsre](http://www.tek-tips.com/userinfo.cfm?member=xmsre) (ISP) | 11 Jul 04 17:56 |

Just out of curiosity, are both domain controllers GCs?  If all of your domain controllers are not global catalogs, then you can have issues with the placement of the Infrastructure Master FSMO role holder.  The infrastructure master should not be on a GC unless all DCs in the forest are GCs.

|     |     |
| --- | --- |
| [esmithbda](http://www.tek-tips.com/userinfo.cfm?member=esmithbda) (IS/IT--Management) | 12 Jul 04 7:41 |

It appears that the PDC is the GC.
I didn't set this up, so I am not particularly familiar with it though.

|     |     |
| --- | --- |
| [dweb](http://www.tek-tips.com/userinfo.cfm?member=dweb) (IS/IT--Management) | 12 Jul 04 15:33 |

Exchange 2003 SP1 fixed this issue for us.
Prior to installing the SP,  Recipient policies (email addresses) were not applied correctly or even at all to new user accounts.  No amount of AD/RUS troubleshooting could fix the problem.
Check your (app) event log for error 8331.
For more info see
<http://support.microsoft.com/default.aspx?scid=kb;en-us;837444&Product=exch2003>
\--David

|     |     |
| --- | --- |
| [b00bies](http://www.tek-tips.com/userinfo.cfm?member=b00bies) (TechnicalUser) | 6 Aug 04 17:48 |

i had the same problem in my test lab with 1 DC, 2 XCH boxes (one front end, one back end) and a live communication box.
when i created a new user account i could not log into the mailbox. after creating a user account i noticed that email properties are empty. so i waited a few minutes for the account settings to populate. when i checked the email address tab in dsa it was still empty. stupid microsnot!
i already had XCH SP1 on both servers and the latest patches on the OS. no errors were being generated in the event logs, everything was clean.
applying the recipient policy did nothing, rebuilding and updating the recipient update service did nothing...yes i tried rebooting<g>.
the only thing i found to resolve my issue was to create a new recipient update service (RUS). now immediately after i create a new user the exchange information is populated and i can access the users mailbox.
i don't know if the default enterprise RUS config is forked or what. if i can get anything further on this i'll post but like i said its my lab config so i may get bored with this problem and play with something else now that everything else \_seems\_ to be ok.
