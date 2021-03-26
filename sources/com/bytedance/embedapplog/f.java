package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

public class f implements Application.ActivityLifecycleCallbacks {
    private static int a = 0;
    private static ay b = null;
    private static ay c = null;
    private static long d = 0;
    private static String e = null;
    private static long f = 0;
    private static String g = null;
    private static int h = -1;
    private static Object i;
    private static Object j;

    /* renamed from: l  reason: collision with root package name */
    private static final HashSet<Integer> f1262l = new HashSet<>(8);
    private final IPicker k;

    public static void b(Object obj) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public f(IPicker iPicker) {
        this.k = iPicker;
    }

    public static Activity a() {
        return (Activity) i;
    }

    private static ay c() {
        ay ayVar = b;
        ay ayVar2 = c;
        if (ayVar2 != null) {
            return ayVar2;
        }
        if (ayVar != null) {
            return ayVar;
        }
        return null;
    }

    public static String b() {
        ay c2 = c();
        return c2 != null ? c2.j : "";
    }

    public static void a(Object obj) {
        obj.getClass().getName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        ay a2 = a(activity.getClass().getName(), "", System.currentTimeMillis(), e);
        b = a2;
        a2.k = !f1262l.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (!activity.isChild()) {
            try {
                h = activity.getWindow().getDecorView().hashCode();
                i = activity;
            } catch (Exception e2) {
                bo.a(e2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (c != null) {
            b(j);
        }
        ay ayVar = b;
        if (ayVar != null) {
            e = ayVar.j;
            long currentTimeMillis = System.currentTimeMillis();
            d = currentTimeMillis;
            a(b, currentTimeMillis);
            b = null;
            if (!activity.isChild()) {
                h = -1;
                i = null;
            }
        }
    }

    public static ay a(String str, String str2, long j2, String str3) {
        ay ayVar = new ay();
        if (!TextUtils.isEmpty(str2)) {
            ayVar.j = str + ":" + str2;
        } else {
            ayVar.j = str;
        }
        ayVar.a = j2;
        ayVar.h = -1;
        if (str3 == null) {
            str3 = "";
        }
        ayVar.i = str3;
        k.a(ayVar);
        return ayVar;
    }

    public static ay a(ay ayVar, long j2) {
        ay ayVar2 = (ay) ayVar.clone();
        ayVar2.a = j2;
        long j3 = j2 - ayVar.a;
        if (j3 >= 0) {
            ayVar2.h = j3;
        } else {
            bo.a(null);
        }
        k.a(ayVar2);
        return ayVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        IPicker iPicker;
        int i2 = a + 1;
        a = i2;
        if (i2 == 1 && (iPicker = this.k) != null) {
            iPicker.show(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (e != null) {
            int i2 = a - 1;
            a = i2;
            if (i2 <= 0) {
                e = null;
                g = null;
                f = 0;
                d = 0;
                IPicker iPicker = this.k;
                if (iPicker != null) {
                    iPicker.show(false);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        f1262l.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        f1262l.add(Integer.valueOf(activity.hashCode()));
    }
}
