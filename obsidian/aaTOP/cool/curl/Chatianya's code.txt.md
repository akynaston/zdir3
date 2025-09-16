for x in `cat /Users/e160743/Downloads/accounts_aaron.txt`; do echo $x========; results=$(curl -s --location --request GET "https://pvwa.cis.dev.swacorp.com/PasswordVault/api/Accounts?search=$x" \

            --header 'Content-Type: application/json' \

            --header $Authorization |  python3 -mjson.tool) ; jq --arg account_name "$x" '. += $ARGS.named' <<<"$results" >> /Users/e160743/Downloads/aarons_list.json; done





cat /Users/e160743/Downloads/aaron1.json | jq -r '. | select(.count == 0) | .account_name'