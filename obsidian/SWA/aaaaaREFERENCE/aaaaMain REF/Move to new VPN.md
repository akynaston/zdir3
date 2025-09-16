11/5/2024 5:36:40 PM
Global protect is the
https://southwest.service-now.com/swa?id=kb_article_view&sysparm_article=KB0113756&sys_kb_id=1c27467793d09ad0527bb31efaba108c&spa=1


  

Skip to page contentSkip to chat

  

[![Dash Help Center - Home Page](https://southwest.service-now.com/e734733fdb1c529892e6816813961948.iix)

# Dash Help Center

](https://southwest.service-now.com/swa?id=dhc_help_center)

- [My Tasks](https://southwest.service-now.com/swa?id=hrm_todos_page)
- [my tickets](https://southwest.service-now.com/swa?id=my_requests)
- [](https://southwest.service-now.com/swa?id=my_favorites_new)

- [
    
    AK
    
    ](https://southwest.service-now.com/swa "User options")

- [Tours](https://southwest.service-now.com/swa)

Switch to IT View

My Tickets

My Favorites

Services

Outage Notifications

Chat

Self Help - GlobalProtect VPN: Install and Setup

KB0113756

## GlobalProtect VPN: Install and Setup

 Updated a day agoa day ago  Knowledge base: Self Help

---

Overview

- GlobalProtect VPN is replacement for Cisco AnyConnect VPN and it is the only VPN which **enables connectivity to cloud databases (AWS Redshift, AWS Aurora, etc…)**
    - _Note: Users must transition to GlobalProtect and stop using Cisco AnyConnect by March 31, 2025_   
          
        
- Unlike Cisco AnyConnect VPN, GlobalProtect VPN must be installed and running on SWA computers **even if you are in HDK/or other campus locations for access to cloud databases.**
- **SWA network drives** are now accessible when using GlobalProtect.   
      
    
- **Only one VPN client can be connected at a time**. Cisco AnyConnect must be disconnected if you need to use GlobalProtect to access resources  
      
    
- **BYOD (Personal Device) users** have restricted access just like they do in Cisco AnyConnect.  
      
    
- **PingID is required** for MFA just like with Cisco AnyConnect. If you need assistance setting up PingID please refer to the [Ping ID MFA Help Guide](https://southwest.service-now.com/swa/x_soai_portal_deci_decision_tree.do?sysparm_tree_id=0589d1f61b13a4d08878a8a82b4bcbac)

- **If you are in Customer CARE -** Please see communications from your Leadership on when to transition from Cisco AnyConnect to GlobalProtect

  
Access

- **Default Access:**
    - For default access, you must be a member of the “**VPN_Globalprotect_Remote**” Active Directory group  
          
        
    - **If you already had Cisco AnyConnect Access....You already have access**:
        - For those who previously had access to AnyConnect, you have already been migrated over to this group and do NOT need to request access.  However, during the transition period, new hires may experience a delay in automatically being provided GlobalProtect access.  Use the guidance below to confirm if you are a member of the GlobalProtect group and request access if not a member.  
              
            
    - **Request default access**:
        - Using [MyAccess](https://wnco.sharepoint.com/sites/SWALife-ManageAccess/SitePages/My-Access.aspx), under "My Requests" click "Access for Self", then click "Remote Access - VPN" and select the GlobalProtect group

![](https://southwest.service-now.com/sys_attachment.do?sys_id=a178ed5447ad5a90d00eaaffe26d4346)  
  

![](https://southwest.service-now.com/sys_attachment.do?sys_id=557a695047ed5a90d00eaaffe26d4312)

- **Access to cloud resources (AWS Redshift, AWS Aurora, etc)** 
    - You must be a member of the "**Self_Service_Global_Protect_Users_S**" Active Directory group.
    - You can request access to the above Active Directory group using [MyAccess](https://wnco.sharepoint.com/sites/SWALife-ManageAccess/SitePages/My-Access.aspx).  For more information refer to KB003433 [Application Request Process - Step 2 - Submit MyAccess Request](https://southwest.service-now.com/vc?id=kb_article_view&sysparm_article=KB0034333).

- **Verify your GlobalProtect Active Directory group membership**  
    - Use [MyAccess](https://wnco.sharepoint.com/sites/SWALife-ManageAccess/SitePages/My-Access.aspx) to confirm if you are a member of either of the above groups by referring to KB0027673 [How can I view my current access rights in MyAccess?](https://southwest.service-now.com/vc?id=kb_article_view&sysparm_article=KB0027673)  
          
        ![](https://southwest.service-now.com/sys_attachment.do?sys_id=6fa776f793d8dad0527bb31efaba10cc)

  
Install

- The GlobalProtect installer should already be available in Software Center (Windows devices) or Self Service (Mac devices).     
      
    - **Windows**:
        - Refer to KB0034419 [Application Request Process - Step 6 - Install Software](https://southwest.service-now.com/vc?id=kb_article_view&sysparm_article=KB0034419) 
    - **Mac**:
        - Refer to KB0080471 [How to Install Software on your Mac](https://southwest.service-now.com/vc?id=kb_article_view&sysparm_article=KB0080471)  
              
            
- BYOD (Personal Device)
    - **Windows & Mac:**
        - The installer can be downloaded from [https://portal.swalife.com/global-protect/getsoftwarepage.esp](https://portal.swalife.com/global-protect/getsoftwarepage.esp "https://portal.swalife.com/global-protect/getsoftwarepage.esp")

  
Configure

1. The portal address should be pre-populated. If not, follow the instructions below.  
      
    - **Windows**:  
          
        1.  From the system tray, click the GlobalProtect VPN icon (globe).  
              
            ![](https://southwest.service-now.com/sys_attachment.do?sys_id=ac0c4e3393949ad0527bb31efaba1080)  
              
            
        2. Configure the portal to **portal.swalife.com**  
              
            ![](https://southwest.service-now.com/sys_attachment.do?sys_id=4d1c027393949ad0527bb31efaba1070)  
              
            
    - **Mac  
          
        **
        1. From the menu bar, click the globe icon to **open GlobalProtect VPN**.  
              
            
        2. Configure the portal to **portal.swalife.com**  
              
            ![](https://southwest.service-now.com/sys_attachment.do?sys_id=1e6cc6f393949ad0527bb31efaba104a)  
              
            
2. Click **Connect** and a browser window opens up to input SWA credentials and MFA password.  
      
    ![](https://southwest.service-now.com/sys_attachment.do?sys_id=7a9c0a3793949ad0527bb31efaba1028)  
      
    
3. Once connected, verify your connection.  Select **Menu > Settings**.  
      
    ![](https://southwest.service-now.com/sys_attachment.do?sys_id=0c3dc63b93949ad0527bb31efaba1068)  
      
    
4. Select **Connections** and refer to the **Status section**.  You will be connected to the best available gateway.  
      
    - **If you have default access:**
        - You will be connected to either **W11_Gateway or SDC_Gateway**  
              
            

![](https://southwest.service-now.com/sys_attachment.do?sys_id=1732f9a247211294d00eaaffe26d43a4 "Default_GW.png")

- - **If you have access to cloud resources (AWS Redshift, AWS Aurora, etc)** 
        - You will be connected to either **W11_AWS_Gateway / SDC_AWS_Gateway or W11_AWS_Int_Gateway / SDC_AWS_Int_Gateway.**  
              
            ![](https://southwest.service-now.com/sys_attachment.do?sys_id=7bc3b92e47211294d00eaaffe26d435f "AWS_GW.png")

![](https://southwest.service-now.com/sys_attachment.do?sys_id=3ae3796e47211294d00eaaffe26d43f6 "AWS_Int_GW.png")

- - If necessary, you can also **switch gateways from one datacenter to the other** by right clicking on the GlobalProtect icon

![](https://southwest.service-now.com/sys_attachment.do?sys_id=9be77dee47611294d00eaaffe26d4363)

Troubleshooting:

- Confirm that Cisco AnyConnect is disconnected and restart your computer.  You cannot be connected to 2 VPNs simultaneously.  Try the connection with only the GlobalProtect VPN client.  
      
    
- Uninstall GlobalProtect VPN. Restart the computer to confirm that the virtual adapter is removed. Reinstall GlobalProtect following the steps above.

---

Copy Permalink

Did this address your need? 

Yes No 

90% found this useful

Routing data

**Solution Level Support:** Level 0: Easy

**Initial Support Group:** Service Desk

**Next Level Support Group:** TS&S L2 Support

**Resolvable by Service Desk:** Yes

Article data

**1,200 views** (last 365 days)

**29 uses** as a ticket solution (last 365 days)

**Knowledge owned by:**  
ISN-Security

## Most Useful

[

Outlook: Add or Remove Members from a Distribution Group (DG)



](https://southwest.service-now.com/swa?id=kb_article_view&sys_kb_id=1dce79666f204a80b702a7131c3ee4ff)

Article MetadataKB0021054 • 2246 Views Article has 2246 views• updated9d ago9 days ago

[

PingID MFA: Register Your Phone for PingID MFA



](https://southwest.service-now.com/swa?id=kb_article_view&sys_kb_id=9ff7e29d87b53910e0a4fc06dabb35a2)

Article MetadataKB0110860 • Baylor Watkins • 2163 Views Article has 2163 views• updated2mo ago2 months ago

[

Technology - Change Management Policy



](https://southwest.service-now.com/swa?id=kb_article_view&sys_kb_id=cf16a59d1369d340122af168d144b029)

Article MetadataKB0068070 • John Maples • 1717 Views Article has 1717 views• updated6mo ago6 months ago

[

Change Management - How to request a new maintenance window for a business service



](https://southwest.service-now.com/swa?id=kb_article_view&sys_kb_id=5e43820993b896d03c5b75ea6aba103b)

Article MetadataKB0113928 • 14 Views Article has 14 views• updated2mo ago2 months ago

[

PingID MFA: Register an iPad/IEFB/EFB for MFA and Log in to Workday



](https://southwest.service-now.com/swa?id=kb_article_view&sys_kb_id=c6d94e734754b510b2666914846d43e7)

Article MetadataKB0109963 • Baylor Watkins • 734 Views Article has 734 views• updated5mo ago5 months ago

![](https://southwest.service-now.com/ba2881d99355961021ed364efaba10b3.iix)

© 2024 Southwest Airlines. All rights reserved