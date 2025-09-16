5/15/2024 6:35:24 PM

Note: You can use this line to convert from jks to pkcs12! (aka p12):
keytool -importkeystore -srckeystore cacerts -destkeystore cacerts.pkcs12 -srcstoretype JKS -deststoretype PKCS12 -deststorepass changeit


