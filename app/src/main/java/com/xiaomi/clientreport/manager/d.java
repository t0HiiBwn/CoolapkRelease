package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;

class d extends ai.a {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "100888";
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.a(this.a) > 0) {
            a.a(this.a).execute(new e(this));
        }
    }
}
