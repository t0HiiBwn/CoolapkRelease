package XI.XI.K0;

import XI.CA.XI.K0;
import XI.K0.XI.XI;
import XI.xo.XI.XI.CA;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;

public class XI {
    public static boolean K0;

    /* renamed from: XI  reason: collision with root package name */
    public static boolean f1175XI;

    public static Context CA(Context context) {
        return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
    }

    public static String K0(Context context) {
        K0 XI2 = K0.XI(context);
        if (XI2 == null) {
            return null;
        }
        String str = K0.WI;
        if (str != null) {
            return str;
        }
        XI2.XI(0, null);
        if (K0.kM == null) {
            K0.XI(K0.f1165XI, 0, null);
        }
        return K0.WI;
    }

    public static String XI(Context context, String str) {
        K0 XI2 = K0.XI(context);
        if (XI2 == null) {
            return null;
        }
        String str2 = K0.cs;
        if (str2 != null) {
            return str2;
        }
        XI2.XI(2, str);
        if (K0.CA == null && K0.cs != null) {
            K0.XI(K0.f1165XI, 2, str);
        }
        return K0.cs;
    }

    public static final boolean XI() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e) {
            e.toString();
        }
        if (context == null) {
            return false;
        }
        return CA.XI().XI(context, false);
    }

    public static String kM(Context context) {
        K0 XI2 = K0.XI(context);
        if (XI2 == null || Build.VERSION.SDK_INT == 28) {
            return null;
        }
        String str = K0.bs;
        if (str != null) {
            return str;
        }
        String packageName = K0.f1165XI.getPackageName();
        XI2.XI(1, packageName);
        if (K0.xo == null && K0.bs != null) {
            K0.XI(K0.f1165XI, 1, packageName);
        }
        return K0.bs;
    }

    public static void xo(Context context) {
        if (!f1175XI) {
            XI.K0 k0 = XI.K0.C0000K0.f1169XI;
            Context CA = CA(context);
            k0.getClass();
            boolean z = false;
            try {
                PackageInfo packageInfo = CA.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (packageInfo != null && packageInfo.versionCode >= 1) {
                    z = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            K0 = z;
            f1175XI = true;
        }
    }

    public static String K0(Context context, String str) {
        K0 XI2 = K0.XI(context);
        if (XI2 == null) {
            return null;
        }
        String str2 = K0.bs;
        if (str2 != null) {
            return str2;
        }
        XI2.XI(1, str);
        if (K0.xo == null && K0.bs != null) {
            K0.XI(K0.f1165XI, 1, str);
        }
        return K0.bs;
    }

    public static String XI(Context context) {
        K0 XI2 = K0.XI(context);
        if (XI2 == null || Build.VERSION.SDK_INT == 28) {
            return null;
        }
        String str = K0.cs;
        if (str != null) {
            return str;
        }
        String packageName = K0.f1165XI.getPackageName();
        XI2.XI(2, packageName);
        if (K0.CA == null && K0.cs != null) {
            K0.XI(K0.f1165XI, 2, packageName);
        }
        return K0.cs;
    }
}
