package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class q extends d {
    public short a = 0;
    public long b = 0;
    public String c = "";
    public String d = "";
    public byte e = 0;
    public byte f = 0;
    public long g = 0;
    public String h = "";

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceType", (int) this.a);
        jSONObject.put("accessId", this.b);
        jSONObject.put("accessKey", this.c);
        jSONObject.put("appCert", this.d);
        jSONObject.put("keyEncrypted", (int) this.e);
        jSONObject.put("isUninstall", (int) this.f);
        jSONObject.put("timestamp", this.g);
        jSONObject.put("sdkVersion", this.h);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.UNREGISTER;
    }
}
