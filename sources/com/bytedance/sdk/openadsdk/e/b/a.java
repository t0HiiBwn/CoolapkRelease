package com.bytedance.sdk.openadsdk.e.b;

import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.e.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: ClickMiddleActivityBackMethod */
public class a extends d<JSONObject, JSONObject> {
    private WeakReference<x> a;

    public static void a(q qVar, final x xVar) {
        qVar.a("immersiveVideoPageBack", (d.b) new d.b() {
            /* class com.bytedance.sdk.openadsdk.e.b.a.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.e.a.d.b
            public d a() {
                return new a(xVar);
            }
        });
    }

    public a(x xVar) {
        this.a = new WeakReference<>(xVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        WeakReference<x> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            x xVar = this.a.get();
            if (xVar == null) {
                c();
            } else {
                xVar.b();
            }
        }
    }
}
