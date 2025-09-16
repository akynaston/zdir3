---
tags: ["#c-fcps"]
---
# FCPS: Script that reads mailbox guids, and creates ldif file to set association

FCPS: Script that reads mailbox guids, and creates ldif file to set association
##################################################
\# BuildMailboxGuidLDIF.ps1
\# This script reads all mailboxes from all accessable databases, and generates an ldif file to be added to FCPS tree.
##################################################
param (\[string\] $fullPathLdifFile)
if (Get-PSSnapin -name "Microsoft.Exchange.Management.PowerShell.Admin" -ea "silentlycontinue") {
    Write-Host "Exchange Snapin already loaded."
} else {
    Add-PSSnapin Microsoft.Exchange.Management.Powershell.Admin;
}
    $file = \[System.IO.StreamWriter\] $fullPathLdifFile
    if ($? -eq $null) {
        Write-Host "\*\*\*\*\*\*\*\*\* FAILED TO OPEN FILE! \*\*\*\*\*\*\*";
        
    }
        
    Write-Host "Creating ldif file:" $fullPathLdifFile
    
    $file.WriteLine("version: 1");
    $file.WriteLine();
    Get-MailboxDatabase | Get-Mailbox | foreach {
        $file.WriteLine("dn: cn=" + $\_.Alias + ",ou=Employees,o=FCPS");
        $file.WriteLine("changetype: modify");
        $file.WriteLine("add: DirXML-Associations");
        $file.WriteLine("DirXML-Associations: cn=EX2007-PowerShellDriver,cn=Driver Set,ou=idm,o=services#1#" + $\_.ExchangeGuid);
        $file.WriteLine();
        $file.WriteLine("dn: cn=" + $\_.Alias + ",ou=Employees,o=FCPS");
        $file.WriteLine("changetype: modify");
        $file.WriteLine("add: businessCategory");
        $file.WriteLine("businessCategory: " + $\_.ExchangeGuid);
        $file.WriteLine();
    }
    
    $file.close();
