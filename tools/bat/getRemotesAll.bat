@echo off

del remoteslist.txt

dir /b/ad > repolist.txt

echo #### Listing remotes origin repos . .
for /f "tokens=*" %%a in (repolist.txt) do echo %%a && git -C %%a remote -v | findstr fetch >> remoteslist.txt

echo #### Listing remotes in disabled .. 
pushd C:\disabled
dir /b/ad > repolist.txt
for /f "tokens=*" %%a in (repolist.txt) do echo %%a && git -C %%a remote -v | findstr fetch >> ..\work\remoteslist.txt
del repolist.txt
popd

git -C C:\workspace remote -v | findstr fetch >> ..\work\remoteslist.txt

rem and sort . .
type remoteslist.txt | sort > remoteslistfinal.txt
xcopy /d/y remoteslist.txt adminrepo\tools
xcopy /d/y remoteslistfinal.txt adminrepo\tools

del remoteslist.txt
del remoteslistfinal.txt
