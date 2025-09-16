@echo off
xcopy *.bat C:\work\adminrepo\tools /d/y

dir /b/ad > repolist.txt

echo Fetching from ext on repos
for /f "tokens=*" %%a in (repolist.txt) do echo %%a && git -C %%a fetch ext

del repolist.txt
