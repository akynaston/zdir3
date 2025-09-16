@echo off
xcopy *.bat C:\work\adminrepo\tools /d/y
cd adminrepo
git add .
git ci -m "Tools update."
cd ..

dir /b/ad > repolist.txt

@echo off
for /f "tokens=*" %%a in (repolist.txt) do echo %%a... && git -C %%a fetch origin
