package com.github.ksoichiro.android.observablescrollview;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

public final class ScrollUtils {
    private ScrollUtils() {
    }

    public static float getFloat(float f, float f2, float f3) {
        return Math.min(f3, Math.max(f2, f));
    }

    public static int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public static void addOnGlobalLayoutListener(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.github.ksoichiro.android.observablescrollview.ScrollUtils.AnonymousClass1 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                runnable.run();
            }
        });
    }

    public static int mixColors(int i, int i2, float f) {
        float[] cmykFromRgb = cmykFromRgb(i);
        float[] cmykFromRgb2 = cmykFromRgb(i2);
        float[] fArr = new float[4];
        for (int i3 = 0; i3 < 4; i3++) {
            fArr[i3] = Math.min(1.0f, (cmykFromRgb[i3] * (1.0f - f)) + (cmykFromRgb2[i3] * f));
        }
        return (16777215 & rgbFromCmyk(fArr)) - 16777216;
    }

    public static float[] cmykFromRgb(int i) {
        float f;
        float f2;
        float f3 = 1.0f;
        float f4 = 1.0f - (((float) ((16711680 & i) >> 16)) / 255.0f);
        float f5 = 1.0f - (((float) ((65280 & i) >> 8)) / 255.0f);
        float f6 = 1.0f - (((float) (i & 255)) / 255.0f);
        float min = Math.min(f4, Math.min(f5, f6));
        if (min != 1.0f) {
            float f7 = 1.0f - min;
            f2 = (f5 - min) / f7;
            f = (f6 - min) / f7;
            f3 = (f4 - min) / f7;
        } else {
            f = 1.0f;
            f2 = 1.0f;
        }
        return new float[]{f3, f2, f, min};
    }

    public static int rgbFromCmyk(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = 1.0f - f4;
        return ((((int) ((1.0f - Math.min(1.0f, (f * f5) + f4)) * 255.0f)) & 255) << 16) + ((((int) ((1.0f - Math.min(1.0f, (f2 * f5) + f4)) * 255.0f)) & 255) << 8) + (((int) ((1.0f - Math.min(1.0f, (f3 * f5) + f4)) * 255.0f)) & 255);
    }
}
