package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

/* compiled from: ProGuard */
public class p {
    int a = 0;
    String b = null;

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public JSONObject a() {
        if (this.b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accountType", this.a);
        jSONObject.put("account", this.b);
        return jSONObject;
    }
}
