Perl to pretty rpint an ldap filter . . .
https://gist.github.com/blaxter/60ef4836f341df0cd183

See it run here:
https://www.tutorialspoint.com/execute_perl_online.php

```
|   |
|---|
|#! perl -slw|
||use strict;|
|||
||( my $input = do{ local $/; <DATA> } ) =~ tr[\n][]d;|
|||
||my $tab = 0;|
||$input =~ s[([()])]{|
||$tab-- if $1 eq ')';|
||my $modified = "\n" . ( " " x $tab ) . $1;|
||$tab++ if $1 eq '(';|
||$modified;|
||}ge;|
||$input =~ s[\n\s+\)][)]g;|
|||
||print $input;|
|||
||__DATA__|
||(& (mailnickname=*) (\| (&(objectCategory=person)(objectClass=|
||user)(!(homeMDB=*))(!(msExchHomeServerName=*)))(&(objectCategory=person)(obje|
||ctClass=user)(\|(homeMDB=*)(msExchHomeServerName=*)))(&(objectCategory=person)|
||(objectClass=contact))(objectCategory=group)(objectCategory=publicFolder)(obj|
||ectCategory=msExchDynamicDistributionList) ))|

```