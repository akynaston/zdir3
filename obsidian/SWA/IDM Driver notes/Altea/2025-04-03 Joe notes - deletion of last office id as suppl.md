4/3/2025 2:23:19 PM
Joe discussion altea
IDtoAltea: if remove office, and now data, new code now sets swalateaofficedb to XX
 - only time we have an issue is when we lose the last office id, as a suplmeental . .
 - (when deleting swaalteaofficeid only: only office driver helps with this).

Write/review test . .see if one exists:
 - Is when the last swaAlteasuplemntid is removed, (no otherids are popautled)
   - confirm XX is set in Altea
   - Confirm xx is +1 on cotuner
   - configmg signbdb is updated.
   - core: deleting everyting from suplemtnal - diesn' properly order.
   JOe; wants to make suplemetnal IDtoAltea drive r. .

if you ahve a default, and not one your deleting, just fine . .

4/3/2025 3:06:02 PM
Joe had asked me if I would review the tests, and see if there were any that tested what happened if the last office ID removed, and it was a supplemental, does it 


