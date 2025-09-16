6/4/2025 6:32:20 PM
Moved here; UAT plan:

Team,

Here's some suggestions on what we can test during UAT:

 Since the work done in the driver is related to error management, many of these items are going to be a funny experience to try and test; so we'll either need to come up with a test, or wait until we see the situation in traces. Here are the test items from the error section on the driver page: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/74551170/IDtoEmployeeSvc+EmployeeServicesRoleMgmtDriver


Every one of the following cases have caused event loss in the past. Ideally, if Ops is able to see these messages, and fix the user within a day or so, we should see a decline in INCs generated, and end users 

Items to keep in mind:
* During this testing session, and during normal operation; if something occurs to trigger an issue that the driver can fix on its own; you'll get an error email for the failed attempt, then the driver will resolve the problem. I don't have a way to avoid these email messages, since the driver is getting two separate events - example: When we set bad roles; the driver can recover from this; but does send an email.
* General rules when error is detected:
	* If I know about the error, the driver may:
		* Resolve the problem.
		* Stop the event, and send an email about what needs to be fixed. I have tried to include a suggested fix to the end user, or provided the  message this message if we don't have a solution: "Please record the context that caused this situation, and send this email to the EE team for resolution; we do not currently have a solution for it."
	* If I don't know about the error, the cache fills up, and generates an INC (the only time we can do this), see error 14 below.
* If an error either doesn't ever resolve from retrying, or is one I haven't seen yet, error 14 below will apply.

==================================================================
1	INVALID_SESSION_ID
  Description -  This one appears every 15 in the trace: when the API reports this, the driver logs in again properly now, and retries the event.
  Email? - No, review the trace to see this happening now.
  How to test - See existing traces in DEV/QA to see examples of this happening.
	Use this command to find some instances, and walk through trace: grep sf:INVALID_SESSION_ID *
		Note: the current driver in production does have the ability to log in again; however, there are times where it does not properly detect the session is expired.

==================================================================
2	INVALID_CROSS_REFERENCE_KEY ErrorMsg=invalid cross reference id
  
  Description - appears with an association is bad: mostly seen when switching between FC3 and EMPUAT1; need to discuss cleanup.  This theoretically shoudln't occur in production; but we know upgrades an some minor shifts happen in production from time to time; the driver can deal with this.
  
  Email: No, driver resolves.
  
  How to test - Set a user to a random association; see the driver recover.
      Example:
        Start, change association to #4#bad
        Then wait 30, association is restored . . 
        cn=e97401,ou=Users,o=swaiddev
        cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#1#0052E00000Ji4I0QAJ


==================================================================
3	INVALID_CROSS_REFERENCE_KEY: Cannot create a portal user without contact.
  
  Description -  I didn't see this error enough to be able to reproduce; event is vetoed and logged. The driver can create contacts; but there appears to be a branch of processing that is bypassed and skips the contact creation.
  
  Email: - Yes
  
  How to test -(not enough information) The driver will only notify of this error then exit. in most cases, the contact is created by IDF; there is a branch of code to deal with contact creation; but I couldn't get enough info on what can be done to test this - the email asks the user to report the error to my team until we can come up with a better solution.
  
==================================================================
4	REQUIRED_FIELD_MISSING: ErrorMsg=Required fields are missing: [Email, ProfileId]"
  
  Description - If email address or profile id is missing from the payload, the event is logged and vetoed.

  Email: - Yes
  
  How to test - fixed as many versions of this that I could (users missing email upon initial creation); though some still have been appearing that I can't resolve yet. Ideally, we'll see a pattern on this one and be able to get in front of the problem.
	  e.g.: I think email addresses may be deleted in eDirectory when users become a retiree . . This may be causing our terminated users to not be disabled . .I think in these cases, I may need to add a default 'invalid@invalid.wnco.com' address in the payload; so we can terminate those users . .

==================================================================
5	FIELD_INTEGRITY_EXCEPTION: ErrorMsg= role type must match user type
  
  Description - This happens when the role/profile id are not correct, don't match.
  
  Email: - Yes
  
  How to test - This one has been a bit rare; maybe you can help me to understand: this happens when the driver attempts to assign a valid, correctly formatted role, that does apply to that endpoint, but attempts to give the user too many rights; not sure what the end user would do to fix this . . .

==================================================================
6	FIELD_INTEGRITY_EXCEPTION: ErrorMsg=To create or update users for this profile, go to Setup > Digital Experiences  Settings and select Allow using standard external profiles for self-registration, user creation, and login.
  
  Description - this happens when the role/profile id combo doesn't apply to that endpoint; mostly seen in the FC3 -> EMPUAT1 transfer, or back.
  
  Email: - Yes

  How to test - Give a role that is syntactically valid but doesn't apply to that system, such as this FC3 role:
  "EmployeeSvc_Employee|||00E2h000000RMSdEAO|||00e2h000000EcRCAA0". Note: leave user associated, and ensure they have an email address before testing.

==================================================================
7	FIELD_INTEGRITY_EXCEPTION: ErrorMsg=Invalid Email Address: Must be in domain(s) wnco.com: Email
  
  Description: simple formatting issue: email must end in wnco.com . .an email like e999999@thisisinvalid.wnco.com is valid!
  
  Email:  Yes
  
  How to test: Set an email that violates the format, such as e99999@wnco.com.bad

==================================================================
8	FIELD_INTEGRITY_EXCEPTION: ErrorMsg=Cannot grant or remove a profile with modify all data, without having the modify all data permission yourself.
  Description: This one I have not seen enough to be able to resolve; and do not have a solution for it.
  
  Email: -  Yes
  
  How to test: I've only seen this a handful of times; and don't have enough of a pattern to test it . . we'll be emailed, and the end user will see a message telling them to get the context, and send us the info so we can fix.

==================================================================
8A	FIELD_INTEGRITY_EXCEPTION: (Generic)
  
  Email: -  Yes
  
  How to test: We have 5 different versions of this error . .I suspect there could be more that I haven't seen yet; so this is a catch all on this type of error. Can't test this until we can find a situation that I triggers a FIELD_INTEGRITY_EXCEPTION, that isn't already classified.

==================================================================
9	ErrorMsg=RETRY: ECMA exception at LINE 103: exception: JavaException: org.xml.sax.SAXParseException: Content is not allowed in prolog.

  Description: this was a bug in the driver, attempting to parse a successful SOAP response XML document that wasn't an XML document. This issue has been resolved.

  Email: Yes, and the driver is set to stop on this error, since it is likely bug.
  
  How to test: Can't test directly unless I add the bug back; but we can grep existing logs to see if the error has appeared in the last few days. When it does appear, the the driver will stop . .So far, in most cases I've seen restarting the driver and repushing the user is enough to resolve; but since this isn't super deterministic; we'll stop the driver for now and study logs; unless someone disagrees.

==================================================================
10	ErrorMsg=RETRY: ECMA exception at LINE 288: exception: TypeError: Cannot find function contains in object
  Description: this is a bug in the driver: attempting to pull a field from JSON object that doesn't have that field causes this error.

  Email: No. The code that generated this error has been removed during regular development.

  How to test: I wasn't going to add this one because it was an issue I had caused; but I did want documentation showing that this can happen. If it were to happen, it would be classified as error 14 below.

==================================================================
11	PRIVATE_sfLoginRequest failed to login, error:RETRY: HTTP 500 Server Error, SOAP faultcode=sf:INVALID_LOGIN

  Description: Shown when the given password is bad for the driver.  This should only show up upon driver startup, and when the password changes to a new value while the driver is running; otherwise would classify as error 14 if some version of it does appear that's not already classified.
  
  How to test: We could change the actual password, or put in a bad password in the driver; and see that it won't start without a successful connection to EmployeeSvc.

==================================================================
12	ErrorCode=UNKNOWN_EXCEPTION ErrorMsg=group membership operation already in progress
  
  Description: every time I've seen this error, a retry resolves it.
  
  Email: - no, driver retries automatically. If it doesn't eventually resolve, this error will classify as error 14/.
    
  How to test: we'll have to scan the traces; there isn't a way to reproduce this.

==================================================================
13	INVALID_EMAIL_ADDRESS
  Description: This is a situation where the email provided is bad for some reason, more likely that it isn't an email that was set.
  
  Email:  Yes.
  
  How to test: Set to a value that is not a vaild email address such as "notanemail"

==================================================================
14	Driver infinitely retries an error: either as seen in the trace, or an INC is generated for a large cache for the IDtoEmployeeSvc driver.
  
  Description: This is any other error that I don't know about; or is eventually hit if a retry doesn't solve a problem.
  
  Email: No, however, an INC is generated in this case, since the driver cache file overflows.
  
  How to test: This is meant to be a catch all: it will retry until it succeeds, or the cache grows to a point that we create an INC. I've had about a month of monitoring for this with the latest driver in DEV and QA and haven't seen issues; but if we have it in production, we'll get an INC and then be able to go fix the issue and/or delete the offending event.

==================================================================
15 MALFORMED_ID ErrorMsg=Profile ID: id value of incorrect type: BadValue
   
  Description: This error means that a role or profile ID doesn't follow the proper 18 alphanumeric format, such as: EmployeeSvc_Employee|||potato|||00e2E000001IUCdQAO
  
  Email: Yes.
  
  How to test: Add a bad value as shown in the description. This shouldn't happen during normal operation, unless I have a bug in an EmployeeSvc driver or MyAccess was populated with invalid roles. The driver does require that the format be as follows: (human readable string)|||(role id)|||(profileid). If it is not, the event is vetoed (TODO: Prod MyAccess doesn't have issues with this; but non prod environments may write old format roles . . also, need to be able to swap MyAccess between FC3/EMPUAT1, if we need to support elevated roles there.
  
	  