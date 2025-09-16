@echo off
xcopy *.bat C:\work\adminrepo\tools /d/y

dir /b/ad > repolist.txt

echo Checking Status . . 
for /f "tokens=*" %%a in (repolist.txt) do echo %%a && git -C %%a s

del repolist.txt
