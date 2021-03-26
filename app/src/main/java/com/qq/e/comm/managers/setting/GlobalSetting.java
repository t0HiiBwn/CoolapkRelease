package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;

public final class GlobalSetting {
    private static volatile CustomLandingPageListener a = null;
    private static volatile Integer b = null;
    private static volatile boolean c = false;
    private static volatile boolean d = true;
    private static volatile Boolean e;
    private static volatile String f;
    private static volatile String g;
    private static volatile String h;
    private static volatile String i;
    private static volatile String j;

    public static Integer getChannel() {
        return b;
    }

    public static String getCustomADActivityClassName() {
        return f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return i;
    }

    public static String getCustomPortraitActivityClassName() {
        return g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (e != null) {
            return e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (e == null) {
            e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (b == null) {
            b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        d = z;
    }
}
