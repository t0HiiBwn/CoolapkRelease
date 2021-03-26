package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bk;

class i implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bk f122a;

    i(a aVar, bk bkVar) {
        this.a = aVar;
        this.f122a = bkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f122a.run();
    }
}
