10/24/2024 3:35:42 PM
Working with Mike - found I can do this to get members from a group . . 

curl --location --request GET "https://gitlab-tools.swacorp.com/api/v4/groups/1391/members" --header "PRIVATE-TOKEN: uZcTwadnUKxyc15PFEHe" | jq . | more

![[Pasted image 20241024153525.png]]