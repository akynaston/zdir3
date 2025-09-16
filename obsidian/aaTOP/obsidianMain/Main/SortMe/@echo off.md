# @echo off

[@echo](mailto:w@echo) off
xcopy C:\\work\\pb\_ocs\_oid Z:\\cdrive\\work\\Census-PBO-CS-OIDDriver /s/e/i/d/y
xcopy C:\\work\\idmUnit Z:\\cdrive\\work\\IdMUnit-Census /s/e/i/d/y

/\*
 \* IdMUnit - Automated Testing Framework for Identity Management Solutions
 \* Copyright (c) 2005-2006 TriVir, LLC
 \*
 \* This program is licensed under the terms of the GNU General Public License
 \* Version 2 (the "License") as published by the Free Software Foundation, and
 \* the TriVir Licensing Policies (the "License Policies").  A copy of the License
 \* and the Policies were distributed with this program.  
 \*
 \* The License is available at:
 \* http://www.gnu.org/copyleft/gpl.html
 \*
 \* The Policies are available at:
 \* http://www.idmunit.org/licensing/index.html
 \*
 \* Unless required by applicable law or agreed to in writing, this program is
 \* distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 \* OF ANY KIND, either express or implied.  See the License and the Policies
 \* for specific language governing the use of this program.
 \*
 \* www.TriVir.com
 \* TriVir LLC
 \* 11570 Popes Head View Lane
 \* Fairfax, Virginia 22030-5411
 \*
 \*/
package org.idmunit.extension;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.idmunit.IdMUnitException;
import org.idmunit.connector.ConnectionConfigData;
import org.idmunit.connector.LdapConnector;
import junit.framework.TestCase;
/\*\*
 \* This class is a bulk operation prototype for IdMUnit
 \*
 \* @author Brent Kynaston, Software Engineer, TriVir LLC
 \* @version %I%, %G%
 \*/
public class BulkOpPrototype extends TestCase {
        // Configuration parameters
        // --------------------------
        int m\_rangeStart = 1;
        int m\_rangeStop = 5;
        int m\_waitForCompletion = 10000;
        
        
        String m\_server = "172.17.2.13:390";
        String m\_admin = "cn=admin,o=services";
        String m\_admin\_password = "B2vPD2UsfKc="; // DES encrypted, base64// encoded with IdMUnit
                                                                                                        // EncTool
        String m\_target\_context="ou=FDCA,ou=USERS,ou=PEOPLEGROUPS,o=CENSUS";
        
        String m\_serverPBO = "172.17.2.14:389";
        String m\_adminPBO = "cn=orcladmin";
        String m\_admin\_passwordPBO = "3XrGujtdKVe/rZw35M4qjw=="; // DES// encrypted, base64 encoded with IdMUnit EncTool
        String m\_target\_contextPBO="cn=Users,cn=LCO-2026,cn=RCC-20,cn=HQ,cn=oceUsers,cn=Users,dc=fdca,dc=census2010,dc=gov";
        
        //String m\_serverFDCA = "172.17.2.13:389";
        //String m\_adminFDCA = "cn=orcladmin";
        //String m\_admin\_passwordFDCA = "3XrGujtdKVe/rZw35M4qjw=="; // DES// encrypted, base64 encoded with IdMUnit EncTool
        //String m\_target\_contextFDCA ="cn=Users,cn=LCO-2026,cn=RCC-20,cn=HQ,cn=oceUsers,cn=Users,dc=fdca,dc=census2010,dc=gov";
        
        
        long waittsdfime = 10000;
        PrintWriter pwLog = null;
        
        // --------------------------
        
    // private Map config;
//        LdapConnector m\_connectionFDCA;
        LdapConnector m\_connectionIDV;
        LdapConnector m\_connectionPBO;
        
        public void testAddBulkObjects() throws Exception {
                long startTime;
                long stopTime;
                long deletiontime;
            ArrayList<String> alUsersToValidateAndDelete = new ArrayList<String>();
//            DeleteObjects();
            
//            long startTime = System.currentTimeMillis();
//            AddObjects();
//            VerifyObjects();
//            long stopTime = System.currentTimeMillis();
//            
//            String finalResults = "\[" + m\_rangeStop + "\] users were added/validated in: \[" + (float)((stopTime - startTime))/1000 + "\] seconds.";
            boolean deleteOnlyInEdir = true;
            startTime = System.currentTimeMillis();
            DeleteObjects(deleteOnlyInEdir);
            deletiontime = waitForDeletetion();
            stopTime = System.currentTimeMillis();
            String finalResultsDelete = "\[" + m\_rangeStop + "\] users were deleted in: \[" + (float)(stopTime - startTime)/1000 + "\] seconds,  + \[" + deletiontime + "\] for driver to delete objects.";
//           logln(finalResults);
           logln(finalResultsDelete);
    }
        
        
        protected void setUp() throws Exception {
            super.setUp();
            // creds.setKeystorePath(keystorePath);
            //ConnectionConfigData credsFDCA = new ConnectionConfigData(m\_serverFDCA, m\_adminFDCA, m\_admin\_passwordFDCA);
            //m\_connectionFDCA = new LdapConnector();
            //m\_connectionFDCA.setup(configDataToMap(credsFDCA));
            ConnectionConfigData creds = new ConnectionConfigData(m\_server, m\_admin, m\_admin\_password);
            m\_connectionIDV = new LdapConnector();
            m\_connectionIDV.setup(configDataToMap(creds));
            ConnectionConfigData credsPBO = new ConnectionConfigData(m\_serverPBO, m\_adminPBO, m\_admin\_passwordPBO);
            m\_connectionPBO = new LdapConnector();
            m\_connectionPBO.setup(configDataToMap(credsPBO));
            
            pwLog = new PrintWriter(new FileWriter(new File("C:\\\\Work\\\\PB\_OCS\_OID\\\\resultLogs" + m\_rangeStop + ".log"), true));
            pwLog.println("\\r\\n\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*");
            pwLog.println(new Date());
            pwLog.println("Range: \[" + m\_rangeStart + "\] to \[" + m\_rangeStop + "\]");
                
        }
        protected void tearDown() throws Exception {
                super.tearDown();
                m\_connectionIDV.tearDown();
                m\_connectionPBO.tearDown();
        //                m\_connectionFDCA.tearDown();
                logln("...cleaning up system connection and tearing down processors...");
                pwLog.close();
        }
        
       public long waitForDeletetion() {
           logln("Now waiting for last object to be deleted . .");
           long totalWaitTime = 0;
           
           boolean bLastObjectStillExists = true;
           while (bLastObjectStillExists) {
                   Map attrsIdMUnit = new HashMap<String, Collection<String>>();
                   ArrayList<String> aDN = new ArrayList<String>();
                   aDN.add("cn=bulkTest" + m\_rangeStop + "," + m\_target\_contextPBO);
                   attrsIdMUnit.put("dn", aDN);
                   
                   try {
                           m\_connectionPBO.doValidate(attrsIdMUnit, false);
                           logln("Checking last object: \\n\[" + aDN + "\]\\nstill exists yet, waiting " + m\_waitForCompletion + " more seconds . .");
                           totalWaitTime += m\_waitForCompletion;
                           try {
                                   Thread.sleep(m\_waitForCompletion);                                     
                           } catch (InterruptedException e1) {}
                   } catch (IdMUnitException e) {
                           logln("Last object check threw an exception: " + e);
                           bLastObjectStillExists = false;
                   }
           }
           return totalWaitTime;
       }
       
       public long VerifyObjects() {
           long totalWaitTime = 0;
        logln("Now checking objects exist. .");
        boolean bFirstObjectExists = false;
        while (!bFirstObjectExists) {
                Map attrsIdMUnit = new HashMap<String, Collection<String>>();
                ArrayList<String> aDN = new ArrayList<String>();
                aDN.add("cn=bulkTest" + m\_rangeStop + "," + m\_target\_contextPBO);
                attrsIdMUnit.put("dn", aDN);
                
                try {
                        m\_connectionPBO.doValidate(attrsIdMUnit, false);
                        bFirstObjectExists = true;
                } catch (IdMUnitException e) {
                        logln("Checking last object: \\n\[" + aDN + "\]\\ndoesn't exist yet, waiting " + m\_waitForCompletion + " more seconds . ., exception was: \\n" + e);
                        totalWaitTime += m\_waitForCompletion;
                        try {
                                Thread.sleep(m\_waitForCompletion);                                     
                        } catch (InterruptedException e1) {}
                }
        }
        
        for (int ctr = m\_rangeStart; ctr <= m\_rangeStop; ctr++) {
                log("### Validating range entry: \[" + ctr + "\] ### . . .");
                
                Map attrsIdMUnit = new HashMap<String, Collection<String>>();
                ArrayList<String> aDN = new ArrayList<String>();
                aDN.add("cn=bulkTest" + ctr + "," + m\_target\_contextPBO);
                attrsIdMUnit.put("dn", aDN);
                
                try {
                        m\_connectionPBO.doValidate(attrsIdMUnit, false);
                } catch (IdMUnitException e) {
                        logln("Failed to validate: \[" + e + "\]");
                }
                
                logln(" . . Validated");
                
        }
        
        return totalWaitTime;
       }
        public void DeleteObjects(boolean bDeleteOnlyInEdir) throws Exception {
                // logln("\[" + m\_rangeStop + "\] users were added/validated in:
                                // \[" + (float)((stopTime - startTime)-totalWaitTime)/1000 + "\]
                                // seconds, with \[" + totalWaitTime+ "\] seconds subtracted off
                                // as wait time for validation");
                
                System.out.print("Now cleaning up . .");
                logln("### Deleting range entry: \[" + m\_rangeStart + "\] to \[" + m\_rangeStop + "### . . .");
                for (int ctr = m\_rangeStart; ctr <= m\_rangeStop; ctr++) {
                        
//                        Map attrsIdMUnitFDCA = new HashMap<String, Collection<String>>();
                        Map attrsIdMUnitIV = new HashMap<String, Collection<String>>();
                        Map attrsIdMUnitPBO = new HashMap<String, Collection<String>>();
//                        attrsIdMUnitFDCA.put("dn", ("cn=bulkTest" + ctr + "," + m\_target\_contextFDCA));
                        attrsIdMUnitIV.put("dn", ("cn=bulkTest" + ctr + "," + m\_target\_context));
                        attrsIdMUnitPBO.put("dn", ("cn=bulkTest" + ctr + "," + m\_target\_contextPBO));
                        
//                        m\_connectionFDCA.execute("deleteObject", convertData(attrsIdMUnitFDCA));
                        m\_connectionIDV.execute("deleteObject", convertData(attrsIdMUnitIV));
                        System.out.print(".");
                        if (!bDeleteOnlyInEdir) {
                                m\_connectionPBO.execute("deleteObject", convertData(attrsIdMUnitPBO));
                        }
                        if (ctr % 100 == 0) {
                                System.out.println("\[" + ctr + "\]");
                        }
                }
                
                logln("Done.");
        }
        
        /\*
                 \* public void testRemoveBulkObjects() { for(int
                 \* iterationCounter=m\_rangeStart;iterationCounter<=m\_rangeStop;++iterationCounter) {
                 \* logln("### Removing range entry: \[" + iterationCounter + "\] ###");
                 \* String dn = "cn=bulkTest"+iterationCounter+","+m\_target\_context; Map<String,
                 \* String> attrMap = new HashMap<String, String>(); attrMap.put("dn",
                 \* dn); try { m\_connection.execute("deleteObject",
                 \* convertData(attrMap)); } catch (IdMUnitException e) { fail("Failed to
                 \* add object: " + e.getMessage()); } } }
                 \*/
        /\*
                 \* public void testWait() { try { logln("Waiting for deletions to be
                 \* processed through."); Thread.sleep(1); } catch (Exception e) {
                 \* logln("Wait interrupted"); } }
                 \*/
           private static Map<String, String> configDataToMap(ConnectionConfigData configData) {
                Map<String, String> config = new HashMap<String, String>();
                config.put("Server", configData.getServerURL());
                config.put("User", configData.getAdminCtx());
                config.put("Password", configData.getAdminPwd());
                config.put("KeystorePath", configData.getKeystorePath());
                return config;
            }
           
           public void setup(Map config) throws IdMUnitException {
                // this.config = config;
            }
   private Map<String, Collection<String>> convertData(Map attributeMap) {
        Map<String, Collection<String>> data = new LinkedHashMap<String, Collection<String>>();
        Iterator itr = attributeMap.keySet().iterator();
        while(itr.hasNext()) {
            String attrName = (String)itr.next();
            String attrVal = (String)attributeMap.get(attrName);
            if (attrVal.indexOf("|") == -1) {
                data.put(attrName, Arrays.asList(new String\[\] {attrVal}));
            } else {
                List<String> valueList = new ArrayList<String>();
                StringTokenizer tokenizer = new StringTokenizer(attrVal, "|");
                while(tokenizer.hasMoreTokens()) {
                    valueList.add(tokenizer.nextToken().trim());
                }
                
                data.put(attrName, valueList);
            }
        }
        return data;
    }
   public Map<String, String> populateAttrMap(int iterationCounter) {
        Map<String, String> attrMap = new HashMap<String, String>();                    
//        String dn = "cn=bulkTest"+iterationCounter+","+m\_target\_contextFDCA;
        String dn = "cn=bulkTest"+iterationCounter+","+m\_target\_context;
        attrMap.put("dn", dn);                  
        attrMap.put("objectclass", "inetOrgPerson|bocIDMInformation|oceUserClass");
        //: FDCA: attrMap.put("objectclass", "inetOrgPerson|orclUserV2|oceUserClass");
        attrMap.put("sn", "bulkTest"+iterationCounter);
        attrMap.put("mail", "bulkTest"+iterationCounter+"@trivir.com");
        attrMap.put("description", "Some description");
        attrMap.put("bocContextNameExternal", "cn=bulkTest"+iterationCounter+",CN=Users,CN=LCO-2026,CN=RCC-20,CN=HQ,CN=oceUsers,CN=Users,DC=FDCA,DC=CENSUS2010,DC=GOV");
        // Optional attributes:
// attrMap.put("orclTimeZone", "orclTimeZoneValue");
// attrMap.put("orclActiveStartDate", "20090305000000Z");
// attrMap.put("oceCCMIndependentListingoperatio", "DISABLED");
// attrMap.put("oceCCMIndependentListingQCoperat", "DISABLED");
// attrMap.put("oceEnumerationatTransitoryLocRI", "DISABLED");
// attrMap.put("oceGroupQuartersEnumerationopera",
// "ocegroupquartersenumerationoperationValue");
// attrMap.put("oceGroupQuartersValidationoperat", "ENABLED");
// attrMap.put("oceNonresponseFollowupVacantDele", "DISABLED");
// attrMap.put("oceGroupQuartersAdvanceVisitoper",
// "ocegroupquartersadvancevisitoperationValue");
// attrMap.put("oceNonresponseFollowupRIoperatio", "DISABLED");
// attrMap.put("oceCCMHousingUnitFollowupoperati", "DISABLED");
// attrMap.put("oceEnumerationatTransitoryLocati", "DISABLED");
// attrMap.put("oceDefaultFunction", "Address Canvassing");
// attrMap.put("oceAddressCanvasingOperation", "TRUE");
// attrMap.put("oceOIDTerminationDate", "oceoidterminationdateValue");
// attrMap.put("oceApplicantID", "T9000001");
// attrMap.put("oceLCO", "2026");
// attrMap.put("ocemissionstatus", "ocemissionstatusValue");
// attrMap.put("oceCCMRelistingQCoperation", "T9000001");
// attrMap.put("oceRCC", "2099");
// attrMap.put("oceOfficeCode", "2026");
// attrMap.put("oceOfficeType", "LCO");
// attrMap.put("oceUpdateLeaveoperation", "DISABLED");
// attrMap.put("oceNonresponseFollowupoperation", "T9000001");
// attrMap.put("oceHQ", "N");
// attrMap.put("oceFDCAStaffID", "90001");
// attrMap.put("oceFOSD", "ocefosdValue");
// attrMap.put("oceSharedMailboxName", "ocesharedmailboxnameValue");
// attrMap.put("ocePositionNumber", "99999999");
// attrMap.put("oceCCMRelistingoperation", "T9000001");
// attrMap.put("oceQualityControlOperation", "TRUE");
// attrMap.put("oceUpdateLeaveQCoperation", "oceupdateleaveqcoperationValue");
// attrMap.put("homePhone", "333-333-3333");
// attrMap.put("workforceID", "T9000001");
// attrMap.put("mobile", "222-222-2222");
// attrMap.put("mail", "hgillmore07@census2010.gov");
// attrMap.put("uid", "hgillmore07");
// attrMap.put("givenName", "Happy");
// attrMap.put("fullName", "Happy Gillmore");
// attrMap.put("telephoneNumber", "111-111-1111");
// attrMap.put("loginTime", "20090327163703Z");
// attrMap.put("loginExpirationTime", "20090411000000Z");
// attrMap.put("loginDisabled", "FALSE");
// attrMap.put("description", "descriptionValue");
        
        return attrMap;
        }
   public void AddObjects() throws Exception {
        for(int iterationCounter=m\_rangeStart;iterationCounter<=m\_rangeStop;++iterationCounter) {
            logln("### Adding range entry: \[" + iterationCounter + "\] ###");
            
            Map<String, String> attrMap = populateAttrMap(iterationCounter);
            
            try {
                    //m\_connectionFDCA.execute("addObject", convertData(attrMap));
                        m\_connectionIDV.execute("addObject", convertData(attrMap));
            } catch (IdMUnitException e) {
                fail("Failed to add object: " + e.getMessage());
            }
        }
   }                 
                
                
    public void logln(String \_msg) {                        
            String msg = new Date() + ": " + \_msg;
            System.out.println(msg);
            pwLog.println(msg);
    }
    public void log(String \_msg) {
            String msg = new Date() + ": " + \_msg;
            System.out.print(msg);
            pwLog.print(msg);
    }
    
    
}
