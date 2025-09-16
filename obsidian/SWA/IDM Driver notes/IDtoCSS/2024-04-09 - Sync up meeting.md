4/9/2024 1:56:00 PM
Mickias set this up to have a chat about finalizing css requirements.


4/9/2024 1:32:55 PM
 - Add trigger test
 - rebaseline
 - Redploy IDtoDocunet into QA
   - Initially, there were changes requested from the CSS team, during our last onsite
   - Nirosha
    - 21 -> 45
    - new title code to onboard
    - bob: others? - nirosha: yes
    - aaron: fix request
    - Bob: inflight leadership: they didn't want their other team added -
    - bob: why new codes?
      - Renjith: replaced powertrain
      - this functionality is to CSS
      - Bob - ah ok - new job codes be injested into CSS and create boards . .
      - Bob: to my earlier question:
      - bob - main focus on MCL for pi and fa
        - another, ics: flight rew manifest - this is his main work
        - for these job code updates to the create process
        - involve someine from inflite: crew solutions.
        - They have a backend process.
        - Samantha Shoemer
    - Nirosha: chnages are in place.
       - dev/qa/prod
       - just need the qa/prod.
attnedees:
Mickas abaye
Ruben Grunug
Renjith Pascas (Crew scheduling)
Drew benzer
Nirosha
Robert Dansby

Queue:IF.IDM.CSS_NEW_HIRE_EVENT.AWS.BRIDGE.QUEUE Selector: PropertyApplicationUserType = 'FANH'
Queue:IF.IDM.CSS_CHANGE_CLOUD_EVENT.AWS.BRIDGE.QUEUE Selector: PropertyApplicationUserType NOT LIKE '0002' OR PropertyApplicationUserType NOT LIKE 'FANH'
Queue:FO.IDM.CSS_CHANGE_CLOUD_EVENT.AWS.BRIDGE.QUEUE Selector: PropertyApplicationUserType NOT LIKE '0001' OR PropertyApplicationUserType NOT LIKE '0003' OR PropertyApplicationUserType NOT LIKE 'FANH'

