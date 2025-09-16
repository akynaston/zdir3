4/26/2024 2:32:18 PM
Altea REcon report:
  Changes to make:

KEY UPDATE:
    (first)4 - Run a report of all users in 2,5,6
    2 - edir is actual mismatch: Has office ID, and no matching signid . .
       - with X* & no sign id removed.
       - Fix all these, make sure clean, then back to bigger file.



    (later) 5,6 - actual mismatch, but no RBAC OfficeID.
  1 - Close & rerun edir report.
  2 - Drop NO-RBAC & NO SIGN IDS - THERE'S 40 OF THESE:
  3 - if NO-RBAC-OFFICEID and no signids - prioritize these to the end.
      RBAC: eDir RBAC OfficeID not found in corresponding sign ids for user: [E100016], swaAlteaOfficeID: [NO-RBAC-OFFICEID], sign id data: [{}]

Once I have report of '2' case issues:
   - need to fix them.
   - Can fix a few; then work to resolve in bulk.
   - Joe/Brandon to resolve, Dakota to document
   -



  - NOTE if SQL didn't have sign ID; . .explains why edir doesn't either . .


Case:
  0 - No-RBAC & NO sign ids: drop these; only 40


  1 - xx + No Sign ID issue - IGNORE, LOWER PRIORITY
    RBAC: eDir RBAC OfficeID not found in corresponding sign ids for user: [E100117], swaAlteaOfficeID: [DALWN01XX], sign id data: [{}]
    - E100117 user: what's up in SQL database?
    - not necessaryily a problem . . don't have access anyway.
    - this is a lower priority
    - JOe: if have XX, and no Sign ID -
    - LOWER PRIORITY . .
    - Brandon:
       - SUPER LOW PRIORITY; But can fix:
       - place holders: XX/XY/XZ, not entry in database. Just offload this in Altea, no update in the database reflecting this.
       - Find user in Altea: if still place holder; just add entry in database for place holder and sign.
       - This example does have place holder in Altea, but just not in database.
       - further notes:
         - if need to move from XX to XY; done in Altea, Not in eDirectory. . .
         - Not XY/XZ . . but XX should have been written to SQL; didn't in this case; no signid in edir.
         - likely originally on XX; ofloaded to XW; but only in Altea . .not in directory or database.
    Joe: - only reason why any XX have signids: pulled value from SQl; put into swaAlteaSignid . .
       - if have XX, no sign ID, most likely don't exist in SQL.
       - auto translation?? XW, XY, XZ -> XX?
       - Driver only provisions to XX . .If no longer qualify for - XX (note: driver uses gcv: gcvTerminateOfficeId)DALWN01XX . .
         - Driver can't match these . .
         - joe: offload: offload oldest expirations . . maybe gone for 90 days+; user inactive . .edir won't have record of user! (120 or 90 . .?) for these; uses xy/z as desired.
         - coming up with some plan for clean(er) off load process . .
         - Driver maybe use XY or others?
         - We would need to do full Cr to go change the GCV.
         - this is just to keep counter clean in database.
         - May want to have someone regularly double checking place holders in Altea, compare to database: once a month.
         - Cron job? Check counts? Physical check may be the best way to deal with this.
          Brandond: beginning of May: produce counts between Altea & SQL db to check 10K max - certainly could need a new X* . . 4,5 or 6? . .
         - Why? - Counter thing is a little troublesome for us: too much changes outside of drivers
      ** when XX close to 10K, have driver change instead!!
        - if reach 10K, can't update users any more . .
        -



  *2 - RBAC: eDir RBAC OfficeID not found in corresponding sign ids for user: [E100675], swaAlteaOfficeID: [SATWN01CS], sign id data: [{ATLWN01CS=0216AA}]
     - Bigger problem: 'True mismatch issue'
     - Driver can't manage user . .
     - simliar with 5 and 6 . .


  3 - XY -> mismatch to sign id . .
    - RBAC: eDir RBAC OfficeID not found in corresponding sign ids for user: [E108477], swaAlteaOfficeID: [DALWN01XY], sign id data: [{DALWN01CR=1472SS}]
    - how in edir? must have been manual

  4 - XW -> mismatch to sing id
     - RBAC: eDir RBAC OfficeID not found in corresponding sign ids for user: [E108765], swaAlteaOfficeID: [DALWN01XW], sign id data: [{DALWN01CR=1034LH}]
    - how in edir? must have been manual


  5 - No RBAC, did have sign (not sure if expired in sql)
     - Also need to fix . .
     - RBAC: eDir RBAC OfficeID not found in corresponding sign ids for user: [E108803], swaAlteaOfficeID: [NO-RBAC-OFFICEID], sign id data: [{DALWN01XY=0962LT}]


  6 - No RBAC, has valid matching sign id (not expired in sql)
    RBAC: eDir RBAC OfficeID not found in corresponding sign ids for user: [E108969], swaAlteaOfficeID: [NO-RBAC-OFFICEID], sign id data: [{DALWN01NR=0539MB}]
    - all need to be evaluated: need to know what Atlea and SQL says about this user
    - Similar to 2; way we fix is slightly different.



  - Maybe do a bulk update into eDirectory - to users missing placeholders in edir . .
     - bulk in edir & altea system
     - JOe: note: if we do this; XX re-set in Altea - already exists . .but still no sign id . .
       - maybe get officeID AND signid . .?
       - Joe/Brandond: bulk load to new attr? yes - update swaAlteaOfficeID/swaAlteaSignID.
       - this may be the route we use to fix most of these.
  - May be good to group users by office id . .
    -  fix users by office ids to help control scope.



Random other items:
   - tough to assume . .XW in RBAC?
  RBAC: eDir RBAC OfficeID not found in corresponding sign ids for user: [E109546], swaAlteaOfficeID: [NO-RBAC-OFFICEID], sign id data: [{DALWN01CR=1343ZK, DALWN01XW=1330ZK}]





Major pain points:
   - Can't read sign id on demand from Altea . .
   - Requirement to set office id + limit of 10K on place holder office ids
   - Need to keep data in sync between 4 systems: Altea, eDir, SQL Database










RBAC attrs:

    <if-op-attr name="swaTitleCode" op="changing"/>
    <if-op-attr name="swaDeptCode" op="changing"/>
    <if-op-attr name="swaLocation" op="changing"/>





