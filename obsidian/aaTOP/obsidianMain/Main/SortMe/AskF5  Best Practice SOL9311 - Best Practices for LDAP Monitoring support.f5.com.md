# AskF5 | Best Practice: SOL9311 - Best Practices for LDAP Monitoring [support.f5.com]

[![[./_resources/AskF5__Best_Practice_SOL9311_-_Best_Practices_for_LDAP_Monitoring_support.f5.com.resources/unknown_filename.5.gif]]](http://www.f5.com/)

* [Support](http://www.f5.com/services/customer-support/)
	
* [Global Sites](http://www.f5.com/about/global-sites/)
	
* [How to Buy](http://www.f5.com/products/how-to-buy/)
	
* [Careers](http://www.f5.com/about/careers/)
	
* [Contact](http://www.f5.com/about/contact/)
	

[Login](https://login.f5.com/resource/login.jsp)

* [Home](http://www.f5.com/)
	
* [About F5](http://www.f5.com/about/)
	
* [Solutions](http://www.f5.com/solutions/)
	
* [Products](http://www.f5.com/products/)
	
* [Services](http://www.f5.com/services/)
	
* [Partners](http://www.f5.com/partners/)
	
* [News](http://www.f5.com/news-press-events/)
	
* [Resources](http://www.f5.com/solutions/resources/)
	
* [Community](http://www.f5.com/news-press-events/web-media/community.html)
	

## AskF5 Knowledge Base

* [Home](http://support.f5.com/kb/en-us.html)

* SOL9311

## Applies To:

**Show Versions ![[./_resources/AskF5__Best_Practice_SOL9311_-_Best_Practices_for_LDAP_Monitoring_support.f5.com.resources/unknown_filename.3.gif]]** 

* * *

**sol9311**: Best Practices for LDAP Monitoring

* * *

![[./_resources/AskF5__Best_Practice_SOL9311_-_Best_Practices_for_LDAP_Monitoring_support.f5.com.resources/unknown_filename.2.gif]]**Best Practice**

**Original Publication Date:** 02/18/2009
**Updated Date:** 01/03/2012

#### LDAP services and the LDAP health monitor

Lightweight Directory Access Protocol (LDAP) services refer to directories that follow the X.500 model:

* A directory is a tree of directory entries

* An entry consists of a set of attributes
* An attribute consists of a name (an attribute type or attribute description) and one or more values as defined in the directory schema
* Each entry has a unique identifier, known as its Distinguished Name (DN)

An LDAP server is configured to respond to requests for a subtree starting from a specific entry, such as **dc=example,dc=com** and its children. Portions of that subtree may be delegated to other servers, in which case the server will return a referral or continuation reference pointing to a server which holds that part of the directory tree. LDAP clients receiving such responses are expected to re-submit their request to the indicated server. Some LDAP servers also support request chaining, in which case the server to which the request is made will make the same request of the referral server and return the results to the client.

The BIG-IP LDAP health monitor checks the status of LDAP servers by making a directory search request and evaluating the response. For the monitor to mark the servers up, the search must return **searchResDone** with a **resultCode** of **0** (success). If the Mandatory Attributes option is enabled, the response must also contain at least one valid object with attributes.

#### BIG-IP LDAP Monitor configuration settings

The BIG-IP LDAP monitor template allows you to configure the following settings:

* **Interval**
	Specifies the frequency at which the system issues the monitor check.

* **Timeout**
	Specifies the number of seconds the target has in which to respond to the monitor request.
	
* **UserName / Password**
	This setting must be configured if the LDAP servers require authentication before accepting queries
* **Security**
	This setting specifies whether encryption is required (for monitoring LDAPS servers) and the secure transport to be used (SSL or TLS)
* **Base**
	This setting specifies the location (base DN) in the LDAP tree at which the monitor starts the search. The base DN and all of its subtrees will be searched for the requested object. For example, if the Base value is set to **dc=bigip-test,dc=net**, the search will include the entire **bigip-test** subtree branch.
	_**Note**: The Base DN is the only required search parameter when configuring the BIG-IP LDAP monitor._
* **Filter**
	This setting defines how each entry in the search scope will be evaluated for a match. For example, **objectClass=person** will match entries corresponding only to persons listed in the directory.
	_**Note**: The Filter parameter is not required; however, F5 Networks recommends the Filter parameter, as detailed later in this document._
* **Mandatory Attributes**
	This setting specifies whether the target must include attributes in its response to be considered up. When set to **No**, the BIG-IP system will mark the server up on any valid response, regardless of whether the response included any related attributes. When set to **Yes**, the BIG-IP system will mark the server up only if the response contains at least one attribute.
	Setting to **No** also simulates the use of the LDAP **singleLevel** search option, specifying that the system will perform only a single level search of the configured Base DN, while setting to Yes also simulates use of the LDAP wholeSubtree search option and performs a subtree search from the base DN.
	_**Note**: For more information about this behavior, refer to [SOL9734: Search scope cannot be configured for LDAP monitors](http://support.f5.com/kb/en-us/solutions/public/9000/700/sol9734.html)._
* **Chase Referrals**
	Specifies whether, upon receipt of an LDAP referral entry, the target follows (or chases) that referral.
* **Debug**
	Specifies whether the monitor sends error messages and additional information to a log file created and labeled specifically for this monitor

_**Note**: For more information about the monitor's individual fields, refer to the [BIG-IP Configuration Guide](http://support.f5.com/kb/en-us/products/big-ip_ltm.html) or the Help tab in the GUI._

#### Recommended BIG-IP LDAP Monitor configuration

The following LDAP search options are typically used to further limit LDAP searches or the resulting server response to a specific subset of the available data, but have not been implemented for the BIG-IP LDAP health monitor:
 

* **derefAliases**
	This option determines whether and how to follow alias entries (entries which refer to other entries)
* **attributes**
	This option determines which attributes to return in result entries
* **sizeLimit, timeLimit**
	This option determines maximum number of entries, and maximum search time
* **typesOnly**
	This option returns attribute types only, not attribute values.

Since these options are not available, F5 Networks strongly recommends a monitor configuration that most effectively limits the scope of the search and the volume of results returned; this configuration will minimize resource consumption and improve performance on both BIG-IP and the LDAP servers being monitored.

Ideally the request should perform a single level search in the smallest possible subtree of the directory, and should return a single local entry with few attributes. The following best practice recommendations will assist you in defining the most optimal LDAP monitor configuration:

* Configure the most specific Base DN value possible to limit the scope of the search
* Configure the most specific Filter value possible to limit the amount of data returned by the server
* Do not enable mandatory attributes to force a singleLevel search
* Ensure the requested entry is local to the LDAP servers being monitored to avoid referrals

You should follow these recommendations to avoid overloading your LDAP servers with excessively demanding searches, to limit the bandwidth consumed by the health monitor traffic, and to prevent flapping of the LDAP server status if latency is induced or if false negative monitor results are obtained due to referral or reference following. (Flapping, or rapid, repeated changes to the monitor state, can be observed in the BIG-IP logs when pool members are repeatedly marked down while waiting for a response, then back up once a response is finally received.)

#### LDAP referrals

An LDAP referral, or continuation reference, indicates that it does not have the subtree containing that object (if it exists), instead providing the DNS name of a server that is more likely to hold the object. Ideally, a referral will reference the server that holds the subtree in question. However, it is always possible for a referenced server to generate yet another referral.

By default, some versions of the BIG-IP system follow referrals received in response to queries, and this behavior cannot be adjusted. For more information, refer to [SOL9735: Referral chasing cannot be configured for LDAP monitors](http://support.f5.com/kb/en-us/solutions/public/9000/700/sol9735.html). In general, and especially on affected versions, you should avoid configuring an LDAP monitor which will generate a referral response. If BIG-IP is configured to resolve DNS names, the BIG-IP system will attempt to resolve and follow referrals and references. This behavior is inefficient and undesirable, and may cause the following cascading issues:

* The BIG-IP system will have to perform a DNS lookup for every referral received. The BIG-IP system's resolver will first make AAAA requests and then, depending on DNS server behavior, may timeout and attempt standard A request. Any delays in DNS resolution can severely hinder the monitor's response and may result in monitor flapping.
	_**Note**: If referrals are required, F5 Networks recommends configuring static entries in the **/etc/hosts** file for each host named in a referral to expedite name resolution and help achieve more consistent results._
* The BIG-IP will open a new TCP socket for each referral. These additional sockets plus those used for the DNS queries represent undesirable system and network overhead for each monitor instance.
* The BIG-IP LDAP monitor performs an anonymous bind on referral requests, rather than reusing the credentials provided in the original request. If the referred servers require authentication or the anonymous user doesn't have the required access, requests depending on referrals may fail even if the monitored server is obviously healthy, having just returned a valid referral response.

#### Sample LDAP monitor

A BIG-IP LDAP monitor constructed according to the recommendations in this Solution will appear similar to the following example:

monitor my\_ldap\_monitor {
   defaults from ldap
   base "ou=group,dc=company,dc=com"
   debug "no"
   filter "cn=user1"
   mandatoryattrs "no"
   password "mysecret"
   security "none"
   username "cn=binduser,ou=group,dc=company,dc=com"
}

#### Monitoring Microsoft's Active Directory

When responding to full scope wildcard queries, such as a search for **objectclass=\*** beginning at the root of the domain, Microsoft's Active Directory will by default return referrals to three other directory partitions:

* ForestDnsZones
* DomainDnsZones
* Configuration  

Since chasing referrals creates additional dependencies and can produce unexpected results, when monitoring Active Directory, you should especially avoid eliciting the referral response by always specifying the following:  

* A Base DN other than the domain root.
	For example: **ou=group,dc=company,dc=com** instead of **dc=company,dc=com**
* An object-specific filter
	For example: **cn=user1** instead of **objectclass=\***

**LDAP Monitor Optimization with ldapsearch**
F5 Networks recommends using the **ldapsearch** command to verify the actual mechanics of the health monitor as configured in order to ensure that your monitor configuration is performing the most optimal search possible.

**_Note_**_: The BIG-IP system's LDAP monitor does not utilize the **ldapsearch** command; however, the utility is useful for verifying basic LDAP connectivity and functionality from the BIG-IP._

You can specify the following options for the **ldapsearch** command:

|     |     |
| --- | --- |
| Command option | Function |
| **\-x** | Simple authentication |
| **\-LLL** | Limit comments |
| **\-H** | ldap uri in the form 'protocol://host:port' |
| **\-b** | Base |
| **\-s** | Levels to search (by default, the BIG-IP LDAP monitor will only perfom a single level search, so the option **one** will be closest approximation to the search performed by the monitor) |
| **\-A** | Attribute types only (by default, the BIG-IP LDAP monitor will perform an attribute types-only search) |
| **\-D** | Bind user with credentials/permissions to search the database |
| **\-w** | Password |

For example, to simulate the example monitor, you would type the following command at the BIG-IP command line:
 
**ldapsearch -xLLL -H 'ldap://ldapA.company.com' -b "ou=group,dc=company,dc=com" -s one -A -D "cn=binduser,dc=company,dc=com" -w 'mypassword' "(cn=user1)"**

The search will return an entry that appears similar to the following example:
_**Note**: The example has been truncated._
dn: uid=user1,ou=group,dc=company,dc=com
objectClass: inetOrgPerson

To test the same monitor configuration against an LDAP server running on an alternative port, you would use the following command:
**ldapsearch -xLLL -H 'ldap://ldapA.company.com:390' -b "ou=group,dc=company,dc=com" -s one -A -D "cn=binduser,dc=company,dc=com" -w 'mypassword' "(cn=user1)"**

To test the same monitor configuration against an LDAPS server running on the standard port, you could type the following command:
**ldapsearch -xLLL -H 'ldaps://ldapA.company.com' -b "ou=group,dc=company,dc=com" -s one -A -D "cn=binduser,dc=company,dc=com" -w 'mypassword' "(cn=user1)"**

_**Note**: In order to resolve the LDAP hostname, BIG-IP must be configured to resolve DNS names. Alternatively, you may specify an IP address in place of the hostname._

If the **ldapsearch** command returns a referral, results will contain entries in the form of **#refldap://url/** similar to the following referral received from server **ldapA** for a DN whose subtree was delegated to server ldapB:

refldap://ldapB.company.com/ou=group,dc=company,dc=com??base

A packet trace of the resulting response reveals a search result referral code (searchResRef), as seen in the following response:

LDAPMessage searchResRef(2)
        searchResRef: 1 item
            Item: ldap://ldapB.company.com/DC=ForestDnsZones,DC=company,DC=com??base
 
_**Note**: For more information about LDAP, refer to the following article:
_[_Lightweight Directory Access Protocol (v3)_](http://www.ietf.org/rfc/rfc2251.txt)

_**Note**: For more information about the **ldapsearch** command, type **ldapsearch -h** at the BIG-IP command line or consult the **ldapsearch** man page._

For more information about known issues regarding LDAP monitoring, refer to the following articles:

* [SOL3494: The LDAP or LDAPS monitor may mark all nodes as down](http://support.f5.com/kb/en-us/solutions/public/3000/400/sol3494.html)
* [SOL9530: An LDAP monitor with TLS/SSL enabled fails with a 'Bind failed' error message](http://support.f5.com/kb/en-us/solutions/public/9000/500/sol9530.html)
* [SOL9531: LDAP monitor fails with 'SubDomain: REJECTING r access to /usr/etc/openldap/ldap.conf' error](http://support.f5.com/kb/en-us/solutions/public/9000/500/sol9531.html)
* [SOL9734: Search scope cannot be configured for LDAP monitors](http://support.f5.com/kb/en-us/solutions/public/9000/700/sol9734.html)
* [SOL9735: Referral chasing cannot be configured for LDAP monitors](http://support.f5.com/kb/en-us/solutions/public/9000/700/sol9735.html)

#### Was this resource helpful in solving your issue?

Yes - this resource was helpful
No - this resource was not helpful
I don‘t know yet

NOTE: Please do not provide personal information.

#### Please enter the words to the right:

#### Additional Comments (optional)

![[./_resources/AskF5__Best_Practice_SOL9311_-_Best_Practices_for_LDAP_Monitoring_support.f5.com.resources/unknown_filename.6.jpeg]]
  

* * *

		## [Search AskF5](http://support.f5.com/kb/en-us.html)
	

* [Supported Products](http://support.f5.com/kb/en-us/products.html)
* [BIG-IP Edge Apps](http://support.f5.com/kb/en-us/bigip-edge-apps.html)
* [End-of-Life Products](http://support.f5.com/kb/en-us/archived_products.html)
* [Recent Additions](http://support.f5.com/kb/en-us/recentadditions.html)
* [About AskF5](http://support.f5.com/kb/en-us/about.html)

		## [Downloads](https://downloads.f5.com/)
	
* [BIG-IP iHealth](http://www.f5.com/services/customer-support/ihealth/)
* [WebSupport](https://websupport.f5.com/)
* [Licensing](https://secure.f5.com/)

[![[./_resources/AskF5__Best_Practice_SOL9311_-_Best_Practices_for_LDAP_Monitoring_support.f5.com.resources/unknown_filename.4.jpeg]]](http://support.f5.com/kb/en-us/ask_f5_survey.html)
[![[./_resources/AskF5__Best_Practice_SOL9311_-_Best_Practices_for_LDAP_Monitoring_support.f5.com.resources/unknown_filename.jpeg]]](http://support.f5.com/kb/en-us/pages/technews.html)

* [Home](http://www.f5.com/)

* | [Site Map](http://www.f5.com/tools/sitemap.html)
* | [Contact F5](http://www.f5.com/about/contact/)
* | [Glossary](http://www.f5.com/glossary.html)
* | [Policies](http://www.f5.com/services/customer-support/guidelines-policies/)
* | [Trademarks](http://www.f5.com/services/customer-support/guidelines-policies/trademarks.html)
* © 1998–2012 F5 Networks, Inc. All rights reserved.
