8/13/2024 1:17:46 PM
TODO: 


Some drivers trigger the ident query regularly . .think it may be due to health jobs; workaround is to block it like this:

```

if-op-class = __identquery__ veto . .
```

or:

```
<xsl:template match="query[not(search-class/@class-name='__driver_identification_class__')]">
```