# Bugs:

Bugs:
    2 - AC 3.1 - AC 3.1 email is coming incorrectly from GCV rather than table.
    2 - GL: install explicit access group policy update from Glen
    3 - Fix JDBC driver reset attrs
    2 - AC1.4: UDIdivision should not be reset to S&SS on sync.
    2 - UDIcitizenship is being stripped regardless, it should be stripped first, then set
    4 - GL driver needs some attribute updates (review the previous drivers to confirm updates).
    1 - GL: Group needs to have a sAMAccountName value, clone CN for the value.
    1 - A service account does not appear to be disabled properly (userAccountControl:546 expected, actual: 544)
    2 - Once the password policies are identical: confirm password Expiration Time is set properly.
Changes:
    3 - GL: Avoid removing values from AD attributes that aren't there, causes error.
    2 - UDIvendorInfo: needs to be in the filters for IDV2GSD, GSD2IDV, IDV2UDI, UDI2IDV. We want to migrate this value during the initial migration and then in the execution drivers we want to sync from IDV to GSD and UDI.
    3 - Review eDirectory driver filters for any missing attributes.
    2 - Remove Unix attributes from eDirectory drivers.
    3 - Fixes to Password expiration time (assuming we have fixes as a result of the discussion with Deb)
I'm adding the following to changes as we had assumed Deb would manage these:
    Here's the items that we had assumed Deb would take over, and are discussions with her either way, so are difficult to estimate.
    ? - We need to discuss the status and next steps on your password policies in each environment we are running these drivers in. We've discussed this to some degree so far, but we need to get to a point where all policies are identical.
    ? - There are about 7 password settings for each driver that need to be brought into reconciliation.  Here are the settings I would recommend for all drivers (unless we can come up with reasons for customized settings in each driver).
Changes for later:
    Here's a new object type that was requested, it varies greatly as we have 0 requirement information about 'shopfloor' object types:
    \*16-40 - New functionality needed: 'shopfloor' user type needed.  We need to gather the requirements and the deltas needed for this new user type.

READ MICHAEL'S EMAIL:

Mona,

  As we discussed last week I've put together some estimates around what I think it will take to do an effective on-site production deployment along with the remaining engineering tasks for project completion.

  I believe we've made very good progress so far this week.  Talking with Glen and Aaron, we've been able to make up considerable time and at this point we believe that we will have time to complete a second round of initial migration testing.  This means that we won't need to add any additional on-site testing time for Glen.  At the end of this week we should have 100% coverage with regard to functional testing of both the standard execution and initial migration drivers.  We will also end the week with estimates on how long it will take to do the actual initial migration.

  To give you a small bit of technical detail, whenever a user created in eDirectory, we have to generate a pair of keys (public and private) for the user object.  These keys are used for authentication and encryption when the user connects to eDirectory.  Producing these keys takes significant processor time.  When multiplied across all the users we'll be creating during the initial migration, the total time necessary to create all the users will be significant.  Glen is tracking the amount of time it takes for each step in the migration so we can estimate how much time we'll need to complete the initial migration in production.

  As far as estimating the time we'll need to spend on-site for the production roll out, I've basically assumed we'll be spending a weekend doing the actual initial migration.  Hopefully we could get started late on a Friday afternoon and spend Friday, Saturday and Sunday completing the migration.  To ensure there is plenty of hours available to support the migration and installation, I've estimated 10 hour days across all 3 of these days.  That's 30 hours for the on-site time.  I would also like to allocate 10 hours for off-site post production roll out support.  Given the complexity of the migration, I expect small issues to come up that will need to be fixed manually after we are in production.  Most of these will be quick fixes, but I expect that there will be several hours once everything is added together.  Putting this all together, I think we should add 40 hours to the project for on-site roll out, plus relevant expenses of having someone on-site (hotel, mileage etc.)

  Beyond the on-site roll out, we have a few scope change items that will need to be implemented for a successful delivery.  As often as possible we've planned to delay these changes to after production.  That said, there are a few items that need to be implemented now.  Most of these are small items (2-3 hours a piece) and highly technical in nature so I won't bore you with the details of each change.  The net-net is that these changes are going to add roughly another 40 hours to the project.

  As for the current project state, we're actually right on target with hours.  After Glen finishes his on-site stint this week and Aaron fixes the bugs found this week, we should have about 40 hours left.  This was what we had planned in the beginning leaving 20 hours for off-site support of the production roll out and 20 hours of post delivery support.  These hours we'll hold for Aaron to fix bugs that are found in the respective phases of the project.  Consequently, I don't think we need to add any hours for core engineering activities.  Against all odds, I believe we've roughly kept to the hours plan we started with.

  To summarize, I think we should add about 80 hours to the project.  40 for the list of small engineering scope changes and 40 for the on-site production delivery.  Hopefully this fits inside the reserve allocated for this project.  We're very close to a successful ending and I would hate to derail things over the relatively minor remaining activities.  At this point, we just need to hear from you whether we can move forward with this plan or not.  If you're okay with this then we can immediately begin planning the production roll out with travel logistics etc.

  Thanks for taking the time to read this long email :).  If you have any questions about any of this please feel free to contact me directly.  Thanks,

Michael

Michael Seaver
TriVir LLC
Cell: 801-319-3494
Fax: 703-991-7134
[www.trivir.com](http://www.trivir.com/)
[www.idmunit.org](http://www.idmunit.org/)
