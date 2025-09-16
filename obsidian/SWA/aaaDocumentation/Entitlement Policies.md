8/22/2024 2:17:44 PM
How to export:

8/19/2024 12:12:29 PM
Instructions on how to export Entitlement policies:
 - As always, use DEV to create the gold copy by default.
   - Caveat: If another environment has the latest EP data, export from there first, then search & replace top O to swaiddev.
 - Export the EPs using ldap.
  Source dn: cn=Entitlement Policies,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev
  Scope: Subtree
  Attrs to return: leave blank; don't include operational attributes.
     - Note that this includes members; but we strip them off during normalization; so this is fine.
 - run 'ant normalize' to test the normalization.
 - As always, 'git diff' the result to confirm changes are as desired.

