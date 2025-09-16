8/27/2025 4:31:55 PM
Seems like the pov environment no longe rhas target process . .at least this doesn't worka ny more:

https://southwestairlinespov.tpondemand.com/api/v1/users?where=(email eq 'elaine.hopkins@wnco.com')&access_token={{TP_POV_API}}


8/28/2025 12:42:20 PM
Having issue in driver:


 openssl s_client -connect https://southwestairlinespov.tpondemand.com/api/v1/users -showcerts
I ran that openssl call, then got the 'lowest cert' - the one furthest from the CA, then imported it into "CA certs, and it seemed to work!"