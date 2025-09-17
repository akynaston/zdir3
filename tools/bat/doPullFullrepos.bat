@echo off
xcopy *.bat C:\z\tools\bat /d/y
rem echo zdirFULLREPO3
rem git -C zdirFULLREPO3 fetch
echo zdirFullREpo3
echo fetching . .
git -C zdirFULLREPO3 fetch
echo fastforward main. .
git -C zdirFULLREPO3 fetch origin main:main
echo resetting main 
git -C zdirFULLREPO3 branch -f main origin/main
echo.
echo.
git -C zdirfullREPO3 lg --all -5
pause