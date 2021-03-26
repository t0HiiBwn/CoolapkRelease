package com.tencent.android.tpush.stat.b;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

/* compiled from: ProGuard */
public class a {
    public static Boolean a(Application application, final b bVar) {
        if (!(application == null || bVar == null || Build.VERSION.SDK_INT < 14)) {
            try {
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                    /* class com.tencent.android.tpush.stat.b.a.AnonymousClass1 */

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        bVar.d(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        bVar.a(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        bVar.b(activity, bundle);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        bVar.b(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        bVar.c(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        bVar.e(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        bVar.a(activity, bundle);
                    }
                });
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
