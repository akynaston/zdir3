To reference an external ECMA script in the global library, add it here, then deploy your driver. Don't forget to export your driver so it is included in your next build and MR:

![[Pasted image 20240319130534.png]]

This show an example of where/how to assign policies: right click on the folder, and select 'Link Existing Policy in Set' to select the external object. This is identical to how all policies are added - policies like this are unique only because they exist outside of the driver - in the SWALibrary in this case (global-idm-library repo).
![[Pasted image 20240319130610.png]]