package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class r extends d {
    public long a = 0;
    public String b = "";
    public String c = "";
    public String d = "";
    public long e = 0;
    public String f = "";

    public r() {
    }

    public r(long j, String str, String str2, String str3, long j2, String str4) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j2;
        this.f = str4;
    }

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put("channelType", this.c);
        jSONObject.put("channelToken", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put("sdkVersion", this.f);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.UPDATE_OTHER_TOKEN;
    }
}
