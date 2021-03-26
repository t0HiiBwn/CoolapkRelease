package com.bytedance.sdk.openadsdk.e.b;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.e.a.q;
import com.bytedance.sdk.openadsdk.f.c;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* compiled from: DoGetAdsFromNetworkAsyncMethod */
public class b extends d<JSONObject, JSONObject> {
    private WeakReference<x> a;

    public static void a(q qVar, final x xVar) {
        qVar.a("getNetworkData", (d.b) new d.b() {
            /* class com.bytedance.sdk.openadsdk.e.b.b.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.e.a.d.b
            public d a() {
                return new b(xVar);
            }
        });
    }

    public b(x xVar) {
        this.a = new WeakReference<>(xVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        if (i.d().v()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version: 3 data=");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            Log.d("DoGetAdsFromNetwork", sb.toString());
        }
        x xVar = this.a.get();
        if (xVar == null) {
            Log.e("DoGetAdsFromNetwork", "invoke error");
            c();
            return;
        }
        xVar.a(jSONObject, new c() {
            /* class com.bytedance.sdk.openadsdk.e.b.b.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.f.c
            public void a(boolean z, List<l> list) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        jSONObject.put("creatives", x.b(list));
                        b.this.a((b) jSONObject);
                    } else {
                        b.this.a((b) jSONObject);
                    }
                    if (i.d().v()) {
                        Log.d("DoGetAdsFromNetwork", "[JSB-RSP] version: 3 data=" + jSONObject.toString());
                    }
                } catch (Throwable th) {
                    Log.e("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        });
    }
}
