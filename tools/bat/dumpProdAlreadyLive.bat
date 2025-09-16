@curl -k --location "https://identity.autocrib.net/connect/token" --header "Authorization: Basic U291dGh3ZXN0OjYxM2M2YWU5LTQzN2UtNGIyNi04ZDBlLThkYTJhOGE1YTg1MQ==" --request POST -H "Content-Type: application/x-www-form-urlencoded" --data "grant_type=client_credentials" |  jq -r .access_token > token.jwt

@echo off
for /f "usebackq delims=" %%a in ("token.jwt") do (
  set "tokenData=%%a"
  goto :breakLoop
)
:breakLoop

set dbid=10787
set filename=%dbid%-Chicago.json
echo "dumping %filename%", page 1
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000&pagenumber=1" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %filename%

set dbid=11307
set filename=%dbid%-Dallas.json
echo "dumping %filename%", page 1
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000&pagenumber=1" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %filename%

set dbid=10689
echo "dumping %dbid%-Denver"
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %dbid%-Denver.json

set dbid=10632
echo "dumping %dbid%-Atlanta"
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %dbid%-Atlanta.json

set dbid=10690
echo "dumping %dbid%-Huston"
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %dbid%-Huston.json

set dbid=10691
echo "dumping %dbid%-Orlando"
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %dbid%-Orlando.json

set dbid=10802
set name=FortLauderdale
echo "dumping %dbid%-%name%"
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %dbid%-%name%.json

set dbid=10803
set name=Tampa
echo "dumping %dbid%-%name%"
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %dbid%-%name%.json

set dbid=10804
set name=Milwaukee
echo "dumping %dbid%-%name%"
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %dbid%-%name%.json

set dbid=10806
set name=Baltimore-Washington
echo "dumping %dbid%-%name%"
curl --location "https://api.autocrib.net/v1/Employee?pagesize=1000" --header "dbId: %dbid%" --header "Authorization: Bearer %tokenData%" > %dbid%-%name%.json


echo Pretty printing . . .
setlocal EnableDelayedExpansion

for %%f in (*.json) do (
    echo Processing %%f...
    jq . %%f > %%f.tmp && move /y %%f.tmp %%f
)
endlocal

del token.jwt