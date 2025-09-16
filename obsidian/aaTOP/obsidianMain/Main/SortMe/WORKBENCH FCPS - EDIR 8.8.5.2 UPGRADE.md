---
tags: ["#TODO","#c-fcps"]
---
# WORKBENCH: FCPS - EDIR 8.8.5.2 UPGRADE

FCPS TODO:
 - apptingment at 1 for BAe placement discussion
 - gather fcps prerequisite information from test environment
 - gather fcps prerequisite information from production environment
 - gather questions for novell (confirm pre-requisites, ask backlinker questions ect)
 - open support incident with questions.
 - copy the two tar balls into test and prod.
FCPS notes:
Dev
 - RHE4, requirement asks for RHE5
 - SLPD is not installed in Dev. . is this - [ ] going to be an issue?
 - multicast is not enabled: 224.0.0.0 missing, route is not installed, so we can't make the updates to the table. Do we really need this?
 - double check ntp is installed right (check all servers are updated) ntp-4.2.0.a.20040517-4 (check if sufficient)
 - Dev has compat-libstdc++-33-3.2.3-47.3 installed, since we will probably be targeting RHE5, we'll need to upgrade to "compat-libstdc++-33-3.2.3-61.i386.rpm", we'll have Unix teams do this.
 - A module titled 'compat' should be installed, not sure if this is a series of modules, or exists exactly as named.
     
 - We need to confirm the instructions in the doc, they're misleading and confusing, for triggering a backlink process. "ndstrace=\*B".  We need to know when the processing is completed, and how to execute it properly.

UPGRADE PLAN

Susan,
 
We'll use the standard non-oes, root install of 8.8.5 to accomplish the upgrade from 8.8.2, I haven't seen a separate SP5 download.
 
For tomorrow, I plan on walking you through the documentation at http://www.novell.com/documentation/edir88/edirin88/?page=/documentation/edir88/edirin88/data/a79kg0t.html that describes the installation process. Most of the preliminary checks can even be done now, as time permits.  I'll call you tomorrow morning, and we'll go over it in detail.  Ideally, as you mentioned, I'd like to complete the install in the Dev environment.  At that point, I'll update my team and we'll discuss the next steps.
 
Is there anyone besides yourself that needs to be part of this walk-through?
 
 
 
Overall plan:
 
From this URL:
http://www.novell.com/support/viewContent.do?externalId=7004912
 
This will be our path:
 
8.8.2.0
to
8.8.5.0  (using the standard 8.8.5 install iso, Non - OES, root install) - http://download.novell.com/protected/Summary.jsp?buildid=63eV\_vS9dv4~
to
8.8.5.2  (using download from: http://download.novell.com/Download?buildid=T2wcCZC5kh4~)
                  
 
Let me know if you have any questions or concerns.
