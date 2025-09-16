---
tags: ["#win2k8"]
---
# Windows 2008: EX2007: Calls to make to install EX2007

Windows 2008: EX2007: Calls to make to install EX2007

install.cmd:
ServerManagerCmd -i RSAT-ADDS

(then reboot)

install2.cmd:
ServerManagerCmd -i PowerShell
ServerManagerCmd -i Web-Server
ServerManagerCmd -i Web-ISAPI-Ext
ServerManagerCmd -i Web-Metabase
ServerManagerCmd -i Web-Lgcy-Mgmt-Console
ServerManagerCmd -i Web-Basic-Auth
ServerManagerCmd -i Web-Digest-Auth
ServerManagerCmd -i Web-Windows-Auth
ServerManagerCmd -i Web-Dyn-Compression
ServerManagerCmd -i RPC-over-HTTP-proxy

Trying this isntead:

Import-Module ServerManager
add-windowsfeature RSAT-ADDS
add-windowsfeature Web-Server
add-windowsfeature Web-ISAPI-Ext
add-windowsfeature Web-Metabase
add-windowsfeature Web-Lgcy-Mgmt-Console
add-windowsfeature Web-Basic-Auth
add-windowsfeature Web-Digest-Auth
add-windowsfeature Web-Windows-Auth
add-windowsfeature Web-Dyn-Compression
add-windowsfeature RPC-over-HTTP-proxy
