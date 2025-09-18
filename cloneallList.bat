xcopy *.bat C:\z

set TOKENVALUE=
set HOST=https://southwest.gitlab-dedicated.com/api/v4/groups/

echo #main repos: > cloneAllReposNow.bat
curl --location --request GET "%HOST%51721/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo Page 2 on idm 
curl --location --request GET "%HOST%51721/projects?per_page=200&page=2" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #IDMUnit: >> cloneAllReposNow.bat
curl --location --request GET "%HOST%51734/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #common: >> cloneAllReposNow.bat
curl --location --request GET "%HOST%51732/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #templates: >> cloneAllReposNow.bat
curl --location --request GET "%HOST%51733/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #Connectors: >> cloneAllReposNow.bat
curl --location --request GET "%HOST%51735/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #myaccess: >> cloneAllReposNow.bat
curl --location --request GET "%HOST%51724/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #iga
curl --location --request GET "%HOST%70393/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #scf
curl --location --request GET "%HOST%78281/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #connectors
curl --location --request GET "%HOST%78282/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #connectors
curl --location --request GET "%HOST%84399/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #sailpointsoirces
curl --location --request GET "%HOST%85264/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #sailpointsources
curl --location --request GET "%HOST%90990/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat

echo #sailpointworkflows
curl --location --request GET "%HOST%93071/projects?per_page=200" --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq -r ".[].ssh_url_to_repo" >> cloneAllReposNow.bat




rem debug
rem #curl --location --request GET "https://southwest.gitlab-dedicated.com/api/v4/groups/51721/projects?per_page=200" --header "PRIVATE-TOKEN:" | jq -r ".[].ssh_url_to_repo"