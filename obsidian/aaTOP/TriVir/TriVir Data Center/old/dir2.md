2/7/2024 5:27:20 PM            

Huston told me the wrong cert is being sent; I confirmed; found the cert was good in the tree; but nldap hadn't been restarted:

openssl s_client -showcerts -connect dir2.utah.trivir.com:636 -showcerts

Proved bad cert:
dir2:~ # openssl s_client -showcerts -connect dir2.utah.trivir.com:636 -showcerts


CONNECTED(00000003)
depth=1 /O=TRIVIR-IDV/OU=Organizational CA
verify error:num=19:self signed certificate in certificate chain
verify return:0
---
Certificate chain
 0 s:/O=TRIVIR-IDV/CN=dir2.dock.trivir.com
   i:/O=TRIVIR-IDV/OU=Organizational CA
-----BEGIN CERTIFICATE-----
MIIG3DCCBcSgAwIBAgIlAhwU4W55lSzE0cxiGuqqCytn5mtnMXRkOKOFIdfcAgMV
AmkluzANBgkqhkiG9w0BAQUFADAxMRMwEQYDVQQKEwpUUklWSVItSURWMRowGAYD
VQQLExFPcmdhbml6YXRpb25hbCBDQTAeFw0yMjA4MjQxNTI1NTJaFw0yNDA4MjMx
NTI1NTJaMDQxEzARBgNVBAoTClRSSVZJUi1JRFYxHTAbBgNVBAMTFGRpcjIuZG9j
ay50cml2aXIuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv/92
mBVkjSgDVef0rgaRC/izI4AFqrdPk7UUmtkoKTfu7AKDbMdQOptMOOnLFOrqR12H
XgnMDvHfN3HxEye8KGHyyKuvdsZFwKj7qza9eYwFUcBOJlHin5iXyBDGK95XJ3RF
uldVRZHXNB+Uw2D3hgk8a938YEGsgVsSR4D/pJ3TOO+iXxsmUcFQpyK6oUy4JSN8
FUHVTFPaLW/smEt/kXLXcfDCPSJEPn6+Q4dT+fnqaP5NPwyVN4lp5Zwrkwxk9m+E

nldap -u && nldap -l

restarted nldap, now good cert:

dir2:~ # openssl s_client -showcerts -connect dir2.utah.trivir.com:636 -showcerts
CONNECTED(00000003)
depth=1 /O=TRIVIR-IDV/OU=Organizational CA
verify error:num=19:self signed certificate in certificate chain
verify return:0
---
Certificate chain
 0 s:/O=TRIVIR-IDV/CN=dir2.utah.trivir.com
   i:/O=TRIVIR-IDV/OU=Organizational CA
-----BEGIN CERTIFICATE-----
MIIG5TCCBc2gAwIBAgIULmWnAQsdZWnT+jTR3457oolTmsswDQYJKoZIhvcNAQEL
BQAwMTETMBEGA1UEChMKVFJJVklSLUlEVjEaMBgGA1UECxMRT3JnYW5pemF0aW9u
YWwgQ0EwHhcNMjQwMTE5MDMwNTAyWhcNMjYwMTE4MDMwNTAyWjA0MRMwEQYDVQQK
EwpUUklWSVItSURWMR0wGwYDVQQDExRkaXIyLnV0YWgudHJpdmlyLmNvbTCCASIw
DQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAM1Db7EaxRlqxowKDVc1Xw8boamO

2/8/2024 2:52:50 PM
This is the state of the tree before I did anything; it was already correct: dir2.utah.com
![[dir2-new-cert-default-name-correct.png]]

![[Dir2SubjectName-AlreadyCorrect.png]]



