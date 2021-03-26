package com.xiaomi.push;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g {

    public enum a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a  reason: collision with other field name */
        private final int f497a;

        private a(int i) {
            this.f497a = i;
        }

        public int a() {
            return this.f497a;
        }
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            b.a(e);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ApplicationInfo m354a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            b.m41a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m355a(Context context, String str) {
        ApplicationInfo a2 = m354a(context, str);
        Drawable drawable = null;
        if (a2 != null) {
            try {
                drawable = a2.loadIcon(context.getPackageManager());
                if (drawable == null && Build.VERSION.SDK_INT >= 9) {
                    drawable = a2.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                b.m41a("get app icon drawable failed, " + e);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    private static a a(Context context, ApplicationInfo applicationInfo) {
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return a.UNKNOWN;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object a2 = i >= 29 ? bd.a(context.getSystemService("notification"), "getService", new Object[0]) : context.getSystemService("security");
                if (a2 != null) {
                    bool = (Boolean) bd.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? a.ALLOWED : a.NOT_ALLOWED;
            }
        } catch (Exception e) {
            b.m41a("are notifications enabled error " + e);
        }
        return a.UNKNOWN;
    }

    public static a a(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19) {
            return a.UNKNOWN;
        }
        try {
            ApplicationInfo applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a a2 = a(context, applicationInfo);
            if (a2 != a.UNKNOWN) {
                return a2;
            }
            Integer num = (Integer) bd.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return a.UNKNOWN;
            }
            Integer num2 = (Integer) bd.a((Object) ((AppOpsManager) context.getSystemService("appops")), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
            int i = (Integer) bd.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i2 = (Integer) bd.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            b.b(String.format("get app mode %s|%s|%s", num2, i, i2));
            if (i == null) {
                i = 0;
            }
            if (i2 == null) {
                i2 = 1;
            }
            if (num2 != null) {
                return z ? !num2.equals(i2) ? a.ALLOWED : a.NOT_ALLOWED : num2.equals(i) ? a.ALLOWED : a.NOT_ALLOWED;
            }
            return a.UNKNOWN;
        } catch (Throwable th) {
            b.m41a("get app op error " + th);
        }
    }

    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m356a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            b.a(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m357a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() >= 1) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid() && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m358a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static int b(Context context, String str) {
        ApplicationInfo a2 = m354a(context, str);
        if (a2 == null) {
            return 0;
        }
        int i = a2.icon;
        return (i != 0 || Build.VERSION.SDK_INT < 9) ? i : a2.logo;
    }

    public static String b(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String[] strArr = runningAppProcessInfo.pkgList;
                int i = 0;
                while (strArr != null && i < strArr.length) {
                    if (!arrayList.contains(strArr[i])) {
                        arrayList.add(strArr[i]);
                        if (arrayList.size() == 1) {
                            str = (String) arrayList.get(0);
                        } else {
                            sb.append("#");
                            str = strArr[i];
                        }
                        sb.append(str.hashCode() % 100000);
                    }
                    i++;
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m359b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException e) {
            b.a(e);
            return str;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m360b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
