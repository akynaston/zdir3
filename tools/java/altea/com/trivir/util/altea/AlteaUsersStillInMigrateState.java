package com.trivir.util.altea;

import com.trivir.util.LdapConnectionHelper;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AlteaUsersStillInMigrateState {

  public static String topo = "o=swaiddev";
  public static String server = "w11dcledirdi014.swacorp.com:1636";
  public static String userDN = "cn=ax266698,ou=admins," + topo;

  public static String userSearchBase = "ou=Users," + topo;
  public static PrintWriter pwResults;

  public static String results = "AlteaUsers-InMigrateState.ldif";

  public static String userSearchFilterAtleastOneDriverInMigrate =
      "(|" +
      "(DirXML-Associations=cn=IDtoAltea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#4#*)" +
      "(DirXML-Associations=cn=IDtoAltea,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#4#)" + // no assoc value
      "(DirXML-Associations=cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#4#*)" +
      "(DirXML-Associations=cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#4#)" + // no assoc value
      "(DirXML-Associations=cn=AlteaOfficeDBtoID,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#4#*)" +
      "(DirXML-Associations=cn=AlteaOfficeDBtoID,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#4#)" + // no assoc value
      ")";


  public static int allCount = 0;
  public static void main(String[] args) throws Exception {
    System.out.println("**************************************************************************************");
    System.out.println("NOTE: currently top O is: [" + topo + "], server is: [" + server + "]");
    System.out.println("REMEMBER TO GET BREAKGLASS ACCESS IN PROD!");

    AlteaUsersStillInMigrateState aima = new AlteaUsersStillInMigrateState();

    // Open 4 files: one with all associations, and one for each driver if we need to focus only on 1:
    pwResults = new PrintWriter(new FileWriter(new File(results)));
    aima.createResultsFile(args);

    System.out.println("*********************************");
    System.out.println("NOTE: currently top O is: [" + topo + "], server is: [" + server + "]");
    System.out.println("REMEMBER TO GET BREAKGLASS ACCESS IN PROD!");
  }

  private void createResultsFile(String[] args) throws Exception {

    String keystorePath = null;
    String trustedCertFile = null;
    boolean useTLS = true;
    boolean trustAll = true;

    InitialDirContext edirLdap = LdapConnectionHelper.createLdapConnection(server, userDN, args[0], keystorePath, trustedCertFile, useTLS, trustAll);
    SearchControls sc = new SearchControls();
    sc.setReturningAttributes(new String[]{"DirXML-Associations"});
    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

    int count = 0;
    NamingEnumeration<SearchResult> sr = edirLdap.search(userSearchBase, userSearchFilterAtleastOneDriverInMigrate, sc);
    while (sr.hasMore()) {
      SearchResult user = sr.next();
      String fullDN = user.getNameInNamespace();
      writeUser(fullDN, ++count, user);
      System.out.println("User found: " + fullDN);
    }

    pwResults.close();
    System.out.println("There were [" + count + "] Users found" ); // currently 1205 in dev 12/21/2023 4:36:20 PM
  }

  private void writeUser(String fullDN, int count, SearchResult user) throws NamingException {
    /*
    Each entry should look like this:
    dn: fulldn
    changetype: modify
    add: DirXML-Associations
    DirXMl-Associations: (driver dn)#1#CN, capital E for IDtoAltea, lower for the other two.
     */

    pwResults.println("#count: [" + count + "]");
    pwResults.println("dn: " + fullDN);

    Attribute assocs = user.getAttributes().get("DirXML-Associations");
    NamingEnumeration associationsOnUser = assocs.getAll();

    while (associationsOnUser.hasMore()) {
      String assoc = associationsOnUser.next().toString();
      pwResults.println("DirXML-Associations: " + assoc);
      //if (assocToCheck.contains("Altea,")) {
//        return assocToCheck;
//      }
      }

    }

}




