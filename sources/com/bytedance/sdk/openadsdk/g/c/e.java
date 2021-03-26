package com.bytedance.sdk.openadsdk.g.c;

import com.bytedance.sdk.openadsdk.g.a.a;

/* compiled from: LogUploaderImplEmpty */
class e implements a {
    private static volatile e a;

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(a aVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(a aVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void b() {
    }

    public static e c() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private e() {
    }
}
