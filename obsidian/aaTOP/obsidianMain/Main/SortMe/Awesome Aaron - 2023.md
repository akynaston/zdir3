# Awesome Aaron - 2023

Awesome Aaron - 2023   

Few thoughts before we talk about how amazing I am:

Just to chat outloud a bit, I've really focused on being more deliberate this year. I realized that this is really what was meant by slowing down. it doesn't necessarily mean less anxietity or frustration during a normal work day; but it does mean that I can do what I set out to do, and will eventually feel better as a result. A funnhy sideffect of being essentially staff augmentation on Southwest means I live most of my day in this mental customer mode . .while I would have benefited from doing this all the time before anyway; this has been a funny benefit for me

I say that because I'd like to start by being deliberate and saying that I still love what I do. I like taking the explicit step of saying I choose to be here at these kinds of meetings, as it feels relevant to me.
I love working for TriVir, and doing what I do here; that seems to be a solid place to start with this. TriVir is where I want to be, and I love that.
I'm going to mention a pain point about travel in just a minute; but even with that pain point, I believe I'm still in a good place.

* I'm regularly challenged with things that require me to jump in with both feet and dig into things; and this is very satisfying.
* I do a lot of work that I'm super comfortable with, and can use Git every day, it has been great.

With that said -
I want to mention a comment a pain point about Travel, then one cool item about Patrick:

* While I'm much more comfortable traveling now than I have been in the past, I've found the regular travling to SWA has been wearing me out. I don't mind it so much but seems to take more out of me than I expected. The whole trip, including the airports, time traveling, and even the work on site is all pretty low key but seems to still wear on me.
* January 15th is the next one, and I find myself dreading it, despite the fact that is' just not a big deal. I can't even quite put it into words about why this eats at me so much. It definately is hard on my family; but travel is hard on all of our famiies, and it's part of the job so it's still just this vague emotional state in my head.
* My desire to take a sudden week off increases significantly.
* I am totally converted to the value of being in person and onsite; though I would like a strategic break or two.
	* Next year, I thinhk we do only have 3 onsite trips so that may be the solution.
	* The fact that we travel again so soon after the new year is weighing more heavily on me than I think is healthy; can't quite measure what that cost is, only that it results in me and my famjily being less happy.
		* My 17 year old Holly has no issue with me leaving at all; but everyone else is either unahppy or crying when I leave.  This is of course just normal life to some degree; but I'd like to find a better balance here.
* I think the soluiotn to this is to be super deliberate again, and
	* take all three trip schedules to my family, and see if I need to avoid a trip, at an acceptable cost to SWA and TriVir, and my self.
	* Thankfully, I've quickly come to love my new team; there are porbably too many people in the team for a lot of what we do; but I already ahve a solid relationship of trust with nearly everyone there, and everyone that I workw ith regularly. This isvauable to TriVir and Me.
		

Patrick - I've had a chance to work with him a lot lately and have found the experience to be fantastic. He's got a solid persistent mind, and it's been great. I really miss working with Colton as that was also awesome; but Patrick has been great as well.
		Of course I've known Patrick for years, but have come to respect him more and more as time goes on: I feel ike we could make a great team on any project dealing with any technology.

As far as yearly goals goes go:
ForgeRock training is completed, and I'm certified. .though I suspect that only includes the onprem stuff; I think I could pick up the cloud stuff with the rest of you pretty quick. I would go as far as saying that I'm easily staffable, and I think that's a big deal.

Second goal, the team goal was to help bring peoeple up tos peed on IDM.  Justin and I had some good chats, but we missed our last monthly checkin with me being onsite, so we need to schedule that.

* Trivir training - We had our internal trivir training for several we3eks; and that was great to cover basic concepts; but I ran into two issues:
	* 1 - I didn't get a good sense of a level of enthusasim or even much general interest: after a while, it seemed that people simply either didnt' show up, or weren't super engaged.
	* The second, is what I've mentioend before:  we've gone through all kinds of training where we walk through somting super clearly; such as a git rebase, or IDM matching rule fix, but until people actually experience the pain on a box 1 project, things won't stick much.
	* Quick segway:
		* Learning IDM is a pain in the but, and takes a lot of experience doing things wrong; but I eventually got to a point where I"m comfortable; but only after actually doing box 1 projects.

QàsEa32WA
Dev planning groups of oeople

* Learning Git on the otherhand, came very quickly, and without much struggle; the only difference of course is that I am super fascinated by what it provides, and love learning about how it works . . teaching interest, or giving that enthusiasm to some one else seems nearly impossible.
* So solving those two issues has been on my mind a lot lately:
	* On both problems, I think the only way we can solve this is by find a super clean way to break pieces of work off and give them to other people, and beable to integrate that back into southwest, or whatever cline we're working on.

So on to current projects:

SWA - of course has been fantastic, I have git coming out of my ears, that plus IDM development and the fact they need many trained widget turners really fits me well. I can confidently say that I could be with them for many more years; or just as easily move to any forgerock stuff we have going.

* On southwest we've done a lot of good. I don't think you've heard about all of it, so I wanted to mention a few key points
	* I added JsonPath support to the swa-rest-connector. This has benabled Joe and Patrick to use Json path statemets simliar to XPATH to pull data anywhere out of a JSON doicument. It looks a little ugly in the columsn of a spreadsheet, but works well.
		* I suspect we can now properly pull this connector into our library, as it appears to have been based on our curclient to begin with.
	* I've created the swa-scim-connector, and can also of course pull this into TriVir's system too.
		* We have official time set aside to upgrade the scim connector to the JSONPath api I larned iwth the rest connector.
		* Just so it's mentioned, it was Patrick that brought the JsonPath API as an idea, that panned out very nicely.
		* Another engineer wanted macro support - as clunky as it is, it works to solve a problem and he was able to do it quickly with our two dozen Junit tests that use a mock server.
	* I've worked well with Kyle: This is a big deal because he is fantastic at writing code, and mastering box 2 activites, but he doesn't document super well, and has not helped train other people as much they expect to be.
		* What I have brought to the table Is the ability to quickly come up to speed on Gradle, gitlab pipelines.
		* I've also been able to fix a bunch of broken pieces in the standard and continurally improve the work with Baron and Kyle, despite not being on the core team any more.
		* Just so you know, the biggtest pain point, is that my EE team is not supposed to spend a lot of time documenting the standards, that's a core team responsability, which is silly on top of stubborn; though I understand the time management problem. I'm updating the document as I go anyway; it's slow but I believe I'm bringing a great deal of value to my team and all of IDM developers.
		* I continue to support people as needed on complicated Git issues; which is more and more of a hobby now that I think about it.
	* I've brought maybe 6 people upto speed on the new build process after working to understand it myself.
		* as a short segway, it's funny, I think the exlicit value I bring to the table, is an deep curiosity about the technological world.
		* Iv'e talked with multiple people about the gradle build and have realized that when people normaly would sit and be irrirtated, My gut reaction is to go understand it - I guess habit 5A truely is valuable. I"m plenty irritated when my expectations don't match reality; but my curiosity overrides the irritation.
			* Taking appropriate amounts of time to sit and learn something, and digging just a little deeper Im getting better and better at.
			* This one fact that I daily, will push to learn new things, new ways of thinking is my greatest value to TriVir.
			* Loving what I do, even documentation some days is likely the second.
	* Struggle with coming up with ways to have training that actually causes positive behavior change when it comes to Git, or other daily processes; I can start to see where people are missing knowledge, and the work to focus on the things they need.
	* Funny side benefit of SWA, has been this increase in confidence, and a decrease in general anxiety when working with clients. I don't know why I haven't had this happen before, except maybe that most everyone I talk with is a client, and has forced me to be in that mindset and world constantly; it's been an unexpected benefit. when I cant minimize anxiety, it at least serves as a flag that I can typically change my beavhior - such as going for a walk.

	

BAES - Helped to estimate complicated driver work and code.

* I have thankfully been involved from the beginning on this system and have a good understanding on how it  is supposed to work and why.
* I've been useful in being able to provide useful feedback.
* Biggest painpoint with BAES has been simliar to what we have at other clients we've had for a long time, like FCPS, and others where the entire IdMUnit test suite takes multiple hours to run; I sense a strong need to make the tests less black box in nature; but other then some basic SSH checkking of logs, or something similary.
