===== REMEDIATION ===== 

----------------------------------------------------------------------------------------------------------------------------------
         =    Please refer the driver details into  Detail description section under the Planning Tab   =
----------------------------------------------------------------------------------------------------------------------------------

Restore the previous version of driver from backup taken in step 4 of the implementation CTASK
1) Import the driver with the correct version into designer Driver Set on the primary server from the backup taken (Right-click on the Driver Set -> "Import from Configuration File...")
	2) Engineering note: Ideally; the 'backup taken' is just the previous version of the driver on the master branch. See the implementation 'NOTES REGARDING DRIVER BACKUP' section for details.
2) Copy server specific settings from the primary server to the secondary in Designer
	1) This can be done by simply importing the final/[ current target env]/ [Name of driver]-failover.xml as a second import which is less error prone.
	2) The old/previous  option to explicitly copy the server specific settings is described here:
		1)  Right-click on the target driver  -> Copy -> Server-specific settings
		2)  Select the primary server as the source.
		3)  Select the driver you are working on and the secondary server as the target.)
		4) Check the following for "Select replica data you want to copy"
          "Global configuration values"
          "Named passwords"
          "Driver authentication information"
          "Driver parameters"
          "Engine configuration values"
     3) Select OK to save and then select "NO" when prompted "Would you like to merge GCVs on target servers?"
3) Set driver startup options in Designer
	1) Right-click on the target driver -> Properties
	2) Navigate to Startup Option under the Driver Configuration tab
	3) Change driver start option to the following:
		1) For the primary server, select "Auto start" and select "Do not automatically synchronize the driver" option.
		2) For the secondary server, select 'Manual' and ensure the driver is disabled. Note that it no longer needs to be set to 'manual' as the High Availability (HA) solution no longer require
4)  Deploy driver
	1) Right-click on the target driver -> Live -> Deploy
	2)  This will bring up a Summary window that shows the differences between the version you are about to Deploy and what is currently in eDirectory
	3) Click Deploy 
6) Start the driver on the secondary server and ensure driver started normally and no errors on the log file (/opt/idmlogs/[your driver][your driver].log)
7) Stop the driver on the secondary server, and disable the driver.
8) Start the driver on the primary server and ensure driver started normally and no errors on the the log file (/opt/idmlogs/[your driver][your driver].log)

----- Resources involved in the Implementation-----
* Cybersecurity EE Team (Engineering Enablement Team)