package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.a.b.c;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.i;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.util.List;

/* compiled from: RealInterceptorChain */
public final class g implements t.a {
    private final List<t> a;
    private final com.bytedance.sdk.a.b.a.b.g b;
    private final c c;
    private final c d;
    private final int e;
    private final y f;
    private final e g;
    private final p h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<t> list, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, c cVar2, int i2, y yVar, e eVar, p pVar, int i3, int i4, int i5) {
        this.a = list;
        this.d = cVar2;
        this.b = gVar;
        this.c = cVar;
        this.e = i2;
        this.f = yVar;
        this.g = eVar;
        this.h = pVar;
        this.i = i3;
        this.j = i4;
        this.k = i5;
    }

    public i e() {
        return this.d;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int b() {
        return this.i;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int c() {
        return this.j;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int d() {
        return this.k;
    }

    public com.bytedance.sdk.a.b.a.b.g f() {
        return this.b;
    }

    public c g() {
        return this.c;
    }

    public e h() {
        return this.g;
    }

    public p i() {
        return this.h;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public y a() {
        return this.f;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public aa a(y yVar) throws IOException {
        return a(yVar, this.b, this.c, this.d);
    }

    public aa a(y yVar, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, c cVar2) throws IOException {
        if (this.e < this.a.size()) {
            this.l++;
            if (this.c != null && !this.d.a(yVar.a())) {
                throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must retain the same host and port");
            } else if (this.c == null || this.l <= 1) {
                g gVar2 = new g(this.a, gVar, cVar, cVar2, this.e + 1, yVar, this.g, this.h, this.i, this.j, this.k);
                t tVar = this.a.get(this.e);
                aa a2 = tVar.a(gVar2);
                if (cVar != null && this.e + 1 < this.a.size() && gVar2.l != 1) {
                    throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                } else if (a2 == null) {
                    throw new NullPointerException("interceptor " + tVar + " returned null");
                } else if (a2.h() != null) {
                    return a2;
                } else {
                    throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }
}
