package com.tencent.beacon.core.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.g;
import com.tencent.beacon.core.event.o;
import java.util.Date;
import java.util.List;

/* compiled from: AppInfo */
public final class a {
    public static boolean a = false;
    private static String b = null;
    private static String c = null;
    private static Boolean d = null;
    private static int e = 0;
    private static String f = "";

    public static synchronized boolean a(Context context) {
        Exception e2;
        boolean z;
        synchronized (a.class) {
            boolean z2 = false;
            if (context == null) {
                b.d("[core] context is null", new Object[0]);
                return false;
            }
            try {
                c a2 = c.a(context);
                String a3 = a2.a("APPKEY_DENGTA", (String) null);
                String a4 = b.a(o.a).a();
                if (a3 == null || !a3.equals(a4)) {
                    z = true;
                    try {
                        a2.a().a("APPKEY_DENGTA", (Object) a4).b();
                        z2 = true;
                    } catch (Exception e3) {
                        e2 = e3;
                        b.d("[core] updateLocalAPPKEY fail!", new Object[0]);
                        b.a(e2);
                        z2 = z;
                        return z2;
                    }
                }
            } catch (Exception e4) {
                e2 = e4;
                z = false;
                b.d("[core] updateLocalAPPKEY fail!", new Object[0]);
                b.a(e2);
                z2 = z;
                return z2;
            }
            return z2;
        }
    }

    public static boolean b(Context context) {
        Exception e2;
        boolean z;
        if (context == null) {
            b.d("[core] context is null", new Object[0]);
            return false;
        }
        try {
            c a2 = c.a(context);
            String a3 = a2.a("APPVER_DENGTA", (String) null);
            String b2 = b.a(o.a).b((String) null);
            if (a3 != null && a3.equals(b2)) {
                return false;
            }
            z = true;
            try {
                a2.a().a("APPVER_DENGTA", (Object) b2).b();
                return true;
            } catch (Exception e3) {
                e2 = e3;
                b.d("[core] updateLocalAPPVER fail!", new Object[0]);
                b.a(e2);
                return z;
            }
        } catch (Exception e4) {
            e2 = e4;
            z = false;
            b.d("[core] updateLocalAPPVER fail!", new Object[0]);
            b.a(e2);
            return z;
        }
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        String packageName = context.getPackageName();
        return g.a(packageName) ? "" : packageName;
    }

    public static String d(Context context) {
        if (b == null) {
            b = e(context);
        }
        return b;
    }

    protected static synchronized String e(Context context) {
        char[] charArray;
        synchronized (a.class) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(c(context), 0);
                String str = packageInfo.versionName;
                int i = packageInfo.versionCode;
                if (str != null) {
                    if (str.trim().length() > 0) {
                        String replace = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
                        int i2 = 0;
                        for (char c2 : replace.toCharArray()) {
                            if (c2 == '.') {
                                i2++;
                            }
                        }
                        if (i2 < 3) {
                            b.b("[core] add versionCode: %s", Integer.valueOf(i));
                            replace = replace + "." + i;
                        }
                        b.b("[core] final Version: %s", replace);
                        return replace;
                    }
                }
                return String.valueOf(i);
            } catch (Exception e2) {
                b.a(e2);
                b.d(e2.toString(), new Object[0]);
                return "";
            }
        }
    }

    public static synchronized boolean f(Context context) {
        boolean booleanValue;
        synchronized (a.class) {
            if (d == null) {
                d = Boolean.valueOf(a(context, "android.permission.READ_PHONE_STATE"));
            }
            b.b("[core] Read phone state permission: " + d, new Object[0]);
            booleanValue = d.booleanValue();
        }
        return booleanValue;
    }

    public static boolean g(Context context) {
        return b(context, context.getPackageName());
    }

    public static String a() {
        if (!"".equals(f)) {
            return f;
        }
        try {
            if (e == 0) {
                e = Process.myPid();
            }
            f += e + "_";
            f += new Date().getTime();
        } catch (Exception unused) {
        }
        return f;
    }

    public static int h(Context context) {
        try {
            if (e == 0) {
                e = Process.myPid();
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == e) {
                    return runningAppProcessInfo.importance;
                }
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String i(Context context) {
        String str = c;
        if (str != null) {
            return str;
        }
        try {
            if (e == 0) {
                e = Process.myPid();
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == e) {
                    String str2 = runningAppProcessInfo.processName;
                    c = str2;
                    return str2;
                }
            }
            return "";
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }

    private static boolean a(Context context, String str) {
        if (context != null) {
            boolean z = true;
            boolean z2 = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
            if (z2) {
                return z2;
            }
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (str.equals(strArr[i])) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                z = z2;
                b.b("[core] end", new Object[0]);
                return z;
            } catch (Throwable th) {
                b.b("[core] end", new Object[0]);
                throw th;
            }
        } else {
            b.d("[core] context or permission is null.", new Object[0]);
            return false;
        }
    }

    private static boolean b(Context context, String str) {
        if (!(context == null || str == null || str.trim().length() <= 0)) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    if (runningAppProcesses.size() != 0) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.importance == 100) {
                                for (String str2 : runningAppProcessInfo.pkgList) {
                                    if (str.equals(str2)) {
                                        return true;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                }
                b.c("[core] no running proc", new Object[0]);
                return false;
            } catch (Throwable th) {
                b.a(th);
                b.d("[core] Failed to judge [%s]", th.getLocalizedMessage());
            }
        }
        return false;
    }
}
