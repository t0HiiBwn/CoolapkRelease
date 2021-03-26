package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.d;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ActivityLifecycleListener */
public class a implements Application.ActivityLifecycleCallbacks {
    private volatile AbstractC0066a a;
    private AtomicInteger b = new AtomicInteger(0);
    private AtomicBoolean c = new AtomicBoolean(false);
    private HashSet<Integer> d = new HashSet<>();

    /* renamed from: com.bytedance.sdk.openadsdk.utils.a$a  reason: collision with other inner class name */
    /* compiled from: ActivityLifecycleListener */
    public interface AbstractC0066a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.a != null) {
            this.a.d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.b.incrementAndGet() > 0) {
            this.c.set(false);
        }
        c();
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.d.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.a != null) {
            this.a.a();
        }
        com.bytedance.sdk.adnet.a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.b.decrementAndGet() == 0) {
            this.c.set(true);
        }
        if (this.a != null) {
            this.a.e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.d.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.a != null) {
            this.a.f();
        }
    }

    public boolean a() {
        return this.c.get();
    }

    public boolean a(Activity activity) {
        return activity != null && this.d.contains(Integer.valueOf(activity.hashCode()));
    }

    private void c() {
        long b2 = k.b();
        if (b2 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - b2;
            if (currentTimeMillis < 86400000 && currentTimeMillis > 0) {
                String c2 = k.c();
                String d2 = k.d();
                if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(d2)) {
                    d.a(currentTimeMillis, c2, d2);
                }
            }
        }
    }

    public void a(AbstractC0066a aVar) {
        this.a = aVar;
    }

    public void b() {
        if (this.a != null) {
            this.a = null;
        }
    }
}
