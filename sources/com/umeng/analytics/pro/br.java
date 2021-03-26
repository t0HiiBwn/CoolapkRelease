package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cb;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: TSerializer */
public class br {
    private final ByteArrayOutputStream a;
    private final ct b;
    private ch c;

    public br() {
        this(new cb.a());
    }

    public br(cj cjVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        ct ctVar = new ct(byteArrayOutputStream);
        this.b = ctVar;
        this.c = cjVar.a(ctVar);
    }

    public byte[] a(bi biVar) throws bo {
        this.a.reset();
        biVar.write(this.c);
        return this.a.toByteArray();
    }

    public String a(bi biVar, String str) throws bo {
        try {
            return new String(a(biVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bo("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public String b(bi biVar) throws bo {
        return new String(a(biVar));
    }
}
