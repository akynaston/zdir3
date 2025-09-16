@echo off

set logFileName=%1\lastExternalPush.txt.bak
echo ***************************************** >> %logFileName%
echo. >> %logFileName%
echo %yyyymmdd% >> %logFileName%
time /t >> %logFileName%

rem [url "https://akynaston@git.trivir.com/scm/swa/"]
echo Setting ext only . .  >> %logFileName% 2>&1
git -C %1 remote add ext trivir:%1.git >> %logFileName% 2>&1
echo Done.
echo.
