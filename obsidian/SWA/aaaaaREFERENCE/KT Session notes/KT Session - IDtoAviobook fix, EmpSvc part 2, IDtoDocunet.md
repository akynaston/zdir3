6/13/2025 2:09:11 PM
Second session isn't going to happen I think:

John, Deborah, I think we need to cancel Tuesday's KT session, and here's why. as I looked through your feedback further from the first session, I realized the following:

 - IDtoEmployeeSvc: As discussed, I can't turn this over to Ops until we can generate INCs. In the mean time, I'm going to maintain the small group of people for production issues; so we all at least have visiblity; though the EmployeeSvc team and I will take point on resolution for now.

 - IDtoAviobook: Long story short: I'll resolve these; it would be difficult to move this task to ops currently, with the Postman & direct data modification concerion.

 - IDtoDocunet: I realized this full user push is rare enough that I should probably just get it done . .I think I can just let it run int the background while I do other things.

--Aaron




6/12/2025 5:58:59 AM

Team, We've had our first session of this meeting with the first shift of Ops, and we got a lot of feedback; so  need to change somethings from the original plan.

 1. We're talking about three drivers:
	 1. IDtoEmployeeSvc
	 2. IDtoAviobook
	 3. IDtoDocunet.
 2. The discussion to have on these drivers has changed due to items learned; here's the plan going forward:
	 1. IDtoEmployeeSvc - we really need to keep the visibility high for errors occurring when the driver attempts to update EmployeeSvc. Originally I have chosen email as it was the only possible option at the time, however, my understanding now is that the work you do needs to be tied to INCs or other DASH items; so I need to find out how to resolve.
	 2. IDtoAviobook - The issue resolution I was going to ask for help on requires the use of Postman. That, plus the fact that I found the problem space on issues here, is relatively small; and we have a plan for resolving unarchiving of users on a rehire so I don't think we'll cover anything here except to point out the latest documentation has this recorded.
	 3. IDtoDocunet - the push on this is rare enough that we'll likely keep it with us for now.















Notes from the Session 1 of the Ops KT session for dealing with errors on IDtoAviobook, IDtoEmployeeSvc, IDtoDocunet.

The focus of this call is to be a KT session for Ops on how to deal with three separate drivers with items coming up.
 - For the EmployeeSvc people on the call:
	 - This is just a quick review for you; we'll have a full UAT with you guys later to go into more detail.
	 - This call is to make sure that Ops has what they need to resolve issues.
	 - You were invited to this call to see what they'll be working to take care of. Ideally we'll get to a point where Ops receives the error emails and is able to resolve items before end users report issues.

We'll be covering three separate drivers in two sessions today, one now, and another at 3:30 CST.

1. IDtoEmployeeSvc: Discuss how to resolve the new error notification email messages (part 2; from our previous call); then the EmployeeSvc team can drop off if they'd like.
2. IDtoAviobook: Discuss the need and context on when to delete/archive users directly in Aviobook: this one is more of a question session on how we want to proceed here: it requires using Postman to update Aviobook directly; and I need your feedback: I don't know if it is our intent as a company to have you work that closely with Postman, and the Aviobook API, or what; we'll talk about that.
3. IDtoDocunet: Need to push all employees and Users: I need assistance here: This has happened only about 4-5 times over the last 1.5 years or so; but I'd like help in taking care of this.











============================================================
IDtoEmployeeSvc:
We've had a preliminary discussion on showing you issues; but I wanted to take you though resolving an issue to see the pattern. 

Items to keep in mind:
 - I'll be setting up an email message on error notifications that require intervention to resolve to the Ops distribution group. We cannot generate INC directly yet, so this is the next best approach I could find.
 - At first, we may likely get a lot of these messages. I don't have a sense for what that looks like yet; as this has been the core problem all along: issues have been too hidden to resolve when they happen! As we resolve issues, I'm hoping we can see patterns and potentially fix issues at a larger scale and adjust as needed.

Context: The error email messages are currently only sent from the IDtoEmployeeSvc driver since it's the one that actually uses the API:
	IDtoEmployeeSvc: driver using the SOAP API, and sending error notifications.
	IDtoEmployeeCarePicture: Uses the REST API; only syncs swaImage
	EmployeeServicesRoleMgmtDriver: This driver is responsible for setting swaEmpSvcBaseRole (MyAccess sets swaEmpSvcElevatedRole).
			
When an error occurs that needs intervention, an email message that is sent follows this format. Note that the full driver name appears in the subject: the tree name in the DN of the driver will show you which environment it is in. I think we won't expose all dev/qa issues to Ops, unless you simply want to see examples of errors.

Here's an example email from QA. I've changed some of the data as it appears to be a real user:


------------------------------------------------------------------------------------------------------------------------------------
***Subject:** An EmployeeServices driver reported an error (\SWACO_IDSAT\swa-idsat\services\DirXML\Driver Set AEv1\IDtoEmployeeSvc)*
======================================

***Message:***

*The driver \SWACO_IDSAT\swa-idsat\services\DirXML\Driver Set AEv1\IDtoEmployeeSvc has reported an error for user:*

*e999810.*

*The error was: IDtoEmployeeSvc-ERR-0061:Update user failed CN=e999810 ErrorCode=FIELD_INTEGRITY_EXCEPTION ErrorMsg=To create or update users for this profile, go to Setup > Digital Experiences > Settings and select Allow using standard external profiles for self-registration, user creation, and login.: Profile ID.*

*The suggested fix for this issue (if available) is: The swaEmpSvcBaseRole or swaEmpSvcElevatedRole values provided do not apply to the environment the driver is currently configured for. Fix the swaEmpSvcBaseRole by migrating the user through the EmployeeServicesRoleMgmt driver. If the incorrect role came from swaEmpSvcElevatedRole (provided by MyAccess), then send the incorrect role/profileID value to the EmployeeSvc team, and requested an updated role value, and set the value in the elevated role value (the values are provided here if they are available at the time of the error)*

*The event that caused this error was:*  
```
<add cached-time="20250605185918.052Z" class-name="User" event-id="w11qcledirqi013#20250605185918#7#3:66f45100-feb1-4e59-ac16-0051f466b1fe" qualified-src-dn="O=swa-idsat\OU=Users\CN=e999810" src-dn="\SWACO_IDSAT\swa-idsat\Users\e999810" src-entry-id="396476" timestamp="1749149954#53"> <add-attr attr-name="Given Name"> <value timestamp="1719390233#3398" type="string">FirstName</value> </add-attr> <add-attr attr-name="homeEmailAddress"> <value timestamp="1749149954#53" type="string">home@none.com</value> </add-attr> <add-attr attr-name="Internet EMail Address"> <value timestamp="1733527206#68" type="string">e999810@wnco.com</value> </add-attr> <add-attr attr-name="Surname"> <value timestamp="1719390233#3422" type="string">LastName</value> </add-attr> <add-attr attr-name="swaEmpSvcBaseRole"> <value timestamp="1733527206#86" type="string">EmployeeSvc_Employee|||00E2h000000RMSdEAO|||00e2h000000EcRCAA0</value> </add-attr> <add-attr attr-name="swaStatus"> <value timestamp="1719390233#3386" type="string">A</value> </add-attr> <add-attr attr-name="IsActive"> <value type="string">true</value> </add-attr> <operation-data DRIVER_REVISION="12.5.15" Op-EmployeeSvc-UserId="0054w00000CCNwGAAX" Op-User-Match="FOUND" Op-User-Status="TRUE" checkError="IDtoEmployeeSvc-ERR-0061:Update user failed CN=e999810 ErrorCode=FIELD_INTEGRITY_EXCEPTION ErrorMsg=To create or update users for this profile, go to Setup > Digital Experiences > Settings and select Allow using standard external profiles for self-registration, user creation, and login.: Profile ID" objectType="employee"/> </add>
```

------------------------------------------------------------------------------------------------------------------------------------


The key pieces of this are:
	* The treename in the DN of the driver.
	* The user ID at the beginning.
	* The 'suggested fix for this issue' section.

The whole raw event that triggered the error is included . it's not pretty; but I thought might be helpful; we may remove this if it's just causing noise. As shown above, the fix is to set the base or elevated role to the proper value, then ensure the IDtoEmployeeSvc driver pushes the data.


**SHOW ACTUAL EMAIL FROM THIS MORNING IN QA





**NOTE: ALL EmployeeSvc people can drop now if you would like; we're moving on to other drivers.






============================================================
**For IDtoAviobook:** 
CONTEXT: 
* This is more of a heads up so you can be aware of this. 
* The issue I'm going to describe how to fix shouldn't happen any more, and requires Postman to resolve. 
* I don't think Ops normally uses Postman, and we won't be solving that today. I only wanted you to have seen this error and know what is going on since it stops events from processing and can cause confusion in Aviobook.
* We will not be talking about the API calls today; though if SWA decides we'd like Ops to take on Postman type activities, we could have another discussion at some point if desired. The process and API, and a Postman project has been included in the driver page at: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74553541/IDtoAvioBook?preview=/74553541/648123763/IDtoAviobook%20V%2023.1-RC%20Snapshot.postman_collection.json#tab-b92ed017-afab-480c-b5ae-7e600b76b075 - 

See the Response Codes / Troubleshooting -> Avio API Archiving & Deleting Instructions section for details.




We recently found the Aviobook team has to manually create users during time sensitive situations. We found if they don't set the username and ID to the same value during creation, then the driver can't update it; you'll see errors like this:

{"code":"USER_ID_IN_USE","message":"ID 'e8566210663' is in use."},{"code":"USER_USERNAME_IN_USE","message":"Username 'e8566210663' is in use."}

These errors simply mean that the driver is trying to use an id or username that happens to exist on another already existing user; and the values collide. To fix these:

1. Check their swaAviobookRoles (MyAccess roles) value, and DirXML-EntitlementsRef (automatic roles).
	1. If they have a swaAviobookRole or DirXML-EntitlementRef value for aviobook populated: Delete the user in aviobook, and re-migrate the user the standard way (#4#/migrate-from).
	2. If they have no roles; migrate the user on the RBEAEv1 driver (to re-evaluate their automatic roles).
		1. If they then get a role, migrate as you would for #1 above.
		2. If they still don't get a role, send a note to the Aviobook team that the user is being archived, and archive the user.

I need your help in coming up with a way to allow you to resolve issues in Aviobook. . it may be that you ask my EE team to do the Postman portions . .I'm not sure what this will look like yet: 

To delete users in Aviobook: This is a Postman operation, I don't think Ops normally does this kind of fix. I'll need to work with you to find a way to properly delete users there so you can repush.

To archive users in Aviobook: this is also a Postman operation; we'll need a plan for this too.









============================================================
**For IDtoDocunet:** 
* The IDtoDocunet driver writes out files locally to the prod server, then UFM is used to push those files out to an external Vistair server, to the guys that run the Docunet app. 
* They recently fixed an issue with how they parse our file; and think they may have lost data.  This doesn't happen a lot thankfully; but I need help: We need to migrate all employees and contractors through the driver. 

The bottom line is that we have a lot of migrates to do for this driver; here are some items to keep in mind.
* Ideally, they'd be batched up . .Its about 120K users for employees and contractors for the entire SWA user set that needs to go to IDtoDocunet.
* If we push them all at once, we trigger INCs, and don't want to do that.
* It really is just adding a new DirXML-Association value of "cn=IDtoDocunet,cn=Driver Set v3,ou=DirXML,ou=services,o=swa-idsat#4#" to every single account.
* I think the full processing takes between 10 and 17 hours; depending on what else the server is doing at the time.

I think in the future, if you all agree, we may need to have the IDtoDocunet team submit a RITM to ops requesting a full user push when they need this in the future.





Status email at the end of the call:

Team,

From our call today, we covered the following:

1. IDtoEmployeeSvc: we will now be sending out email messages when we run into issues on the driver when intervention is required. We really need these to be INCs to properly have operations track their work. We don't yet have a sense for how much manual work is required; this has been part of the problem. . We may be too early on in the process to automate the resolution steps to each issue.
2. IDtoAviobook: Ops has a goal to reduce manual work - using Postman is not only manual work, but would require access to passwords, and require direct modification to Aviobook data which is also undesirable to some degree.
3. IDToDocunet: I need assistance in pushing users through the system: all employees and contractors need to be sent.
4. Manual work for Ops has been recently pushed to be more automated, and less towards manual fix resolutions. We need to find out what we're up against for all manual work above, and see what we can do to resolve.

Action items remaining:
1. For IDtoEmployeeSvc: 
	1. The manual email messages are a minimum viable solution; they really need to be  submitted as INCs, but we don't have a way to do this reliably yet.
	2. I'll be including Jeff Wade to speak to the email postfix portion of the resolution and see what we can do to avoid the 'wnco.com' postfix.
2. For IDtoAviobook: decide on our path forward if we want Ops to use Postman.
	1. I believe the Ops team has a goal to move away from manual data fixing, and there are probably no plans to use Postman nor have direct data fixing in Aviobook.
	2. We'll need to find a pattern to follow here. The Aviobook team may need to be setup with the API so they can resolve their own issues.
3. For IDtoDocunet:
	1. Push all users through the driver again (about 120K users). They fixed a bug in their parsing and suspect they may have lost data; so need all of it again. 
	2. We will likely need a way to formalize this process - we may need the Docunet team to submit a RITM or something similar in the future, though I don't know if this is the desired path forward. 
4. Ops Manual assigned work:
	1. Ops is pushing to automate issue resolution. To make this happen we are going to need to see patterns in the issues reported by the email error notification 