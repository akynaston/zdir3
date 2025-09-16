@echo off
xcopy *.bat C:\work\adminrepo\tools /d/y


@echo off
echo Cleaning and compressing repos
for /f "tokens=*" %%a in (repolist.txt) do echo %%a... && start "%%a" git -C %%a hardclean && timeout /t 2 /nobreak > NUL