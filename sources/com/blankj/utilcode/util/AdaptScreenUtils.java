package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class AdaptScreenUtils {
    private static List<Field> sMetricsFields;

    private AdaptScreenUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Resources adaptWidth(Resources resources, int i) {
        Objects.requireNonNull(resources, "Argument 'resources' of type Resources (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        applyDisplayMetrics(resources, (((float) resources.getDisplayMetrics().widthPixels) * 72.0f) / ((float) i));
        Objects.requireNonNull(resources, "Detected an attempt to return null from a method com.blankj.utilcode.util.AdaptScreenUtils.adaptWidth() marked by @androidx.annotation.NonNull");
        return resources;
    }

    public static Resources adaptHeight(Resources resources, int i) {
        Objects.requireNonNull(resources, "Argument 'resources' of type Resources (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Resources adaptHeight = adaptHeight(resources, i, false);
        Objects.requireNonNull(adaptHeight, "Detected an attempt to return null from a method com.blankj.utilcode.util.AdaptScreenUtils.adaptHeight() marked by @androidx.annotation.NonNull");
        return adaptHeight;
    }

    public static Resources adaptHeight(Resources resources, int i, boolean z) {
        Objects.requireNonNull(resources, "Argument 'resources' of type Resources (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        applyDisplayMetrics(resources, (((float) (resources.getDisplayMetrics().heightPixels + (z ? getNavBarHeight(resources) : 0))) * 72.0f) / ((float) i));
        Objects.requireNonNull(resources, "Detected an attempt to return null from a method com.blankj.utilcode.util.AdaptScreenUtils.adaptHeight() marked by @androidx.annotation.NonNull");
        return resources;
    }

    private static int getNavBarHeight(Resources resources) {
        Objects.requireNonNull(resources, "Argument 'resources' of type Resources (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Resources closeAdapt(Resources resources) {
        Objects.requireNonNull(resources, "Argument 'resources' of type Resources (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        applyDisplayMetrics(resources, Resources.getSystem().getDisplayMetrics().density * 72.0f);
        Objects.requireNonNull(resources, "Detected an attempt to return null from a method com.blankj.utilcode.util.AdaptScreenUtils.closeAdapt() marked by @androidx.annotation.NonNull");
        return resources;
    }

    public static int pt2Px(float f) {
        return (int) (((double) ((f * Utils.getApp().getResources().getDisplayMetrics().xdpi) / 72.0f)) + 0.5d);
    }

    public static int px2Pt(float f) {
        return (int) (((double) ((f * 72.0f) / Utils.getApp().getResources().getDisplayMetrics().xdpi)) + 0.5d);
    }

    private static void applyDisplayMetrics(Resources resources, float f) {
        Objects.requireNonNull(resources, "Argument 'resources' of type Resources (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        resources.getDisplayMetrics().xdpi = f;
        Utils.getApp().getResources().getDisplayMetrics().xdpi = f;
        applyOtherDisplayMetrics(resources, f);
    }

    static Runnable getPreLoadRunnable() {
        return new Runnable() {
            /* class com.blankj.utilcode.util.AdaptScreenUtils.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                AdaptScreenUtils.preLoad();
            }
        };
    }

    /* access modifiers changed from: private */
    public static void preLoad() {
        applyDisplayMetrics(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }

    private static void applyOtherDisplayMetrics(Resources resources, float f) {
        if (sMetricsFields == null) {
            sMetricsFields = new ArrayList();
            Class<?> cls = resources.getClass();
            Field[] declaredFields = cls.getDeclaredFields();
            while (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                        field.setAccessible(true);
                        DisplayMetrics metricsFromField = getMetricsFromField(resources, field);
                        if (metricsFromField != null) {
                            sMetricsFields.add(field);
                            metricsFromField.xdpi = f;
                        }
                    }
                }
                cls = cls.getSuperclass();
                if (cls != null) {
                    declaredFields = cls.getDeclaredFields();
                } else {
                    return;
                }
            }
            return;
        }
        applyMetricsFields(resources, f);
    }

    private static void applyMetricsFields(Resources resources, float f) {
        for (Field field : sMetricsFields) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) field.get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static DisplayMetrics getMetricsFromField(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }
}
