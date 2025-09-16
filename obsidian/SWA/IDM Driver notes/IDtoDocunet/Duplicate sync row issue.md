6/6/2024 12:44:00 PM
Note on push in prod #3 - for some reason, sync events print out two lines when doing a high number of resyncs . .




w11pcledirpi010
6/5/2024 3:35:08 PM - started IDtoDocunet push, dxcmd hasn't come back yet.
6/5/2024 3:35:26 PM - cpu 116%
6/5/2024 3:35:37 PM - 109
6/5/2024 3:35:41 PM - 102
6/5/2024 3:36:32 PM - 102.6 dxcmd still not back yet
6/5/2024 3:37:31 PM - not back yet
6/5/2024 3:38:36 PM - just starteds eeting itesm write otu . .uh oh lower trace DXCMD NOT BACK YET!
6/5/2024 3:39:07 PM - about 2-3 a second, now trace at 1, many a second


took 3 mins and 36 second sjust to mark all resyncs.
 - takes roughtly 10 times as long when trace is high . .


[edir@w11pcledirpi010 /opt/IDMFeeds/IDtoDocunet/output]$ date && cat *  | wc -l
Wed Jun  5 16:43:59 CDT 2024
10675
[edir@w11pcledirpi010 /opt/IDMFeeds/IDtoDocunet/output]$

[edir@w11pcledirpi010 /opt/IDMFeeds/IDtoDocunet/output]$ date && cat *  | wc -l
Wed Jun  5 16:44:13 CDT 2024
11262
[edir@w11pcledirpi010 /opt/IDMFeeds/IDtoDocunet/output]$

6/5/2024 3:47:20 PM - DXCMD STILL NOT BACK!


[edir@w11pcledirpi010 /opt/IDMFeeds/IDtoDocunet/output]$ date && cat *  | wc -l
Wed Jun  5 16:47:26 CDT 2024
18697

duplicated row:
2024 06 05 09 3836.604,03,Ground Operations,e100070,Trevor Lee,Trevor,Fernandez,Trevor.Fernandez@wnco.com,RM01,Ramp Agent,SRQ,Employee,e3208,,?????,?????,01/16/2012,,A,,sync
2024 06 05 10 3347.588,03,Ground Operations,e100070,Trevor Lee,Trevor,Fernandez,Trevor.Fernandez@wnco.com,RM01,Ramp Agent,SRQ,Employee,e3208,,?????,?????,01/16/2012,,A,,sync

