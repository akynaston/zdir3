@echo off
xcopy *.bat C:\z\tools\bat /d/y/I

dir /b/ad > repolist.txt

echo Fetching From origin repos . .
for /f "tokens=*" %%a in (repolist.txt) do echo %%a && git -C %%a fetch && git -C %%a fetch --tags -f && git -C %%a merge

del repolist.txt
