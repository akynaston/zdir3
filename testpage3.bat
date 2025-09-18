xcopy *.bat C:\z
set TOKENVALUE=
set HOST=https://southwest.gitlab-dedicated.com/api/v4/groups/

echo Page 2 on idm 
curl --location --request GET "%HOST%51721/projects?per_page=200&page=2"  --header "PRIVATE-TOKEN: %TOKENVALUE%" | jq