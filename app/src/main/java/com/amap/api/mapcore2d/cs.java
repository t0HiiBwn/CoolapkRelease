package com.amap.api.mapcore2d;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: AuthManager */
public class cs {
    public static int a = -1;
    public static String b = "";
    private static da c = null;
    private static String d = "http://apiinit.amap.com/v3/log/init";
    private static String e;

    private static boolean a(Context context, da daVar, boolean z) {
        c = daVar;
        try {
            String a2 = a();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", c.d());
            hashMap.put("X-INFO", ct.b(context));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", c.b(), c.a()));
            er a3 = er.a();
            dc dcVar = new dc();
            dcVar.a(cy.a(context));
            dcVar.a(hashMap);
            dcVar.b(a(context));
            dcVar.a(a2);
            return a(a3.b(dcVar));
        } catch (Throwable th) {
            dl.a(th, "Auth", "getAuth");
            return true;
        }
    }

    @Deprecated
    public static synchronized boolean a(Context context, da daVar) {
        boolean a2;
        synchronized (cs.class) {
            a2 = a(context, daVar, false);
        }
        return a2;
    }

    public static void a(String str) {
        cq.a(str);
    }

    private static String a() {
        return d;
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(db.a(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    a = 1;
                } else if (i == 0) {
                    a = 0;
                }
            }
            if (jSONObject.has("info")) {
                b = jSONObject.getString("info");
            }
            if (a == 0) {
                Log.i("AuthFailure", b);
            }
            return a == 1;
        } catch (JSONException e2) {
            dl.a(e2, "Auth", "lData");
            return false;
        } catch (Throwable th) {
            dl.a(th, "Auth", "lData");
            return false;
        }
    }

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", "UTF-8");
            String a2 = ct.a();
            hashMap.put("ts", a2);
            hashMap.put("key", cq.f(context));
            hashMap.put("scode", ct.a(context, a2, db.d("resType=json&encode=UTF-8&key=" + cq.f(context))));
        } catch (Throwable th) {
            dl.a(th, "Auth", "gParams");
        }
        return hashMap;
    }
}
