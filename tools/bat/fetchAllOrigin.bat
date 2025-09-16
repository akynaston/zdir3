@echo off
xcopy *.bat C:\work\adminrepo\tools /d/y

dir /b/ad > repolist.txt

echo Fetching From origin repos . .
for /f "tokens=*" %%a in (repolist.txt) do (
	if "%%a" == "adminrepo" then goto :skiprepo
	echo %%a
	git -C %%a fetch 
	git -C %%a fetch --tags -f 
	git -C %%a merge
	:skiprepo
)

del repolist.txt
