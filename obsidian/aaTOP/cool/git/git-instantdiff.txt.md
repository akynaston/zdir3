git difftool 56.15.0..56.18.2 -- exports


Multiple remotes:
When you show your remotes, you just see this:
C:\work\IDtoSWAUMobile>git remote -v
origin   https://akynaston@git.trivir.com/scm/swa/IDtoSWAUMobile.git (fetch)
origin   https://akynaston@git.trivir.com/scm/swa/IDtoSWAUMobile.git (push)

C:\work\IDtoSWAUMobile>


But when I do it, I see this:

C:\work\IDtoSWAUMobile>git remote -v
ext     https://akynaston@git.trivir.com/scm/swa/IDtoSWAUMobile.git (fetch)
ext     https://akynaston@git.trivir.com/scm/swa/IDtoSWAUMobile.git (push)
origin  git@gitlab-ssh.apex-tools.prod0.prod.aws.swacorp.com:csiam/idm/IDtoSWAUMobile.git (fetch)
origin  git@gitlab-ssh.apex-tools.prod0.prod.aws.swacorp.com:csiam/idm/IDtoSWAUMobile.git (push)

C:\work\IDtoSWAUMobile>


In my case, I can push/pull from ext or origin, depending on the repo I want to talk to! It works because it's the exact same commit tree on both sides - exept for the justin/gary/dev branches we've created!  Cool eh?

Now, when you push to your repo, I can do a 'git pull from ext', then eventually a 'git push origin', and submit a merge request!  I LOVE it! :-)

