---
tags: ["#TODO"]
---
# WORKBENCH: INTELINK: AUDITDRIVER

2/2/2010 10:58:59 AM

Aaron,
  Sorry I have not gotten back to you sooner.  We ran into a problem last week causing us to rebuild on of our IDM servers.  Over the next day or so I will install this connector and start testing.
Thanks,
Jessop McCrea
CSC Contractor
Identity Program
Intelligence Community Enterprise services Office of the Director of National Intelligence
410-854-9824

Intelink questions:
Missing attribute definitions:
 - ICEmail
 - IntelinkApps
 - nationality-Extended
 - NiprnetEmail
 - secureTelephoneNumber
 - serviceOrAgency
 - SiprnetEmail
 - usCitizen
Additional findings:
 - Discuss goofy attributes . . .
 - If we really are synchronizing compund attributes,
        we should probably change the dtf delimiter to a |, as we have ACL,s DirXML-Associations.
 - DN has been included in the list of attributes - it would make sense to me to add it to the meta data area:
        change:
                timestamp, objectClass, action, field, field, field...
                to
                timestamp|objectClass|action|dn|field|field|field...

2/19/2010 11:54:04 AM
 - Still need to talk with Mchaela bout work on the perpetrator - possibly chosoing a better audit solution
 - got new work: create a new log for each new day.

2/17/2010 11:10:07 AM
Sent RElease 4 - fixed java.io.File ambiguous errror, I had to move to idm 3.6.1, and 8.8.5 and was able to reproduce the problem.  Called him and toold him where the new settings are, and asked for nay new featers.  AS of this time, we have not done any dev work on perpetrator - we should probly still call his boss.
Sent email to Michael:
Michael,
I just sent a release 4 to Jessop with some fixes, he mentioned they want to go into production about a week from today.  Do we want to have a discussion with his boss to discuss the use of an actual audit product?  I would think we would want to be completed with these discussions this week if they're going into production next Wednesday.
