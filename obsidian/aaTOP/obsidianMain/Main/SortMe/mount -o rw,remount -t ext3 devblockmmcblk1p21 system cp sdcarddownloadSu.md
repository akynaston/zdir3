# mount -o rw,remount -t ext3 /dev/block/mmcblk1p21 /system cp /sdcard/download/Su

mount -o rw,remount -t ext3 /dev/block/mmcblk1p21 /system
cp /sdcard/download/Superuser.apk /system/app/Superuser.apk
cp /sdcard/download/su /system/bin/su
cp /sdcard/download/busybox /system/bin/busybox
chmod 4755 /system/bin/su
chmod 4755 /system/bin/busybox
mount -o ro,remount -t ext3 /dev/block/mmcblk1p21 /system
exit
