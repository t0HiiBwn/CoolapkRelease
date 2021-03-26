package com.bytedance.sdk.openadsdk.e.b;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.e.a.e;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.e.a.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: PreventTouchEventMethod */
public class g extends e<JSONObject, JSONObject> {
    private WeakReference<SSWebView> a;

    public static void a(q qVar, SSWebView sSWebView) {
        qVar.a("preventTouchEvent", (e<?, ?>) new g(sSWebView));
    }

    public g(SSWebView sSWebView) {
        this.a = new WeakReference<>(sSWebView);
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.a.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(optBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable th) {
            Log.e("PreventTouchEventMethod", "invoke error", th);
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
