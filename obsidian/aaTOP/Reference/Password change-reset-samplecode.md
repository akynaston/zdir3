```
//LDAP Password compare notes from:
//http://download.oracle.com/javase/jndi/tutorial/ldap/search/compare.html

package com.trivir.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;

public class PasswordChanger {
      
       public static void main(String[] args) {
            PasswordChanger pc = new PasswordChanger();
            System. out .println(pc.changePassword("cn=admin,o=services" , "trivir" , "172.17.2.160:389" , "cn=NewUser3test,ou=Users,o=lawson" , "asdfAaronWasdfsHere1" , "20111111111111Z" ));
            
            System. out .println("Now running password compare . ." );
            System. out .println("REsults: " + pc.comparePassword("cn=admin,o=services" , "trivir" , "172.17.2.160:389" , "cn=NewUser3test,ou=Users,o=lawson" , "asdfAaronWasdfsHere2" , "20111111111111Z" ));
            System. out .println("Exiting . ." );
            
      }
      
       public String comparePassword(String admin, String adminpass, String hostAndPort, String targetUser, String targetPassword, String expirationTimeToUse) {
            java.util.Hashtable<String, String> env = new java.util.Hashtable<String, String>();
          env.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY ,"com.sun.jndi.ldap.LdapCtxFactory" );
          env.put(javax.naming.Context. PROVIDER_URL , "ldap://" + hostAndPort);
          env.put(javax.naming.Context. SECURITY_AUTHENTICATION , "simple" );
          env.put(javax.naming.Context. SECURITY_PRINCIPAL , admin);
          env.put(Context. SECURITY_CREDENTIALS , adminpass);
          InitialDirContext ctx = null ;
         
          try {
                  ctx = new InitialDirContext(env);
            } catch (Exception e) {
                   return "Error: Could not connect: " + e;
            }

            
          // Set up the search controls
          javax.naming.directory.SearchControls ctls = new javax.naming.directory.SearchControls();
            ctls.setReturningAttributes( new String[0]);       // Return no attrs
            ctls.setSearchScope(javax.naming.directory.SearchControls. OBJECT_SCOPE ); // Search object only
            
             // Invoke search method that will use the LDAP "compare" operation
             try {
                  javax.naming.NamingEnumeration answer = ctx.search(targetUser,"(userPassword={0})" , new Object[]{targetPassword}, ctls);
                   if (answer.hasMore()) {
                         return "compare succeded, passwords the same!" ;
                  } else {
                         return "compare succeeded, passwords are NOT the same";
                  }                 
            } catch (NamingException e) {
                   return "Failed to compare password: " + e;
            }
            
            
      }
      
      
      
      
       public String changePassword(String admin, String adminpass, String hostAndPort, String targetUser, String targetPassword, String expirationTimeToUse) {
            java.util.Hashtable<String, String> env = new java.util.Hashtable<String, String>();
          env.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY ,"com.sun.jndi.ldap.LdapCtxFactory" );
          env.put(javax.naming.Context. PROVIDER_URL , "ldap://" + hostAndPort);
          env.put(javax.naming.Context. SECURITY_AUTHENTICATION , "simple" );
          env.put(javax.naming.Context. SECURITY_PRINCIPAL , admin);
          env.put(Context. SECURITY_CREDENTIALS , adminpass);
          InitialDirContext ctx = null ;
         
          try {
                  ctx = new InitialDirContext(env);
            } catch (Exception e) {
                   return "Error: Could not connect: " + e;
            }
             try {
                  ModificationItem[] modNewPassArray = new ModificationItem[1];
                  modNewPassArray[0] = new javax.naming.directory.ModificationItem(DirContext.REPLACE_ATTRIBUTE, new javax.naming.directory.BasicAttribute( "userPassword", targetPassword));
                  ctx.modifyAttributes(targetUser, modNewPassArray);

                  modNewPassArray = new ModificationItem[1];
                  modNewPassArray[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE , new javax.naming.directory.BasicAttribute("passwordExpirationTime" , expirationTimeToUse));
                  ctx.modifyAttributes(targetUser, modNewPassArray);
                  
            } catch (javax.naming.NamingException e) {
                   return "Error: Could not modify the password/expirationtime  for the user: " + targetUser + ", error: " + e;
            }
             return "success" ;
         
      }
      
       public void writeLog(String logfile, String data) throws Exception {
            PrintWriter pw = new PrintWriter(new FileWriter( new File(logfile), true ));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssZ" );
            pw.print(sdf.format( new Date()));
            pw.println( ": " + data);
            pw.close();
      }
   
}
```