package com.coolapk.market.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.coolapk.market.AppHolder;

public class DisplayUtils {
    private static Point sPoint = new Point();

    public static int dp2px(Context context, float f) {
        return (int) (TypedValue.applyDimension(1, f, getDM()) + 0.5f);
    }

    public static float dp2pxf(Context context, float f) {
        return TypedValue.applyDimension(1, f, getDM()) + 0.5f;
    }

    public static int sp2px(Context context, float f) {
        return (int) (TypedValue.applyDimension(2, f, getDM()) + 0.5f);
    }

    public static int px2dp(Context context, float f) {
        return (int) ((f / getDM().density) + 0.5f);
    }

    public static int getWidthDp(Context context) {
        DisplayMetrics dm = getDM();
        return (int) (((float) dm.widthPixels) / dm.density);
    }

    public static int getHeightDp(Context context) {
        DisplayMetrics dm = getDM();
        return (int) (((float) dm.heightPixels) / dm.density);
    }

    public static int getWidthPixels(Context context) {
        return getDM().widthPixels;
    }

    public static int getHeightPixels(Context context) {
        return getDM().heightPixels;
    }

    public static int getDpi(Context context) {
        return getDM().densityDpi;
    }

    public static float getAnyScaleHeightPixels(Context context, float f) {
        return ((float) getDM().heightPixels) / f;
    }

    private static DisplayMetrics getDM() {
        return AppHolder.getApplication().getResources().getDisplayMetrics();
    }

    public static int getDecorViewWidth(Context context) {
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity == null) {
            return getWidthPixels(context);
        }
        currentActivity.getWindowManager().getDefaultDisplay().getSize(sPoint);
        return sPoint.x;
    }

    public static int getDecorMinSideLength(Context context) {
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity == null) {
            return Math.min(getWidthPixels(context), getHeightPixels(context));
        }
        currentActivity.getWindowManager().getDefaultDisplay().getSize(sPoint);
        return Math.min(sPoint.x, sPoint.y);
    }

    public static int getDecorViewHeight(Context context) {
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity == null) {
            return getWidthPixels(context);
        }
        currentActivity.getWindowManager().getDefaultDisplay().getSize(sPoint);
        return sPoint.y;
    }
}
