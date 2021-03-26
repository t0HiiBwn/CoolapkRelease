package com.kk.taurus.playerbase.utils;

import android.content.Context;
import android.content.res.Resources;

public class PUtils {
    public static int getStatusBarHeight(Context context) {
        int statusBarHeightMethod1 = getStatusBarHeightMethod1(context);
        return statusBarHeightMethod1 <= 0 ? getStatusBarHeightMethod2(context) : statusBarHeightMethod1;
    }

    public static int getStatusBarHeightMethod1(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static int getStatusBarHeightMethod2(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }
}
