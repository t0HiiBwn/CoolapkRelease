package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class o extends d {
    public long a = 0;
    public String b = "";
    public String c = "";
    public int d = 0;
    public long e = 0;
    public String f = "";

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put("tag", this.c);
        jSONObject.put("flag", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put("sdkVersion", this.f);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.TAG_INFO;
    }
}
