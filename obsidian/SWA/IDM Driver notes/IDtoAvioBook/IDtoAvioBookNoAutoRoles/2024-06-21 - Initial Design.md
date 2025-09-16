Initial design discussion - same driver; but no auto roles: myacces  roles yes . .otherwise, get notified; just don't do any auto roles. . .might be as easy as not including an entitlement int he drive r. . .

6/21/2024 1:03:17 PM
Aviobook preprod env
new folks:
  Simo Hraga
  Andy Sampson
  RJ Lemaster

 - Preprod river simliar to the existing driver
 - didn't want any one "in there" loaded by the driver
 - to test userload and database doing something - do need all users and roles in aviobook prelive
 - driver make production updates in prelive driver . .
 - JOe: same exact driver?? - different end point.
 - ever make an update to prod for job codces - want to propagate to prelive . .
 - prelive environment - one different:
   - Users are the same: not attach roles in users . .
   - FA)1 - put them in aviobook . .
   - FA01 - avio_pilot . .
   - provision titlecode -into aviobook
 - same user list; but no role . .
 - one codnition: pre-prod - single environment
 - do everytning - but don't populate role . .
 - Second driver . .
    *** - stand driver
 - New myaccess instalce for the norole driver . .
 - two sets never intersect . .
 - lets them do load testing . .
 - RJ - additional users? yes - myaccess reuqests . .
 - "office pilots" program maangers - still fly the line
 - part of the jobcode for pilots; also do office work.
 - Gary did something to say these users ids don't mess -
 - Gary - added the role manually . .
 - ***Initial migration - reconcile exsting users
 - simo: user service: access service . .audit filestand . . . .?? more for myaccess.
 - Chandu: still needs regular audit file . .
 - IDtoAvioBookNoAutoRole
 -    need to be in prod by 8/15 . .
 -  migration aug 5 . .
 - RJ - asking about validation
 - 'kill it and run again'
 - migrate the users; then nader excel form is empty . .
 - if user colunm is empty - 35K users
QA approval for Cabin, aviobook flight changes (approved for QA in prod on 8/15)
   **** - Technlog approved for Qa, not prod . . October . .
   - Nader out for July - will lead pod - be filling in.
   -
   - https://prelive.swa.aviobook.aero/idp/saml/sp/metadata


4 urls we have:
```

DEV			<param name="drv.baseurl" expression="https://dev.swa.aviobook.aero/idp"/>
QA			<param name="drv.baseurl" expression="https://acc.swa.aviobook.aero/idp"/>
Prod			<param name="drv.baseurl" expression="https://prod.swa.aviobook.aero/idp"/>

	Prelive- Prod: https://prelive.swa.aviobook.aero/idp/

```