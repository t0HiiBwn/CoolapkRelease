package com.bytedance.sdk.openadsdk.g.c;

import com.bytedance.sdk.openadsdk.g.c.c;
import com.bytedance.sdk.openadsdk.multipro.c.a;
import java.util.UUID;

/* compiled from: LogUploaderImpl4MultiProcess */
public class d implements a {
    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a() {
        a.d();
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(com.bytedance.sdk.openadsdk.g.a.a aVar) {
        try {
            a.c(aVar.a().toString());
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(com.bytedance.sdk.openadsdk.g.a.a aVar, boolean z) {
        try {
            a.a(new c.a(UUID.randomUUID().toString(), aVar.a()).a(), z);
        } catch (Throwable unused) {
        }
    }
}
