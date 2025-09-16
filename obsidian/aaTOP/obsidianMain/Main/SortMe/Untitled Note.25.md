# Untitled Note

EDP - 2020
\*\*2/26/2020 1:27:45 PM\*\* \*\*  ((
DEP: single and mulitple dev plans

Mike thoughts
  Linked in learning training tell the team better job training

Quick note on Census: After some thought, I believe I need to sell willy on moving this DappsCBS JDBC driver to a triggered driver.  The triggerless idea just will not scale to the number of users we have.
      - The driver is relatively fast now, we could speedit up further, but this delta determination thing is a mess.
     - Willy was concerned about a big system change - while it can seem like it, the only difference is that the driver won't have to do most of the work it is doing now - we have more control over the table than I thought too.
     - I'd like to get the seal of approval from several people, and come up wth a prototype that Willie can see working in a short live demo, then he'll be much more amenable to the idea.

Personal:

      - Still have IdMUnit cookbook I think floating around.
      - Like to get more general Network understanding.
            - Everything from the OSI model to how F5's do their job, loadbalancers , how clustering is managed by the network.
      - re-read 7 habits
      - Write a hello world in NodeJs - seems big enough that I ought to have some basic exerience there.
      - NetIQ docker container work: very curious what they mean when they support eDirectory and IDM - can't fully fit it in my head
      - JSON patch tool - Like to see it solve the specific problem of doing a patch to fix an attribute across the board.
      - SQL: getting into more complicated SQL: I need to be aware more of what kinds of things can be solved - just learned that some SQL database support the idea of an Interesect. L AND L

Team:

LAPTOP BACKUPS!!!
CENSUS TRAINING total competency level...
How to help Willie.

      - Had a historical task of being a 7 habits missionary. I've broight it up in the past, but I don't think that anyone would comment on me actually pushing the 7 habits.
      - My L&L and ideas for now, have been still rsync, and windows 10 shadows. 

\*\* Focus on yes or no... Did u back up.

                 - Other lunch and learns that I know would be beneficial at Census - maybe some crash courses or intro claseess
                          - eDirectory: structure, schema, vocabulary, basic health operations.
                          - LDAP
                          - IDM: Netiq, Forgerock, compare and contrast the two
                          - How to connect multiple GIT remotes & SVN to a single code checkout, and what are the gotchas.
       - Continue to coordinate L&L's - Alex has one that we'll get scheduled soon and parick is about ready to go.

L&l with Census... for the team
 Work with sushma
 Work with Traci
Punch hard for that week.
Give thought.

       - Had an old task in 2017 to review what the Census fokls are using as far as softwar,e what kind of habits they have, and have some kind of general discipline/7 habits  checkup.
           - In a unique position to ipick that u again; ahve done a little, but I don't know how to actually make changes, other then doing a lunch and learn. - even an L&L on how and why to use a source code reository at all . .?
      - Still have the desire to document technologies, and new solutions done for clients - such as nowing that SOU is moving form eDirectory to Forgerock, or that BAES UK was the first time we created dynamic groups on driver startup.
      - Creating a very simple reference document describing software/strengths of employees, so people can know who to turn to for questions. new and old employees would benefit.

Mux with carl

      - Set up slightly more official code reviews: Create a stronger explicit expectation that it is normal to invite 2-3 people for a 15-20 minute billable code review session for people to see things. If I would have done this on the BAES dynamic grou thing, saved some pain in Glen's understanding when teaching the client wha tto expect. Or Brent's situation where he wote a custom health job in policy . . 
   -
