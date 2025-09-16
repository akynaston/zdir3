.xOk - status report for week ending 9-05
Yvonne,

Here's our weekly status report:

MyAccess:
  - Mike is working on the MyAccess work for Apptio & TargetProcess - collectors are all done.
  - He's had many projects to fix and resolve in QA & production as you know.
  - We're now working on the fulfilment side (writing to eDirectory).
  - Next we'll actually deploy the driver to QA so we can have the driver complete the fufillment, and test end-end.
  - Mike and I had a call today to confirm we can properly assign TargetProcess roles into eDirectory, and it seems to have succeeded; however, 4 major questions came out of this call we need Ashleigh to answer.

IDtoApptionFrontDoor: Driver is complete; waiting on end to end testing with MyAccess
IDtoApptionTargetProcess: Driver user create use case is complete . .I have about 5-8 use cases left plus an authentication issue.

The biggest issue on my plate is this authentication issue.  Whenever the API is used to make a request to Apptio, the actual URL contains the authentication key!!  It's completely visible to every component that can see the url, this is a big security hole.

https://southwestairlines.tpondemand.com/api/v1/users/2959?format=json&access_token=secret value is right here!!