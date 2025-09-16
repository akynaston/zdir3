# #BAES Pass on notes

* * *

**Every one:**
Rules for determining SF vs NSF:
1 - User has to be 'complete': have a GL and SVS association.
2 - If user has GCI, It is most likely the user is an SF account.
3 - If user has no GCI, it is most likely an NSF account (and can be viewed/edited in the NSFUI).
side note: If user does get an SF association, we'd still have to receive a GCI before we assumed they were an SF account.
This is the best we can do with the dumpy data I think, as I think it is the simplest thing that can work. Please ping me if you disagree.

 - Don't need to process deletes: don't bother creating deletion dector; at least not needed for business reuqirements.

 - Available tools in library (Stored in service driver). Don't forget to attach this 'Tools' ecma script in the far right hand tab of the "Driver Configuration!"
Tools Ecma script
Write file for simple logging:
function writeFile(workDirectory, employeeID, actionToTake) {
    var nowTimeStamp = new java.text.SimpleDateFormat("yyyy-MM-dd-hh.mm.ss.S").format(new java.util.Date());    
    var pw = new java.io.PrintWriter(new java.io.FileWriter(workDirectory + nowTimeStamp + "." + actionToTake, true));
    pw.print(employeeID);
    pw.close();
}

* * *

**SVS driver:**
SVS: use Firstname + DOB + PlaceOfBirth, maybe plus base64 encoding - I don't want anyone thknkikng ever that they chan change the value, and to provide a minor amount of obfuscation.
 - When the SVS & GL association is assigned, need to set baeIsUserComplete
 - Block publisher deletes (or don't generate them)

* * *

**SF driver:**
SF: use GCI + Employee\_Date\_Of\_Birth
     - Assumptions:
        SVS data feed is always partial data, so we CANNOT do delta determiniation; not deletinog from source systems anway; however, asked SF delta figuring on 3/15/2018 10:14:44 AM.

 - Block publisher deletes (or don't generate them)

\*\* - when you workon secondment data, let me know.  I need to do quite a bit of work that is secondment related.
