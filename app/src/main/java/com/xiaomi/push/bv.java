package com.xiaomi.push;

import com.xiaomi.push.ai;

class bv extends ai.a {
    final /* synthetic */ bs a;

    bv(bs bsVar) {
        this.a = bsVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "10053";
    }

    @Override // java.lang.Runnable
    public void run() {
        if (bs.a(this.a) != null) {
            bs.a(this.a).b(bs.a(this.a));
            this.a.b("delete_time");
        }
    }
}
