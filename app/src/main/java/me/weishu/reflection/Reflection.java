package me.weishu.reflection;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

public class Reflection {
    private static final int ERROR_SET_APPLICATION_FAILED = -20;
    private static final String TAG = "Reflection";
    private static int UNKNOWN = -9999;
    private static Object sVmRuntime;
    private static Method setHiddenApiExemptions;
    private static int unsealed = -9999;

    private static native int unsealNative(int i);

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            setHiddenApiExemptions = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            sVmRuntime = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
        } catch (Throwable th) {
            Log.e("Reflection", "reflect bootstrap failed:", th);
        }
        System.loadLibrary("free-reflection");
    }

    public static int unseal(Context context) {
        if (Build.VERSION.SDK_INT < 28 || exemptAll()) {
            return 0;
        }
        if (context == null) {
            return -10;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.targetSdkVersion;
        synchronized (Reflection.class) {
            int i2 = unsealed;
            if (i2 != UNKNOWN) {
                return i2;
            }
            int unsealNative = unsealNative(i);
            unsealed = unsealNative;
            if (unsealNative < 0) {
                return unsealNative;
            }
            if ((Build.VERSION.SDK_INT != 28 || Build.VERSION.PREVIEW_SDK_INT <= 0) && Build.VERSION.SDK_INT <= 28) {
                try {
                    ApplicationInfo.class.getDeclaredMethod("setHiddenApiEnforcementPolicy", Integer.TYPE).invoke(applicationInfo, 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    unsealed = -20;
                }
                return unsealed;
            }
            return unsealed;
        }
    }

    public static boolean exempt(String str) {
        return exempt(str);
    }

    public static boolean exempt(String... strArr) {
        Method method;
        Object obj = sVmRuntime;
        if (!(obj == null || (method = setHiddenApiExemptions) == null)) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean exemptAll() {
        return exempt("L");
    }
}
