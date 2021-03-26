package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.bb;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class fb {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f438a = new byte[0];
    private static String b = (gk.a(5) + "-");

    /* renamed from: a  reason: collision with other field name */
    private dw.a f439a;

    /* renamed from: a  reason: collision with other field name */
    String f440a;

    /* renamed from: a  reason: collision with other field name */
    private short f441a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f442b;

    public fb() {
        this.f441a = 2;
        this.f442b = f438a;
        this.f440a = null;
        this.f439a = new dw.a();
    }

    fb(dw.a aVar, short s, byte[] bArr) {
        this.f441a = 2;
        this.f442b = f438a;
        this.f440a = null;
        this.f439a = aVar;
        this.f441a = s;
        this.f442b = bArr;
    }

    @Deprecated
    public static fb a(fz fzVar, String str) {
        int i;
        fb fbVar = new fb();
        try {
            i = Integer.parseInt(fzVar.k());
        } catch (Exception e) {
            b.m41a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        fbVar.a(i);
        fbVar.a(fzVar.j());
        fbVar.c(fzVar.m());
        fbVar.b(fzVar.n());
        fbVar.a("XMLMSG", (String) null);
        try {
            fbVar.a(fzVar.m352a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                fbVar.a((short) 3);
            } else {
                fbVar.a((short) 2);
                fbVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            b.m41a("Blob setPayload err： " + e2.getMessage());
        }
        return fbVar;
    }

    static fb a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            dw.a aVar = new dw.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new fb(aVar, s, bArr);
        } catch (Exception e) {
            b.m41a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fb.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            long j = a;
            a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public int a() {
        return this.f439a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m317a() {
        return this.f439a.m222c();
    }

    /* renamed from: a  reason: collision with other method in class */
    ByteBuffer mo318a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f441a);
        byteBuffer.putShort((short) this.f439a.mo211a());
        byteBuffer.putInt(this.f442b.length);
        int position = byteBuffer.position();
        this.f439a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f439a.mo211a());
        byteBuffer.position(position + this.f439a.mo211a());
        byteBuffer.put(this.f442b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m319a() {
        return this.f441a;
    }

    public void a(int i) {
        this.f439a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f439a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f439a.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f439a.b(str2);
        }
    }

    public void a(String str) {
        this.f439a.e(str);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f439a.c(str);
            this.f439a.mo217a();
            if (!TextUtils.isEmpty(str2)) {
                this.f439a.d(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("command should not be empty");
    }

    public void a(short s) {
        this.f441a = s;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f439a.c(1);
            this.f442b = bb.a(bb.a(str, e()), bArr);
            return;
        }
        this.f439a.c(0);
        this.f442b = bArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m320a() {
        return this.f439a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m321a() {
        return this.f442b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m322a(String str) {
        if (this.f439a.e() == 1) {
            return bb.a(bb.a(str, e()), this.f442b);
        }
        if (this.f439a.e() == 0) {
            return this.f442b;
        }
        b.m41a("unknow cipher = " + this.f439a.e());
        return this.f442b;
    }

    public int b() {
        return this.f439a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m323b() {
        return this.f439a.m224d();
    }

    public void b(String str) {
        this.f440a = str;
    }

    public int c() {
        return this.f439a.mo212b() + 8 + this.f442b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m324c() {
        return this.f439a.m228f();
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f439a.a(parseLong);
                this.f439a.a(substring);
                this.f439a.b(substring2);
            } catch (Exception e) {
                b.m41a("Blob parse user err " + e.getMessage());
            }
        }
    }

    public String e() {
        String e = this.f439a.m226e();
        if ("ID_NOT_AVAILABLE".equals(e)) {
            return null;
        }
        if (this.f439a.g()) {
            return e;
        }
        String d = d();
        this.f439a.e(d);
        return d;
    }

    public String f() {
        return this.f440a;
    }

    public String g() {
        if (!this.f439a.mo221b()) {
            return null;
        }
        return Long.toString(this.f439a.mo216a()) + "@" + this.f439a.mo218a() + "/" + this.f439a.mo220b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m317a() + "; type=" + ((int) m319a()) + "; from=" + g() + " ]";
    }
}
