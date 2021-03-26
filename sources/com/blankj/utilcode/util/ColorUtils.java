package com.blankj.utilcode.util;

import android.graphics.Color;
import androidx.core.content.ContextCompat;
import java.util.Objects;

public final class ColorUtils {
    public static int setAlphaComponent(int i, float f) {
        return (i & 16777215) | (((int) ((f * 255.0f) + 0.5f)) << 24);
    }

    public static int setAlphaComponent(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public static int setBlueComponent(int i, float f) {
        return (i & -256) | ((int) ((f * 255.0f) + 0.5f));
    }

    public static int setBlueComponent(int i, int i2) {
        return (i & -256) | i2;
    }

    public static int setGreenComponent(int i, float f) {
        return (i & -65281) | (((int) ((f * 255.0f) + 0.5f)) << 8);
    }

    public static int setGreenComponent(int i, int i2) {
        return (i & -65281) | (i2 << 8);
    }

    public static int setRedComponent(int i, float f) {
        return (i & -16711681) | (((int) ((f * 255.0f) + 0.5f)) << 16);
    }

    public static int setRedComponent(int i, int i2) {
        return (i & -16711681) | (i2 << 16);
    }

    private ColorUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getColor(int i) {
        return ContextCompat.getColor(Utils.getApp(), i);
    }

    public static int string2Int(String str) {
        Objects.requireNonNull(str, "Argument 'colorString' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Color.parseColor(str);
    }

    public static String int2RgbString(int i) {
        String hexString = Integer.toHexString(i & 16777215);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        return "#" + hexString;
    }

    public static String int2ArgbString(int i) {
        String hexString = Integer.toHexString(i);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        while (hexString.length() < 8) {
            hexString = "f" + hexString;
        }
        return "#" + hexString;
    }

    public static int getRandomColor() {
        return getRandomColor(true);
    }

    public static int getRandomColor(boolean z) {
        return (z ? ((int) (Math.random() * 256.0d)) << 24 : -16777216) | ((int) (Math.random() * 1.6777216E7d));
    }

    public boolean isLightColor(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) >= 127.5d;
    }
}
