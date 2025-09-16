11/18/2024 4:51:45 PM - don't forget its 'include' and 'exclude' - not pural, otherwise this is good:
```
grep --include="*.xml" --exclude-dir=final --exclude-dir=build swaPersonType -Ri *
```