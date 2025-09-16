import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * Take list of e/x/rids and create import ldif file for migration.
 *  Should add idtoAviobook, idtoaviobookprelive, rbeaev1 and mail attribute.
 */
public class MigrateNewQAusers {
  public static void main(String[] args) throws Exception {

    String inputFile = "C:\\work\\work\\User-qa-migrate-list-avio_connect_goops.ldif";
    BufferedReader br = new BufferedReader(new FileReader(inputFile));

    Set<String> listOfFiles = null;

    try (Stream<Path> stream = Files.list(Paths.get("C:\\work\\work"))) {
      listOfFiles = stream
        .filter(file -> !Files.isDirectory(file))
        .map(Path::toAbsolutePath)
        .map(Path::toString)
        .collect(Collectors.toSet());
    }

    for (String file : listOfFiles) {
      BufferedReader inputUsers = new BufferedReader(new FileReader(file));
      PrintWriter outputMigFile = new PrintWriter(new FileWriter(file + "-import.ldif"));
      MigrateNewQAusers.writeFile(inputUsers, outputMigFile);

      inputUsers.close();
      outputMigFile.close();
    }

    int x = 0;
    x++;
  }

  /*
  Input:
  e100077

  output:
  dn: cn=e100077,ou=Users,o=swa-idsat
  changetype: modify
  add: mail
  mail: e100077@wnco.com
  -
  add: DirXML-Associations
  cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#4#
  cn=IDtoAvioBookPrelive,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#4#
  cn=RBEAEv1,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#4#

   */
  public static void writeFile(BufferedReader input, PrintWriter pwoutput) throws Exception {

    String line = null;
    while ((line = input.readLine()) != null) {
      line = line.trim();
      if (line.length() == 0) {
        continue;
      }

      pwoutput.println("dn: cn=" + line + ",ou=Users,o=swa-idsat");
      pwoutput.println("changetype: modify");
      pwoutput.println("add: mail");
      pwoutput.println("mail: " + line + "@wnco.com");
      pwoutput.println("");

      pwoutput.println("dn: cn=" + line + ",ou=Users,o=swa-idsat");
      pwoutput.println("changetype: modify");
      pwoutput.println("add: DirXML-Associations");
      //pwoutput.println("DirXML-Associations: cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#4#");
      //pwoutput.println("DirXML-Associations: cn=IDtoAvioBookPrelive,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#4#");
      pwoutput.println("DirXML-Associations: cn=RBEAEv1,cn=Driver Set AEv1,ou=DirXML,ou=services,o=swa-idsat#4#");
      pwoutput.println("");

    }


  }
}
