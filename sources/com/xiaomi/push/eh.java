package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dd;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.z;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

public class eh {
    ByteBuffer a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);
    private Adler32 c = new Adler32();
    private ek d;
    private OutputStream e;
    private int f;
    private int g;
    private byte[] h;

    eh(OutputStream outputStream, ek ekVar) {
        this.e = new BufferedOutputStream(outputStream);
        this.d = ekVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f = timeZone.getRawOffset() / 3600000;
        this.g = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(ef efVar) {
        int l = efVar.l();
        if (l > 32768) {
            c.a("Blob size=" + l + " should be less than 32768 Drop blob chid=" + efVar.c() + " id=" + efVar.h());
            return 0;
        }
        this.a.clear();
        int i = l + 8 + 4;
        if (i > this.a.capacity() || this.a.capacity() > 4096) {
            this.a = ByteBuffer.allocate(i);
        }
        this.a.putShort(-15618);
        this.a.putShort(5);
        this.a.putInt(l);
        int position = this.a.position();
        this.a = efVar.a(this.a);
        if (!"CONN".equals(efVar.a())) {
            if (this.h == null) {
                this.h = this.d.a();
            }
            z.a(this.h, this.a.array(), true, position, l);
        }
        this.c.reset();
        this.c.update(this.a.array(), 0, this.a.position());
        this.b.putInt(0, (int) this.c.getValue());
        this.e.write(this.a.array(), 0, this.a.position());
        this.e.write(this.b.array(), 0, 4);
        this.e.flush();
        int position2 = this.a.position() + 4;
        c.c("[Slim] Wrote {cmd=" + efVar.a() + ";chid=" + efVar.c() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        dd.e eVar = new dd.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(jb.e());
        eVar.c(ag.e());
        eVar.b(39);
        eVar.d(this.d.f());
        eVar.e(this.d.e());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] c2 = this.d.d().c();
        if (c2 != null) {
            eVar.a(dd.b.b(c2));
        }
        ef efVar = new ef();
        efVar.a(0);
        efVar.a("CONN", (String) null);
        efVar.a(0, "xiaomi.com", null);
        efVar.a(eVar.c(), (String) null);
        a(efVar);
        c.a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + ag.e() + " tz=" + this.f + ":" + this.g + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        ef efVar = new ef();
        efVar.a("CLOSE", (String) null);
        a(efVar);
        this.e.close();
    }
}
