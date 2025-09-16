@echo off

REM Set the 'date' variable' so we know when the data was last pushed.
REM from: https://superuser.com/questions/47885/windows-command-line-create-a-file-with-the-current-date-in-its-name
for /F "tokens=2-4 delims=/ " %%i in ('date /t') do set yyyymmdd=%%k-%%i-%%j
rem echo %yyyymmdd%

set logFileName=%1\lastExternalPush.txt.bak
echo ***************************************** >> %logFileName%
echo. >> %logFileName%
echo %yyyymmdd% >> %logFileName%
time /t >> %logFileName%

git -C %1 remote add ext ssh://git@git.trivir.com:7999/swa/%1.git >> %logFileName% 2>&1
echo | set /p="...fetching remote . . ."
echo Fetching from %1 . .
git -C %1 fetch ext >> %logFileName% 2>&1
echo | set /p="...branches(remote)"
git -C %1 push ext refs/remotes/origin/*:refs/heads/* %2  >> %logFileName% 2>&1
echo | set /p="...branches(local)"
git -C %1 push ext --all %2  >> %logFileName% 2>&1
echo | set /p="...tags"
git -C %1 push ext --tags %2  >> %logFileName% 2>&1

rem echo | set /p="...cleanup"
rem echo Removing added remotes: >> %logFileName%
rem git -C %1 remote remove ext >> %logFileName% 2>&1
echo Done.
echo.
 