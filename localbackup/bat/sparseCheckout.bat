pushd "%~dp0"
if not exist .\IDMDriverTemplateRepo mkdir .\IDMDriverTemplateRepo
pushd .\IDMDriverTemplateRepo
git init
git remote add origin -f https://stash1-tools.swacorp.com/scm/csiam/idmdrivertemplaterepo.git
git pull --depth=1 origin master
git co master
popd