# PowerShell driver errors

PowerShell driver errors

    <status event-id="IDVServer#20091112155813#1#1" level="error" type="driver-general">
      <description>Unable to execute 'Operation failed with status: \[1\] External process output:  | Access to the address list service on all Exchange 2007 servers has been denied.At line:1 char:1+ E <<<< nable-Mailbox -Identity 'Red2\_1bh' -Alias 'User2\_1b' -Database 'CN=Mailbox Database,CN=First Storage Group,CN=InformationStore,CN=DOMAIN2007,CN=Servers,CN=Exchange Administrative Group (FYDIBOHF23SPDLT),CN=Administrative Groups,CN=First Organization,CN=Microsoft Exchange,CN=Services,CN=Configuration,DC=testdev,DC=com''</description>
    </status>

This error was due to having the "routing and remote acess" service stopped.  NOt sure what stopped it though . ..
