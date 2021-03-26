package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;

public final class es {
    private static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static a f412a;

    /* renamed from: a  reason: collision with other field name */
    private static final String f413a = XMJobService.class.getCanonicalName();

    interface a {
        /* renamed from: a */
        void mo311a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m310a();
    }

    public static synchronized void a() {
        synchronized (es.class) {
            if (f412a != null) {
                b.c("stop alarm.");
                f412a.mo311a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        if (r7.equals(com.xiaomi.push.t.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007d, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a  */
    public static void a(Context context) {
        et etVar;
        Exception e;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            etVar = new et(applicationContext);
        } else {
            int i = 0;
            try {
                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    int length = serviceInfoArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        try {
                            ServiceInfo serviceInfo = serviceInfoArr[i];
                            if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                String str = f413a;
                                if (!str.equals(serviceInfo.name)) {
                                }
                                i2 = 1;
                                if (i2 == 1) {
                                    break;
                                }
                            }
                            if (f413a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                i = 1;
                                break;
                            }
                            i++;
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                            b.m41a("check service err : " + e.getMessage());
                            if (i == 0) {
                            }
                            int i3 = Build.VERSION.SDK_INT;
                            etVar = new et(applicationContext);
                            f412a = etVar;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                b.m41a("check service err : " + e.getMessage());
                if (i == 0) {
                }
                int i3 = Build.VERSION.SDK_INT;
                etVar = new et(applicationContext);
                f412a = etVar;
            }
            if (i == 0 || !t.m678a(applicationContext)) {
                int i3 = Build.VERSION.SDK_INT;
                etVar = new et(applicationContext);
            } else {
                throw new RuntimeException("Should export service: " + f413a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
            }
        }
        f412a = etVar;
    }

    public static synchronized void a(Context context, int i) {
        synchronized (es.class) {
            int i2 = a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    a = 2;
                } else {
                    a = 0;
                }
            }
            int i3 = a;
            if (i2 != i3 && i3 == 2) {
                a();
                f412a = new ev(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (es.class) {
            if (f412a == null) {
                b.m41a("timer is not initialized");
                return;
            }
            b.c("register alarm. (" + z + ")");
            f412a.a(z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m309a() {
        synchronized (es.class) {
            a aVar = f412a;
            if (aVar == null) {
                return false;
            }
            return aVar.m310a();
        }
    }
}
