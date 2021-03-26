package com.huawei.hms.stats;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

public abstract class k {

    private static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    private static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls != null) {
            if (clsArr == null) {
                if (objArr != null) {
                    throw new a("paramsType is null, but params is not null");
                }
            } else if (objArr == null) {
                throw new a("paramsType or params should be same");
            } else if (clsArr.length != objArr.length) {
                throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
            try {
                try {
                    return cls.getMethod(str, clsArr).invoke(null, objArr);
                } catch (IllegalAccessException unused) {
                    str2 = "invokeStaticFun(): method invoke Exception!";
                    af.c("hmsSdk", str2);
                    return null;
                } catch (IllegalArgumentException unused2) {
                    str2 = "invokeStaticFun(): Illegal Argument!";
                    af.c("hmsSdk", str2);
                    return null;
                } catch (InvocationTargetException unused3) {
                    str2 = "invokeStaticFun(): Invocation Target Exception!";
                    af.c("hmsSdk", str2);
                    return null;
                }
            } catch (NoSuchMethodException unused4) {
                af.c("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
                return null;
            }
        } else {
            throw new a("class is null in invokeStaticFun");
        }
    }

    private static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return a(Class.forName(str), str2, clsArr, objArr);
        } catch (ClassNotFoundException unused) {
            str3 = "invokeStaticFun() Not found class!";
            af.c("hmsSdk", str3);
            return null;
        } catch (a unused2) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            af.c("hmsSdk", str3);
            return null;
        }
    }

    public static String a() {
        return bi.a("ro.build.version.emui", "");
    }

    public static String a(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String a2 = a("android.os.SystemProperties", str, str2);
        return TextUtils.isEmpty(a2) ? a("com.huawei.android.os.SystemPropertiesEx", str, str2) : a2;
    }

    private static String a(String str, String str2, String str3) {
        Object a2 = a(str, "get", new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return a2 != null ? (String) a2 : str3;
    }

    public static String b() {
        String a2 = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        af.b("hmsSdk", "SystemPropertiesEx: get rom_ver: " + a2);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String str = Build.DISPLAY;
        af.b("hmsSdk", "SystemProperties: get rom_ver: " + str);
        return str;
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            af.c("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }

    public static String c(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String d(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String obj2 = obj.toString();
            return obj2.length() > 256 ? "Unknown" : obj2;
        } catch (PackageManager.NameNotFoundException unused) {
            af.c("hmsSdk", "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }
}
