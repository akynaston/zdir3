# Untitled Note

#Arris

10/20/2016 11:03:47 AM

Todo list from conf call with Matt today: we reviewed a timestamp issue with the OMSCERP driver, and collected these todo items.

Arris TODO list:
done - Discuss state of GCVS on EBSFIN
done - Discuss of gcvs on OMSCERP
done - Do an add through the OMSCERP driver: watch the date formatting.
     - Did add-resp for existing associated user; existed in both sides: it succeeded.
On hold: - Locate all other locations in the driver where we use date formats.
 - Get an export of the OMSCERP driver from production.
 - Get an export of the OMSCERP driver from dev.
optional: - Delete unassociated policies to remove confusion.

Aaron
 - Check on status on hiding passwords
      done: I submited in 2011, and no news on it since.

Matt todo list:
hold - Discuss how we want to manage them clearning out the system:
     - 1 - clear associateiosn from edirectoy
     - 2 - build intelligence into the driver to deal with it . .     
     \*\*\* - Matt to have a meeting to discuss whether or not this happens in production, about 10/25/2016.
hold - FALSE reutrn on add\_resp - any functionality needed . .
     - Matt to get with Joong about how we want to proceed on this (may use Sentienal)
     - Talk about the response on an emabile user:
         - define TRUe/FALSE menaing
         - define how to rproceed on either response.
done - Discussion: I assume we don't need to update the EBSFIN driver as it has an instance of the API in a different sytem, right? -
    - WE understand this to be separate
    -\* Matt to confirm that other drivers have their own copy of the API.
 - trenna confirm trenna exists, is enabled, and has the repsonsiblity we added.
 - Matt to get an answer on what occured with the date format changing.

 DONE - Confirm associated query assumes user exists when it does not . .
done - Restart Designer: Found differences weren't being detected in Designer.
done - Check SQL\_DATE\_FORMAT GCV: confirm it appears in the GUI as expected.
dup - Identy all places that dates have changed.
     - add\_resp call is definately one of them; may just be start\_date, and end\_date; though we need to confirm.
done - Review packages on the driver: remove or not repmove . .

3/7/2019 1:19:40 PM
4.0.2.7 patch fix:
<https://support.microfocus.com/kb/doc.php?id=7003488>

Bidirectional ssl bugs
<https://forums.novell.com/showthread.php/507425-Possible-bug-in-IDM-4-7-eDirectory-Driver>

latest bidirectional fixes:

<https://download.microfocus.com/Download?buildid=XKVqJxSb1r4~&patch_redirect=true&old_patch=sidmnw1tqbk>~

6/13/2019 9:59:27 AM
Arris work:
eDir 9 box:
     - point change log driver to point to the new replica .
     - on upgrade day, move to the new 4.7 box on the engine side.
     - Install edir and changelog?
     -     Changelog on edir 9: have to do 4.0.2.7 hotfix on IDV . .
        - Edir 9, change server side piece
        - spreadsheet
     - VPN client - SVN    
     - software acces:
        EDS a little different
        - IDM 4.7,. 402
        - SUDO su -
        - look at jim history for  fil01/sourcevolume/officila; . t . . ..
     - iManager 3.0 -
        \*\*\*DO THIS FIRST\*\* idmedsprd02 - Added to the tree first.
        - SECOND: IDMEDSPRD02, THEN IDM
     - after:
         - UserApp install
            idmuaiprd01 - tendancy to install drive rinto the tree; don't want to do that.
            4.7 install: stand up new user app - (on upgrade day)
            Just need tomcat server in place, configure it to use existing drivers.
                 - change the driver config to use th enew url for the servers.
            - do the package updates on the drivers as well.
            - caveot - anything in database on old server, inf lighe worflows
            - Colton working as well.
    - 6/13/2019 9:40:34 AM-
        one other document
     - main doc for userapp
        <https://docs.google.com/document/d/1WCqaDhMcpsgvrC7ZAgAoOusdFg3AgVeMswmSQHU1l9g/edit>
            changelog list . .
     - custom shims in place . .- almost entirely in EDS
         - flxexeria LMS, oracle . . .Colton do this maybe . .
    - Jason's been wrting tests . .
    - try to push to the 13th for upgrade of next month . . .
     - other items:
         - changelog is done, idm engine, can add the new boxes to the driver sets that they will take over; get data copied.
         - Sathic's driver set settings tool.
    - IdMUnit running on that jumpstation . .
    - Another version of the list of tasks . .6/13/2019 9:44:30 AM     -
         - from Jim: consolidated or cleaned up list -
    - Give Jim status for Arris updates.
        - Shot email for jim . . .
        -

2 status email for JIm . . .
     - get vpn in and review spreadsheet.
     - -
