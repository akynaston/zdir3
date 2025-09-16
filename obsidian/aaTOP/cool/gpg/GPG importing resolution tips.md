4/24/2024 4:47:34 PM
importing private keys can be problematic: 

Some times, you have to manually create the private keys dir:

mkdir -p ~/.gnupg/private-keys-v1.d
chmod 700 ~/.gnupg/private-keys-v1.d

then import it as a batch operation:


[edir@w11dcledirdi013 ~/ufm-idtodocunet/gpg]$ cat trivirtemptestkey.asc  | gpg --batch --import
gpg: key EDFFDD9D27D182E9: "tempkey (tempkey payload test) <test@wnco.com>" not changed
gpg: key EDFFDD9D27D182E9: secret key imported
gpg: Total number processed: 1
gpg:              unchanged: 1
gpg:       secret keys read: 1
gpg:   secret keys imported: 1
[edir@w11dcledirdi013 ~/ufm-idtodocunet/gpg]$
