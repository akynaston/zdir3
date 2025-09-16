1/5/2024 4:33:12 PM


git-filter-repo comand to strip auxiliary directory, and avoid adding replace-refs.
python adminrepo\\tools\\git-filter-repo.py --invert-paths --replace-refs update-no-add -f --path delivery

Delete all refs if I forget --replace-refs update-no-add; works on windows with gitbash . .
git replace | xargs git replace --delete




Example commands I'll use in the idm-cmndline-deploy repo:
python "..\adminrepo\tools\git-filter-repo.py" --analyze -f

python ..\adminrepo\tools\git-filter-repo.py --invert-paths --path-glob "*.zip" --path-glob "*.jar" --replace-refs update-no-add -f


Recently used this to remove the archive directory:
python C:\work\adminrepo\tools\git-filter-repo.py --invert-paths --replace-refs update-no-add -f --path archive
