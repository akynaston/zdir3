# VLookup notes for BAESUK 2017

Steps to update latest Requirements Catalogue with the Category columns:
\- Sync files to local machine (using Google Drive is most direct)
\- Open Excel 2010.
\- Load both the input and output documents in the same Excel window.
\- Copy the 'Requirements' tab containing the TriVir added category columns.
\- Rename this copied Requirements tab to ReqTriVirSource (a short name makes a easier to read formula)
\- Optional: select both tabs and resize columns. This step just helps with visually validating the functions are working properly. Selecting them causes the column widths to match.
\- Unfilter all data (helps to validate, and avoid missing any data.)
\- Unfreeze all panes (I've seen some odd frozen panes every now and then that just hides data, and makes it dififcult to navigate).
\- Create three new columns, G, H, and I.
\- Title them Category, Category and Questions.
\- Add this formula to G4:
    =IF(
        VLOOKUP($A4,ReqTriVirSource!$A$1:ReqTriVirSource!$I$9999,7,FALSE) = "", "",
        VLOOKUP($A4,ReqTriVirSource!$A$1:ReqTriVirSource!$I$9999,7,FALSE)
    )
\- Copy and paste the formula to H4, but replace the '7' with '8'.
\- Copy and paste the formula to I4, but replace the '8' with '9'.
\- Add the filtering on the Status (show only 'approved' and 'agreed').
\- Add any frozen window panes as desired.
\- Optional step to convert formulas to raw text: if desired, select the entire three new columns with formulas -> paste special -> paste values to move to the raw text.
\- Save.
Explaination of formula:
VLOOKUP($A4,ReqTriVirSource!$A$1:ReqTriVirSource!$I$9999,7,FALSE) = "", "",
The VLOOKUP matches up the data from the ID in column A in the 'database' as defined in the range in the second parameter. The third parameter '7' means get the data from the (1 based) 7th column of that 'database range', and the 'FALSE' indicates the data is not sorted (this isn't needed).
The if statement simply avoids a result of '0' if no data is available from the source; hence the need for the VLOOKUP appearing twice.
