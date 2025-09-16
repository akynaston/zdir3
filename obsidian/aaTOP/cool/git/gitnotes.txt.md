7/21/2023 2:00:20 PM
Cool - assume unchanged, to avoid adding other files!




7/7/2023 4:38:10 PM

# These are shortcuts for commonly used remotes.  If you don't use 'git remote add', then you don't need these.

[url "https://stash1-tools.swacorp.com/scm/csiam/"]
	insteadOf = swa:
[url "https://stash1-tools.swacorp.com/scm/~x266698/"]
	insteadOf = me:
[url "https://akynaston@git.trivir.com/scm/swa/"]
	insteadOf = trivir:
[url "git@gitlab-ssh.apex-tools.prod0.prod.aws.swacorp.com:csiam/idm/"]
	insteadOf = gitlab:
[url "git@gitlab-ssh.apex-tools.prod0.prod.aws.swacorp.com:x266698/"]
	insteadOf = gitlabavk:
[credential]
	helper = manager
[diff "xl"]
	command = git-xl-diff.exe
[credential "https://git.trivir.com"]
	provider = bitbucket
[safe]
	directory = C:/work/idmunit-utils
	directory = '%(prefix)///192.168.0.125/swa/IDtoQualtrics'
	directory = %(prefix)///192.168.0.125/swa/IDtoFusion
[credential "https://stash1-tools.swacorp.com"]
	provider = bitbucket
[credential "https://gitlab-tools.swacorp.com"]
	provider = generic




7/20/2023 10:18:55 AM
Work remaining on 3 step data migration:


git -c "core.sshCommand=ssh -i key" push -u origin HEAD
git -c "core.sshCommand=ssh -i key" clone git@gitlab-ssh.apex-tools.prod0.prod.aws.swacorp.com:x266698/orgmigrate.git
git -c "core.sshCommand=ssh -i ../key" fetch

8/1/2023 10:37:24 AM
Set executebit on files for git
git update-index --chmod=+x gradlew
git update-index --chmod=+x scripts/get_next_version.sh
git update-index --chmod=+x scripts/update_version.sh



8/15/2023 2:48:52 PM
General pattern for commits.


Until then, I figured this may be easier, since I have another call after this one. I like to do three phase of commits: 1: one or more to upgrade to the latest build. 2: one or more commits of my actual real & core changes. 3: Run the build:

I'd do this:

First, unstage everything by running this:
git reset

Then stage your build updates:
git add .gitignore
git add driver.sh
git commit -m "chore: CSEE-2662 Update build to the latest standards" (I'm guessing on this)


Then stage just your driver and test changes:
git add *xls
git add exports
git commit -m "(fix/feat/chore) CSEE-2662 [what you did]"

Then run the build again to confirm latest changes:
Go to bash then:
./driver.sh build

Confirm the build looks good:
git s
git diff

When ready:
git add README*
git add final
git commit -m "chore: CSEE-2662 Run Build."


9/5/2023 4:18:01 PM
Check it out: to avoid getting tags unless you say --tags, use this in the local config:
	tagOpt = --no-tags



Change many commit messages:

python C:\work\adminrepo\tools\git-filter-repo.py --replace-message replace.txt  --refs CSEE-2943..gold --force
Parsed 56 commits
New history written in 0.71 seconds...
HEAD is now at afd80ce fix: CSEE-2947 Resolve scim dependency to point to dev version.
Completely finished after 1.17 seconds.

replace.txt had:
CSEE-2943==>CSEE-2947

I just needed to change the branch prefix.


Support long paths:
[core]
	longpaths = true




To create a
I just ran git fetch origin refs/pull-requests/44/from:feature/dirxml-ldap-conn


get prs as branches:
[core]
	repositoryformatversion = 0
	filemode = false
	bare = false
	logallrefupdates = true
	symlinks = false
	ignorecase = true
[remote "origin"]
	url = ssh://git@git.trivir.com:7999/idmunit/idmunit-connectors.git
	fetch = +refs/heads/*:refs/remotes/origin/*
	fetch = +refs/pull-requests/*/from:refs/remotes/origin/pr/*
[branch "master"]
	remote = origin
	merge = refs/heads/master
