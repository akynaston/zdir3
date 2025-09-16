# Untitled Note

Arris: Notes: Creation of secondary tree; potentially keeping them in sync.

Mat Peterson . . .

12/6/2018 9:20:06 AM
Arris migration work
**Goal**:
\- End up with two trees
\- Is continuous bidirectional updating required between these two trees? Sounds like authentication related attributes need to be Bidirectional.

12/6/2018 1:04:28 PM
Joong: got VMs - ready to go on the driver . . .
If we have to . . bidirectionally
     - just one way to another . .

* 1 - Need - official 4.02 driver policy in idm 4.7 . .engine
* 2 - IDM 4.7 instllation into IDM 4.02 tree - schema confirmation
* 3 - Need 4.02 - 4.7 IDM bidirectional engine patch - 
* REPEAT: 4 - Confirm that IDM 4.02 bidirectional patch driver to connect 4.7 engine can still connect to IDM4.02
* KEEP IN MIDN; NOT A CAVEOT . .5 - VMWare snapshots: avoid if possible: take and restore as a whole

chat with Jim - splitting server . . .

1 - New Linux server
2 - Install eDirectory 9
3 - Patch eDirectory to desired patch (check minimum requirements for IDM 4.7
4 - Add Server to the replica ring in the tree.
5 - Ensure rw is fully online for all partitions - 
6 - Install IDM 4.7 on the new server (confirm schema update is ok for 4.02 drivers)
7 - Patch update 4.7 . . 
8 - Start and set to manual on IMR 4.7 drivers to start caching
9 - Stop and disable drivers on original server.

9b: Ideally the time between these steps would be minimized to avoid large caches, and a long cache processing time.10 - Start and enable driver son source server . .

**Strategies**:
There are few ways to go about this, depending on the desired behavior. A continuous synchronization between the duplicate trees is a bit more complicated; though is doable.

Options for duplicating the tree in one time event; I've assigned names to each to amke it easier to talk about. Note: that all methods would end up with a duplicated three with the same tree key. It could create a security hole (borrowed authentication & network switch hole)

\- Replication then cut.
\- Dib set backup & restore (caveot of identical tree keys: could do a network swithc with an active authentication, and have access to either tree).
\- Raw method: clone a server holding the master.
\* Note: on ALL of the above cases, it is VERY important that the duplicated tree NEVER come in contact with it's source tree.
To keep the trees continuously in sync, IDM makes the most sense.  An eDirectory driver can be used to do this; after creating the second tree (using the above methods, or creating a tree from scratch if desired).
Most of the issues come from simply needing to synchornize so much data. Drivers normally have 5-30 attributes to synchonize, yet it's very normal for a migration eDir driver to have 150 to 200 attributes, and there is a lot of careful management that needs to go on with this amount of work.

Having so many attributes to synchronize causes the following issues:

1 - If a single attribute fails to sync for any reason (most likely schema related), the ENTIRE event is thrown away; and these types of errors are NOT retried.
2 - Schema issues them selves can be very prevalent; here's a list of items to deal with:
     - DN type attributes can be tricky. eDirectory tries to resolve these by association; so you need to hide these values past the associatin processor and keep them upto date yourself. Or, associate everything in the tree which can be irritating and require a larger initial migration session and very clean matching rules.
     - Read only attributes: There are many attributes that IDM can't necessarially write to as they are read only in the source server.  Any attributes part of the consideration for synchronization, should be pre-screened for strict necessity.
     -
3 - Add rule issues:
     - Placement rules need to be built to mirror the source tree (ideally); or have some very well defined placement that will avoid collisions from samed named accounts.
     - Matching rules should be built to completely tie together every single object type being synchronized.
     - Create rules need to be considered: some times there are attributes that need to be removed/added when the objects exist in a second tree: ideally these should be considered here.
4 - Migration/Duplication of other drivers
    - Prexisting drivers need to be considered. Do they need to run in the other tree? Should they process everything the src driver does? Should they be disabled? Are additional service drivers or other mechanisms needed to consdier here?
