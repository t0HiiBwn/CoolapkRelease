package com.bytedance.tea.crash.e.a;

import android.content.Context;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.c.b;
import com.bytedance.tea.crash.g.k;
import com.bytedance.tea.crash.h;

/* compiled from: JavaCrashAssembly */
class g extends c {
    g(Context context, b bVar, d dVar) {
        super(c.JAVA, context, bVar, dVar);
    }

    @Override // com.bytedance.tea.crash.e.a.c
    public a a(a aVar) {
        a a = super.a(aVar);
        a.a("app_count", (Object) 1);
        a.a("magic_tag", "ss_app_log");
        c(a);
        b a2 = b.a(this.b);
        a2.a(h.a().a());
        a2.a(h.c().a());
        a2.b(this.c.c());
        a.a(a2);
        k.a(a, a2, this.a);
        return a;
    }
}
