package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.b.h;
import java.util.Map;
import java.util.Set;

/* compiled from: JsonObject */
public final class o extends l {
    private final h<String, l> a = new h<>();

    public void a(String str, l lVar) {
        h<String, l> hVar = this.a;
        if (lVar == null) {
            lVar = n.a;
        }
        hVar.put(str, lVar);
    }

    public Set<Map.Entry<String, l>> n() {
        return this.a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
