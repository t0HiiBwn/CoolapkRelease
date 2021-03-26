package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.XMJobService;

public final class dw {
    private static a a;
    private static final String b = XMJobService.class.getCanonicalName();
    private static int c = 0;

    interface a {
        void a();

        void a(boolean z);

        boolean b();
    }

    public static synchronized void a() {
        synchronized (dw.class) {
            if (a != null) {
                c.c("stop alarm.");
                a.a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        if (r7.equals(com.xiaomi.push.jb.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007d, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a  */
    public static void a(Context context) {
        dx dxVar;
        Exception e;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            dxVar = new dx(applicationContext);
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
                                String str = b;
                                if (!str.equals(serviceInfo.name)) {
                                }
                                i2 = 1;
                                if (i2 == 1) {
                                    break;
                                }
                            }
                            if (b.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                i = 1;
                                break;
                            }
                            i++;
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                            c.a("check service err : " + e.getMessage());
                            if (i == 0) {
                            }
                            int i3 = Build.VERSION.SDK_INT;
                            dxVar = new dx(applicationContext);
                            a = dxVar;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                c.a("check service err : " + e.getMessage());
                if (i == 0) {
                }
                int i3 = Build.VERSION.SDK_INT;
                dxVar = new dx(applicationContext);
                a = dxVar;
            }
            if (i == 0 || !jb.b(applicationContext)) {
                int i3 = Build.VERSION.SDK_INT;
                dxVar = new dx(applicationContext);
            } else {
                throw new RuntimeException("Should export service: " + b + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
            }
        }
        a = dxVar;
    }

    public static synchronized void a(Context context, int i) {
        synchronized (dw.class) {
            int i2 = c;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    c = 2;
                } else {
                    c = 0;
                }
            }
            int i3 = c;
            if (i2 != i3 && i3 == 2) {
                a();
                a = new dz(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (dw.class) {
            if (a == null) {
                c.a("timer is not initialized");
                return;
            }
            c.c("register alarm. (" + z + ")");
            a.a(z);
        }
    }

    public static synchronized boolean b() {
        synchronized (dw.class) {
            a aVar = a;
            if (aVar == null) {
                return false;
            }
            return aVar.b();
        }
    }
}
