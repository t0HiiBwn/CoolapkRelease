package com.xiaomi.push;

import com.xiaomi.push.be;
import com.xiaomi.push.j;

class bf extends j.a {
    final /* synthetic */ be a;

    bf(be beVar) {
        this.a = beVar;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 100957;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.a.f) {
            if (this.a.f.size() > 0) {
                if (this.a.f.size() > 1) {
                    be beVar = this.a;
                    beVar.a(beVar.f);
                } else {
                    be beVar2 = this.a;
                    beVar2.b((be.a) beVar2.f.get(0));
                }
                this.a.f.clear();
                System.gc();
            }
        }
    }
}
