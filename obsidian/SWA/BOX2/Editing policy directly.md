Some times it's handy to modify plicy by directly editing XML.  Remember to save often at times where the XML is formatted correctly; if it says there is an error, it will toss all your changes for the last saved version; hit undo twice to bring it back, fix the error then save.

You can give yourself code completion if you ensure the DOCTYPE is at the top of your policy; something like this:

<!DOCTYPE policy PUBLIC "policy-builder-dtd" "C:\netiq\idm\apps\Designer\plugins\com.novell.idm.policybuilder_4.0.0.202306212152\DTD\dirxmlscript4.8.6.dtd">

Instead of using the one above; copy and paste one from another policy. Also, 