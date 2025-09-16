[user]
    name = Aaron Kynaston
    email = akynaston@trivir.com
[push]
    default = simple
[color]
    ui = auto
[alias]
    lg = !"git lg1"
    lga = !"git lg --all"
    lg1 = !"git lg1-specific"
    lg2 = !"git lg2-specific"
    lg1-specific = log --graph --abbrev-commit --decorate --format=format:'%C(bold blue)%h%C(reset) - %C(bold green)(%ar)%C(reset) %C(white)%s%C(reset) %C(dim white)- %an%C(reset)%C(auto)%d%C(reset)'
    lg2-specific = log --graph --abbrev-commit --decorate --format=format:'%C(bold blue)%h%C(reset) - %C(bold cyan)%aD%C(reset) %C(bold green)(%ar)%C(reset)%C(auto)%d%C(reset)%n''          %C(white)%s%C(reset) %C(dim white)- %an%C(reset)'
[diff]
    tool = p4merge
[difftool]
    prompt = false
[difftool "p4merge"]
    cmd = p4merge "$LOCAL" "$REMOTE"
[merge]
    tool = p4merge
[mergetool]
    prompt = false
    keepBackup = false
[mergetool "p4merge"]
    cmd = p4merge "$BASE" "$LOCAL" "$REMOTE" "$MERGED"
[pull]
    rebase = false
[core]
    autocrlf = input
