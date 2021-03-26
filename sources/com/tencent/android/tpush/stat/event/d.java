package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.a.a;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class d extends c {
    private int a = 1;

    @Override // com.tencent.android.tpush.stat.event.c
    public boolean a(JSONObject jSONObject) {
        return true;
    }

    public d(Context context, int i) {
        super(context);
        this.a = i;
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public EventType a() {
        return EventType.LAUNCH;
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            EventType a2 = a();
            if (a2 != null) {
                jSONObject.put("et", a2.GetIntValue());
            }
            jSONObject.put("launchType", this.a);
            jSONObject.put("sdkVersion", "1.2.3.1");
            jSONObject.put("token", GuidInfoManager.getToken(this.l.getApplicationContext()));
            jSONObject.put("accessId", XGApiConfig.getAccessId(this.l));
            jSONObject.put("appkey", XGApiConfig.getAccessKey(this.l));
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject.put("idx", a.a());
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.e("LaunchEvent toJson Error:", th.getMessage());
            return "";
        }
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public String toString() {
        return b();
    }
}
