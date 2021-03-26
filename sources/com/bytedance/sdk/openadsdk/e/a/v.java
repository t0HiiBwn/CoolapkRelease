package com.bytedance.sdk.openadsdk.e.a;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: PermissionConfigRepository */
class v {
    private final Collection<String> a;
    private final Map<String, u> b;
    private final k c;
    private final Set<a> d;

    /* compiled from: PermissionConfigRepository */
    interface a {
    }

    u a(String str) {
        if (this.a.contains(str) || TextUtils.equals(str, "host")) {
            return a(str, null);
        }
        throw new IllegalArgumentException("Namespace: " + str + " not registered.");
    }

    void a(a aVar) {
        this.d.add(aVar);
    }

    private u a(String str, JSONObject jSONObject) {
        u uVar = this.b.get(str);
        if (uVar == null) {
            u uVar2 = new u(str, this.c.c(), this.c.a(), this.c.b(), jSONObject);
            this.b.put(str, uVar2);
            return uVar2;
        } else if (jSONObject == null) {
            return uVar;
        } else {
            uVar.a(jSONObject);
            return uVar;
        }
    }
}
