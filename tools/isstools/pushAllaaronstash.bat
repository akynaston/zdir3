@echo off
xcopy *.bat C:\work\adminrepo\tools /d/y

dir /b/ad > repolist.txt

@echo off
echo Pushing to trivr . . .
for /f "tokens=*" %%a in (repolist.txt) do (
	echo ##########################
	echo %%a...
	git -C %%a push aaronstash refs/remotes/origin/*:refs/heads/*
	git -C %%a push aaronstash --tags
)