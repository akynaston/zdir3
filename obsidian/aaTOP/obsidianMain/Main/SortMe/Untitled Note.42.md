# Untitled Note

ndsupg - dry upgrade:

# Performing a Dry Run before Upgrading eDirectory

ndsupg can be used to perform a dry run before upgrading the packages. This utility alone can be used against a copied database on all the supported platforms. The advantage is that eDirectory services will still be available when the dry run is being performed.
Here, the \-d option can be used where the upgrade utility itself takes a copy of the DIB and performs the upgrade on the copy. ds.nlm should be unloaded while copying the database to ensure the integrity of the database. Upgrade will require twice the size of the database since a copy needs to be taken.

From 
<https://www.netiq.com/documentation/edir88/edirin88/data/b4u5vco.html>
