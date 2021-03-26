package com.bytedance.sdk.openadsdk.e.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.d.a;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.e.a.q;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;

/* compiled from: GetDownloadStatusMethod */
public class e extends com.bytedance.sdk.openadsdk.e.a.e<JSONObject, JSONObject> {
    public static void a(q qVar) {
        qVar.a("getDownloadStatus", (com.bytedance.sdk.openadsdk.e.a.e<?, ?>) new e());
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        return a(jSONObject);
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            a(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String optString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(optString)) {
                a(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            u.b("GetDownloadStatusMethod", "GetDownloadStatusMethod analysisJson downloadId " + optString);
            JSONObject a = a.C0049a.a(optString);
            u.b("GetDownloadStatusMethod", "GetDownloadStatusMethod analysisJson downloadJson " + a.toString());
            return a;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void a(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject != null) {
            try {
                jSONObject.put("code", i);
                jSONObject.put("codeMsg", str);
                jSONObject.put("downloadStatus", i2);
                jSONObject.put("downloadProcessRate", i3);
            } catch (Exception unused) {
                u.b("GetDownloadStatusMethod", str);
            }
        }
    }
}
