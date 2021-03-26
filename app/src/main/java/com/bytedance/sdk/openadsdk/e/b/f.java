package com.bytedance.sdk.openadsdk.e.b;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.e;
import com.bytedance.sdk.openadsdk.e.a.q;
import org.json.JSONObject;

/* compiled from: OldBridgeSyncMethod */
public class f extends e<JSONObject, JSONObject> {
    private String a;
    private x b;

    public f(String str, x xVar) {
        this.b = xVar;
        this.a = str;
    }

    public static void a(q qVar, x xVar) {
        qVar.a("appInfo", (e<?, ?>) new f("appInfo", xVar));
        qVar.a("adInfo", (e<?, ?>) new f("adInfo", xVar));
        qVar.a("playable_style", (e<?, ?>) new f("playable_style", xVar));
        qVar.a("getTemplateInfo", (e<?, ?>) new f("getTemplateInfo", xVar));
        qVar.a("getTeMaiAds", (e<?, ?>) new f("getTeMaiAds", xVar));
        qVar.a("isViewable", (e<?, ?>) new f("isViewable", xVar));
        qVar.a("getScreenSize", (e<?, ?>) new f("getScreenSize", xVar));
        qVar.a("getCloseButtonInfo", (e<?, ?>) new f("getCloseButtonInfo", xVar));
        qVar.a("getVolume", (e<?, ?>) new f("getVolume", xVar));
        qVar.a("removeLoading", (e<?, ?>) new f("removeLoading", xVar));
        qVar.a("sendReward", (e<?, ?>) new f("sendReward", xVar));
        qVar.a("subscribe_app_ad", (e<?, ?>) new f("subscribe_app_ad", xVar));
        qVar.a("download_app_ad", (e<?, ?>) new f("download_app_ad", xVar));
        qVar.a("cancel_download_app_ad", (e<?, ?>) new f("cancel_download_app_ad", xVar));
        qVar.a("unsubscribe_app_ad", (e<?, ?>) new f("unsubscribe_app_ad", xVar));
        qVar.a("landscape_click", (e<?, ?>) new f("landscape_click", xVar));
        qVar.a("clickEvent", (e<?, ?>) new f("clickEvent", xVar));
        qVar.a("renderDidFinish", (e<?, ?>) new f("renderDidFinish", xVar));
        qVar.a("dynamicTrack", (e<?, ?>) new f("dynamicTrack", xVar));
        qVar.a("skipVideo", (e<?, ?>) new f("skipVideo", xVar));
        qVar.a("muteVideo", (e<?, ?>) new f("muteVideo", xVar));
        qVar.a("changeVideoState", (e<?, ?>) new f("changeVideoState", xVar));
        qVar.a("getCurrentVideoState", (e<?, ?>) new f("getCurrentVideoState", xVar));
        qVar.a("send_temai_product_ids", (e<?, ?>) new f("send_temai_product_ids", xVar));
        qVar.a("getMaterialMeta", (e<?, ?>) new f("getMaterialMeta", xVar));
        qVar.a("endcard_load", (e<?, ?>) new f("endcard_load", xVar));
        qVar.a("pauseWebView", (e<?, ?>) new f("pauseWebView", xVar));
        qVar.a("pauseWebViewTimers", (e<?, ?>) new f("pauseWebViewTimers", xVar));
        qVar.a("webview_time_track", (e<?, ?>) new f("webview_time_track", xVar));
    }

    public JSONObject a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.e.a.f fVar) throws Exception {
        x.a aVar = new x.a();
        aVar.a = "call";
        aVar.c = this.a;
        aVar.d = jSONObject;
        JSONObject a2 = this.b.a(aVar, 3);
        if (i.d().v()) {
            Log.d("OldBridgeSyncMethod", "[JSB-RSP] version: 3 data=" + a2.toString());
        }
        return a2;
    }
}
