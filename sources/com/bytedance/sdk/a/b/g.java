package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.b.a.i.c;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner */
public final class g {
    public static final g a = new a().a();
    private final Set<b> b;
    private final c c;

    g(Set<b> set, c cVar) {
        this.b = set;
        this.c = cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (com.bytedance.sdk.a.b.a.c.a(this.c, gVar.c) && this.b.equals(gVar.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        c cVar = this.c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.b.hashCode();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (!a2.isEmpty()) {
            c cVar = this.c;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a2.size();
                f fVar = null;
                f fVar2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = a2.get(i2);
                    if (bVar.c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = b(x509Certificate);
                        }
                        if (bVar.d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = a(x509Certificate);
                        }
                        if (bVar.d.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a2.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(a2.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.b) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    g a(c cVar) {
        return com.bytedance.sdk.a.b.a.c.a(this.c, cVar) ? this : new g(this.b, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static f a(X509Certificate x509Certificate) {
        return f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    static f b(X509Certificate x509Certificate) {
        return f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    /* compiled from: CertificatePinner */
    static final class b {
        final String a;
        final String b;
        final String c;
        final f d;

        boolean a(String str) {
            if (!this.a.startsWith("*.")) {
                return str.equals(this.b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.b.length()) {
                String str2 = this.b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.a.equals(bVar.a) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.a.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return this.c + this.d.b();
        }
    }

    /* compiled from: CertificatePinner */
    public static final class a {
        private final List<b> a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.a), null);
        }
    }
}
