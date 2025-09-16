#!/bin/bash

# Iterate through each file tracked by Git
git ls-tree -r --name-only HEAD | while read filename; do
  # Get the last modification date of the file from Git history
  last_modified=$(git log -1 --format="%ad" --date=iso -- "$filename")

  # If last_modified is empty, skip to the next file
  if [ -z "$last_modified" ]; then
    continue
  fi

  # Convert the date format
  formatted_date=$(date -d "$last_modified" "+%Y%m%d%H%M.%S")

  # Set the file's timestamp to the last modified time
  echo $last_modified
  echo touch -t "$formatted_date" "$filename"
  touch -t "$formatted_date" "$filename"

done
