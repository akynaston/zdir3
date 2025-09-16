6/14/2024 12:41:35 PM
Summar
At around 12:30 today, the core team came to me about a prod issue that caused the IDtoAlteaSignDB driver to go into infinite retry. a user has a single ' mark in their email address, so the SQL update atempt appeard like this: EMAIL_TXT='Dustin.O'Bright@wnco.com', meaning  the single tick marks were not parsed correctly.

originaiting event:
```
<modify cached-time="20240611172451.021Z" class-name="User" event-id="w11pcledirpi011#20240611172450#2#2:c6f2d417-c1ff-48d2-a7c5-17d4f2c6ffc1" qualified-src-dn="O=SWA-ID\OU=Users\CN=x256287" src-dn="\SWACO_ID\SWA-ID\Users\x256287" src-entry-id="111798" timestamp="0#0">
<modify-attr attr-name="swaAlteaOfficeID">
<remove-value>
<value timestamp="1669220955#1" type="string">DSMWN01GS</value>
</remove-value>
<add-value>
<value timestamp="1718126691#2" type="string">DALWN01XX</value>
</add-value>
</modify-attr>
</modify>
```


result:
&lt;description>An error occurred executing statement "update RES_DCS_USER set FRST_NME_TXT='Dustin', LST_NME_TXT='OBright', EMAIL_TXT='Dustin.O'Bright@wnco.com', EMP_STAT_IND='T', EMP_NUM='x256287', RES_USER_TYPE_CDE='C', LCK_STAT_IND='N', LCK_STAT_UTC_DT=getUTCdate(), UPDT_IND='Y', LST_UPDT_UTC_DT=getUTCdate(), DFLT_OFC_ID='DALWN01XX' where RES_USER_ID='X256287'".  There is a connectivity-related problem.&lt;/description>
&lt;jdbc:exception jdbc:class="java.sql.SQLException" jdbc:error-code="0" jdbc:sql-state="22025" xmlns:jdbc="urn:dirxml:jdbc">
&lt;jdbc:message>Invalid SQL statement or JDBC escape, terminating ''' not found.&lt;/jdbc:message>
&lt;/jdbc:exception><application>DirXML</application>
<module>IDtoAlteaSignDB</module>
<object-dn>\SWACO_ID\SWA-ID\Users\x256287</object-dn>
<component>Subscriber</component>



tried to fix; user doesn't exist anyway - due to the tick mostlikely.

select * from RES_DCS_USER where RES_USER_ID='X256287';

 update RES_DCS_USER set FRST_NME_TXT='Dustin', LST_NME_TXT='OBright', EMAIL_TXT='Dustin.O''Bright@wnco.com', EMP_STAT_IND='T', EMP_NUM='x256287', RES_USER_TYPE_CDE='C', LCK_STAT_IND='N', LCK_STAT_UTC_DT=getUTCdate(), UPDT_IND='Y', LST_UPDT_UTC_DT=getUTCdate(), DFLT_OFC_ID='DALWN01XX' where RES_USER_ID='X256287'


We need 5 new stories:

Irequested these from farhan:


Sanitize ' with '' for all fields in IDtoAlteaSignDB - users not in the database maybe . .
   - other characters that need escaping
   - which fields to escape?
      email: only use eid@wnco.com for users with issues . . .
   - Need to report Farhan
   - Ops & Core & Brandon: priority can let us know priority . .
   - Stories: prefixed with point estimate
     - 1 - IDtoAlteaSignDB | IDM | Research which characters need to be escaped in an SQL statment.
     - 2 - IDtoAlteaSignDB | IDM | Research which fileds could have characters that need escaping.
     - 2 - IDtoAlteaSignDB | IDM | DEV Update escpaing in code.
     - 1 - IDtoAlteaSignDB | IDM | QA deploy escaping fixes.
     - 1 - IDtoAlteaSignDB | IDM | PROD deploy escaping fixes.
   -
