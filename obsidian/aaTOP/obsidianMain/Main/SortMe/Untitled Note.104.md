# Untitled Note

1/4/2017 10:17:03 AM
Ticket 350:
•ERROR: Disabled Non-Employee (bbamber) still reports to TX’d Manager (kdrice). As is currently happening with active Non-EEs, Disabled Non-EEs should be reassigned to mdmum (placeholder manager).
•ERROR: Active Non-Employee (bsienna) does not receive email indicating that he no longer has a manager. I tested that bsienna can receive emails.
•ERROR: Employees still report to Terminated Manager (kdrice). When a manager is terminated, his EEs should be reassigned to the terminated manager’s manager (tdavis).
Terminated managers:
Issue 1: - all nom emp direct reports should be re-assigned to mdmum
Issue 2: - email: no longer has a manager (done in manager termination info job & email)
Issue 3: - all emp direct reports should be re-assigned to mdmum
350
    create a new ticket; update 307 to point to new ticket; close-fix 307.
         - new ticket: post exchange online, pczicht to own it.
         - Set to review.
    (This appears to be 307: this is a good representation of this section of ticket 350 - next action: talk with TRicia to ensure there is no business requirement behind the temporary manager, and subsequent move of non employees to match the mdmum placement in AD.).
1 - Reassignment of a managers direct reports on termination to temporary manager mdmum (non employees active and disabled, and active employees . . what about disabled employees?); and subsequent move of non employees in AD
    Information: Manager termination check job applies only to active non employees currently.
    Status: may be wontfix: need to know if there is a business requirement behind this.
This should be on it's own ticket:
         - post exchange online pczicht ownt it, set to review.
         - need to ask the question: why did we decide to do this email and manager setting on a job? Could move this to normal termination work so it is done on termination.
         - Ask: Can a user be a direct reports to multiple people?
2 - Email needs to be sent indicationg direct reports no longer have an actual manager (non place holder manager).
