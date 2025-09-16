

2/20/2024 3:00:54 PM
Glen R&d TAX CREDIT PROJECT
 - Trivir spent on tasks - qualilfy
 - SWA time spent on R&D
 - not specific percentage . .
 - regular type of idm work
 - mostly normal stuff.
 - covering last 2023 . .
 - may have been things at SWA . .typicall on big projects
  General terms about R&D . .
   - SCIM - new
   - Rest conenctor
   - 10% guess R&D
   - other than idmunit connector . .
   - oneline of items for R&D
   - Yearly . .
   - send Glen one line . .
   - gradle build


Email sent to Glen:

subject: ## Tax R&D items on SWA for 2023
Glen,

  

Per our chat, here's the total list of R&D items from 2023. It is a bit more verbose than you were expecting as I wanted to add an explanation to each assuming it is helpful.

  

Here are the items we discussed already:

  

1 - **We built a brand new IdMUnit SCIM connector.** This one may be borderline for R&D; but it was a brand new connector that had to deal with the SCIM protocol and we had to research how to combine our normal new IdMUnit connector process with the protocol requirements.

  

2 - **Altea driver split:** had to split a single driver into 3; as it communicated with three distinct systems that had to work together to provide the same solution as before plus a cloud version of Altea, rather than on-prem.

  

  

  

New items:

  

3 - **We upgraded the REST connector to use JSONPath**: I classify this as R&D because it integrated so well with an IdmUnit test (Thanks to Patrick H!!)

  

4 - **Automation of NetIQ IDM Driver deployment & testing:**  I worked with SWA folks, Preston, and others to help create an upgraded build process using Gradle and Gitlab pipelines. This is the furthest I've ever seen IDM automation get: We are just about to the point where IdMUnit tests can be run any time someone pushes commits to a driver repo - SO COOL!

  

5 - **We had to Design a JDBC to DTF driver conversion process** for a system that is going away and will force us to use flat files for now. This involves finding ways to convert shim settings and policies from one driver to another while maintaining equivalent behavior.

  

6 - **New ways of classifying pilots using GCV comparisons:** Patrick H found a cool way to check entire GCV lists of data to attribute values in a single line of code in NetIQ IDM Policy.

  

That's all I can think of for now. Patrick may be a good source of these items, He's clever, that one :-)

  

--Aaron