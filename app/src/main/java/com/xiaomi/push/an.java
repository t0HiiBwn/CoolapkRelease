package com.xiaomi.push;

import com.xiaomi.push.al;

class an implements Runnable {
    final /* synthetic */ al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f197a;

    an(al alVar, al.b bVar) {
        this.f197a = alVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f197a.a(this.a);
    }
}
