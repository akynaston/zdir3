Chandu  trying to run collection scr9ipts:


Chandu showing location of drop file l. . .
![[Pasted image 20250828120845.png]]

didn't run last night at 6 as he expected.
w11qclmya

instructions:
![[{444BFFEE-21F8-41F9-925E-F18FCAA08657}.png]]
if on qa1 and qa2
006 and stg001

drop files to both servers if apps on both servers:
![[{58A0D6C1-EBE3-4D18-B217-907D7530BB8E}.png]]

QA1 server:
This server is for both - and ufm stuff:
![[Pasted image 20250828122021.png]]

Apparently, this is where both qa1 and qa2 get their files . .

taylor: would run ufm64.sh on this server . . 
then megescript running here . .

location of receive files - qa/dev/prod repository of files . . 
![[{CAD28897-9529-4B63-8670-08EE27564352}.png]]


steve
xlqmya06 - merge script here when running in ONLY QA2.
steve - used to just execute here . .but now need to execute in appropariate envionrment 1 or 2 . .

stg001 - no ufm setup here on staging, because all should be going through mya001 . .

Steve didn't know ufm was here:
![[Pasted image 20250828124953.png]]