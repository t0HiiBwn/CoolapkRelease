package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake */
public final class q {
    private final ad a;
    private final h b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private q(ad adVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.a = adVar;
        this.b = hVar;
        this.c = list;
        this.d = list2;
    }

    public static q a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            h a2 = h.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                ad a3 = ad.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = c.a(certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = c.a(localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new q(a3, a2, list, list2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public h a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!this.a.equals(qVar.a) || !this.b.equals(qVar.b) || !this.c.equals(qVar.c) || !this.d.equals(qVar.d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }
}
