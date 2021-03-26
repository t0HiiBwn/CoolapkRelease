package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dd;
import com.xiaomi.push.service.z;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ef {
    private static String b = (fp.a(5) + "-");
    private static long c = 0;
    private static final byte[] f = new byte[0];
    String a;
    private dd.a d;
    private short e;
    private byte[] g;

    public ef() {
        this.e = 2;
        this.g = f;
        this.a = null;
        this.d = new dd.a();
    }

    ef(dd.a aVar, short s, byte[] bArr) {
        this.e = 2;
        this.g = f;
        this.a = null;
        this.d = aVar;
        this.e = s;
        this.g = bArr;
    }

    @Deprecated
    public static ef a(fe feVar, String str) {
        int i;
        ef efVar = new ef();
        try {
            i = Integer.parseInt(feVar.l());
        } catch (Exception e2) {
            c.a("Blob parse chid err " + e2.getMessage());
            i = 1;
        }
        efVar.a(i);
        efVar.a(feVar.k());
        efVar.c(feVar.n());
        efVar.b(feVar.o());
        efVar.a("XMLMSG", (String) null);
        try {
            efVar.a(feVar.c().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                efVar.a((short) 3);
            } else {
                efVar.a((short) 2);
                efVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            c.a("Blob setPayload err： " + e3.getMessage());
        }
        return efVar;
    }

    static ef b(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            dd.a aVar = new dd.a();
            aVar.b(slice.array(), slice.arrayOffset() + 8, s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new ef(aVar, s, bArr);
        } catch (Exception e2) {
            c.a("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String g() {
        String sb;
        synchronized (ef.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            long j = c;
            c = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public String a() {
        return this.d.l();
    }

    ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(l());
        }
        byteBuffer.putShort(this.e);
        byteBuffer.putShort((short) this.d.a());
        byteBuffer.putInt(this.g.length);
        int position = byteBuffer.position();
        this.d.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.d.a());
        byteBuffer.position(position + this.d.a());
        byteBuffer.put(this.g);
        return byteBuffer;
    }

    public void a(int i) {
        this.d.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.d.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.d.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.d.b(str2);
        }
    }

    public void a(String str) {
        this.d.e(str);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.d.c(str);
            this.d.p();
            if (!TextUtils.isEmpty(str2)) {
                this.d.d(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("command should not be empty");
    }

    public void a(short s) {
        this.e = s;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d.c(1);
            this.g = z.a(z.a(str, h()), bArr);
            return;
        }
        this.d.c(0);
        this.g = bArr;
    }

    public String b() {
        return this.d.n();
    }

    public void b(String str) {
        this.a = str;
    }

    public int c() {
        return this.d.d();
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.d.a(parseLong);
                this.d.a(substring);
                this.d.b(substring2);
            } catch (Exception e2) {
                c.a("Blob parse user err " + e2.getMessage());
            }
        }
    }

    public boolean d() {
        return this.d.x();
    }

    public byte[] d(String str) {
        if (this.d.u() == 1) {
            return z.a(z.a(str, h()), this.g);
        }
        if (this.d.u() == 0) {
            return this.g;
        }
        c.a("unknow cipher = " + this.d.u());
        return this.g;
    }

    public int e() {
        return this.d.w();
    }

    public String f() {
        return this.d.y();
    }

    public String h() {
        String q = this.d.q();
        if ("ID_NOT_AVAILABLE".equals(q)) {
            return null;
        }
        if (this.d.r()) {
            return q;
        }
        String g2 = g();
        this.d.e(g2);
        return g2;
    }

    public String i() {
        return this.a;
    }

    public String j() {
        if (!this.d.g()) {
            return null;
        }
        return Long.toString(this.d.f()) + "@" + this.d.h() + "/" + this.d.j();
    }

    public byte[] k() {
        return this.g;
    }

    public int l() {
        return this.d.b() + 8 + this.g.length;
    }

    public short m() {
        return this.e;
    }

    public String toString() {
        return "Blob [chid=" + c() + "; Id=" + h() + "; cmd=" + a() + "; type=" + ((int) m()) + "; from=" + j() + " ]";
    }
}
