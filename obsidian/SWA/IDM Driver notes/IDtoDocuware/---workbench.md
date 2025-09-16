8/22/2025 2:10:42 PM
had pssadmin-userrightsfix as shown in my other note

8/22/2025 2:10:49 PM

8/18/2025 11:04:25 AM
IDToDocuware:
Iman restart:
https://w11scledirsm004:8443/nps/servlet/webacc?taskId=fw.Startup
x266698.admins.swa-id
w11scledirsi009.swacorp.com:1524


8/18/2025 11:22:29 AM - Confirmed that ppsadmin has lost access, August 15, about 8:15 am . .
   - Possible recent CR: changes in rights in the last little while, and weren't fully set . .
   - ppsadmin should not have fully elevated rights . . need to find actual rights needed for this ppsadmin . .
   - recent CTASK needs to have corrected rights for this account . .certainly possible that ppsadmin admin rights were removed as a result!
   - Myaccess request needed:
     -
      hen sysadmin rights are granted, once CR is completed . .sysadmin rights revoked, but not DB owner . .
   - ppsadmin: don't want sysadmin!! Too many rights . .
     - Jose Marin: showing that the user had sysadmin!
     - Company policy: can't have sysadmin forever: during CR - 1pm to 4 pm . .
     - DBOwner is on IDM_Feed now!!
   - DB_OWNER is final -
   -

Naveen Kumar Konduri is the owner
yeah I can be owner

Jose Marin






ppsadmin
jdbc:jtds:sqlserver://172.23.30.84:1433/IDM_Feed
