# [IdMMonitor] Disable ALL Nagios Notifications

\[IdMMonitor\] Disable ALL Nagios Notifications
**How to disable notifications in the Nagios UI**

Click on "Process Info" in the left nav pane
Choose "Disable Notifications"

Click "Commit".

Found this here: <http://serverfault.com/questions/549603/how-to-stop-disable-nagios-email-notifications>

* * *

**How to do this via the command line**
Login to the Nagios admin: ssh nagios@10.31.43.201
Password See env doc.

vi /usr/local/nagios/etc/nagios.cfg

/enable\_notifications
**Edit from enable\_notifications=1 to enable\_notifications=0**
:x
/etc/init.d/nagios restart

Change back to 1 again when you are done.

RU5DMKQCxKzLJz6sdZmzODdQaGoiw+Umr8B9NOhD3qcOzg/CrK/RvtnXV2clHuDGhKGWWW5/ecreC3df9iMeuF3GcNk+tVqxZmwmybCqbLpAqPLawbal166W7wEQso0Do93BwdyqpwMC+ZLmTpAo0mJZA4x7EXoyCsiZ1VQhe1vdPyL3x572QTOtD/HCdU9xDKbbIkeLU7h6rrIQy42J0h0TheSIzTCHfx6apVN7Aa4qHQPzGZYBXvLkZBpz0ZzEjD1aM4SSi9Fwqfbs4mhIFVlw3fbPQtYIPNsGydPuKYb2XkYiOy0N6bFGUTmObJPzePDtg+Wm8ShvRdotjfbQr3bc4lBxVnYxawhBHva/spq9iP/8YUQ+V+9qiR4Xw0kiSgj66B/Oz829/6k7aS/VTj6Og5kNFd8zJzxgq62s0hdBaOH7d+jCBdNILLcBtNFF7bTQAFvRGCgXNaZpj9euhLIm3zx7DHTcMy+QRUlnafYPel47avEB0sdconBz9YnXOzKN1gtWkNeSg1HrNI5twTv2+Vl6doImrXo1ZuJkVpZS6XtjPIqzmmbk0cyJCkowC90qOpRzcX12R47aJWCtjEnr0QzgwHSlnstVDjEv7siR3sE566jBcM3+cSm2wmHA9IDXkePUBk9zGngJ9wpzy/v6PsxFNfR3MvY17Spg7D+SctDk5M+kvsIXCS6Gcfvb8NWZTgaLLJIr45dVNbizKVxHJYGKBCP/Tiw1RtTNXjeuHh578IWM8ZMd2ZZZVMH/bNdM/T0DXonKj2eNClY7ZkQC4soBg6v8Sa30Jkrzbp21SdNC
