
Awesome way to renormalze all commits; assuming they normalize in a healthy way. . .
git rebase -i --root -Xtheirs --exec="bash ../jqNormalizeSimple.sh"

jqNormalizeSimple content:
![[jsonNormalize.sh]]