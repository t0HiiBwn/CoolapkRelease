package com.xiaomi.push;

import com.xiaomi.push.iu;
import java.io.ByteArrayOutputStream;

public class it {
    private iy a;

    /* renamed from: a  reason: collision with other field name */
    private final jf f868a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f869a;

    public it() {
        this(new iu.a());
    }

    public it(ja jaVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f869a = byteArrayOutputStream;
        jf jfVar = new jf(byteArrayOutputStream);
        this.f868a = jfVar;
        this.a = jaVar.a(jfVar);
    }

    public byte[] a(in inVar) {
        this.f869a.reset();
        inVar.b(this.a);
        return this.f869a.toByteArray();
    }
}
