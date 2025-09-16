12/5/2024 12:08:48 PM
Jack
Odd account creation issue
 - needs
 access
 ldap
 ad
 - should have all three of these . .
 - *106708 - some times ldap only has E . .AD has both tins time
 - code looking at unique ID, if match between idv and ldv . .
 - r acocunt missing in ldap tree
   - swaUniqueID - it is r10608 - uid
   - 106708 -> r106708
   - r account showed up in LDAP
   - collision . .all id's always have the same swaUniqueID
   - Access tree, don't have the eAccount - swaUniqueID - in access, only R, because 106708 was there!

Issue statement: Cannot have an employee and RID and expect to flow with same swaUniqueID

problem 1: colliding swauniqueid
problem 2: fixing swanique id - deleted accounts . .

 - more: *38798
 - ad, has r account
 - has r account in access .
 - missing in ldap: when both accounts, had e38798
 - would not link accounts . .

 - deliberate trash can with our test ids . .
 - jack r38798
 - ultimate goal:
 - if awe have objects that we aren't working on, this is fine . .
 - if workday comes in, and workday sets as E, and r14374 . .
 - ultimate goal:
 - if we run a check in dev - seeing associations bad
 - swaidmunit
 - Heres the problem:
   - Jack had it clean at one oint
   - e88985020241204
 - Core has been responsible for deleting old accounts.
