package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.a;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

/* compiled from: BUGLY */
public class b {
    public static a a = null;
    private static boolean b = false;
    private static int c = 10;
    private static long d = 300000;
    private static long e = 30000;
    private static long f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static Application.ActivityLifecycleCallbacks k = null;
    private static Class<?> l = null;
    private static boolean m = true;

    static /* synthetic */ String a(String str, String str2) {
        return z.a() + "  " + str + "  " + str2 + "\n";
    }

    static /* synthetic */ int g() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z;
        boolean z2;
        boolean z3;
        if (buglyStrategy != null) {
            z2 = buglyStrategy.recordUserInfoOnceADay();
            z = buglyStrategy.isEnableUserInfo();
        } else {
            z = true;
            z2 = false;
        }
        if (z2) {
            a a2 = a.a(context);
            List<UserInfoBean> a3 = a.a(a2.d);
            if (a3 != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= a3.size()) {
                        break;
                    }
                    UserInfoBean userInfoBean = a3.get(i2);
                    if (userInfoBean.n.equals(a2.k) && userInfoBean.b == 1) {
                        long b2 = z.b();
                        if (b2 <= 0) {
                            break;
                        } else if (userInfoBean.e >= b2) {
                            if (userInfoBean.f <= 0) {
                                a aVar = a;
                                w a4 = w.a();
                                if (a4 != null) {
                                    a4.a(new Runnable() {
                                        /* class com.tencent.bugly.crashreport.biz.a.AnonymousClass2 */

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            try {
                                                a.this.c();
                                            } catch (Throwable th) {
                                                x.a(th);
                                            }
                                        }
                                    });
                                }
                            }
                            z3 = false;
                        }
                    }
                    i2++;
                }
                if (!z3) {
                    z = false;
                } else {
                    return;
                }
            }
            z3 = true;
            if (!z3) {
            }
        }
        a b3 = a.b();
        Application application = null;
        if (b3 != null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String str = null;
            boolean z4 = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getMethodName().equals("onCreate")) {
                    str = stackTraceElement.getClassName();
                }
                if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                    z4 = true;
                }
            }
            if (str == null) {
                str = "unknown";
            } else if (z4) {
                b3.a(true);
            } else {
                str = "background";
            }
            b3.q = str;
        }
        if (z && Build.VERSION.SDK_INT >= 14) {
            if (context.getApplicationContext() instanceof Application) {
                application = (Application) context.getApplicationContext();
            }
            if (application != null) {
                try {
                    if (k == null) {
                        k = new Application.ActivityLifecycleCallbacks() {
                            /* class com.tencent.bugly.crashreport.biz.b.AnonymousClass2 */

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
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onResumed <<<", name);
                                    a b = a.b();
                                    if (b != null) {
                                        b.D.add(b.a(name, "onResumed"));
                                        b.a(true);
                                        b.q = name;
                                        b.r = System.currentTimeMillis();
                                        b.u = b.r - b.i;
                                        long j = b.r - b.h;
                                        if (j > (b.f > 0 ? b.f : b.e)) {
                                            b.d();
                                            b.g();
                                            x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j / 1000), Long.valueOf(b.e / 1000));
                                            if (b.g % b.c == 0) {
                                                b.a.a(4, b.m, 0);
                                                return;
                                            }
                                            b.a.a(4, false, 0L);
                                            long currentTimeMillis = System.currentTimeMillis();
                                            if (currentTimeMillis - b.j > b.d) {
                                                long unused = b.j = currentTimeMillis;
                                                x.a("add a timer to upload hot start user info", new Object[0]);
                                                if (b.m) {
                                                    w.a().a(new a.RunnableC0143a(null, true), b.d);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityPaused(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onPaused <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (b != null) {
                                        b.D.add(b.a(name, "onPaused"));
                                        b.a(false);
                                        b.s = System.currentTimeMillis();
                                        b.t = b.s - b.r;
                                        long unused = b.h = b.s;
                                        if (b.t < 0) {
                                            b.t = 0;
                                        }
                                        if (activity != null) {
                                            b.q = "background";
                                        } else {
                                            b.q = "unknown";
                                        }
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityDestroyed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onDestroyed <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (b != null) {
                                        b.D.add(b.a(name, "onDestroyed"));
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityCreated(Activity activity, Bundle bundle) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onCreated <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (b != null) {
                                        b.D.add(b.a(name, "onCreated"));
                                    }
                                }
                            }
                        };
                    }
                    application.registerActivityLifecycleCallbacks(k);
                } catch (Exception e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (m) {
            i = System.currentTimeMillis();
            a.a(1, false, 0L);
            x.a("[session] launch app, new start", new Object[0]);
            a.a();
            w.a().a(new a.c(21600000), 21600000);
        }
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j2;
        if (!b) {
            boolean z = com.tencent.bugly.crashreport.common.info.a.a(context).e;
            m = z;
            a = new a(context, z);
            b = true;
            if (buglyStrategy != null) {
                l = buglyStrategy.getUserInfoActivity();
                j2 = buglyStrategy.getAppReportDelay();
            } else {
                j2 = 0;
            }
            if (j2 <= 0) {
                c(context, buglyStrategy);
            } else {
                w.a().a(new Runnable() {
                    /* class com.tencent.bugly.crashreport.biz.b.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public final void run() {
                        b.c(context, buglyStrategy);
                    }
                }, j2);
            }
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().o;
        }
        f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        w a2;
        a aVar = a;
        if (!(aVar == null || z || (a2 = w.a()) == null)) {
            a2.a(new Runnable() {
                /* class com.tencent.bugly.crashreport.biz.a.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.c();
                    } catch (Throwable th) {
                        x.a(th);
                    }
                }
            });
        }
        if (strategyBean != null) {
            if (strategyBean.o > 0) {
                e = strategyBean.o;
            }
            if (strategyBean.t > 0) {
                c = strategyBean.t;
            }
            if (strategyBean.u > 0) {
                d = strategyBean.u;
            }
        }
    }

    public static void a() {
        a aVar = a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (b && context != null) {
            Application application = null;
            if (Build.VERSION.SDK_INT >= 14) {
                if (context.getApplicationContext() instanceof Application) {
                    application = (Application) context.getApplicationContext();
                }
                if (application != null) {
                    try {
                        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = k;
                        if (activityLifecycleCallbacks != null) {
                            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                        }
                    } catch (Exception e2) {
                        if (!x.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            b = false;
        }
    }
}
