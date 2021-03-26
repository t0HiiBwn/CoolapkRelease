package com.xiaomi.push;

import com.xiaomi.push.iu;

public class ir {
    private final iy a;

    /* renamed from: a  reason: collision with other field name */
    private final jh f867a;

    public ir() {
        this(new iu.a());
    }

    public ir(ja jaVar) {
        jh jhVar = new jh();
        this.f867a = jhVar;
        this.a = jaVar.a(jhVar);
    }

    public void a(in inVar, byte[] bArr) {
        try {
            this.f867a.a(bArr);
            inVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
