package com.xiaomi.push;

import com.xiaomi.push.ca;
import com.xiaomi.push.m;

class cc extends m.b {
    m.b a;
    final /* synthetic */ ca b;

    cc(ca caVar) {
        this.b = caVar;
    }

    @Override // com.xiaomi.push.m.b
    public void b() {
        ca.b bVar = (ca.b) ca.b(this.b).peek();
        if (bVar != null && bVar.d()) {
            if (ca.b(this.b).remove(bVar)) {
                this.a = bVar;
            }
            m.b bVar2 = this.a;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    @Override // com.xiaomi.push.m.b
    public void c() {
        m.b bVar = this.a;
        if (bVar != null) {
            bVar.c();
        }
    }
}
