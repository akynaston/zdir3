4/16/2025 12:06:04 PM
Jeremiah showing lunch_and_learn client in the AIC UI . .
have clien tid and secret

conversationa bout authentication
	 - implied consent disabled
	 - - client type: confidential . .so not giving client secret . . per Brian
talking about config of the oauth2 client in 'bravo' realm

* discussing override settings: make sure you set everything in the screen
*

urls from Jeremiah:
[https://10.30.128.34:12000](https://10.30.128.34:12000)  

[https://10.30.128.34:12000/pkce.html](https://10.30.128.34:12000/pkce.html)
now testing these
hit the pages; now redirect brought us to the login screen am . .

lnl
TriVir#1

authorized, 'allow' - back to authorize endpoint, now authetnicatd, cna finish auth code flow
 - request - auth endpoint
reviewing JWT we get back:

going through each; some notes added
acces stoken:
{
  "sub": "85acdba7-9c66-4bf2-a1a8-852c871ad9df",
  "cts": "OAUTH2_STATELESS_GRANT",
  "auth_level": 0,
  "auditTrackingId": "10d43ba9-75cf-44c1-a787-d0efe6bf1891-97250",
  "subname": "85acdba7-9c66-4bf2-a1a8-852c871ad9df",
  "iss": "https://openam-trivir.forgeblocks.com:443/am/oauth2/bravo",
  "tokenName": "access_token",
  "token_type": "Bearer",
  "authGrantId": "jQKncup5eKWsTje0TV6ECcdJpyE",
  "client_id": "lnl_pkce",
  "aud": "lnl_pkce",
  "nbf": 1744827795,
	  not-before
  "grant_type": "authorization_code",
  "scope": [
    "openid",
    "profile"
  ],
	scopes let you decide how much a user can expose to an ap . .
  "auth_time": 1744827615,
  "realm": "/bravo",
	  AM thing
  "exp": 1744831395,
  "iat": 1744827795,
	  issued at
  "expires_in": 3600,
  "jti": "An0zjo6gD-yfnE_WNmLkVBqynV0"
	  token id . .
}

id token
{
  "at_hash": "5on7Htvzg3XWVIv1rloF2A",
	  tying things to geter, group can't remember
  "sub": "85acdba7-9c66-4bf2-a1a8-852c871ad9df",
  "auditTrackingId": "10d43ba9-75cf-44c1-a787-d0efe6bf1891-97251",
  "subname": "85acdba7-9c66-4bf2-a1a8-852c871ad9df",
  "iss": "https://openam-trivir.forgeblocks.com:443/am/oauth2/bravo",
  "tokenName": "id_token",
  	  "given_name": "Lunch",
	  	  some personal stuff like this tabbed in
  "sid": "SsF1ZJ2pKwJKBVwnplTaTW4c6lABxG4Z2Mt1js9cC70=",
  "aud": "lnl_pkce",
  "c_hash": "Sb8FVoKQvTsjsTBemjropw",
  "org.forgerock.openidconnect.ops": "t9HIWqOqqqVA6bqW6jCy8XrAGkc",
  "azp": "lnl_pkce",
	  authroziign party:
  "auth_time": 1744827615,
	  "name": "Lunch Learn",
  "realm": "/bravo",
  "exp": 1744831395,
  "tokenType": "JWTToken",
  "iat": 1744827795,
	  "family_name": "Learn"
}

tok the same steps on:
[https://10.30.128.34:12000/pkce.html](https://10.30.128.34:12000/pkce.html)

with oauth 1 and bapi, required to use pkce . .

bapi - financial api: really high security oauth apis . .
pkce: proof key for code exchange - major standord . .want this all the time in aauth

Key item: Never during hte process could Brian's back end application have access to hte username/password.

doing postman L&L oauth stuff can ask for profile in clent crednetisl; but not prifle; client

