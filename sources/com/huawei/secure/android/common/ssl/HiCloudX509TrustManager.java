package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HiCloudX509TrustManager implements X509TrustManager {
    private static final String TAG = "HiCloudX509TrustManager";
    private static final String a = "X509";
    private static final String b = "bks";
    protected List<X509TrustManager> c = new ArrayList();

    public HiCloudX509TrustManager(InputStream inputStream, String str) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, IllegalArgumentException {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, str.toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.c.add((X509TrustManager) trustManagers[i]);
                }
            }
            if (this.c.isEmpty()) {
                throw new CertificateException("X509TrustManager is empty");
            }
        } finally {
            f.c(inputStream);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.c.isEmpty()) {
            this.c.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(TAG, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length);
        for (X509Certificate x509Certificate : x509CertificateArr) {
            g.b(TAG, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN() + " , getIssuerDN :" + x509Certificate.getIssuerDN());
        }
        if (!this.c.isEmpty()) {
            X509TrustManager x509TrustManager = this.c.get(0);
            X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
            if (acceptedIssuers != null) {
                g.c(TAG, "client root ca size is : " + acceptedIssuers.length);
                for (int i = 0; i < acceptedIssuers.length; i++) {
                    g.b(TAG, "client root ca getIssuerDN :" + acceptedIssuers[i].getIssuerDN());
                }
            }
            x509TrustManager.checkServerTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager x509TrustManager : this.c) {
                arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            String str = TAG;
            g.e(str, "getAcceptedIssuers exception : " + e.getMessage());
            return new X509Certificate[0];
        }
    }
}
