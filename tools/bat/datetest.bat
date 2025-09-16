@REM from: https://superuser.com/questions/47885/windows-command-line-create-a-file-with-the-current-date-in-its-name
@echo off
for /F "tokens=2-4 delims=/ " %%i in ('date /t') do set yyyymmdd=%%k-%%j-%%i
echo %yyyymmdd%