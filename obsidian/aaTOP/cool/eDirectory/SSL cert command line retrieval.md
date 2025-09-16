https://stackoverflow.com/questions/7084482/how-to-save-the-ldap-ssl-certificate-from-openssl

```
openssl s_client -connect 192.168.1.225:636
```

Then just get the standard cert data from the top of the request, and store to a file.