package com.xiaomi.push;

import com.xiaomi.push.fy;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.q;

class fu implements q.b.a {
    private XMPushService a;
    private q.b b;
    private em c;
    private q.c d;
    private int e;
    private boolean f = false;

    fu(XMPushService xMPushService, q.b bVar) {
        this.a = xMPushService;
        this.d = q.c.binding;
        this.b = bVar;
    }

    private void b() {
        this.b.b(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    public void c() {
        eb ebVar;
        b();
        if (this.f && this.e != 11) {
            ec f2 = ga.a().f();
            int i = fx.a[this.d.ordinal()];
            if (i != 1) {
                if (i == 3) {
                    ebVar = eb.BIND_SUCCESS;
                }
                if (f2 != null) {
                    f2.b(this.c.e());
                    f2.d(this.b.b);
                    f2.c = 1;
                    try {
                        f2.a((byte) Integer.parseInt(this.b.h));
                    } catch (NumberFormatException unused) {
                    }
                    ga.a().a(f2);
                    return;
                }
                return;
            }
            int i2 = this.e;
            if (i2 == 17) {
                ebVar = eb.BIND_TCP_READ_TIMEOUT;
            } else if (i2 == 21) {
                ebVar = eb.BIND_TIMEOUT;
            } else {
                try {
                    fy.a c2 = fy.c(ga.b().a());
                    f2.b = c2.a.a();
                    f2.c(c2.b);
                } catch (NullPointerException unused2) {
                    f2 = null;
                }
                if (f2 != null) {
                }
            }
            f2.b = ebVar.a();
            if (f2 != null) {
            }
        }
    }

    void a() {
        this.b.a(this);
        this.c = this.a.h();
    }

    @Override // com.xiaomi.push.service.q.b.a
    public void a(q.c cVar, q.c cVar2, int i) {
        if (!this.f && cVar == q.c.binding) {
            this.d = cVar2;
            this.e = i;
            this.f = true;
        }
        this.a.a(new fw(this, 4));
    }
}
