5/22/2025 11:51:38 AM

1password does a lot . .but OpenSSH is require don swalaptops, so just ssh-add the keys,a nd it works!  1Password adds this config; but I had to add the allowed signers file:

[gpg]
	format = ssh
[gpg "ssh"]
	program = C:\\Users\\x266698\\AppData\\Local\\1Password\\app\\8\\op-ssh-sign.exe
    allowedSignersFile = C:\\Users\\x266698\\.ssh\\allowed_signers
[commit]
	gpgsign = true


C:\Users\x266698\.ssh>type allowed_signers
Aaron.Kynaston@wnco.com ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIAdJyLLTxjBHfiEs+aQTJDwHqk7dahH2ELJDUWx6Bl+8
C:\Users\x266698\.ssh>
