package com.coolapk.market.widget;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class ColorProgressDrawable extends ClipDrawable {
    public ColorProgressDrawable(int i) {
        super(createDrawable(i), 3, 1);
    }

    private static Drawable createDrawable(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public void setProgress(float f, int i) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (i < 0) {
            setLevel(0);
            return;
        }
        float f2 = (float) i;
        if (f > f2) {
            f = f2;
        }
        setLevel((int) ((f * 10000.0f) / f2));
    }
}
