3/22/2024 2:26:29 PM
if you see that obsidian seems stuck indexing, do this:

 - close obsidian
 - go to .obsidian folder
 - backup/move your workspace.json
 - Delete workspace.json
 - start Obisidan
 - It should tell you it is indexing; then it may tell you a file name that it has an issue indexing.
 - For me, it was a .ldif schema file dump: after encosling it in the three ticks to designate as code; it saved ok.
 - Save your fixed files as needed
 - Close obsidian
 - Restore your workspace.json file
 - restart obsidian and confirm it is now working properly.