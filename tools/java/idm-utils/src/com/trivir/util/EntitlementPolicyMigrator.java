package src.com.trivir.util;

import com.trivir.util.LdapConnectionHelper;

import javax.naming.NamingEnumeration;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EntitlementPolicyMigrator {

  //public static String topo = "o=swaiddev";
  //public static String server = "w11dcledirdi014.swacorp.com:1636";

  public static String topo = "o=swaiddev";
  public static String server = "w11dcledirdi019.swacorp.com:1636";

  public static String userDN = "cn=ax266698,ou=admins," + topo;
  public static String userSearchBase = "ou=Users," + topo;


  // TOOL NOT DONE; ONLY HAD 5 USERS TO SYNC TOMIROW . .

  private static InitialDirContext edirLdap = null;
  public static void main(String args[]) throws Exception {
    String keystorePath = null;
    String trustedCertFile = null;
    boolean useTLS = true;
    boolean trustAll = true;

//    String targetEPDN = "cn=AvioBook-Flight-avio_atc_specialists,cn=Entitlement Policies,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev";
    String[] targetEPDNs = new String[] { "cn=SOAR-SWA Reporting GO Submitter,cn=Entitlement Policies,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev" };
    String[] targetEPDNFile = new String[] { "epGoSubmitter.ldif "};



    edirLdap = LdapConnectionHelper.createLdapConnection(server, userDN, args[0], keystorePath, trustedCertFile, useTLS, trustAll);
    getDirxmlSyncString("nodriver", "cn=e190443,ou=Users,o=swaiddev");



    //migrateEP(targetEPDNs[0], new PrintWriter(new FileWriter(new File(targetEPDNFile[0]))));


  }

  public static void migrateEP(String targetEPDN, PrintWriter pw) throws Exception {
    int memberCount = 0;
    // Create Associations based off of original AlteaDriver associations:
    SearchControls sc = new SearchControls();
    sc.setReturningAttributes(new String[]{"member"}); // just get member for now
    sc.setSearchScope(SearchControls.OBJECT_SCOPE);
    NamingEnumeration<SearchResult> sr = edirLdap.search(targetEPDN, "objectClass=*", sc);
    while (sr.hasMore()) {
      SearchResult epPolicy = sr.next();
      String fullDN = epPolicy.getNameInNamespace();

      BasicAttribute members = (BasicAttribute) epPolicy.getAttributes().get("member");
      pw.println("# migrating members for: [" + fullDN + "]");
      pw.println();





      for (int ctr = 0; ctr < members.size(); ctr++) {
        String member = (String)members.get(ctr);

        String dirxmlsyncString = getDirxmlSyncString("RBEAEv1,", member);
        memberCount++;
        pw.println("#################  member#: " + memberCount);
        pw.println("dn: " + member);
        pw.println("changetype: modify");
        pw.println(dirxmlsyncString);
        pw.println();
        if (memberCount % 100 == 0) {
          System.out.print(".");
        }
        if (memberCount % 1000 == 0) {
          System.out.println();
        }

      }

    }
    pw.close();

    System.out.println("Total members: [" + memberCount + "]");
  }

  private static String getDirxmlSyncString(String targetDriver, String memberDN) throws Exception  {
    String ret = "NOASSOCIATION";

    SearchControls sc = new SearchControls();
   // sc.setReturningAttributes(new String[]{"DirXML-Associations"}); // explicitly return no attrs
    sc.setReturningAttributes(new String[]{"*", "+"}); // explicitly return no attrs
    sc.setSearchScope(SearchControls.OBJECT_SCOPE);

    NamingEnumeration<SearchResult> sr = edirLdap.search(memberDN, "objectClass=*", sc);
    SearchResult memberObject = sr.next();
    //NamingEnumeration<BasicAttribute> memberObject. ().get("DirXML-Associations").getAll();
    NamingEnumeration<String> neGuidValue = (NamingEnumeration<String>) memberObject.getAttributes().get("guid").getAll();

    String assoc = guid2Associations(neGuidValue.next().getBytes());

    ret =
    "delete: DirXML-Associations\r\n" +
      "DirXML-Associations: " + assoc + "\r\n" +
      "-\r\n" +

      "add: DirXML-Associations\r\n" +
      // find and remove the current association; replace it with #4#:
      "DirXML-Associations: " + assoc.substring(0, assoc.indexOf("{") - 3) + "#4#";

    /*
    NamingEnumeration<String> associations = (NamingEnumeration<String>) memberObject.getAttributes().get("DirXMl-Associations").getAll();

    boolean foundExistingAssociation = false;

    String assoc = null;
    while (associations.hasMore()) {
      assoc = associations.next();
      if (assoc.contains(targetDriver)) {
        foundExistingAssociation = true;
        break;
      }
    }

    if (foundExistingAssociation) {
      ret = "delete: DirXML-Associations\r\n" +
        "DirXML-Associations: " + assoc + "\r\n" +
        "-\r\n";
    }
    ret += "add: DirXML-Associations\r\n" +
        // find and remove the current association; replace it with #4#:
        "DirXML-Associations: " + assoc.substring(0, assoc.indexOf("{") - 3) + "#4#";
    */
    return ret;

  }

  // From javascript tool in global IDM library converted to java:
  public static String guid2Associations(byte[] guidBytes) {
    //byte[] bytes = Base64.getDecoder().decode(guidBytes);
    String s1 = encodeAsciiHex(guidBytes);
    return '{' +
      s1.substring(0, 8) +
      '-' +
      s1.substring(8, 12) +
      '-' +
      s1.substring(12, 16).toLowerCase() +
      '-' +
      s1.substring(16, 20) +
      '-' +
      s1.substring(20) +
      '}';
  }


   // From javascript tool in global IDM library converted to java:
  public static String encodeAsciiHex(byte[] inputBytes) {
    StringBuffer buffer =  new StringBuffer();

    byte[] binToAscii = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'A', 'B', 'C', 'D', 'E', 'F'
    };

    for(int i = 0; i < inputBytes.length; i++)
    {
      byte byte0 = inputBytes[i];
      buffer.append(binToAscii[byte0 << 4 & 0xf]);
      buffer.append(binToAscii[byte0 & 0xf]);
    }
    return buffer.toString();
  }


}
