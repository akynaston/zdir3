     Team responsible for the changes: CSCE


IDtoFusion

[11/21/24 15:01:58.856]:IDtoFusion ST:            EC: HTTP status: 200
[11/21/24 15:01:58.857]:IDtoFusion ST:            EC: HTTP phrase: OK
[11/21/24 15:01:58.857]:IDtoFusion ST:            EC: HTTP version: HTTP/1.1
[11/21/24 15:01:58.857]:IDtoFusion ST:            EC: Found SOAP faultcode=
[11/21/24 15:01:58.858]:IDtoFusion ST:            Token Value: "<?xml version="1.0" encoding="UTF-8"?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="urn:enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-
instance"><soapenv:Header><LimitInfoHeader><limitInfo><current>4893</current><limit>351000</limit><type>API REQUESTS</type></limitInfo></LimitInfoHeader></soapenv:Header><soapenv:Body><updateResponse><result><errors><message>unable to obtain exclusive access to
 this record or 1 records: a0H1I00000BhsluUAB</message><statusCode>UNABLE_TO_LOCK_ROW</statusCode></errors><id xsi:nil="true"/><success>false</success></result></updateResponse></soapenv:Body></soapenv:Envelope>".
[11/21/24 15:01:58.858]:IDtoFusion ST:          Arg Value: "<?xml version="1.0" encoding="UTF-8"?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="urn:enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-inst
ance"><soapenv:Header><LimitInfoHeader><limitInfo><current>4893</current><limit>351000</limit><type>API REQUESTS</type></limitInfo></LimitInfoHeader></soapenv:Header><soapenv:Body><updateResponse><result><errors><message>unable to obtain exclusive access to thi
s record or 1 records: a0H1I00000BhsluUAB</message><statusCode>UNABLE_TO_LOCK_ROW</statusCode></errors><id xsi:nil="true"/><success>false</success></result></updateResponse></soapenv:Body></soapenv:Envelope>".
[11/21/24 15:01:58.859]:IDtoFusion ST:      Action: do-set-local-variable("lvUpdateContactResult",scope="policy",token-substring(length="5",start="0",token-local-variable("lvUpdateContactResponse"))).
[11/21/24 15:01:58.859]:IDtoFusion ST:        arg-string(token-substring(length="5",start="0",token-local-variable("lvUpdateContactResponse")))
[11/21/24 15:01:58.860]:IDtoFusion ST:          token-substring(length="5",start="0",token-local-variable("lvUpdateContactResponse"))
[11/21/24 15:01:58.860]:IDtoFusion ST:            token-substring(length="5",start="0",token-local-variable("lvUpdateContactResponse"))
[11/21/24 15:01:58.860]:IDtoFusion ST:              token-local-variable("lvUpdateContactResponse")
[11/21/24 15:01:58.860]:IDtoFusion ST:                Token Value: "<?xml version="1.0" encoding="UTF-8"?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="urn:enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSch
ema-instance"><soapenv:Header><LimitInfoHeader><limitInfo><current>4893</current><limit>351000</limit><type>API REQUESTS</type></limitInfo></LimitInfoHeader></soapenv:Header><soapenv:Body><updateResponse><result><errors><message>unable to obtain exclusive acces
s to this record or 1 records: a0H1I00000BhsluUAB</message><statusCode>UNABLE_TO_LOCK_ROW</statusCode></errors><id xsi:nil="true"/><success>false</success></result></updateResponse></soapenv:Body></soapenv:Envelope>".
[11/21/24 15:01:58.861]:IDtoFusion ST:              Arg Value: "<?xml version="1.0" encoding="UTF-8"?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="urn:enterprise.soap.sforce.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-
instance"><soapenv:Header><LimitInfoHeader><limitInfo><current>4893</current><limit>351000</limit><type>API REQUESTS</type></limitInfo></LimitInfoHeader></soapenv:Header><soapenv:Body><updateResponse><result><errors><message>unable to obtain exclusive access to
 this record or 1 records: a0H1I00000BhsluUAB</message><statusCode>UNABLE_TO_LOCK_ROW</statusCode></errors><id xsi:nil="true"/><success>false</success></result></updateResponse></soapenv:Body></soapenv:Envelope>".
[11/21/24 15:01:58.861]:IDtoFusion ST:            Token Value: "<?xml".


