package com.xiaomi.push;

class fs implements Runnable {
    final /* synthetic */ fp a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f482a;

    fs(fp fpVar, String str) {
        this.a = fpVar;
        this.f482a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cq.a().a(this.f482a, true);
    }
}
