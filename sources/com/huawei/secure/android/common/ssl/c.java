package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.b;
import com.huawei.secure.android.common.ssl.util.g;
import com.huawei.secure.android.common.ssl.util.j;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.X509TrustManager;

public class c implements X509TrustManager {
    private static final String TAG = "WebViewX509TrustManger";
    private X509Certificate V;
    private List<X509TrustManager> c = new ArrayList();

    public c(Context context) {
        Objects.requireNonNull(context, "WebViewX509TrustManger context is null");
        com.huawei.secure.android.common.ssl.util.c.setContext(context);
        X509Certificate l = new j(context).l();
        this.V = l;
        Objects.requireNonNull(l, "WebViewX509TrustManger cannot get cbg root ca");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c("WebViewX509TrustManger", "checkClientTrusted");
        if (!this.c.isEmpty()) {
            this.c.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c("WebViewX509TrustManger", "checkServerTrusted");
        boolean z = false;
        for (int i = 0; i < x509CertificateArr.length; i++) {
            g.b("WebViewX509TrustManger", "checkServerTrusted " + i + " : " + x509CertificateArr[i].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            x509CertificateArr2[i2] = x509CertificateArr[(x509CertificateArr.length - 1) - i2];
        }
        CertificateException e = new CertificateException("CBG root CA CertificateException");
        try {
            z = b.a(this.V, x509CertificateArr2);
        } catch (NoSuchProviderException e2) {
            g.e("WebViewX509TrustManger", "checkServerTrusted NoSuchProviderException: " + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            g.e("WebViewX509TrustManger", "checkServerTrusted NoSuchAlgorithmException: " + e3.getMessage());
        } catch (InvalidKeyException e4) {
            g.e("WebViewX509TrustManger", "checkServerTrusted InvalidKeyException: " + e4.getMessage());
        } catch (SignatureException e5) {
            g.e("WebViewX509TrustManger", "checkServerTrusted SignatureException: " + e5.getMessage());
        } catch (CertificateException e6) {
            e = e6;
            g.e("WebViewX509TrustManger", "checkServerTrusted CertificateException: " + e.getMessage());
        }
        if (!z) {
            throw e;
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
            g.e("WebViewX509TrustManger", "getAcceptedIssuers exception : " + e.getMessage());
            return new X509Certificate[0];
        }
    }
}
