# [TriVir] My project threads: how they will be handled while I'm on vacation

Michael, Huston, Brent, Jim,

I wanted to send a quick status for all of my projects along with how they are going to be handled while I am gone, and what the next steps are. While I'm gone, texting me will be the best way to get a hold of me (it's free).  Voice time from Canada is .89 cents a minute, and data is restricted, I don't think me or TriVir should pay that crazy rate; though if a client needs immediate help, they can pay for it and I can be on the phone ;-)

**PetSmart:** Franken script replacement idea nearly complete: Summary: use combination of cronjobs/scp/rsync from the eDirectory server, copy the iDocs directly to the driver; removing the need for the frakenscript or the remote loader. Could be done to support more than one application server, and no more Fraken script!
    **Next-Action:** Polish up Franken script replacement documentation in appendix P in the AC, and then sell to PetSmart. I can run with this when I get back, or we can have a call if needed. See Appendix P at: <https://src.trivir.com/customer/PetSmart/trunk/SAP/doc/Acceptance%20Criteria%20-%20PetSmart%20-SAP%20Identity%20Management%20Infrastructure.docx>

**SouthwestAirlines:** Ben Sobanam wants a conference call ( to discuss how to use the WinSCP settings in the IdMUnit SAP HR connector (2-3 hours I suspect). Ideally, we'd instead use the time to implement the JSCH library in the SAP connector so WinSCP wouldn't be involved . . .need hours and someone to pay for it; I think we should just do this, and let SWA foot the bill.  Then we would show Ben how to use the improved connector instead.
    **Next-Action:**  We are in the process of getting more hours.  We have 300 hours waiting for procurement: so we should confirm the 300 hour bucket has been accepted. Once we have the go-ahead, I will decide with Huston the ideal way to proceed (WinSCP vs JSCH for the SAP IdMUnit connector), then schedule a call with Ben at SWA. I will call SWA tomorrow and ensure they know I'm gone for a week and confirm this fits in their schedule.

**Arris:**
     - Joong is working on a way to be notified when password syncs fail. 
    **Next-Action:** Jim will be working with Joong next week to do some password sync failure email notification tests and see if they have enough information.
     - Production monitoring will continue.
    **Next-Action:** Brent will be back from vacation and will monitor for any production issues.

**FCPS:**  
     - A re-org is occurring next week (lots of data changing in Lawson, lots of driver synchronization)
    **Next-Action:** Jim and Carl will be standing by to help support this.
    - A new production eDirectory server is ready to be added to the tree.
  **Next-Action:** FCPS wants to add this to the tree after this weeks work (a re-org is occurring), so I will schedule and complete this when I get back. They are happy working around my vacation as they are busy with the re-org.
     - A different Production eDirectory server is going to have a new IP address added so it can be placed behind a load balancer.
  **Next-Action:** When I am back, I will update the eDir configuration to fully use both IP's for eDirectory. FCPS has already scheduled around my vacation for this.
     - The eDirectory server that runs IDM in the TEST environment at FCPS is coring regularly.
  **Next-Action:** Jim is going to run with the SR in my absence.
  - There are many other tasks, though they are box 2 items; I will pick them up when I get back.

**BAE:** John Lebahn reported a Trivir PowerShell driver issue where XdsLib.ps1 was loaded twice and a malformed XML was generated; producing a SaxParserException
     **Next-Action:**John reported the error was due to an Exchange server, and the problem was 'resolved' after restarting the server. We've requested logs to see if we can update the driver to manage the situation better and find out what the error was; assuming they want to pay for it.
