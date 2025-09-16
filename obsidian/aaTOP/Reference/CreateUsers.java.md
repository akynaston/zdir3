```
**package** com.trivir.util;

  

**import** java.io.File;

**import** java.io.FileWriter;

**import** java.io.PrintWriter;

  

**public** **class** CreateUsers {

  

       **public** **static** **void** main(String[] args) **throws** Exception {

             PrintWriter pw = **new** PrintWriter (**new** FileWriter(**new** File("C:\\input.ldif" )));

            String batchID = "Userbatch1";

             **for** (**int** ctr = 0; ctr < 18000; ctr++) {

                  pw.println( "dn: cn=" + batchID + "-" + ctr + ",ou=users,o=lawson" );

                  pw.println( "changetype: add");

                  pw.println( "objectClass: user");

                  pw.println( "sn: lastname");

                  pw.println( "userPassword: MyPassword123" );

                  pw.println( "");

            }

            pw.close();

      }

}
```