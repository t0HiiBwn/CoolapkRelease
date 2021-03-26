package com.huawei.hms.stats;

import java.nio.charset.Charset;

public final class e {
    public static final Charset a = Charset.forName("UTF-8");
    private static e b;
    private i c;

    /* renamed from: com.huawei.hms.stats.e$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.AES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.HMCSHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.RSA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum a {
        AES(16),
        RSA(128),
        HMCSHA256(16),
        OTHER(0);
        
        private int e;

        private a(int i) {
            this.e = i;
        }

        public int a() {
            return this.e;
        }
    }

    private e() {
    }

    public static e a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        synchronized (e.class) {
            if (b == null) {
                b = new e();
            }
        }
    }

    public i a(a aVar) {
        i iVar;
        int i = AnonymousClass1.a[aVar.ordinal()];
        if (i == 1) {
            iVar = new d();
        } else if (i == 2) {
            iVar = new h();
        } else if (i != 3) {
            af.b("CryptFactory", "crypt type is other");
            return this.c;
        } else {
            iVar = new j();
        }
        this.c = iVar;
        return this.c;
    }

    public String a(String str) {
        return f.a(str);
    }

    public String a(char[] cArr, byte[] bArr) {
        return f.a(cArr, bArr);
    }

    public String b(a aVar) {
        return g.a(aVar.a());
    }

    public byte[] b(String str) {
        return g.a(str);
    }
}
