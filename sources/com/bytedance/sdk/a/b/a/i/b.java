package com.bytedance.sdk.a.b.a.i;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* compiled from: BasicTrustRootIndex */
public final class b implements f {
    private final Map<X500Principal, Set<X509Certificate>> a = new LinkedHashMap();

    public b(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.i.f
    public X509Certificate a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b) || !((b) obj).a.equals(this.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
