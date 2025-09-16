11/1/2024 4:29:37 PM

Start with my dev plan goals:
1 - Learn about Jenkins pipelines, and add a useful pipeline. Looks like Will bowden had already added a maven build setup to the idmunit-core, so I'm digging in to that to see where it stands. Do you know of specific pieces that are left to do on this build? I didn't think we had one at all.
 - Also noticed, the config is not in a jenkins file - it's in the jenkns server I think . .I think I'd personally like to have the build file stored in each branch  . .
 
2 - Git exercises: the framework Josh handed me I think will work really nicely for all of Trivir - I've started down their path to create our own git extercises, so far it seems promising. 
	I have a lot to say here; but the bottom line is that I would take the much higher quiality readmes from your gitkats exampl;e but build it on the automated framework that Josh's polish gitexercises has: I like the determinsitic verification of end state to see that the end user has been able to express understanding.
	
	- I want to come up with some super clear rebasing scenarios that are then explicitly verified and reported on.
- ** learned two important things: the instructions need to be severely clear, and must match the verification exactly. about 5 of their 23 built in exercises the verification does not match the read me; ahd to go read the PHP code to see what they expected. - a readme described two commits, where the vierify looked for 3 commits.
- 
	

	 - Your git-katas repo is a little less automated, and is more of an interactive documentation; no official verification step that I completed the work requested in the readme. both have the setup.sh script to prepare a situation.
		 - git-katas creates brand new temporary repos inside of the excercise folder - could be good or bad
	 - Next action on this is to send you a demo training, and see if you agree. The default trainings have some bugs such as the verification not matching the readme about what people are told.
		 - I do really like the php verificatoin support - they've abused the remote messageing response on a git push to master to trigger a php verification step

	 - The raw framework is here:
	 - https://gitexercises.fracz.com/

* First I should say thanks you for mpushing me to get some Forgerock training: as you know it's tough to just up and leave one train of thought for Box 2 stuff; but it's always a great place to be. as we make box 2 bigger and bigger.
* Next item: I do want to bring up BAES; though with some rougness over the last few months, it's a bit of a two edged sword when trying to express my value to TriVir - They've had a few issues reported; but overall, I think I've been able to be a core component of keeping this going - Gary and Carl have done a larger share lately
* BAES - also helped to put together and estimate the next big project over there; and help with vroius items throug the last few months.
* Next item: I feel like I've been able to provide continued value at southwest airlines, but I have a sense that TriVir would rather I'd back out of southwest, and work to help push on other projects. 
	* Is that the case?
	* Lately I've found an infinite amount of work working behind all other idm engineeris in pipeline enabling their stuff and helping them learn what is the new standard. It has been good to be able to detect value and constantly be able to put effort towards things that have value; while at the same time being open to new drivers and other work as it comes in.
	* I've implenmented and successfully updated drivers that are very visible, like Aviobook to help flight teams go paperless.
	* I've helped to resolve Altea driver and system related issues - it's a ginormous system that support folks at airports use.
	* I definitely have the interest and the drive to move on to new things; but there is so much to do at SWA, especially as they move to the new platform.
		* BTW - Jim and I will meet sometime this week to do a quick rundown on sailpoint, and I'll pilng Core again to see what they have.
	* I have a few realtively major pushes at SWA that I think I should probably work to at least come to a certain state of completion before Iw ere to roll off
		* One of the major pushes is to get all the driver documentation to better solve the kinds of issues that a well written TriVir AC would do and we're getting close - has a new high elvel operatoins section that Ops has really valued, we've ttarted a myaccess section to help them tie the two systems to gether better.
		* another major push is to get credential rotation upa dn running; my old team is working on a sync between cyberark and aws; and this would be a huge coment to making the general rotatoin be able to be done by some one ops
		* another push is to help people be more focused in getting to the heart of the matter:
			* Increasing effectivness when testing authenticatoin: I had an egineer tell me that, no this driver is SOAP so we can't use postman - Just about make my breakfast with postman it's so feature rich.
				* I was bale to put together a shareable collection that everyone can use on Soap drivers now or at least provide an example that uses soap; that helped us validate passwords from dev/qa and prod; isntead of trying to validate througha  driver config - which can work; but is super frustrating since a failure could mean any number of things.
		* One comment about Git (mostly because I can't stop talking about it) - still people at SWA and TriVir that are looking to learn more about rebasing, so I have some good ideas about having a handful of rebasing examples in our git extercises library
			* Tempted to have one or share ours with the SWA folks, and see if they want more training.
		* Another new item we're pushing on is trying to get MyAccess configuration into Git. For some reason no one has seemed to want it - Steve Stone the main myaccess guy over there has asked about it; so I know he's thought about it.
			* Especially aswe move to the new model; having good clear normalized exports of what we do now would help us move to the new stuff in a more deliberate 1-to-1 model.
			* After hearing the painpoints from myAccess folks, and especially after seeing what Mike labi has gon through to get things done; even just using it as a diffable bucket would be a huge leap forward, not even considering pipelines or other automation.
	* Should mention I also helped to come up with the new role model - well' it's actually the super old RBE role model that NetIQ came out with; but Southwest really needed a system to extract role definition away from drivres - and I think it's a more natrual transition to the new platform assuming it has identity provisioning; or at leats some sort of role model.
	* Wrote the Docunet driver - I was able to learn and implmenet a lesser used path for UFM that we had to use and hepled to get that documetnation improved. UFM is nothing to be proud of; but I was able to get it to work. In 2003, it was pretty cool. 
	* Helped to create their main SWA SCIM IdMUnit connector working - I added the Mock server to it that allowed us to have a large set of very useful tests that have been key in fixing issues - we've had maybe a dozen new SCIM drivers over the last year, so it's been a high value activity.
	* 
* Next item I helped push forward on FCPS on some of the connector AC and work.
* Supported Census efforts in some cases - Matthew Murry has requested I respond to some eDirectory stuff occasionally and can help there - I'm glad he trusts me; but thats a funny one.
* One completely unexpected benefit I realize I bring to the table is I feel like I"m getting better and being able to jump to the heart of issues better, and help debug random things - I've been able to offer useful and immediately applicable adice to people looking to debug complicated things.
* I've been able to help keep the TriVir tree clean.
* Also working with Jeremiah to come up with some good clear git standards to minimize issues and time he has to spend with pull requests, and people submitting bad branches and commits.
	


 
gustons yurn
Ping thing
gaty

	 
