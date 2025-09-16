3/28/2024 12:28:51 PM
Just spoke with joe; found we had to add DirXML-EntitlementRef to the DirXML-SharedProfile (Entitlement policy) to get it to assign. We knew there was an issue, because the RBEAEv1 trace said 'Ignoring empty entitlement'; but this tie seemed to fix it:

![[Pasted image 20240328122925.png]]