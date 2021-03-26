package com.tencent.tpns.baseapi.base.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class ChannelUtils {
    public static boolean isMiuiV12() {
        return "V12".equals(getMiuiVersionName());
    }

    public static String getMiuiVersionCode() {
        return a("ro.miui.ui.version.code");
    }

    public static String getMiuiVersionName() {
        return a("ro.miui.ui.version.name");
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, str);
        } catch (Exception unused) {
            TBaseLogger.w("ChannelUtils", "unexpected for getSystemPropertiesKey:" + str);
            return "";
        }
    }

    public static boolean isBrandMeiZu() {
        return !TextUtils.isEmpty(a("ro.meizu.product.model")) || "meizu".equalsIgnoreCase(Build.BRAND) || "meizu".equalsIgnoreCase(Build.MANUFACTURER) || "22c4185e".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean isBrandHuaWei() {
        return "huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandHonor() {
        return "honor".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandXiaoMi() {
        return "xiaomi".equalsIgnoreCase(Build.MANUFACTURER) || "xiaomi".equalsIgnoreCase(Build.MODEL);
    }
}
