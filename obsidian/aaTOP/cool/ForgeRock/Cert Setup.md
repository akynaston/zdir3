  
---------- Forwarded message ---------  
From: **Carl Kynaston <Evernote>** <[noreply@notifications.evernote.com](mailto:noreply@notifications.evernote.com)>  
Date: Thu, Sep 12, 2024 at 3:12 PM  
Subject: LDAPS Imports and scripting  
To: <[ckynaston@trivir.com](mailto:ckynaston@trivir.com)>  

  
  

## Get and import certs on server 1 and 2 (Do this on each server) (duplcated here [Script to get LDAPS cert and import it into Java](https://t2.mail-svc.evernote.com/f/a/67yels9sM_1raSTooo0Jcg~~/AADd_wA~/RgRoxd5CP0RQaHR0cHM6Ly93d3cuZXZlcm5vdGUuY29tL3NoYXJkL3M2L25sLzg4MjMzMi9hNTQwMjFmMC0yMjFkLTZiNzgtNjcwNi0wYWZhM2IyZWMzZGJXA3NwY0IKZuFCWeNme2BrlFIUY2t5bmFzdG9uQHRyaXZpci5jb21YBAAAAAw~))

mkdir /home/forgerock/scripts
touch /home/forgerock/scripts/import_ldap_cert.sh
chmod 775 /home/forgerock/scripts/import_ldap_cert.sh
vi /home/forgerock/scripts/import_ldap_cert.sh
  

#!/bin/bash
 

# Check if a DNS name and port and an alias are passed as arguments
if [ $# -ne 2 ]; then
    echo "Usage: $0 &lt;dns_name:port> &lt;alias>"
    exit 1
fi

  

DNS_PORT=$1
ALIAS=$2
TEMP_DIR="$HOME/tmp"
mkdir -p $TEMP_DIR
CERT_FILE="$TEMP_DIR/ldap_cert.der"
PEM_FILE="$TEMP_DIR/ldap_cert.pem"
KEYSTORE_PATH="/usr/lib/jvm/java-17-zulu-openjdk-jdk/lib/security/cacerts"
KEYSTORE_PASSWORD="changeit"
  
# Step 1: Retrieve the LDAP server certificate using openssl
echo "Retrieving certificate from $DNS_PORT ..."
openssl s_client -showcerts -connect $DNS_PORT &lt;/dev/null 2>/dev/null | openssl x509 -outform der -out $CERT_FILE
  

# Check if the certificate was retrieved successfully
if [ $? -ne 0 ]; then
    echo "Failed to retrieve certificate from $DNS_PORT"
    exit 1
fi

  

echo "Certificate saved to $CERT_FILE"

# Step 2: Convert the certificate from DER to PEM format
echo "Converting certificate to PEM format..."
openssl x509 -inform der -in $CERT_FILE -out $PEM_FILE
  
# Step 3: Import the certificate into the Java cacerts keystore
echo "Importing the certificate into Java keystore at $KEYSTORE_PATH ..."
keytool -import -alias $ALIAS -file $PEM_FILE -keystore $KEYSTORE_PATH -storepass $KEYSTORE_PASSWORD -noprompt
  
if [ $? -eq 0 ]; then
    echo "Certificate successfully imported into the Java keystore."
else
    echo "Failed to import the certificate into the Java keystore."
    exit 1
fi
 
# Clean up temporary files
rm -f $CERT_FILE $PEM_FILE
  
echo "Done."
  
- Remove a bad cert (only if needed)
   
sudo keytool -delete -alias ds-userstore1 -keystore /usr/lib/jvm/java-17-zulu-openjdk-jdk/lib/security/cacerts -storepass changeit
  
- Import the userstore1 cert. - userstore1
   
sudo /home/forgerock/scripts/import_ldap_cert.sh [ds-userstore1.dev.trivir.com:2636](http://ds-userstore1.dev.trivir.com:2636/) ds-userstore1
  
  
- Print the cert that you have based on your alias. - userstore1
   
keytool -list -alias ds-userstore1 -keystore /usr/lib/jvm/java-17-zulu-openjdk-jdk/lib/security/cacerts -storepass changeit -v



- Import the userstore 2 cert - userstore2
    

sudo /home/forgerock/scripts/import_ldap_cert.sh [ds-userstore2.dev.trivir.com:2636](http://ds-userstore2.dev.trivir.com:2636/) ds-userstore2

- Print the cert that you have based on your alias. - userstore2
    

keytool -list -alias ds-userstore2 -keystore /usr/lib/jvm/java-17-zulu-openjdk-jdk/lib/security/cacerts -storepass changeit -v

  

  

# Test Connecting to each LDAP server from Java

  

vi /home/forgerock/scripts/LDAPTest.java

  

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import javax.naming.directory.DirContext;

import javax.naming.directory.InitialDirContext;

import java.util.Hashtable;

  

public class LDAPTest {

    public static void main(String[] args) {

        if (args.length != 1) {

            System.out.println("Usage: java LDAPTest &lt;ldap_server:port>");

            System.exit(1);

        }

  

        String[] parts = args[0].split(":");

        if (parts.length != 2) {

            System.out.println("Invalid format. Expected &lt;ldap_server:port>");

            System.exit(1);

        }

  

        String ldapServer = parts[0];

        String port = parts[1];

        String ldapUrl = "ldaps://" + ldapServer + ":" + port;

  

        Hashtable&lt;String, String> env = new Hashtable&lt;>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        env.put(Context.PROVIDER_URL, ldapUrl);

  

        try {

            DirContext ctx = new InitialDirContext(env);

            System.out.println("Successfully connected to " + ldapUrl);

            ctx.close();

        } catch (NamingException e) {

            System.err.println("Failed to connect to " + ldapUrl);

            e.printStackTrace();

        }

    }

}

  

  

cd /home/forgerock/scripts

javac LDAPTest.java

java LDAPTest [ds-config1.dev.trivir.com:1636](http://ds-config1.dev.trivir.com:1636/)

java LDAPTest [ds-config2.dev.trivir.com:1636](http://ds-config2.dev.trivir.com:1636/)

java LDAPTest [ds-userstore1.dev.trivir.com:2636](http://ds-userstore1.dev.trivir.com:2636/)

java LDAPTest [ds-userstore2.dev.trivir.com:2636](http://ds-userstore2.dev.trivir.com:2636/)

  

output:

[forgerock@am2 scripts]$ cd /home/forgerock/scripts

javac LDAPTest.java

java LDAPTest [ds-config1.dev.trivir.com:1636](http://ds-config1.dev.trivir.com:1636/)

java LDAPTest [ds-config2.dev.trivir.com:1636](http://ds-config2.dev.trivir.com:1636/)

java LDAPTest [ds-userstore1.dev.trivir.com:2636](http://ds-userstore1.dev.trivir.com:2636/)

java LDAPTest [ds-userstore2.dev.trivir.com:2636](http://ds-userstore2.dev.trivir.com:2636/)

Successfully connected to ldaps://[ds-config1.dev.trivir.com:1636](http://ds-config1.dev.trivir.com:1636/)

Successfully connected to ldaps://[ds-config2.dev.trivir.com:1636](http://ds-config2.dev.trivir.com:1636/)

Successfully connected to ldaps://[ds-userstore1.dev.trivir.com:2636](http://ds-userstore1.dev.trivir.com:2636/)

Successfully connected to ldaps://[ds-userstore2.dev.trivir.com:2636](http://ds-userstore2.dev.trivir.com:2636/)

[forgerock@am2 scripts]$

  

sudo systemctl enable ds-config.service

sudo systemctl enable ds-userstore.service

  

  

Took a snapshot - ds-userstore 1 and 2 complete