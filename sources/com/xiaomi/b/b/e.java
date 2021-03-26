package com.xiaomi.b.b;

import com.xiaomi.push.j;

class e extends j.a {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 100888;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.g() > 0) {
            this.a.c.execute(new f(this));
        }
    }
}
