package com.trivir.util.empsvc;

import com.trivir.util.LdapConnectionHelper;

import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Creates the Altea driver import files for the new associations
 * Also creates swaStatus -L import files
 * <p>
 * This tool searches for:
 * cn=IDtoAltea,cn=SDC Driver Set,ou=DirXML,ou=Services,o=swaiddev#1#*
 * <p>
 * And creates import file for:
 */
public class EmpsvcInitMigAssocs {


  //public static String topo = "o=swaiddev";
  //public static String server = "w11dcledirdi014.swacorp.com:1636";

  // PROD SETTINGS:
  public static String topo = "o=swa-id";
  public static String server = "w11pcledirpi011.swacorp.com:1636";
  public static String baseRole = "EmployeeSvc_Retiree|||00E2E000002RP3oUAG|||00e2E000001IUCiQAO";
  // DEV SETTINGS:
  //public static String topo = "o=swaiddev";
  //public static String server = "w11dcledirdi019.swacorp.com:1636";
//  public static String baseRole = "EmployeeSvc_Retiree|||00E2h000000RMT8EAO|||00e2h000000EcgoAAC";


  //public static String userDN = "cn=ax266698,ou=admins," + topo;
  public static String userDN = "cn=x266698,ou=users," + topo;
  public static String userSearchBase = "ou=Users," + topo;
  public static String searchFilterForRetireesCreatedSinceAugTwentyFive =
    "(&" +
      "    (cn=r*)" +
      "    (swaStatus=*)" +
      "    (createTimestamp>=20240825000000Z)" +
      ")";

  public static String assocPrefix = "cn=IDtoEmployeeSvc,cn=Driver Set AEv1,ou=DirXML,ou=Services," + topo;
  public static String assocRegexCheck = ".+IDtoEmployeeSvc.+";

  // Stores count for all file; since it increases by 3 every write.
  public static int allCount = 0;

  public static void main(String[] args) throws Exception {
    System.out.println("**************************************************************************************");
    System.out.println("NOTE: currently top O is: [" + topo + "], server is: [" + server + "]");
    System.out.println("REMEMBER TO SET PASSWORD FOR TARGET ENV AND GET BREAKGLASS ACCESS IN PROD!");

    EmpsvcInitMigAssocs eima = new EmpsvcInitMigAssocs();

    // First retrieve all objects to migrate:
    PrintWriter pwTargetUsers = new PrintWriter(new FileWriter("C:\\work\\work\\emp-r-accounts-topush-still.txt.ldif"));

    eima.writeTargetUserFile(pwTargetUsers, args[0]);


    System.out.println("DONE: currently top O is: [" + topo + "], server is: [" + server + "]");
    System.out.println("REMEMBER TO SET PASSWORD FOR TARGET ENV AND GET BREAKGLASS ACCESS IN PROD!");
    System.out.println("**************************************************************************************");
  }

  private void writeTargetUserFile(PrintWriter targetFile, String userpass) throws Exception {
    String keystorePath = null;
    String trustedCertFile = null;
    boolean useTLS = true;
    boolean trustAll = true;

    InitialDirContext edirLdap = LdapConnectionHelper.createLdapConnection(server, userDN, userpass, keystorePath, trustedCertFile, useTLS, trustAll);
    SearchControls sc = new SearchControls();
    sc.setReturningAttributes(new String[]{"swaEmpSvcBaseRole", "swaEmpSvcElevatedRole"}); // to help confirm no existing associations, maybe use 'assocRegexCheck' . . .
    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

    int count = 0;

    BufferedReader br = new BufferedReader(new FileReader("C:\\work\\work\\emp-r-accounts-topush-still.txt"));
    String inputLine = null;

    targetFile.println("version: 1");


    // Create Associations based off of original AlteaDriver associations:
    //NamingEnumeration<SearchResult> sr = edirLdap.search(userSearchBase, searchFilterForRetireesCreatedSinceAugTwentyFive, sc);
    //while (sr.hasMore()) {
    while ((inputLine = br.readLine()) != null) {
      count++;
      //SearchResult user = sr.next();
      NamingEnumeration<SearchResult> sr = edirLdap.search(userSearchBase, "cn=" + inputLine, sc);
      if (!sr.hasMore()) {
        targetFile.println("");
        targetFile.println("# User [" + count + "]");
        targetFile.println("#Missing User:  [" + inputLine + "]!");
        continue;
      }
      SearchResult nextUser = sr.next();

      String fullDN = nextUser.getNameInNamespace();
      String swaEmpSvcBaseRole = getSafeAttribute(nextUser, "swaEmpSvcBaseRole");
      String swaEmpSvcElevatedRole = getSafeAttribute(nextUser, "swaEmpSvcElevatedRole");


      targetFile.println("");
      targetFile.println("# User [" + count + "]");
      targetFile.println("dn: " + fullDN);
      targetFile.println("changetype: modify");
      //printRemovalOfOldAssociationIfneeded(targetFile, null);
      //targetFile.println("-");
      //targetFile.println("add: DirXML-Associations");
      //targetFile.println("DirXML-Associations: " + assocPrefix + "#4#");
      targetFile.println("-");
      targetFile.println("#existing swaEmpSvcBaseRole: [" + swaEmpSvcBaseRole + "]");
      targetFile.println("#existing swaEmpSvcElevatedRole: [" + swaEmpSvcElevatedRole + "]");
      targetFile.println("replace: swaEmpSvcBaseRole");
      targetFile.println("swaEmpSvcBaseRole: " + baseRole);

      //targetFile.println("#Other associations if any:");
      //NamingEnumeration values = associations.getAll();
      //while (values.hasMore()) {
//        targetFile.println("#DirXML-Associations: " + values.next());
//      }


      System.out.println("User found: " + fullDN);
    }

    System.out.println("count was: [" + count + "]");


    targetFile.close();
  }

  public void printRemovalOfOldAssociationIfneeded(PrintWriter targetFile, BasicAttribute assocs) throws Exception {
    NamingEnumeration values = assocs.getAll();
    while (values.hasMore()) {
      String assoc = (String) values.next();
      if (assoc.matches(assocRegexCheck)) {
        targetFile.println("-");
        targetFile.println("delete: DirXML-Associations");
        targetFile.println("DirXML-Associations: " + assoc);
      }
    }
  }

  public String getSafeAttribute(SearchResult nextUser, String attrName) {
    Attribute attrToCheck = nextUser.getAttributes().get(attrName);
    if (attrToCheck == null) {
      return "NULL";
    } else {
      return attrToCheck.toString();
    }
  }

}


/*
    if (oldAssoc.length() > 0) {
      pwRemoveRemoveOldAlteaAssocFile.println();
      pwRemoveRemoveOldAlteaAssocFile.println("#User entry count: [" + count + "]");
      pwRemoveRemoveOldAlteaAssocFile.println("dn: " + fullDN);
      pwRemoveRemoveOldAlteaAssocFile.println("changetype: modify");
      pwRemoveRemoveOldAlteaAssocFile.println("delete: DirXML-Associations");
      pwRemoveRemoveOldAlteaAssocFile.println("DirXML-Associations: " + oldAssoc);
    }

 */
