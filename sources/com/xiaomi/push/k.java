package com.xiaomi.push;

import com.xiaomi.push.j;

class k extends j.b {
    final /* synthetic */ String b;
    final /* synthetic */ j c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(j jVar, j.a aVar, String str) {
        super(aVar);
        this.c = jVar;
        this.b = str;
    }

    @Override // com.xiaomi.push.j.b
    void a() {
        super.a();
    }

    @Override // com.xiaomi.push.j.b
    void b() {
        this.c.e.edit().putLong(this.b, System.currentTimeMillis()).commit();
    }
}
