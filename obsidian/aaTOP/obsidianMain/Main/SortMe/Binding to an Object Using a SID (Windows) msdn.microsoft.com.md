# Binding to an Object Using a SID (Windows) [msdn.microsoft.com]

# Binding to an Object Using a SID

0 out of 1 rated this helpful \- [Rate this topic](http://msdn.microsoft.com/en-us/library/ms675562(VS.85).aspx#feedback)

In Windows Server 2003, it is possible to bind to an object using the object Security Identifier (SID) as well as a GUID. The object SID is stored in the **objectSID** attribute. Binding to an SID does not work on Windows 2000.

The LDAP provider for Active Directory Domain Services provides a method to bind to an object using the object SID. The binding string format is:

LDAP://servername/<SID=XXXXX>

In this example, "servername" is the name of the directory server and "XXXXX" is the string representation of the hexadecimal value of the SID. The "servername" is optional. The SID string is specified in a form where each character in the string is the hexadecimal representation of each byte of the SID. For example, if the array is:

0xAB 0x14 0xE2

the SID binding string would be "<SID=AB14E2>". The [**ADsEncodeBinaryData**](http://msdn.microsoft.com/en-us/library/aa772180(v=vs.85).aspx) function should not be used to convert the SID array into a string because it precedes each byte character with a backslash, which is not a valid bind string format.

The SID string can also take the form "<SID=S-X-X-XX-XXXXXXXXXX-XXXXXXXXXX-XXXXXXXXX-XXX>", where the "S-X-X-XX-XXXXXXXXXX-XXXXXXXXXX-XXXXXXXXX-XXX" portion is the same as the string returned by the [**ConvertSidToStringSid**](http://msdn.microsoft.com/en-us/library/aa376399(v=vs.85).aspx) function.

When binding using the object SID, some [**IADs**](http://msdn.microsoft.com/en-us/library/aa705950(v=vs.85).aspx) and [**IADsContainer**](http://msdn.microsoft.com/en-us/library/aa705985(v=vs.85).aspx) methods and properties are not supported. The following **IADs** properties are not supported by objects obtained by binding using the object SID:

* [**ADsPath**](http://msdn.microsoft.com/en-us/library/aa746351(v=vs.85).aspx)
* [**Name**](http://msdn.microsoft.com/en-us/library/aa746351(v=vs.85).aspx)
* [**Parent**](http://msdn.microsoft.com/en-us/library/aa746351(v=vs.85).aspx)

The following **IADsContainer** methods are not supported by objects obtained by binding using the object SID:

* [**GetObject**](http://msdn.microsoft.com/en-us/library/aa705989(v=vs.85).aspx)
* [**Create**](http://msdn.microsoft.com/en-us/library/aa705987(v=vs.85).aspx)
* [**Delete**](http://msdn.microsoft.com/en-us/library/aa705988(v=vs.85).aspx)
* [**CopyHere**](http://msdn.microsoft.com/en-us/library/aa705986(v=vs.85).aspx)
* [**MoveHere**](http://msdn.microsoft.com/en-us/library/aa705991(v=vs.85).aspx)

To use these methods and properties after binding to an object using the object SID, use the [**IADs.Get**](http://msdn.microsoft.com/en-us/library/aa746347(v=vs.85).aspx) method to retrieve the object distinguished name and then use the distinguished name to bind to the object again.

The following code example shows how to convert an **objectSid** into a bindable string.

HRESULT VariantArrayToBytes(VARIANT Variant, 
    LPBYTE \*ppBytes, 
    DWORD \*pdwBytes);

/\*\*\*\*\*\*\*\*

    GetSIDBindStringFromVariant()

    Converts a SID in VARIANT form, such as an objectSid value, and 
    converts it into a bindable string in the form:

    LDAP://<SID=xxxxxxx...>

    The returned string is allocated with AllocADsMem and must be 
    freed by the caller with FreeADsMem.

\*\*\*\*\*\*\*\*\*/

LPWSTR GetSIDBindStringFromVariant(VARIANT vSID)
{
    LPWSTR pwszReturn = NULL;

    if(VT\_ARRAY & vSID.vt) 
    {
        HRESULT hr;
        LPBYTE pByte;
        DWORD dwBytes = 0;

        hr = VariantArrayToBytes(vSID, &pByte, &dwBytes);
        if(S\_OK == hr)
        {
            // Convert the BYTE array into a string of hex 
		          // characters.
            CComBSTR sbstrTemp = "LDAP://<SID=";

            for(DWORD i = 0; i < dwBytes; i++)
            {
                WCHAR wszByte\[3\];

                swprintf\_s(wszByte, L"%02x", pByte\[i\]);
                sbstrTemp += wszByte;
            }

            sbstrTemp += ">";
            pwszReturn = 
               (LPWSTR)AllocADsMem((sbstrTemp.Length() + 1) \* 
                sizeof(WCHAR));
            if(pwszReturn)
            {
                wcscpy\_s(pwszReturn, sbstrTemp.m\_str);
            }

            FreeADsMem(pByte);
        }
    }

    return pwszReturn;
}

/\*\*\*\*\*\*\*\*\*

    VariantArrayToBytes()

    This function converts a VARIANT array into an array of BYTES. 
    This function allocates the buffer using AllocADsMem. The 
    caller must free this memory with FreeADsMem when it is no 
    longer required.

\*\*\*\*\*\*\*\*\*\*/

HRESULT VariantArrayToBytes(VARIANT Variant, 
    LPBYTE \*ppBytes, 
    DWORD \*pdwBytes)
{
    if(!(Variant.vt & VT\_ARRAY) ||
        !Variant.parray ||
        !ppBytes ||
        !pdwBytes)
    {
        return E\_INVALIDARG;
    }

    \*ppBytes = NULL;
    \*pdwBytes = 0;

    HRESULT hr = E\_FAIL;
    SAFEARRAY \*pArrayVal = NULL;
    CHAR HUGEP \*pArray = NULL;
    
    // Retrieve the safe array.
    pArrayVal = Variant.parray;
    DWORD dwBytes = pArrayVal->rgsabound\[0\].cElements;
    \*ppBytes = (LPBYTE)AllocADsMem(dwBytes);
    if(NULL == \*ppBytes) 
    {
        return E\_OUTOFMEMORY;
    }

    hr = SafeArrayAccessData(pArrayVal, (void HUGEP \* FAR \*) &pArray);
    if(SUCCEEDED(hr))
    {
        // Copy the bytes to the safe array.
        CopyMemory(\*ppBytes, pArray, dwBytes);
        SafeArrayUnaccessData( pArrayVal );
        \*pdwBytes = dwBytes;
    }
    
    return hr;
}

[Send comments about this topic to Microsoft](mailto:wsddocfb@microsoft.com?subject=Documentation%20feedback%20[ad\ad]:%20Binding%20to%20an%20Object%20Using%20a%20SID%20%20RELEASE:%20(10/26/2012)&body=%0A%0APRIVACY%20STATEMENT%0A%0AThe%20doc%20team%20uses%20your%20feedback%20to%20improve%20the%20documentation.%20We%20don't%20use%20your%20email%20address%20for%20any%20other%20purpose.%20We'll%20remove%20your%20email%20address%20from%20our%20system%20after%20the%20issue%20that%20you%20are%20reporting%20is%20resolved.%20While%20we%20are%20working%20to%20resolve%20this%20issue,%20we%20may%20send%20you%20an%20email%20message%20to%20request%20more%20info%20about%20your%20feedback.%20After%20the%20issue%20is%20addressed,%20we%20may%20send%20you%20an%20email%20message%20to%20let%20you%20know%20that%20your%20feedback%20has%20been%20addressed.%0A%0AFor%20more%20info%20about%20Microsoft's%20privacy%20policy,%20see%20http://privacy.microsoft.com/en-us/default.aspx.)

Build date: 10/26/2012
