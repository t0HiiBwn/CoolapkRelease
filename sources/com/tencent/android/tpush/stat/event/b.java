package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class b extends c {
    protected a a;
    protected long b = -1;

    @Override // com.tencent.android.tpush.stat.event.c
    public boolean a(JSONObject jSONObject) {
        return true;
    }

    public b(Context context, int i, String str, long j, long j2) {
        super(context, i, j);
        a aVar = new a();
        this.a = aVar;
        aVar.a = str;
        this.k = j2;
    }

    /* compiled from: ProGuard */
    public static class a {
        public String a;
        public JSONArray b;
        public JSONObject c;
        public boolean d;

        public a(String str, String[] strArr, Properties properties) {
            this.c = null;
            this.d = false;
            this.a = str;
            if (properties != null) {
                this.c = new JSONObject(properties);
            } else if (strArr != null) {
                this.b = new JSONArray();
                for (String str2 : strArr) {
                    this.b.put(str2);
                }
            } else {
                this.c = new JSONObject();
            }
        }

        public a() {
            this.c = null;
            this.d = false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append(",");
            JSONArray jSONArray = this.b;
            if (jSONArray != null) {
                sb.append(jSONArray.toString());
            }
            JSONObject jSONObject = this.c;
            if (jSONObject != null) {
                sb.append(jSONObject.toString());
            }
            return sb.toString();
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return toString().equals(((a) obj).toString());
            }
            return false;
        }
    }

    public a c() {
        return this.a;
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public EventType a() {
        return EventType.CUSTOM;
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public String toString() {
        return b();
    }

    @Override // com.tencent.android.tpush.stat.event.c
    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("eventId", this.a.a);
            if (!(this.a.c == null || this.a.c.length() == 0)) {
                jSONObject2.put("kv", this.a.c);
            }
            jSONObject.put("customEvent", jSONObject2);
            EventType a2 = a();
            if (a2 != null) {
                jSONObject.put("et", a2.GetIntValue());
            }
            jSONObject.put("sdkVersion", "1.2.3.1");
            jSONObject.put("token", GuidInfoManager.getToken(this.l.getApplicationContext()));
            jSONObject.put("accessId", XGApiConfig.getAccessId(this.l));
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject.put("idx", com.tencent.android.tpush.stat.a.a.a());
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.e("CustomEvent toJson Error:", th.getMessage());
            return "";
        }
    }
}
