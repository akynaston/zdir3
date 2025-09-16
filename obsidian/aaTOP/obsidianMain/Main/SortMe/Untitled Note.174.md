# Untitled Note

Add Server name and IP address to prompt:

export PROMPT\_COMMAND='echo -ne "\\e\]0;$USER@${HOSTNAME}/\`hostname -i\`: $(pwd -P)\\a"'
