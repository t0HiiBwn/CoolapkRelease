package com.xiaomi.push;

import com.xiaomi.push.ai;

class ak extends ai.b {
    final /* synthetic */ ai a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(ai aiVar, ai.a aVar) {
        super(aVar);
        this.a = aiVar;
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        synchronized (ai.a(this.a)) {
            ai.a(this.a).remove(this.a.mo141a());
        }
    }
}
