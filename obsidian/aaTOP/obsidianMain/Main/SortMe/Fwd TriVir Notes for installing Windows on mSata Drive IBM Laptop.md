# Fwd: [TriVir] Notes for installing Windows on mSata Drive IBM Laptop

\---------- Forwarded message ----------
From: **Carl Kynaston** <[carlkynaston@gmail.com](mailto:carlkynaston@gmail.com)\>
Date: Tue, Feb 4, 2014 at 2:30 PM
Subject: \[TriVir\] Notes for installing Windows on mSata Drive IBM Laptop
To: [akynaston@gmail.com](mailto:akynaston@gmail.com)

Took out the battery
Unscrewed all the screws on the bottom with a little keyboard pic next to it.
On the top side of the keyboard, I popped off the plastic power button cover area from the top.
I pushed the keyboard forward by the tabs that are on the otto.
Removed black cover
Removed screw
Pushed in SSD
Tightened screw
Replaced black cover
pushed keyboard in back first and pushed the tabs in in the front.
Made sure keyboard was snug.
Attached plastic powerutton cover by sliding in bottom first and then clicking in.

Backup hard disk
Erase hard disk (If you don't do this, Windows has problems seeing the other installation and screws up.)
install Windows on SSD
Restore data to hard disk

Page File fix:
To reduce the number of write cycles on the msata drives, move the Windows page file to your spinning drive (instructions are for XP, but Windows 7 is the same process): <http://support.microsoft.com/kb/307886>

User Docs to hard drive:
In order to have all your user documents on the spinning drive by default, redirect your user directories (i.e. c:\\users\\<username>\\\*) to a location on the spinning drive: <http://windows.microsoft.com/en-US/windows7/Redirect-a-folder-to-a-new-location>
         \* NOTE: This operation has to be repeated for every folder in c:\\users\\<username>. I belive the only file that can't be moved to another drive is the AppData directory which needs to remain on the C drive.

Evernote helps you remember everything and get organized effortlessly. [Download Evernote](https://www.evernote.com/getit?email_name=emailNote&email_guid=d951e5dc-5fc4-4e29-9537-d70cf62aec53&email_link=download_app).
