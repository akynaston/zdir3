# Identity Manager FAQ - CoolSolutionsWiki [wiki.novell.com]

hard returns in text emails

[![[./_resources/Identity_Manager_FAQ_-_CoolSolutionsWiki_wiki.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](http://wiki.novell.com/index.php/Identity_Manager_FAQ#top)

		### [Solutions](http://www.novell.com/solutions/)
	
		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners & Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[Close](http://wiki.novell.com/index.php/Identity_Manager_FAQ#)

[**LOGOUT**](https://secure-www.novell.com/cmd/ICSLogout)**_Welcome_ Aaron Kynaston**

								

# Identity Manager FAQ

##### Search

  

* [Page](http://wiki.novell.com/index.php/Identity_Manager_FAQ)

* [Discussion](http://wiki.novell.com/index.php/Talk:Identity_Manager_FAQ)
* [Edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit)
* [History](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=history)
* [Move](http://wiki.novell.com/index.php/Special:MovePage/Identity_Manager_FAQ)
* [Watch](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=watch)

This is a living document that can be updated by anybody who is has answers that others might find useful.

## Contents

\[\]

* [1.1 Q: How can I figure out why my driver isn't working?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_How_can_I_figure_out_why_my_driver_isn.27t_working.3F)
* [1.2 Q: How do I trace driver activity?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_How_do_I_trace_driver_activity.3F)
* [1.3 Q: What do the different trace levels mean?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_What_do_the_different_trace_levels_mean.3F)
* [1.4 Q: Beyond tracing, how can I execute tests against IDM drivers?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_Beyond_tracing.2C_how_can_I_execute_tests_against_IDM_drivers.3F)
* [1.5 Q: How do I insert line breaks into email sent from Policy Builder?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_How_do_I_insert_line_breaks_into_email_sent_from_Policy_Builder.3F)

* [2.1 Q: Why am I getting the error "Code(-9065) Unable to determine value of attribute nspmDistributionPassword ...?"](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_Why_am_I_getting_the_error_.22Code.28-9065.29_Unable_to_determine_value_of_attribute_nspmDistributionPassword_....3F.22)

* [3.1 Q: How does the eDirectory Driver work?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_How_does_the_eDirectory_Driver_work.3F)
* [3.2 Q: I've setup the eDirectory drivers, but no data is coming across. Why?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_I.27ve_setup_the_eDirectory_drivers.2C_but_no_data_is_coming_across._Why.3F)

* [4.1 Q: Why can't I get the AD driver to create Users in AD?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_Why_can.27t_I_get_the_AD_driver_to_create_Users_in_AD.3F)
* [4.2 Q: How can I stop my AD users from being created as disabled?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_How_can_I_stop_my_AD_users_from_being_created_as_disabled.3F)
* [4.3 Q: When I create a User in eDirectory from a template that has group memberships assigned, why doesn't the corresponding AD User get assigned membership in the associated AD groups?](http://wiki.novell.com/index.php/Identity_Manager_FAQ#Q:_When_I_create_a_User_in_eDirectory_from_a_template_that_has_group_memberships_assigned.2C_why_doesn.27t_the_corresponding_AD_User_get_assigned_membership_in_the_associated_AD_groups.3F)

## \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=1)\]General

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=2)\]Q: How can I figure out why my driver isn't working?

A: The best place to start to figure out why you driver isn't doing what you think it should be doing is to figure out what it is doing. The way to tell what it is doing is by using trace. You can learn how to use trace using [TID10065332](http://support.novell.com/cgi-bin/search/searchtid.cgi?/10065332.htm).

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=3)\]Q: How do I trace driver activity?

See:

* [TID10065332](http://support.novell.com/cgi-bin/search/searchtid.cgi?/10065332.htm).

* [Capturing and Reading Novell Identity Manager Traces](http://www.novell.com/communities/node/5681/capturing-and-reading-novell-identity-manager-traces)

* [Guide to Reading DSTRACE Output from Identity Manager](http://www.novell.com/communities/node/4428/guide-reading-dstrace-output-identity-manager).

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=4)\]Q: What do the different trace levels mean?

A:

0 - Only event status messages.
1 - Adds basic processing messages.
2 - Adds XML documents that are passed between the engine and drivers.
3 - Adds detailed policy execution and XML documents after policy execution.
4 - Adds more details about events coming from eDirectory.

Some drivers add additional messages for successively higher trace levels, but there is no general meaning assigned to trace levels higher than four.

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=5)\]Q: Beyond tracing, how can I execute tests against IDM drivers?

* See [IDMunit](http://wiki.novell.com/index.php/IDMunit).

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=6)\]Q: How do I insert line breaks into email sent from Policy Builder?

A: There are several ways of accomplishing this:

* In IDM 3.5 you can use the Character token to insert any character based on it's Unicode code point value. New lines are represented differently on different platforms, but it is usually either line feed (10) or carriage return (13) followed by line feed.

<do-send-email server="my.email.server" type="text">
  <arg-string name="to">
    <token-text>me@myself.com</token-text>
  </arg-string>
  <arg-string name="subject">
    <token-text>Multi line email example</token-text>
  </arg-string>
  <arg-string name="message">
    <token-text>Line 1</token-text>
    <token-char value="10"/>
    <token-text>Line 2</token-text>
  </arg-string>
</do-send-email>

* Use the XPath token with an extension function call to java.lang.System.getProperty("line.separator"). Note that depending on the platform IDM is running on, this will return different things.

<policy xmlns:jsystem="http://www.novell.com/nxsl/java/java.lang.System">
  <rule>
    <description>Send multiline email</description>
    <conditions/>
    <actions>
      <do-send-email server="my.email.server" type="text">
        <arg-string name="to">
          <token-text>me@myself.com</token-text>
        </arg-string>
        <arg-string name="subject">
          <token-text>Multi line email example</token-text>
        </arg-string>
        <arg-string name="message">
          <token-text>Line 1</token-text>
          <token-xpath expression="jsystem:getProperty('line.separator')"/>
          <token-text>Line 2</token-text>
        </arg-string>
      </do-send-email>
    </actions>
  </rule>
</policy>

* Write your own Java extension function that return the character sequence you want to use as the line separator and call it from the XPath token.
* If you use Designer, the Text token uses a multi-line text field, which means you can hit the enter key to insert a line feed. Note, however, that if you ever edit that token in iManager the line feed will be removed by the single line edit field used there.
* Use email templates.
* Send email as HTML instead of text and use the standard HTML tags for formatting.

## \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=7)\]Password Synchronization

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=8)\]Q: Why am I getting the error "Code(-9065) Unable to determine value of attribute nspmDistributionPassword ...?"

A: There are a few known causes for this error.

1. You haven't granted the driver sufficient rights. Reading nspmDistributionPassword requires that the driver object have supervisor rights to the User.
2. The password policy assigned to the user doesn't have the "Allow user agent to retrieve password" feature enabled.
3. The Identity Manager server holds a filtered replica of the partition containing the User and you are using a version of NMAS older than 3.1 (older versions of NMAS do not work on filtered replicas).

## \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=9)\]eDir Driver

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=10)\]Q: How does the eDirectory Driver work?

A: The eDirectory driver is unique in that it requires TWO drivers to work - one in each tree. IDM must be installed on a server in each eDirectory. Each eDir driver has its own subscriber and publisher channel. From here it can get confusing as the terminology sometimes changes. Remember that the subscriber channel of one driver connects to the publisher channel of the other and vice versa. Essentially, the job of each driver is to publish and subscribe to XML data for its OWN Indentity Store.

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=11)\]Q: I've setup the eDirectory drivers, but no data is coming across. Why?

A: There could be a couple of reasons. Usually, with the eDirectory driver, replication doesn't occur because of one of the following reasons:

* One or both of the drivers have not been started. Check iManager status for BOTH drivers and also check the driver trace.
* The drivers aren't communicating with each other. Check configuration and dstrace. Each driver should have the correct IP address and port of the other driver.
* Check that the publisher and subscriber information for each driver is effectively the reverse of the other.
* Check that the "full name", "first name" and "last name" fields are populated. Users without these fields populated will not be replicated.
* Users will not be replicated unless a change is made or the 'migrate' button is used to perform a first time migration.

## \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=12)\]AD Driver

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=13)\]Q: Why can't I get the AD driver to create Users in AD?

A: The default AD driver configuration uses Full Name to populate several attributes and to generate the DN of the AD User object. If Full Name has not been populated then the Subscriber Creation policy will prevent the AD User from being created. Possible ways to get around this if your eDirectory Users don't have Full Name populated are:

* Change the rule in your Subscriber Creation Policy that requires _Full Name_ to require _Surname_ and _Given Name_ instead. Add a _set default attribute_ action that sets the default value of _Full Name_ to a value constructed from the _Surname_ and _Given Name_ and writes that value back to eDirectory.
* Remove the rule in your Subscriber Creation Policy that requires _Full Name_. Edit all of the policies that rely on _Full Name_ and change them to rely on something else. Before using this option, note that the reason _Full Name_ is used in the default configuration is because it is needed to emulate the standard naming conventions used when creating users in AD via MMC.

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=14)\]Q: How can I stop my AD users from being created as disabled?

A: AD users are created as disabled if they are created without a password or with a password that does not meet AD's password complexity requirements. Depending on your needs, any one of the following should solve the problem:

* Add a rule to the Subscriber Creation Policy that requires _nspmDistributionPassword_ to be available before the AD user can be created. Make sure that your eDirectory password policy requirements guarantee a password that will meet AD's complexity rules.
* Change the default password generation rule found in in the Subscriber Command Transformation Policy named "Password(Sub)-Default Password Policy" so that it generates a default password that meets AD's complexity requirements.
* Disable AD's complexity requirements.

### \[[edit](http://wiki.novell.com/index.php?title=Identity_Manager_FAQ&action=edit&section=15)\]Q: When I create a User in eDirectory from a template that has group memberships assigned, why doesn't the corresponding AD User get assigned membership in the associated AD groups?

A: Group membership in AD is controlled exclusively on the Group Object, whereas in eDirectory group membership is written to both the Group and User objects. Normally syncronizing the Member attribute of the Group object will allow you to synchronize group membership, but on initial User creation the Member attribute usually tries to synchronize to the Group before the User has been created in AD and therefore will fail (with a warning). You can cause the Member attribute to be updated on the group after the AD user has been created by adding [AD Add Groups Policy](http://wiki.novell.com/index.php/AD_Add_Groups_Policy) to the Subscriber Command Transformation of your AD driver.

Note: The default AD configuration that ships with IDM 3.5 and greater ships with policies that take care of this issue.

[Category](http://wiki.novell.com/index.php/Special:Categories): [Security and Identity](http://wiki.novell.com/index.php/Category:Security_and_Identity)

[![[./_resources/Identity_Manager_FAQ_-_CoolSolutionsWiki_wiki.novell.com.resources/unknown_filename.1.png]]](http://www.mediawiki.org/)

* This page was last modified on 3 January 2009, at 15:58.

* This page has been accessed 18,303 times.
* [About CoolSolutionsWiki](http://wiki.novell.com/index.php/CoolSolutionsWiki:About)
* [Disclaimers](http://wiki.novell.com/index.php/CoolSolutionsWiki:General_disclaimer)

* [Cool Solutions Home](http://www.novell.com/coolsolutions/)

* [Main page](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page)
* [Community portal](http://wiki.novell.com/index.php/CoolSolutionsWiki:Community_portal)
* [Current events](http://wiki.novell.com/index.php/CoolSolutionsWiki:Current_events)
* [Recent changes](http://wiki.novell.com/index.php/Special:RecentChanges)
* [Random page](http://wiki.novell.com/index.php/Special:Random)
* [Help](http://wiki.novell.com/index.php/Help:Contents)
	
	* [Akynaston](http://wiki.novell.com/index.php/User:Akynaston)
	* [My talk](http://wiki.novell.com/index.php/User_talk:Akynaston)
	* [My preferences](http://wiki.novell.com/index.php/Special:Preferences)
	* [My watchlist](http://wiki.novell.com/index.php/Special:Watchlist)
	* [My contributions](http://wiki.novell.com/index.php/Special:Contributions/Akynaston)
	* [Log out](http://wiki.novell.com/index.php?title=Special:UserLogout&returnto=Identity_Manager_FAQ&returntoquery=wpName%3Dakynaston)
	
	* [What links here](http://wiki.novell.com/index.php/Special:WhatLinksHere/Identity_Manager_FAQ)
	* [Related changes](http://wiki.novell.com/index.php/Special:RecentChangesLinked/Identity_Manager_FAQ)
	* [Upload file](http://wiki.novell.com/index.php/Special:Upload)
	* [Special pages](http://wiki.novell.com/index.php/Special:SpecialPages)

[Novell® Making IT Work As One™](http://www.novell.com/company/strategy.html)

* [Careers](http://www.novell.com/company/careers/index.html)

* [Contact Us](http://www.novell.com/company/contacts-offices/)
* [Feedback](http://www.novell.com/inc/feedback/feedback.html)
* [Legal](http://www.novell.com/company/legal/)
* [Print](http://wiki.novell.com/index.php/Identity_Manager_FAQ#)

© 2011 Novell
