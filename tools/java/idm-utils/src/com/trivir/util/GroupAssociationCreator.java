package com.trivir.util;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.nio.charset.StandardCharsets;

public class GroupAssociationCreator {

    public static String server = "w11scwaddsdv001.devad.swacorp.com";
    public static String port = "636";
    public static String user = "CN=NVID,OU=Service Accounts,OU=Admin,DC=DEVAD,DC=SWACORP,DC=com";
    public static String pass = "novell";

    public static String searchBase = "OU=Groups,OU=SWACO,DC=DEVAD,DC=SWACORP,DC=com";
/*
    //ldap://hdqqcwqaad100.QAAD.SWACORP.COM:636/????X-CONNECTION-NAME=QA-AD-hdqqcwqaad100.QAAD.SWACORP.COM,
    // X-ENCRYPTION=ldaps,X-BIND-USER=QAAD%5Cnvid,X-BIND-PASSWORD=N0v3ll,X-COUNT-LIMIT=1000

    public static String server = "hdqqcwqaad100.QAAD.SWACORP.COM";
    public static String port = "636";
    public static String user = "QAAD\\nvid";//"CN=NVID,OU=Service Accounts,OU=Admin,DC=QAAD,DC=SWACORP,DC=com";
    public static String pass = "N0v3ll";

    public static String searchBase = "OU=Groups,OU=SWACO,DC=QAAD,DC=SWACORP,DC=com";
*/

    public static void main(String[] args) throws Exception {
        byte[] testAssoc = new byte[16];

        dowork();

        //From association (apache shows this too)   e3f36e91 e09a f547 a3ab 1c3aa442a3e1
        //From actual 'objectGuid' attribute in AD: {916ef3e3-9ae0-47f5-a3ab-1c3aa442a3e1}
        //e3f36e91e09af547a3ab1c3aa442a3e1
        testAssoc[0] = (byte)0xe3;
        testAssoc[1] = (byte)0xf3;
        testAssoc[2] = (byte)0x6e;
        testAssoc[3] = (byte)0x91;
        testAssoc[4] = (byte)0xe0;
        testAssoc[5] = (byte)0x9a;
        testAssoc[6] = (byte)0xf5;
        testAssoc[7] = (byte)0x47;
        testAssoc[8] = (byte)0xa3;
        testAssoc[9] = (byte)0xab;
        testAssoc[10] = (byte)0x1c;
        testAssoc[11] = (byte)0x3a;
        testAssoc[12] = (byte)0xa4;
        testAssoc[13] = (byte)0x42;
        testAssoc[14] = (byte)0xa3;
        testAssoc[15] = (byte)0xe1;

        String results = convertToDashedString(testAssoc);
        int x = 1;
        x++;
    }

    public static void dowork() throws Exception {
        LdapConnectionHelper ldapconn = new LdapConnectionHelper();
        DirContext ctx = ldapconn.createLdapConnection(server, user, pass, null, null, true, true);
        // First, search for all groups, and retreive their guids:
        SearchControls sc = new SearchControls();
        //sc.setCountLimit(1);
        sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
        sc.setReturningAttributes(new String[]{"objectGuid"});
        NamingEnumeration<SearchResult> ne = ctx.search(searchBase, "cn=AADC_SQL_RW_S", sc);

        while (ne.hasMore()) {
            SearchResult result = ne.next();
            String groupDN = result.getName();
            Attributes attrs = result.getAttributes();
            Attribute attrGuid = attrs.get("objectGuid");
            Object guid = attrGuid.get();
            byte[] guidarray = guid.toString().getBytes(StandardCharsets.UTF_8);
/*
            guidarray = {byte[24]@1828} [35, 32, 102, -17, -65, -67, 31, 51, -17, -65, +14 more]
            0 = 35
            1 = 32
            2 = 102
            3 = -17
            4 = -65
            5 = -67
            6 = 31
            7 = 51
            8 = -17
            9 = -65
            10 = -67
            11 = 75
            12 = -17
            13 = -65
            14 = -67
            15 = 32
            16 = 101
            17 = 16
            18 = 46
            19 = -17
            20 = -65
            21 = -67
            22 = -54
            23 = -75
  */
            String assocValue = convertToDashedString(guidarray);

            //89da2817-bfef-efbd-bfbd-efbfbd4cefbf

            //CN=AADC_SQL_RW_S:
            // cn=IDtoAD,cn=Driver Set v3,ou=DirXML,ou=services,o=swa-idsat#1#
            //           e3f36e91 e09a f547 a3ab 1c3aa442a3e1
            // guid is: {916ef3e3-9ae0-47f5-a3ab-1c3aa442a3e1}

            int x = 0;
            x++;
        }
    }
    // from: https://stackoverflow.com/questions/33214007/how-to-get-decoded-objectguid-from-active-directory-using-unboundid-ldap-sdk-in
    public static String convertToDashedString(byte[] objectGUID) {
        //CN=AADC_SQL_RW_S,OU=Groups,OU=SWACO,DC=QAAD,DC=SWACORP,DC=com
        //Goal:
        //cn=IDtoAD,cn=Driver Set v3,ou=DirXML,ou=services,o=swa-idsat#1#e3f36e91e09af547a3ab1c3aa442a3e1          //           e3f36e91 e09a f547 a3ab 1c3aa442a3e1

        StringBuilder displayStr = new StringBuilder();

        displayStr.append(prefixZeros((int) objectGUID[0] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[1] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[2] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[3] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[4] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[5] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[6] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[7] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[8] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[9] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[10] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[11] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[12] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[13] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[14] & 0xFF));
        displayStr.append(prefixZeros((int) objectGUID[15] & 0xFF));
        return displayStr.toString();
    }


        private static String prefixZeros(int value) {
            if (value <= 0xF) {
                StringBuilder sb = new StringBuilder("0");
                sb.append(Integer.toHexString(value));

                return sb.toString();

            } else {
                return Integer.toHexString(value);
            }
        }




}
