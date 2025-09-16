grep -Fxv -f first-file.txt second-file.txt
Basically looks for all lines in second-file.txt which don't match any line in first-file.txt. Might be slow if the files are large.



