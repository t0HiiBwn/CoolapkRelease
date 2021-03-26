package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.bugly.proguard.x;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public class AppInfo {
    private static ActivityManager a;

    static {
        "@buglyAllChannel@".split(",");
        "@buglyAllChannelPriority@".split(",");
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        if (!(context == null || str == null || str.trim().length() <= 0)) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[Catch:{ all -> 0x0051, all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[SYNTHETIC, Splitter:B:24:0x004d] */
    public static String a(int i) {
        FileReader fileReader;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/" + i + "/cmdline");
            try {
                char[] cArr = new char[512];
                fileReader.read(cArr);
                int i2 = 0;
                while (i2 < 512 && cArr[i2] != 0) {
                    i2++;
                }
                String substring = new String(cArr).substring(0, i2);
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                return substring;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    String valueOf = String.valueOf(i);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return valueOf;
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            if (!x.a(th)) {
            }
            String valueOf = String.valueOf(i);
            if (fileReader != null) {
            }
            return valueOf;
        }
        throw th;
    }

    public static String c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (!(packageManager == null || applicationInfo == null || (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) == null)) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                hashMap.put("BUGLY_DISABLE", obj.toString());
            }
            Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                hashMap.put("BUGLY_APPID", obj2.toString());
            }
            Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                hashMap.put("BUGLY_APP_VERSION", obj4.toString());
            }
            Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                hashMap.put("com.tencent.rdm.uuid", obj6.toString());
            }
            Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
            if (obj7 != null) {
                hashMap.put("BUGLY_APP_BUILD_NO", obj7.toString());
            }
            Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
            if (obj8 != null) {
                hashMap.put("BUGLY_AREA", obj8.toString());
            }
            return hashMap;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null) {
                if (str.length() != 0) {
                    String[] split = str.split(",");
                    for (int i = 0; i < split.length; i++) {
                        split[i] = split[i].trim();
                    }
                    return Arrays.asList(split);
                }
            }
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        if (a == null) {
            a = (ActivityManager) context.getSystemService("activity");
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            a.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            x.c("Memory is low.", new Object[0]);
            return true;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
