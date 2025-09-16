package src.com.trivir.util;

import com.trivir.util.LdapConnectionHelper;

import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AssocSyncListOfUsers {

  //public static String topo = "o=swaiddev";
  //public static String server = "w11dcledirdi014.swacorp.com:1636";

  public static String topo = "o=swa-id";
  public static String server = "w11pcledirpi011.swacorp.com:1636";

  public static String userDN = "cn=ax266698,ou=admins," + topo;
  public static String userSearchBase = "ou=Users," + topo;
  public static String filterAllUsers =
    "(&" +
      "(swaMiroRoles=*)" +
    "(|" +
      "(cn=e107786)" +
      "(cn=e108168)" +
      "(cn=e112082)" +
      "(cn=e148231)" +
      "(cn=e14909)" +
      "(cn=e151163)" +
      "(cn=e151389)" +
      "(cn=e159333)" +
      "(cn=e160347)" +
      "(cn=e160936)" +
      "(cn=e161617)" +
      "(cn=e163950)" +
      "(cn=e166925)" +
      "(cn=e170955)" +
      "(cn=e171062)" +
      "(cn=e171701)" +
      "(cn=e172853)" +
      "(cn=e173823)" +
      "(cn=e174457)" +
      "(cn=e179658)" +
      "(cn=e180474)" +
      "(cn=e181443)" +
      "(cn=e181800)" +
      "(cn=e182181)" +
      "(cn=e188852)" +
      "(cn=e189069)" +
      "(cn=e189823)" +
      "(cn=e189979)" +
      "(cn=e189985)" +
      "(cn=e190222)" +
      "(cn=e190297)" +
      "(cn=e190298)" +
      "(cn=e190299)" +
      "(cn=e190300)" +
      "(cn=e190301)" +
      "(cn=e190302)" +
      "(cn=e190303)" +
      "(cn=e190304)" +
      "(cn=e190305)" +
      "(cn=e190306)" +
      "(cn=e190307)" +
      "(cn=e190308)" +
      "(cn=e190309)" +
      "(cn=e190310)" +
      "(cn=e190311)" +
      "(cn=e190312)" +
      "(cn=e190313)" +
      "(cn=e190314)" +
      "(cn=e190315)" +
      "(cn=e190316)" +
      "(cn=e36548)" +
      "(cn=e48784)" +
      "(cn=e57114)" +
      "(cn=e58259)" +
      "(cn=e60481)" +
      "(cn=e67854)" +
      "(cn=e7126)" +
      "(cn=e76695)" +
      "(cn=e81929)" +
      "(cn=e90280)" +
      "(cn=r32135)" +
      "(cn=r71863)" +
      "(cn=x215164)" +
      "(cn=x232037)" +
      "(cn=x260677)" +
      "(cn=x262126)" +
      "(cn=x263581)" +
      "(cn=x263593)" +
      "(cn=x278710)" +
      "(cn=x279334)" +
      "(cn=x281983)" +
      "(cn=x286087)" +
      "(cn=x295889)" +
      "(cn=x295894)" +
      "(cn=x306587)" +
      "(cn=x307705)" +
      "(cn=x309171)" +
      "(cn=x310428)" +
      "(cn=x311923)" +
      "(cn=x316323)" +
      "(cn=x318127)" +
      "(cn=x318731)" +
      "(cn=x319811)" +
      "(cn=x319812)" +
      "(cn=x321092)" +
      "(cn=x321353)" +
      "(cn=x321366)" +
      "(cn=x323233)" +
      "(cn=x323403)" +
      "(cn=x323703)" +
      "(cn=x323737)" +
      "(cn=x324118)" +
      "(cn=x324447)" +
      "(cn=x325120)" +
      "(cn=x325124)" +
      "(cn=x325125)" +
      "(cn=x325126)" +
      "(cn=x325127)" +
      "(cn=x325128)" +
      "(cn=x325129)" +
      "(cn=x325130)" +
      "(cn=x325131)" +
      "(cn=x325132)" +
      "(cn=x325133)" +
      "(cn=x325134)" +
      "(cn=x325135)" +
      "(cn=x325136)" +
      "(cn=x325137)" +
      "(cn=x325138)" +
      "(cn=x325139)" +
      "(cn=x325140)" +
      "(cn=x325141)" +
      "(cn=x325142)" +
      "(cn=x325143)" +
      "(cn=x325144)" +
      "(cn=x325145)" +
      "(cn=x325146)" +
      "(cn=x325147)" +
      "(cn=x325148)" +
      "(cn=x325149)" +
      "(cn=x325150)" +
      "(cn=x325151)" +
      "(cn=x325152)" +
      "(cn=x325153)" +
      "(cn=x325154)" +
      "(cn=x325155)" +
      "(cn=x325156)" +
      "(cn=x325157)" +
      "(cn=x325158)" +
      "(cn=x325159)" +
      "(cn=x325160)" +
      "(cn=x325161)" +
      "(cn=x325162)" +
      "(cn=x325163)" +
      "(cn=x325164)" +
      "(cn=x325165)" +
      "(cn=x325166)" +
      "(cn=x325167)" +
      "(cn=x325168)" +
      "(cn=x325169)" +
      "(cn=x325170)" +
      "(cn=x325171)" +
      "(cn=x325172)" +
      "(cn=x325173)" +
      "(cn=x325174)" +
      "(cn=x325175)" +
      "(cn=x325176)" +
      "(cn=x325177)" +
      "(cn=x325178)" +
      "(cn=x325179)" +
      "(cn=x325180)" +
      "(cn=x325181)" +
      "(cn=x325182)" +
      "(cn=x325183)" +
      "(cn=x325184)" +
      "(cn=x325185)" +
      "(cn=x325186)" +
      ")" + // close |
      ")"; // close &



  // TOOL NOT DONE; ONLY HAD 5 USERS TO SYNC TOMIROW . .

  public static void mainDISABLED(String args[]) throws Exception {
    String keystorePath = null;
    String trustedCertFile = null;
    boolean useTLS = true;
    boolean trustAll = true;
    int count = 0;

    InitialDirContext edirLdap = LdapConnectionHelper.createLdapConnection(server, userDN, args[0], keystorePath, trustedCertFile, useTLS, trustAll);
    SearchControls sc = new SearchControls();
    sc.setReturningAttributes(new String[]{"DirXML-Associations"}); // explicitly return no attrs
    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

    PrintWriter pw = new PrintWriter(new FileWriter(new File("syncUsers.ldif")));

    // Create Associations based off of original AlteaDriver associations:
    NamingEnumeration<SearchResult> sr = edirLdap.search(userSearchBase, filterAllUsers, sc);
    while (sr.hasMore()) {
      count++;
      SearchResult user = sr.next();
      String fullDN = user.getNameInNamespace();
      BasicAttribute associations = (BasicAttribute) user.getAttributes().get("DirXML-Associations");

      String dirxmlsyncString = getDirxmlSyncString("IDtoMiro,", associations);

      pw.println("dn: " + fullDN);
      pw.println("changetype: modify");
      pw.println("delete: DirXML-Associations");
      pw.println(dirxmlsyncString);
      pw.println();

      System.out.println("User found: " + fullDN);
    }
    pw.close();

    System.out.println("Total users: [" + count + "]");
  }

  private static String getDirxmlSyncString(String IDtoMiro, BasicAttribute associations) throws Exception  {
    String ret = "NOASSOCIATION";

    NamingEnumeration assocEnum =  associations.getAll();

    while (assocEnum.hasMore()) {

      String associationValue = (String)assocEnum.next();


      if (associationValue.contains(IDtoMiro)) {
        return associationValue;
      }
       int  x = 0;
       x++;
    }
    return ret;

  }




}
