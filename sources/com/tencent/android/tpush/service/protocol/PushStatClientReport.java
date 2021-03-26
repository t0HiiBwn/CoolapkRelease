package com.tencent.android.tpush.service.protocol;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class PushStatClientReport {
    public long a;
    public long b;
    public String c;
    public String d;
    public long e;
    public long f;
    public EnumPushAction g;
    public long h;
    public String i;
    public long j;
    public String k;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msgId", this.a);
        jSONObject.put("accessId", this.b);
        jSONObject.put("accessKey", this.c);
        jSONObject.put("token", this.d);
        jSONObject.put("pushTime", this.e / 1000);
        jSONObject.put("timestamp", this.f / 1000);
        jSONObject.put("pushAction", this.g.getType());
        jSONObject.put("msgType", this.h);
        jSONObject.put("groupId", this.i);
        jSONObject.put("pushChannel", this.j);
        jSONObject.put("sdkVersion", this.k);
        return jSONObject;
    }

    /* compiled from: ProGuard */
    public enum EnumPushAction {
        PUSH_ACTION_MOBILE_SERVICE_RECEIVED(4),
        PUSH_ACTION_MOBILE_APP_RECEIVED(8),
        PUSH_ACTION_MOBILE_USER_CLICK(16),
        PUSH_ACTION_MOBILE_CLEAN_UP(32);
        
        private long type;

        private EnumPushAction(long j) {
            this.type = j;
        }

        public long getType() {
            return this.type;
        }
    }

    public String toString() {
        try {
            return a().toString();
        } catch (JSONException unused) {
            return "JSONException";
        }
    }
}
