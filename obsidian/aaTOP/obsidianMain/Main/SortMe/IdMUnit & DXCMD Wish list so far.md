# [IdMUnit & DXCMD] Wish list so far

Huston,

These two items for the DXCMD would be immediately useful for me:

 - PartitionSyncRequest
  <https://www.novell.com/documentation/developer/jldap/jldapenu/api/com/novell/ldap/extensions/PartitionSyncRequest.html>
 Purpose: on demand replication!
 To Test: create a second server in the tree; configure it for slow replication, and use two ldap connectors to see an object isn't synchronized, cause a replication, then see it is synchronized.

   - Update job state: GetJobStateRequest/GetJobStateResponse
  Purpose: to reload Job configuration on demand. I would like to be able to verify and update jobscopes during test runs to help make IdMUnit tests that focus on jobs to be more deterministic. This would give us the ability to tell the IDM engine to reload configuration on the fly.

**Other items that I think could be useful in IDM:**
 - Get Privileges List Request: if this is what I think it is (get ACL's for user); this could potentially be deeply useful in a few different ways.
 - Secret store work: looks like we can do read/write secrets with ldap! See bottom of <https://www.novell.com/documentation/developer/ldapover/ldap_enu/data/a6ik7oi.html>
 - ndsToLdap(Request/Response) -potentially able to convert DN's . . may be useful to put everything in LDAP dns, and convert it for the end user? . . not sure about this one; could help DN's be more consistent throughout tests, and this appeals to me quite a bit.

\--Aaron
