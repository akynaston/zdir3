# Awesome Aaron 2018 (Trivir Wins) aawins

2018
\======

1/10/2018 12:30:40 PM - PCAOB: worked a lot with Collin; created a relationship that pushed towards the two new projects totaling 116K.

1/10/2018 12:31:36 PM - Multiple times KUHA came back to us asking for help with things: while they're a smaller client, we have a relation ship of trist wit them that I"ve helped create - My KHA trip was nearly completely self run and executed, and they were happy with the results.

1/24/2018 2:50:47 PM: Arris had replication issues in two trees due to some IDM drivers being deleted and recreated too quickly. I was able to help step in and resolve replication in both trees in about 30 minutes. I believe they've begun to trust us.
     - I've been able to help Joong slow down and consdier other options; which is kinda funny coming from me, the short cut man.

1/29/2018 10:22:27 AM PCAOB & Michelle:
    Helped resolve SSPR errors; multiple times: gave SSPR configuration hints, and LDAP configuratoin, and options to trace the LDAP communicatoin.

 Helped Sadique, Monique, Michelle and others regularly.

12/13/2018 9:10:39 AM- BAE - the US side have repeatedly asked us for help in resolving items, and we've been able to work with them despite Deb's some what delayed responses to us.

12/13/2018 9:11:32 AM- BAES has gone reasonbly well from the engineering side - we've built to resolve some pretty cmplicated rules, despite our desire to make them simpiler.

helped a lot with UMB, have a good relationship with Patrick Beach; and have continujed to support Jason in his work with them.

My main development goal for the team is the trivir backup stuff - my personal goal of forge rock stuff han't been met yet; though I am close to getting access. With the press of Diversey and BAES I'll need to re-evaluate how I'll fit that in this year.

Chris and I have done a lot of work on the backup stuff. While I haven't answered the cloning thing to a satisfactory position; the main goal of getting data backed up for people has been met: Chris and I see various ways that your requirements can be met for backing up laptops; that don't necesarially include cloning; I'll continue research.  The typical path for rebuilding a machine really involves getting something bootable to windows, and having access to your data, and we have mulitple ways to do that now.
     - I have a sales guy I"ve been in contact with and made no commitments to; but I've pushed on getting help with lots of the features, and have answered all of them except for the cloning side.

*  Chris and I also hve other backup options and thoughs around VMS vs system restores; all of which I've been a major part of putting together. I have a few contacts with the company we are thinking to go with, and have receent relatively decent help.

I feel like the lunch and learns have gone well, albiet a little bumpy - Patrick needs to reschedule nad Alex didn't get his LUnch and learn in; I think craming Diversy todo list:

QA
     - Not much left to do; Drivers are moved from on Prem to Azure, will look at the Auth tree in Azure; confirm the driver is up and running.
     - Ensure Changelog module is in the auth tree. . .

Production
     - Email issue: Sravan has given me another test account to test some new tracing flags to see if I can get more info.
         - AS we've mentioned, we know the request for the role is the portion that is failing due to a schema issue; we just need to know what value  is bad and why, then we will decide how to proceed from there.
     - Getting ready for today's move of drivers today at 5, from on prem to Azure in production.
     - Notification:
         - Confirm drivers supposed to be in 'manual' in azure IDV?

FIRST:
     - Sravan - DNS change is updated . . .
         - DNS change . . .
     - Get latest drivers from prod and QA, on prem and off to store in SVN.
QA work:
Done - QA- Move all drivers to Azure, confirm they are working properly.
     - 12/14/2018 9:52:23 AM - Nearly completed; working around designer issue to update loopback driver in QA to finalize testing of new hire email problem as described in issue one 1 above.
done     - Create missing place holder policies in QA to allow Designer 4. deploy.
done     - Finalize Div-Loopback driver deploy.
done     - Re-run hire test in QA to confirm Email population works as expected.
\- Auth tree work:
    - Confirm Auth tree driver in Azure QA IDV is updating Auth tree.
\- Deploy Glen's code to

Prod work
     - Email: add additional flags from Elgie to test role asignemtn issue.
     - Find out if AD association issue is ours or not.
     -

     - migrate drivers now:
        WAITING - get permission: bob & patricl
         - lopback drivers: point to azure . .
         - Glen's policy azure to idv driver . .         
NEW WORK:
     - Investigate switching loopback drivers directly to azure Userapp in prod to see if we can shortcut our fixing.
\- DNS switch from on prem to azure when we're ready (requires 1+ day lead time I think)
    IDV2Azure Migration driver fixes needed (discovered while on the project)
        - IDV2Azure updates needed: fix sync initiated from Azure: currently deletes associations    in Azure.
        - IDV2Azure updates needed: Don't synchronize the Auth driver association; as the auth driver there needs its own association (it's a different destination auth tree).
\- Confirm migration and DIV-loopback driver's can communiate to userapp.
\- Auth tree work:
    - Confirm Auth tree driver in Azure QA IDV is updating Auth tree.
    - Update Auth tree driver as needed to resolve issues.
    - Execute Auth tree driver "migrate from" if needed to update users.
\- Ensure SSPR is running as expected in Azure (Alex doing this I think?)
\- Put tracining back to 0 for the documented drivers.
\- Check in prod: azure driver set, on prem driver set

DONE - Move all drivers to Azure.
(IN process) - confirm they are working properly.
\- Confirm Azure Auth drivers in QA and Prod are properly updating their respective trees.
\- Finalize Email issue: intermittent DAL communication issue.
\- IDV2Azure updates needed: fix sync initiated from Azure: currently deletes associations in Azure.
\- IDV2Azure updates needed: Don't synchronize the Auth driver association; as the auth driver there needs its own association (it's a different destination auth tree).
\- Document workarounds for Designer 4.7 to simplify driver move process in prod.
PROD: Get DNS updates made so the UserApp system can communicate properly when running in Azure.
\- Ensure SSPR is running as expected in Azure (Alex doing this I think?)
\- In the process of moving drivers; not much new to say.
\- Prabhu just reported a repeat of an error, and it looks identical to the issue we saw before; it's acting like it can't authenticate again.  Sravan confirmed the IP address is pointing to the load balancer as it should, and the IP address is the correct load balancer.
     - Prabhu - 7 people impacted . .
\- Then working with Sravan on the password sync.

\- Get DNS updates made so the UserApp system can communicate properly when running in Azure.
\- Move all drivers to Azure, confirm they are working properly.
\- Confirm Azure Auth drivers in QA and Prod are properly updating their respective trees.
\- IDV2Azure updates needed: fix sync initiated from Azure: currently deletes associations in Azure.
\- IDV2Azure updates needed: Don't synchronize the Auth driver association; as the auth driver there needs its own association (it's a different destination auth tree).

I've had a chance to resolve the core issue on issue #1 - We had a bad password on a service account so the roles and entitlements.
I've had a chance to boil down issue 1 to a bad password; I"m working aon a way to reprocess users, and will send through some issue users; this one we may

On the second issue, we've clarified it a little, and I've had a chance to confirm just now that at least one of the three users  Sravan has identified, doesn't have the UserAccount entitlement, so didn't get set to the AD LIV

Diversy traces to set back to zero:
cn=Role and Resource Service Driver,cn=IDM-Driverset,o=services - trace to 0
cn=AD-LDIVNA,cn=IDM-Driverset,o=services - 0

Aaron Heuristics.
1 - Case issues for DNs.
2 - Remove Trivir test specfici items
3 - see build is healthy: maybe add manifest, and validate against manifest? md5s?

ynab lessons:
\- Paying much better attention to everything that happens:
     - found elec and gas bill were confused; paying gas double; lot of unnecessary money on my account
     - Gass bill

it in now would be a mistake.  I did give my how to lunch and learn in march, so I think that was good and went well; though I should have been just a little more proactive about getting people on the calendar.

* I still owe a lunch and learn on Shadow copies; even after we have our backup solution in place; this is still deeply valueable for people to have in addition to the backup informationw e put together - the fact that we can backup data while using it, is so powerful.
* I think we had planned maybe another smaller repeat lunch and learn on some eDirectory resolution or replication 

I've generally improved in communication, and project structure - people know that when I"m involved on a project it will be done the TriVir way, and that I'll push others to do the same.

I continue to work well as a team; in most caess, I"m able to help people effectively; though do struggle when people don't seem to want to dig on their own.

The only major issue I'm having these last few months is knowing how to balance home and work.  Leah's been fiercly sick for a week now; and it's been very tricky to try and decide how to proceed: with Diversey in the state that it is; I don't have a satisfactory plan in place to deal with things like this.  NOrmally the answer is an automated test; but my ability to see into the system in this case is somewhat clouded. Advice on a how to manage this would be greatly apprecaited.

1/16/2019 8:37:10 AM
