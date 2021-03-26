package com.coolapk.market.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.coolapk.market.AppHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DarkStatusBarHandler {
    private static DarkStatusBarHandler sInstance;
    private boolean isAospMRom;
    private boolean isMeizuRom;
    private boolean isMiuiRom;

    public static DarkStatusBarHandler getInstance() {
        if (sInstance == null) {
            sInstance = new DarkStatusBarHandler();
        }
        return sInstance;
    }

    private DarkStatusBarHandler() {
        boolean z = true;
        try {
            Class.forName("android.view.MiuiWindowManager$LayoutParams");
            this.isMiuiRom = true;
        } catch (Throwable unused) {
            this.isMeizuRom = false;
            this.isAospMRom = Build.VERSION.SDK_INT < 23 ? false : z;
        }
    }

    public void setDarkMode(Activity activity, boolean z) {
        if (this.isMiuiRom) {
            setMiuiStatusBarDarkMode(activity, z);
        } else if (this.isMeizuRom) {
            setMeizuStatusBarDarkMode(activity, z);
        } else if (this.isAospMRom) {
            setAospStatusBarDarkMode(activity, z);
        }
    }

    public boolean canHandleDarkMode() {
        return this.isMiuiRom || this.isMeizuRom || this.isAospMRom;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0048: APUT  
      (r3v3 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x0044: INVOKE  (r9v2 java.lang.Integer) = (r9v1 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    private static boolean setMiuiStatusBarDarkMode(final Activity activity, final boolean z) {
        AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
            /* class com.coolapk.market.util.DarkStatusBarHandler.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                DarkStatusBarHandler.setAospStatusBarDarkMode(activity, z);
            }
        }, 150);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean setMeizuStatusBarDarkMode(final Activity activity, final boolean z) {
        AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
            /* class com.coolapk.market.util.DarkStatusBarHandler.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                DarkStatusBarHandler.setAospStatusBarDarkMode(activity, z);
            }
        }, 150);
        if (activity != null) {
            try {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                activity.getWindow().setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean setAospStatusBarDarkMode(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        View decorView = activity.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        return true;
    }
}
