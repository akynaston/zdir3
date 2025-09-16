# 1 - Create the new HRSUPER_CHANGE_MANAGEMENT table, with two columns: EMPLOYEE (

1 - Create the new HRSUPER\_CHANGE\_MANAGEMENT table, with two columns: EMPLOYEE (corresponds with PK\_EMPLOYEE in the EMPLOYEE table), and HRSUPER\_CHANGED
2 - Update the EMPLOYEE table's INSERT and DELETE triggers to add and remove the corresponding "workforceID,NULL" row to and from the table respectively.
3 - Modify the COP.IDV view: include the HRSUPER\_CHANGED column into the COP.IDV view; do the same column addition for the unioned COP.TEST\_IDV table at the bottom of the view definition.
4 - Update the HRSUPER trigger to update the timestamp stored in the HRSUPER\_CHANGED column in the HRSUPER\_CHANGE\_MANAGEMENT table, any time changes are made. Per our subsequent conversation, I suspect two categories of event types will need to occur:
1 - When the COP.IDV manager field changes from a Y to N or N to Y based on an HRSUPER update, send an event type of 6, the timestamp in the tamepstamp update isn't necessary, and may result in duplicate rows.
2 - When the COP.IDV manager field DOES NOT CHANGE from a Y to N or N to Y based on an HRSUPER update, send an event type of 3, using our timestamp value as discussed.
