3/27/2025 11:40:58 AM - update: I made more changes, then clicked 'ready for review', and now it's published . . ?? lol - anywho, it looks like it's reayd to go, so I'm considering this task done.


3/17/2025 11:46:12 AM

KB0115345: New KB, to cover IDtoDocunet UFM monitoring: 
https://southwest.service-now.com/nav_to.do?uri=%2Fkb_knowledge.do%3Fsys_id%3D2e88da92c3982e18a6cd1e53e4013111%26sysparm_view%3D%26sysparm_domain%3Dnull%26sysparm_domain_scope%3Dnull

TITLE:
================================
UFM failure explanation and resolution to copy files from IDtoDocunet out to the destination client servers.

CONTEXT:
================================
The IDtoDocunet driver is a CSV flat file output driver that runs on **w11pcledirpi010**. This driver went live June 3rd, 2024. After the driver writes out a file (about 1 every hour), it relies on a UFM process that runs every 4th hour to copy those files to a client server. Since this go live date, the UFM process has completely failed 3 times. Once in September, once in February, and once again today, March 17. 

REASON FOR KB & KNOWLEDGE TRANSFER SESSION:
================================
I've just been covering this myself for the last two times, and realized I should probably make this an official Ops item that is carefully monitored and that we have a KB for Ops to know what to do when this occurs.

MONITORING STATUS:
================================
I am working with a team to get the proper monitoring in place, but have not yet seen a response from them. In the mean time, I've set up a temporary non-standard notification that will at least email me the file counts in the /opt/IDMFeeds/IDtoDocunet/ufm directory. Since the UFM process is supposed to run every 4 hours, there never should be more then 4, or in some rare cases 5 files in that directory. For this reason, I have setup a cronjob as the x266698 user account that just sends a file count of that directory every 4 hours:

![[Pasted image 20250317120630.png]]

Text version of image above:
================================
```
[x266698@w11pcledirpi010 ~]$ crontab -l
#every morning at 12 midnight, send count of total files to aaron until we can get a real monitoring solution
00 */4 * * *  ls -rlth /opt/IDMFeeds/IDtoDocunet/ufm | wc -l | mail -s docunet-file-count aaron.kynaston@wnco.com
[x266698@w11pcledirpi010 ~]$
```

Any time that file count is > 4 or 5 or so, I know there's a issue going on, since files are created every hour on the half hour.  Since the cronjob runs every 4 on the hour, there should be a maximum of only 4 files . .sometimes 5 if the driver happens to sneak in another file.  However, if this total grows past 5, then we know there is an issue. I believe I should not leave this cronjob here, I see this as an undesirable, but successful way to stay notified of this issue until the proper channels work successfully. **I am happy to move it to another account as needed; but I need something in place that works right now, so I'll leave at least this much in place.**

Current notification list:
Aaron.Kynaston@wnco.com (this is me . .should probably remove eventually . . .)
CentralPubsAutomationSupport-DG - Application owner's DG
gerald.dunn@wnco.com - Monitoring personnel helping with the error.



ISSUES AND METHODS USED TO FIX SO FAR:
================================
I've seen two kinds of issues.  An odd UFM error 22 that simply starts to come back from the UFM process, and another where the UFM process seems to simply stop.

**1 - Error '22' -** I don't know what this means, but my  delete_old_archive_files script runs as a UFM postscript, and we pass the return code from UFM using the '-e 0' parameter so that my cleanup script will avoid removing any archives until we know we can successfully send files. In December,  When I heard files were not transferring since September, I found the return code was 22, so the command line appeared as '-e, 22,' below.  I don't know what a UFM 22 return code is, and have been unable to find any documentation:

This is an example of a successful return code from UFM, where my script was being called, note the '-e, 0,'"
```
CMD: [/swa/opt/idmfiles/scripts/delete_old_archive_files.sh, -e, 0, /opt/IDMFeeds/IDtoDocunet/archive/, 120]
```

This is an example of the return code value of 22; which is sent to my delete_old_archive_file, so I can check the return code before cleaning the archive.
```
CMD: [/swa/opt/idmfiles/scripts/delete_old_archive_files.sh, -e, 22, /opt/IDMFeeds/IDtoDocunet/archive/, 120]
```


**2 - UFM Process crashed:** The UFM process was simply found to not be in memory any more; meaning it must have crashed.  The only reason I know this was that I email myself the number of files not yet sent to docunet . .if it ever goes above 8 or so in a 12 hour period, I know there's a problem. I've fixed this problem by just manually running the send to send over the files immediately. I used this when we were a few thousand files behind, and, while it took a while to complete, it seemed to resolve the error 22. The next 4 hour window for the process to run seemed to successfully send files again; **though I do not now why!**  Please note, I did just realize that the server may have been rebooted . .which seems as if the UFM process does not properly load on a reboot maybe?

![[{E3321131-9C03-44F5-BBFF-E4C3A213830A}.png]]




DIAGNOSING THE ISSUE:
================================
There are typically two processes (PIDS) that run on this server when UFM is operating properly:

This is an example of a failed listing, calling 
/opt/UFM/bin/run_transfers -l:

![[{F664CC02-52DD-444C-8288-D3AE306C9F10}.png]]

Also, you can see the source directory at /opt/IDMFeeds/IDtoDocunet/ufm to see what files are ready to send. You can see there are 13 files here, which means the email notification I received this morning showed about 15 files, due to the 'wc -l' call including the 'total 56K' and other metadata; and showed me there was an error. This is an example of a problem. This is the directory where a maximum of only 4 or 5 files should reside:

![[{EC662BB6-57B0-4745-B27F-3D4D4CCB8090}.png]]

You can also see logs of the process here:
![[{C375F797-295E-4984-AA9A-FE4033E7E042}.png]]

The interesting files are UFM.log which is a general log, and the ft-docunet-vistair-prod1-idtodocunet-outgoing-send.log. Right now, these files seem to simply stop sending out data due to the error #2, the sudden crash that seemed to happen today. Normally both of these files would have the timestamp of the most recent 4 hour execution (midnight, 4 am, 8 am, 12 pm, 4 pm, 8 pm are the run times).





RESOLUTION OF THE ERROR
================================

I've done two separate tasks to resolve the problem. I would start with #1, then only use 2 if needed.

1 - Less invasive: Manually ran the UFM process on document which seemed to resolve the 'error 22', and UFM seemed to be running properly.
2 - Slightly more invasive: Remove, and re-add the docunet from UFM which seemed to resolve the crashing UFM issue.

=============
To do #1, run this command:
**/opt/UFM/bin/UFM64.sh idtodocunet.json**
This is the command that tells the UFM process to send the data now.

=============
To do #2, run this 3 step command. It'll remove the current config, add it back, then list all the processes, which should then show two PIDS as the result of the 'run_transfers.sh -l' call
**./run_transfers.sh -k -f ./idtodocunet.json && ./run_transfers.sh -f ./idtodocunet.json && ./run_transfers.sh -l**





OTHER INFORMATION:
================================
UFM jobs are configured by submitting a JSON document, this is the one for the IDtoDocunet driver output files:

![[{6B17A223-80E5-461B-AB93-AF588372BC8B}.png]]

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



3/20/2025 6:54:39 AM
Not in the KB article; in lower environments I run this script to keep all three directories clean:

```
#!/bin/bash
# Removes all files that the IDtoDocunet driver & process might create over time; not to be used in Production; which has its own cleanup of transfered UFM files.
# Add these two lines to the crontab for the edir user:
#        Remove old IDtoDocunet related files (x266698: Aaron Kynaston)
#        00 00 * * * /opt/idmfiles/scripts/remove-30-day-old-IDtoDocunet-related-files-non-prod.sh
find /opt/IDMFeeds/IDtoDocunet/ufm -mtime +30 -type f -exec rm {} \;
find /opt/IDMFeeds/IDtoDocunet/archive -mtime +30 -type f -exec rm {} \;
find /opt/IDMFeeds/IDtoDocunet/output -mtime +30 -type f -exec rm {} \;

```









