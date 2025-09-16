9/29/2023 2:55:16 PM

'HR Feed SocketTimeOutException Issue' OA task on the BAES UK O&M 2023/24 project for that BAES work you are doing (I adjusted your last week's timesheet to use that task FYI).

Jave program to use url connection:
     - run on a cronjob . .
     - download the file with lots of logging . 
     - Log out all headers
     - Log out reading of all data
     - every 30 mins for a eek . .
     - icnrease during problematic time.
     - Hurl if it doesn't give us the data .
     - HTTPUrlconnectionhandler
         - Confirm this . .
     - Appache HTTP client:
         - apache client: does have debug logging I can turn on . .
     - httpurlconnectionhandler:
         - Don't get headers until it's received them all . .
         - **warning: if it's this one: don't get headers . .
     - This is the step we need to take to cut the problem in half . .
     - JVM flags - turn on - turn on all data being sent  .
     - USE IDM JVM . .
     - make test program do any of the tests . 
     - Removes IDM variable . .
     - Variy timeout vlaues!!
     - if it fails, grab schema; or do some alternate!
     ]
9/29/2023 2:55:24 PM
Tool requirements
 - configurable:
    - provide URL and html parameters.
 - excellent logging: slf4j.log
    timestamps 
    - 

10/18/2023 12:32:16 PM
Conference call discussing HRDS web server tool.
BAES:
	- As I've tested the API thorugh a separate tool, I've been able to confirm into two findings.	
	
	
	1 - The first of course is that our 1 hour 15 minute read timeout for the payload to come down is no longer sufficient; we've crossed some threshold with some component of the download process where we simply can't rely on the blind wait any more. 
		 - 
	2 - The second finding is that we do have the ability to read a chunk at a time, even down to a single byte per read which would give us some fantastic feed back, and solid monitiring of the webserver. The caveot here, is that we can avoid locking on the larger payload, and only get some at a time.
		 - I do see a stream option that 
	
	- 'm not suggesting we do this in the driver right now; but just to update our tool - we're still using the same API as the driver; but we need to deeply increase the feedback and speed of the download.  I suspect w'el eventually do something simliar in the driver once we find out how sensitivy to the read we need to be.
	
	Neail - stream ption
	
	- Stream - 
		 - Timeout - adnaan - when data from other prespective takes longer than 30 mins, the timeout already occured at 30 . .
		 - less than 30 . .
		 - a bit more evidence that this is
		 - since sunday night production feed has been jsut fine.
		 - Time taking for the driver: each day up to aand including: no more than 24-26 minutes
			 - last week - consistent failure
			 - taking 34-40 mins to download the feed.
			 - they're working on their side to improve performance 
			 - 
		 1 - learning the timeout - they're seing successful donload - 
			dispinte successful downoad - beyond 30 mins, their successful - 1.25
			- nothing to sugugest from our perspective . .
			- 30 minute . .
			- 
		 2 - read a part of the ilfe
			- preprod -  replicate puload . .
		 - Martin adnaan:
			 - still pulling full flat file . .
			 - My mind: eeps oging to make more streamlined - less processing
			 - HRDS - long discussion with orgina lartichect (persnabechat
			 - interface - pul deltas only . . 
			 - option to pull a full file on the first of the month: 20 days after that just pull deltas . .
			 - delta would work: moment pull full file - delta after that . .
			 - Entire user . .
		 - Happy to do the testing . .
		 - &GCI= 
		 
		 - chucnk the data - pul entire data . .
		 - stream option . .
		 - later: delter opation . .
		 
		 1 - Chucnking down the data.
		  - stream option
		  - delta option
		  - %75 - failure . .
		  - 20 days - had issues . .
		  - only last 4 days . .
		  1 off - just happened to work . .
		  - over 30 minutes: ever succeed? no . .
		  - last time we saw succeed?	 - juast befor eAS enhacnements ent live . .
		  - data change swith HRDS . .6 months of leavers added . .
		  - They did roll this back . .
			- some reason: still have the same issue; not t odo with data . .
			- indexes . .3 quarters on annual leva e. .
			- Neail on thuresday of last week - indexer . . may take a few day s. .
		 2 - Martin:
			 - mast: data has taken longer than the time out: went to 1.5 hour and a half . .
				 - only thing to say here: neil domain owner: wasn't happy with performance
				 - timelines: after 4.5 . . 
				 - 
		 
		 
			 
			 
			 
	
	
	
	
	
	
	
	and see the test data take about 7.5 minutes to come down, I've found we nedd to take advantage of some flexibility the API has. Until recently, t just having a straightfwoard read timeout has ben sufficient, but we seem to have crossed some threshold where something has changed.
		 - I've found some flexitilbity in the API to change how I read. Before it didn't appear to be necessary; but now I'd like to update the test tool to read differently, and pull back only a chunk of data at a time, all the way down to one byte if needed. 
		 I'm not saying this is how we'd do this in the driver; but we need to have some much better feedback on pulling down the payload.
		 - 
	
	

	 - So a few findings - the defautl settings on the  API I'm using, is to completely block until all data is received from a single HTTP GET call. For a majority of our time having this thing run, that's been sufficient, until there is any variation in behavior anywhere between the driver making the call, and the HR data server.
	 - This has been sufficient for most of the time, but seems no longer flexibile enough to deal with these variations that we've seen lately. having a super long read time out is no longer sufficient, as simply waiting doesn't seem to solve every situation we've run into.
	 - There are some options in the API that may let me read only a chunk of data at a time . .and possibly even produce a speed of data read during each read session. This would be one more metric that would be useful; but we'll get to this.
	 
	 So I'd like to do a few things at this point.
		Writing the tool has really helped get a better feel for the TESt webservice at least, while  it only takes about 7.5 minutes to respond, it's still a decent spot to get a feel for the behavior, assuming it's otherwise identical to production.
	 1 - Identify and document the set of health metrics for the webserver we want to watch. It seems like any time we have a failure, all we know right now is that it was a read timeout.  It would be beneficial to have more information, so a few ideas i had:
		 - Can I resolve the servename to an IP.
		 - Can I successfully ping the server.
		 - Can I Identify specific error cases where the code could do something more intelligent instead of just waiting; and possibly even end early and be ready to run again.
		 - Can I do a exploratory HTTP GET where I can just ask the server how much data there is to read before requesting it all.
		 - Can I monitor the throughput during the read operation.
	 2 - Look at reading the data in chunks: this would give us many of the above items, and flexilbity to help debug issues.  That when things go wrong; we have a better picture of what that was.
	 
	 
		 



[root@whtas50899v akynaston]# vi config.properties
HRDS-MAIN-URL=https://hrfsdataservice.ent.baesystems.com:3000/HRDataService.aspx?op=FN_EXPORT_AUTH_EXTRACT&FMT=XML&ACTION=DOWNLOAD&SCHEMA=IGNORE
HRDS-CONTROL-URL=http://10.180.162.33:8028
#5,000,000 is 83.33 minutes
HRDS-CONN-TIMEOUT=5000000
HRDS-READ-TIMEOUT=5000000
HRDS-READ-LINES=20
HRDS-driver.input.username=EC_Auth_Serv
HRDS-driver.input.password=Exp0rt_Ma5terPwd01====




HRDS-MAIN-URL=https://hrfsdataservice.ent.baesystems.com:3000/HRDataService.aspx?op=FN_EXPORT_AUTH_EXTRACT&FMT=XML&ACTION=DOWNLOAD&SCHEMA=IGNORE
HRDS-CONTROL-URL=http://10.180.162.33:8028
HRDS-CONN-TIMEOUT=500000
HRDS-READ-TIMEOUT=500000
HRDS-READ-LINES=20
HRDS-driver.input.username=EC_Auth_Serv
HRDS-driver.input.password=Exp0rt_Ma5terPwd01====





10/18/2023 12:34:15 PM
BAES summary from call today:

This is the results of our conference call today, and next steps:

Summary:
     - The blind read timeout for the 'hrfs' data retrieval system is insufficient for our needs now that we've had some change in behavior in the process.
     - The need to read at a more deliberate 'subset of data' mode is most likely requred. Explicitly seeing if we can pull down potentially even only 1 byte at a time would give us more control over the process.
     - There's an odd pattern: it seems any payload download attempt that completes in under 30 minutes is typically successful.  We don't believe we've seen it succeed in situations where the time taken was greater than 30 minutes.
     
BAES Action items:
     - Increase payload size in the TEST environment (https://hrfsdataservice.ent.baesystems.com:3000/HRDataService.aspx?op=FN_EXPORT_AUTH_EXTRACT&FMT=XML&ACTION=DOWNLOAD&SCHEMA=IGNORE) - Ideally, the end result would be that it would take somewhere consistently closer to 30 minutes to download to truely emulate what is happening in production: even if the users in the payload are duplicated repeately.

TriVir Action items:
      - Produce this list.
      - Document the plan (below)
      - Begin implementing a more sensitive read process by the HRDS testing tool, and confirm the behavior of the web server.

Plans & Items to consider
     - Note that each of these items may require subsequent interaction with BAES to make decisions; these are simply the top level plans.
     
1 - HRDS test tool: Update the code to implement smaller read portions: Request a much smaller amount of data at any one time to allow the code to respond and proceed more intelligently.
2 - Test reading the data in designated ranged portions, using the GCI wild card approach.


     
 
 
qwer


 
 10/30/2023 10:54:13 AM
BAES has had an IDM driver called the SuccessFactors driver, a publisher driver that has a subscriber job that retreives a large XML file input (200-300MB) file. This subscriber job downloads the file, and then places it into the driver's input directory for processing. Over the last month or so (October 2023) the download process has begun to have issues and will occasionally have a read timeout, despite being set at 1 hour and 15 minutes. While we have not nailed down the root cause we have nailed down a few items. Here's some points that we have confirmed:

 - The network between the IDM server and the HRDS server seems to be flaky at best.
 - Pedro, one of the main server contacts has confirmed that they don't build the file we request until we send our HTTP GET request.
 - Pedro has also confirmed that they won't be able to generate the file and store it to enable a simple direct file download.
 - NEW: Pedro just sent an email (10/30/2023 11:17:45 AM) where they mention they've submitted a fix to lower the normal 30 minute timeout to 2.5 minutes . .though we have yet to get reports on how well it functions.
 
Since they have potentially resolved the super long API time, this part of the project may be on hold; however, we may want to have something in place.
 
Our plan at this point is to write possibly two bash scripts: 1 that downloads the file into a temporary, and a second one that moves the file into the driver's input path. Both would be called on a cronjob.  The first one would be setup a few hours prior to the download time so that it can work on getting the file. It will attempt to download the file, possiby repeatedly if necessary. The second script would then run at the expected time to move the file from temporary to the driver's input path.



11/13/2023 12:03:52 PM
BAES JML
pub-mp matching:

Regarding AC 1.2.2.3 (now expanding to .1 and .2)

Current 'matching rule behaviors':
1 - Veto & trace 'received term user, discarding event' if baeLastWorkingDay < now
2 - GCI standard match
3 - DOB/GivenName/SN (supports rehires where GCI may not match)
	 - A match on this combination is a 'guaranteed match' by definition.
	NOTE: on a match: old association deleted, new one added is switched 
		out for the new one here!
4 - DOB and Surname - 
	 - if Only DOB and surname match (meaning Given Name didn't from the match above)
		we gather a bunch of data and log it:
		msg: The prior SF record matched the following IDV user on surname and birthdate only, then call
			es:writeSnDobMatchLog
5 - Email only match:
	 - This is an error scenario, givenName, and Surname didn't match!
	 - Send BAES-SF-Match Email Only Error


Proposed solution:
on #3 - 



PS3 - duplicate GCIs
	 - givenname/preferred may not be the same
		 - between sf and vrs
		 - When not, no match . .
		 - PS3 attempt with table in JML doc
		 