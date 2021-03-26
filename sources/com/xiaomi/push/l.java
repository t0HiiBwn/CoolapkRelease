package com.xiaomi.push;

import com.xiaomi.push.j;

class l extends j.b {
    final /* synthetic */ j b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l(j jVar, j.a aVar) {
        super(aVar);
        this.b = jVar;
    }

    @Override // com.xiaomi.push.j.b
    void b() {
        synchronized (this.b.d) {
            this.b.c.remove(this.a.a());
        }
    }
}
