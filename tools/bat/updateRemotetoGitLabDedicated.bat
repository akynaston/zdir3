@echo off
for %%I in (.) do set CurrDirName=%%~nxI
echo Setting remote value to: git@southwest.gitlab-dedicated.com:csiam/idm/%CurrDirName%
git remote set-url origin git@southwest.gitlab-dedicated.com:csiam/idm/%CurrDirName%
echo Doing a test fetch to ensure the new repo name is correct . .
git fetch -v