package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.c.g;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;

/* compiled from: ConnectInterceptor */
public final class a implements t {
    public final v a;

    public a(v vVar) {
        this.a = vVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        g gVar = (g) aVar;
        y a2 = gVar.a();
        g f = gVar.f();
        return gVar.a(a2, f, f.a(this.a, aVar, !a2.b().equals("GET")), f.b());
    }
}
