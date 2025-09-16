# Cool Solutions: Adding IDM Driver Support for Intruder Lockout Detection on Linux/UNIX - https://www.novell.com/

# Adding IDM Driver Support for Intruder Lockout Detection on Linux/UNIX

## Novell Cool Solutions: Feature
By [Geoffrey Carman](https://www.novell.com/coolsolutions/author/364.html)

|     |     |
| --- | --- |
| [[#\|Digg This]] - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 10 Oct 2007_ |     |

### Introduction

Although the IDM drivers for Linux/Unix support a number of features, a missing one is Intruder Detection on the Unix side. Most of the reason for that is that by default, there is no intruder detection implemented. To add support for this you need a third party PAM module, such as pam\_login\_limit, from http://www.comsmiths.com.au/pam/index.html

To enable IDM driver support for Intruder Detection on Linux/Unix, you need to do these three basic things:

1\. Add support for the authPassword attribute by editing the poll.sh file.

2\. In the Schema mapping, map SolauthPassword in eDirectory to authPassword from the driver, allowing it to flow in both directions on the filter.

3\. Add rules in both directions to map the resulting event to Intruder Lockout.

### Adding Support for the authPassword Attribute

You need to add support for the authPassword attribute by editing the poll.sh file. This file is usually at "/usr/local/nxdrv/scripts/<AuthType>/" - where <AuthType> is either "files", "nis", or "nisplus", depending on what authentication type you are running on the remote Unix system.

First, you must add a rule on the Subscriber channel that converts Locked By Intruder into what NIS expects.

**1**. In the check\_shadow\_changes() function definition, find this block:

       # By default, we do not detect authPassword changes; instead PAM will
        # send by the actual password modification.
        #if \[ "$prev\_authPassword" != "$curr\_authPassword" \]; then
        #  MODIFY\_CMD=$MODIFY\_CMD"REMOVE\_authPassword=$prev\_authPassword$NEWLINE"
        #  MODIFY\_CMD=$MODIFY\_CMD"ADD\_authPassword=$curr\_authPassword$NEWLINE"
        #fi

**2**. Uncomment the "#if-#fi" block.

**3**. Find this block:

      IFS=$IFSSAVE
      prev\_loginName=\`echo "$PREV" | awk -F: '{print $1}'\`
      #prev\_authPassword=\`echo "$PREV" | awk -F: '{print $2}'\`
      prev\_shadowMin=\`echo "$PREV" | awk -F: '{print $4}'\`
      prev\_shadowMax=\`echo "$PREV" | awk -F: '{print $5}'\`
      prev\_shadowWarning=\`echo "$PREV" | awk -F: '{print $6}'\`
      prev\_shadowInactive=\`echo "$PREV" | awk -F: '{print $7}'\`
      prev\_shadowFlag=\`echo "$PREV" | awk -F: '{print $9}'\`

**4**. Uncomment the following line:

#prev\_authPassword=\`echo "$PREV" | awk -F: '{print $2}'\`

**5**. Find this block:

        curr\_loginName=\`echo "$CURR" | awk -F: '{print $1}'\`
        #curr\_authPassword=\`echo "$CURR" | awk -F: '{print $2}'\`
        curr\_shadowMin=\`echo "$CURR" | awk -F: '{print $4}'\`
        curr\_shadowMax=\`echo "$CURR" | awk -F: '{print $5}'\`
        curr\_shadowWarning=\`echo "$CURR" | awk -F: '{print $6}'\`
        curr\_shadowInactive=\`echo "$CURR" | awk -F: '{print $7}'\`
        curr\_shadowFlag=\`echo "$CURR" | awk -F: '{print $9}'\`

**6**. Uncomment the following line:

#curr\_authPassword=\`echo "$CURR" | awk -F: '{print $2}'\`

This will send the attribute authPassword. When an intruder lockout is performed in NIS, it writes to the password field the value \*LK\* which replaces the login password and is taken to mean account is locked. (Linux uses a "!passwordcrypt" which means you can remove the "!" and the password is re-enabled). This means the password on NIS is lost when this happens, because the actual encrypted string is lost. On Linux, however, it can be recovered when you unlock it, by just removing the exclamation mark.

### Mapping the SolauthPassword Attribute

**1**. If it does not already exist, create the SolauthPassword attribute.

**2**. Make sure this attribute has been added to an existing Aux class.

**3**. In the Schema mapping, map SolauthPassword in eDirectory to authPassword from the driver, allowing it to flow in both directions on the filter.

**4**. Remember to set Locked By Intruder to Notify on the Subscriber channel, or else you will not see the event in this driver.

### Adding Rules to Map the Event to Intruder Lockout

You will need to add some rules in both directions to map this event to Intruder Lock out.

**1**. On the Publisher side, add something like this:

<rule>
  <description>Convert NIS's Intruder Lockout to
eDir</description>
  <comment xml:space="preserve">In NIS, the /etc/shadow
file stores the encrypted password.  If you use passwd -l username it sets the
encrypted string to \*LK\*.  When we see the password crypt with a
actual value of \*LK\* that means intruder lockout has been triggered,
so set Locked By Intruder in the Vault, and veto the operation.  If it
changes to anything else, it was a passwd change to the file direct
not through NIS, and we veto it.</comment>
  <conditions>
    <and>
      <if-class-name mode="nocase"
op="equal">User</if-class-name>
        <if-op-attr name="SolauthPassword"
op="available"/>
    </and>
  </conditions>
      <actions>
    <do-set-local-variable
name="incomingAuthPassword" scope="policy">
      <arg-string>
        <token-op-attr name="SolauthPassword"/>
      </arg-string> ;
    </do-set-local-variable>
    <do-if>
      <arg-conditions>
        <and>
          <if-xpath
op="true">$incomingAuthPassword = "\*LK\*"</if-xpath>
        </and>
      </arg-conditions>
      <arg-actions>
        <do-set-dest-attr-value
direct="true" name="Locked By Intruder">
          <arg-value type="string">
            <token-text
xml:space="preserve">true</token-text>
          </arg-value>
        </do-set-dest-attr-value>
        <do-veto/>
    </arg-actions>
      <arg-actions>
        <do-veto/>
      </arg-actions>
    </do-if>
  </actions>
</rule>

**2**. On the Subscriber side, add something like the following pair of rules. (I suppose I could have nested IF's and done it in one rule, but this should work as well.)

<rule>
<description>\[acme\] Convert Intruder Lockout to true for NIS</description>
<comment xml:space="preserve">If Locked By Intruder on eDir, set the
authPassword value to \*LK\*.</comment>
  <conditions>
    <and>
      <if-class-name mode="nocase"< BR>op="equal">User</if-class-name>
      <if-op-attr mode="nocase" name="Locked
By Intruder" op="changing-to">true</if-op-attr>
    </and>
  </conditions>
  <actions>
    <do-set-dest-attr-value direct="true" name="SolauthPassword">
      <arg-value type="string">
        <token-text xml:space="preserve">\*LK\*</token-text>
      </arg-value>
    </do-set-dest-attr-value>
      <do-veto/>
  </actions>
</rule>
<rule>
<description>Convert Intruder Lockout to false for NIS</description>
<comment xml:space="preserve">If Locked By Intruder is cleared on
eDir, set the authPassword value to the current password.</comment>
  <conditions>
    <and>
      <if-class-name mode="nocase" op="equal">User</if-class-name>
      <if-op-attr mode="nocase" name="Locked
By Intruder" op="changing-from">true</if-op-attr>
    </and>
  </conditions>
  <actions>
    <do-set-dest-password direct="true">
      <arg-string>
        <token-attr name="nspmDistributionPassword"/>
      </arg-string>
    </do-set-dest-password>
    <do-veto/>
  </actions>
</rule>

**3**. Finally, test to make sure it is doing exactly what you thought it was doing.

**Examining the Trace**

Here we see the event in a Level 3 trace on the Publisher channel, where the authPassword is changing to \*LK\* coming from NIS. I locked it by attempting to telnet to the Solaris box with a blank password three times, which the pam\_login\_limit interprets as a lockout attempt.

<nds dtdversion="1.1" ndsversion="8.6">
<source>
<product build="20070717\_1304" version="3.5.0"/>
<contact/>
</source>
<input>
<modify class-name="User" event-id="20070808142352Z#0000736830">
<association>E123456User</association>
<modify-attr attr-name="authPassword">
<remove-value>
<value>L4jwSct09Qr66</value>
</remove-value>
<add-value>
<value>\*LK\*</value>
</add-value>
</modify-attr>
</modify>
</input>
</nds>

Then in the trace we see it get to our Event Transformation rule, and here is the rule we wrote firing, and reacting.

03:06:28 9327BBA0 Drvrs: SolarisV PT: Applying rule '\[acme\] Convert
NIS's Intruder Lockout to eDir'.
03:06:28 9327BBA0 Drvrs: SolarisV PT: Action:
do-set-local-variable("incomingAuthPassword",scope="policy",token-op-attr("acmeSolauthPassword")).
03:06:28 9327BBA0 Drvrs: SolarisV PT:
arg-string(token-op-attr("acmeSolauthPassword"))
03:06:28 9327BBA0 Drvrs: SolarisV PT: token-op-attr("acmeSolauthPassword")
03:06:28 9327BBA0 Drvrs: SolarisV PT: Token Value: "\*LK\*".
03:06:28 9327BBA0 Drvrs: SolarisV PT: Arg Value: "\*LK\*".
03:06:28 9327BBA0 Drvrs: SolarisV PT: Action: do-if().
03:06:28 9327BBA0 Drvrs: SolarisV PT: Evaluating conditions.
03:06:28 9327BBA0 Drvrs: SolarisV PT: (if-xpath true
"$incomingAuthPassword = "\*LK\*"") = TRUE.
03:06:28 9327BBA0 Drvrs: SolarisV PT: Performing if actions.
03:06:28 9327BBA0 Drvrs: SolarisV PT: Action:
do-set-dest-attr-value("Locked By Intruder",direct="true","true").
03:06:28 9327BBA0 Drvrs : SolarisV PT: arg-string("true")
03:06:28 9327BBA0 Drvrs: SolarisV PT: token-text("true")
03:06:28 9327BBA0 Drvrs: SolarisV PT: Arg Value: "true".
03:06:28 9327BBA0 Drvrs: SolarisV PT: Action: do-veto().
03:06:28 9327BBA0 Drvrs: SolarisV PT: Direct command from policy
03:06:28 9327BBA0 Drvrs: SolarisV PT:
<nds dtdversion="3.5" ndsversion="8.x">
<source>
<product version="3.5.0.20070315 ">DirXML</product>
<contact>Novell, Inc.</contact>
</source>
<input>
<modify class-name="User" event-id="20070808142352Z#0000736830">
<association>E123456User</association>
<modify-attr attr-name="Locked By Intruder">
<remove-all-values/>
<add-value>
<value type="string">true</value>
</add-value>
</modify-attr>
</modify>
</input>
< /nds>

So "Locked By Intruder" gets set to True, which is what we wanted.

On the subscriber channel, when we clear the Intruder Lockout in eDirectory, we see the following event:

<nds dtdversion="3.5" ndsversion="8.x">
<source>
<product version="3.5.0.20070315 ">DirXML</product>
<contact>Novell, Inc.</contact>
</source>
<input>
<modify class-name="User" event-id="acmeSMSLES10FS1#20070811070833#1#1"
qualified-src-dn="O=LAB\\OU=EMPLOYEES\\OU=ACTIVE\\CN=JUser"
src-dn="\\acme-LAB\\LAB\\EMPLOYEES\\ACTIVE\\JUser" src-entry-id="32951"
timestamp="0#0">
<modify-attr attr-name="Locked By Intruder">
<remove-value>
<value timestamp="1186815988#2" type="state">true</value>
</remove-value>
</modify-attr>
</modify>
</input>
</nds>
03:21:44 932FCBA0 Drvrs: SolarisV ST: Evaluating selection criteria
for rule '\[acme\] Convert Intruder Lockout to true for NIS'.
03:21:44 932FCBA0 Drvrs: SolarisV ST: (if-class-name equal "User") = TRUE.
03:21:44 932FCBA0 Drvrs: SolarisV ST: (if-op-attr 'Locked By Intruder'
changing-to "true") = FALSE.
03:21:44 932FCBA0 Drvrs: SolarisV ST: Rule rejected.
03:21:44 932FCBA0 Drvrs: SolarisV ST: Evaluating selection criteria
for rule '\[acme\] Convert Intruder Lockout to false for NIS'.
03:21:44 932FCBA0 Drvrs: SolarisV ST: (if-class-name equal "User") = TRUE.
03:21:44 932FCBA0 Drvrs: SolarisV ST: (if-op-attr 'Locked By Intruder'
changing-from "true") = TRUE.
03:21:44 932FCBA0 Drvrs: SolarisV ST: Rule selected.
03:21:44 932FCBA0 Drvrs: SolarisV ST: Applying rule '\[acme\] Convert
Intruder Lockout to false for NIS'.
03:21:44 932FCBA0 Drvrs: SolarisV ST: Action:
do-set-dest-password(direct="true",token-attr("nspmDistributionPassword")).
03: 21:44 932FCBA0 Drvrs: SolarisV ST:
arg-string(token-attr("nspmDistributionPassword"))
03:21:44 932FCBA0 Drvrs: SolarisV ST: token-attr("nspmDistributionPassword")
03:21:44 932FCBA0 Drvrs: SolarisV ST: Query from policy
03:21:44 932FCBA0 Drvrs: SolarisV ST:
<nds dtdversion="3.5" ndsversion="8.x">
<source>
<product version="3.5.0.20070315 ">DirXML</product>
<contact>Novell, Inc.</contact>
</source>
<input>
<query class-name="User"
dest-dn="\\acme-LAB\\LAB\\EMPLOYEES\\ACTIVE\\JUser"
dest-entry-id="32951" scope="entry">
<read-attr attr-name="nspmDistributionPassword"/>
</query>
</input>
</nds>
03:21:44 932FCBA0 Drvrs: SolarisV ST: Pumping XDS to eDirectory.
03:21:44 932FCBA0 Drvrs: SolarisV ST: Performing operation query for
\\acme-LAB\\LAB\\EMPLOYEES\\ACTIVE\\JUser.
03:21:44 932FCBA0 Drvrs: SolarisV ST: Q uery from policy result
03:21:44 932FCBA0 Drvrs: SolarisV ST:
<nds dtdversion="3.5" ndsversion="8.x">
<source>
<product version="3.5.0.20070315 ">DirXML</product>
<contact>Novell, Inc.</contact>
</source>
<output>
<instance class-name="User"
qualified-src-dn="O=LAB\\OU=EMPLOYEES\\OU=ACTIVE\\CN=JUser"
src-dn="\\acme-LAB\\LAB\\EMPLOYEES\\ACTIVE\\JUser"
src-entry-id="32951">
<association state="associated">E123456User</association>
<attr attr-name="nspmDistributionPassword"><!-- content suppressed -->
</attr>
</instance>
<status level="success"></status>
</output>
</nds>
03:21:44 932FCBA0 Drvrs: SolarisV ST: Token Value: "-- suppressed --".
03:21:44 932FCBA0 Drvrs: SolarisV ST: Arg Value: "-- suppressed --".
03:21:44 932FCBA0 Drvrs: SolarisV ST : Action: do-veto().
03:21:44 932FCBA0 Drvrs: SolarisV ST: Direct command from policy
03:21:44 932FCBA0 Drvrs: SolarisV ST:
<nds dtdversion="3.5" ndsversion="8.x">
<source>
<product version="3.5.0.20070315 ">DirXML</product>
<contact>Novell, Inc.</contact>
</source>
<input>
<modify-password class-name="User"
event-id="acmeSMSLES10FS1#20070811072144#1#1"
src-dn="\\acme-LAB\\LAB\\EMPLOYEES\\ACTIVE\\JUser"
src-entry-id="32951">
<association>E123456User</association>
<password><!-- content suppressed --></password>
</modify-password>
</input>
</nds>

We see in the rules that Locked By Intruder is changing from True, which means it is no longer locked. So to clear it on the NIS side, we need to reset the password to whatever the user's current password is. Thus we query eDirectory for the nspmDistributionPassword, which is nicely obsfuscated in the trace as the value of "<!-- content suppressed -->" - and then we write it out to NIS.

To see this happen on the NIS side, try the command tail /etc/shadow and you should see the following:

When locked -
E123456:\*LK\*:13733::::::

When normal and active -
E123456:ftCb4qyTwFOWU:13733::::::

(Note that the password is "testing123!" in case you are wondering what generates the encrypted hash).

The third case where Intruder Lockout is triggered in eDirectory looks much the same. The value changes to true, the other rule in the Subscriber Event Transform fires and sets the authPassword to "\*LK\*", and the account is locked. (This one is harder for me to simulate, so I will skip the detailed trace and leave it as an exercise for the reader).

[**Like what you see?**
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_Adding_IDM_Driver_Support_for_Intruder_Lockout_Detection_on_LinuxUNIX_-_httpswww.novell.com.resources/h_link-arrow.gif]]](https://www.novell.com/coolsolutions/forms/subscribe.html) 

[**Want to contribute?**
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_Adding_IDM_Driver_Support_for_Intruder_Lockout_Detection_on_LinuxUNIX_-_httpswww.novell.com.resources/h_link-arrow.gif]]](https://www.novell.com/coolsolutions/forms/submit_a_tip.html) 

[**Like Wikis?**
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_Adding_IDM_Driver_Support_for_Intruder_Lockout_Detection_on_LinuxUNIX_-_httpswww.novell.com.resources/h_link-arrow.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_Adding_IDM_Driver_Support_for_Intruder_Lockout_Detection_on_LinuxUNIX_-_httpswww.novell.com.resources/20060127phone.gif]] |     | [**Interested?**<br>Request a sales call ![[./_resources/Cool_Solutions_Adding_IDM_Driver_Support_for_Intruder_Lockout_Detection_on_LinuxUNIX_-_httpswww.novell.com.resources/h_link-arrow.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_Adding_IDM_Driver_Support_for_Intruder_Lockout_Detection_on_LinuxUNIX_-_httpswww.novell.com.resources/spacer.gif]]

_Novell Cool Solutions (corporate web communities) are produced by WebWise Solutions. [[#|www.webwiseone.com]]_
