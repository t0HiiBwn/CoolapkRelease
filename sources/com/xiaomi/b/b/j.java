package com.xiaomi.b.b;

import com.xiaomi.push.aj;

class j implements Runnable {
    final /* synthetic */ aj a;
    final /* synthetic */ b b;

    j(b bVar, aj ajVar) {
        this.b = bVar;
        this.a = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
