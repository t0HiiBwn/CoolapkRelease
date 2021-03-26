package com.xiaomi.push;

import com.xiaomi.push.ai;
import com.xiaomi.push.ce;

class cf extends ai.a {
    final /* synthetic */ ce a;

    cf(ce ceVar) {
        this.a = ceVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "100957";
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.a.f253a) {
            if (this.a.f253a.size() > 0) {
                if (this.a.f253a.size() > 1) {
                    ce ceVar = this.a;
                    ceVar.a(ceVar.f253a);
                } else {
                    ce ceVar2 = this.a;
                    ceVar2.b((ce.a) ceVar2.f253a.get(0));
                }
                this.a.f253a.clear();
                System.gc();
            }
        }
    }
}
