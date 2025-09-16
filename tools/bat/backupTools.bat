@echo off
echo Getting .bat files backedup . .
C:
cd\work
xcopy *.bat C:\work\adminrepo\tools /d/y/q
echo Duplicating .bat files to disabled dir . . 
xcopy *.bat C:\work\disabled /d/y/q
echo Getting remaining tools . . .
xcopy * C:\work\adminrepo\tools /d/y/q

xcopy C:\users\x266698\.idmunit\env.properties C:\work\adminrepo\.idmunit /s/e/i/d/h/y


echo Backing up git config:
xcopy %home%\.gitconfig C:\work\adminrepo\tools /y/d
xcopy "C:\program files\Git\Etc\gitconfig" C:\work\adminrepo\tools\gitconfig(system) /y/d


rem echo backing up iml files . .
rem dir /s/b *iml > imllist.txt
rem for /f "tokens=*" %%a in (imllist.txt) do xcopy %%a adminrepo\intelliJ\imlFilesToUse /d/y/q > %temp%/trash.txt


xcopy /d/h/y C:\Users\x266698\.* C:\work\adminrepo\tools\laptopfiles
xcopy /s/e/i/d/h/y C:\Users\x266698\.ssh C:\work\adminrepo\tools\laptopfiles\.ssh
xcopy /s/e/i/d/h/y C:\Users\x266698\.m2\settings* C:\work\adminrepo\tools\laptopfiles\.m2
xcopy /s/e/i/d/h/y C:\Users\x266698\.aws C:\work\adminrepo\tools\laptopfiles\.aws
xcopy /s/e/i/d/h/y C:\Users\x266698\.awssaml C:\work\adminrepo\tools\laptopfiles\.awssaml
xcopy /s/e/i/d/h/y C:\Users\x266698\.idmunit C:\work\adminrepo\tools\laptopfiles\.idmunit
xcopy /s/e/i/d/h/y C:\Users\x266698\.ApacheDirectoryStudio\.metadata\.plugins C:\work\adminrepo\tools\laptopfiles\ApacheDirectoryStudio\.metadata\.plugins
xcopy /y/d C:\portapps\openvpn-portable\data\config\* C:\work\adminrepo\tools\laptopfiles\utvpn\config


rem bookmarks:
xcopy /d/y "C:\Users\x266698\AppData\Local\Google\Chrome\User Data\Profile 1\Bookmarks" "C:\work\adminrepo\tools\laptopfiles\Chrome\Users\x266698\AppData\Local\Google\Chrome\User Data\Profile 1\Bookmarks"
xcopy /d/y "C:\Users\x266698\AppData\Local\Google\Chrome\User Data\Profile 2\Bookmarks" "C:\work\adminrepo\tools\laptopfiles\Chrome\Users\x266698\AppData\Local\Google\Chrome\User Data\Profile 2\Bookmarks"

rem: backup downloads:
xcopy /s/ei/d/h/y C:\Users\x266698\Downloads C:\workarchive\downloads-swa
xcopy /s/ei/d/h/y C:\t\downloads C:\workarchive\downloads-swa

xcopy /d/y C:\work\adminrepo\.git\config C:\work\adminrepo\tools\laptopfiles\admin.gitconfig

xcopy /d "C:\Users\x266698\AppData\Roaming\obsidian\Custom Dictionary.txt" "C:\work\adminrepo\obsidian-config\Custom Dictionary.txt"

pushd adminrepo
call delfiles.bat
popd
cd adminrepo
git s