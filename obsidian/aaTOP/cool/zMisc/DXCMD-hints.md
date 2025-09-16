2/14/2024 3:35:31 PM
If doing an update-job, and a 601 comes back . .need to document what MOnique finds . .may just be a missing ACL . .

DXCMD error codes list

2/15/2024 8:47:50 AM
 - DXCMD IdMUnit connector:
	 - 32: likely is dn is incorrect issue: had swaiddev, needed swa-idsat: likely needs to be full LDAP DN; touble check top O.
	 - 50: likely is a rights issue . .
	 -   org.idmunit.IdMUnitTestCase - ...FAILURE: DXCMD returned: [-1], error: [java.net.UnknownHostException: w11dcledirdi013.swacorp.com:1636
		 - This was because it was interpreting the port as part of the host name . .it doesn't support the :port format.