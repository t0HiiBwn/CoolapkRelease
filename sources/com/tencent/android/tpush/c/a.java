package com.tencent.android.tpush.c;

import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a {
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = "0";
    private long e = 0;
    private int f = 0;
    private long g = 0;

    public void a(long j) {
        this.e = j;
    }

    public static a a(String str) {
        a aVar = new a();
        if (e.a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("imei")) {
                    aVar.c(jSONObject.getString("imei"));
                }
                if (!jSONObject.isNull("imsi")) {
                    aVar.d(jSONObject.getString("imsi"));
                }
                if (!jSONObject.isNull("mac")) {
                    aVar.e(jSONObject.getString("mac"));
                }
                if (!jSONObject.isNull("mid")) {
                    aVar.b(jSONObject.getString("mid"));
                }
                if (!jSONObject.isNull("ts")) {
                    aVar.a(jSONObject.getLong("ts"));
                }
                if (!jSONObject.isNull("ver")) {
                    aVar.f = jSONObject.optInt("ver", 0);
                }
                if (!jSONObject.isNull("guid")) {
                    aVar.g = jSONObject.optLong("guid", 0);
                }
            } catch (JSONException e2) {
                TLogger.w("MidEntity", "MidEntity parse error: " + e2.toString());
            }
        }
        return aVar;
    }

    public String toString() {
        return a().toString();
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            e.a(jSONObject, "imei", this.a);
            e.a(jSONObject, "imsi", this.b);
            e.a(jSONObject, "mac", this.c);
            e.a(jSONObject, "mid", this.d);
            try {
                jSONObject.put("guid", this.g);
            } catch (Throwable unused) {
            }
            jSONObject.put("ts", this.e);
        } catch (JSONException e2) {
            TLogger.w("MidEntity", "MidEntity encode error: " + e2.toString());
        }
        return jSONObject;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(String str) {
        this.b = str;
    }

    public void e(String str) {
        this.c = str;
    }
}
