package com.tencent.beacon.cover;

import android.content.Context;
import java.net.HttpURLConnection;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: QualityCollect */
public final class e {
    private static e b = null;
    private static String c = "qua_info";
    private Context a;
    private JSONArray d = null;
    private String e = null;

    private e(Context context) {
        if (context == null) {
            g.a("W", "context is null!", new Object[0]);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.e = g.f(applicationContext);
        this.d = new JSONArray();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                b = new e(context);
            }
            eVar = b;
        }
        return eVar;
    }

    protected final void a(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("res", false);
            jSONObject.put("msg", str.replace('\n', ' ').replace('\r', ' '));
            str2 = jSONObject.toString();
        } catch (JSONException unused) {
            str2 = null;
        }
        if (str2 != null) {
            try {
                String b2 = g.b(this.a, c, "");
                if (!"".equals(b2)) {
                    Context context = this.a;
                    String str3 = c;
                    g.a(context, str3, b2 + "," + str2);
                    return;
                }
                g.a(this.a, c, str2);
            } catch (Exception unused2) {
            }
        }
    }

    protected final void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("res", false);
            jSONObject.put("msg", str.replace('\n', ' ').replace('\r', ' '));
            this.d.put(jSONObject);
        } catch (Exception unused) {
        }
    }

    protected final void a(boolean z) {
        String b2 = b(z);
        String a2 = g.a(this.a, this.e);
        int i = 0;
        try {
            byte[] a3 = g.a(true, this.e, b2.getBytes("utf-8"));
            if (a3 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                hashMap.put("Content-Length", String.valueOf(a3.length));
                hashMap.put("encr_type", "rsapost");
                hashMap.put("rsa_encr_key", a2);
                hashMap.put("qua_log", "1");
                while (true) {
                    int i2 = i + 1;
                    if (i < 3) {
                        HttpURLConnection a4 = i.a("http://oth.update.mdt.qq.com:8080/beacon/vercheck", hashMap);
                        if (a4 == null || i.a(a4, a3) == null) {
                            g.a(10000);
                            i = i2;
                        } else {
                            g.a(this.a, c, "");
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception unused) {
            g.a("E", "Encry post data error!", new Object[0]);
        }
    }

    private String b(boolean z) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", g.b(this.a));
            jSONObject.put("appversion", g.c(this.a));
            jSONObject.put("model", g.a());
            jSONObject.put("aid", g.d(this.a));
            jSONObject.put("cpuabi", g.b());
            jSONObject.put("coverSDKver", "1.0.0");
            String jSONObject2 = jSONObject.toString();
            String b2 = g.b(this.a, c, "");
            if ("".equals(b2)) {
                str = jSONObject2 + "|";
            } else {
                str = jSONObject2 + "|[" + b2 + "]";
            }
            if (z) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("compsDownRes", false);
                jSONObject3.put("compsDownErr", this.d);
                return str + "|" + jSONObject3.toString();
            }
            return str + "|";
        } catch (Exception unused) {
            return "";
        }
    }
}
