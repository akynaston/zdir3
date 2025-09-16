start /wait ant
start /wait xcopy final\DEV\* exports
del exports\*-failover.xml
start /wait git restore final README.md
git s