
```
package com.trivir.util;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
 
public class AnalyzeAssociations {
public static void main(String[] args) throws Exception {
BufferedReader br = new BufferedReader( new FileReader( new File( "C:\\work\\umms\\listofUserAssocs-prod.ldif" )));
PrintWriter pw = new PrintWriter( new FileWriter( new File( "C:\\work\\umms\\prodUserAssociationCount.ldif" )));
 
String temp = null ;
String userDN = null ;
HashMap<String, ArrayList<String>> assocsWithUsers = new HashMap<String, ArrayList<String>>();
while ( (temp = br.readLine()) != null ) {
if (temp.startsWith( "dn:" )) {
userDN = temp.substring(4);
continue ;
}
if (temp.startsWith( "DirXML-Associations" )) {
String key = temp.substring(21, temp.lastIndexOf( "#" ) + 1);
if (assocsWithUsers.get(key) == null ) {
assocsWithUsers.put(key, new ArrayList<String>());
}
assocsWithUsers.get(key).add(userDN);
}
}
br.close();
pw.println( "All users in the ou=users,o=lawson fall into one or more of the following driver/association patterns:" );
pw.println( "There are [" + assocsWithUsers.keySet().size() + "] different association states" );
for (String assoc : new TreeSet<String>(assocsWithUsers.keySet())) {
pw.println(assoc + "\t\t with [" + assocsWithUsers.get(assoc).size() + "] objects." );
}
 
for (String assoc : new TreeSet<String>(assocsWithUsers.keySet())) {
pw.println();
pw.println();
pw.println( "######################################################################" );
pw.println( "There are [" + assocsWithUsers.get(assoc).size() + "] users with this driver association and state: [" +  assoc + "]" );
if (assoc.indexOf( "#1#" ) > -1) {
pw.println( "....Not printing users, list of users are associated to driver" );
continue ;
}
for (String users : assocsWithUsers.get(assoc)) {
pw.println(users);
}
}
pw.close();
}
}
 
```