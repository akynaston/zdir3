2/14/2024 12:46:57 PM
ENTITLEMENT DRIVERS - sent to he IGA-COP chat just now . .we need to put them in git and autoamte use of idmprovadmin!
Two updates for you: - sent to the team
1 - It looks like all entitlement policy definitions in all non prod environments have been updated to use IDMProvAdmin. This is just a heads up to make sure we try to move everything over to this account assuming this is still the standard. Thanks all!

2 - These policy definitions don't appear to be in any drivers (they're under the DriversetV3 'Policies' container and I don't think we've stored this in Git yet.


![[Pasted image 20240214124740.png]]


related: - need to update dgidentity's to the ones in the tree . .likely imdprovadmin . .
![[Pasted image 20240214125316.png]]

2/14/2024 1:04:58 PM
Genreal tech debt, related to above: need to get all driver sets in git and get all gcvs in agreement across all envs - sent note to paull just now to see if we cna have a story on this.