@echo off
rem This is just a small tool to hide changes I've disabled.
rem del *gary* /s
del *kyle* /s
del *aaron* /s
rem git update-index --assume-unchanged src/test/java/org/idmunit/IDtoADTestsGary.java
git update-index --assume-unchanged src/test/java/org/idmunit/IDtoADTestsKyle.java
git update-index --assume-unchanged src/test/java/org/idmunit/IDtoADTestsAaron.java
rem git update-index --assume-unchanged src/test/resources/IDtoADTestsGary.xls
git update-index --assume-unchanged src/test/resources/IDtoADTestsKyle.xls
git update-index --assume-unchanged src/test/resources/IDtoADTestsAaron.xls

