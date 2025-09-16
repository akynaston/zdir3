rem @echo off


rem @echo off
xcopy *.bat C:\work\adminrepo\tools /d/y

dir /b/ad > repolist.txt

echo Fetching From origin repos . .
for /f "tokens=*" %%a in (repolist.txt) do (
	for /f "delims=" %%I in ('git remote -v ^| grep -c git@gitlab') do set "remotecount=%%I"
	rem echo hey, got it: it was "%newvar%" cool
	if "%remotecount%"=="2" (
		echo has a problem, fixing now
		cd %%a && call C:\z\tools\updateRemotetoGitLabDedicated.bat
	) else (
		echo was ok
	)
)

del repolist.txt
