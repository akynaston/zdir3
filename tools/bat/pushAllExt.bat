@echo off
xcopy *.bat C:\z\tools /d/y

dir /b/ad > repolist.txt

@echo off
echo Pushing to trivr . . .
for /f "tokens=*" %%a in (repolist.txt) do (
	echo ##########################
	echo %%a...
	git -C %%a fetch ext
	call pushExt.bat %%a %1 && move %%a aaaValidateEXT
)