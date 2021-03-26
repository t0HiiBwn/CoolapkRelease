package com.xiaomi.b.b;

import com.xiaomi.b.a.c;

class d implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    d(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.a);
    }
}
