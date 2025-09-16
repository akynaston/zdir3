# $> rsync over SSH to rooted android device ... [www.sesser.eu]

## rsync over SSH to rooted android device ...

* * *

\*) rooting your android device ist not covered in this howto!
	
1) requirements:

	rsync on source device (e.g. linux, macos, ...) 
	ssh server on android (e.g. SSHDroid)
	shell access to your android device


2) get rsync for android

	I didn't found any native rsync binary for my Samsung Galaxy SII, but ...
	with "rsync backup for Android" I get it working.

	Install it:	http://android.kowalczuk.eu/rsync4android/
			https://play.google.com/store/apps/details?id=eu.kowalczuk.rsync4android


3) symlink rsync binary
	
	native rsync from linux to android doesn't work yet, because rsync binary isn't in $PATH
	You can add the new rsync directory to your path variable.
	It is located here: /data/data/eu.kowalczuk.rsync4android/files/rsync
	# PATH=$PATH:/data/data/eu.kowalczuk.rsync4android/files/	# not tested!!

	alternatively you can add a symlink:

	# cd /sbin
	/sbin # touch test
	touch: test: Read-only file system	# here is a problem

	/sbin # mount | grep ro
	rootfs on / type rootfs (ro,relatime)	# root partition is mounted in read-only mode

	/sbin # mount -o remount,rw -t rootfs rootfs /
	/sbin # ln -s /data/data/eu.kowalczuk.rsync4android/files/rsync rsync
	/sbin # mount -o remount,ro -t rootfs rootfs /
	/sbin # exit


\*) test

	$ rsync -Ltrv --size-only --delete /home/sem/manuals/ -e ssh root@192.168.0.1:/sdcard/data/manuals/
		

* * *

by Markus Sesser
