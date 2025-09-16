# Untitled Note

Mirror SSD and spinning drive notes

4/27/2015 4:13:50 PM

Sympton:
 - After doing dd from ssd to spinning, compujter woudln't boot!  The first 446 bytes on the spinning drive had something causing a x0000007B (STOP) - Inacessable boot device.  To enable two bootable windows 7 systems, that first 446 (of the 512 MBR bytes) have to be cleared!

Resolution:
 - Do the DD to spinning.
 - Backup 512 on spinning
 - Clear 446 on spinning
 - Backup stores partition table on Spinning driver: if I change partition back it up again.
 - Restoration procedure:
\- 512 - on SSD or dropbox!
\- put back 512!
 - partprobe (reload partitions)
 - /dev/zero, 446 - (bs=446 count=1)
 - 

 ssd.mbr is 512 bytes from the harddrive.
