
 - DXCMD - Get latest idmunit-core - idmunit-core fixes & prs -idmunit-core-3.0.0-20231127.230622-62.jar
  - IDM Deployer - Named password confusion nail this down:
    Miro I used this:
            namedPasswordKey_1: miroAPIToken
            namedPassword_1: aws:dev/MiroSCIM_BearerToken
            namedPasswordDescription_1: Bearer token for the Miro application
      Latest example has this:
            #      namedPassword_1_password1: aws:alpha/IDtoADPowershell/namedPassword/password1
            #      namedPasswordDescription_1: named password 1 description
    - Update swa-scim-connector to use jsonpath - https://southwest.atlassian.net/browse/CSEE-3256
  - Document new CI process - KB0016525

5/8/2024 2:36:15 PM - Gokul to note to Baron/Kyle regarding support accessible front end to trigger a sync for a userid, and application . . along with some security check maybe? Authentication of e/x id?




