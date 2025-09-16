---
tags: ["#vmware"]
---
# VMWARE: Order of installation

VMWARE: Order of installation

Order of Operations:
\- Confirm mac address is correct
\- diskpart if needed
\- set ip address
\- install/update vmware tools
\- Activate the server if applicable
\- ad (hardest to change port numbers, so we let AD take 389/636)
\- edirectory (set to 390/637)
\- iManager
 - Install IDM plugin if you didn't do it during the iManager install (I dont' like to as it takes for ever, and I like iManger to be installed successfully).
 - Install idm licences.
\- .5.1 (install direct from cd took 169,684,992 bytes)
\- designer/eclipse(641 mb) - install says it needs a gig. (eclips copy over takes 137,535,488 bytes)
