# **Operational Overview**

The purpose of this section is to give Ops a high level view of the driver.

The general review of the driver is that it manages about 5000 Miro accounts, and is currently only responsible for provisioning, basic attribute update, and deprovisioning. 
  

- Driver Point of Contact:
  
    - The pattern for most drivers is to be created in the Engineering Enablement (EE) team, then when the warranty expires on the driver, the Core team should be contacted.
        
    - See the block in the upper right hand corner for relevant contact information.
        
- What is the application that this driver is servicing?
    
    - This driver provisions users into the Miro application. The driver only provisions the users. They default to a 'Free Restricted' mode that doesn't consume a license.
        
        - **September 2024:** They are in the process of defaulting users to 'Free' which can upgrade to a full license the first time they log in.
            
    - The Miro application URL provides provisioning capabilities over SCIM: [https://miro.com/api/v1/scim/Users/](https://miro.com/api/v1/scim/Users/)
        
- Driver Scope:
    
    - As of October 2024, It currently has about **4600 users, out of a cap of 5000 licenses colour** - this is noted as one of the issues below; we will spend more time on this in a sec.
        
    - At the moment, this driver is not associated with any regulatory processes and is meant only to provide provisioned accounts to Miro.
        
- Driver usage of Cron/UFM
    
    - This driver does not use cronjobs or any UFM tasks. There are no external components, other than a dependency of the SCIM API to be enabled in Miro.
        
- Driver provisioning use case walkthrough (does someone log in to MyAccess etc?)
    
    - The usecases for the driver are below. All cases follow some request in MyAccess, or are triggered from normal employee/contractor cycle changes such as a termination.
        
- Information sent to the remote systems
    
    - This driver maps the schema as shown in the Schema Mapping section below. This shows how data from eDirectory maps to SCIM fields in Miro . A SCIM payload is also included.
        
- Tickets expected for this driver
    
    - There are currently no situations that generate tickets in this driver; however, See the issue list below to resolve issues as they are encountered.
        
- A valid CI is created for the driver:
    
    - The 'IDtoMiro' CI has been created.
        
- Has any monitoring been enabled for the driver? If so, how is the process and type of alerts expected.
    
    - Yes. At the moment there are no special alerts to pay attention to; above and beyond the standard cache filling up, driver being stopped etc.
        
    - The default monitoring available to drivers will monitor all basic issues, except for the license issue as mentioned above, and more in detail below.l
- What do you do if the driver terminates and does not start back up?
    - Contact the core team.
- What information does the driver send to the remote system?
    - This document contains all use cases covered by the driver. See the Schema mapping section below for specific field mapping from eDirectory to Miro.
- What are the uses cases in the driver?
    
    - The use cases are below.
        
- .What application testing areas do we have?
    - The Miro application is accessible as one of two different types:
        
        - Sandbox: All non prod envs reference this environment.
            
        - Production: the Production driver references this environment.
            
        - The end point to both is the same. The correct environment is **chosen based on the bearerToken passed in.**
            
    - The URL used is: [https://miro.com/api/v1/scim/Users/](https://miro.com/api/v1/scim/Users/)  
          
        

New Items in progress of of October 7:

- Flow direction:
    - This is a 'subscriber only' driver: meaning the events only flow one way from eDirectory to Miro. SCIM is used only to send payloads to Miro.
- Licensing:
    - The Licensing issues described in this document refer ONLY to the Miro system user provisioning limit of 5000 that SWA currently owns.
- eDirectory updates for this driver:
    - This driver required only the new swaMiroRoles attribute added (Multi valued, case ignore string) added to the swaPerson auxiliary class.
- Notes on the IDM cache file:
    - The maintains a standard IDM driver cache (aka the .TAO file). This is where events from eDirectory are stored. If the driver can be processed immediately it may bypass the cache as event processing is live. If the driver is already processing something then events are put into the cache  in FIFO order (first in first out)
- ****Bearer token updates**:** The Sandbox and Production bearer tokens are currently static.  We are working on getting some kind of rotation setup for these tokens..
    - **UPDATE:** Note on bearer token: Rotation: The bearer token is a 64 alphanumeric string that is generated by the Miro software. I have a meeting on Friday October 11 to discuss a rotation plan with the app owner, Arvin Kamau; the rotation will likely need to be a manual process.