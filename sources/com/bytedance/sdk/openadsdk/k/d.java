package com.bytedance.sdk.openadsdk.k;

import java.util.List;

/* compiled from: TrackAdUrlImplEmpty */
class d implements a {
    private static volatile d a;

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a(String str, List<String> list, boolean z) {
    }

    public static d b() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private d() {
    }
}
