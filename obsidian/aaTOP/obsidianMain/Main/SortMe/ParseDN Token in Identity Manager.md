---
tags: ["#IDM"]
---
# ParseDN Token in Identity Manager

## Examples of using the ParseDN Token in Identity Manager

## S = start

L = length

get-cn-from-dn - slash - S-1L1
get-cn-from-dn - ldap -  S-1L1
getDN-From-CN - slash - S0L-2
getDN-From-CN - ldap - S0L-2 (guessing)

## Note: besure to get the 'src-dn' and 'dest-dn' specifications correct - in some cases, I was converiting an edir dn to an edir den, and was on the input transform, and should have seen edir dn for src and dtest.

## 

## Chop off tree name:Start: 1 (skip the first node)Length: -1 (go to the end)

## \\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH would become \\LAB\\USERS\\ACTIVE\\BSMITH

drop cn
drop-cn
GET-DN-FROM-CN
Chop off last node: (Get the parent container)Start: 0 (start at the beginning)Length: -2 (go to one before the end)

## Drop CN from DN

## \\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH would become \\ACME-TREE\\LAB\\USERS\\ACTIVE\\

## 

## Get the name of the object:Start: -1Length: 1

\\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH would become BSMITH

## 

## get-cn-from-dn, ldap dn:

<do-set-local-variable name="cnfromDN" scope="policy">

## <arg-string>

## <token-parse-dn dest-dn-format="slash" length="1" src-dn-format="ldap" start="-1">

## <token-xpath expression="association/text()"/>

## </token-parse-dn>

## </arg-string>

## </do-set-local-variable>

## 

## 

## 

## 

## convert from idv dn to uid sunone dn:

## 

## 

## <do-set-op-association>

## <arg-association>

## <token-text xml:space="preserve">uid=</token-text>

## <token-xpath expression="new-name/text()"/>

## <token-text xml:space="preserve">,</token-text>

## <token-lower-case>

## <token-src-dn convert="true" length="-3" start="1"/>

## </token-lower-case>

## </arg-association>

## </do-set-op-association>

## 

## 

## 

## 

## <rule>

## <description>Users: Mirror the placement</description>

## <comment xml:space="preserve">Convert the eDirectory DN to an LDAP style SunOne dn, and lowercase the full dn.  Note: the start of 1 drops the tree name on the DN before converting.

## 

## 

## Also, use uid instead of CN for naming.</comment>

## <conditions>

## <or>

## <if-class-name mode="nocase" op="equal">User</if-class-name>

## </or>

## </conditions>

## <actions>

## <do-set-local-variable name="parentContainer" scope="policy">

## <arg-string>

## <token-lower-case>

## <token-src-dn convert="true" length="-3" start="1"/>

## </token-lower-case>

## </arg-string>

## </do-set-local-variable>

## <do-set-op-dest-dn>

## <arg-dn>

## <token-text xml:space="preserve">uid=</token-text>

## <token-op-attr name="CN"/>

## <token-text xml:space="preserve">,</token-text>

## <token-local-variable name="parentContainer"/>

## </arg-dn>

## </do-set-op-dest-dn>

## </actions>

## </rule>

## Here's some code that I'm using to get just the container of the dn I'm specifying.  I needed to be reltive in my dn names, now I'll be able to.

## <?xml version="1.0" encoding="UTF-8"?><!DOCTYPE policy PUBLIC "policy-builder-dtd" "C:\\Program Files\\Novell\\Designer\\plugins\\com.novell.idm.policybuilder\_3.5.0.200909160331\\DTD\\dirxmlscript3.6.1.dtd"><policy>        <rule>                <description>df</description>                <conditions>                        <and/>                </conditions>                <actions>                        <do-set-local-variable name="dirxml.auto.driverdn" scope="policy">                                <arg-string>                                        <token-text xml:space="preserve">\\IDV\\idm\\Driver Set\\ADAccountsGoldLinkDriver</token-text>                                </arg-string>                        </do-set-local-variable>                        <do-set-local-variable name="driverSetDN" scope="policy">                                <arg-string>                                        <token-parse-dn dest-dn-format="slash" length="-2" src-dn-format="slash" start="0">                                                <token-local-variable name="dirxml.auto.driverdn"/>                                        </token-parse-dn>                                </arg-string>                        </do-set-local-variable>                        <do-set-local-variable name="loopackdn" scope="policy">                                <arg-string>                                        <token-replace-all regex="\\\\" replace-with="/">                                                <token-local-variable name="driverSetDN"/>                                        </token-replace-all>                                        <token-text xml:space="preserve">/Loopback/AddressMappingTable#DirXML-Data</token-text>                                </arg-string>                        </do-set-local-variable>                </actions>        </rule></policy>

## 

## this produces (in the simulater):

## ADAccountsGoldLinkDriver :Applying policy: %+C%14Ctest%-C.ADAccountsGoldLinkDriver :  Applying to add #1.ADAccountsGoldLinkDriver :    Evaluating selection criteria for rule 'df'.ADAccountsGoldLinkDriver :    Rule selected.ADAccountsGoldLinkDriver :    Applying rule 'df'.ADAccountsGoldLinkDriver :      Action: do-set-local-variable("dirxml.auto.driverdn",scope="policy","\\IDV\\idm\\Driver Set\\ADAccountsGoldLinkDriver").ADAccountsGoldLinkDriver :        arg-string("\\IDV\\idm\\Driver Set\\ADAccountsGoldLinkDriver")ADAccountsGoldLinkDriver :          token-text("\\IDV\\idm\\Driver Set\\ADAccountsGoldLinkDriver")ADAccountsGoldLinkDriver :          Arg Value: "\\IDV\\idm\\Driver Set\\ADAccountsGoldLinkDriver".ADAccountsGoldLinkDriver :      Action: do-set-local-variable("driverSetDN",scope="policy",token-parse-dn(dest-dn-format="slash",length="-2",src-dn-format="slash",start="0",token-local-variable("dirxml.auto.driverdn"))).ADAccountsGoldLinkDriver :        arg-string(token-parse-dn(dest-dn-format="slash",length="-2",src-dn-format="slash",start="0",token-local-variable("dirxml.auto.driverdn")))ADAccountsGoldLinkDriver :          token-parse-dn(dest-dn-format="slash",length="-2",src-dn-format="slash",start="0",token-local-variable("dirxml.auto.driverdn"))ADAccountsGoldLinkDriver :            token-parse-dn(dest-dn-format="slash",length="-2",src-dn-format="slash",start="0",token-local-variable("dirxml.auto.driverdn"))ADAccountsGoldLinkDriver :              token-local-variable("dirxml.auto.driverdn")ADAccountsGoldLinkDriver :                Token Value: "\\IDV\\idm\\Driver Set\\ADAccountsGoldLinkDriver".ADAccountsGoldLinkDriver :              Arg Value: "\\IDV\\idm\\Driver Set\\ADAccountsGoldLinkDriver".ADAccountsGoldLinkDriver :            Token Value: "\\IDV\\idm\\Driver Set".ADAccountsGoldLinkDriver :          Arg Value: "\\IDV\\idm\\Driver Set".ADAccountsGoldLinkDriver :      Action: do-set-local-variable("loopackdn",scope="policy",token-replace-all("\\\\","/",token-local-variable("driverSetDN"))+"/Loopback/AddressMappingTable#DirXML-Data").ADAccountsGoldLinkDriver :        arg-string(token-replace-all("\\\\","/",token-local-variable("driverSetDN"))+"/Loopback/AddressMappingTable#DirXML-Data")ADAccountsGoldLinkDriver :          token-replace-all("\\\\","/",token-local-variable("driverSetDN"))ADAccountsGoldLinkDriver :            token-replace-all("\\\\","/",token-local-variable("driverSetDN"))ADAccountsGoldLinkDriver :              token-local-variable("driverSetDN")ADAccountsGoldLinkDriver :                Token Value: "\\IDV\\idm\\Driver Set".ADAccountsGoldLinkDriver :              Arg Value: "\\IDV\\idm\\Driver Set".ADAccountsGoldLinkDriver :            Token Value: "/IDV/idm/Driver Set".ADAccountsGoldLinkDriver :          token-text("/Loopback/AddressMappingTable#DirXML-Data")ADAccountsGoldLinkDriver :          Arg Value: "/IDV/idm/Driver Set/Loopback/AddressMappingTable#DirXML-Data".ADAccountsGoldLinkDriver :Policy returned:ADAccountsGoldLinkDriver :<nds dtdversion="3.5" ndsversion="8.x">  <source>    <product version="?.?.?.?">DirXML</product>    <contact>Novell, Inc.</contact>  </source>  <input>    <add class-name="user">      <add-attr attr-name="defaultClassStore">        <value type="dn">asdf</value>      </add-attr>    </add>  </input></nds>

## 

## 

## 

## 

## Action: do-set-local-variable("matchContainer",scope="policy",token-parse-dn(token-src-dn(start="1"))).

## \[03/25/10 14:17:57.329\]:SunOne ST:        arg-string(token-parse-dn(token-src-dn(start="1")))

## \[03/25/10 14:17:57.329\]:SunOne ST:          token-parse-dn(token-src-dn(start="1"))

## \[03/25/10 14:17:57.330\]:SunOne ST:            token-parse-dn(token-src-dn(start="1"))

## \[03/25/10 14:17:57.330\]:SunOne ST:              token-src-dn(start="1")

## \[03/25/10 14:17:57.330\]:SunOne ST:                Token Value: "cn=sunonetestGroup5\_3,ou=groups,ou=us,ou=landa".

## \[03/25/10 14:17:57.330\]:SunOne ST:              Arg Value: "cn=sunonetestGroup5\_3,ou=groups,ou=us,ou=landa".

## \[03/25/10 14:17:57.331\]:SunOne ST:            Token Value: "landa\\us\\groups\\sunonetestGroup5\_3".

## \[03/25/10 14:17:57.331\]:SunOne ST:          Arg Value: "landa\\us\\groups\\sunonetestGroup5\_3".

## 

## 

## 

## Article:

## 

## 

## Novell Identity Manager has a number of very powerful verbs, nouns, and tokens. One that I use a lot, but drives me mad on a regular basis is ParseDN.

## Watch out for known limitations, as described at: http://www.novell.com/communities/node/4337/ parsedn-token-identity-manager-and-some-its-limitations.

## ParseDN is pretty powerful and cool, but as described in the article above, it can only do what it can with the available data. (The issue above relates to LDAP naming, when the data about whether each node is a CN=, OU=, C=, DC=, or the like is not available. If it is not in the attribute you are using the token on, it cannot, alas, magically figure it out for you. I had so hoped it would somehow magically calculate the full LDAP DN, but that was not to be.)

## The thing is, the help in Designer (at least last I looked in the 3.0 beta 1 build) tries to explain the token, but could really use some better examples. Thus I thought I would try and provide some of the most common ones I use.

## All my examples are going to work with DN's in the format Identity Manager uses internally. That is, a DN that would look like \\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH. In this example, the LDAP name might be CN=BSMITH,OU=ACTIVE,OU=USERS,O=LAB,T=ACME-TREE or somesuch. But for now, I will use the backslash format to explain it. The root most node, regardless of how you look at (IDM internal, or LDAP) is the ACME-TREE node, since it is closest to the root of the tree. (Ok, so it IS actually the tree name, hard to get closer to root than that, right?).

## Leaf most node is the one farthest from the root, in our examples BSMITH (or CN=BSMITH in LDAP namespace).

## The most common issue I use ParseDN for is changing the length of the DN. Usually I want to do one of three things. Chop off the tree name (root most node), chop off the BSMITH node (leaf most node) to get the parent container of the object, or just get the name of the object, without any of the path.

## You have two controls, Start and Length.

## Start is pretty easy. A start value of zero (0) means start at the beginning of the DN, which is root most. Where it gets kind of interesting, is working the other way, -1 means start at the leaf most node. So -2 would be start one node from the leaf most end.

## Length is easy at first, a positive integer means go that number of nodes.

## Negative one (-1), means go to the end of the nodes (leaf most). Negative 2 (-2) means go to one node before the leaf most node.

## For the examples above, I would set the following values:

## Chop off tree name:Start: 1 (skip the first node)Length: -1 (go to the end)

## \\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH would become \\LAB\\USERS\\ACTIVE\\BSMITH

## Chop off last node: (Get the parent container)Start: 0 (start at the beginning)Length: -2 (go to one before the end)

\\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH

## would become

## \\ACME-TREE\\LAB\\USERS\\ACTIVE\\

## Get the name of the object:Start: -1Length: 1

## \\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH would become BSMITH

## It is worth noting that the Source DN() token and the Destination DN() token in Argument Builder both have the ability to specify these length and start values in a similar fashion. What ParseDN brings to the table that is additional, is conversion between formats (source, destination, LDAP (with the limits noted above), and others that you can define)

## One trick to be careful of that I have noticed, is that trying to combine length changes in one move, can be fraught with peril. That is, trying to get the middle set of nodes can be tricky.

## In principle to get the middle bits of a DN path, i.e. the part without the end node and without the tree name, you should be able to:

## Start: 1Length: -2

## But in practice I have had a hard time doing this. What I mean by that is, it just does not work reliably. I am not sure why exactly. What I found works the best when you run into an issue like this one is to chop of the end (leaf most) node first, either as part of the Source DN token, (which as I mentioned above can do some of ParseDN's cool stuff) with a length of -1 and a start of 1, and the nest that under a ParseDN token to chop off the tree name.

## Often I have the value of the DN stored as string in some other attribute, or it is coming from an object that is not actually the current operational object, or from somewhere else, where I cannot use the Source DN or Destination DN tokens.

## One common example of that would be from the XPATH of @src-dn from the results of a query for an object as is discussed in the middle of this article at: http://www.novell.com/communities/node/4833/some-thoughts-xpath-novell-identity-manager

## The issue is that if you want to use the Query token to find the a user in either the source or destination data store, that while it is quite powerful, there is no direct way to get the distinguished name of the object you are looking for. You would think, based on Argument Builders interface, that you could Query for the SourceDN token, but alas that does not work. In fact, the attribute you would want to return is called DN, but it is not a real attribute in the usual sense, so you cannot return it directly.

## Instead what you need to do is query for the object you want, as appropriate, and get a nodeset value back. Part of the reason it is not so simple to do is that you could end up with a single or multiple results. In any case, you need to then use an XPATH expression of @src-dn to get the value out. The most common way is to set a local variable, as a nodeset. The value set into the local variable is a Query token for the object you are looking for. Then in the next action, set a local variable of type string, equal to the XPATH expression. Something like the following rule:

## 

## <do-set-local-variable name="SOURCE-DN" scope="policy">        <arg-node-set>                <token-query datastore="src">                        <arg-dn>                                <token-global-variable name="eDirUserContainer"/>                        </arg-dn>                        <arg-match-attr name="workforceID"/>                        <arg-string>                                <token-text xml:space="preserve">Object Class</token-text>                        </arg-string>                </token-query>                </arg-node-set></do-set-local-variable><do-set-local-variable name="SOURCE-DN" scope="policy">        <arg-string>                <token-xpath expression="$SOURCE-DN/@src-dn"/>        </arg-string></do-set-local-variable>In this example, we generate a Query against the source datasource (so depending on your channel (subscriber or publisher) it could be either eDirectory of the application, for a user with the current value of workforceID.

## I like to scope things so that we only search from the container I know users are stored in, in this case defined by a Global Configuration Variable called eDirUserContainer. I really like scoping my searches, since sometimes the trees can be very large, and unconstrained searches can do a lot of extra work.

## Now one of the tricks is ask for the return of an attribute you know will ALWAY be there on an object, If you think about it, Object Class is implicitly a mandatory attribute. Actually it is an explicitly mandatory attribute of the Top class, which every object class in the tree inherits from. Anyway, every object in the tree has Object Class defined, even if it is set to Unknown. Of course, in this case, you could probably also ask it to return the attribute you searched on, workforceID since if it is found, it must have it by definition.

## Then once we have it set, note that the first SOURCE-DN is set as a nodeset variable, not a string, we use a second set local variable action to set the same variable name SOURCE-DN as a string, to the XPATH of $SOURCE-DN/@src-dn The $SOURCE-DN is how you represent the variable (with a leading dollar sign ($)) and then in the context of that variable get the attribute (the at sign (@)) src-dn.

## If you need to ParseDN this to LDAP syntax, then you probably want to grab the attribute @qualified-src-dn instead which would look more like CN=BSMITH.OU=ACTIVE.OU=USERS.O=LAB.T=ACME-TREE. Which as discussed above can be ParseDN'ed into real LDAP syntax (which alas means mostly swapping periods with commas.)

## If you have an expectation of returning more than one value in your search (I hope not for workforceID, one hopes that is unique in your tree), then you should probably iterate through the values returned inside a for-each loop, and get the value of each object returned. Otherwise you will only get the value from the first one, which may or may not be the one you want. You can always test to see how many values got returned by using an XPATH of something like count($SOURCE-DN) to get the number of nodes in the returned document, and if it is greater than 1, you may have a problem.

## Whoever thought getting the distinguished name of an object could be so complex? (Wait till you try and get the DN of an object very soon after a move operation happened, and then see how much fun that can be! You often get two values returned, the old and the new, depending on when you query it).

## Author Info

## 9 July 2008 - 12:33pmSubmitted by: geoffc

## Author BlogAuthor ProfileTags

## DirXML eDirectory Identity Manager Identity Manager 3.5Tags Map  Related Articles

## ParseDN Token in Identity Manager and Some of its LimitationsTesting the Destination Container: Explaining Why it WorksUsing Regex Matches across a ContainerAvoiding Empty Attributes in Identity ManagerPlacing DNs in Multi-Valued Attributes User Comments

## 

## Additional insight

## Submitted by Anonymous on 11 August 2008 - 5:48am.

## \> In principle to get the middle bits of a DN path, i.e. the> part without the end node and without the tree name, you> should be able to:>> Start: 1> Length: -2>> But in practice I have had a hard time doing this. What I > mean by that is, it just does not work reliably. I am not > sure why exactly.

## The reason you are having a problem to get it to work is that you are thinking of the length incorrectly.

## \> Negative one (-1), means go to the end of the nodes> (leaf most). Negative 2 (-2) means go to one node before> the leaf most node.

## Negative numbers in the length don't have any direct connection to the leaf node or the root node or any other node: They represent the total number of nodes in the input DN. e.g. -1 is the count of all the nodes, -2 is one less than that, -3 is 2 less than that. So if you want all the nodes but the first and the last, you want some thing that is 2 nodes shorter than, the original, hence you need to use -3.

## Login to post commentsNovell® Making IT Work As One™

CareersContact UsFeedbackLegalPrint© 2009 Novell, Inc. All Rights Reserved.

\[02/25/11 16:06:50.886\]:IDV2EDIR PT:    Applying rule 'Place User based on Department'.
\[02/25/11 16:06:50.886\]:IDV2EDIR PT:      Action: do-set-local-variable("dest-dn",scope="policy",token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))).
\[02/25/11 16:06:50.886\]:IDV2EDIR PT:        arg-string(token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))))
\[02/25/11 16:06:50.886\]:IDV2EDIR PT:          token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:50.901\]:IDV2EDIR PT:            token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:50.901\]:IDV2EDIR PT:              token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:50.901\]:IDV2EDIR PT:                token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:50.901\]:IDV2EDIR PT:                  token-xpath("@qualified-src-dn")
\[02/25/11 16:06:50.901\]:IDV2EDIR PT:                    Token Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:50.901\]:IDV2EDIR PT:                  Arg Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:50.979\]:IDV2EDIR PT:                Token Value: "CN=fenixm,OU=Mosquito\_Control,OU=PublicWorks,OU=CTH,O=LEON".
\[02/25/11 16:06:50.979\]:IDV2EDIR PT:              Arg Value: "CN=fenixm,OU=Mosquito\_Control,OU=PublicWorks,OU=CTH,O=LEON".
\[02/25/11 16:06:50.979\]:IDV2EDIR PT:            Token Value: "NOT-FOUND".
\[02/25/11 16:06:50.979\]:IDV2EDIR PT:          Arg Value: "NOT-FOUND".
\[02/25/11 16:06:50.979\]:IDV2EDIR PT:      Action: do-set-local-variable("dest-dn",scope="policy",token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))).
\[02/25/11 16:06:50.979\]:IDV2EDIR PT:        arg-string(token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))))
\[02/25/11 16:06:50.979\]:IDV2EDIR PT:          token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:50.979\]:IDV2EDIR PT:            token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:              token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:                token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:                  token-xpath("@qualified-src-dn")
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:                    Token Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:                  Arg Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:                Token Value: "OU=Mosquito\_Control,OU=PublicWorks,OU=CTH,O=LEON".
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:              Arg Value: "OU=Mosquito\_Control,OU=PublicWorks,OU=CTH,O=LEON".
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:            Token Value: "ou=Mosquito\_Control,ou=Board,o=Leon".
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:          Arg Value: "ou=Mosquito\_Control,ou=Board,o=Leon".
\[02/25/11 16:06:50.995\]:IDV2EDIR PT:      Action: do-set-local-variable("dest-dn",scope="policy",token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))).
\[02/25/11 16:06:51.011\]:IDV2EDIR PT:        arg-string(token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))))
\[02/25/11 16:06:51.011\]:IDV2EDIR PT:          token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:51.011\]:IDV2EDIR PT:            token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:51.011\]:IDV2EDIR PT:              token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:51.011\]:IDV2EDIR PT:                token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="0",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:51.011\]:IDV2EDIR PT:                  token-xpath("@qualified-src-dn")
\[02/25/11 16:06:51.011\]:IDV2EDIR PT:                    Token Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:                  Arg Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:                Token Value: "OU=PublicWorks,OU=CTH,O=LEON".
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:              Arg Value: "OU=PublicWorks,OU=CTH,O=LEON".
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:            Token Value: "ou=PublicWorks,ou=Board,o=Leon".
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:          Arg Value: "ou=PublicWorks,ou=Board,o=Leon".
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:      Action: do-set-local-variable("dest-dn",scope="policy",token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))).
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:        arg-string(token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))))
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:          token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:51.026\]:IDV2EDIR PT:            token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:              token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:                token-parse-dn(dest-dn-format="ldap",length="-1",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:                  token-xpath("@qualified-src-dn")
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:                    Token Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:                  Arg Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:                Token Value: "CN=fenixm".
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:              Arg Value: "CN=fenixm".
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:            Token Value: "NOT-FOUND".
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:          Arg Value: "NOT-FOUND".
\[02/25/11 16:06:51.042\]:IDV2EDIR PT:      Action: do-set-local-variable("dest-dn",scope="policy",token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))).
\[02/25/11 16:06:51.057\]:IDV2EDIR PT:        arg-string(token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))))
\[02/25/11 16:06:51.057\]:IDV2EDIR PT:          token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:51.057\]:IDV2EDIR PT:            token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:51.057\]:IDV2EDIR PT:              token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:51.057\]:IDV2EDIR PT:                token-parse-dn(dest-dn-format="ldap",length="-2",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:51.057\]:IDV2EDIR PT:                  token-xpath("@qualified-src-dn")
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:                    Token Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:                  Arg Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:                Token Value: "CN=fenixm".
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:              Arg Value: "CN=fenixm".
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:            Token Value: "NOT-FOUND".
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:          Arg Value: "NOT-FOUND".
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:      Action: do-set-local-variable("dest-dn",scope="policy",token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))).
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:        arg-string(token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))))
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:          token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:51.073\]:IDV2EDIR PT:            token-map("..\\PlacementMappingTable","edir-dn","idv-dn",default-value="NOT-FOUND",token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn")))
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:              token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:                token-parse-dn(dest-dn-format="ldap",length="-3",src-dn-format="qualified-slash",start="-1",token-xpath("@qualified-src-dn"))
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:                  token-xpath("@qualified-src-dn")
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:                    Token Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:                  Arg Value: "O=LEON\\OU=CTH\\OU=PublicWorks\\OU=Mosquito\_Control\\CN=fenixm".
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:                Token Value: "CN=fenixm".
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:              Arg Value: "CN=fenixm".
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:            Token Value: "NOT-FOUND".
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:          Arg Value: "NOT-FOUND".
\[02/25/11 16:06:51.089\]:IDV2EDIR PT:      Action: do-if().
