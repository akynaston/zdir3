8/18/2025 11:42:16 AM
Had password issue with ppsadmin on Friday, today, learned he needs DB_OWNER, so they've requested I submit rights request in myaccess

8/18/2025 12:01:42 PM
Worked with:
Naveen Kumar Konduri - he's desginated as the owner of ppsadmin
Jose Marin - was able to fix the rights to be DB_OWNER for ppsadmin.

I think I need to change the owner to Naveen . .or manager?
correct, under: Kynaston, Aaron-754936
![[{951C4DE1-4B77-4CC9-86A7-F84895A33E08}.png]]

I also made this update to eh driver doc:
https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551166/IDtoDocuWare#tab-d0318d1b-e4cd-4000-bfc7-5c6daa61360c
![[Pasted image 20250818115657.png]]






This one Kynaston, Aaron-754926 - is wrong; JOse Marin isn't the owner:
wrong one

![[Pasted image 20250818114246.jpg]]
application name: IDtoDocuware NetIQ IDM driver service account
database name: IDM_Feed, at jdbc:jtds:sqlserver://172.23.146.22:1433/IDM_Feed