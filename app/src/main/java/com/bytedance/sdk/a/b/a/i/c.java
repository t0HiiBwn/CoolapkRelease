package com.bytedance.sdk.a.b.a.i;

import com.bytedance.sdk.a.b.a.g.e;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* compiled from: CertificateChainCleaner */
public abstract class c {
    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static c a(X509TrustManager x509TrustManager) {
        return e.b().a(x509TrustManager);
    }
}
