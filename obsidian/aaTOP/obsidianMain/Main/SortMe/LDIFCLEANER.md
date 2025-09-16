# LDIFCLEANER

LDIFCLEANER

package org.idmunit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
/\*
Data:
orclversion: 90400
objectclass: domain
objectclass: top
objectclass: orclSubscriber
dc: fdca
dn: cn=Products,cn=OracleContext,dc=fdca,dc=census2010,dc=gov
objectclass: top
objectclass: orclContainer
cn: Products
orclaci: access to entry by group="cn=iASAdmins, cn=Groups,cn=OracleContext,dc
 =fdca,dc=census2010,dc=gov" (browse, add)
dn: cn=OracleDBSecurity,cn=Products,cn=OracleContext,dc=fdca,dc=census2010,dc=
 gov
orclentrylevelaci: access to entry by \* (browse,noadd,nodelete)
orclentrylevelaci: access to attr=(orcldbversioncompatibility,orclversion,obje
 ctclass) by \* (read,search,compare,nowrite,noselfwrite)
orclentrylevelaci: access to attr=(orcldboidauthentication) by group="cn=Oracl
 eDBCreators,cn=OracleContext,dc=fdca,dc=census2010,dc=gov" (read, nowrite, s
 earch, compare) by group="cn=iASAdmins,cn=Groups,cn=OracleContext,dc=fdca,dc
 =census2010,dc=gov" (read, nowrite, search, compare) by \* (none)
orclentrylevelaci: access to attr=(\*) by \* (none)
orclaci: access to entry by group="cn=OracleDBSecurityAdmins,cn=OracleContext,
 dc=fdca,dc=census2010,dc=gov" (browse,add,delete)
orclaci: access to entry by \* (none)
orclaci: access to attr=(\*) by group="cn=OracleDBSecurityAdmins,cn=OracleConte
 xt,dc=fdca,dc=census2010,dc=gov" (read,search,compare,selfwrite,write)
orclaci: access to attr=(\*) by \* (none)
orcldbversioncompatibility: 90000
orcldboidauthentication: PASSWORD
objectclass: orclDBSecConfig
objectclass: top
objectclass: orclContainer
objectclass: orclDBSecConfig10i
cn: OracleDBSecurity
orclversion: 102000
dn: cn=Groups,cn=OracleContext,dc=fdca,dc=census2010,dc=gov
objectclass: top
objectclass: orclContainer
cn: Groups
\*/
public class LdifCleaner {
        public static void main(String\[\] args) throws Exception {
                BufferedReader br = new BufferedReader(new FileReader(new File("C:\\\\oid\_container\_structure.ldif")));
                PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\\\newcontianerfile.ldif")));
                
                String temp = null;
                
                int ctr = 0;
                
                while ( (temp = br.readLine()) != null) {
                        if (temp.startsWith("dn")) {
                                ctr++;
                                pw.println();
                                pw.println("# Record: \[" + ctr + "\]");
                                pw.println(temp);
                        }
                        if (temp.startsWith("dc")) {
                                pw.println(temp);
                        }
                        if (temp.startsWith("objectclass")) {
                                pw.println(temp);
                        }
                        if (temp.startsWith("cn")) {
                                pw.println(temp);
                        }
                        if (temp.startsWith("ou")) {
                                pw.println(temp);
                        }
                }
                
                pw.close();
                
                
                
        }
}
