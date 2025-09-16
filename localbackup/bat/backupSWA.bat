@echo off

date /T > timeItTook-SwaBackup
time /T >> timeItTook-SwaBackup
echo "Start . ." >> timeItTook-SwaBackup


xcopy backupSWA.bat C:\work\adminrepo\tools\bat /d/y

echo Backing up this drives' batch files to adminrepo\tools.
robocopy C:\Users\x266698\Downloads G:\swa-downloads
robocopy C:\t\downloads G:\swa-downloads\t /E
xcopy G:\*.bat C:\work\adminrepo\tools /y/d 
robocopy C:\work G:\swa-work /E
robocopy C:\workArchive G:\swa-workArchive /E
robocopy C:\workarchive C:\workArchiveBackedUP /e
robocopy C:\workArchive\workwork C:\workArchiveBackedUP\workwork /e
robocopy C:\workspace G:\swa-workspace /E

echo now doing mir backups:
robocopy C:\workspace G:\swa-workspace /mir
robocopy C:\work G:\swa-work /mir
robocopy C:\work\work G:\swa-workwork /mir



echo "Done. ." >> timeItTook-SwaBackup
date /T >> timeItTook-SwaBackup
time /T >> timeItTook-SwaBackup
