package com.tencent.beacon.core.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.beacon.core.b.a;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.core.event.g;
import com.tencent.beacon.core.event.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LifecycleCallbacks */
public final class e implements Application.ActivityLifecycleCallbacks {
    private static SparseArray<WeakReference<Activity>> a = new SparseArray<>();
    private boolean b = false;
    private long c = 0;
    private long d = 0;
    private long e = 20000;
    private String f = "";
    private Map<String, String> g = null;

    public e() {
        HashMap hashMap = new HashMap(6);
        this.g = hashMap;
        hashMap.put("A63", "N");
        this.g.put("A66", "F");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        b(activity);
        a(true, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        b(activity);
        a(false, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        b(activity);
    }

    private void a(boolean z, Activity activity) {
        UserEventModule instance = UserEventModule.getInstance();
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.c > 0) {
                long j = this.d;
                if (j > 0 && j + a() <= currentTimeMillis) {
                    b.b("[lifecycle] -> return foreground more than 20s.", new Object[0]);
                    a(activity);
                    if (instance != null) {
                        instance.onAppResumed();
                    }
                }
            }
            this.c = currentTimeMillis;
            this.d = 0;
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        this.d = currentTimeMillis2;
        long j2 = this.c;
        if (800 + j2 > currentTimeMillis2) {
            b.b("[lifecycle] -> debounce activity switch.", new Object[0]);
            this.c = 0;
            return;
        }
        if (j2 == 0) {
            this.c = currentTimeMillis2;
        }
        if (instance != null) {
            instance.onAppStop();
        }
        TunnelModule.flushObjectsToDB(false);
    }

    private void a(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        com.tencent.beacon.core.b.e.a(applicationContext);
        this.g.put("A33", com.tencent.beacon.core.b.e.j(applicationContext));
        this.g.put("A85", a.a ? "Y" : "N");
        this.g.put("A20", com.tencent.beacon.core.b.e.g(applicationContext));
        this.g.put("A69", com.tencent.beacon.core.b.e.h(applicationContext));
        o.a("rqd_applaunched", true, 0, 0, this.g, true);
        b.a().a(new Runnable() {
            /* class com.tencent.beacon.core.a.e.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                TunnelModule.doUploadRecentCommonData(true);
            }
        });
    }

    private void b(final Activity activity) {
        boolean z = true;
        a.a = true;
        if (!(activity == null || a == null)) {
            int hashCode = activity.hashCode();
            if (a.get(hashCode) == null) {
                a.put(hashCode, new WeakReference<>(activity));
            }
        }
        boolean z2 = false;
        if (!this.b) {
            b.b("[event] lifecycle callback recover active user.", new Object[0]);
            b.a().a(new Runnable() {
                /* class com.tencent.beacon.core.a.e.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    new g(activity.getApplicationContext()).c();
                }
            });
            this.b = true;
        }
        String a2 = h.a();
        if ("".equals(this.f)) {
            this.f = c.a(activity).a("LAUEVE_DENGTA", "");
        }
        if (!a2.equals(this.f)) {
            c.a(activity).a().a("LAUEVE_DENGTA", (Object) a2).b();
            if (!"".equals(this.f)) {
                b.b("[core] -> report new day launcher event.", new Object[0]);
            } else {
                z = false;
            }
            this.f = a2;
            z2 = z;
        }
        if (z2) {
            a(activity);
        }
    }

    private long a() {
        if (this.e <= 20000) {
            String b2 = com.tencent.beacon.core.strategy.a.a().b("hotLauncher");
            if (b2 != null) {
                try {
                    this.e = Long.valueOf(b2).longValue();
                    b.b("[strategy] -> change launcher time: %s ms", b2);
                } catch (NumberFormatException unused) {
                    b.d("[strategy] -> event param 'hotLauncher' error.", new Object[0]);
                }
            }
            this.e++;
        }
        return this.e;
    }
}
