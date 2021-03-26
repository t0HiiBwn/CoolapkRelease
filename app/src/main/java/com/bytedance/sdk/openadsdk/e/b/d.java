package com.bytedance.sdk.openadsdk.e.b;

import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.e;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.e.a.q;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: GetAppManageModelMethod */
public class d extends e<JSONObject, JSONObject> {
    private WeakReference<x> a;

    public static void a(q qVar, x xVar) {
        qVar.a("getAppManage", (e<?, ?>) new d(xVar));
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        return a(jSONObject);
    }

    public d(x xVar) {
        this.a = new WeakReference<>(xVar);
    }

    public JSONObject a(JSONObject jSONObject) {
        x xVar;
        JSONObject jSONObject2 = new JSONObject();
        try {
            WeakReference<x> weakReference = this.a;
            if (weakReference == null || (xVar = weakReference.get()) == null) {
                return jSONObject2;
            }
            JSONObject k = xVar.k();
            u.b("GetAppManageModelMethod", "GetAppManageModelMethod analysisJson resultJsonObject " + k.toString());
            return k;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }
}
