@echo off
rem ********* VERSION 1.0
pushd ..

set TEMPLATEREPO=IDMDriverTemplateRepo
set STASHURL=https://stash1-tools.swacorp.com/scm/csiam/

echo ===============================================================
echo Cloning template repo as a sibling to your current repo . . .
echo You may see an error about the 'remote origin already exists' or 'already on master' these can be ignored.
echo.
echo.
if not exist .\%TEMPLATEREPO% mkdir .\%TEMPLATEREPO%
pushd %TEMPLATEREPO%
rem Setup the repo, and add a connection to the source and fetch now (-f); but get only master.
git init && git remote add origin -t master %STASHURL%%TEMPLATEREPO%.git
rem Simplify the remote to only have the latest commit, and only the master branch, then check it out.
git fetch --depth=1 origin master && git co master 
popd
popd
echo done.