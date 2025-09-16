# BAESUK - hrdsdataservice info

Zili,

Thank you for this information. Can we have a copy of the WSDL for this web service? We need the actual WSDL file to mock up a stub in our dev environment.

Thanks,
Glen Knutti
703-375-9030
TriVir LLC

On Thu, Nov 30, 2017 at 9:52 AM, Gao, Zili (UK) <[zili.gao2@baesystems.com](mailto:zili.gao2@baesystems.com)\> wrote:

Hi Glen,

Please see the following web page that shows how the HR Data Service (HDS) API (**FN\_EXPORT\_AUTH\_EXTRACT).** Once your engineers get access to AS test environment and have accounts setup in HDS, you should be able to access it.

In AS test environment IDV is able to connect to HDS web server via Basic Authentication (we need to test this with HDS team once the IDV Linux machine is provisioned); but the account will only return data based on Success Factor training database (i.e. no prod data).

Example call: <https://hrfsdataservice.ent.baesystems.com:3000/HRDataService.aspx?op=FN_EXPORT_AUTH_EXTRACT&FMT=XML>

The sample data Tom prepared for SF people is based on the call (i.e. data from training DB)

BR,
Zili

Calling interfaces for **FN\_EXPORT\_AUTH\_EXTRACT** . Export Controls custom extractSOAP 1.1, SOAP 1.2 or HTTP Post interfaces are described within under [/HRDataService.asmx?op=FN_EXPORT_AUTH_EXTRACT](https://dwtest.ent.baesystems.com:1000/HRDataService.asmx?op=FN_EXPORT_AUTH_EXTRACT)Web Service response data is obtained via /HRDataService.aspx?op=FN\_EXPORT\_AUTH\_EXTRACTe.g. <https://dwtest.ent.baesystems.com:1000/HRDataService.aspx?op=FN_EXPORT_AUTH_EXTRACT&FMT=XML&SCHEMA=IGNORE>

|     |     |     |     |
| --- | --- | --- | --- |
| API Parameters |     |     |     |     |     |
| **Name** | **Values** | **Default** | **Description** |     |     |
| FMT | XML, JSON | XML | Specifies the response format (JSON file or XML response) |     |     |
| ACTION | STREAM, DOWNLOAD | STREAM | Return data within the web service HTTP response or as a download file. Applies to FMT=XML only |     |     |
| SCHEMA | IGNORE, INCLUDE | INCLUDE | Specifies whether responses includes the schema definition. Applies to FMT=XML only |     |     |
| BASELINE | <snapshot name> |     | Saves the returned data under a named basline, for later comparison via a COMPARE operation |     |     |
| COMPARE | <snapshot name> |     | Compare response to a named baseline, returning only additions, changes and deletions |     |     |
| GCI | <GCI> | %   | GCI number |     |     |
| API Response Fields |     |     |     |     |     |
| **Name** |     |     | **Type** | **Description** | **Primary Key** |
| GCI |     |     | System.String | GCI Number | Y   |
| Employee\_Number |     |     | System.String | Legacy Payroll Number |     |
| First\_Name |     |     | System.String | First Name |     |
| Preferred\_Name |     |     | System.String | Preferred First Name |     |
| Surname |     |     | System.String | Last Name |     |
| Email |     |     | System.String | Email Address (Business) |     |
| Employee\_Date\_Of\_Birth |     |     | System.DateTime | Date Of Birth |     |
| EC\_Awareness\_Training\_Last\_Completed |     |     | System.DateTime | Export Controls Awareness Training Completed (Last) |     |
| EC\_Enhanced\_Training\_Last\_Completed |     |     | System.DateTime | Export Controls Enhanced Training Completed (Last) |     |
| Contract\_Type |     |     | System.String | Contract Type (Contingent Worker, Employee, ...) |     |
| Is\_Direct\_Employee |     |     | System.String | Direct Employee Indicator |     |
| Job\_Title |     |     | System.String | Job Title |     |
| Line\_Manager\_GCI |     |     | System.String | Line Manager GCI |     |
| Company\_Start\_Date |     |     | System.DateTime | Continuous Service Start Date |     |
| Employment\_End\_Date |     |     | System.DateTime | Employment End Date (from Contingent Worker End Date if available, otherwise Employment End Date) |     |
| Last\_Day\_At\_Work |     |     | System.DateTime | Last Day At Work |     |
| Place\_Of\_Work\_Code |     |     | System.String | Place Of Work Code |     |
| Place\_Of\_Work |     |     | System.String | Place Of Work Name |     |
| Legal\_Entity\_Code |     |     | System.String | Legal Entity Code (Home) |     |
| Legal\_Entity\_Name |     |     | System.String | Legal Entity Name (Home) |     |
| Enterprise\_Code |     |     | System.String | Enterprise Code (Home) |     |
| Enterprise\_Name |     |     | System.String | Enterprise Name (Home) |     |
| Group\_Code |     |     | System.String | Group Code (Home) |     |
| Group\_Name |     |     | System.String | Group Name (Home) |     |
| Business\_Level\_1\_Code |     |     | System.String | Business Level 1 Code (Home) |     |
| Business\_Level\_1\_Name |     |     | System.String | Business Level 1 Name (Home) |     |
| Business\_Level\_2\_Code |     |     | System.String | Business Level 2 Code (Home) |     |
| Business\_Level\_2\_Name |     |     | System.String | Business Level 2 Name (Home) |     |
| Business\_Level\_3\_Code |     |     | System.String | Business Level 3 Code (Home) |     |
| Business\_Level\_3\_Name |     |     | System.String | Business Level 3 Name (Home) |     |
| Department\_Level\_1\_Code |     |     | System.String | Department Level 1 Code (Home) |     |
| Department\_Level\_1\_Description |     |     | System.String | Department Level 1 Name (Home) |     |
| Department\_Level\_2\_Code |     |     | System.String | Department Level 2 Code (Home) |     |
| Department\_Level\_2\_Description |     |     | System.String | Department Level 2 Name (Home) |     |
| Department\_Level\_3\_Code |     |     | System.String | Department Level 3 Code (Home) |     |
| Department\_Level\_3\_Description |     |     | System.String | Department Level 3 Name (Home) |     |
| Function\_Code |     |     | System.String | Job Function Code (Home) |     |
| Function\_Name |     |     | System.String | Job Function Name (Home) |     |
| Department\_Code |     |     | System.String | Department Code (Home) |     |
| Department\_Name |     |     | System.String | Department Name (Home) |     |
| Secondment\_Start\_Date |     |     | System.DateTime | Secondment Start Date |     |
| Secondment\_End\_Date |     |     | System.DateTime | Secondment End Date |     |
| SECONDMENT\_Legal\_Entity\_Code |     |     | System.String | Legal Entity Code (host) |     |
| SECONDMENT\_Legal\_Entity\_Name |     |     | System.String | Legal Entity Name (host) |     |
| SECONDMENT\_Enterprise\_Code |     |     | System.String | Enterprise Code (host) |     |
| SECONDMENT\_Enterprise\_Name |     |     | System.String | Enterprise Name (host) |     |
| SECONDMENT\_Group\_Code |     |     | System.String | Group Code (host) |     |
| SECONDMENT\_Group\_Name |     |     | System.String | Group Name (host) |     |
| SECONDMENT\_Business\_Level\_1\_Code |     |     | System.String | Business Level 1 Code (host) |     |
| SECONDMENT\_Business\_Level\_1\_Name |     |     | System.String | Business Level 1 Name (host) |     |
| SECONDMENT\_Business\_Level\_2\_Code |     |     | System.String | Business Level 2 Code (host) |     |
| SECONDMENT\_Business\_Level\_2\_Name |     |     | System.String | Business Level 2 Name (host) |     |
| SECONDMENT\_Business\_Level\_3\_Code |     |     | System.String | Business Level 3 Code (host) |     |
| SECONDMENT\_Business\_Level\_3\_Name |     |     | System.String | Business Level 3 Name (host) |     |
| SECONDMENT\_Department\_Level\_1\_Code |     |     | System.String | Department Level 1 Code (host) |     |
| SECONDMENT\_Department\_Level\_1\_Description |     |     | System.String | Department Level 1 Name (host) |     |
| SECONDMENT\_Department\_Level\_2\_Code |     |     | System.String | Department Level 2 Code (host) |     |
| SECONDMENT\_Department\_Level\_2\_Description |     |     | System.String | Department Level 2 Name (host) |     |
| SECONDMENT\_Department\_Level\_3\_Code |     |     | System.String | Department Level 3 Code (host) |     |
| SECONDMENT\_Department\_Level\_3\_Description |     |     | System.String | Department Level 3 Name (host) |     |
| SECONDMENT\_Department\_Code |     |     | System.String | Department Code (Host) |     |
| SECONDMENT\_Department\_Name |     |     | System.String | Department Name (Host) |     |

\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*This email and any attachments are confidential to the intendedrecipient and may also be privileged. If you are not the intendedrecipient please delete it from your system and notify the [sender.You](http://sender.You) should not copy it or use it for any purpose nor disclose ordistribute its contents to any other person.\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
