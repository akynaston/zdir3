@echo off
rem echo "Setting home dir . . "
set homedrive=C:
set HOMEPATH=C:\users\x266698
rem goto :done

echo | set /p="Setting git settings . . . ."
del C:\users\x266698\.gitconfig
del C:\users\x266698\.gitconfig.lock
rem #!/bin/bash
rem #Make sure your home drive/settings point to a local drive: having .gitconfig on a network drive REALLY slows down git:


git config --global --remove-section alias

git config --global user.name "Aaron Kynaston (Contractor)"
git config --global user.email Aaron.Kynaston@wnco.com

rem log:
git config --global alias.lg "!git lg1"
git config --global alias.lgs "lg --simplify-by-decoration"
git config --global alias.lgn "!git lg1 -n 5"
git config --global alias.lg1 "!git lg1-specific"
git config --global alias.lg2 "!git lg2-specific"
git config --global alias.lg1-specific "log --graph --abbrev-commit --decorate --format=format:'%%C(bold blue)%%h%%C(reset) - %%C(bold green)(%%ar)%%C(reset) %%C(white)%%s%%C(reset) %%C(dim white)- %%an%%C(reset)%%C(auto)%%d%%C(reset)'"
git config --global alias.lg2-specific "log --graph --abbrev-commit --decorate --format=format:'%%C(bold blue)%%h%%C(reset) - %%C(bold cyan)%%aD%%C(reset) %%C(bold green)(%%ar)%%C(reset)%%C(auto)%%d%%C(reset)%%n''          %%C(white)%%s%%C(reset) %%C(dim white)- %%an%%C(reset)'"

rem Standard shortcuts:
git config --global alias.s "!git status -s --branch && git stash list"
git config --global alias.si "!git status -s --branch --ignored && git stash list"
git config --global alias.ci commit
git config --global alias.co checkout
git config --global alias.b "branch -vv"
git config --global alias.ba "branch -avv"
git config --global alias.r "remote -v"
git config --global alias.f "fetch -v"
git config --global alias.a "!git f --all -v && git b && echo && git stash list && git s"

echo | set /p=" . . .Half way done . . ."
rem Windows tools:
git config --global diff.tool winmerge
git config --global merge.tool winmerge
git config --global difftool.winmerge.cmd "/c/Program\ Files\ \(x86\)/Winmerge/WinMergeU.exe -u -e $LOCAL $REMOTE"
git config --global mergetool.winmerge.cmd "/c/Program\ Files\ \(x86\)/Winmerge/WinMergeU.exe -u -e $LOCAL $REMOTE"
rem git config --global mergetool.winmerge.cmd "\"C:\Program Files (x86)\WinMerge\WinMergeU.exe\" -e -u -dl \"Base\" -dr \"Mine\" \"$LOCAL\" \"$REMOTE\" \"$MERGED1\""
git config --global difftool.prompt true
git config --global mergetool.prompt true
git config --global mergetool.keepBackup true
rem git config --global mergetool.p4merge.cmd = 'p4merge "$BASE" "$LOCAL" "$REMOTE" "$MERGED"'


rem Tools:
git config --global core.autocrlf true
git config --global alias.hardclean "!git reflog expire --expire=now --expire-unreachable=now --all && git gc --prune=now --aggressive"
git config --global merge.ff only
git config --global core.compression 9
rem Also enable reuse recorded resolution:
git config --global rerere.enabled true

rem Set post buffer to 500MB for larger files when using https.
git config --global http.postbuffer 524288000

git config --global core.editor "'C:\Program Files\Notepad++\Notepad++.exe' -multiInst -notabbar -nosession -noPlugin"

rem This sets SecureChannel instead of openSSL: by default, it uses the HTTP certs in the windows cert store.
rem This allows https cert checking to work properly.
git config --global http.sslBackend schannel
git config --global http.sslVerify true

rem New ones I"m testing:

rem Show full diff incommit message!
rem git config --global commit.verbose false

rem Pull only if it's a fast forward, simliar to merge.ff.
git config --global pull.ff only

rem use git clone swa:IDtoAD!
git config --global url."https://stash1-tools.swacorp.com/scm/csiam/".insteadOf "swa:"
git config --global url."https://stash1-tools.swacorp.com/scm/~x266698/".insteadOf "me:"
git config --global url."https://akynaston@git.trivir.com/scm/swa/".insteadOf "trivir:"
git config --global url."git@gitlab-ssh.apex-tools.prod0.prod.aws.swacorp.com:csiam/idm/".insteadOf "gitlab:"
git config --global url."git@gitlab-ssh.apex-tools.prod0.prod.aws.swacorp.com:x266698/".insteadOf "gitlabavk:"

rem Use windows credential helper:
git config --global credential.helper manager-core

rem: note: can use this to enable differently named local branches.
rem git config push.default upstream

:done
C:
echo Done.