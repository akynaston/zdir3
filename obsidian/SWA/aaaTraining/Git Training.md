4 Major talking points - My goal is to get through the first two major points today, but we'll see how we do.
1. ~~Basic repo porcelain diagnostic commands, and aliases for navigating and managing a repo.~~
	* ~~The kinds of responsibilities we have as engineers really benefit when we behave deliberately.~~
	* ~~Nearly every time I've had a chance to talk with one of you, or engineers at Southwest, we use the same three commands to diagnose just about any issue~~
2. ~~Basic navigation,  committing, branching, tagging.~~
	* ~~We'll talk about 'keeping a line in the sand' regarding commits.~~
	* ~~Managing the HEAD pointer with the lab . .~~
	* ~~Remotes & references~~
3. ~~Deliberate commits: DIFF DIFF DIFF!!!~~ 
	* ~~Major Habit 2 "Begin with the end in mind" scenario: someone is going to be looking at your changes. Generally the more deliberate you are, the better; we'll talk about what that looks like.~~
		* ~~Knowing what your changes are: even if you just made them; good to diff anyway: confirm you'll be committing what you expect.~~ 
	* ~~Pull requests/Merge requests: submitting a series of commits to someone else for review: Please review it yourself first: click on your own link, and see what they will see.~~ 
	* ~~'keeping a line in the sand' commits.~~
	* ~~Managing the commit tree with rebasing/cherry-picking~~
4. I'm working on some labs, mostly around rebasing, conflict resolution.
	* Interactive rebase
		* straightforward rebase, non-interactive - replaying of commits from one location to another, no real complication.
		* Rebase that shows combination of source and dest branches.
		* Rebase that shows a simple conflicts, and how to deal with it.
		* Rebase that shows multiple conflicts, and how to deal with it.
		* Interactive rebase using a fixup commit and autosquash
	* Any others?
		* If you think of something you'd like to see, please let me know, and we'll set something up.



GIT SESSION 5 - Rebasing with a conflict


I've reset our repo - please delete or archive your copy, then clone again. It's not strictly necessary to clone again, it's not hard to cleanup a local clone; but I want to get to rebasing:

git clone ssh://git@git.trivir.com:7999/~akynaston/gitlabs.git

Create small conflict
 

ISquashing commits.
Time for fixup commits and autosquash?
 - surprising finding: it appears fixup commits only use the commit message to determine which commit it's there to fix!! This is a good reason to have really good, consise commit messages, and to do autosquash interactive rebases only across the commits you want to consider.

I want to start by taking about cherry-picking and amending commits because it's an easy wya to start talking about how commits can be replayed, and we'll build on that concept.




cherry-picking allows you to reference any commit, and say I want to replay that commit where I am now as if I just did htat work again where I'm at.

Amending allows you to rebuild a commit - you use amending even during a rebase when you request to edit a commit.


This is some good documentation on seeing an example of conflict markers:
https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-using-the-command-line



Example conflict markers:
<<<<<<< HEAD
* Git installed
* SSH keys already configured with bitbucket
=======
* Install the aliases recommended there: we'll go through them and talk about knowing the underlying commands rather than relying on the alias.
* Setup your SSH keys with bitbucket
* Clone this: ssh://git@git.trivir.com:7999/~akynaston/gitlabs.git
* SSH keys already configred with bitbucket
>>>>>>> 78a9243 (Auto commit)


	* BE DELIBERATE!
	* BE DELIBERATE!
	* BE DELIBERATE!
		* **Diffing and normalization: If the next few items are all you remember from today, let it be this: Be deliberate in your commits.**
		* Huston story: "Aaron, there is a space you changed in this file, and I want you to fix it."
		* I want to be super clear: We are in an industry where exactness is a good thing, being super deliberate is more of a requirement than just a good idea.
		* What does this mean?
			* git diff like crazy!! If you are working on something that goes in a git repo, you should be diffing many times in one day.
			* Commits should be SUPER clean and single minded: git lets you do this!
			* "Oh, I didn't do that, it was just there!" - <-- don't say this :-)  If the system is introducing changes, then it needs to be normalized - Sounds like normalizing in Frodo is a relatively new thing, and that was great news to hear that's a thing now - I have almost no context, except how it affects git.
			* If you build a commit, you need to be responsible for the whole thing.
	* Show how to create a test repo & test remote repo: git init && git clone - foundation for what we'll be doing.
	* Quick comment: three places Git falls short that I know of:
		* hooks
		* submodules
		* git filter-branch command (use git-filter-repo!)
 - Components of Git:
	 - The setup:
		 - Some aliases I use all the time; wanted to show them to you now.
			 - git s				 
			 - git lg
			 - git ba
			 - git mh
	 - The Repo: 
		 -  Single independent storage area for a project.
		 -  There's lots of documentation on how much you should put in a single repo; but having it as single minded as possible seems to be wise.
	 - The commit object.
	 - The 'commit tree' <--- core concept for me: understanding this, and how branches & tags are just references to the commit-tree, finally clicked in my head how it worked; helped understanding relationship with a remote repo too.
	 - Branches
		 - git branch -avv - go to command to see everything related to branches in the repo, aliased as 'git ba'
	 - Tags
		 - Normally Just a static reference to a commit: at the implementation level, they're identical to branches, except that branches effectively 'move' to the new commit ID with HEAD whenever you make a commit - the new commit id whenever you commit is put into the branch reference.
			 - Two examples where this rule seems to apply less:
				 - I use a 'gold' tag, and a 'wip' tag.
		 - Kinda funny: git seems to kinda tiptoe around tags:
			 - It doesn't push tags with you do a normal push.
			 - It does get tags on a fetch if you simply don't have the ones the remote does.
			 - If you already have a tag locally that is at a different spot on the remote, it doesn't update your local tag witout you forcing it.
		 - 
		 - normal lightweight tags
		 - annotated tags
		 - reflog tags - just learned about on the 7th!
	 - Tags and branches: just files with a commit id! (difference: branches move with you, tags meant to stay put, with two exceptions: 'gold' and 'wip')
	 - Nothing is ever removed from a repo or its history that still has a reference to it.	 - 
 - Navigating a repo
	 - ---> Quick discussion on having a 'fake remote'  - some of the things we want to do, require a remote repo.
		 - To be clear, a remote repo is meant to be essentially a copy or 'clone' of your local repo: of course, only items that have been pushed/pulled with a commt id will be in sync.
		 - We'll talk about how they can be different.
	 - Note regarding fake remote, and bare repos: repos that don't have a sandbox
	 - Listing commits.
		 - git log, git lg, git reflog
		 - "--name-status"!!!
	 - The HEAD pointer: identifying and moving, and 'Detached' head.
	 - The 'sandbox' or 'working area'.
	 - The Index
		 - So what exactly does this file do?
			 - Stores the state - essentially is the area between your sandbox/workarea, and the commit pointed at by the HEAD pointer.
			 - Show how git s, git add -p, and git diff can be used to produce super clean commits.
			 - Deletion of index example.
 - Good habits to get into when using Git
	 - Use, but always understand what your aliases are doing: Aliases are a way to run commands in a more simple way.
	 - Discussion on Diffing.
		 - Be SUPER deliberate with Git: each commit should have a very specific purpose:
		 - DIFF DIFF, DIFF!!! If you aren't diffing ALL THE TIME when making updates to any type of code. 
	 - You must take on all responsibility for everything you are about to put into a commit.
		 - If you are committing something, make sure it is exactly what you watned.
 - Navigating a repo. 
	 - How to set the HEAD pointer. 
	 - How to reference & diff anything in the repo.  
 - Git Aliases  
	 - Super useful git aliases to use, after becoming comfortable with the actual commands.  
	 - Two that I will use regularly are:
	 - git lg
		 - See definition in clickup.
	 - git s
		 -  !git status -s --branch && git stash list
 - General git commands
	 - there are 46 main commands called 'porcelan' - meaning they are likely to be useed by an end user in a normal use scenario. There are another 130 or so commands that are lower level, and typically used either in scripting, or when doing something super low level.
	 - Note on Git submodules, and git hooks: both are a cool idea, but to me, seem to be missing some functionality. We may still use them in some cases; but aren't as simple to work with as I had hoped.
	 - Git config --list --show-origin
		 - Shows where a setting is coming from!

Other commands:
 - reflog
 - 
		* git diff CSEE-5250..origin/CSEE-5250
	* Log side: shows the commits in chronological order
		* git lg --first-parent!! and --no-merges
		* git merge-base branch1 branch2

Main Porcelain Commands
   diff                    Show changes between commits, commit and working tree, etc
   add                     Add file contents to the index
   checkout                Switch branches or restore working tree files
   commit                  Record changes to the repository
   fetch                   Download objects and refs from another repository
   log                     Show commit logs
   restore                 Restore working tree files
   rm                      Remove files from the working tree and from the index
   show                    Show various types of objects
   stash                   Stash the changes in a dirty working directory away
   status                  Show the working tree statusswitch                  Switch branches
   
   bisect                  Use binary search to find the commit that introduced a bug
   cherry-pick             Apply the changes introduced by some existing commits
   clean                   Remove untracked files from the working tree
   clone                   Clone a repository into a new directory
   describe                Give an object a human readable name based on an available ref
   gc                      Cleanup unnecessary files and optimize the local repository
   init                    Create an empty Git repository or reinitialize an existing one
   merge                   Join two or more development histories together
   mv                      Move or rename a file, a directory, or a symlink
   rebase                  Reapply commits on top of another base tip
   reset                   Reset current HEAD to the specified state
   revert                  Revert some existing commits
   tag                     Create, list, delete or verify a tag object signed with GPG
   worktree                Manage multiple working trees

   am                      Apply a series of patches from a mailbox
   archive                 Create an archive of files from a named tree
   backfill                Download missing objects in a partial clone
   branch                  List, create, or delete branches
   bundle                  Move objects and refs by archive
   citool                  Graphical alternative to git-commit
   format-patch            Prepare patches for e-mail submission
   gitk                    The Git repository browser
   grep                    Print lines matching a pattern
   gui                     A portable graphical interface to Git
   maintenance             Run tasks to optimize Git repository data
   notes                   Add or inspect object notes
   pull                    Fetch from and integrate with another repository or a local branch
   push                    Update remote refs along with associated objects
   range-diff              Compare two commit ranges (e.g. two versions of a branch)
      scalar                  A tool for managing large Git repositories
   shortlog                Summarize 'git log' output
   sparse-checkout         Reduce your working tree to a subset of tracked files
   submodule               Initialize, update or inspect submodules
   survey                  EXPERIMENTAL: Measure various repository dimensions of scale
   


 - Crazy things that are possible (this is the maybe don't do it . . but it's cool and handy to know what's out there section)
	 - Modify history
		 - git commit --amend
		 - git rebase -i
		 - For making large number of changes such as removing passwords from all of history from a repo, or changing a commit user id, use git-filter-repo - NOT the built in filter-branch command!
		 - . . instead: use 'git-filter-repo'
		 - Even the main git docs recommend using something like git-filter-repo - it's a python script!
		 - https://git-scm.com/docs/git-filter-branch: recommends 
			 - git-filter-repo.py: - https://github.com/newren/git-filter-repo/
		 - Lets you re-write commit messages, author, dates, replace strings with other strings (such as password removal)
		 - It works by building new commits, then, by default will leave references to the old commits so they're not mistakenly cleaned up UNLESS you delete them (see --replace-refs update-no-add) - this concept has MANY cool implications: meaning you can safely preserve tags, etc - or use the update-no-add to not add any extra references to the old stuff, and let you 'git hardclean'.
			 - 			 - Example call I used: 
			 - Command I used to delete an 'archive' directory from all of history. (The --invert-paths makes it so that I could have maintained only the archive directory)
				 - python C:\work\adminrepo\tools\git-filter-repo.py --invert-paths --replace-refs update-no-add -f --path archive
			- Example where I updated a bunch of commit messages to have the proper branch in the header between my branch pointer and the gold tag:
				- python C:\work\adminrepo\tools\git-filter-repo.py --replace-message replace.txt  --refs CSEE-2943..gold --force
				- where replace.txt:
				- replace.txt had this: this is how you represent a set of changes every file needs to avoid having; such as passwords or SSH keys, etc:
					- CSEE-2943==>CSEE-2947
	 - git rebase -i --root
		 - rebase your entire repo! Again, maybe not super useful, and will of course lose tags across commits that are changed.
 - Demo/Lab  
     - Show how to create and imitate a remote repo.  
     - Maintaining deliberate branches  
         - Diff, example and lab  
         - Merge, example and lab  
         - Rebase, example and lab; recovering from conflicts.




** - get the exercise plus automated validation . .see what the issue is . .
Outline slides . .


Huston,  
  
Here's what I have so far in my git training plans. There is a lot to decide on the demo; so we'll have that in a later session. Here's the overall thoughts I had.  I keep tripping over myself with all the cool things I want to cover; so have been trying to prioritize; here's what I came up with:

Probably not going to do a lab in the first; but I do want to cover the following items including showing how everyone can learn to work with a remote completely locally:

* After your low level portion of the discussion, I wanted to cover a few things
* Git Standards: link in clickup and thought process behind the required ones.
	* Config file 
* Section on the importance of diffing
* Diffing, logging and references
	* Navigation reflog, lg
	*  Show a few different diff examples; doesn't seem like humans diff a lot by default for some reason.		
		* diff -I
		* diff -R
		* diff --name-status
	* diff - ranges (2 or 3 . . .)
		* ..
	
STUDY THIS:		
		* ...
		* reflog - bail myself out . .
		* Can specify two commits . .
		* git diff CSEE-5250..origin/CSEE-5250
	* Log side: shows the commits in chronological order
		* git lg --first-parent!! and --no-merges
		* git merge-base branch1 branch2

* Rebase & merge
	* Easy rebase
	* collision rebase
	* "wrong thing" - Huston "lost" code . . 

STUDY THIS	
	* Can confuse git . . Auto merging . . 
		* More common case: merge conflicts really bad REPRODUCE THIS?
		* merge conflicts can be dumb . .    REPRODUCE THIS?
	* Josh old rebase issue??
	* Rebasing across merging
		* Merge commits always throw off rebasing . . 
		* MERGING MASTER INTO YOUR BRANCH:
			* Huston did rebase: person had feature branch kept merging master into their branch
				* They got to the end . . rebase on master, everything went haywire . .
			* Set up these scenarios . . 
		
* Section on setting up for learning git better:
	* Can setup a local remote, and push and pull as much as needed, and is a really helpful way to exercise git commands and see how things behave.
* Useful aliases
	* git s - 
		* git status -s --branch && git stash list
	* git lg
		* from standards . .
	* git branch ba
		* git branch -avv
	* hardclean
		* !git reflog expire --expire-unreachable=now --all && git gc --prune=now --aggressive
	* git shallow repo/single branch repos
	* bare repos . .
	* git worktree
	*  incremental commits

Demo & Lab






Git Standards

Prerequisites:
* Install Git. I will be using "git version 2.49.0.windows.1", but any version close to that should be fine (git --version)
* Be super familiar with our git standards link: https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-30151
* Install the aliases recommended there: we'll go through them and talk about knowing the underlying commands rather than relying on the alias only.
* SSH keys already configured with bitbucket
alias.
* Setup your SSH keys with bitbucket
* Clone this: ssh://git@git.trivir.com:7999/~akynaston/gitlabs.git
	* Move to and script . . 
	* Don't build stuff on laptop that goes out to customer . .however: local building for this test to have you see the process . .
* SSH keys already configured with bitbucket
* Know about these aliases:
	* See clickup - git config with winmerge config
	* git status alias (git s)
	* git lg - super handy one line version of git commits - it's realtively involved; but not diffiulc to understand, simple version:
		* short easy version to remember: "git log dog" - git config alias.j "log --decorate --oneline --graph"
	* 

* Get people to diff as a regular habit; ideally everyone would be responsible for every last byte they check into Git or any source code repository; it should a completely and automatically 
	* incremental commits
* Talk about merging and rebasing:
	* merging: explicitly saves the history of a branch on to yours; if that's what you want to do, then it's appropriate. Merging to master or completing a pull request to any branch is a good example of when a  merge.
	* rebase: i tend to rebase almost all of the time; because I like a linear history.
* Tips and tricks:
	* Creating a local remote to practice pushing; and help understand relationship between local and remote (remote doesn't have to be a bare repo; which is a repo without a working copy - you can take any repo and create a child, or a new local from that repo. The only time this is super useful is when you're learning how to push, and don't want to have to fix a remote over and over.
	* Super useful aliases - TriVir has a set of default aliases in the 
		* See 'Git Standards'.
	* Diff: Getting people to own every last byte in commits and pull requests.
		* diff -I
		* diff -R
		* Having super clear deliberate commits.
		* Smaller commits that can be squashed later
		* Can diff between any to commit-ish call them - really anything that can be resolved to a commit.
	* Navigating a repo.
		* reset, revert, restore
		* git reflog
		* git lg --name-status
		* git show, and with --name-status - show ANY object in the repo
	* Cleaning a repo:
		* git gc
		* Finding and removing orphaned commits: git fsck
		* git reflog
		* git hardclean - 
			* hardclean = !git reflog expire --expire=now --expire-unreachable=now --all && git gc --prune=now --aggressive
		*  git pull ff = only 
	* Only commands that do something with the remote, or management of the remote:
		* git remote
		* git clone
		* git fetch
		* git pull
		* git push
		* git ls-remote




Key items:
 - Diffing like mad. Get into the habit of knowing every last byte you commit to a source code repository.
	 - I have a few tips and tricks on this, in addition to mentioning the concept of 'normalization'.
 - The realization that they can create a fake local remote end point to do test push/pull/fetching, is a big deal; this was huge in helping me learn how to deal with a remote without breaking something.
 - Use of the gold and wip tags: only moveable tags
 - The --name-status flag . .
  
Goals:  
  1 - Get everyone using the same vocabulary, and have shared understanding of how Git works, and how we use it.  
  2 - Navigating and maintaining a collaborative-friendly repo.  
  3 - Tips and tricks.  

Major pain points:
 - Git training: really nail down goal: one step after a basic training - just hitting some painpoints - seems most issues come from people not knowing how to navigate. .
   - Don't know how to navigate.
   - Don't know what is possible to search for & resolve issues.
   - Don't know what the specific commands are to get the job done.

6 hour git training: really handy simple to more advanced commands. He's using a pretty old version of git, but I think what he does seems generally still supported:
https://trivir.udemy.com/course/git-going-fast/learn/lecture/1332348




Key items:
* The 'gold' tag!! 
* 'git mh' - Log from master to HEAD, show all files changed: super handy for rebasing recent commits; assuming master is your branch starting point. Use the correct starting point as needed.
* rebasing: fixing conflicts, recovering from bad rebase, vs cherry picking . .* 
* Diffing:
	* --word-diff-regex=. !!!	* 
* PATCHES!
	* git add -p  (add -i is cool too . . .)
	* git log -p
	* git restore -p
* Git reset, restore, revert:
	* reset: head pointer and sandbox management
	* revert: add a full commit showing the removal of a prevoius commit
	* restore: Reset a file back to what it was in the index, or most recent commit.
* Cancel a commit! remove all content in the file.
* Using the index effectively:
	* Diffing against the most recent commit, vs what is in the index! Can be super handy to do partial diffs, and stage only a piece at a time.
	* Commit only portions of files, and only a subset of files - see patch add above!
* Incremental/Amending commits:
	* Super handy way to list to eventually be able to submit  a commit with detailed information on what you did; lets you focus on one piece at a time.
	* Show amending of previous commit
		* Using rebase edit
		* Using fixup & auto-squashing 
Recent real rebase case:
Had a branch with a commit on it; really should get it merged; but it's friday, people have gone home, I started a new branch, made its commit, then realized I really should update the base build version as my first commit on top of master!  So i created a new branch called new on master, then I can run the update, commit, then rebase 4985 on master, then rebase 4986 on 4985.  My MR for 4985 will have a funny history about adding a bunch of commits, but is otherwise unharmed!
![[{4A888330-5510-49E8-99F9-63ED58AE7B00}.png]]

Went to the 'new' branch, ran the build, committed. Notice how HEAD is at the top now; but you can see it's head is the original master branch.  Now, I can fix 4985, then 4986.

![[{F04322EE-10EF-41B0-8145-037896887F75}.png]]
Conflict while updating:

![[{8F798BAB-2FA0-4532-8243-02647323AB30}.png]]

Only issue was that I had deleted the manifest file on the previous work on 4985; but deleted it on my 4986 branch.  This one is simple to resolve, since this file doesn't matter a whole lot on this commit, and I'm going to rebuild it anyway on the next build:

![[{A5F79732-D475-48C3-B608-F7536224476B}.png]]

I accepted the change, by just staging the file: see how the D is on the right hand side, meaning on my local branch I had deleted the file; and that's good enough.
![[{C16100B8-49CA-4F61-BB5E-9A831F33A0A5}.png]]

so a git lg shows just this; but the origin/CSEE-4986 and origin/CSEE-4986 .. where'd they go?

![[{82891D3F-9AEE-444B-8EB4-966C15CB04DE}.png]]

Git lg --all shows where they are: See how they are still where they were? You can see now that my HEAD pointer is pointing at CSEE-4986 and it's based on my local CSEE-4985, and it's in-turn based on the 'new' branch.  Now that this is done, I can delete the new branch with "git branch -d new" since I don't need it any more.


![[{6BA6683B-437D-426D-9B9B-621CE970880F}.png]]

git branch -avv shows this: Notice how 4985 is ahead 2, behind 1? Thats because it has the 'new' branch's first commit, and it's old commit. The behind one was that old commit that didn't have the new branches' commit as the parent (see above for a full picture).

Branch 4986 has followed the same pattern, but of course is one hire in the ahead and behind count, because it was on top of 4985 to begin with, and has 1 commit of it's own. 
![[Pasted image 20250606174842.png]]

A diff at this point from the old branches on the remote and my latest stuff pretty much shows the same thing for both branches; it just shows the files updated on the first commit on new. Also note: if you provide two references, it diffs from left to right.

![[{081BD0F9-FE69-4FB9-9C92-1372CAE87B54}.png]]

Then I did: git rebase continue, revisited the  commit message:
fix: CSEE-4986 Adding standard basic vanilla file place holders for IDtoApptio.

and all done! I Confirmed my CSEE-4985 branch MR is still ready to go, went back to 4986 and I'm on my way.

Once I merge 4985 to master, I know that my rebase of 4986 on to master afterwards won't have conflicts, because I know what files change on a merge and can avoid a conflict.

Note: in this case, I was fixing some historical commits on two branches so I had to force push. This is the time where a force push is desirable and the correct thing to do: I am the only developer on these branches, and I own both.  If someone else had committed to these branches while I was doing this work, they would need to go back, collect all of the work they had done, and create a new branch at the correct spot, then pushed it.

However, the new branch doesn't follow our pre-receive hooks, and stopped the whole thing. AFter deleting the branch, I was able to update everything:
![[{6E33878D-9C40-4A1E-AF13-09F25E21099B}.png]]

And now everything is clean, and references updated:
![[{910A9E85-3215-4280-A902-1D9858F4AE3A}.png]]



Next case: Not showing you that this is something you should do; but it was an interesting case: obsidian, is a simple note taking app, and I like to remove images from it every now and then just to save space; but still have them accessible in the history:

Holding a 'hidden' commit: while creating this, my junkdrawer repo, I realized I want a copy of all these files in my obsidian note taking app, but Maybe I want to remove them all in the long run, so I created a tag that points at the original commit, and one that points at a commit with them removed:

![[{452F54CB-CEF2-42E5-8C34-207C6149CED9}.png]]

Now, I want master to point at gitTrainingImages, because I still need to use them for now:

![[{66B0A9AF-3B25-4C32-801F-102004CCB32D}.png]]

And I can then proceed. I know I can rebase my master branch on the removed version later when I don't need them any more.

Outline:  
 - Intro  
     - Huston's portion on low-level Git.  
     - Lots of Git training's out there so we won't cover basics but we'll cover some specific pain points, and cover tips and tricks.  
 - Good habits to get into when using Git  
     - Discussion on Diffing  
     - Responsibility for ALL changes in a commit.  
 - Navigating a repo.  
     - How to set the HEAD pointer.  
     - How to reference & diff anything in the repo.  
 - Git Aliases  
     - Super useful git aliases to use, after becoming comfortable with the actual commands.  
 - Demo/Lab  
     - Show how to create and imitate a remote repo.  
     - Maintaining deliberate branches  
         - Diff, example and lab  
         - Merge, example and lab  
         - Rebase, example and lab; recovering from conflicts.
