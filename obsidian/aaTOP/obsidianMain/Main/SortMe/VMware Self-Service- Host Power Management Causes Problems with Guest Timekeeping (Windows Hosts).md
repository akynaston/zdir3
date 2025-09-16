# VMware Self-Service- Host Power Management Causes Problems with Guest Timekeeping (Windows Hosts)

**VMware**
[Support](http://www.vmware.com/support/) > Knowledge Base
[![[./_resources/VMware_Self-Service-_Host_Power_Management_Causes_Problems_with_Guest_Timekeeping_(Windows_Hosts).resources/btn_kbhome.gif]]](http://kb.vmware.com/selfservice)   [![[./_resources/VMware_Self-Service-_Host_Power_Management_Causes_Problems_with_Guest_Timekeeping_(Windows_Hosts).resources/btn_kbhelp.gif]]](http://kb.vmware.com/kb/878)

## Knowledge Base

![[./_resources/VMware_Self-Service-_Host_Power_Management_Causes_Problems_with_Guest_Timekeeping_(Windows_Hosts).resources/Header.jpg]]

### Search the Knowledge Base:

 

|     |     |
| --- | --- |
|     |     |

|     |     |
| --- | --- |
|     |     |

### Search the Knowledge Base:

  

|     |     |
| --- | --- |
|     |     |

|     |     |
| --- | --- |
| Products: |     |

|     |     |
| --- | --- |
| Search In: |     |

# Host Power Management Causes Problems with Guest Timekeeping (Windows Hosts)

#### Details

* The host is a computer running Windows that has power management features in the hardware that varies the processor's operating speed.
* When the host processor speed increases, the guest operating system's real-time clock (RTC) runs too fast.

#### Solution

This problem can occur on some host computers that use Intel SpeedStep, AMD Cool 'n' Quiet, or other similar power-saving technologies that vary the processor speed.

**Note**: This article is designed for hosts running Windows for the listed product versions. For Linux hosts running these product versions, see [Host Power Management Causes Problems with Guest Timekeeping on Linux Hosts (1591)](http://kb.vmware.com/kb/1591). Previous product versions do not accept the workaround listed, for these product versions, see [Locking SpeedStep, PowerNow, or Cool'n'Quiet on the Host to a Constant Speed (708)](http://kb.vmware.com/kb/708).

# Workaround

You must specify the correct maximum CPU speed of the physical hardware in the global configuration file ( config.ini).

To specify the correct maximum CPU speed:

1. Find the maximum speed of the host computer's CPU. To do this, open **Control Panel > System**. Note the speed rating of the processor (CPU) written in the model designation text. This may be higher than the current operating speed of the processor noted here. This value can often also be obtained from the computer's BIOS diagnostic screen when starting the computer.
	
2. Find the config.ini file:
	
			**Windows 2000 / XP -** %AllUsersProfile%\\Application Data\\VMware\\_<VMware-Product>_\\config.ini
		
			**Windows Vista -** C:\\ProgramData\\VMware\\_<VMware-Product>_
		
	
	**Note**: This file is normally created when the VMware product is installed. However, if the file does not exist, create a new text file in the appropriate location as described above, then add the required lines to form a valid config.ini file. For the specifications of the file, see [Creating and Editing config.ini on Windows Hosts (1754)](http://kb.vmware.com/kb/1754).
	
3. Edit config.ini, and add the following lines. Modify the cpukHz value according to the value of the physical computer's maximum CPU speed from step 1. Also add the second and third lines. This enables a mechanism that keeps the guest's clock accurate even when the time stamp counter (TSC) is slow.
	
	host.cpukHz = "1700000"
	      host.noTSC = "TRUE"
	      ptsc.noTSC = "TRUE"
	
	The example above is for a computer that has a maximum CPU speed of 1700 MHz (or 1.7 GHz). The value entered on this line must be in KHz. To convert the speed from MHz, multiply by 1000. To convert from GHz, multiply by 1 000 000.
	
4. Restart the VMware Authorization service for the changes to take effect.
	Click **Start > Control Panel > Administrative Tools >** **Services**. Right-click **VMware** **Authorization Service** and click **Restart**.
	
5. In addition, verify that the VMware in the guest operating system are set to enable time synchronization.
	
	1. Open the VMware Tools toolbox application by double-clicking the VMware icon in the system notification area (tray).
		
6. Click **Options**, select **Time synchronization between the virtual machine and the host operating system**.
	

# Additional Information

For additional information about timekeeping, see [Timekeeping in VMware Virtual Machines (PDF)](http://www.vmware.com/pdf/vmware_timekeeping.pdf).

#### Feedback

**Rating:**      (58 Ratings)   

|     |
| --- |
| **Did this article help you?** |     |
| This article resolved my issue.<br>This article did not resolve my issue.<br>This article helped but additional information was required to resolve my issue. |     |
| **What can we do to improve this information? (2000 or fewer characters)** |     |
|     |     |
| ![[./_resources/VMware_Self-Service-_Host_Power_Management_Causes_Problems_with_Guest_Timekeeping_(Windows_Hosts).resources/btn_submit.gif]] |     |

**Rating:**      (58 Ratings)
