package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bh;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

public class fd {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fg f449a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f450a;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f451a = ByteBuffer.allocate(2048);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f452a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private byte[] f453a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f454b = ByteBuffer.allocate(4);

    fd(OutputStream outputStream, fg fgVar) {
        this.f450a = new BufferedOutputStream(outputStream);
        this.f449a = fgVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fb fbVar) {
        int c = fbVar.c();
        if (c > 32768) {
            b.m41a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + fbVar.a() + " id=" + fbVar.e());
            return 0;
        }
        this.f451a.clear();
        int i = c + 8 + 4;
        if (i > this.f451a.capacity() || this.f451a.capacity() > 4096) {
            this.f451a = ByteBuffer.allocate(i);
        }
        this.f451a.putShort(-15618);
        this.f451a.putShort(5);
        this.f451a.putInt(c);
        int position = this.f451a.position();
        this.f451a = fbVar.mo318a(this.f451a);
        if (!"CONN".equals(fbVar.m317a())) {
            if (this.f453a == null) {
                this.f453a = this.f449a.mo328a();
            }
            bb.a(this.f453a, this.f451a.array(), true, position, c);
        }
        this.f452a.reset();
        this.f452a.update(this.f451a.array(), 0, this.f451a.position());
        this.f454b.putInt(0, (int) this.f452a.getValue());
        this.f450a.write(this.f451a.array(), 0, this.f451a.position());
        this.f450a.write(this.f454b.array(), 0, 4);
        this.f450a.flush();
        int position2 = this.f451a.position() + 4;
        b.c("[Slim] Wrote {cmd=" + fbVar.m317a() + ";chid=" + fbVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        dw.e eVar = new dw.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m675a());
        eVar.c(bh.m641a());
        eVar.b(41);
        eVar.d(this.f449a.b());
        eVar.e(this.f449a.mo328a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] a2 = this.f449a.mo328a().m339a();
        if (a2 != null) {
            eVar.a(dw.b.a(a2));
        }
        fb fbVar = new fb();
        fbVar.a(0);
        fbVar.a("CONN", (String) null);
        fbVar.a(0, "xiaomi.com", null);
        fbVar.a(eVar.mo211a(), (String) null);
        a(fbVar);
        b.m41a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=41 hash=" + bh.m641a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fb fbVar = new fb();
        fbVar.a("CLOSE", (String) null);
        a(fbVar);
        this.f450a.close();
    }
}
