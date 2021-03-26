package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class e extends c {
    public JSONObject A;
    public String B;
    public String C;
    public String a;
    public long b;
    public long m;
    public long n;
    public long o;
    public int p;
    public String q;
    public String r;
    public String s;
    public long t;
    public long u;
    public int v;
    public String w;
    public long x;
    public long y;
    public String z;

    @Override // com.tencent.android.tpush.stat.event.c
    public EventType a() {
        return null;
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public boolean a(JSONObject jSONObject) {
        return true;
    }

    public e(Context context, String str, long j) {
        super(context, str, j);
        this.a = null;
        this.b = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = null;
        this.x = 0;
        this.y = 0;
        this.z = null;
        this.A = null;
        this.B = "";
        this.C = "";
        this.a = str;
        this.b = j;
    }

    public e(Context context, long j) {
        this(context, XGApiConfig.getAccessKey(context), j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            e eVar = (e) obj;
            try {
                if (this.b == eVar.b && this.n == eVar.n && this.u == eVar.u && this.v == eVar.v && this.t == eVar.t && this.q.equals(eVar.q) && this.s.equals(eVar.s) && this.x == eVar.x && this.y == eVar.y) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                TLogger.d("MQTTEvent equals Error:", th.getMessage());
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
            jSONObject.put("accessId", this.b);
            jSONObject.put("pushAction", this.v);
            jSONObject.put("msgId", this.t);
            jSONObject.put("msgType", this.u);
            jSONObject.put("msgId", this.t);
            jSONObject.put("pushtime", this.o);
            jSONObject.put("timestamp", this.n);
            jSONObject.put("templateId", this.B);
            jSONObject.put("traceId", this.C);
            String str = this.s;
            if (str != null) {
                jSONObject.put("token", str);
            }
            String str2 = this.a;
            if (str2 != null) {
                jSONObject.put("accessKey", str2);
            }
            String str3 = this.q;
            if (str3 != null) {
                jSONObject.put("appVersion", str3);
            }
            String str4 = this.r;
            if (str4 != null) {
                jSONObject.put("sdkVersion", str4);
            }
            String str5 = this.w;
            if (str5 != null) {
                jSONObject.put("groupId", str5);
            }
            jSONObject.put("pushChannel", this.p);
            long j = this.x;
            if (j > 0) {
                jSONObject.put("targetType", j);
            }
            long j2 = this.y;
            if (j2 > 0) {
                jSONObject.put("source", j2);
            }
            String str6 = this.z;
            if (str6 != null && !TextUtils.isEmpty(str6)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventId", this.z);
                JSONObject jSONObject3 = this.A;
                if (!(jSONObject3 == null || jSONObject3.length() == 0)) {
                    jSONObject2.put("kv", this.A);
                }
                jSONObject.put("customEvent", jSONObject2);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.d("MQTTEvent toJsonString Error:", th.getMessage());
            return null;
        }
    }
}
