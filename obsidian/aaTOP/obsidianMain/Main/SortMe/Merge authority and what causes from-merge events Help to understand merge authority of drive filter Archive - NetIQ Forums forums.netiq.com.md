# Merge authority and what causes from-merge events: Help to understand merge authority of drive filter [Archive] - NetIQ Forums [forums.netiq.com]

[NetIQ Forums](https://forums.netiq.com/archive/index.php) \> [PRODUCT DISCUSSION FORUMS](https://forums.netiq.com/archive/index.php/f-1.html) \> [Identity and Access Governance](https://forums.netiq.com/archive/index.php/f-90.html) \> [Identity Manager](https://forums.netiq.com/archive/index.php/f-19.html) \> [IM: Engine-Drivers](https://forums.netiq.com/archive/index.php/f-22.html) \> Help to understand merge authority of drive filter
[PDA](https://forums.netiq.com/archive/index.php/t-11682.html?pda=1)
**View Full Version :** [Help to understand merge authority of drive filter](https://forums.netiq.com/showthread.php?11682-Help-to-understand-merge-authority-of-drive-filter)

**AlanCota**
12-Nov-2010, 10:36

Hello everyall!

I would like to really understand how works merge authority of my
driver filter. I've an AD IDM driver and I need to send user password
over subscriber chanell when matching found user in AD but when matchin
occours only sAMAccountName (DirXML-ADAliasName) comes from AD and
anyone eDrectory attribute is sent to AD over subscriber.

This is my filter:

<?xml version="1.0" encoding="UTF-8"?><!DOCTYPE filter PUBLIC
"dirxmlfilter" "C:\\Program Files
(x86)\\Novell\\Designer\\plugins\\com.novell.idm.filte r\_3.5.0.200909160331\\DTD\\dirxmlfilter.dtd"><filter>
<filter-class class-name="Group" publisher="sync" subscriber="sync">
<filter-attr attr-name="CN" merge-authority="none" publisher="notify"
subscriber="notify"/>
<filter-attr attr-name="Description" merge-authority="edir"
publisher="ignore" publisher-optimize-modify="false"
subscriber="sync"/>
<filter-attr attr-name="midGroup-System" merge-authority="none"
publisher="ignore" publisher-optimize-modify="false"
subscriber="notify"/>
<filter-attr attr-name="midGroup-Type" merge-authority="none"
publisher="ignore" publisher-optimize-modify="false"
subscriber="notify"/>
<filter-attr attr-name="midGroup-Name" merge-authority="none"
publisher="ignore" publisher-optimize-modify="false"
subscriber="notify"/>
<filter-attr attr-name="DirXML-ADAliasName" merge-authority="default"
publisher="sync" publisher-optimize-modify="true" subscriber="ignore"/>
</filter-class>
<filter-class class-name="User" publisher="sync"
publisher-create-homedir="false" subscriber="sync">
<!--filter-attr attr-name="DirXML-ADContext" publisher="notify"
subscriber="sync"/-->
<!-- login disabled is not synchronized if account is controlled by
entitlements-->
<filter-attr attr-name="nspmDistributionPassword"
merge-authority="none" publisher="ignore"
publisher-optimize-modify="true" subscriber="sync"/>
<!-- turn on entitlement notifications when entitlements are
enabled.
if the user enables entitlements after import this will need to
be
updated manually in the driver filter config via iManager or
Designer. -->
<filter-attr attr-name="DirXML-EntitlementRef" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true"
subscriber="notify"/>
<filter-attr attr-name="midExchangeUser-MDB" merge-authority="none"
publisher="sync" publisher-optimize-modify="true" subscriber="ignore"/>
<filter-attr attr-name="midExchangeUser-Nickname"
merge-authority="none" publisher="sync" publisher-optimize-modify="true"
subscriber="ignore"/>
<filter-attr attr-name="midExchEntAtt7" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true"
subscriber="ignore"/>
<filter-attr attr-name="Surname" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="Telephone Number" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="Given Name" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="midGivennameAltr" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true"
subscriber="notify"/>
<filter-attr attr-name="midSurnameAltr" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true"
subscriber="notify"/>
<filter-attr attr-name="midLogin" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="employeeType" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="workforceID" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="personalTitle" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="Title" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="company" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="Full Name" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="OU" merge-authority="none" publisher="ignore"
publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="Facsimile Telephone Number"
merge-authority="none" publisher="ignore"
publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="DirXML-ADAliasName" merge-authority="app"
publisher="sync" publisher-optimize-modify="true" subscriber="ignore"/>
<filter-attr attr-name="Internet EMail Address" merge-authority="app"
publisher="sync" publisher-optimize-modify="true" subscriber="ignore"/>
<filter-attr attr-name="Login Disabled" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="midDnRede" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true"
subscriber="notify"/>
<filter-attr attr-name="Group Membership" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="midExchangeUser-CMD" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true"
subscriber="notify"/>
<filter-attr attr-name="Login Expiration Time"
merge-authority="default" publisher="ignore"
publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="midFullNameAltr" merge-authority="default"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
<filter-attr attr-name="assistantPhone" merge-authority="default"
publisher="notify" publisher-optimize-modify="true"
subscriber="ignore"/>
<filter-attr attr-name="employeeStatus" merge-authority="default"
publisher="ignore" publisher-optimize-modify="true"
subscriber="notify"/>
</filter-class>
</filter>

What can I change in my filter to send only user password in merge and
when matching rule found a AD user?

Thank you!

\--
\*:cool: Alan Cota | Open Consult | Brazil, Novell Platinum Partner.
CNE | ISM & Security Specialist.
http://www.alancota.net\*
\------------------------------------------------------------------------
AlanCota's Profile: http://forums.novell.com/member.php?userid=1961
View this thread: http://forums.novell.com/showthread.php?t=425782

**florianz**
12-Nov-2010, 14:36

eg.:
<filter-attr attr-name="Surname" merge-authority="none"
publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
will overwrite the value in AD any time, the only way to not let that
happen is to remove it from the filter or strip it out in a policy. if
edir is authoritative for this attribute it is (in most cases one might
want to make sure the data is consistent in all connected systems.

\--
florianz
\------------------------------------------------------------------------
florianz's Profile: http://forums.novell.com/member.php?userid=210
View this thread: http://forums.novell.com/showthread.php?t=425782

**AlanCota**
12-Nov-2010, 15:06

Thank you @florianz. Really my merge authority concept was wrong.

You told:

florianz;2044656 Wrote:
\> eg.:
\> <filter-attr attr-name="Surname" merge-authority="none"
\> publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
\> will overwrite the value in AD any time, the only way to not let that
\> happen is to remove it from the filter or strip it out in a policy. if
\> edir is authoritative for this attribute it is (in most cases one might
\> want to make sure the data is consistent in all connected systems.

But, if this same attribute (surname) had merge-authorty defined to
default, application or identity vault? How will be the result?

Thank you!

\--
\*:cool: Alan Cota | Open Consult | Brazil, Novell Platinum Partner.
CNE | ISM & Security Specialist.
http://www.alancota.net\*
\------------------------------------------------------------------------
AlanCota's Profile: http://forums.novell.com/member.php?userid=1961
View this thread: http://forums.novell.com/showthread.php?t=425782

**sveldhuisen**
12-Nov-2010, 15:36

The above comment is not true. When the merge-authority is set to
"none", the attr is not synchronized when a merge occurs, regardless of
the settings for publisher or subscriber.

If you put subscriber='sync', publisher='ignore' and
merge-authority='default', the Surname of AD gets overwritten with the
value from eDirectory upon a merge.

Hope this clarifies the behavior.

\--
sveldhuisen
\------------------------------------------------------------------------
sveldhuisen's Profile: http://forums.novell.com/member.php?userid=18142
View this thread: http://forums.novell.com/showthread.php?t=425782

**florianz**
12-Nov-2010, 15:36

this is not in accordance with my experience at least (thought of that
as a bug). in my environment <filter-attr attr-name="Description"
merge-authority="none" publisher="sync" publisher-optimize-modify="true"
subscriber="ignore"/> results on change of the ad-description in
overwriting the edir-description (both sides have the attr valued)

\--
florianz
\------------------------------------------------------------------------
florianz's Profile: http://forums.novell.com/member.php?userid=210
View this thread: http://forums.novell.com/showthread.php?t=425782

**sveldhuisen**
12-Nov-2010, 16:06

florianz;2044689 Wrote:
\> this is not in accordance with my experience at least (thought of that
\> as a bug). in my environment <filter-attr attr-name="Description"
\> merge-authority="none" publisher="sync" publisher-optimize-modify="true"
\> subscriber="ignore"/> results on change of the ad-description in
\> overwriting the edir-description (both sides have the attr valued)

That can still happen, due to publisher='sync' with a regular modify
event. The merge-authority is only relevant when a merge occurs. So when
a regualr change on description takes place inside AD, this gets synced
to eDir. This is exactly what your filter defines. What exactly are you
trying to accomplish?

\--
sveldhuisen
\------------------------------------------------------------------------
sveldhuisen's Profile: http://forums.novell.com/member.php?userid=18142
View this thread: http://forums.novell.com/showthread.php?t=425782

**florianz**
12-Nov-2010, 16:06

thanks :)

so one can define on a per-attr basis what happens when, and only when,
two users values (without an association > go through matching) are
thrown together. for all other operations the merge-authority is
irrelevant?

\--
florianz
\------------------------------------------------------------------------
florianz's Profile: http://forums.novell.com/member.php?userid=210
View this thread: http://forums.novell.com/showthread.php?t=425782

**sveldhuisen**
12-Nov-2010, 16:06

florianz;2044700 Wrote:
\> thanks :)
\>
\> so one can define on a per-attr basis what happens when, and only when,
\> two users values (without an association > go through matching) are
\> thrown together. for all other operations the merge-authority is
\> irrelevant?

That is almost correct :-)

The engine has what is termed a "merge" process in which the engine
examines corresponding objects from both eDirectory and the connected
system (e.g., AD). Depending on the filter and its merge-authority
settings, the engine will issue one or more modify commands in each
directory (to eDirectory and to the application).

Issuing a migrate on an already-associated object will result in a
merge
(this is often referred to as a "re-sync"). If a match is found when
migrating a non-associated object this will also result in a merge.

Nifty or what?

\--
sveldhuisen
\------------------------------------------------------------------------
sveldhuisen's Profile: http://forums.novell.com/member.php?userid=18142
View this thread: http://forums.novell.com/showthread.php?t=425782

**florianz**
12-Nov-2010, 16:06

puh.

only operations of op-type "sync" result in a merge then :)?

\--
florianz
\------------------------------------------------------------------------
florianz's Profile: http://forums.novell.com/member.php?userid=210
View this thread: http://forums.novell.com/showthread.php?t=425782

**sveldhuisen**
12-Nov-2010, 16:36

florianz;2044707 Wrote:
\> puh.
\>
\> only operations of op-type "sync" result in a merge then :)?

Nope. A merge can occur by a sync, add or modify event. You can split
them up into 4 originating events:

\- When a sync event occurs on an associated object.
No matching rule is performed, the filter is read with its
merge-authority settings, the engine will issue one or more modify
commands in each directory (to eDirectory and to the application).

\- When a sync event occurs on an unassociated object.
The matching rule is performed, upon a succesful match, the filter is
read with its merge-authority settings, the engine will issue one or
more modify commands in each directory (to eDirectory and to the
application). If no match is found, the sync is converted to a synthetic
add

\- a regular add on an unassociated object. The matching rule is
performed, upon a succesful match, the filter is read with its
merge-authority settings, the engine will issue one or more modify
commands in each directory (to eDirectory and to the application). If
no match is found, the event just continues through the rest of the
channel.

\- a regular modify on an unassociated object. The matching rule is
performed, upon a succesful match, the filter is read with its
merge-authority settings, the engine will issue one or more modify
commands in each directory (to eDirectory and to the application). If
no match is found, the event is converted to a synthetic add.

\--
sveldhuisen
\------------------------------------------------------------------------
sveldhuisen's Profile: http://forums.novell.com/member.php?userid=18142
View this thread: http://forums.novell.com/showthread.php?t=425782
