11/12/2024 1:34:43 PM
NIrosha autocrib meeting
 - postman work
 - minor mapping discussin
 - departmentNo - swaTitle code
 - header: dbid - 10632
   - swalocation -> dbids
   - 12 right now . .
 - getting this was rough
   - final choice: swalocation codes - DBid
   - showing list of codes
   - only for employees - no contractors/venderos.
   - no feed file in myaccess . .
   -
 - swatitledescription: use codes instead . .swaTitleCodes vs jobcode: TBD
 - if no dbid, drop it . .
 - what if swalocation changes?
   - need to use changed dbid . .
 - joe - need to handle role removal and terminate . .
   - how are we managing role? single value attr . .
   - how they set permissions - when remove role - customerattr1
   - permissions how they set up on their side; not sure . .
   - customfield1 - swaautocribrole.
   - Myaccess is the control -
 - change of a header:
   -

Questions:
1 - swaTitleCode and jobCode seems to over lap slightly in purpsoe
   - Are we certain that we want titlecode instead of jobcode?
   -
2 - dbid value in the header
   - is there a rEST call to get the list?
   - lots of back and forth . .
   - 10632
   - Locations where mechanics reside - values should change freqnetly.


3 - Can you forward that email with the dbids?, send all of your autocrib contacts, and that notepad 'new 278 with your design thoughts?
4 - workforceid vs swauniqueid
   - use swauniueied for badge and . .other . .?
5 - initial migration thoughts . .some data in their env already.
6 - repo: IDtoAutocrib
7 - myaccess role: replace role with one value at a time.
8 - Have you already requested the new single valued case ignore attribute 'swaAutocribRole' attribute?
9 - swaAutocribRole exists in DEV.


List of items needed for IDtoAutocrib
 - Contacts for AutoCrib

Part 2: 11/12/2024 3:01:18 PM
- one role to another role
   - there are permissions; swa internal team decides
   - NIrosha will answer more on permissions
   - swalocation -: ATL -> MDW
     - what to do?
     - 10632 - ATL -> MDW - 10787
     - will create the user, do a new post call!!
     - user in the atl old location: can't decide . .
     - if we deactivate the user.
     - api testing: api.autocrib.net/index.html
Questions:
 - Example of autocrib role
 - want acces sto the autocrib.net
 customField1
   - Autocrib_Admin_S
   - Autocrib_AMT_Mechanic_S
   - Autocrib_AMT_Sup_Rpt_S
   - Autocrib_Appearance_S
   - Autocrib_Insp_QC_S
   - Autocrib_Inventory_S
   - Autocrib_Helpdesk_S


