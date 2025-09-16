---
tags: ["#Zimbra"]
---
# Example Readme content

\====================================================================================================
Please test the following in this iteration:
 - 1.1.1. Passport Team is created
 - 1.2.1 - Passport Team is enabled for Zimbra Mail Group only
 - 1.2.2. Passport Team is enabled for Zimbra Mail Group and Group Calendar
 - 1.2.3. Passport Team is enabled for Zimbra Mail Group and Team Mailbox
 - 1.2.4. Passport Team is enabled for Zimbra Mail Group, team Calendar, and team Mailbox
 - 1.3.1 - Passport Team is modified: fullName, no Calendor, no Mailbx
 - 1.3.2. Passport Team is modified: full name, no mailbox
 - 1.3.3. Passport Team is modified: fullname, no Calendar
 - 1.3.4. Passport Team is modified: full name, Group, Calendar and Mailbox exist
 - 1.4.1 - Passport Team is disabled for Zimbra Mail Group only (reconfirmed/moved to classify policy)
 - 1.4.1. Passport Team is disabled for Zimbra Mail Group only
 - 1.4.2. Passport Team is disabled for Zimbra Mail Group and Group Calendar
 - 1.4.3. Passport Team is disabled for Zimbra Mail Group and Team Mailbox
 - 1.4.4. Passport Team is disabled for Zimbra Mail Group, team Calendar, and team Mailbox
 - 1.4.5. Passport Team is disabled for team Calendar, and team Mailbox
 - 1.4.6. Passport Team is disabled for team Calendar
 - 1.4.7. Passport Team is disabled for team Mailbox
 - 1.5.1 - Passport Team is deleted
 - 2.1.1 - User is added to a Passport Team: neither Calendar nor Mailbox exist
 - 2.1.2. User is added to a Passport Team: only Calendar Exists
 - 2.1.3. User is added to a Passport Team: only Mailbox Exists
 - 2.1.4. User is added to a Passport Team: Calendar and Mailbox exist.
 - 2.2.1 - User is added/promoted as a Passport Team owner: neither Calendar nor Mailbox exist
 - 2.2.2. User is added/promoted as a Passport Team owner: only Calendar exists
 - 2.2.3. User is added/promoted as a Passport Team owner: only mailbox exists
 - 2.2.3. User is added/promoted as a Passport Team owner: only mailbox exists
 - 2.2.4. User is added/promoted as a Passport Team owner: Calendar and Mailbox exist.
 - 2.2.4. User is added/promoted as a Passport Team owner: Calendar and Mailbox exist.
 - 2.3.1 - User is demoted as Passport Team admin: neither Calendar nor Mailbox exist
 - 2.3.1. User is demoted as Passport Team admin: neither Calendar nor Mailbox exist.
 - 2.3.1. User is demoted as Passport Team admin: neither Calendar nor Mailbox exist.
 - 2.3.2. User is demoted as Passport Team admin: only Calendar exists.
 - 2.3.3. User is demoted as Passport Team admin: only Mailbox exists
 - 2.3.4. User is demoted as Passport Team admin: Calendar and Mailbox both exist.
 - 2.4.1. User(s) is/are removed from Passport Team: Group and Mail Group exist
 - 2.4.1. User(s) is/are removed from Passport Team: neither Calendor nor Mailbox exist.
 - 2.4.2. User(s) is/are removed from Passport Team: Team Mail Group and Calendar exist.
 - 2.4.3. User(s) is/are removed from Passport Team: Team Mail Group and Mailbox exist.
 - 2.4.4. User(s) is/are removed from Passport Team: Team Mail Group, Calendar and Mailbox exist.
 
See the changelog below for additional details.
 
\====================================================================================================
Installation instructions:
 
 - Import the driver using iManager, ensuring rights are set properly.
 - Use the PassportSchema-Updated.ldif as a reference to ensure the latest attributes are added.
  
\====================================================================================================
Known Issues:
 - User Deletion events are not reported on yet.  Assuming that the scripts need to take action on the user in Zimbra when the corresponding user in eDirectory is deleted, this will be a problem as the scripts currently won't be able to distinguish between 2.4.\* AC items and 3.1.\* items (both are simply group membership removals).  
         - This issue affects the following AC items:
                - 3.1.1 - User is deleted from Passport: Mail Group exists
                - 3.1.2. User is deleted from Passport: Mail Group and Calendar exist.
                - 3.1.3. User is deleted from Passport: Mail Group and Mailbox exists.
                - 3.1.4. User is deleted from Passport: Mail Group, Calendar and Mailbox exists
\====================================================================================================
CHANGELOG: Zimbra Driver: Build: BUILDVALUE
Iteration 1:
1.1.1. Passport Team is created
1.2.1. Passport Team is enabled for Zimbra Mail Group only
1.2.2. Passport Team is enabled for Zimbra Mail Group and Group Calendar
1.2.3. Passport Team is enabled for Zimbra Mail Group and Team Mailbox
Release 1b:
 - Fixed bug with adds being vetoed.
Release 2:
 - Fixed configuration values
 - Updated Revision framework to latest.
 - No longer setting association (allowing scripts to accomplish this).
 - Removed ZDOMAIN GCV - Associations are created in scripts now.
 - Cleaned up build scripts.
 - 1.2.1 - Passport Team is enabled for Zimbra Mail Group only
 - 1.3.1 - Passport Team is modified: fullName, no Calendor, no Mailbx
 - 1.4.1 - Passport Team is disabled for Zimbra Mail Group only (reconfirmed/moved to classify policy)
 - 1.5.1 - Passport Team is deleted
 - 2.1.1 - User is added to a Passport Team: neither Calendar nor Mailbox exist
 - 2.2.1 - User is added/promoted as a Passport Team owner: neither Calendar nor Mailbox exist
 - 2.3.1 - User is demoted as Passport Team admin: neither Calendar nor Mailbox exist
 - 2.4.1. User(s) is/are removed from Passport Team: Group and Mail Group exist
 - AC: Changed name of 2.4.1 to 2.4.1. User(s) is/are removed from Passport Team: neither Calendor nor Mailbox exist.
 - 3.1.1 - User is deleted from Passport: Mail Group exists
Additional AC items completed:
 - 1.2.2. Passport Team is enabled for Zimbra Mail Group and Group Calendar
 - 1.2.3. Passport Team is enabled for Zimbra Mail Group and Team Mailbox
 - 1.2.4. Passport Team is enabled for Zimbra Mail Group, team Calendar, and team Mailbox
 - 1.3.2. Passport Team is modified: full name, no mailbox
 - 1.3.3. Passport Team is modified: fullname, no Calendar
 - 1.3.4. Passport Team is modified: full name, Group, Calendar and Mailbox exist
 - 1.4.1. Passport Team is disabled for Zimbra Mail Group only
 - 1.4.2. Passport Team is disabled for Zimbra Mail Group and Group Calendar
 - 1.4.3. Passport Team is disabled for Zimbra Mail Group and Team Mailbox
 - 1.4.4. Passport Team is disabled for Zimbra Mail Group, team Calendar, and team Mailbox
 - 1.4.5. Passport Team is disabled for team Calendar, and team Mailbox
 - 1.4.6. Passport Team is disabled for team Calendar
 - 1.4.7. Passport Team is disabled for team Mailbox
 - 2.1.2. User is added to a Passport Team: only Calendar Exists
 - 2.1.3. User is added to a Passport Team: only Mailbox Exists
 - 2.1.4. User is added to a Passport Team: Calendar and Mailbox exist.
 - 2.2.2. User is added/promoted as a Passport Team owner: only Calendar exists
 - 2.2.3. User is added/promoted as a Passport Team owner: only mailbox exists
 - 2.2.4. User is added/promoted as a Passport Team owner: Calendar and Mailbox exist.
 - 2.3.1. User is demoted as Passport Team admin: neither Calendar nor Mailbox exist.
 - 2.2.3. User is added/promoted as a Passport Team owner: only mailbox exists
 - 2.2.4. User is added/promoted as a Passport Team owner: Calendar and Mailbox exist.
 - 2.3.1. User is demoted as Passport Team admin: neither Calendar nor Mailbox exist.
 - 2.3.2. User is demoted as Passport Team admin: only Calendar exists.
 - 2.3.3. User is demoted as Passport Team admin: only Mailbox exists
 - 2.3.4. User is demoted as Passport Team admin: Calendar and Mailbox both exist.
 - 2.4.1. User(s) is/are removed from Passport Team: neither Calendor nor Mailbox exist.
 - 2.4.2. User(s) is/are removed from Passport Team: Team Mail Group and Calendar exist.
 - 2.4.3. User(s) is/are removed from Passport Team: Team Mail Group and Mailbox exist.
 - 2.4.4. User(s) is/are removed from Passport Team: Team Mail Group, Calendar and Mailbox exist.
