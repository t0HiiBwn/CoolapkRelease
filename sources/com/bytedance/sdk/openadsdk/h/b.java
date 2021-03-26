package com.bytedance.sdk.openadsdk.h;

import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.g.a;
import com.bytedance.sdk.openadsdk.g.a.c;

/* compiled from: StatsImageListener */
public class b implements d.AbstractC0032d {
    private boolean a;
    private c b;

    @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
    public void a() {
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public void a(m<Bitmap> mVar) {
    }

    @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
    public void b() {
    }

    public void a(String str) {
        c cVar;
        if (this.a && (cVar = this.b) != null) {
            cVar.c(str);
        }
    }

    public void a(int i) {
        c cVar;
        if (this.a && (cVar = this.b) != null) {
            cVar.a(i);
        }
    }

    public void b(String str) {
        c cVar;
        if (this.a && (cVar = this.b) != null) {
            cVar.f(str);
        }
    }

    public void c(String str) {
        c cVar;
        if (this.a && (cVar = this.b) != null) {
            cVar.d(str);
        }
    }

    public void d(String str) {
        c cVar;
        if (this.a && (cVar = this.b) != null) {
            cVar.h(str);
        }
    }

    public b(boolean z) {
        this.a = z;
        if (z) {
            this.b = c.b();
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
    public void a(d.c cVar, boolean z) {
        if (this.a && this.b != null) {
            if (cVar == null || cVar.a() == null) {
                this.b.b(202).g(h.a(202));
                a.a().k(this.b);
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public void b(m<Bitmap> mVar) {
        c cVar;
        if (this.a && (cVar = this.b) != null) {
            cVar.b(201).g(h.a(201));
            a.a().k(this.b);
        }
    }
}
