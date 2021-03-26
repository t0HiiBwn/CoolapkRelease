package com.pgl.sys.a;

import android.content.Context;
import android.util.Base64;
import com.pgl.a.b.d;
import org.json.JSONObject;

public class a {
    static int a = 504;
    static boolean b = false;
    static String c = "";
    static String d = "";
    private static long e;
    private static Context f;

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "Android");
            jSONObject.put("version", "1.0.5");
            String str = d;
            if (str == null || str.length() <= 0) {
                try {
                    jSONObject.put("token_id", com.pgl.sys.ces.a.meta(303, f, null));
                } catch (Throwable unused) {
                    jSONObject.put("token_id", "");
                }
            } else {
                jSONObject.put("token_id", d);
            }
            jSONObject.put("code", a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable unused2) {
            d.a("Call onEvent Error");
            return "";
        }
    }

    public static void a(Context context, String str, com.pgl.sys.a.a.a aVar) {
        if (f == null) {
            f = context;
        }
        int i = a;
        if (i != 102 && i != 202 && i != 200) {
            e = System.currentTimeMillis();
            b = false;
            c = str;
            a = 102;
            Thread thread = new Thread(new b(context, aVar));
            thread.setName("CZL-3");
            thread.start();
        }
    }
}
