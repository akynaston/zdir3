---
tags: ["#xslt"]
---
# XPATH Examples - CoolSolutionsWiki

  [![[./_resources/XPATH_Examples_-_CoolSolutionsWiki.resources/novell_logo_redonblack.png]]](http://www.novell.com/)

* [Skip to Content](http://wiki.novell.com/index.php/XPATH_Examples#top)
* [+ Menu](http://www.novell.com/menu.php)

### [Solutions](http://www.novell.com/solutions)

* [**Data Center**](http://www.novell.com/solutions/data-center)
* [Enterprise Linux Servers](http://www.novell.com/solutions/enterprise-linux-servers)
* [Virtualization & Workload Management](http://www.novell.com/solutions/virtualization-workload)
* [Business Service Management](http://www.novell.com/solutions/business-service-management)
* [**End-User Computing**](http://www.novell.com/solutions/end-user-computing)
* [Collaboration](http://www.novell.com/solutions/collaboration)
* [Enterprise Linux Desktops](http://www.novell.com/solutions/enterprise-linux-desktops)
* [Endpoint Management](http://www.novell.com/solutions/endpoint-management)
* [**Identity & Security**](http://www.novell.com/solutions/identity-and-security)
* [Compliance Management](http://www.novell.com/solutions/compliance-management)
* [Identity & Access Management](http://www.novell.com/solutions/identity-and-access)
* [Security Management](http://www.novell.com/solutions/security-management)

[Not Sure? _Try our solution finder +_](http://www.novell.com/solutions)

### [Products](http://www.novell.com/products)

* [Access Manager](http://www.novell.com/products/accessmanager)
* [Compliance Management Platform](http://www.novell.com/products/compliancemanagementplatform)
* [GroupWise](http://www.novell.com/products/groupwise)
* [Identity Manager](http://www.novell.com/products/identitymanager)
* [Open Enterprise Server](http://www.novell.com/products/openenterpriseserver)
* [PlateSpin Forge](http://www.novell.com/products/forge)
* [PlateSpin Migrate](http://www.novell.com/products/migrate)
* [PlateSpin Orchestrate](http://www.novell.com/products/orchestrate)
* [Sentinel](http://www.novell.com/products/sentinel)
* [SUSE Appliance Program](http://www.novell.com/partners/technology/isv/appliance)
* [SUSE Linux Enterprise Server](http://www.novell.com/products/server)
* [Teaming + Conferencing](http://www.novell.com/products/teaming)
* [ZENworks Configuration Management](http://www.novell.com/products/zenworks/configurationmanagement)
* [ZENworks Endpoint Security Management](http://www.novell.com/products/zenworks/endpointsecuritymanagement)

[_All Products_ +](http://www.novell.com/products)

### [Services](http://www.novell.com/services)

* [Technical Support](http://www.novell.com/support)
* [Technical Training](http://www.novell.com/training)
* [IT Consulting](http://www.novell.com/consulting)
* [Downloads](http://download.novell.com/)
* [Customer Center](http://www.novell.com/center)
* [Support Forums](http://forums.novell.com/)
* [Documentation](http://www.novell.com/documentation)

### [Partners & Community](http://www.novell.com/communities)

* [Partners](http://www.novell.com/partners)
* [Developers](http://developer.novell.com/wiki/index.php/Developer_Home)
* [Users](http://www.novell.com/communities/nui)
* [Cool Solutions](http://www.novell.com/communities/coolsolutions)
* [Blogs](http://www.novell.com/company/blogs)

#### Search

* [Login](https://www.novell.com/ICSLogin/?%22http://wiki.novell.com/index.php/XPATH_Examples%22)
	* [Create an Account](https://secure-www.novell.com/selfreg/jsp/createAccount.jsp)
	* [Change Language](http://www.novell.com/common/util/langselect.php?referer=http%3A//wiki.novell.com/index.php/XPATH_Examples)

### [About Novell](http://www.novell.com/company)

* [Contact Us](http://www.novell.com/company/contacts-offices)
* [Our Customers](http://www.novell.com/success)
* [Events Center](http://www.novell.com/events)
* [Connection Magazine](http://www.novell.com/connectionmagazine)
* [Press Room](http://www.novell.com/news/press/room)
* [Novell News Blog](http://www.novell.com/prblogs)

[- Close Menu](http://wiki.novell.com/index.php/XPATH_Examples#)

[![[./_resources/XPATH_Examples_-_CoolSolutionsWiki.resources/novell_logo_redonblack.png]]](http://www.novell.com/)

# 

## 

##### 

##### 

* [Article](http://wiki.novell.com/index.php/XPATH_Examples)
* [Discussion](http://wiki.novell.com/index.php/Talk:XPATH_Examples)
* [Edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit)
* [History](http://wiki.novell.com/index.php?title=XPATH_Examples&action=history)

This page is intent to help demystify XPATH expressions by showing example expressions with explanations as to what elements they match. Example traces are encouraged.

## Contents

\[\]

* [1 Reference Information](http://wiki.novell.com/index.php/XPATH_Examples#Reference_Information)
	* [1.1 Geoff Carman's series on XPATH](http://wiki.novell.com/index.php/XPATH_Examples#Geoff_Carman.27s_series_on_XPATH)
	* [1.2 Father Ramon Tutorials](http://wiki.novell.com/index.php/XPATH_Examples#Father_Ramon_Tutorials)
* [2 Examples](http://wiki.novell.com/index.php/XPATH_Examples#Examples)
	* [2.1 Strip Values](http://wiki.novell.com/index.php/XPATH_Examples#Strip_Values)
		* [2.1.1 Strip Empty Values Add](http://wiki.novell.com/index.php/XPATH_Examples#Strip_Empty_Values_.5BAdd.5D)
		* [2.1.2 Strip Empty Values Modify](http://wiki.novell.com/index.php/XPATH_Examples#Strip_Empty_Values_.5BModify.5D)
		* [2.1.3 Strip 'Remove All Values'](http://wiki.novell.com/index.php/XPATH_Examples#Strip_.27Remove_All_Values.27)
		* [2.1.4 Strip a Specific Value of a Specific Attribute](http://wiki.novell.com/index.php/XPATH_Examples#Strip_a_Specific_Value_of_a_Specific_Attribute)
		* [2.1.5 Strip All Empty Nodes (unscoped)](http://wiki.novell.com/index.php/XPATH_Examples#Strip_All_Empty_Nodes_.28unscoped.29)
	* [2.2 String Operations](http://wiki.novell.com/index.php/XPATH_Examples#String_Operations)
		* [2.2.1 Retrieve a Portion of a String](http://wiki.novell.com/index.php/XPATH_Examples#Retrieve_a_Portion_of_a_String)
		* [2.2.2 Remove Leading Zeros from a Number](http://wiki.novell.com/index.php/XPATH_Examples#Remove_Leading_Zeros_from_a_Number)
	* [2.3 Working with nodesets](http://wiki.novell.com/index.php/XPATH_Examples#Working_with_nodesets)
		* [2.3.1 Get Value From a Nodeset](http://wiki.novell.com/index.php/XPATH_Examples#Get_Value_From_a_Nodeset)
		* [2.3.2 Min and max value in a nodeset](http://wiki.novell.com/index.php/XPATH_Examples#Min_and_max_value_in_a_nodeset)
	* [2.4 Working with Nodeset Attributes](http://wiki.novell.com/index.php/XPATH_Examples#Working_with_Nodeset_Attributes)
		* [2.4.1 Remove an attribute of an element](http://wiki.novell.com/index.php/XPATH_Examples#Remove_an_attribute_of_an_element)
		* [2.4.2 Parse a CN from an attribute of an element](http://wiki.novell.com/index.php/XPATH_Examples#Parse_a_CN_from_an_attribute_of_an_element)
	* [2.5 Structured Attributes](http://wiki.novell.com/index.php/XPATH_Examples#Structured_Attributes)
		* [2.5.1 Component Value of a Structured Attribute (By Name)](http://wiki.novell.com/index.php/XPATH_Examples#Component_Value_of_a_Structured_Attribute_.28By_Name.29)
		* [2.5.2 Component Value of a Structured Attribute (By Position)](http://wiki.novell.com/index.php/XPATH_Examples#Component_Value_of_a_Structured_Attribute_.28By_Position.29)
	* [2.6 Working With Event and Status Messages](http://wiki.novell.com/index.php/XPATH_Examples#Working_With_Event_and_Status_Messages)
		* [2.6.1 Detect a Warning Error](http://wiki.novell.com/index.php/XPATH_Examples#Detect_a_Warning_Error)
		* [2.6.2 Detect a Merge Event](http://wiki.novell.com/index.php/XPATH_Examples#Detect_a_Merge_Event)
	* [2.7 Remove Un-Associated Group Memberships](http://wiki.novell.com/index.php/XPATH_Examples#Remove_Un-Associated_Group_Memberships)
	* [2.8 Query Vault for DN using Email address as a matching attribute](http://wiki.novell.com/index.php/XPATH_Examples#Query_Vault_for_DN_using_Email_address_as_a_matching_attribute)
	* [2.9 Run external code on the IDM engine server](http://wiki.novell.com/index.php/XPATH_Examples#Run_external_code_on_the_IDM_engine_server)
	* [2.10 Allow Unsynchronized Values to Exist](http://wiki.novell.com/index.php/XPATH_Examples#Allow_Unsynchronized_Values_to_Exist)

\[[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=1)\]

## 

 <http://www.w3.org/TR/xpath>

XPATH 2.0 <http://www.w3.org/TR/xpath20>
_Note that xpath 2.0 is **not** supported by Novell Identity Manager as of Version 3.5_

XPATH 2.0 Warning applies to these links as well:

[http://www.w3schools.com/Xpath/](http://www.w3schools.com/Xpath)

<http://www.zvon.org/xxl/XPathTutorial/General_ger/examples.html>

\[[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=2)\]

### 

<http://www.novell.com/communities/node/4833/some-thoughts-xpath-novell-identity-manager>
<http://www.novell.com/communities/node/6175/xpath-and-context-node>
<http://www.novell.com/communities/node/6109/xpath-and-math>
<http://www.novell.com/communities/node/6179/using-string-compares-xpath-statements>
<http://www.novell.com/communities/node/6910/another-attempt-explaining-xpath-context-node>
<http://www.novell.com/communities/node/5845/using-xpath-examine-association-values>
<http://www.novell.com/communities/node/5686/cool-tricks-using-xpath-nodesets>
<http://www.novell.com/communities/node/4825/using-global-configuration-values-xpath>
<http://www.novell.com/communities/node/6276/using-xpath-get-position-node-node-set>
<http://www.novell.com/communities/node/5818/different-attribute-options-identity-manager>

\[[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=3)\]

### 

* 
* 
* 

* 

* 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=4)\]

## 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=5)\]

### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=6)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=7)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=8)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=9)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=10)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=11)\]

### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=12)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=13)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=14)\]

### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=15)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=16)\]

#### 

> <http://www.novell.com/communities/node/6431/again-power-xpath-or-missing-max-function>

<do-set-local-variable name="minValue" scope="policy">
   <arg-string>
      <token-xpath expression='self::\*//value\[ancestor::\*/@attr-name="attrNameGoesHere"\]\[not(. > preceding-sibling::value or . > following-sibling::value)\]\[1\]'/>
   </arg-string>
</do-set-local-variable>
<do-set-local-variable name="maxValue" scope="policy">
   <arg-string>
      <token-xpath expression='self::\*//value\[ancestor::\*/@attr-name="attrNameGoesHere"\]\[not(. < preceding-sibling::value or . < following-sibling::value)\]\[1\]'/>
   </arg-string>
</do-set-local-variable>
\[[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=17)\]

### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=18)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=19)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=20)\]

### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=21)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=22)\]

#### 

     

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=23)\]

### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=24)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=25)\]

#### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=26)\]

### 

   

   

   

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=27)\]

### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=28)\]

### 

[edit](http://wiki.novell.com/index.php?title=XPATH_Examples&action=edit&section=29)\]

### 

* 
	* 
	* 
* 
	* 

	* 
	* 
	* 

<http://wiki.novell.com/index.php/XPATH_Examples>"

[Categories](http://wiki.novell.com/index.php?title=Special:Categories&article=XPATH_Examples): [Identity Manager](http://wiki.novell.com/index.php/Category:Identity_Manager) | [Security and Identity](http://wiki.novell.com/index.php/Category:Security_and_Identity)
