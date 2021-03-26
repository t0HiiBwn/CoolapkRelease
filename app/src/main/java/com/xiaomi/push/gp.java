package com.xiaomi.push;

import com.xiaomi.push.gs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;

class gp implements as.b.a {
    private int a;

    /* renamed from: a */
    private fi f517a;

    /* renamed from: a */
    private XMPushService f518a;

    /* renamed from: a */
    private as.b f519a;

    /* renamed from: a */
    private as.c f520a;

    /* renamed from: a */
    private boolean f521a = false;

    gp(XMPushService xMPushService, as.b bVar) {
        this.f518a = xMPushService;
        this.f520a = as.c.binding;
        this.f519a = bVar;
    }

    private void b() {
        this.f519a.b(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    public void c() {
        ex exVar;
        b();
        if (this.f521a && this.a != 11) {
            ey a2 = gu.m378a().m380a();
            int i = gr.a[this.f520a.ordinal()];
            if (i != 1) {
                if (i == 3) {
                    exVar = ex.BIND_SUCCESS;
                }
                if (a2 != null) {
                    a2.b(this.f517a.m331a());
                    a2.d(this.f519a.f971b);
                    a2.f427b = 1;
                    try {
                        a2.a((byte) Integer.parseInt(this.f519a.g));
                    } catch (NumberFormatException unused) {
                    }
                    gu.m378a().a(a2);
                    return;
                }
                return;
            }
            int i2 = this.a;
            if (i2 == 17) {
                exVar = ex.BIND_TCP_READ_TIMEOUT;
            } else if (i2 == 21) {
                exVar = ex.BIND_TIMEOUT;
            } else {
                try {
                    gs.a c = gs.c(gu.a().a());
                    a2.f424a = c.a.a();
                    a2.c(c.f522a);
                } catch (NullPointerException unused2) {
                    a2 = null;
                }
                if (a2 != null) {
                }
            }
            a2.f424a = exVar.a();
            if (a2 != null) {
            }
        }
    }

    void a() {
        this.f519a.a(this);
        this.f517a = this.f518a.m581a();
    }

    @Override // com.xiaomi.push.service.as.b.a
    public void a(as.c cVar, as.c cVar2, int i) {
        if (!this.f521a && cVar == as.c.binding) {
            this.f520a = cVar2;
            this.a = i;
            this.f521a = true;
        }
        this.f518a.a(new gq(this, 4));
    }
}
