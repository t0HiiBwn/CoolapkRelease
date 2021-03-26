package com.xiaomi.push;

class cq implements Runnable {
    final /* synthetic */ cp a;

    cq(cp cpVar) {
        this.a = cpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
