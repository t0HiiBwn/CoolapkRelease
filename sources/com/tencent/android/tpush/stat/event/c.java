package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.a.a;
import com.tencent.android.tpush.stat.a.d;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class c {
    public static String g = "xgsdk";
    protected static String i;
    protected static long j;
    protected String c = null;
    protected long d = 0;
    protected long e;
    protected int f;
    protected String h = null;
    protected long k = 0;
    protected Context l;

    public abstract EventType a();

    public abstract boolean a(JSONObject jSONObject);

    public c(Context context, int i2, long j2) {
        this.c = "Axg" + j2;
        a(context, i2, j2);
    }

    public c(Context context, String str, long j2) {
        this.c = str;
        a(context, 0, j2);
    }

    public c(Context context) {
        a(context, 0, 0);
    }

    private void a(Context context, int i2, long j2) {
        this.l = context;
        this.d = j2;
        this.e = System.currentTimeMillis() / 1000;
        this.f = i2;
        this.h = a.b(context, j2);
        String str = i;
        if (str == null || str.trim().length() < 40) {
            String token = XGPushConfig.getToken(context);
            i = token;
            if (!a.b(token)) {
                i = "0";
            }
        }
        if (j == 0) {
            j = CacheManager.getGuid(d());
        }
    }

    public Context d() {
        return this.l;
    }

    public boolean b(JSONObject jSONObject) {
        try {
            d.a(jSONObject, "ky", this.c);
            EventType a = a();
            if (a != null) {
                jSONObject.put("et", a.GetIntValue());
            }
            jSONObject.put("ui", d.a(this.l));
            d.a(jSONObject, "mc", CustomDeviceInfos.getFacilityMacAddr(this.l));
            jSONObject.put("ut", 1);
            if (a() != EventType.SESSION_ENV) {
                d.a(jSONObject, "av", this.h);
                d.a(jSONObject, "ch", g);
            }
            d.a(jSONObject, "mid", i);
            jSONObject.put("si", this.f);
            if (a() == EventType.CUSTOM) {
                jSONObject.put("cts", this.e);
                long j2 = this.k;
                if (j2 == 0) {
                    long j3 = this.e;
                    if (j3 != 0) {
                        jSONObject.put("ts", j3);
                    }
                }
                jSONObject.put("ts", j2);
            } else {
                jSONObject.put("ts", this.e);
            }
            if ("0".equals(a.a(this.l, this.d))) {
                jSONObject.put("sv", a.a(this.l));
            } else {
                jSONObject.put("sv", a.a(this.l, this.d));
            }
            jSONObject.put("guid", j);
            jSONObject.put("dts", a.a(this.l, false));
            return a(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    public String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return b();
    }
}
