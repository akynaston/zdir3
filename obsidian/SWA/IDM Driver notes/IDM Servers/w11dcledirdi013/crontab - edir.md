8/13/2025 10:52:46 AM
I'm removing my last removal script; this is the original file:


[edir@w11dcledirdi013 bin]$ crontab -l
# execute script to backup eDirectory dib
0 22 * * * /opt/novell_common/scripts/dsbkup.sh > /dev/null 2>&1

# execute script to backup eDirectory objects
40 22 * * * /opt/novell_common/scripts/ndsbackup.sh > /dev/null 2>&1

# Rotate dirxml driver log files to the backup drive (Jack Sellers)
# commenting out for now because we don't need this running in QA except for testing
#####*  *  *  *  *    /opt/idmfiles/scripts/rotateIDMlogs.sh >> /opt/idmlogs/archive/rotateIDMlogs.log 2>&1

# execute script to copy data from /opt/IDMFeeds/IDtoEDW/outputdelimited to /opt/IDMFeeds/IDtoEDW/output
# script also creates trigger file for MQ FTE agent to pickup file
##### 55 4 * * * /opt/idmfiles/scripts/IDtoEDW_FileSend.sh

# Altea MyAccess Feeds generation script -- Contact Naveen Chhabra #####
#####30 16 * * * /var/opt/novell/eDirectory1/Altea_MyAccessFeeds/code/bin/generateFeeds.sh >& /var/opt/novell/eDirectory1/Altea_MyAccessFeeds/code/log/AlteaMyAccessFeedSctRun$(date +"\%Y\%m\%d").log

#----- IDtoAltea Feed Normalizer Script -- Contact Marsha ####
#####45 23 * * * /var/opt/novell/eDirectory1/IDtoAltea/code/feed_normalizer/feed_normalizer.sh > /dev/null 2>&1

#----- IDtoAltea Office Counter Script -- Contact Marsha ####
#####15 0 * * * /var/opt/novell/eDirectory1/IDtoAltea/code/office_counter/office_counter.sh > /dev/null 2>&1

# Altea LSS extract preprocessor script -- Contact Naveen Chhabra #####
#####40 05 * * * /var/opt/novell/eDirectory1/IDtoSecDB/code/bin/preprocessor_shell.sh >& /var/opt/novell/eDirectory1/IDtoSecDB/code/log/AlteatoSecDB_PreProcessorScript$(d +"\%Y\%m\%d").log

# SecurityDB User Record Updates Processor script -- Contact Naveen Chhabra #####
#####0,15,30,45 * * * * /var/opt/novell/eDirectory1/SecDBEventProcessor/code/bin/processSecDBUsrEvts.sh >& /var/opt/novell/eDirectory1/SecDBEventProcessor/code/log/SecDBUvtsProcessorScript$(date +"\%Y\%m\%d-\%H_\%M_\%S").log

# Remove old IDtoDocunet related files (x266698: Aaron Kynaston)
00 00 * * * /opt/idmfiles/scripts/remove-30-day-old-IDtoDocunet-related-files-non-prod.sh

[edir@w11dcledirdi013 bin]$


