package com.tencent.beacon.core.event;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.tencent.beacon.core.a.a;
import com.tencent.beacon.core.a.e;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.d;
import com.tencent.beacon.core.d.g;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: UserActionInternal */
public final class o {
    public static Context a = null;
    public static List<c> b = new ArrayList();
    private static String c = "";

    public static void a(Context context, boolean z) {
        a(context, z, 0);
    }

    public static void a(Context context, boolean z, long j) {
        a(context, z, j, (InitHandleListener) null, (UploadHandleListener) null);
    }

    public static void a(Context context, boolean z, final long j, final InitHandleListener initHandleListener, UploadHandleListener uploadHandleListener) {
        if (a != null) {
            b.d("[core] SDK is already initialized.", new Object[0]);
        } else if (context == null) {
            b.c("[core] context is null! init failed!", new Object[0]);
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                a = applicationContext;
            } else {
                a = context;
            }
            if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 14) {
                ((Application) a).registerActivityLifecycleCallbacks(new e());
            } else {
                com.tencent.beacon.core.a.b.a().a(new a(a));
            }
            i.a(a).a(z);
            if (uploadHandleListener != null) {
                i.a(a).a(uploadHandleListener);
            }
            com.tencent.beacon.core.a.b.a().a(new Runnable() {
                /* class com.tencent.beacon.core.event.o.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    o.b.add(UserEventModule.getInstance(o.a));
                    o.b.add(TunnelModule.getInstance(o.a));
                    for (String str : com.tencent.beacon.core.b.a) {
                        try {
                            c cVar = (c) d.a(str, "getInstance", new Class[]{Context.class}, new Object[]{o.a});
                            if (cVar != null) {
                                b.a("[core] %s module load successfully.", str);
                                o.b.add(cVar);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    StrategyQueryModule.getInstance(o.a).setInitHandleListener(initHandleListener);
                    o.b.add(StrategyQueryModule.getInstance(o.a));
                    for (c cVar2 : o.b) {
                        cVar2.onSDKInit(o.a);
                    }
                    long j = j;
                    if (j > 0) {
                        if (j > 10000) {
                            j = 10000;
                        }
                        com.tencent.beacon.core.strategy.c.a(j);
                    }
                }
            });
        }
    }

    public static void a(boolean z) {
        UserEventModule instance = UserEventModule.getInstance();
        if (instance != null) {
            instance.setUploadMode(z);
        } else {
            b.c("[core] UserEventModule is null, init sdk first!", new Object[0]);
        }
        TunnelModule instance2 = TunnelModule.getInstance();
        if (instance2 != null) {
            instance2.setUploadMode(z);
        }
    }

    public static void a(String str) {
        if (!g.a(str)) {
            com.tencent.beacon.core.b.b.b = str;
        }
    }

    public static void a(String str, String str2) {
        b.a("[core] setUserID:" + str2, new Object[0]);
        TunnelModule.setUserId(str, str2);
    }

    public static String b(String str) {
        return TunnelModule.getUserId(str);
    }

    public static void c(String str) {
        if (str != null) {
            try {
                if (Long.parseLong(str) > 10000) {
                    c = str;
                }
            } catch (Exception unused) {
                b.c("[core] set qq is not available !", new Object[0]);
            }
        } else {
            b.c("[core] set qq is null !", new Object[0]);
        }
    }

    public static String a() {
        return c;
    }

    public static void a(Map<String, String> map) {
        TunnelModule.setAdditionalInfo(null, map);
    }

    public static void a(String str, Map<String, String> map) {
        TunnelModule.setAdditionalInfo(str, map);
    }

    public static Map<String, String> d(String str) {
        return TunnelModule.getAdditionalInfo(str);
    }

    public static void e(String str) {
        if (!g.a(str)) {
            com.tencent.beacon.core.b.b.a = str;
            TunnelModule instance = TunnelModule.getInstance();
            if (instance != null) {
                instance.setAppKey(str);
            }
        }
    }

    public static void f(String str) {
        if (!g.a(str)) {
            com.tencent.beacon.core.b.b.c = com.tencent.beacon.core.d.a.a(str);
        }
    }

    public static void b() {
        com.tencent.beacon.core.a.b.a().a(new Runnable() {
            /* class com.tencent.beacon.core.event.o.AnonymousClass2 */

            @Override // java.lang.Runnable
            public final void run() {
                b.b("[core] db events to up on app call", new Object[0]);
                try {
                    TunnelModule.doUploadAllEventsData();
                } catch (Throwable th) {
                    b.a(th);
                }
            }
        });
    }

    public static void b(boolean z) {
        TunnelModule.flushObjectsToDB(z);
    }

    public static String g(String str) {
        Map<String, String> d;
        if (a == null || (d = com.tencent.beacon.core.strategy.a.a().d()) == null) {
            return null;
        }
        return d.get(str);
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        return a(str, z, j, j2, map, z2, false);
    }

    public static boolean a(String str, Map<String, String> map, boolean z, boolean z2) {
        return a(str, true, -1, -1, map, z, z2);
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        return TunnelModule.onUserAction(null, str, z, j, j2, map, z2, z3);
    }

    public static boolean a(String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        return TunnelModule.onUserAction(str, str2, z, j, j2, map, z2, z3);
    }

    public static boolean a(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        return a(str, str2, true, -1, -1, map, z, z2);
    }

    public static void c(boolean z) {
        com.tencent.beacon.core.a.a = z;
    }

    public static void a(boolean z, boolean z2) {
        b.a = z;
        b.b = z2;
        b.c = z & z2;
    }

    public static String c() {
        Context context = a;
        if (context != null) {
            return com.tencent.beacon.core.b.d.a(context).f();
        }
        b.d("[core] init sdk first!", new Object[0]);
        return "";
    }

    public static void b(String str, String str2) {
        com.tencent.beacon.core.strategy.a.a().a(str, str2);
    }

    public static void h(String str) {
        com.tencent.beacon.core.b.b.a(a).d(str);
    }

    public static boolean a(boolean z, long j, Map<String, String> map) {
        Context context = a;
        if (context != null) {
            com.tencent.beacon.core.b.e.a(context);
            map.put("A33", com.tencent.beacon.core.b.e.j(a));
        }
        return a("rqd_wgLogin", z, j, 0, map, true);
    }

    @Deprecated
    public static void i(String str) {
        a(str);
    }

    public static String d() {
        return com.tencent.beacon.core.b.b.a(a).c();
    }

    @Deprecated
    public static void j(String str) {
        e(str);
    }

    public static void k(String str) {
        f.a(com.tencent.beacon.core.d.a.c(str));
    }

    public static void l(String str) {
        f.b(com.tencent.beacon.core.d.a.c(str));
    }

    public static void a(TunnelInfo tunnelInfo) {
        TunnelModule.registerTunnel(tunnelInfo);
    }

    public static void a(Context context) {
        a(context, true, 0L);
    }
}
