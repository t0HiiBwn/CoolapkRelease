package com.coolapk.market.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import java.lang.reflect.Field;

public final class ATEUtil {
    public static int adjustAlpha(int i, float f) {
        return Color.argb(Math.round(((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static int resolveColor(Context context, int i) {
        return resolveColor(context, i, 0);
    }

    public static int resolveColor(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getColor(0, i2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int shiftColor(int i, float f) {
        if (f == 1.0f) {
            return i;
        }
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * f;
        return Color.HSVToColor(fArr);
    }

    public static int darkenColor(int i) {
        return shiftColor(i, 0.9f);
    }

    public static boolean isColorLight(int i) {
        if (i == -16777216) {
            return false;
        }
        if (i == -1 || i == 0 || Double.valueOf(1.0d - ((((((double) Color.red(i)) * 0.25d) + (((double) Color.green(i)) * 0.7d)) + (((double) Color.blue(i)) * 0.05d)) / 255.0d)).doubleValue() < 0.4d) {
            return true;
        }
        return false;
    }

    public static boolean isColorLight(int i, int i2) {
        if (Color.alpha(i) < 128) {
            return isColorLight(i2);
        }
        return isColorLight(i);
    }

    public static int invertColor(int i) {
        return Color.argb(Color.alpha(i), 255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
    }

    public static Toolbar getSupportActionBarView(ActionBar actionBar) {
        if (actionBar == null) {
            return null;
        }
        try {
            Field declaredField = actionBar.getClass().getDeclaredField("mDecorToolbar");
            declaredField.setAccessible(true);
            Field declaredField2 = ToolbarWidgetWrapper.class.getDeclaredField("mToolbar");
            declaredField2.setAccessible(true);
            return (Toolbar) declaredField2.get((ToolbarWidgetWrapper) declaredField.get(actionBar));
        } catch (Throwable unused) {
            Log.d("ATEUtil", "Unable to get Toolbar from " + actionBar.getClass().getName());
            return null;
        }
    }

    public static void removeOnGlobalLayoutListener(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT < 16) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        } else {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void setBackgroundCompat(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static int stripAlpha(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    public static boolean isInClassPath(String str) {
        try {
            return inClassPath(str) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Class<?> inClassPath(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            throw new IllegalStateException(String.format("%s is not in your class path! You must include the associated library.", str));
        }
    }

    public static int blendColors(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    private static void removeLayoutListener(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    private ATEUtil() {
    }
}
