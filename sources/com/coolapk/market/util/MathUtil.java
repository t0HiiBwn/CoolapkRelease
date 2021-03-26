package com.coolapk.market.util;

public class MathUtil {
    public static int floorEven(int i) {
        return i & -2;
    }

    public static float interpolate(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public static int roundMult4(int i) {
        return (i + 2) & -4;
    }

    public static float constrain(float f, float f2, float f3) {
        return Math.max(f, Math.min(f2, f3));
    }

    public static float uninterpolate(float f, float f2, float f3) {
        float f4 = f2 - f;
        if (f4 != 0.0f) {
            return (f3 - f) / f4;
        }
        throw new IllegalArgumentException("Can't reverse interpolate with domain size of 0");
    }

    public static int intDivideRoundUp(int i, int i2) {
        int i3 = -1;
        int i4 = i > 0 ? 1 : -1;
        if (i2 > 0) {
            i3 = 1;
        }
        return ((i4 * i3) * ((Math.abs(i) + Math.abs(i2)) - 1)) / Math.abs(i2);
    }

    private MathUtil() {
    }
}
