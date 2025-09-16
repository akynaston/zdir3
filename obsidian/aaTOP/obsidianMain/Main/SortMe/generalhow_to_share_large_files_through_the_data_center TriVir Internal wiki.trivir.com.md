# general:how_to_share_large_files_through_the_data_center [TriVir Internal] [wiki.trivir.com]

### Table of Contents

* [Customer uploads to TriVir's anonymous FTP server](https://wiki.trivir.com/doku.php?id=general:how_to_share_large_files_through_the_data_center&s[]=large&s[]=files#customer_uploads_to_trivir_s_anonymous_ftp_server)
	* [Sharing the file to the customer:](https://wiki.trivir.com/doku.php?id=general:how_to_share_large_files_through_the_data_center&s[]=large&s[]=files#sharing_the_file_to_the_customer)

* [Splitting Archives into Multiple Pieces](https://wiki.trivir.com/doku.php?id=general:how_to_share_large_files_through_the_data_center&s[]=large&s[]=files#splitting_archives_into_multiple_pieces)
* [Trivir's Virginia NAS](https://wiki.trivir.com/doku.php?id=general:how_to_share_large_files_through_the_data_center&s[]=large&s[]=files#trivir_s_virginia_nas)

# Customer uploads to TriVir's anonymous FTP server

The following instructions may be used to allow a customer to upload a file to Trivir's FTP server using an anonymous login. This is useful when the user is attempting to send a file that is to large for sending as an email attachment.

Here is the information the customer will need to be able to login to the data center and send large files.

1. The customer must configure their FTP client for PASV file transfers
	* Host name: [ftp.trivir.com](ftp://ftp.trivir.com/)
	* User name: anonymous
	* Password: <your trivir email address>

* Change directories to the /incoming directory
* Upload their file to the /incoming directory

Note:

* The customer will not be able to list the directory contents of the incoming directory before or after they send the file.
* Files may not be overwritten. If the customer has a failed upload, they may need to rename the file before they attempt to upload it again.

# Upload files to TriVir's FTP server

Here is the info you will need to be able to login to the data center and send large files.

1. Get WinSCP (or any other SFTP client) to be able to login. You can get it here: <http://winscp.net/eng/download.php> (if that link doesn't work you can just Search for WinSCP download on google).
2. Run the program and login with the following information:

* Host name: [ftp.trivir.com](ftp://ftp.trivir.com/)
* Port number 22
* Credentials: eDirectory Credentials (only works for SFTP)
* Protocol: SFTP with SCP for fallback

Click “Save” so you don't have to re-enter the information. Then click “Login”

Note: To share large files to customers, copy the file to:

/srv/ftp/outgoing/\[customer name\]/file

## Sharing the file to the customer:

You have two options to share the file to the customer: FTP, and HTTP.

Share the file as:

<http://ftp.trivir.com/outgoing/LeonCounty/LeonCounty-IDMDrivers-Release-7.zip>

or

<ftp://ftp.trivir.com/outgoing/LeonCounty/LeonCounty-IDMDrivers-Release-7.zip> (note: when using ftp, a username/password is no longer necessary.)

# Splitting Archives into Multiple Pieces

WinZip allows large archives to be split into multiple smaller pieces. This has several advantages, including:

1\.  If there is an error during the transfer, only the corrupt pieces need to be re-sent rather than the entire archive.
2.  If the transfer is interrupted - at worst you'll only need to restart the current piece rather than the entire archive.
3.  The recipient can begin downloading completed pieces as soon as they're ready instead of having to wait for the entire archive.
4.  The pieces can be sized to fit onto available media (CDs or DVDs).

In order to upload or download an archive split into multiple pieces, you'll need the following software:

* WinZip 11 - This is our corporate standard. More info can be found [here](https://wiki.trivir.com/doku.php?id=data_center_admin:winzip)
* GnuWin32 - Available at <http://gnuwin32.sourceforge.net/> . This provides a number of useful command line utilities including md5sum which can be used to verify the integrity of each piece of the archive.

**Warning, users have reported problems trying to reconstruct archives when using other software. 7zip, ZipGenius, etc. may not work.**

Creating the multi-piece archive:

1\.  Open WinZip and select File -> New Archive
2\.  Select a location for the new archive and give it a name (i.e. ExampleVM.zip).
    It's best to create this is a new clean folder.
3\.  An Add dialog should appear
    \*\* Just close it for now! \*\* (This add dialog doesn't allow you to select folders properly)
4\.  Drag the folder containing your VM into the WinZip window.
5\.  Another Add dialog should appear.
6\.  Next to "Split Zip file:" select one of the options, then click Add
    "700MB (sized for CD-ROM)" is a good balance.  Smaller pieces create a large number of files.  Larger pieces defeat the benefits described above.
7\.  If you get a warning about the compression method, just click "Yes"

WinZip will begin creating a number of files in the folder that you selected. The main file will have the name specified in step 2. Additional pieces will be named .z01, .z02, etc.

Create a new folder on the FTP server to hold all of the pieces of the archive. As soon as a .zXX file appears in windows explorer, you can begin uploading it (verify the size matches what was selected in step 6). Upload the main file (ExampleVM.zip) last - after WinZip has completed.

It is useful to include an md5sum hash so that the recipient can verify the integrity of each piece of the archive. It's also a good idea to include a list of the files and their sizes. Create and upload this file as soon as WinZip finishes creating all of the pieces - that way, anyone anxiously waiting to download the archive can grab this, see the expected file sizes, and determine if it's safe to begin downloading a piece.

To do this:

1\.  Open a Windows Command Prompt and CD to the directory containing all of the archive pieces.
2\.  Type "md5sum \*.z?? > md5sum.txt"
    Use whatever wildcard pattern you like.  The idea is to include the archive pieces and not anything else in the
    directory (including the md5sum.txt file you're creating)
3\.  Then type "dir >> md5sum.txt"
    This will append the directory listing to the file (be sure there are 2 >>'s)
4\.  Upload the md5sum.txt file to the same directory on the FTP server that holds the archive.      

To reconstruct a split archive:

1\.  Download all pieces of the archive.
    It's best to download them to a new clean folder.   All pieces must reside in the same directory as the main .zip file.
    You can begin downloading a piece as soon as it's size reaches the expected size given in the md5sum.txt file.
2\.  Verify the integrity of each piece by running md5sum against all of the pieces ("md5sum \*") and comparing that against the contents of md5sum.txt.
3\.  Extract the main file as you would any other archive.  So long as all the other pieces are in the same directory, WinZip will find them. 

# Trivir's Virginia NAS

1. Login with the following information:

* Host name: nas.trivir.com
* User name: trivir
* Password: rKmqnFaF
* Protocol: Use FTP
* Port: 21
* Select 'No encryption'

Click “Save” so you don't have to re-enter the information. Then click “Login”

For more information see [nas](https://wiki.trivir.com/doku.php?id=data_center_admin:nas)
