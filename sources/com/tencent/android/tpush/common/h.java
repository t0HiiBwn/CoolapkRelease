package com.tencent.android.tpush.common;

import android.content.Context;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.b;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class h {
    private static h a;
    private Context b = null;
    private String c = null;
    private String d = null;

    private h(Context context) {
        this.b = context.getApplicationContext();
        this.c = b.a(context);
        this.d = "1.2.3.1";
    }

    public static synchronized h a(Context context) {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                a = new h(context);
            }
            hVar = a;
        }
        return hVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x009c A[Catch:{ all -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c9 A[Catch:{ all -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d0 A[ADDED_TO_REGION, Catch:{ all -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f4 A[Catch:{ all -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010a A[Catch:{ all -> 0x0120 }] */
    public String a() {
        boolean z;
        int i;
        int i2;
        long j;
        JSONObject jSONObject = new JSONObject();
        try {
            CommonHelper.jsonPut(jSONObject, "appVer", this.c);
            CommonHelper.jsonPut(jSONObject, "appSdkVer", this.d);
            CommonHelper.jsonPut(jSONObject, "ch", XGPushConfig.getInstallChannel(this.b));
            CommonHelper.jsonPut(jSONObject, "gs", XGPushConfig.getGameServer(this.b));
            if (XGPushConfig.isUsedOtherPush(this.b) && d.a(this.b).j()) {
                String i3 = d.a(this.b).i();
                String f = d.a(this.b).f();
                TLogger.ii("RegisterReservedInfo", "Reservert info: other push token is : " + f + "  other push type: " + i3);
                if (!j.b(i3) && !j.b(f)) {
                    CommonHelper.jsonPut(jSONObject, i3, f);
                    i = d.a(this.b).e() == 4 ? 2 : 1;
                    z = true;
                    if (!z) {
                        TLogger.ii("RegisterReservedInfo", "Reservert info: use normal TPNS token register");
                        CommonHelper.jsonPut(jSONObject, "fcm", "");
                        CommonHelper.jsonPut(jSONObject, "miid", "");
                    }
                    i2 = PushPreferences.getInt(this.b, ".firstregister", 1);
                    int i4 = PushPreferences.getInt(this.b, ".usertype", 0);
                    j = PushPreferences.getLong(this.b, ".installtime", 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (j != 0) {
                        PushPreferences.putLong(this.b, ".installtime", currentTimeMillis);
                        j = currentTimeMillis;
                    } else if (i4 == 0 && i2 != 1 && !j.a(j).equals(j.a(System.currentTimeMillis()))) {
                        PushPreferences.putInt(this.b, ".usertype", 1);
                        i4 = 1;
                    }
                    jSONObject.put("ut", i4);
                    if (i2 == 1) {
                        jSONObject.put("freg", 1);
                    }
                    jSONObject.put("it", (int) (j / 1000));
                    if (j.b(this.b)) {
                        jSONObject.put("aidl", 1);
                    }
                    jSONObject.put("nf_st", b.b(this.b));
                    jSONObject.put("push_type", i);
                    return jSONObject.toString();
                }
            }
            i = 0;
            z = false;
            if (!z) {
            }
            i2 = PushPreferences.getInt(this.b, ".firstregister", 1);
            int i4 = PushPreferences.getInt(this.b, ".usertype", 0);
            j = PushPreferences.getLong(this.b, ".installtime", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (j != 0) {
            }
            jSONObject.put("ut", i4);
            if (i2 == 1) {
            }
            jSONObject.put("it", (int) (j / 1000));
            if (j.b(this.b)) {
            }
            jSONObject.put("nf_st", b.b(this.b));
            jSONObject.put("push_type", i);
        } catch (Throwable th) {
            TLogger.e("RegisterReservedInfo", "toSting", th);
        }
        return jSONObject.toString();
    }
}
