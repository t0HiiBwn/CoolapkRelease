package com.bytedance.sdk.openadsdk.e.b;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.e.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DoNewClickEventMethod */
public class c extends d<JSONObject, JSONObject> {
    private WeakReference<x> a;

    public static void a(q qVar, final x xVar) {
        qVar.a("newClickEvent", (d.b) new d.b() {
            /* class com.bytedance.sdk.openadsdk.e.b.c.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.e.a.d.b
            public d a() {
                return new c(xVar);
            }
        });
    }

    public c(x xVar) {
        this.a = new WeakReference<>(xVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        if (i.d().v()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version: 3 data=");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            Log.d("DoNewClickEventMethod", sb.toString());
        }
        x xVar = this.a.get();
        if (xVar == null) {
            Log.e("DoNewClickEventMethod", "invoke error");
            c();
            return;
        }
        xVar.c(jSONObject);
    }
}
