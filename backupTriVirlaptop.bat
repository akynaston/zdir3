@echo off
mkdir -p C:\z\localbackup\git
mkdir -p C:\z\localbackup\ssh
xcopy C:\users\akynaston\.gitconfig C:\z\localbackup\git /y/d
xcopy C:/Users/akynaston/AppData/Local/Programs/Git/etc/gitconfig C:\z\localbackup\git /y/d
xcopy C:\users\akynaston\.ssh\* C:\z\localbackup\ssh /s/e/i/d/h/y
xcopy *.bat C:\z\localbackup\bat /y
del /s/q C:\z\localbackup\ssh\.git 