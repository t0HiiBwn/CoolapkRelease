package com.tencent.android.tpush.service.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class g {
    public long a = -1;
    public String b = "";
    public String c = "";

    public boolean a() {
        return this.a > 0 && !TextUtils.isEmpty(this.b) && !this.b.equals("0") && !TextUtils.isEmpty(this.c);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessid", this.a);
        jSONObject.put("token", this.b);
        jSONObject.put("channel", this.c);
        return jSONObject;
    }
}
