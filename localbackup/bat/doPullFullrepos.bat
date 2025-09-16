@echo off
xcopy *.bat C:\z\tools\bat /d/y
rem echo zdirFULLREPO
rem git -C zdirFULLREPO fetch
echo zdirFullREpo2
echo fetching . .
git -C zdirFULLREPO2 fetch
echo pushing . . 
git -C zdirFULLREPO2 push --all
echo.
echo.
git -C zdirfullREPO2 lg --all -5
pause