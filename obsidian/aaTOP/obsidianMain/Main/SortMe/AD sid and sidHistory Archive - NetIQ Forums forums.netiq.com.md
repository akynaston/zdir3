# AD sid and sidHistory [Archive] - NetIQ Forums [forums.netiq.com]

[NetIQ Forums](https://forums.netiq.com/archive/index.php) > [PRODUCT DISCUSSION FORUMS](https://forums.netiq.com/archive/index.php/f-1.html) > [Identity and Access Governance](https://forums.netiq.com/archive/index.php/f-90.html) > [Identity Manager](https://forums.netiq.com/archive/index.php/f-19.html) > [IM: Engine-Drivers](https://forums.netiq.com/archive/index.php/f-22.html) > AD sid and sidHistory
[PDA](https://forums.netiq.com/archive/index.php/t-8081.html?pda=1)

View Full Version : [AD sid and sidHistory](https://forums.netiq.com/showthread.php?8081-AD-sid-and-sidHistory)

joakim ganse
17-Sep-2008, 15:06

Hi,
Im setting up two sd drivers to eventually migrate all the users from
one AD to the other.
For this to be successful I neet to synchronize the sidHistory and
objectsid from the old AD to sidHistory in the new AD.
objectsid is a single valued octet attribute and sidHistory is a
multivalued octet attribute.
Having created an aux-class with two attributes for objectsid and
sidHistory in eDir. If I syncronize, I can read the sid in cleartext in
the level 3 trace and for the objectsid in the "other" tab in iManager.
sidHistory is readable in the trace, it syncronizes fine to eDir but is
not seen in iManager. If I read the attributes with an ldap-browser it
looks strange (its an octet so no surprise) but what is strange is that
the two attributes look diffrent even thou in this case I wrote the same
source attribute (objectsid) to both destination attributes.
When I then try to synchronize sidHistory to the new AD the error is :
<status level="error" type="driver-general"
event-id="AD-Org##11c705d5eeb##0">
<ldap-err ldap-rc="50" ldap-rc-name="LDAP\_INSUFFICIENT\_RIGHTS">
<client-err ldap-rc="50"
ldap-rc-name="LDAP\_INSUFFICIENT\_RIGHTS">Insufficient
Rights</client-err>
<server-err>00000005: SecErr: DSID-031A1169, problem 4003
(INSUFF\_ACCESS\_RIGHTS), data 0
</server-err>
<server-err-ex win32-rc="5"/>
</ldap-err>
</status>
I'm using an account that is member of Domain Admins.
Thanks
Joakim
\--
joakim\_ganse
\------------------------------------------------------------------------
joakim\_ganse's Profile: http://forums.novell.com/member.php?userid=6236
View this thread: http://forums.novell.com/showthread.php?t=343938

ab@novell.com
17-Sep-2008, 15:37

\-----BEGIN PGP SIGNED MESSAGE-----
Hash: SHA1
Trace of the synchronization? iManager not showing an attribute is
interesting.... are you sure the value is on the object you were
checking? In theory the 'Other' sub-tab in iManager should show you all
attributes including those not associated with a specific iManager
plugin. If LDAP Browser sees the values on the object in eDir then
they're definitely there.
Regarding the rights issue.... is it possible to write these values at
all? Some attributes in MAD simply cannot be written from an outside
source via LDAP.
Good luck.
joakim ganse wrote:
\> Hi,
\>
\> Im setting up two sd drivers to eventually migrate all the users from
\> one AD to the other.
\> For this to be successful I neet to synchronize the sidHistory and
\> objectsid from the old AD to sidHistory in the new AD.
\>
\> objectsid is a single valued octet attribute and sidHistory is a
\> multivalued octet attribute.
\>
\> Having created an aux-class with two attributes for objectsid and
\> sidHistory in eDir. If I syncronize, I can read the sid in cleartext in
\> the level 3 trace and for the objectsid in the "other" tab in iManager.
\> sidHistory is readable in the trace, it syncronizes fine to eDir but is
\> not seen in iManager. If I read the attributes with an ldap-browser it
\> looks strange (its an octet so no surprise) but what is strange is that
\> the two attributes look diffrent even thou in this case I wrote the same
\> source attribute (objectsid) to both destination attributes.
\>
\> When I then try to synchronize sidHistory to the new AD the error is :
\> <status level="error" type="driver-general"
\> event-id="AD-Org##11c705d5eeb##0">
\> <ldap-err ldap-rc="50" ldap-rc-name="LDAP\_INSUFFICIENT\_RIGHTS">
\> <client-err ldap-rc="50"
\> ldap-rc-name="LDAP\_INSUFFICIENT\_RIGHTS">Insufficient
\> Rights</client-err>
\> <server-err>00000005: SecErr: DSID-031A1169, problem 4003
\> (INSUFF\_ACCESS\_RIGHTS), data 0
\> </server-err>
\> <server-err-ex win32-rc="5"/>
\> </ldap-err>
\> </status>
\>
\> I'm using an account that is member of Domain Admins.
\>
\> Thanks
\> Joakim
\>
\>
\-----BEGIN PGP SIGNATURE-----
Version: GnuPG v1.4.2 (GNU/Linux)
Comment: Using GnuPG with Mozilla - http://enigmail.mozdev.org
iD8DBQFI0RY73s42bA80+9kRAhVoAJ49wtBEzFgpkKzWjxF+8r H055guJwCeNQ0F
+Pzr/KmCKu8i6hi5/YLln38=
\=xwr2
\-----END PGP SIGNATURE-----

joakim ganse
18-Sep-2008, 09:26

No luck,
You are totally right, with a little investigation I found out that
sidHistory is not possible to write from an outside source via LDAP :-(
Maybe it could be done with the scripting driver if it is possible to
create a script that uses some ms-tools, but that is a long shot.
I am still a bit puzzeld about the attribute not showing up in
iManager, what led me to have a go with an ldap-browser was the fact
that the attribute was removed from the list of attributes not used.
/Joakim
\--
joakim\_ganse
\------------------------------------------------------------------------
joakim\_ganse's Profile: http://forums.novell.com/member.php?userid=6236
View this thread: http://forums.novell.com/showthread.php?t=343938

geoffc
18-Sep-2008, 18:36

joakim\_ganse;1641113 Wrote:
\> No luck,
\>
\> You are totally right, with a little investigation I found out that
\> sidHistory is not possible to write from an outside source via LDAP :-(
\>
\> Maybe it could be done with the scripting driver if it is possible to
\> create a script that uses some ms-tools, but that is a long shot.
\>
\> I am still a bit puzzeld about the attribute not showing up in
\> iManager, what led me to have a go with an ldap-browser was the fact
\> that the attribute was removed from the list of attributes not used.
\>
\> /Joakim
I think this brings up an important enhancement that would be really
nice on the AD driver shim.
We can execute Java code on the engine, during an event, as much as we
would like. Seen lots of great examples to use that to report JVM stack
memory usage, log something to a file, etc.
Would be really nice to be able to execute Java in the remote loader
instance. If we get just Java, that is fine, then all we need is a Java
class that can run arbitrary Win32 executables...
With those two things, many more options become available.
\--
geoffc
\------------------------------------------------------------------------
geoffc's Profile: http://forums.novell.com/member.php?userid=1904
View this thread: http://forums.novell.com/showthread.php?t=343938

ab@novell.com
18-Sep-2008, 18:47

\-----BEGIN PGP SIGNED MESSAGE-----
Hash: SHA1
Done! This is called the Scripting driver. You could also probably
write your own shim to do whatever, but otherwise there is no other
logic in the RL so all you could do was send commands out, which you can
already do with the scripting driver. You could also put the engine on
the box where you need to execute commands, though I know that's not
desirable in most cases on a DC for load reasons....
Good luck.
geoffc wrote:
\> joakim\_ganse;1641113 Wrote:
\>> No luck,
\>>
\>> You are totally right, with a little investigation I found out that
\>> sidHistory is not possible to write from an outside source via LDAP :-(
\>>
\>> Maybe it could be done with the scripting driver if it is possible to
\>> create a script that uses some ms-tools, but that is a long shot.
\>>
\>> I am still a bit puzzeld about the attribute not showing up in
\>> iManager, what led me to have a go with an ldap-browser was the fact
\>> that the attribute was removed from the list of attributes not used.
\>>
\>> /Joakim
\>
\> I think this brings up an important enhancement that would be really
\> nice on the AD driver shim.
\>
\> We can execute Java code on the engine, during an event, as much as we
\> would like. Seen lots of great examples to use that to report JVM stack
\> memory usage, log something to a file, etc.
\>
\> Would be really nice to be able to execute Java in the remote loader
\> instance. If we get just Java, that is fine, then all we need is a Java
\> class that can run arbitrary Win32 executables...
\>
\> With those two things, many more options become available.
\>
\>
\-----BEGIN PGP SIGNATURE-----
Version: GnuPG v1.4.2 (GNU/Linux)
Comment: Using GnuPG with Mozilla - http://enigmail.mozdev.org
iD8DBQFI0pQc3s42bA80+9kRAqiyAJ0Y7SjhauwehGXINjOXM9 W2DeZD6ACfTv9O
i+ViHsMFQbzC6Bnv/WCpIdM=
\=hSla
\-----END PGP SIGNATURE-----

joakim ganse
19-Sep-2008, 13:46

Hi,
Working around this problem, what we actually will do is not useing the
scripting driver but use the text driver to write a list with old-name,
new-name and then use admt to populate the sidHistory.
/Joakim
\--
joakim\_ganse
\------------------------------------------------------------------------
joakim\_ganse's Profile: http://forums.novell.com/member.php?userid=6236
View this thread: http://forums.novell.com/showthread.php?t=343938

ab@novell.com
19-Sep-2008, 16:42

\-----BEGIN PGP SIGNED MESSAGE-----
Hash: SHA1
Interesting. Sounds like a clever workaround. Thank-you for posting it
back here.
Good luck.
joakim ganse wrote:
\> Hi,
\>
\> Working around this problem, what we actually will do is not useing the
\> scripting driver but use the text driver to write a list with old-name,
\> new-name and then use admt to populate the sidHistory.
\>
\> /Joakim
\>
\>
\-----BEGIN PGP SIGNATURE-----
Version: GnuPG v1.4.2 (GNU/Linux)
Comment: Using GnuPG with Mozilla - http://enigmail.mozdev.org
iD8DBQFI08h/3s42bA80+9kRAsHVAJ4pZeEikem2EHB4X/V2ZE1SSDKtlACcDKu5
1MfPNn5YzVKNTFCtGfyT7eI=
\=l7m8
\-----END PGP SIGNATURE-----

Geoffrey Carman
19-Sep-2008, 17:14

I guess my point is, the cost and complexity of the Scripting driver is
not always required, and there are reasonable use cases where it should
be part of the AD driver.
Home directory creation, minor Esxchange Powershell commands to
customize the create, etc...
What is nice is this Cool Solution was just out on the topic this week!
http://www.novell.com/communities/node/6073/exchange-2007-management-shell-cmdlet-execution-within-idm-policy-rules
I need to look into this one, and it may be very very helpful!
ab@novell.com wrote:
\> -----BEGIN PGP SIGNED MESSAGE-----
\> Hash: SHA1
\>
\> Done! This is called the Scripting driver. You could also probably
\> write your own shim to do whatever, but otherwise there is no other
\> logic in the RL so all you could do was send commands out, which you can
\> already do with the scripting driver. You could also put the engine on
\> the box where you need to execute commands, though I know that's not
\> desirable in most cases on a DC for load reasons....
\>
\> Good luck.
\>
\>
\>
\>
\>
\> geoffc wrote:
\>> joakim\_ganse;1641113 Wrote:
\>>> No luck,
\>>>
\>>> You are totally right, with a little investigation I found out that
\>>> sidHistory is not possible to write from an outside source via LDAP :-(
\>>>
\>>> Maybe it could be done with the scripting driver if it is possible to
\>>> create a script that uses some ms-tools, but that is a long shot.
\>>>
\>>> I am still a bit puzzeld about the attribute not showing up in
\>>> iManager, what led me to have a go with an ldap-browser was the fact
\>>> that the attribute was removed from the list of attributes not used.
\>>>
\>>> /Joakim
\>> I think this brings up an important enhancement that would be really
\>> nice on the AD driver shim.
\>>
\>> We can execute Java code on the engine, during an event, as much as we
\>> would like. Seen lots of great examples to use that to report JVM stack
\>> memory usage, log something to a file, etc.
\>>
\>> Would be really nice to be able to execute Java in the remote loader
\>> instance. If we get just Java, that is fine, then all we need is a Java
\>> class that can run arbitrary Win32 executables...
\>>
\>> With those two things, many more options become available.
\>>
\>>
\> -----BEGIN PGP SIGNATURE-----
\> Version: GnuPG v1.4.2 (GNU/Linux)
\> Comment: Using GnuPG with Mozilla - http://enigmail.mozdev.org
\>
\> iD8DBQFI0pQc3s42bA80+9kRAqiyAJ0Y7SjhauwehGXINjOXM9 W2DeZD6ACfTv9O
\> i+ViHsMFQbzC6Bnv/WCpIdM=
\> =hSla
\> -----END PGP SIGNATURE-----

ab@novell.com
19-Sep-2008, 17:24

\-----BEGIN PGP SIGNED MESSAGE-----
Hash: SHA1
Yes, I guess there may be some reasons where it comes in handy there. I
guess submit an enhancement request and let's see what comes of it.
There may be some other reasons for not doing it I haven't thought of,
of course. License fees, complexity.... who knows.
Good luck.
Geoffrey Carman wrote:
\> I guess my point is, the cost and complexity of the Scripting driver is
\> not always required, and there are reasonable use cases where it should
\> be part of the AD driver.
\>
\> Home directory creation, minor Esxchange Powershell commands to
\> customize the create, etc...
\>
\> What is nice is this Cool Solution was just out on the topic this week!
\> http://www.novell.com/communities/node/6073/exchange-2007-management-shell-cmdlet-execution-within-idm-policy-rules
\>
\>
\> I need to look into this one, and it may be very very helpful!
\>
\> ab@novell.com wrote:
\> Done! This is called the Scripting driver. You could also probably
\> write your own shim to do whatever, but otherwise there is no other
\> logic in the RL so all you could do was send commands out, which you can
\> already do with the scripting driver. You could also put the engine on
\> the box where you need to execute commands, though I know that's not
\> desirable in most cases on a DC for load reasons....
\>
\> Good luck.
\>
\>
\>
\>
\>
\> geoffc wrote:
\>>>> joakim\_ganse;1641113 Wrote:
\>>>>> No luck,
\>>>>>
\>>>>> You are totally right, with a little investigation I found out that
\>>>>> sidHistory is not possible to write from an outside source via LDAP :-(
\>>>>>
\>>>>> Maybe it could be done with the scripting driver if it is possible to
\>>>>> create a script that uses some ms-tools, but that is a long shot.
\>>>>>
\>>>>> I am still a bit puzzeld about the attribute not showing up in
\>>>>> iManager, what led me to have a go with an ldap-browser was the fact
\>>>>> that the attribute was removed from the list of attributes not used.
\>>>>>
\>>>>> /Joakim
\>>>> I think this brings up an important enhancement that would be really
\>>>> nice on the AD driver shim.
\>>>>
\>>>> We can execute Java code on the engine, during an event, as much as we
\>>>> would like. Seen lots of great examples to use that to report JVM stack
\>>>> memory usage, log something to a file, etc.
\>>>> Would be really nice to be able to execute Java in the remote loader
\>>>> instance. If we get just Java, that is fine, then all we need is a Java
\>>>> class that can run arbitrary Win32 executables...
\>>>> With those two things, many more options become available.
\>>>>
\>>>>
\-----BEGIN PGP SIGNATURE-----
Version: GnuPG v1.4.2 (GNU/Linux)
Comment: Using GnuPG with Mozilla - http://enigmail.mozdev.org
iD8DBQFI09Ja3s42bA80+9kRAl1EAKCJ63skWGHoHsN8Ln0meX nHbbU5qgCfdjXi
nXy7SgjRn7iOxBOsyzXbPcc=
\=juKa
\-----END PGP SIGNATURE-----

Geoffrey Carman
19-Sep-2008, 17:48

ab@novell.com wrote:
\> -----BEGIN PGP SIGNED MESSAGE-----
\> Hash: SHA1
\>
\> Yes, I guess there may be some reasons where it comes in handy there. I
\> guess submit an enhancement request and let's see what comes of it.
\> There may be some other reasons for not doing it I haven't thought of,
\> of course. License fees, complexity.... who knows.
Handling responses is probably the biggest component. If all you want
is to cast a command and assume it always works, this is probably perfect.
If you want to get a response and react, Scripting is a much better
choice...
\> Good luck.
\>
\>
\>
\>
\>
\> Geoffrey Carman wrote:
\>> I guess my point is, the cost and complexity of the Scripting driver is
\>> not always required, and there are reasonable use cases where it should
\>> be part of the AD driver.
\>>
\>> Home directory creation, minor Esxchange Powershell commands to
\>> customize the create, etc...
\>>
\>> What is nice is this Cool Solution was just out on the topic this week!
\>> http://www.novell.com/communities/node/6073/exchange-2007-management-shell-cmdlet-execution-within-idm-policy-rules
\>>
\>>
\>> I need to look into this one, and it may be very very helpful!
\>>
\>> ab@novell.com wrote:
\>> Done! This is called the Scripting driver. You could also probably
\>> write your own shim to do whatever, but otherwise there is no other
\>> logic in the RL so all you could do was send commands out, which you can
\>> already do with the scripting driver. You could also put the engine on
\>> the box where you need to execute commands, though I know that's not
\>> desirable in most cases on a DC for load reasons....
\>>
\>> Good luck.
\>>
\>>
\>>
\>>
\>>
\>> geoffc wrote:
\>>>>> joakim\_ganse;1641113 Wrote:
\>>>>>> No luck,
\>>>>>>
\>>>>>> You are totally right, with a little investigation I found out that
\>>>>>> sidHistory is not possible to write from an outside source via LDAP :-(
\>>>>>>
\>>>>>> Maybe it could be done with the scripting driver if it is possible to
\>>>>>> create a script that uses some ms-tools, but that is a long shot.
\>>>>>>
\>>>>>> I am still a bit puzzeld about the attribute not showing up in
\>>>>>> iManager, what led me to have a go with an ldap-browser was the fact
\>>>>>> that the attribute was removed from the list of attributes not used.
\>>>>>>
\>>>>>> /Joakim
\>>>>> I think this brings up an important enhancement that would be really
\>>>>> nice on the AD driver shim.
\>>>>>
\>>>>> We can execute Java code on the engine, during an event, as much as we
\>>>>> would like. Seen lots of great examples to use that to report JVM stack
\>>>>> memory usage, log something to a file, etc.
\>>>>> Would be really nice to be able to execute Java in the remote loader
\>>>>> instance. If we get just Java, that is fine, then all we need is a Java
\>>>>> class that can run arbitrary Win32 executables...
\>>>>> With those two things, many more options become available.
\>>>>>
\>>>>>
\> -----BEGIN PGP SIGNATURE-----
\> Version: GnuPG v1.4.2 (GNU/Linux)
\> Comment: Using GnuPG with Mozilla - http://enigmail.mozdev.org
\>
\> iD8DBQFI09Ja3s42bA80+9kRAl1EAKCJ63skWGHoHsN8Ln0meX nHbbU5qgCfdjXi
\> nXy7SgjRn7iOxBOsyzXbPcc=
\> =juKa
\> -----END PGP SIGNATURE-----

ab@novell.com
19-Sep-2008, 17:57

\-----BEGIN PGP SIGNED MESSAGE-----
Hash: SHA1
Yup.
Good luck.
Geoffrey Carman wrote:
\> ab@novell.com wrote:
\> Yes, I guess there may be some reasons where it comes in handy there. I
\> guess submit an enhancement request and let's see what comes of it.
\> There may be some other reasons for not doing it I haven't thought of,
\> of course. License fees, complexity.... who knows.
\>
\>> Handling responses is probably the biggest component. If all you want
\>> is to cast a command and assume it always works, this is probably perfect.
\>
\>> If you want to get a response and react, Scripting is a much better
\>> choice...
\>
\>
\> Good luck.
\>
\>
\>
\>
\>
\> Geoffrey Carman wrote:
\>>>> I guess my point is, the cost and complexity of the Scripting driver is
\>>>> not always required, and there are reasonable use cases where it should
\>>>> be part of the AD driver.
\>>>>
\>>>> Home directory creation, minor Esxchange Powershell commands to
\>>>> customize the create, etc...
\>>>>
\>>>> What is nice is this Cool Solution was just out on the topic this week!
\>>>> http://www.novell.com/communities/node/6073/exchange-2007-management-shell-cmdlet-execution-within-idm-policy-rules
\>>>>
\>>>>
\>>>>
\>>>> I need to look into this one, and it may be very very helpful!
\>>>>
\>>>> ab@novell.com wrote:
\>>>> Done! This is called the Scripting driver. You could also probably
\>>>> write your own shim to do whatever, but otherwise there is no other
\>>>> logic in the RL so all you could do was send commands out, which you can
\>>>> already do with the scripting driver. You could also put the engine on
\>>>> the box where you need to execute commands, though I know that's not
\>>>> desirable in most cases on a DC for load reasons....
\>>>>
\>>>> Good luck.
\>>>>
\>>>>
\>>>>
\>>>>
\>>>>
\>>>> geoffc wrote:
\>>>>>>> joakim\_ganse;1641113 Wrote:
\>>>>>>>> No luck,
\>>>>>>>>
\>>>>>>>> You are totally right, with a little investigation I found out that
\>>>>>>>> sidHistory is not possible to write from an outside source via
\>>>>>>>> LDAP :-(
\>>>>>>>>
\>>>>>>>> Maybe it could be done with the scripting driver if it is
\>>>>>>>> possible to
\>>>>>>>> create a script that uses some ms-tools, but that is a long shot.
\>>>>>>>>
\>>>>>>>> I am still a bit puzzeld about the attribute not showing up in
\>>>>>>>> iManager, what led me to have a go with an ldap-browser was the fact
\>>>>>>>> that the attribute was removed from the list of attributes not used.
\>>>>>>>>
\>>>>>>>> /Joakim
\>>>>>>> I think this brings up an important enhancement that would be really
\>>>>>>> nice on the AD driver shim.
\>>>>>>>
\>>>>>>> We can execute Java code on the engine, during an event, as much
\>>>>>>> as we
\>>>>>>> would like. Seen lots of great examples to use that to report JVM
\>>>>>>> stack
\>>>>>>> memory usage, log something to a file, etc. Would be really nice
\>>>>>>> to be able to execute Java in the remote loader
\>>>>>>> instance. If we get just Java, that is fine, then all we need is
\>>>>>>> a Java
\>>>>>>> class that can run arbitrary Win32 executables... With those two
\>>>>>>> things, many more options become available.
\>>>>>>>
\>>>>>>>
\-----BEGIN PGP SIGNATURE-----
Version: GnuPG v1.4.2 (GNU/Linux)
Comment: Using GnuPG with Mozilla - http://enigmail.mozdev.org
iD8DBQFI09nf3s42bA80+9kRAh4DAJ9dwRUTZaHKnRyUu2popd/AZwKZaQCgg0jw
RG3gFN0kusdfAGUOXbhJNAs=
\=WcV6
\-----END PGP SIGNATURE-----

Lothar Haeger
23-Sep-2008, 12:32

Geoffrey Carman wrote:
\> Handling responses is probably the biggest component. If all you want is to cast a command and assume it always works, this is probably perfect.
\>
\> If you want to get a response and react, Scripting is a much better choice...
the RL (and the engine as well, to make it universally usable) could look for a new operation type e.g. "execute" and run it with java.lang.Runtime.exec() and deliver the returncode in a status message.
Maybe someone skilled could even write a proxy driver shim, that would sit between RL and AD driver (or any other one) and do exactly this, if Novell does not want to build it into the standard RL?
Cheers, Lothar
