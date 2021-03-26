package com.xiaomi.push;

import com.xiaomi.push.iu;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class je extends iu {
    private static int b = 10000;
    private static int c = 10000;
    private static int d = 10000;
    private static int e = 10485760;
    private static int f = 104857600;

    public static class a extends iu.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.iu.a, com.xiaomi.push.ja
        public iy a(ji jiVar) {
            je jeVar = new je(jiVar, this.f875a, this.b);
            if (this.a != 0) {
                jeVar.b(this.a);
            }
            return jeVar;
        }
    }

    public je(ji jiVar, boolean z, boolean z2) {
        super(jiVar, z, z2);
    }

    @Override // com.xiaomi.push.iu, com.xiaomi.push.iy
    /* renamed from: a */
    public iw mo532a() {
        byte a2 = mo532a();
        int a3 = mo532a();
        if (a3 <= c) {
            return new iw(a2, a3);
        }
        throw new iz(3, "Thrift list size " + a3 + " out of range!");
    }

    @Override // com.xiaomi.push.iu, com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public ix mo557a() {
        byte a2 = mo532a();
        byte a3 = mo532a();
        int a4 = mo532a();
        if (a4 <= b) {
            return new ix(a2, a3, a4);
        }
        throw new iz(3, "Thrift map size " + a4 + " out of range!");
    }

    @Override // com.xiaomi.push.iu, com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public jc mo558a() {
        byte a2 = mo532a();
        int a3 = mo532a();
        if (a3 <= d) {
            return new jc(a2, a3);
        }
        throw new iz(3, "Thrift set size " + a3 + " out of range!");
    }

    @Override // com.xiaomi.push.iu, com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public String mo559a() {
        int a2 = mo532a();
        if (a2 > e) {
            throw new iz(3, "Thrift string size " + a2 + " out of range!");
        } else if (this.a.b() < a2) {
            return mo543a(a2);
        } else {
            try {
                String str = new String(this.a.a(), this.a.mo564a(), a2, "UTF-8");
                this.a.a(a2);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new is("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    @Override // com.xiaomi.push.iu, com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo560a() {
        int a2 = mo532a();
        if (a2 <= f) {
            c(a2);
            if (this.a.b() >= a2) {
                ByteBuffer wrap = ByteBuffer.wrap(this.a.a(), this.a.mo564a(), a2);
                this.a.a(a2);
                return wrap;
            }
            byte[] bArr = new byte[a2];
            this.a.b(bArr, 0, a2);
            return ByteBuffer.wrap(bArr);
        }
        throw new iz(3, "Thrift binary size " + a2 + " out of range!");
    }
}
