@echo off
xcopy *.bat C:\z\tools\bat /d/y
rem echo zdirFULLREPO
rem git -C zdirFULLREPO fetch
echo zdirFullREpo2
echo fetching . .
git -C zdirFULLREPO2 fetch
echo fastforward master . .
git -C zdirFULLREPO2 fetch origin master:master
echo resetting master 
git -C zdirFULLREPO2 branch -f master origin/master
echo.
echo.
git -C zdirfullREPO2 lg --all -5
pause