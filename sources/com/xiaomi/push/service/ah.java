package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.bv;
import com.xiaomi.push.dc;
import com.xiaomi.push.jb;
import com.xiaomi.push.m;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.z;
import java.util.List;

class ah extends m.b {
    boolean a = false;
    final /* synthetic */ ag b;

    ah(ag agVar) {
        this.b = agVar;
    }

    @Override // com.xiaomi.push.m.b
    public void b() {
        try {
            dc.a b2 = dc.a.b(Base64.decode(bv.a(jb.a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<z>) null), 10));
            if (b2 != null) {
                this.b.c = b2;
                this.a = true;
                this.b.i();
            }
        } catch (Exception e) {
            c.a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.m.b
    public void c() {
        ag.a[] aVarArr;
        this.b.d = null;
        if (this.a) {
            synchronized (this.b) {
                aVarArr = (ag.a[]) this.b.b.toArray(new ag.a[this.b.b.size()]);
            }
            for (ag.a aVar : aVarArr) {
                aVar.a(this.b.c);
            }
        }
    }
}
