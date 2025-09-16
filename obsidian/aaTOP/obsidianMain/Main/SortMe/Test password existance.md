# Test password existance

shows how to see if password exists or not.
 public static void main(String\[\] args) throws Exception {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL\_CONTEXT\_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        //env.put("com.sun.jndi.ldap.connect.pool", "true");
        //env.put("com.sun.jndi.ldap.connect.pool.protocol", "plain ssl");
        //env.put("com.sun.jndi.ldap.connect.pool.timeout", "1000");
        //env.put("com.sun.jndi.ldap.connect.pool.maxsize", "3");
        //env.put("com.sun.jndi.ldap.connect.pool.prefsize", "1");
        env.put(Context.SECURITY\_AUTHENTICATION, "none");
        env.put(Context.PROVIDER\_URL, "ldap://" + "172.17.2.13:390");
        env.put(Context.SECURITY\_PRINCIPAL, "cn=admin,o=services");
        //env.put(Context.SECURITY\_CREDENTIALS, "trivir");
        env.put(Context.SECURITY\_CREDENTIALS, "");
        env.put("com.sun.jndi.ldap.connect.timeout", "5000");
        env.put(Context.REFERRAL, "follow");
        DirContext ctxAnon = new InitialDirContext(env);
        
        
        String dnPass = "cn=akynastonpass,cn=Users,dc=fdca,dc=census2010,dc=gov";
        String dnNOPass = "cn=akynastonnopass,cn=Users,dc=fdca,dc=census2010,dc=gov";
        Attribute modValuesRemove = new BasicAttribute("userPassword");
         modValuesRemove.add("");        
        Attribute modValuesAdd = new BasicAttribute("userPassword");
        modValuesAdd.add("asdfasdf3234");        
        List<ModificationItem> mods = new ArrayList<ModificationItem>();
        mods.add(new ModificationItem(DirContext.REMOVE\_ATTRIBUTE, modValuesRemove));
        mods.add(new ModificationItem(DirContext.ADD\_ATTRIBUTE, modValuesAdd));
                
        try {
            ctxAnon.modifyAttributes(dnNOPass, (ModificationItem\[\])mods.toArray(new ModificationItem\[mods.size()\]));
        } catch (Exception e) {
            System.out.println("dnNOpas: " + e);
        }
        try {
            ctxAnon.modifyAttributes(dnPass, (ModificationItem\[\])mods.toArray(new ModificationItem\[mods.size()\]));
        } catch (Exception e) {
            System.out.println("dnpas: " + e);
        }
    }
results:
dnNOpas: javax.naming.directory.NoSuchAttributeException: \[LDAP: error code 16 - NDS error: no such value (-602)\]; remaining name 'cn=akynastonnopass,cn=Users,dc=fdca,dc=census2010,dc=gov'
dnpas: javax.naming.AuthenticationException: \[LDAP: error code 49 - NDS error: failed authentication (-669)\]; remaining name 'cn=akynastonpass,cn=Users,dc=fdca,dc=census2010,dc=gov'
Summary:  If a password exists, replacing with blank causes failed authentication.  If password does not exist when replacing with blank, a no such value appears.
Note: the new password must be any non 0 length string, it does NOT need to comply with the password policy - a 0 length string causes an unwilling to perform.
