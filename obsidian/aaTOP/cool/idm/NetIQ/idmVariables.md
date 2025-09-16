Variables
DirXML Script supports two kinds of variables: global and local. A global variable is a variable that is defined in a global configuration value for the driver or the driver set. Global variables are by definition read-only. A local variable is a variable that is set by a policy. A local variable can exist in one of two different scopes: policy or driver. A policy-scoped variable is only visible during the processing of the current operation by the policy that sets the variable. A driver-scoped variable is visible from all DirXML Script policies running within the same driver until the driver is stopped.

A variable name must be a legal XML name. For information on what is a legal XML name, see W3C Extensible Markup Language (XML).

There are a number of global and local variables that are automatically defined.

Table 4-2 Defined Global and Local Variables

Name

Type

Description

dirxml.auto.driverdn

global/string

Slash format DN of the current driver.

dirxml.auto.localserverdn

global/string

DN of the local server where the current driver is running in LDAP format.

dirxml.auto.driverguid

global/string

GUID of the current driver.

dirxml.auto.treename

global/string

Tree name of the local eDirectory instance.

fromNds

policy local/boolean

True if the source data store is the Identity Vault. False if the source data store is the connected application.

destQueryProcessor

policy local/java object

Instance of XdsQueryProcessor used to query the destination data store.

srcQueryProcessor

policy local/java object

Instance of XdsQueryProcessor used to query the source data store.

destCommandProcessor

policy local/java object

Instance of XdsCommandProcessor used to execute the command using the destination data store.

srcCommandProcessor

policy local/java object

Instance of XdsCommandProcessor used to execute the command using the source data store.

dnConverter

policy local/java object

Instance of DNConverter.

current-node

policy local/node set

The loop variable for each iteration of the for each element.

current-value

policy local/node set

The loop variable for each iteration of the reformat operation attribute.

current-op

policy local/node set

The current operation. Setting this variable using the <do-set-local-variable> element causes the first operation specified by <arg-node-set> to become the current operation for the remainder of the current policy execution or until it is set to another value. The new current operation must be an element sibling of the original current operation and must have been added by the current policy.

comment on this topic