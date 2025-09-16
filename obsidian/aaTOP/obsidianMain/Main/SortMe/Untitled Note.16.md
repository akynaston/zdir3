# Untitled Note

#reading group

9/4/2019 1:25:31 PM

Potential Reading Group OptionsBooks:
\- Crucial Conversations
\- Great by Choice
\- EssentialismVideos:
\- Linked in Learning Videos
\- Vulnerability -  <https://www.ted.com/talks/brene_brown_on_vulnerability?language=en>Training:
\- Docker training: <https://docs.docker.com/get-started/>
\- Linked in Learning Search:  <https://www.linkedin.com/learning/search?keywords=docker&u=2241162>
\- Prometheus
\- AnsibleWe decided we would do the Docker training together.
<https://docs.docker.com/get-started/> 

2/23/2021 6:16:43 PM

GPG reading group

reading group
2/17/2021 12:08:09 PM
\- set up smart card (OpenPGP) applet on yubikey
\- move subkeys
\- gpg --card-edit
ccccccvdlufrdhjbevnibvnveeetdrhtkbeebileurrj

yubikey manager
ykman openpgp reset - resets what we do today

\- next
can store url of public key
singaure pin - not forced . .

admin pin: required to make changes to the card

C:\\Users\\akynaston>gpg --list-secret-key
C:/Users/akynaston/AppData/Roaming/gnupg/pubring.kbx
\----------------------------------------------------
sec   rsa4096 2021-02-03 \[SC\]
      7A7B56A3CC9C4F40D1C4584EC5F19760CDF6EEC8
uid           \[ultimate\] Aaron Kynaston (First GPG key test) <[akynaston@trivir.com](mailto:akynaston@trivir.com)\>
ssb   rsa4096 2021-02-03 \[E\]
ssb   rsa4096 2021-02-03 \[S\]
ssb   rsa4096 2021-02-03 \[A\]

C:\\Users\\akynaston>

drduh - has options for moing keys
\- keytocard failed unsable secret key
\- didn't have my secrent . .
\- gpg --card-status
git

the key id is list-keys result
user.signingkey=7A7B56A3CC9C4F40D1C4584EC5F19760CDF6EEC8
gpg.program - location of gpg.exe

optional: will atempt to sign every commit.
comit.gpgsign=true

git commit -S -m "my commit"

can sign commits or tags

git commit -s is a lower case signed auth byvs signed

in any vm use yubickey for signing:
     - edit vmx file:
     - shut down and close vm before editing vmx file
     - usb.generic.allowHID = "TRUE"
     - usb.generic.alowLastHID = "TRUE"
base centos - vmx file
     - yubikey discinnect from host
     - open host - gpg --card-status
     - should see everything
     - default on centos 7
         - gpg --version
         - is 2.0.22
         - have to have gpg 2.0.22 to work with yubikey
         - gpg interwoven into operating system.
     - Jeremiah had to do some work to get gpg instlalation in
     - had to installsecond version of gpg
     - bash\_profile
        add to the path
         - /opt/gnupg22/bin
         or alias but didn't work for jeremiah

     -  in ~/.gnupg
         - had to edit gpg-ageng.conf
         - pinetry-program /usr/bin/pinetry-gtk-2
gpg --clearsign
plan is to mirror gpg info the smae as git settings info, shared into vm
\- have gpg and git shared to vm

\- Huston made some modifiations . .

Any new vm you do this with:
     - need to import your public key as trusted into your gpg install on the vm.
     - Jeremian has shared folder on the nas - gpg keys
     - signing email works better with piv better than with pgp
     - piv already set up to trust
revocation - is an option
     - only works if uploaded key to

trust another key

\- gpg --import jeremiah\_publickey.gpg
gpg --list-secret-key
