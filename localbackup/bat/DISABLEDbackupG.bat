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
xcopy *.bat C:\z\tools\bat /i/d/h/y
echo "**end ignore errors"

del C:\t\rsync-gbackup.log

echo .
echo ******************************************
echo Work: Zall
rsync -rLtivP --chmod=ugo=rwX --info=progress2 --exclude-from /cygdrive/g/exclude.txt --log-file /cygdrive/c/t/rsync-GBackup.log --no-whole-file --no-compress --inplace "/cygdrive/c/zall/" "/cygdrive/g/zall/"

echo Mirror various folders:
rsync -rltivP --chmod=ugo=rwX --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log  --delete-after /cygdrive/c/zall/zwork/ /cygdrive/g/zall/zwork/
rsync -rltivP --chmod=ugo=rwX --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log --delete-after /cygdrive/c/zall/zvmware/ /cygdrive/g/zall/zvmware/

:done
echo "Done. ." >> timeItTook
date /T >> timeItTook
time /T >> timeItTook

echo.
echo.
type timeItTook

