3/27/2024 1:54:33 PM
If you get the error that the DTF connector is not detecting the latest file, check your output-file-ext setting!

13:51:38.260 [Test worker] INFO  org.idmunit.IdMUnitTestCase - testUserModifyLOA[16]: Verify object created in the file.
13:54:45.630 [Test worker] INFO  org.idmunit.IdMUnitTestCase - RETRY (9) Expected file '1711568695199.tmp' or '1711568695199.txt' to be the oldest file but '1711569093286.tmp' was the oldest testUserModifyLOA[16]
13:54:45.631 [Test worker] INFO  org.idmunit.IdMUnitTestCase - ...delaying 6 secs


![[Pasted image 20240327135432.png]]