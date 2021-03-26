package com.coolapk.market.util;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.LruCache;

public class ScrimUtil {
    private static final LruCache<Integer, Drawable> cubicGradientScrimCache = new LruCache<>(10);

    private ScrimUtil() {
    }

    public static Drawable makeCubicGradientScrimDrawable(int i, int i2, int i3) {
        final float f;
        final float f2;
        final float f3;
        final float f4;
        int i4 = (((i * 31) + i2) * 31) + i3;
        Drawable drawable = cubicGradientScrimCache.get(Integer.valueOf(i4));
        if (drawable != null) {
            return drawable;
        }
        int max = Math.max(i2, 2);
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        final int[] iArr = new int[max];
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int alpha = Color.alpha(i);
        int i5 = 0;
        while (true) {
            f = 0.0f;
            if (i5 >= max) {
                break;
            }
            iArr[i5] = Color.argb((int) (((float) alpha) * MathUtil.constrain(0.0f, 1.0f, (float) Math.pow((double) ((((float) i5) * 1.0f) / ((float) (max - 1))), 3.0d))), red, green, blue);
            i5++;
        }
        int i6 = i3 & 7;
        if (i6 != 3) {
            f2 = i6 != 5 ? 0.0f : 1.0f;
            f3 = 0.0f;
        } else {
            f2 = 0.0f;
            f3 = 1.0f;
        }
        int i7 = i3 & 112;
        if (i7 == 48) {
            f4 = 1.0f;
        } else if (i7 != 80) {
            f4 = 0.0f;
        } else {
            f4 = 0.0f;
            f = 1.0f;
        }
        paintDrawable.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            /* class com.coolapk.market.util.ScrimUtil.AnonymousClass1 */

            @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
            public Shader resize(int i, int i2) {
                float f = (float) i;
                float f2 = (float) i2;
                return new LinearGradient(f * f3, f2 * f4, f * f2, f2 * f, iArr, (float[]) null, Shader.TileMode.CLAMP);
            }
        });
        cubicGradientScrimCache.put(Integer.valueOf(i4), paintDrawable);
        return paintDrawable;
    }
}
