package com.xiaomi.push;

import com.xiaomi.push.ic;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class im extends ic {
    private static int f = 10000;
    private static int g = 10000;
    private static int h = 10000;
    private static int i = 10485760;
    private static int j = 104857600;

    public static class a extends ic.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.ic.a, com.xiaomi.push.ii
        public ig a(iq iqVar) {
            im imVar = new im(iqVar, this.a, this.b);
            if (this.c != 0) {
                imVar.c(this.c);
            }
            return imVar;
        }
    }

    public im(iq iqVar, boolean z, boolean z2) {
        super(iqVar, z, z2);
    }

    @Override // com.xiaomi.push.ic, com.xiaomi.push.ig
    public Cif j() {
        byte q = q();
        byte q2 = q();
        int s = s();
        if (s <= f) {
            return new Cif(q, q2, s);
        }
        throw new ih(3, "Thrift map size " + s + " out of range!");
    }

    @Override // com.xiaomi.push.ic, com.xiaomi.push.ig
    public ie l() {
        byte q = q();
        int s = s();
        if (s <= g) {
            return new ie(q, s);
        }
        throw new ih(3, "Thrift list size " + s + " out of range!");
    }

    @Override // com.xiaomi.push.ic, com.xiaomi.push.ig
    public ik n() {
        byte q = q();
        int s = s();
        if (s <= h) {
            return new ik(q, s);
        }
        throw new ih(3, "Thrift set size " + s + " out of range!");
    }

    @Override // com.xiaomi.push.ic, com.xiaomi.push.ig
    public String v() {
        int s = s();
        if (s > i) {
            throw new ih(3, "Thrift string size " + s + " out of range!");
        } else if (this.e.c() < s) {
            return b(s);
        } else {
            try {
                String str = new String(this.e.a(), this.e.b(), s, "UTF-8");
                this.e.a(s);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new ia("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    @Override // com.xiaomi.push.ic, com.xiaomi.push.ig
    public ByteBuffer w() {
        int s = s();
        if (s <= j) {
            d(s);
            if (this.e.c() >= s) {
                ByteBuffer wrap = ByteBuffer.wrap(this.e.a(), this.e.b(), s);
                this.e.a(s);
                return wrap;
            }
            byte[] bArr = new byte[s];
            this.e.d(bArr, 0, s);
            return ByteBuffer.wrap(bArr);
        }
        throw new ih(3, "Thrift binary size " + s + " out of range!");
    }
}
