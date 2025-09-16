# Server Discussion - How to: Set up a linux server on ubuntu | Official Chucklefish Forums! [community.playstarbound.com]

### [Log in or Sign up](http://community.playstarbound.com/index.php?login/)

<http://community.playstarbound.com/index.php?misc/quick-navigation-menu&selected=node-102>[Home**/**](http://playstarbound.com/) [Forums**/**](http://community.playstarbound.com/index.php) \> [Starbound**/**](http://community.playstarbound.com/index.php#starbound.1) \> [Multiplayer**/**](http://community.playstarbound.com/index.php?forums/multiplayer.102/) \>

1. When making a thread, please tag your thread accordingly using the menu to the left of the textfield where you name your thread where applicable. [Server Advertisements](http://community.playstarbound.com/index.php?forums/server-advertisements.104/) and [Mod Releases](http://community.playstarbound.com/index.php?forums/mod-releases.103/) should be contained to their respective subforums.

Page 1 of 6
[1](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/) [2](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-2) [3](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-3) [4](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-4) [5](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-5) [6](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-6) [Next >](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-2)

. .

### Server Discussion How to: Set up a linux server on ubuntu

### Discussion in '[Multiplayer](http://community.playstarbound.com/index.php?forums/multiplayer.102/)' started by [sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/).

1. [![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/4788e5feb79e34fb2bc59a43c78bcf80.jpg]]](http://community.playstarbound.com/index.php?members/sovredcat.120586/)
	
	### [sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/) _Zero Gravity Genie_
	
	> Hopefully this is useful for some of you ![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.9.png]]
	> This tutorial assumes you have some basic knowledge of Linux and is based upon Ubuntu 12.04. This tutorial will work if you are completely new to Linux so don't be discouraged.
	> What you need:
	> 1) An VPS or dedicated server with Linux on it.
	> 2) SSH access to it.
	> First we need to login to SSH, we will be using [Putty](http://www.chiark.greenend.org.uk/~sgtatham/putty/download.html) to do this. Simply download it, put it on your desktop and start it up. Then input the IP of your vps/dedi, press 'open' and continue to login.
	> We will be using SteamCMD to download the dedicated server, for more info check <https://developer.valvesoftware.com/wiki/SteamCMD>
	> First we need to move to our home directory, then make a Steam folder there.
	> 
	> Code:
	> cd /home
	> mkdir steam
	> cd steam
	> 
	> Now we need to download SteamCMD and unpack it.
	> 
	> Code:
	> wget http://media.steampowered.com/client/steamcmd\_linux.tar.gz
	> tar -xvzf steamcmd\_linux.tar.gz
	> 
	> Now we will remove the tar.gz file we downloaded and run SteamCMD.
	> 
	> Code:
	> rm steamcmd\_linux.tar.gz
	> ./steamcmd.sh
	> 
	> Let it update, and wait till you see "Steam>", now you can type Steam commands, let's login to our account first:
	> 
	> Code:
	> login your\_steam\_user\_name your\_steam\_password
	> 
	> This will log you in into your Steam account. If you have Steam open on any other computer (like the one you are on right now), you will be logged out.
	> SteamCMD will now log you in using your account you bought Starbound on, and it will most likely ask you to input a Steamguard code if you have set that up, simply follow the instructions on screen to continue.
	> After logging in type:
	> 
	> Code:
	> force\_install\_dir ./starbound
	> 
	> Assuming you are in /home/steam this will make a folder called starbound inside /home/steam/starbound, now type:
	> 
	> Code:
	> app\_update 211820
	> 
	> This will download and update Starbound, wait till it finishes (might take a while depending on how fast the connection is).
	> Now we can safely exit SteamCMD using the following command:
	> 
	> Code:
	> quit
	> 
	> After it's downloaded we can now run the Starbound server. Depending on whether your Linux operating system is 32 or 64 bit we need to move to the correct directory.
	> I am using 64bit so I will type "cd /home/steam/starbound/linux64" to get to the right place. Now we can launch the startbound server using the following command:
	> 
	> Code:
	> ./starbound\_server
	> 
	> But before you do that I would suggest running that in screen, as followed:
	> 
	> Code:
	> screen -S starbound -d -m ./starbound\_server
	> 
	> Using screen will basically run the Starbound server in another window (screen), you can enter and exit this screen at any time, might be a bit confusing at first but you'll get the hang of it.
	> "starbound" is the screen name.
	> If you accidentally ran starbound\_server before running it in screen press CTRL + Z to close it.
	> Type the following to enter the screen:
	> 
	> Code:
	> screen -d -R starbound
	> 
	> Press CTRL + A then CTRL + D to exit the screen without shutting down the starbound server.
	> Type the following to get a list of screens:
	> 
	> Code:
	> screen -ls
	> 
	> And type the following to shutdown (kill) the server and the screen at the same time:
	> 
	> Code:
	> screen -S starbound -X quit
	> 
	> To update the server repeat the following steps:
	> 
	> Code:
	> cd /home/steam
	> ./steamcmd.sh
	> 
	> Then:
	> 
	> Code:
	> login your\_steam\_username your\_steam\_password
	> force\_install\_dir ./starbound
	> app\_update 211820
	> quit
	
	Last edited: Apr 9, 2014
	
	[sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/)
	[#1](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/)
	
	[Usiemon](http://community.playstarbound.com/index.php?members/usiemon.232011/), [supernet2](http://community.playstarbound.com/index.php?members/supernet2.173100/), [xxswatelitexx](http://community.playstarbound.com/index.php?members/xxswatelitexx.12375/) and [7 others](http://community.playstarbound.com/index.php?posts/1367849/likes) like this.
	
	.

		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/92593c8547bde0a3a7ca039c59fc7e66.png]]](http://community.playstarbound.com/index.php?members/akaikee.43463/)
	
	### [akaikee](http://community.playstarbound.com/index.php?members/akaikee.43463/) _Space Spelunker_
	
	> Lets hope it helps! Im gonna give some feedback if it works!
	
	[akaikee](http://community.playstarbound.com/index.php?members/akaikee.43463/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1367898)
	[#2](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1367898)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/4788e5feb79e34fb2bc59a43c78bcf80.jpg]]](http://community.playstarbound.com/index.php?members/sovredcat.120586/)
	
	### [sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/) _Zero Gravity Genie_
	
	> Good luck! If anyone knows how to change the amount of players slots let me know... I have no idea either what it is by default. Or password, or anything for that matter.
	
	[sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1367929)
	[#3](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1367929)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.4.png]]](http://community.playstarbound.com/index.php?members/necrogami.107009/)
	
	### [necrogami](http://community.playstarbound.com/index.php?members/necrogami.107009/) _Yeah, you!_
	
	[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.jpeg]]](http://community.playstarbound.com/index.php?members/necrogami.107009/medals)
	
	> This also assumes your linux server has a gui... most dont
	
	[necrogami](http://community.playstarbound.com/index.php?members/necrogami.107009/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1367963)
	[#4](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1367963)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/4788e5feb79e34fb2bc59a43c78bcf80.jpg]]](http://community.playstarbound.com/index.php?members/sovredcat.120586/)
	
	### [sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/) _Zero Gravity Genie_
	
	> necrogami said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1367963#post-1367963)
	> 
	> > This also assumes your linux server has a gui... most dont
	> 
	> What? I did this through SSH.
	
	[sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1367977)
	[#5](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1367977)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.4.png]]](http://community.playstarbound.com/index.php?members/necrogami.107009/)
	
	### [necrogami](http://community.playstarbound.com/index.php?members/necrogami.107009/) _Yeah, you!_
	
	[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.jpeg]]](http://community.playstarbound.com/index.php?members/necrogami.107009/medals)
	
	> How is steam starting without x?
	
	[necrogami](http://community.playstarbound.com/index.php?members/necrogami.107009/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368034)
	[#6](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368034)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/4788e5feb79e34fb2bc59a43c78bcf80.jpg]]](http://community.playstarbound.com/index.php?members/sovredcat.120586/)
	
	### [sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/) _Zero Gravity Genie_
	
	> <https://developer.valvesoftware.com/wiki/SteamCMD>
	
	[sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368114)
	[#7](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368114)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/a85a0e9819e1ee41e5575c90c33e8167.png]]](http://community.playstarbound.com/index.php?members/seanwcom.93987/)
	
	### [SeanWcom](http://community.playstarbound.com/index.php?members/seanwcom.93987/) _Space Spelunker_
	
	> Should we use this method rather than just copying the files up and running the server? Is there a benefit to having the server logged into my steam account?
	
	[SeanWcom](http://community.playstarbound.com/index.php?members/seanwcom.93987/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368306)
	[#8](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368306)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.7.png]]](http://community.playstarbound.com/index.php?members/nebiz.129940/)
	
	### [nebiz](http://community.playstarbound.com/index.php?members/nebiz.129940/) _Intergalactic Tourist_
	
	> Will this require your steam account to be logged in once you have the server installed and running?
	
	[nebiz](http://community.playstarbound.com/index.php?members/nebiz.129940/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368493)
	[#9](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368493)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.8.png]]](http://community.playstarbound.com/index.php?members/love-doctor.8348/)
	
	### [love doctor](http://community.playstarbound.com/index.php?members/love-doctor.8348/) _Cosmic Narwhal_
	
	 [![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.3.jpeg]]](http://community.playstarbound.com/index.php?members/love-doctor.8348/medals)[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.1.jpeg]]](http://community.playstarbound.com/index.php?members/love-doctor.8348/medals)[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.6.jpeg]]](http://community.playstarbound.com/index.php?members/love-doctor.8348/medals)
	
	> SeanWcom said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1368306#post-1368306)
	> 
	> > Should we use this method rather than just copying the files up and running the server? Is there a benefit to having the server logged into my steam account?
	> 
	> cant seem to get it to work via copying the files so this method may work better
	
	[love doctor](http://community.playstarbound.com/index.php?members/love-doctor.8348/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368515)
	[#10](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368515)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.4.png]]](http://community.playstarbound.com/index.php?members/syntax42.129893/)
	
	### [Syntax42](http://community.playstarbound.com/index.php?members/syntax42.129893/) _Big Damn Hero_
	
	> Using the SteamCMD to add the files to your server can be helpful in case of future updates. You don't use Steam to launch it--only to download the files and update them in the future.
	> In the tutorial above, you can skip the creation of the .txt file if you just put those commands in SteamCMD directly when it is running. Some might find it a bad idea to save unencrypted passwords on their drive.
	> I was able to get a server set up using Ubuntu 12.04 LTS server (not desktop) on an old 32-bit Xeon machine I have. The instructions above are accurate. I did not force an install directory. Instead, I allowed SteamCMD to install in the default location, which is inside the user's home folder in Ubuntu ( /home/<username>/Steam/SteamApps/common/Starbound ).
	> A tip for those using SSH to control their server: learn to use Screen!
	> <https://help.ubuntu.com/community/Screen>
	> Before you launch your server app, type screen and hit enter. Now, launch it. While it is running, you can press Ctrl+a then press d to detach from the screen and it will run in the background, allowing you to perform other tasks. To return to your screen, type "screen -r" or if you have multiple screens running, type "screen -ls" then "screen -r 1234" replacing 1234 with the process number of your screen. To end the a screen, return to it and press Ctrl+a then type :quit and press enter. Only do this after ending the server program by pressing ctrl+c first.
	
	[Syntax42](http://community.playstarbound.com/index.php?members/syntax42.129893/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368635)
	[#11](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368635)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/4788e5feb79e34fb2bc59a43c78bcf80.jpg]]](http://community.playstarbound.com/index.php?members/sovredcat.120586/)
	
	### [sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/) _Zero Gravity Genie_
	
	> SeanWcom said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1368306#post-1368306)
	> 
	> > Should we use this method rather than just copying the files up and running the server? Is there a benefit to having the server logged into my steam account?
	> 
	> You can copy files I suppose yeah, but it's nice to use steam cause you can update it by typing a command.
	> 
	> nebiz said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1368493#post-1368493)
	> 
	> > Will this require your steam account to be logged in once you have the server installed and running?
	> 
	> No.
	
	[sovredcat](http://community.playstarbound.com/index.php?members/sovredcat.120586/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368748)
	[#12](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1368748)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.5.png]]](http://community.playstarbound.com/index.php?members/class101.84940/)
	
	### [class101](http://community.playstarbound.com/index.php?members/class101.84940/) _Phantasmal Quasar_
	
	 [![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.3.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.1.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.6.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)
	[Show All Badges (4)](http://community.playstarbound.com/index.php?members/class101.84940/medals)
	
	> Thanks for that but I'm not fine installing Steam on my linux dedicated server, they will probably add later an auto update feature something similar that you see in King Arthur World server. They will probably so provide a way to download the server software from the site too so we are able to wget it easy because uploading like 700MB is a bit heavy for my small upload connection, like 1h40 at 100Kb/s upload huhu
	> Yet I just packed linux64 and assets myself and deleted linux64/starbound to save 300MB
	
	[class101](http://community.playstarbound.com/index.php?members/class101.84940/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1369026)
	[#13](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1369026)
	
	[supernet2](http://community.playstarbound.com/index.php?members/supernet2.173100/) likes this.
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/3762c257731bd21fd5034fab6bb51e0f.jpg]]](http://community.playstarbound.com/index.php?members/fracomac.129874/)
	
	### [FracOMac](http://community.playstarbound.com/index.php?members/fracomac.129874/) _Intergalactic Tourist_
	
	> ./starbound\_server: /usr/lib/libstdc++.so.6: version \`CXXABI\_1.3.5' not found (required by ./starbound\_server)
	> seems that I have CXXABI\_1.3.3 anyone know how to update that?
	
	[FracOMac](http://community.playstarbound.com/index.php?members/fracomac.129874/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1369176)
	[#14](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1369176)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.5.png]]](http://community.playstarbound.com/index.php?members/class101.84940/)
	
	### [class101](http://community.playstarbound.com/index.php?members/class101.84940/) _Phantasmal Quasar_
	
	 [![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.3.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.1.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.6.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)
	[Show All Badges (4)](http://community.playstarbound.com/index.php?members/class101.84940/medals)
	
	> FracOMac said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1369176#post-1369176)
	> 
	> > ./starbound\_server: /usr/lib/libstdc++.so.6: version \`CXXABI\_1.3.5' not found (required by ./starbound\_server)
	> > seems that I have CXXABI\_1.3.3 anyone know how to update that?
	> 
	> Interesting, are you using CentOS ? if that's the case will need to recompile gcc , I did this to solve similiar server issue for King Arthur's Gold server and CentOS machine where libstdc++ is a lower version
	
	[class101](http://community.playstarbound.com/index.php?members/class101.84940/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1369289)
	[#15](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1369289)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/25996fddbfa51dcf190f0c4d8e954d58.jpg]]](http://community.playstarbound.com/index.php?members/modesix.86266/)
	
	### [ModeSix](http://community.playstarbound.com/index.php?members/modesix.86266/) _Space Spelunker_
	
	> Anyone figured out how to set the password, set slots, server name etc?
	
	[ModeSix](http://community.playstarbound.com/index.php?members/modesix.86266/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1370064)
	[#16](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1370064)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.4.png]]](http://community.playstarbound.com/index.php?members/syntax42.129893/)
	
	### [Syntax42](http://community.playstarbound.com/index.php?members/syntax42.129893/) _Big Damn Hero_
	
	> FracOMac said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1369176#post-1369176)
	> 
	> > ./starbound\_server: /usr/lib/libstdc++.so.6: version \`CXXABI\_1.3.5' not found (required by ./starbound\_server)
	> > seems that I have CXXABI\_1.3.3 anyone know how to update that?
	> 
	> What operating system? CentOS is not compatible with a lot of libraries required for SteamCMD, and I suspect this is the case with the Starbound binaries as well. The easiest OS to use for this is Ubuntu.
	> 
	> ModeSix said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1370064#post-1370064)
	> 
	> > Anyone figured out how to set the password, set slots, server name etc?
	> 
	> There is another thread on these forums with the server.config file information.
	
	[Syntax42](http://community.playstarbound.com/index.php?members/syntax42.129893/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1370219)
	[#17](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1370219)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/c344a71fbb8c844cca65f7e6ed060532.png]]](http://community.playstarbound.com/index.php?members/darkinnit.126143/)
	
	### [darkinnit](http://community.playstarbound.com/index.php?members/darkinnit.126143/) _Aquatic Astronaut_
	
	> ModeSix said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1370064#post-1370064)
	> 
	> > Anyone figured out how to set the password, set slots, server name etc?
	> 
	> StuFka said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1369299#post-1369299)
	> 
	> > <https://twitter.com/bartwerf/statuses/408342742159208449>
	> 
	> Quoting that Tweet here for the lazy:
	> "if you want to set a password on your server: assets/default\_configuration.config edit the serverPasswords list."
	
	[darkinnit](http://community.playstarbound.com/index.php?members/darkinnit.126143/), [Dec 4, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1370493)
	[#18](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1370493)
	
	[class101](http://community.playstarbound.com/index.php?members/class101.84940/) likes this.
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.5.png]]](http://community.playstarbound.com/index.php?members/class101.84940/)
	
	### [class101](http://community.playstarbound.com/index.php?members/class101.84940/) _Phantasmal Quasar_
	
	 [![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.3.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.1.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.6.jpeg]]](http://community.playstarbound.com/index.php?members/class101.84940/medals)
	[Show All Badges (4)](http://community.playstarbound.com/index.php?members/class101.84940/medals)
	
	> can confirm you need rebuild a newer libstdc++ (through gcc) for it to work on CentOS, shouldn't be a problem on Debian/Ubuntu(they have newest libstdc++), will make a CentOS guide once I get my centos set
	
	[class101](http://community.playstarbound.com/index.php?members/class101.84940/), [Dec 5, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1371301)
	[#19](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1371301)
	
	.
		[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/3762c257731bd21fd5034fab6bb51e0f.jpg]]](http://community.playstarbound.com/index.php?members/fracomac.129874/)
	
	### [FracOMac](http://community.playstarbound.com/index.php?members/fracomac.129874/) _Intergalactic Tourist_
	
	> class101 said: [↑](http://community.playstarbound.com/index.php?goto/post&id=1369289#post-1369289)
	> 
	> > Interesting, are you using CentOS ? if that's the case will need to recompile gcc , I did this to solve similiar server issue for King Arthur's Gold server and CentOS machine where libstdc++ is a lower version
	> 
	> Actually I'm using ubuntu 10.04.4 server. I'm guessing I'll probably just need to upgrade to the newer lts release. (never got around to it, since it hasn't been needed for anything and is supported until 2015)
	
	[FracOMac](http://community.playstarbound.com/index.php?members/fracomac.129874/), [Dec 5, 2013](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1371522)
	[#20](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#post-1371522)
	
	.

[(You must log in or sign up to reply here.)](http://community.playstarbound.com/index.php?login/)
Page 1 of 6
[1](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/) [2](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-2) [3](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-3) [4](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-4) [5](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-5) [6](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-6) [Next >](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/page-2)

. .

### Share This Page

.

<http://community.playstarbound.com/index.php?misc/quick-navigation-menu&selected=node-102>[Home**/**](http://playstarbound.com/) [Forums**/**](http://community.playstarbound.com/index.php) \> [Starbound**/**](http://community.playstarbound.com/index.php#starbound.1) \> [Multiplayer**/**](http://community.playstarbound.com/index.php?forums/multiplayer.102/) \>

.

[![[./_resources/Server_Discussion_-_How_to_Set_up_a_linux_server_on_ubuntu__Official_Chucklefish_Forums!_community.playstarbound.com.resources/unknown_filename.2.png]]](http://community.playstarbound.com/index.php)

Welcome Guest... please login

.

.
Stay logged in
[Forgot your password?](http://community.playstarbound.com/index.php?lost-password/)

<http://community.playstarbound.com/index.php?register/>

.

.

* [Home](http://playstarbound.com/)

* [Forums](http://community.playstarbound.com/index.php)
	
	* [Search Forums](http://community.playstarbound.com/index.php?search/&type=post)
	
* [Recent Posts](http://community.playstarbound.com/index.php?find-new/posts)

* [Mods](http://community.playstarbound.com/index.php?resources/)<http://community.playstarbound.com/index.php?resources/>
* [Staff List](http://community.playstarbound.com/index.php?threads/chucklefish-irc-forum-staff-list.572/)
* [Members](http://community.playstarbound.com/index.php?members/)<http://community.playstarbound.com/index.php?members/>
.

[Fusion Gamer](http://community.playstarbound.com/index.php?misc/style&redirect=%2Findex.php%3Fthreads%2Fhow-to-set-up-a-linux-server-on-ubuntu.34623%2F)

* [Contact Us](http://community.playstarbound.com/index.php?misc/contact)

* [Help](http://community.playstarbound.com/index.php?help/)
* [Home](http://playstarbound.com/)
* [Top](http://community.playstarbound.com/index.php?threads/how-to-set-up-a-linux-server-on-ubuntu.34623/#navigation)
* [RSS](http://community.playstarbound.com/index.php?forums/-/index.rss)

* [Terms and Rules](http://community.playstarbound.com/index.php?help/terms)

* [Privacy Policy](http://community.playstarbound.com/index.php?help/cookies)
[Forum software by XenForo™ ©2010-2013 XenForo Ltd.](http://xenforo.com/) | [Style by pixelExit.com](http://pixelexit.com/)

Tac Anti Spam from [Surrey Forum](http://www.surreyforum.co.uk/)
