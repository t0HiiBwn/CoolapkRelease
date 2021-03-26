package com.xiaomi.push;

import com.xiaomi.push.m;

class o implements Runnable {
    final /* synthetic */ m.b a;
    final /* synthetic */ m b;

    o(m mVar, m.b bVar) {
        this.b = mVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a);
    }
}
