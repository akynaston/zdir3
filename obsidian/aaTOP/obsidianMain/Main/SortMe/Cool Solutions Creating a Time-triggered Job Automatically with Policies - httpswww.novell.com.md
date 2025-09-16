# Cool Solutions: Creating a Time-triggered Job Automatically with Policies - https://www.novell.com/

Novell is now a part of [Micro Focus](https://www.microfocus.com/about/at-a-glance)

* [Skip to Content](https://www.novell.com/coolsolutions/appnote/19645.html#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](https://www.novell.com/services/)
* [Partners](https://www.microfocus.com/partners)
* [Communities](http://www.novell.com/communities/)
* [About Us](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

|     |     |
| --- | --- |
|     | ![[]] |

[**Change**](https://www.novell.com/common/util/langselect.php?referer=https%3A//www.novell.com/coolsolutions/appnote/19645.html) **_United States,_ English**

[**Login**](https://www.novell.com/common/util/secure/login.php?r=https://www.novell.com/coolsolutions/appnote/19645.html)

[Close](https://www.novell.com/coolsolutions/appnote/19645.html#)

# Creating a Time-triggered Job Automatically with Policies

## Novell Cool Solutions: AppNote
By [Pekka Kuronen](https://www.novell.com/coolsolutions/author/3909.html)

|     |     |
| --- | --- |
| [[#\|Digg This]] - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 19 Sep 2007_ |     |

### Overview

With IDM 3.5, I noticed a wonderful new feature: I can make time-triggered events, in the spirit of crontab. That ability answered many issues I had going in my projects. The only problem is that you can make only a single-time triggered job, one at a time, with Designer. This produces an LDAP object and calls a Java method to wake it up (presumably copying its key information to IDM's internal cron-like system).

I've managed to make the process automatic, and this AppNote explains how.

Note: This solution was tested in an environment with Novell eDirectory 8.8, Novell Identity Manager 3.5, Designer 2.x.

### Step 1: Create an Admin User

Create a user with admin rights and add the password under your driver configuration to named passwords as "adminpwd".

### Step 2: Create a One-Time Job with Designer

To create a one-time job with Designer,

**1**. Right-click a driver object in Outline view.

**2**. Select New > Job.

**3**. Make the job a Subscriber Channel trigger.

### Step 3: Copy the Job Object to a Text Editor

Use ldapsearch or other LDAP tool to copy the contents of the job object to a text editor.

To ease the pain, here are all attributes of a stripped but working object, set to trigger 08:59 am and delete itself after that:

DirXML-EmailServer :           cn=Default Notification Collection,cn=Security 
DirXML-Scope :                 cn=your\_user,ou=Staff,o=your\_org#0#<scope-def scope="entry">
</scope-def> 
DirXML-ServerList :            cn=your\_server,o=your\_org 
objectClass :                  DirXML-Job 
                               Top
XmlData :                      
<?xml version="1.0" encoding="UTF-8"?>
<job-aggregation><job-definition auto-delete="true" disabled="false" display-name="xlfid(job-display-name)
Subscriber channel trigger" schedule="59 8 \* \* \*" scope-required="false" type="java"><description>xlfid(job-description)
This job submits zero or more trigger documents to the subscriber channel. The
submission may either be a document per object if a scope is defined or may be a single
document for each job run.</description>
<containment>DirXML-Driver</containment><java-class>com.novell.nds.dirxml.job.trigger.Trigger</java-class>
<configuration-values><definitions><definition display-name="xlfid(process-unassociated)Submit a trigger document for
objects without a driver association?" name="process-unassociated"
type="boolean"><value>true</value></definition><group><definition
display-name="xlfid(use-job-cn)Use Job CN as trigger document identifier?"
name="use-job-cn" type="boolean"><description>xlfid(use-job-cn-desc)If set, use the
job object's CN as the value of the trigger element's "source"
attribute.</description><value>true</value></definition><subordinates
active-value="false"><definition display-name="xlfid(trigger-source)Trigger element
source value" name="trigger-source"
type="string"><description>xlfid(trigger-source-desc)String to use as the value for
the trigger element's "source"
attribute.</description>
<value>1</value>
</definition></subordinates></group><group>
<definition display-name="xlfid(submit-method)Method for submitting trigger documents" name="submit-method" type="enum">
<enum-choice display-name="xlfid(submit-queue)queue (use cache)">submit-queue</enum-choice>
<enum-choice display-name="xlfid(submit-direct)direct (bypass cache)">submit-direct</enum-choice>
<value>submit-queue</value>
</definition><subordinates active-value="submit-direct">
<group><definition display-name="xlfid(start-driver)Start driver if not running" name="start-driver" type="boolean">
<value>true</value>
</definition><subordinates active-value="true">
<definition display-name="xlfid(stop-driver)Stop driver when finished processing trigger(s)" name="stop-driver" type="boolean">
<value>true</value>
</definition></subordinates>
</group></subordinates></group>
</definitions></configuration-values></job-definition>
<xliff version="1.0"><file datatype="xliff" original="Trigger.xml" source-language="de" xml:space="preserve">

  <header/>
  <body>
    <trans-unit id="job-display-name">
      <source>Subscriber channel trigger</source>
    </trans-unit>
    <trans-unit id="job-description">
      <source>This job submits zero or more trigger
documents to the subscriber channel. The submission may either be a document per object
if a scope is defined or may be a single document for each job run.</source>
    </trans-unit>
    <trans-unit id="process-unassociated">
      <source>Submit a trigger document for objects without a driver association?</source>
    </trans-unit>
    <trans-unit id="use-job-cn">
      <source>Use Job CN as trigger document identifier?</source>
    </trans-unit>
    <trans-unit id="use-job-cn-desc">
      <source>If set, use the job object's CN as the value of the trigger element's "source" attribute.</source>
    </trans-unit>
    <trans-unit id="trigger-source">
      <source>Trigger element source value</source>
    </trans-unit>
    <trans-unit id="trigger-source-desc">
      <source>String to use as the value for the trigger element's "source" attribute.</source>
    </trans-unit>
    <trans-unit id="submit-method">
      <source>Method for submitting trigger documents</source>
    </trans-unit>
    <trans-unit id="submit-queue">
      <source>queue (use cache)</source>
    </trans-unit>
    <trans-unit id="submit-direct">
      <source>direct (bypass cache)</source>
    </trans-unit>
    <trans-unit id="start-driver">
      <source>Start driver if not running</source>
    </trans-unit>
    <trans-unit id="stop-driver">
      <source>Stop driver when finished processing trigger(s)</source>
    </trans-unit>
  </body>
</file></xliff></job-aggregation>

### Step 4: Create the Policy

Prepare a policy that will react to the wanted event, set correct time parameters and create the object.

Here is an example policy that triggers one hour from now. This is a fully working policy, with object names replaced (YOUR\_TREE, your\_org, your\_user) so you can copy paste but correct following things:

* Policy conditions
* Your driver location
* Default Notification Collection location
* Name of your tree and the naming practice - for example, you may want objects to be named like "job-mycommonname-0859".

<policy xmlns:date="http://www.novell.com/nxsl/java/java.util.Date"
xmlns:dxcommand="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.util.DxCommand"
xmlns:format="http://www.novell.com/nxsl/java/java.text.SimpleDateFormat">
<description>Create a trigger part 1</description>
<rule>
<description>Create a timed job object, set to plus one hour</description>
<comment xml:space="preserve">Use person name and current time for job naming and create under this driver ou. 
Hour must be recalculated because of the +1 hour add (23 + 1 = 00).</comment>
<conditions>
<and>
<if-op-property mode="nocase" name="make\_trigger" op="equal">TRUE</if-op-property>
</and>
</conditions>
<actions>
<do-set-local-variable name="time">
<arg-string>
<token-xpath expression="format:format(format:new('HHmm'),date:new())"/>
</arg-string>
</do-set-local-variable>
<do-set-local-variable name="objectdn" scope="driver">
<arg-string>
<token-text xml:space="preserve">system\\Services\\IDM Driver Set\\</token-text>
<token-global-variable name="ConnectedSystemName"/>
<token-text xml:space="preserve">\\job-</token-text>
<token-src-name/>
<token-text>-</token-text>
<token-local-variable name="time"/>
</arg-string>
</do-set-local-variable>
<do-set-local-variable name="jobdn" scope="driver">
<arg-string>
<token-text xml:space="preserve">job-</token-text>
<token-src-name/>
<token-text>-</token-text>
<token-local-variable name="time"/>
<token-text>.</token-text>
<token-global-variable name="ConnectedSystemName"/>
<token-text xml:space="preserve">.IDM Driver Set.Services.system</token-text>
</arg-string>
</do-set-local-variable>
<do-set-local-variable name="currenthour">
<arg-string>
<token-xpath expression="format:format(format:new('HH'),date:new())"/>
</arg-string>
</do-set-local-variable>
<do-if>
<arg-conditions>
<and>
<if-local-variable mode="nocase" name="currenthour" op="gt">22</if-local-variable>
</and>
</arg-conditions>
<arg-actions>
<do-set-local-variable name="hour" scope="policy">
<arg-string>
<token-text xml:space="preserve">00</token-text>
</arg-string>
</do-set-local-variable>
</arg-actions>
<arg-actions>
<do-set-local-variable name="hour" scope="policy">
<arg-string>
<token-xpath expression="$currenthour+1"/>
</arg-string>
</do-set-local-variable>
</arg-actions>
</do-if>
<do-add-src-object class-name="DirXML-Job">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
</do-add-src-object>
<do-add-src-attr-value name="Object Class">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value>
<token-text xml:space="preserve">Top</token-text>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value name="DirXML-EmailServer">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value>
<token-text xml:space="preserve">Security\\Default Notification Collection</token-text>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value name="DirXML-Scope">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value type="structured">
<arg-component name="nameSpace">
<token-text xml:space="preserve">0</token-text>
</arg-component>
<arg-component name="volume">
<token-replace-all regex="\\\\YOUR\_TREE\\\\" replace-with="">
<token-src-dn/>
</token-replace-all>
</arg-component>
<arg-component name="path">
<token-text xml:space="preserve"><scope-def scope="entry">
</scope-def></token-text>
</arg-component>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value name="DirXML-ServerList">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value>
<token-text xml:space="preserve">your\_org\\your\_server</token-text>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value name="XmlData">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value>
<token-text xml:space="preserve"><?xml version="1.0"
encoding="UTF-8"?><job-aggregation><job-definition auto-delete="true"
disabled="false" display-name="xlfid(job-display-name)Subscriber channel trigger"
schedule="</token-text>
<token-xpath expression="concat(format:format(format:new('mm'),date:new()),' ')"/>
<token-local-variable name="hour"/>
<token-text xml:space="preserve"> \* \* \*" scope-required="false" type="java">
<description>xlfid(job-description)This job submits zero or more trigger
documents to the subscriber channel. The submission may either be a document per object
if a scope is defined or may be a single document for each job run.
</description><containment>DirXML-Driver</containment>
<java-class>com.novell.nds.dirxml.job.trigger.Trigger</java-class>
<configuration-values>
<definitions><definition display-name="xlfid(process-unassociated)
Submit a trigger document for objects without a driver association?"
name="process-unassociated" type="boolean">
<value>true</value></definition>
<group><definition
display-name="xlfid(use-job-cn)Use Job CN as trigger document identifier?"
name="use-job-cn" type="boolean"><description>xlfid(use-job-cn-desc)If set, use the
job object's CN as the value of the trigger element's "source" attribute.</description>
<value>true</value></definition><subordinates
active-value="false">
<definition display-name="xlfid(trigger-source)Trigger element
source value" name="trigger-source" type="string">
<description>xlfid(trigger-source-desc)String to use as the value for
the trigger element's "source" attribute.</description>
<value>1</value></definition></subordinates>
</group><group><definition display-name="xlfid(submit-method)Method for
submitting trigger documents" name="submit-method" type="enum">
<enum-choice display-name="xlfid(submit-queue)queue (use cache)">submit-queue</enum-choice>
<enum-choice display-name="xlfid(submit-direct)direct (bypass cache)">submit-direct</enum-choice>
<value>submit-queue</value></definition><subordinates active-value="submit-direct">
<group><definition display-name="xlfid(start-driver)Start driver if not running" name="start-driver" type="boolean">
<value>true</value></definition><subordinates active-value="true">
<definition display-name="xlfid(stop-driver)Stop driver when finished processing trigger(s)" name="stop-driver" type="boolean">
<value>true</value></definition></subordinates>
</group></subordinates></group></definitions></configuration-values></job-definition>
<xliff version="1.0"><file datatype="xliff" original="Trigger.xml" source-language="de" xml:space="preserve">
  <header/>
  <body>
    <trans-unit id="job-display-name">
      <source>Subscriber channel trigger</source>
    </trans-unit>
    <trans-unit id="job-description">
      <source>This job submits zero or more trigger documents to the subscriber channel. 
The submission may either be a document per object if a scope is defined or may be a single document for each job run.</source>
    </trans-unit>
    <trans-unit id="process-unassociated">
      <source>Submit a trigger document for objects without a driver association?</source>
    </trans-unit>
    <trans-unit id="use-job-cn">
      <source>Use Job CN as trigger document identifier?</source>
    </trans-unit>
    <trans-unit id="use-job-cn-desc">
      <source>If set, use the job object's CN as the value of the trigger element's "source" attribute.</source>
    </trans-unit>
    <trans-unit id="trigger-source">
      <source>Trigger element source value</source>
    </trans-unit>
    <trans-unit id="trigger-source-desc">
      <source>String to use as the value for the trigger element's "source" attribute.</source>
    </trans-unit>
    <trans-unit id="submit-method">
      <source>Method for submitting trigger documents</source>
    </trans-unit>
    <trans-unit id="submit-queue">
      <source>queue (use cache)</source>
    </trans-unit>
    <trans-unit id="submit-direct">
      <source>direct (bypass cache)</source>
    </trans-unit>
    <trans-unit id="start-driver">
      <source>Start driver if not running</source>
    </trans-unit>
    <trans-unit id="stop-driver">
      <source>Stop driver when finished processing trigger(s)</source>
    </trans-unit>
  </body>
 </file></xliff></job-aggregation></token-text>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
<arg-dn>
<token-text xml:space="preserve">system\\Services\\IDM Driver Set\\</token-text>
<token-global-variable name="ConnectedSystemName"/>
</arg-dn>
<arg-value type="structured">
<arg-component name="protectedName">
<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
</arg-component>
<arg-component name="trustee">
<token-local-variable name="objectdn"/>
</arg-component>
<arg-component name="privileges">
<token-text xml:space="preserve">4</token-text>
</arg-component>
</arg-value>
</do-add-src-attr-value>
</actions>
</rule>
</policy>

### Step 5: Activate the Timed Job

Activate the timed job by calling DxCommand java class.

This must be done in a separate policy that comes after the creation of the LDAP object, because we need to use that object in activation. Just to make it "foolproof" I've included a five-second delay (which may be totally worthless, "but you can't blame a hologram for trying"). Again, here's a sample working policy with structure names changed:

<policy xmlns:dxcommand="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.util.DxCommand"
xmlns:thread="http://www.novell.com/nxsl/java/java.lang.Thread">
<description>Create a trigger part 2</description>
<rule>
<description>Activate the newly created job object</description>
<comment xml:space="preserve">Assemble a command and call DxCommand.commandLine to activate the timed job</comment>
<conditions>
<and>
<if-op-property mode="nocase" name="make\_trigger" op="equal">TRUE</if-op-property>
</and>
</conditions>
<actions>
<do-set-local-variable name="javaCommand" scope="policy">
<arg-string>
<token-text xml:space="preserve">-user admin.your\_org </token-text>
<token-text xml:space="preserve">-password </token-text>
<token-named-password name="adminpwd"/>
<token-text xml:space="preserve"> -updatejob "</token-text>
<token-local-variable name="jobdn"/>
<token-text xml:space="preserve">"</token-text>
</arg-string>
</do-set-local-variable>
<do-trace-message level="1">
<arg-string>
<token-text>Updating job object </token-text>
<token-local-variable name="objectdn"/>
<token-xpath expression="thread:sleep('5000')"/>
<token-xpath expression="dxcommand:commandLine(string($javaCommand))"/>
</arg-string>
</do-trace-message>
</actions>
</rule>
</policy>

### Step 6: Add a Policy to React to the Trigger Event

Add a policy to react to the trigger event. You can add it to the policies above, or make a separate policy. Here is an example rule to add to a policy:

<rule>
<description>React to timed job event</description>
<conditions>
<and>
<if-xpath op="true">contains(./@event-id,'trigger-job:')</if-xpath>
<if-op-property name="source" op="available"/>
</and>
</conditions>
<actions>
<do-trace-message>
<arg-string>
<token-text>A trigger event detected</token-text>
</arg-string>
</do-trace-message>
</actions>
</rule>

### Example Policies

Here are a few more example policies you can use.

**Example 1**

<policy xmlns:date="http://www.novell.com/nxsl/java/java.util.Date"
xmlns:dxcommand="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.util.DxCommand"
xmlns:format="http://www.novell.com/nxsl/java/java.text.SimpleDateFormat">
<description>Create a trigger part 1</description>
<rule>
<description>Create a timed job object, set to plus one hour</description>
<comment xml:space="preserve">Use person name and current time for job naming and
create under this driver ou. Hour must be recalculated because of the +1 hour add (23 + 1 = 00).</comment>
<conditions>
<and>
<if-op-property mode="nocase" name="make\_trigger" op="equal">TRUE</if-op-property>
</and>
</conditions>
<actions>
<do-set-local-variable name="time">
<arg-string>
<token-xpath expression="format:format(format:new('HHmm'),date:new())"/>
</arg-string>
</do-set-local-variable>
<do-set-local-variable name="objectdn" scope="driver">
<arg-string>
<token-text xml:space="preserve">system\\Services\\IDM Driver Set\\</token-text>
<token-global-variable name="ConnectedSystemName"/>
<token-text xml:space="preserve">\\job-</token-text>
<token-src-name/>
<token-text>-</token-text>
<token-local-variable name="time"/>
</arg-string>
</do-set-local-variable>
<do-set-local-variable name="jobdn" scope="driver">
<arg-string>
<token-text xml:space="preserve">job-</token-text>
<token-src-name/>
<token-text>-</token-text>
<token-local-variable name="time"/>
<token-text>.</token-text>
<token-global-variable name="ConnectedSystemName"/>
<token-text xml:space="preserve">.IDM Driver Set.Services.system</token-text>
</arg-string>
</do-set-local-variable>
<do-set-local-variable name="currenthour">
<arg-string>
<token-xpath expression="format:format(format:new('HH'),date:new())"/>
</arg-string>
</do-set-local-variable>
<do-if>
<arg-conditions>
<and>
<if-local-variable mode="nocase" name="currenthour" op="gt">22</if-local-variable>
</and>
</arg-conditions>
<arg-actions>
<do-set-local-variable name="hour" scope="policy">
<arg-string>
<token-text xml:space="preserve">00</token-text>
</arg-string>
</do-set-local-variable>
</arg-actions>
<arg-actions>
<do-set-local-variable name="hour" scope="policy">
<arg-string>
<token-xpath expression="$currenthour+1"/>
</arg-string>
</do-set-local-variable>
</arg-actions>
</do-if>
<do-add-src-object class-name="DirXML-Job">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
</do-add-src-object>
<do-add-src-attr-value name="Object Class">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value>
<token-text xml:space="preserve">Top</token-text>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value name="DirXML-EmailServer">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value>
<token-text xml:space="preserve">Security\\Default Notification Collection</token-text>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value name="DirXML-Scope">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value type="structured">
<arg-component name="nameSpace">
<token-text xml:space="preserve">0</token-text>
</arg-component>
<arg-component name="volume">
<token-replace-all regex="\\\\YOUR\_TREE\\\\" replace-with="">
<token-src-dn/>
</token-replace-all>
</arg-component>
<arg-component name="path">
<token-text xml:space="preserve"><scope-def scope="entry">
</scope-def></token-text>
</arg-component>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value name="DirXML-ServerList">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value>
<token-text xml:space="preserve">your\_org\\your\_server</token-text>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value name="XmlData">
<arg-dn>
<token-local-variable name="objectdn"/>
</arg-dn>
<arg-value>
<token-text xml:space="preserve"><?xml version="1.0"
encoding="UTF-8"?><job-aggregation><job-definition auto-delete="true"
disabled="false" display-name="xlfid(job-display-name)Subscriber channel trigger"
schedule="</token-text>
<token-xpath expression="concat(format:format(format:new('mm'),date:new()),' ')"/>
<token-local-variable name="hour"/>
<token-text xml:space="preserve"> \* \* \*" scope-required="false"
type="java"><description>xlfid(job-description)This job submits zero or more trigger
documents to the subscriber channel. The submission may either be a document per object
if a scope is defined or may be a single document for each job
run.</description>
<containment>DirXML-Driver</containment>
<java-class>com.novell.nds.dirxml.job.trigger.Trigger</java-class>
<configuration-values><definitions><definition display-name="xlfid(process-unassociated)Submit a trigger document for
objects without a driver association?" name="process-unassociated"
type="boolean">
<value>true</value></definition><group><definition
display-name="xlfid(use-job-cn)Use Job CN as trigger document identifier?"
name="use-job-cn" type="boolean"><description>xlfid(use-job-cn-desc)If set, use the
job object's CN as the value of the trigger element's "source"
attribute.</description><value>true</value></definition><subordinates
active-value="false"><definition display-name="xlfid(trigger-source)Trigger element
source value" name="trigger-source"
type="string"><description>xlfid(trigger-source-desc)String to use as the value for
the trigger element's "source"
attribute.</description>
<value>1</value></definition></subordinates></group>
<group><definition display-name="xlfid(submit-method)Method for submitting trigger documents" name="submit-method" type="enum">
<enum-choice display-name="xlfid(submit-queue)queue (use cache)">submit-queue</enum-choice>
<enum-choice display-name="xlfid(submit-direct)direct (bypass cache)">submit-direct</enum-choice>
<value>submit-queue</value></definition><subordinates active-value="submit-direct">
<group><definition display-name="xlfid(start-driver)Start driver if not running" name="start-driver" type="boolean">
<value>true</value></definition><subordinates active-value="true">
<definition display-name="xlfid(stop-driver)Stop driver when finished processing trigger(s)" name="stop-driver" type="boolean">
<value>true</value>
</definition></subordinates></group></subordinates></group></definitions></configuration-values></job-definition>
<xliff version="1.0"><file datatype="xliff" original="Trigger.xml" source-language="de" xml:space="preserve">
  <header/>
  <body>
    <trans-unit id="job-display-name">
      <source>Subscriber channel trigger</source>
    </trans-unit>
    <trans-unit id="job-description">
      <source>This job submits zero or more trigger
documents to the subscriber channel. The submission may either be a document per object
if a scope is defined or may be a single document for each job run.</source>
    </trans-unit>
    <trans-unit id="process-unassociated">
      <source>Submit a trigger document for objects without a driver association?</source>
    </trans-unit>
    <trans-unit id="use-job-cn">
      <source>Use Job CN as trigger document identifier?</source>
    </trans-unit>
    <trans-unit id="use-job-cn-desc">
      <source>If set, use the job object's CN as the value of the trigger element's "source" attribute.</source>
    </trans-unit>
    <trans-unit id="trigger-source">
      <source>Trigger element source value</source>
    </trans-unit>
    <trans-unit id="trigger-source-desc">
      <source>String to use as the value for the trigger element's "source" attribute.</source>
    </trans-unit>
    <trans-unit id="submit-method">
      <source>Method for submitting trigger documents</source>
    </trans-unit>
    <trans-unit id="submit-queue">
      <source>queue (use cache)</source>
    </trans-unit>
    <trans-unit id="submit-direct">
      <source>direct (bypass cache)</source>
    </trans-unit>
    <trans-unit id="start-driver">
      <source>Start driver if not running</source>
    </trans-unit>
    <trans-unit id="stop-driver">
      <source>Stop driver when finished processing trigger(s)</source>
    </trans-unit>
  </body>
 </file></xliff></job-aggregation></token-text>
</arg-value>
</do-add-src-attr-value>
<do-add-src-attr-value class-name="DirXML-Driver" name="ACL">
<arg-dn>
<token-text xml:space="preserve">system\\Services\\IDM Driver Set\\</token-text>
<token-global-variable name="ConnectedSystemName"/>
</arg-dn>
<arg-value type="structured">
<arg-component name="protectedName">
<token-text xml:space="preserve">DirXML-AccessSubmitCommand</token-text>
</arg-component>
<arg-component name="trustee">
<token-local-variable name="objectdn"/>
</arg-component>
<arg-component name="privileges">
<token-text xml:space="preserve">4</token-text>
</arg-component>
</arg-value>
</do-add-src-attr-value>
</actions>
</rule>
</policy>

**Example 2**

<policy xmlns:dxcommand="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.util.DxCommand"
xmlns:thread="http://www.novell.com/nxsl/java/java.lang.Thread">
<description>Create a trigger part 2</description>
<rule>
<description>Activate the newly created job object</description>
<comment xml:space="preserve">Assemble a command and call DxCommand.commandLine to activate the timed job</comment>
<conditions>
<and>
<if-op-property mode="nocase" name="make\_trigger" op="equal">TRUE</if-op-property>
</and>
</conditions>
<actions>
<do-set-local-variable name="javaCommand" scope="policy">
<arg-string>
<token-text xml:space="preserve">-user admin.your\_org </token-text>
<token-text xml:space="preserve">-password </token-text>
<token-named-password name="adminpwd"/>
<token-text xml:space="preserve"> -updatejob "</token-text>
<token-local-variable name="jobdn"/>
<token-text xml:space="preserve">"</token-text>
</arg-string>
</do-set-local-variable>
<do-trace-message level="1">
<arg-string>
<token-text>Updating job object </token-text>
<token-local-variable name="objectdn"/>
<token-xpath expression="thread:sleep('5000')"/>
<token-xpath expression="dxcommand:commandLine(string($javaCommand))"/>
</arg-string>
</do-trace-message>
</actions>
</rule>
<rule>
<description>React to timed job event</description>
<conditions>
<and>
<if-xpath op="true">contains(./@event-id,'trigger-job:')</if-xpath>
<if-op-property name="source" op="available"/>
</and>
</conditions>
<actions>
<do-trace-message>
<arg-string>
<token-text>A trigger event detected</token-text>
</arg-string>
</do-trace-message>
</actions>
</rule>
</policy>

### Conclusion

It's important to understand what really happens in the above examples - do not just copy and paste. Note that there is an admin level password and an access to an admin level java class involved here; therefore, the potential for bad things to happen is greater.

[**Like what you see?**
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_Creating_a_Time-triggered_Job_Automatically_with_Policies_-_httpswww.novell.com.resources/h_link-arrow.gif]]](https://www.novell.com/coolsolutions/forms/subscribe.html) 

[**Want to contribute?**
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_Creating_a_Time-triggered_Job_Automatically_with_Policies_-_httpswww.novell.com.resources/h_link-arrow.gif]]](https://www.novell.com/coolsolutions/forms/submit_a_tip.html) 

[**Like Wikis?**
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_Creating_a_Time-triggered_Job_Automatically_with_Policies_-_httpswww.novell.com.resources/h_link-arrow.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_Creating_a_Time-triggered_Job_Automatically_with_Policies_-_httpswww.novell.com.resources/20060127phone.gif]] |     | [**Interested?**<br>Request a sales call ![[./_resources/Cool_Solutions_Creating_a_Time-triggered_Job_Automatically_with_Policies_-_httpswww.novell.com.resources/h_link-arrow.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_Creating_a_Time-triggered_Job_Automatically_with_Policies_-_httpswww.novell.com.resources/spacer.gif]]

_Novell Cool Solutions (corporate web communities) are produced by WebWise Solutions. [[#|www.webwiseone.com]]_

[Advertising in Cool Solutions](http://www.novell.com/coolsolutions/ratecard.html)
[Talk to Us](http://www.novell.com/communities/contact)
[Submit Content](http://www.novell.com/communities/node/1394)
[Subscribe](http://www.novell.com/coolsolutions/forms/subscribe.html)

[Cool Solutions Home (New)](https://www.novell.com/communities/coolsolutions)

[Classic Cool Solutions Home](https://www.novell.com/coolsolutions/index.html)

[Authors](http://www.novell.com/coolsolutions/author/)

[Cool Blogs](https://www.novell.com/communities/coolblogs)

[Cool Solutions Wiki](http://wiki.novell.com/)

[Cool Tools](http://www.novell.com/communities/coolsolutions/tools)

Get Involved  _\>_

[Open Audio (podcasts)](http://www.novell.com/company/podcasts/openaudio.html)

© 2016 Micro Focus

* [Careers](https://jobs.microfocus.com/)

* [Legal](https://www.novell.com/company/legal/)

[close](https://www.novell.com/coolsolutions/appnote/19645.html#)

* [Feedback](https://www.novell.com/inc/feedback/feedback.html)

* [Print](https://www.novell.com/coolsolutions/appnote/19645.html#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](https://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Us](https://www.novell.com/coolsolutions/appnote/19645.html#)
