package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class SpaceView extends View {
    public SpaceView(Context context) {
        super(context);
    }

    public SpaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SpaceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private static int getDefaultSize2(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i : size;
        }
        return Math.min(i, size);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), i), getDefaultSize2(getSuggestedMinimumHeight(), i2));
    }
}
