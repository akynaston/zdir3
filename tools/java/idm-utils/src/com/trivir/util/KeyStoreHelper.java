/*
 * Copyright (c) 2015-2022 TriVir LLC - All Rights Reserved
 *
 *  This software is proprietary and confidential.
 *  Unauthorized copying of this file, via any medium, is strictly prohibited.
 */

package com.trivir.util;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class KeyStoreHelper {

    public static void writeCertificatesToKeyStore(String keyStorePath, char[] keyStorePassphrase, String alias, String host, int port) throws Exception {
        X509Certificate[] chain = getCertificates(host, port);

        File file = new File(keyStorePath);

        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        if (file.exists()) {
            InputStream in = new FileInputStream(file);
            ks.load(in, keyStorePassphrase);
            in.close();
        } else {
            ks.load(null, null);
        }

        for (int i = 0; i < chain.length; ++i) {
            ks.setCertificateEntry(alias + "-" + i, chain[i]);
        }

        OutputStream out = new FileOutputStream(keyStorePath);
        ks.store(out, keyStorePassphrase);
        out.close();
    }

    //TODO: reconcile with LdapConnector.getCertificates()
    private static X509Certificate[] getCertificates(String host, int port) throws Exception {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init((KeyStore)null);

        X509TrustManager defaultTrustManager = (X509TrustManager)tmf.getTrustManagers()[0];

        SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);

        SSLContext context = SSLContext.getInstance("TLS");

        context.init(null, new TrustManager[]{tm}, null);

        SSLSocketFactory factory = context.getSocketFactory();

        SSLSocket socket = (SSLSocket)factory.createSocket(host, port);

        socket.setSoTimeout(5000);

        try {
            socket.startHandshake();
            socket.close();
            throw new Exception("Certificate is already trusted.");
        } catch (SSLException e) {
            //ignore exception
        } catch (IOException e) {
            //ignore exception
        }

        if (tm.chain == null) {
            throw new Exception("No certificate chain received.");
        }

        return tm.chain;
    }

    public static class SavingTrustManager implements X509TrustManager {
        private final X509TrustManager tm;
        private X509Certificate[] chain;

        SavingTrustManager(X509TrustManager tm) {
            this.tm = tm;
        }

        public void checkClientTrusted(X509Certificate[] certChain, String authType) throws CertificateException {
            throw new UnsupportedOperationException();
        }

        public void checkServerTrusted(X509Certificate[] certChain, String authType) throws CertificateException {
            this.chain = certChain;
            tm.checkServerTrusted(certChain, authType);
        }

        public X509Certificate[] getAcceptedIssuers() {
            throw new UnsupportedOperationException();
        }

        public X509Certificate[] getChain() {
            return this.chain;
        }
    }

}
