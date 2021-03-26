package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec */
public final class k {
    public static final k a;
    public static final k b;
    public static final k c = new a(false).a();
    private static final h[] h;
    final boolean d;
    final boolean e;
    final String[] f;
    final String[] g;

    static {
        h[] hVarArr = {h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.ay, h.aI, h.az, h.aJ, h.ag, h.ah, h.E, h.I, h.i};
        h = hVarArr;
        k a2 = new a(true).a(hVarArr).a(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0).a(true).a();
        a = a2;
        b = new a(a2).a(ad.TLS_1_0).a(true).a();
    }

    k(a aVar) {
        this.d = aVar.a;
        this.f = aVar.b;
        this.g = aVar.c;
        this.e = aVar.d;
    }

    public boolean a() {
        return this.d;
    }

    public List<h> b() {
        String[] strArr = this.f;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public List<ad> c() {
        String[] strArr = this.g;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean d() {
        return this.e;
    }

    void a(SSLSocket sSLSocket, boolean z) {
        k b2 = b(sSLSocket, z);
        String[] strArr = b2.g;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f != null) {
            strArr = c.a(h.a, sSLSocket.getEnabledCipherSuites(), this.f);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.g != null) {
            strArr2 = c.a(c.h, sSLSocket.getEnabledProtocols(), this.g);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = c.a(h.a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            strArr = c.a(strArr, supportedCipherSuites[a2]);
        }
        return new a(this).a(strArr).b(strArr2).a();
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.d) {
            return false;
        }
        if (this.g != null && !c.b(c.h, this.g, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f == null || c.b(h.a, this.f, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z = this.d;
        if (z != kVar.d) {
            return false;
        }
        return !z || (Arrays.equals(this.f, kVar.f) && Arrays.equals(this.g, kVar.g) && this.e == kVar.e);
    }

    public int hashCode() {
        if (this.d) {
            return ((((527 + Arrays.hashCode(this.f)) * 31) + Arrays.hashCode(this.g)) * 31) + (!this.e ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.d) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f != null ? b().toString() : str;
        if (this.g != null) {
            str = c().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.e + ")";
    }

    /* compiled from: ConnectionSpec */
    public static final class a {
        boolean a;
        String[] b;
        String[] c;
        boolean d;

        a(boolean z) {
            this.a = z;
        }

        public a(k kVar) {
            this.a = kVar.d;
            this.b = kVar.f;
            this.c = kVar.g;
            this.d = kVar.e;
        }

        public a a(h... hVarArr) {
            if (this.a) {
                String[] strArr = new String[hVarArr.length];
                for (int i = 0; i < hVarArr.length; i++) {
                    strArr[i] = hVarArr[i].bj;
                }
                return a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a a(ad... adVarArr) {
            if (this.a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a b(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public a a(boolean z) {
            if (this.a) {
                this.d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public k a() {
            return new k(this);
        }
    }
}
