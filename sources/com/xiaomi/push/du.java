package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.b.a.b;
import com.xiaomi.b.a.c;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class du {
    private static a a;
    private static Map<String, gs> b;

    public interface a {
        void uploader(Context context, gm gmVar);
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof gi) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof gs) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof ea) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static b a(Context context, String str, String str2, int i, long j, String str3) {
        b a2 = a(str);
        a2.a = str2;
        a2.b = i;
        a2.c = j;
        a2.d = str3;
        return a2;
    }

    public static b a(String str) {
        b bVar = new b();
        bVar.e = 1000;
        bVar.g = 1001;
        bVar.f = str;
        return bVar;
    }

    public static c a() {
        c cVar = new c();
        cVar.e = 1000;
        cVar.g = 1000;
        cVar.f = "P100000";
        return cVar;
    }

    public static c a(Context context, int i, long j, long j2) {
        c a2 = a();
        a2.a = i;
        a2.b = j;
        a2.c = j2;
        return a2;
    }

    public static gm a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gm gmVar = new gm();
        gmVar.d("category_client_report_data");
        gmVar.a("push_sdk_channel");
        gmVar.a(1);
        gmVar.b(str);
        gmVar.c(true);
        gmVar.b(System.currentTimeMillis());
        gmVar.g(context.getPackageName());
        gmVar.e("com.xiaomi.xmsf");
        gmVar.f(ak.a());
        gmVar.c("quality_support");
        return gmVar;
    }

    public static String a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    public static void a(Context context, com.xiaomi.b.a.a aVar) {
        com.xiaomi.b.b.a.a(context, aVar, new dr(context), new ds(context));
    }

    private static void a(Context context, gm gmVar) {
        if (a(context.getApplicationContext())) {
            al.a(context.getApplicationContext(), gmVar);
            return;
        }
        a aVar = a;
        if (aVar != null) {
            aVar.uploader(context, gmVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list != null) {
            try {
                for (String str : list) {
                    gm a2 = a(context, str);
                    if (!ak.a(a2, false)) {
                        a(context, a2);
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.a.a.a.c.d(th.getMessage());
            }
        }
    }

    public static void a(a aVar) {
        a = aVar;
    }

    public static boolean a(Context context) {
        return context != null && !TextUtils.isEmpty(context.getPackageName()) && "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    public static int b(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static gs b(String str) {
        if (b == null) {
            synchronized (gs.class) {
                if (b == null) {
                    b = new HashMap();
                    gs[] values = gs.values();
                    for (gs gsVar : values) {
                        b.put(gsVar.S.toLowerCase(), gsVar);
                    }
                }
            }
        }
        gs gsVar2 = b.get(str.toLowerCase());
        return gsVar2 != null ? gsVar2 : gs.Invalid;
    }

    public static void b(Context context) {
        com.xiaomi.b.b.a.a(context, c(context));
    }

    public static com.xiaomi.b.a.a c(Context context) {
        boolean a2 = l.a(context).a(gn.PerfUploadSwitch.a(), false);
        boolean a3 = l.a(context).a(gn.EventUploadNewSwitch.a(), false);
        int a4 = l.a(context).a(gn.PerfUploadFrequency.a(), 86400);
        return com.xiaomi.b.a.a.a().b(a3).b((long) l.a(context).a(gn.EventUploadFrequency.a(), 86400)).c(a2).c((long) a4).a(context);
    }
}
