2/26/2025 2:55:26 PM

These are actual calls I'm using at swa to confirm users are part of a qualification . . some cleanup can be done; but this is just to note that the extra parenthesis are required when doing it in IdMUnit.

```

mainResult.read("$.items[?(@.id=='avio_qual_b737')].users[?(@.id == '8566004598')]")


mainResult.read("$.items[?(@.id=='avio_qual_b737')]")

mainResult.read("$.items[?(@.id=='avio_qual_b737f')]")

```