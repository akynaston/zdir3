QA
w11qcledirqi010 - 
[edir@w11qcledirqi010 /opt/UFM/bin]$ ./run_transfers.sh -l
2024-06-03 11:21:27 [UFM] [biz.capitalware.ufm.UFMScheduleAdder] [Line: 160] INFO - Scheduled Transfers
2024-06-03 11:21:27 [UFM] [biz.capitalware.ufm.UFMScheduleAdder] [Line: 164] INFO - -a idmdrivers -s idmdrivers -p id-to-corp-sec-transfer -d send -e qa1 -status:Active
2024-06-03 11:21:27 [UFM] [biz.capitalware.ufm.UFMScheduleAdder] [Line: 164] INFO - -a idmdrivers -s idmdrivers -p id-to-edw-transfer -d send -e qa1 -status:Active
2024-06-03 11:21:27 [UFM] [biz.capitalware.ufm.UFMScheduleAdder] [Line: 171] INFO - -a docunet -s docunet -v vistair -p swa-initiated -d send -e qa2 -partnerPath /sftp-vistair-com/SWA_QA -status: Active
2024-06-03 11:21:27 [UFM] [biz.capitalware.ufm.UFMScheduleAdder] [Line: 179] INFO - running with PID (there should be two): 36745 36756
[edir@w11qcledirqi010 /opt/UFM/bin]$


