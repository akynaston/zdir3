# Untitled Note

#FCPS - RL Upgarde steps

Chip:
 For each of the 7 domain controllers in production:
 Follow the instructions from the remote loader upgrade document located at: https://docs.google.com/document/d/1wW4AUE1h-jw13ao\_4Xd63D9CapeqCRjEYayNHiJxAZg/edit#.
     - Chip will be working from a copy of this file.
1 - Download all required upgrades for the 7 DC's.
2 - Download  the updated password sync files from https://goo.gl/KymWwy (zip file: IDM45PasswordFilterFiles.zip)
3 - Move PwFilter.dll and psevent.dll to another directory.
4 - Copy all files from IDM45PasswordFilterFiles.zip into C:\\Windows\\System32.
5 - Update the remote loader server names as mentioned in the documentation.
     - Note: Feel free to test the password sync gui, it should save time; otherwise feel free to continue modifying the registry directly.
6 - Reboot the DC.
7 - Coordinate password change tests with Aaron.

Aaron:
(Following steps for internal notes at:  https://goo.gl/SKADiu

8 - Update the Staff and Student AD and PowerShell IP addresses (four updates to point to the three new remote loaders).
9  - Connect the drivers to the new remote loaders.
10  - Do basic connection plumbing tests (except for password sync.)
When Chip is completed updating all 7 DC's:
11 - Wait for Chip to change passwords in DC
12 - Confirm password changes come through both remote loaders; and they are processed/vetoed as appropriate as only one remote loader processes password changes.
13 - Notify Jackie she can begin her testing.

Jackie:
14 - Create a new employee or non employee, and see user created through the system.
15 - Confirm Mailbox was created for user.
16 - Confirm password was synchronized to the new account; or change password in eDir and see it sync to AD.
17 - Change password for the user in AD, see it sync to eDirectory.
18 - Notify team testing is complete.

At this point, we'll all go into a monitor state and resolve issues as they come up.

ABOUT ONE TO TWO WEEKS LATER:

Chip:
When Chip decides the timing is right (aka the new remote loaders are working fine):
19 - Remove the two old remote loaders (IDMRLUSER and IDMSTUADRL) from the host names list on all 7 DCs.
     - Chip, per our discussion, you can do this work over several days if needed; remembering to reboot the DCs that have had the old remote loaders removed.
20 - Check password caches to ensure they are cleaning out properly (ideally, we'd have empty caches; though anything under 300 would be considered healthy).
