package com.coolapk.market.view.danmaku.easy.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenUtil {
    private static final String TAG = "ScreenUtil";
    private static int sDesignHeight = 1920;
    private static int sDesignWidth = 1080;
    private static int sScreenHeight = 1080;
    private static int sScreenWidth = 1920;

    public static void init(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        sScreenWidth = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels;
        sScreenHeight = i;
        int i2 = sDesignWidth;
        int i3 = sDesignHeight;
        boolean z = true;
        boolean z2 = i2 > i3;
        if (sScreenWidth <= i) {
            z = false;
        }
        if (z2 != z) {
            sDesignWidth = i3;
            sDesignHeight = i2;
        }
    }

    public static void setDesignWidthAndHeight(int i, int i2) {
        sDesignWidth = i;
        sDesignHeight = i2;
    }

    public static int autoSize(int i) {
        return autoWidth(i);
    }

    public static int autoSize(int i, int i2) {
        return isPortrait() ? autoSize(i2) : autoSize(i);
    }

    public static int autoWidth(int i) {
        int i2;
        int i3 = sScreenWidth;
        if (i3 == 0 || (i2 = sDesignWidth) == 0) {
            return i;
        }
        int i4 = (i3 * i) / i2;
        if (i == 0 || i4 != 0) {
            return i4;
        }
        return 1;
    }

    public static int autoHeight(int i) {
        int i2;
        int i3 = sScreenHeight;
        if (i3 == 0 || (i2 = sDesignHeight) == 0) {
            return i;
        }
        int i4 = (i3 * i) / i2;
        if (i == 0 || i4 != 0) {
            return i4;
        }
        return 1;
    }

    public static int getScreenWidth() {
        return sScreenWidth;
    }

    public static void setScreenWidth(int i) {
        sScreenWidth = i;
    }

    public static int getScreenHeight() {
        return sScreenHeight;
    }

    public static void setScreenHeight(int i) {
        sScreenHeight = i;
    }

    public static boolean isPortrait() {
        return getScreenHeight() > getScreenWidth();
    }
}
