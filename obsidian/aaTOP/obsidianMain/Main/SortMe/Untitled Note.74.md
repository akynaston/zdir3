# Untitled Note

BAE: Check for and produce 'populate' BSIEUID file

**public** **static** **void** main(String\[\] args) **throws** Exception {
            System.**_out_**.println("Started . .");

            BufferedReader br \= **new** BufferedReader(**new** FileReader(**new** File("c:\\\\UsersWithBSIEUID.ldif")));

      String next \= **null**;
      String dn \= "NONE";
      String euid \= "NONE";
      HashMap<String,ArrayList<String>> hmDupFinder \= **new** HashMap<String,ArrayList<String>>();
      ArrayList<String> dupes \= **new** ArrayList<String>();
      **while** ((next \= br.readLine()) != **null**) {
            **if** (next.startsWith("dn:")) {
                  dn \= next;
                  **continue**;
            }
            **if** (next.startsWith("BSIEUID:")) {
                  euid \= next;
                  ArrayList<String> preExisting \= hmDupFinder.get(euid);
                  **if** (preExisting \== **null**) {
                        hmDupFinder.put(euid, **new** ArrayList<String>(Arrays._asList_(dn)));
                        euid \= "NONE";
                        dn \= "NONE";
                        **continue**;
                  } **else** {
                        dupes.add(euid);
                        preExisting.add(dn);                      
                        hmDupFinder.put(euid, preExisting);
                        System.**_out_**.println("Found one . . .\[" + euid + "\]");
                        euid \= "NONE";
                        dn \= "NONE";
                        **continue**;
                  }
            }
      }

      System.**_out_**.println("done, had \[" + dupes.size() + "\] duplicates . . ");

      PrintWriter pw \= **new** PrintWriter(**new** FileWriter(**new** File("C:\\\\FixAccounts.ldif")));

      **for** (String duplicate : dupes)  {
            ArrayList<String> dns \= hmDupFinder.get(duplicate);
            System.**_out_**.println("duplicate: \[" + duplicate + "\] was found on DNs:");
            **int** ctr \= 0;
            **for** (String dnvalue : dns) {
                  System.**_out_**.print("\\t\\t\[" + dnvalue + "\]");                  
                  **if** (ctr \== 0) {
                        System.**_out_**.println("\\tAssuming this one is correct . .");
                  } **else** {
                        System.**_out_**.println("");
                        pw.println(dnvalue);
                        pw.println("changetype: modify");
                        pw.println("replace: BSIEUID");
                        pw.println("BSIEUID: populate");
                        pw.println("");
                  }
                  ctr++;
            }

      }
      pw.close();

      System.**_out_**.println("Done processing");
