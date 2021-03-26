package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bj;

class h implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bj f121a;

    h(a aVar, bj bjVar) {
        this.a = aVar;
        this.f121a = bjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f121a.run();
    }
}
