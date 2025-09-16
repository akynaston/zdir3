11/7/2024 11:16:17 AM
Nick Kohlep just asked about somne issue users:
my response to all of them including Farhan:
Nick,
Not a problem - In the future, feel free to include Farhan just so he's kept in the loop.
  
  
I found all 4 of those users sent a few days ago in the archive - Here is the list of files including the date, and the content they had when sent over.
  
Do we need to set up a call and see if there is something up with the transfer with UFM or encryption/decryption portion?
  
  
  
  
  
  
Here are the files, and when they were sent over:
  
userDocunet20241015173000.csv:20241015092349.474,,,x330814,,,,,,,,Contractor,,,?????,?????,,,,,add
userDocunet20241015173000.csv:20241015092349.905,03,Ground Operations,x330814,Melissa,Melissa,Escobar,,2WBN,INTL Agent CS/OPS/Weight & Balance - Non GSC,HDQ,Contractor,e25531,,?????,?????,,,A,,add
userDocunet20241015173000.csv:20241015100713.423,03,Ground Operations,x330814,Melissa,Melissa,Escobar,Melissa.Escobar@wnco.com,2WBN,INTL Agent CS/OPS/Weight & Balance - Non GSC,HDQ,Contractor,e25531,,?????,?????,,,A,,modify
userDocunet20241015183000.csv:20241015105218.479,03,Ground Operations,x330823,Shaiel,Shaiel,Castro,,2WBN,INTL Agent CS/OPS/Weight & Balance - Non GSC,HDQ,Contractor,e25531,,?????,?????,,,A,,add
userDocunet20241015193000.csv:20241016121213.818,03,Ground Operations,x330823,Shaiel,Shaiel,Castro,Shaiel.Castro@wnco.com,2WBN,INTL Agent CS/OPS/Weight & Balance - Non GSC,HDQ,Contractor,e25531,,?????,?????,,,A,,modify
userDocunet20241030123000.csv:20241030050626.524,,,x331426,,,,,,,,Contractor,,,?????,?????,,,,,add
userDocunet20241030123000.csv:20241030050626.950,03,Ground Operations,x331426,Alexis,Alexis,McPherson,,2CA1,INTL Agent CS/Ops - Non GSC,HDQ,Contractor,e69916,,?????,?????,,,A,,add
userDocunet20241030133000.csv:20241030061323.253,03,Ground Operations,x331426,Alexis,Alexis,McPherson,Alexis.McPherson@wnco.com,2CA1,INTL Agent CS/Ops - Non GSC,HDQ,Contractor,e69916,,?????,?????,,,A,,modify
userDocunet20241031183000.csv:20241031104939.979,03,Ground Operations,x331548,Kristie,Kristie,Rodrigues,,2CA1,INTL Agent CS/Ops - Non GSC,HDQ,Contractor,e69916,,?????,?????,,,A,,add
userDocunet20241031193000.csv:20241101120823.900,03,Ground Operations,x331548,Kristie,Kristie,Rodrigues,Kristie.Rodrigues@wnco.com,2CA1,INTL Agent CS/Ops - Non GSC,HDQ,Contractor,e69916,,?????,?????,,,A,,modify

copy i did . .
cp archive/userDocunet20241015173000.csv ~
cp archive/userDocunet20241015183000.csv ~
cp archive/userDocunet20241015193000.csv ~
cp archive/userDocunet20241030123000.csv ~
cp archive/userDocunet20241030133000.csv ~
cp archive/userDocunet20241031183000.csv ~
cp archive/userDocunet20241031193000.csv ~




11/7/2024 11:26:17 AM
Found 1258 files, none sent since midnight on September 16th due to UFM returning error '22' . . 

```

2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 74] ^[[32mINFO^[[m -      Direction            = send
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 75] ^[[32mINFO^[[m -      ENV + Hangar         = prod1
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 76] ^[[32mINFO^[[m -      Path                 = /opt/IDMFeeds/IDtoDocunet/ufm/.*.csv.gpg
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 78] ^[[32mINFO^[[m -      PartnerPath          = /sftp-vistair-com/SWA_PROD
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 82] ^[[32mINFO^[[m -      Delete               = y
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 83] ^[[32mINFO^[[m -      Type                 = swaPushToPartner
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 84] ^[[32mINFO^[[m -      AlertLevel           = High
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 85] ^[[32mINFO^[[m -      Schedule(cron)       = 0 00 */4 ? * * *
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 86] ^[[32mINFO^[[m - Cyberark Information:
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 87] ^[[32mINFO^[[m -      AppID                 = SWAAPP-IDM
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 88] ^[[32mINFO^[[m -      Safe                  = AIM-PROD-UFM-IDM
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 89] ^[[32mINFO^[[m -      AccessKeyObject       = Application-AWSUnmanaged-ufmprod-docunet-put-access
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 90] ^[[32mINFO^[[m -      SecretKeyObject       = Application-AWSUnmanaged-ufmprod-docunet-put-secret
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 91] ^[[32mINFO^[[m - General Output Below - Transfer specific log = ft-docunet-vistair-prod1-idtodocunet-output-send.log
2024-09-15 20:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 92] ^[[32mINFO^[[m - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
2024-09-15 20:00:06 [UFM] [biz.capitalware.ufm.actions.FMAction] [Line: 22] ^[[32mINFO^[[m -
2024-09-15 20:00:06 [UFM] [biz.capitalware.ufm.actions.FMAction] [Line: 23] ^[[32mINFO^[[m - delete_old_archive_files.sh action now being performed.
2024-09-15 20:00:06 [UFM] [biz.capitalware.ufm.actions.FMAction] [Line: 24] ^[[32mINFO^[[m - User Supplied parameters:
2024-09-15 20:00:06 [UFM] [biz.capitalware.ufm.handlers.RunJob] [Line: 190] ^[[32mINFO^[[m - CMD: [/swa/opt/idmfiles/scripts/delete_old_archive_files.sh, -e, 22, /opt/IDMFeeds/IDtoDocunet/archive/, 120]
2024-09-15 20:00:06 [UFM] [biz.capitalware.ufm.handlers.RunJob] [Line: 211] ^[[32mINFO^[[m - <Output> ERROR: the second parmeter was not zero, it was: [22], meaning that the UFM operation attempted failed! not continuing from here, returning with UFM return code.
2024-09-15 20:00:06 [UFM] [biz.capitalware.ufm.handlers.RunJob] [Line: 224] ^[[32mINFO^[[m - External program for 'null' terminated.
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.actions.S3Action] [Line: 90] ^[[32mINFO^[[m - {STDOUT=STDOUT, ufm_appender=ufm_appender}
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.actions.S3Action] [Line: 106] ^[[32mINFO^[[m - logPath value is: ../logs
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 42] ^[[32mINFO^[[m - ======================================================================
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 43] ^[[32mINFO^[[m - UFM version 422 is now starting.
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 45] ^[[32mINFO^[[m - System Information:
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 48] ^[[32mINFO^[[m -      OS                   = Linux
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 49] ^[[32mINFO^[[m -      user.name            = edir
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 50] ^[[32mINFO^[[m -      user.dir             = /swa/opt/UFM/bin
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 51] ^[[32mINFO^[[m -      Hostname             = w11pcledirpi010.swacorp.com
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 52] ^[[32mINFO^[[m -      UseFileLocking       = true
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 53] ^[[32mINFO^[[m -      OwnerDashGroup       = Cybersecurity-Engineering Operations
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 54] ^[[32mINFO^[[m -      RunningAsDaemon      = true
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 55] ^[[32mINFO^[[m -      UFMVersion           = 422
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 63] ^[[32mINFO^[[m - Transfer Information:
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 67] ^[[32mINFO^[[m -      Standby              = false
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 69] ^[[32mINFO^[[m -      AppName              = docunet
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 70] ^[[32mINFO^[[m -      SendAppName          = docunet
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 71] ^[[32mINFO^[[m -      PayloadDescription   = swa-initiated
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 73] ^[[32mINFO^[[m -      PartnerName          = vistair
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 74] ^[[32mINFO^[[m -      Direction            = send
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 75] ^[[32mINFO^[[m -      ENV + Hangar         = prod1
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 76] ^[[32mINFO^[[m -      Path                 = /opt/IDMFeeds/IDtoDocunet/ufm/.*.csv.gpg
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 78] ^[[32mINFO^[[m -      PartnerPath          = /sftp-vistair-com/SWA_PROD
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 82] ^[[32mINFO^[[m -      Delete               = y
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 83] ^[[32mINFO^[[m -      Type                 = swaPushToPartner
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 84] ^[[32mINFO^[[m -      AlertLevel           = High
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 85] ^[[32mINFO^[[m -      Schedule(cron)       = 0 00 */4 ? * * *
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 86] ^[[32mINFO^[[m - Cyberark Information:
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 87] ^[[32mINFO^[[m -      AppID                 = SWAAPP-IDM
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 88] ^[[32mINFO^[[m -      Safe                  = AIM-PROD-UFM-IDM
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 89] ^[[32mINFO^[[m -      AccessKeyObject       = Application-AWSUnmanaged-ufmprod-docunet-put-access
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 90] ^[[32mINFO^[[m -      SecretKeyObject       = Application-AWSUnmanaged-ufmprod-docunet-put-secret
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 91] ^[[32mINFO^[[m - General Output Below - Transfer specific log = ft-docunet-vistair-prod1-idtodocunet-output-send.log
2024-09-16 00:00:00 [UFM] [biz.capitalware.ufm.other.GeneralInfo] [Line: 92] ^[[32mINFO^[[m - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
2024-09-16 00:00:07 [UFM] [biz.capitalware.ufm.actions.FMAction] [Line: 22] ^[[32mINFO^[[m -
2024-09-16 00:00:07 [UFM] [biz.capitalware.ufm.actions.FMAction] [Line: 23] ^[[32mINFO^[[m - delete_old_archive_files.sh action now being performed.
2024-09-16 00:00:07 [UFM] [biz.capitalware.ufm.actions.FMAction] [Line: 24] ^[[32mINFO^[[m - User Supplied parameters:
2024-09-16 00:00:07 [UFM] [biz.capitalware.ufm.handlers.RunJob] [Line: 190] ^[[32mINFO^[[m - CMD: [/swa/opt/idmfiles/scripts/delete_old_archive_files.sh, -e, 22, /opt/IDMFeeds/IDtoDocunet/archive/, 120]
2024-09-16 00:00:07 [UFM] [biz.capitalware.ufm.handlers.RunJob] [Line: 211] ^[[32mINFO^[[m - <Output> ERROR: the second parmeter was not zero, it was: [22], meaning that the UFM operation attempted failed! not continuing from here, returning with UFM return code.
2024-09-16 00:00:07 [UFM] [biz.capitalware.ufm.handlers.RunJob] [Line: 224] ^[[32mINFO^[[m - External program for 'null' terminated.

```



On November 7th, we were notified that files haven't been synchronizing to Docunet since September 16. It turns out the last successful send was on September 16 - UFM was returning errorcode 22, and stopped sending files, leavning 1258 unprocessed files.

The log above was on w11pcledirpi010 in /opt/UFM/logs/UFM.log

I found to manually execute a send, I ran 
cd /opt/UFM/bin
./UFM64.sh idtodocunet.json

And the upload appeared to work properly: files are being upload

