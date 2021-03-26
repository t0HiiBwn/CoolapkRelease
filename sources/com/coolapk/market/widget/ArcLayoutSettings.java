package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.coolapk.market.R;

public class ArcLayoutSettings {
    public static final int CROP_INSIDE = 0;
    public static final int CROP_OUTSIDE = 1;
    public static final int POSITION_BOTTOM = 0;
    public static final int POSITION_LEFT = 2;
    public static final int POSITION_RIGHT = 3;
    public static final int POSITION_TOP = 1;
    private float arcHeight;
    private boolean cropInside = true;
    private float elevation;
    private int position;

    private static float dpToPx(Context context, int i) {
        return TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    ArcLayoutSettings(Context context, AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcLayout, 0, 0);
        this.arcHeight = obtainStyledAttributes.getDimension(1, dpToPx(context, 10));
        this.cropInside = obtainStyledAttributes.getInt(0, 0) != 0 ? false : z;
        this.position = obtainStyledAttributes.getInt(2, 0);
        obtainStyledAttributes.recycle();
    }

    public float getElevation() {
        return this.elevation;
    }

    public void setElevation(float f) {
        this.elevation = f;
    }

    public boolean isCropInside() {
        return this.cropInside;
    }

    public float getArcHeight() {
        return this.arcHeight;
    }

    public int getPosition() {
        return this.position;
    }
}
