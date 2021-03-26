package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class SecureX509TrustManager implements X509TrustManager {
    private static final String J = "AndroidCAStore";
    private static final String TAG = "SecureX509TrustManager";
    private static final String a = "X509";
    private static final String b = "bks";
    public static final String k = "hmsrootcas.bks";
    private static final String l = "";
    private X509Certificate[] K;
    protected List<X509TrustManager> c;

    public SecureX509TrustManager(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    public SecureX509TrustManager(Context context, boolean z) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.c = new ArrayList();
        if (context != null) {
            c.setContext(context);
            if (z) {
                a();
            }
            a(context);
            if (this.c.isEmpty()) {
                throw new CertificateException("X509TrustManager is empty");
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        this.c = new ArrayList();
        a(inputStream, str);
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    public SecureX509TrustManager(String str, boolean z) throws IllegalArgumentException, FileNotFoundException {
        Throwable th;
        this.c = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                a(fileInputStream2, "");
                f.c(fileInputStream2);
                if (z) {
                    a();
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                f.c(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            f.c(fileInputStream);
            throw th;
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z) throws IllegalArgumentException {
        this.c = new ArrayList();
        a(inputStream, str);
        if (z) {
            a();
        }
    }

    private void a() {
        g.c(TAG, "loadSystemCA");
        try {
            KeyStore instance = KeyStore.getInstance("AndroidCAStore");
            instance.load(null, null);
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance("X509");
            instance2.init(instance);
            TrustManager[] trustManagers = instance2.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.c.add((X509TrustManager) trustManagers[i]);
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            String str = TAG;
            g.e(str, "loadSystemCA: exception : " + e.getMessage());
        }
    }

    private void a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        boolean z;
        String str = TAG;
        g.c(str, "loadBksCA");
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                g.c(str, " get bks not from assets");
                a(filesBksIS);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                String str2 = TAG;
                g.e(str2, "loadBksCA: exception : " + e.getMessage());
                z = false;
            }
        }
        z = true;
        if (!z || filesBksIS == null) {
            g.c(TAG, " get bks from assets ");
            a(context.getAssets().open("hmsrootcas.bks"));
        }
    }

    private void a(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, "".toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.c.add((X509TrustManager) trustManagers[i]);
                }
            }
        } finally {
            f.c(inputStream);
        }
    }

    private void a(InputStream inputStream, String str) {
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
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            String str2 = TAG;
            g.e(str2, "loadInputStream: exception : " + e.getMessage());
        } catch (Throwable th) {
            f.c(inputStream);
            throw th;
        }
        f.c(inputStream);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(TAG, "checkClientTrusted: ");
        for (X509TrustManager x509TrustManager : this.c) {
            try {
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e) {
                String str2 = TAG;
                g.e(str2, "checkServerTrusted CertificateException" + e.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        g.c(TAG, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length);
        for (X509Certificate x509Certificate : x509CertificateArr) {
            g.b(TAG, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN() + " , getIssuerDN :" + x509Certificate.getIssuerDN());
        }
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            try {
                String str2 = TAG;
                g.c(str2, "check server i : " + i);
                X509TrustManager x509TrustManager = this.c.get(i);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    g.c(str2, "client root ca size is : " + acceptedIssuers.length);
                    for (int i2 = 0; i2 < acceptedIssuers.length; i2++) {
                        g.b(TAG, "client root ca getIssuerDN :" + acceptedIssuers[i2].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e) {
                String str3 = TAG;
                g.e(str3, "checkServerTrusted error :" + e.getMessage() + " , time : " + i);
                if (i == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        g.e(str3, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e;
                }
            }
        }
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

    public X509Certificate[] getChain() {
        return this.K;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.K = x509CertificateArr;
    }
}
