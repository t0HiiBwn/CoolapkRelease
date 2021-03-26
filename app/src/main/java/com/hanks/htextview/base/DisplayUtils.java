package com.hanks.htextview.base;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class DisplayUtils {
    public static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    public static int dp2px(float f) {
        return Math.round(f * getDisplayMetrics().density);
    }

    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }
}
