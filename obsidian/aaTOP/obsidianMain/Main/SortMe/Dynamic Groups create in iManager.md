---
tags: ["#instructions"]
---
# Dynamic Groups: create in iManager

Instructions using iManager 2.7:
 - Authenticate to iManager with administrative credentials.
 - Click on the 'View Objects' button in iManager.
 - Ensure the 'Tree' tab is selected.
 - Browse for the desired destination container for the Group.  These steps will use O=FCPS as the container.
 - Click on the FCPS container on the left so that it's child objects appear on the right hand pane.
 - Click on the new 'New' menu item in the right hand pane.
 - The Create Group screen appears.
 - Name the Group. These steps will use 'countAUPUsers'
 - Ensure the 'Dynamic Group' checkbox is selected.
 - Click Ok.
 - Click Ok on the response screen.
 - In the right hand pane, select the new Group object.
 - Click on the dynamic tab
 - Choose the Settings sub tab (next to the 'Member Query' tab.)
 - Select an identity object: this is the user object with enough rights to read the objectClass, and the fcpsAUPAcceptanceDate attribute for users in the Employees.FCPS container.
 - Select the Member Query sub tab (Next to the Settings sub tab.)
 - For the 'Start search at(Base dn):' field, select the 'Employees.FCPS' container.
 - For the 'Search Scope' select 'Search Sub containers'
 - Click on the pencil icon next to the 'Search filter'.
 - Use the following value: '(&(objectClass=inetOrgPerson)(fcpsAUPAcceptanceDate=\*))'
 - Click apply.
 - Scroll to the bottom of the window - confirm that the 'Query Results: ' section contains the users that have the date set, the count appears below the window.
 - Click Ok.
