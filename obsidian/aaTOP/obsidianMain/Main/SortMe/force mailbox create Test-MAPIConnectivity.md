# force mailbox create: Test-MAPIConnectivity

Actually force a creation of all mailboxes with this command.  it tests a login, which enforces a creation of the mailbox!
get-mailbox | Test-MAPIConnectivity
