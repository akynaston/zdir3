4/18/2024 1:46:58 PM
When using find and -regex, be sure to check -regextype; but more importantly - prefix with '.*' since find returns the ./ at the beginning of every path!

```
[edir@w11dcledirdi013 /opt/IDMFeeds/IDtoDocunet/output]$ find /opt/IDMFeeds/IDtoDocunet/output -type f -regex ".*userDocu.+csv"
./opt/IDMFeeds/IDtoDocunet/output/userDocunet_header.csv
[edir@w11dcledirdi013 /opt/IDMFeeds/IDtoDocunet/output]$
```