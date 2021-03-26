package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.openadsdk.g.c.c;
import com.bytedance.sdk.openadsdk.multipro.c.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StatsDispatcher4MultiProcess */
public class m extends b<c.a> {
    private AtomicBoolean a = new AtomicBoolean(false);
    private boolean b = true;

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    public m(boolean z) {
        this.b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (!this.a.getAndSet(true)) {
            a.a(this.b);
        }
    }

    public void a(c.a aVar) {
        if (this.a.get()) {
            a.a(aVar.a(), this.b);
        }
    }
}
