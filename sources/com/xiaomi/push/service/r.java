package com.xiaomi.push.service;

import com.xiaomi.push.service.q;

class r implements q.b.a {
    final /* synthetic */ q.b a;

    r(q.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.q.b.a
    public void a(q.c cVar, q.c cVar2, int i) {
        if (cVar2 == q.c.binding) {
            this.a.t.a(this.a.v, 60000);
        } else {
            this.a.t.b(this.a.v);
        }
    }
}
