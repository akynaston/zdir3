# Untitled Note

//getEffectiveRights.java
package org.idmunit;

//Warning: This code has been marked up for HTML

/\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
\*  Novell Software Developer Kit
\*
\*  Copyright (C) 2002-2003 Novell, Inc. All Rights Reserved.
\*
\*  THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND TREATIES.
\*  USE AND REDISTRIBUTION OF THIS WORK IS SUBJECT TO THE LICENSE AGREEMENT
\*  ACCOMPANYING THE SOFTWARE DEVELOPER KIT (SDK) THAT CONTAINS THIS WORK.
\*  PURSUANT TO THE SDK LICENSE AGREEMENT, NOVELL HEREBY GRANTS TO DEVELOPER A
\*  ROYALTY-FREE, NON-EXCLUSIVE LICENSE TO INCLUDE NOVELL'S SAMPLE CODE IN ITS
\*  PRODUCT. NOVELL GRANTS DEVELOPER WORLDWIDE DISTRIBUTION RIGHTS TO MARKET,
\*  DISTRIBUTE, OR SELL NOVELL'S SAMPLE CODE AS A COMPONENT OF DEVELOPER'S
\*  PRODUCTS. NOVELL SHALL HAVE NO OBLIGATIONS TO DEVELOPER OR DEVELOPER'S
\*  CUSTOMERS WITH RESPECT TO THIS CODE.
\*
\* $name:         GetEffectiveRights.java
\* $description:  GetEffectiveRights.java is used to find the rights a trustee
\*                has on an object.
\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*/
import java.io.IOException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import com.novell.service.ndssdk.jndi.ldap.ext.GetEffectiveRightsRequest;
import com.novell.service.ndssdk.jndi.ldap.ext.GetEffectiveRightsResponse;
import com.novell.service.ndssdk.jndi.ldap.ext.LdapRights;
import com.novell.service.ndssdk.jndi.ldap.ext.LDAPExtendedResponse;

public class getEffectiveRights {
  public static void main(String\[\] args) {

      //if (args.length != 5) {
          //usage();
      //}
      String hostURL      = "ldap://172.17.2.140:389";             
      String loginDN      = "cn=admin,o=services";
      String passWord     = "trivir";
      String entryDN      = "o=services";
      String trusteeDN    = "cn=admin,o=services";

      try {
         // Create a Hashtable object.

          Hashtable<String, String> env = new Hashtable<String,String>(5, 0.75f);

          env.put(Context.INITIAL\_CONTEXT\_FACTORY,
                          "com.sun.jndi.ldap.LdapCtxFactory");
          env.put(Context.PROVIDER\_URL, hostURL);
          env.put(Context.SECURITY\_AUTHENTICATION, "simple" );
          env.put(Context.SECURITY\_PRINCIPAL, loginDN );
          env.put(Context.SECURITY\_CREDENTIALS, passWord );

         // Construct an LdapContext object.

          LdapContext ctx = new InitialLdapContext(env, null);

          /\*
           \* Use the following attrName to get either the entry rights the
           \* trusteeDN has on the entry specified by the entryDN, or
           \* the all attribute rights the trusteeDN has on the entry
           \* specified by the entryDN:
           \*   1. attrName = "\[Entry Rights}"
           \*   2. attrName = "\[All Attributes Rights\]"
           \*/
         //String attrName =   "\[Entry Rights\]";

          //String attrName =   "\[All Attributes Rights\]";
          String attrName =   "description";

         // call extended operation to get the effective rights.

          GetEffectiveRightsRequest  reqs = new GetEffectiveRightsRequest(
                                              entryDN, trusteeDN, attrName);

          GetEffectiveRightsResponse resp = (GetEffectiveRightsResponse)
                                              ctx.extendedOperation(reqs);

          LdapRights right = resp.getRights();
          System.out.println("\\n\\tThe trustee " + trusteeDN
              + " has the following " + attrName
                  + " on the object " + entryDN + " :\\n" + right);

          System.out.println("\\n\\tGetEffectiveRights operation succeeded.");
      }
      catch (NamingException e) {
          System.err.println("\\n\\tGetEffectiveRights operation  failed.");
          e.printStackTrace();
      }
      catch (IOException ioe) {
          System.err.println("\\n\\tGetEffectiveRights operation  failed.");
          ioe.printStackTrace();
      }
      finally {
          System.exit(0);
      }
  }

  public static void usage() {
      System.err.println("\\n Usage  : java GetEffectiveRights <host URL>"
          + " <login dn> <password>\\n          <entry DN> <trustee DN>\\n");
      System.err.println(" Example: java GetEffectiveRights ldap://Acme.com:"
          + "389 cn=admin,o=Acme secret\\n          cn=james,o=Acme cn=admin"
          + ",o=Acme");
      System.exit(1);
  }

  /\*
   \* Example output:
   \*
   \*
    The trustee cn=admin,o=services has the following description on the object o=services :
compare: true, read: true, write: true, self: true, supervisor: true, inherit\_ctl: false

    GetEffectiveRights operation succeeded.

   \*
   \*/
}
