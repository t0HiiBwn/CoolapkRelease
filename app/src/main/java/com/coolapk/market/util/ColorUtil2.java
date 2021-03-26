package com.coolapk.market.util;

import android.graphics.drawable.GradientDrawable;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\b¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/util/ColorUtil2;", "", "()V", "createGradientDrawableByColor", "Landroid/graphics/drawable/GradientDrawable;", "palette", "Landroidx/palette/graphics/Palette;", "getDarkenColor", "", "color", "value", "", "getLightenColor", "getThemeColor", "defaultColor", "setAlphaComponent", "alpha", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ColorUtil2.kt */
public final class ColorUtil2 {
    public static final ColorUtil2 INSTANCE = new ColorUtil2();

    private ColorUtil2() {
    }

    public final int getLightenColor(int i, float f) {
        float[] fArr = new float[3];
        ColorUtils.colorToHSL(i, fArr);
        fArr[2] = fArr[2] + f;
        fArr[2] = Math.max(0.0f, Math.min(fArr[2], 1.0f));
        return ColorUtils.HSLToColor(fArr);
    }

    public final int getDarkenColor(int i, float f) {
        float[] fArr = new float[3];
        ColorUtils.colorToHSL(i, fArr);
        fArr[2] = fArr[2] - f;
        fArr[2] = Math.max(0.0f, Math.min(fArr[2], 1.0f));
        return ColorUtils.HSLToColor(fArr);
    }

    public static /* synthetic */ int getThemeColor$default(ColorUtil2 colorUtil2, Palette palette, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = AppHolder.getAppTheme().getColorAccent();
        }
        return colorUtil2.getThemeColor(palette, i);
    }

    public final int getThemeColor(Palette palette, int i) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        int mutedColor = palette.getMutedColor(i);
        if (mutedColor != i) {
            return mutedColor;
        }
        int vibrantColor = palette.getVibrantColor(i);
        if (vibrantColor != i) {
            return vibrantColor;
        }
        int lightMutedColor = palette.getLightMutedColor(i);
        return lightMutedColor == i ? palette.getDominantColor(i) : lightMutedColor;
    }

    public final int setAlphaComponent(int i, int i2) {
        return ColorUtils.setAlphaComponent(i, i2);
    }

    public final GradientDrawable createGradientDrawableByColor(Palette palette) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        ColorUtil2 colorUtil2 = INSTANCE;
        int themeColor$default = getThemeColor$default(colorUtil2, palette, 0, 2, null);
        int darkenColor = colorUtil2.getDarkenColor(themeColor$default, 0.23f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{themeColor$default, darkenColor});
        return gradientDrawable;
    }
}
