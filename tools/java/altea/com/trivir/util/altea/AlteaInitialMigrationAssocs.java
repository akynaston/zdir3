package com.trivir.util.altea;

import com.trivir.util.LdapConnectionHelper;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Creates the Altea driver import files for the new associations
 * Also creates swaStatus -L import files
 *
 * This tool searches for:
 *  cn=IDtoAltea,cn=SDC Driver Set,ou=DirXML,ou=Services,o=swaiddev#1#*
 *
 *  And creates import file for:
 *
 *
 *
 */
public class AlteaInitialMigrationAssocs {


  //public static String topo = "o=swaiddev";
  //public static String server = "w11dcledirdi014.swacorp.com:1636";

  public static String topo = "o=swa-id";
  public static String server = "w11pcledirpi011.swacorp.com:1636";

  public static String userDN = "cn=ax266698,ou=admins," + topo;
  public static String userSearchBase = "ou=Users," + topo;
  public static String userMainSourceFilterHasAlteaAssocMissingAtLeastOneNewDriver =
    "(&" +
      "(|" +
      "(DirXML-Associations=cn=Altea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*)" +
      "(DirXML-Associations=cn=Altea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#2#*)" + // Also getting 'stuck' associations,
      "(DirXML-Associations=cn=Altea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#3#*)" +
      "(DirXML-Associations=cn=Altea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#4#*)" +
      ")" +
      "(|" +
      "(!(DirXML-Associations=cn=IDtoAltea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*))" +
      "(!(DirXML-Associations=cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*))" +
      "(!(DirXML-Associations=cn=AlteaOfficeDBtoID,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*))" +
      ")" +
      ")";

  public static String userMainSourceFilterNoAlteaAssocButHasOfficeIDsMissingAtLeastOneNewDriver =
    "(&" +
      "    (!(DirXML-Associations=cn=Altea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*))\n" +
      "    (|" +
      "        (swaAlteaOfficeID=*)" +
      "        (swaAlteaSuppOfficeID=*)" +
      "    )" +
      "    (|" +
      "        (!(DirXML-Associations=cn=IDtoAltea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*))\n" +
      "        (!(DirXML-Associations=cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*))\n" +
      "        (!(DirXML-Associations=cn=AlteaOfficeDBtoID,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*))\n" +
      "    )" +
      ")";


  public static String assocIDtoAltea = "cn=IDtoAltea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo;
  public static String assocIDtoAlteaSignDB = "cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo;
  public static String assocAlteaOfficeDB = "cn=AlteaOfficeDBtoID,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo;

  public static String fileNamePrefix = "./Import-Associations";
  public static PrintWriter pwAssocAllFile;

  public static String importAssocsAllFile = fileNamePrefix + "-All.ldif";

  // Deletion of old attrs file:
  public static PrintWriter pwRemoveRemoveOldAlteaAssocFile;
  public static String removeAssocsOldAlteaDriverFile = "Remove-Associations-old-Altea.ldif";


  // Stores count for all file; since it increases by 3 every write.
  public static int allCount = 0;

  public static void main(String[] args) throws Exception {
    System.out.println("**************************************************************************************");
    System.out.println("NOTE: currently top O is: [" + topo + "], server is: [" + server + "]");
    System.out.println("REMEMBER TO GET BREAKGLASS ACCESS IN PROD!");

    AlteaInitialMigrationAssocs aima = new AlteaInitialMigrationAssocs();

    // Open 4 files: one with all associations, and one for each driver if we need to focus only on 1:
    pwAssocAllFile = new PrintWriter(new FileWriter(new File(importAssocsAllFile)));
    pwRemoveRemoveOldAlteaAssocFile = new PrintWriter(new FileWriter(new File(removeAssocsOldAlteaDriverFile)));

    aima.createImportfiles(args);

    System.out.println("DONE: currently top O is: [" + topo + "], server is: [" + server + "]");
    System.out.println("REMEMBER TO GET BREAKGLASS ACCESS IN PROD!");
    System.out.println("**************************************************************************************");


  }

  private void createImportfiles(String[] args) throws Exception {
    String keystorePath = null;
    String trustedCertFile = null;
    boolean useTLS = true;
    boolean trustAll = true;

    InitialDirContext edirLdap = LdapConnectionHelper.createLdapConnection(server, userDN, args[0], keystorePath, trustedCertFile, useTLS, trustAll);
    SearchControls sc = new SearchControls();
    sc.setReturningAttributes(new String[]{"DirXML-Associations"}); // explicitly return no attrs
    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

    int count = 0;
    int countFromAlteaAssocSource = 0;
    int countFromOnlyOfficeIDPopulatedSource = 0;

    // Create Associations based off of original AlteaDriver associations:
    NamingEnumeration<SearchResult> sr = edirLdap.search(userSearchBase, userMainSourceFilterHasAlteaAssocMissingAtLeastOneNewDriver, sc);
    while (sr.hasMore()) {
      SearchResult user = sr.next();
      String fullDN = user.getNameInNamespace();
      BasicAttribute associations = (BasicAttribute) user.getAttributes().get("DirXML-Associations");
      countFromAlteaAssocSource++;
      writeAssocsForUser(fullDN, associations, ++count);
      System.out.println("User found: " + fullDN);
    }

    pwAssocAllFile.println("################# STARTING ASSOCS BASED OFF only presence of at least one office id.");

    // Create Associations based off of original AlteaDriver associations:
    sr = edirLdap.search(userSearchBase, userMainSourceFilterNoAlteaAssocButHasOfficeIDsMissingAtLeastOneNewDriver, sc);
    while (sr.hasMore()) {
      SearchResult user = sr.next();
      String fullDN = user.getNameInNamespace();
      BasicAttribute associations = (BasicAttribute) user.getAttributes().get("DirXML-Associations");
      countFromOnlyOfficeIDPopulatedSource++;
      writeAssocsForUser(fullDN, associations, ++count);
      System.out.println("User found: " + fullDN);
    }
    String msg = "There were [" + count + "] Users found"; // currently 1205 in dev 12/21/2023 4:36:20 PM
    String msg2 = "There were [" + countFromAlteaAssocSource + "] users from Altea#1#, and [" + countFromOnlyOfficeIDPopulatedSource + "] from users that had at least one office id, but no Altea#1#";

    pwAssocAllFile.println(msg);
    pwAssocAllFile.println(msg2);

    pwAssocAllFile.close();
    pwRemoveRemoveOldAlteaAssocFile.close();

  }

  /**
   * Writes out association file(s) for associations. Will write one association per record, to be able to fail easily.
   *
   * @param fullDN Full LDAP DN of the user to generate associations for
   */
  private void writeAssocsForUser(String fullDN, BasicAttribute assocs, int count) throws NamingException {
    String cn = getLowerCaseCNFromDN(fullDN);
    String oldAssoc = getOldAlteaAssoc(assocs);
    /*
    Each entry should look like this:
    dn: fulldn
    changetype: modify
    add: DirXML-Associations
    DirXMl-Associations: (driver dn)#1#CN, capital E for IDtoAltea, lower for the other two.
     */

    // write Altea association:
    ArrayList<String> assocData = new ArrayList();
    assocData.add("#User entry count: [" + count + "]");
    assocData.add("dn: " + fullDN);
    assocData.add("changetype: modify");
    assocData.add("add: DirXML-Associations");

    // Write IDtoAltea assoc:
    String assocLine = "DirXML-Associations: " + assocIDtoAltea + "#1#" + cn.toUpperCase();  //IDtoAltea association value is upper case
    writeData(assocData, assocLine, pwAssocAllFile);

    // Write AlteaOfficeDB assoc:
    assocLine = "DirXML-Associations: " + assocAlteaOfficeDB + "#1#" + cn.toLowerCase();
    writeData(assocData, assocLine, pwAssocAllFile);

    // Write IDtoAlteaSignDB assoc:
    assocLine = "DirXML-Associations: " + assocIDtoAlteaSignDB + "#1#" + cn.toLowerCase();
    writeData(assocData, assocLine, pwAssocAllFile);

    if (oldAssoc.length() > 0) {
      pwRemoveRemoveOldAlteaAssocFile.println();
      pwRemoveRemoveOldAlteaAssocFile.println("#User entry count: [" + count + "]");
      pwRemoveRemoveOldAlteaAssocFile.println("dn: " + fullDN);
      pwRemoveRemoveOldAlteaAssocFile.println("changetype: modify");
      pwRemoveRemoveOldAlteaAssocFile.println("delete: DirXML-Associations");
      pwRemoveRemoveOldAlteaAssocFile.println("DirXML-Associations: " + oldAssoc);
    }
  }

  private String getOldAlteaAssoc(BasicAttribute assocs) throws NamingException {
    NamingEnumeration<?> associationValues = assocs.getAll();
    while (associationValues.hasMore()) {
      String assoctoCheck = (String)associationValues.next();
      if (assoctoCheck.contains("cn=Altea,")) {
        return assoctoCheck;
      }
    }
    return "";
  }

  /**
   * Returns the CN from the DN
   * @param fullDN DN value to get the cn from, cn=x257875,ou=Users,o=swaiddev
   * @return
   */
  private String getLowerCaseCNFromDN(String fullDN) {
    return fullDN.substring(fullDN.indexOf("=") + 1, fullDN.indexOf(","));
  }

  public void writeData(ArrayList<String> assocData, String assocLine, PrintWriter pwTargetAll) {

    // Write to all assoc file:
    pwTargetAll.println("#User count: [" + (++allCount) + "]"); // this count increase 3 times faster, so increment here.
    for(String data :assocData) {
      pwTargetAll.println(data);
    }
    pwTargetAll.println(assocLine);
    pwTargetAll.println();

  }

}

