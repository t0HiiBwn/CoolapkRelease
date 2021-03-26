package com.xiaomi.b.b;

import com.xiaomi.push.j;

class g extends j.a {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 100889;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.h() > 0) {
            this.a.c.execute(new h(this));
        }
    }
}
