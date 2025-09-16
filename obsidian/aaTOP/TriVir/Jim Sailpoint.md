11/6/2024 1:06:41 PM
Jim - Governance project: different mindset . .
- lots of decision points need to happen up front.
 - IDM - A
 - 
 - C's write first.
	- what data collecting & how synchronzie . .
 - Jim worked with it 5-6 tools - implemented for arris - rebranded . .
 - on prem vs cloud . .
 - on prem was original - very flexibile, amost enough . 
 - cloud version - identity now - does not do the same thing - different arhitecture, limited feautre
 - next few months
 - Two different dimensions - 
	 - realtime engine of idm . .
	 - maybe some permissions.
	 - IGA is entirely different. 


data coming in going out . .don't have this with sailpoint.

 Sailpoint:
 * get data
 * "job or process" changes data
 * idm auth source . .
	 * base Identity (aka user record from one source)
	 * collector to get identity - could be from edir . .
		 * during this phase - which attrs to get
		 * once the data is consumed,
		 * now customization scripts.
		 * They use 'Bean shell' - crappy unsupported version of javascript
 * Data is then processed - goes through each scritps in particular order
 * end result - row in the database.
 * Logical represenation of a user - not quite a user record . .
 * slightly more than a phone book . .not quite full 'user'
 * then later, other collectors bring in:
	 * From apps:
		 * Account
		 * 

![[Pasted image 20241106131505.png]]Now, we'll start buildling permissions
each identity can reference an account . .

on prem version - oracle or postgress maybe . .
cloud version - don't get choice . .

all collectors use those cololection scripts at the top - data is transforemd to help the data to make the data properly
onset set of scripts for entire system . .

not realtime system - collect every few hours . .once a day . .
Account data - same kind of thing.
May not be appropriate to ever hours . . for some hours, for some once a week . .
data doesn't need to be fresh or recent.

Use cases
what can you do:
IGA standpoint - **Reviews**

Can collect data right before a review.
oposit:
Requests of new access
 - workflows arond process . .
 - As soon as you have reuqest system: need up to date data - in order to prevent - already has access kind of errors . .

* Frequent data collection - jim scared of this: if you have 20 apps - data collection: almost means all accounts, all permissions, and all apps - regardless of what you know already
* Collectors mostly can't do just changes. . .ouch . .

 **SOD** separation of Duties
 * can we check SOD rules?
 * mostly financial applicatoins to prevent fraud  - SarbanesOxley - released a bunch of numbers
 * 
Risk scoring
* assign numbers to users: how risky they are: how much rights they have.
* These are business  process changes . .won't have a lot of baility to do this for quite some time.

provising out to an app as well . .
simliar lmitations: get set of customization scripts that apply to lots of apps . . matching pooicy VERY difficult . .placement very diffusing

jim talked with sailpoint for fannymae - several hundred apps - they won't go to the cloud version - so much time customziing how all apps get imported - 


![[Pasted image 20241106132712.png]]


api calls to fix data later . .
jim never did provisioing - just collecting data . .

web server log - is on prem version accessible . .
When Jim doing it with Arris - how to shove same process from IDM . .jim trying to use idm mentality - idmunit connector for sailpoint - it was ok - slow - cuz bulkload . . 
These days, jim thinkgs about iga differently - different methdololgy . .

INitial deployment: meant to replace 

need to 

![[{48260FA6-423F-46C9-948B-E0293D40C48A}.png]]

11/8/2024 12:05:59 PM
Jim session 2
Jim - sailpoint
 - highlevel
 - good IG implementation looks like
 - last few years - replicate for IDM for IG . .
 - intro
 - policy: what's driving this? sarbens oxley
 - processes policy workshop
 - trail of paperwork that leads to responses
 - standards discussion . .
 - standards -> no one involved with governance program understands standards . .
	 - 3rd party auditor: wants to see documented process . .and policy to meet standard
	 - They need the document & follow through . .
	 - policy people and implementation of plicy poeople are different people
 - Needs to be super clear . .
 - Auditor can't see anything . .if not there . .
 - amount of data is huge . .
	 - need to collect, then review, then show artifcats about review occured . .
 - mantra - this is a buisness problem . . .
 - IDM: good at synchronizing data . .
 - IG is more of a business problem . .
	 - don't want to do reviews all the time . .
	 - Need some portions regular some sort 
 - IDM: write an AC first: still the same; but MUCH larger process
 - Part of the dleiverable is this conversation
	 - most idm processes: consumption of data . .assignments . .
 -  IG is collect process then report
	 - ONe week to write a collector . .
 - Governing board . .
	 - group of folks to become champions to address things.
	 - Could be who auditor talks to . .some times they'd go to the app
	 - good for definitin; but need to see things are followed through
	 - Needs:
		 - need to clearly define what we are giving to the business
		 - Need to clearly define what we're dong
		 - Say: helping to onboard.
		 - think about it as a 'service' being provied back to the app owners . .
		 - Those app owners pay the money for licenses - that keep the tool running - they're providng a service . .
		 - but we're preoving a service to tthem to help 
	 - stnadard reivew/collection
	 - Day 2 process
	 - How do you knwo if it was correct . .
	 - C&A - after onboarded their app . .have some collection in place
		 - pulled account and permision data into our model - then present back to them . .
		 - can you confirm this matches tow hat you are seeing? Too much data?
		 - Completeness and Accuracy (auditor term): confirming we properly refelct aboutitliy in app
	 Day 3
	 * Metrics . .
		 * Server working? simple ones . .
		 * Are processes working?
			 * for standard rreview: how many days did it take to do a review?
			 * how long for the review?
			 * what was the oputout? is this normal?
			 * regular churning of pruning . .
		 * last kind of metric: program level metrics
			 * CIO - see some thigns about how many people can do explicit permissions vs role assignments?
			 * how many apps conencted to the IG tool?
		 * SErvice mindset
		 * deep dive environment
		 * training component - huge!
			 * everyone in the business will need to know this.
			 * could be a pure job for training . . .
	 day 4
	 * priority of apps
		 * created a spreadsheet for weighted claculator to help determine which apps are top level.
		 * planning  .phasing . . tming . .
	 * Width vs depth
		 * Do we just do reviews? just role mining? requests? sod? risk scoring?
		 * if deploying all these features . .
		 * Wide enough to provide governance, but deep enough to have it mean something.
		 * some customers: only do the reviews . .
		* 
Starts with:
* Get tool installed
* LOgical idea of pulling in the data . . .
* Depending on features, that would define . . 
* Leadership thinks tool solves the problem: the clear buisness process . .
* 

this lets TriVir move deeper into business analyzis . . not just a driver processing . . .
	 - stnadards -> . . 
	 - auditor repellent . .
	 - periodic review: ideally: no issues!
		 - review service
		 - SEPARATE
		 - from request service . .
		 - review and request - NOT and reconciliation process . .
	 - IMportant not tto do this process - review - manded by standards: request process - 
		 - reconcilliation: way to aviod the mailnfnrequest process . .

Question: It hink TriVir was explicitly excluded from helping make these dcissions
	 
