
![[Pasted image 20240611112300.jpg]]


WorkdayHCM:
  looks like the end point is unavailable:
   500 for URL: https://wd2-impl-services1.workday.com/ccx/service/swa_preview/Human_Resources/v32.0

IDtoSWAUMoble is stuck in a retry; looks like our auth info has expired in some way:
    DirXML Log Event -------------------
       Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\SDC Driver Set\IDtoSWAUMobile
       Channel:  Subscriber
       Status:   Retry
       Message:  Code(-9174) A policy issued a "retry" status indicating that the current operation should be retried. Detail from policy: Retry Status: [1/5] IDtoSWAUMobile-RETRY-0001 : ErrorMsg={"body":"{\"statusCode\":401,\"appCode\":\"UNAUTHORIZED\",\"message\":\"Unauthorized\"}","error":"RETRY: ","status":"401"}

RapidRewardsV2 - looksl ike we have bad username/password
[05/24/24 09:19:27.002]:RapidRewards_v2 ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set v3\RapidRewards v2
     Channel:  Subscriber
     Status:   Fatal
     Message:  Code(-9005) The driver returned a "fatal" status indicating that the driver should be shut down. Detail from driver: <description>Unab
le to connect.  Authentication failed.</description>
<object-dn>O=swaiddev\OU=Users\CN=e189392</object-dn>
<jdbc:exception jdbc:class="java.sql.SQLException" jdbc:error-code="1017" jdbc:sql-state="72000" xmlns:jdbc="urn:dirxml:jdbc">
        <jdbc:message>ORA-01017: invalid username/password; logon denied
</jdbc:message>

6/11/2024 11:22:29 AM
WorkdayHCM:
  looks like the end point is unavailable:
   500 for URL: https://wd2-impl-services1.workday.com/ccx/service/swa_preview/Human_Resources/v32.0

IDtoSWAUMoble is stuck in a retry; looks like our auth info has expired in some way:
    DirXML Log Event -------------------
       Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\SDC Driver Set\IDtoSWAUMobile
       Channel:  Subscriber
       Status:   Retry
       Message:  Code(-9174) A policy issued a "retry" status indicating that the current operation should be retried. Detail from policy: Retry Status: [1/5] IDtoSWAUMobile-RETRY-0001 : ErrorMsg={"body":"{\"statusCode\":401,\"appCode\":\"UNAUTHORIZED\",\"message\":\"Unauthorized\"}","error":"RETRY: ","status":"401"}

RapidRewardsV2 - looksl ike we have bad username/password
[05/24/24 09:19:27.002]:RapidRewards_v2 ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set v3\RapidRewards v2
     Channel:  Subscriber
     Status:   Fatal
     Message:  Code(-9005) The driver returned a "fatal" status indicating that the driver should be shut down. Detail from driver: <description>Unab
le to connect.  Authentication failed.</description>
<object-dn>O=swaiddev\OU=Users\CN=e189392</object-dn>
<jdbc:exception jdbc:class="java.sql.SQLException" jdbc:error-code="1017" jdbc:sql-state="72000" xmlns:jdbc="urn:dirxml:jdbc">
        <jdbc:message>ORA-01017: invalid username/password; logon denied
</jdbc:message>




8/8/2024 7:35:26 PM
INC6045630 - RBEAEV1 - big cache: from my initial migration . .