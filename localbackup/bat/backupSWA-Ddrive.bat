@echo off
echo Backing up this drives' batch files to adminrepo\tools.
xcopy *.bat C:\work\adminrepo\tools /y/d 
xcopy C:\work D:\swa-work /s/e/i/d/h/y
xcopy C:\workspace D:\swa-workspace /s/e/i/d/h/y
xcopy C:\workArchive D:\swa-workArchive /s/e/i/d/h/y
xcopy C:\Users\x266698\Downloads D:\swa-downloads /s/e/i/d/h/y
xcopy C:\t\downloads D:\swa-downloads\t /s/e/i/d/h/y