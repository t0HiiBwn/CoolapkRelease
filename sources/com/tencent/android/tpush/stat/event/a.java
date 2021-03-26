package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.os.Build;
import com.tencent.android.tpush.common.b;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a extends c {
    public String a;
    public long b = 0;
    private String m = null;
    private String n = null;
    private String o = null;
    private long p = 0;
    private int q = 0;

    @Override // com.tencent.android.tpush.stat.event.c
    public EventType a() {
        return null;
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public boolean a(JSONObject jSONObject) {
        return true;
    }

    public a(Context context, long j, int i) {
        super(context, XGApiConfig.getAccessKey(context), XGApiConfig.getAccessId(context));
        this.c = XGApiConfig.getAccessKey(context);
        this.d = XGApiConfig.getAccessId(context);
        this.m = GuidInfoManager.getToken(context.getApplicationContext());
        this.n = "1.2.3.1";
        this.o = b.a(context);
        this.p = j;
        this.q = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            try {
                if (this.d != aVar.d || this.e != aVar.e || !this.m.equals(aVar.m) || !this.n.equals(aVar.n) || !this.a.equals(aVar.a) || this.b != aVar.b) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                TLogger.d("CloudEvent equals Error:", th.getMessage());
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
            String str = this.m;
            if (str != null) {
                jSONObject.put("token", str);
            }
            if (this.c != null) {
                jSONObject.put("accessKey", this.c);
            }
            String str2 = this.n;
            if (str2 != null) {
                jSONObject.put("sdkVersion", str2);
            }
            String str3 = this.o;
            if (str3 != null) {
                jSONObject.put("appVersion", str3);
            }
            jSONObject.put("et", 4);
            jSONObject.put("sdkVersionName", Build.VERSION.RELEASE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cloudVersion", this.p);
            jSONObject2.put("cloudControlRet", this.q);
            jSONObject.put("cloudMsg", jSONObject2);
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.e("CloudEvent toJson Error:", th.getMessage());
            return null;
        }
    }
}
