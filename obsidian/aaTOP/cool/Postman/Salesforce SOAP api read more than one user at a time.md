6/2/2025 11:28:00 AM
API to read lots ofusers at once:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:enterprise.soap.sforce.com">
    <soapenv:Header>
        <urn:SessionHeader>
            <urn:sessionId>{{empsesid}}</urn:sessionId>
        </urn:SessionHeader>
    </soapenv:Header>
    <soapenv:Body>
        <urn:query>
            <urn:queryString>SELECT username, Id, Name, EmployeeNumber, FederationIdentifier, Profile.Name, UserRole.Name, IsActive FROM User  WHERE 
                FederationIdentifier='e100299' or
                FederationIdentifier='e113460' or 
                FederationIdentifier='e117472' or 
                FederationIdentifier='e121337' or 
                FederationIdentifier='e122409' or 
                FederationIdentifier='e128636' or 
                FederationIdentifier='e139209' or 
                FederationIdentifier='e143619' or 
                FederationIdentifier='e145504' or 
                FederationIdentifier='e146439' or 
                FederationIdentifier='e146554' or 
                FederationIdentifier='e148044' or 
                FederationIdentifier='e153744' or 
                FederationIdentifier='e155130' or 
                FederationIdentifier='e159976' or 
                FederationIdentifier='e162305' or 
                FederationIdentifier='e183530' or 
                FederationIdentifier='e5605' or 
                FederationIdentifier='e90558' or 
                FederationIdentifier='e96486' or 
                FederationIdentifier='e99855'       
            </urn:queryString>         
        </urn:query>
    </soapenv:Body>
</soapenv:Envelope>