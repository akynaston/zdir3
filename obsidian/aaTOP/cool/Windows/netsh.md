Carl used this to fix an ip address issue - from Jake Hornack

I had a local VM where I needed to set a static IP, the UI wouldn't save properly. Every time I returned to that network connection in the UI, it would be reverted. I finally got it working by making a network change on the command line instead... Maybe that helps?  

  

I used this to show my config:  
netsh interface ip show config  

  

I used this to set my IP:  
  
netsh interface ip set address name="Ethernet0" static 172.17.2.112 255.255.255.0 172.17.2.2