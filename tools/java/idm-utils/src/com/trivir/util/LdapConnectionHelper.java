/*
 * Copyright (c) 2015-2022 TriVir LLC - All Rights Reserved
 *
 *  This software is proprietary and confidential.
 *  Unauthorized copying of this file, via any medium, is strictly prohibited.
 */

package com.trivir.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.InitialLdapContext;
import javax.net.SocketFactory;
import javax.net.ssl.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.*;
import java.util.*;

public class LdapConnectionHelper {
    @SuppressWarnings("checkstyle:ConstantName")
    private static final Logger log = LoggerFactory.getLogger(LdapConnectionHelper.class);

    public static InitialDirContext createLdapConnection(String server, String userDN, String password, String keystorePath, String trustedCertFile, boolean useTLS, boolean trustAll) throws IDMUtilsException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        env.put("java.naming.ldap.attributes.binary", "guid");

        env.put("com.sun.jndi.ldap.connect.pool", "true");  //CP CHANGE TO DISABLE LDAP CONNECTION POOL
        env.put("com.sun.jndi.ldap.connect.pool.protocol", "plain ssl");
        env.put("com.sun.jndi.ldap.connect.pool.timeout", "1000");
        env.put("com.sun.jndi.ldap.connect.pool.maxsize", "3");
        env.put("com.sun.jndi.ldap.connect.pool.prefsize", "1");
        env.put("java.naming.ldap.attributes.binary", "DirXML-DriverImage");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userDN);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put("com.sun.jndi.ldap.connect.timeout", "50000");
        env.put(Context.REFERRAL, "follow");

        log.warn("DISABLING ENDPOING IDENTIFICATON!");

        if (!useTLS) {
            env.put(Context.PROVIDER_URL, "ldap://" + server);
        } else {
            env.put(Context.PROVIDER_URL, "ldaps://" + server);
            if (keystorePath != null) {
                CustomSocketFactory.setTrustedKeyStore(keystorePath, null);
                env.put("java.naming.ldap.factory.socket", CustomSocketFactory.class.getName());
            } else if (trustedCertFile != null) {
                CustomSocketFactory.setTrustedCert(trustedCertFile);
                env.put("java.naming.ldap.factory.socket", CustomSocketFactory.class.getName());
            } else if (trustAll) {
                CustomSocketFactory.setTrustAll();
                env.put("java.naming.ldap.factory.socket", CustomSocketFactory.class.getName());
            }
        }

        for (Map.Entry<String, String> entry : env.entrySet()) {
            if (env.containsKey(entry.getKey())) {
                log.debug(String.format("Overriding configured LDAP connection option '%s' containing value '%s' with value '%s'.", entry.getKey(), env.get(entry.getKey()), entry.getValue()));
            } else {
                log.debug(String.format("Adding additional LDAP connection option '%s' with value '%s'.", entry.getKey(), entry.getValue()));
            }
            env.put(entry.getKey(), entry.getValue());
        }

        try {
            return new InitialLdapContext(env, null);
        } catch (NamingException e) {
            if (useTLS) {
                if (keystorePath != null) {
                    log.info("Using configured keystore (" + keystorePath + ").");
                } else if (trustedCertFile != null) {
                    log.info("Using configured certificate (" + trustedCertFile + ").");
                } else if (trustAll) {
                    log.info("Configured to trust all certificates, this should not have happened.");
                } else {
                    if (System.getProperty("javax.net.ssl.trustStore") != null) {
                        log.info("Using keystore configured from javax.net.ssl.trustStore (" + System.getProperty("javax.net.ssl.trustStore") + ").");
                    } else {
                        final char sep = File.separatorChar;
                        final String jssecacerts = System.getProperty("java.home") + sep + "lib" + sep + "security" + sep + "jssecacerts";
                        String defaultKeystore;
                        if (new File(jssecacerts).exists()) {
                            defaultKeystore = jssecacerts;
                        } else {
                            defaultKeystore = System.getProperty("java.home") + sep + "lib" + sep + "security" + sep + "cacerts";
                        }
                        log.info("Using JRE default keystore (" + defaultKeystore + ").");
                    }
                }

                exportCertificate(server, trustedCertFile);
                throw new IDMUtilsException("Failed to obtain an SSL LDAP Connection: " + e.getMessage(), e);
            } else {
                log.debug("### Failed to obtain an LDAP server connection to: [" + server + "].");
                throw new IDMUtilsException("Failed to obtain an LDAP Connection: " + e.getMessage(), e);
            }
        }
    }

    private static void exportCertificate(String server, String trustedCertFile) throws IDMUtilsException {
        String host;
        int port = 636;
        if (server.indexOf(':') == -1) {
            host = server;
        } else {
            int j = server.indexOf(':');
            host = server.substring(0, j);
            port = Integer.parseInt(server.substring(j + 1));
        }

        String certFilePath;
        if (trustedCertFile != null) {
            certFilePath = trustedCertFile;
        } else {
            if (port == 636) {
                certFilePath = host + ".cer";
            } else {
                certFilePath = host + "_" + port + ".cer";
            }
        }

        writeCertificatesToFile(certFilePath, host, port);
        log.info("Writing certificates for '" + server + "' to file '" + certFilePath + "'");
    }

    private static void writeCertificatesToFile(String certFilePath, String host, int port) throws IDMUtilsException {
        X509Certificate[] chain = getCertificates(host, port);

        FileOutputStream os;
        try {
            os = new FileOutputStream(certFilePath);
        } catch (FileNotFoundException e) {
            throw new IDMUtilsException("Error opening to file '" + certFilePath + "'");
        }

        try {
            for (int i = 0; i < chain.length; i++) {
                byte[] buf;
                try {
                    buf = chain[i].getEncoded();
                } catch (CertificateEncodingException e) {
                    throw new IDMUtilsException("Error encoding certificate.", e);
                }

                Writer wr = new OutputStreamWriter(os, Charset.forName("UTF-8"));
                try {
                    wr.write("-----BEGIN CERTIFICATE-----\n");
                    wr.write(Base64.getEncoder().encodeToString(buf) + "\n");
                    wr.write("-----END CERTIFICATE-----\n");
                    wr.flush();
                } catch (IOException e) {
                    throw new IDMUtilsException("Error writing certificate to file '" + certFilePath + "'");
                }
            }
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                //ignore exception
            }
        }
    }

    private static X509Certificate[] getCertificates(String host, int port) throws IDMUtilsException {
        TrustManagerFactory tmf;
        try {
            tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            throw new IDMUtilsException("Error getting TrustManagerFactory.", e);
        }

        try {
            tmf.init((KeyStore)null);
        } catch (KeyStoreException e) {
            throw new IDMUtilsException("Error initializing TrustManagerFactory.", e);
        }

        X509TrustManager defaultTrustManager = (X509TrustManager)tmf.getTrustManagers()[0];

        KeyStoreHelper.SavingTrustManager tm = new KeyStoreHelper.SavingTrustManager(defaultTrustManager);

        SSLContext context;
        try {
            context = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IDMUtilsException("Error getting SSLContext.", e);
        }

        try {
            context.init(null, new TrustManager[] {tm}, null);
        } catch (KeyManagementException e) {
            throw new IDMUtilsException("Error initializing SSLContext.", e);
        }

        SSLSocketFactory factory = context.getSocketFactory();

        SSLSocket socket;
        try {
            socket = (SSLSocket)factory.createSocket(host, port);
        } catch (UnknownHostException e) {
            throw new IDMUtilsException("Error creating socket.", e);
        } catch (IOException e) {
            throw new IDMUtilsException("Error creating socket.", e);
        }

        try {
            socket.setSoTimeout(50000);
        } catch (SocketException e) {
            throw new IDMUtilsException("Error setting socket timeout.", e);
        }

        try {
            socket.startHandshake();
            socket.close();
        } catch (SSLException e) {
            //ignore exception
        } catch (IOException e) {
            //ignore exception
        }

        if (tm.getChain() == null) {
            throw new IDMUtilsException("No certificate chain received.");
        }

        return tm.getChain();
    }

    public static void destroyLdapConnection(DirContext context) throws IDMUtilsException {
        try {
            if (context != null) {
                context.close();
            }
        } catch (NamingException e) {
            throw new IDMUtilsException("Failed to close ldap connection: " + e.getMessage());
        }
    }

    public static final class CustomSocketFactory extends SocketFactory {
        private static SocketFactory factory = null;
        private static TrustManager[] tm;
        private SSLSocketFactory sf;

        private CustomSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, tm, null);
            sf = sc.getSocketFactory();
        }

        static void setTrustAll() {
            tm = new TrustManager[] {new TrustAllX509TrustManager()};
        }

        static void setTrustedKeyStore(String keyStorePath, char[] passphrase) throws IDMUtilsException {
            KeyStore caKeystore;
            try {
                caKeystore = KeyStore.getInstance(KeyStore.getDefaultType());
            } catch (KeyStoreException e) {
                throw new IDMUtilsException("Error creating keystore.", e);
            }

            InputStream in;
            try {
                in = new FileInputStream(keyStorePath);
            } catch (FileNotFoundException e) {
                throw new IDMUtilsException("Error reading keystore '" + keyStorePath + "'.", e);
            }
            try {
                try {
                    caKeystore.load(in, passphrase);
                } catch (NoSuchAlgorithmException e) {
                    throw new IDMUtilsException("Error loading keystore '" + keyStorePath + "'.", e);
                } catch (CertificateException e) {
                    throw new IDMUtilsException("Error loading keystore '" + keyStorePath + "'.", e);
                } catch (IOException e) {
                    throw new IDMUtilsException("Error loading keystore '" + keyStorePath + "'.", e);
                }
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            setTrustManager(caKeystore);
        }

        static void setTrustedCert(String certFilePath) throws IDMUtilsException {
            InputStream is;
            try {
                is = new FileInputStream(certFilePath);
            } catch (FileNotFoundException e) {
                throw new IDMUtilsException("Error reading certificate '" + certFilePath + "'.", e);
            }
            try {
                CertificateFactory cf;
                try {
                    cf = CertificateFactory.getInstance("X.509");
                } catch (CertificateException e) {
                    throw new IDMUtilsException("Error getting CertificateFactory.", e);
                }
                Collection<? extends Certificate> x509Certs;
                try {
                    x509Certs = cf.generateCertificates(is);
                } catch (CertificateException e) {
                    throw new IDMUtilsException("Error parsing certificates '" + certFilePath + "'.", e);
                }

                KeyStore ks;
                try {
                    ks = KeyStore.getInstance(KeyStore.getDefaultType());
                } catch (KeyStoreException e) {
                    throw new IDMUtilsException("Error creating KeyStore.", e);
                }

                try {
                    ks.load(null, null);
                } catch (NoSuchAlgorithmException e) {
                    throw new IDMUtilsException("Error initializing KeyStore", e);
                } catch (CertificateException e) {
                    throw new IDMUtilsException("Error initializing KeyStore", e);
                } catch (IOException e) {
                    throw new IDMUtilsException("Error initializing KeyStore", e);
                }

                int count = 0;
                for (Iterator<? extends Certificate> it = x509Certs.iterator(); it.hasNext(); ) {
                    X509Certificate cert = (X509Certificate) it.next();
//                    cert.checkValidity();

                    String subjectPrincipal = cert.getSubjectX500Principal().toString();
                    StringTokenizer st = new StringTokenizer(subjectPrincipal, ",");
                    String cn = "";
                    while (st.hasMoreTokens()) {
                        String tok = st.nextToken();
                        int x = tok.indexOf("CN=");
                        if (x >= 0) {
                            cn = tok.substring(x + "CN=".length());
                        }
                    }
                    String alias = cn + "_" + count;
                    try {
                        ks.setCertificateEntry(alias, cert);
                    } catch (KeyStoreException e) {
                        throw new IDMUtilsException("Error adding certificate to KeyStore", e);
                    }
                    count++;
                }
                setTrustManager(ks);
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private static void setTrustManager(KeyStore caKeystore) {
            String defaultTrustAlgorithm = TrustManagerFactory.getDefaultAlgorithm();

            TrustManagerFactory caTrustManagerFactory;
            try {
                caTrustManagerFactory = TrustManagerFactory.getInstance(defaultTrustAlgorithm);
            } catch (NoSuchAlgorithmException e) {
                caTrustManagerFactory = null;
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                caTrustManagerFactory.init(caKeystore);
            } catch (KeyStoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            tm = caTrustManagerFactory.getTrustManagers();
        }

        public static SocketFactory getDefault() {
            synchronized (CustomSocketFactory.class) {
                if (factory == null) {
                    try {
                        factory = new CustomSocketFactory();
                    } catch (KeyManagementException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return factory;
        }

        public Socket createSocket() throws IOException {
            return sf.createSocket();
        }

        public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
            return sf.createSocket(host, port);
        }

        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
            return sf.createSocket(host, port, localHost, localPort);
        }

        public Socket createSocket(InetAddress host, int port) throws IOException {
            return sf.createSocket(host, port);
        }

        public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
            return sf.createSocket(address, port, localAddress, localPort);
        }
    }

    private static class TrustAllX509TrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }


    }
}
