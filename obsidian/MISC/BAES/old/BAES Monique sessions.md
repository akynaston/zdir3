

1/31/2024 11:36:49 AM - had our third(?) session today. First session gave some context: today discussed DVE very shortly, and did fill trace review of 1.1.2.6 VRS match to see her test is working properly.

1/31/2024 10:33:40 AM
Monique,
Here's the few items we noted today . . none of them are time-sensitive; but may be handy to keep in mind.

Notes: - Note: Multivalue delimiter has changed to !!, from |. All of the tests should eventually be updated; though we fixed 1.1.2.6. - Documentation idmunit: We need to add a note about the multivalue delimiter
 - vrs driver: - creation scenario for some reason reads baeGCINumber
 - 1.1.2.6 - Confirm 8001126 gets clenaedup - maybe 27 as well . . .
 - Apache dir studio has italicised attributes . . .
 - low priority: optionally upgrade apache directory studio . .won't load schema prop;erly.
 - odd irq handler for vector . .
 - low priority - find out why we get tiny inputdocs - 
	<NewEcVRSData>
    <EC_VRS_Data_Record source="idmunit">
        <Surname>Blogs</Surname>
    </EC_VRS_Data_Record>
	</NewEcVRSData>

context items:
 - DVE: data validation engine: can stop events early if data fails to comply with specific rules. We did not go into detail at this point as it isn't relevant yet.
 - We have a few policies like the DVE that dump out a lot of trace; something to keep in mind.
 - The add in the test was failing because of the '|' vs '!!' multivalue delimiter in our object class; meaning the driver was successfully creating accounts when it should have collided.

Next action:
	 - Re-run 1.1.2.6, and see that the driver create collides since the test creation of the user should have succeeded to setup for the test.
	 - Re-enable the cleanup on test 1.1.2.6.


2/2/2024 11:13:50 AM
Today we went through the process of debugging a test that didn't match; monique just had swapped the target match attr with the data to match with: given name and preferred name.
  - Glen also reported some test data bugs . . doh' haven't been going to that level.



2/6/2024 12:11:16 PM
 - She's made reasonable progress - has an ECMA script not found issue.
 - Found old driver in tre e. didn't update from SVN . .

2/7/2024 3:23:55 PM
1.1.2.3.2 - when there is stuff to clean up . .
 - works, but once you match on surname date of birht given name . .
 - 