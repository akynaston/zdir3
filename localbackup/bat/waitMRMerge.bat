@echo off
cls

echo *****************************
echo Waiting on Pipeline for: %cd%
echo Version:
type version.txt
echo.
echo latest tag: 
git describe --tags --abbrev=0
echo.
echo.
echo *****************************
git s
git fetch origin --prune && git merge && git lg -5