We did not meet last week; here's th entoes from my phone:




oaurh and oidc


oaurh 1 removed
ouath 2 and 2.1
oqtuh allow authorization, not authentication necessarily

authentication: proves who you are
authorization key to front door

Facebook: photos problem. people using password everywhere.

oidc is auth layer on oaurh 

jwt: payload . and signed...

tokens:
access - token in oaurh flow... super short lifetime... 15 mins...
refresh - get new access. don't be longer than a year.
Id - user and profile data. from oidc.


bearer - any party with this can use the token. needs to be super secure...equivalent to username and password. can hash etc when debugging.

auth server - issues all tokens.
resource server - has to validate access token. typically there's an endpoint to validate.
Blacklisting tokens... have to do manually.


resource owner... not necesaurlalh a person..

client - app asking for access/get tokens...
scope- limits to account ( only oaurh)
claims - assertions  that one subject makes about itself or another subject 

note claims not same as scope.

redirect uri - receives code or token responses.

most flows in oauth are through browser. 

can limit here.. Trivir com

tokens: can revoke/expire where username password is to much.

pkce: extension of auth code flow. used when app can't keep secret secure. oaut2.1 requires anyway.

client credentials: oaurh client with no user involved... no user anything. no user info/reference...

oauth flows:

device code - type in this number: Netflix on Xbox

refresh token

res owner pass creds. deprecated in 2, removed in 2.1. app takes credentials the. goes to get get token.

implicit: dep in 2, removed 2.1 user auth directly, but no client sec. less secure...not really much validation. DGI is using... per Jeremiah

now doing flow diagrams

auth code flow.. 11 steps.betwrrn

client, res owner user agent, am auth server resource server.


if token only is valid 5 mins, maybe only validate once... if much longer validate more often.

not shown:  step 12 could be app session... says Huston... not doing much with token at this point..

Jeremiah: PKCE may override this...

PKCE flow.. also 11 steps..

device code flow: like Netflix on TV... this is the one with a "user code" like on Netflix...

client credentials.. 6 steps.. like test aois...


questions... 








