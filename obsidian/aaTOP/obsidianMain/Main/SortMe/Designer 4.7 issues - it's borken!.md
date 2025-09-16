# Designer 4.7 issues - it's borken!

*  Schema compare can't come back clean
* Designer won't deploy policies/libraries at times: shows that objects have an invalid LDAP dn, and don't begin with a 'cn=', so the creation fails. Manual creation of at least a place holder of the same object class appears to be the workaround.
* odd connection loss: can brows treet sollect driver set adding area ; but get read time out amost immediately on driver compare.
	* fixable by restarting designer, but startup is really slow.
* LDAP Read Timeout: once seen when compareing drivers, there's no apparent coming back from this; you have to restart Designer, despite refreshing conect ect.  Other ldap operatoins work without fail; it's just the compare that seems to have issues reconnecting.

Startup is still slow.
