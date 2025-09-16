---
tags: ["#powershell"]
---
# Powershell: Array maniuplation notes: windows powershell Re: Updating AD proxyAddresses

$u.PutEx(2, 'proxyAddresses', (,"$pa"))
All I had to do was add quotes to what you posted and then, pow; it worked!
Thanks again.
