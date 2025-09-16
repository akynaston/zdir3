CONTEXT:  
================================  
The IDtoDocunet driver is a CSV flat file output driver that runs on **w11pcledirpi010**. This driver went live June 3rd, 2024. After the driver writes out a file (about 1 every hour), it relies on a UFM process that runs every 4th hour to copy those files to a client server. Since this go live date, the UFM process has completely failed 3 times. Once in September, once in February, and once again on March 17. 

UFM HEALTH MONITORING STATUS:  
================================  
I am working with a team to get the proper monitoring in place, but that isn't completed yet. In the meantime, I've set up a temporary non-standard notification that will at least email me the file counts in the /opt/IDMFeeds/IDtoDocunet/ufm directory. Since the UFM process is supposed to run every 4 hours, there should never be more than 4, or in some rare cases 5 files in that directory, depending on timing. For this reason, I have added a cronjob as my user x266698 user account that just sends a file count of that directory every 4 hours. This is not a standard way to monitor, but I had to have some way to keep an eye on this immediately.

![](/sys_attachment.do?sys_id=67a9a766c39866d8d8c2300f05013150)

Text version of image above:  
===============================  
[x266698@w11pcledirpi010 ~]$ crontab -l  
#every morning at 12 midnight, send count of total files to aaron until we can get a real monitoring solution  
00 */4 * * *  ls -rlth /opt/IDMFeeds/IDtoDocunet/ufm | wc -l | mail -s docunet-file-count aaron.kynaston@wnco.com  
[x266698@w11pcledirpi010 ~]$  
  

Any time that file count is > 4 or 5 or so, there is likely an issue in progress. Since the cron job runs every 4th hour on the hour, there should be a maximum of only 4 files . sometimes 5 if the driver happens to sneak in another file.  However, if this total grows past 5, then we know there is an issue. I suspect I should probably eventually remove the cronjob as it can be invisible and easily forgotten; but will leave it in place until we have a working monitoring process.

ISSUES AND METHODS USED TO FIX SO FAR:  
================================  
I've seen two kinds of issues.  An odd UFM error 22 simply starts to come back from the UFM process, and another where the UFM process simply stops.

Error 1:   Error '22' - I don't know what this error means, still working on that. My UFM postscript called delete_old_archive_files avoids deleting archive files if the return code from UFM is non zero.  The '-e, 0' parameter seen in the logs is what I'm referring to. During one of the issues we had, I saw that UFM was sending a '-e, 22' to my script meaning that it could not proceed with archive cleanup.

This is an example of a successful return code from the /opt/UFM/logs/UFM.log, where my script was being called, note the '-e, 0,'"  
```  
**CMD: [/swa/opt/idmfiles/scripts/delete_old_archive_files.sh, -e, 0, /opt/IDMFeeds/IDtoDocunet/archive/, 120]**  
```

This is an example of the return code value of 22; which is sent to my delete_old_archive_file, so I can check the return code before cleaning the archive.  
```  
**CMD: [/swa/opt/idmfiles/scripts/delete_old_archive_files.sh, -e, 22, /opt/IDMFeeds/IDtoDocunet/archive/, 120]**  
```

Error 2: UFM Process is stopped:  The UFM process was simply found to not be in memory any more; meaning it must have crashed, or server rebooted without restarting UFM.  On March 15 during the most recent error, I saw the file count increase again so I knew there was a problem. The file count is constantly increasing from the driver's perspective, it's UFM that clears out the UFM directory at /opt/IDMFeeds/IDtoDocunet/ufm.

Also, I had checked the uptime on the server, and saw that it was likely a reboot that caused this problem . .but this is a guess.

![](/sys_attachment.do?sys_id=54e9eba6c39866d8d8c2300f050131de)

  
DIAGNOSING THE ISSUE:  
================================  
There are typically two processes (PIDS) that run on this server when UFM is operating properly:

This is an example of a failed listing, calling   
/opt/UFM/bin/run_transfers -l:

![](/sys_attachment.do?sys_id=d2f9a7e6c39866d8d8c2300f0501311c)

Here is a screenshot of the source directory at /opt/IDMFeeds/IDtoDocunet/ufm - when there is a problem. This screen shot shows that there are more than 4 files in  this directory:

![](/sys_attachment.do?sys_id=2e2a672ac39866d8d8c2300f05013155)

You can also see logs of the process here:  
![](/sys_attachment.do?sys_id=a63aa36ac39866d8d8c2300f050131e9)

The interesting files are UFM.log which is a general log, and the ft-docunet-vistair-prod1-idtodocunet-outgoing-send.log. Right now, these files seem to simply stop sending out data due to the error #2, the sudden crash that seemed to happen today. Normally both of these files would have the timestamp of the most recent 4 hour execution (midnight, 4 am, 8 am, 12 pm, 4 pm, 8 pm are the run times). Note: UFM.log contains the '-e, 0' portion if you are looking for that data.

RESOLUTION OF THE ERROR  
================================

I've done two separate tasks to resolve the problem. I would start with #1, then only use 2 if needed.

1 - Less invasive: Manually ran the UFM process for Docunet. which seemed to resolve the 'error 22', and UFM seemed to be running properly. UFM seemed to properly process automatically during the next 4 hour window, again I do not not why.  
2 - Slightly more invasive: Remove, and re-add the docunet config from UFM which seemed to resolve the crashing UFM issue.

=============  
To do #1, run this command:

First, go into the /opt/UFM/bin directory then run:  
UFM64.sh idtodocunet.json

  
This is the command that tells the UFM process to send the data now.

=============  
To do #2, run this 3 step command. It'll remove the current config, adds it back, and then lists all the processes, which should then show two PIDS as the result of the  'run_transfers.sh -l' call: 

First, go into the /opt/UFM/bin directory then run:

./run_transfers.sh -k -f ./idtodocunet.json && ./run_transfers.sh -f ./idtodocunet.json && ./run_transfers.sh -l

OTHER INFORMATION:  
================================  
UFM jobs are configured by submitting a JSON document, this is the one for the IDtoDocunet driver output files:

![](/sys_attachment.do?sys_id=226aaf6ac39866d8d8c2300f05013145)

Text version:  
```  
{  
    "transfer": [  
        {  
            "appName": "docunet",  
            "partnerName": "vistair",  
            "direction": "send",  
            "payloadDescription": "idtodocunet-output",  
            "sendAppName": "docunet",  
            "path": "/opt/IDMFeeds/IDtoDocunet/ufm/.*.csv.gpg",  
            "delete": "y",  
            "transferType": "",  
            "version": 7,  
            "env": "prod",  
            "hangar": 1,  
            "schedule": {  
                "minute": "00",  
                "hour": "*/4",  
                "dayOfWeek": "*",  
                "dayOfMonth": "",  
                "month": "*",  
                "year": ""  
            },  
            "postscript": {  
                "command": "/opt/idmfiles/scripts/delete_old_archive_files.sh",  
                "param": [  
                    "/opt/IDMFeeds/IDtoDocunet/archive/",  
                    "120"  
                ],  
                "thread": "y"  
            },  
            "dashGroup": "Cybersecurity-Engineering Operations",  
            "cyberarkAccessKey": {  
                "cyberarkAppId": "SWAAPP-IDM",  
                "cyberarkRoot": "Root",  
                "cyberarkObject": "Application-AWSUnmanaged-ufmprod-docunet-put-access",  
                "cyberarkSafe": "AIM-PROD-UFM-IDM"  
            },  
            "cyberarkSecret": {  
                "cyberarkAppId": "SWAAPP-IDM",  
                "cyberarkRoot": "Root",  
                "cyberarkObject": "Application-AWSUnmanaged-ufmprod-docunet-put-secret",  
                "cyberarkSafe": "AIM-PROD-UFM-IDM"  
            },  
            "type": "swaPushToPartner",  
            "partnerPath": "/sftp-vistair-com/SWA_PROD",  
            "maxFileAge": 0  
        }  
    ]  
}

```

Extra notes: when we have a final official monitoring on this, these are the people who should be included in the notification

Current notification list:  
Aaron.Kynaston@wnco.com  
CentralPubsAutomationSupport-DG - Application owner's DG  
gerald.dunn@wnco.com - Interested in the status

CybersecurityOperations-DG@wnco.com - Ops DG