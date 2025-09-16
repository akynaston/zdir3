# Mount shadow copy in wsl

Create shadow through powershell, mapp to normal dir, then use drv fs to show it.

mount -t drvfs 'C:\\shadow0' /mnt/shadow0
