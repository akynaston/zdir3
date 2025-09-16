# Backup WSL

<https://help.ubuntu.com/community/BackupYourSystem/TAR>

Essentially this:
tar -cvpzf /mnt/c/t/wslBackup.tar.gz --exclude=/backup.tar.gz --one-file-system /
