package com.bytedance.sdk.openadsdk.e.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.e.a.e;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.e.a.q;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;

/* compiled from: ReportPlayableScreenshotMethod */
public class h extends e<JSONObject, JSONObject> {
    public static void a(q qVar) {
        qVar.a("reportPlayableScreenshot", (e<?, ?>) new h());
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        return a(jSONObject);
    }

    private JSONObject a(JSONObject jSONObject) {
        u.b("ReportPlayableScreenshotMethod", "reportPlayableScreenshot ");
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            a(jSONObject2, 1, "params is null");
            return jSONObject2;
        }
        try {
            String optString = jSONObject.optString("image");
            String optString2 = jSONObject.optString("type");
            Bitmap a = com.bytedance.sdk.openadsdk.utils.f.a(optString);
            if (a == null) {
                a(jSONObject2, 1, "imageBase64 to Bitmap error");
                return jSONObject2;
            }
            l c = c();
            if (c == null) {
                a(jSONObject2, 1, "materialMeta is null");
                return jSONObject2;
            }
            ak.a(p.a(), c, "rewarded_video", "playable_show_status", com.bytedance.sdk.openadsdk.utils.f.a(a, a.getWidth() / 6, a.getHeight() / 6), true, b(optString2));
            return jSONObject2;
        } catch (Throwable unused) {
        }
    }

    private void a(JSONObject jSONObject, int i, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put("code", i);
                jSONObject.put("codeMsg", str);
            } catch (Exception unused) {
                u.b("ReportPlayableScreenshotMethod", str);
            }
        }
    }

    private l c() {
        String e = k.e();
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        try {
            return c.a(new JSONObject(e));
        } catch (Throwable unused) {
            u.f("ReportPlayableScreenshotMethod", "ReportPlayableScreenshotMethod materialMeta is null ");
            return null;
        }
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("video".equals(str)) {
            return 2;
        }
        if ("canvas".equals(str)) {
            return 3;
        }
        return 0;
    }
}
