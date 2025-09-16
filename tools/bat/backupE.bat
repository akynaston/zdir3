@echo off
rem @echo off
rem goto check_Permissions
rem 
rem :check_Permissions
rem     echo Administrative permissions required. Detecting permissions...
rem 
rem     net session >nul 2>&1
rem     if NOT %errorLevel% == 0 (
rem         echo Failure: Current permissions inadequate; please run cmd as admin and re-run.
rem 	pause
rem 	exit
rem 
rem     )
rem 	echo Administrative permissions enabled, continuing . .


rem echo Exclude file 
rem type exclude.txt
rem echo done show exclude.txt
rem echo.
echo.

date /T > timeItTook
time /T >> timeItTook
echo "Start . ." >> timeItTook

echo "ignore copy errpors, backing up this file . ."
xcopy *.bat C:\z\bat /i/d/h/y
echo "**end ignore errors"

del C:\t\rsync-gbackup.log

echo .
echo ******************************************
echo Work: Zall
rsync -rLtivP --chmod=a=rw,Da+x --info=progress2 --exclude-from /cygdrive/e/exclude.txt --log-file /cygdrive/c/t/rsync-GBackup.log --no-whole-file --no-compress --inplace "/cygdrive/c/zall/" "/cygdrive/e/zall/"

echo Mirror various folders:
rsync -rltivP --chmod=a=rw,Da+x --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log  --delete-after /cygdrive/c/zall/zwork/ /cygdrive/e/zall/zwork/
rsync -rltivP --chmod=a=rw,Da+x --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log --delete-after /cygdrive/c/zall/zallGitRepos/ /cygdrive/e/zall/zallGitRepos/
rsync -rltivP --chmod=a=rw,Da+x --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log --delete-after /cygdrive/c/zall/zvmware/ /cygdrive/e/zall/zvmware/

:done
echo "Done. ." >> timeItTook
date /T >> timeItTook
time /T >> timeItTook

echo.
echo.
type timeItTook

