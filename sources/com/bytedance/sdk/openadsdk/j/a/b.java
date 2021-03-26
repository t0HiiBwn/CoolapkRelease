package com.bytedance.sdk.openadsdk.j.a;

import com.bytedance.sdk.openadsdk.j.e;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKThreadStateLogModel */
public class b {
    private int a = e.a;
    private int b = 0;
    private String c = "";

    public b(int i, String str) {
        this.b = i;
        this.c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.a);
            jSONObject.put("sdkThreadCount", this.b);
            jSONObject.put("sdkThreadNames", this.c);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
