9/28/2023 8:32:32 AM
BAES call
9/28/2023 8:59:26 AM
BAES call
Nick Penmen - joineding EC - technical authority

IDV and AS
 - NIck to talk us tthrough the intor.

Key point: 
 - IDV to eDirectory 
 - seeing full context in diagram - vsdx - 
 - Want to improve control about taking devices to forgen contries.
 - Proactive side: for people that want to declare devices
	 - make the process smoother and easier for them
 - Reactive process: for broken policies - take devices away.
 
 - Just focusing on proactive process for now.
	 - Reactive side around security tool sets, not with in export control, so not us.
 - RAY - authrization
	 - BAE sysems and laptophand cary web page - enter traveller detials
	 - New request - nick.penmenhays@baesystems.com, also has hays2 account . .
	 - Software - Axway GAteway: rest API - LDAP calls, SQL calls
		 - basic transofmratoin from rest to back end system.
	 - using this to integrate with IDV.
	 - RAE - can see greenleen, qualtricks.
	 - scope is only greenlink now.
	 - 
	 
	 - second step: via wem methods
	 - oracle db pull data from webapps
	 - product called taphis.
	 - can check ecp for "am i authorized"
	 = Taphis: document marka nd marke mails
	 - can track ecport control markings.
	 - marking - export controled markes
		 - Titus - email
		 - word exel pwoerpoint . 
	 - WebMethods also gos for audit compliance
		 - ids dropped to audit.
		 - can scan emails in markings.
		 - Secondary account: hays2
		 - One user have multipl accounts in moultipe domains . .
		 - greenlnk, pinklnk - all have different security boundaries
		 - exahnge mailbox, fileservers; all can contain markikngs.
		 - Can't send or save without marking.
 - There are other contols in place; can do dirty word analysis.
 - allows for approval; but futehr downthe line, can do automated approvals.
 - if risk virtually zero; in the future, in about a year from now 9/28/2023 9:19:58 AM
 - TriVir: focusing around AS piece (cicurling idv)
 - want to use wemethods from oracle database.
	 - consulting dates to explore schema, generate SQL to navigate throught shchema.
	 - 5 days is the guess . .
	 - Most optimal way to talk to the dtabase.
	 - Webmethods and Axway - mule soft or del boone 
	 - 	data mover, aggregate "EPLs" etl?
	 - presents rest api, and simple translation
	 - want to reuse through webmethods . .
	 - (edir drive rlater)
	 - Shaun: SQL side - Jeremiah
	 debate:
		 - axway directly to idv
		 - or separate edir
		 - IDV is sensitive
	 - could do an edir2edir driver to the secondary tree.
	 - could be in different network . .
	 - super appealing for these reasons to have separate edir tree . .
	 - preferred on seconedary tree from arthechectual review
		 - If have appb, coudl also make use of the secondary tree.
		 - each app could have new directory . .
	 - price it up: single direction edirectory
		 - Nick: firstname lastname, domains, CN
		 - pushign data, event driven.
		 - Also need to look at deletes
		 - Levers dates against person so know when they've left.
		 - May need to delete users . .
		 - not ineterestd in disbaled or expired accounts.
		 - lookup tree of current users
		 - Some attrs, login disabled & leavers date may be good; could filter out on their side.
		 - if future app comes along, can still use edir 
	 - there's lots of lever request from applicatoins
		 - could just look for leavers: just leaving date populated.
		 - 
	 - if something is deleted in IDV.
	 - creates updates delet,e all pull across.
	 -  - creates updates delets - 
		 - frist name ,astnae msin cn logindisabled, levaers date
	 - lookup tree doesn't exist at all
	 - until deleted in central idv.
		- condition: filter leavers records and expired users.
		- No sprawl for edir data . .
		- current api creating today - could read from lookup tree, just current users.
	 - future proofing: be careful - 
		 - axwaygateway . .leavers date and domain record expired
		 - greenlink may be active, quratslink expired . .
		 - ASSUMPTION; axway gateway: can do standard ldap
	 - if user has one active/one inactive domain on a user . .
		 - can we dismiss domain as it is expired .. 
		 - as long as we can do this in an ldap query . .
		 - could say to RAE: current employees only . .
	 - Building intellinjece into the LDAP
		 - exluce leavers, and expired domains.
	 - would need identiy and auxiliary classes:
		 - superset . .
		 - axway . .
	 - LDAP query help
	 - Consider some indexes . .
	 - All auxiliary classes in this app data . .
	 - Schema for secondary tree: may need to be subset . .
		- just auxiliary classes . .
		- Need to understand pros and cons . .
	 - naming conventions need to be the same . .
	 - IDV and lookup tree: data nad schema would be subset . .
	 - Application Directory
	 ** - AGD axway gageway directory
	 - SOW and rom
	 - Nick: - 
	 - timelines - shuan:
		 - Timeline: Get SOW & ROOM cost
		 - 9th of october - goal for the SOW
	 - NEXT ACTIONS:
		 - PUt together estimate stylesheet.
		 - 
	 
	 
     
     
9/29/2023 11:29:32 AM
Shaun and Aaron call
BAES - CBT
 - They are in their "pre-definition" phase.
 - RA is next
 - then engineering.
 - Estimate
 - 40 hours for RA/AC work.
 - SOW - When done with this fase, another SOW for engineering itme.
 - They want a ROM, probably 4 week.
 - 
