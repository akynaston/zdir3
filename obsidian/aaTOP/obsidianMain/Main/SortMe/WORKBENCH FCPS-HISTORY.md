# WORKBENCH: FCPS-HISTORY

WORKBENCH: FCPS-HISTORY
2/19/2010 12:49:38 PM
Next step:
 - I need to update the current vm dev env sql with the new supeviers\_+workforceid column, and update the env\\sql file.

2/19/2010 12:49:23 PM
I updated the aalis->gu uiod update a few days agao, and it is in production.

2/11/2010 1:54:33 PM
Ready to deploy alias -> guid update for updatemailboxes, last change was to refactor enable mailbox, and source the script, so we could use $maibox = doenablemailbox, and pull the guid from there.
 - next step: deploy updates into production, I have the goa head from Glen today.

2/3/2010 12:06:14 PM
FCPS:
about 1 hour left of fixing associatoins, and ensuring email policies are not set.
     - report to trisha: rgwarbelow is actually RGWarbelow@fcps.edu . .  in exchange . . (double check this)
         CN=Warbelow\\, Rachel G,OU=Staff,OU=Chesterbrook,OU=ES,DC=fcps,DC=edu has G for her initials now . . .
Intelnk: research
     - two questions: purpetrator
     - identifiyting fields witht he delimited file - was dtf the wrong driver?
BAE - list of fixes, I've estimated them and reported all to Michael, we have a new item, I' estaimte report and then start on the list.

2/17/2010 11:08:31 AM
I sent new tasks for fcps manager notification work. work:
1.5 - Create policy for sending emails
.5 - Create corresponding job
3 - Add code to collect table data from direct reports list
2 - Convert Huston's table-in-html-email java code to ecma script
1 - Come up with selection critieria for those managers needing the notification email.
     - may be 0 hours depending on whether or not I can borrow Glen's code.
2/9/2010 11:02:27 AM
Email from Kathy higham: I responded to glen saying I was slooppy - I need to put together some fixes, and get going on them,a nd do it right this time.
The problem is/was with name changes.  We have one of the scenarios documented below.
Problem:  When an employee’s last name changed, the e-mail address was changed in IDV & Lawson, but not Exchange so the epay notifications got kicked back.  We have hard copies all of the kicked out e-mails.
Resolution:  People started fixing the problem so the epays could be resent, but we are not sure what is being fixed.  We do know that one of the fixes by the Exchange group was to add the new e-mail address to Exchange with a small smtp so the monthly epay notifications could be resent to the original e-mail address - but we are not clear as to what other “fixes” were made.  What fixes have you and Aaron made to fix some of the problems?

\====================================================================================
FCPS
2/18/2010 6:25:47 PM
sent status to glen, still need tasks in - I sent email successfully with replacement of table data, now need to incportate in dirxml, and get direct reports data.

1 - Determine best attribute for identifying managers in Lawson
2 - Define plan for Lawson driver to bring manager identifier into IDV (preferably issue sync event)
3 - Update Lawson driver: write manager dn's, and reciprocate
1 - Determine best attribute for identifying managers in IDV (probably manager or isManager)
1 - Execute plan for updating manager dn's in eDirectory
1.5 - Create policy for sending email notifications
.5 - Create corresponding Manager notification job object
4 - Add code to collect table data from direct reports list
2 - Convert current existing table-in-html-email java code to ECMA script
1 - Come up with selection criteria for those managers needing the notification email.
3 - TEST: Deploy and test on a large scale
1 - PROD: Deploy and spot test.
