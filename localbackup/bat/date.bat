for /F "tokens=2-4 delims=/ " %%i in ('date /t') do set yyyymmdd=%%k-%%i-%%j
echo %yyyymmdd%