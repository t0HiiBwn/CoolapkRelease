package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.cz;

class db extends al.b {
    al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cz f308a;

    db(cz czVar) {
        this.f308a = czVar;
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: b */
    public void mo197b() {
        cz.b bVar = (cz.b) cz.a(this.f308a).peek();
        if (bVar != null && bVar.a()) {
            if (cz.a(this.f308a).remove(bVar)) {
                this.a = bVar;
            }
            al.b bVar2 = this.a;
            if (bVar2 != null) {
                bVar2.mo197b();
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo198c() {
        al.b bVar = this.a;
        if (bVar != null) {
            bVar.mo198c();
        }
    }
}
