package com.xiaomi.push;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.j;
import java.lang.ref.WeakReference;

class at extends j.a {
    final /* synthetic */ ar a;

    at(ar arVar) {
        this.a = arVar;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 10054;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.c("exec== DbSizeControlJob");
        be.a(this.a.f).a(new aw(this.a.d(), new WeakReference(this.a.f)));
        this.a.b("check_time");
    }
}
