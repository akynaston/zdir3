# Untitled Note

#BAES - AC updates

\================================================================================
AFFECT TESTING (add to assumptions if not otherwise stated)

3/16/2018 5:11:18 PM 
 - AS system will not delete IDV user accounts when users are deleted in SF, SVS, or GL.

3/16/2018 12:12:02 PM - ASSUMPTION: User deletes are blocked from SF, SVS, and GL. GL deletes however, will trigger a removal of the DirXML-Association, so the user doesn't have an invalid association, and can be matched again.
    Details: Per an email thread with Zili on March 15, we determined that we don't want to do anything from SVS and SF on a delete (user removed from source system). However, for the GL driver, I will at least remove the corresponding association from IDV so the user becomes matchable again.

\================================================================================
DON'T AFFECT TESTING
Association will be this, plus a base64 encoding for obfucation purposes (available directly in policy)
SVS: use Firstname + DOB + PlaceOfBirth
SF: use GCI + Employee\_Date\_Of\_Birth
     - Assumptions:
        SVS data feed is always partial data, so we CANNOT do delta determiniation; not deletinog from source systems anway; however, asked SF delta figuring on 3/15/2018 10:14:44 AM.
