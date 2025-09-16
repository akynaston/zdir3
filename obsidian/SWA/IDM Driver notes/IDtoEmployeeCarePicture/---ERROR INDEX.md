12/18/2024 11:16:13 AM
Seems the login expires . .

DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoEmployeeCarePicture
     Channel:  Subscriber
     Object:   \DEV_SWACO_ID\swaiddev\Users\e97455875
     Status:   Error
     Message:  <driver-operation-data class-name="User" command="add" dest-dn="\DEV_SWACO_ID\swaiddev\Users\e97455875" event-id="w11dcledirdi019#20241218180821#1#2:98acb221-5a27-4e9c-b243-21b2ac98275a" src-dn="\DEV_SWACO_ID\swaiddev\Users\e97455875">
        <response>
                <url-token/>
                <header/>
                <response-header Cache-Control="no-cache,must-revalidate,max-age=0,no-store,private" Content-Type="application/json;charset=UTF-8" Date="Wed, 18 Dec 2024 18:12:28 GMT" Strict-Transport-Security="max-age=63072000; includeSubDomains" Transfer-Encoding="chunked" WWW-Authenticate="Token" X-Content-Type-Options="nosniff" X-Robots-Tag="none"/>
                <value message="Unauthorized" status="401">[{"message":"Session expired or invalid","errorCode":"INVALID_SESSION_ID"}]</value>
        </response>
</driver-operation-data>


1/6/2025 10:47:54 AM

I the password is expried
   Message:  Code(-9174) A policy issued a "retry" status indicating that the current operation should be retried. Detail from policy: Retry Status: [1/5] IDtoEmployeeSvc-RETRY-001 : ErrorMsg=RETRY: HTTP 500 Server Error, SOAP faultcode=sf:INVALID_OPERATION_WITH_EXPIRED_PASSWORD


Example from faileventslog

```
[Medium][IDM][lib-RetryManager-IDtoEmployeeSvc][w11dcledirdi019][lib-RetryManager discarded event due to too many retries.]
LIB-RETRY-START<add cached-time="20241220202729.230Z" class-name="User" event-id="w11dcledirdi019#20241220202729#3#1:90a6fdd9-43f9-4b90-ae46-d9fda690f943" qualified-src-dn="O=swaiddev\OU=Users\CN=r8201017450" src-dn="\DEV_SWACO_ID\swaiddev\Users\r8201017450" src-entry-id="593119" timestamp="1734726449#7">
        <add-attr attr-name="Given Name">
                <value timestamp="1734726445#10" type="string">Barry</value>
        </add-attr>
        <add-attr attr-name="Surname">
                <value timestamp="1734726445#19" type="string">Johnson</value>
        </add-attr>
        <add-attr attr-name="swaEmpSvcBaseRole">
                <value timestamp="1734726449#7" type="string">EmployeeSvc_Retiree|||00E2h000000RMT8EAO|||00e2h000000EcgoAAC</value>
        </add-attr>
        <add-attr attr-name="swaStatus">
                <value timestamp="1734726445#8" type="string">A</value>
        </add-attr>
        <operation-data DRIVER_REVISION="12.5.8" LIBIN-executeRetry="IDtoEmployeeSvc-RETRY-001 : ErrorMsg=RETRY: HTTP 500 Server Error, SOAP faultcode=sf:INVALID_OPERATION_WITH_EXPIRED_PASSWORD" objectType="retiree"/>
</add>LIB-RETRY-END
```