package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

/* compiled from: ProGuard */
public class h {
    public String a;
    public String b;
    public String c;
    public String d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ssid", this.a);
        jSONObject.put("bssid", this.b);
        jSONObject.put("mac", this.c);
        jSONObject.put("wflist", this.d);
        return jSONObject;
    }
}
