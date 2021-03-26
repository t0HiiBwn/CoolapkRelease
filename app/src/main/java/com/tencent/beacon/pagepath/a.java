package com.tencent.beacon.pagepath;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.beacon.core.a.b;
import com.tencent.beacon.core.event.o;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PageTimeLifeCallbacks */
public final class a implements Application.ActivityLifecycleCallbacks {
    private long a = System.currentTimeMillis();
    private Map<Activity, Long> b = new HashMap();
    private long c = 0;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.b.put(activity, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Long l2 = this.b.get(activity);
        if (l2 == null) {
            l2 = Long.valueOf(this.a);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final String localClassName = activity.getLocalClassName();
        final long longValue = currentTimeMillis - l2.longValue();
        b.a().a(new Runnable() {
            /* class com.tencent.beacon.pagepath.a.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("A110", String.valueOf(currentTimeMillis));
                hashMap.put("A111", localClassName);
                hashMap.put("A112", String.valueOf(longValue));
                o.a("rqd_page", true, 0, 0, hashMap, false);
                a.this.c += longValue;
                if (a.this.c >= 15000) {
                    a.this.c = 0;
                    o.b(false);
                }
            }
        });
        this.b.remove(activity);
    }
}
