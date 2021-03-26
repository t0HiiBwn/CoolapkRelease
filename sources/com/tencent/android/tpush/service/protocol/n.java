package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

/* compiled from: ProGuard */
public class n {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bootTime", this.a);
        jSONObject.put("countryCode", this.b);
        jSONObject.put("deviceName", this.c);
        jSONObject.put("carrierInfo", this.d);
        jSONObject.put("memorySize", this.e);
        jSONObject.put("diskSize", this.f);
        jSONObject.put("sysFileTime", this.g);
        return jSONObject;
    }
}
