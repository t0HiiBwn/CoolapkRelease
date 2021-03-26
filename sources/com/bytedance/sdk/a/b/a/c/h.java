package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.u;

/* compiled from: RealResponseBody */
public final class h extends ab {
    private final String a;
    private final long b;
    private final e c;

    public h(String str, long j, e eVar) {
        this.a = str;
        this.b = j;
        this.c = eVar;
    }

    @Override // com.bytedance.sdk.a.b.ab
    public u a() {
        String str = this.a;
        if (str != null) {
            return u.a(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.a.b.ab
    public long b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.a.b.ab
    public e d() {
        return this.c;
    }
}
