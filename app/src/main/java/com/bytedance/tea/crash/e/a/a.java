package com.bytedance.tea.crash.e.a;

import android.content.Context;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.c.b;
import com.bytedance.tea.crash.g.k;
import com.bytedance.tea.crash.h;

/* compiled from: ANRAssembly */
class a extends c {
    a(Context context, b bVar, d dVar) {
        super(c.ANR, context, bVar, dVar);
    }

    @Override // com.bytedance.tea.crash.e.a.c
    public com.bytedance.tea.crash.c.a a(com.bytedance.tea.crash.c.a aVar) {
        com.bytedance.tea.crash.c.a a = super.a(aVar);
        b a2 = b.a(this.b);
        a2.a(h.a().a());
        a2.a(h.c().a());
        a2.b(this.c.c());
        a.a(a2);
        a.a("process_name", com.bytedance.tea.crash.g.a.d(this.b));
        k.a(a, a2, this.a);
        return a;
    }
}
