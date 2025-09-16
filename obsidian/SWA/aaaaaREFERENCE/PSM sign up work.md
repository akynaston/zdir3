8/22/2025 2:12:15 PM
Last friday, we were asked to move to PSM for authentication - now we're on it, and it's working great - some ntoes:


There are two fields in


ssh -i C:/Users/x266698/.ssh/key.openssh x266698@EDIRengDEV#diracvsps.cis.prod.swacorp.com@w11dcledirdi013@psmp.cis.dev.swacorp.com




 - Create new test, with modification of email if needed . .
   - e989721%UNIQUECN%NEW@wncotest.com
 - Also do a version where we change roles.



Best so far:

C:\z>ssh -i C:/Users/x266698/.ssh/key.openssh x266698@EDIRengDEV#diracvsps.cis.prod.swacorp.com@w11dcledirdi013@psmp.cis.dev.swacorp.com
Enter passphrase for key 'C:/Users/x266698/.ssh/key.openssh':

x266698@EDIRengDEV#diracvsps.cis.prod.swacorp.com@w11dcledirdi013@psmp.cis.dev.swacorp.com


This session is being recorded by w11dclcarkpp001
ssh: connect to host diracvsps.cis.prod.swacorp.com port 22: No route to host
Connection to psmp.cis.dev.swacorp.com closed.

 On


ssh -i C:/Users/x266698/.ssh/key.openssh x266698@edir@w11dcledirdi013.swacorp.com@psmp.cis.dev.swacorp.com

@EDIRengDEV#diracvsps.cis.prod.swacorp.com@

Enter passphrase for key 'C:/Users/x266698/.ssh/key.openssh':
Failed to obtain account. Error: [010E Retrieve target account [edir] with address [w11dcledirdi013.swacorp.com] failed. Error: [076E Password object was not found (Diagnostic Info: 5). Please check that there is a password object that answers your query in the Vault and that both the PSM SSH Proxy and the Vault user have the appropriate permissions needed in order to use the password.]] (Diagnostic Info: 1)

Received disconnect from 10.133.96.42 port 22:2: Too many authentication failures
Disconnected from 10.133.96.42 port 22




Request the proper group:
https://southwest.service-now.com/vc?id=kb_article_view&sysparm_article=KB0111958&sys_kb_id=0fe6207147880a14cf7b3ee3836d43ef&spa=1

Video from Gokul that seems to show how to use cybeark to access an RDP session . .
https://wnco.sharepoint.com/sites/CyberProgramTeam/_layouts/15/stream.aspx?id=%2Fsites%2FCyberProgramTeam%2FShared%20Documents%2F1%2E%20BGatB%2F05%2E%20Least%20Privilege%20Access%20%28LPA%29%2F3%20Data%20Center%20System%20Admin%20Rights%2F1%20Change%20Management%2F2%20LPA%20Documentation%20%26%20User%20Guides%5FWindows%2FUser%20Guides%2FPSM%20User%20Guides%2FCyberArk%20PVWA%20Updated%2Emp4&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1FbWFpbCIsInJlZmVycmFsQXBwUGxhdGZvcm0iOiJXZWIiLCJyZWZlcnJhbE1vZGUiOiJ2aWV3In19&referrer=StreamWebApp%2EWeb&referrerScenario=AddressBarCopied%2Eview%2Ee7ea12fc%2D9c66%2D4abd%2Dacae%2D135225a3cd8d


login via ssh client:
  https://southwest.service-now.com/vc?id=kb_article_view&sysparm_article=KB0113143

https://wnco.sharepoint.com/:v:/s/CyberProgramTeam/EbBfLvqSmdhNuD8azkIpfTMB3Fo5XGMy6Hvbn12yUNbi-w?e=0rFVen&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

ssh -i C:/Users/x266698/.ssh/key.openssh x266698@edir@w11dcledirdi013@psmp.cis.dev.swacorp.com

Links from Rachel Sather
SSH command line: is another option: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/305440355/Connect+via+PSM+For+SSH+Proxy+using+MFA+caching+SSH+key

RDP otpoin
https://wnco.sharepoint.com/sites/SWALife-Cybersecurity/SitePages/Least-Privileged-Access.aspx?CT=1755112206922&OR=OWA-NTB-Mail&CID=da518fc0-5fbc-7001-9be4-835325c301cc&csf=1&web=1&e=sJstu4

