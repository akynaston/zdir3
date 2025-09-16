repo from scratch

Creating manual repo!
.git
objects
HEAD (ref: refs/heads/master)
refs/heads
echo "this is my text" | git hash-object --stdin -w

Created hash object as a file:
git update-index --add --cacheinfo 100644 891c48d5e61fba68ade07d341485214b2c0e226f test.txt

trivir@containers-lnl:~/gitlunchandlearn/from-scratch$ git ls-files --stage
100644 891c48d5e61fba68ade07d341485214b2c0e226f 0	test.txt

talkkng about 0 . . this shows 

