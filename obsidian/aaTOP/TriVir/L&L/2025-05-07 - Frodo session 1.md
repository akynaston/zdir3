5/7/2025 12:07:45 PM
Frodo

ForgeROck DO - 
* PIngAM
* PingOne
* forgeOps
* PingIDM(soon)

amster is another - but only for am . .
Forgerock config manger ony clouds . .
 - there is an effort to allow frodo to take config maanger exports . .

Added a connection:
trivir@trivir-frodo-dev-vm:~/frodoLNL$ frodo conn add 'http://openam-frodo-dev.classic.com:8080/am' 'amadmin' 'TriVir#1'
Connected to http://openam-frodo-dev.classic.com:8080/am [/] as user amadmin
Saved connection profile http://openam-frodo-dev.classic.com:8080/am
trivir@trivir-frodo-dev-vm:~/frodoLNL$ ^C


frodo conn add -h - gives info about environment variables.

trivir@trivir-frodo-dev-vm:~/frodoLNL$ frodo conn describe openam --show-secrets
Host           │http://openam-frodo-dev.classic.com:8080/am
Deployment Type│classic                                    
Username       │amadmin                                    
Password       │TriVir#1                                   
trivir@trivir-frodo-dev-vm:~/frodoLNL$ 

getting some keys from 1password
Frodo L&L Service Account and API Key/Secret
https://start.1password.com/open/i?a=B7SZ4EDWTZDBBHUKAJQ3ZHPWDY&v=p2khxbjcffhibizqxoqw6efvqy&i=sx4kps5xudf2b2nmu3isfjjwaa&h=my.1password.com


Ran this to validate . . . the service account
trivir@trivir-frodo-dev-vm:~/frodoLNL$ frodo conn add 'https://openam-trivir.forgeblocks.com/am' --sa-id 'a5c67e68-c7ba-484e-88e7-ed3327256582' --sa-jwk-file 'privateKey.jwk' --log-api-key '63514e244c3b78c63e4f1150a4f765a8' --log-api-secret '9e4e5aad0ed7564aff1258dbc9c9ba8b8dbdc5772320b04c2fc11e443ef6b89a'
Connected to https://openam-trivir.forgeblocks.com/am [alpha] as service account Frodo L&L [a5c67e68-c7ba-484e-88e7-ed3327256582]
✔ Successfully validated service account a5c67e68-c7ba-484e-88e7-ed3327256582.
Validated and added service account with id a5c67e68-c7ba-484e-88e7-ed3327256582 to profile.
Saved connection profile https://openam-trivir.forgeblocks.com/am


frodo conn describe trivir

Exporting: this is likely the best
-A - all
-x - split js and json
-N
frodo script export trivir -AxND ./scripts/


