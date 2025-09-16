10/3/2024 12:39:33 PM
This at least pretty prints it - just a '.' for the filter. It reduces lots of spacing by defailt.

type bstack-Users-ToMigrate.json | jq . > clean.json && move clean.json bstack-Users-ToMigrate.json




