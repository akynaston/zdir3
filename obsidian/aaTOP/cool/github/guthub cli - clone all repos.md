To clone all repos from github:

```
gh auth login
```

Now you can clone any number of repos under a new `./myorgname` folder. Replace `myorgname` with your org name, or delete it to get repos just in your personal area:

```
gh repo list myorgname --limit 4000 | while read -r repo _; do
  gh repo clone "$repo" "$repo"
done
```