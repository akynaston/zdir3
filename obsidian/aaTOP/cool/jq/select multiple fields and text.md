type browser_stack_users.json | jq --raw-output ".Resources[] | \"userName: \(.userName)\t bstack_product: \(.bstack_product), cn: \(.id) \" "


Lists users in aviobook, and the JQ's id and username to find users to delete:

@curl -k --location "https://prod.swa.aviobook.aero/idp/login" --request POST -H "Content-Type: application/json" --data "{ \"username\": \"avio-idp-api\", \"password\": \"PASSWORD HERE\" }" |  jq -r .accessToken > token.jwt

@echo off
for /f "usebackq delims=" %%a in ("token.jwt") do (
  set "tokenData=%%a"
  goto :breakLoop
)
:breakLoop

rem curl --location https://prod.swa.aviobook.aero/idp/users?query=id==a* --header "AVIO-Token: %tokenData%" --request GET  |  jq -r .items[*].id > User.json

echo "Users to delete: " > usersToDelete.txt

curl --location https://prod.swa.aviobook.aero/idp/users?query=id==a* --header "AVIO-Token: %tokenData%" --request GET | jq -r ".items[] | \"username: \" + .credentials.username + \"\tid: \" + .id" >> usersToDelete.txt

