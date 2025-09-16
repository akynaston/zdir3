rem @echo off
xcopy *.bat C:\work\adminrepo\tools /d/y

dir /b/ad > repolist.txt

@echo off
echo Pushing to trivr . . .
for /f "tokens=*" %%a in (repolist.txt) do (
	echo ##########################
	echo %%a...
	call setExt.bat %%a %1
	move %%a 
)