

6/14/2024 7:10:28 AM
ILM chat
SCIM server - yes
Tennant server - yes
- remote loader service - cloud
- on rem: use cloud brdige
- ILM -
 - plan to migrate to gcp . .
 - cloud bridge . . apparently in IGA . .trivir famliar with this?
 - SCIM services is graph database
 - packages for ILM is a bit different
   - ncp in the packages . .
   - ILM - SCIM name space
   - custom drivers may need package change
 - seldom use package . .
 - do we have same flexiblity based on need?
 - If migrating from an expsing space
 - if export config: if package wil migrate to new package
 - policy builder - 1.0; not there; early next year.
 - can create packages, can asociate witha ny drivers
 - packages only option between now and next year.
 - If just at policy just policy level; but can manage in Designer
 - migration: Can export iLm packages, import into ILm; migration will happen
 - not in our tennatn password management not available
   - prod tennnts will lhave it . .
 - dynamic fullfiment: new feature
 - dynamic group simliar . .
   1 - not scaleable
   2 - dyanmci group changes can' ttrac  - won't generate event
 - can capture event . .
 - jim: is equivlaent to busines rule?
 - idea only prov/deprov.
 - Shalabh Garg - giving demo
 - graph dtabase . .
 - log explorer - download or see . .
 - lots of other projects we can itengate with
 - SCIM driver out of the box
 - login goes to ILM -/

 - MAU licence model - users monthly . .licencing  . .
 - allows to pay for usage . .
 - all IDM drivers supported.
 - not userapp or rbpm . .
 - would entitlements still work?
   - should work in 1.0
   - don't have object on ilm side to collect them.
 - entitlements used to come as collection
 - operation to collect entitlements: PRC
 - managing them in the driver? yes
 - If the driver can't pull them, can store in ILM.
 - OOTB - doesn't have resource for storing entitlements; next release.
 - removing IDM entitlenets/ILM entitlements difference!
 - drivers: any change in reatlime happning in application
  - "Code map refersh" - colection . .?
 - how to migrate
 - only driver & driver config, yes migration can be done
 - roles resources & workflows
 - not a direct migratin; more trasnition
 - workflow service . .trying to bring in . .
 - workflocse require changes as they're brought in . .
 - ad/ldap/dtd migration rl manadatory
 -24.4 - common workflow library
 - policy library & risk service
 - 25 mins left: naga
 - naga share screen
 - ilm login
 - identicy console
 - driver configuration management title
 - - ILM tile
 - showing list of drivers
 - issues with application loading
 - has postman like interface
 - still has dirxmlassociation
 - advanced authentication
 - BAckup of SCIM database?
   - mechansim to grab all databalse
   - nothing - just scim
 - need to write driver to sync to edir on prem.
 -coming up with idm driver OOT B
 - end user just usermanagementobject management
 - RL running in docker . .
 - cloud bridge running in docker
 -locally rl container
 - ideally rl would run remote load as in IDM case
 - cloud bridge container - available for download
 - strucutre is flat . .
 - container attributes on the user to be added . .represent system ilike ad
 - encryption policy .
 - scim interface: can't import drivers
 -  . . .
 - admin guide - technical review ..f
 - GA - 24.3 - generally avaiable
 - towrds end first month in quarter - hand to to opeations; then month to public clod
 - Aug & stemptempber to public . .

 Q - interactoin with ILM is intended to be over Designer and identityconsole?



