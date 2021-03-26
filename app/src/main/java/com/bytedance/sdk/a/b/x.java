package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.b;
import com.bytedance.sdk.a.b.a.c.g;
import com.bytedance.sdk.a.b.a.c.j;
import com.bytedance.sdk.a.b.a.g.e;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: RealCall */
final class x implements e {
    final v a;
    final j b;
    final y c;
    final boolean d;
    private p e;
    private boolean f;

    private x(v vVar, y yVar, boolean z) {
        this.a = vVar;
        this.c = yVar;
        this.d = z;
        this.b = new j(vVar, z);
    }

    static x a(v vVar, y yVar, boolean z) {
        x xVar = new x(vVar, yVar, z);
        xVar.e = vVar.x().a(xVar);
        return xVar;
    }

    @Override // com.bytedance.sdk.a.b.e
    public aa a() throws IOException {
        synchronized (this) {
            if (!this.f) {
                this.f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        g();
        this.e.a(this);
        try {
            this.a.s().a(this);
            aa f2 = f();
            if (f2 != null) {
                this.a.s().b(this);
                return f2;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            this.e.a(this, e2);
            throw e2;
        } catch (Throwable th) {
            this.a.s().b(this);
            throw th;
        }
    }

    private void g() {
        this.b.a(e.b().a("response.body().close()"));
    }

    public boolean b() {
        return this.b.a();
    }

    /* renamed from: c */
    public x clone() {
        return a(this.a, this.c, this.d);
    }

    /* compiled from: RealCall */
    final class a extends b {
        final /* synthetic */ x a;
        private final f c;

        String a() {
            return this.a.c.a().f();
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x003d A[SYNTHETIC, Splitter:B:13:0x003d] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005d A[Catch:{ all -> 0x0036 }] */
        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            IOException e;
            boolean z = true;
            try {
                aa f = this.a.f();
                if (this.a.b.a()) {
                    try {
                        this.c.a(this.a, new IOException("Canceled"));
                    } catch (IOException e2) {
                        e = e2;
                        if (!z) {
                        }
                        this.a.a.s().a(this);
                    }
                } else {
                    this.c.a(this.a, f);
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
                if (!z) {
                    try {
                        e b = e.b();
                        b.a(4, "Callback failure for " + this.a.d(), e);
                    } catch (Throwable th) {
                        this.a.a.s().a(this);
                        throw th;
                    }
                } else {
                    this.a.e.a(this.a, e);
                    this.c.a(this.a, e);
                }
                this.a.a.s().a(this);
            }
            this.a.a.s().a(this);
        }
    }

    String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(b() ? "canceled " : "");
        sb.append(this.d ? "web socket" : "call");
        sb.append(" to ");
        sb.append(e());
        return sb.toString();
    }

    String e() {
        return this.c.a().m();
    }

    aa f() throws IOException {
        ArrayList arrayList = new ArrayList(this.a.v());
        arrayList.add(this.b);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.a.f()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.a.g()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.a));
        if (!this.d) {
            arrayList.addAll(this.a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.d));
        return new g(arrayList, null, null, null, 0, this.c, this, this.e, this.a.a(), this.a.b(), this.a.c()).a(this.c);
    }
}
