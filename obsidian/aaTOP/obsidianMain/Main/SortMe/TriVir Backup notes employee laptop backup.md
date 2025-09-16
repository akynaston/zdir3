# TriVir Backup notes: employee laptop backup

Considerations and aproaches to next steps:

Priorities
1 - take step back: survey of options
2 - Backing up important data
    VMs
    Project documents
3 - Ultimate solution: Clone style backups
     - storage and time cost
     - reduandacy vs backup?
4 - Restore quickly?
5 - Restore granularly?

I see three types of backups:
 - Fully using some 3rd party backup for full+partial backup/restores.
 - cloning/dd to second drive, then maintain with rsync on a regular basis.
 - Keeping at least a second bootable drive, then maintaining with rsync on a regular basis.

What data should be backed up? If the goal is to get back up and running as soon as possible, here are good items to back up/or at least have on hand:
 - VMs
 - The ability to boot
 - Applications and their associated configuration
 - It is assumed all of your code is checked in.
