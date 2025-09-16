# Cool Solutions: Understanding the DSRepair Function: "Rebuild Operation Schema" [www.novell.com]

# Understanding the DSRepair Function: "Rebuild Operation Schema"

## Novell Cool Solutions: Tip

|     |     |
| --- | --- |
| [[#\|Digg This]] - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 8 Apr 2002_ |     |

_Here's some new information from the support team regarding an often used but seldom understood DSRepair function. Read on to be enlightened._

To get updates and full details on this tip, see [TID-10069531](http://support.novell.com/cgi-bin/search/searchtid.cgi?/10069531.htm).

Rebuild Operation Schema is commonly run by Novell Support individuals, customers, and consultants. When running this repair it is critical that you understand exactly why or why not to use this option.

The main issues with "rebuild operational schema" are:
  (1) **flags**, and
  (2) **rules** changes
that customers may have done to their tree schema in order to get their customized or third-party applications working "correctly".

By default, when this option is selected we force the local dib schema to comply with what the current loaded DS knows to be its original schema definitions (i.e., flags, rules, OIDs, boundaries, etc.), we leave additions to rules alone, but would add back any removed original rule to the class being checked.

If the current flags found in the dib don't match what the loaded DS believes to be the real definitions, we change them to comply with it. However, this action may have an undersirable consequence for applications the customer may have installed.

An advanced mode "no flag" check allows DSRepair to rebuild the operational schema without modifying any flags that may have been changed by the customer or his/her specific application. This flag is the (-anf) switch.

We only addressed flags because there were few choices to allow for removing or putting back flags on schema attributes/classes that were simple to use. As we all know, we can now use schema editors to add or remove rules without much effort, so no switch was provided for those type of changes.

In essence, we want to give customers the flexibility of making changes in an educated manner but still give him/her the option to fix their trees if such modifications were to cause problems.

**How do you know if Rebuild Operational Schema is safe for your environment?**

In the Local database repair, you deselect everything but: "Use temporary NDS database during repair?" -> YES, and "Rebuild operational schema?" -> YES. You will then see what changes DSRepair is planning on doing to the dib set and have the option to accept the changes or not. Using iMonitor/DSBrowse, you can then check the proposed changes to see if they would indeed affect working applications on your servers and decide whether or not you should save the changes.

Once you have determined whether these changes would adversely affect your system you will know whether or not to run the repair.

[**Like what you see?**
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_Understanding_the_DSRepair_Function_Rebuild_Operation_Schema_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 

[**Want to contribute?**
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_Understanding_the_DSRepair_Function_Rebuild_Operation_Schema_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 

[**Like Wikis?**
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_Understanding_the_DSRepair_Function_Rebuild_Operation_Schema_www.novell.com.resources/unknown_filename.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_Understanding_the_DSRepair_Function_Rebuild_Operation_Schema_www.novell.com.resources/unknown_filename.1.gif]] |     | [**Interested?**<br>Request a sales call ![[./_resources/Cool_Solutions_Understanding_the_DSRepair_Function_Rebuild_Operation_Schema_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_Understanding_the_DSRepair_Function_Rebuild_Operation_Schema_www.novell.com.resources/unknown_filename.2.gif]]

_Novell Cool Solutions (corporate web communities) are produced by WebWise Solutions. [[#|www.webwiseone.com]]_
