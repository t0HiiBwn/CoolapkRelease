package com.coolapk.market.util;

import android.animation.ArgbEvaluator;

public class AnimationUtils {
    private static ArgbEvaluator sEvaluator = new ArgbEvaluator();

    public static int calculateColor(float f, int i, int i2) {
        return ((Integer) sEvaluator.evaluate(f, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }
}
