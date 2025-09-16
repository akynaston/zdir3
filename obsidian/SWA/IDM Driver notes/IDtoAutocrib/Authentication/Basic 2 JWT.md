1/10/2025 4:32:00 PM
Authentication through postman appears to be stnadard basic auth; however, the response appears to be a full JWT:


Example JWT - retreived about 1/10/2025 4:33:45 PM
eyJhbGciOiJSUzI1NiIsImtpZCI6ImpiMlZJODdYMmFXc3FpNjdydVdZVEEiLCJ0eXAiOiJhdCtqd3QifQ.eyJuYmYiOjE3MzY1NDkxODcsImV4cCI6MTczNjU1Mjc4NywiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS5hdXRvY3JpYi5uZXQiLCJhdWQiOiJhcmN0dXJ1c3dlYmFwaSIsImNsaWVudF9pZCI6IlNvdXRod2VzdCIsImFwaVNjb3BlIjpbImFwaS5jcmVhdGUiLCJhcGkucmVhZCIsImFwaS51cGRhdGUiLCJhcGkuZGVsZXRlIl0sIkRiSWQiOlsiOTEzMiIsIjEwNjM2IiwiMTA2MzciLCIxMDYzMiJdLCJFcGljb3JDb250cmFjdE51bWJlciI6Ijk5OTkiLCJzY29wZSI6WyJhcmN0dXJ1c3dlYmFwaSJdfQ.FtVMhVkVXxorQt_Tx4cloQNMKzGxxOUyWmVfd7bO_zYW800aQ7CENATCmU338GFAlBboY7KA3QJMueIXfB2D3hyqCJTOCe5LwYVunUj1plTuFFRG95VS-H59OSem0eAypRXITs-CChGlChwAud1weR3yqwJTN6ArBCw16LmNcpcmgHUuaSQwfpJfv3MTWSasui5RwJ3WmjfIU_zC7Z1aaU9AD_sxY1BGagCc5uSpnjTkx0DjsBhsejryt1-fuqv6SojkX4vJU6aNG6pGjHfFhek0b9JmG2moshuDmbvnv9O43XDJPXfS13XG6obX2c2I-tbftFm7kE752lo2OEEU_w

Decoded:

HEADER:ALGORITHM & TOKEN TYPE
{
  "alg": "RS256",
  "kid": "jb2VI87X2aWsqi67ruWYTA",
  "typ": "at+jwt"
}

PAYLOAD:DATA
{
  "nbf": 1736549187,
  "exp": 1736552787,
  "iss": "https://identity.autocrib.net",
  "aud": "arcturuswebapi",
  "client_id": "Southwest",
  "apiScope": [
    "api.create",
    "api.read",
    "api.update",
    "api.delete"
  ],
  "DbId": [
    "9132",
    "10636",
    "10637",
    "10632"
  ],
  "EpicorContractNumber": "9999",
  "scope": [
    "arcturuswebapi"
  ]
}

VERIFY SIGNATURE

RSASHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  ,
  
)

1/10/2025 4:46:50 PM
Found this works
Post to https://identity.autocrib.net/connect/token
Authorization: Basic "base64 encoded clientid + client secret"
Content-Type application/x-www-form-urlencoded,
Body: x-www-form-url-encoded:
	grant_type -> client_credentials

response:
{

    "access_token": "eyJhbGciOiJSUzI1NiIsImtpZCI6ImpiMlZJODdYMmFXc3FpNjdydVdZVEEiLCJ0eXAiOiJhdCtqd3QifQ.eyJuYmYiOjE3MzY1NTI3OTIsImV4cCI6MTczNjU1NjM5MiwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS5hdXRvY3JpYi5uZXQiLCJhdWQiOiJhcmN0dXJ1c3dlYmFwaSIsImNsaWVudF9pZCI6IlNvdXRod2VzdCIsImFwaVNjb3BlIjpbImFwaS5jcmVhdGUiLCJhcGkucmVhZCIsImFwaS51cGRhdGUiLCJhcGkuZGVsZXRlIl0sIkRiSWQiOlsiOTEzMiIsIjEwNjM2IiwiMTA2MzciLCIxMDYzMiJdLCJFcGljb3JDb250cmFjdE51bWJlciI6Ijk5OTkiLCJzY29wZSI6WyJhcmN0dXJ1c3dlYmFwaSJdfQ.V7s3hbkBVXR30fA3Y7j6PN5Cfo7fgEDQMLvpuQhUQ1Fp_J_SMSr4JKpoumU_XEwgSkYbMtFxoG29fmMsSwQlxYEStb1zSSFUmZ37AxfUpMUVb32dwiXcjMzG7rqwrxXBVOBV2xn8qkNVVkawmHC-TT6jgEgQUla4HlxWILk0WLmSxfvBgtAbc2oFMBHQdoQJak6pi6KwTEZJGETJZBZPgX92T7Z055m64VvOkzaqWy3mkvkF-kQedCwGXh88sA3uaM6auASHeI3KB_BIzWanHdSSS2tMvZJBpr1x6cf_fPzSAFcB53NeOjuff9sItdmAqXRow6atX1pEhHEJ-XSjLQ",

    "expires_in": 3600,

    "token_type": "Bearer",

    "scope": "arcturuswebapi"

}
