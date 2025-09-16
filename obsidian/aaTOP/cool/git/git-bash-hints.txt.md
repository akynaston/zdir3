2/5/2024 11:58:51 AM
new way to use bash easily from the commnand line

Just need to put path to git\bin as the first entry:

C:\work\MCL>path
PATH=C:\Program Files\Git\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Program Files (x86)\Sennheiser\SoftphoneSDK\;C:\Program Files\PuTTY\;C:\Program Files\Microsoft SQL Server\110\Tools\Binn\;C:\Users\x266698\.jdks\azul-1.8.0_382\bin;C:\cygwin64\bin;C:\maven\bin;C:\ProgramData\chocolatey\bin;C:\Users\x266698\AppData\Local\Programs\Python\Python311;C:\Program Files\Amazon\AWSCLIV2\;C:\Users\x266698\AppData\Local\Programs\Common;C:\Program Files\Docker\Docker\resources;C:\work\trivir\bin\idmunit-test-converter\bin;C:\work\trivir\bin\schema-check\bin;C:\Program Files\GitHub CLI\;C:\Program Files (x86)\Microsoft SQL Server\Client SDK\ODBC\130\Tools\Binn\;C:\Program Files (x86)\Microsoft SQL Server\140\Tools\Binn\;C:\Program Files (x86)\Microsoft SQL Server\140\DTS\Binn\;C:\Program Files (x86)\Microsoft SQL Server\140\Tools\Binn\ManagementStudio\;C:\Program Files\Git\cmd;C:\Program Files\Git\bin;C:\Users\x266698\AppData\Local\Microsoft\WindowsApps;C:\Users\x266698\AppData\Local\Programs\Git\cmd;C:\Users\x266698\AppData\Local\Programs\Git\bin;C:\ant\apache-ant-1.10.13\bin;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\bin;C:\Users\x266698\AppData\Local\Programs\Microsoft VS Code\binC:\Users\x266698\AppData\Local\Programs\Common\C:\Users\x266698\AppData\Local\Programs\Common\;C:\Users\x266698\AppData\Local\Programs\Microsoft VS Code\binC:\Users\x266698\AppData\Local\Programs\Common\;C:\Users\x266698\AppData\Local\Programs\Microsoft VS Code\bin;C:\work\utils\idmunit-test-converter\bin;



2/5/2024 11:58:49 AM- old way:
Set this to fix escape characters; cygwin must be installed.


$ cat ~/.bashrc
export TERM=cygwin
