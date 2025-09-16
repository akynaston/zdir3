===== VALIDATION ===== 

----------------------------------------------------------------------------------------------------------------------------------
         =    Please refer the driver details into  Detail description section under the Planning Tab   =
----------------------------------------------------------------------------------------------------------------------------------
Overview:
The goal of validation is:
1. Confirm the driver has no unintentional behavior changes.
2. Ensure the change/update made is successfully present.

Pipeline note:
Around Feb 2024, We now have the option to deploy drivers through the pipeline. Most of the validation for driver diffing can be done in the 'env_on_prem_plan' step in the pipeline steps where env is qa or prod.  The actual driver code is tested during the test phase that runs in all non prod environments.  See the 'Manual Validation' step below to do a manual validation; which is still valid and can be done even when using pipelines.

Validation Task - Manually Validation: Confirm the driver deployed successfully:

Begin by confirming the driver can start on the backup server:
1. Start the driver on secondary Server.
2. Confirm the driver has changed to a Running state by looking at the log file on Secondary Server, located here: /opt/idmlogs/(Target driver)/(Target driver).log.

You should see this appear somewhere at the end of the file, the 'Starting' to 'Running' is the key text here.

[05/12/21 17:13:21.618]:[DRIVER NAME APPEARS HERE] ST: Received state change event.
[05/12/21 17:13:21.619]:[DRIVER NAME APPEARS HERE] ST: Transitioned from state 'Starting' to state 'Running'.
[05/12/21 17:13:21.619]:[DRIVER NAME APPEARS HERE] ST: Successfully processed state change event.

3 - Confirm the driver revision has been updated to the target driver version.
	Notes: Confirm the DRIVER_REVISON value in the log is visible. The following < instance > document will be seen after starting the driver, towards the bottom of the trace. Somewhere in this instance document a DRIVER_REVISION element will be available - See the '< operation-data DRIVER_REVISION="X" />' section. Here is an example of the driver identification instance document which contains the driver version. Also note that any other event in the driver should contain the DRIVER_REVISON value, and can be used to verify the version.

Example of Driver revision element in the trace:

< operation-data DRIVER_REVISION="(Target driver version)"/ >

4. Stop the driver on Secondary Server; this is only the backup server used as a fallback in the event that the primary server has issues.

Now confirm the driver can start on the primary server:
1. Start the driver on Primary Server.
2. Confirm the driver has changed to a Running state by using the same methods as described above.
3. Validate driver version as described above.

----- Resources involved in the Implementation-----
* Cybersecurity EE Team (Engineering Enablement)