package com.xiaomi.push;

import com.xiaomi.push.ic;
import java.io.ByteArrayOutputStream;

public class ib {
    private final ByteArrayOutputStream a;
    private final in b;
    private ig c;

    public ib() {
        this(new ic.a());
    }

    public ib(ii iiVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        in inVar = new in(byteArrayOutputStream);
        this.b = inVar;
        this.c = iiVar.a(inVar);
    }

    public byte[] a(hu huVar) {
        this.a.reset();
        huVar.b(this.c);
        return this.a.toByteArray();
    }
}
