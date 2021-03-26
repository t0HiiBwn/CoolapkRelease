package com.tencent.android.tpush.stat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.a.a;
import com.tencent.android.tpush.stat.a.b;
import com.tencent.android.tpush.stat.a.c;
import com.tencent.android.tpush.stat.event.b;
import com.tencent.android.tpush.stat.event.d;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class e {
    static volatile long a = 0;
    public static volatile boolean b = true;
    private static Map<String, Long> c = new ConcurrentHashMap();
    private static volatile Handler d = null;
    private static volatile int e = 0;
    private static volatile String f = "";
    private static volatile String g = "";
    private static b h = a.b();
    private static volatile boolean i = false;
    private static volatile boolean j = true;
    private static Handler k = null;
    private static volatile Runnable l = null;
    private static long m = 0;
    private static List<Object> n = new CopyOnWriteArrayList();
    private static long o = 800;
    private static volatile long p = -1;
    private static Context q = null;
    private static String r = null;
    private static volatile SharedPreferences s = null;
    private static volatile SharedPreferences t = null;
    private static volatile SharedPreferences u = null;
    private static AtomicInteger v = new AtomicInteger(0);
    private static final Integer w = 3;

    public static Context a(Context context) {
        return context != null ? context : q;
    }

    public static void b(Context context) {
        if (context != null) {
            q = context.getApplicationContext();
        }
    }

    static boolean c(Context context) {
        boolean z;
        long a2 = c.a(context, b.c, 0L);
        long a3 = a.a("2.0.6");
        if (a3 <= a2) {
            b bVar = h;
            bVar.e("MTA is disable for current version:" + a3 + ",wakeup version:" + a2);
            z = false;
        } else {
            z = true;
        }
        b.b(z);
        return z;
    }

    static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static synchronized void d(Context context) {
        synchronized (e.class) {
            if (context != null) {
                f(context);
                if (d == null) {
                    if (c(context)) {
                        final Context applicationContext = context.getApplicationContext();
                        q = applicationContext;
                        HandlerThread handlerThread = new HandlerThread("XgStat");
                        handlerThread.start();
                        d = new Handler(handlerThread.getLooper());
                        d.post(new Runnable() {
                            /* class com.tencent.android.tpush.stat.e.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                a.a(e.q).c();
                                a.a(applicationContext, true);
                                d.b(applicationContext);
                                if (b.a() == StatReportStrategy.APP_LAUNCH) {
                                    e.b(applicationContext, -1);
                                }
                                if (b.b()) {
                                    e.h.h("Init MTA StatService success.");
                                }
                                String d = a.d(e.q);
                                if (d == null || d.trim().length() == 0) {
                                    d = "default";
                                }
                                String str = d + ".xg.stat.";
                                SharedPreferences unused = e.s = applicationContext.getSharedPreferences("." + str, 0);
                                SharedPreferences unused2 = e.t = applicationContext.getSharedPreferences("." + str + ".err.", 0);
                                SharedPreferences unused3 = e.u = applicationContext.getSharedPreferences("." + str + ".custom.", 0);
                            }
                        });
                    }
                }
            }
        }
    }

    public static Handler e(Context context) {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    try {
                        d(context);
                    } catch (Throwable th) {
                        h.a(th);
                        b.b(false);
                    }
                }
            }
        }
        return d;
    }

    public static void a(Context context, final com.tencent.android.tpush.stat.event.c cVar) {
        if (!b.c()) {
            TLogger.w("stat", "disable stat service");
            return;
        }
        Context a2 = a(context);
        if (a2 == null) {
            h.e("The Context of StatService.trackCustomEvent() can not be null!");
        } else if (e(a2) != null) {
            d.post(new Runnable() {
                /* class com.tencent.android.tpush.stat.e.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.a(cVar);
                    } catch (Throwable th) {
                        e.h.b(th);
                    }
                }
            });
        }
    }

    public static void a(Context context, final int i2) {
        if (b.c()) {
            final Context a2 = a(context);
            if (a2 == null) {
                h.e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (e(a2) != null) {
                d.post(new Runnable() {
                    /* class com.tencent.android.tpush.stat.e.AnonymousClass5 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            e.a(new d(a2, i2));
                        } catch (Throwable th) {
                            e.h.b(th);
                        }
                    }
                });
            }
        }
    }

    public static void a(Context context, final String str, Properties properties) {
        if (b.c()) {
            final Context a2 = a(context);
            if (a2 == null) {
                h.e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (a(str)) {
                h.e("The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                final b.a aVar = new b.a(str, null, properties);
                if (e(a2) != null) {
                    d.post(new Runnable() {
                        /* class com.tencent.android.tpush.stat.e.AnonymousClass6 */

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.tencent.android.tpush.stat.event.b bVar = new com.tencent.android.tpush.stat.event.b(a2, 0, str, XGApiConfig.getAccessId(a2), System.currentTimeMillis());
                                bVar.c().c = aVar.c;
                                e.a(bVar);
                            } catch (Throwable th) {
                                e.h.b(th);
                            }
                        }
                    });
                }
            }
        }
    }

    public static boolean b(Context context, int i2) {
        if (!b.c()) {
            return false;
        }
        if (b.b()) {
            com.tencent.android.tpush.stat.a.b bVar = h;
            bVar.b("commitEvents, maxNumber=" + i2);
        }
        Context a2 = a(context);
        if (a2 == null) {
            h.e("The Context of StatService.commitEvents() can not be null!");
            return false;
        } else if (i2 < -1 || i2 == 0) {
            h.e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            return false;
        } else if (!a.a(a2).a() || e(a2) == null) {
            return false;
        } else {
            d.post(new Runnable() {
                /* class com.tencent.android.tpush.stat.e.AnonymousClass7 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.a();
                    } catch (Throwable th) {
                        e.h.b(th);
                    }
                }
            });
            return true;
        }
    }

    public static boolean c(Context context, int i2) {
        if (!b.c()) {
            return false;
        }
        if (b.b()) {
            com.tencent.android.tpush.stat.a.b bVar = h;
            bVar.b("commitEvents, maxNumber=" + i2);
        }
        Context a2 = a(context);
        if (a2 == null) {
            h.e("The Context of StatService.commitEvents() can not be null!");
            return false;
        } else if (i2 < -1 || i2 == 0) {
            h.e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            return false;
        } else if (!a.a(a2).a()) {
            return false;
        } else {
            com.tencent.android.tpush.stat.a.b bVar2 = h;
            bVar2.b("sendLocalMsg, maxNumber=" + i2);
            if (e(a2) == null) {
                return false;
            }
            d.post(new Runnable() {
                /* class com.tencent.android.tpush.stat.e.AnonymousClass8 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.a();
                    } catch (Throwable th) {
                        e.h.b(th);
                    }
                }
            });
            return true;
        }
    }

    static void a(com.tencent.android.tpush.stat.event.c cVar) {
        if (a.a(q).a()) {
            if (b) {
                b = !c(q, 100);
            }
            b(cVar);
            return;
        }
        a(Arrays.asList(cVar));
    }

    static void b(final com.tencent.android.tpush.stat.event.c cVar) {
        d.b(q).a(cVar, new c() {
            /* class com.tencent.android.tpush.stat.e.AnonymousClass9 */

            @Override // com.tencent.android.tpush.stat.c
            public void a() {
                e.v.set(0);
            }

            @Override // com.tencent.android.tpush.stat.c
            public void b() {
                if (e.v.getAndIncrement() < e.w.intValue()) {
                    CommonWorkingThread.getInstance().execute(new Runnable() {
                        /* class com.tencent.android.tpush.stat.e.AnonymousClass9.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            e.b(cVar);
                        }
                    }, ((long) e.v.get()) * 1000);
                    return;
                }
                e.v.set(0);
                e.a(Arrays.asList(cVar));
            }
        });
    }

    private static void a(List<?> list, SharedPreferences sharedPreferences) {
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator<?> it2 = list.iterator();
            while (it2.hasNext()) {
                edit.putInt(it2.next().toString(), 1);
            }
            edit.commit();
        } catch (Throwable th) {
            h.b(th);
        }
    }

    private static void b(List<?> list, SharedPreferences sharedPreferences) {
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator<?> it2 = list.iterator();
            while (it2.hasNext()) {
                edit.remove(it2.next().toString());
            }
            edit.commit();
        } catch (Throwable th) {
            h.b(th);
        }
    }

    private static void a(SharedPreferences sharedPreferences, List<?> list) {
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                Iterator<?> it2 = list.iterator();
                while (it2.hasNext()) {
                    String obj = it2.next().toString();
                    int i2 = sharedPreferences.getInt(obj, 1);
                    if (i2 <= 0 || i2 > b.e()) {
                        edit.remove(obj);
                    } else {
                        edit.putInt(obj, i2 + 1);
                    }
                }
                edit.commit();
            } catch (Throwable th) {
                h.b(th);
            }
        }
    }

    static synchronized void a(List<?> list) {
        synchronized (e.class) {
            if (list != null) {
                try {
                    if (!(s == null || t == null || u == null)) {
                        b = true;
                        com.tencent.android.tpush.stat.a.b bVar = h;
                        bVar.h("store event size:" + list.size());
                        int e2 = e(list);
                        if (e2 == 1) {
                            a(list, s);
                        } else if (e2 != 2) {
                            a(list, t);
                        } else {
                            a(list, u);
                        }
                    }
                } catch (Throwable th) {
                    h.b(th);
                }
            }
        }
        return;
    }

    static synchronized void b(List<?> list) {
        synchronized (e.class) {
            if (list != null) {
                try {
                    if (!(s == null || t == null || u == null)) {
                        com.tencent.android.tpush.stat.a.b bVar = h;
                        bVar.h("delete event size:" + list.size());
                        int e2 = e(list);
                        if (e2 == 1) {
                            b(list, s);
                        } else if (e2 != 2) {
                            b(list, t);
                        } else {
                            b(list, u);
                        }
                    }
                } catch (Throwable th) {
                    h.b(th);
                }
            }
        }
        return;
    }

    static synchronized void c(List<?> list) {
        synchronized (e.class) {
            if (list != null) {
                try {
                    if (!(s == null || t == null || u == null)) {
                        com.tencent.android.tpush.stat.a.b bVar = h;
                        bVar.h("update event size:" + list.size());
                        int e2 = e(list);
                        if (e2 == 1) {
                            a(s, list);
                        } else if (e2 != 2) {
                            a(t, list);
                        } else {
                            a(u, list);
                        }
                    }
                } catch (Throwable th) {
                    h.b(th);
                }
            }
        }
        return;
    }

    static void d(final List<String> list) {
        if (list != null && list.size() != 0) {
            d.b(q).b(list, new c() {
                /* class com.tencent.android.tpush.stat.e.AnonymousClass2 */

                @Override // com.tencent.android.tpush.stat.c
                public void a() {
                    e.b(list);
                }

                @Override // com.tencent.android.tpush.stat.c
                public void b() {
                    e.c(list);
                }
            });
        }
    }

    private static int e(List<?> list) {
        if (list != null && !list.isEmpty()) {
            try {
                Object obj = list.get(0);
                if (!(obj instanceof com.tencent.android.tpush.stat.event.c)) {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    String optString = jSONObject.optString("msgId", "");
                    if (optString != null && optString.length() > 0) {
                        com.tencent.android.tpush.stat.a.b bVar = h;
                        bVar.d("a stat string event msgId: " + optString);
                        return 1;
                    } else if (jSONObject.has("customEvent")) {
                        h.d(" string customEvent");
                        return 2;
                    } else {
                        h.d("other string ");
                        return 0;
                    }
                } else if (obj instanceof com.tencent.android.tpush.stat.event.e) {
                    h.d("a stat instance MQTTEvent event");
                    return 1;
                } else if (obj instanceof com.tencent.android.tpush.stat.event.b) {
                    h.d("a stat instance custom event");
                    return 2;
                } else {
                    h.d("other instance ErrorEvent or other");
                    return 0;
                }
            } catch (Throwable th) {
                com.tencent.android.tpush.stat.a.b bVar2 = h;
                bVar2.d("distinguish event error" + th.toString());
            }
        }
        return 0;
    }

    static synchronized void a() {
        synchronized (e.class) {
            if (s != null) {
                a(s);
            }
            if (t != null) {
                a(t);
            }
            if (u != null) {
                a(u);
            }
        }
    }

    static void a(SharedPreferences sharedPreferences) {
        try {
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null) {
                com.tencent.android.tpush.stat.a.b bVar = h;
                bVar.a("sendLocalEvent " + all.size());
            }
            if (all != null && all.size() > 0) {
                ArrayList arrayList = new ArrayList(10);
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    arrayList.add(entry.getKey());
                    if (arrayList.size() == 10) {
                        d(arrayList);
                        arrayList.clear();
                    }
                }
                d(arrayList);
                arrayList.clear();
            }
        } catch (Throwable th) {
            com.tencent.android.tpush.stat.a.b bVar2 = h;
            bVar2.f("sendLocalEvent error: " + th.toString());
        }
    }

    public static void f(final Context context) {
        Application application;
        try {
            if (context instanceof Application) {
                application = (Application) context;
            } else if (context instanceof Activity) {
                application = ((Activity) context).getApplication();
            } else {
                application = (Application) context;
            }
            if (application != null) {
                final String p2 = j.p(context);
                com.tencent.android.tpush.stat.b.a.a(application, new com.tencent.android.tpush.stat.b.b() {
                    /* class com.tencent.android.tpush.stat.e.AnonymousClass3 */

                    @Override // com.tencent.android.tpush.stat.b.b
                    public void a(Activity activity) {
                    }

                    @Override // com.tencent.android.tpush.stat.b.b
                    public void b(Activity activity) {
                    }

                    @Override // com.tencent.android.tpush.stat.b.b
                    public void b(Activity activity, Bundle bundle) {
                    }

                    @Override // com.tencent.android.tpush.stat.b.b
                    public void c(Activity activity) {
                    }

                    @Override // com.tencent.android.tpush.stat.b.b
                    public void d(Activity activity) {
                    }

                    @Override // com.tencent.android.tpush.stat.b.b
                    public void e(Activity activity) {
                    }

                    @Override // com.tencent.android.tpush.stat.b.b
                    public void a(final Activity activity, Bundle bundle) {
                        try {
                            final String className = activity.getComponentName().getClassName();
                            if (p2.equals(className) && !j.b(GuidInfoManager.getToken(context.getApplicationContext()))) {
                                CommonWorkingThread.getInstance().execute(new Runnable() {
                                    /* class com.tencent.android.tpush.stat.e.AnonymousClass3.AnonymousClass1 */

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        TLogger.d("stat", "context," + context + ", mainClass:" + p2 + ", activityName:" + className);
                                        if (j.c(context, activity.getPackageName()) && PushPreferences.getBoolean(context, "app_first_launch", true)) {
                                            ServiceStat.reportCustomData4FirstLaunch(context);
                                            PushPreferences.putBoolean(context, "app_first_launch", false);
                                        }
                                    }
                                });
                                if (!CloudManager.getInstance(context).disableRepLanuEv()) {
                                    CommonWorkingThread.getInstance().execute(new Runnable() {
                                        /* class com.tencent.android.tpush.stat.e.AnonymousClass3.AnonymousClass2 */

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            ServiceStat.reportLaunchEvent(context, 4);
                                        }
                                    }, 2000);
                                }
                            }
                        } catch (Throwable th) {
                            TLogger.d("stat", "unexpected for onActivityCreated:" + th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable unused) {
            TLogger.d("stat", "unexpected for checkAppLunch");
        }
    }
}
