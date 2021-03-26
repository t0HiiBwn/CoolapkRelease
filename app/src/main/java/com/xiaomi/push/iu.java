package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class iu extends iy {
    private static final jd a = new jd();

    /* renamed from: a  reason: collision with other field name */
    protected int f870a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f871a = false;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f872a = new byte[1];
    protected boolean b = true;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f873b = new byte[2];
    protected boolean c = false;

    /* renamed from: c  reason: collision with other field name */
    private byte[] f874c = new byte[4];
    private byte[] d = new byte[8];
    private byte[] e = new byte[1];
    private byte[] f = new byte[2];
    private byte[] g = new byte[4];
    private byte[] h = new byte[8];

    public static class a implements ja {
        protected int a;

        /* renamed from: a  reason: collision with other field name */
        protected boolean f875a;
        protected boolean b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f875a = false;
            this.b = true;
            this.f875a = z;
            this.b = z2;
            this.a = i;
        }

        @Override // com.xiaomi.push.ja
        public iy a(ji jiVar) {
            iu iuVar = new iu(jiVar, this.f875a, this.b);
            int i = this.a;
            if (i != 0) {
                iuVar.b(i);
            }
            return iuVar;
        }
    }

    public iu(ji jiVar, boolean z, boolean z2) {
        super(jiVar);
        this.f871a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return this.a.b(bArr, i, i2);
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a */
    public byte mo532a() {
        if (this.a.b() >= 1) {
            byte b2 = this.a.a()[this.a.mo564a()];
            this.a.a(1);
            return b2;
        }
        a(this.e, 0, 1);
        return this.e[0];
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public double mo532a() {
        return Double.longBitsToDouble(mo533a());
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a */
    public int mo532a() {
        byte[] bArr = this.g;
        int i = 0;
        if (this.a.b() >= 4) {
            bArr = this.a.a();
            i = this.a.mo564a();
            this.a.a(4);
        } else {
            a(this.g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public long mo533a() {
        byte[] bArr = this.h;
        int i = 0;
        if (this.a.b() >= 8) {
            bArr = this.a.a();
            i = this.a.mo564a();
            this.a.a(8);
        } else {
            a(this.h, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8);
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public iv mo534a() {
        byte a2 = mo532a();
        return new iv("", a2, a2 == 0 ? 0 : mo541a());
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public iw mo535a() {
        return new iw(mo532a(), mo532a());
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public ix mo536a() {
        return new ix(mo532a(), mo532a(), mo532a());
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public jc mo537a() {
        return new jc(mo532a(), mo532a());
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public jd mo538a() {
        return a;
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public String mo539a() {
        int a2 = mo532a();
        if (this.a.b() < a2) {
            return mo543a(a2);
        }
        try {
            String str = new String(this.a.a(), this.a.mo564a(), a2, "UTF-8");
            this.a.a(a2);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new is("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a */
    public String mo543a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            this.a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new is("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo540a() {
        int a2 = mo532a();
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

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public short mo541a() {
        byte[] bArr = this.f;
        int i = 0;
        if (this.a.b() >= 2) {
            bArr = this.a.a();
            i = this.a.mo564a();
            this.a.a(2);
        } else {
            a(this.f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public void mo542a() {
    }

    @Override // com.xiaomi.push.iy
    public void a(byte b2) {
        this.f872a[0] = b2;
        this.a.a(this.f872a, 0, 1);
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public void mo543a(int i) {
        byte[] bArr = this.f874c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.a.a(this.f874c, 0, 4);
    }

    @Override // com.xiaomi.push.iy
    public void a(long j) {
        byte[] bArr = this.d;
        bArr[0] = (byte) ((int) ((j >> 56) & 255));
        bArr[1] = (byte) ((int) ((j >> 48) & 255));
        bArr[2] = (byte) ((int) ((j >> 40) & 255));
        bArr[3] = (byte) ((int) ((j >> 32) & 255));
        bArr[4] = (byte) ((int) ((j >> 24) & 255));
        bArr[5] = (byte) ((int) ((j >> 16) & 255));
        bArr[6] = (byte) ((int) ((j >> 8) & 255));
        bArr[7] = (byte) ((int) (j & 255));
        this.a.a(this.d, 0, 8);
    }

    @Override // com.xiaomi.push.iy
    public void a(iv ivVar) {
        a(ivVar.a);
        a(ivVar.f877a);
    }

    @Override // com.xiaomi.push.iy
    public void a(iw iwVar) {
        a(iwVar.a);
        mo543a(iwVar.f878a);
    }

    @Override // com.xiaomi.push.iy
    public void a(ix ixVar) {
        a(ixVar.a);
        a(ixVar.b);
        mo543a(ixVar.f879a);
    }

    @Override // com.xiaomi.push.iy
    public void a(jd jdVar) {
    }

    @Override // com.xiaomi.push.iy
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo543a(bytes.length);
            this.a.a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new is("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.iy
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo543a(limit);
        this.a.a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.iy
    public void a(short s) {
        byte[] bArr = this.f873b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.a.a(this.f873b, 0, 2);
    }

    @Override // com.xiaomi.push.iy
    public void a(boolean z) {
        a(z ? (byte) 1 : 0);
    }

    @Override // com.xiaomi.push.iy
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo544a() {
        return mo532a() == 1;
    }

    @Override // com.xiaomi.push.iy
    public void b() {
    }

    public void b(int i) {
        this.f870a = i;
        this.c = true;
    }

    @Override // com.xiaomi.push.iy
    public void c() {
        a((byte) 0);
    }

    protected void c(int i) {
        if (i < 0) {
            throw new is("Negative length: " + i);
        } else if (this.c) {
            int i2 = this.f870a - i;
            this.f870a = i2;
            if (i2 < 0) {
                throw new is("Message length exceeded: " + i);
            }
        }
    }

    @Override // com.xiaomi.push.iy
    public void d() {
    }

    @Override // com.xiaomi.push.iy
    public void e() {
    }

    @Override // com.xiaomi.push.iy
    public void f() {
    }

    @Override // com.xiaomi.push.iy
    public void g() {
    }

    @Override // com.xiaomi.push.iy
    public void h() {
    }

    @Override // com.xiaomi.push.iy
    public void i() {
    }

    @Override // com.xiaomi.push.iy
    public void j() {
    }
}
