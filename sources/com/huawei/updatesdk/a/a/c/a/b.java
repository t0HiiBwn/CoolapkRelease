package com.huawei.updatesdk.a.a.c.a;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.a.c.c;
import com.huawei.updatesdk.a.a.c.e;
import com.huawei.updatesdk.service.otaupdate.h;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class b {
    private static b a = new b();
    private static String d = null;
    private int b = 0;
    private int c = 0;

    private b() {
        int a2 = a("ro.maple.enable", 0);
        int a3 = a("persist.mygote.disable", 0);
        if (a2 == 1 && a3 != 1) {
            this.b = 1;
        }
        this.c = a("ro.build.version.ark", 0);
    }

    public static int a(String str, int i) {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i))).intValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodError | NoSuchMethodException e) {
            a.a("DeviceUtil", "Exception while getting system property: ", e);
            return i;
        }
    }

    public static String a() {
        try {
            Object obj = Class.forName("com.huawei.system.BuildEx").getField("DISPLAY").get(null);
            return obj == null ? Build.DISPLAY : obj.toString();
        } catch (IllegalAccessException unused) {
            return Build.DISPLAY;
        } catch (NoSuchFieldException unused2) {
            return Build.DISPLAY;
        } catch (ClassNotFoundException unused3) {
            return Build.DISPLAY;
        } catch (Throwable unused4) {
            return Build.DISPLAY;
        }
    }

    public static String a(Context context) {
        DisplayMetrics j = j(context);
        return j != null ? String.valueOf(j.densityDpi) : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    public static String a(Context context, String str) {
        String str2;
        String str3;
        StringBuilder sb;
        String c2 = h.a().c();
        if (TextUtils.isEmpty(c2)) {
            return str;
        }
        str2 = null;
        try {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            grsBaseInfo.setSerCountry(c2);
            str2 = new GrsClient(context, grsBaseInfo).synGetGrsUrl("com.huawei.updatesdk", "ROOT");
        } catch (NoSuchMethodError e) {
            sb = new StringBuilder();
            sb.append("UpdateSDK Get url from GRS_SDK error: ");
            str3 = e.toString();
        } catch (Exception e2) {
            sb = new StringBuilder();
            sb.append("UpdateSDK Get url from GRS_SDK error: ");
            str3 = e2.toString();
        } catch (Throwable th) {
            sb = new StringBuilder();
            sb.append("UpdateSDK Get url from GRS_SDK error: ");
            str3 = th.toString();
        }
        if (!TextUtils.isEmpty(str2)) {
            Log.i("DeviceUtil", "UpdateSDK Get url is default url");
            return str;
        }
        Log.i("DeviceUtil", "UpdateSDK Get url from GRS_SDK Success!" + str2);
        return str2;
        sb.append(str3);
        Log.w("DeviceUtil", sb.toString());
        if (!TextUtils.isEmpty(str2)) {
        }
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException | Exception | NoSuchMethodError | NoSuchMethodException e) {
            a.a("DeviceUtil", "Exception while getting system property: ", e);
            return str2;
        }
    }

    public static List<String> a(List<String> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!a(str, strArr)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    static boolean a(String str, String[] strArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (String str2 : strArr) {
            if (str2.startsWith("config.")) {
                i = 1;
            } else if (!str2.contains(".config.")) {
                i2++;
            }
            if (str2.endsWith("config." + str)) {
                i3++;
            }
        }
        return i + i2 == i3;
    }

    public static String b() {
        String str;
        String str2;
        Locale locale = Locale.getDefault();
        String str3 = "";
        if (locale != null) {
            str = locale.getLanguage();
            if (Build.VERSION.SDK_INT >= 21) {
                str3 = locale.getScript();
            }
            str2 = locale.getCountry();
        } else {
            str = "en";
            str2 = "US";
        }
        if (TextUtils.isEmpty(str3)) {
            return str + "_" + str2;
        }
        return str + "_" + str3 + "_" + str2;
    }

    static String b(Context context) {
        if (d == null) {
            d = e.a(k(context), ",");
        }
        return d;
    }

    public static List<String> c(Context context) {
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT;
        Configuration configuration = context.getResources().getConfiguration();
        if (i >= 24) {
            LocaleList locales = configuration.getLocales();
            for (int i2 = 0; i2 < locales.size(); i2++) {
                String language = locales.get(i2).getLanguage();
                if (!TextUtils.isEmpty(language) && !arrayList.contains(language)) {
                    arrayList.add(language);
                }
            }
        } else {
            arrayList.add(configuration.locale.getLanguage());
        }
        return arrayList;
    }

    public static String[] c() {
        return Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS == null ? new String[0] : Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI};
    }

    public static int d() {
        String str;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            Object invoke = cls.getMethod("myUserId", new Class[0]).invoke(cls, new Object[0]);
            if (invoke instanceof Integer) {
                return ((Integer) invoke).intValue();
            }
            return 0;
        } catch (IllegalArgumentException e) {
            sb = new StringBuilder();
            sb.append("get current uid IllegalArgumentException! ");
            str2 = e.toString();
            sb.append(str2);
            str = sb.toString();
            a.d("DeviceUtil", str);
            return 0;
        } catch (ClassNotFoundException e2) {
            sb = new StringBuilder();
            sb.append("get current uid ClassNotFoundException! ");
            str2 = e2.toString();
            sb.append(str2);
            str = sb.toString();
            a.d("DeviceUtil", str);
            return 0;
        } catch (NoSuchMethodException e3) {
            sb = new StringBuilder();
            sb.append("get current uid NoSuchMethodException! ");
            str2 = e3.toString();
            sb.append(str2);
            str = sb.toString();
            a.d("DeviceUtil", str);
            return 0;
        } catch (InvocationTargetException e4) {
            sb = new StringBuilder();
            sb.append("get current uid InvocationTargetException! ");
            str2 = e4.toString();
            sb.append(str2);
            str = sb.toString();
            a.d("DeviceUtil", str);
            return 0;
        } catch (IllegalAccessException e5) {
            sb2 = new StringBuilder();
            sb2.append("get current uid IllegalAccessException! ");
            str3 = e5.toString();
            sb2.append(str3);
            str = sb2.toString();
            a.d("DeviceUtil", str);
            return 0;
        } catch (Exception e6) {
            sb2 = new StringBuilder();
            sb2.append("get current uid IllegalAccessException! ");
            str3 = e6.toString();
            sb2.append(str3);
            str = sb2.toString();
            a.d("DeviceUtil", str);
            return 0;
        } catch (Throwable th) {
            sb2 = new StringBuilder();
            sb2.append("get current uid IllegalAccessException! ");
            str3 = th.toString();
            sb2.append(str3);
            str = sb2.toString();
            a.d("DeviceUtil", str);
            return 0;
        }
    }

    public static String d(Context context) {
        DisplayMetrics j = j(context);
        if (j == null) {
            return "";
        }
        String valueOf = String.valueOf(j.widthPixels);
        String valueOf2 = String.valueOf(j.heightPixels);
        return valueOf + "_" + valueOf2;
    }

    public static String e() {
        return Build.VERSION.RELEASE.trim();
    }

    public static boolean e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.gsf.login", 16);
            packageManager.getPackageInfo("com.google.android.gsf", 16);
            return (packageManager.getPackageInfo("com.google.android.gms", 16).applicationInfo.flags & 1) != 0;
        } catch (Exception e) {
            a.d("DeviceUtil", e.getMessage());
            return false;
        }
    }

    public static int f(Context context) {
        try {
            return Integer.parseInt(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionCode + "");
        } catch (Exception unused) {
            return 1;
        }
    }

    public static b f() {
        return a;
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.appmarket", 16).versionName + "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h(Context context) {
        String g = g(context);
        int i = 0;
        int i2 = 0;
        while (i < g.length() && i2 < 3) {
            if (g.charAt(i) == '.') {
                i2++;
            }
            i++;
        }
        return 3 == i2 ? g.substring(0, i - 1) : g;
    }

    public static String i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName + "";
        } catch (Exception unused) {
            return null;
        }
    }

    private static DisplayMetrics j(Context context) {
        Display defaultDisplay;
        Object systemService = context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static List<String> k(Context context) {
        ArrayList arrayList = new ArrayList();
        FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
        if (systemAvailableFeatures != null) {
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if (featureInfo.name != null) {
                    arrayList.add(c.a(featureInfo.name));
                }
            }
        }
        return arrayList;
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return this.c;
    }
}
