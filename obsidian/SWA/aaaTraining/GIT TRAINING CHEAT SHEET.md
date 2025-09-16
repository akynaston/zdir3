DOCUMENT MOVED HERE:
https://docs.google.com/document/d/1yxupHWwLOwWxR2Zs4CemVvoycwizLXzIe-pSwYyFDuU/edit?tab=t.0


8/21/2025 4:52:12 PM - backup:

**

GIT L&L TRAINING CHEAT SHEET

There are dozens of cheat sheets online for Git, I wanted to put one together while we’re doing the git training so we can keep track of what we’ve talked about.  We’ll put this in a better spot, like Clickup or (some git repo ;-) ) at some point.

  

Please look at our Git standards and external git config links:

  

Goal at the moment is to increase awareness of the documentation out there; we’ll go into more detail as needed; we’ll briefly review them now for awareness. Our documentation isn’t super clean at the moment, but it’s getting there. Please ask someone if you run into a question you can’t answer or need assistance.

  

1 - Git standards: [https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-30151](https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-30151)

2 - Externalizing Git config (also has example configs) - (this name is bad, and this version only shows some brief notes on how to use public key authentication, so we have some cleanup work to do.)

[https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-24071](https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-24071)

- TODO: this document only has the example configs, and how to setup your public key; 

3 - Externalizing Git config from a Linux VM: [https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-24711](https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-24711)

4 - Externalizing Git config from a Windows VM [https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-24071](https://app.clickup.com/45049292/v/dc/1aytec-23271/1aytec-24071)

  
  

WE’LL ADD THE ITEMS WE COVER HERE AS WE WORK - see below for a preview . . .

  

LIST OF ALIASES

  

git s: command used all the time to get a quick picture of whats happening in a repo, compared to the HEAD pointer, and show what has been staged/indexed/cached.

Command: git config --global alias.s "!git status -s --branch && git stash list"

  

git lg: command to list commits in a much cleaner single-line format.

Command: git config --global alias.lg "log --decorate --oneline --graph"

More information: There is a more fancy version with better timestamps and colors located in the ‘winmerge’ example file in the #2 link above.

git ba: Command to get a list of all branches, local and remote tracking references, and how they relate to each other.

Command: git config --global alias.lg "branch -avv"

  

COMMANDS WE’VE USED SO FAR

  

git status: shows the current state of the repo - I recommend creating an alias to show you the data the way you want to see it; but keep in mind, this call with no parameters is super helpful in showing what is happening in the repo in a ‘long-format’ style.

  

git log: Used to list all commits in a repo - has MANY parameters to list the commits exactly in the way you want.

  

git branch: Used to list all branches, create branches, move/rename branches etc.

  

git init: create a repo in the current directory. Provide a name if you want to create a repo in the directory you are in, instead of using that directory for the repo - e.g.: ‘git init testrepo’ will create a repo called ‘testrepo’ in your current directory, where ‘git init’ would just create the .git folder right in your current directory!

  

git config--list --show-origin:  shows all settings in all scopes from your git configs, and shows them in the order that they are applied - first, System, Global and Local.

  

git config (scope)  -e: This command lets you edit settings.  (scope) should be either --system, --global, or --local.  If you don’t provide a scope, it defaults to --local.

  

git config --global core.whitespace trailing-space,blank-at-eof,space-before-tab,cr-at-eol: This command enables a more aggressive view of all possibly undesirable data that exists in your file.

  
  
  
  

MORE DETAIL ON ITEMS WE’VE COVERED:

  
  

Start by mentioning the ‘git config’ command: The command 'git config' is used to configure your git installation. It’s really good to know this really well, as there are a lot of settings, and you can really benefit by having the right settings in the correct location.

  

git config parameters:

  

Git has 3 levels of settings - System, Global, and Local

* System are settings that apply to all users on your system. 

  

* --system: Highest level of settings, applies to all users.

* --global: Current user settings; overrides system settings.

* (no specification or --local): Applies only to the current repo, overrides global and system settings.

* Add a  '-e' to edit that config file

* --list --show-origin: shows all settings in all files, in the order they are applied!

  
  

Here are the locations of my files:

System: file:C:/Users/akynaston/AppData/Local/Programs/Git/etc/gitconfig

Global: file:C:/Users/akynaston/.gitconfig

Local: file:.git/config (this one is simply the config inside of the repo I was in)

  
  

Example: To edit the global config items, run this:

git config --global -e 

  
  

To Configure A GUI Diffing Tool: Using Winmerge in this case:

  

* Please review the git configs on the ‘externalizing git config’ link above. My settings are based on the one that mentions winmerge. Use the above ‘git config --global -e’ command to easily copy and paste settings into your config.

  

Download the "Git config with winmerge" file.

- Save and open it in a notepad.

- Select all & copy all the data.

- Type: git config -e --global.

- Paste the entire settings file.

- Set your name & email at the top.

- check your Winmerge/p4merge/other diffing tool settings.

  

BEST 'What's in my repo' commands!!

  

git status -s --branch && git stash list

- Shows a streamlined version of status, current branch, and it's relationship to the remote tracking branch (if any).
    
- USEFUL FOR: getting a clear, very quick review of files changed in your sandbox as compared to the most recent commit (where the HEAD pointer is at). The stash item I added is to help you never lose a stash; we'll talk about that later.
    

- Meaning of the letters: These are the letters that appear next toa  file when using the ‘-s’ parameter on git status:
    

- ? - File is new, git has likely not seen it at all.
    
- A - File has been added
    
- M - file has been modified
    
- D - File has been deleted
    
- R - File has been renamed - note: a file will appear ‘D’eleted, and ‘A’dded unless both are added to the index, then ‘R’ will appear assuming the file contents are sufficiently similar.
    

- 8/21/2025 2:37:55 PM update: 
    

- From the ‘git diff’ documentation, there’s a more inclusive list of these codes. You can exclude files from the diff by excluding them with this:
    

- --diff-filter=[(A|C|D|M|R|T|U|X|B)...[*]]
    
- Select only files that are 
    

- Added (A),
    
- Copied (C), 
    
- Deleted (D), 
    
- Modified (M), 
    
- Renamed (R),
    
- Type change (T) -  have their type (i.e. regular file, symlink, submodule, …​) changed
    
- Unmerged (U),
    
- Unknown (X)
    
- Pairing Broken (B). Any combination of the filter characters (including none) can be used. When * (All-or-none) is added to the combination, all paths are selected if there is any file that matches other criteria in the comparison; if there is no file that matches other criteria, nothing is selected.
    

-   
    
- Also, these upper-case letters can be downcased to exclude. E.g. --diff-filter=ad excludes added and deleted paths.
    
-   
    
- Note that not all diffs can feature all types. For instance, copied and renamed entries cannot appear if detection for those types is disabled.
    
-   
    

  
  

git log --decorate --oneline --graph (Optionally add --all to see all branches).

- Shows the entire set of commits to the beginning of the repo.
    
- USEFUL FOR: reviewing the history of your commits.
    
- TIP: Add a --all to see the entire commit tree along with all tags and branches present.
    

- sidenote: if we get to talking about orphan branches, this output can be confusing, but it seems orphan branches are rare; we’ll see how far we get.
    
- --name-status: adds the same ‘short single letter’ status next to each file; very useful when looking at commits as a whole.
    
- Using ‘master..currentbranch’ allows you to log a set of commits; super useful when you want to only see commits you are focused on.
    

  

git branch -avv

* Shows all local branches, remote tracking branches, and the relationship between the two.

* USEFUL FOR: seeing all branches in one list and how they relate to their respective remote tracking branches.

  
  

ALIAS SHORT VERSIONS: Aliases for HIGHLY used commands:

- git config --global alias.s "!git status -s --branch && git stash list"
    
- git config --global alias.lg "log --decorate --oneline --graph"  (this is the simple-easy version: the lg alias in the ‘external git config’ file has better color, times are included, and are relative to now.)
    
- OPTIONAL:
    

- git config --global alias.ba "branch -avv"
    

  

More on "git log"

- Super helpful in seeing where branch and tag references are.
    
- Spend time in understanding the simple ASCII art relationship of branches - it can help to see how branches are related.
    
- Remember that commits are shown most recent first, and will sometimes prefer to show the HEAD pointer closer to the top; so don’t rush a review.
    
- Combined with ‘git branch -avv’, and ‘git tag’ and git show-ref, you can get a full picture of what references are in the repo. This is necessary for deciding when and how to do a rebase, or when it is appropriate to 
    

  
  
  

Interesting git lg variations:

  

- --name-status - shows the list of files changed on that commit, along with a single character status.
    

- E.g - git lg master..HEAD --name-status
    

- Assuming your branch is based on master, this shows all changes between master and your branch.
    
- Note: Normally, you’d do a log like this from your merge-point if that’s not master.
    

  
  
  

 * git mh

* Shows only the list of all my commits, along with the files that had an update, and what was done to them.

* At SouthwestAirlines - we always start our branches from master - so this may not work well for our team

* git lg master..HEAD --name-status

* Perhaps just do a git lg master..HEAD --name-status -5 

 * git diffr

* git diff --word-diff-regex=.

* Uses a regular expression '.' to do a byte for byte comparison, and show a more precise diff - it's a bit more cpu intensive; but is worth it when you need it.

* The --word-diff-regex setting is very interesting: you can use it to really help simplify diffs!

  

Useful tool:

 * git fsck - check for repo health, and detect issues.

* Use these flags to find unreachable or 'pruneable' stuff: 

* git fsck --lost-found --unreachable

  

* git bisect! Use git plus automated tests to have git help you find bugs!

* git blame! Use to see when a line changed in a file!

  
  

================================================================

  

FUTURE NOTES:

  

================================================================

* git help -a

* Show all commands (46 porcelain, 129 others!!)

* git init

* Create a new repo. Creates the repo in the current directory if you don't give it a directory name.

* git clone (url)

* Get a url from a remote. Url can be a file:/// reference!

* git update-git-for-windows

* Handy windows specific way to update git on windows - You'll want to treat updating git as you would any application

  
  

* Lots of git cheat sheets: seems like people create them as a hobby - documentation is everywhere for git, and the official docs are actually quite good despite the terrible colors on the webpage

* This one is reasonable: https://education.github.com/git-cheat-sheet-education.pdf

* One stored in a repo, a little more random: https://github.com/devaaravmishra/git-commands

* 

  

* git nit*

  
  

Git config: Used for all settings you'd like to have stick around, such as aliases:

* Note:  git config scopes:

* git config: overriding is a thing: if you have a setting on system; but need it to behave differently for you, you can use --global . .

* --system: for entire machine you are on

* --global: for the user you are logged in as

* --local: (default) - only for the repo you are on

* git config --list --show-origin

* Shows where all of your settings are coming from! Super handy when fixing settings.

* git config --list | grep alias

* Shows all aliases

* git config alias.lg --unset

* Unset an alias! 

* git config alias.lg "log --decorate --oneline --graph"

* Note: this is the simplified version!! See the trivir standards for the colorful one!

* Some aliases I use quite a bit:

* alias.s=!git status -s --branch && git stash list

* alias.si=!git status -s --branch --ignored && git stash list

* alias.ba=branch -avv

* alias.hardclean=!git reflog expire --expire=now --expire-unreachable=now --all && git gc --prune=now --aggressive

* alias.mh=lg master..HEAD --name-status

* alias.diffr=diff --word-diff-regex=.

  
  

TODO:

git --help -a: Raw list of all commands - we’ll decide which we want to cover:

list of 46 porclean commands, plus 129 other commands to do all kinds of other things (just learned git cherry!)

  

   add                     Add file contents to the index

   am                      Apply a series of patches from a mailbox

  archive                 Create an archive of files from a named tree

  backfill                Download missing objects in a partial clone

   bisect                  Use binary search to find the commit that introduced a bug

   branch                  List, create, or delete branches

  bundle                  Move objects and refs by archive

   checkout                Switch branches or restore working tree files

   cherry-pick             Apply the changes introduced by some existing commits

   citool                  Graphical alternative to git-commit

   clean                   Remove untracked files from the working tree

   clone                   Clone a repository into a new directory

   commit                  Record changes to the repository

   describe                Give an object a human readable name based on an available ref

   diff                    Show changes between commits, commit and working tree, etc

   fetch                   Download objects and refs from another repository

   format-patch            Prepare patches for e-mail submission

   gc                      Cleanup unnecessary files and optimize the local repository

   gitk                    The Git repository browser

   grep                    Print lines matching a pattern

   gui                     A portable graphical interface to Git

   init                    Create an empty Git repository or reinitialize an existing one

   log                     Show commit logs

   maintenance             Run tasks to optimize Git repository data

   merge                   Join two or more development histories together

   mv                      Move or rename a file, a directory, or a symlink

   notes                   Add or inspect object notes

   pull                    Fetch from and integrate with another repository or a local branch

   push                    Update remote refs along with associated objects

   range-diff              Compare two commit ranges (e.g. two versions of a branch)

   rebase                  Reapply commits on top of another base tip

   reset                   Reset current HEAD to the specified state

   restore                 Restore working tree files

   revert                  Revert some existing commits

   rm                      Remove files from the working tree and from the index

   scalar                  A tool for managing large Git repositories

   shortlog                Summarize 'git log' output

   show                    Show various types of objects

   sparse-checkout         Reduce your working tree to a subset of tracked files

   stash                   Stash the changes in a dirty working directory away

   status                  Show the working tree status

   submodule               Initialize, update or inspect submodules

   survey                  EXPERIMENTAL: Measure various repository dimensions of scale

   switch                  Switch branches

   tag                     Create, list, delete or verify a tag object signed with GPG

   worktree                Manage multiple working trees

  
  

Ancillary Commands / Manipulators

   config                  Get and set repository or global options

   filter-branch           Rewrite branches (don't use! use git-filter-repo python script!)

   reflog                  Manage reflog information

   remote                  Manage set of tracked repositories

  

Remaining commands:

   config                  Get and set repository or global options

   fast-export             Git data exporter

   fast-import             Backend for fast Git data importers

   filter-branch           Rewrite branches

   mergetool               Run merge conflict resolution tools to resolve merge conflicts

   pack-refs               Pack heads and tags for efficient repository access

   prune                   Prune all unreachable objects from the object database

   reflog                  Manage reflog information

   refs                    Low-level access to refs

   remote                  Manage set of tracked repositories

   repack                  Pack unpacked objects in a repository

   replace                 Create, list, delete refs to replace objects

   annotate                Annotate file lines with commit information

   blame                   Show what revision and author last modified each line of a file

   bugreport               Collect information for user to file a bug report

   count-objects           Count unpacked number of objects and their disk consumption

   diagnose                Generate a zip archive of diagnostic information

   difftool                Show changes using common diff tools

   fsck                    Verifies the connectivity and validity of the objects in the database

   gitweb                  Git web interface (web frontend to Git repositories)

   help                    Display help information about Git

   instaweb                Instantly browse your working repository in gitweb

   merge-tree              Perform merge without touching index or working tree

   rerere                  Reuse recorded resolution of conflicted merges

   show-branch             Show branches and their commits

   verify-commit           Check the GPG signature of commits

   verify-tag              Check the GPG signature of tags

   version                 Display version information about Git

   whatchanged             Show logs with differences each commit introduces

   archimport              Import a GNU Arch repository into Git

   cvsexportcommit         Export a single commit to a CVS checkout

   cvsimport               Salvage your data out of another SCM people love to hate

   cvsserver               A CVS server emulator for Git

   imap-send               Send a collection of patches from stdin to an IMAP folder

   p4                      Import from and submit to Perforce repositories

   quiltimport             Applies a quilt patchset onto the current branch

   request-pull            Generates a summary of pending changes

   send-email              Send a collection of patches as emails

   svn                     Bidirectional operation between a Subversion repository and Git

   apply                   Apply a patch to files and/or to the index

   checkout-index          Copy files from the index to the working tree

   commit-graph            Write and verify Git commit-graph files

   commit-tree             Create a new commit object

   hash-object             Compute object ID and optionally create an object from a file

   index-pack              Build pack index file for an existing packed archive

   merge-file              Run a three-way file merge

   merge-index             Run a merge for files needing merging

   mktag                   Creates a tag object with extra validation

   mktree                  Build a tree-object from ls-tree formatted text

   multi-pack-index        Write and verify multi-pack-indexes

   pack-objects            Create a packed archive of objects

   prune-packed            Remove extra objects that are already in pack files

   read-tree               Reads tree information into the index

   replay                  EXPERIMENTAL: Replay commits on a new base, works with bare repos too

   symbolic-ref            Read, modify and delete symbolic refs

   unpack-objects          Unpack objects from a packed archive

   update-index            Register file contents in the working tree to the index

   update-ref              Update the object name stored in a ref safely

   write-tree              Create a tree object from the current index

   cat-file                Provide contents or details of repository objects

   cherry                  Find commits yet to be applied to upstream

   diff-files              Compares files in the working tree and the index

   diff-index              Compare a tree to the working tree or index

   diff-tree               Compares the content and mode of blobs found via two tree objects

   for-each-ref            Output information on each ref

   for-each-repo           Run a Git command on a list of repositories

   get-tar-commit-id       Extract commit ID from an archive created using git-archive

   ls-files                Show information about files in the index and the working tree

   ls-remote               List references in a remote repository

   ls-tree                 List the contents of a tree object

   merge-base              Find as good common ancestors as possible for a merge

   name-rev                Find symbolic names for given revs

   pack-redundant          Find redundant pack files

   rev-list                Lists commit objects in reverse chronological order

   rev-parse               Pick out and massage parameters

   show-index              Show packed archive index

   show-ref                List references in a local repository

   unpack-file             Creates a temporary file with a blob's contents

   var                     Show a Git logical variable

   verify-pack             Validate packed Git archive files

   daemon                  A really simple server for Git repositories

   fetch-pack              Receive missing objects from another repository

   http-backend            Server side implementation of Git over HTTP

   send-pack               Push objects over Git protocol to another repository

   update-server-info      Update auxiliary info file to help dumb servers

   check-attr              Display gitattributes information

   check-ignore            Debug gitignore / exclude files

   check-mailmap           Show canonical names and email addresses of contacts

   check-ref-format        Ensures that a reference name is well formed

   column                  Display data in columns

   credential              Retrieve and store user credentials

   credential-cache        Helper to temporarily store passwords in memory

   credential-store        Helper to store credentials on disk

   fmt-merge-msg           Produce a merge commit message

   hook                    Run git hooks

   interpret-trailers      Add or parse structured information in commit messages

   mailinfo                Extracts patch and authorship from a single e-mail message

   mailsplit               Simple UNIX mbox splitter program

   merge-one-file          The standard helper program to use with git-merge-index

   patch-id                Compute unique ID for a patch

   sh-i18n                 Git's i18n setup code for shell scripts

   sh-setup                Common Git shell script setup code

   stripspace              Remove unnecessary whitespace

   attributes              Defining attributes per path

   cli                     Git command-line interface and conventions

   hooks                   Hooks used by Git

   ignore                  Specifies intentionally untracked files to ignore

   mailmap                 Map author/committer names and/or E-Mail addresses

   modules                 Defining submodule properties

   repository-layout       Git Repository Layout

   revisions               Specifying revisions and ranges for Git

   format-bundle           The bundle file format

   format-chunk            Chunk-based file formats

   format-commit-graph     Git commit-graph format

   format-index            Git index format

   format-pack             Git pack format

   format-signature        Git cryptographic signature formats

   protocol-capabilities   Protocol v0 and v1 capabilities

   protocol-common         Things common to various protocols

   protocol-http           Git HTTP-based protocols

   protocol-pack           How packs are transferred over-the-wire

   protocol-v2             Git Wire Protocol, Version 2

   askpass

   askyesno

   credential-helper-selector

   credential-manager

   flow

   lfs

   update-git-for-windows

  
  
**
