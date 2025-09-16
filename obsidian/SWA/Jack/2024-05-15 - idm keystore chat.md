keytool -importkeystore -srckeystore cacerts -destkeystore cacerts.pkcs12 -srcstoretype JKS -deststoretype PKCS12 -deststorepass changeit


5/15/2024 5:35:04 PM
Jack:
keystore chat:
 - need freedom: PKCS12 new, old: JKS
 - keytool will complain about JKS . .
 - https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/edit-v2/74615159
   - purpose for rule 2
   - Couldn't update existing cert in keystore . . .but something was wrong with it.
   - Had to create a new cacert, so would do this . .
  - could make a second copy with PKCS12.
  - For new drivers, please use PKCS12.
 - only model problem:
   - doing things under edir id . .
   - edir id has a lot of rights. .
   - ideally: have own local account . .
   - like an 'idmuser'
 - maybe recommend git/chef/terraform/ansible - /idmFeeds, /idmfiles, etc . .
 - Now, exprining certs - especially CA certs . .
   - Manual Venify situation?
   - How do we get the new jdk cert pack?

keytool -importkeystore -srckeystore [MY_KEYSTORE.jks] -destkeystore [MY_FILE.p12] -srcstoretype JKS -deststoretype PKCS12 -deststorepass [PASSWORD_PKCS12]

