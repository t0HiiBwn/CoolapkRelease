package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class i extends d {
    public long a = 0;
    public long b = 0;
    public long c = 0;
    public long d = 0;
    public long e = 0;
    public long f = 0;
    public String g = "";
    public String h = "";
    public String i = "";

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.a);
        jSONObject.put("accessId", this.b);
        jSONObject.put("msgId", this.c);
        jSONObject.put("broadcastId", this.d);
        jSONObject.put("msgTimestamp", this.e);
        jSONObject.put("clientTimestamp", this.f);
        jSONObject.put("msg", this.g);
        jSONObject.put("ext", this.h);
        jSONObject.put("pkgName", this.i);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.COMMON_REPORT;
    }
}
