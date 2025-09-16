2/21/2024 11:32:05 AM
this error:
warning: git-credential-manager-core was renamed to git-credential-manager
warning: see https://aka.ms/gcm/rename for more information

says to update to latest git, but 2.43.0 seems to cause issues . . for now, do this:

Delete the '-core' from the global and system .gitconfig credential.helper section.


![[Pasted image 20240221113233.png]]


Tip to find these easily is here:
https://github.com/git-ecosystem/git-credential-manager/blob/main/docs/rename.md
they say do this:
git config --show-origin --get-all credential.helper.

output is like this:

C:\work\adminrepo>git config --show-origin --get-all credential.helper
file:C:/Program Files/Git/etc/gitconfig manager-core
file:C:/users/x266698/.gitconfig        manager-core

but should be like this (drop -core):

C:\work\adminrepo>git config --show-origin --get-all credential.helper
file:C:/Program Files/Git/etc/gitconfig manager
file:C:/users/x266698/.gitconfig        manager
