---
tags: ["#powershell"]
---
# Get exchange 2007 mailstore databases: potential homeMDB values:

Get exchange 2007 mailstore databases: potential homeMDB values:

\[PS\] C:\\Windows\\System32>get-mailboxdatabase | fl Name, DistinguishedName
Name              : Mailbox Database
DistinguishedName : CN=Mailbox Database,CN=First Storage Group,CN=InformationSt
                    ore,CN=WIN2K8EX2007,CN=Servers,CN=Exchange Administrative G
                    roup (FYDIBOHF23SPDLT),CN=Administrative Groups,CN=First Or
                    ganization,CN=Microsoft Exchange,CN=Services,CN=Configurati
                    on,DC=trivirdev,DC=com
Name              : MailboxDatabase2
DistinguishedName : CN=MailboxDatabase2,CN=First Storage Group,CN=InformationSt
                    ore,CN=WIN2K8EX2007,CN=Servers,CN=Exchange Administrative G
                    roup (FYDIBOHF23SPDLT),CN=Administrative Groups,CN=First Or
                    ganization,CN=Microsoft Exchange,CN=Services,CN=Configurati
                    on,DC=trivirdev,DC=com
Name              : MailboxDatabase3
DistinguishedName : CN=MailboxDatabase3,CN=First Storage Group,CN=InformationSt
                    ore,CN=WIN2K8EX2007,CN=Servers,CN=Exchange Administrative G
                    roup (FYDIBOHF23SPDLT),CN=Administrative Groups,CN=First Or
                    ganization,CN=Microsoft Exchange,CN=Services,CN=Configurati
                    on,DC=trivirdev,DC=com

Or if you just want the names:

\[PS\] C:\\Windows\\System32>get-mailboxdatabase | fl Name
Name : Mailbox Database
Name : MailboxDatabase2
Name : MailboxDatabase3
