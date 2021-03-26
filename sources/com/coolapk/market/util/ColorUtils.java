package com.coolapk.market.util;

import android.graphics.Color;
import com.coolapk.market.binding.ThemeBindingAdapters;
import java.util.regex.Pattern;

public class ColorUtils {
    private static Pattern colorPattern = Pattern.compile("^#[0-9A-F]{6,8}$", 2);

    public static int adjustAlpha(int i, float f) {
        return Color.argb(Math.round(((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
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

    public static int darkerColor(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * f;
        return Color.HSVToColor(fArr);
    }

    public static String toColorString(int i) {
        String str;
        try {
            str = Integer.toHexString(Color.argb(0, Color.red(i), Color.green(i), Color.blue(i)));
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str != null && str.length() < 6) {
            while (str.length() < 6) {
                str = "0" + str;
            }
        }
        if (str == null) {
            return str;
        }
        return "#" + str.toUpperCase();
    }

    public static int calculateOneColorPlusAnotherColor(int i, int i2) {
        float alpha = ((float) Color.alpha(i)) / 255.0f;
        float f = 1.0f - alpha;
        float red = (((float) Color.red(i)) * alpha) + (((float) Color.red(i2)) * f);
        return ((int) ((((float) Color.blue(i)) * alpha) + (f * ((float) Color.blue(i2))) + 0.5f)) | (((int) (red + 0.5f)) << 16) | -16777216 | (((int) (((((float) Color.green(i)) * alpha) + (((float) Color.green(i2)) * f)) + 0.5f)) << 8);
    }

    public static int calculateOverlayColor(int i, int i2) {
        float red = Color.red(i2) > 0 ? (((float) Color.red(i)) * 1.0f) / ((float) Color.red(i2)) : 0.0f;
        float green = Color.green(i2) > 0 ? (((float) Color.green(i)) * 1.0f) / ((float) Color.green(i2)) : 0.0f;
        float blue = Color.blue(i2) > 0 ? (((float) Color.blue(i)) * 1.0f) / ((float) Color.blue(i2)) : 0.0f;
        float f = red + green + blue;
        int i3 = 3;
        if (red <= 0.0f || red >= 1.0f) {
            i3 = 2;
        }
        if (green <= 0.0f || green >= 1.0f) {
            i3--;
        }
        if (blue <= 0.0f || blue >= 1.0f) {
            i3--;
        }
        if (i3 == 0) {
            return 1140850688;
        }
        return ((int) (((1.0f - (f / ((float) i3))) * 255.0f) + 0.5f)) << 24;
    }

    public static Integer stringToColor(String str) {
        if (str == null) {
            return null;
        }
        int themeColor = ThemeBindingAdapters.getThemeColor(str);
        if (themeColor != 0) {
            return Integer.valueOf(themeColor);
        }
        if (colorPattern.matcher(str).matches()) {
            return Integer.valueOf(Color.parseColor(str));
        }
        return null;
    }
}
