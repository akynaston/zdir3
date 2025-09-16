# [BAE] Home Market AD Rename Bug

\[BAE\] Home Market AD Rename Bug

Deb's comments so far:

I am finding that a rename in a home market domain such as Purple or Greenlnk isn’t renaming the account in Global IDVault. It seems to update BSIADaliasname and BSIADcontext but it doesn’t change the CN, DirXML-ADAliasname, or DirXML-ADContext. Once I rename the account in Global IDVault it updates DirXML-ADAliasname and DirXML\_ADContext.

...

I haven’t found any that work and haven’t correlated if it is just one driver or multiple. I am not changing anything in home market when I rename, I am changing in Global IDVault (eDirectory), the BSIADaliasname, BSIADcontext seem to reflect the new name but CN, DirXML-ADAliasname, and DirXML-ADcontext do not. I rename in eDirectory and the DirXML attrs get updated somehow.

...

Sorry to hear about your family, hope everything remains ok.

Questions and answers from Deb

 - What attributes you are changing during the rename? I assume they are changing the sAMAccountname in home market AD

 - In what system are you doing the rename? A Home Market Domain? Global IDV? The Home Market AD Domain

 - Document the attributes that are changed as a result of that rename in each system. Global IDV, I see that BSIADAliasname and BSIADContext reflect the new name but CN, DirXML-ADAliasname, and DirXML-ADContext reflect the old name. I normally just rename the account in Global and DirXML-ADAliasname and DirXML-ADContext will update then.

I don’t believe the rename in home market AD has any issues the driver isn’t updating all the attributes you needs to in Global IDV for a name change.

* * *

We also have an AC for renames, I am not sure if that lines up with what she wants or not.
