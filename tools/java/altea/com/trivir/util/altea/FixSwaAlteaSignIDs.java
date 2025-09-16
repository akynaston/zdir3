package com.trivir.util.altea;

import com.sun.jndi.ldap.LdapCtx;
import com.trivir.util.LdapConnectionHelper;

import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class FixSwaAlteaSignIDs {

  public static String topo = "o=swa-id";
  public static String server = "w11pcledirpi011.swacorp.com:1636";

  public static String userDN = "cn=ax266698,ou=admins," + topo;
  public static String userSearchBase = "ou=Users," + topo;


  public static String outputLDIF = "./swaAlteaSignIDFixes.ldif";
  public static String outputFixINDB = "./ToFixInDB.txt";

  public static String mainuserDumpInput = "C:/work/adminrepo/altea/cleanup-swaAlteaSignIDs-dump-34910.txt";

  public static String outputLDIFRemovedisabledAssociations = "./toRemoveAssociations.ldif";

  public static HashSet<String> getUsersAssociatedToSignDB(InitialDirContext edirLdap) throws Exception {
    HashSet<String> ret = new HashSet<>();
    SearchControls sc = new SearchControls();
    sc.setReturningAttributes(new String[]{"DirXML-Associations"}); // explicitly return no attrs
    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

    String filter = "DirXML-Associations=cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*";

    int count = 0;
    NamingEnumeration<SearchResult> sr = edirLdap.search(userSearchBase, filter, sc);
    while (sr.hasMore()) {
      SearchResult user = sr.next();
      String fullDN = user.getNameInNamespace();
      ret.add(fullDN.toLowerCase());

    }
    return ret;
  }

  public static void main(String[] args) throws Exception  {
    BufferedReader inputFile = new BufferedReader(new FileReader(new File(mainuserDumpInput)));
    PrintWriter outputFixInDB = new PrintWriter(new FileWriter(new File(outputFixINDB)));
    PrintWriter outputSwaAlteaIDs = new PrintWriter(new FileWriter(new File(outputLDIF)));
    PrintWriter outputCleanupAssocaitions = new PrintWriter(new FileWriter(new File(outputLDIFRemovedisabledAssociations)));

    String keystorePath = null;
    String trustedCertFile = null;
    boolean useTLS = true;
    boolean trustAll = true;

    // *** pull out users that have an association!
    //"(DirXML-Associations=cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services," + topo + "#1#*))" +

    //*** for the users that do, document them, and fix date in securityDB (not all users will)

    // LATER: Users terminated without an association - AlteaOfficeDB not processing these users . . .swaSatuschange . .getting associated . . .
    // Note: not all users will be fixed

    InitialDirContext edirLdap = LdapConnectionHelper.createLdapConnection(server, userDN, args[0], keystorePath, trustedCertFile, useTLS, trustAll);
    //SearchControls sc = new SearchControls();
    //sc.setReturningAttributes(new String[]{"DirXML-Associations"}); // explicitly return no attrs
    //sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

    HashSet<String> allUsersAlreadyAssociated = getUsersAssociatedToSignDB(edirLdap);
    outputFixInDB.println("Users Already associated: " + allUsersAlreadyAssociated.size());

    int outputDotEveryCount = 100;
    System.out.println("Showing a '.' every [" + outputDotEveryCount + "] entries seen in the input file");
    // Loop through input file, and retreive each user
    String line = null;
    int usersConsideredCount = 0;
    while ((line = inputFile.readLine()) != null) {
      String nextUserDN = null;
        nextUserDN = "cn=" + line.substring(0, line.indexOf("|||")) + ",ou=Users,o=SWA-ID";

        if (allUsersAlreadyAssociated.contains(nextUserDN.toLowerCase())) {
          outputFixInDB.println("User was already associated, needs fixing in SecurityDB: " + nextUserDN);
          continue;
        }


        LdapCtx nextUserObject = null;
//      try {
        //nextUserObject = (LdapCtx)edirLdap.lookup(nextUserDN);
        usersConsideredCount++;
        if (usersConsideredCount % outputDotEveryCount == 0) {
          System.out.print(".");
        }
        if (usersConsideredCount % 200 == 0) {
          System.out.print(""); // new line . . .
        }

      //} catch (NameNotFoundException e) {
//        outputFixInDB.println("User did not exist in edir: " + nextUserDN);
//        outputFixInDB.flush();
//        continue;
//      }
      //Attributes nextUserObjExistingSignIDs = nextUserObject.getAttributes("", new String[] { "swaAlteaSignIDs" });
      Attributes nextUserObjExistingSignIDs = null;
      outputSwaAlteaIDs.println("************ [" + usersConsideredCount + "] - NEXT: " + nextUserDN);

      // Write LDIF file entry for the user to clear existing swaAlteaSignIDs:
      outputSwaAlteaIDs.println("dn: " + nextUserDN);
      outputSwaAlteaIDs.println("changetype: modify");
      outputSwaAlteaIDs.println("add: DirXML-Associations");
      outputSwaAlteaIDs.println("DirXML-Associations: cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services,o=SWA-ID#0#");
      outputSwaAlteaIDs.println("");

      // Step out to a different file, and record the association to remove.
      outputCleanupAssocaitions.println("dn: " + nextUserDN);
      outputCleanupAssocaitions.println("changetype: modify");
      outputCleanupAssocaitions.println("add: DirXML-Associations");
      outputCleanupAssocaitions.println("DirXML-Associations: cn=IDtoAlteaSignDB,cn=SDC Driver Set,ou=DirXML,ou=Services,o=SWA-ID#0#");
      outputCleanupAssocaitions.println("");

      // Write LDIF file entry for the user to clear existing swaAlteaSignIDs:
      //     nope - on second thought, leave them there; users have more than one value
      //outputSwaAlteaIDs.println("dn: " + nextUserDN);
      //outputSwaAlteaIDs.println("changetype: modify");
      //outputSwaAlteaIDs.println("delete: swaAlteaSignIDs");
      //outputSwaAlteaIDs.println("");

      // Write LDIF file entry for user to add swaAlteaSignIDs; record current signIDs if any.
      outputSwaAlteaIDs.println("dn: " + nextUserDN);
      outputSwaAlteaIDs.println("changetype: modify");
      outputSwaAlteaIDs.println("add: swaAlteaSignIDs");
      //if (nextUserObjExistingSignIDs != null) {
//        outputSwaAlteaIDs.println("#Existing signIDs: " + outputSwaAlteaIDs);
//      } else {
//        outputSwaAlteaIDs.println("#Existing signIDs: [NONE]");
//      }
      outputSwaAlteaIDs.println("swaAlteaSignIDs: " + line);
      outputSwaAlteaIDs.println();

      //outputSwaAlteaIDs.flush();

      int x = 0;
        x++;
    }

    inputFile.close();
    outputFixInDB.close();
    outputSwaAlteaIDs.close();
    outputCleanupAssocaitions.close();

  }
}
