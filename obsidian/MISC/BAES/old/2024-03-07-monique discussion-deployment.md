3/7/2024 12:50:42 PM
Monique BAES
0 - Confirm their environment is up and running in a healthy state (all drivers running; content is as they expected).
1 - Start by reconciling our latest SVN commit with their tree.
  - This includes driver code, driver set config items, and email templates.
  - Update your Designer with everything in their tree.
  - Diff the drivers: I prefer WinMerge/SVN diffs: so export them all back into
  - ***Any changes encountered here, are likely because some one has updated components without putting them back in SVN; so we'll need to make sure we're up to date.
2 - Roll a build if it hasn't been done yet, and commit.
3 - Import all email templates and drivers.
4 - Diff compare, and deploy.
   - Note: Ownership on some items like the email templates may be owned by them; So some caution will need to be taken here . .
   - Store, communicate any changes found here to the BAES team and decide which data is correct, theirs or our SVN latest commit.
5 - Restart all drivers.


