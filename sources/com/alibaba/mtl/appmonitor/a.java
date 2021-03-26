package com.alibaba.mtl.appmonitor;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.log.d.b;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.r;

/* compiled from: BackgroundTrigger */
class a implements Runnable {
    private static boolean j;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f1190l;
    private Application b;
    private boolean k = true;

    public static void init(Application application) {
        if (!j) {
            i.a("BackgroundTrigger", "init BackgroundTrigger");
            f1190l = a(application.getApplicationContext());
            a aVar = new a(application);
            if (f1190l) {
                r.a().a(4, aVar, 60000);
            } else if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new C0012a(aVar));
            }
            j = true;
        }
    }

    public a(Application application) {
        this.b = application;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        i.a("BackgroundTrigger", "[bg check]");
        boolean b2 = b.b(this.b.getApplicationContext());
        if (this.k != b2) {
            this.k = b2;
            if (b2) {
                j.a().j();
                f[] values = f.values();
                int length = values.length;
                while (i < length) {
                    f fVar = values[i];
                    AppMonitorDelegate.setStatisticsInterval(fVar, fVar.c());
                    i++;
                }
                com.alibaba.mtl.log.a.l();
            } else {
                f[] values2 = f.values();
                int length2 = values2.length;
                while (i < length2) {
                    f fVar2 = values2[i];
                    AppMonitorDelegate.setStatisticsInterval(fVar2, fVar2.d());
                    i++;
                }
                AppMonitorDelegate.triggerUpload();
                com.alibaba.mtl.log.a.k();
            }
        }
        if (f1190l) {
            r.a().a(4, this, 60000);
        }
    }

    /* renamed from: com.alibaba.mtl.appmonitor.a$a  reason: collision with other inner class name */
    /* compiled from: BackgroundTrigger */
    class C0012a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with other field name */
        private Runnable f40a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        C0012a(Runnable runnable) {
            this.f40a = runnable;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            r.a().f(4);
            r.a().a(4, this.f40a, 60000);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            r.a().f(4);
            r.a().a(4, this.f40a, 60000);
        }
    }

    private static boolean a(Context context) {
        String a = b.a(context);
        i.a("BackgroundTrigger", "[checkRuningProcess]:", a);
        return !TextUtils.isEmpty(a) && a.indexOf(":") != -1;
    }
}
