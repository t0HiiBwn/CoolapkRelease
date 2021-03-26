package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;

class f extends ai.a {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "100889";
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.b(this.a) > 0) {
            a.a(this.a).execute(new g(this));
        }
    }
}
