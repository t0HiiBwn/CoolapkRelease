package com.ss.android.downloadlib.a.a;

import android.os.Build;
import java.lang.reflect.Method;

/* compiled from: HiddenAPIEnforcementPolicyUtils */
public class b {
    private static Method a;
    private static Object b;
    private static boolean c;

    private static void b() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) Class.class.getDeclaredMethod("forName", String.class).invoke(null, "dalvik.system.VMRuntime");
            a = (Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            b = ((Method) declaredMethod.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
            a("Landroid/", "Lcom/android/", "Ljava/lang/", "Ldalvik/system/", "Llibcore/io/", "Lsun/misc/");
        } catch (Throwable unused) {
        }
    }

    private static void a(String... strArr) throws Throwable {
        a.invoke(b, strArr);
    }

    private static int c() {
        if (Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        try {
            return Build.VERSION.PREVIEW_SDK_INT;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static boolean d() {
        return Build.VERSION.SDK_INT > 27 || (Build.VERSION.SDK_INT == 27 && c() > 0);
    }

    public static void a() {
        if (!c) {
            if (d()) {
                try {
                    b();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            c = true;
        }
    }
}
