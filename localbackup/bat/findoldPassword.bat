@echo off
echo Old password: expect no results:
grep -ERi "1Dev1111|1Sat1111" -Ri *
echo new password is used: expect one result:
grep -ERi "1luv" -Ri *