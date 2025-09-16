@echo off

date /T > timeItTook
time /T >> timeItTook
echo "Start . ." >> timeItTook

echo "ignore copy errpors, backing up this file . ."
xcopy *.bat C:\z\tools\bat /i/d/h/y
echo "**end ignore errors"

del C:\t\rsync-dbackup.log

echo .
echo ******************************************
echo Work: Zall
rsync -rLtivP --chmod=ugo=rwX --info=progress2 --exclude-from /cygdrive/d/exclude.txt --log-file /cygdrive/c/t/rsync-GBackup.log --no-whole-file --no-compress --inplace "/cygdrive/c/zall/" "/cygdrive/d/zall/"

echo Mirror various folders:
rsync -rltivP --chmod=ugo=rwX --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log --delete-after /cygdrive/c/zall/zwork/ /cygdrive/d/zall/zwork/
rsync -rltivP --chmod=ugo=rwX --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log --delete-after /cygdrive/c/zall/zvmware/ /cygdrive/d/zall/zvmware/
rsync -rltivP --chmod=ugo=rwX --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log --delete-after /cygdrive/c/zall/zdir/ /cygdrive/d/zall/zdir/
rsync -rltivP --chmod=ugo=rwX --info=progress2 --inplace --log-file /cygdrive/c/t/rsync-GBackup.log --delete-after /cygdrive/c/zall/zdirFullRepo2/ /cygdrive/d/zall/zdirFullRepo2/



:done
echo "Done. ." >> timeItTook
date /T >> timeItTook
time /T >> timeItTook

echo.
echo.
type timeItTook

