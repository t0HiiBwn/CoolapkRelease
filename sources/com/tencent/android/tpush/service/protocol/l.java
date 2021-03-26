package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.Md5;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class l extends d {
    public String A = "";
    public String B = "";
    public String C = "";
    public int D = 0;
    public g E = null;
    public int F = 0;
    public long G = 0;
    private boolean H = true;
    public long a = 0;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public short f = 0;
    public short g = 0;
    public f h = null;
    public short i = 0;
    public byte j = 0;
    public h k = null;
    public short l = 0;
    public String m = "";
    public String n = "";
    public String o = "";
    public long p = 0;
    public long q = 0;
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public String v = "";
    public long w = 0;
    public long x = 0;
    public String y = "";
    public String z = "";

    public boolean b(Context context) {
        try {
            a(context);
        } catch (Throwable th) {
            TLogger.d("RegisterReq", "unexpected for:" + th.getMessage());
        }
        return this.H;
    }

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put("deviceId", this.c);
        jSONObject.put("appCert", this.d);
        jSONObject.put("ticket", this.e);
        jSONObject.put("ticketType", (int) this.f);
        jSONObject.put("deviceType", (int) this.g);
        f fVar = this.h;
        if (fVar != null) {
            jSONObject.put("deviceInfo", fVar.a());
        }
        jSONObject.put("version", (int) this.i);
        jSONObject.put("keyEncrypted", (int) this.j);
        h hVar = this.k;
        if (hVar != null) {
            jSONObject.put("mutableInfo", hVar.a());
        }
        jSONObject.put("updateAutoTag", (int) this.l);
        jSONObject.put("appVersion", this.m);
        jSONObject.put("clientid", this.o);
        jSONObject.put("connVersion", this.r);
        jSONObject.put("channelId", this.s);
        jSONObject.put("otherPushTokenOpType", this.t);
        jSONObject.put("otherPushTokenType", this.u);
        jSONObject.put("otherPushToken", this.v);
        jSONObject.put("otherPushTokenCrc32", this.w);
        jSONObject.put("tokenCrc32", this.x);
        jSONObject.put("otherPushData", this.y);
        jSONObject.put("sdkVersion", this.z);
        if (!j.b(this.A) && !j.b(this.B)) {
            jSONObject.put("channelToken", this.A);
            jSONObject.put("channelType", this.B);
        }
        if (!j.b(this.C)) {
            jSONObject.put("appPkgName", this.C);
        }
        jSONObject.put("tAd", this.D);
        g gVar = this.E;
        if (gVar != null && gVar.a()) {
            jSONObject.put("freeVersionInfo", this.E.b());
        }
        jSONObject.put("hwSdk", this.F);
        jSONObject.put("cloudVersion", this.G);
        try {
            String jSONObject2 = jSONObject.toString();
            String str = jSONObject2.substring(0, jSONObject2.indexOf("bootTime")) + jSONObject2.substring(jSONObject2.indexOf("countryCode"));
            if (Md5.md5(str).equals(SharePrefsUtil.getString(context, "REGISTERED_REQ", ""))) {
                this.H = false;
            } else {
                this.H = true;
                SharePrefsUtil.setString(context, "REGISTERED_REQ", Md5.md5(str));
            }
        } catch (Throwable unused) {
            this.H = true;
        }
        jSONObject.put("timestamp", this.q);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.REGISTER;
    }
}
