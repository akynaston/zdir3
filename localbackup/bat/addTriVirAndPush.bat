@echo off
for %%a in ("%~dp0\.") do set "parent=%%~nxa"
echo Adding Remote for directory: [%parent%] . .
git remote add trivir trivir:%parent%
rem: don't need to fetch; pushing seems to bring branches in.
rem echo Fetching . .
rem git fetch trivir -v
echo Pushing . . .
git push trivir refs/remotes/origin/*:refs/heads/*
echo Pushing tags . .
git push trivir --tags
echo done.