# Untitled Note

Yubikey LUnch and learn 

1/20/2021 1:42:29 PM

1/20/2021 12:07:10 PM
YUBI Key 
L&L meeting 1
meeting 2: gpg key set up moved to yubickey
meeting 3: 

 - ksl venmo issue with sms
 - idea behind hardware, have to possess to use it.
 - fido protocol - fishing proof, baring bugsin the browser.
 - webauthn - protocol standard, backs it: fido
 - this is pretty new - 2019 coming together . .became web standard
 - september 2020 - apple - started supporting with all brwosers.
 - MY not be fully supportd everywhere.

 - Yubikey manager with key in
    firmware: 5.2.7
    Serial: 15904332
 - derived credentials - from fips perpsective, issued to yobiki fips . .
 - yubikiky 5 can be valid for piv credential.
 - applicatoins -> OTP
     - just tapped button:
     - ccccccvdlufrtlnlrktcbtrftbbvfrcuenuueungktht
     - called the yubisneez - has hardreturn
     - not supported any more really - last pass uses this . .
    - Forge rock AM - nodeds that support this
    - OATH-HOTP - uses HMAC  . . - oath can also store totp seeds.
 - FIDO2 pin
     - always require pin -some sites may require pin.
     - 057556 - set
     - FIDO - can do hard reset
 - PIV
     - condisdered a smart card
     - 
 - ykman:
 C:\\Program Files\\Yubico\\YubiKey Manager>ykman info
Device type: YubiKey 5C NFC
Serial number: 15904332
Firmware version: 5.2.7
Form factor: Keychain (USB-C)
Enabled USB interfaces: OTP+FIDO+CCID
NFC interface is enabled.

Applications    USB     NFC
OTP             Enabled Enabled
FIDO U2F        Enabled Enabled
OpenPGP         Enabled Enabled
PIV             Enabled Enabled
OATH            Enabled Enabled
FIDO2           Enabled Enabled

25 or 32 resident credentaisl,different than fido creds
     - these are like password authentication, so sliktly more complciated.
 - 
accounts.google.com:

 - in google: YubikeyTrivir - retgistred as econd

https://www.yubico.com/genuine/
     - verifyyubikey . .
     - 

play around
 https://demo.yubico.com/

End with: fun to work on

https://webauthn.io/

https://webauthn.guide/
