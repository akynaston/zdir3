  IDtoEmployeeSvc error seciton:
  Edit link:
  https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/edit/74551170?draftId=74588952&draftShareId=852d0704-09d4-41a2-9bcc-a42b9a89dc22&

Confluence version 36+ or so . .
# Error Management

UPDATE: May, 2025 - The following errors have been identified and many have been dealt with; in the new  error checker library (lib-checkError) while some still require intervention. For items "NOT PRESENT", you shouldn't see any more.  If you do, please notify EE. For the items marked as PRESENT, resolve the problem as indicated.

The EmployeeServices drivers (there are three, see below) are responsible for keeping users updated in the EmployeeServices database that seems to support many applications. The main driver, IDtoEmployeeSvc has MANY different error scenarios that we've had to deal with. We've tried a few options; but have settled on this main set of rules while working on these errors:

When an error is identified:

1. Automatically retry it indefinitely: we don't want to lose events. An overloaded cache already properly generates an INC, so this is a good indication there is a problem, or an error that we haven't dealt with yet.
2. If a retry can eventually solve the problem with in a retry or two, leave it handled as a retry. Add it to this documentation if it is new.
3. If retrying cannot solve the problem relatively immediately, then explicitly add a handler for it in the lib-checkError.
4. Errors that require intervention will be emailed, and written to a log (NOTE: the Dev environment cannot yet email; so we're also writing errors to a file, "IDtoEmployeeSvc.log-checkError.txt" next to the driver logs and then be vetoed.
    1. Note: this file does not roll over, and currently will grow indefinitely. Ideally, when we are able to create INCs and/or email notifications work, we'll do that instead.
    2. **DEV NOTE move to sending email only or add rollover of some sort to the error file.**
5. The 'Resolution' column below describes what should be done on the error being described.

## Notes regarding the check error file: "IDtoEmployeeSvc.log-checkError.txt"

We are using this file in place of an INC generation because this process doesn't seem to fully exist or be supported yet. Email notifications are also not working in DEV. When we deploy this to QA, the email notifications may start working. The email notifications are currently being set to this group (in the **errorNotificationRecipients** gcv in the IDtoEmployeeSvc driver). This is a smaller set of users for now until we confirm email sending works properly in QA:

- John.Mapes@wnco.com,
- Juan.Alonzo@wnco.com,
- Daman.Vallejo@wnco.com,
- Aaron.Kynaston@wnco.com

Eventually, when we believe the email content is timely and useful, we'll include a link to this page, and change this to:

- [CybersecurityOperations-DG@wnco.com](mailto:CybersecurityOperations-DG@wnco.com)

For now, I'll be reviewing this file on a regular basis to see if we can capture any other errors and disable it as soon as we can confirm email is working. Please note that I move the data in this file to a file named 'reviewMe' so that I can delete entries from it that I've already seen. 

## General Driver Information

This section describes some higher level components of the driver to help add context to the error resolution:

The EmployeeServices drivers consists of three drivers:

**IDtoEmployeeSvc** - This is the main driver; **this is the driver with the new error checker** to deal with all of the different error responses we've seen from the SOAP Salesforce API. The two drivers below do not use this endpoint.

**IDtoEmployeeCarePicture** - This driver only synchronizes images from the swaImage attribute to EmployeeServices using the REST api.

**EmployeeServicesRoleMgmtDriver** - This driver is responsible for setting the swaEmpSvcBaseRole attribute to one of the 4 base role attributes, after reviewing attributes on users. The swaEmpSvcElevatedRole attribute is used by MyAccess to set a more specific role on users.  When this is populated, this driver removes the swaEmpSvcBaseRole value.

  

The format of swaEmpSvcBaseRole and swaEmpSvcElevated role is as follows:

**(role name, human readable)**|||**(Role id value)**|||**(Profile ID value.)**

Example:

**EmployeeSvc_HR|||00E2E000002RP3SUAW|||00e2E000001IUCdQAO**

These values are endpoint specific! If you are using a role/profile combo not meant for that environment, you'll see the "To create or update users for this profile..." error below.

  

Endpoint information: With each of these endpoints, is a potential to have a brand new set of swaEmpSvc*Role values; however, recent environment clones from production mean that all roles are currently identical (May 2025).

**Prod**: This is the prod endpoint.

**EMPUAT1**: this is a temporary endpoint we use in QA.

**FC3**: this tends to be the longer term endpoint we stay on in QA.

**EMPDEV1**: This is the endpoint used in DEV.

  

Here is the current status of all errors we've identified from the Salesforce API. The 'Report to EE' column is there to help identify when items should be elevated; however, please ask us (EE) questions on an as-needed basis:

*Note: the red items below are not fully resolved:

|   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|
|**Message Short name**|**Description**|**Status**|**Resolution**|**Report to EE?**|**Is the driver automatically recovering from this?**|**Details on Driver auto-response:**|
|INVALID_CROSS_REFERENCE_KEY ErrorMsg=invalid cross reference id|This appears to be the error thrown when the association is bad. This happens quite a bit in QA when we have to switch between FC3 and their EMPUAT1 environment.|PRESENT|SHORT TERM:<br><br>The driver marks the bad association for removal and retries the event 30 seconds later. The only issue with this is that if many hundreds of users have this issue, the driver can easily get behind.<br><br>LONG TERM:<br><br>In the future when we move between FC3 and EMPUAT1, We need to delete all of the IDtoEmployeeSvc association values; and let the driver match up as needed.|No|Yes|Since the driver can fix the association and retry, this shouldn't be a problem any more. Keep in mind, every time we move between FC3 and EMPUAT1, we really should remove all existing IDtoEmployeeSvc associations, and delete all swaEmpSvcBaseRoles, and swaEmpElevatedRoles since they will no longer apply for that environment!<br><br>  <br><br>TODO: The need to do the major cleanup between environment moves became apparent with this auto-response; but we are not doing it yet. We need to investigate the least invasive way to complete a full move to another environment.|
|INVALID_CROSS_REFERENCE_KEY: Cannot create a portal user without contact.|I don't have enough information to resolve this. It appears retirees some times can be added to the system in a way that causes the driver to throw this error.|PRESENT|Notify EE, I don't have enough information to resolve this yet. Driver is just emailing/writing to a file. Eventually this really should be an INC when we can generate them from a driver.|Yes|No|N/A|
|REQUIRED_FIELD_MISSING: ErrorMsg=Required fields are missing: [Email, ProfileId]"|Simple missing fields error|PRESENT|Still appears in driver most cases have been fixed, I have not been able to remove all instances of this error. In the mean time, ensure the user has a proper email address, or LDAP mail attribute, and retirees have a proper homeEmailAddress value.<br><br>This requires an INC; to add a  proper ProfileID or email. More importantly, if we see this error, it may mean that the driver did not stop the event soon enough . .Ideally we'd stop events before they get this far since the driver cannot process it.<br><br>_**DEV NOTE: TODO: find all situations that can still cause this, and resolve.**_|Yes|No|N/A|
|FIELD_INTEGRITY_EXCEPTION: ErrorMsg= role type must match user type|swaEmpSvcBaseRole or swaEmpSvcElevatedRole most likely are bad.|PRESENT|Confirm with the app team that the role/profile combos used are valid for that endpoint.|No, the app team should be able to help define a role/profile combo.|No|N/A|
|FIELD_INTEGRITY_EXCEPTION: ErrorMsg=To create or update users for this profile, go to Setup > Digital Experiences  Settings and select Allow using standard external profiles for self-registration, user creation, and login.|We've see this error when using a role/profile ID combo that DOES NOT APPLY to that environment: This mostly happens when we move between FC3 and EMPUAT1 in QA; and an old role/profile id combo is presented.|PRESENT|Populate swaEmpSvcElevatedRoles or swaEmpSvcBaseRoles with some role/profile id combos that have been verified to exist in the destination EmployeeSvc instance.<br><br>Tip: The EmployeeServicesRoleMgmt driver is responsible for setting swaEmpSvcBaseRole. If it needs to be reset, just clear this value, and the proper new one will be added. Using a 'migrate from' on this driver also works.<br><br>  <br><br>  <br><br>* Special note: There is an incorrectly named Retiree role in most EmployeeService environments. In Employee Services, it appears as the 'LGull' role - or the Linda Gulledge role. This user still exists at SWA BTW, in at least one non prod env; though I'm not sure which. If we attempt to use the 'actual' retiree role, you'll see the, "FIELD_INTEGRITY_EXCEPTION: ErrorMsg=To create or update users . . ." issue as described above.|No.|No|N/A|
|FIELD_INTEGRITY_EXCEPTION: ErrorMsg=Invalid Email Address: Must be in domain(s) [wnco.com](http://wnco.com/): Email|The email must end in '[wnco.com](http://wnco.com/)' in most environments.|PRESENT|Ensure the email address (Internet EMail Address, or just 'mail' through LDAP ends in  '[wnco.com](http://wnco.com/)'. <br><br>  <br><br>Note: all environments including non-prod must end in **wnco.com**, but any prefix on it can be used: Use something like @[default.wnco.com](http://default.wnco.com/) or @[invalid.wnco.com](http://invalid.wnco.com/) for email addresses in lower environments.|No|No|N/A|
|FIELD_INTEGRITY_EXCEPTION:* ErrorMsg=Cannot grant or remove a profile with modify all data, without having the modify all data permission yourself.|NOT SOLVED: I do not know how to resolve this issue|PRESENT|TBD: determine how to resolve. I've seen this in any number of modification scenarios, and have not been able to determine a pattern. Next action: when reproduced send original payload and full error to the EmployeeSvc app team.|Yes|No|N/A|
|ErrorMsg=RETRY: ECMA exception at LINE 103: exception: JavaException: org.xml.sax.SAXParseException: Content is not allowed in prolog.|Happens when the driver tries to parse the result of a failed event as XML, then discards the original error. These are 100% due to password issues for the service account.|NOT PRESENT|This error has been resolved by adding a step to test the authentication upon startup. The driver will fail to start if the password is bad.<br><br>Second, we've added a check to see if the authentication fails, the driver avoids parsing the result as XML when it is not XML; so the actual INVALID_LOGIN error can be seen.  If this error does appear, it means the driver attempted to parse XML that wasn't valid.|Yes, error should not be seen.|No|N/A - a fix was put in the driver to avoid the main cause of this error; though if it appears again, we'd need to find the new offending code path and resolve.|
|ErrorMsg=RETRY: ECMA exception at LINE 288: exception: TypeError: Cannot find function contains in object|This is due to a programmer error, and has been resolved|NOT PRESENT|This should no longer appear. This occurs when a field or function access is attempted on a javascript object that does not have that field or function; and requires a bug fix.|Yes, error should not be seen.|No|N/A - a fix was put in the driver to avoid the main cause of this error; though if it appears again, we'd need to find the new offending code path and resolve.|
|PRIVATE_sfLoginRequest failed to login, error:RETRY: HTTP 500 Server Error, SOAP faultcode=sf:INVALID_LOGIN|This is seen whenever the password is bad: driver has been updated to test the password upon startup: this error will be displayed if the password is bad.|PRESENT|This error is now should only be seen during driver startup, and when the driver attempts to log in again when the session has expired.|No, unless the error is seen outside of a driver start up attempt.|Yes, partially.|The driver will validate the authentication upon startup, and will refuse to fully start if it can't authenticate.|
|ErrorCode=UNKNOWN_EXCEPTION ErrorMsg=group membership operation already in progress|This error simply means the user isn't ready to be updated yet, and just needs to be retried.|PRESENT|This is a temporary error and is resolved by the natural retry in the lib retry manager.|No.|Yes|The driver just retries until it succeeds on this situation. As with all errors, if the retry never succeeds; the cache will grow to point that will trigger an already existing INC generation that happens for all drivers on large cache errors. That way, the issue can be studied, potentially fixed, then re-sent through the driver when issues are resolved.|
|Driver infinitely retries an error: either as seen in the trace, or an INC is generated for a large cache for the IDtoEmployeeSvc driver.|This means we've hit an error that we do not yet have documented.|PRESENT|The EE team needs to know about this, it means there's another error that cannot be retried.|Yes.|No|This kind of error will show up as an INC due to the cache overload INC that exists for all drivers. Look at the most recent few events in the trace to determine what events are being retried repeatedly.|
||||||||

  

Success messages:

  

|Message Identifier|Description|Sample message|
|---|---|---|
|IDtoEmployeeSvc-INFO-0001|User ID Found|IDtoEmployeeSvc-INFO-0001: User ID Found for User : CN={e855631} :  EmpSVCUserId={a0H2F000001EggMUAS}|
|IDtoEmployeeSvc-INFO-0010<br><br>(Contact object msg code range starts from 0010)|Contact match found|IDtoEmployeeSvc-INFO-0010: Contact match found CN={r855631}  EmpSVCContactId={a0H2F000001RggMUAS}|
|IDtoEmployeeSvc-INFO-0056|Create user success|IDtoEmployeeSvc-INFO-0056: Create user success CN={e855631} UserId=={a0H2F000001EggMUAS} Association has been added|
|IDtoEmployeeSvc-INFO-0012|Create contact success|IDtoEmployeeSvc-INFO-0012: Create contact success CN={r855631} ContactId={a0H2F000001RggMUAS} Association has been added|
|IDtoEmployeeSvc-INFO-0058|Update user success|IDtoEmployeeSvc-INFO-0058: Update user success CN={e855631} EmployeeSvc UserId=={a0H2F000001EggMUAS}|
|IDtoEmployeeSvc-INFO-0060|Update (merge) user success|IDtoEmployeeSvc-INFO-0060: Update  (merge) user success CN={e855631} EmployeeSvc UserId=={a0H2F000001EggMUAS}  Association has been updated|

Reference error message standard: [IDM Driver Messages](https://southwest.atlassian.net/wiki/display/CYSEC/IDM+Driver+Messages)

  

Below are issues reported as Dash INCs that do not have an error handling in the Driver (if any of these errors need to be handled in the Driver logic, OPS to work with Core/CSEE to schedule that in)

|   |   |   |   |   |   |
|---|---|---|---|---|---|
||Issue Reported|Issue Resolution|Reported Date|Resolved Date|Issue Status|
|1|||||RESOLVED|