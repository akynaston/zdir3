import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

Reconconciles roles in aviobook and prod
C:\work\adminrepo\aviobook\initialmigration\IDV-prodRoles-2024-08-06.ldif
C:\work\adminrepo\aviobook\initialmigration\aviobook-prodroles-SWA_user_export-UserRolesAsOf-2024-08-05.csv

 */
public class RoleReconcile {
  public static void main(String[] args) throws Exception {
    BufferedReader brAvioBookRoles = new BufferedReader(new FileReader("C:\\work\\adminrepo\\aviobook\\initialmigration\\aviobook-prodroles-SWA_user_export-UserRolesAsOf-2024-08-05.csv"));
    BufferedReader brIDVavioBookRoles = new BufferedReader(new FileReader("C:\\work\\adminrepo\\aviobook\\initialmigration\\IDV-prodRoles-2024-08-06.ldif"));

    PrintWriter pwNotInEDir = new PrintWriter(new FileWriter(new File("C:\\work\\adminrepo\\aviobook\\initialmigration\\usersWithRolesINAvioBookbutNotIneDir.txt")));
    PrintWriter pwUsersToGetRoleOnMigration = new PrintWriter(new FileWriter(new File("C:\\work\\adminrepo\\aviobook\\initialmigration\\usersThatWillGetRoleOnMigration.ldif")));
    PrintWriter pwUsersToGetRoleOnMigrationAvioCabinFA = new PrintWriter(new FileWriter(new File("C:\\work\\adminrepo\\aviobook\\initialmigration\\usersThatWillGetRoleOnMigration-avioCabinFA.ldif")));

    PrintWriter pwListOfUsersWhereRolesAgree = new PrintWriter(new FileWriter(new File("C:\\work\\adminrepo\\aviobook\\initialmigration\\usersRolesAgree.ldif")));


    /* read aviobook roles files first, CSV in this format:
    username,first_name,middle_name,last_name,roles
    admin,"System Administrator",NULL,AvioVision,"full admin"
    "avio_aircraft_api ",Aircraft,NULL,API,api-user-role
    avio-access-api,SWA,NULL,ACCESS,idp-user-role

    Fields:
    1 username
    2 first
    3 middle
    4 last
    5 role
     */
    Map<String, ArrayList<String>> avioBookRolesInAvioNow = new HashMap<String, ArrayList<String>>();
    Map<String, ArrayList<String>> avioBookRolesInIDVNow = new HashMap<String, ArrayList<String>>();

    String line = null;
    while ((line = brAvioBookRoles.readLine()) != null) {
      if (line.startsWith("username,")) {
        continue;
      }
      String[] fields = line.split(",");
      if (fields.length != 5) {
        throw new Exception("could not parse fields for row: [" + line + "]");
      }
      String username = fields[0].replaceAll("\"", "");
      String[] roles = fields[4].replace("\"", "").split(":");

      ArrayList<String> rolesExisting = avioBookRolesInAvioNow.getOrDefault(username, new ArrayList<>());
      for (String role : roles) {
        rolesExisting.add(role);
      }
      avioBookRolesInAvioNow.put(username, rolesExisting);

    }

    System.out.println("Roles in Aviobook: *************************************************************************");
    System.out.println("Done reading, size was: \t[" + avioBookRolesInAvioNow.size() + "] users with roles in aviobook.");

    int count = 0;
    // are there any with more than one role?
    for (String userkey : avioBookRolesInAvioNow.keySet()) {
      //if (avioBookRolesInAvioNow.get(userkey).size() > 1) {
//        throw new Exception("found one with more than one . .");
//      }
      count++;
    }

    System.out.println("There were \t\t\t\t[" + count + "] users.");


    // Now read the LDIF file, and compare roles
    String currentRole = null;
    while ((line = brIDVavioBookRoles.readLine()) != null) {
      if (line.contains("dn:")) {
        currentRole = line.split("-|,")[2];
        continue;
      }
      if (!line.contains("member:") || line.startsWith("#")) {
        continue;
      }
      String userName = line.split("=|,")[1];
      // line is a member if we get here
      ArrayList<String> rolesExisting = avioBookRolesInIDVNow.getOrDefault(userName, new ArrayList<>(Arrays.asList(currentRole)));
      avioBookRolesInIDVNow.put(userName, rolesExisting);
    }
    System.out.println("Roles in eDirectory: *************************************************************************");
    System.out.println("eDirectory had: \t[" + avioBookRolesInIDVNow.size() + "] user with roles");

    count = 0;
    // are there any with more than one role in edir?
    for (String userkey : avioBookRolesInIDVNow.keySet()) {
      if (avioBookRolesInIDVNow.get(userkey).size() > 1) {
        throw new Exception("found one with more than one . .");
      }
      count++;
    }

    System.out.println("There were \t\t\t\t[" + count + "] users in edir.");

    // before moving on, lets get some raw roll counts
    //avioBookRolesInIDVNow.keySet().removeAll(avioBookRolesInAvioNow.keySet());
    // 8/6/2024 5:16:50 PM- shows 239 in idvnow that are not in aviobook.

    Map<String, Integer> countRoleAvioBook = new HashMap<String, Integer>();
    Map<String, Integer> countRoleIDV = new HashMap<String, Integer>();


    System.out.println("Reconciling beginning . . . .**************");
    // loop through avio file first, and use that as the gold standard.
    int mismatch = 0;
    int match = 0;
    int nullCount = 0;

    for (String username : avioBookRolesInAvioNow.keySet()) {

      List<String> expectedRoles = avioBookRolesInAvioNow.get(username);
      List<String> edirRole = avioBookRolesInIDVNow.get(username);

      // store counts of roles being used
      for (String expectedRolesHere : expectedRoles) {
        Integer countValue = countRoleAvioBook.getOrDefault(expectedRolesHere, new Integer(0));
        countValue = new Integer(countValue.intValue() + 1);
        if (countValue.intValue() == 2) {
          int x = 0;
          x++;
        }
        countRoleAvioBook.put(expectedRolesHere, countValue);
      }

      if (edirRole == null) {
        //throw new Exception("User: [" + username + "] Did not appear to exist in eDirectory!");
        pwNotInEDir.println("user: [" + username + "] Does not appear to be eventually granted a role in edirectory; Maybe the user was terminated and should be removed from aviobook, or it's a special account of some sort?.");
        continue;
      }

      mismatch = 0;
      ArrayList<String> nullRoles = new ArrayList<>(Arrays.asList("NULL"));

      if (expectedRoles.equals(edirRole)) {
        pwListOfUsersWhereRolesAgree.println("User [" + username + "] had aviobook roles [" + expectedRoles + "], and IDV had [" + edirRole + "], so they agreed.");
        avioBookRolesInIDVNow.remove(username); // done reconciling here . .
        match++;
      } else if (expectedRoles.equals(nullRoles)) {
        nullCount++;
        System.out.println("Null count . .");
      } else {
        mismatch++;
        System.out.println("DISAGREEMENT!");
      }
    }

    System.out.println("There were [" + mismatch + "] mismatches, [" + nullCount + "], and [" + match + "] matches.");

    for (String username : avioBookRolesInIDVNow.keySet()) {
      List<String> rolesToGet = avioBookRolesInIDVNow.get(username);

      // store counts of roles being used
      for (String rolesToGetHere : rolesToGet) {
        Integer countValue = countRoleIDV.getOrDefault(rolesToGetHere, new Integer(0));
        countValue = new Integer(countValue.intValue() + 1);
        countRoleIDV.put(rolesToGetHere, countValue);
      }

      if (rolesToGet.get(0).equals("avio_cabin_fa")) {
        pwUsersToGetRoleOnMigrationAvioCabinFA.println("User [" + username + "] didn't have a role in avio book; but will be provisioned and get one [" + rolesToGet + "]from the driver on migration.");
      } else {
        pwUsersToGetRoleOnMigration.println("User [" + username + "] didn't have a role in avio book; but will be provisioned and get one [" + rolesToGet + "]from the driver on migration.");
      }
    }

    System.out.println("Done with reconcile. There are [" + avioBookRolesInIDVNow.size() + "] users left in eDirectory that did not match aviobook");

    System.out.println("Counts in aviobook:");
    System.out.println(countRoleAvioBook);

    System.out.println("Counts of roles left over in idv:");
    System.out.println(countRoleIDV);


    pwNotInEDir.close();
    pwUsersToGetRoleOnMigration.close();
    pwUsersToGetRoleOnMigrationAvioCabinFA.close();
    pwListOfUsersWhereRolesAgree.close();
    brAvioBookRoles.close();
    brIDVavioBookRoles.close();
    System.out.println("done");

  }
}

