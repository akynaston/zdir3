===== IMPLEMENTATION =====

The high level steps are:
1 - Backup the existing driver (Note: skip this step if this is a new driver, go to the 'Steps to deploy the new driver:' step below):
2 - Deploy the driver code
3 - Disable the driver

----------------------------------------------------------------------------------------------------------------------------------
         =    Please refer the driver details into  Detail description section under the Planning Tab   =
----------------------------------------------------------------------------------------------------------------------------------

===== STEPS TO DEPLOY AN EXISTING DRIVER =====

1) Ensure driver is running normal (Check using iManager and driver log files)
     1a) Confirm the driver is running, using the description in the validation change plan.
2) Import the currently live driver into your Designer project
     2a) Using designer, if you already had driver  in your project, delete it from your Project (Right-click -> Delete)
     2b) Import the Live version into your Project (Right-click on the DriverSet -> Live -> Import -> Browse -> Navigate to the driver under the Services OU)
3) Take a back up of the driver you just imported from designer project
     3a) Right-click on the driver and choose "Export to Configuration File..."
     3b) Save it to a place where you can use it if you need to back out the Change (Best to name it in the format of Environmnet_DriverName_CHG#.xml :
4) Stop driver on IDM hosts  (Can be done either through iManager or Designer)
5) Delete the driver  from designer project.

===== STEPS TO DEPLOY NEW DRIVER  =====
	*The developer must have already committed the changes into Stash/Git, and then merged to master before the link below is valid!
6) Import driver (Driver revision DRIVER_REV) into designer
     Git URL: https://gitlab-tools.swacorp.com/csiam/idm/[ "drivername" ] driver  - xml is under the Final/Environment folder.
     - Import the "drivername"xml file for the main driver onto the main server,
     - Then import the "drivername"-failover.xml file for the driver settings on the secondary server.
7) Select OK to save.
8) Set driver startup options in Designer to enable testing of the driver first on the secondary server:
     8a) Right-click on driver -> Properties
     8b) Navigate to Startup Option under the Driver Configuration tab
     8c) Change driver start option to the following:
          Select secondary server: Select "Enabled"
          on new IDM host: Select "Disabled".
9) Update all the password (Authentication, Driver object, Remote loader, Named passwords) on all servers
10) Deploy driver
     10a) Right-click on driver -> Live -> Deploy
     10b) Click Deploy
11) Start the driver on Secondary IDM host  and ensure driver started normally and no errors on the log file.
12) Stop the driver on Secondary IDM host (testing here is complete for now).
13) Disable the driver on Secondary IDM host
14)  Change driver start option to the following:
 - new IDM host: Select "Auto start" and select "Do not automatically synchronize the driver" option
 - Secondary IDM host: Select "Disabled".
15) Deploy driver
     15a) Right-click on driver  -> Live -> Deploy
     15b) Click Deploy
16) Start the drivers and ensure driver started normally and no errors on the log file. (/opt/idmlogs/[ drivername] driver . .log)


----- Resources involved in the Implementation-----
* Cybersecurity EE Team (Engineering Enablement)