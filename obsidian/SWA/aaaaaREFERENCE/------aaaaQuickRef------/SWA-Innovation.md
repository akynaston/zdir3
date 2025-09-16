


12/11/2024 1:47:45 PM
Gokul innovation chat:


 - SCIM default template? Was this a driver template?
   - With basic attributes
   - Base schema with mapper
   - Base policies to create an account
   - Since SCIM has a solid defintion, makes sense to templatize . .
 - INC generation work: fully document at least one driver's set of known issues, and create INCS
   - IDtoEmployeeSvc is the first one on my list . .
   - Need to start a repo possibly, if the INC genreation config.
   - Gokul - 2 ways
     - e.g. Contarctor become employee - just disabling the old account works; but creating a new account doesn't work . have to send email to slack team . .
     - Would prefer to create INC!
     - Loki - if there are three users getting contarcted to employee, puts them all in one ticket!!
   - Bottom line:
     - Need a way to generate INCs: there are some cases on demand.
     - Grafana is the first way . .
     - Second way: need account: Rammesh . .waiting on dash team
 - IDM deployer needs fixes
   - What about driver passwords? were we going to suppor this? Are we waiting on CyberArk -> AWS updates first?
   - goal: automate all passwords
   - Deletion - need to decide how to do some cleanup . .what about entitlement
 - IdmUnit needs some fixes and/or feature updates.
  - Next action: call Kyle
 - Password/token rotation
   - Need to automate this . .
   - CyberArk -> AWS
   - What about CyberArk -> AWS -> IDM?
   - IdMUnit still users aws . .
   - Need to come up with a new CyberArk friendly format.
 -


LATER:
IDMSumTotal - terminated: changed to retiree
   - in WD changes to


moved plans to: https://wnco.sharepoint.com/:w:/r/sites/CybersecurityIAM/_layouts/15/Doc.aspx?sourcedoc=%7B42605AD2-7DBF-496B-9857-857681AA58A5%7D&file=EE%20Innovation%20items.docx&action=default&mobileredirect=true

one of the firstitems is to update FArhan's spreadsheet: https://wnco.sharepoint.com/:x:/r/sites/CyberProgramTeam/_layouts/15/Doc.aspx?sourcedoc=%7B902715AE-5C9F-4638-AD44-6A09C0EF5029%7D&file=Impacted%20teams%20for%20IGA%20Modernization.xlsx&fromShare=true&action=default&mobileredirect=true