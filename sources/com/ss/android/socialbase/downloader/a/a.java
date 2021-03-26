package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AppStatusManager */
public class a {
    private Application a;
    private c b;
    private final List<AbstractC0102a> c;
    private int d;
    private WeakReference<Activity> e;
    private volatile int f;
    private final Application.ActivityLifecycleCallbacks g;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* compiled from: AppStatusManager */
    public interface AbstractC0102a {
        void b();

        void c();
    }

    /* compiled from: AppStatusManager */
    private static class b {
        private static final a a = new a();
    }

    /* compiled from: AppStatusManager */
    public interface c {
        boolean a();
    }

    public static a a() {
        return b.a;
    }

    private a() {
        this.c = new ArrayList();
        this.f = -1;
        this.g = new Application.ActivityLifecycleCallbacks() {
            /* class com.ss.android.socialbase.downloader.a.a.AnonymousClass1 */

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.e = new WeakReference(activity);
                int i = a.this.d;
                a.this.d = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    a.this.d();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                com.ss.android.socialbase.downloader.c.a.b("AppStatusManager", "onActivityResumed activity = [" + activity + "]");
                int i = a.this.d;
                a.this.d = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    a.this.d();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                com.ss.android.socialbase.downloader.c.a.b("AppStatusManager", "onActivityPaused activity = [" + activity + "]");
                if (a.this.d == 0 && activity != null) {
                    a.this.d = activity.hashCode();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                com.ss.android.socialbase.downloader.c.a.b("AppStatusManager", "onActivityStopped activity = [" + activity + "]");
                if (activity != null && activity.hashCode() == a.this.d) {
                    a.this.d = 0;
                    a.this.e();
                }
            }
        };
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.g);
                }
            }
        }
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public boolean b() {
        c cVar = this.b;
        if (cVar != null) {
            return !cVar.a();
        }
        int i = this.f;
        int i2 = i;
        if (i == -1) {
            ?? f2 = f();
            this.f = f2;
            i2 = f2;
        }
        if (i2 == 1) {
            return true;
        }
        return false;
    }

    public void a(AbstractC0102a aVar) {
        if (aVar != null) {
            synchronized (this.c) {
                if (!this.c.contains(aVar)) {
                    this.c.add(aVar);
                }
            }
        }
    }

    public void b(AbstractC0102a aVar) {
        synchronized (this.c) {
            this.c.remove(aVar);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.c) {
            array = this.c.size() > 0 ? this.c.toArray() : null;
        }
        return array;
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f = 1;
        Object[] c2 = c();
        if (c2 != null) {
            for (Object obj : c2) {
                ((AbstractC0102a) obj).b();
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f = 0;
        Object[] c2 = c();
        if (c2 != null) {
            for (Object obj : c2) {
                ((AbstractC0102a) obj).c();
            }
        }
    }

    private boolean f() {
        try {
            Application application = this.a;
            if (application == null) {
                return false;
            }
            String packageName = application.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            if (runningAppProcesses.isEmpty()) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && TextUtils.equals(runningAppProcessInfo.processName, packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
