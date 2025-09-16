

8/2/2024 11:46:11 AM
Items to verify in a CR review:
 - To start, select the "Review - Internal Change Review" task, assign it to yourself, and hit the start button.
  Hint: - Open this CTASK in a separate browser and keep open: later you can click 'end task' and it'll take care of the date insertions.
 - Confirm the short description has been updated with something meaningful.
 - Confirm all CTASKS have been assigned (Assigned To column has a value for every CTASK).
 - Confirm schedule is doable: aka: in the near future, at reasonable hours. Ideally standard changes would be done in the afternoon, or after hours; though this date can change after review.
 - Confirm the Process Integration -> parent change is listed on QA changes. This value should be the prod version of the Cr.
 - Confirm the Planning tab has the top server, versions, and information filled out properly.
 - Confirm there are 9 CTASKS, and all but the review, implementation & validation tasks are closed.
 - Click on 'Modified Cis'
   - You should see all CI's have had 'incidents suppressed'.
   - There should be a CI for the following: the two IDV servers, identity_manager or identity_manager_qa, and the driver name.
   - Example:
      IDtoMiro
      w11qcledirqi013
      hdqqcledirqi013
      identity_manager_qa
 - When done, go back to your "Review - Internal Change Review", and click close task.
