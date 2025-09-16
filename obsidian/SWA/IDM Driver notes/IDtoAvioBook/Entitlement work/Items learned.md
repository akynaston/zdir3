
Items learned about storing entitlements:
 - We appear to need to store the full Entitlement Policies container as an LDIF file. Portions of it won't import or export properly with Designer.
 - Also need store memberQueryURLs that return more than 2k-3k results, as the import won't work properly if you don't do it separately.
 - When exporting, remove the 'member:' attributes from the file as we don't need to store these in this kind of storage setup; they'll get added back in when importing the file.
 - Move the 'DirXML-SPPriority' attributes to the bottom of the file as they refer to objects created in the file.
 - base64 data: the memberQueryURL filter can move around a little causing diffs. This makes diffs useless; we may want to store them as text if possible.
 - base64 memberQueryURL needs to be updated per env: it has the top O in it . .
 - Entitlement policies have multiple CNs
   - This is tough tough on apache; get 'can't remove naming value' when trying to 'update existing objects'; some times you have to remove them since the available on the DN anyway; then add 'cn=dynamic' later.
 - Attrs to read back when dumping entitlements
   - gives a way to ignore members:
   - objectClass, cn, description, DirXML-SPPriority, dgIdentity, DirXML-EntitlementRef, DirXML-SPDisplayEntitlements, DirXML-SPFilterXML, memberQueryURL
   - or remove with regex: member:.+\n (if linux file)
 - Apache dir studio hint: the DirXML-SPFilterXML, which I think is the visual version of the memberQueryURL for Designer appears to crash apache directory studio. Designate it as a binary attribute in Apache, and it'll stop crashing.
 - NEW: ensure objectClass doesn't get part of RBE driver.
   - restaring the driver through iman EP editor does rebuild filter;  . . manual restart does not.
   - regualrloy check filter, and remove it if present.
Notes:
 - copying ad pasting an entitlement policies causes the RBE driver to refigure everyone . .
 - WARNIGN: when coping and pasting entitlements: remember to delete 'member' on the new one; as the previous memberswill be there statically!

 - RBE driver Fitler is built on entitlement editor trestart in iManager; haven't found other way to trigger it.
 - objectlcass of user has to be there . . .Gokul's concern?
 - ldap filter items to escape . .trying to find assigned entitlements: https://www.rlmueller.net/CharactersEscaped.htm