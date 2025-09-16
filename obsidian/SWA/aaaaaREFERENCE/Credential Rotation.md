11/7/2024 5:38:31 PM

10/22/2024 5:15:54 PM
Drivers needing some sort of credential rotation:
- IDtoMiro
  Sandbox: - "namedPasswordKey_1"
  production: - "namedPasswordKey_1"
- IDtoAvioBook
  Non prod:
    standard: "namedPassword_1"
    prelive: "namedPassword_2"

    standard qa: "namedPassword_1"
    standard prod: "namedPassword_1"

    prelive prod: namedPassword_2

- IDtoDocunet
   sftp_private_key_passphrase - for sending the file.
   sftp_private_key - for sending the file.
    gpg_public_key - for encrypting the files - the client needs to create the keys.
- IDtoBrowserStack
- IDtoSprinkler