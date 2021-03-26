package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class f extends c {
    public String a = null;
    public String b = null;
    public int m;
    public String n;
    public long o = 0;
    public String p;
    public byte q;
    public String r;

    @Override // com.tencent.android.tpush.stat.event.c
    public boolean a(JSONObject jSONObject) {
        return true;
    }

    public f(Context context, int i, String str) {
        super(context, XGApiConfig.getAccessKey(context), XGApiConfig.getAccessId(context));
        this.c = XGApiConfig.getAccessKey(context);
        this.d = XGApiConfig.getAccessId(context);
        this.a = GuidInfoManager.getToken(context.getApplicationContext());
        this.b = "1.2.3.1";
        this.m = i;
        this.p = str;
        this.q = DeviceInfos.getNetworkType(context);
        this.r = DeviceInfos.getDeviceModel(context);
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public EventType a() {
        return EventType.ERRCODE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            f fVar = (f) obj;
            try {
                if (this.d != fVar.d || this.e != fVar.e || !this.a.equals(fVar.a) || !this.b.equals(fVar.b) || this.m != fVar.m || !this.n.equals(fVar.n) || this.o != fVar.o || !this.p.equals(fVar.p) || this.q != fVar.q || !this.r.equals(fVar.r)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                TLogger.d("RspErrcodeEvent equals Error:", th.getMessage());
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public String toString() {
        return b();
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accessId", this.d);
            jSONObject.put("timestamp", this.e);
            String str = this.a;
            if (str != null) {
                jSONObject.put("token", str);
            }
            if (this.c != null) {
                jSONObject.put("accessKey", this.c);
            }
            String str2 = this.b;
            if (str2 != null) {
                jSONObject.put("sdkVersion", str2);
            }
            jSONObject.put("et", a().GetIntValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errCode", this.m);
            String str3 = this.n;
            if (str3 != null) {
                jSONObject2.put("msg", str3);
            }
            long j = this.o;
            if (0 != j) {
                jSONObject2.put("id", j);
            }
            jSONObject.put("errCode", jSONObject2);
            String str4 = this.p;
            if (str4 != null) {
                jSONObject.put("errType", str4);
            }
            jSONObject.put("networkType", (int) this.q);
            String str5 = this.r;
            if (str5 != null) {
                jSONObject.put("deviceModel", str5);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.e("RspErrcodeEvent toJson Error:", th.getMessage());
            return null;
        }
    }
}
