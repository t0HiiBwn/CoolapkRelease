package com.bytedance.sdk.openadsdk.core.dynamic.b;

import com.bytedance.sdk.openadsdk.a.a;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DynamicAppInfo */
public class b {
    private List<String> b() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : b()) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put("appName", a.a());
            jSONObject.put("innerAppName", a.e());
            jSONObject.put("aid", a.b());
            jSONObject.put("sdkEdition", a.c());
            jSONObject.put("appVersion", a.d());
            jSONObject.put("netType", a.f());
            jSONObject.put("supportList", jSONArray);
            jSONObject.put("deviceId", a.a(p.a()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
