5/21/2025 2:03:02 PM
trying to get driver working . .these seem to work; but driver can't seem to do it . .

curl --location 'https://demo.ironcladapp.com/oauth/token' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic NmVhYjE5N2UtMjRiYS00ZDk2LTgxMDItZWVmZjM1YzY2NGY0OjQ4ODRjOGNjLWUyZjgtNDNhNS05YzNjLTVmMjFmNjlkMGNiNw==' \
--data '{
    "grant_type":"client_credentials"
    }'



curl --location 'https://demo.ironcladapp.com/oauth/token' \
--header 'Content-Type: application/json' \
--data '{
    "grant_type":"client_credentials",
    "scope":"scim.users.readUsers scim.users.createUsers scim.users.updateUsers scim.users.deleteUsers scim.groups.readGroups scim.groups.updateGroups",
    "client_id":"6eab197e-24ba-4d96-8102-eeff35c664f4",
    "client_secret":"4884c8cc-e2f8-43a5-9c3c-5f21f69d0cb7"
    }'