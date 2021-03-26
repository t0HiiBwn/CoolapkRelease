package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.stat.a.c;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class b {
    static a a = new a(2);
    static a b = new a(1);
    static String c = "__HIBERNATE__";
    private static com.tencent.android.tpush.stat.a.b d = com.tencent.android.tpush.stat.a.a.b();
    private static StatReportStrategy e = StatReportStrategy.APP_LAUNCH;
    private static boolean f = true;
    private static boolean g = true;
    private static boolean h = false;
    private static short i = 6;
    private static int j = 1024;
    private static int k = 30000;
    private static int l = 0;
    private static int m = 20;

    /* compiled from: ProGuard */
    static class a {
        int a;
        JSONObject b = new JSONObject();
        String c = "";
        int d = 0;

        a(int i) {
            this.a = i;
        }
    }

    public static StatReportStrategy a() {
        return e;
    }

    public static void a(StatReportStrategy statReportStrategy) {
        e = statReportStrategy;
        if (b()) {
            com.tencent.android.tpush.stat.a.b bVar = d;
            bVar.h("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static boolean b() {
        return f;
    }

    public static void a(boolean z) {
        f = z;
        com.tencent.android.tpush.stat.a.a.b().a(z);
    }

    public static boolean c() {
        Context context = XGPushManager.getContext();
        if (context == null) {
            if (XGVipPushService.a() == null) {
                return false;
            }
            context = XGVipPushService.a().getApplicationContext();
        }
        if (context == null) {
            return g;
        }
        if (!g || com.tencent.android.tpush.service.a.a.a(context.getApplicationContext()).B != 1) {
            return false;
        }
        return true;
    }

    public static void b(boolean z) {
        g = z;
        if (!z) {
            d.c("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    static void a(Context context, JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(b.a))) {
                    a(context, b, jSONObject.getJSONObject(next));
                } else if (next.equalsIgnoreCase(Integer.toString(a.a))) {
                    a(context, a, jSONObject.getJSONObject(next));
                }
            }
        } catch (JSONException e2) {
            d.b((Throwable) e2);
        }
    }

    static void a(Context context, a aVar, JSONObject jSONObject) {
        boolean z = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    int i2 = jSONObject.getInt(next);
                    if (aVar.d != i2) {
                        z = true;
                    }
                    aVar.d = i2;
                } else if (next.equalsIgnoreCase("c")) {
                    String string = jSONObject.getString("c");
                    if (string.length() > 0) {
                        aVar.b = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase("m")) {
                    aVar.c = jSONObject.getString("m");
                }
            }
            if (z && aVar.a == b.a) {
                a(aVar.b);
                b(aVar.b);
            }
            a(context, aVar);
        } catch (JSONException e2) {
            d.b((Throwable) e2);
        } catch (Throwable th) {
            d.b(th);
        }
    }

    static void a(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                a(statReportStrategy);
            }
        } catch (JSONException unused) {
            if (b()) {
                d.b("rs not found.");
            }
        }
    }

    static void a(Context context, a aVar) {
        if (aVar.a == b.a) {
            b = aVar;
            a(aVar.b);
        } else if (aVar.a == a.a) {
            a = aVar;
        }
    }

    static void b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                String string = jSONObject.getString(c);
                if (b()) {
                    com.tencent.android.tpush.stat.a.b bVar = d;
                    bVar.h("hibernateVer:" + string + ", current version:2.0.6");
                }
                long a2 = com.tencent.android.tpush.stat.a.a.a(string);
                if (com.tencent.android.tpush.stat.a.a.a("2.0.6") <= a2) {
                    a(a2);
                }
            } catch (JSONException unused) {
                d.h("__HIBERNATE__ not found.");
            }
        }
    }

    static void a(long j2) {
        c.b(d.a(), c, j2);
        b(false);
        d.c("MTA is disable for current SDK version");
    }

    public static boolean d() {
        return h;
    }

    public static void c(boolean z) {
        h = z;
    }

    public static short e() {
        return i;
    }
}
