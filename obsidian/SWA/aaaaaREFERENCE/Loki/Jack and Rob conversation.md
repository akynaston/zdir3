```
6/25/2025 10:59:48 AM
Jack & Rob inc
 - example string
https://em-grafana.ris.qa.swacorp.com/d/hqrdOl0Il/edir-centralized-dashboard-qa?orgId=12
Akami edit . .


 - Register driver in Loki!

sum by (driver, description, hostname)(count_over_time({job="Security_Driver_Log_Monitor_QA_1"} | pattern "<_>]:<driver> ST:msgStart <description> msgEnd" |= "has been deprovisioned from Akamai Group on IDM, Please remove access for"[1m])) or vector(0)

doesn't pick it up with in 5 mins . .

yellow line means in progress, green means sent . .
 - suppression: groups all in one bucket . .
 - then wait 5 more minutes for email/INC to generate . .
 - two different cases for resolution:
   - if email: wait until I got email, can generate new one
   - if inc: won't generate another one until 'closed'.
     - generate same condition: appends this second to that ticket.

What we are going to is use sentinel to create dash ticket . .

 - Loki is looking at /opt/idmlogs directory . .
 - IDM driver dev - no connection to remote loadder

ST:msgStart:IDtoApptio: msgEnd
if have problems mucked up in Loki - Gerald Dunn . .can help . .
   - Aneal REaddy is theother guy . Ready Done . .





```

Aaron's driver alert test originally:
sum by (driver, hostname)(count_over_time({job="Security_Driver_Log_Monitor_QA_1"} | pattern "<_>]:<driver> <_> <description>" |= "500 Internal Server Error"[1m])) or vector(0)

changed to this:
sum by (driver, description, hostname)(count_over_time({job="Security_Driver_Log_Monitor_QA_1"} | pattern "<_>]:<driver> ST:msgStart <description> msgEnd" |= "has been deprovisioned from Akamai Group on IDM, Please remove access for"[1m])) or vector(0)


## IDM Driver DEV - Aaron's Alert test
now this to trigger anything
sum by (driver, description, hostname)(count_over_time({job="Security_Driver_Log_Monitor_QA_1"} | pattern "<_>]:<driver> ST:Start trasnaction" |= "Event has started - variable here"[1m])) or vector(0)